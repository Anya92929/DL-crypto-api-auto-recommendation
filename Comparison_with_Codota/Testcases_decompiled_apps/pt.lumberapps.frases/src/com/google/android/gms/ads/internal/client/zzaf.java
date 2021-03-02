package com.google.android.gms.ads.internal.client;

import android.content.Context;
import android.os.RemoteException;
import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.Correlator;
import com.google.android.gms.ads.doubleclick.AppEventListener;
import com.google.android.gms.ads.doubleclick.OnCustomRenderedAdLoadedListener;
import com.google.android.gms.ads.doubleclick.PublisherInterstitialAd;
import com.google.android.gms.ads.internal.reward.client.zzd;
import com.google.android.gms.ads.internal.reward.client.zzg;
import com.google.android.gms.ads.internal.util.client.zzb;
import com.google.android.gms.ads.purchase.InAppPurchaseListener;
import com.google.android.gms.ads.purchase.PlayStorePurchaseListener;
import com.google.android.gms.ads.reward.RewardedVideoAdListener;
import com.google.android.gms.internal.zzdo;
import com.google.android.gms.internal.zzdp;
import com.google.android.gms.internal.zzgi;
import com.google.android.gms.internal.zzho;
import com.google.android.gms.internal.zzht;
import com.google.android.gms.internal.zzhx;
import com.google.android.gms.internal.zzin;

@zzin
public class zzaf {

    /* renamed from: a */
    private final zzgi f3552a;

    /* renamed from: b */
    private final Context f3553b;

    /* renamed from: c */
    private final zzh f3554c;

    /* renamed from: d */
    private AdListener f3555d;

    /* renamed from: e */
    private zza f3556e;

    /* renamed from: f */
    private zzu f3557f;

    /* renamed from: g */
    private String f3558g;

    /* renamed from: h */
    private String f3559h;

    /* renamed from: i */
    private AppEventListener f3560i;

    /* renamed from: j */
    private PlayStorePurchaseListener f3561j;

    /* renamed from: k */
    private InAppPurchaseListener f3562k;

    /* renamed from: l */
    private PublisherInterstitialAd f3563l;

    /* renamed from: m */
    private OnCustomRenderedAdLoadedListener f3564m;

    /* renamed from: n */
    private Correlator f3565n;

    /* renamed from: o */
    private RewardedVideoAdListener f3566o;

    /* renamed from: p */
    private boolean f3567p;

    public zzaf(Context context) {
        this(context, zzh.zzih(), (PublisherInterstitialAd) null);
    }

    public zzaf(Context context, PublisherInterstitialAd publisherInterstitialAd) {
        this(context, zzh.zzih(), publisherInterstitialAd);
    }

    public zzaf(Context context, zzh zzh, PublisherInterstitialAd publisherInterstitialAd) {
        this.f3552a = new zzgi();
        this.f3553b = context;
        this.f3554c = zzh;
        this.f3563l = publisherInterstitialAd;
    }

    /* renamed from: a */
    private void m5590a(String str) {
        if (this.f3558g == null) {
            m5591b(str);
        }
        this.f3557f = zzm.zzix().zzb(this.f3553b, this.f3567p ? AdSizeParcel.zzii() : new AdSizeParcel(), this.f3558g, this.f3552a);
        if (this.f3555d != null) {
            this.f3557f.zza((zzq) new zzc(this.f3555d));
        }
        if (this.f3556e != null) {
            this.f3557f.zza((zzp) new zzb(this.f3556e));
        }
        if (this.f3560i != null) {
            this.f3557f.zza((zzw) new zzj(this.f3560i));
        }
        if (this.f3562k != null) {
            this.f3557f.zza((zzho) new zzht(this.f3562k));
        }
        if (this.f3561j != null) {
            this.f3557f.zza(new zzhx(this.f3561j), this.f3559h);
        }
        if (this.f3564m != null) {
            this.f3557f.zza((zzdo) new zzdp(this.f3564m));
        }
        if (this.f3565n != null) {
            this.f3557f.zza((zzy) this.f3565n.zzdd());
        }
        if (this.f3566o != null) {
            this.f3557f.zza((zzd) new zzg(this.f3566o));
        }
    }

    /* renamed from: b */
    private void m5591b(String str) {
        if (this.f3557f == null) {
            throw new IllegalStateException(new StringBuilder(String.valueOf(str).length() + 63).append("The ad unit ID must be set on InterstitialAd before ").append(str).append(" is called.").toString());
        }
    }

    public AdListener getAdListener() {
        return this.f3555d;
    }

    public String getAdUnitId() {
        return this.f3558g;
    }

    public AppEventListener getAppEventListener() {
        return this.f3560i;
    }

    public InAppPurchaseListener getInAppPurchaseListener() {
        return this.f3562k;
    }

    public String getMediationAdapterClassName() {
        try {
            if (this.f3557f != null) {
                return this.f3557f.getMediationAdapterClassName();
            }
        } catch (RemoteException e) {
            zzb.zzd("Failed to get the mediation adapter class name.", e);
        }
        return null;
    }

    public OnCustomRenderedAdLoadedListener getOnCustomRenderedAdLoadedListener() {
        return this.f3564m;
    }

    public boolean isLoaded() {
        try {
            if (this.f3557f == null) {
                return false;
            }
            return this.f3557f.isReady();
        } catch (RemoteException e) {
            zzb.zzd("Failed to check if ad is ready.", e);
            return false;
        }
    }

    public boolean isLoading() {
        try {
            if (this.f3557f == null) {
                return false;
            }
            return this.f3557f.isLoading();
        } catch (RemoteException e) {
            zzb.zzd("Failed to check if ad is loading.", e);
            return false;
        }
    }

    public void setAdListener(AdListener adListener) {
        try {
            this.f3555d = adListener;
            if (this.f3557f != null) {
                this.f3557f.zza((zzq) adListener != null ? new zzc(adListener) : null);
            }
        } catch (RemoteException e) {
            zzb.zzd("Failed to set the AdListener.", e);
        }
    }

    public void setAdUnitId(String str) {
        if (this.f3558g != null) {
            throw new IllegalStateException("The ad unit ID can only be set once on InterstitialAd.");
        }
        this.f3558g = str;
    }

    public void setAppEventListener(AppEventListener appEventListener) {
        try {
            this.f3560i = appEventListener;
            if (this.f3557f != null) {
                this.f3557f.zza((zzw) appEventListener != null ? new zzj(appEventListener) : null);
            }
        } catch (RemoteException e) {
            zzb.zzd("Failed to set the AppEventListener.", e);
        }
    }

    public void setCorrelator(Correlator correlator) {
        this.f3565n = correlator;
        try {
            if (this.f3557f != null) {
                this.f3557f.zza((zzy) this.f3565n == null ? null : this.f3565n.zzdd());
            }
        } catch (RemoteException e) {
            zzb.zzd("Failed to set correlator.", e);
        }
    }

    public void setInAppPurchaseListener(InAppPurchaseListener inAppPurchaseListener) {
        if (this.f3561j != null) {
            throw new IllegalStateException("Play store purchase parameter has already been set.");
        }
        try {
            this.f3562k = inAppPurchaseListener;
            if (this.f3557f != null) {
                this.f3557f.zza((zzho) inAppPurchaseListener != null ? new zzht(inAppPurchaseListener) : null);
            }
        } catch (RemoteException e) {
            zzb.zzd("Failed to set the InAppPurchaseListener.", e);
        }
    }

    public void setOnCustomRenderedAdLoadedListener(OnCustomRenderedAdLoadedListener onCustomRenderedAdLoadedListener) {
        try {
            this.f3564m = onCustomRenderedAdLoadedListener;
            if (this.f3557f != null) {
                this.f3557f.zza((zzdo) onCustomRenderedAdLoadedListener != null ? new zzdp(onCustomRenderedAdLoadedListener) : null);
            }
        } catch (RemoteException e) {
            zzb.zzd("Failed to set the OnCustomRenderedAdLoadedListener.", e);
        }
    }

    public void setPlayStorePurchaseParams(PlayStorePurchaseListener playStorePurchaseListener, String str) {
        if (this.f3562k != null) {
            throw new IllegalStateException("In app purchase parameter has already been set.");
        }
        try {
            this.f3561j = playStorePurchaseListener;
            this.f3559h = str;
            if (this.f3557f != null) {
                this.f3557f.zza(playStorePurchaseListener != null ? new zzhx(playStorePurchaseListener) : null, str);
            }
        } catch (RemoteException e) {
            zzb.zzd("Failed to set the play store purchase parameter.", e);
        }
    }

    public void setRewardedVideoAdListener(RewardedVideoAdListener rewardedVideoAdListener) {
        try {
            this.f3566o = rewardedVideoAdListener;
            if (this.f3557f != null) {
                this.f3557f.zza((zzd) rewardedVideoAdListener != null ? new zzg(rewardedVideoAdListener) : null);
            }
        } catch (RemoteException e) {
            zzb.zzd("Failed to set the AdListener.", e);
        }
    }

    public void show() {
        try {
            m5591b("show");
            this.f3557f.showInterstitial();
        } catch (RemoteException e) {
            zzb.zzd("Failed to show interstitial.", e);
        }
    }

    public void zza(zza zza) {
        try {
            this.f3556e = zza;
            if (this.f3557f != null) {
                this.f3557f.zza((zzp) zza != null ? new zzb(zza) : null);
            }
        } catch (RemoteException e) {
            zzb.zzd("Failed to set the AdClickListener.", e);
        }
    }

    public void zza(zzad zzad) {
        try {
            if (this.f3557f == null) {
                m5590a("loadAd");
            }
            if (this.f3557f.zzb(this.f3554c.zza(this.f3553b, zzad))) {
                this.f3552a.zzh(zzad.zzjg());
            }
        } catch (RemoteException e) {
            zzb.zzd("Failed to load ad.", e);
        }
    }

    public void zzd(boolean z) {
        this.f3567p = z;
    }
}
