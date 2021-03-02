package org.p004a.p005a.p007b.p008a;

import java.net.InetAddress;
import java.util.Collection;
import org.p004a.p005a.C0565n;

/* renamed from: org.a.a.b.a.a */
public class C0249a implements Cloneable {

    /* renamed from: a */
    public static final C0249a f50a = new C0250b().mo4882a();

    /* renamed from: b */
    private final boolean f51b;

    /* renamed from: c */
    private final C0565n f52c;

    /* renamed from: d */
    private final InetAddress f53d;

    /* renamed from: e */
    private final boolean f54e;

    /* renamed from: f */
    private final String f55f;

    /* renamed from: g */
    private final boolean f56g;

    /* renamed from: h */
    private final boolean f57h;

    /* renamed from: i */
    private final boolean f58i;

    /* renamed from: j */
    private final int f59j;

    /* renamed from: k */
    private final boolean f60k;

    /* renamed from: l */
    private final Collection f61l;

    /* renamed from: m */
    private final Collection f62m;

    /* renamed from: n */
    private final int f63n;

    /* renamed from: o */
    private final int f64o;

    /* renamed from: p */
    private final int f65p;

    C0249a(boolean z, C0565n nVar, InetAddress inetAddress, boolean z2, String str, boolean z3, boolean z4, boolean z5, int i, boolean z6, Collection collection, Collection collection2, int i2, int i3, int i4) {
        this.f51b = z;
        this.f52c = nVar;
        this.f53d = inetAddress;
        this.f54e = z2;
        this.f55f = str;
        this.f56g = z3;
        this.f57h = z4;
        this.f58i = z5;
        this.f59j = i;
        this.f60k = z6;
        this.f61l = collection;
        this.f62m = collection2;
        this.f63n = i2;
        this.f64o = i3;
        this.f65p = i4;
    }

    /* renamed from: f */
    public static C0250b m71f() {
        return new C0250b();
    }

    /* renamed from: a */
    public final String mo4875a() {
        return this.f55f;
    }

    /* renamed from: b */
    public final boolean mo4876b() {
        return this.f57h;
    }

    /* renamed from: c */
    public final boolean mo4877c() {
        return this.f58i;
    }

    /* access modifiers changed from: protected */
    public /* bridge */ /* synthetic */ Object clone() {
        return (C0249a) super.clone();
    }

    /* renamed from: d */
    public final Collection mo4879d() {
        return this.f61l;
    }

    /* renamed from: e */
    public final Collection mo4880e() {
        return this.f62m;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(", expectContinueEnabled=").append(this.f51b);
        sb.append(", proxy=").append(this.f52c);
        sb.append(", localAddress=").append(this.f53d);
        sb.append(", staleConnectionCheckEnabled=").append(this.f54e);
        sb.append(", cookieSpec=").append(this.f55f);
        sb.append(", redirectsEnabled=").append(this.f56g);
        sb.append(", relativeRedirectsAllowed=").append(this.f57h);
        sb.append(", maxRedirects=").append(this.f59j);
        sb.append(", circularRedirectsAllowed=").append(this.f58i);
        sb.append(", authenticationEnabled=").append(this.f60k);
        sb.append(", targetPreferredAuthSchemes=").append(this.f61l);
        sb.append(", proxyPreferredAuthSchemes=").append(this.f62m);
        sb.append(", connectionRequestTimeout=").append(this.f63n);
        sb.append(", connectTimeout=").append(this.f64o);
        sb.append(", socketTimeout=").append(this.f65p);
        sb.append("]");
        return sb.toString();
    }
}
