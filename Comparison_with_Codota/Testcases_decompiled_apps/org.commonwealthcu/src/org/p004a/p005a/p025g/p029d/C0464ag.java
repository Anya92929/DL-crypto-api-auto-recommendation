package org.p004a.p005a.p025g.p029d;

import java.util.StringTokenizer;
import org.p004a.p005a.p007b.p008a.C0250b;
import org.p004a.p005a.p021e.C0345a;
import org.p004a.p005a.p021e.C0346b;
import org.p004a.p005a.p021e.C0347c;
import org.p004a.p005a.p021e.C0349e;
import org.p004a.p005a.p021e.C0351g;
import org.p004a.p005a.p021e.C0357m;
import org.p004a.p005a.p021e.C0358n;
import org.p004a.p005a.p021e.C0359o;

/* renamed from: org.a.a.g.d.ag */
public final class C0464ag implements C0347c {
    /* renamed from: a */
    private static boolean m843a(int i, int[] iArr) {
        for (int i2 : iArr) {
            if (i == i2) {
                return true;
            }
        }
        return false;
    }

    /* renamed from: a */
    private static int[] m844a(String str) {
        StringTokenizer stringTokenizer = new StringTokenizer(str, ",");
        int[] iArr = new int[stringTokenizer.countTokens()];
        int i = 0;
        while (stringTokenizer.hasMoreTokens()) {
            try {
                iArr[i] = Integer.parseInt(stringTokenizer.nextToken().trim());
                if (iArr[i] < 0) {
                    throw new C0357m("Invalid Port attribute.");
                }
                i++;
            } catch (NumberFormatException e) {
                throw new C0357m("Invalid Port attribute: " + e.getMessage());
            }
        }
        return iArr;
    }

    /* renamed from: a */
    public final void mo5053a(C0346b bVar, C0349e eVar) {
        C0250b.m84a((Object) bVar, "Cookie");
        C0250b.m84a((Object) eVar, "Cookie origin");
        int c = eVar.mo5059c();
        if ((bVar instanceof C0345a) && ((C0345a) bVar).mo5044b("port") && !m843a(c, bVar.mo5050e())) {
            throw new C0351g("Port attribute violates RFC 2965: Request port not found in cookie's port list.");
        }
    }

    /* renamed from: a */
    public final void mo5054a(C0358n nVar, String str) {
        C0250b.m84a((Object) nVar, "Cookie");
        if (nVar instanceof C0359o) {
            C0359o oVar = (C0359o) nVar;
            if (str != null && str.trim().length() > 0) {
                oVar.mo5078a(m844a(str));
            }
        }
    }

    /* renamed from: b */
    public final boolean mo5055b(C0346b bVar, C0349e eVar) {
        C0250b.m84a((Object) bVar, "Cookie");
        C0250b.m84a((Object) eVar, "Cookie origin");
        int c = eVar.mo5059c();
        if ((bVar instanceof C0345a) && ((C0345a) bVar).mo5044b("port")) {
            if (bVar.mo5050e() == null) {
                return false;
            }
            if (!m843a(c, bVar.mo5050e())) {
                return false;
            }
        }
        return true;
    }
}
