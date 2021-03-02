package com.google.android.gms.internal;

import com.google.android.gms.ads.internal.overlay.AdOverlayInfoParcel;
import com.google.android.gms.ads.internal.zzu;

/* renamed from: com.google.android.gms.internal.jj */
class C1661jj implements Runnable {

    /* renamed from: a */
    final /* synthetic */ AdOverlayInfoParcel f5174a;

    /* renamed from: b */
    final /* synthetic */ zzgy f5175b;

    C1661jj(zzgy zzgy, AdOverlayInfoParcel adOverlayInfoParcel) {
        this.f5175b = zzgy;
        this.f5174a = adOverlayInfoParcel;
    }

    public void run() {
        zzu.zzfo().zza(this.f5175b.f6288a, this.f5174a);
    }
}
