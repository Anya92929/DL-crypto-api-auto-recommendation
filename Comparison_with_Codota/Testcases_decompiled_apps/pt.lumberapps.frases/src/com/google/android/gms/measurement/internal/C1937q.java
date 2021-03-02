package com.google.android.gms.measurement.internal;

import android.os.RemoteException;

/* renamed from: com.google.android.gms.measurement.internal.q */
class C1937q implements Runnable {

    /* renamed from: a */
    final /* synthetic */ zzad f7226a;

    C1937q(zzad zzad) {
        this.f7226a = zzad;
    }

    public void run() {
        zzm c = this.f7226a.f7248b;
        if (c == null) {
            this.f7226a.zzbsd().zzbsv().log("Discarding data. Failed to send app launch");
            return;
        }
        try {
            c.zza(this.f7226a.zzbrv().mo9579a(this.f7226a.zzbsd().zzbtd()));
            this.f7226a.m7758i();
        } catch (RemoteException e) {
            this.f7226a.zzbsd().zzbsv().zzj("Failed to send app launch to AppMeasurementService", e);
        }
    }
}
