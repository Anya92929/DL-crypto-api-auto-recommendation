package com.google.android.gms.flags.impl;

import android.content.Context;
import android.content.SharedPreferences;
import com.google.android.gms.internal.zzpl;
import java.util.concurrent.Callable;

public class zzb {

    /* renamed from: a */
    private static SharedPreferences f3160a = null;

    public static SharedPreferences zzw(final Context context) {
        SharedPreferences sharedPreferences;
        synchronized (SharedPreferences.class) {
            if (f3160a == null) {
                f3160a = (SharedPreferences) zzpl.zzb(new Callable<SharedPreferences>() {
                    /* renamed from: a */
                    public SharedPreferences call() {
                        return context.getSharedPreferences("google_sdk_flags", 1);
                    }
                });
            }
            sharedPreferences = f3160a;
        }
        return sharedPreferences;
    }
}
