package com.google.android.gms.measurement.internal;

import android.os.RemoteException;
import android.text.TextUtils;

/* renamed from: com.google.android.gms.measurement.internal.n */
class C1934n implements Runnable {

    /* renamed from: a */
    final /* synthetic */ String f7218a;

    /* renamed from: b */
    final /* synthetic */ EventParcel f7219b;

    /* renamed from: c */
    final /* synthetic */ zzad f7220c;

    C1934n(zzad zzad, String str, EventParcel eventParcel) {
        this.f7220c = zzad;
        this.f7218a = str;
        this.f7219b = eventParcel;
    }

    public void run() {
        zzm c = this.f7220c.f7248b;
        if (c == null) {
            this.f7220c.zzbsd().zzbsv().log("Discarding data. Failed to send event to service");
            return;
        }
        try {
            if (TextUtils.isEmpty(this.f7218a)) {
                c.zza(this.f7219b, this.f7220c.zzbrv().mo9579a(this.f7220c.zzbsd().zzbtd()));
            } else {
                c.zza(this.f7219b, this.f7218a, this.f7220c.zzbsd().zzbtd());
            }
            this.f7220c.m7758i();
        } catch (RemoteException e) {
            this.f7220c.zzbsd().zzbsv().zzj("Failed to send event to AppMeasurementService", e);
        }
    }
}
