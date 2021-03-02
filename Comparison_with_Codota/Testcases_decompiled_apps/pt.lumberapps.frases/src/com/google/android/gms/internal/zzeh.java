package com.google.android.gms.internal;

import com.google.android.gms.ads.formats.NativeContentAd;
import com.google.android.gms.internal.zzec;

@zzin
public class zzeh extends zzec.zza {

    /* renamed from: a */
    private final NativeContentAd.OnContentAdLoadedListener f6148a;

    public zzeh(NativeContentAd.OnContentAdLoadedListener onContentAdLoadedListener) {
        this.f6148a = onContentAdLoadedListener;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public zzdy mo8334a(zzdx zzdx) {
        return new zzdy(zzdx);
    }

    public void zza(zzdx zzdx) {
        this.f6148a.onContentAdLoaded(mo8334a(zzdx));
    }
}
