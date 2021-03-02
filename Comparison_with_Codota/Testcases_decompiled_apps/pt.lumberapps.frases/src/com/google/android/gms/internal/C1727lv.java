package com.google.android.gms.internal;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import com.google.android.gms.internal.zzkf;

/* renamed from: com.google.android.gms.internal.lv */
final class C1727lv extends C1729lx {

    /* renamed from: a */
    final /* synthetic */ Context f5319a;

    /* renamed from: b */
    final /* synthetic */ zzkf.zzb f5320b;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    C1727lv(Context context, zzkf.zzb zzb) {
        super((C1718lm) null);
        this.f5319a = context;
        this.f5320b = zzb;
    }

    public void zzew() {
        SharedPreferences zzn = zzkf.zzn(this.f5319a);
        Bundle bundle = new Bundle();
        bundle.putBoolean("content_url_opted_out", zzn.getBoolean("content_url_opted_out", true));
        if (this.f5320b != null) {
            this.f5320b.zzg(bundle);
        }
    }
}
