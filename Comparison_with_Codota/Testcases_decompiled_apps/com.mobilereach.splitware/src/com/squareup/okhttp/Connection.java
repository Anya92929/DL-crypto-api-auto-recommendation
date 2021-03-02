package com.squareup.okhttp;

import com.squareup.okhttp.Request;
import com.squareup.okhttp.internal.Platform;
import com.squareup.okhttp.internal.Util;
import com.squareup.okhttp.internal.http.HttpConnection;
import com.squareup.okhttp.internal.http.HttpEngine;
import com.squareup.okhttp.internal.http.HttpTransport;
import com.squareup.okhttp.internal.http.OkHeaders;
import com.squareup.okhttp.internal.http.SpdyTransport;
import com.squareup.okhttp.internal.http.Transport;
import com.squareup.okhttp.internal.spdy.SpdyConnection;
import com.squareup.okhttp.internal.tls.OkHostnameVerifier;
import java.io.IOException;
import java.net.Proxy;
import java.net.Socket;
import java.net.URL;
import java.security.cert.X509Certificate;
import java.util.concurrent.TimeUnit;
import javax.net.ssl.SSLPeerUnverifiedException;
import javax.net.ssl.SSLSocket;
import okio.Source;

public final class Connection {
    private boolean connected = false;
    private Handshake handshake;
    private HttpConnection httpConnection;
    private long idleStartTimeNs;
    private Object owner;
    private final ConnectionPool pool;
    private Protocol protocol = Protocol.HTTP_1_1;
    private int recycleCount;
    private final Route route;
    private Socket socket;
    private SpdyConnection spdyConnection;

    public Connection(ConnectionPool pool2, Route route2) {
        this.pool = pool2;
        this.route = route2;
    }

    /* access modifiers changed from: package-private */
    public Object getOwner() {
        Object obj;
        synchronized (this.pool) {
            obj = this.owner;
        }
        return obj;
    }

    /* access modifiers changed from: package-private */
    public void setOwner(Object owner2) {
        if (!isSpdy()) {
            synchronized (this.pool) {
                if (this.owner != null) {
                    throw new IllegalStateException("Connection already has an owner!");
                }
                this.owner = owner2;
            }
        }
    }

    /* access modifiers changed from: package-private */
    public boolean clearOwner() {
        boolean z;
        synchronized (this.pool) {
            if (this.owner == null) {
                z = false;
            } else {
                this.owner = null;
                z = true;
            }
        }
        return z;
    }

    /* access modifiers changed from: package-private */
    public void closeIfOwnedBy(Object owner2) throws IOException {
        if (isSpdy()) {
            throw new IllegalStateException();
        }
        synchronized (this.pool) {
            if (this.owner == owner2) {
                this.owner = null;
                this.socket.close();
            }
        }
    }

    /* access modifiers changed from: package-private */
    public void connect(int connectTimeout, int readTimeout, int writeTimeout, Request tunnelRequest) throws IOException {
        if (this.connected) {
            throw new IllegalStateException("already connected");
        }
        if (this.route.proxy.type() == Proxy.Type.DIRECT || this.route.proxy.type() == Proxy.Type.HTTP) {
            this.socket = this.route.address.socketFactory.createSocket();
        } else {
            this.socket = new Socket(this.route.proxy);
        }
        this.socket.setSoTimeout(readTimeout);
        Platform.get().connectSocket(this.socket, this.route.inetSocketAddress, connectTimeout);
        if (this.route.address.sslSocketFactory != null) {
            upgradeToTls(tunnelRequest, readTimeout, writeTimeout);
        } else {
            this.httpConnection = new HttpConnection(this.pool, this, this.socket);
        }
        this.connected = true;
    }

    /* access modifiers changed from: package-private */
    public void connectAndSetOwner(OkHttpClient client, Object owner2, Request request) throws IOException {
        setOwner(owner2);
        if (!isConnected()) {
            connect(client.getConnectTimeout(), client.getReadTimeout(), client.getWriteTimeout(), tunnelRequest(request));
            if (isSpdy()) {
                client.getConnectionPool().share(this);
            }
            client.routeDatabase().connected(getRoute());
        }
        setTimeouts(client.getReadTimeout(), client.getWriteTimeout());
    }

    private Request tunnelRequest(Request request) throws IOException {
        if (!this.route.requiresTunnel()) {
            return null;
        }
        String host = request.url().getHost();
        int port = Util.getEffectivePort(request.url());
        Request.Builder result = new Request.Builder().url(new URL("https", host, port, "/")).header("Host", port == Util.getDefaultPort("https") ? host : host + ":" + port).header("Proxy-Connection", "Keep-Alive");
        String userAgent = request.header("User-Agent");
        if (userAgent != null) {
            result.header("User-Agent", userAgent);
        }
        String proxyAuthorization = request.header("Proxy-Authorization");
        if (proxyAuthorization != null) {
            result.header("Proxy-Authorization", proxyAuthorization);
        }
        return result.build();
    }

    /* JADX INFO: finally extract failed */
    private void upgradeToTls(Request tunnelRequest, int readTimeout, int writeTimeout) throws IOException {
        String maybeProtocol;
        Platform platform = Platform.get();
        if (tunnelRequest != null) {
            makeTunnel(tunnelRequest, readTimeout, writeTimeout);
        }
        this.socket = this.route.address.sslSocketFactory.createSocket(this.socket, this.route.address.uriHost, this.route.address.uriPort, true);
        SSLSocket sslSocket = (SSLSocket) this.socket;
        this.route.connectionSpec.apply(sslSocket, this.route);
        try {
            sslSocket.startHandshake();
            if (this.route.connectionSpec.supportsTlsExtensions() && (maybeProtocol = platform.getSelectedProtocol(sslSocket)) != null) {
                this.protocol = Protocol.get(maybeProtocol);
            }
            platform.afterHandshake(sslSocket);
            this.handshake = Handshake.get(sslSocket.getSession());
            if (!this.route.address.hostnameVerifier.verify(this.route.address.uriHost, sslSocket.getSession())) {
                X509Certificate cert = (X509Certificate) sslSocket.getSession().getPeerCertificates()[0];
                throw new SSLPeerUnverifiedException("Hostname " + this.route.address.uriHost + " not verified:" + "\n    certificate: " + CertificatePinner.pin(cert) + "\n    DN: " + cert.getSubjectDN().getName() + "\n    subjectAltNames: " + OkHostnameVerifier.allSubjectAltNames(cert)); // CRYPTOGRAPHIC API CALLSITE 6, CRYPTOGRAPHIC API CALLSITE 18
            }
            this.route.address.certificatePinner.check(this.route.address.uriHost, this.handshake.peerCertificates());
            if (this.protocol == Protocol.SPDY_3 || this.protocol == Protocol.HTTP_2) {
                sslSocket.setSoTimeout(0);
                this.spdyConnection = new SpdyConnection.Builder(this.route.address.getUriHost(), true, this.socket).protocol(this.protocol).build();
                this.spdyConnection.sendConnectionPreface();
                return;
            }
            this.httpConnection = new HttpConnection(this.pool, this, this.socket);
        } catch (Throwable th) {
            platform.afterHandshake(sslSocket);
            throw th;
        }
    }

    /* access modifiers changed from: package-private */
    public boolean isConnected() {
        return this.connected;
    }

    public Route getRoute() {
        return this.route;
    }

    public Socket getSocket() {
        return this.socket;
    }

    /* access modifiers changed from: package-private */
    public boolean isAlive() {
        return !this.socket.isClosed() && !this.socket.isInputShutdown() && !this.socket.isOutputShutdown();
    }

    /* access modifiers changed from: package-private */
    public boolean isReadable() {
        if (this.httpConnection != null) {
            return this.httpConnection.isReadable();
        }
        return true;
    }

    /* access modifiers changed from: package-private */
    public void resetIdleStartTime() {
        if (this.spdyConnection != null) {
            throw new IllegalStateException("spdyConnection != null");
        }
        this.idleStartTimeNs = System.nanoTime();
    }

    /* access modifiers changed from: package-private */
    public boolean isIdle() {
        return this.spdyConnection == null || this.spdyConnection.isIdle();
    }

    /* access modifiers changed from: package-private */
    public long getIdleStartTimeNs() {
        return this.spdyConnection == null ? this.idleStartTimeNs : this.spdyConnection.getIdleStartTimeNs();
    }

    public Handshake getHandshake() {
        return this.handshake;
    }

    /* access modifiers changed from: package-private */
    public Transport newTransport(HttpEngine httpEngine) throws IOException {
        return this.spdyConnection != null ? new SpdyTransport(httpEngine, this.spdyConnection) : new HttpTransport(httpEngine, this.httpConnection);
    }

    /* access modifiers changed from: package-private */
    public boolean isSpdy() {
        return this.spdyConnection != null;
    }

    public Protocol getProtocol() {
        return this.protocol;
    }

    /* access modifiers changed from: package-private */
    public void setProtocol(Protocol protocol2) {
        if (protocol2 == null) {
            throw new IllegalArgumentException("protocol == null");
        }
        this.protocol = protocol2;
    }

    /* access modifiers changed from: package-private */
    public void setTimeouts(int readTimeoutMillis, int writeTimeoutMillis) throws IOException {
        if (!this.connected) {
            throw new IllegalStateException("setTimeouts - not connected");
        } else if (this.httpConnection != null) {
            this.socket.setSoTimeout(readTimeoutMillis);
            this.httpConnection.setTimeouts(readTimeoutMillis, writeTimeoutMillis);
        }
    }

    /* access modifiers changed from: package-private */
    public void incrementRecycleCount() {
        this.recycleCount++;
    }

    /* access modifiers changed from: package-private */
    public int recycleCount() {
        return this.recycleCount;
    }

    private void makeTunnel(Request request, int readTimeout, int writeTimeout) throws IOException {
        HttpConnection tunnelConnection = new HttpConnection(this.pool, this, this.socket);
        tunnelConnection.setTimeouts(readTimeout, writeTimeout);
        URL url = request.url();
        String requestLine = "CONNECT " + url.getHost() + ":" + url.getPort() + " HTTP/1.1";
        do {
            tunnelConnection.writeRequest(request.headers(), requestLine);
            tunnelConnection.flush();
            Response response = tunnelConnection.readResponse().request(request).build();
            long contentLength = OkHeaders.contentLength(response);
            if (contentLength == -1) {
                contentLength = 0;
            }
            Source body = tunnelConnection.newFixedLengthSource(contentLength);
            Util.skipAll(body, Integer.MAX_VALUE, TimeUnit.MILLISECONDS);
            body.close();
            switch (response.code()) {
                case 200:
                    if (tunnelConnection.bufferSize() > 0) {
                        throw new IOException("TLS tunnel buffered too many bytes!");
                    }
                    return;
                case 407:
                    request = OkHeaders.processAuthHeader(this.route.address.authenticator, response, this.route.proxy);
                    break;
                default:
                    throw new IOException("Unexpected response code for CONNECT: " + response.code());
            }
        } while (request != null);
        throw new IOException("Failed to authenticate with proxy");
    }

    public String toString() {
        return "Connection{" + this.route.address.uriHost + ":" + this.route.address.uriPort + ", proxy=" + this.route.proxy + " hostAddress=" + this.route.inetSocketAddress.getAddress().getHostAddress() + " cipherSuite=" + (this.handshake != null ? this.handshake.cipherSuite() : "none") + " protocol=" + this.protocol + '}';
    }
}
