package com.google.android.gms.internal;

import android.content.SharedPreferences;

/* renamed from: com.google.android.gms.internal.ej */
final class C1526ej extends zzcy {
    C1526ej(int i, String str, Boolean bool) {
        super(i, str, bool, (C1526ej) null);
    }

    /* renamed from: b */
    public Boolean mo7230a(SharedPreferences sharedPreferences) {
        return Boolean.valueOf(sharedPreferences.getBoolean(getKey(), ((Boolean) zzjw()).booleanValue()));
    }
}
