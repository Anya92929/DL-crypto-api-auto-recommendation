package com.google.android.gms.p018c;

/* renamed from: com.google.android.gms.c.t */
public class C0678t {

    /* renamed from: a */
    public static final int[] f4380a = new int[0];

    /* renamed from: b */
    public static final long[] f4381b = new long[0];

    /* renamed from: c */
    public static final Object[] f4382c = new Object[0];

    /* renamed from: a */
    public static int m3918a(int[] iArr, int i, int i2) {
        int i3 = 0;
        int i4 = i - 1;
        while (i3 <= i4) {
            int i5 = (i3 + i4) >>> 1;
            int i6 = iArr[i5];
            if (i6 < i2) {
                i3 = i5 + 1;
            } else if (i6 <= i2) {
                return i5;
            } else {
                i4 = i5 - 1;
            }
        }
        return i3 ^ -1;
    }

    /* renamed from: a */
    public static boolean m3919a(Object obj, Object obj2) {
        return obj == obj2 || (obj != null && obj.equals(obj2));
    }
}
