package com.google.android.gms.internal;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import com.google.android.gms.internal.zzkf;

/* renamed from: com.google.android.gms.internal.ln */
final class C1719ln extends C1729lx {

    /* renamed from: a */
    final /* synthetic */ Context f5302a;

    /* renamed from: b */
    final /* synthetic */ zzkf.zzb f5303b;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    C1719ln(Context context, zzkf.zzb zzb) {
        super((C1718lm) null);
        this.f5302a = context;
        this.f5303b = zzb;
    }

    public void zzew() {
        SharedPreferences zzn = zzkf.zzn(this.f5302a);
        Bundle bundle = new Bundle();
        bundle.putString("content_url_hashes", zzn.getString("content_url_hashes", ""));
        if (this.f5303b != null) {
            this.f5303b.zzg(bundle);
        }
    }
}
