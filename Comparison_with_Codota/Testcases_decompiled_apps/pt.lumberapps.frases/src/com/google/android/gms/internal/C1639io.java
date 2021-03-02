package com.google.android.gms.internal;

import android.os.RemoteException;

/* renamed from: com.google.android.gms.internal.io */
class C1639io implements Runnable {

    /* renamed from: a */
    final /* synthetic */ zzge f5148a;

    /* renamed from: b */
    final /* synthetic */ zzgh f5149b;

    C1639io(zzgh zzgh, zzge zzge) {
        this.f5149b = zzgh;
        this.f5148a = zzge;
    }

    public void run() {
        try {
            this.f5148a.zzboo.destroy();
        } catch (RemoteException e) {
            zzkd.zzd("Could not destroy mediation adapter.", e);
        }
    }
}
