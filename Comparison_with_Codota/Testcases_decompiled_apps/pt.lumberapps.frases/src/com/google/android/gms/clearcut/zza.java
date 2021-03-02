package com.google.android.gms.clearcut;

import android.content.Context;

public class zza {

    /* renamed from: a */
    private static int f4236a = -1;

    /* renamed from: pY */
    public static final zza f4237pY = new zza();

    protected zza() {
    }

    public int zzbk(Context context) {
        if (f4236a < 0) {
            f4236a = context.getSharedPreferences("bootCount", 0).getInt("bootCount", 1);
        }
        return f4236a;
    }
}
