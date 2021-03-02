package com.google.android.gms.measurement.internal;

import android.os.RemoteException;

/* renamed from: com.google.android.gms.measurement.internal.m */
class C1933m implements Runnable {

    /* renamed from: a */
    final /* synthetic */ zzad f7217a;

    C1933m(zzad zzad) {
        this.f7217a = zzad;
    }

    public void run() {
        zzm c = this.f7217a.f7248b;
        if (c == null) {
            this.f7217a.zzbsd().zzbsv().log("Failed to send measurementEnabled to service");
            return;
        }
        try {
            c.zzb(this.f7217a.zzbrv().mo9579a(this.f7217a.zzbsd().zzbtd()));
            this.f7217a.m7758i();
        } catch (RemoteException e) {
            this.f7217a.zzbsd().zzbsv().zzj("Failed to send measurementEnabled to AppMeasurementService", e);
        }
    }
}
