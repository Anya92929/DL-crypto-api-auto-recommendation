package com.google.android.gms.ads;

import android.content.Context;
import android.os.RemoteException;
import com.google.android.gms.internal.C0199ab;
import com.google.android.gms.internal.C0202ac;
import com.google.android.gms.internal.C0208ae;
import com.google.android.gms.internal.C0237av;
import com.google.android.gms.internal.C0344cn;
import com.google.android.gms.internal.C0618t;
import com.google.android.gms.internal.C0619u;
import com.google.android.gms.internal.C0620v;
import com.google.android.gms.internal.C0622x;
import com.google.android.gms.internal.C0624z;

public final class InterstitialAd {

    /* renamed from: dS */
    private final C0237av f319dS = new C0237av();

    /* renamed from: dT */
    private AdListener f320dT;

    /* renamed from: dU */
    private C0202ac f321dU;

    /* renamed from: dV */
    private String f322dV;

    /* renamed from: dW */
    private C0132a f323dW;
    private final Context mContext;

    public InterstitialAd(Context context) {
        this.mContext = context;
    }

    /* renamed from: c */
    private void m202c(String str) throws RemoteException {
        if (this.f322dV == null) {
            m203d(str);
        }
        this.f321dU = C0619u.m1951a(this.mContext, new C0622x(), this.f322dV, this.f319dS);
        if (this.f320dT != null) {
            this.f321dU.mo4017a((C0199ab) new C0618t(this.f320dT));
        }
        if (this.f323dW != null) {
            this.f321dU.mo4018a((C0208ae) new C0624z(this.f323dW));
        }
    }

    /* renamed from: d */
    private void m203d(String str) {
        if (this.f321dU == null) {
            throw new IllegalStateException("The ad unit ID must be set on InterstitialAd before " + str + " is called.");
        }
    }

    public AdListener getAdListener() {
        return this.f320dT;
    }

    public String getAdUnitId() {
        return this.f322dV;
    }

    public boolean isLoaded() {
        try {
            if (this.f321dU == null) {
                return false;
            }
            return this.f321dU.isReady();
        } catch (RemoteException e) {
            C0344cn.m731b("Failed to check if ad is ready.", e);
            return false;
        }
    }

    public void loadAd(AdRequest adRequest) {
        try {
            if (this.f321dU == null) {
                m202c("loadAd");
            }
            if (this.f321dU.mo4019a(new C0620v(this.mContext, adRequest))) {
                this.f319dS.mo4061c(adRequest.mo3460v());
            }
        } catch (RemoteException e) {
            C0344cn.m731b("Failed to load ad.", e);
        }
    }

    public void setAdListener(AdListener adListener) {
        try {
            this.f320dT = adListener;
            if (this.f321dU != null) {
                this.f321dU.mo4017a((C0199ab) adListener != null ? new C0618t(adListener) : null);
            }
        } catch (RemoteException e) {
            C0344cn.m731b("Failed to set the AdListener.", e);
        }
    }

    public void setAdUnitId(String adUnitId) {
        if (this.f322dV != null) {
            throw new IllegalStateException("The ad unit ID can only be set once on InterstitialAd.");
        }
        this.f322dV = adUnitId;
    }

    public void show() {
        try {
            m203d("show");
            this.f321dU.showInterstitial();
        } catch (RemoteException e) {
            C0344cn.m731b("Failed to show interstitial.", e);
        }
    }
}
