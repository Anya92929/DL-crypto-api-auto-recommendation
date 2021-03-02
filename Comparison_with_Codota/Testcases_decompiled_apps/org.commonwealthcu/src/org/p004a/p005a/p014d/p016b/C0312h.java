package org.p004a.p005a.p014d.p016b;

import java.net.InetAddress;
import org.p004a.p005a.C0565n;
import org.p004a.p005a.p007b.p008a.C0250b;
import org.p004a.p005a.p007b.p010c.C0266m;

/* renamed from: org.a.a.d.b.h */
public final class C0312h implements Cloneable, C0309e {

    /* renamed from: a */
    private final C0565n f150a;

    /* renamed from: b */
    private final InetAddress f151b;

    /* renamed from: c */
    private boolean f152c;

    /* renamed from: d */
    private C0565n[] f153d;

    /* renamed from: e */
    private C0311g f154e;

    /* renamed from: f */
    private C0310f f155f;

    /* renamed from: g */
    private boolean f156g;

    public C0312h(C0306b bVar) {
        this(bVar.mo4964a(), bVar.mo4966b());
    }

    private C0312h(C0565n nVar, InetAddress inetAddress) {
        C0250b.m84a((Object) nVar, "Target host");
        this.f150a = nVar;
        this.f151b = inetAddress;
        this.f154e = C0311g.PLAIN;
        this.f155f = C0310f.PLAIN;
    }

    /* renamed from: a */
    public final C0565n mo4964a() {
        return this.f150a;
    }

    /* renamed from: a */
    public final C0565n mo4965a(int i) {
        C0250b.m78a(i, "Hop index");
        int c = mo4967c();
        C0250b.m95a(i < c, "Hop index exceeds tracked route length");
        return i < c + -1 ? this.f153d[i] : this.f150a;
    }

    /* renamed from: a */
    public final void mo4977a(C0565n nVar, boolean z) {
        C0250b.m84a((Object) nVar, "Proxy host");
        C0266m.m146a(!this.f152c, "Already connected");
        this.f152c = true;
        this.f153d = new C0565n[]{nVar};
        this.f156g = z;
    }

    /* renamed from: a */
    public final void mo4978a(boolean z) {
        C0266m.m146a(!this.f152c, "Already connected");
        this.f152c = true;
        this.f156g = z;
    }

    /* renamed from: b */
    public final InetAddress mo4966b() {
        return this.f151b;
    }

    /* renamed from: b */
    public final void mo4979b(boolean z) {
        C0266m.m146a(this.f152c, "No tunnel unless connected");
        C0266m.m145a((Object) this.f153d, "No tunnel without proxy");
        this.f154e = C0311g.TUNNELLED;
        this.f156g = z;
    }

    /* renamed from: c */
    public final int mo4967c() {
        if (!this.f152c) {
            return 0;
        }
        if (this.f153d == null) {
            return 1;
        }
        return this.f153d.length + 1;
    }

    /* renamed from: c */
    public final void mo4980c(boolean z) {
        C0266m.m146a(this.f152c, "No layered protocol unless connected");
        this.f155f = C0310f.LAYERED;
        this.f156g = z;
    }

    public final Object clone() {
        return super.clone();
    }

    /* renamed from: d */
    public final C0565n mo4969d() {
        if (this.f153d == null) {
            return null;
        }
        return this.f153d[0];
    }

    /* renamed from: e */
    public final boolean mo4970e() {
        return this.f154e == C0311g.TUNNELLED;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof C0312h)) {
            return false;
        }
        C0312h hVar = (C0312h) obj;
        return this.f152c == hVar.f152c && this.f156g == hVar.f156g && this.f154e == hVar.f154e && this.f155f == hVar.f155f && C0250b.m97a((Object) this.f150a, (Object) hVar.f150a) && C0250b.m97a((Object) this.f151b, (Object) hVar.f151b) && C0250b.m98a((Object[]) this.f153d, (Object[]) hVar.f153d);
    }

    /* renamed from: f */
    public final boolean mo4972f() {
        return this.f155f == C0310f.LAYERED;
    }

    /* renamed from: g */
    public final boolean mo4973g() {
        return this.f156g;
    }

    /* renamed from: h */
    public final void mo4983h() {
        this.f152c = false;
        this.f153d = null;
        this.f154e = C0311g.PLAIN;
        this.f155f = C0310f.PLAIN;
        this.f156g = false;
    }

    public final int hashCode() {
        int a = C0250b.m77a(C0250b.m77a(17, (Object) this.f150a), (Object) this.f151b);
        if (this.f153d != null) {
            C0565n[] nVarArr = this.f153d;
            int length = nVarArr.length;
            int i = 0;
            while (i < length) {
                int a2 = C0250b.m77a(a, (Object) nVarArr[i]);
                i++;
                a = a2;
            }
        }
        return C0250b.m77a(C0250b.m77a(C0250b.m79a(C0250b.m79a(a, this.f152c), this.f156g), (Object) this.f154e), (Object) this.f155f);
    }

    /* renamed from: i */
    public final boolean mo4985i() {
        return this.f152c;
    }

    /* renamed from: j */
    public final C0306b mo4986j() {
        if (!this.f152c) {
            return null;
        }
        return new C0306b(this.f150a, this.f151b, this.f153d, this.f156g, this.f154e, this.f155f);
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder((mo4967c() * 30) + 50);
        sb.append("RouteTracker[");
        if (this.f151b != null) {
            sb.append(this.f151b);
            sb.append("->");
        }
        sb.append('{');
        if (this.f152c) {
            sb.append('c');
        }
        if (this.f154e == C0311g.TUNNELLED) {
            sb.append('t');
        }
        if (this.f155f == C0310f.LAYERED) {
            sb.append('l');
        }
        if (this.f156g) {
            sb.append('s');
        }
        sb.append("}->");
        if (this.f153d != null) {
            for (C0565n append : this.f153d) {
                sb.append(append);
                sb.append("->");
            }
        }
        sb.append(this.f150a);
        sb.append(']');
        return sb.toString();
    }
}
