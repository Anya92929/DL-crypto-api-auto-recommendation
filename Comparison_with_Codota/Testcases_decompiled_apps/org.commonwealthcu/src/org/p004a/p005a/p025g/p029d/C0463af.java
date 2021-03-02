package org.p004a.p005a.p025g.p029d;

import java.util.Locale;
import org.p004a.p005a.p007b.p008a.C0250b;
import org.p004a.p005a.p021e.C0345a;
import org.p004a.p005a.p021e.C0346b;
import org.p004a.p005a.p021e.C0347c;
import org.p004a.p005a.p021e.C0349e;
import org.p004a.p005a.p021e.C0351g;
import org.p004a.p005a.p021e.C0357m;
import org.p004a.p005a.p021e.C0358n;

/* renamed from: org.a.a.g.d.af */
public final class C0463af implements C0347c {
    /* renamed from: a */
    private static boolean m839a(String str, String str2) {
        return str.equals(str2) || (str2.startsWith(".") && str.endsWith(str2));
    }

    /* renamed from: a */
    public final void mo5053a(C0346b bVar, C0349e eVar) {
        C0250b.m84a((Object) bVar, "Cookie");
        C0250b.m84a((Object) eVar, "Cookie origin");
        String lowerCase = eVar.mo5057a().toLowerCase(Locale.ENGLISH);
        if (bVar.mo5048c() == null) {
            throw new C0351g("Invalid cookie state: domain not specified");
        }
        String lowerCase2 = bVar.mo5048c().toLowerCase(Locale.ENGLISH);
        if (!(bVar instanceof C0345a) || !((C0345a) bVar).mo5044b("domain")) {
            if (!bVar.mo5048c().equals(lowerCase)) {
                throw new C0351g("Illegal domain attribute: \"" + bVar.mo5048c() + "\".Domain of origin: \"" + lowerCase + "\"");
            }
        } else if (!lowerCase2.startsWith(".")) {
            throw new C0351g("Domain attribute \"" + bVar.mo5048c() + "\" violates RFC 2109: domain must start with a dot");
        } else {
            int indexOf = lowerCase2.indexOf(46, 1);
            if ((indexOf < 0 || indexOf == lowerCase2.length() - 1) && !lowerCase2.equals(".local")) {
                throw new C0351g("Domain attribute \"" + bVar.mo5048c() + "\" violates RFC 2965: the value contains no embedded dots and the value is not .local");
            } else if (!m839a(lowerCase, lowerCase2)) {
                throw new C0351g("Domain attribute \"" + bVar.mo5048c() + "\" violates RFC 2965: effective host name does not domain-match domain attribute.");
            } else if (lowerCase.substring(0, lowerCase.length() - lowerCase2.length()).indexOf(46) != -1) {
                throw new C0351g("Domain attribute \"" + bVar.mo5048c() + "\" violates RFC 2965: effective host minus domain may not contain any dots");
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
            String lowerCase = str.toLowerCase(Locale.ENGLISH);
            if (!str.startsWith(".")) {
                lowerCase = "." + lowerCase;
            }
            nVar.mo5076c(lowerCase);
        }
    }

    /* renamed from: b */
    public final boolean mo5055b(C0346b bVar, C0349e eVar) {
        C0250b.m84a((Object) bVar, "Cookie");
        C0250b.m84a((Object) eVar, "Cookie origin");
        String lowerCase = eVar.mo5057a().toLowerCase(Locale.ENGLISH);
        String c = bVar.mo5048c();
        return m839a(lowerCase, c) && lowerCase.substring(0, lowerCase.length() - c.length()).indexOf(46) == -1;
    }
}
