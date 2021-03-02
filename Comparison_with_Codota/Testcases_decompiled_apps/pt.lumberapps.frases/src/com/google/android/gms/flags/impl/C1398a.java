package com.google.android.gms.flags.impl;

import android.content.SharedPreferences;
import java.util.concurrent.Callable;

/* renamed from: com.google.android.gms.flags.impl.a */
final class C1398a implements Callable {

    /* renamed from: a */
    final /* synthetic */ SharedPreferences f4788a;

    /* renamed from: b */
    final /* synthetic */ String f4789b;

    /* renamed from: c */
    final /* synthetic */ Boolean f4790c;

    C1398a(SharedPreferences sharedPreferences, String str, Boolean bool) {
        this.f4788a = sharedPreferences;
        this.f4789b = str;
        this.f4790c = bool;
    }

    /* renamed from: a */
    public Boolean call() {
        return Boolean.valueOf(this.f4788a.getBoolean(this.f4789b, this.f4790c.booleanValue()));
    }
}
