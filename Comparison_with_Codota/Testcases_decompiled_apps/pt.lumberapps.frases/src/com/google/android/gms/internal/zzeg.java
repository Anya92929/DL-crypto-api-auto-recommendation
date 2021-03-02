package com.google.android.gms.internal;

import com.google.android.gms.ads.formats.NativeAppInstallAd;
import com.google.android.gms.internal.zzeb;

@zzin
public class zzeg extends zzeb.zza {

    /* renamed from: a */
    private final NativeAppInstallAd.OnAppInstallAdLoadedListener f6147a;

    public zzeg(NativeAppInstallAd.OnAppInstallAdLoadedListener onAppInstallAdLoadedListener) {
        this.f6147a = onAppInstallAdLoadedListener;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public zzdw mo8333a(zzdv zzdv) {
        return new zzdw(zzdv);
    }

    public void zza(zzdv zzdv) {
        this.f6147a.onAppInstallAdLoaded(mo8333a(zzdv));
    }
}
