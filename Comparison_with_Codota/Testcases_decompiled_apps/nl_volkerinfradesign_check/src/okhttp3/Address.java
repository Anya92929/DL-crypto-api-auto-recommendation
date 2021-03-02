package okhttp3;

import java.net.Proxy;
import java.net.ProxySelector;
import java.util.List;
import javax.net.SocketFactory;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.SSLSocketFactory;
import okhttp3.HttpUrl;
import okhttp3.internal.Util;

public final class Address {

    /* renamed from: a */
    final HttpUrl f5681a;

    /* renamed from: b */
    final Dns f5682b;

    /* renamed from: c */
    final SocketFactory f5683c;

    /* renamed from: d */
    final Authenticator f5684d;

    /* renamed from: e */
    final List<Protocol> f5685e;

    /* renamed from: f */
    final List<ConnectionSpec> f5686f;

    /* renamed from: g */
    final ProxySelector f5687g;

    /* renamed from: h */
    final Proxy f5688h;

    /* renamed from: i */
    final SSLSocketFactory f5689i;

    /* renamed from: j */
    final HostnameVerifier f5690j;

    /* renamed from: k */
    final CertificatePinner f5691k;

    public Address(String str, int i, Dns dns, SocketFactory socketFactory, SSLSocketFactory sSLSocketFactory, HostnameVerifier hostnameVerifier, CertificatePinner certificatePinner, Authenticator authenticator, Proxy proxy, List<Protocol> list, List<ConnectionSpec> list2, ProxySelector proxySelector) {
        this.f5681a = new HttpUrl.Builder().scheme(sSLSocketFactory != null ? "https" : "http").host(str).port(i).build();
        if (dns == null) {
            throw new IllegalArgumentException("dns == null");
        }
        this.f5682b = dns;
        if (socketFactory == null) {
            throw new IllegalArgumentException("socketFactory == null");
        }
        this.f5683c = socketFactory;
        if (authenticator == null) {
            throw new IllegalArgumentException("proxyAuthenticator == null");
        }
        this.f5684d = authenticator;
        if (list == null) {
            throw new IllegalArgumentException("protocols == null");
        }
        this.f5685e = Util.immutableList(list);
        if (list2 == null) {
            throw new IllegalArgumentException("connectionSpecs == null");
        }
        this.f5686f = Util.immutableList(list2);
        if (proxySelector == null) {
            throw new IllegalArgumentException("proxySelector == null");
        }
        this.f5687g = proxySelector;
        this.f5688h = proxy;
        this.f5689i = sSLSocketFactory;
        this.f5690j = hostnameVerifier;
        this.f5691k = certificatePinner;
    }

    public HttpUrl url() {
        return this.f5681a;
    }

    public Dns dns() {
        return this.f5682b;
    }

    public SocketFactory socketFactory() {
        return this.f5683c;
    }

    public Authenticator proxyAuthenticator() {
        return this.f5684d;
    }

    public List<Protocol> protocols() {
        return this.f5685e;
    }

    public List<ConnectionSpec> connectionSpecs() {
        return this.f5686f;
    }

    public ProxySelector proxySelector() {
        return this.f5687g;
    }

    public Proxy proxy() {
        return this.f5688h;
    }

    public SSLSocketFactory sslSocketFactory() {
        return this.f5689i;
    }

    public HostnameVerifier hostnameVerifier() {
        return this.f5690j;
    }

    public CertificatePinner certificatePinner() {
        return this.f5691k;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof Address)) {
            return false;
        }
        Address address = (Address) obj;
        if (!this.f5681a.equals(address.f5681a) || !this.f5682b.equals(address.f5682b) || !this.f5684d.equals(address.f5684d) || !this.f5685e.equals(address.f5685e) || !this.f5686f.equals(address.f5686f) || !this.f5687g.equals(address.f5687g) || !Util.equal(this.f5688h, address.f5688h) || !Util.equal(this.f5689i, address.f5689i) || !Util.equal(this.f5690j, address.f5690j) || !Util.equal(this.f5691k, address.f5691k)) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        int i;
        int i2;
        int i3;
        int i4 = 0;
        int hashCode = (((((((((((this.f5681a.hashCode() + 527) * 31) + this.f5682b.hashCode()) * 31) + this.f5684d.hashCode()) * 31) + this.f5685e.hashCode()) * 31) + this.f5686f.hashCode()) * 31) + this.f5687g.hashCode()) * 31;
        if (this.f5688h != null) {
            i = this.f5688h.hashCode();
        } else {
            i = 0;
        }
        int i5 = (i + hashCode) * 31;
        if (this.f5689i != null) {
            i2 = this.f5689i.hashCode();
        } else {
            i2 = 0;
        }
        int i6 = (i2 + i5) * 31;
        if (this.f5690j != null) {
            i3 = this.f5690j.hashCode();
        } else {
            i3 = 0;
        }
        int i7 = (i3 + i6) * 31;
        if (this.f5691k != null) {
            i4 = this.f5691k.hashCode();
        }
        return i7 + i4;
    }
}
