package android.support.p007a.p008a;

import java.util.ArrayList;

/* renamed from: android.support.a.a.f */
class C0010f {
    /* renamed from: a */
    private static int m55a(String str, int i) {
        while (i < str.length()) {
            char charAt = str.charAt(i);
            if (((charAt - 'A') * (charAt - 'Z') <= 0 || (charAt - 'a') * (charAt - 'z') <= 0) && charAt != 'e' && charAt != 'E') {
                break;
            }
            i++;
        }
        return i;
    }

    /* JADX WARNING: Can't fix incorrect switch cases order */
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static void m56a(java.lang.String r7, int r8, android.support.p007a.p008a.C0012h r9) {
        /*
            r1 = 0
            r5 = 1
            r9.f73b = r1
            r0 = r1
            r2 = r1
            r3 = r1
            r4 = r8
        L_0x0008:
            int r6 = r7.length()
            if (r4 >= r6) goto L_0x0018
            char r6 = r7.charAt(r4)
            switch(r6) {
                case 32: goto L_0x001b;
                case 44: goto L_0x001b;
                case 45: goto L_0x001e;
                case 46: goto L_0x0027;
                case 69: goto L_0x0031;
                case 101: goto L_0x0031;
                default: goto L_0x0015;
            }
        L_0x0015:
            r0 = r1
        L_0x0016:
            if (r3 == 0) goto L_0x0033
        L_0x0018:
            r9.f72a = r4
            return
        L_0x001b:
            r0 = r1
            r3 = r5
            goto L_0x0016
        L_0x001e:
            if (r4 == r8) goto L_0x0015
            if (r0 != 0) goto L_0x0015
            r9.f73b = r5
            r0 = r1
            r3 = r5
            goto L_0x0016
        L_0x0027:
            if (r2 != 0) goto L_0x002c
            r0 = r1
            r2 = r5
            goto L_0x0016
        L_0x002c:
            r9.f73b = r5
            r0 = r1
            r3 = r5
            goto L_0x0016
        L_0x0031:
            r0 = r5
            goto L_0x0016
        L_0x0033:
            int r4 = r4 + 1
            goto L_0x0008
        */
        throw new UnsupportedOperationException("Method not decompiled: android.support.p007a.p008a.C0010f.m56a(java.lang.String, int, android.support.a.a.h):void");
    }

    /* renamed from: a */
    private static void m57a(ArrayList arrayList, char c, float[] fArr) {
        arrayList.add(new C0013i(c, fArr));
    }

    /* renamed from: a */
    public static C0013i[] m59a(String str) {
        if (str == null) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        int i = 1;
        int i2 = 0;
        while (i < str.length()) {
            int a = m55a(str, i);
            String trim = str.substring(i2, a).trim();
            if (trim.length() > 0) {
                m57a(arrayList, trim.charAt(0), m61b(trim));
            }
            i = a + 1;
            i2 = a;
        }
        if (i - i2 == 1 && i2 < str.length()) {
            m57a(arrayList, str.charAt(i2), new float[0]);
        }
        return (C0013i[]) arrayList.toArray(new C0013i[arrayList.size()]);
    }

    /* renamed from: a */
    public static C0013i[] m60a(C0013i[] iVarArr) {
        if (iVarArr == null) {
            return null;
        }
        C0013i[] iVarArr2 = new C0013i[iVarArr.length];
        for (int i = 0; i < iVarArr.length; i++) {
            iVarArr2[i] = new C0013i();
        }
        return iVarArr2;
    }

    /* renamed from: b */
    private static float[] m61b(String str) {
        int i;
        if ((str.charAt(0) == 'z') || (str.charAt(0) == 'Z')) {
            return new float[0];
        }
        try {
            float[] fArr = new float[str.length()];
            C0012h hVar = new C0012h();
            int length = str.length();
            int i2 = 0;
            int i3 = 1;
            while (i3 < length) {
                m56a(str, i3, hVar);
                int i4 = hVar.f72a;
                if (i3 < i4) {
                    i = i2 + 1;
                    fArr[i2] = Float.parseFloat(str.substring(i3, i4));
                } else {
                    i = i2;
                }
                if (hVar.f73b) {
                    i3 = i4;
                    i2 = i;
                } else {
                    i3 = i4 + 1;
                    i2 = i;
                }
            }
            return m62b(fArr, 0, i2);
        } catch (NumberFormatException e) {
            throw new RuntimeException("error in parsing \"" + str + "\"", e);
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: b */
    public static float[] m62b(float[] fArr, int i, int i2) {
        if (i > i2) {
            throw new IllegalArgumentException();
        }
        int length = fArr.length;
        if (i < 0 || i > length) {
            throw new ArrayIndexOutOfBoundsException();
        }
        int i3 = i2 - i;
        int min = Math.min(i3, length - i);
        float[] fArr2 = new float[i3];
        System.arraycopy(fArr, i, fArr2, 0, min);
        return fArr2;
    }
}
