package com.google.android.gms.clearcut;

import android.content.Context;

public class zza {

    /* renamed from: a */
    private static int f2564a = -1;
    public static final zza zzaeP = new zza();

    protected zza() {
    }

    public int zzah(Context context) {
        if (f2564a < 0) {
            f2564a = context.getSharedPreferences("bootCount", 0).getInt("bootCount", 1);
        }
        return f2564a;
    }
}
