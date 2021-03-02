package com.google.android.gms.flags.impl;

import android.content.SharedPreferences;
import java.util.concurrent.Callable;

/* renamed from: com.google.android.gms.flags.impl.c */
final class C1400c implements Callable {

    /* renamed from: a */
    final /* synthetic */ SharedPreferences f4794a;

    /* renamed from: b */
    final /* synthetic */ String f4795b;

    /* renamed from: c */
    final /* synthetic */ Long f4796c;

    C1400c(SharedPreferences sharedPreferences, String str, Long l) {
        this.f4794a = sharedPreferences;
        this.f4795b = str;
        this.f4796c = l;
    }

    /* renamed from: a */
    public Long call() {
        return Long.valueOf(this.f4794a.getLong(this.f4795b, this.f4796c.longValue()));
    }
}
