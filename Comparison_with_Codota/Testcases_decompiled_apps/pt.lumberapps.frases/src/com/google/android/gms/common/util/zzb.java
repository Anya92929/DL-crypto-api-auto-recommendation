package com.google.android.gms.common.util;

import com.google.android.gms.common.internal.zzaa;
import java.util.ArrayList;
import java.util.Arrays;

public final class zzb {
    public static int zza(Object[] objArr, Object obj) {
        int length = objArr != null ? objArr.length : 0;
        for (int i = 0; i < length; i++) {
            if (zzaa.equal(objArr[i], obj)) {
                return i;
            }
        }
        return -1;
    }

    public static void zza(StringBuilder sb, double[] dArr) {
        int length = dArr.length;
        for (int i = 0; i < length; i++) {
            if (i != 0) {
                sb.append(",");
            }
            sb.append(Double.toString(dArr[i]));
        }
    }

    public static void zza(StringBuilder sb, float[] fArr) {
        int length = fArr.length;
        for (int i = 0; i < length; i++) {
            if (i != 0) {
                sb.append(",");
            }
            sb.append(Float.toString(fArr[i]));
        }
    }

    public static void zza(StringBuilder sb, int[] iArr) {
        int length = iArr.length;
        for (int i = 0; i < length; i++) {
            if (i != 0) {
                sb.append(",");
            }
            sb.append(Integer.toString(iArr[i]));
        }
    }

    public static void zza(StringBuilder sb, long[] jArr) {
        int length = jArr.length;
        for (int i = 0; i < length; i++) {
            if (i != 0) {
                sb.append(",");
            }
            sb.append(Long.toString(jArr[i]));
        }
    }

    public static void zza(StringBuilder sb, Object[] objArr) {
        int length = objArr.length;
        for (int i = 0; i < length; i++) {
            if (i != 0) {
                sb.append(",");
            }
            sb.append(objArr[i].toString());
        }
    }

    public static void zza(StringBuilder sb, String[] strArr) {
        int length = strArr.length;
        for (int i = 0; i < length; i++) {
            if (i != 0) {
                sb.append(",");
            }
            sb.append("\"").append(strArr[i]).append("\"");
        }
    }

    public static void zza(StringBuilder sb, boolean[] zArr) {
        int length = zArr.length;
        for (int i = 0; i < length; i++) {
            if (i != 0) {
                sb.append(",");
            }
            sb.append(Boolean.toString(zArr[i]));
        }
    }

    public static byte[] zza(byte[]... bArr) {
        if (bArr.length == 0) {
            return new byte[0];
        }
        int i = 0;
        for (byte[] length : bArr) {
            i += length.length;
        }
        byte[] copyOf = Arrays.copyOf(bArr[0], i);
        int length2 = bArr[0].length;
        for (int i2 = 1; i2 < bArr.length; i2++) {
            byte[] bArr2 = bArr[i2];
            System.arraycopy(bArr2, 0, copyOf, length2, bArr2.length);
            length2 += bArr2.length;
        }
        return copyOf;
    }

    public static Integer[] zza(int[] iArr) {
        if (iArr == null) {
            return null;
        }
        int length = iArr.length;
        Integer[] numArr = new Integer[length];
        for (int i = 0; i < length; i++) {
            numArr[i] = Integer.valueOf(iArr[i]);
        }
        return numArr;
    }

    public static ArrayList zzavj() {
        return new ArrayList();
    }

    public static ArrayList zzb(Object[] objArr) {
        ArrayList arrayList = new ArrayList(r1);
        for (Object add : objArr) {
            arrayList.add(add);
        }
        return arrayList;
    }

    public static boolean zzb(Object[] objArr, Object obj) {
        return zza(objArr, obj) >= 0;
    }
}
