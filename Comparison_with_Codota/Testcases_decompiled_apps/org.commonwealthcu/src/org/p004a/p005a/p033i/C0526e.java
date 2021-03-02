package org.p004a.p005a.p033i;

import java.util.ArrayList;
import org.p004a.p005a.C0360f;
import org.p004a.p005a.C0576y;
import org.p004a.p005a.p007b.p008a.C0250b;
import org.p004a.p005a.p036l.C0552d;
import org.p004a.p005a.p037m.C0563b;

/* renamed from: org.a.a.i.e */
public final class C0526e implements C0538q {

    /* renamed from: a */
    public static final C0526e f571a = new C0526e();

    /* renamed from: b */
    private static final char[] f572b = {';', ','};

    static {
        new C0526e();
    }

    /* renamed from: a */
    private static C0576y m1042a(String str, String str2) {
        return new C0532k(str, str2);
    }

    /* renamed from: a */
    private static boolean m1043a(char c, char[] cArr) {
        if (cArr == null) {
            return false;
        }
        for (char c2 : cArr) {
            if (c == c2) {
                return true;
            }
        }
        return false;
    }

    /* renamed from: a */
    public static C0360f[] m1044a(String str, C0538q qVar) {
        C0250b.m84a((Object) str, "Value");
        C0563b bVar = new C0563b(str.length());
        bVar.mo5428a(str);
        return f571a.mo5342a(bVar, new C0541t(0, str.length()));
    }

    /* renamed from: c */
    private C0576y m1045c(C0563b bVar, C0541t tVar) {
        return mo5341a(bVar, tVar, f572b);
    }

    /* renamed from: a */
    public final C0576y mo5341a(C0563b bVar, C0541t tVar, char[] cArr) {
        boolean z;
        String str;
        boolean z2;
        boolean z3 = true;
        C0250b.m84a((Object) bVar, "Char array buffer");
        C0250b.m84a((Object) tVar, "Parser cursor");
        int b = tVar.mo5385b();
        int b2 = tVar.mo5385b();
        int a = tVar.mo5383a();
        while (true) {
            if (b < a) {
                char a2 = bVar.mo5423a(b);
                if (a2 == '=') {
                    break;
                } else if (m1043a(a2, cArr)) {
                    z = true;
                    break;
                } else {
                    b++;
                }
            } else {
                break;
            }
        }
        z = false;
        if (b == a) {
            str = bVar.mo5432b(b2, a);
            z = true;
        } else {
            String b3 = bVar.mo5432b(b2, b);
            b++;
            str = b3;
        }
        if (z) {
            tVar.mo5384a(b);
            return m1042a(str, (String) null);
        }
        boolean z4 = false;
        boolean z5 = false;
        int i = b;
        while (true) {
            if (i < a) {
                char a3 = bVar.mo5423a(i);
                if (a3 != '\"' || z4) {
                    z2 = z5;
                } else {
                    z2 = !z5;
                }
                if (!z2 && !z4 && m1043a(a3, cArr)) {
                    break;
                }
                i++;
                z4 = !z4 && z2 && a3 == '\\';
                z5 = z2;
            } else {
                z3 = z;
                break;
            }
        }
        int i2 = b;
        while (i2 < i && C0552d.m1151a(bVar.mo5423a(i2))) {
            i2++;
        }
        int i3 = i;
        while (i3 > i2 && C0552d.m1151a(bVar.mo5423a(i3 - 1))) {
            i3--;
        }
        if (i3 - i2 >= 2 && bVar.mo5423a(i2) == '\"' && bVar.mo5423a(i3 - 1) == '\"') {
            i2++;
            i3--;
        }
        String a4 = bVar.mo5425a(i2, i3);
        tVar.mo5384a(z3 ? i + 1 : i);
        return m1042a(str, a4);
    }

    /* renamed from: a */
    public final C0360f[] mo5342a(C0563b bVar, C0541t tVar) {
        C0250b.m84a((Object) bVar, "Char array buffer");
        C0250b.m84a((Object) tVar, "Parser cursor");
        ArrayList arrayList = new ArrayList();
        while (!tVar.mo5386c()) {
            C0360f b = mo5343b(bVar, tVar);
            if (b.mo5080a().length() != 0 || b.mo5083b() != null) {
                arrayList.add(b);
            }
        }
        return (C0360f[]) arrayList.toArray(new C0360f[arrayList.size()]);
    }

    /* renamed from: b */
    public final C0360f mo5343b(C0563b bVar, C0541t tVar) {
        C0250b.m84a((Object) bVar, "Char array buffer");
        C0250b.m84a((Object) tVar, "Parser cursor");
        C0576y c = m1045c(bVar, tVar);
        C0576y[] yVarArr = null;
        if (!tVar.mo5386c() && bVar.mo5423a(tVar.mo5385b() - 1) != ',') {
            C0250b.m84a((Object) bVar, "Char array buffer");
            C0250b.m84a((Object) tVar, "Parser cursor");
            int b = tVar.mo5385b();
            int a = tVar.mo5383a();
            while (b < a && C0552d.m1151a(bVar.mo5423a(b))) {
                b++;
            }
            tVar.mo5384a(b);
            if (tVar.mo5386c()) {
                yVarArr = new C0576y[0];
            } else {
                ArrayList arrayList = new ArrayList();
                while (!tVar.mo5386c()) {
                    arrayList.add(m1045c(bVar, tVar));
                    if (bVar.mo5423a(tVar.mo5385b() - 1) == ',') {
                        break;
                    }
                }
                yVarArr = (C0576y[]) arrayList.toArray(new C0576y[arrayList.size()]);
            }
        }
        return new C0524c(c.mo5357a(), c.mo5358b(), yVarArr);
    }
}
