package org.p004a.p005a.p025g.p029d;

import org.p004a.p005a.p007b.p008a.C0250b;
import org.p004a.p005a.p021e.C0345a;
import org.p004a.p005a.p021e.C0346b;
import org.p004a.p005a.p021e.C0347c;
import org.p004a.p005a.p021e.C0349e;
import org.p004a.p005a.p021e.C0351g;
import org.p004a.p005a.p021e.C0357m;
import org.p004a.p005a.p021e.C0358n;
import org.p004a.p005a.p021e.C0359o;

/* renamed from: org.a.a.g.d.aj */
public final class C0467aj implements C0347c {
    /* renamed from: a */
    public final void mo5053a(C0346b bVar, C0349e eVar) {
        C0250b.m84a((Object) bVar, "Cookie");
        if ((bVar instanceof C0359o) && (bVar instanceof C0345a) && !((C0345a) bVar).mo5044b("version")) {
            throw new C0351g("Violates RFC 2965. Version attribute is required.");
        }
    }

    /* renamed from: a */
    public final void mo5054a(C0358n nVar, String str) {
        int i;
        C0250b.m84a((Object) nVar, "Cookie");
        if (str == null) {
            throw new C0357m("Missing value for version attribute");
        }
        try {
            i = Integer.parseInt(str);
        } catch (NumberFormatException e) {
            i = -1;
        }
        if (i < 0) {
            throw new C0357m("Invalid cookie version.");
        }
        nVar.mo5073a(i);
    }

    /* renamed from: b */
    public final boolean mo5055b(C0346b bVar, C0349e eVar) {
        return true;
    }
}
