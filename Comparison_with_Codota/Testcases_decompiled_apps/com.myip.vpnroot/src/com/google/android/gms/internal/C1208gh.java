package com.google.android.gms.internal;

import android.content.Context;
import android.content.SharedPreferences;

@C1130ez
/* renamed from: com.google.android.gms.internal.gh */
public final class C1208gh {
    /* renamed from: a */
    public static void m4603a(Context context, boolean z) {
        SharedPreferences.Editor edit = m4604n(context).edit();
        edit.putBoolean("use_https", z);
        edit.commit();
    }

    /* renamed from: n */
    private static SharedPreferences m4604n(Context context) {
        return context.getSharedPreferences("admob", 0);
    }

    /* renamed from: o */
    public static boolean m4605o(Context context) {
        return m4604n(context).getBoolean("use_https", true);
    }
}
