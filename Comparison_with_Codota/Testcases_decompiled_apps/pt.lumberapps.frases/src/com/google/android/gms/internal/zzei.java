package com.google.android.gms.internal;

import com.google.android.gms.ads.formats.NativeCustomTemplateAd;
import com.google.android.gms.internal.zzed;

@zzin
public class zzei extends zzed.zza {

    /* renamed from: a */
    private final NativeCustomTemplateAd.OnCustomClickListener f6149a;

    public zzei(NativeCustomTemplateAd.OnCustomClickListener onCustomClickListener) {
        this.f6149a = onCustomClickListener;
    }

    public void zza(zzdz zzdz, String str) {
        this.f6149a.onCustomClick(new zzea(zzdz), str);
    }
}
