package com.google.android.gms.internal;

import android.os.RemoteException;
import com.google.android.gms.ads.internal.util.client.zzb;

/* renamed from: com.google.android.gms.internal.iy */
class C1649iy implements Runnable {

    /* renamed from: a */
    final /* synthetic */ zzgw f5160a;

    C1649iy(zzgw zzgw) {
        this.f5160a = zzgw;
    }

    public void run() {
        try {
            this.f5160a.f6287a.onAdOpened();
        } catch (RemoteException e) {
            zzb.zzd("Could not call onAdOpened.", e);
        }
    }
}
