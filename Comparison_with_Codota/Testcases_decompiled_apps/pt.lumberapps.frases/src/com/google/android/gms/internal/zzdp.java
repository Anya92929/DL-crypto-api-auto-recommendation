package com.google.android.gms.internal;

import com.google.android.gms.ads.doubleclick.OnCustomRenderedAdLoadedListener;
import com.google.android.gms.internal.zzdo;

@zzin
public final class zzdp extends zzdo.zza {

    /* renamed from: a */
    private final OnCustomRenderedAdLoadedListener f6130a;

    public zzdp(OnCustomRenderedAdLoadedListener onCustomRenderedAdLoadedListener) {
        this.f6130a = onCustomRenderedAdLoadedListener;
    }

    public void zza(zzdn zzdn) {
        this.f6130a.onCustomRenderedAdLoaded(new zzdm(zzdn));
    }
}
