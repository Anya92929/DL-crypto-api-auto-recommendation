package com.google.android.gms.internal;

import java.io.IOException;

/* renamed from: com.google.android.gms.internal.pp */
public final class C1721pp {
    public static final int[] awL = new int[0];
    public static final long[] awM = new long[0];
    public static final float[] awN = new float[0];
    public static final double[] awO = new double[0];
    public static final boolean[] awP = new boolean[0];
    public static final String[] awQ = new String[0];
    public static final byte[][] awR = new byte[0][];
    public static final byte[] awS = new byte[0];

    /* renamed from: b */
    public static final int m6106b(C1709pe peVar, int i) throws IOException {
        int i2 = 1;
        int position = peVar.getPosition();
        peVar.mo10022gm(i);
        while (peVar.mo10028qg() == i) {
            peVar.mo10022gm(i);
            i2++;
        }
        peVar.mo10025gq(position);
        return i2;
    }

    /* renamed from: gG */
    static int m6107gG(int i) {
        return i & 7;
    }

    /* renamed from: gH */
    public static int m6108gH(int i) {
        return i >>> 3;
    }

    /* renamed from: x */
    static int m6109x(int i, int i2) {
        return (i << 3) | i2;
    }
}
