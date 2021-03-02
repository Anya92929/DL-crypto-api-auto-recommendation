package com.google.android.gms.p018c;

import android.os.Binder;

/* renamed from: com.google.android.gms.c.k */
public abstract class C0669k<T> {

    /* renamed from: c */
    private static final Object f4371c = new Object();
    /* access modifiers changed from: private */

    /* renamed from: d */
    public static C0675q f4372d = null;

    /* renamed from: e */
    private static int f4373e = 0;

    /* renamed from: f */
    private static String f4374f = "com.google.android.providers.gsf.permission.READ_GSERVICES";

    /* renamed from: a */
    protected final String f4375a;

    /* renamed from: b */
    protected final T f4376b;

    /* renamed from: g */
    private T f4377g = null;

    protected C0669k(String str, T t) {
        this.f4375a = str;
        this.f4376b = t;
    }

    /* renamed from: a */
    public static int m3882a() {
        return f4373e;
    }

    /* renamed from: a */
    public static C0669k<Float> m3883a(String str, Float f) {
        return new C0673o(str, f);
    }

    /* renamed from: a */
    public static C0669k<Integer> m3884a(String str, Integer num) {
        return new C0672n(str, num);
    }

    /* renamed from: a */
    public static C0669k<Long> m3885a(String str, Long l) {
        return new C0671m(str, l);
    }

    /* renamed from: a */
    public static C0669k<String> m3886a(String str, String str2) {
        return new C0674p(str, str2);
    }

    /* renamed from: a */
    public static C0669k<Boolean> m3887a(String str, boolean z) {
        return new C0670l(str, Boolean.valueOf(z));
    }

    /* renamed from: b */
    public static boolean m3888b() {
        return f4372d != null;
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public abstract T mo7233a(String str);

    /* renamed from: c */
    public final T mo7234c() {
        return this.f4377g != null ? this.f4377g : mo7233a(this.f4375a);
    }

    /* renamed from: d */
    public final T mo7235d() {
        long clearCallingIdentity = Binder.clearCallingIdentity();
        try {
            return mo7234c();
        } finally {
            Binder.restoreCallingIdentity(clearCallingIdentity);
        }
    }
}
