package org.p004a.p005a.p033i;

import org.p004a.p005a.C0239aa;
import org.p004a.p005a.C0241ac;
import org.p004a.p005a.C0244af;
import org.p004a.p005a.C0344e;
import org.p004a.p005a.C0573v;
import org.p004a.p005a.p007b.p008a.C0250b;
import org.p004a.p005a.p036l.C0552d;
import org.p004a.p005a.p037m.C0563b;

/* renamed from: org.a.a.i.i */
public final class C0530i implements C0540s {

    /* renamed from: a */
    public static final C0530i f582a = new C0530i();

    /* renamed from: b */
    private C0241ac f583b;

    static {
        new C0530i();
    }

    public C0530i() {
        this((C0241ac) null);
    }

    private C0530i(C0241ac acVar) {
        this.f583b = C0573v.f645b;
    }

    /* renamed from: c */
    private C0241ac m1061c(C0563b bVar, C0541t tVar) {
        boolean z = true;
        C0250b.m84a((Object) bVar, "Char array buffer");
        C0250b.m84a((Object) tVar, "Parser cursor");
        String a = this.f583b.mo4854a();
        int length = a.length();
        int b = tVar.mo5385b();
        int a2 = tVar.mo5383a();
        m1062d(bVar, tVar);
        int b2 = tVar.mo5385b();
        if (b2 + length + 4 > a2) {
            throw new C0239aa("Not a valid protocol version: " + bVar.mo5425a(b, a2));
        }
        int i = 0;
        boolean z2 = true;
        while (z2 && i < length) {
            z2 = bVar.mo5423a(b2 + i) == a.charAt(i);
            i++;
        }
        if (!z2) {
            z = z2;
        } else if (bVar.mo5423a(b2 + length) != '/') {
            z = false;
        }
        if (!z) {
            throw new C0239aa("Not a valid protocol version: " + bVar.mo5425a(b, a2));
        }
        int i2 = length + 1 + b2;
        int a3 = bVar.mo5424a(46, i2, a2);
        if (a3 == -1) {
            throw new C0239aa("Invalid protocol version number: " + bVar.mo5425a(b, a2));
        }
        try {
            int parseInt = Integer.parseInt(bVar.mo5432b(i2, a3));
            int i3 = a3 + 1;
            int a4 = bVar.mo5424a(32, i3, a2);
            if (a4 == -1) {
                a4 = a2;
            }
            try {
                int parseInt2 = Integer.parseInt(bVar.mo5432b(i3, a4));
                tVar.mo5384a(a4);
                return this.f583b.mo4855a(parseInt, parseInt2);
            } catch (NumberFormatException e) {
                throw new C0239aa("Invalid protocol minor version number: " + bVar.mo5425a(b, a2));
            }
        } catch (NumberFormatException e2) {
            throw new C0239aa("Invalid protocol major version number: " + bVar.mo5425a(b, a2));
        }
    }

    /* renamed from: d */
    private static void m1062d(C0563b bVar, C0541t tVar) {
        int b = tVar.mo5385b();
        int a = tVar.mo5383a();
        while (b < a && C0552d.m1151a(bVar.mo5423a(b))) {
            b++;
        }
        tVar.mo5384a(b);
    }

    /* renamed from: a */
    public final C0344e mo5352a(C0563b bVar) {
        return new C0536o(bVar);
    }

    /* renamed from: a */
    public final boolean mo5353a(C0563b bVar, C0541t tVar) {
        boolean z = true;
        C0250b.m84a((Object) bVar, "Char array buffer");
        C0250b.m84a((Object) tVar, "Parser cursor");
        int b = tVar.mo5385b();
        String a = this.f583b.mo4854a();
        int length = a.length();
        if (bVar.mo5435c() < length + 4) {
            return false;
        }
        if (b < 0) {
            b = (bVar.mo5435c() - 4) - length;
        } else if (b == 0) {
            while (b < bVar.mo5435c() && C0552d.m1151a(bVar.mo5423a(b))) {
                b++;
            }
        }
        if (b + length + 4 > bVar.mo5435c()) {
            return false;
        }
        int i = 0;
        boolean z2 = true;
        while (z2 && i < length) {
            z2 = bVar.mo5423a(b + i) == a.charAt(i);
            i++;
        }
        if (!z2) {
            z = z2;
        } else if (bVar.mo5423a(b + length) != '/') {
            z = false;
        }
        return z;
    }

    /* renamed from: b */
    public final C0244af mo5354b(C0563b bVar, C0541t tVar) {
        C0250b.m84a((Object) bVar, "Char array buffer");
        C0250b.m84a((Object) tVar, "Parser cursor");
        int b = tVar.mo5385b();
        int a = tVar.mo5383a();
        try {
            C0241ac c = m1061c(bVar, tVar);
            m1062d(bVar, tVar);
            int b2 = tVar.mo5385b();
            int a2 = bVar.mo5424a(32, b2, a);
            int i = a2 < 0 ? a : a2;
            String b3 = bVar.mo5432b(b2, i);
            for (int i2 = 0; i2 < b3.length(); i2++) {
                if (!Character.isDigit(b3.charAt(i2))) {
                    throw new C0239aa("Status line contains invalid status code: " + bVar.mo5425a(b, a));
                }
            }
            return new C0534m(c, Integer.parseInt(b3), i < a ? bVar.mo5432b(i, a) : "");
        } catch (NumberFormatException e) {
            throw new C0239aa("Status line contains invalid status code: " + bVar.mo5425a(b, a));
        } catch (IndexOutOfBoundsException e2) {
            throw new C0239aa("Invalid status line: " + bVar.mo5425a(b, a));
        }
    }
}
