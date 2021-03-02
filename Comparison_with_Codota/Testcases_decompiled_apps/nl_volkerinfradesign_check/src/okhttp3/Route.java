package okhttp3;

import java.net.InetSocketAddress;
import java.net.Proxy;

public final class Route {

    /* renamed from: a */
    final Address f5948a;

    /* renamed from: b */
    final Proxy f5949b;

    /* renamed from: c */
    final InetSocketAddress f5950c;

    public Route(Address address, Proxy proxy, InetSocketAddress inetSocketAddress) {
        if (address == null) {
            throw new NullPointerException("address == null");
        } else if (proxy == null) {
            throw new NullPointerException("proxy == null");
        } else if (inetSocketAddress == null) {
            throw new NullPointerException("inetSocketAddress == null");
        } else {
            this.f5948a = address;
            this.f5949b = proxy;
            this.f5950c = inetSocketAddress;
        }
    }

    public Address address() {
        return this.f5948a;
    }

    public Proxy proxy() {
        return this.f5949b;
    }

    public InetSocketAddress socketAddress() {
        return this.f5950c;
    }

    public boolean requiresTunnel() {
        return this.f5948a.f5689i != null && this.f5949b.type() == Proxy.Type.HTTP;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof Route)) {
            return false;
        }
        Route route = (Route) obj;
        if (!this.f5948a.equals(route.f5948a) || !this.f5949b.equals(route.f5949b) || !this.f5950c.equals(route.f5950c)) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        return ((((this.f5948a.hashCode() + 527) * 31) + this.f5949b.hashCode()) * 31) + this.f5950c.hashCode();
    }
}
