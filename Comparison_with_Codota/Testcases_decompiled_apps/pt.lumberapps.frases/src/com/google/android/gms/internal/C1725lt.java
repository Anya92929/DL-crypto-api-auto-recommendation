package com.google.android.gms.internal;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import com.google.android.gms.internal.zzkf;

/* renamed from: com.google.android.gms.internal.lt */
final class C1725lt extends C1729lx {

    /* renamed from: a */
    final /* synthetic */ Context f5315a;

    /* renamed from: b */
    final /* synthetic */ zzkf.zzb f5316b;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    C1725lt(Context context, zzkf.zzb zzb) {
        super((C1718lm) null);
        this.f5315a = context;
        this.f5316b = zzb;
    }

    public void zzew() {
        SharedPreferences zzn = zzkf.zzn(this.f5315a);
        Bundle bundle = new Bundle();
        bundle.putInt("webview_cache_version", zzn.getInt("webview_cache_version", 0));
        if (this.f5316b != null) {
            this.f5316b.zzg(bundle);
        }
    }
}
