package com.google.android.gms.ads.internal.client;

import com.google.android.gms.ads.AdListener;
import com.google.android.gms.internal.zzin;

@zzin
public class zzo extends AdListener {

    /* renamed from: a */
    private final Object f3614a = new Object();

    /* renamed from: b */
    private AdListener f3615b;

    public void onAdClosed() {
        synchronized (this.f3614a) {
            if (this.f3615b != null) {
                this.f3615b.onAdClosed();
            }
        }
    }

    public void onAdFailedToLoad(int i) {
        synchronized (this.f3614a) {
            if (this.f3615b != null) {
                this.f3615b.onAdFailedToLoad(i);
            }
        }
    }

    public void onAdLeftApplication() {
        synchronized (this.f3614a) {
            if (this.f3615b != null) {
                this.f3615b.onAdLeftApplication();
            }
        }
    }

    public void onAdLoaded() {
        synchronized (this.f3614a) {
            if (this.f3615b != null) {
                this.f3615b.onAdLoaded();
            }
        }
    }

    public void onAdOpened() {
        synchronized (this.f3614a) {
            if (this.f3615b != null) {
                this.f3615b.onAdOpened();
            }
        }
    }

    public void zza(AdListener adListener) {
        synchronized (this.f3614a) {
            this.f3615b = adListener;
        }
    }
}
