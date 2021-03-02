package org.p004a.p005a.p025g.p029d;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import org.p004a.p005a.C0344e;
import org.p004a.p005a.C0360f;
import org.p004a.p005a.C0576y;
import org.p004a.p005a.p007b.p008a.C0250b;
import org.p004a.p005a.p021e.C0345a;
import org.p004a.p005a.p021e.C0346b;
import org.p004a.p005a.p021e.C0347c;
import org.p004a.p005a.p021e.C0349e;
import org.p004a.p005a.p021e.C0357m;
import org.p004a.p005a.p021e.C0358n;
import org.p004a.p005a.p033i.C0536o;
import org.p004a.p005a.p037m.C0563b;

/* renamed from: org.a.a.g.d.ah */
public final class C0465ah extends C0458aa {
    public C0465ah() {
        this((String[]) null, false);
    }

    public C0465ah(String[] strArr, boolean z) {
        super(strArr, z);
        mo5262a("domain", new C0463af());
        mo5262a("port", new C0464ag());
        mo5262a("commenturl", new C0461ad());
        mo5262a("discard", new C0462ae());
        mo5262a("version", new C0467aj());
    }

    /* renamed from: b */
    private List m848b(C0360f[] fVarArr, C0349e eVar) {
        ArrayList arrayList = new ArrayList(fVarArr.length);
        for (C0360f fVar : fVarArr) {
            String a = fVar.mo5080a();
            String b = fVar.mo5083b();
            if (a == null || a.length() == 0) {
                throw new C0357m("Cookie name may not be empty");
            }
            C0470d dVar = new C0470d(a, b);
            dVar.mo5077d(m916a(eVar));
            dVar.mo5076c(eVar.mo5057a());
            dVar.mo5078a(new int[]{eVar.mo5059c()});
            C0576y[] c = fVar.mo5084c();
            HashMap hashMap = new HashMap(c.length);
            for (int length = c.length - 1; length >= 0; length--) {
                C0576y yVar = c[length];
                hashMap.put(yVar.mo5357a().toLowerCase(Locale.ENGLISH), yVar);
            }
            for (Map.Entry value : hashMap.entrySet()) {
                C0576y yVar2 = (C0576y) value.getValue();
                String lowerCase = yVar2.mo5357a().toLowerCase(Locale.ENGLISH);
                dVar.mo5264a(lowerCase, yVar2.mo5358b());
                C0347c a2 = mo5261a(lowerCase);
                if (a2 != null) {
                    a2.mo5054a((C0358n) dVar, yVar2.mo5358b());
                }
            }
            arrayList.add(dVar);
        }
        return arrayList;
    }

    /* renamed from: b */
    private static C0349e m849b(C0349e eVar) {
        boolean z = false;
        String a = eVar.mo5057a();
        int i = 0;
        while (true) {
            if (i >= a.length()) {
                z = true;
                break;
            }
            char charAt = a.charAt(i);
            if (charAt == '.' || charAt == ':') {
                break;
            }
            i++;
        }
        return z ? new C0349e(a + ".local", eVar.mo5059c(), eVar.mo5058b(), eVar.mo5060d()) : eVar;
    }

    /* renamed from: a */
    public final int mo5063a() {
        return 1;
    }

    /* renamed from: a */
    public final List mo5065a(C0344e eVar, C0349e eVar2) {
        C0250b.m84a((Object) eVar, "Header");
        C0250b.m84a((Object) eVar2, "Cookie origin");
        if (eVar.mo5040c().equalsIgnoreCase("Set-Cookie2")) {
            return m848b(eVar.mo5042e(), m849b(eVar2));
        }
        throw new C0357m("Unrecognized cookie header '" + eVar.toString() + "'");
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public final List mo5260a(C0360f[] fVarArr, C0349e eVar) {
        return m848b(fVarArr, m849b(eVar));
    }

    /* renamed from: a */
    public final void mo5066a(C0346b bVar, C0349e eVar) {
        C0250b.m84a((Object) bVar, "Cookie");
        C0250b.m84a((Object) eVar, "Cookie origin");
        super.mo5066a(bVar, m849b(eVar));
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public final void mo5258a(C0563b bVar, C0346b bVar2, int i) {
        String a;
        int[] e;
        super.mo5258a(bVar, bVar2, i);
        if ((bVar2 instanceof C0345a) && (a = ((C0345a) bVar2).mo5043a("port")) != null) {
            bVar.mo5428a("; $Port");
            bVar.mo5428a("=\"");
            if (a.trim().length() > 0 && (e = bVar2.mo5050e()) != null) {
                int length = e.length;
                for (int i2 = 0; i2 < length; i2++) {
                    if (i2 > 0) {
                        bVar.mo5428a(",");
                    }
                    bVar.mo5428a(Integer.toString(e[i2]));
                }
            }
            bVar.mo5428a("\"");
        }
    }

    /* renamed from: b */
    public final C0344e mo5067b() {
        C0563b bVar = new C0563b(40);
        bVar.mo5428a("Cookie2");
        bVar.mo5428a(": ");
        bVar.mo5428a("$Version=");
        bVar.mo5428a(Integer.toString(1));
        return new C0536o(bVar);
    }

    /* renamed from: b */
    public final boolean mo5068b(C0346b bVar, C0349e eVar) {
        C0250b.m84a((Object) bVar, "Cookie");
        C0250b.m84a((Object) eVar, "Cookie origin");
        return super.mo5068b(bVar, m849b(eVar));
    }

    public final String toString() {
        return "rfc2965";
    }
}
