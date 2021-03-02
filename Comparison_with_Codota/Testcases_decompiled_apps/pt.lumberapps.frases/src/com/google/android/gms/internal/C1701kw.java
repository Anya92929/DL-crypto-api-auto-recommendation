package com.google.android.gms.internal;

import android.os.RemoteException;
import com.google.android.gms.ads.internal.request.AdRequestInfoParcel;
import com.google.android.gms.ads.internal.request.AdResponseParcel;
import com.google.android.gms.ads.internal.request.zzl;
import com.google.android.gms.ads.internal.zzu;

/* renamed from: com.google.android.gms.internal.kw */
class C1701kw implements Runnable {

    /* renamed from: a */
    final /* synthetic */ AdRequestInfoParcel f5254a;

    /* renamed from: b */
    final /* synthetic */ zzl f5255b;

    /* renamed from: c */
    final /* synthetic */ zzip f5256c;

    C1701kw(zzip zzip, AdRequestInfoParcel adRequestInfoParcel, zzl zzl) {
        this.f5256c = zzip;
        this.f5254a = adRequestInfoParcel;
        this.f5255b = zzl;
    }

    public void run() {
        AdResponseParcel adResponseParcel;
        try {
            adResponseParcel = this.f5256c.zzd(this.f5254a);
        } catch (Exception e) {
            zzu.zzft().zzb((Throwable) e, true);
            zzkd.zzd("Could not fetch ad response due to an Exception.", e);
            adResponseParcel = null;
        }
        if (adResponseParcel == null) {
            adResponseParcel = new AdResponseParcel(0);
        }
        try {
            this.f5255b.zzb(adResponseParcel);
        } catch (RemoteException e2) {
            zzkd.zzd("Fail to forward ad response.", e2);
        }
    }
}
