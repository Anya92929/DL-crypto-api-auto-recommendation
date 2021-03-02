package com.google.android.gms.internal;

import android.content.SharedPreferences;

/* renamed from: com.google.android.gms.internal.em */
final class C1529em extends zzcy {
    C1529em(int i, String str, String str2) {
        super(i, str, str2, (C1526ej) null);
    }

    /* renamed from: b */
    public String mo7230a(SharedPreferences sharedPreferences) {
        return sharedPreferences.getString(getKey(), (String) zzjw());
    }
}
