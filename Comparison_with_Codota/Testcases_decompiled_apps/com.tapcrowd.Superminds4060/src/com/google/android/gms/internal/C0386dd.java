package com.google.android.gms.internal;

import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

/* renamed from: com.google.android.gms.internal.dd */
public abstract class C0386dd implements SafeParcelable {

    /* renamed from: kA */
    private static ClassLoader f1090kA = null;

    /* renamed from: kB */
    private static Integer f1091kB = null;

    /* renamed from: kz */
    private static final Object f1092kz = new Object();

    /* renamed from: kC */
    private boolean f1093kC = false;

    /* renamed from: a */
    private static boolean m834a(Class<?> cls) {
        try {
            return SafeParcelable.NULL.equals(cls.getField("NULL").get((Object) null));
        } catch (IllegalAccessException | NoSuchFieldException e) {
            return false;
        }
    }

    /* renamed from: aV */
    protected static ClassLoader m835aV() {
        ClassLoader classLoader;
        synchronized (f1092kz) {
            classLoader = f1090kA;
        }
        return classLoader;
    }

    /* access modifiers changed from: protected */
    /* renamed from: aW */
    public static Integer m836aW() {
        Integer num;
        synchronized (f1092kz) {
            num = f1091kB;
        }
        return num;
    }

    /* access modifiers changed from: protected */
    /* renamed from: y */
    public static boolean m837y(String str) {
        ClassLoader aV = m835aV();
        if (aV == null) {
            return true;
        }
        try {
            return m834a(aV.loadClass(str));
        } catch (Exception e) {
            return false;
        }
    }

    /* access modifiers changed from: protected */
    /* renamed from: aX */
    public boolean mo4323aX() {
        return this.f1093kC;
    }
}
