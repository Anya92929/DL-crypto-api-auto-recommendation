package com.google.android.gms.internal;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import com.google.android.gms.internal.zzkf;

/* renamed from: com.google.android.gms.internal.lr */
final class C1723lr extends C1729lx {

    /* renamed from: a */
    final /* synthetic */ Context f5311a;

    /* renamed from: b */
    final /* synthetic */ zzkf.zzb f5312b;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    C1723lr(Context context, zzkf.zzb zzb) {
        super((C1718lm) null);
        this.f5311a = context;
        this.f5312b = zzb;
    }

    public void zzew() {
        SharedPreferences zzn = zzkf.zzn(this.f5311a);
        Bundle bundle = new Bundle();
        bundle.putString("app_settings_json", zzn.getString("app_settings_json", ""));
        bundle.putLong("app_settings_last_update_ms", zzn.getLong("app_settings_last_update_ms", 0));
        if (this.f5312b != null) {
            this.f5312b.zzg(bundle);
        }
    }
}
