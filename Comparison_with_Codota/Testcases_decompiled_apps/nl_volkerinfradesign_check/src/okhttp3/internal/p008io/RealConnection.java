package okhttp3.internal.p008io;

import java.io.IOException;
import java.lang.ref.Reference;
import java.net.ConnectException;
import java.net.Socket;
import java.net.SocketTimeoutException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;
import okhttp3.Connection;
import okhttp3.Handshake;
import okhttp3.HttpUrl;
import okhttp3.Protocol;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.Route;
import okhttp3.internal.ConnectionSpecSelector;
import okhttp3.internal.Platform;
import okhttp3.internal.Util;
import okhttp3.internal.Version;
import okhttp3.internal.framed.FramedConnection;
import okhttp3.internal.http.Http1xStream;
import okhttp3.internal.http.OkHeaders;
import okhttp3.internal.http.StreamAllocation;
import okio.BufferedSink;
import okio.BufferedSource;
import okio.Okio;
import okio.Source;
import p010uk.p011co.senab.photoview.IPhotoView;

/* renamed from: okhttp3.internal.io.RealConnection */
public final class RealConnection implements Connection {

    /* renamed from: a */
    private final Route f6258a;
    public final List<Reference<StreamAllocation>> allocations = new ArrayList();

    /* renamed from: b */
    private Socket f6259b;

    /* renamed from: c */
    private Handshake f6260c;

    /* renamed from: d */
    private Protocol f6261d;
    public volatile FramedConnection framedConnection;
    public long idleAtNanos = Long.MAX_VALUE;
    public boolean noNewStreams;
    public BufferedSink sink;
    public Socket socket;
    public BufferedSource source;
    public int successCount;

    public RealConnection(Route route) {
        this.f6258a = route;
    }

    /* JADX WARNING: CFG modification limit reached, blocks count: 135 */
    /* JADX WARNING: Removed duplicated region for block: B:15:0x005e A[SYNTHETIC, Splitter:B:15:0x005e] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void connect(int r8, int r9, int r10, java.util.List<okhttp3.ConnectionSpec> r11, boolean r12) throws okhttp3.internal.http.RouteException {
        /*
            r7 = this;
            r1 = 0
            okhttp3.Protocol r0 = r7.f6261d
            if (r0 == 0) goto L_0x000d
            java.lang.IllegalStateException r0 = new java.lang.IllegalStateException
            java.lang.String r1 = "already connected"
            r0.<init>(r1)
            throw r0
        L_0x000d:
            okhttp3.internal.ConnectionSpecSelector r3 = new okhttp3.internal.ConnectionSpecSelector
            r3.<init>(r11)
            okhttp3.Route r0 = r7.f6258a
            java.net.Proxy r4 = r0.proxy()
            okhttp3.Route r0 = r7.f6258a
            okhttp3.Address r5 = r0.address()
            okhttp3.Route r0 = r7.f6258a
            okhttp3.Address r0 = r0.address()
            javax.net.ssl.SSLSocketFactory r0 = r0.sslSocketFactory()
            if (r0 != 0) goto L_0x00a3
            okhttp3.ConnectionSpec r0 = okhttp3.ConnectionSpec.CLEARTEXT
            boolean r0 = r11.contains(r0)
            if (r0 != 0) goto L_0x00a3
            okhttp3.internal.http.RouteException r0 = new okhttp3.internal.http.RouteException
            java.net.UnknownServiceException r1 = new java.net.UnknownServiceException
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            java.lang.String r3 = "CLEARTEXT communication not supported: "
            java.lang.StringBuilder r2 = r2.append(r3)
            java.lang.StringBuilder r2 = r2.append(r11)
            java.lang.String r2 = r2.toString()
            r1.<init>(r2)
            r0.<init>(r1)
            throw r0
        L_0x0050:
            java.net.Socket r2 = new java.net.Socket     // Catch:{ IOException -> 0x0077 }
            r2.<init>(r4)     // Catch:{ IOException -> 0x0077 }
        L_0x0055:
            r7.f6259b = r2     // Catch:{ IOException -> 0x0077 }
            r7.m6873a(r8, r9, r10, r3)     // Catch:{ IOException -> 0x0077 }
        L_0x005a:
            okhttp3.Protocol r2 = r7.f6261d
            if (r2 != 0) goto L_0x00a2
            java.net.Proxy$Type r2 = r4.type()     // Catch:{ IOException -> 0x0077 }
            java.net.Proxy$Type r6 = java.net.Proxy.Type.DIRECT     // Catch:{ IOException -> 0x0077 }
            if (r2 == r6) goto L_0x006e
            java.net.Proxy$Type r2 = r4.type()     // Catch:{ IOException -> 0x0077 }
            java.net.Proxy$Type r6 = java.net.Proxy.Type.HTTP     // Catch:{ IOException -> 0x0077 }
            if (r2 != r6) goto L_0x0050
        L_0x006e:
            javax.net.SocketFactory r2 = r5.socketFactory()     // Catch:{ IOException -> 0x0077 }
            java.net.Socket r2 = r2.createSocket()     // Catch:{ IOException -> 0x0077 }
            goto L_0x0055
        L_0x0077:
            r2 = move-exception
            java.net.Socket r6 = r7.socket
            okhttp3.internal.Util.closeQuietly((java.net.Socket) r6)
            java.net.Socket r6 = r7.f6259b
            okhttp3.internal.Util.closeQuietly((java.net.Socket) r6)
            r7.socket = r1
            r7.f6259b = r1
            r7.source = r1
            r7.sink = r1
            r7.f6260c = r1
            r7.f6261d = r1
            if (r0 != 0) goto L_0x009e
            okhttp3.internal.http.RouteException r0 = new okhttp3.internal.http.RouteException
            r0.<init>(r2)
        L_0x0095:
            if (r12 == 0) goto L_0x009d
            boolean r2 = r3.connectionFailed(r2)
            if (r2 != 0) goto L_0x005a
        L_0x009d:
            throw r0
        L_0x009e:
            r0.addConnectException(r2)
            goto L_0x0095
        L_0x00a2:
            return
        L_0x00a3:
            r0 = r1
            goto L_0x005a
        */
        throw new UnsupportedOperationException("Method not decompiled: okhttp3.internal.p008io.RealConnection.connect(int, int, int, java.util.List, boolean):void");
    }

    /* renamed from: a */
    private void m6873a(int i, int i2, int i3, ConnectionSpecSelector connectionSpecSelector) throws IOException {
        this.f6259b.setSoTimeout(i2);
        try {
            Platform.get().connectSocket(this.f6259b, this.f6258a.socketAddress(), i);
            this.source = Okio.buffer(Okio.source(this.f6259b));
            this.sink = Okio.buffer(Okio.sink(this.f6259b));
            if (this.f6258a.address().sslSocketFactory() != null) {
                m6874a(i2, i3, connectionSpecSelector);
            } else {
                this.f6261d = Protocol.HTTP_1_1;
                this.socket = this.f6259b;
            }
            if (this.f6261d == Protocol.SPDY_3 || this.f6261d == Protocol.HTTP_2) {
                this.socket.setSoTimeout(0);
                FramedConnection build = new FramedConnection.Builder(true).socket(this.socket, this.f6258a.address().url().host(), this.source, this.sink).protocol(this.f6261d).build();
                build.sendConnectionPreface();
                this.framedConnection = build;
            }
        } catch (ConnectException e) {
            throw new ConnectException("Failed to connect to " + this.f6258a.socketAddress());
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v0, resolved type: java.lang.String} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v1, resolved type: javax.net.ssl.SSLSocket} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v2, resolved type: java.lang.String} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v9, resolved type: javax.net.ssl.SSLSocket} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v4, resolved type: javax.net.ssl.SSLSocket} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v6, resolved type: java.lang.String} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v7, resolved type: java.lang.String} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v20, resolved type: javax.net.ssl.SSLSocket} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v21, resolved type: java.lang.String} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void m6874a(int r10, int r11, okhttp3.internal.ConnectionSpecSelector r12) throws java.io.IOException {
        /*
            r9 = this;
            r1 = 0
            okhttp3.Route r0 = r9.f6258a
            boolean r0 = r0.requiresTunnel()
            if (r0 == 0) goto L_0x000c
            r9.m6872a(r10, r11)
        L_0x000c:
            okhttp3.Route r0 = r9.f6258a
            okhttp3.Address r2 = r0.address()
            javax.net.ssl.SSLSocketFactory r0 = r2.sslSocketFactory()
            java.net.Socket r3 = r9.f6259b     // Catch:{ AssertionError -> 0x0143 }
            okhttp3.HttpUrl r4 = r2.url()     // Catch:{ AssertionError -> 0x0143 }
            java.lang.String r4 = r4.host()     // Catch:{ AssertionError -> 0x0143 }
            okhttp3.HttpUrl r5 = r2.url()     // Catch:{ AssertionError -> 0x0143 }
            int r5 = r5.port()     // Catch:{ AssertionError -> 0x0143 }
            r6 = 1
            java.net.Socket r0 = r0.createSocket(r3, r4, r5, r6)     // Catch:{ AssertionError -> 0x0143 }
            javax.net.ssl.SSLSocket r0 = (javax.net.ssl.SSLSocket) r0     // Catch:{ AssertionError -> 0x0143 }
            okhttp3.ConnectionSpec r3 = r12.configureSecureSocket(r0)     // Catch:{ AssertionError -> 0x00cd, all -> 0x013e }
            boolean r4 = r3.supportsTlsExtensions()     // Catch:{ AssertionError -> 0x00cd, all -> 0x013e }
            if (r4 == 0) goto L_0x004c
            okhttp3.internal.Platform r4 = okhttp3.internal.Platform.get()     // Catch:{ AssertionError -> 0x00cd, all -> 0x013e }
            okhttp3.HttpUrl r5 = r2.url()     // Catch:{ AssertionError -> 0x00cd, all -> 0x013e }
            java.lang.String r5 = r5.host()     // Catch:{ AssertionError -> 0x00cd, all -> 0x013e }
            java.util.List r6 = r2.protocols()     // Catch:{ AssertionError -> 0x00cd, all -> 0x013e }
            r4.configureTlsExtensions(r0, r5, r6)     // Catch:{ AssertionError -> 0x00cd, all -> 0x013e }
        L_0x004c:
            r0.startHandshake()     // Catch:{ AssertionError -> 0x00cd, all -> 0x013e }
            javax.net.ssl.SSLSession r4 = r0.getSession()     // Catch:{ AssertionError -> 0x00cd, all -> 0x013e }
            okhttp3.Handshake r4 = okhttp3.Handshake.get(r4)     // Catch:{ AssertionError -> 0x00cd, all -> 0x013e }
            javax.net.ssl.HostnameVerifier r5 = r2.hostnameVerifier()     // Catch:{ AssertionError -> 0x00cd, all -> 0x013e }
            okhttp3.HttpUrl r6 = r2.url()     // Catch:{ AssertionError -> 0x00cd, all -> 0x013e }
            java.lang.String r6 = r6.host()     // Catch:{ AssertionError -> 0x00cd, all -> 0x013e }
            javax.net.ssl.SSLSession r7 = r0.getSession()     // Catch:{ AssertionError -> 0x00cd, all -> 0x013e }
            boolean r5 = r5.verify(r6, r7)     // Catch:{ AssertionError -> 0x00cd, all -> 0x013e }
            if (r5 != 0) goto L_0x00eb
            java.util.List r1 = r4.peerCertificates()     // Catch:{ AssertionError -> 0x00cd, all -> 0x013e }
            r3 = 0
            java.lang.Object r1 = r1.get(r3)     // Catch:{ AssertionError -> 0x00cd, all -> 0x013e }
            java.security.cert.X509Certificate r1 = (java.security.cert.X509Certificate) r1     // Catch:{ AssertionError -> 0x00cd, all -> 0x013e }
            javax.net.ssl.SSLPeerUnverifiedException r3 = new javax.net.ssl.SSLPeerUnverifiedException     // Catch:{ AssertionError -> 0x00cd, all -> 0x013e }
            java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch:{ AssertionError -> 0x00cd, all -> 0x013e }
            r4.<init>()     // Catch:{ AssertionError -> 0x00cd, all -> 0x013e }
            java.lang.String r5 = "Hostname "
            java.lang.StringBuilder r4 = r4.append(r5)     // Catch:{ AssertionError -> 0x00cd, all -> 0x013e }
            okhttp3.HttpUrl r2 = r2.url()     // Catch:{ AssertionError -> 0x00cd, all -> 0x013e }
            java.lang.String r2 = r2.host()     // Catch:{ AssertionError -> 0x00cd, all -> 0x013e }
            java.lang.StringBuilder r2 = r4.append(r2)     // Catch:{ AssertionError -> 0x00cd, all -> 0x013e }
            java.lang.String r4 = " not verified:"
            java.lang.StringBuilder r2 = r2.append(r4)     // Catch:{ AssertionError -> 0x00cd, all -> 0x013e }
            java.lang.String r4 = "\n    certificate: "
            java.lang.StringBuilder r2 = r2.append(r4)     // Catch:{ AssertionError -> 0x00cd, all -> 0x013e }
            java.lang.String r4 = okhttp3.CertificatePinner.pin(r1)     // Catch:{ AssertionError -> 0x00cd, all -> 0x013e }
            java.lang.StringBuilder r2 = r2.append(r4)     // Catch:{ AssertionError -> 0x00cd, all -> 0x013e }
            java.lang.String r4 = "\n    DN: "
            java.lang.StringBuilder r2 = r2.append(r4)     // Catch:{ AssertionError -> 0x00cd, all -> 0x013e }
            java.security.Principal r4 = r1.getSubjectDN()     // Catch:{ AssertionError -> 0x00cd, all -> 0x013e }  //CRYPTOGRAPHIC API CALLSITE 06
            java.lang.String r4 = r4.getName()     // Catch:{ AssertionError -> 0x00cd, all -> 0x013e }               //CRYPTOGRAPHIC API CALLSITE 07
            java.lang.StringBuilder r2 = r2.append(r4)     // Catch:{ AssertionError -> 0x00cd, all -> 0x013e }
            java.lang.String r4 = "\n    subjectAltNames: "
            java.lang.StringBuilder r2 = r2.append(r4)     // Catch:{ AssertionError -> 0x00cd, all -> 0x013e }
            java.util.List r1 = okhttp3.internal.tls.OkHostnameVerifier.allSubjectAltNames(r1)     // Catch:{ AssertionError -> 0x00cd, all -> 0x013e }
            java.lang.StringBuilder r1 = r2.append(r1)     // Catch:{ AssertionError -> 0x00cd, all -> 0x013e }
            java.lang.String r1 = r1.toString()     // Catch:{ AssertionError -> 0x00cd, all -> 0x013e }
            r3.<init>(r1)     // Catch:{ AssertionError -> 0x00cd, all -> 0x013e }
            throw r3     // Catch:{ AssertionError -> 0x00cd, all -> 0x013e }
        L_0x00cd:
            r1 = move-exception
            r8 = r1
            r1 = r0
            r0 = r8
        L_0x00d1:
            boolean r2 = okhttp3.internal.Util.isAndroidGetsocknameError(r0)     // Catch:{ all -> 0x00dd }
            if (r2 == 0) goto L_0x013d
            java.io.IOException r2 = new java.io.IOException     // Catch:{ all -> 0x00dd }
            r2.<init>(r0)     // Catch:{ all -> 0x00dd }
            throw r2     // Catch:{ all -> 0x00dd }
        L_0x00dd:
            r0 = move-exception
        L_0x00de:
            if (r1 == 0) goto L_0x00e7
            okhttp3.internal.Platform r2 = okhttp3.internal.Platform.get()
            r2.afterHandshake(r1)
        L_0x00e7:
            okhttp3.internal.Util.closeQuietly((java.net.Socket) r1)
            throw r0
        L_0x00eb:
            okhttp3.CertificatePinner r5 = r2.certificatePinner()     // Catch:{ AssertionError -> 0x00cd, all -> 0x013e }
            okhttp3.HttpUrl r2 = r2.url()     // Catch:{ AssertionError -> 0x00cd, all -> 0x013e }
            java.lang.String r2 = r2.host()     // Catch:{ AssertionError -> 0x00cd, all -> 0x013e }
            java.util.List r6 = r4.peerCertificates()     // Catch:{ AssertionError -> 0x00cd, all -> 0x013e }
            r5.check((java.lang.String) r2, (java.util.List<java.security.cert.Certificate>) r6)     // Catch:{ AssertionError -> 0x00cd, all -> 0x013e }
            boolean r2 = r3.supportsTlsExtensions()     // Catch:{ AssertionError -> 0x00cd, all -> 0x013e }
            if (r2 == 0) goto L_0x010c
            okhttp3.internal.Platform r1 = okhttp3.internal.Platform.get()     // Catch:{ AssertionError -> 0x00cd, all -> 0x013e }
            java.lang.String r1 = r1.getSelectedProtocol(r0)     // Catch:{ AssertionError -> 0x00cd, all -> 0x013e }
        L_0x010c:
            r9.socket = r0     // Catch:{ AssertionError -> 0x00cd, all -> 0x013e }
            java.net.Socket r2 = r9.socket     // Catch:{ AssertionError -> 0x00cd, all -> 0x013e }
            okio.Source r2 = okio.Okio.source((java.net.Socket) r2)     // Catch:{ AssertionError -> 0x00cd, all -> 0x013e }
            okio.BufferedSource r2 = okio.Okio.buffer((okio.Source) r2)     // Catch:{ AssertionError -> 0x00cd, all -> 0x013e }
            r9.source = r2     // Catch:{ AssertionError -> 0x00cd, all -> 0x013e }
            java.net.Socket r2 = r9.socket     // Catch:{ AssertionError -> 0x00cd, all -> 0x013e }
            okio.Sink r2 = okio.Okio.sink((java.net.Socket) r2)     // Catch:{ AssertionError -> 0x00cd, all -> 0x013e }
            okio.BufferedSink r2 = okio.Okio.buffer((okio.Sink) r2)     // Catch:{ AssertionError -> 0x00cd, all -> 0x013e }
            r9.sink = r2     // Catch:{ AssertionError -> 0x00cd, all -> 0x013e }
            r9.f6260c = r4     // Catch:{ AssertionError -> 0x00cd, all -> 0x013e }
            if (r1 == 0) goto L_0x013a
            okhttp3.Protocol r1 = okhttp3.Protocol.get(r1)     // Catch:{ AssertionError -> 0x00cd, all -> 0x013e }
        L_0x012e:
            r9.f6261d = r1     // Catch:{ AssertionError -> 0x00cd, all -> 0x013e }
            if (r0 == 0) goto L_0x0139
            okhttp3.internal.Platform r1 = okhttp3.internal.Platform.get()
            r1.afterHandshake(r0)
        L_0x0139:
            return
        L_0x013a:
            okhttp3.Protocol r1 = okhttp3.Protocol.HTTP_1_1     // Catch:{ AssertionError -> 0x00cd, all -> 0x013e }
            goto L_0x012e
        L_0x013d:
            throw r0     // Catch:{ all -> 0x00dd }
        L_0x013e:
            r1 = move-exception
            r8 = r1
            r1 = r0
            r0 = r8
            goto L_0x00de
        L_0x0143:
            r0 = move-exception
            goto L_0x00d1
        */
        throw new UnsupportedOperationException("Method not decompiled: okhttp3.internal.p008io.RealConnection.m6874a(int, int, okhttp3.internal.ConnectionSpecSelector):void");
    }

    /* renamed from: a */
    private void m6872a(int i, int i2) throws IOException {
        Request a = m6871a();
        HttpUrl url = a.url();
        String str = "CONNECT " + url.host() + ":" + url.port() + " HTTP/1.1";
        do {
            Http1xStream http1xStream = new Http1xStream((StreamAllocation) null, this.source, this.sink);
            this.source.timeout().timeout((long) i, TimeUnit.MILLISECONDS);
            this.sink.timeout().timeout((long) i2, TimeUnit.MILLISECONDS);
            http1xStream.writeRequest(a.headers(), str);
            http1xStream.finishRequest();
            Response build = http1xStream.readResponse().request(a).build();
            long contentLength = OkHeaders.contentLength(build);
            if (contentLength == -1) {
                contentLength = 0;
            }
            Source newFixedLengthSource = http1xStream.newFixedLengthSource(contentLength);
            Util.skipAll(newFixedLengthSource, Integer.MAX_VALUE, TimeUnit.MILLISECONDS);
            newFixedLengthSource.close();
            switch (build.code()) {
                case IPhotoView.DEFAULT_ZOOM_DURATION /*200*/:
                    if (!this.source.buffer().exhausted() || !this.sink.buffer().exhausted()) {
                        throw new IOException("TLS tunnel buffered too many bytes!");
                    }
                    return;
                case 407:
                    a = this.f6258a.address().proxyAuthenticator().authenticate(this.f6258a, build);
                    break;
                default:
                    throw new IOException("Unexpected response code for CONNECT: " + build.code());
            }
        } while (a != null);
        throw new IOException("Failed to authenticate with proxy");
    }

    /* renamed from: a */
    private Request m6871a() throws IOException {
        return new Request.Builder().url(this.f6258a.address().url()).header("Host", Util.hostHeader(this.f6258a.address().url())).header("Proxy-Connection", "Keep-Alive").header("User-Agent", Version.userAgent()).build();
    }

    public Route route() {
        return this.f6258a;
    }

    public void cancel() {
        Util.closeQuietly(this.f6259b);
    }

    public Socket socket() {
        return this.socket;
    }

    public int allocationLimit() {
        FramedConnection framedConnection2 = this.framedConnection;
        if (framedConnection2 != null) {
            return framedConnection2.maxConcurrentStreams();
        }
        return 1;
    }

    public boolean isHealthy(boolean z) {
        int soTimeout;
        if (this.socket.isClosed() || this.socket.isInputShutdown() || this.socket.isOutputShutdown()) {
            return false;
        }
        if (this.framedConnection != null || !z) {
            return true;
        }
        try {
            soTimeout = this.socket.getSoTimeout();
            this.socket.setSoTimeout(1);
            if (this.source.exhausted()) {
                this.socket.setSoTimeout(soTimeout);
                return false;
            }
            this.socket.setSoTimeout(soTimeout);
            return true;
        } catch (SocketTimeoutException e) {
            return true;
        } catch (IOException e2) {
            return false;
        } catch (Throwable th) {
            this.socket.setSoTimeout(soTimeout);
            throw th;
        }
    }

    public Handshake handshake() {
        return this.f6260c;
    }

    public boolean isMultiplexed() {
        return this.framedConnection != null;
    }

    public Protocol protocol() {
        return this.f6261d != null ? this.f6261d : Protocol.HTTP_1_1;
    }

    public String toString() {
        return "Connection{" + this.f6258a.address().url().host() + ":" + this.f6258a.address().url().port() + ", proxy=" + this.f6258a.proxy() + " hostAddress=" + this.f6258a.socketAddress() + " cipherSuite=" + (this.f6260c != null ? this.f6260c.cipherSuite() : "none") + " protocol=" + this.f6261d + '}';
    }
}
