package org.p004a.p005a.p033i;

import org.p004a.p005a.C0360f;
import org.p004a.p005a.C0576y;
import org.p004a.p005a.p007b.p008a.C0250b;
import org.p004a.p005a.p037m.C0563b;

/* renamed from: org.a.a.i.d */
public final class C0525d {

    /* renamed from: a */
    public static final C0525d f570a = new C0525d();

    static {
        new C0525d();
    }

    /* renamed from: a */
    private static int m1037a(C0576y yVar) {
        if (yVar == null) {
            return 0;
        }
        int length = yVar.mo5357a().length();
        String b = yVar.mo5358b();
        return b != null ? length + b.length() + 3 : length;
    }

    /* renamed from: a */
    private void m1038a(C0563b bVar, String str, boolean z) {
        if (!z) {
            for (int i = 0; i < str.length() && !z; i++) {
                z = " ;,:@()<>\\\"/[]?={}\t".indexOf(str.charAt(i)) >= 0;
            }
        }
        if (z) {
            bVar.mo5427a('\"');
        }
        for (int i2 = 0; i2 < str.length(); i2++) {
            char charAt = str.charAt(i2);
            if ("\"\\".indexOf(charAt) >= 0) {
                bVar.mo5427a('\\');
            }
            bVar.mo5427a(charAt);
        }
        if (z) {
            bVar.mo5427a('\"');
        }
    }

    /* renamed from: a */
    public final C0563b mo5338a(C0563b bVar, C0360f fVar, boolean z) {
        int length;
        C0250b.m84a((Object) fVar, "Header element");
        if (fVar == null) {
            length = 0;
        } else {
            length = fVar.mo5080a().length();
            String b = fVar.mo5083b();
            if (b != null) {
                length += b.length() + 3;
            }
            int d = fVar.mo5085d();
            if (d > 0) {
                int i = 0;
                while (i < d) {
                    int a = m1037a(fVar.mo5081a(i)) + 2 + length;
                    i++;
                    length = a;
                }
            }
        }
        bVar.mo5433b(length);
        bVar.mo5428a(fVar.mo5080a());
        String b2 = fVar.mo5083b();
        if (b2 != null) {
            bVar.mo5427a('=');
            m1038a(bVar, b2, false);
        }
        int d2 = fVar.mo5085d();
        if (d2 > 0) {
            for (int i2 = 0; i2 < d2; i2++) {
                bVar.mo5428a("; ");
                mo5339a(bVar, fVar.mo5081a(i2), false);
            }
        }
        return bVar;
    }

    /* renamed from: a */
    public final C0563b mo5339a(C0563b bVar, C0576y yVar, boolean z) {
        C0250b.m84a((Object) yVar, "Name / value pair");
        int a = m1037a(yVar);
        if (bVar == null) {
            bVar = new C0563b(a);
        } else {
            bVar.mo5433b(a);
        }
        bVar.mo5428a(yVar.mo5357a());
        String b = yVar.mo5358b();
        if (b != null) {
            bVar.mo5427a('=');
            m1038a(bVar, b, z);
        }
        return bVar;
    }

    /* renamed from: a */
    public final C0563b mo5340a(C0563b bVar, C0576y[] yVarArr, boolean z) {
        int i;
        C0250b.m84a((Object) yVarArr, "Header parameter array");
        if (yVarArr == null || yVarArr.length <= 0) {
            i = 0;
        } else {
            i = (yVarArr.length - 1) << 1;
            int length = yVarArr.length;
            int i2 = 0;
            while (i2 < length) {
                int a = m1037a(yVarArr[i2]) + i;
                i2++;
                i = a;
            }
        }
        bVar.mo5433b(i);
        for (int i3 = 0; i3 < yVarArr.length; i3++) {
            if (i3 > 0) {
                bVar.mo5428a("; ");
            }
            mo5339a(bVar, yVarArr[i3], false);
        }
        return bVar;
    }
}
