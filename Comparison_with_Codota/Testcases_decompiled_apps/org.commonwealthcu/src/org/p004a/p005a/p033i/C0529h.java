package org.p004a.p005a.p033i;

import org.p004a.p005a.C0241ac;
import org.p004a.p005a.C0243ae;
import org.p004a.p005a.C0244af;
import org.p004a.p005a.C0301d;
import org.p004a.p005a.C0344e;
import org.p004a.p005a.p007b.p008a.C0250b;
import org.p004a.p005a.p037m.C0563b;

/* renamed from: org.a.a.i.h */
public final class C0529h implements C0539r {

    /* renamed from: a */
    public static final C0529h f581a = new C0529h();

    static {
        new C0529h();
    }

    /* renamed from: a */
    private static int m1055a(C0241ac acVar) {
        return acVar.mo4854a().length() + 4;
    }

    /* renamed from: a */
    private static C0563b m1056a(C0563b bVar) {
        if (bVar == null) {
            return new C0563b(64);
        }
        bVar.mo5426a();
        return bVar;
    }

    /* renamed from: a */
    private C0563b m1057a(C0563b bVar, C0241ac acVar) {
        C0250b.m84a((Object) acVar, "Protocol version");
        int a = m1055a(acVar);
        if (bVar == null) {
            bVar = new C0563b(a);
        } else {
            bVar.mo5433b(a);
        }
        bVar.mo5428a(acVar.mo4854a());
        bVar.mo5427a('/');
        bVar.mo5428a(Integer.toString(acVar.mo4857b()));
        bVar.mo5427a('.');
        bVar.mo5428a(Integer.toString(acVar.mo4858c()));
        return bVar;
    }

    /* renamed from: a */
    public final C0563b mo5349a(C0563b bVar, C0243ae aeVar) {
        C0250b.m84a((Object) aeVar, "Request line");
        C0563b a = m1056a(bVar);
        String a2 = aeVar.mo4863a();
        String c = aeVar.mo4865c();
        a.mo5433b(a2.length() + 1 + c.length() + 1 + m1055a(aeVar.mo4864b()));
        a.mo5428a(a2);
        a.mo5427a(' ');
        a.mo5428a(c);
        a.mo5427a(' ');
        m1057a(a, aeVar.mo4864b());
        return a;
    }

    /* renamed from: a */
    public final C0563b mo5350a(C0563b bVar, C0244af afVar) {
        C0250b.m84a((Object) afVar, "Status line");
        C0563b a = m1056a((C0563b) null);
        int a2 = m1055a(afVar.mo4866a()) + 1 + 3 + 1;
        String c = afVar.mo4868c();
        if (c != null) {
            a2 += c.length();
        }
        a.mo5433b(a2);
        m1057a(a, afVar.mo4866a());
        a.mo5427a(' ');
        a.mo5428a(Integer.toString(afVar.mo4867b()));
        a.mo5427a(' ');
        if (c != null) {
            a.mo5428a(c);
        }
        return a;
    }

    /* renamed from: a */
    public final C0563b mo5351a(C0563b bVar, C0344e eVar) {
        C0250b.m84a((Object) eVar, "Header");
        if (eVar instanceof C0301d) {
            return ((C0301d) eVar).mo4949a();
        }
        C0563b a = m1056a(bVar);
        String c = eVar.mo5040c();
        String d = eVar.mo5041d();
        int length = c.length() + 2;
        if (d != null) {
            length += d.length();
        }
        a.mo5433b(length);
        a.mo5428a(c);
        a.mo5428a(": ");
        if (d != null) {
            a.mo5428a(d);
        }
        return a;
    }
}
