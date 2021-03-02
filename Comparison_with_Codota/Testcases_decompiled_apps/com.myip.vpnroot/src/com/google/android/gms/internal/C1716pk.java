package com.google.android.gms.internal;

import java.util.Arrays;

/* renamed from: com.google.android.gms.internal.pk */
public final class C1716pk {
    public static final Object awI = new Object();

    public static boolean equals(float[] field1, float[] field2) {
        if (field1 == null || field1.length == 0) {
            return field2 == null || field2.length == 0;
        }
        return Arrays.equals(field1, field2);
    }

    public static boolean equals(int[] field1, int[] field2) {
        if (field1 == null || field1.length == 0) {
            return field2 == null || field2.length == 0;
        }
        return Arrays.equals(field1, field2);
    }

    public static boolean equals(long[] field1, long[] field2) {
        if (field1 == null || field1.length == 0) {
            return field2 == null || field2.length == 0;
        }
        return Arrays.equals(field1, field2);
    }

    public static boolean equals(Object[] field1, Object[] field2) {
        int length = field1 == null ? 0 : field1.length;
        int length2 = field2 == null ? 0 : field2.length;
        int i = 0;
        int i2 = 0;
        while (true) {
            if (i2 >= length || field1[i2] != null) {
                int i3 = i;
                while (i3 < length2 && field2[i3] == null) {
                    i3++;
                }
                boolean z = i2 >= length;
                boolean z2 = i3 >= length2;
                if (z && z2) {
                    return true;
                }
                if (z != z2 || !field1[i2].equals(field2[i3])) {
                    return false;
                }
                i = i3 + 1;
                i2++;
            } else {
                i2++;
            }
        }
    }

    public static int hashCode(float[] field) {
        if (field == null || field.length == 0) {
            return 0;
        }
        return Arrays.hashCode(field);
    }

    public static int hashCode(int[] field) {
        if (field == null || field.length == 0) {
            return 0;
        }
        return Arrays.hashCode(field);
    }

    public static int hashCode(long[] field) {
        if (field == null || field.length == 0) {
            return 0;
        }
        return Arrays.hashCode(field);
    }

    public static int hashCode(Object[] field) {
        int i = 0;
        int length = field == null ? 0 : field.length;
        for (int i2 = 0; i2 < length; i2++) {
            Object obj = field[i2];
            if (obj != null) {
                i = (i * 31) + obj.hashCode();
            }
        }
        return i;
    }
}
