package okhttp3.internal.http;

import java.io.Closeable;
import java.io.IOException;
import java.net.ProtocolException;
import java.util.Date;
import java.util.List;
import java.util.concurrent.TimeUnit;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.SSLSocketFactory;
import okhttp3.Address;
import okhttp3.CertificatePinner;
import okhttp3.Connection;
import okhttp3.Cookie;
import okhttp3.CookieJar;
import okhttp3.Headers;
import okhttp3.HttpUrl;
import okhttp3.Interceptor;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Protocol;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.ResponseBody;
import okhttp3.internal.Internal;
import okhttp3.internal.InternalCache;
import okhttp3.internal.Util;
import okhttp3.internal.Version;
import okhttp3.internal.http.CacheStrategy;
import okio.Buffer;
import okio.BufferedSink;
import okio.BufferedSource;
import okio.GzipSource;
import okio.Okio;
import okio.Sink;
import okio.Source;
import okio.Timeout;

public final class HttpEngine {
    public static final int MAX_FOLLOW_UPS = 20;

    /* renamed from: c */
    private static final ResponseBody f6209c = new ResponseBody() {
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

    /* renamed from: a */
    final OkHttpClient f6210a;

    /* renamed from: b */
    long f6211b = -1;
    public final boolean bufferRequestBody;

    /* renamed from: d */
    private final Response f6212d;
    /* access modifiers changed from: private */

    /* renamed from: e */
    public HttpStream f6213e;

    /* renamed from: f */
    private boolean f6214f;

    /* renamed from: g */
    private final Request f6215g;
    /* access modifiers changed from: private */

    /* renamed from: h */
    public Request f6216h;

    /* renamed from: i */
    private Response f6217i;

    /* renamed from: j */
    private Response f6218j;

    /* renamed from: k */
    private Sink f6219k;

    /* renamed from: l */
    private BufferedSink f6220l;

    /* renamed from: m */
    private final boolean f6221m;

    /* renamed from: n */
    private final boolean f6222n;

    /* renamed from: o */
    private CacheRequest f6223o;

    /* renamed from: p */
    private CacheStrategy f6224p;
    public final StreamAllocation streamAllocation;

    public HttpEngine(OkHttpClient okHttpClient, Request request, boolean z, boolean z2, boolean z3, StreamAllocation streamAllocation2, RetryableSink retryableSink, Response response) {
        this.f6210a = okHttpClient;
        this.f6215g = request;
        this.bufferRequestBody = z;
        this.f6221m = z2;
        this.f6222n = z3;
        this.streamAllocation = streamAllocation2 == null ? new StreamAllocation(okHttpClient.connectionPool(), m6835a(okHttpClient, request)) : streamAllocation2;
        this.f6219k = retryableSink;
        this.f6212d = response;
    }

    public void sendRequest() throws RequestException, RouteException, IOException {
        if (this.f6224p == null) {
            if (this.f6213e != null) {
                throw new IllegalStateException();
            }
            Request b = m6843b(this.f6215g);
            InternalCache internalCache = Internal.instance.internalCache(this.f6210a);
            Response response = internalCache != null ? internalCache.get(b) : null;
            this.f6224p = new CacheStrategy.Factory(System.currentTimeMillis(), b, response).get();
            this.f6216h = this.f6224p.networkRequest;
            this.f6217i = this.f6224p.cacheResponse;
            if (internalCache != null) {
                internalCache.trackResponse(this.f6224p);
            }
            if (response != null && this.f6217i == null) {
                Util.closeQuietly((Closeable) response.body());
            }
            if (this.f6216h == null && this.f6217i == null) {
                this.f6218j = new Response.Builder().request(this.f6215g).priorResponse(m6838a(this.f6212d)).protocol(Protocol.HTTP_1_1).code(504).message("Unsatisfiable Request (only-if-cached)").body(f6209c).build();
            } else if (this.f6216h == null) {
                this.f6218j = this.f6217i.newBuilder().request(this.f6215g).priorResponse(m6838a(this.f6212d)).cacheResponse(m6838a(this.f6217i)).build();
                this.f6218j = m6844b(this.f6218j);
            } else {
                try {
                    this.f6213e = m6846b();
                    this.f6213e.setHttpEngine(this);
                    if (m6841a()) {
                        long contentLength = OkHeaders.contentLength(b);
                        if (!this.bufferRequestBody) {
                            this.f6213e.writeRequestHeaders(this.f6216h);
                            this.f6219k = this.f6213e.createRequestBody(this.f6216h, contentLength);
                        } else if (contentLength > 2147483647L) {
                            throw new IllegalStateException("Use setFixedLengthStreamingMode() or setChunkedStreamingMode() for requests larger than 2 GiB.");
                        } else if (contentLength != -1) {
                            this.f6213e.writeRequestHeaders(this.f6216h);
                            this.f6219k = new RetryableSink((int) contentLength);
                        } else {
                            this.f6219k = new RetryableSink();
                        }
                    }
                } catch (Throwable th) {
                    if (response != null) {
                        Util.closeQuietly((Closeable) response.body());
                    }
                    throw th;
                }
            }
        }
    }

    /* renamed from: a */
    private boolean m6841a() {
        return this.f6221m && mo11105a(this.f6216h) && this.f6219k == null;
    }

    /* renamed from: b */
    private HttpStream m6846b() throws RouteException, RequestException, IOException {
        return this.streamAllocation.newStream(this.f6210a.connectTimeoutMillis(), this.f6210a.readTimeoutMillis(), this.f6210a.writeTimeoutMillis(), this.f6210a.retryOnConnectionFailure(), !this.f6216h.method().equals("GET"));
    }

    /* renamed from: a */
    private static Response m6838a(Response response) {
        return (response == null || response.body() == null) ? response : response.newBuilder().body((ResponseBody) null).build();
    }

    public void writingRequestHeaders() {
        if (this.f6211b != -1) {
            throw new IllegalStateException();
        }
        this.f6211b = System.currentTimeMillis();
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public boolean mo11105a(Request request) {
        return HttpMethod.permitsRequestBody(request.method());
    }

    public Sink getRequestBody() {
        if (this.f6224p != null) {
            return this.f6219k;
        }
        throw new IllegalStateException();
    }

    public BufferedSink getBufferedRequestBody() {
        BufferedSink bufferedSink = this.f6220l;
        if (bufferedSink != null) {
            return bufferedSink;
        }
        Sink requestBody = getRequestBody();
        if (requestBody == null) {
            return null;
        }
        BufferedSink buffer = Okio.buffer(requestBody);
        this.f6220l = buffer;
        return buffer;
    }

    public boolean hasResponse() {
        return this.f6218j != null;
    }

    public Request getRequest() {
        return this.f6215g;
    }

    public Response getResponse() {
        if (this.f6218j != null) {
            return this.f6218j;
        }
        throw new IllegalStateException();
    }

    public Connection getConnection() {
        return this.streamAllocation.connection();
    }

    public HttpEngine recover(IOException iOException, Sink sink) {
        if (!this.streamAllocation.recover(iOException, sink) || !this.f6210a.retryOnConnectionFailure()) {
            return null;
        }
        return new HttpEngine(this.f6210a, this.f6215g, this.bufferRequestBody, this.f6221m, this.f6222n, close(), (RetryableSink) sink, this.f6212d);
    }

    public HttpEngine recover(IOException iOException) {
        return recover(iOException, this.f6219k);
    }

    /* renamed from: c */
    private void m6847c() throws IOException {
        InternalCache internalCache = Internal.instance.internalCache(this.f6210a);
        if (internalCache != null) {
            if (CacheStrategy.isCacheable(this.f6218j, this.f6216h)) {
                this.f6223o = internalCache.put(m6838a(this.f6218j));
            } else if (HttpMethod.invalidatesCache(this.f6216h.method())) {
                try {
                    internalCache.remove(this.f6216h);
                } catch (IOException e) {
                }
            }
        }
    }

    public void releaseStreamAllocation() throws IOException {
        this.streamAllocation.release();
    }

    public void cancel() {
        this.streamAllocation.cancel();
    }

    public StreamAllocation close() {
        if (this.f6220l != null) {
            Util.closeQuietly((Closeable) this.f6220l);
        } else if (this.f6219k != null) {
            Util.closeQuietly((Closeable) this.f6219k);
        }
        if (this.f6218j != null) {
            Util.closeQuietly((Closeable) this.f6218j.body());
        } else {
            this.streamAllocation.connectionFailed((IOException) null);
        }
        return this.streamAllocation;
    }

    /* renamed from: b */
    private Response m6844b(Response response) throws IOException {
        if (!this.f6214f || !"gzip".equalsIgnoreCase(this.f6218j.header("Content-Encoding")) || response.body() == null) {
            return response;
        }
        GzipSource gzipSource = new GzipSource(response.body().source());
        Headers build = response.headers().newBuilder().removeAll("Content-Encoding").removeAll("Content-Length").build();
        return response.newBuilder().headers(build).body(new RealResponseBody(build, Okio.buffer((Source) gzipSource))).build();
    }

    public static boolean hasBody(Response response) {
        if (response.request().method().equals("HEAD")) {
            return false;
        }
        int code = response.code();
        if ((code < 100 || code >= 200) && code != 204 && code != 304) {
            return true;
        }
        if (OkHeaders.contentLength(response) != -1 || "chunked".equalsIgnoreCase(response.header("Transfer-Encoding"))) {
            return true;
        }
        return false;
    }

    /* renamed from: b */
    private Request m6843b(Request request) throws IOException {
        Request.Builder newBuilder = request.newBuilder();
        if (request.header("Host") == null) {
            newBuilder.header("Host", Util.hostHeader(request.url()));
        }
        if (request.header("Connection") == null) {
            newBuilder.header("Connection", "Keep-Alive");
        }
        if (request.header("Accept-Encoding") == null) {
            this.f6214f = true;
            newBuilder.header("Accept-Encoding", "gzip");
        }
        List<Cookie> loadForRequest = this.f6210a.cookieJar().loadForRequest(request.url());
        if (!loadForRequest.isEmpty()) {
            newBuilder.header("Cookie", m6834a(loadForRequest));
        }
        if (request.header("User-Agent") == null) {
            newBuilder.header("User-Agent", Version.userAgent());
        }
        return newBuilder.build();
    }

    /* renamed from: a */
    private String m6834a(List<Cookie> list) {
        StringBuilder sb = new StringBuilder();
        int size = list.size();
        for (int i = 0; i < size; i++) {
            if (i > 0) {
                sb.append("; ");
            }
            Cookie cookie = list.get(i);
            sb.append(cookie.name()).append('=').append(cookie.value());
        }
        return sb.toString();
    }

    public void readResponse() throws IOException {
        Response d;
        if (this.f6218j == null) {
            if (this.f6216h == null && this.f6217i == null) {
                throw new IllegalStateException("call sendRequest() first!");
            } else if (this.f6216h != null) {
                if (this.f6222n) {
                    this.f6213e.writeRequestHeaders(this.f6216h);
                    d = m6848d();
                } else if (!this.f6221m) {
                    d = new C1820a(0, this.f6216h).proceed(this.f6216h);
                } else {
                    if (this.f6220l != null && this.f6220l.buffer().size() > 0) {
                        this.f6220l.emit();
                    }
                    if (this.f6211b == -1) {
                        if (OkHeaders.contentLength(this.f6216h) == -1 && (this.f6219k instanceof RetryableSink)) {
                            this.f6216h = this.f6216h.newBuilder().header("Content-Length", Long.toString(((RetryableSink) this.f6219k).contentLength())).build();
                        }
                        this.f6213e.writeRequestHeaders(this.f6216h);
                    }
                    if (this.f6219k != null) {
                        if (this.f6220l != null) {
                            this.f6220l.close();
                        } else {
                            this.f6219k.close();
                        }
                        if (this.f6219k instanceof RetryableSink) {
                            this.f6213e.writeRequestBody((RetryableSink) this.f6219k);
                        }
                    }
                    d = m6848d();
                }
                receiveHeaders(d.headers());
                if (this.f6217i != null) {
                    if (m6842a(this.f6217i, d)) {
                        this.f6218j = this.f6217i.newBuilder().request(this.f6215g).priorResponse(m6838a(this.f6212d)).headers(m6836a(this.f6217i.headers(), d.headers())).cacheResponse(m6838a(this.f6217i)).networkResponse(m6838a(d)).build();
                        d.body().close();
                        releaseStreamAllocation();
                        InternalCache internalCache = Internal.instance.internalCache(this.f6210a);
                        internalCache.trackConditionalCacheHit();
                        internalCache.update(this.f6217i, m6838a(this.f6218j));
                        this.f6218j = m6844b(this.f6218j);
                        return;
                    }
                    Util.closeQuietly((Closeable) this.f6217i.body());
                }
                this.f6218j = d.newBuilder().request(this.f6215g).priorResponse(m6838a(this.f6212d)).cacheResponse(m6838a(this.f6217i)).networkResponse(m6838a(d)).build();
                if (hasBody(this.f6218j)) {
                    m6847c();
                    this.f6218j = m6844b(m6839a(this.f6223o, this.f6218j));
                }
            }
        }
    }

    /* renamed from: okhttp3.internal.http.HttpEngine$a */
    class C1820a implements Interceptor.Chain {

        /* renamed from: b */
        private final int f6231b;

        /* renamed from: c */
        private final Request f6232c;

        /* renamed from: d */
        private int f6233d;

        C1820a(int i, Request request) {
            this.f6231b = i;
            this.f6232c = request;
        }

        public Connection connection() {
            return HttpEngine.this.streamAllocation.connection();
        }

        public Request request() {
            return this.f6232c;
        }

        public Response proceed(Request request) throws IOException {
            this.f6233d++;
            if (this.f6231b > 0) {
                Interceptor interceptor = HttpEngine.this.f6210a.networkInterceptors().get(this.f6231b - 1);
                Address address = connection().route().address();
                if (!request.url().host().equals(address.url().host()) || request.url().port() != address.url().port()) {
                    throw new IllegalStateException("network interceptor " + interceptor + " must retain the same host and port");
                } else if (this.f6233d > 1) {
                    throw new IllegalStateException("network interceptor " + interceptor + " must call proceed() exactly once");
                }
            }
            if (this.f6231b < HttpEngine.this.f6210a.networkInterceptors().size()) {
                C1820a aVar = new C1820a(this.f6231b + 1, request);
                Interceptor interceptor2 = HttpEngine.this.f6210a.networkInterceptors().get(this.f6231b);
                Response intercept = interceptor2.intercept(aVar);
                if (aVar.f6233d != 1) {
                    throw new IllegalStateException("network interceptor " + interceptor2 + " must call proceed() exactly once");
                } else if (intercept != null) {
                    return intercept;
                } else {
                    throw new NullPointerException("network interceptor " + interceptor2 + " returned null");
                }
            } else {
                HttpEngine.this.f6213e.writeRequestHeaders(request);
                Request unused = HttpEngine.this.f6216h = request;
                if (HttpEngine.this.mo11105a(request) && request.body() != null) {
                    BufferedSink buffer = Okio.buffer(HttpEngine.this.f6213e.createRequestBody(request, request.body().contentLength()));
                    request.body().writeTo(buffer);
                    buffer.close();
                }
                Response b = HttpEngine.this.m6848d();
                int code = b.code();
                if ((code != 204 && code != 205) || b.body().contentLength() <= 0) {
                    return b;
                }
                throw new ProtocolException("HTTP " + code + " had non-zero Content-Length: " + b.body().contentLength());
            }
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: d */
    public Response m6848d() throws IOException {
        this.f6213e.finishRequest();
        Response build = this.f6213e.readResponseHeaders().request(this.f6216h).handshake(this.streamAllocation.connection().handshake()).header(OkHeaders.SENT_MILLIS, Long.toString(this.f6211b)).header(OkHeaders.RECEIVED_MILLIS, Long.toString(System.currentTimeMillis())).build();
        if (!this.f6222n) {
            build = build.newBuilder().body(this.f6213e.openResponseBody(build)).build();
        }
        if ("close".equalsIgnoreCase(build.request().header("Connection")) || "close".equalsIgnoreCase(build.header("Connection"))) {
            this.streamAllocation.noNewStreams();
        }
        return build;
    }

    /* renamed from: a */
    private Response m6839a(final CacheRequest cacheRequest, Response response) throws IOException {
        Sink body;
        if (cacheRequest == null || (body = cacheRequest.body()) == null) {
            return response;
        }
        final BufferedSource source = response.body().source();
        final BufferedSink buffer = Okio.buffer(body);
        return response.newBuilder().body(new RealResponseBody(response.headers(), Okio.buffer((Source) new Source() {

            /* renamed from: a */
            boolean f6225a;

            public long read(Buffer buffer, long j) throws IOException {
                try {
                    long read = source.read(buffer, j);
                    if (read == -1) {
                        if (!this.f6225a) {
                            this.f6225a = true;
                            buffer.close();
                        }
                        return -1;
                    }
                    buffer.copyTo(buffer.buffer(), buffer.size() - read, read);
                    buffer.emitCompleteSegments();
                    return read;
                } catch (IOException e) {
                    if (!this.f6225a) {
                        this.f6225a = true;
                        cacheRequest.abort();
                    }
                    throw e;
                }
            }

            public Timeout timeout() {
                return source.timeout();
            }

            public void close() throws IOException {
                if (!this.f6225a && !Util.discard(this, 100, TimeUnit.MILLISECONDS)) {
                    this.f6225a = true;
                    cacheRequest.abort();
                }
                source.close();
            }
        }))).build();
    }

    /* renamed from: a */
    private static boolean m6842a(Response response, Response response2) {
        Date date;
        if (response2.code() == 304) {
            return true;
        }
        Date date2 = response.headers().getDate("Last-Modified");
        if (date2 == null || (date = response2.headers().getDate("Last-Modified")) == null || date.getTime() >= date2.getTime()) {
            return false;
        }
        return true;
    }

    /* renamed from: a */
    private static Headers m6836a(Headers headers, Headers headers2) throws IOException {
        Headers.Builder builder = new Headers.Builder();
        int size = headers.size();
        for (int i = 0; i < size; i++) {
            String name = headers.name(i);
            String value = headers.value(i);
            if ((!"Warning".equalsIgnoreCase(name) || !value.startsWith("1")) && (!OkHeaders.m6851a(name) || headers2.get(name) == null)) {
                builder.add(name, value);
            }
        }
        int size2 = headers2.size();
        for (int i2 = 0; i2 < size2; i2++) {
            String name2 = headers2.name(i2);
            if (!"Content-Length".equalsIgnoreCase(name2) && OkHeaders.m6851a(name2)) {
                builder.add(name2, headers2.value(i2));
            }
        }
        return builder.build();
    }

    public void receiveHeaders(Headers headers) throws IOException {
        if (this.f6210a.cookieJar() != CookieJar.NO_COOKIES) {
            List<Cookie> parseAll = Cookie.parseAll(this.f6215g.url(), headers);
            if (!parseAll.isEmpty()) {
                this.f6210a.cookieJar().saveFromResponse(this.f6215g.url(), parseAll);
            }
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:23:0x0069, code lost:
        if (r5.f6210a.followRedirects() == false) goto L_?;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:24:0x006b, code lost:
        r0 = r5.f6218j.header("Location");
     */
    /* JADX WARNING: Code restructure failed: missing block: B:25:0x0073, code lost:
        if (r0 == null) goto L_?;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:26:0x0075, code lost:
        r0 = r5.f6215g.url().resolve(r0);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:27:0x007f, code lost:
        if (r0 == null) goto L_?;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:29:0x0093, code lost:
        if (r0.scheme().equals(r5.f6215g.url().scheme()) != false) goto L_0x009d;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:31:0x009b, code lost:
        if (r5.f6210a.followSslRedirects() == false) goto L_?;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:32:0x009d, code lost:
        r2 = r5.f6215g.newBuilder();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:33:0x00a7, code lost:
        if (okhttp3.internal.http.HttpMethod.permitsRequestBody(r3) == false) goto L_0x00c3;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:35:0x00ad, code lost:
        if (okhttp3.internal.http.HttpMethod.redirectsToGet(r3) == false) goto L_0x00d8;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:36:0x00af, code lost:
        r2.method("GET", (okhttp3.RequestBody) null);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:37:0x00b4, code lost:
        r2.removeHeader("Transfer-Encoding");
        r2.removeHeader("Content-Length");
        r2.removeHeader("Content-Type");
     */
    /* JADX WARNING: Code restructure failed: missing block: B:39:0x00c7, code lost:
        if (sameConnection(r0) != false) goto L_0x00ce;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:40:0x00c9, code lost:
        r2.removeHeader("Authorization");
     */
    /* JADX WARNING: Code restructure failed: missing block: B:42:0x00d8, code lost:
        r2.method(r3, (okhttp3.RequestBody) null);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:44:?, code lost:
        return r5.f6210a.authenticator().authenticate(r0, r5.f6218j);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:46:?, code lost:
        return null;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:47:?, code lost:
        return null;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:48:?, code lost:
        return null;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:49:?, code lost:
        return null;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:50:?, code lost:
        return r2.url(r0).build();
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public okhttp3.Request followUpRequest() throws java.io.IOException {
        /*
            r5 = this;
            r1 = 0
            okhttp3.Response r0 = r5.f6218j
            if (r0 != 0) goto L_0x000b
            java.lang.IllegalStateException r0 = new java.lang.IllegalStateException
            r0.<init>()
            throw r0
        L_0x000b:
            okhttp3.internal.http.StreamAllocation r0 = r5.streamAllocation
            okhttp3.internal.io.RealConnection r0 = r0.connection()
            if (r0 == 0) goto L_0x0027
            okhttp3.Route r0 = r0.route()
        L_0x0017:
            okhttp3.Response r2 = r5.f6218j
            int r2 = r2.code()
            okhttp3.Request r3 = r5.f6215g
            java.lang.String r3 = r3.method()
            switch(r2) {
                case 300: goto L_0x0063;
                case 301: goto L_0x0063;
                case 302: goto L_0x0063;
                case 303: goto L_0x0063;
                case 307: goto L_0x0053;
                case 308: goto L_0x0053;
                case 401: goto L_0x0046;
                case 407: goto L_0x0029;
                default: goto L_0x0026;
            }
        L_0x0026:
            return r1
        L_0x0027:
            r0 = r1
            goto L_0x0017
        L_0x0029:
            if (r0 == 0) goto L_0x003f
            java.net.Proxy r1 = r0.proxy()
        L_0x002f:
            java.net.Proxy$Type r1 = r1.type()
            java.net.Proxy$Type r2 = java.net.Proxy.Type.HTTP
            if (r1 == r2) goto L_0x0046
            java.net.ProtocolException r0 = new java.net.ProtocolException
            java.lang.String r1 = "Received HTTP_PROXY_AUTH (407) code while not using proxy"
            r0.<init>(r1)
            throw r0
        L_0x003f:
            okhttp3.OkHttpClient r1 = r5.f6210a
            java.net.Proxy r1 = r1.proxy()
            goto L_0x002f
        L_0x0046:
            okhttp3.OkHttpClient r1 = r5.f6210a
            okhttp3.Authenticator r1 = r1.authenticator()
            okhttp3.Response r2 = r5.f6218j
            okhttp3.Request r1 = r1.authenticate(r0, r2)
            goto L_0x0026
        L_0x0053:
            java.lang.String r0 = "GET"
            boolean r0 = r3.equals(r0)
            if (r0 != 0) goto L_0x0063
            java.lang.String r0 = "HEAD"
            boolean r0 = r3.equals(r0)
            if (r0 == 0) goto L_0x0026
        L_0x0063:
            okhttp3.OkHttpClient r0 = r5.f6210a
            boolean r0 = r0.followRedirects()
            if (r0 == 0) goto L_0x0026
            okhttp3.Response r0 = r5.f6218j
            java.lang.String r2 = "Location"
            java.lang.String r0 = r0.header(r2)
            if (r0 == 0) goto L_0x0026
            okhttp3.Request r2 = r5.f6215g
            okhttp3.HttpUrl r2 = r2.url()
            okhttp3.HttpUrl r0 = r2.resolve(r0)
            if (r0 == 0) goto L_0x0026
            java.lang.String r2 = r0.scheme()
            okhttp3.Request r4 = r5.f6215g
            okhttp3.HttpUrl r4 = r4.url()
            java.lang.String r4 = r4.scheme()
            boolean r2 = r2.equals(r4)
            if (r2 != 0) goto L_0x009d
            okhttp3.OkHttpClient r2 = r5.f6210a
            boolean r2 = r2.followSslRedirects()
            if (r2 == 0) goto L_0x0026
        L_0x009d:
            okhttp3.Request r2 = r5.f6215g
            okhttp3.Request$Builder r2 = r2.newBuilder()
            boolean r4 = okhttp3.internal.http.HttpMethod.permitsRequestBody(r3)
            if (r4 == 0) goto L_0x00c3
            boolean r4 = okhttp3.internal.http.HttpMethod.redirectsToGet(r3)
            if (r4 == 0) goto L_0x00d8
            java.lang.String r3 = "GET"
            r2.method(r3, r1)
        L_0x00b4:
            java.lang.String r1 = "Transfer-Encoding"
            r2.removeHeader(r1)
            java.lang.String r1 = "Content-Length"
            r2.removeHeader(r1)
            java.lang.String r1 = "Content-Type"
            r2.removeHeader(r1)
        L_0x00c3:
            boolean r1 = r5.sameConnection(r0)
            if (r1 != 0) goto L_0x00ce
            java.lang.String r1 = "Authorization"
            r2.removeHeader(r1)
        L_0x00ce:
            okhttp3.Request$Builder r0 = r2.url((okhttp3.HttpUrl) r0)
            okhttp3.Request r1 = r0.build()
            goto L_0x0026
        L_0x00d8:
            r2.method(r3, r1)
            goto L_0x00b4
        */
        throw new UnsupportedOperationException("Method not decompiled: okhttp3.internal.http.HttpEngine.followUpRequest():okhttp3.Request");
    }

    public boolean sameConnection(HttpUrl httpUrl) {
        HttpUrl url = this.f6215g.url();
        return url.host().equals(httpUrl.host()) && url.port() == httpUrl.port() && url.scheme().equals(httpUrl.scheme());
    }

    /* renamed from: a */
    private static Address m6835a(OkHttpClient okHttpClient, Request request) {
        HostnameVerifier hostnameVerifier;
        SSLSocketFactory sSLSocketFactory;
        CertificatePinner certificatePinner = null;
        if (request.isHttps()) {
            sSLSocketFactory = okHttpClient.sslSocketFactory();
            hostnameVerifier = okHttpClient.hostnameVerifier();
            certificatePinner = okHttpClient.certificatePinner();
        } else {
            hostnameVerifier = null;
            sSLSocketFactory = null;
        }
        return new Address(request.url().host(), request.url().port(), okHttpClient.dns(), okHttpClient.socketFactory(), sSLSocketFactory, hostnameVerifier, certificatePinner, okHttpClient.proxyAuthenticator(), okHttpClient.proxy(), okHttpClient.protocols(), okHttpClient.connectionSpecs(), okHttpClient.proxySelector());
    }
}
