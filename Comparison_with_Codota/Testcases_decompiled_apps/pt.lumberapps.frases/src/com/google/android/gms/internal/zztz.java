package com.google.android.gms.internal;

public final class zztz {

    /* renamed from: a */
    private static zztz f7002a;

    /* renamed from: b */
    private final zztw f7003b = new zztw();

    /* renamed from: c */
    private final zztx f7004c = new zztx();

    static {
        m7562a(new zztz());
    }

    private zztz() {
    }

    /* renamed from: a */
    private static zztz m7561a() {
        zztz zztz;
        synchronized (zztz.class) {
            zztz = f7002a;
        }
        return zztz;
    }

    /* renamed from: a */
    protected static void m7562a(zztz zztz) {
        synchronized (zztz.class) {
            f7002a = zztz;
        }
    }

    public static zztw zzbet() {
        return m7561a().f7003b;
    }

    public static zztx zzbeu() {
        return m7561a().f7004c;
    }
}
