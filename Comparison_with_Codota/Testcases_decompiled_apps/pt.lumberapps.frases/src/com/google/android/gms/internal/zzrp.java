package com.google.android.gms.internal;

import android.content.Context;

public class zzrp {

    /* renamed from: b */
    private static zzrp f6976b = new zzrp();

    /* renamed from: a */
    private zzro f6977a = null;

    public static zzro zzcq(Context context) {
        return f6976b.zzcp(context);
    }

    public synchronized zzro zzcp(Context context) {
        if (this.f6977a == null) {
            if (context.getApplicationContext() != null) {
                context = context.getApplicationContext();
            }
            this.f6977a = new zzro(context);
        }
        return this.f6977a;
    }
}
