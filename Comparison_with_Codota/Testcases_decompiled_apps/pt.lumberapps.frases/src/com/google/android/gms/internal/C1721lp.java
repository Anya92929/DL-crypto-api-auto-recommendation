package com.google.android.gms.internal;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import com.google.android.gms.internal.zzkf;

/* renamed from: com.google.android.gms.internal.lp */
final class C1721lp extends C1729lx {

    /* renamed from: a */
    final /* synthetic */ Context f5306a;

    /* renamed from: b */
    final /* synthetic */ zzkf.zzb f5307b;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    C1721lp(Context context, zzkf.zzb zzb) {
        super((C1718lm) null);
        this.f5306a = context;
        this.f5307b = zzb;
    }

    public void zzew() {
        SharedPreferences zzn = zzkf.zzn(this.f5306a);
        Bundle bundle = new Bundle();
        bundle.putBoolean("auto_collect_location", zzn.getBoolean("auto_collect_location", false));
        if (this.f5307b != null) {
            this.f5307b.zzg(bundle);
        }
    }
}
