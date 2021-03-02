package com.google.android.gms.internal;

import com.google.android.gms.ads.AdListener;
import com.google.android.gms.internal.C0932bc;

@C1130ez
/* renamed from: com.google.android.gms.internal.at */
public final class C0922at extends C0932bc.C0933a {

    /* renamed from: nR */
    private final AdListener f2608nR;

    public C0922at(AdListener adListener) {
        this.f2608nR = adListener;
    }

    public void onAdClosed() {
        this.f2608nR.onAdClosed();
    }

    public void onAdFailedToLoad(int errorCode) {
        this.f2608nR.onAdFailedToLoad(errorCode);
    }

    public void onAdLeftApplication() {
        this.f2608nR.onAdLeftApplication();
    }

    public void onAdLoaded() {
        this.f2608nR.onAdLoaded();
    }

    public void onAdOpened() {
        this.f2608nR.onAdOpened();
    }
}
