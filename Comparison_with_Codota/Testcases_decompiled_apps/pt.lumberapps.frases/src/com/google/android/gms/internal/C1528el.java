package com.google.android.gms.internal;

import android.content.SharedPreferences;

/* renamed from: com.google.android.gms.internal.el */
final class C1528el extends zzcy {
    C1528el(int i, String str, Long l) {
        super(i, str, l, (C1526ej) null);
    }

    /* renamed from: b */
    public Long mo7230a(SharedPreferences sharedPreferences) {
        return Long.valueOf(sharedPreferences.getLong(getKey(), ((Long) zzjw()).longValue()));
    }
}
