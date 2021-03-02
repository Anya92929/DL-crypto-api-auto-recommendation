package org.p004a.p005a.p025g.p029d;

import java.util.ArrayList;
import org.p004a.p005a.C0360f;
import org.p004a.p005a.C0576y;
import org.p004a.p005a.p007b.p008a.C0250b;
import org.p004a.p005a.p033i.C0524c;
import org.p004a.p005a.p033i.C0532k;
import org.p004a.p005a.p033i.C0541t;
import org.p004a.p005a.p036l.C0552d;
import org.p004a.p005a.p037m.C0563b;

/* renamed from: org.a.a.g.d.w */
public final class C0489w {

    /* renamed from: a */
    public static final C0489w f489a = new C0489w();

    /* renamed from: b */
    private static C0576y m928b(C0563b bVar, C0541t tVar) {
        String str;
        boolean z;
        boolean z2 = true;
        boolean z3 = false;
        int b = tVar.mo5385b();
        int b2 = tVar.mo5385b();
        int a = tVar.mo5383a();
        while (true) {
            if (b >= a) {
                break;
            }
            char a2 = bVar.mo5423a(b);
            if (a2 == '=') {
                break;
            } else if (a2 == ';') {
                z3 = true;
                break;
            } else {
                b++;
            }
        }
        if (b == a) {
            str = bVar.mo5432b(b2, a);
            z = true;
        } else {
            String b3 = bVar.mo5432b(b2, b);
            b++;
            str = b3;
            z = z3;
        }
        if (z) {
            tVar.mo5384a(b);
            return new C0532k(str, (String) null);
        }
        int i = b;
        while (true) {
            if (i >= a) {
                z2 = z;
                break;
            } else if (bVar.mo5423a(i) == ';') {
                break;
            } else {
                i++;
            }
        }
        while (b < i && C0552d.m1151a(bVar.mo5423a(b))) {
            b++;
        }
        int i2 = i;
        while (i2 > b && C0552d.m1151a(bVar.mo5423a(i2 - 1))) {
            i2--;
        }
        String a3 = bVar.mo5425a(b, i2);
        tVar.mo5384a(z2 ? i + 1 : i);
        return new C0532k(str, a3);
    }

    /* renamed from: a */
    public final C0360f mo5269a(C0563b bVar, C0541t tVar) {
        C0250b.m84a((Object) bVar, "Char array buffer");
        C0250b.m84a((Object) tVar, "Parser cursor");
        C0576y b = m928b(bVar, tVar);
        ArrayList arrayList = new ArrayList();
        while (!tVar.mo5386c()) {
            arrayList.add(m928b(bVar, tVar));
        }
        return new C0524c(b.mo5357a(), b.mo5358b(), (C0576y[]) arrayList.toArray(new C0576y[arrayList.size()]));
    }
}
