package com.google.android.gms.vision;

import android.util.SparseArray;

public class zza {
    private static int zzbnl = 0;
    private static final Object zzqy = new Object();
    private SparseArray<Integer> zzbnm = new SparseArray<>();
    private SparseArray<Integer> zzbnn = new SparseArray<>();

    public int zzkr(int i) {
        int i2;
        synchronized (zzqy) {
            Integer num = this.zzbnm.get(i);
            if (num != null) {
                i2 = num.intValue();
            } else {
                i2 = zzbnl;
                zzbnl++;
                this.zzbnm.append(i, Integer.valueOf(i2));
                this.zzbnn.append(i2, Integer.valueOf(i));
            }
        }
        return i2;
    }

    public int zzks(int i) {
        int intValue;
        synchronized (zzqy) {
            intValue = this.zzbnn.get(i).intValue();
        }
        return intValue;
    }
}
