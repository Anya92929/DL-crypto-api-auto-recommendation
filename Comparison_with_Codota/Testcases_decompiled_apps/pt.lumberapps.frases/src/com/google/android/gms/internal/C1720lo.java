package com.google.android.gms.internal;

import android.content.Context;
import android.content.SharedPreferences;

/* renamed from: com.google.android.gms.internal.lo */
final class C1720lo extends C1729lx {

    /* renamed from: a */
    final /* synthetic */ Context f5304a;

    /* renamed from: b */
    final /* synthetic */ boolean f5305b;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    C1720lo(Context context, boolean z) {
        super((C1718lm) null);
        this.f5304a = context;
        this.f5305b = z;
    }

    public void zzew() {
        SharedPreferences.Editor edit = zzkf.zzn(this.f5304a).edit();
        edit.putBoolean("auto_collect_location", this.f5305b);
        edit.apply();
    }
}
