package org.p004a.p005a.p007b.p012e;

import java.net.URI;
import java.util.List;
import org.p004a.p005a.C0297c;
import org.p004a.p005a.p014d.p020f.C0332a;

/* renamed from: org.a.a.b.e.d */
public final class C0284d {

    /* renamed from: a */
    private String f108a;

    /* renamed from: b */
    private String f109b;

    /* renamed from: c */
    private String f110c;

    /* renamed from: d */
    private String f111d;

    /* renamed from: e */
    private String f112e;

    /* renamed from: f */
    private String f113f;

    /* renamed from: g */
    private int f114g;

    /* renamed from: h */
    private String f115h;

    /* renamed from: i */
    private String f116i;

    /* renamed from: j */
    private String f117j;

    /* renamed from: k */
    private List f118k;

    /* renamed from: l */
    private String f119l;

    /* renamed from: m */
    private String f120m;

    public C0284d() {
        this.f114g = -1;
    }

    public C0284d(URI uri) {
        this.f108a = uri.getScheme();
        this.f109b = uri.getRawSchemeSpecificPart();
        this.f110c = uri.getRawAuthority();
        this.f113f = uri.getHost();
        this.f114g = uri.getPort();
        this.f112e = uri.getRawUserInfo();
        this.f111d = uri.getUserInfo();
        this.f116i = uri.getRawPath();
        this.f115h = uri.getPath();
        this.f117j = uri.getRawQuery();
        String rawQuery = uri.getRawQuery();
        this.f118k = (rawQuery == null || rawQuery.length() <= 0) ? null : C0285e.m191a(rawQuery, C0297c.f129a);
        this.f120m = uri.getRawFragment();
        this.f119l = uri.getFragment();
    }

    /* renamed from: e */
    private String m175e() {
        StringBuilder sb = new StringBuilder();
        if (this.f108a != null) {
            sb.append(this.f108a).append(':');
        }
        if (this.f109b != null) {
            sb.append(this.f109b);
        } else {
            if (this.f110c != null) {
                sb.append("//").append(this.f110c);
            } else if (this.f113f != null) {
                sb.append("//");
                if (this.f112e != null) {
                    sb.append(this.f112e).append("@");
                } else if (this.f111d != null) {
                    sb.append(C0285e.m192b(this.f111d, C0297c.f129a)).append("@");
                }
                if (C0332a.m318b(this.f113f)) {
                    sb.append("[").append(this.f113f).append("]");
                } else {
                    sb.append(this.f113f);
                }
                if (this.f114g >= 0) {
                    sb.append(":").append(this.f114g);
                }
            }
            if (this.f116i != null) {
                sb.append(m176f(this.f116i));
            } else if (this.f115h != null) {
                sb.append(C0285e.m194d(m176f(this.f115h), C0297c.f129a));
            }
            if (this.f117j != null) {
                sb.append("?").append(this.f117j);
            } else if (this.f118k != null) {
                sb.append("?").append(C0285e.m187a((Iterable) this.f118k, C0297c.f129a));
            }
        }
        if (this.f120m != null) {
            sb.append("#").append(this.f120m);
        } else if (this.f119l != null) {
            sb.append("#").append(C0285e.m193c(this.f119l, C0297c.f129a));
        }
        return sb.toString();
    }

    /* renamed from: f */
    private static String m176f(String str) {
        if (str == null) {
            return null;
        }
        int i = 0;
        while (i < str.length() && str.charAt(i) == '/') {
            i++;
        }
        return i > 1 ? str.substring(i - 1) : str;
    }

    /* renamed from: a */
    public final URI mo4921a() {
        return new URI(m175e());
    }

    /* renamed from: a */
    public final C0284d mo4922a(int i) {
        if (i < 0) {
            i = -1;
        }
        this.f114g = i;
        this.f109b = null;
        this.f110c = null;
        return this;
    }

    /* renamed from: a */
    public final C0284d mo4923a(String str) {
        this.f108a = str;
        return this;
    }

    /* renamed from: b */
    public final String mo4924b() {
        return this.f111d;
    }

    /* renamed from: b */
    public final C0284d mo4925b(String str) {
        this.f111d = null;
        this.f109b = null;
        this.f110c = null;
        this.f112e = null;
        return this;
    }

    /* renamed from: c */
    public final String mo4926c() {
        return this.f113f;
    }

    /* renamed from: c */
    public final C0284d mo4927c(String str) {
        this.f113f = str;
        this.f109b = null;
        this.f110c = null;
        return this;
    }

    /* renamed from: d */
    public final String mo4928d() {
        return this.f115h;
    }

    /* renamed from: d */
    public final C0284d mo4929d(String str) {
        this.f115h = str;
        this.f109b = null;
        this.f116i = null;
        return this;
    }

    /* renamed from: e */
    public final C0284d mo4930e(String str) {
        this.f119l = null;
        this.f120m = null;
        return this;
    }

    public final String toString() {
        return m175e();
    }
}
