package com.google.android.gms.internal;

import android.os.RemoteException;
import com.google.android.gms.ads.mediation.MediationBannerAdapter;
import com.google.android.gms.ads.mediation.MediationBannerListener;
import com.google.android.gms.ads.mediation.MediationInterstitialAdapter;
import com.google.android.gms.ads.mediation.MediationInterstitialListener;
import com.google.android.gms.common.internal.C0348n;

@C1130ez
/* renamed from: com.google.android.gms.internal.cy */
public final class C1024cy implements MediationBannerListener, MediationInterstitialListener {

    /* renamed from: qF */
    private final C1019cv f3074qF;

    public C1024cy(C1019cv cvVar) {
        this.f3074qF = cvVar;
    }

    public void onAdClicked(MediationBannerAdapter adapter) {
        C0348n.m854aT("onAdClicked must be called on the main UI thread.");
        C1229gs.m4675S("Adapter called onAdClicked.");
        try {
            this.f3074qF.onAdClicked();
        } catch (RemoteException e) {
            C1229gs.m4683d("Could not call onAdClicked.", e);
        }
    }

    public void onAdClicked(MediationInterstitialAdapter adapter) {
        C0348n.m854aT("onAdClicked must be called on the main UI thread.");
        C1229gs.m4675S("Adapter called onAdClicked.");
        try {
            this.f3074qF.onAdClicked();
        } catch (RemoteException e) {
            C1229gs.m4683d("Could not call onAdClicked.", e);
        }
    }

    public void onAdClosed(MediationBannerAdapter adapter) {
        C0348n.m854aT("onAdClosed must be called on the main UI thread.");
        C1229gs.m4675S("Adapter called onAdClosed.");
        try {
            this.f3074qF.onAdClosed();
        } catch (RemoteException e) {
            C1229gs.m4683d("Could not call onAdClosed.", e);
        }
    }

    public void onAdClosed(MediationInterstitialAdapter adapter) {
        C0348n.m854aT("onAdClosed must be called on the main UI thread.");
        C1229gs.m4675S("Adapter called onAdClosed.");
        try {
            this.f3074qF.onAdClosed();
        } catch (RemoteException e) {
            C1229gs.m4683d("Could not call onAdClosed.", e);
        }
    }

    public void onAdFailedToLoad(MediationBannerAdapter adapter, int errorCode) {
        C0348n.m854aT("onAdFailedToLoad must be called on the main UI thread.");
        C1229gs.m4675S("Adapter called onAdFailedToLoad with error. " + errorCode);
        try {
            this.f3074qF.onAdFailedToLoad(errorCode);
        } catch (RemoteException e) {
            C1229gs.m4683d("Could not call onAdFailedToLoad.", e);
        }
    }

    public void onAdFailedToLoad(MediationInterstitialAdapter adapter, int errorCode) {
        C0348n.m854aT("onAdFailedToLoad must be called on the main UI thread.");
        C1229gs.m4675S("Adapter called onAdFailedToLoad with error " + errorCode + ".");
        try {
            this.f3074qF.onAdFailedToLoad(errorCode);
        } catch (RemoteException e) {
            C1229gs.m4683d("Could not call onAdFailedToLoad.", e);
        }
    }

    public void onAdLeftApplication(MediationBannerAdapter adapter) {
        C0348n.m854aT("onAdLeftApplication must be called on the main UI thread.");
        C1229gs.m4675S("Adapter called onAdLeftApplication.");
        try {
            this.f3074qF.onAdLeftApplication();
        } catch (RemoteException e) {
            C1229gs.m4683d("Could not call onAdLeftApplication.", e);
        }
    }

    public void onAdLeftApplication(MediationInterstitialAdapter adapter) {
        C0348n.m854aT("onAdLeftApplication must be called on the main UI thread.");
        C1229gs.m4675S("Adapter called onAdLeftApplication.");
        try {
            this.f3074qF.onAdLeftApplication();
        } catch (RemoteException e) {
            C1229gs.m4683d("Could not call onAdLeftApplication.", e);
        }
    }

    public void onAdLoaded(MediationBannerAdapter adapter) {
        C0348n.m854aT("onAdLoaded must be called on the main UI thread.");
        C1229gs.m4675S("Adapter called onAdLoaded.");
        try {
            this.f3074qF.onAdLoaded();
        } catch (RemoteException e) {
            C1229gs.m4683d("Could not call onAdLoaded.", e);
        }
    }

    public void onAdLoaded(MediationInterstitialAdapter adapter) {
        C0348n.m854aT("onAdLoaded must be called on the main UI thread.");
        C1229gs.m4675S("Adapter called onAdLoaded.");
        try {
            this.f3074qF.onAdLoaded();
        } catch (RemoteException e) {
            C1229gs.m4683d("Could not call onAdLoaded.", e);
        }
    }

    public void onAdOpened(MediationBannerAdapter adapter) {
        C0348n.m854aT("onAdOpened must be called on the main UI thread.");
        C1229gs.m4675S("Adapter called onAdOpened.");
        try {
            this.f3074qF.onAdOpened();
        } catch (RemoteException e) {
            C1229gs.m4683d("Could not call onAdOpened.", e);
        }
    }

    public void onAdOpened(MediationInterstitialAdapter adapter) {
        C0348n.m854aT("onAdOpened must be called on the main UI thread.");
        C1229gs.m4675S("Adapter called onAdOpened.");
        try {
            this.f3074qF.onAdOpened();
        } catch (RemoteException e) {
            C1229gs.m4683d("Could not call onAdOpened.", e);
        }
    }
}
