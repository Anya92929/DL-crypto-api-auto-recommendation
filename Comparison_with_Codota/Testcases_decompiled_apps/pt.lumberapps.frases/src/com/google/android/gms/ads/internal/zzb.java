package com.google.android.gms.ads.internal;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.os.Messenger;
import android.os.RemoteException;
import android.util.DisplayMetrics;
import android.view.View;
import android.webkit.CookieManager;
import com.google.android.gms.ads.internal.client.AdRequestParcel;
import com.google.android.gms.ads.internal.client.AdSizeParcel;
import com.google.android.gms.ads.internal.client.zzm;
import com.google.android.gms.ads.internal.overlay.zzg;
import com.google.android.gms.ads.internal.purchase.GInAppPurchaseManagerInfoParcel;
import com.google.android.gms.ads.internal.purchase.zzc;
import com.google.android.gms.ads.internal.purchase.zzd;
import com.google.android.gms.ads.internal.purchase.zzf;
import com.google.android.gms.ads.internal.purchase.zzj;
import com.google.android.gms.ads.internal.purchase.zzk;
import com.google.android.gms.ads.internal.request.AdRequestInfoParcel;
import com.google.android.gms.ads.internal.request.CapabilityParcel;
import com.google.android.gms.ads.internal.util.client.VersionInfoParcel;
import com.google.android.gms.common.internal.zzab;
import com.google.android.gms.internal.zzdc;
import com.google.android.gms.internal.zzdk;
import com.google.android.gms.internal.zzer;
import com.google.android.gms.internal.zzgb;
import com.google.android.gms.internal.zzgj;
import com.google.android.gms.internal.zzhl;
import com.google.android.gms.internal.zzho;
import com.google.android.gms.internal.zzhs;
import com.google.android.gms.internal.zzin;
import com.google.android.gms.internal.zzju;
import com.google.android.gms.internal.zzjv;
import com.google.android.gms.internal.zzjw;
import com.google.android.gms.internal.zzkd;
import com.google.android.gms.internal.zzkh;
import com.google.android.gms.internal.zzlh;
import java.util.ArrayList;
import java.util.UUID;
import java.util.concurrent.Future;

@zzin
public abstract class zzb extends zza implements zzg, zzj, zzs, zzer, zzgb {

    /* renamed from: j */
    protected final zzgj f4015j;

    /* renamed from: k */
    protected transient boolean f4016k;

    /* renamed from: l */
    private final Messenger f4017l;

    public zzb(Context context, AdSizeParcel adSizeParcel, String str, zzgj zzgj, VersionInfoParcel versionInfoParcel, zzd zzd) {
        this(new zzv(context, adSizeParcel, str, versionInfoParcel), zzgj, (zzr) null, zzd);
    }

    protected zzb(zzv zzv, zzgj zzgj, zzr zzr, zzd zzd) {
        super(zzv, zzr, zzd);
        this.f4015j = zzgj;
        this.f4017l = new Messenger(new zzhl(this.f4011f.zzagf));
        this.f4016k = false;
    }

    /* renamed from: a */
    private AdRequestInfoParcel.zza m5787a(AdRequestParcel adRequestParcel, Bundle bundle, zzjw zzjw) {
        PackageInfo packageInfo;
        ApplicationInfo applicationInfo = this.f4011f.zzagf.getApplicationInfo();
        try {
            packageInfo = this.f4011f.zzagf.getPackageManager().getPackageInfo(applicationInfo.packageName, 0);
        } catch (PackageManager.NameNotFoundException e) {
            packageInfo = null;
        }
        DisplayMetrics displayMetrics = this.f4011f.zzagf.getResources().getDisplayMetrics();
        Bundle bundle2 = null;
        if (!(this.f4011f.f4112c == null || this.f4011f.f4112c.getParent() == null)) {
            int[] iArr = new int[2];
            this.f4011f.f4112c.getLocationOnScreen(iArr);
            int i = iArr[0];
            int i2 = iArr[1];
            int width = this.f4011f.f4112c.getWidth();
            int height = this.f4011f.f4112c.getHeight();
            int i3 = 0;
            if (this.f4011f.f4112c.isShown() && i + width > 0 && i2 + height > 0 && i <= displayMetrics.widthPixels && i2 <= displayMetrics.heightPixels) {
                i3 = 1;
            }
            bundle2 = new Bundle(5);
            bundle2.putInt("x", i);
            bundle2.putInt("y", i2);
            bundle2.putInt("width", width);
            bundle2.putInt("height", height);
            bundle2.putInt("visible", i3);
        }
        String zzsj = zzu.zzft().zzsj();
        this.f4011f.zzapd = new zzjv(zzsj, this.f4011f.zzaou);
        this.f4011f.zzapd.zzq(adRequestParcel);
        String zza = zzu.zzfq().zza(this.f4011f.zzagf, (View) this.f4011f.f4112c, this.f4011f.zzapa);
        long j = 0;
        if (this.f4011f.f4116g != null) {
            try {
                j = this.f4011f.f4116g.getValue();
            } catch (RemoteException e2) {
                zzkd.zzcx("Cannot get correlation id, default to 0.");
            }
        }
        String uuid = UUID.randomUUID().toString();
        Bundle zza2 = zzu.zzft().zza(this.f4011f.zzagf, this, zzsj);
        ArrayList arrayList = new ArrayList();
        int i4 = 0;
        while (true) {
            int i5 = i4;
            if (i5 >= this.f4011f.f4122m.size()) {
                break;
            }
            arrayList.add((String) this.f4011f.f4122m.mo1152b(i5));
            i4 = i5 + 1;
        }
        boolean z = this.f4011f.f4117h != null;
        boolean z2 = this.f4011f.f4118i != null && zzu.zzft().zzsv();
        boolean zzr = this.f4014i.zzakl.zzr(this.f4011f.zzagf);
        String str = "";
        if (((Boolean) zzdc.zzbdn.get()).booleanValue()) {
            zzkd.zzcv("Getting webview cookie from CookieManager.");
            CookieManager zzao = zzu.zzfs().zzao(this.f4011f.zzagf);
            if (zzao != null) {
                str = zzao.getCookie("googleads.g.doubleclick.net");
            }
        }
        String str2 = null;
        if (zzjw != null) {
            str2 = zzjw.zzsg();
        }
        return new AdRequestInfoParcel.zza(bundle2, adRequestParcel, this.f4011f.zzapa, this.f4011f.zzaou, applicationInfo, packageInfo, zzsj, zzu.zzft().getSessionId(), this.f4011f.zzaow, zza2, this.f4011f.f4127r, arrayList, bundle, zzu.zzft().zzsn(), this.f4017l, displayMetrics.widthPixels, displayMetrics.heightPixels, displayMetrics.density, zza, j, uuid, zzdc.zzjx(), this.f4011f.f4110a, this.f4011f.f4123n, new CapabilityParcel(z, z2, zzr), this.f4011f.zzgt(), zzu.zzfq().zzey(), zzu.zzfq().zzfa(), zzu.zzfq().zzam(this.f4011f.zzagf), zzu.zzfq().zzn(this.f4011f.f4112c), this.f4011f.zzagf instanceof Activity, zzu.zzft().zzsr(), str, str2, zzu.zzft().zzss(), zzu.zzgj().zzlk(), zzu.zzfq().zzti());
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public void mo5830a(zzju zzju, boolean z) {
        if (zzju == null) {
            zzkd.zzcx("Ad state was null when trying to ping impression URLs.");
            return;
        }
        super.mo5818b(zzju);
        if (!(zzju.zzcig == null || zzju.zzcig.zzbnn == null)) {
            zzu.zzgf().zza(this.f4011f.zzagf, this.f4011f.zzaow.zzcs, zzju, this.f4011f.zzaou, z, zzju.zzcig.zzbnn);
        }
        if (zzju.zzbon != null && zzju.zzbon.zzbna != null) {
            zzu.zzgf().zza(this.f4011f.zzagf, this.f4011f.zzaow.zzcs, zzju, this.f4011f.zzaou, z, zzju.zzbon.zzbna);
        }
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public boolean mo5815a(AdRequestParcel adRequestParcel) {
        return super.mo5815a(adRequestParcel) && !this.f4016k;
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public boolean mo5831a(AdRequestParcel adRequestParcel, zzju zzju, boolean z) {
        if (!z && this.f4011f.zzgp()) {
            if (zzju.zzbns > 0) {
                this.f4010e.zza(adRequestParcel, zzju.zzbns);
            } else if (zzju.zzcig != null && zzju.zzcig.zzbns > 0) {
                this.f4010e.zza(adRequestParcel, zzju.zzcig.zzbns);
            } else if (!zzju.zzcby && zzju.errorCode == 2) {
                this.f4010e.zzg(adRequestParcel);
            }
        }
        return this.f4010e.zzfc();
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public boolean mo5816a(zzju zzju) {
        AdRequestParcel adRequestParcel;
        boolean z = false;
        if (this.f4012g != null) {
            adRequestParcel = this.f4012g;
            this.f4012g = null;
        } else {
            adRequestParcel = zzju.zzcar;
            if (adRequestParcel.extras != null) {
                z = adRequestParcel.extras.getBoolean("_noRefresh", false);
            }
        }
        return mo5831a(adRequestParcel, zzju, z);
    }

    /* access modifiers changed from: protected */
    /* renamed from: f */
    public boolean mo5832f() {
        return zzu.zzfq().zza(this.f4011f.zzagf.getPackageManager(), this.f4011f.zzagf.getPackageName(), "android.permission.INTERNET") && zzu.zzfq().zzac(this.f4011f.zzagf);
    }

    public String getMediationAdapterClassName() {
        if (this.f4011f.zzapb == null) {
            return null;
        }
        return this.f4011f.zzapb.zzbop;
    }

    public void onAdClicked() {
        if (this.f4011f.zzapb == null) {
            zzkd.zzcx("Ad state was null when trying to ping click URLs.");
            return;
        }
        if (!(this.f4011f.zzapb.zzcig == null || this.f4011f.zzapb.zzcig.zzbnm == null)) {
            zzu.zzgf().zza(this.f4011f.zzagf, this.f4011f.zzaow.zzcs, this.f4011f.zzapb, this.f4011f.zzaou, false, this.f4011f.zzapb.zzcig.zzbnm);
        }
        if (!(this.f4011f.zzapb.zzbon == null || this.f4011f.zzapb.zzbon.zzbmz == null)) {
            zzu.zzgf().zza(this.f4011f.zzagf, this.f4011f.zzaow.zzcs, this.f4011f.zzapb, this.f4011f.zzaou, false, this.f4011f.zzapb.zzbon.zzbmz);
        }
        super.onAdClicked();
    }

    public void onPause() {
        this.f4013h.zzk(this.f4011f.zzapb);
    }

    public void onResume() {
        this.f4013h.zzl(this.f4011f.zzapb);
    }

    public void pause() {
        zzab.zzhi("pause must be called on the main UI thread.");
        if (!(this.f4011f.zzapb == null || this.f4011f.zzapb.zzbtm == null || !this.f4011f.zzgp())) {
            zzu.zzfs().zzi(this.f4011f.zzapb.zzbtm);
        }
        if (!(this.f4011f.zzapb == null || this.f4011f.zzapb.zzboo == null)) {
            try {
                this.f4011f.zzapb.zzboo.pause();
            } catch (RemoteException e) {
                zzkd.zzcx("Could not pause mediation adapter.");
            }
        }
        this.f4013h.zzk(this.f4011f.zzapb);
        this.f4010e.pause();
    }

    public void recordImpression() {
        mo5830a(this.f4011f.zzapb, false);
    }

    public void resume() {
        zzab.zzhi("resume must be called on the main UI thread.");
        zzlh zzlh = null;
        if (!(this.f4011f.zzapb == null || this.f4011f.zzapb.zzbtm == null)) {
            zzlh = this.f4011f.zzapb.zzbtm;
        }
        if (zzlh != null && this.f4011f.zzgp()) {
            zzu.zzfs().zzj(this.f4011f.zzapb.zzbtm);
        }
        if (!(this.f4011f.zzapb == null || this.f4011f.zzapb.zzboo == null)) {
            try {
                this.f4011f.zzapb.zzboo.resume();
            } catch (RemoteException e) {
                zzkd.zzcx("Could not resume mediation adapter.");
            }
        }
        if (zzlh == null || !zzlh.zzup()) {
            this.f4010e.resume();
        }
        this.f4013h.zzl(this.f4011f.zzapb);
    }

    public void showInterstitial() {
        throw new IllegalStateException("showInterstitial is not supported for current ad type");
    }

    public void zza(zzho zzho) {
        zzab.zzhi("setInAppPurchaseListener must be called on the main UI thread.");
        this.f4011f.f4117h = zzho;
    }

    public void zza(zzhs zzhs, String str) {
        zzab.zzhi("setPlayStorePurchaseParams must be called on the main UI thread.");
        this.f4011f.f4128s = new zzk(str);
        this.f4011f.f4118i = zzhs;
        if (!zzu.zzft().zzsm() && zzhs != null) {
            Future future = (Future) new zzc(this.f4011f.zzagf, this.f4011f.f4118i, this.f4011f.f4128s).zzpy();
        }
    }

    public void zza(String str, ArrayList arrayList) {
        zzd zzd = new zzd(str, arrayList, this.f4011f.zzagf, this.f4011f.zzaow.zzcs);
        if (this.f4011f.f4117h == null) {
            zzkd.zzcx("InAppPurchaseListener is not set. Try to launch default purchase flow.");
            if (!zzm.zziw().zzar(this.f4011f.zzagf)) {
                zzkd.zzcx("Google Play Service unavailable, cannot launch default purchase flow.");
            } else if (this.f4011f.f4118i == null) {
                zzkd.zzcx("PlayStorePurchaseListener is not set.");
            } else if (this.f4011f.f4128s == null) {
                zzkd.zzcx("PlayStorePurchaseVerifier is not initialized.");
            } else if (this.f4011f.f4130u) {
                zzkd.zzcx("An in-app purchase request is already in progress, abort");
            } else {
                this.f4011f.f4130u = true;
                try {
                    if (!this.f4011f.f4118i.isValidPurchase(str)) {
                        this.f4011f.f4130u = false;
                    } else {
                        zzu.zzga().zza(this.f4011f.zzagf, this.f4011f.zzaow.zzcnm, new GInAppPurchaseManagerInfoParcel(this.f4011f.zzagf, this.f4011f.f4128s, zzd, this));
                    }
                } catch (RemoteException e) {
                    zzkd.zzcx("Could not start In-App purchase.");
                    this.f4011f.f4130u = false;
                }
            }
        } else {
            try {
                this.f4011f.f4117h.zza(zzd);
            } catch (RemoteException e2) {
                zzkd.zzcx("Could not start In-App purchase.");
            }
        }
    }

    public void zza(String str, boolean z, int i, Intent intent, zzf zzf) {
        try {
            if (this.f4011f.f4118i != null) {
                this.f4011f.f4118i.zza(new com.google.android.gms.ads.internal.purchase.zzg(this.f4011f.zzagf, str, z, i, intent, zzf));
            }
        } catch (RemoteException e) {
            zzkd.zzcx("Fail to invoke PlayStorePurchaseListener.");
        }
        zzkh.zzclc.postDelayed(new C1222b(this, intent), 500);
    }

    public boolean zza(AdRequestParcel adRequestParcel, zzdk zzdk) {
        zzjw zzjw;
        String str = null;
        if (!mo5832f()) {
            return false;
        }
        Bundle a = mo5810a(zzu.zzft().zzaa(this.f4011f.zzagf));
        this.f4010e.cancel();
        this.f4011f.zzapw = 0;
        if (((Boolean) zzdc.zzbct.get()).booleanValue()) {
            zzjw = zzu.zzft().zzst();
            zzg zzgi = zzu.zzgi();
            Context context = this.f4011f.zzagf;
            VersionInfoParcel versionInfoParcel = this.f4011f.zzaow;
            if (zzjw != null) {
                str = zzjw.zzsh();
            }
            zzgi.zza(context, versionInfoParcel, false, zzjw, str, this.f4011f.zzaou);
        } else {
            zzjw = null;
        }
        AdRequestInfoParcel.zza a2 = m5787a(adRequestParcel, a, zzjw);
        zzdk.zzh("seq_num", a2.zzcau);
        zzdk.zzh("request_id", a2.zzcbg);
        zzdk.zzh("session_id", a2.zzcav);
        if (a2.zzcas != null) {
            zzdk.zzh("app_version", String.valueOf(a2.zzcas.versionCode));
        }
        this.f4011f.zzaoy = zzu.zzfm().zza(this.f4011f.zzagf, a2, this.f4011f.f4111b, this);
        return true;
    }

    /* access modifiers changed from: protected */
    public boolean zza(zzju zzju, zzju zzju2) {
        int i;
        int i2 = 0;
        if (!(zzju == null || zzju.zzboq == null)) {
            zzju.zzboq.zza((zzgb) null);
        }
        if (zzju2.zzboq != null) {
            zzju2.zzboq.zza((zzgb) this);
        }
        if (zzju2.zzcig != null) {
            i = zzju2.zzcig.zzbny;
            i2 = zzju2.zzcig.zzbnz;
        } else {
            i = 0;
        }
        this.f4011f.zzapu.zzh(i, i2);
        return true;
    }

    public void zzb(zzju zzju) {
        super.zzb(zzju);
        if (zzju.zzbon != null) {
            zzkd.zzcv("Pinging network fill URLs.");
            zzu.zzgf().zza(this.f4011f.zzagf, this.f4011f.zzaow.zzcs, zzju, this.f4011f.zzaou, false, zzju.zzbon.zzbnb);
            if (zzju.zzcig.zzbnp != null && zzju.zzcig.zzbnp.size() > 0) {
                zzkd.zzcv("Pinging urls remotely");
                zzu.zzfq().zza(this.f4011f.zzagf, zzju.zzcig.zzbnp);
            }
        }
        if (zzju.errorCode == 3 && zzju.zzcig != null && zzju.zzcig.zzbno != null) {
            zzkd.zzcv("Pinging no fill URLs.");
            zzu.zzgf().zza(this.f4011f.zzagf, this.f4011f.zzaow.zzcs, zzju, this.f4011f.zzaou, false, zzju.zzcig.zzbno);
        }
    }

    public void zzdx() {
        this.f4013h.zzi(this.f4011f.zzapb);
        this.f4016k = false;
        mo5811a();
        this.f4011f.zzapd.zzsa();
    }

    public void zzdy() {
        this.f4016k = true;
        mo5819c();
    }

    public void zzdz() {
        onAdClicked();
    }

    public void zzea() {
        zzdx();
    }

    public void zzeb() {
        zzdo();
    }

    public void zzec() {
        zzdy();
    }

    public void zzed() {
        if (this.f4011f.zzapb != null) {
            String str = this.f4011f.zzapb.zzbop;
            zzkd.zzcx(new StringBuilder(String.valueOf(str).length() + 74).append("Mediation adapter ").append(str).append(" refreshed, but mediation adapters should never refresh.").toString());
        }
        mo5830a(this.f4011f.zzapb, true);
        mo5820d();
    }

    public void zzee() {
        recordImpression();
    }

    public void zzef() {
        zzu.zzfq().runOnUiThread(new C1223c(this));
    }

    public void zzeg() {
        zzu.zzfq().runOnUiThread(new C1254d(this));
    }
}
