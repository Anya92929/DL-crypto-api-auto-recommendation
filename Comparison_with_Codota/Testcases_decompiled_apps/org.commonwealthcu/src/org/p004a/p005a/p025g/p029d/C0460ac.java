package org.p004a.p005a.p025g.p029d;

import org.p004a.p005a.p007b.p008a.C0250b;
import org.p004a.p005a.p021e.C0346b;
import org.p004a.p005a.p021e.C0349e;
import org.p004a.p005a.p021e.C0351g;
import org.p004a.p005a.p021e.C0357m;
import org.p004a.p005a.p021e.C0358n;

/* renamed from: org.a.a.g.d.ac */
public final class C0460ac extends C0457a {
    /* renamed from: a */
    public final void mo5053a(C0346b bVar, C0349e eVar) {
        C0250b.m84a((Object) bVar, "Cookie");
        if (bVar.mo5052g() < 0) {
            throw new C0351g("Cookie version may not be negative");
        }
    }

    /* renamed from: a */
    public final void mo5054a(C0358n nVar, String str) {
        C0250b.m84a((Object) nVar, "Cookie");
        if (str == null) {
            throw new C0357m("Missing value for version attribute");
        } else if (str.trim().length() == 0) {
            throw new C0357m("Blank value for version attribute");
        } else {
            try {
                nVar.mo5073a(Integer.parseInt(str));
            } catch (NumberFormatException e) {
                throw new C0357m("Invalid version: " + e.getMessage());
            }
        }
    }
}
