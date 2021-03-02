package org.p004a.p005a.p025g.p029d;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import org.p004a.p005a.C0360f;
import org.p004a.p005a.C0576y;
import org.p004a.p005a.p007b.p008a.C0250b;
import org.p004a.p005a.p021e.C0346b;
import org.p004a.p005a.p021e.C0347c;
import org.p004a.p005a.p021e.C0349e;
import org.p004a.p005a.p021e.C0357m;
import org.p004a.p005a.p021e.C0358n;

/* renamed from: org.a.a.g.d.s */
public abstract class C0485s extends C0468b {
    /* renamed from: a */
    protected static String m916a(C0349e eVar) {
        String b = eVar.mo5058b();
        int lastIndexOf = b.lastIndexOf(47);
        if (lastIndexOf < 0) {
            return b;
        }
        if (lastIndexOf == 0) {
            lastIndexOf = 1;
        }
        return b.substring(0, lastIndexOf);
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public List mo5260a(C0360f[] fVarArr, C0349e eVar) {
        ArrayList arrayList = new ArrayList(fVarArr.length);
        for (C0360f fVar : fVarArr) {
            String a = fVar.mo5080a();
            String b = fVar.mo5083b();
            if (a == null || a.length() == 0) {
                throw new C0357m("Cookie name may not be empty");
            }
            C0469c cVar = new C0469c(a, b);
            cVar.mo5077d(m916a(eVar));
            cVar.mo5076c(eVar.mo5057a());
            C0576y[] c = fVar.mo5084c();
            for (int length = c.length - 1; length >= 0; length--) {
                C0576y yVar = c[length];
                String lowerCase = yVar.mo5357a().toLowerCase(Locale.ENGLISH);
                cVar.mo5264a(lowerCase, yVar.mo5358b());
                C0347c a2 = mo5261a(lowerCase);
                if (a2 != null) {
                    a2.mo5054a((C0358n) cVar, yVar.mo5358b());
                }
            }
            arrayList.add(cVar);
        }
        return arrayList;
    }

    /* renamed from: a */
    public void mo5066a(C0346b bVar, C0349e eVar) {
        C0250b.m84a((Object) bVar, "Cookie");
        C0250b.m84a((Object) eVar, "Cookie origin");
        for (C0347c a : mo5263c()) {
            a.mo5053a(bVar, eVar);
        }
    }

    /* renamed from: b */
    public boolean mo5068b(C0346b bVar, C0349e eVar) {
        C0250b.m84a((Object) bVar, "Cookie");
        C0250b.m84a((Object) eVar, "Cookie origin");
        for (C0347c b : mo5263c()) {
            if (!b.mo5055b(bVar, eVar)) {
                return false;
            }
        }
        return true;
    }
}
