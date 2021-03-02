package com.google.android.gms.common.internal;

import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

public abstract class DowngradeableSafeParcel implements SafeParcelable {
    private static final Object zzalh = new Object();
    private static ClassLoader zzali = null;
    private static Integer zzalj = null;
    private boolean zzalk = false;

    private static boolean zza(Class<?> cls) {
        try {
            return SafeParcelable.NULL.equals(cls.getField("NULL").get((Object) null));
        } catch (IllegalAccessException | NoSuchFieldException e) {
            return false;
        }
    }

    protected static boolean zzcF(String str) {
        ClassLoader zzqA = zzqA();
        if (zzqA == null) {
            return true;
        }
        try {
            return zza(zzqA.loadClass(str));
        } catch (Exception e) {
            return false;
        }
    }

    protected static ClassLoader zzqA() {
        ClassLoader classLoader;
        synchronized (zzalh) {
            classLoader = zzali;
        }
        return classLoader;
    }

    protected static Integer zzqB() {
        Integer num;
        synchronized (zzalh) {
            num = zzalj;
        }
        return num;
    }

    /* access modifiers changed from: protected */
    public boolean zzqC() {
        return this.zzalk;
    }
}
