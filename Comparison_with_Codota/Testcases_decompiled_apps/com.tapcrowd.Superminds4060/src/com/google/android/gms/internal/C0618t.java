package com.google.android.gms.internal;

import com.google.android.gms.ads.AdListener;
import com.google.android.gms.internal.C0199ab;

/* renamed from: com.google.android.gms.internal.t */
public final class C0618t extends C0199ab.C0200a {

    /* renamed from: dT */
    private final AdListener f1575dT;

    public C0618t(AdListener adListener) {
        this.f1575dT = adListener;
    }

    public void onAdClosed() {
        this.f1575dT.onAdClosed();
    }

    public void onAdFailedToLoad(int errorCode) {
        this.f1575dT.onAdFailedToLoad(errorCode);
    }

    public void onAdLeftApplication() {
        this.f1575dT.onAdLeftApplication();
    }

    public void onAdLoaded() {
        this.f1575dT.onAdLoaded();
    }

    public void onAdOpened() {
        this.f1575dT.onAdOpened();
    }
}
