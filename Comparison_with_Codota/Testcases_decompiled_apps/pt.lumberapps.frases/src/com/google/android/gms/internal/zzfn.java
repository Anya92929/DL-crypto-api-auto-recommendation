package com.google.android.gms.internal;

import android.content.Context;
import android.os.Bundle;
import com.google.android.gms.ads.internal.client.AdRequestParcel;
import com.google.android.gms.ads.internal.client.AdSizeParcel;
import com.google.android.gms.ads.internal.client.VideoOptionsParcel;
import com.google.android.gms.ads.internal.client.zzab;
import com.google.android.gms.ads.internal.client.zzp;
import com.google.android.gms.ads.internal.client.zzq;
import com.google.android.gms.ads.internal.client.zzu;
import com.google.android.gms.ads.internal.client.zzw;
import com.google.android.gms.ads.internal.client.zzy;
import com.google.android.gms.ads.internal.util.client.VersionInfoParcel;
import com.google.android.gms.ads.internal.zzd;
import com.google.android.gms.ads.internal.zzl;

@zzin
public class zzfn extends zzu.zza {

    /* renamed from: a */
    private String f6186a;

    /* renamed from: b */
    private zzfh f6187b;

    /* renamed from: c */
    private zzl f6188c;

    /* renamed from: d */
    private C1601hd f6189d;

    /* renamed from: e */
    private zzhs f6190e;

    /* renamed from: f */
    private String f6191f;

    public zzfn(Context context, String str, zzgj zzgj, VersionInfoParcel versionInfoParcel, zzd zzd) {
        this(str, new zzfh(context, zzgj, versionInfoParcel, zzd));
    }

    zzfn(String str, zzfh zzfh) {
        this.f6186a = str;
        this.f6187b = zzfh;
        this.f6189d = new C1601hd();
        com.google.android.gms.ads.internal.zzu.zzgb().mo8371a(zzfh);
    }

    /* renamed from: a */
    static boolean m7047a(AdRequestParcel adRequestParcel) {
        Bundle a = zzfk.m7031a(adRequestParcel);
        return a != null && a.containsKey("gw");
    }

    /* renamed from: b */
    private void m7048b() {
        if (this.f6188c != null && this.f6190e != null) {
            this.f6188c.zza(this.f6190e, this.f6191f);
        }
    }

    /* renamed from: b */
    static boolean m7049b(AdRequestParcel adRequestParcel) {
        Bundle a = zzfk.m7031a(adRequestParcel);
        return a != null && a.containsKey("_ad");
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo8376a() {
        if (this.f6188c == null) {
            this.f6188c = this.f6187b.zzbc(this.f6186a);
            this.f6189d.mo7290a(this.f6188c);
            m7048b();
        }
    }

    public void destroy() {
        if (this.f6188c != null) {
            this.f6188c.destroy();
        }
    }

    public String getMediationAdapterClassName() {
        if (this.f6188c != null) {
            return this.f6188c.getMediationAdapterClassName();
        }
        return null;
    }

    public boolean isLoading() {
        return this.f6188c != null && this.f6188c.isLoading();
    }

    public boolean isReady() {
        return this.f6188c != null && this.f6188c.isReady();
    }

    public void pause() {
        if (this.f6188c != null) {
            this.f6188c.pause();
        }
    }

    public void resume() {
        if (this.f6188c != null) {
            this.f6188c.resume();
        }
    }

    public void setManualImpressionsEnabled(boolean z) {
        mo8376a();
        if (this.f6188c != null) {
            this.f6188c.setManualImpressionsEnabled(z);
        }
    }

    public void setUserId(String str) {
    }

    public void showInterstitial() {
        if (this.f6188c != null) {
            this.f6188c.showInterstitial();
        } else {
            zzkd.zzcx("Interstitial ad must be loaded before showInterstitial().");
        }
    }

    public void stopLoading() {
        if (this.f6188c != null) {
            this.f6188c.stopLoading();
        }
    }

    public void zza(AdSizeParcel adSizeParcel) {
        if (this.f6188c != null) {
            this.f6188c.zza(adSizeParcel);
        }
    }

    public void zza(VideoOptionsParcel videoOptionsParcel) {
        throw new IllegalStateException("getVideoController not implemented for interstitials");
    }

    public void zza(zzp zzp) {
        this.f6189d.f5066e = zzp;
        if (this.f6188c != null) {
            this.f6189d.mo7290a(this.f6188c);
        }
    }

    public void zza(zzq zzq) {
        this.f6189d.f5062a = zzq;
        if (this.f6188c != null) {
            this.f6189d.mo7290a(this.f6188c);
        }
    }

    public void zza(zzw zzw) {
        this.f6189d.f5063b = zzw;
        if (this.f6188c != null) {
            this.f6189d.mo7290a(this.f6188c);
        }
    }

    public void zza(zzy zzy) {
        mo8376a();
        if (this.f6188c != null) {
            this.f6188c.zza(zzy);
        }
    }

    public void zza(com.google.android.gms.ads.internal.reward.client.zzd zzd) {
        this.f6189d.f5067f = zzd;
        if (this.f6188c != null) {
            this.f6189d.mo7290a(this.f6188c);
        }
    }

    public void zza(zzdo zzdo) {
        this.f6189d.f5065d = zzdo;
        if (this.f6188c != null) {
            this.f6189d.mo7290a(this.f6188c);
        }
    }

    public void zza(zzho zzho) {
        this.f6189d.f5064c = zzho;
        if (this.f6188c != null) {
            this.f6189d.mo7290a(this.f6188c);
        }
    }

    public void zza(zzhs zzhs, String str) {
        this.f6190e = zzhs;
        this.f6191f = str;
        m7048b();
    }

    public boolean zzb(AdRequestParcel adRequestParcel) {
        if (!m7047a(adRequestParcel)) {
            mo8376a();
        }
        if (zzfk.m7037c(adRequestParcel)) {
            mo8376a();
        }
        if (adRequestParcel.zzatt != null) {
            mo8376a();
        }
        if (this.f6188c != null) {
            return this.f6188c.zzb(adRequestParcel);
        }
        zzfk zzgb = com.google.android.gms.ads.internal.zzu.zzgb();
        if (m7049b(adRequestParcel)) {
            zzgb.mo8373b(adRequestParcel, this.f6186a);
        }
        C1605hh a = zzgb.mo8369a(adRequestParcel, this.f6186a);
        if (a != null) {
            if (!a.f5080e) {
                a.mo7305a();
            }
            this.f6188c = a.f5076a;
            a.f5078c.mo7286a(this.f6189d);
            this.f6189d.mo7290a(this.f6188c);
            m7048b();
            return a.f5081f;
        }
        mo8376a();
        return this.f6188c.zzb(adRequestParcel);
    }

    public com.google.android.gms.dynamic.zzd zzdm() {
        if (this.f6188c != null) {
            return this.f6188c.zzdm();
        }
        return null;
    }

    public AdSizeParcel zzdn() {
        if (this.f6188c != null) {
            return this.f6188c.zzdn();
        }
        return null;
    }

    public void zzdp() {
        if (this.f6188c != null) {
            this.f6188c.zzdp();
        } else {
            zzkd.zzcx("Interstitial ad must be loaded before pingManualTrackingUrl().");
        }
    }

    public zzab zzdq() {
        throw new IllegalStateException("getVideoController not implemented for interstitials");
    }
}
