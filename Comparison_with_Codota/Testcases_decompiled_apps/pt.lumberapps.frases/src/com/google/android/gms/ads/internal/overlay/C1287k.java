package com.google.android.gms.ads.internal.overlay;

import android.graphics.Bitmap;
import com.google.android.gms.ads.internal.zzu;
import com.google.android.gms.internal.zzin;
import com.google.android.gms.internal.zzkc;
import com.google.android.gms.internal.zzkh;

@zzin
/* renamed from: com.google.android.gms.ads.internal.overlay.k */
class C1287k extends zzkc {

    /* renamed from: a */
    final /* synthetic */ zzd f3743a;

    private C1287k(zzd zzd) {
        this.f3743a = zzd;
    }

    /* synthetic */ C1287k(zzd zzd, C1284h hVar) {
        this(zzd);
    }

    public void onStop() {
    }

    public void zzew() {
        Bitmap zza = zzu.zzgh().zza(Integer.valueOf(this.f3743a.f3779b.zzbtv.zzamj));
        if (zza != null) {
            zzkh.zzclc.post(new C1288l(this, zzu.zzfs().zza(this.f3743a.f3792o, zza, this.f3743a.f3779b.zzbtv.zzamh, this.f3743a.f3779b.zzbtv.zzami)));
        }
    }
}
