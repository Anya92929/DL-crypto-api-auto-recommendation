package com.appbrain.p032a;

import android.content.SharedPreferences;
import com.appbrain.C0983ad;

/* renamed from: com.appbrain.a.fn */
public final class C0933fn implements C0983ad {

    /* renamed from: a */
    private final SharedPreferences f2448a;

    public C0933fn(SharedPreferences sharedPreferences) {
        this.f2448a = sharedPreferences;
    }

    /* renamed from: a */
    public final String mo3856a(String str) {
        return this.f2448a.getString(str, (String) null);
    }

    /* renamed from: a */
    public final String mo3857a(String str, String str2) {
        return this.f2448a.getString(str, str2);
    }
}
