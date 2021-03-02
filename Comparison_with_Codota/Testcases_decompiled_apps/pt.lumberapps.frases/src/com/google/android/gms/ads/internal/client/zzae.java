package com.google.android.gms.ads.internal.client;

import android.content.Context;
import android.os.RemoteException;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.AdSize;
import com.google.android.gms.ads.Correlator;
import com.google.android.gms.ads.VideoController;
import com.google.android.gms.ads.VideoOptions;
import com.google.android.gms.ads.doubleclick.AppEventListener;
import com.google.android.gms.ads.doubleclick.OnCustomRenderedAdLoadedListener;
import com.google.android.gms.ads.internal.util.client.zzb;
import com.google.android.gms.ads.purchase.InAppPurchaseListener;
import com.google.android.gms.ads.purchase.PlayStorePurchaseListener;
import com.google.android.gms.dynamic.zzd;
import com.google.android.gms.dynamic.zze;
import com.google.android.gms.internal.zzdo;
import com.google.android.gms.internal.zzdp;
import com.google.android.gms.internal.zzgi;
import com.google.android.gms.internal.zzho;
import com.google.android.gms.internal.zzht;
import com.google.android.gms.internal.zzhx;
import com.google.android.gms.internal.zzin;
import java.util.concurrent.atomic.AtomicBoolean;

@zzin
public class zzae {

    /* renamed from: a */
    final zzo f3532a;

    /* renamed from: b */
    private final zzgi f3533b;

    /* renamed from: c */
    private final zzh f3534c;

    /* renamed from: d */
    private final AtomicBoolean f3535d;
    /* access modifiers changed from: private */

    /* renamed from: e */
    public final VideoController f3536e;

    /* renamed from: f */
    private zza f3537f;

    /* renamed from: g */
    private AdListener f3538g;

    /* renamed from: h */
    private AdSize[] f3539h;

    /* renamed from: i */
    private AppEventListener f3540i;

    /* renamed from: j */
    private Correlator f3541j;

    /* renamed from: k */
    private zzu f3542k;

    /* renamed from: l */
    private InAppPurchaseListener f3543l;

    /* renamed from: m */
    private OnCustomRenderedAdLoadedListener f3544m;

    /* renamed from: n */
    private PlayStorePurchaseListener f3545n;

    /* renamed from: o */
    private VideoOptions f3546o;

    /* renamed from: p */
    private String f3547p;

    /* renamed from: q */
    private String f3548q;

    /* renamed from: r */
    private ViewGroup f3549r;

    /* renamed from: s */
    private boolean f3550s;

    /* renamed from: t */
    private boolean f3551t;

    public zzae(ViewGroup viewGroup) {
        this(viewGroup, (AttributeSet) null, false, zzh.zzih(), false);
    }

    public zzae(ViewGroup viewGroup, AttributeSet attributeSet, boolean z) {
        this(viewGroup, attributeSet, z, zzh.zzih(), false);
    }

    zzae(ViewGroup viewGroup, AttributeSet attributeSet, boolean z, zzh zzh, zzu zzu, boolean z2) {
        this.f3533b = new zzgi();
        this.f3536e = new VideoController();
        this.f3532a = new C1231d(this);
        this.f3549r = viewGroup;
        this.f3534c = zzh;
        this.f3542k = zzu;
        this.f3535d = new AtomicBoolean(false);
        this.f3550s = z2;
        if (attributeSet != null) {
            Context context = viewGroup.getContext();
            try {
                zzk zzk = new zzk(context, attributeSet);
                this.f3539h = zzk.zzl(z);
                this.f3547p = zzk.getAdUnitId();
                if (viewGroup.isInEditMode()) {
                    zzm.zziw().zza(viewGroup, m5585a(context, this.f3539h[0], this.f3550s), "Ads by Google");
                }
            } catch (IllegalArgumentException e) {
                zzm.zziw().zza(viewGroup, new AdSizeParcel(context, AdSize.BANNER), e.getMessage(), e.getMessage());
            }
        }
    }

    zzae(ViewGroup viewGroup, AttributeSet attributeSet, boolean z, zzh zzh, boolean z2) {
        this(viewGroup, attributeSet, z, zzh, (zzu) null, z2);
    }

    public zzae(ViewGroup viewGroup, AttributeSet attributeSet, boolean z, boolean z2) {
        this(viewGroup, attributeSet, z, zzh.zzih(), z2);
    }

    public zzae(ViewGroup viewGroup, boolean z) {
        this(viewGroup, (AttributeSet) null, false, zzh.zzih(), z);
    }

    /* renamed from: a */
    private static AdSizeParcel m5585a(Context context, AdSize adSize, boolean z) {
        AdSizeParcel adSizeParcel = new AdSizeParcel(context, adSize);
        adSizeParcel.zzk(z);
        return adSizeParcel;
    }

    /* renamed from: a */
    private static AdSizeParcel m5586a(Context context, AdSize[] adSizeArr, boolean z) {
        AdSizeParcel adSizeParcel = new AdSizeParcel(context, adSizeArr);
        adSizeParcel.zzk(z);
        return adSizeParcel;
    }

    /* renamed from: c */
    private void m5587c() {
        try {
            zzd zzdm = this.f3542k.zzdm();
            if (zzdm != null) {
                this.f3549r.addView((View) zze.zzad(zzdm));
            }
        } catch (RemoteException e) {
            zzb.zzd("Failed to get an ad frame.", e);
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo5169a() {
        if ((this.f3539h == null || this.f3547p == null) && this.f3542k == null) {
            throw new IllegalStateException("The ad size and ad unit ID must be set before loadAd is called.");
        }
        this.f3542k = mo5170b();
        this.f3542k.zza((zzq) new zzc(this.f3532a));
        if (this.f3537f != null) {
            this.f3542k.zza((zzp) new zzb(this.f3537f));
        }
        if (this.f3540i != null) {
            this.f3542k.zza((zzw) new zzj(this.f3540i));
        }
        if (this.f3543l != null) {
            this.f3542k.zza((zzho) new zzht(this.f3543l));
        }
        if (this.f3545n != null) {
            this.f3542k.zza(new zzhx(this.f3545n), this.f3548q);
        }
        if (this.f3544m != null) {
            this.f3542k.zza((zzdo) new zzdp(this.f3544m));
        }
        if (this.f3541j != null) {
            this.f3542k.zza((zzy) this.f3541j.zzdd());
        }
        if (this.f3546o != null) {
            this.f3542k.zza(new VideoOptionsParcel(this.f3546o));
        }
        this.f3542k.setManualImpressionsEnabled(this.f3551t);
        m5587c();
    }

    /* access modifiers changed from: protected */
    /* renamed from: b */
    public zzu mo5170b() {
        Context context = this.f3549r.getContext();
        AdSizeParcel a = m5586a(context, this.f3539h, this.f3550s);
        return zzb(a) ? zzm.zzix().zza(context, a, this.f3547p) : zzm.zzix().zza(context, a, this.f3547p, this.f3533b);
    }

    public void destroy() {
        try {
            if (this.f3542k != null) {
                this.f3542k.destroy();
            }
        } catch (RemoteException e) {
            zzb.zzd("Failed to destroy AdView.", e);
        }
    }

    public AdListener getAdListener() {
        return this.f3538g;
    }

    public AdSize getAdSize() {
        AdSizeParcel zzdn;
        try {
            if (!(this.f3542k == null || (zzdn = this.f3542k.zzdn()) == null)) {
                return zzdn.zzij();
            }
        } catch (RemoteException e) {
            zzb.zzd("Failed to get the current AdSize.", e);
        }
        if (this.f3539h != null) {
            return this.f3539h[0];
        }
        return null;
    }

    public AdSize[] getAdSizes() {
        return this.f3539h;
    }

    public String getAdUnitId() {
        return this.f3547p;
    }

    public AppEventListener getAppEventListener() {
        return this.f3540i;
    }

    public InAppPurchaseListener getInAppPurchaseListener() {
        return this.f3543l;
    }

    public String getMediationAdapterClassName() {
        try {
            if (this.f3542k != null) {
                return this.f3542k.getMediationAdapterClassName();
            }
        } catch (RemoteException e) {
            zzb.zzd("Failed to get the mediation adapter class name.", e);
        }
        return null;
    }

    public OnCustomRenderedAdLoadedListener getOnCustomRenderedAdLoadedListener() {
        return this.f3544m;
    }

    public VideoController getVideoController() {
        return this.f3536e;
    }

    public VideoOptions getVideoOptions() {
        return this.f3546o;
    }

    public boolean isLoading() {
        try {
            if (this.f3542k != null) {
                return this.f3542k.isLoading();
            }
        } catch (RemoteException e) {
            zzb.zzd("Failed to check if ad is loading.", e);
        }
        return false;
    }

    public void pause() {
        try {
            if (this.f3542k != null) {
                this.f3542k.pause();
            }
        } catch (RemoteException e) {
            zzb.zzd("Failed to call pause.", e);
        }
    }

    public void recordManualImpression() {
        if (!this.f3535d.getAndSet(true)) {
            try {
                if (this.f3542k != null) {
                    this.f3542k.zzdp();
                }
            } catch (RemoteException e) {
                zzb.zzd("Failed to record impression.", e);
            }
        }
    }

    public void resume() {
        try {
            if (this.f3542k != null) {
                this.f3542k.resume();
            }
        } catch (RemoteException e) {
            zzb.zzd("Failed to call resume.", e);
        }
    }

    public void setAdListener(AdListener adListener) {
        this.f3538g = adListener;
        this.f3532a.zza(adListener);
    }

    public void setAdSizes(AdSize... adSizeArr) {
        if (this.f3539h != null) {
            throw new IllegalStateException("The ad size can only be set once on AdView.");
        }
        zza(adSizeArr);
    }

    public void setAdUnitId(String str) {
        if (this.f3547p != null) {
            throw new IllegalStateException("The ad unit ID can only be set once on AdView.");
        }
        this.f3547p = str;
    }

    public void setAppEventListener(AppEventListener appEventListener) {
        try {
            this.f3540i = appEventListener;
            if (this.f3542k != null) {
                this.f3542k.zza((zzw) appEventListener != null ? new zzj(appEventListener) : null);
            }
        } catch (RemoteException e) {
            zzb.zzd("Failed to set the AppEventListener.", e);
        }
    }

    public void setCorrelator(Correlator correlator) {
        this.f3541j = correlator;
        try {
            if (this.f3542k != null) {
                this.f3542k.zza((zzy) this.f3541j == null ? null : this.f3541j.zzdd());
            }
        } catch (RemoteException e) {
            zzb.zzd("Failed to set correlator.", e);
        }
    }

    public void setInAppPurchaseListener(InAppPurchaseListener inAppPurchaseListener) {
        if (this.f3545n != null) {
            throw new IllegalStateException("Play store purchase parameter has already been set.");
        }
        try {
            this.f3543l = inAppPurchaseListener;
            if (this.f3542k != null) {
                this.f3542k.zza((zzho) inAppPurchaseListener != null ? new zzht(inAppPurchaseListener) : null);
            }
        } catch (RemoteException e) {
            zzb.zzd("Failed to set the InAppPurchaseListener.", e);
        }
    }

    public void setManualImpressionsEnabled(boolean z) {
        this.f3551t = z;
        try {
            if (this.f3542k != null) {
                this.f3542k.setManualImpressionsEnabled(this.f3551t);
            }
        } catch (RemoteException e) {
            zzb.zzd("Failed to set manual impressions.", e);
        }
    }

    public void setOnCustomRenderedAdLoadedListener(OnCustomRenderedAdLoadedListener onCustomRenderedAdLoadedListener) {
        this.f3544m = onCustomRenderedAdLoadedListener;
        try {
            if (this.f3542k != null) {
                this.f3542k.zza((zzdo) onCustomRenderedAdLoadedListener != null ? new zzdp(onCustomRenderedAdLoadedListener) : null);
            }
        } catch (RemoteException e) {
            zzb.zzd("Failed to set the onCustomRenderedAdLoadedListener.", e);
        }
    }

    public void setPlayStorePurchaseParams(PlayStorePurchaseListener playStorePurchaseListener, String str) {
        if (this.f3543l != null) {
            throw new IllegalStateException("InAppPurchaseListener has already been set.");
        }
        try {
            this.f3545n = playStorePurchaseListener;
            this.f3548q = str;
            if (this.f3542k != null) {
                this.f3542k.zza(playStorePurchaseListener != null ? new zzhx(playStorePurchaseListener) : null, str);
            }
        } catch (RemoteException e) {
            zzb.zzd("Failed to set the play store purchase parameter.", e);
        }
    }

    public void setVideoOptions(VideoOptions videoOptions) {
        this.f3546o = videoOptions;
        try {
            if (this.f3542k != null) {
                this.f3542k.zza(videoOptions == null ? null : new VideoOptionsParcel(videoOptions));
            }
        } catch (RemoteException e) {
            zzb.zzd("Failed to set video options.", e);
        }
    }

    public void zza(zza zza) {
        try {
            this.f3537f = zza;
            if (this.f3542k != null) {
                this.f3542k.zza((zzp) zza != null ? new zzb(zza) : null);
            }
        } catch (RemoteException e) {
            zzb.zzd("Failed to set the AdClickListener.", e);
        }
    }

    public void zza(zzad zzad) {
        try {
            if (this.f3542k == null) {
                mo5169a();
            }
            if (this.f3542k.zzb(this.f3534c.zza(this.f3549r.getContext(), zzad))) {
                this.f3533b.zzh(zzad.zzjg());
            }
        } catch (RemoteException e) {
            zzb.zzd("Failed to load ad.", e);
        }
    }

    public void zza(AdSize... adSizeArr) {
        this.f3539h = adSizeArr;
        try {
            if (this.f3542k != null) {
                this.f3542k.zza(m5586a(this.f3549r.getContext(), this.f3539h, this.f3550s));
            }
        } catch (RemoteException e) {
            zzb.zzd("Failed to set the ad size.", e);
        }
        this.f3549r.requestLayout();
    }

    public boolean zzb(AdSizeParcel adSizeParcel) {
        return "search_v2".equals(adSizeParcel.zzaur);
    }

    public zzab zzjk() {
        if (this.f3542k == null) {
            return null;
        }
        try {
            return this.f3542k.zzdq();
        } catch (RemoteException e) {
            zzb.zzd("Failed to retrieve VideoController.", e);
            return null;
        }
    }
}
