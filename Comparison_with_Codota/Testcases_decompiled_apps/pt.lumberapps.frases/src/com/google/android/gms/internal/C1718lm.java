package com.google.android.gms.internal;

import android.content.Context;
import android.content.SharedPreferences;

/* renamed from: com.google.android.gms.internal.lm */
final class C1718lm extends C1729lx {

    /* renamed from: a */
    final /* synthetic */ Context f5300a;

    /* renamed from: b */
    final /* synthetic */ boolean f5301b;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    C1718lm(Context context, boolean z) {
        super((C1718lm) null);
        this.f5300a = context;
        this.f5301b = z;
    }

    public void zzew() {
        SharedPreferences.Editor edit = zzkf.zzn(this.f5300a).edit();
        edit.putBoolean("use_https", this.f5301b);
        edit.apply();
    }
}
