package com.google.android.gms.ads.internal.client;

import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.internal.client.zzq;
import com.google.android.gms.internal.zzin;

@zzin
public final class zzc extends zzq.zza {

    /* renamed from: a */
    private final AdListener f3577a;

    public zzc(AdListener adListener) {
        this.f3577a = adListener;
    }

    public void onAdClosed() {
        this.f3577a.onAdClosed();
    }

    public void onAdFailedToLoad(int i) {
        this.f3577a.onAdFailedToLoad(i);
    }

    public void onAdLeftApplication() {
        this.f3577a.onAdLeftApplication();
    }

    public void onAdLoaded() {
        this.f3577a.onAdLoaded();
    }

    public void onAdOpened() {
        this.f3577a.onAdOpened();
    }
}
