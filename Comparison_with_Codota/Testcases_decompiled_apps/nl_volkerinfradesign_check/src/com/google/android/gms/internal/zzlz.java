package com.google.android.gms.internal;

import android.os.Binder;

public abstract class zzlz<T> {

    /* renamed from: a */
    private static final Object f3183a = new Object();
    /* access modifiers changed from: private */

    /* renamed from: b */
    public static C0781a f3184b = null;

    /* renamed from: c */
    private static int f3185c = 0;

    /* renamed from: d */
    private static String f3186d = "com.google.android.providers.gsf.permission.READ_GSERVICES";

    /* renamed from: e */
    private T f3187e = null;
    protected final String zzvs;
    protected final T zzvt;

    /* renamed from: com.google.android.gms.internal.zzlz$a */
    interface C0781a {
        /* renamed from: a */
        Boolean mo5889a(String str, Boolean bool);

        /* renamed from: a */
        Float mo5890a(String str, Float f);

        /* renamed from: a */
        Integer mo5891a(String str, Integer num);

        /* renamed from: a */
        Long mo5892a(String str, Long l);

        /* renamed from: a */
        String mo5893a(String str, String str2);
    }

    protected zzlz(String str, T t) {
        this.zzvs = str;
        this.zzvt = t;
    }

    public static boolean isInitialized() {
        return f3184b != null;
    }

    public static zzlz<Float> zza(String str, Float f) {
        return new zzlz<Float>(str, f) {
            /* access modifiers changed from: protected */
            /* renamed from: a */
            public Float zzct(String str) {
                return zzlz.f3184b.mo5890a(this.zzvs, (Float) this.zzvt);
            }
        };
    }

    public static zzlz<Integer> zza(String str, Integer num) {
        return new zzlz<Integer>(str, num) {
            /* access modifiers changed from: protected */
            /* renamed from: a */
            public Integer zzct(String str) {
                return zzlz.f3184b.mo5891a(this.zzvs, (Integer) this.zzvt);
            }
        };
    }

    public static zzlz<Long> zza(String str, Long l) {
        return new zzlz<Long>(str, l) {
            /* access modifiers changed from: protected */
            /* renamed from: a */
            public Long zzct(String str) {
                return zzlz.f3184b.mo5892a(this.zzvs, (Long) this.zzvt);
            }
        };
    }

    public static zzlz<Boolean> zzk(String str, boolean z) {
        return new zzlz<Boolean>(str, Boolean.valueOf(z)) {
            /* access modifiers changed from: protected */
            /* renamed from: a */
            public Boolean zzct(String str) {
                return zzlz.f3184b.mo5889a(this.zzvs, (Boolean) this.zzvt);
            }
        };
    }

    public static int zzpW() {
        return f3185c;
    }

    public static zzlz<String> zzv(String str, String str2) {
        return new zzlz<String>(str, str2) {
            /* access modifiers changed from: protected */
            /* renamed from: a */
            public String zzct(String str) {
                return zzlz.f3184b.mo5893a(this.zzvs, (String) this.zzvt);
            }
        };
    }

    public final T get() {
        return this.f3187e != null ? this.f3187e : zzct(this.zzvs);
    }

    /* access modifiers changed from: protected */
    public abstract T zzct(String str);

    public final T zzpX() {
        long clearCallingIdentity = Binder.clearCallingIdentity();
        try {
            return get();
        } finally {
            Binder.restoreCallingIdentity(clearCallingIdentity);
        }
    }
}
