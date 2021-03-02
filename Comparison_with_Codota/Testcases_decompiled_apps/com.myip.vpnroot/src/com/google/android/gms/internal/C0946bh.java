package com.google.android.gms.internal;

import android.content.Context;
import android.os.RemoteException;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.AdSize;
import com.google.android.gms.ads.doubleclick.AppEventListener;
import com.google.android.gms.ads.doubleclick.C0142b;
import com.google.android.gms.ads.doubleclick.PublisherAdView;
import com.google.android.gms.ads.purchase.InAppPurchaseListener;
import com.google.android.gms.ads.purchase.PlayStorePurchaseListener;
import com.google.android.gms.dynamic.C0594d;
import com.google.android.gms.dynamic.C0597e;

/* renamed from: com.google.android.gms.internal.bh */
public final class C0946bh {

    /* renamed from: nR */
    private AdListener f2867nR;

    /* renamed from: oA */
    private String f2868oA;

    /* renamed from: oB */
    private ViewGroup f2869oB;

    /* renamed from: oC */
    private InAppPurchaseListener f2870oC;

    /* renamed from: oD */
    private PlayStorePurchaseListener f2871oD;

    /* renamed from: oE */
    private C0142b f2872oE;

    /* renamed from: oi */
    private AppEventListener f2873oi;

    /* renamed from: oj */
    private AdSize[] f2874oj;

    /* renamed from: ok */
    private String f2875ok;

    /* renamed from: ox */
    private final C1012cs f2876ox;

    /* renamed from: oy */
    private final C0926ax f2877oy;

    /* renamed from: oz */
    private C0935bd f2878oz;

    public C0946bh(ViewGroup viewGroup) {
        this(viewGroup, (AttributeSet) null, false, C0926ax.m3911bb());
    }

    public C0946bh(ViewGroup viewGroup, AttributeSet attributeSet, boolean z) {
        this(viewGroup, attributeSet, z, C0926ax.m3911bb());
    }

    C0946bh(ViewGroup viewGroup, AttributeSet attributeSet, boolean z, C0926ax axVar) {
        this(viewGroup, attributeSet, z, axVar, (C0935bd) null);
    }

    C0946bh(ViewGroup viewGroup, AttributeSet attributeSet, boolean z, C0926ax axVar, C0935bd bdVar) {
        this.f2876ox = new C1012cs();
        this.f2869oB = viewGroup;
        this.f2877oy = axVar;
        if (attributeSet != null) {
            Context context = viewGroup.getContext();
            try {
                C0931bb bbVar = new C0931bb(context, attributeSet);
                this.f2874oj = bbVar.mo8031f(z);
                this.f2875ok = bbVar.getAdUnitId();
                if (viewGroup.isInEditMode()) {
                    C1228gr.m4669a(viewGroup, new C0927ay(context, this.f2874oj[0]), "Ads by Google");
                    return;
                }
            } catch (IllegalArgumentException e) {
                C1228gr.m4671a(viewGroup, new C0927ay(context, AdSize.BANNER), e.getMessage(), e.getMessage());
                return;
            }
        }
        this.f2878oz = bdVar;
    }

    /* renamed from: bh */
    private void m3977bh() {
        try {
            C0594d X = this.f2878oz.mo8036X();
            if (X != null) {
                this.f2869oB.addView((View) C0597e.m1742f(X));
            }
        } catch (RemoteException e) {
            C1229gs.m4683d("Failed to get an ad frame.", e);
        }
    }

    /* renamed from: bi */
    private void m3978bi() throws RemoteException {
        if ((this.f2874oj == null || this.f2875ok == null) && this.f2878oz == null) {
            throw new IllegalStateException("The ad size and ad unit ID must be set before loadAd is called.");
        }
        Context context = this.f2869oB.getContext();
        this.f2878oz = C0923au.m3904a(context, new C0927ay(context, this.f2874oj), this.f2875ok, this.f2876ox);
        if (this.f2867nR != null) {
            this.f2878oz.mo8039a((C0932bc) new C0922at(this.f2867nR));
        }
        if (this.f2873oi != null) {
            this.f2878oz.mo8040a((C0941bf) new C0930ba(this.f2873oi));
        }
        if (this.f2870oC != null) {
            this.f2878oz.mo8041a((C1095eh) new C1110em(this.f2870oC));
        }
        if (this.f2871oD != null) {
            this.f2878oz.mo8042a(new C1115eq(this.f2871oD), this.f2868oA);
        }
        if (this.f2872oE != null) {
            this.f2878oz.mo8043a((C1120et) new C1127ew(this.f2872oE, (PublisherAdView) this.f2869oB));
        }
        m3977bh();
    }

    /* renamed from: a */
    public void mo8090a(C0944bg bgVar) {
        try {
            if (this.f2878oz == null) {
                m3978bi();
            }
            if (this.f2878oz.mo8045a(this.f2877oy.mo8021a(this.f2869oB.getContext(), bgVar))) {
                this.f2876ox.mo8236d(bgVar.mo8064be());
            }
        } catch (RemoteException e) {
            C1229gs.m4683d("Failed to load ad.", e);
        }
    }

    /* renamed from: a */
    public void mo8091a(AdSize... adSizeArr) {
        this.f2874oj = adSizeArr;
        try {
            if (this.f2878oz != null) {
                this.f2878oz.mo8038a(new C0927ay(this.f2869oB.getContext(), this.f2874oj));
            }
        } catch (RemoteException e) {
            C1229gs.m4683d("Failed to set the ad size.", e);
        }
        this.f2869oB.requestLayout();
    }

    public void destroy() {
        try {
            if (this.f2878oz != null) {
                this.f2878oz.destroy();
            }
        } catch (RemoteException e) {
            C1229gs.m4683d("Failed to destroy AdView.", e);
        }
    }

    public AdListener getAdListener() {
        return this.f2867nR;
    }

    public AdSize getAdSize() {
        try {
            if (this.f2878oz != null) {
                return this.f2878oz.mo8037Y().mo8022bc();
            }
        } catch (RemoteException e) {
            C1229gs.m4683d("Failed to get the current AdSize.", e);
        }
        if (this.f2874oj != null) {
            return this.f2874oj[0];
        }
        return null;
    }

    public AdSize[] getAdSizes() {
        return this.f2874oj;
    }

    public String getAdUnitId() {
        return this.f2875ok;
    }

    public AppEventListener getAppEventListener() {
        return this.f2873oi;
    }

    public InAppPurchaseListener getInAppPurchaseListener() {
        return this.f2870oC;
    }

    public String getMediationAdapterClassName() {
        try {
            if (this.f2878oz != null) {
                return this.f2878oz.getMediationAdapterClassName();
            }
        } catch (RemoteException e) {
            C1229gs.m4683d("Failed to get the mediation adapter class name.", e);
        }
        return null;
    }

    public void pause() {
        try {
            if (this.f2878oz != null) {
                this.f2878oz.pause();
            }
        } catch (RemoteException e) {
            C1229gs.m4683d("Failed to call pause.", e);
        }
    }

    public void recordManualImpression() {
        try {
            if (this.f2878oz != null) {
                this.f2878oz.mo8046aj();
            }
        } catch (RemoteException e) {
            C1229gs.m4683d("Failed to record impression.", e);
        }
    }

    public void resume() {
        try {
            if (this.f2878oz != null) {
                this.f2878oz.resume();
            }
        } catch (RemoteException e) {
            C1229gs.m4683d("Failed to call resume.", e);
        }
    }

    public void setAdListener(AdListener adListener) {
        try {
            this.f2867nR = adListener;
            if (this.f2878oz != null) {
                this.f2878oz.mo8039a((C0932bc) adListener != null ? new C0922at(adListener) : null);
            }
        } catch (RemoteException e) {
            C1229gs.m4683d("Failed to set the AdListener.", e);
        }
    }

    public void setAdSizes(AdSize... adSizes) {
        if (this.f2874oj != null) {
            throw new IllegalStateException("The ad size can only be set once on AdView.");
        }
        mo8091a(adSizes);
    }

    public void setAdUnitId(String adUnitId) {
        if (this.f2875ok != null) {
            throw new IllegalStateException("The ad unit ID can only be set once on AdView.");
        }
        this.f2875ok = adUnitId;
    }

    public void setAppEventListener(AppEventListener appEventListener) {
        try {
            this.f2873oi = appEventListener;
            if (this.f2878oz != null) {
                this.f2878oz.mo8040a((C0941bf) appEventListener != null ? new C0930ba(appEventListener) : null);
            }
        } catch (RemoteException e) {
            C1229gs.m4683d("Failed to set the AppEventListener.", e);
        }
    }

    public void setInAppPurchaseListener(InAppPurchaseListener inAppPurchaseListener) {
        if (this.f2871oD != null) {
            throw new IllegalStateException("Play store purchase parameter has already been set.");
        }
        try {
            this.f2870oC = inAppPurchaseListener;
            if (this.f2878oz != null) {
                this.f2878oz.mo8041a((C1095eh) inAppPurchaseListener != null ? new C1110em(inAppPurchaseListener) : null);
            }
        } catch (RemoteException e) {
            C1229gs.m4683d("Failed to set the InAppPurchaseListener.", e);
        }
    }

    public void setPlayStorePurchaseParams(PlayStorePurchaseListener playStorePurchaseListener, String publicKey) {
        if (this.f2870oC != null) {
            throw new IllegalStateException("InAppPurchaseListener has already been set.");
        }
        try {
            this.f2871oD = playStorePurchaseListener;
            this.f2868oA = publicKey;
            if (this.f2878oz != null) {
                this.f2878oz.mo8042a(playStorePurchaseListener != null ? new C1115eq(playStorePurchaseListener) : null, publicKey);
            }
        } catch (RemoteException e) {
            C1229gs.m4683d("Failed to set the play store purchase parameter.", e);
        }
    }
}
