package org.p004a.p005a.p025g.p029d;

import org.p004a.p005a.p007b.p008a.C0250b;
import org.p004a.p005a.p021e.C0346b;
import org.p004a.p005a.p021e.C0347c;
import org.p004a.p005a.p021e.C0349e;
import org.p004a.p005a.p021e.C0351g;
import org.p004a.p005a.p021e.C0357m;
import org.p004a.p005a.p021e.C0358n;

/* renamed from: org.a.a.g.d.f */
public class C0472f implements C0347c {
    /* renamed from: a */
    public void mo5053a(C0346b bVar, C0349e eVar) {
        C0250b.m84a((Object) bVar, "Cookie");
        C0250b.m84a((Object) eVar, "Cookie origin");
        String a = eVar.mo5057a();
        String c = bVar.mo5048c();
        if (c == null) {
            throw new C0351g("Cookie domain may not be null");
        } else if (a.contains(".")) {
            if (!a.endsWith(c)) {
                if (c.startsWith(".")) {
                    c = c.substring(1, c.length());
                }
                if (!a.equals(c)) {
                    throw new C0351g("Illegal domain attribute \"" + c + "\". Domain of origin: \"" + a + "\"");
                }
            }
        } else if (!a.equals(c)) {
            throw new C0351g("Illegal domain attribute \"" + c + "\". Domain of origin: \"" + a + "\"");
        }
    }

    /* renamed from: a */
    public final void mo5054a(C0358n nVar, String str) {
        C0250b.m84a((Object) nVar, "Cookie");
        if (str == null) {
            throw new C0357m("Missing value for domain attribute");
        } else if (str.trim().length() == 0) {
            throw new C0357m("Blank value for domain attribute");
        } else {
            nVar.mo5076c(str);
        }
    }

    /* renamed from: b */
    public boolean mo5055b(C0346b bVar, C0349e eVar) {
        C0250b.m84a((Object) bVar, "Cookie");
        C0250b.m84a((Object) eVar, "Cookie origin");
        String a = eVar.mo5057a();
        String c = bVar.mo5048c();
        if (c == null) {
            return false;
        }
        if (a.equals(c)) {
            return true;
        }
        if (!c.startsWith(".")) {
            c = "." + c;
        }
        return a.endsWith(c) || a.equals(c.substring(1));
    }
}
