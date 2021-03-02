package com.google.android.gms.internal;

import android.content.Context;
import android.os.RemoteException;
import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.doubleclick.AppEventListener;
import com.google.android.gms.ads.doubleclick.C0143c;
import com.google.android.gms.ads.doubleclick.PublisherInterstitialAd;
import com.google.android.gms.ads.purchase.InAppPurchaseListener;
import com.google.android.gms.ads.purchase.PlayStorePurchaseListener;

/* renamed from: com.google.android.gms.internal.bi */
public class C0947bi {
    private final Context mContext;

    /* renamed from: nR */
    private AdListener f2879nR;

    /* renamed from: oA */
    private String f2880oA;

    /* renamed from: oC */
    private InAppPurchaseListener f2881oC;

    /* renamed from: oD */
    private PlayStorePurchaseListener f2882oD;

    /* renamed from: oF */
    private PublisherInterstitialAd f2883oF;

    /* renamed from: oG */
    private C0143c f2884oG;

    /* renamed from: oi */
    private AppEventListener f2885oi;

    /* renamed from: ok */
    private String f2886ok;

    /* renamed from: ox */
    private final C1012cs f2887ox;

    /* renamed from: oy */
    private final C0926ax f2888oy;

    /* renamed from: oz */
    private C0935bd f2889oz;

    public C0947bi(Context context) {
        this(context, C0926ax.m3911bb(), (PublisherInterstitialAd) null);
    }

    public C0947bi(Context context, PublisherInterstitialAd publisherInterstitialAd) {
        this(context, C0926ax.m3911bb(), publisherInterstitialAd);
    }

    public C0947bi(Context context, C0926ax axVar, PublisherInterstitialAd publisherInterstitialAd) {
        this.f2887ox = new C1012cs();
        this.mContext = context;
        this.f2888oy = axVar;
        this.f2883oF = publisherInterstitialAd;
    }

    /* renamed from: v */
    private void m3981v(String str) throws RemoteException {
        if (this.f2886ok == null) {
            m3982w(str);
        }
        this.f2889oz = C0923au.m3904a(this.mContext, new C0927ay(), this.f2886ok, this.f2887ox);
        if (this.f2879nR != null) {
            this.f2889oz.mo8039a((C0932bc) new C0922at(this.f2879nR));
        }
        if (this.f2885oi != null) {
            this.f2889oz.mo8040a((C0941bf) new C0930ba(this.f2885oi));
        }
        if (this.f2881oC != null) {
            this.f2889oz.mo8041a((C1095eh) new C1110em(this.f2881oC));
        }
        if (this.f2882oD != null) {
            this.f2889oz.mo8042a(new C1115eq(this.f2882oD), this.f2880oA);
        }
        if (this.f2884oG != null) {
            this.f2889oz.mo8044a((C1123eu) new C1128ex(this.f2884oG, this.f2883oF));
        }
    }

    /* renamed from: w */
    private void m3982w(String str) {
        if (this.f2889oz == null) {
            throw new IllegalStateException("The ad unit ID must be set on InterstitialAd before " + str + " is called.");
        }
    }

    /* renamed from: a */
    public void mo8109a(C0944bg bgVar) {
        try {
            if (this.f2889oz == null) {
                m3981v("loadAd");
            }
            if (this.f2889oz.mo8045a(this.f2888oy.mo8021a(this.mContext, bgVar))) {
                this.f2887ox.mo8236d(bgVar.mo8064be());
            }
        } catch (RemoteException e) {
            C1229gs.m4683d("Failed to load ad.", e);
        }
    }

    public AdListener getAdListener() {
        return this.f2879nR;
    }

    public String getAdUnitId() {
        return this.f2886ok;
    }

    public AppEventListener getAppEventListener() {
        return this.f2885oi;
    }

    public InAppPurchaseListener getInAppPurchaseListener() {
        return this.f2881oC;
    }

    public String getMediationAdapterClassName() {
        try {
            if (this.f2889oz != null) {
                return this.f2889oz.getMediationAdapterClassName();
            }
        } catch (RemoteException e) {
            C1229gs.m4683d("Failed to get the mediation adapter class name.", e);
        }
        return null;
    }

    public boolean isLoaded() {
        try {
            if (this.f2889oz == null) {
                return false;
            }
            return this.f2889oz.isReady();
        } catch (RemoteException e) {
            C1229gs.m4683d("Failed to check if ad is ready.", e);
            return false;
        }
    }

    public void setAdListener(AdListener adListener) {
        try {
            this.f2879nR = adListener;
            if (this.f2889oz != null) {
                this.f2889oz.mo8039a((C0932bc) adListener != null ? new C0922at(adListener) : null);
            }
        } catch (RemoteException e) {
            C1229gs.m4683d("Failed to set the AdListener.", e);
        }
    }

    public void setAdUnitId(String adUnitId) {
        if (this.f2886ok != null) {
            throw new IllegalStateException("The ad unit ID can only be set once on InterstitialAd.");
        }
        this.f2886ok = adUnitId;
    }

    public void setAppEventListener(AppEventListener appEventListener) {
        try {
            this.f2885oi = appEventListener;
            if (this.f2889oz != null) {
                this.f2889oz.mo8040a((C0941bf) appEventListener != null ? new C0930ba(appEventListener) : null);
            }
        } catch (RemoteException e) {
            C1229gs.m4683d("Failed to set the AppEventListener.", e);
        }
    }

    public void setInAppPurchaseListener(InAppPurchaseListener inAppPurchaseListener) {
        if (this.f2882oD != null) {
            throw new IllegalStateException("Play store purchase parameter has already been set.");
        }
        try {
            this.f2881oC = inAppPurchaseListener;
            if (this.f2889oz != null) {
                this.f2889oz.mo8041a((C1095eh) inAppPurchaseListener != null ? new C1110em(inAppPurchaseListener) : null);
            }
        } catch (RemoteException e) {
            C1229gs.m4683d("Failed to set the InAppPurchaseListener.", e);
        }
    }

    public void setPlayStorePurchaseParams(PlayStorePurchaseListener playStorePurchaseListener, String publicKey) {
        try {
            this.f2882oD = playStorePurchaseListener;
            if (this.f2889oz != null) {
                this.f2889oz.mo8042a(playStorePurchaseListener != null ? new C1115eq(playStorePurchaseListener) : null, publicKey);
            }
        } catch (RemoteException e) {
            C1229gs.m4683d("Failed to set the play store purchase parameter.", e);
        }
    }

    public void show() {
        try {
            m3982w("show");
            this.f2889oz.showInterstitial();
        } catch (RemoteException e) {
            C1229gs.m4683d("Failed to show interstitial.", e);
        }
    }
}
