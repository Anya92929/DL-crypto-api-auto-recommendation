package org.p004a.p005a.p025g.p029d;

import java.util.Locale;
import java.util.StringTokenizer;
import org.p004a.p005a.p007b.p008a.C0250b;
import org.p004a.p005a.p021e.C0346b;
import org.p004a.p005a.p021e.C0349e;
import org.p004a.p005a.p021e.C0351g;

/* renamed from: org.a.a.g.d.v */
public final class C0488v extends C0472f {
    /* renamed from: a */
    public final void mo5053a(C0346b bVar, C0349e eVar) {
        super.mo5053a(bVar, eVar);
        String a = eVar.mo5057a();
        String c = bVar.mo5048c();
        if (a.contains(".")) {
            int countTokens = new StringTokenizer(c, ".").countTokens();
            String upperCase = c.toUpperCase(Locale.ENGLISH);
            if (upperCase.endsWith(".COM") || upperCase.endsWith(".EDU") || upperCase.endsWith(".NET") || upperCase.endsWith(".GOV") || upperCase.endsWith(".MIL") || upperCase.endsWith(".ORG") || upperCase.endsWith(".INT")) {
                if (countTokens < 2) {
                    throw new C0351g("Domain attribute \"" + c + "\" violates the Netscape cookie specification for special domains");
                }
            } else if (countTokens < 3) {
                throw new C0351g("Domain attribute \"" + c + "\" violates the Netscape cookie specification");
            }
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
        return a.endsWith(c);
    }
}
