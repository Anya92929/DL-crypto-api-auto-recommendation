package org.p004a.p005a.p025g.p029d;

import org.p004a.p005a.p007b.p008a.C0250b;
import org.p004a.p005a.p021e.C0346b;
import org.p004a.p005a.p021e.C0347c;
import org.p004a.p005a.p021e.C0349e;
import org.p004a.p005a.p021e.C0351g;
import org.p004a.p005a.p021e.C0358n;

/* renamed from: org.a.a.g.d.i */
public class C0475i implements C0347c {
    /* renamed from: a */
    public void mo5053a(C0346b bVar, C0349e eVar) {
        if (!mo5055b(bVar, eVar)) {
            throw new C0351g("Illegal path attribute \"" + bVar.mo5049d() + "\". Path of origin: \"" + eVar.mo5058b() + "\"");
        }
    }

    /* renamed from: a */
    public final void mo5054a(C0358n nVar, String str) {
        C0250b.m84a((Object) nVar, "Cookie");
        if (C0250b.m105b((CharSequence) str)) {
            str = "/";
        }
        nVar.mo5077d(str);
    }

    /* renamed from: b */
    public final boolean mo5055b(C0346b bVar, C0349e eVar) {
        C0250b.m84a((Object) bVar, "Cookie");
        C0250b.m84a((Object) eVar, "Cookie origin");
        String b = eVar.mo5058b();
        String d = bVar.mo5049d();
        if (d == null) {
            d = "/";
        }
        if (d.length() > 1 && d.endsWith("/")) {
            d = d.substring(0, d.length() - 1);
        }
        boolean startsWith = b.startsWith(d);
        return (!startsWith || b.length() == d.length() || d.endsWith("/")) ? startsWith : b.charAt(d.length()) == '/';
    }
}
