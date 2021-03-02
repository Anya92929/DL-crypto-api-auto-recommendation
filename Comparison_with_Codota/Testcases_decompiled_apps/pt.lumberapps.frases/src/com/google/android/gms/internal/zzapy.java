package com.google.android.gms.internal;

public final class zzapy {
    public static final int[] bjH = new int[0];
    public static final long[] bjI = new long[0];
    public static final float[] bjJ = new float[0];
    public static final double[] bjK = new double[0];
    public static final boolean[] bjL = new boolean[0];
    public static final String[] bjM = new String[0];
    public static final byte[][] bjN = new byte[0][];
    public static final byte[] bjO = new byte[0];

    /* renamed from: a */
    static int m6834a(int i) {
        return i & 7;
    }

    public static int zzagj(int i) {
        return i >>> 3;
    }

    public static int zzaj(int i, int i2) {
        return (i << 3) | i2;
    }

    public static boolean zzb(zzapn zzapn, int i) {
        return zzapn.zzafp(i);
    }

    public static final int zzc(zzapn zzapn, int i) {
        int i2 = 1;
        int position = zzapn.getPosition();
        zzapn.zzafp(i);
        while (zzapn.mo7957ah() == i) {
            zzapn.zzafp(i);
            i2++;
        }
        zzapn.zzaft(position);
        return i2;
    }
}
