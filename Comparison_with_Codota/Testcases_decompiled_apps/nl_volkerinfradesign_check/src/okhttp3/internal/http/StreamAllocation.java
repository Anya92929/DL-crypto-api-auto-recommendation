package okhttp3.internal.http;

import java.io.IOException;
import java.io.InterruptedIOException;
import java.lang.ref.WeakReference;
import java.net.ProtocolException;
import java.net.SocketTimeoutException;
import java.security.cert.CertificateException;
import java.util.concurrent.TimeUnit;
import javax.net.ssl.SSLHandshakeException;
import javax.net.ssl.SSLPeerUnverifiedException;
import okhttp3.Address;
import okhttp3.ConnectionPool;
import okhttp3.Route;
import okhttp3.internal.Internal;
import okhttp3.internal.RouteDatabase;
import okhttp3.internal.Util;
import okhttp3.internal.p008io.RealConnection;
import okio.Sink;

public final class StreamAllocation {

    /* renamed from: a */
    private Route f6251a;
    public final Address address;

    /* renamed from: b */
    private final ConnectionPool f6252b;

    /* renamed from: c */
    private RouteSelector f6253c;

    /* renamed from: d */
    private RealConnection f6254d;

    /* renamed from: e */
    private boolean f6255e;

    /* renamed from: f */
    private boolean f6256f;

    /* renamed from: g */
    private HttpStream f6257g;

    public StreamAllocation(ConnectionPool connectionPool, Address address2) {
        this.f6252b = connectionPool;
        this.address = address2;
        this.f6253c = new RouteSelector(address2, m6865a());
    }

    public HttpStream newStream(int i, int i2, int i3, boolean z, boolean z2) throws RouteException, IOException {
        HttpStream http1xStream;
        try {
            RealConnection a = m6867a(i, i2, i3, z, z2);
            if (a.framedConnection != null) {
                http1xStream = new Http2xStream(this, a.framedConnection);
            } else {
                a.socket().setSoTimeout(i2);
                a.source.timeout().timeout((long) i2, TimeUnit.MILLISECONDS);
                a.sink.timeout().timeout((long) i3, TimeUnit.MILLISECONDS);
                http1xStream = new Http1xStream(this, a.source, a.sink);
            }
            synchronized (this.f6252b) {
                this.f6257g = http1xStream;
            }
            return http1xStream;
        } catch (IOException e) {
            throw new RouteException(e);
        }
    }

    /* renamed from: a */
    private RealConnection m6867a(int i, int i2, int i3, boolean z, boolean z2) throws IOException, RouteException {
        RealConnection a;
        while (true) {
            a = m6866a(i, i2, i3, z);
            synchronized (this.f6252b) {
                if (a.successCount != 0) {
                    if (a.isHealthy(z2)) {
                        break;
                    }
                    connectionFailed(new IOException());
                } else {
                    break;
                }
            }
        }
        return a;
    }

    /* renamed from: a */
    private RealConnection m6866a(int i, int i2, int i3, boolean z) throws IOException, RouteException {
        RealConnection realConnection;
        Route route;
        synchronized (this.f6252b) {
            if (this.f6255e) {
                throw new IllegalStateException("released");
            } else if (this.f6257g != null) {
                throw new IllegalStateException("stream != null");
            } else if (this.f6256f) {
                throw new IOException("Canceled");
            } else {
                realConnection = this.f6254d;
                if (realConnection == null || realConnection.noNewStreams) {
                    realConnection = Internal.instance.get(this.f6252b, this.address, this);
                    if (realConnection != null) {
                        this.f6254d = realConnection;
                    } else {
                        Route route2 = this.f6251a;
                        if (route2 == null) {
                            Route next = this.f6253c.next();
                            synchronized (this.f6252b) {
                                this.f6251a = next;
                            }
                            route = next;
                        } else {
                            route = route2;
                        }
                        realConnection = new RealConnection(route);
                        acquire(realConnection);
                        synchronized (this.f6252b) {
                            Internal.instance.put(this.f6252b, realConnection);
                            this.f6254d = realConnection;
                            if (this.f6256f) {
                                throw new IOException("Canceled");
                            }
                        }
                        realConnection.connect(i, i2, i3, this.address.connectionSpecs(), z);
                        m6865a().connected(realConnection.route());
                    }
                }
            }
        }
        return realConnection;
    }

    public void streamFinished(boolean z, HttpStream httpStream) {
        synchronized (this.f6252b) {
            if (httpStream != null) {
                if (httpStream == this.f6257g) {
                    if (!z) {
                        this.f6254d.successCount++;
                    }
                }
            }
            throw new IllegalStateException("expected " + this.f6257g + " but was " + httpStream);
        }
        m6869a(z, false, true);
    }

    public HttpStream stream() {
        HttpStream httpStream;
        synchronized (this.f6252b) {
            httpStream = this.f6257g;
        }
        return httpStream;
    }

    /* renamed from: a */
    private RouteDatabase m6865a() {
        return Internal.instance.routeDatabase(this.f6252b);
    }

    public synchronized RealConnection connection() {
        return this.f6254d;
    }

    public void release() {
        m6869a(false, true, false);
    }

    public void noNewStreams() {
        m6869a(true, false, false);
    }

    /* renamed from: a */
    private void m6869a(boolean z, boolean z2, boolean z3) {
        RealConnection realConnection = null;
        synchronized (this.f6252b) {
            if (z3) {
                this.f6257g = null;
            }
            if (z2) {
                this.f6255e = true;
            }
            if (this.f6254d != null) {
                if (z) {
                    this.f6254d.noNewStreams = true;
                }
                if (this.f6257g == null && (this.f6255e || this.f6254d.noNewStreams)) {
                    m6868a(this.f6254d);
                    if (this.f6254d.allocations.isEmpty()) {
                        this.f6254d.idleAtNanos = System.nanoTime();
                        if (Internal.instance.connectionBecameIdle(this.f6252b, this.f6254d)) {
                            realConnection = this.f6254d;
                        }
                    }
                    this.f6254d = null;
                }
            }
        }
        if (realConnection != null) {
            Util.closeQuietly(realConnection.socket());
        }
    }

    public void cancel() {
        HttpStream httpStream;
        RealConnection realConnection;
        synchronized (this.f6252b) {
            this.f6256f = true;
            httpStream = this.f6257g;
            realConnection = this.f6254d;
        }
        if (httpStream != null) {
            httpStream.cancel();
        } else if (realConnection != null) {
            realConnection.cancel();
        }
    }

    public void connectionFailed(IOException iOException) {
        synchronized (this.f6252b) {
            if (this.f6254d != null && this.f6254d.successCount == 0) {
                if (!(this.f6251a == null || iOException == null)) {
                    this.f6253c.connectFailed(this.f6251a, iOException);
                }
                this.f6251a = null;
            }
        }
        m6869a(true, false, true);
    }

    public void acquire(RealConnection realConnection) {
        realConnection.allocations.add(new WeakReference(this));
    }

    /* renamed from: a */
    private void m6868a(RealConnection realConnection) {
        int size = realConnection.allocations.size();
        for (int i = 0; i < size; i++) {
            if (realConnection.allocations.get(i).get() == this) {
                realConnection.allocations.remove(i);
                return;
            }
        }
        throw new IllegalStateException();
    }

    public boolean recover(IOException iOException, Sink sink) {
        if (this.f6254d != null) {
            connectionFailed(iOException);
        }
        boolean z = sink == null || (sink instanceof RetryableSink);
        if ((this.f6253c == null || this.f6253c.hasNext()) && m6870a(iOException) && z) {
            return true;
        }
        return false;
    }

    /* renamed from: a */
    private boolean m6870a(IOException iOException) {
        if (iOException instanceof ProtocolException) {
            return false;
        }
        if (iOException instanceof InterruptedIOException) {
            return iOException instanceof SocketTimeoutException;
        }
        if ((!(iOException instanceof SSLHandshakeException) || !(iOException.getCause() instanceof CertificateException)) && !(iOException instanceof SSLPeerUnverifiedException)) {
            return true;
        }
        return false;
    }

    public String toString() {
        return this.address.toString();
    }
}
