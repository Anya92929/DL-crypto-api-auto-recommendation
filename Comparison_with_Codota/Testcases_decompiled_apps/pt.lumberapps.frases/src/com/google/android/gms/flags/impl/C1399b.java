package com.google.android.gms.flags.impl;

import android.content.SharedPreferences;
import java.util.concurrent.Callable;

/* renamed from: com.google.android.gms.flags.impl.b */
final class C1399b implements Callable {

    /* renamed from: a */
    final /* synthetic */ SharedPreferences f4791a;

    /* renamed from: b */
    final /* synthetic */ String f4792b;

    /* renamed from: c */
    final /* synthetic */ Integer f4793c;

    C1399b(SharedPreferences sharedPreferences, String str, Integer num) {
        this.f4791a = sharedPreferences;
        this.f4792b = str;
        this.f4793c = num;
    }

    /* renamed from: a */
    public Integer call() {
        return Integer.valueOf(this.f4791a.getInt(this.f4792b, this.f4793c.intValue()));
    }
}
