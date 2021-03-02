package com.google.android.gms.internal;

import android.content.Context;
import android.content.SharedPreferences;

/* renamed from: com.google.android.gms.internal.lw */
final class C1728lw extends C1729lx {

    /* renamed from: a */
    final /* synthetic */ Context f5321a;

    /* renamed from: b */
    final /* synthetic */ String f5322b;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    C1728lw(Context context, String str) {
        super((C1718lm) null);
        this.f5321a = context;
        this.f5322b = str;
    }

    public void zzew() {
        SharedPreferences.Editor edit = zzkf.zzn(this.f5321a).edit();
        edit.putString("content_url_hashes", this.f5322b);
        edit.apply();
    }
}
