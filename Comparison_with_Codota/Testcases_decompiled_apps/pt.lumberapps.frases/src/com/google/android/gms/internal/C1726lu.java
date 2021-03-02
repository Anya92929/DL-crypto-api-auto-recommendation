package com.google.android.gms.internal;

import android.content.Context;
import android.content.SharedPreferences;

/* renamed from: com.google.android.gms.internal.lu */
final class C1726lu extends C1729lx {

    /* renamed from: a */
    final /* synthetic */ Context f5317a;

    /* renamed from: b */
    final /* synthetic */ boolean f5318b;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    C1726lu(Context context, boolean z) {
        super((C1718lm) null);
        this.f5317a = context;
        this.f5318b = z;
    }

    public void zzew() {
        SharedPreferences.Editor edit = zzkf.zzn(this.f5317a).edit();
        edit.putBoolean("content_url_opted_out", this.f5318b);
        edit.apply();
    }
}
