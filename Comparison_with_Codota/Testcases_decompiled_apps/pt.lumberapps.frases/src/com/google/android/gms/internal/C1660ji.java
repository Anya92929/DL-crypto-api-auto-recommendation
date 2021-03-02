package com.google.android.gms.internal;

import com.google.android.gms.ads.internal.overlay.zzg;
import com.google.android.gms.ads.internal.util.client.zzb;

/* renamed from: com.google.android.gms.internal.ji */
class C1660ji implements zzg {

    /* renamed from: a */
    final /* synthetic */ zzgy f5173a;

    C1660ji(zzgy zzgy) {
        this.f5173a = zzgy;
    }

    public void onPause() {
        zzb.zzcv("AdMobCustomTabsAdapter overlay is paused.");
    }

    public void onResume() {
        zzb.zzcv("AdMobCustomTabsAdapter overlay is resumed.");
    }

    public void zzdx() {
        zzb.zzcv("AdMobCustomTabsAdapter overlay is closed.");
        this.f5173a.f6290c.onAdClosed(this.f5173a);
        this.f5173a.f6289b.zzd(this.f5173a.f6288a);
    }

    public void zzdy() {
        zzb.zzcv("Opening AdMobCustomTabsAdapter overlay.");
        this.f5173a.f6290c.onAdOpened(this.f5173a);
    }
}
