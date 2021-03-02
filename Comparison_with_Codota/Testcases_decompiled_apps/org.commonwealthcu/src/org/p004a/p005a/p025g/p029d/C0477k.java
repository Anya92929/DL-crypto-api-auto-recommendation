package org.p004a.p005a.p025g.p029d;

import java.util.Iterator;
import java.util.List;
import org.p004a.p005a.C0301d;
import org.p004a.p005a.C0344e;
import org.p004a.p005a.C0360f;
import org.p004a.p005a.p007b.p008a.C0250b;
import org.p004a.p005a.p021e.C0346b;
import org.p004a.p005a.p021e.C0349e;
import org.p004a.p005a.p021e.C0352h;
import org.p004a.p005a.p021e.C0357m;
import org.p004a.p005a.p021e.C0359o;
import org.p004a.p005a.p033i.C0541t;
import org.p004a.p005a.p037m.C0563b;

/* renamed from: org.a.a.g.d.k */
public final class C0477k implements C0352h {

    /* renamed from: a */
    private final String[] f474a;

    /* renamed from: b */
    private final boolean f475b;

    /* renamed from: c */
    private C0465ah f476c;

    /* renamed from: d */
    private C0458aa f477d;

    /* renamed from: e */
    private C0479m f478e;

    public C0477k() {
        this((String[]) null, false);
    }

    public C0477k(String[] strArr, boolean z) {
        this.f474a = strArr == null ? null : (String[]) strArr.clone();
        this.f475b = z;
    }

    /* renamed from: c */
    private C0465ah m896c() {
        if (this.f476c == null) {
            this.f476c = new C0465ah(this.f474a, this.f475b);
        }
        return this.f476c;
    }

    /* renamed from: d */
    private C0458aa m897d() {
        if (this.f477d == null) {
            this.f477d = new C0458aa(this.f474a, this.f475b);
        }
        return this.f477d;
    }

    /* renamed from: e */
    private C0479m m898e() {
        if (this.f478e == null) {
            this.f478e = new C0479m(this.f474a);
        }
        return this.f478e;
    }

    /* renamed from: a */
    public final int mo5063a() {
        return m896c().mo5063a();
    }

    /* renamed from: a */
    public final List mo5064a(List list) {
        C0250b.m84a((Object) list, "List of cookies");
        Iterator it = list.iterator();
        int i = Integer.MAX_VALUE;
        boolean z = true;
        while (it.hasNext()) {
            C0346b bVar = (C0346b) it.next();
            if (!(bVar instanceof C0359o)) {
                z = false;
            }
            i = bVar.mo5052g() < i ? bVar.mo5052g() : i;
        }
        return i > 0 ? z ? m896c().mo5064a(list) : m897d().mo5064a(list) : m898e().mo5064a(list);
    }

    /* renamed from: a */
    public final List mo5065a(C0344e eVar, C0349e eVar2) {
        C0563b bVar;
        C0541t tVar;
        C0250b.m84a((Object) eVar, "Header");
        C0250b.m84a((Object) eVar2, "Cookie origin");
        C0360f[] e = eVar.mo5042e();
        boolean z = false;
        boolean z2 = false;
        for (C0360f fVar : e) {
            if (fVar.mo5082a("version") != null) {
                z2 = true;
            }
            if (fVar.mo5082a("expires") != null) {
                z = true;
            }
        }
        if (!z && z2) {
            return "Set-Cookie2".equals(eVar.mo5040c()) ? m896c().mo5260a(e, eVar2) : m897d().mo5260a(e, eVar2);
        }
        C0489w wVar = C0489w.f489a;
        if (eVar instanceof C0301d) {
            bVar = ((C0301d) eVar).mo4949a();
            tVar = new C0541t(((C0301d) eVar).mo4950b(), bVar.mo5435c());
        } else {
            String d = eVar.mo5041d();
            if (d == null) {
                throw new C0357m("Header value is null");
            }
            bVar = new C0563b(d.length());
            bVar.mo5428a(d);
            tVar = new C0541t(0, bVar.mo5435c());
        }
        return m898e().mo5260a(new C0360f[]{wVar.mo5269a(bVar, tVar)}, eVar2);
    }

    /* renamed from: a */
    public final void mo5066a(C0346b bVar, C0349e eVar) {
        C0250b.m84a((Object) bVar, "Cookie");
        C0250b.m84a((Object) eVar, "Cookie origin");
        if (bVar.mo5052g() <= 0) {
            m898e().mo5066a(bVar, eVar);
        } else if (bVar instanceof C0359o) {
            m896c().mo5066a(bVar, eVar);
        } else {
            m897d().mo5066a(bVar, eVar);
        }
    }

    /* renamed from: b */
    public final C0344e mo5067b() {
        return m896c().mo5067b();
    }

    /* renamed from: b */
    public final boolean mo5068b(C0346b bVar, C0349e eVar) {
        C0250b.m84a((Object) bVar, "Cookie");
        C0250b.m84a((Object) eVar, "Cookie origin");
        return bVar.mo5052g() > 0 ? bVar instanceof C0359o ? m896c().mo5068b(bVar, eVar) : m897d().mo5068b(bVar, eVar) : m898e().mo5068b(bVar, eVar);
    }

    public final String toString() {
        return "best-match";
    }
}
