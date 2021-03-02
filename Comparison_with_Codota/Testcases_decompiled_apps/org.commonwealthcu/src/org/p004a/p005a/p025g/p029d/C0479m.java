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
import org.p004a.p005a.p033i.C0524c;
import org.p004a.p005a.p033i.C0525d;
import org.p004a.p005a.p033i.C0536o;
import org.p004a.p005a.p033i.C0541t;
import org.p004a.p005a.p037m.C0563b;

/* renamed from: org.a.a.g.d.m */
public final class C0479m extends C0485s {

    /* renamed from: a */
    private static final String[] f481a = {"EEE, dd MMM yyyy HH:mm:ss zzz", "EEE, dd-MMM-yy HH:mm:ss zzz", "EEE MMM d HH:mm:ss yyyy", "EEE, dd-MMM-yyyy HH:mm:ss z", "EEE, dd-MMM-yyyy HH-mm-ss z", "EEE, dd MMM yy HH:mm:ss z", "EEE dd-MMM-yyyy HH:mm:ss z", "EEE dd MMM yyyy HH:mm:ss z", "EEE dd-MMM-yyyy HH-mm-ss z", "EEE dd-MMM-yy HH:mm:ss z", "EEE dd MMM yy HH:mm:ss z", "EEE,dd-MMM-yy HH:mm:ss z", "EEE,dd-MMM-yyyy HH:mm:ss z", "EEE, dd-MM-yyyy HH:mm:ss z"};

    /* renamed from: b */
    private final String[] f482b;

    public C0479m() {
        this((String[]) null, C0483q.f486a);
    }

    public C0479m(String[] strArr) {
        this(strArr, C0483q.f486a);
    }

    public C0479m(String[] strArr, int i) {
        if (strArr != null) {
            this.f482b = (String[]) strArr.clone();
        } else {
            this.f482b = f481a;
        }
        switch (C0481o.f483a[i - 1]) {
            case 1:
                mo5262a("path", new C0475i());
                break;
            case 2:
                mo5262a("path", new C0480n(this));
                break;
            default:
                throw new RuntimeException("Unknown security level");
        }
        mo5262a("domain", new C0472f());
        mo5262a("max-age", new C0474h());
        mo5262a("secure", new C0476j());
        mo5262a("comment", new C0471e());
        mo5262a("expires", new C0473g(this.f482b));
        mo5262a("version", new C0484r());
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
        for (int i = 0; i < list.size(); i++) {
            C0346b bVar2 = (C0346b) list.get(i);
            if (i > 0) {
                bVar.mo5428a("; ");
            }
            String a = bVar2.mo5045a();
            String b = bVar2.mo5047b();
            if (bVar2.mo5052g() <= 0 || (b.startsWith("\"") && b.endsWith("\""))) {
                bVar.mo5428a(a);
                bVar.mo5428a("=");
                if (b != null) {
                    bVar.mo5428a(b);
                }
            } else {
                C0525d.f570a.mo5338a(bVar, (C0360f) new C0524c(a, b), false);
            }
        }
        ArrayList arrayList = new ArrayList(1);
        arrayList.add(new C0536o(bVar));
        return arrayList;
    }

    /* renamed from: a */
    public final List mo5065a(C0344e eVar, C0349e eVar2) {
        C0360f[] fVarArr;
        C0563b bVar;
        C0541t tVar;
        C0250b.m84a((Object) eVar, "Header");
        C0250b.m84a((Object) eVar2, "Cookie origin");
        if (!eVar.mo5040c().equalsIgnoreCase("Set-Cookie")) {
            throw new C0357m("Unrecognized cookie header '" + eVar.toString() + "'");
        }
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
        if (z || !z2) {
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
            fVarArr = new C0360f[]{wVar.mo5269a(bVar, tVar)};
        } else {
            fVarArr = e;
        }
        return mo5260a(fVarArr, eVar2);
    }

    /* renamed from: b */
    public final C0344e mo5067b() {
        return null;
    }

    public final String toString() {
        return "compatibility";
    }
}
