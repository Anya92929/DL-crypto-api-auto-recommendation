package com.google.android.gms.internal;

import android.os.RemoteException;
import com.google.ads.AdRequest;
import com.google.ads.mediation.MediationBannerAdapter;
import com.google.ads.mediation.MediationBannerListener;
import com.google.ads.mediation.MediationInterstitialAdapter;
import com.google.ads.mediation.MediationInterstitialListener;
import com.google.ads.mediation.MediationServerParameters;
import com.google.ads.mediation.NetworkExtras;

@C1130ez
/* renamed from: com.google.android.gms.internal.da */
public final class C1028da<NETWORK_EXTRAS extends NetworkExtras, SERVER_PARAMETERS extends MediationServerParameters> implements MediationBannerListener, MediationInterstitialListener {
    /* access modifiers changed from: private */

    /* renamed from: qF */
    public final C1019cv f3089qF;

    public C1028da(C1019cv cvVar) {
        this.f3089qF = cvVar;
    }

    public void onClick(MediationBannerAdapter<?, ?> mediationBannerAdapter) {
        C1229gs.m4675S("Adapter called onClick.");
        if (!C1228gr.m4673dt()) {
            C1229gs.m4679W("onClick must be called on the main UI thread.");
            C1228gr.f3776wC.post(new Runnable() {
                public void run() {
                    try {
                        C1028da.this.f3089qF.onAdClicked();
                    } catch (RemoteException e) {
                        C1229gs.m4683d("Could not call onAdClicked.", e);
                    }
                }
            });
            return;
        }
        try {
            this.f3089qF.onAdClicked();
        } catch (RemoteException e) {
            C1229gs.m4683d("Could not call onAdClicked.", e);
        }
    }

    public void onDismissScreen(MediationBannerAdapter<?, ?> mediationBannerAdapter) {
        C1229gs.m4675S("Adapter called onDismissScreen.");
        if (!C1228gr.m4673dt()) {
            C1229gs.m4679W("onDismissScreen must be called on the main UI thread.");
            C1228gr.f3776wC.post(new Runnable() {
                public void run() {
                    try {
                        C1028da.this.f3089qF.onAdClosed();
                    } catch (RemoteException e) {
                        C1229gs.m4683d("Could not call onAdClosed.", e);
                    }
                }
            });
            return;
        }
        try {
            this.f3089qF.onAdClosed();
        } catch (RemoteException e) {
            C1229gs.m4683d("Could not call onAdClosed.", e);
        }
    }

    public void onDismissScreen(MediationInterstitialAdapter<?, ?> mediationInterstitialAdapter) {
        C1229gs.m4675S("Adapter called onDismissScreen.");
        if (!C1228gr.m4673dt()) {
            C1229gs.m4679W("onDismissScreen must be called on the main UI thread.");
            C1228gr.f3776wC.post(new Runnable() {
                public void run() {
                    try {
                        C1028da.this.f3089qF.onAdClosed();
                    } catch (RemoteException e) {
                        C1229gs.m4683d("Could not call onAdClosed.", e);
                    }
                }
            });
            return;
        }
        try {
            this.f3089qF.onAdClosed();
        } catch (RemoteException e) {
            C1229gs.m4683d("Could not call onAdClosed.", e);
        }
    }

    public void onFailedToReceiveAd(MediationBannerAdapter<?, ?> mediationBannerAdapter, final AdRequest.ErrorCode errorCode) {
        C1229gs.m4675S("Adapter called onFailedToReceiveAd with error. " + errorCode);
        if (!C1228gr.m4673dt()) {
            C1229gs.m4679W("onFailedToReceiveAd must be called on the main UI thread.");
            C1228gr.f3776wC.post(new Runnable() {
                public void run() {
                    try {
                        C1028da.this.f3089qF.onAdFailedToLoad(C1040db.m4188a(errorCode));
                    } catch (RemoteException e) {
                        C1229gs.m4683d("Could not call onAdFailedToLoad.", e);
                    }
                }
            });
            return;
        }
        try {
            this.f3089qF.onAdFailedToLoad(C1040db.m4188a(errorCode));
        } catch (RemoteException e) {
            C1229gs.m4683d("Could not call onAdFailedToLoad.", e);
        }
    }

    public void onFailedToReceiveAd(MediationInterstitialAdapter<?, ?> mediationInterstitialAdapter, final AdRequest.ErrorCode errorCode) {
        C1229gs.m4675S("Adapter called onFailedToReceiveAd with error " + errorCode + ".");
        if (!C1228gr.m4673dt()) {
            C1229gs.m4679W("onFailedToReceiveAd must be called on the main UI thread.");
            C1228gr.f3776wC.post(new Runnable() {
                public void run() {
                    try {
                        C1028da.this.f3089qF.onAdFailedToLoad(C1040db.m4188a(errorCode));
                    } catch (RemoteException e) {
                        C1229gs.m4683d("Could not call onAdFailedToLoad.", e);
                    }
                }
            });
            return;
        }
        try {
            this.f3089qF.onAdFailedToLoad(C1040db.m4188a(errorCode));
        } catch (RemoteException e) {
            C1229gs.m4683d("Could not call onAdFailedToLoad.", e);
        }
    }

    public void onLeaveApplication(MediationBannerAdapter<?, ?> mediationBannerAdapter) {
        C1229gs.m4675S("Adapter called onLeaveApplication.");
        if (!C1228gr.m4673dt()) {
            C1229gs.m4679W("onLeaveApplication must be called on the main UI thread.");
            C1228gr.f3776wC.post(new Runnable() {
                public void run() {
                    try {
                        C1028da.this.f3089qF.onAdLeftApplication();
                    } catch (RemoteException e) {
                        C1229gs.m4683d("Could not call onAdLeftApplication.", e);
                    }
                }
            });
            return;
        }
        try {
            this.f3089qF.onAdLeftApplication();
        } catch (RemoteException e) {
            C1229gs.m4683d("Could not call onAdLeftApplication.", e);
        }
    }

    public void onLeaveApplication(MediationInterstitialAdapter<?, ?> mediationInterstitialAdapter) {
        C1229gs.m4675S("Adapter called onLeaveApplication.");
        if (!C1228gr.m4673dt()) {
            C1229gs.m4679W("onLeaveApplication must be called on the main UI thread.");
            C1228gr.f3776wC.post(new Runnable() {
                public void run() {
                    try {
                        C1028da.this.f3089qF.onAdLeftApplication();
                    } catch (RemoteException e) {
                        C1229gs.m4683d("Could not call onAdLeftApplication.", e);
                    }
                }
            });
            return;
        }
        try {
            this.f3089qF.onAdLeftApplication();
        } catch (RemoteException e) {
            C1229gs.m4683d("Could not call onAdLeftApplication.", e);
        }
    }

    public void onPresentScreen(MediationBannerAdapter<?, ?> mediationBannerAdapter) {
        C1229gs.m4675S("Adapter called onPresentScreen.");
        if (!C1228gr.m4673dt()) {
            C1229gs.m4679W("onPresentScreen must be called on the main UI thread.");
            C1228gr.f3776wC.post(new Runnable() {
                public void run() {
                    try {
                        C1028da.this.f3089qF.onAdOpened();
                    } catch (RemoteException e) {
                        C1229gs.m4683d("Could not call onAdOpened.", e);
                    }
                }
            });
            return;
        }
        try {
            this.f3089qF.onAdOpened();
        } catch (RemoteException e) {
            C1229gs.m4683d("Could not call onAdOpened.", e);
        }
    }

    public void onPresentScreen(MediationInterstitialAdapter<?, ?> mediationInterstitialAdapter) {
        C1229gs.m4675S("Adapter called onPresentScreen.");
        if (!C1228gr.m4673dt()) {
            C1229gs.m4679W("onPresentScreen must be called on the main UI thread.");
            C1228gr.f3776wC.post(new Runnable() {
                public void run() {
                    try {
                        C1028da.this.f3089qF.onAdOpened();
                    } catch (RemoteException e) {
                        C1229gs.m4683d("Could not call onAdOpened.", e);
                    }
                }
            });
            return;
        }
        try {
            this.f3089qF.onAdOpened();
        } catch (RemoteException e) {
            C1229gs.m4683d("Could not call onAdOpened.", e);
        }
    }

    public void onReceivedAd(MediationBannerAdapter<?, ?> mediationBannerAdapter) {
        C1229gs.m4675S("Adapter called onReceivedAd.");
        if (!C1228gr.m4673dt()) {
            C1229gs.m4679W("onReceivedAd must be called on the main UI thread.");
            C1228gr.f3776wC.post(new Runnable() {
                public void run() {
                    try {
                        C1028da.this.f3089qF.onAdLoaded();
                    } catch (RemoteException e) {
                        C1229gs.m4683d("Could not call onAdLoaded.", e);
                    }
                }
            });
            return;
        }
        try {
            this.f3089qF.onAdLoaded();
        } catch (RemoteException e) {
            C1229gs.m4683d("Could not call onAdLoaded.", e);
        }
    }

    public void onReceivedAd(MediationInterstitialAdapter<?, ?> mediationInterstitialAdapter) {
        C1229gs.m4675S("Adapter called onReceivedAd.");
        if (!C1228gr.m4673dt()) {
            C1229gs.m4679W("onReceivedAd must be called on the main UI thread.");
            C1228gr.f3776wC.post(new Runnable() {
                public void run() {
                    try {
                        C1028da.this.f3089qF.onAdLoaded();
                    } catch (RemoteException e) {
                        C1229gs.m4683d("Could not call onAdLoaded.", e);
                    }
                }
            });
            return;
        }
        try {
            this.f3089qF.onAdLoaded();
        } catch (RemoteException e) {
            C1229gs.m4683d("Could not call onAdLoaded.", e);
        }
    }
}
