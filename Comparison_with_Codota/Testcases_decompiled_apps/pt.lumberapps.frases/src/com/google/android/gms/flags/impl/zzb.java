package com.google.android.gms.flags.impl;

import android.content.Context;
import android.content.SharedPreferences;
import com.google.android.gms.internal.zzua;

public class zzb {

    /* renamed from: a */
    private static SharedPreferences f4801a = null;

    public static SharedPreferences zzn(Context context) {
        SharedPreferences sharedPreferences;
        synchronized (SharedPreferences.class) {
            if (f4801a == null) {
                f4801a = (SharedPreferences) zzua.zzb(new C1402e(context));
            }
            sharedPreferences = f4801a;
        }
        return sharedPreferences;
    }
}
