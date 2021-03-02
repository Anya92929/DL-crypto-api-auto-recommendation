package com.google.ads;

import com.google.ads.AdRequest;
import com.google.ads.C0221g;
import com.google.ads.mediation.MediationInterstitialAdapter;
import com.google.ads.mediation.MediationInterstitialListener;
import com.google.ads.util.C0282a;
import com.google.ads.util.C0284b;

/* renamed from: com.google.ads.k */
class C0263k implements MediationInterstitialListener {

    /* renamed from: a */
    private final C0223h f610a;

    C0263k(C0223h hVar) {
        this.f610a = hVar;
    }

    public void onReceivedAd(MediationInterstitialAdapter<?, ?> adapter) {
        synchronized (this.f610a) {
            C0282a.m470a((Object) adapter, (Object) this.f610a.mo3420i());
            if (this.f610a.mo3414c()) {
                C0284b.m490e("Got an onReceivedAd() callback after loadAdTask is done from an interstitial adapter. Ignoring callback.");
            } else {
                this.f610a.mo3412a(true, C0221g.C0222a.AD);
            }
        }
    }

    public void onFailedToReceiveAd(MediationInterstitialAdapter<?, ?> adapter, AdRequest.ErrorCode error) {
        synchronized (this.f610a) {
            C0282a.m470a((Object) adapter, (Object) this.f610a.mo3420i());
            C0284b.m480a("Mediation adapter " + adapter.getClass().getName() + " failed to receive ad with error code: " + error);
            if (this.f610a.mo3414c()) {
                C0284b.m484b("Got an onFailedToReceiveAd() callback after loadAdTask is done from an interstitial adapter.  Ignoring callback.");
            } else {
                this.f610a.mo3412a(false, error == AdRequest.ErrorCode.NO_FILL ? C0221g.C0222a.NO_FILL : C0221g.C0222a.ERROR);
            }
        }
    }

    public void onPresentScreen(MediationInterstitialAdapter<?, ?> mediationInterstitialAdapter) {
        synchronized (this.f610a) {
            this.f610a.mo3421j().mo3386a(this.f610a);
        }
    }

    public void onDismissScreen(MediationInterstitialAdapter<?, ?> mediationInterstitialAdapter) {
        synchronized (this.f610a) {
            this.f610a.mo3421j().mo3391b(this.f610a);
        }
    }

    public void onLeaveApplication(MediationInterstitialAdapter<?, ?> mediationInterstitialAdapter) {
        synchronized (this.f610a) {
            this.f610a.mo3421j().mo3392c(this.f610a);
        }
    }
}
