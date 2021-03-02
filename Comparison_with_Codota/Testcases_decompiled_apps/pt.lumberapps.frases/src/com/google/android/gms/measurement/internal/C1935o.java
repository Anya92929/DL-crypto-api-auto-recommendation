package com.google.android.gms.measurement.internal;

import android.os.RemoteException;

/* renamed from: com.google.android.gms.measurement.internal.o */
class C1935o implements Runnable {

    /* renamed from: a */
    final /* synthetic */ UserAttributeParcel f7221a;

    /* renamed from: b */
    final /* synthetic */ zzad f7222b;

    C1935o(zzad zzad, UserAttributeParcel userAttributeParcel) {
        this.f7222b = zzad;
        this.f7221a = userAttributeParcel;
    }

    public void run() {
        zzm c = this.f7222b.f7248b;
        if (c == null) {
            this.f7222b.zzbsd().zzbsv().log("Discarding data. Failed to set user attribute");
            return;
        }
        try {
            c.zza(this.f7221a, this.f7222b.zzbrv().mo9579a(this.f7222b.zzbsd().zzbtd()));
            this.f7222b.m7758i();
        } catch (RemoteException e) {
            this.f7222b.zzbsd().zzbsv().zzj("Failed to send attribute to AppMeasurementService", e);
        }
    }
}
