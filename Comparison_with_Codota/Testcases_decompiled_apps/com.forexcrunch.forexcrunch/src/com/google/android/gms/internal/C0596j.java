package com.google.android.gms.internal;

import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

/* renamed from: com.google.android.gms.internal.j */
public abstract class C0596j implements SafeParcelable {

    /* renamed from: bo */
    private static final Object f1385bo = new Object();

    /* renamed from: bp */
    private static ClassLoader f1386bp = null;

    /* renamed from: bq */
    private static Integer f1387bq = null;

    /* renamed from: br */
    private boolean f1388br = false;

    /* renamed from: a */
    private static boolean m1782a(Class<?> cls) {
        try {
            return SafeParcelable.NULL.equals(cls.getField("NULL").get((Object) null));
        } catch (IllegalAccessException | NoSuchFieldException e) {
            return false;
        }
    }

    /* access modifiers changed from: protected */
    /* renamed from: h */
    public static boolean m1783h(String str) {
        ClassLoader u = m1784u();
        if (u == null) {
            return true;
        }
        try {
            return m1782a(u.loadClass(str));
        } catch (Exception e) {
            return false;
        }
    }

    /* renamed from: u */
    protected static ClassLoader m1784u() {
        ClassLoader classLoader;
        synchronized (f1385bo) {
            classLoader = f1386bp;
        }
        return classLoader;
    }

    /* access modifiers changed from: protected */
    /* renamed from: v */
    public static Integer m1785v() {
        Integer num;
        synchronized (f1385bo) {
            num = f1387bq;
        }
        return num;
    }

    /* access modifiers changed from: protected */
    /* renamed from: w */
    public boolean mo5427w() {
        return this.f1388br;
    }
}
