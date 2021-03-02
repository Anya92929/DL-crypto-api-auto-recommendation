package com.google.android.gms.internal;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import com.google.android.gms.internal.zzkf;

/* renamed from: com.google.android.gms.internal.ls */
final class C1724ls extends C1729lx {

    /* renamed from: a */
    final /* synthetic */ Context f5313a;

    /* renamed from: b */
    final /* synthetic */ zzkf.zzb f5314b;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    C1724ls(Context context, zzkf.zzb zzb) {
        super((C1718lm) null);
        this.f5313a = context;
        this.f5314b = zzb;
    }

    public void zzew() {
        SharedPreferences zzn = zzkf.zzn(this.f5313a);
        Bundle bundle = new Bundle();
        bundle.putBoolean("use_https", zzn.getBoolean("use_https", true));
        if (this.f5314b != null) {
            this.f5314b.zzg(bundle);
        }
    }
}
