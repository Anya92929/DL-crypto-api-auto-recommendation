package com.google.android.gms.ads.internal.client;

import android.os.RemoteException;
import com.google.android.gms.ads.internal.util.client.zzb;

/* renamed from: com.google.android.gms.ads.internal.client.i */
class C1236i implements Runnable {

    /* renamed from: a */
    final /* synthetic */ zzan f3461a;

    C1236i(zzan zzan) {
        this.f3461a = zzan;
    }

    public void run() {
        if (this.f3461a.f3574a != null) {
            try {
                this.f3461a.f3574a.onRewardedVideoAdFailedToLoad(1);
            } catch (RemoteException e) {
                zzb.zzd("Could not notify onRewardedVideoAdFailedToLoad event.", e);
            }
        }
    }
}
