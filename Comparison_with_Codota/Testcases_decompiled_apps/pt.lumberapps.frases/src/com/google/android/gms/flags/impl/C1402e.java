package com.google.android.gms.flags.impl;

import android.content.Context;
import android.content.SharedPreferences;
import java.util.concurrent.Callable;

/* renamed from: com.google.android.gms.flags.impl.e */
final class C1402e implements Callable {

    /* renamed from: a */
    final /* synthetic */ Context f4800a;

    C1402e(Context context) {
        this.f4800a = context;
    }

    /* renamed from: a */
    public SharedPreferences call() {
        return this.f4800a.getSharedPreferences("google_sdk_flags", 1);
    }
}
