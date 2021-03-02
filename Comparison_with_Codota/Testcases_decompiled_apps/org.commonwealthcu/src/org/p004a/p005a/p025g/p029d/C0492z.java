package org.p004a.p005a.p025g.p029d;

import java.util.Locale;
import org.p004a.p005a.p007b.p008a.C0250b;
import org.p004a.p005a.p021e.C0346b;
import org.p004a.p005a.p021e.C0347c;
import org.p004a.p005a.p021e.C0349e;
import org.p004a.p005a.p021e.C0351g;
import org.p004a.p005a.p021e.C0357m;
import org.p004a.p005a.p021e.C0358n;

/* renamed from: org.a.a.g.d.z */
public final class C0492z implements C0347c {
    /* renamed from: a */
    public final void mo5053a(C0346b bVar, C0349e eVar) {
        C0250b.m84a((Object) bVar, "Cookie");
        C0250b.m84a((Object) eVar, "Cookie origin");
        String a = eVar.mo5057a();
        String c = bVar.mo5048c();
        if (c == null) {
            throw new C0351g("Cookie domain may not be null");
        } else if (c.equals(a)) {
        } else {
            if (c.indexOf(46) == -1) {
                throw new C0351g("Domain attribute \"" + c + "\" does not match the host \"" + a + "\"");
            } else if (!c.startsWith(".")) {
                throw new C0351g("Domain attribute \"" + c + "\" violates RFC 2109: domain must start with a dot");
            } else {
                int indexOf = c.indexOf(46, 1);
                if (indexOf < 0 || indexOf == c.length() - 1) {
                    throw new C0351g("Domain attribute \"" + c + "\" violates RFC 2109: domain must contain an embedded dot");
                }
                String lowerCase = a.toLowerCase(Locale.ENGLISH);
                if (!lowerCase.endsWith(c)) {
                    throw new C0351g("Illegal domain attribute \"" + c + "\". Domain of origin: \"" + lowerCase + "\"");
                } else if (lowerCase.substring(0, lowerCase.length() - c.length()).indexOf(46) != -1) {
                    throw new C0351g("Domain attribute \"" + c + "\" violates RFC 2109: host minus domain may not contain any dots");
                }
            }
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
    public final boolean mo5055b(C0346b bVar, C0349e eVar) {
        C0250b.m84a((Object) bVar, "Cookie");
        C0250b.m84a((Object) eVar, "Cookie origin");
        String a = eVar.mo5057a();
        String c = bVar.mo5048c();
        if (c == null) {
            return false;
        }
        return a.equals(c) || (c.startsWith(".") && a.endsWith(c));
    }
}
