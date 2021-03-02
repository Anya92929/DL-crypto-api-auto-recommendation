package com.google.android.gms.common.internal;

import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

public abstract class DowngradeableSafeParcel implements SafeParcelable {

    /* renamed from: a */
    private static final Object f2904a = new Object();

    /* renamed from: b */
    private static ClassLoader f2905b = null;

    /* renamed from: c */
    private static Integer f2906c = null;

    /* renamed from: d */
    private boolean f2907d = false;

    /* renamed from: a */
    private static boolean m3893a(Class<?> cls) {
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
            return m3893a(zzqA.loadClass(str));
        } catch (Exception e) {
            return false;
        }
    }

    protected static ClassLoader zzqA() {
        ClassLoader classLoader;
        synchronized (f2904a) {
            classLoader = f2905b;
        }
        return classLoader;
    }

    protected static Integer zzqB() {
        Integer num;
        synchronized (f2904a) {
            num = f2906c;
        }
        return num;
    }

    /* access modifiers changed from: protected */
    public boolean zzqC() {
        return this.f2907d;
    }
}
