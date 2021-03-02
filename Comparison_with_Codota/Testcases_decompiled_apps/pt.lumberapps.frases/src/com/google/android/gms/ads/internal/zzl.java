package com.google.android.gms.ads.internal;

import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Point;
import android.graphics.Rect;
import android.os.Bundle;
import android.os.RemoteException;
import android.view.Window;
import com.google.ads.mediation.AbstractAdViewAdapter;
import com.google.android.gms.ads.internal.client.AdRequestParcel;
import com.google.android.gms.ads.internal.client.AdSizeParcel;
import com.google.android.gms.ads.internal.overlay.AdOverlayInfoParcel;
import com.google.android.gms.ads.internal.overlay.zzg;
import com.google.android.gms.ads.internal.request.AdResponseParcel;
import com.google.android.gms.ads.internal.reward.mediation.client.RewardItemParcel;
import com.google.android.gms.ads.internal.util.client.VersionInfoParcel;
import com.google.android.gms.common.internal.zzab;
import com.google.android.gms.internal.zzdc;
import com.google.android.gms.internal.zzdk;
import com.google.android.gms.internal.zzet;
import com.google.android.gms.internal.zzey;
import com.google.android.gms.internal.zzfz;
import com.google.android.gms.internal.zzga;
import com.google.android.gms.internal.zzgj;
import com.google.android.gms.internal.zzhg;
import com.google.android.gms.internal.zzin;
import com.google.android.gms.internal.zziq;
import com.google.android.gms.internal.zzjo;
import com.google.android.gms.internal.zzju;
import com.google.android.gms.internal.zzkd;
import com.google.android.gms.internal.zzlh;
import com.google.android.gms.internal.zzli;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.Future;
import org.json.JSONException;
import org.json.JSONObject;

@zzin
public class zzl extends zzc implements zzet, zzey.zza {

    /* renamed from: l */
    protected transient boolean f4052l = false;

    /* renamed from: m */
    private int f4053m = -1;
    /* access modifiers changed from: private */

    /* renamed from: n */
    public boolean f4054n;
    /* access modifiers changed from: private */

    /* renamed from: o */
    public float f4055o;

    public zzl(Context context, AdSizeParcel adSizeParcel, String str, zzgj zzgj, VersionInfoParcel versionInfoParcel, zzd zzd) {
        super(context, adSizeParcel, str, zzgj, versionInfoParcel, zzd);
    }

    /* renamed from: a */
    private zzju.zza m5819a(zzju.zza zza) {
        try {
            String jSONObject = zziq.zzc(zza.zzciq).toString();
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put(AbstractAdViewAdapter.AD_UNIT_ID_PARAMETER, zza.zzcip.zzaou);
            zzga zzga = new zzga(Collections.singletonList(new zzfz(jSONObject, (String) null, Collections.singletonList("com.google.ads.mediation.admob.AdMobAdapter"), (String) null, (String) null, Collections.emptyList(), Collections.emptyList(), jSONObject2.toString(), (String) null, Collections.emptyList(), Collections.emptyList(), (String) null, (String) null, (String) null, (List) null, (String) null, Collections.emptyList())), -1, Collections.emptyList(), Collections.emptyList(), Collections.emptyList(), Collections.emptyList(), false, "", -1, 0, 1, (String) null, 0, -1, -1, false);
            AdResponseParcel adResponseParcel = zza.zzciq;
            return new zzju.zza(zza.zzcip, new AdResponseParcel(zza.zzcip, adResponseParcel.zzbto, adResponseParcel.body, adResponseParcel.zzbnm, adResponseParcel.zzbnn, adResponseParcel.zzcbx, true, adResponseParcel.zzcbz, adResponseParcel.zzcca, adResponseParcel.zzbns, adResponseParcel.orientation, adResponseParcel.zzccb, adResponseParcel.zzccc, adResponseParcel.zzccd, adResponseParcel.zzcce, adResponseParcel.zzccf, adResponseParcel.zzccg, adResponseParcel.zzcch, adResponseParcel.zzauu, adResponseParcel.zzcaz, adResponseParcel.zzcci, adResponseParcel.zzccj, adResponseParcel.zzccm, adResponseParcel.zzauv, adResponseParcel.zzauw, adResponseParcel.zzccn, adResponseParcel.zzcco, adResponseParcel.zzccp, adResponseParcel.zzccq, adResponseParcel.zzccr, adResponseParcel.zzcbq, adResponseParcel.zzcbr, adResponseParcel.zzbnp, adResponseParcel.zzccs, adResponseParcel.zzbnq, adResponseParcel.zzcct), zzga, zza.zzapa, zza.errorCode, zza.zzcik, zza.zzcil, zza.zzcie);
        } catch (JSONException e) {
            zzkd.zzb("Unable to generate ad state for an interstitial ad with pooling.", e);
            return zza;
        }
    }

    /* renamed from: a */
    private void m5820a(Bundle bundle) {
        zzu.zzfq().zzb(this.f4011f.zzagf, this.f4011f.zzaow.zzcs, "gmob-apps", bundle, false);
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public zzlh mo5843a(zzju.zza zza, zze zze, zzjo zzjo) {
        zzlh zza2 = zzu.zzfr().zza(this.f4011f.zzagf, this.f4011f.zzapa, false, false, this.f4011f.f4111b, this.f4011f.zzaow, this.f4006a, this, this.f4014i);
        zza2.zzuj().zza(this, (zzg) null, this, this, ((Boolean) zzdc.zzazt.get()).booleanValue(), this, this, zze, (zzhg) null, zzjo);
        mo5844a(zza2);
        zza2.zzcz(zza.zzcip.zzcbg);
        zzey.zza(zza2, (zzey.zza) this);
        return zza2;
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public void mo5811a() {
        zzeu();
        super.mo5811a();
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public boolean mo5831a(AdRequestParcel adRequestParcel, zzju zzju, boolean z) {
        if (this.f4011f.zzgp() && zzju.zzbtm != null) {
            zzu.zzfs().zzi(zzju.zzbtm);
        }
        return this.f4010e.zzfc();
    }

    /* access modifiers changed from: protected */
    /* renamed from: d */
    public void mo5820d() {
        super.mo5820d();
        this.f4052l = true;
    }

    /* access modifiers changed from: protected */
    /* renamed from: g */
    public boolean mo5861g() {
        Window window;
        if (!(this.f4011f.zzagf instanceof Activity) || (window = ((Activity) this.f4011f.zzagf).getWindow()) == null || window.getDecorView() == null) {
            return false;
        }
        Rect rect = new Rect();
        Rect rect2 = new Rect();
        window.getDecorView().getGlobalVisibleRect(rect, (Point) null);
        window.getDecorView().getWindowVisibleDisplayFrame(rect2);
        return (rect.bottom == 0 || rect2.bottom == 0 || rect.top != rect2.top) ? false : true;
    }

    public void showInterstitial() {
        zzab.zzhi("showInterstitial must be called on the main UI thread.");
        if (this.f4011f.zzapb == null) {
            zzkd.zzcx("The interstitial has not loaded.");
            return;
        }
        if (((Boolean) zzdc.zzbau.get()).booleanValue()) {
            String packageName = this.f4011f.zzagf.getApplicationContext() != null ? this.f4011f.zzagf.getApplicationContext().getPackageName() : this.f4011f.zzagf.getPackageName();
            if (!this.f4052l) {
                zzkd.zzcx("It is not recommended to show an interstitial before onAdLoaded completes.");
                Bundle bundle = new Bundle();
                bundle.putString("appid", packageName);
                bundle.putString("action", "show_interstitial_before_load_finish");
                m5820a(bundle);
            }
            if (!zzu.zzfq().zzai(this.f4011f.zzagf)) {
                zzkd.zzcx("It is not recommended to show an interstitial when app is not in foreground.");
                Bundle bundle2 = new Bundle();
                bundle2.putString("appid", packageName);
                bundle2.putString("action", "show_interstitial_app_not_in_foreground");
                m5820a(bundle2);
            }
        }
        if (this.f4011f.zzgq()) {
            return;
        }
        if (this.f4011f.zzapb.zzcby && this.f4011f.zzapb.zzboo != null) {
            try {
                this.f4011f.zzapb.zzboo.showInterstitial();
            } catch (RemoteException e) {
                zzkd.zzd("Could not show interstitial.", e);
                zzeu();
            }
        } else if (this.f4011f.zzapb.zzbtm == null) {
            zzkd.zzcx("The interstitial failed to load.");
        } else if (this.f4011f.zzapb.zzbtm.zzun()) {
            zzkd.zzcx("The interstitial is already showing.");
        } else {
            this.f4011f.zzapb.zzbtm.zzah(true);
            if (this.f4011f.zzapb.zzcie != null) {
                this.f4013h.zza(this.f4011f.zzapa, this.f4011f.zzapb);
            }
            Bitmap zzaj = this.f4011f.f4131v ? zzu.zzfq().zzaj(this.f4011f.zzagf) : null;
            this.f4053m = zzu.zzgh().zzb(zzaj);
            if (!((Boolean) zzdc.zzbca.get()).booleanValue() || zzaj == null) {
                InterstitialAdParameterParcel interstitialAdParameterParcel = new InterstitialAdParameterParcel(this.f4011f.f4131v, mo5861g(), false, 0.0f, -1);
                int requestedOrientation = this.f4011f.zzapb.zzbtm.getRequestedOrientation();
                if (requestedOrientation == -1) {
                    requestedOrientation = this.f4011f.zzapb.orientation;
                }
                zzu.zzfo().zza(this.f4011f.zzagf, new AdOverlayInfoParcel(this, this, this, this.f4011f.zzapb.zzbtm, requestedOrientation, this.f4011f.zzaow, this.f4011f.zzapb.zzccd, interstitialAdParameterParcel));
                return;
            }
            Future future = (Future) new C1299r(this, this.f4053m).zzpy();
        }
    }

    public void zza(zzju.zza zza, zzdk zzdk) {
        boolean z = true;
        if (!((Boolean) zzdc.zzbae.get()).booleanValue()) {
            super.zza(zza, zzdk);
        } else if (zza.errorCode != -2) {
            super.zza(zza, zzdk);
        } else {
            Bundle bundle = zza.zzcip.zzcar.zzatw.getBundle("com.google.ads.mediation.admob.AdMobAdapter");
            boolean z2 = bundle == null || !bundle.containsKey("gw");
            if (zza.zzciq.zzcby) {
                z = false;
            }
            if (z2 && z) {
                this.f4011f.zzapc = m5819a(zza);
            }
            super.zza(this.f4011f.zzapc, zzdk);
        }
    }

    public void zza(boolean z, float f) {
        this.f4054n = z;
        this.f4055o = f;
    }

    public boolean zza(AdRequestParcel adRequestParcel, zzdk zzdk) {
        if (this.f4011f.zzapb == null) {
            return super.zza(adRequestParcel, zzdk);
        }
        zzkd.zzcx("An interstitial is already loading. Aborting.");
        return false;
    }

    public boolean zza(zzju zzju, zzju zzju2) {
        if (!super.zza(zzju, zzju2)) {
            return false;
        }
        if (!(this.f4011f.zzgp() || this.f4011f.f4129t == null || zzju2.zzcie == null)) {
            this.f4013h.zza(this.f4011f.zzapa, zzju2, this.f4011f.f4129t);
        }
        return true;
    }

    public void zzb(RewardItemParcel rewardItemParcel) {
        if (this.f4011f.zzapb != null) {
            if (this.f4011f.zzapb.zzccp != null) {
                zzu.zzfq().zza(this.f4011f.zzagf, this.f4011f.zzaow.zzcs, this.f4011f.zzapb.zzccp);
            }
            if (this.f4011f.zzapb.zzccn != null) {
                rewardItemParcel = this.f4011f.zzapb.zzccn;
            }
        }
        mo5814a(rewardItemParcel);
    }

    public void zzdy() {
        zzli zzuj;
        recordImpression();
        super.zzdy();
        if (this.f4011f.zzapb != null && this.f4011f.zzapb.zzbtm != null && (zzuj = this.f4011f.zzapb.zzbtm.zzuj()) != null) {
            zzuj.zzva();
        }
    }

    public void zzeu() {
        zzu.zzgh().zzb(Integer.valueOf(this.f4053m));
        if (this.f4011f.zzgp()) {
            this.f4011f.zzgm();
            this.f4011f.zzapb = null;
            this.f4011f.f4131v = false;
            this.f4052l = false;
        }
    }

    public void zzev() {
        if (!(this.f4011f.zzapb == null || this.f4011f.zzapb.zzcij == null)) {
            zzu.zzfq().zza(this.f4011f.zzagf, this.f4011f.zzaow.zzcs, this.f4011f.zzapb.zzcij);
        }
        mo5821e();
    }

    public void zzg(boolean z) {
        this.f4011f.f4131v = z;
    }
}
