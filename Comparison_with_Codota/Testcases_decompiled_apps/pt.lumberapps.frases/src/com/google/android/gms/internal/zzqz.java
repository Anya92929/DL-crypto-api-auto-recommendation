package com.google.android.gms.internal;

import android.os.Binder;

public abstract class zzqz {

    /* renamed from: c */
    private static final Object f6938c = new Object();

    /* renamed from: d */
    private static C1841qa f6939d = null;

    /* renamed from: e */
    private static int f6940e = 0;

    /* renamed from: f */
    private static String f6941f = "com.google.android.providers.gsf.permission.READ_GSERVICES";

    /* renamed from: a */
    protected final String f6942a;

    /* renamed from: b */
    protected final Object f6943b;

    /* renamed from: g */
    private Object f6944g = null;

    protected zzqz(String str, Object obj) {
        this.f6942a = str;
        this.f6943b = obj;
    }

    /* renamed from: a */
    static /* synthetic */ C1841qa m7544a() {
        return null;
    }

    public static zzqz zza(String str, Float f) {
        return new C1838py(str, f);
    }

    public static zzqz zza(String str, Integer num) {
        return new C1837px(str, num);
    }

    public static zzqz zza(String str, Long l) {
        return new C1836pw(str, l);
    }

    public static zzqz zzab(String str, String str2) {
        return new C1839pz(str, str2);
    }

    public static zzqz zzm(String str, boolean z) {
        return new C1835pv(str, Boolean.valueOf(z));
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public abstract Object mo7655a(String str);

    public final Object get() {
        long clearCallingIdentity;
        try {
            return mo7655a(this.f6942a);
        } catch (SecurityException e) {
            clearCallingIdentity = Binder.clearCallingIdentity();
            Object a = mo7655a(this.f6942a);
            Binder.restoreCallingIdentity(clearCallingIdentity);
            return a;
        } catch (Throwable th) {
            Binder.restoreCallingIdentity(clearCallingIdentity);
            throw th;
        }
    }
}
