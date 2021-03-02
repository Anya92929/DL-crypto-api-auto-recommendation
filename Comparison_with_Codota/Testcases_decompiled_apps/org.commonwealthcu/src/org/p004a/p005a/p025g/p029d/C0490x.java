package org.p004a.p005a.p025g.p029d;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import org.p004a.p005a.C0301d;
import org.p004a.p005a.C0344e;
import org.p004a.p005a.C0360f;
import org.p004a.p005a.p007b.p008a.C0250b;
import org.p004a.p005a.p021e.C0346b;
import org.p004a.p005a.p021e.C0349e;
import org.p004a.p005a.p021e.C0357m;
import org.p004a.p005a.p033i.C0536o;
import org.p004a.p005a.p033i.C0541t;
import org.p004a.p005a.p037m.C0563b;

/* renamed from: org.a.a.g.d.x */
public final class C0490x extends C0485s {

    /* renamed from: a */
    private final String[] f490a;

    public C0490x() {
        this((String[]) null);
    }

    public C0490x(String[] strArr) {
        if (strArr != null) {
            this.f490a = (String[]) strArr.clone();
        } else {
            this.f490a = new String[]{"EEE, dd-MMM-yy HH:mm:ss z"};
        }
        mo5262a("path", new C0475i());
        mo5262a("domain", new C0488v());
        mo5262a("max-age", new C0474h());
        mo5262a("secure", new C0476j());
        mo5262a("comment", new C0471e());
        mo5262a("expires", new C0473g(this.f490a));
    }

    /* renamed from: a */
    public final int mo5063a() {
        return 0;
    }

    /* renamed from: a */
    public final List mo5064a(List list) {
        C0250b.m90a((Collection) list, "List of cookies");
        C0563b bVar = new C0563b(list.size() * 20);
        bVar.mo5428a("Cookie");
        bVar.mo5428a(": ");
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 < list.size()) {
                C0346b bVar2 = (C0346b) list.get(i2);
                if (i2 > 0) {
                    bVar.mo5428a("; ");
                }
                bVar.mo5428a(bVar2.mo5045a());
                String b = bVar2.mo5047b();
                if (b != null) {
                    bVar.mo5428a("=");
                    bVar.mo5428a(b);
                }
                i = i2 + 1;
            } else {
                ArrayList arrayList = new ArrayList(1);
                arrayList.add(new C0536o(bVar));
                return arrayList;
            }
        }
    }

    /* renamed from: a */
    public final List mo5065a(C0344e eVar, C0349e eVar2) {
        C0563b bVar;
        C0541t tVar;
        C0250b.m84a((Object) eVar, "Header");
        C0250b.m84a((Object) eVar2, "Cookie origin");
        if (!eVar.mo5040c().equalsIgnoreCase("Set-Cookie")) {
            throw new C0357m("Unrecognized cookie header '" + eVar.toString() + "'");
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
        return mo5260a(new C0360f[]{wVar.mo5269a(bVar, tVar)}, eVar2);
    }

    /* renamed from: b */
    public final C0344e mo5067b() {
        return null;
    }

    public final String toString() {
        return "netscape";
    }
}
