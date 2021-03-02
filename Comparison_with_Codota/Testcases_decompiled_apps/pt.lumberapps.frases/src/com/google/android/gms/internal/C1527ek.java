package com.google.android.gms.internal;

import android.content.SharedPreferences;

/* renamed from: com.google.android.gms.internal.ek */
final class C1527ek extends zzcy {
    C1527ek(int i, String str, Integer num) {
        super(i, str, num, (C1526ej) null);
    }

    /* renamed from: b */
    public Integer mo7230a(SharedPreferences sharedPreferences) {
        return Integer.valueOf(sharedPreferences.getInt(getKey(), ((Integer) zzjw()).intValue()));
    }
}
