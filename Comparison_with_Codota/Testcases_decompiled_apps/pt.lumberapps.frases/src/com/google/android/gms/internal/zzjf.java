package com.google.android.gms.internal;

import android.content.Context;
import android.os.RemoteException;
import android.text.TextUtils;
import com.google.ads.mediation.AbstractAdViewAdapter;
import com.google.android.gms.ads.internal.client.AdRequestParcel;
import com.google.android.gms.ads.internal.client.AdSizeParcel;
import com.google.android.gms.ads.internal.reward.client.RewardedVideoAdRequestParcel;
import com.google.android.gms.ads.internal.reward.mediation.client.RewardItemParcel;
import com.google.android.gms.ads.internal.util.client.VersionInfoParcel;
import com.google.android.gms.ads.internal.zzb;
import com.google.android.gms.ads.internal.zzd;
import com.google.android.gms.ads.internal.zzu;
import com.google.android.gms.common.internal.zzab;
import com.google.android.gms.dynamic.zze;
import com.google.android.gms.internal.zzju;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

@zzin
public class zzjf extends zzb implements zzji {

    /* renamed from: l */
    private static final zzgi f6509l = new zzgi();

    /* renamed from: m */
    private final Map f6510m = new HashMap();

    /* renamed from: n */
    private boolean f6511n;

    public zzjf(Context context, zzd zzd, AdSizeParcel adSizeParcel, zzgj zzgj, VersionInfoParcel versionInfoParcel) {
        super(context, adSizeParcel, (String) null, zzgj, versionInfoParcel, zzd);
    }

    /* renamed from: a */
    private zzju.zza m7269a(zzju.zza zza) {
        zzkd.m7303v("Creating mediation ad response for non-mediated rewarded ad.");
        try {
            String jSONObject = zziq.zzc(zza.zzciq).toString();
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put(AbstractAdViewAdapter.AD_UNIT_ID_PARAMETER, zza.zzcip.zzaou);
            return new zzju.zza(zza.zzcip, zza.zzciq, new zzga(Arrays.asList(new zzfz[]{new zzfz(jSONObject, (String) null, Arrays.asList(new String[]{"com.google.ads.mediation.admob.AdMobAdapter"}), (String) null, (String) null, Collections.emptyList(), Collections.emptyList(), jSONObject2.toString(), (String) null, Collections.emptyList(), Collections.emptyList(), (String) null, (String) null, (String) null, (List) null, (String) null, Collections.emptyList())}), -1, Collections.emptyList(), Collections.emptyList(), Collections.emptyList(), Collections.emptyList(), false, "", -1, 0, 1, (String) null, 0, -1, -1, false), zza.zzapa, zza.errorCode, zza.zzcik, zza.zzcil, zza.zzcie);
        } catch (JSONException e) {
            zzkd.zzb("Unable to generate ad state for non-mediated rewarded video.", e);
            return m7270b(zza);
        }
    }

    /* renamed from: b */
    private zzju.zza m7270b(zzju.zza zza) {
        return new zzju.zza(zza.zzcip, zza.zzciq, (zzga) null, zza.zzapa, 0, zza.zzcik, zza.zzcil, zza.zzcie);
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public boolean mo5831a(AdRequestParcel adRequestParcel, zzju zzju, boolean z) {
        return false;
    }

    public void destroy() {
        zzab.zzhi("destroy must be called on the main UI thread.");
        for (String str : this.f6510m.keySet()) {
            try {
                zzjm zzjm = (zzjm) this.f6510m.get(str);
                if (!(zzjm == null || zzjm.zzru() == null)) {
                    zzjm.zzru().destroy();
                }
            } catch (RemoteException e) {
                String valueOf = String.valueOf(str);
                zzkd.zzcx(valueOf.length() != 0 ? "Fail to destroy adapter: ".concat(valueOf) : new String("Fail to destroy adapter: "));
            }
        }
    }

    public boolean isLoaded() {
        zzab.zzhi("isLoaded must be called on the main UI thread.");
        return this.f4011f.zzaoy == null && this.f4011f.zzaoz == null && this.f4011f.zzapb != null && !this.f6511n;
    }

    public void onContextChanged(Context context) {
        for (zzjm zzru : this.f6510m.values()) {
            try {
                zzru.zzru().zzj(zze.zzac(context));
            } catch (RemoteException e) {
                zzkd.zzb("Unable to call Adapter.onContextChanged.", e);
            }
        }
    }

    public void onRewardedVideoAdClosed() {
        mo5811a();
    }

    public void onRewardedVideoAdLeftApplication() {
        mo5817b();
    }

    public void onRewardedVideoAdOpened() {
        mo5830a(this.f4011f.zzapb, false);
        mo5819c();
    }

    public void onRewardedVideoStarted() {
        if (!(this.f4011f.zzapb == null || this.f4011f.zzapb.zzbon == null)) {
            zzu.zzgf().zza(this.f4011f.zzagf, this.f4011f.zzaow.zzcs, this.f4011f.zzapb, this.f4011f.zzaou, false, this.f4011f.zzapb.zzbon.zzbnd);
        }
        mo5821e();
    }

    public void pause() {
        zzab.zzhi("pause must be called on the main UI thread.");
        for (String str : this.f6510m.keySet()) {
            try {
                zzjm zzjm = (zzjm) this.f6510m.get(str);
                if (!(zzjm == null || zzjm.zzru() == null)) {
                    zzjm.zzru().pause();
                }
            } catch (RemoteException e) {
                String valueOf = String.valueOf(str);
                zzkd.zzcx(valueOf.length() != 0 ? "Fail to pause adapter: ".concat(valueOf) : new String("Fail to pause adapter: "));
            }
        }
    }

    public void resume() {
        zzab.zzhi("resume must be called on the main UI thread.");
        for (String str : this.f6510m.keySet()) {
            try {
                zzjm zzjm = (zzjm) this.f6510m.get(str);
                if (!(zzjm == null || zzjm.zzru() == null)) {
                    zzjm.zzru().resume();
                }
            } catch (RemoteException e) {
                String valueOf = String.valueOf(str);
                zzkd.zzcx(valueOf.length() != 0 ? "Fail to resume adapter: ".concat(valueOf) : new String("Fail to resume adapter: "));
            }
        }
    }

    public void zza(RewardedVideoAdRequestParcel rewardedVideoAdRequestParcel) {
        zzab.zzhi("loadAd must be called on the main UI thread.");
        if (TextUtils.isEmpty(rewardedVideoAdRequestParcel.zzaou)) {
            zzkd.zzcx("Invalid ad unit id. Aborting.");
            return;
        }
        this.f6511n = false;
        this.f4011f.zzaou = rewardedVideoAdRequestParcel.zzaou;
        super.zzb(rewardedVideoAdRequestParcel.zzcar);
    }

    public void zza(zzju.zza zza, zzdk zzdk) {
        if (zza.errorCode != -2) {
            zzkh.zzclc.post(new C1708lc(this, zza));
            return;
        }
        this.f4011f.zzapc = zza;
        if (zza.zzcig == null) {
            this.f4011f.zzapc = m7269a(zza);
        }
        this.f4011f.zzapw = 0;
        this.f4011f.zzaoz = zzu.zzfp().zza(this.f4011f.zzagf, this.f4011f.zzapc, this);
    }

    public boolean zza(zzju zzju, zzju zzju2) {
        return true;
    }

    public void zzc(RewardItemParcel rewardItemParcel) {
        if (!(this.f4011f.zzapb == null || this.f4011f.zzapb.zzbon == null)) {
            zzu.zzgf().zza(this.f4011f.zzagf, this.f4011f.zzaow.zzcs, this.f4011f.zzapb, this.f4011f.zzaou, false, this.f4011f.zzapb.zzbon.zzbne);
        }
        if (!(this.f4011f.zzapb == null || this.f4011f.zzapb.zzcig == null || TextUtils.isEmpty(this.f4011f.zzapb.zzcig.zzbnt))) {
            rewardItemParcel = new RewardItemParcel(this.f4011f.zzapb.zzcig.zzbnt, this.f4011f.zzapb.zzcig.zzbnu);
        }
        mo5814a(rewardItemParcel);
    }

    /* JADX WARNING: Removed duplicated region for block: B:14:0x0036  */
    /* JADX WARNING: Removed duplicated region for block: B:16:0x003f  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public com.google.android.gms.internal.zzjm zzcf(java.lang.String r6) {
        /*
            r5 = this;
            java.util.Map r0 = r5.f6510m
            java.lang.Object r0 = r0.get(r6)
            com.google.android.gms.internal.zzjm r0 = (com.google.android.gms.internal.zzjm) r0
            if (r0 != 0) goto L_0x0026
            com.google.android.gms.internal.zzgj r1 = r5.f4015j     // Catch:{ Exception -> 0x0027 }
            java.lang.String r2 = "com.google.ads.mediation.admob.AdMobAdapter"
            boolean r2 = r2.equals(r6)     // Catch:{ Exception -> 0x0027 }
            if (r2 == 0) goto L_0x0048
            com.google.android.gms.internal.zzgi r1 = f6509l     // Catch:{ Exception -> 0x0027 }
            r2 = r1
        L_0x0017:
            com.google.android.gms.internal.zzjm r1 = new com.google.android.gms.internal.zzjm     // Catch:{ Exception -> 0x0027 }
            com.google.android.gms.internal.zzgk r2 = r2.zzbm(r6)     // Catch:{ Exception -> 0x0027 }
            r1.<init>(r2, r5)     // Catch:{ Exception -> 0x0027 }
            java.util.Map r0 = r5.f6510m     // Catch:{ Exception -> 0x0045 }
            r0.put(r6, r1)     // Catch:{ Exception -> 0x0045 }
            r0 = r1
        L_0x0026:
            return r0
        L_0x0027:
            r1 = move-exception
            r2 = r1
            r1 = r0
        L_0x002a:
            java.lang.String r3 = "Fail to instantiate adapter "
            java.lang.String r0 = java.lang.String.valueOf(r6)
            int r4 = r0.length()
            if (r4 == 0) goto L_0x003f
            java.lang.String r0 = r3.concat(r0)
        L_0x003a:
            com.google.android.gms.internal.zzkd.zzd(r0, r2)
            r0 = r1
            goto L_0x0026
        L_0x003f:
            java.lang.String r0 = new java.lang.String
            r0.<init>(r3)
            goto L_0x003a
        L_0x0045:
            r0 = move-exception
            r2 = r0
            goto L_0x002a
        L_0x0048:
            r2 = r1
            goto L_0x0017
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.zzjf.zzcf(java.lang.String):com.google.android.gms.internal.zzjm");
    }

    public void zzrq() {
        zzab.zzhi("showAd must be called on the main UI thread.");
        if (!isLoaded()) {
            zzkd.zzcx("The reward video has not loaded.");
            return;
        }
        this.f6511n = true;
        zzjm zzcf = zzcf(this.f4011f.zzapb.zzbop);
        if (zzcf != null && zzcf.zzru() != null) {
            try {
                zzcf.zzru().showVideo();
            } catch (RemoteException e) {
                zzkd.zzd("Could not call showVideo.", e);
            }
        }
    }

    public void zzrr() {
        onAdClicked();
    }
}
