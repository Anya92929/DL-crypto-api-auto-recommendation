package com.google.android.gms.ads.internal;

import com.google.android.gms.internal.zzep;
import com.google.android.gms.internal.zzft;
import com.google.android.gms.internal.zzkd;
import com.google.android.gms.internal.zzlh;
import java.util.Map;

/* renamed from: com.google.android.gms.ads.internal.e */
class C1255e implements zzep {

    /* renamed from: a */
    final /* synthetic */ zzc f3617a;

    C1255e(zzc zzc) {
        this.f3617a = zzc;
    }

    public void zza(zzlh zzlh, Map map) {
        if (this.f3617a.f4011f.zzapb != null) {
            this.f3617a.f4013h.zza(this.f3617a.f4011f.zzapa, this.f3617a.f4011f.zzapb, zzlh.getView(), (zzft) zzlh);
        } else {
            zzkd.zzcx("Request to enable ActiveView before adState is available.");
        }
    }
}
