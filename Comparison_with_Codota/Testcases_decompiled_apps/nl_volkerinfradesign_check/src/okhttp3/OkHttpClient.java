package okhttp3;

import java.net.MalformedURLException;
import java.net.Proxy;
import java.net.ProxySelector;
import java.net.UnknownHostException;
import java.security.GeneralSecurityException;
import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;
import javax.net.SocketFactory;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.KeyManager;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSocket;
import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.TrustManager;
import okhttp3.Call;
import okhttp3.Headers;
import okhttp3.internal.Internal;
import okhttp3.internal.InternalCache;
import okhttp3.internal.RouteDatabase;
import okhttp3.internal.Util;
import okhttp3.internal.http.StreamAllocation;
import okhttp3.internal.p008io.RealConnection;
import okhttp3.internal.tls.OkHostnameVerifier;

public final class OkHttpClient implements Cloneable, Call.Factory {
    /* access modifiers changed from: private */

    /* renamed from: y */
    public static final List<Protocol> f5852y = Util.immutableList((T[]) new Protocol[]{Protocol.HTTP_2, Protocol.SPDY_3, Protocol.HTTP_1_1});
    /* access modifiers changed from: private */

    /* renamed from: z */
    public static final List<ConnectionSpec> f5853z = Util.immutableList((T[]) new ConnectionSpec[]{ConnectionSpec.MODERN_TLS, ConnectionSpec.COMPATIBLE_TLS, ConnectionSpec.CLEARTEXT});

    /* renamed from: a */
    final Dispatcher f5854a;

    /* renamed from: b */
    final Proxy f5855b;

    /* renamed from: c */
    final List<Protocol> f5856c;

    /* renamed from: d */
    final List<ConnectionSpec> f5857d;

    /* renamed from: e */
    final List<Interceptor> f5858e;

    /* renamed from: f */
    final List<Interceptor> f5859f;

    /* renamed from: g */
    final ProxySelector f5860g;

    /* renamed from: h */
    final CookieJar f5861h;

    /* renamed from: i */
    final Cache f5862i;

    /* renamed from: j */
    final InternalCache f5863j;

    /* renamed from: k */
    final SocketFactory f5864k;

    /* renamed from: l */
    final SSLSocketFactory f5865l;

    /* renamed from: m */
    final HostnameVerifier f5866m;

    /* renamed from: n */
    final CertificatePinner f5867n;

    /* renamed from: o */
    final Authenticator f5868o;

    /* renamed from: p */
    final Authenticator f5869p;

    /* renamed from: q */
    final ConnectionPool f5870q;

    /* renamed from: r */
    final Dns f5871r;

    /* renamed from: s */
    final boolean f5872s;

    /* renamed from: t */
    final boolean f5873t;

    /* renamed from: u */
    final boolean f5874u;

    /* renamed from: v */
    final int f5875v;

    /* renamed from: w */
    final int f5876w;

    /* renamed from: x */
    final int f5877x;

    static {
        Internal.instance = new Internal() {
            public void addLenient(Headers.Builder builder, String str) {
                builder.mo10690a(str);
            }

            public void addLenient(Headers.Builder builder, String str, String str2) {
                builder.mo10691a(str, str2);
            }

            public void setCache(Builder builder, InternalCache internalCache) {
                builder.mo10813a(internalCache);
            }

            public InternalCache internalCache(OkHttpClient okHttpClient) {
                return okHttpClient.mo10776a();
            }

            public boolean connectionBecameIdle(ConnectionPool connectionPool, RealConnection realConnection) {
                return connectionPool.mo10602b(realConnection);
            }

            public RealConnection get(ConnectionPool connectionPool, Address address, StreamAllocation streamAllocation) {
                return connectionPool.mo10600a(address, streamAllocation);
            }

            public void put(ConnectionPool connectionPool, RealConnection realConnection) {
                connectionPool.mo10601a(realConnection);
            }

            public RouteDatabase routeDatabase(ConnectionPool connectionPool) {
                return connectionPool.f5753a;
            }

            public void callEnqueue(Call call, Callback callback, boolean z) {
                ((C1295iv) call).mo8688a(callback, z);
            }

            public StreamAllocation callEngineGetStreamAllocation(Call call) {
                return ((C1295iv) call).f4515c.streamAllocation;
            }

            public void apply(ConnectionSpec connectionSpec, SSLSocket sSLSocket, boolean z) {
                connectionSpec.mo10607a(sSLSocket, z);
            }

            public HttpUrl getHttpUrlChecked(String str) throws MalformedURLException, UnknownHostException {
                return HttpUrl.m6565b(str);
            }
        };
    }

    public OkHttpClient() {
        this(new Builder());
    }

    private OkHttpClient(Builder builder) {
        this.f5854a = builder.f5878a;
        this.f5855b = builder.f5879b;
        this.f5856c = builder.f5880c;
        this.f5857d = builder.f5881d;
        this.f5858e = Util.immutableList(builder.f5882e);
        this.f5859f = Util.immutableList(builder.f5883f);
        this.f5860g = builder.f5884g;
        this.f5861h = builder.f5885h;
        this.f5862i = builder.f5886i;
        this.f5863j = builder.f5887j;
        this.f5864k = builder.f5888k;
        if (builder.f5889l != null) {
            this.f5865l = builder.f5889l;
        } else {
            try {
                SSLContext instance = SSLContext.getInstance("TLS");
                instance.init((KeyManager[]) null, (TrustManager[]) null, (SecureRandom) null);
                this.f5865l = instance.getSocketFactory();
            } catch (GeneralSecurityException e) {
                throw new AssertionError();
            }
        }
        this.f5866m = builder.f5890m;
        this.f5867n = builder.f5891n;
        this.f5868o = builder.f5892o;
        this.f5869p = builder.f5893p;
        this.f5870q = builder.f5894q;
        this.f5871r = builder.f5895r;
        this.f5872s = builder.f5896s;
        this.f5873t = builder.f5897t;
        this.f5874u = builder.f5898u;
        this.f5875v = builder.f5899v;
        this.f5876w = builder.f5900w;
        this.f5877x = builder.f5901x;
    }

    public int connectTimeoutMillis() {
        return this.f5875v;
    }

    public int readTimeoutMillis() {
        return this.f5876w;
    }

    public int writeTimeoutMillis() {
        return this.f5877x;
    }

    public Proxy proxy() {
        return this.f5855b;
    }

    public ProxySelector proxySelector() {
        return this.f5860g;
    }

    public CookieJar cookieJar() {
        return this.f5861h;
    }

    public Cache cache() {
        return this.f5862i;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public InternalCache mo10776a() {
        return this.f5862i != null ? this.f5862i.f5692a : this.f5863j;
    }

    public Dns dns() {
        return this.f5871r;
    }

    public SocketFactory socketFactory() {
        return this.f5864k;
    }

    public SSLSocketFactory sslSocketFactory() {
        return this.f5865l;
    }

    public HostnameVerifier hostnameVerifier() {
        return this.f5866m;
    }

    public CertificatePinner certificatePinner() {
        return this.f5867n;
    }

    public Authenticator authenticator() {
        return this.f5869p;
    }

    public Authenticator proxyAuthenticator() {
        return this.f5868o;
    }

    public ConnectionPool connectionPool() {
        return this.f5870q;
    }

    public boolean followSslRedirects() {
        return this.f5872s;
    }

    public boolean followRedirects() {
        return this.f5873t;
    }

    public boolean retryOnConnectionFailure() {
        return this.f5874u;
    }

    public Dispatcher dispatcher() {
        return this.f5854a;
    }

    public List<Protocol> protocols() {
        return this.f5856c;
    }

    public List<ConnectionSpec> connectionSpecs() {
        return this.f5857d;
    }

    public List<Interceptor> interceptors() {
        return this.f5858e;
    }

    public List<Interceptor> networkInterceptors() {
        return this.f5859f;
    }

    public Call newCall(Request request) {
        return new C1295iv(this, request);
    }

    public Builder newBuilder() {
        return new Builder(this);
    }

    public static final class Builder {

        /* renamed from: a */
        Dispatcher f5878a;

        /* renamed from: b */
        Proxy f5879b;

        /* renamed from: c */
        List<Protocol> f5880c;

        /* renamed from: d */
        List<ConnectionSpec> f5881d;

        /* renamed from: e */
        final List<Interceptor> f5882e;

        /* renamed from: f */
        final List<Interceptor> f5883f;

        /* renamed from: g */
        ProxySelector f5884g;

        /* renamed from: h */
        CookieJar f5885h;

        /* renamed from: i */
        Cache f5886i;

        /* renamed from: j */
        InternalCache f5887j;

        /* renamed from: k */
        SocketFactory f5888k;

        /* renamed from: l */
        SSLSocketFactory f5889l;

        /* renamed from: m */
        HostnameVerifier f5890m;

        /* renamed from: n */
        CertificatePinner f5891n;

        /* renamed from: o */
        Authenticator f5892o;

        /* renamed from: p */
        Authenticator f5893p;

        /* renamed from: q */
        ConnectionPool f5894q;

        /* renamed from: r */
        Dns f5895r;

        /* renamed from: s */
        boolean f5896s;

        /* renamed from: t */
        boolean f5897t;

        /* renamed from: u */
        boolean f5898u;

        /* renamed from: v */
        int f5899v;

        /* renamed from: w */
        int f5900w;

        /* renamed from: x */
        int f5901x;

        public Builder() {
            this.f5882e = new ArrayList();
            this.f5883f = new ArrayList();
            this.f5878a = new Dispatcher();
            this.f5880c = OkHttpClient.f5852y;
            this.f5881d = OkHttpClient.f5853z;
            this.f5884g = ProxySelector.getDefault();
            this.f5885h = CookieJar.NO_COOKIES;
            this.f5888k = SocketFactory.getDefault();
            this.f5890m = OkHostnameVerifier.INSTANCE;
            this.f5891n = CertificatePinner.DEFAULT;
            this.f5892o = Authenticator.NONE;
            this.f5893p = Authenticator.NONE;
            this.f5894q = new ConnectionPool();
            this.f5895r = Dns.SYSTEM;
            this.f5896s = true;
            this.f5897t = true;
            this.f5898u = true;
            this.f5899v = 10000;
            this.f5900w = 10000;
            this.f5901x = 10000;
        }

        Builder(OkHttpClient okHttpClient) {
            this.f5882e = new ArrayList();
            this.f5883f = new ArrayList();
            this.f5878a = okHttpClient.f5854a;
            this.f5879b = okHttpClient.f5855b;
            this.f5880c = okHttpClient.f5856c;
            this.f5881d = okHttpClient.f5857d;
            this.f5882e.addAll(okHttpClient.f5858e);
            this.f5883f.addAll(okHttpClient.f5859f);
            this.f5884g = okHttpClient.f5860g;
            this.f5885h = okHttpClient.f5861h;
            this.f5887j = okHttpClient.f5863j;
            this.f5886i = okHttpClient.f5862i;
            this.f5888k = okHttpClient.f5864k;
            this.f5889l = okHttpClient.f5865l;
            this.f5890m = okHttpClient.f5866m;
            this.f5891n = okHttpClient.f5867n;
            this.f5892o = okHttpClient.f5868o;
            this.f5893p = okHttpClient.f5869p;
            this.f5894q = okHttpClient.f5870q;
            this.f5895r = okHttpClient.f5871r;
            this.f5896s = okHttpClient.f5872s;
            this.f5897t = okHttpClient.f5873t;
            this.f5898u = okHttpClient.f5874u;
            this.f5899v = okHttpClient.f5875v;
            this.f5900w = okHttpClient.f5876w;
            this.f5901x = okHttpClient.f5877x;
        }

        public Builder connectTimeout(long j, TimeUnit timeUnit) {
            if (j < 0) {
                throw new IllegalArgumentException("timeout < 0");
            } else if (timeUnit == null) {
                throw new IllegalArgumentException("unit == null");
            } else {
                long millis = timeUnit.toMillis(j);
                if (millis > 2147483647L) {
                    throw new IllegalArgumentException("Timeout too large.");
                } else if (millis != 0 || j <= 0) {
                    this.f5899v = (int) millis;
                    return this;
                } else {
                    throw new IllegalArgumentException("Timeout too small.");
                }
            }
        }

        public Builder readTimeout(long j, TimeUnit timeUnit) {
            if (j < 0) {
                throw new IllegalArgumentException("timeout < 0");
            } else if (timeUnit == null) {
                throw new IllegalArgumentException("unit == null");
            } else {
                long millis = timeUnit.toMillis(j);
                if (millis > 2147483647L) {
                    throw new IllegalArgumentException("Timeout too large.");
                } else if (millis != 0 || j <= 0) {
                    this.f5900w = (int) millis;
                    return this;
                } else {
                    throw new IllegalArgumentException("Timeout too small.");
                }
            }
        }

        public Builder writeTimeout(long j, TimeUnit timeUnit) {
            if (j < 0) {
                throw new IllegalArgumentException("timeout < 0");
            } else if (timeUnit == null) {
                throw new IllegalArgumentException("unit == null");
            } else {
                long millis = timeUnit.toMillis(j);
                if (millis > 2147483647L) {
                    throw new IllegalArgumentException("Timeout too large.");
                } else if (millis != 0 || j <= 0) {
                    this.f5901x = (int) millis;
                    return this;
                } else {
                    throw new IllegalArgumentException("Timeout too small.");
                }
            }
        }

        public Builder proxy(Proxy proxy) {
            this.f5879b = proxy;
            return this;
        }

        public Builder proxySelector(ProxySelector proxySelector) {
            this.f5884g = proxySelector;
            return this;
        }

        public Builder cookieJar(CookieJar cookieJar) {
            if (cookieJar == null) {
                throw new NullPointerException("cookieJar == null");
            }
            this.f5885h = cookieJar;
            return this;
        }

        /* access modifiers changed from: package-private */
        /* renamed from: a */
        public void mo10813a(InternalCache internalCache) {
            this.f5887j = internalCache;
            this.f5886i = null;
        }

        public Builder cache(Cache cache) {
            this.f5886i = cache;
            this.f5887j = null;
            return this;
        }

        public Builder dns(Dns dns) {
            if (dns == null) {
                throw new NullPointerException("dns == null");
            }
            this.f5895r = dns;
            return this;
        }

        public Builder socketFactory(SocketFactory socketFactory) {
            if (socketFactory == null) {
                throw new NullPointerException("socketFactory == null");
            }
            this.f5888k = socketFactory;
            return this;
        }

        public Builder sslSocketFactory(SSLSocketFactory sSLSocketFactory) {
            if (sSLSocketFactory == null) {
                throw new NullPointerException("sslSocketFactory == null");
            }
            this.f5889l = sSLSocketFactory;
            return this;
        }

        public Builder hostnameVerifier(HostnameVerifier hostnameVerifier) {
            if (hostnameVerifier == null) {
                throw new NullPointerException("hostnameVerifier == null");
            }
            this.f5890m = hostnameVerifier;
            return this;
        }

        public Builder certificatePinner(CertificatePinner certificatePinner) {
            if (certificatePinner == null) {
                throw new NullPointerException("certificatePinner == null");
            }
            this.f5891n = certificatePinner;
            return this;
        }

        public Builder authenticator(Authenticator authenticator) {
            if (authenticator == null) {
                throw new NullPointerException("authenticator == null");
            }
            this.f5893p = authenticator;
            return this;
        }

        public Builder proxyAuthenticator(Authenticator authenticator) {
            if (authenticator == null) {
                throw new NullPointerException("proxyAuthenticator == null");
            }
            this.f5892o = authenticator;
            return this;
        }

        public Builder connectionPool(ConnectionPool connectionPool) {
            if (connectionPool == null) {
                throw new NullPointerException("connectionPool == null");
            }
            this.f5894q = connectionPool;
            return this;
        }

        public Builder followSslRedirects(boolean z) {
            this.f5896s = z;
            return this;
        }

        public Builder followRedirects(boolean z) {
            this.f5897t = z;
            return this;
        }

        public Builder retryOnConnectionFailure(boolean z) {
            this.f5898u = z;
            return this;
        }

        public Builder dispatcher(Dispatcher dispatcher) {
            if (dispatcher == null) {
                throw new IllegalArgumentException("dispatcher == null");
            }
            this.f5878a = dispatcher;
            return this;
        }

        public Builder protocols(List<Protocol> list) {
            List<T> immutableList = Util.immutableList(list);
            if (!immutableList.contains(Protocol.HTTP_1_1)) {
                throw new IllegalArgumentException("protocols doesn't contain http/1.1: " + immutableList);
            } else if (immutableList.contains(Protocol.HTTP_1_0)) {
                throw new IllegalArgumentException("protocols must not contain http/1.0: " + immutableList);
            } else if (immutableList.contains((Object) null)) {
                throw new IllegalArgumentException("protocols must not contain null");
            } else {
                this.f5880c = Util.immutableList(immutableList);
                return this;
            }
        }

        public Builder connectionSpecs(List<ConnectionSpec> list) {
            this.f5881d = Util.immutableList(list);
            return this;
        }

        public List<Interceptor> interceptors() {
            return this.f5882e;
        }

        public Builder addInterceptor(Interceptor interceptor) {
            this.f5882e.add(interceptor);
            return this;
        }

        public List<Interceptor> networkInterceptors() {
            return this.f5883f;
        }

        public Builder addNetworkInterceptor(Interceptor interceptor) {
            this.f5883f.add(interceptor);
            return this;
        }

        public OkHttpClient build() {
            return new OkHttpClient(this);
        }
    }
}
