package com.google.android.gms.internal;

import com.google.android.gms.ads.formats.NativeCustomTemplateAd;
import com.google.android.gms.internal.zzee;

@zzin
public class zzej extends zzee.zza {

    /* renamed from: a */
    private final NativeCustomTemplateAd.OnCustomTemplateAdLoadedListener f6150a;

    public zzej(NativeCustomTemplateAd.OnCustomTemplateAdLoadedListener onCustomTemplateAdLoadedListener) {
        this.f6150a = onCustomTemplateAdLoadedListener;
    }

    public void zza(zzdz zzdz) {
        this.f6150a.onCustomTemplateAdLoaded(new zzea(zzdz));
    }
}
