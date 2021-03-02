package com.google.android.gms.internal;

import android.content.Context;
import android.content.SharedPreferences;

/* renamed from: com.google.android.gms.internal.lq */
final class C1722lq extends C1729lx {

    /* renamed from: a */
    final /* synthetic */ Context f5308a;

    /* renamed from: b */
    final /* synthetic */ String f5309b;

    /* renamed from: c */
    final /* synthetic */ long f5310c;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    C1722lq(Context context, String str, long j) {
        super((C1718lm) null);
        this.f5308a = context;
        this.f5309b = str;
        this.f5310c = j;
    }

    public void zzew() {
        SharedPreferences.Editor edit = zzkf.zzn(this.f5308a).edit();
        edit.putString("app_settings_json", this.f5309b);
        edit.putLong("app_settings_last_update_ms", this.f5310c);
        edit.apply();
    }
}
