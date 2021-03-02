package com.squareup.okhttp.internal.http;

import com.squareup.okhttp.Address;
import com.squareup.okhttp.CertificatePinner;
import com.squareup.okhttp.Connection;
import com.squareup.okhttp.ConnectionPool;
import com.squareup.okhttp.Headers;
import com.squareup.okhttp.Interceptor;
import com.squareup.okhttp.MediaType;
import com.squareup.okhttp.OkHttpClient;
import com.squareup.okhttp.Protocol;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.Response;
import com.squareup.okhttp.ResponseBody;
import com.squareup.okhttp.Route;
import com.squareup.okhttp.internal.Internal;
import com.squareup.okhttp.internal.InternalCache;
import com.squareup.okhttp.internal.Util;
import com.squareup.okhttp.internal.Version;
import com.squareup.okhttp.internal.http.CacheStrategy;
import java.io.Closeable;
import java.io.IOException;
import java.io.InterruptedIOException;
import java.net.CookieHandler;
import java.net.ProtocolException;
import java.net.URL;
import java.net.UnknownHostException;
import java.security.cert.CertificateException;
import java.util.Date;
import java.util.concurrent.TimeUnit;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.SSLHandshakeException;
import javax.net.ssl.SSLPeerUnverifiedException;
import javax.net.ssl.SSLSocketFactory;
import okio.Buffer;
import okio.BufferedSink;
import okio.BufferedSource;
import okio.GzipSource;
import okio.Okio;
import okio.Sink;
import okio.Source;
import okio.Timeout;

public final class HttpEngine {
    private static final ResponseBody EMPTY_BODY = new ResponseBody() {
        public MediaType contentType() {
            return null;
        }

        public long contentLength() {
            return 0;
        }

        public BufferedSource source() {
            return new Buffer();
        }
    };
    public static final int MAX_FOLLOW_UPS = 20;
    private Address address;
    public final boolean bufferRequestBody;
    private BufferedSink bufferedRequestBody;
    private Response cacheResponse;
    private CacheStrategy cacheStrategy;
    private final boolean callerWritesRequestBody;
    final OkHttpClient client;
    /* access modifiers changed from: private */
    public Connection connection;
    private final boolean forWebSocket;
    private Request networkRequest;
    private final Response priorResponse;
    private Sink requestBodyOut;
    private Route route;
    private RouteSelector routeSelector;
    long sentRequestMillis = -1;
    private CacheRequest storeRequest;
    private boolean transparentGzip;
    /* access modifiers changed from: private */
    public Transport transport;
    private final Request userRequest;
    private Response userResponse;

    public HttpEngine(OkHttpClient client2, Request request, boolean bufferRequestBody2, boolean callerWritesRequestBody2, boolean forWebSocket2, Connection connection2, RouteSelector routeSelector2, RetryableSink requestBodyOut2, Response priorResponse2) {
        this.client = client2;
        this.userRequest = request;
        this.bufferRequestBody = bufferRequestBody2;
        this.callerWritesRequestBody = callerWritesRequestBody2;
        this.forWebSocket = forWebSocket2;
        this.connection = connection2;
        this.routeSelector = routeSelector2;
        this.requestBodyOut = requestBodyOut2;
        this.priorResponse = priorResponse2;
        if (connection2 != null) {
            Internal.instance.setOwner(connection2, this);
            this.route = connection2.getRoute();
            return;
        }
        this.route = null;
    }

    public void sendRequest() throws IOException {
        Response cacheCandidate;
        if (this.cacheStrategy == null) {
            if (this.transport != null) {
                throw new IllegalStateException();
            }
            Request request = networkRequest(this.userRequest);
            InternalCache responseCache = Internal.instance.internalCache(this.client);
            if (responseCache != null) {
                cacheCandidate = responseCache.get(request);
            } else {
                cacheCandidate = null;
            }
            this.cacheStrategy = new CacheStrategy.Factory(System.currentTimeMillis(), request, cacheCandidate).get();
            this.networkRequest = this.cacheStrategy.networkRequest;
            this.cacheResponse = this.cacheStrategy.cacheResponse;
            if (responseCache != null) {
                responseCache.trackResponse(this.cacheStrategy);
            }
            if (cacheCandidate != null && this.cacheResponse == null) {
                Util.closeQuietly((Closeable) cacheCandidate.body());
            }
            if (this.networkRequest != null) {
                if (this.connection == null) {
                    connect();
                }
                this.transport = Internal.instance.newTransport(this.connection, this);
                if (this.callerWritesRequestBody && permitsRequestBody() && this.requestBodyOut == null) {
                    long contentLength = OkHeaders.contentLength(request);
                    if (!this.bufferRequestBody) {
                        this.transport.writeRequestHeaders(this.networkRequest);
                        this.requestBodyOut = this.transport.createRequestBody(this.networkRequest, contentLength);
                    } else if (contentLength > 2147483647L) {
                        throw new IllegalStateException("Use setFixedLengthStreamingMode() or setChunkedStreamingMode() for requests larger than 2 GiB.");
                    } else if (contentLength != -1) {
                        this.transport.writeRequestHeaders(this.networkRequest);
                        this.requestBodyOut = new RetryableSink((int) contentLength);
                    } else {
                        this.requestBodyOut = new RetryableSink();
                    }
                }
            } else {
                if (this.connection != null) {
                    Internal.instance.recycle(this.client.getConnectionPool(), this.connection);
                    this.connection = null;
                }
                if (this.cacheResponse != null) {
                    this.userResponse = this.cacheResponse.newBuilder().request(this.userRequest).priorResponse(stripBody(this.priorResponse)).cacheResponse(stripBody(this.cacheResponse)).build();
                } else {
                    this.userResponse = new Response.Builder().request(this.userRequest).priorResponse(stripBody(this.priorResponse)).protocol(Protocol.HTTP_1_1).code(504).message("Unsatisfiable Request (only-if-cached)").body(EMPTY_BODY).build();
                }
                this.userResponse = unzip(this.userResponse);
            }
        }
    }

    private static Response stripBody(Response response) {
        return (response == null || response.body() == null) ? response : response.newBuilder().body((ResponseBody) null).build();
    }

    private void connect() throws IOException {
        if (this.connection != null) {
            throw new IllegalStateException();
        }
        if (this.routeSelector == null) {
            this.address = createAddress(this.client, this.networkRequest);
            this.routeSelector = RouteSelector.get(this.address, this.networkRequest, this.client);
        }
        this.connection = nextConnection();
        this.route = this.connection.getRoute();
    }

    private Connection nextConnection() throws IOException {
        Connection connection2 = createNextConnection();
        Internal.instance.connectAndSetOwner(this.client, connection2, this, this.networkRequest);
        return connection2;
    }

    private Connection createNextConnection() throws IOException {
        ConnectionPool pool = this.client.getConnectionPool();
        while (true) {
            Connection pooled = pool.get(this.address);
            if (pooled == null) {
                return new Connection(pool, this.routeSelector.next());
            }
            if (this.networkRequest.method().equals("GET") || Internal.instance.isReadable(pooled)) {
                return pooled;
            }
            pooled.getSocket().close();
        }
    }

    public void writingRequestHeaders() {
        if (this.sentRequestMillis != -1) {
            throw new IllegalStateException();
        }
        this.sentRequestMillis = System.currentTimeMillis();
    }

    /* access modifiers changed from: package-private */
    public boolean permitsRequestBody() {
        return HttpMethod.permitsRequestBody(this.userRequest.method());
    }

    public Sink getRequestBody() {
        if (this.cacheStrategy != null) {
            return this.requestBodyOut;
        }
        throw new IllegalStateException();
    }

    public BufferedSink getBufferedRequestBody() {
        BufferedSink result;
        BufferedSink result2 = this.bufferedRequestBody;
        if (result2 != null) {
            return result2;
        }
        Sink requestBody = getRequestBody();
        if (requestBody != null) {
            result = Okio.buffer(requestBody);
            this.bufferedRequestBody = result;
        } else {
            result = null;
        }
        return result;
    }

    public boolean hasResponse() {
        return this.userResponse != null;
    }

    public Request getRequest() {
        return this.userRequest;
    }

    public Response getResponse() {
        if (this.userResponse != null) {
            return this.userResponse;
        }
        throw new IllegalStateException();
    }

    public Connection getConnection() {
        return this.connection;
    }

    public HttpEngine recover(IOException e, Sink requestBodyOut2) {
        if (!(this.routeSelector == null || this.connection == null)) {
            connectFailed(this.routeSelector, e);
        }
        boolean canRetryRequestBody = requestBodyOut2 == null || (requestBodyOut2 instanceof RetryableSink);
        if ((this.routeSelector == null && this.connection == null) || ((this.routeSelector != null && !this.routeSelector.hasNext()) || !isRecoverable(e) || !canRetryRequestBody)) {
            return null;
        }
        return new HttpEngine(this.client, this.userRequest, this.bufferRequestBody, this.callerWritesRequestBody, this.forWebSocket, close(), this.routeSelector, (RetryableSink) requestBodyOut2, this.priorResponse);
    }

    private void connectFailed(RouteSelector routeSelector2, IOException e) {
        if (Internal.instance.recycleCount(this.connection) <= 0) {
            routeSelector2.connectFailed(this.connection.getRoute(), e);
        }
    }

    public HttpEngine recover(IOException e) {
        return recover(e, this.requestBodyOut);
    }

    private boolean isRecoverable(IOException e) {
        if (!this.client.getRetryOnConnectionFailure() || (e instanceof SSLPeerUnverifiedException)) {
            return false;
        }
        if ((!(e instanceof SSLHandshakeException) || !(e.getCause() instanceof CertificateException)) && !(e instanceof ProtocolException) && !(e instanceof InterruptedIOException)) {
            return true;
        }
        return false;
    }

    public Route getRoute() {
        return this.route;
    }

    private void maybeCache() throws IOException {
        InternalCache responseCache = Internal.instance.internalCache(this.client);
        if (responseCache != null) {
            if (CacheStrategy.isCacheable(this.userResponse, this.networkRequest)) {
                this.storeRequest = responseCache.put(stripBody(this.userResponse));
            } else if (HttpMethod.invalidatesCache(this.networkRequest.method())) {
                try {
                    responseCache.remove(this.networkRequest);
                } catch (IOException e) {
                }
            }
        }
    }

    public void releaseConnection() throws IOException {
        if (!(this.transport == null || this.connection == null)) {
            this.transport.releaseConnectionOnIdle();
        }
        this.connection = null;
    }

    public void disconnect() {
        if (this.transport != null) {
            try {
                this.transport.disconnect(this);
            } catch (IOException e) {
            }
        }
    }

    public Connection close() {
        if (this.bufferedRequestBody != null) {
            Util.closeQuietly((Closeable) this.bufferedRequestBody);
        } else if (this.requestBodyOut != null) {
            Util.closeQuietly((Closeable) this.requestBodyOut);
        }
        if (this.userResponse == null) {
            if (this.connection != null) {
                Util.closeQuietly(this.connection.getSocket());
            }
            this.connection = null;
            return null;
        }
        Util.closeQuietly((Closeable) this.userResponse.body());
        if (this.transport == null || this.connection == null || this.transport.canReuseConnection()) {
            if (this.connection != null && !Internal.instance.clearOwner(this.connection)) {
                this.connection = null;
            }
            Connection connection2 = this.connection;
            this.connection = null;
            return connection2;
        }
        Util.closeQuietly(this.connection.getSocket());
        this.connection = null;
        return null;
    }

    private Response unzip(Response response) throws IOException {
        if (!this.transparentGzip || !"gzip".equalsIgnoreCase(this.userResponse.header("Content-Encoding")) || response.body() == null) {
            return response;
        }
        GzipSource responseBody = new GzipSource(response.body().source());
        Headers strippedHeaders = response.headers().newBuilder().removeAll("Content-Encoding").removeAll("Content-Length").build();
        return response.newBuilder().headers(strippedHeaders).body(new RealResponseBody(strippedHeaders, Okio.buffer((Source) responseBody))).build();
    }

    public static boolean hasBody(Response response) {
        if (response.request().method().equals("HEAD")) {
            return false;
        }
        int responseCode = response.code();
        if ((responseCode < 100 || responseCode >= 200) && responseCode != 204 && responseCode != 304) {
            return true;
        }
        if (OkHeaders.contentLength(response) != -1 || "chunked".equalsIgnoreCase(response.header("Transfer-Encoding"))) {
            return true;
        }
        return false;
    }

    private Request networkRequest(Request request) throws IOException {
        Request.Builder result = request.newBuilder();
        if (request.header("Host") == null) {
            result.header("Host", hostHeader(request.url()));
        }
        if ((this.connection == null || this.connection.getProtocol() != Protocol.HTTP_1_0) && request.header("Connection") == null) {
            result.header("Connection", "Keep-Alive");
        }
        if (request.header("Accept-Encoding") == null) {
            this.transparentGzip = true;
            result.header("Accept-Encoding", "gzip");
        }
        CookieHandler cookieHandler = this.client.getCookieHandler();
        if (cookieHandler != null) {
            OkHeaders.addCookies(result, cookieHandler.get(request.uri(), OkHeaders.toMultimap(result.build().headers(), (String) null)));
        }
        if (request.header("User-Agent") == null) {
            result.header("User-Agent", Version.userAgent());
        }
        return result.build();
    }

    public static String hostHeader(URL url) {
        if (Util.getEffectivePort(url) != Util.getDefaultPort(url.getProtocol())) {
            return url.getHost() + ":" + url.getPort();
        }
        return url.getHost();
    }

    public void readResponse() throws IOException {
        Response networkResponse;
        if (this.userResponse == null) {
            if (this.networkRequest == null && this.cacheResponse == null) {
                throw new IllegalStateException("call sendRequest() first!");
            } else if (this.networkRequest != null) {
                if (this.forWebSocket) {
                    this.transport.writeRequestHeaders(this.networkRequest);
                    networkResponse = readNetworkResponse();
                } else if (!this.callerWritesRequestBody) {
                    networkResponse = new NetworkInterceptorChain(0, this.networkRequest).proceed(this.networkRequest);
                } else {
                    if (this.bufferedRequestBody != null && this.bufferedRequestBody.buffer().size() > 0) {
                        this.bufferedRequestBody.emit();
                    }
                    if (this.sentRequestMillis == -1) {
                        if (OkHeaders.contentLength(this.networkRequest) == -1 && (this.requestBodyOut instanceof RetryableSink)) {
                            this.networkRequest = this.networkRequest.newBuilder().header("Content-Length", Long.toString(((RetryableSink) this.requestBodyOut).contentLength())).build();
                        }
                        this.transport.writeRequestHeaders(this.networkRequest);
                    }
                    if (this.requestBodyOut != null) {
                        if (this.bufferedRequestBody != null) {
                            this.bufferedRequestBody.close();
                        } else {
                            this.requestBodyOut.close();
                        }
                        if (this.requestBodyOut instanceof RetryableSink) {
                            this.transport.writeRequestBody((RetryableSink) this.requestBodyOut);
                        }
                    }
                    networkResponse = readNetworkResponse();
                }
                receiveHeaders(networkResponse.headers());
                if (this.cacheResponse != null) {
                    if (validate(this.cacheResponse, networkResponse)) {
                        this.userResponse = this.cacheResponse.newBuilder().request(this.userRequest).priorResponse(stripBody(this.priorResponse)).headers(combine(this.cacheResponse.headers(), networkResponse.headers())).cacheResponse(stripBody(this.cacheResponse)).networkResponse(stripBody(networkResponse)).build();
                        networkResponse.body().close();
                        releaseConnection();
                        InternalCache responseCache = Internal.instance.internalCache(this.client);
                        responseCache.trackConditionalCacheHit();
                        responseCache.update(this.cacheResponse, stripBody(this.userResponse));
                        this.userResponse = unzip(this.userResponse);
                        return;
                    }
                    Util.closeQuietly((Closeable) this.cacheResponse.body());
                }
                this.userResponse = networkResponse.newBuilder().request(this.userRequest).priorResponse(stripBody(this.priorResponse)).cacheResponse(stripBody(this.cacheResponse)).networkResponse(stripBody(networkResponse)).build();
                if (hasBody(this.userResponse)) {
                    maybeCache();
                    this.userResponse = unzip(cacheWritingResponse(this.storeRequest, this.userResponse));
                }
            }
        }
    }

    class NetworkInterceptorChain implements Interceptor.Chain {
        private int calls;
        private final int index;
        private final Request request;

        NetworkInterceptorChain(int index2, Request request2) {
            this.index = index2;
            this.request = request2;
        }

        public Connection connection() {
            return HttpEngine.this.connection;
        }

        public Request request() {
            return this.request;
        }

        public Response proceed(Request request2) throws IOException {
            this.calls++;
            if (this.index > 0) {
                Interceptor caller = HttpEngine.this.client.networkInterceptors().get(this.index - 1);
                Address address = connection().getRoute().getAddress();
                if (!request2.url().getHost().equals(address.getUriHost()) || Util.getEffectivePort(request2.url()) != address.getUriPort()) {
                    throw new IllegalStateException("network interceptor " + caller + " must retain the same host and port");
                } else if (this.calls > 1) {
                    throw new IllegalStateException("network interceptor " + caller + " must call proceed() exactly once");
                }
            }
            if (this.index < HttpEngine.this.client.networkInterceptors().size()) {
                NetworkInterceptorChain chain = new NetworkInterceptorChain(this.index + 1, request2);
                Interceptor interceptor = HttpEngine.this.client.networkInterceptors().get(this.index);
                Response intercept = interceptor.intercept(chain);
                if (chain.calls == 1) {
                    return intercept;
                }
                throw new IllegalStateException("network interceptor " + interceptor + " must call proceed() exactly once");
            }
            HttpEngine.this.transport.writeRequestHeaders(request2);
            if (HttpEngine.this.permitsRequestBody() && request2.body() != null) {
                BufferedSink bufferedRequestBody = Okio.buffer(HttpEngine.this.transport.createRequestBody(request2, request2.body().contentLength()));
                request2.body().writeTo(bufferedRequestBody);
                bufferedRequestBody.close();
            }
            return HttpEngine.this.readNetworkResponse();
        }
    }

    /* access modifiers changed from: private */
    public Response readNetworkResponse() throws IOException {
        this.transport.finishRequest();
        Response networkResponse = this.transport.readResponseHeaders().request(this.networkRequest).handshake(this.connection.getHandshake()).header(OkHeaders.SENT_MILLIS, Long.toString(this.sentRequestMillis)).header(OkHeaders.RECEIVED_MILLIS, Long.toString(System.currentTimeMillis())).build();
        if (!this.forWebSocket) {
            networkResponse = networkResponse.newBuilder().body(this.transport.openResponseBody(networkResponse)).build();
        }
        Internal.instance.setProtocol(this.connection, networkResponse.protocol());
        return networkResponse;
    }

    private Response cacheWritingResponse(final CacheRequest cacheRequest, Response response) throws IOException {
        Sink cacheBodyUnbuffered;
        if (cacheRequest == null || (cacheBodyUnbuffered = cacheRequest.body()) == null) {
            return response;
        }
        final BufferedSource source = response.body().source();
        final BufferedSink cacheBody = Okio.buffer(cacheBodyUnbuffered);
        return response.newBuilder().body(new RealResponseBody(response.headers(), Okio.buffer(new Source() {
            boolean cacheRequestClosed;

            public long read(Buffer sink, long byteCount) throws IOException {
                try {
                    long bytesRead = source.read(sink, byteCount);
                    if (bytesRead == -1) {
                        if (!this.cacheRequestClosed) {
                            this.cacheRequestClosed = true;
                            cacheBody.close();
                        }
                        return -1;
                    }
                    sink.copyTo(cacheBody.buffer(), sink.size() - bytesRead, bytesRead);
                    cacheBody.emitCompleteSegments();
                    return bytesRead;
                } catch (IOException e) {
                    if (!this.cacheRequestClosed) {
                        this.cacheRequestClosed = true;
                        cacheRequest.abort();
                    }
                    throw e;
                }
            }

            public Timeout timeout() {
                return source.timeout();
            }

            public void close() throws IOException {
                if (!this.cacheRequestClosed && !Util.discard(this, 100, TimeUnit.MILLISECONDS)) {
                    this.cacheRequestClosed = true;
                    cacheRequest.abort();
                }
                source.close();
            }
        }))).build();
    }

    private static boolean validate(Response cached, Response network) {
        Date networkLastModified;
        if (network.code() == 304) {
            return true;
        }
        Date lastModified = cached.headers().getDate("Last-Modified");
        if (lastModified == null || (networkLastModified = network.headers().getDate("Last-Modified")) == null || networkLastModified.getTime() >= lastModified.getTime()) {
            return false;
        }
        return true;
    }

    private static Headers combine(Headers cachedHeaders, Headers networkHeaders) throws IOException {
        Headers.Builder result = new Headers.Builder();
        int size = cachedHeaders.size();
        for (int i = 0; i < size; i++) {
            String fieldName = cachedHeaders.name(i);
            String value = cachedHeaders.value(i);
            if ((!"Warning".equalsIgnoreCase(fieldName) || !value.startsWith("1")) && (!OkHeaders.isEndToEnd(fieldName) || networkHeaders.get(fieldName) == null)) {
                result.add(fieldName, value);
            }
        }
        int size2 = networkHeaders.size();
        for (int i2 = 0; i2 < size2; i2++) {
            String fieldName2 = networkHeaders.name(i2);
            if (!"Content-Length".equalsIgnoreCase(fieldName2) && OkHeaders.isEndToEnd(fieldName2)) {
                result.add(fieldName2, networkHeaders.value(i2));
            }
        }
        return result.build();
    }

    public void receiveHeaders(Headers headers) throws IOException {
        CookieHandler cookieHandler = this.client.getCookieHandler();
        if (cookieHandler != null) {
            cookieHandler.put(this.userRequest.uri(), OkHeaders.toMultimap(headers, (String) null));
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:20:0x0069, code lost:
        if (r9.client.getFollowRedirects() == false) goto L_?;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:21:0x006b, code lost:
        r0 = r9.userResponse.header("Location");
     */
    /* JADX WARNING: Code restructure failed: missing block: B:22:0x0073, code lost:
        if (r0 == null) goto L_?;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:23:0x0075, code lost:
        r5 = new java.net.URL(r9.userRequest.url(), r0);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:24:0x008a, code lost:
        if (r5.getProtocol().equals("https") != false) goto L_0x0098;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:26:0x0096, code lost:
        if (r5.getProtocol().equals("http") == false) goto L_?;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:28:0x00aa, code lost:
        if (r5.getProtocol().equals(r9.userRequest.url().getProtocol()) != false) goto L_0x00b4;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:30:0x00b2, code lost:
        if (r9.client.getFollowSslRedirects() == false) goto L_?;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:31:0x00b4, code lost:
        r1 = r9.userRequest.newBuilder();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:32:0x00c4, code lost:
        if (com.squareup.okhttp.internal.http.HttpMethod.permitsRequestBody(r9.userRequest.method()) == false) goto L_0x00da;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:33:0x00c6, code lost:
        r1.method("GET", (com.squareup.okhttp.RequestBody) null);
        r1.removeHeader("Transfer-Encoding");
        r1.removeHeader("Content-Length");
        r1.removeHeader("Content-Type");
     */
    /* JADX WARNING: Code restructure failed: missing block: B:35:0x00de, code lost:
        if (sameConnection(r5) != false) goto L_0x00e5;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:36:0x00e0, code lost:
        r1.removeHeader("Authorization");
     */
    /* JADX WARNING: Code restructure failed: missing block: B:39:?, code lost:
        return com.squareup.okhttp.internal.http.OkHeaders.processAuthHeader(r9.client.getAuthenticator(), r9.userResponse, r4);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:41:?, code lost:
        return null;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:42:?, code lost:
        return null;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:43:?, code lost:
        return null;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:44:?, code lost:
        return null;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:45:?, code lost:
        return r1.url(r5).build();
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public com.squareup.okhttp.Request followUpRequest() throws java.io.IOException {
        /*
            r9 = this;
            r6 = 0
            com.squareup.okhttp.Response r7 = r9.userResponse
            if (r7 != 0) goto L_0x000b
            java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
            r6.<init>()
            throw r6
        L_0x000b:
            com.squareup.okhttp.Route r7 = r9.getRoute()
            if (r7 == 0) goto L_0x0023
            com.squareup.okhttp.Route r7 = r9.getRoute()
            java.net.Proxy r4 = r7.getProxy()
        L_0x0019:
            com.squareup.okhttp.Response r7 = r9.userResponse
            int r2 = r7.code()
            switch(r2) {
                case 300: goto L_0x0063;
                case 301: goto L_0x0063;
                case 302: goto L_0x0063;
                case 303: goto L_0x0063;
                case 307: goto L_0x0047;
                case 308: goto L_0x0047;
                case 401: goto L_0x003a;
                case 407: goto L_0x002a;
                default: goto L_0x0022;
            }
        L_0x0022:
            return r6
        L_0x0023:
            com.squareup.okhttp.OkHttpClient r7 = r9.client
            java.net.Proxy r4 = r7.getProxy()
            goto L_0x0019
        L_0x002a:
            java.net.Proxy$Type r6 = r4.type()
            java.net.Proxy$Type r7 = java.net.Proxy.Type.HTTP
            if (r6 == r7) goto L_0x003a
            java.net.ProtocolException r6 = new java.net.ProtocolException
            java.lang.String r7 = "Received HTTP_PROXY_AUTH (407) code while not using proxy"
            r6.<init>(r7)
            throw r6
        L_0x003a:
            com.squareup.okhttp.OkHttpClient r6 = r9.client
            com.squareup.okhttp.Authenticator r6 = r6.getAuthenticator()
            com.squareup.okhttp.Response r7 = r9.userResponse
            com.squareup.okhttp.Request r6 = com.squareup.okhttp.internal.http.OkHeaders.processAuthHeader(r6, r7, r4)
            goto L_0x0022
        L_0x0047:
            com.squareup.okhttp.Request r7 = r9.userRequest
            java.lang.String r7 = r7.method()
            java.lang.String r8 = "GET"
            boolean r7 = r7.equals(r8)
            if (r7 != 0) goto L_0x0063
            com.squareup.okhttp.Request r7 = r9.userRequest
            java.lang.String r7 = r7.method()
            java.lang.String r8 = "HEAD"
            boolean r7 = r7.equals(r8)
            if (r7 == 0) goto L_0x0022
        L_0x0063:
            com.squareup.okhttp.OkHttpClient r7 = r9.client
            boolean r7 = r7.getFollowRedirects()
            if (r7 == 0) goto L_0x0022
            com.squareup.okhttp.Response r7 = r9.userResponse
            java.lang.String r8 = "Location"
            java.lang.String r0 = r7.header(r8)
            if (r0 == 0) goto L_0x0022
            java.net.URL r5 = new java.net.URL
            com.squareup.okhttp.Request r7 = r9.userRequest
            java.net.URL r7 = r7.url()
            r5.<init>(r7, r0)
            java.lang.String r7 = r5.getProtocol()
            java.lang.String r8 = "https"
            boolean r7 = r7.equals(r8)
            if (r7 != 0) goto L_0x0098
            java.lang.String r7 = r5.getProtocol()
            java.lang.String r8 = "http"
            boolean r7 = r7.equals(r8)
            if (r7 == 0) goto L_0x0022
        L_0x0098:
            java.lang.String r7 = r5.getProtocol()
            com.squareup.okhttp.Request r8 = r9.userRequest
            java.net.URL r8 = r8.url()
            java.lang.String r8 = r8.getProtocol()
            boolean r3 = r7.equals(r8)
            if (r3 != 0) goto L_0x00b4
            com.squareup.okhttp.OkHttpClient r7 = r9.client
            boolean r7 = r7.getFollowSslRedirects()
            if (r7 == 0) goto L_0x0022
        L_0x00b4:
            com.squareup.okhttp.Request r7 = r9.userRequest
            com.squareup.okhttp.Request$Builder r1 = r7.newBuilder()
            com.squareup.okhttp.Request r7 = r9.userRequest
            java.lang.String r7 = r7.method()
            boolean r7 = com.squareup.okhttp.internal.http.HttpMethod.permitsRequestBody(r7)
            if (r7 == 0) goto L_0x00da
            java.lang.String r7 = "GET"
            r1.method(r7, r6)
            java.lang.String r6 = "Transfer-Encoding"
            r1.removeHeader(r6)
            java.lang.String r6 = "Content-Length"
            r1.removeHeader(r6)
            java.lang.String r6 = "Content-Type"
            r1.removeHeader(r6)
        L_0x00da:
            boolean r6 = r9.sameConnection(r5)
            if (r6 != 0) goto L_0x00e5
            java.lang.String r6 = "Authorization"
            r1.removeHeader(r6)
        L_0x00e5:
            com.squareup.okhttp.Request$Builder r6 = r1.url((java.net.URL) r5)
            com.squareup.okhttp.Request r6 = r6.build()
            goto L_0x0022
        */
        throw new UnsupportedOperationException("Method not decompiled: com.squareup.okhttp.internal.http.HttpEngine.followUpRequest():com.squareup.okhttp.Request");
    }

    public boolean sameConnection(URL followUp) {
        URL url = this.userRequest.url();
        return url.getHost().equals(followUp.getHost()) && Util.getEffectivePort(url) == Util.getEffectivePort(followUp) && url.getProtocol().equals(followUp.getProtocol());
    }

    private static Address createAddress(OkHttpClient client2, Request request) throws UnknownHostException {
        String uriHost = request.url().getHost();
        if (uriHost == null || uriHost.length() == 0) {
            throw new UnknownHostException(request.url().toString());
        }
        SSLSocketFactory sslSocketFactory = null;
        HostnameVerifier hostnameVerifier = null;
        CertificatePinner certificatePinner = null;
        if (request.isHttps()) {
            sslSocketFactory = client2.getSslSocketFactory();
            hostnameVerifier = client2.getHostnameVerifier();
            certificatePinner = client2.getCertificatePinner();
        }
        return new Address(uriHost, Util.getEffectivePort(request.url()), client2.getSocketFactory(), sslSocketFactory, hostnameVerifier, certificatePinner, client2.getAuthenticator(), client2.getProxy(), client2.getProtocols(), client2.getConnectionSpecs(), client2.getProxySelector());
    }
}
