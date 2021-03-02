package com.google.android.gms.common.internal;

import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

/* renamed from: com.google.android.gms.common.internal.c */
public abstract class C0315c implements SafeParcelable {

    /* renamed from: Ln */
    private static final Object f744Ln = new Object();

    /* renamed from: Lo */
    private static ClassLoader f745Lo = null;

    /* renamed from: Lp */
    private static Integer f746Lp = null;

    /* renamed from: Lq */
    private boolean f747Lq = false;

    /* renamed from: a */
    private static boolean m683a(Class<?> cls) {
        try {
            return SafeParcelable.NULL.equals(cls.getField("NULL").get((Object) null));
        } catch (IllegalAccessException | NoSuchFieldException e) {
            return false;
        }
    }

    /* renamed from: aV */
    protected static boolean m684aV(String str) {
        ClassLoader gO = m685gO();
        if (gO == null) {
            return true;
        }
        try {
            return m683a(gO.loadClass(str));
        } catch (Exception e) {
            return false;
        }
    }

    /* renamed from: gO */
    protected static ClassLoader m685gO() {
        ClassLoader classLoader;
        synchronized (f744Ln) {
            classLoader = f745Lo;
        }
        return classLoader;
    }

    /* renamed from: gP */
    protected static Integer m686gP() {
        Integer num;
        synchronized (f744Ln) {
            num = f746Lp;
        }
        return num;
    }

    /* access modifiers changed from: protected */
    /* renamed from: gQ */
    public boolean mo4427gQ() {
        return this.f747Lq;
    }
}
