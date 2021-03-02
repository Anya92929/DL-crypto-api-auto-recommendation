package okhttp3.internal.http;

import java.io.IOException;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.Proxy;
import java.net.SocketAddress;
import java.net.SocketException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.NoSuchElementException;
import okhttp3.Address;
import okhttp3.HttpUrl;
import okhttp3.Route;
import okhttp3.internal.RouteDatabase;

public final class RouteSelector {

    /* renamed from: a */
    private final Address f6242a;

    /* renamed from: b */
    private final RouteDatabase f6243b;

    /* renamed from: c */
    private Proxy f6244c;

    /* renamed from: d */
    private InetSocketAddress f6245d;

    /* renamed from: e */
    private List<Proxy> f6246e = Collections.emptyList();

    /* renamed from: f */
    private int f6247f;

    /* renamed from: g */
    private List<InetSocketAddress> f6248g = Collections.emptyList();

    /* renamed from: h */
    private int f6249h;

    /* renamed from: i */
    private final List<Route> f6250i = new ArrayList();

    public RouteSelector(Address address, RouteDatabase routeDatabase) {
        this.f6242a = address;
        this.f6243b = routeDatabase;
        m6858a(address.url(), address.proxy());
    }

    public boolean hasNext() {
        return m6861c() || m6859a() || m6863e();
    }

    public Route next() throws IOException {
        if (!m6861c()) {
            if (m6859a()) {
                this.f6244c = m6860b();
            } else if (m6863e()) {
                return m6864f();
            } else {
                throw new NoSuchElementException();
            }
        }
        this.f6245d = m6862d();
        Route route = new Route(this.f6242a, this.f6244c, this.f6245d);
        if (!this.f6243b.shouldPostpone(route)) {
            return route;
        }
        this.f6250i.add(route);
        return next();
    }

    public void connectFailed(Route route, IOException iOException) {
        if (!(route.proxy().type() == Proxy.Type.DIRECT || this.f6242a.proxySelector() == null)) {
            this.f6242a.proxySelector().connectFailed(this.f6242a.url().uri(), route.proxy().address(), iOException);
        }
        this.f6243b.failed(route);
    }

    /* renamed from: a */
    private void m6858a(HttpUrl httpUrl, Proxy proxy) {
        if (proxy != null) {
            this.f6246e = Collections.singletonList(proxy);
        } else {
            this.f6246e = new ArrayList();
            List<Proxy> select = this.f6242a.proxySelector().select(httpUrl.uri());
            if (select != null) {
                this.f6246e.addAll(select);
            }
            this.f6246e.removeAll(Collections.singleton(Proxy.NO_PROXY));
            this.f6246e.add(Proxy.NO_PROXY);
        }
        this.f6247f = 0;
    }

    /* renamed from: a */
    private boolean m6859a() {
        return this.f6247f < this.f6246e.size();
    }

    /* renamed from: b */
    private Proxy m6860b() throws IOException {
        if (!m6859a()) {
            throw new SocketException("No route to " + this.f6242a.url().host() + "; exhausted proxy configurations: " + this.f6246e);
        }
        List<Proxy> list = this.f6246e;
        int i = this.f6247f;
        this.f6247f = i + 1;
        Proxy proxy = list.get(i);
        m6857a(proxy);
        return proxy;
    }

    /* renamed from: a */
    private void m6857a(Proxy proxy) throws IOException {
        int i;
        String str;
        this.f6248g = new ArrayList();
        if (proxy.type() == Proxy.Type.DIRECT || proxy.type() == Proxy.Type.SOCKS) {
            String host = this.f6242a.url().host();
            i = this.f6242a.url().port();
            str = host;
        } else {
            SocketAddress address = proxy.address();
            if (!(address instanceof InetSocketAddress)) {
                throw new IllegalArgumentException("Proxy.address() is not an InetSocketAddress: " + address.getClass());
            }
            InetSocketAddress inetSocketAddress = (InetSocketAddress) address;
            String a = m6856a(inetSocketAddress);
            i = inetSocketAddress.getPort();
            str = a;
        }
        if (i < 1 || i > 65535) {
            throw new SocketException("No route to " + str + ":" + i + "; port is out of range");
        }
        if (proxy.type() == Proxy.Type.SOCKS) {
            this.f6248g.add(InetSocketAddress.createUnresolved(str, i));
        } else {
            List<InetAddress> lookup = this.f6242a.dns().lookup(str);
            int size = lookup.size();
            for (int i2 = 0; i2 < size; i2++) {
                this.f6248g.add(new InetSocketAddress(lookup.get(i2), i));
            }
        }
        this.f6249h = 0;
    }

    /* renamed from: a */
    static String m6856a(InetSocketAddress inetSocketAddress) {
        InetAddress address = inetSocketAddress.getAddress();
        if (address == null) {
            return inetSocketAddress.getHostName();
        }
        return address.getHostAddress();
    }

    /* renamed from: c */
    private boolean m6861c() {
        return this.f6249h < this.f6248g.size();
    }

    /* renamed from: d */
    private InetSocketAddress m6862d() throws IOException {
        if (!m6861c()) {
            throw new SocketException("No route to " + this.f6242a.url().host() + "; exhausted inet socket addresses: " + this.f6248g);
        }
        List<InetSocketAddress> list = this.f6248g;
        int i = this.f6249h;
        this.f6249h = i + 1;
        return list.get(i);
    }

    /* renamed from: e */
    private boolean m6863e() {
        return !this.f6250i.isEmpty();
    }

    /* renamed from: f */
    private Route m6864f() {
        return this.f6250i.remove(0);
    }
}
