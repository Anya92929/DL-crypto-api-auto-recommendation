package com.google.android.gms.flags.impl;

import android.content.SharedPreferences;
import java.util.concurrent.Callable;

/* renamed from: com.google.android.gms.flags.impl.d */
final class C1401d implements Callable {

    /* renamed from: a */
    final /* synthetic */ SharedPreferences f4797a;

    /* renamed from: b */
    final /* synthetic */ String f4798b;

    /* renamed from: c */
    final /* synthetic */ String f4799c;

    C1401d(SharedPreferences sharedPreferences, String str, String str2) {
        this.f4797a = sharedPreferences;
        this.f4798b = str;
        this.f4799c = str2;
    }

    /* renamed from: a */
    public String call() {
        return this.f4797a.getString(this.f4798b, this.f4799c);
    }
}
