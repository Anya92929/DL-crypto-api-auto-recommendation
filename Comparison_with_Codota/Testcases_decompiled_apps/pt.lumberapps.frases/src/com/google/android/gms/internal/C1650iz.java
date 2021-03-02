package com.google.android.gms.internal;

import android.os.RemoteException;
import com.google.android.gms.ads.internal.util.client.zzb;

/* renamed from: com.google.android.gms.internal.iz */
class C1650iz implements Runnable {

    /* renamed from: a */
    final /* synthetic */ zzgw f5161a;

    C1650iz(zzgw zzgw) {
        this.f5161a = zzgw;
    }

    public void run() {
        try {
            this.f5161a.f6287a.onAdLoaded();
        } catch (RemoteException e) {
            zzb.zzd("Could not call onAdLoaded.", e);
        }
    }
}
