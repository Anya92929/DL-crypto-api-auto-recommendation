package com.google.android.gms.internal;

import android.os.RemoteException;
import com.google.ads.AdRequest;
import com.google.ads.mediation.MediationBannerAdapter;
import com.google.ads.mediation.MediationBannerListener;
import com.google.ads.mediation.MediationInterstitialAdapter;
import com.google.ads.mediation.MediationInterstitialListener;
import com.google.ads.mediation.MediationServerParameters;
import com.google.ads.mediation.NetworkExtras;

/* renamed from: com.google.android.gms.internal.ba */
public final class C0263ba<NETWORK_EXTRAS extends NetworkExtras, SERVER_PARAMETERS extends MediationServerParameters> implements MediationBannerListener, MediationInterstitialListener {
    /* access modifiers changed from: private */

    /* renamed from: ft */
    public final C0244ay f825ft;

    public C0263ba(C0244ay ayVar) {
        this.f825ft = ayVar;
    }

    public void onClick(MediationBannerAdapter<?, ?> mediationBannerAdapter) {
        C0344cn.m733m("Adapter called onClick.");
        if (!C0343cm.m726ar()) {
            C0344cn.m737q("onClick must be called on the main UI thread.");
            C0343cm.f1013hO.post(new Runnable() {
                public void run() {
                    try {
                        C0263ba.this.f825ft.mo4056y();
                    } catch (RemoteException e) {
                        C0344cn.m731b("Could not call onAdClicked.", e);
                    }
                }
            });
            return;
        }
        try {
            this.f825ft.mo4056y();
        } catch (RemoteException e) {
            C0344cn.m731b("Could not call onAdClicked.", e);
        }
    }

    public void onDismissScreen(MediationBannerAdapter<?, ?> mediationBannerAdapter) {
        C0344cn.m733m("Adapter called onDismissScreen.");
        if (!C0343cm.m726ar()) {
            C0344cn.m737q("onDismissScreen must be called on the main UI thread.");
            C0343cm.f1013hO.post(new Runnable() {
                public void run() {
                    try {
                        C0263ba.this.f825ft.onAdClosed();
                    } catch (RemoteException e) {
                        C0344cn.m731b("Could not call onAdClosed.", e);
                    }
                }
            });
            return;
        }
        try {
            this.f825ft.onAdClosed();
        } catch (RemoteException e) {
            C0344cn.m731b("Could not call onAdClosed.", e);
        }
    }

    public void onDismissScreen(MediationInterstitialAdapter<?, ?> mediationInterstitialAdapter) {
        C0344cn.m733m("Adapter called onDismissScreen.");
        if (!C0343cm.m726ar()) {
            C0344cn.m737q("onDismissScreen must be called on the main UI thread.");
            C0343cm.f1013hO.post(new Runnable() {
                public void run() {
                    try {
                        C0263ba.this.f825ft.onAdClosed();
                    } catch (RemoteException e) {
                        C0344cn.m731b("Could not call onAdClosed.", e);
                    }
                }
            });
            return;
        }
        try {
            this.f825ft.onAdClosed();
        } catch (RemoteException e) {
            C0344cn.m731b("Could not call onAdClosed.", e);
        }
    }

    public void onFailedToReceiveAd(MediationBannerAdapter<?, ?> mediationBannerAdapter, final AdRequest.ErrorCode errorCode) {
        C0344cn.m733m("Adapter called onFailedToReceiveAd with error. " + errorCode);
        if (!C0343cm.m726ar()) {
            C0344cn.m737q("onFailedToReceiveAd must be called on the main UI thread.");
            C0343cm.f1013hO.post(new Runnable() {
                public void run() {
                    try {
                        C0263ba.this.f825ft.onAdFailedToLoad(C0275bb.m554a(errorCode));
                    } catch (RemoteException e) {
                        C0344cn.m731b("Could not call onAdFailedToLoad.", e);
                    }
                }
            });
            return;
        }
        try {
            this.f825ft.onAdFailedToLoad(C0275bb.m554a(errorCode));
        } catch (RemoteException e) {
            C0344cn.m731b("Could not call onAdFailedToLoad.", e);
        }
    }

    public void onFailedToReceiveAd(MediationInterstitialAdapter<?, ?> mediationInterstitialAdapter, final AdRequest.ErrorCode errorCode) {
        C0344cn.m733m("Adapter called onFailedToReceiveAd with error " + errorCode + ".");
        if (!C0343cm.m726ar()) {
            C0344cn.m737q("onFailedToReceiveAd must be called on the main UI thread.");
            C0343cm.f1013hO.post(new Runnable() {
                public void run() {
                    try {
                        C0263ba.this.f825ft.onAdFailedToLoad(C0275bb.m554a(errorCode));
                    } catch (RemoteException e) {
                        C0344cn.m731b("Could not call onAdFailedToLoad.", e);
                    }
                }
            });
            return;
        }
        try {
            this.f825ft.onAdFailedToLoad(C0275bb.m554a(errorCode));
        } catch (RemoteException e) {
            C0344cn.m731b("Could not call onAdFailedToLoad.", e);
        }
    }

    public void onLeaveApplication(MediationBannerAdapter<?, ?> mediationBannerAdapter) {
        C0344cn.m733m("Adapter called onLeaveApplication.");
        if (!C0343cm.m726ar()) {
            C0344cn.m737q("onLeaveApplication must be called on the main UI thread.");
            C0343cm.f1013hO.post(new Runnable() {
                public void run() {
                    try {
                        C0263ba.this.f825ft.onAdLeftApplication();
                    } catch (RemoteException e) {
                        C0344cn.m731b("Could not call onAdLeftApplication.", e);
                    }
                }
            });
            return;
        }
        try {
            this.f825ft.onAdLeftApplication();
        } catch (RemoteException e) {
            C0344cn.m731b("Could not call onAdLeftApplication.", e);
        }
    }

    public void onLeaveApplication(MediationInterstitialAdapter<?, ?> mediationInterstitialAdapter) {
        C0344cn.m733m("Adapter called onLeaveApplication.");
        if (!C0343cm.m726ar()) {
            C0344cn.m737q("onLeaveApplication must be called on the main UI thread.");
            C0343cm.f1013hO.post(new Runnable() {
                public void run() {
                    try {
                        C0263ba.this.f825ft.onAdLeftApplication();
                    } catch (RemoteException e) {
                        C0344cn.m731b("Could not call onAdLeftApplication.", e);
                    }
                }
            });
            return;
        }
        try {
            this.f825ft.onAdLeftApplication();
        } catch (RemoteException e) {
            C0344cn.m731b("Could not call onAdLeftApplication.", e);
        }
    }

    public void onPresentScreen(MediationBannerAdapter<?, ?> mediationBannerAdapter) {
        C0344cn.m733m("Adapter called onPresentScreen.");
        if (!C0343cm.m726ar()) {
            C0344cn.m737q("onPresentScreen must be called on the main UI thread.");
            C0343cm.f1013hO.post(new Runnable() {
                public void run() {
                    try {
                        C0263ba.this.f825ft.onAdOpened();
                    } catch (RemoteException e) {
                        C0344cn.m731b("Could not call onAdOpened.", e);
                    }
                }
            });
            return;
        }
        try {
            this.f825ft.onAdOpened();
        } catch (RemoteException e) {
            C0344cn.m731b("Could not call onAdOpened.", e);
        }
    }

    public void onPresentScreen(MediationInterstitialAdapter<?, ?> mediationInterstitialAdapter) {
        C0344cn.m733m("Adapter called onPresentScreen.");
        if (!C0343cm.m726ar()) {
            C0344cn.m737q("onPresentScreen must be called on the main UI thread.");
            C0343cm.f1013hO.post(new Runnable() {
                public void run() {
                    try {
                        C0263ba.this.f825ft.onAdOpened();
                    } catch (RemoteException e) {
                        C0344cn.m731b("Could not call onAdOpened.", e);
                    }
                }
            });
            return;
        }
        try {
            this.f825ft.onAdOpened();
        } catch (RemoteException e) {
            C0344cn.m731b("Could not call onAdOpened.", e);
        }
    }

    public void onReceivedAd(MediationBannerAdapter<?, ?> mediationBannerAdapter) {
        C0344cn.m733m("Adapter called onReceivedAd.");
        if (!C0343cm.m726ar()) {
            C0344cn.m737q("onReceivedAd must be called on the main UI thread.");
            C0343cm.f1013hO.post(new Runnable() {
                public void run() {
                    try {
                        C0263ba.this.f825ft.onAdLoaded();
                    } catch (RemoteException e) {
                        C0344cn.m731b("Could not call onAdLoaded.", e);
                    }
                }
            });
            return;
        }
        try {
            this.f825ft.onAdLoaded();
        } catch (RemoteException e) {
            C0344cn.m731b("Could not call onAdLoaded.", e);
        }
    }

    public void onReceivedAd(MediationInterstitialAdapter<?, ?> mediationInterstitialAdapter) {
        C0344cn.m733m("Adapter called onReceivedAd.");
        if (!C0343cm.m726ar()) {
            C0344cn.m737q("onReceivedAd must be called on the main UI thread.");
            C0343cm.f1013hO.post(new Runnable() {
                public void run() {
                    try {
                        C0263ba.this.f825ft.onAdLoaded();
                    } catch (RemoteException e) {
                        C0344cn.m731b("Could not call onAdLoaded.", e);
                    }
                }
            });
            return;
        }
        try {
            this.f825ft.onAdLoaded();
        } catch (RemoteException e) {
            C0344cn.m731b("Could not call onAdLoaded.", e);
        }
    }
}
