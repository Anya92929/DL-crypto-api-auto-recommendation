package com.google.android.gms.ads.internal.request;

import com.google.android.gms.ads.internal.request.zzc;
import com.google.android.gms.ads.internal.request.zzl;
import com.google.android.gms.internal.zzin;
import java.lang.ref.WeakReference;

@zzin
public final class zzg extends zzl.zza {

    /* renamed from: a */
    private final WeakReference f3954a;

    public zzg(zzc.zza zza) {
        this.f3954a = new WeakReference(zza);
    }

    public void zzb(AdResponseParcel adResponseParcel) {
        zzc.zza zza = (zzc.zza) this.f3954a.get();
        if (zza != null) {
            zza.zzb(adResponseParcel);
        }
    }
}
