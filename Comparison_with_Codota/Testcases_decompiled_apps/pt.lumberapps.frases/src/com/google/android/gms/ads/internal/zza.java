package com.google.android.gms.ads.internal;

import android.location.Location;
import android.os.Bundle;
import android.os.RemoteException;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewParent;
import com.google.android.gms.ads.internal.client.AdRequestParcel;
import com.google.android.gms.ads.internal.client.AdSizeParcel;
import com.google.android.gms.ads.internal.client.ThinAdSizeParcel;
import com.google.android.gms.ads.internal.client.VideoOptionsParcel;
import com.google.android.gms.ads.internal.client.zzf;
import com.google.android.gms.ads.internal.client.zzm;
import com.google.android.gms.ads.internal.client.zzq;
import com.google.android.gms.ads.internal.client.zzu;
import com.google.android.gms.ads.internal.client.zzw;
import com.google.android.gms.ads.internal.client.zzy;
import com.google.android.gms.ads.internal.overlay.zzp;
import com.google.android.gms.ads.internal.request.zza;
import com.google.android.gms.ads.internal.reward.client.zzd;
import com.google.android.gms.ads.internal.reward.mediation.client.RewardItemParcel;
import com.google.android.gms.ads.internal.zzv;
import com.google.android.gms.common.internal.zzab;
import com.google.android.gms.common.util.zzi;
import com.google.android.gms.dynamic.zze;
import com.google.android.gms.internal.zzcg;
import com.google.android.gms.internal.zzcl;
import com.google.android.gms.internal.zzco;
import com.google.android.gms.internal.zzdc;
import com.google.android.gms.internal.zzdi;
import com.google.android.gms.internal.zzdk;
import com.google.android.gms.internal.zzdo;
import com.google.android.gms.internal.zzel;
import com.google.android.gms.internal.zzho;
import com.google.android.gms.internal.zzhs;
import com.google.android.gms.internal.zzic;
import com.google.android.gms.internal.zzin;
import com.google.android.gms.internal.zzjd;
import com.google.android.gms.internal.zzju;
import com.google.android.gms.internal.zzjz;
import com.google.android.gms.internal.zzka;
import com.google.android.gms.internal.zzkd;
import java.util.HashSet;
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.CountDownLatch;

@zzin
public abstract class zza extends zzu.zza implements com.google.android.gms.ads.internal.client.zza, zzp, zza.C2105zza, zzel, zzic.zza, zzjz {

    /* renamed from: a */
    protected zzdk f4006a;

    /* renamed from: b */
    protected zzdi f4007b;

    /* renamed from: c */
    protected zzdi f4008c;

    /* renamed from: d */
    protected boolean f4009d = false;

    /* renamed from: e */
    protected final zzr f4010e;

    /* renamed from: f */
    protected final zzv f4011f;

    /* renamed from: g */
    protected transient AdRequestParcel f4012g;

    /* renamed from: h */
    protected final zzcg f4013h;

    /* renamed from: i */
    protected final zzd f4014i;

    zza(zzv zzv, zzr zzr, zzd zzd) {
        this.f4011f = zzv;
        this.f4010e = zzr == null ? new zzr(this) : zzr;
        this.f4014i = zzd;
        zzu.zzfq().zzad(this.f4011f.zzagf);
        zzu.zzft().zzb(this.f4011f.zzagf, this.f4011f.zzaow);
        this.f4013h = zzu.zzft().zzsu();
        mo5832f();
    }

    /* renamed from: a */
    private TimerTask m5771a(Timer timer, CountDownLatch countDownLatch) {
        return new C1213a(this, countDownLatch, timer);
    }

    /* renamed from: b */
    private AdRequestParcel mo5853b(AdRequestParcel adRequestParcel) {
        return (!zzi.zzcl(this.f4011f.zzagf) || adRequestParcel.zzatu == null) ? adRequestParcel : new zzf(adRequestParcel).zza((Location) null).zzig();
    }

    /* renamed from: f */
    private void mo5832f() {
        if (((Boolean) zzdc.zzbcj.get()).booleanValue()) {
            Timer timer = new Timer();
            timer.schedule(m5771a(timer, new CountDownLatch(((Integer) zzdc.zzbcl.get()).intValue())), 0, ((Long) zzdc.zzbck.get()).longValue());
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public long mo5809a(String str) {
        int indexOf = str.indexOf("ufe");
        int indexOf2 = str.indexOf(44, indexOf);
        if (indexOf2 == -1) {
            indexOf2 = str.length();
        }
        try {
            return Long.parseLong(str.substring(indexOf + 4, indexOf2));
        } catch (IndexOutOfBoundsException e) {
            zzkd.zzcx("Invalid index for Url fetch time in CSI latency info.");
        } catch (NumberFormatException e2) {
            zzkd.zzcx("Cannot find valid format of Url fetch time in CSI latency info.");
        }
        return -1;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public Bundle mo5810a(zzco zzco) {
        String str;
        String zzsp;
        if (zzco == null) {
            return null;
        }
        if (zzco.zzid()) {
            zzco.wakeup();
        }
        zzcl zzib = zzco.zzib();
        if (zzib != null) {
            zzsp = zzib.zzhr();
            str = zzib.zzhs();
            String valueOf = String.valueOf(zzib.toString());
            zzkd.zzcv(valueOf.length() != 0 ? "In AdManager: loadAd, ".concat(valueOf) : new String("In AdManager: loadAd, "));
            if (zzsp != null) {
                zzu.zzft().zzcm(zzsp);
            }
        } else {
            str = null;
            zzsp = zzu.zzft().zzsp();
        }
        if (zzsp == null) {
            return null;
        }
        Bundle bundle = new Bundle(1);
        bundle.putString("fingerprint", zzsp);
        if (zzsp.equals(str)) {
            return bundle;
        }
        bundle.putString("v_fp", str);
        return bundle;
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public void mo5811a() {
        zzkd.zzcw("Ad closing.");
        if (this.f4011f.f4114e != null) {
            try {
                this.f4011f.f4114e.onAdClosed();
            } catch (RemoteException e) {
                zzkd.zzd("Could not call AdListener.onAdClosed().", e);
            }
        }
        if (this.f4011f.f4126q != null) {
            try {
                this.f4011f.f4126q.onRewardedVideoAdClosed();
            } catch (RemoteException e2) {
                zzkd.zzd("Could not call RewardedVideoAdListener.onRewardedVideoAdClosed().", e2);
            }
        }
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public void mo5812a(int i) {
        zzkd.zzcx(new StringBuilder(30).append("Failed to load ad: ").append(i).toString());
        this.f4009d = false;
        if (this.f4011f.f4114e != null) {
            try {
                this.f4011f.f4114e.onAdFailedToLoad(i);
            } catch (RemoteException e) {
                zzkd.zzd("Could not call AdListener.onAdFailedToLoad().", e);
            }
        }
        if (this.f4011f.f4126q != null) {
            try {
                this.f4011f.f4126q.onRewardedVideoAdFailedToLoad(i);
            } catch (RemoteException e2) {
                zzkd.zzd("Could not call RewardedVideoAdListener.onRewardedVideoAdFailedToLoad().", e2);
            }
        }
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public void mo5813a(View view) {
        zzv.zza zza = this.f4011f.f4112c;
        if (zza != null) {
            zza.addView(view, zzu.zzfs().zztm());
        }
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public void mo5814a(RewardItemParcel rewardItemParcel) {
        if (this.f4011f.f4126q != null) {
            String str = "";
            int i = 0;
            if (rewardItemParcel != null) {
                try {
                    str = rewardItemParcel.type;
                    i = rewardItemParcel.zzcid;
                } catch (RemoteException e) {
                    zzkd.zzd("Could not call RewardedVideoAdListener.onRewarded().", e);
                    return;
                }
            }
            this.f4011f.f4126q.zza(new zzjd(str, i));
        }
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public boolean mo5815a(AdRequestParcel adRequestParcel) {
        if (this.f4011f.f4112c == null) {
            return false;
        }
        ViewParent parent = this.f4011f.f4112c.getParent();
        if (!(parent instanceof View)) {
            return false;
        }
        View view = (View) parent;
        return zzu.zzfq().zza(view, view.getContext());
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public boolean mo5816a(zzju zzju) {
        return false;
    }

    /* access modifiers changed from: protected */
    /* renamed from: b */
    public void mo5817b() {
        zzkd.zzcw("Ad leaving application.");
        if (this.f4011f.f4114e != null) {
            try {
                this.f4011f.f4114e.onAdLeftApplication();
            } catch (RemoteException e) {
                zzkd.zzd("Could not call AdListener.onAdLeftApplication().", e);
            }
        }
        if (this.f4011f.f4126q != null) {
            try {
                this.f4011f.f4126q.onRewardedVideoAdLeftApplication();
            } catch (RemoteException e2) {
                zzkd.zzd("Could not call  RewardedVideoAdListener.onRewardedVideoAdLeftApplication().", e2);
            }
        }
    }

    /* access modifiers changed from: protected */
    /* renamed from: b */
    public void mo5818b(zzju zzju) {
        if (zzju == null) {
            zzkd.zzcx("Ad state was null when trying to ping impression URLs.");
            return;
        }
        zzkd.zzcv("Pinging Impression URLs.");
        this.f4011f.zzapd.zzry();
        if (zzju.zzbnn != null && !zzju.zzcin) {
            zzu.zzfq().zza(this.f4011f.zzagf, this.f4011f.zzaow.zzcs, zzju.zzbnn);
            zzju.zzcin = true;
        }
    }

    /* access modifiers changed from: protected */
    /* renamed from: c */
    public void mo5819c() {
        zzkd.zzcw("Ad opening.");
        if (this.f4011f.f4114e != null) {
            try {
                this.f4011f.f4114e.onAdOpened();
            } catch (RemoteException e) {
                zzkd.zzd("Could not call AdListener.onAdOpened().", e);
            }
        }
        if (this.f4011f.f4126q != null) {
            try {
                this.f4011f.f4126q.onRewardedVideoAdOpened();
            } catch (RemoteException e2) {
                zzkd.zzd("Could not call RewardedVideoAdListener.onRewardedVideoAdOpened().", e2);
            }
        }
    }

    /* access modifiers changed from: protected */
    /* renamed from: d */
    public void mo5820d() {
        zzkd.zzcw("Ad finished loading.");
        this.f4009d = false;
        if (this.f4011f.f4114e != null) {
            try {
                this.f4011f.f4114e.onAdLoaded();
            } catch (RemoteException e) {
                zzkd.zzd("Could not call AdListener.onAdLoaded().", e);
            }
        }
        if (this.f4011f.f4126q != null) {
            try {
                this.f4011f.f4126q.onRewardedVideoAdLoaded();
            } catch (RemoteException e2) {
                zzkd.zzd("Could not call RewardedVideoAdListener.onRewardedVideoAdLoaded().", e2);
            }
        }
    }

    public void destroy() {
        zzab.zzhi("destroy must be called on the main UI thread.");
        this.f4010e.cancel();
        this.f4013h.zzj(this.f4011f.zzapb);
        this.f4011f.destroy();
    }

    /* access modifiers changed from: protected */
    /* renamed from: e */
    public void mo5821e() {
        if (this.f4011f.f4126q != null) {
            try {
                this.f4011f.f4126q.onRewardedVideoStarted();
            } catch (RemoteException e) {
                zzkd.zzd("Could not call RewardedVideoAdListener.onVideoStarted().", e);
            }
        }
    }

    public boolean isLoading() {
        return this.f4009d;
    }

    public boolean isReady() {
        zzab.zzhi("isLoaded must be called on the main UI thread.");
        return this.f4011f.zzaoy == null && this.f4011f.zzaoz == null && this.f4011f.zzapb != null;
    }

    public void onAdClicked() {
        if (this.f4011f.zzapb == null) {
            zzkd.zzcx("Ad state was null when trying to ping click URLs.");
            return;
        }
        zzkd.zzcv("Pinging click URLs.");
        this.f4011f.zzapd.zzrz();
        if (this.f4011f.zzapb.zzbnm != null) {
            zzu.zzfq().zza(this.f4011f.zzagf, this.f4011f.zzaow.zzcs, this.f4011f.zzapb.zzbnm);
        }
        if (this.f4011f.f4113d != null) {
            try {
                this.f4011f.f4113d.onAdClicked();
            } catch (RemoteException e) {
                zzkd.zzd("Could not notify onAdClicked event.", e);
            }
        }
    }

    public void onAppEvent(String str, String str2) {
        if (this.f4011f.f4115f != null) {
            try {
                this.f4011f.f4115f.onAppEvent(str, str2);
            } catch (RemoteException e) {
                zzkd.zzd("Could not call the AppEventListener.", e);
            }
        }
    }

    public void pause() {
        zzab.zzhi("pause must be called on the main UI thread.");
    }

    public void resume() {
        zzab.zzhi("resume must be called on the main UI thread.");
    }

    public void setManualImpressionsEnabled(boolean z) {
        throw new UnsupportedOperationException("Attempt to call setManualImpressionsEnabled for an unsupported ad type.");
    }

    public void setUserId(String str) {
        zzkd.zzcx("RewardedVideoAd.setUserId() is deprecated. Please do not call this method.");
    }

    public void stopLoading() {
        zzab.zzhi("stopLoading must be called on the main UI thread.");
        this.f4009d = false;
        this.f4011f.zzi(true);
    }

    public void zza(AdSizeParcel adSizeParcel) {
        zzab.zzhi("setAdSize must be called on the main UI thread.");
        this.f4011f.zzapa = adSizeParcel;
        if (!(this.f4011f.zzapb == null || this.f4011f.zzapb.zzbtm == null || this.f4011f.zzapw != 0)) {
            this.f4011f.zzapb.zzbtm.zza(adSizeParcel);
        }
        if (this.f4011f.f4112c != null) {
            if (this.f4011f.f4112c.getChildCount() > 1) {
                this.f4011f.f4112c.removeView(this.f4011f.f4112c.getNextView());
            }
            this.f4011f.f4112c.setMinimumWidth(adSizeParcel.widthPixels);
            this.f4011f.f4112c.setMinimumHeight(adSizeParcel.heightPixels);
            this.f4011f.f4112c.requestLayout();
        }
    }

    public void zza(VideoOptionsParcel videoOptionsParcel) {
        zzab.zzhi("setVideoOptions must be called on the main UI thread.");
        this.f4011f.f4124o = videoOptionsParcel;
    }

    public void zza(com.google.android.gms.ads.internal.client.zzp zzp) {
        zzab.zzhi("setAdListener must be called on the main UI thread.");
        this.f4011f.f4113d = zzp;
    }

    public void zza(zzq zzq) {
        zzab.zzhi("setAdListener must be called on the main UI thread.");
        this.f4011f.f4114e = zzq;
    }

    public void zza(zzw zzw) {
        zzab.zzhi("setAppEventListener must be called on the main UI thread.");
        this.f4011f.f4115f = zzw;
    }

    public void zza(zzy zzy) {
        zzab.zzhi("setCorrelationIdProvider must be called on the main UI thread");
        this.f4011f.f4116g = zzy;
    }

    public void zza(zzd zzd) {
        zzab.zzhi("setRewardedVideoAdListener can only be called from the UI thread.");
        this.f4011f.f4126q = zzd;
    }

    public void zza(zzdo zzdo) {
        throw new IllegalStateException("setOnCustomRenderedAdLoadedListener is not supported for current ad type");
    }

    public void zza(zzho zzho) {
        throw new IllegalStateException("setInAppPurchaseListener is not supported for current ad type");
    }

    public void zza(zzhs zzhs, String str) {
        throw new IllegalStateException("setPlayStorePurchaseParams is not supported for current ad type");
    }

    public void zza(zzju.zza zza) {
        if (zza.zzciq.zzccc != -1 && !TextUtils.isEmpty(zza.zzciq.zzccl)) {
            long a = mo5809a(zza.zzciq.zzccl);
            if (a != -1) {
                zzdi zzc = this.f4006a.zzc(a + zza.zzciq.zzccc);
                this.f4006a.zza(zzc, "stc");
            }
        }
        this.f4006a.zzas(zza.zzciq.zzccl);
        this.f4006a.zza(this.f4007b, "arf");
        this.f4008c = this.f4006a.zzkg();
        this.f4006a.zzh("gqi", zza.zzciq.zzccm);
        this.f4011f.zzaoy = null;
        this.f4011f.zzapc = zza;
        zza(zza, this.f4006a);
    }

    /* access modifiers changed from: protected */
    public abstract void zza(zzju.zza zza, zzdk zzdk);

    public void zza(HashSet hashSet) {
        this.f4011f.zza(hashSet);
    }

    /* access modifiers changed from: protected */
    public abstract boolean zza(AdRequestParcel adRequestParcel, zzdk zzdk);

    /* access modifiers changed from: protected */
    public abstract boolean zza(zzju zzju, zzju zzju2);

    public void zzb(zzju zzju) {
        this.f4006a.zza(this.f4008c, "awr");
        this.f4011f.zzaoz = null;
        if (!(zzju.errorCode == -2 || zzju.errorCode == 3)) {
            zzu.zzft().zzb(this.f4011f.zzgl());
        }
        if (zzju.errorCode == -1) {
            this.f4009d = false;
            return;
        }
        if (mo5816a(zzju)) {
            zzkd.zzcv("Ad refresh scheduled.");
        }
        if (zzju.errorCode != -2) {
            mo5812a(zzju.errorCode);
            return;
        }
        if (this.f4011f.zzapu == null) {
            this.f4011f.zzapu = new zzka(this.f4011f.zzaou);
        }
        this.f4013h.zzi(this.f4011f.zzapb);
        if (zza(this.f4011f.zzapb, zzju)) {
            this.f4011f.zzapb = zzju;
            this.f4011f.zzgu();
            this.f4006a.zzh("is_mraid", this.f4011f.zzapb.zzho() ? "1" : "0");
            this.f4006a.zzh("is_mediation", this.f4011f.zzapb.zzcby ? "1" : "0");
            if (!(this.f4011f.zzapb.zzbtm == null || this.f4011f.zzapb.zzbtm.zzuj() == null)) {
                this.f4006a.zzh("is_delay_pl", this.f4011f.zzapb.zzbtm.zzuj().zzuy() ? "1" : "0");
            }
            this.f4006a.zza(this.f4007b, "ttc");
            if (zzu.zzft().zzsl() != null) {
                zzu.zzft().zzsl().zza(this.f4006a);
            }
            if (this.f4011f.zzgp()) {
                mo5820d();
            }
        }
        if (zzju.zzbnp != null) {
            zzu.zzfq().zza(this.f4011f.zzagf, zzju.zzbnp);
        }
    }

    public boolean zzb(AdRequestParcel adRequestParcel) {
        zzab.zzhi("loadAd must be called on the main UI thread.");
        AdRequestParcel b = mo5853b(adRequestParcel);
        if (this.f4011f.zzaoy == null && this.f4011f.zzaoz == null) {
            zzkd.zzcw("Starting ad request.");
            zzdl();
            this.f4007b = this.f4006a.zzkg();
            if (!b.zzatp) {
                String valueOf = String.valueOf(zzm.zziw().zzaq(this.f4011f.zzagf));
                zzkd.zzcw(new StringBuilder(String.valueOf(valueOf).length() + 71).append("Use AdRequest.Builder.addTestDevice(\"").append(valueOf).append("\") to get test ads on this device.").toString());
            }
            this.f4009d = zza(b, this.f4006a);
            return this.f4009d;
        }
        if (this.f4012g != null) {
            zzkd.zzcx("Aborting last ad request since another ad request is already in progress. The current request object will still be cached for future refreshes.");
        } else {
            zzkd.zzcx("Loading already in progress, saving this object for future refreshes.");
        }
        this.f4012g = b;
        return false;
    }

    public void zzd(AdRequestParcel adRequestParcel) {
        if (mo5815a(adRequestParcel)) {
            zzb(adRequestParcel);
            return;
        }
        zzkd.zzcw("Ad is not visible. Not refreshing ad.");
        this.f4010e.zzg(adRequestParcel);
    }

    public void zzdl() {
        this.f4006a = new zzdk(((Boolean) zzdc.zzaze.get()).booleanValue(), "load_ad", this.f4011f.zzapa.zzaur);
        this.f4007b = new zzdi(-1, (String) null, (zzdi) null);
        this.f4008c = new zzdi(-1, (String) null, (zzdi) null);
    }

    public com.google.android.gms.dynamic.zzd zzdm() {
        zzab.zzhi("getAdFrame must be called on the main UI thread.");
        return zze.zzac(this.f4011f.f4112c);
    }

    public AdSizeParcel zzdn() {
        zzab.zzhi("getAdSize must be called on the main UI thread.");
        if (this.f4011f.zzapa == null) {
            return null;
        }
        return new ThinAdSizeParcel(this.f4011f.zzapa);
    }

    public void zzdo() {
        mo5817b();
    }

    public void zzdp() {
        zzab.zzhi("recordManualImpression must be called on the main UI thread.");
        if (this.f4011f.zzapb == null) {
            zzkd.zzcx("Ad state was null when trying to ping manual tracking URLs.");
            return;
        }
        zzkd.zzcv("Pinging manual tracking URLs.");
        if (this.f4011f.zzapb.zzcca != null && !this.f4011f.zzapb.zzcio) {
            zzu.zzfq().zza(this.f4011f.zzagf, this.f4011f.zzaow.zzcs, this.f4011f.zzapb.zzcca);
            this.f4011f.zzapb.zzcio = true;
        }
    }

    public com.google.android.gms.ads.internal.client.zzab zzdq() {
        return null;
    }
}
