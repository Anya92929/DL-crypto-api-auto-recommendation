package com.google.android.gms.internal;

import android.app.Activity;
import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.customtabs.CustomTabsIntent;
import android.text.TextUtils;
import com.google.android.gms.ads.internal.client.zza;
import com.google.android.gms.ads.internal.overlay.AdLauncherIntentInfoParcel;
import com.google.android.gms.ads.internal.overlay.AdOverlayInfoParcel;
import com.google.android.gms.ads.internal.overlay.zzp;
import com.google.android.gms.ads.internal.util.client.VersionInfoParcel;
import com.google.android.gms.ads.internal.util.client.zzb;
import com.google.android.gms.ads.internal.zzu;
import com.google.android.gms.ads.mediation.MediationAdRequest;
import com.google.android.gms.ads.mediation.MediationInterstitialAdapter;
import com.google.android.gms.ads.mediation.MediationInterstitialListener;
import com.google.android.gms.internal.zzdq;

@zzin
public class zzgy implements MediationInterstitialAdapter {
    /* access modifiers changed from: private */

    /* renamed from: a */
    public Activity f6288a;
    /* access modifiers changed from: private */

    /* renamed from: b */
    public zzdq f6289b;
    /* access modifiers changed from: private */

    /* renamed from: c */
    public MediationInterstitialListener f6290c;

    /* renamed from: d */
    private Uri f6291d;

    public static boolean zzp(Context context) {
        return zzdq.zzo(context);
    }

    public void onDestroy() {
        zzb.zzcv("Destroying AdMobCustomTabsAdapter adapter.");
        try {
            this.f6289b.zzd(this.f6288a);
        } catch (Exception e) {
            zzb.zzb("Exception while unbinding from CustomTabsService.", e);
        }
    }

    public void onPause() {
        zzb.zzcv("Pausing AdMobCustomTabsAdapter adapter.");
    }

    public void onResume() {
        zzb.zzcv("Resuming AdMobCustomTabsAdapter adapter.");
    }

    public void requestInterstitialAd(Context context, MediationInterstitialListener mediationInterstitialListener, Bundle bundle, MediationAdRequest mediationAdRequest, Bundle bundle2) {
        this.f6290c = mediationInterstitialListener;
        if (this.f6290c == null) {
            zzb.zzcx("Listener not set for mediation. Returning.");
        } else if (!(context instanceof Activity)) {
            zzb.zzcx("AdMobCustomTabs can only work with Activity context. Bailing out.");
            this.f6290c.onAdFailedToLoad(this, 0);
        } else if (!zzp(context)) {
            zzb.zzcx("Default browser does not support custom tabs. Bailing out.");
            this.f6290c.onAdFailedToLoad(this, 0);
        } else {
            String string = bundle.getString("tab_url");
            if (TextUtils.isEmpty(string)) {
                zzb.zzcx("The tab_url retrieved from mediation metadata is empty. Bailing out.");
                this.f6290c.onAdFailedToLoad(this, 0);
                return;
            }
            this.f6288a = (Activity) context;
            this.f6291d = Uri.parse(string);
            this.f6289b = new zzdq();
            this.f6289b.zza((zzdq.zza) new C1659jh(this));
            this.f6289b.zze(this.f6288a);
            this.f6290c.onAdLoaded(this);
        }
    }

    public void showInterstitial() {
        CustomTabsIntent build = new CustomTabsIntent.Builder(this.f6289b.zzkl()).build();
        build.intent.setData(this.f6291d);
        zzkh.zzclc.post(new C1661jj(this, new AdOverlayInfoParcel(new AdLauncherIntentInfoParcel(build.intent), (zza) null, new C1660ji(this), (zzp) null, new VersionInfoParcel(0, 0, false))));
        zzu.zzft().zzaf(false);
    }
}
