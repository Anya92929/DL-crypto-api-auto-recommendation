package com.google.android.gms.internal;

import android.os.RemoteException;
import com.google.android.gms.ads.internal.util.client.zzb;

/* renamed from: com.google.android.gms.internal.ja */
class C1652ja implements Runnable {

    /* renamed from: a */
    final /* synthetic */ zzgw f5163a;

    C1652ja(zzgw zzgw) {
        this.f5163a = zzgw;
    }

    public void run() {
        try {
            this.f5163a.f6287a.onAdClosed();
        } catch (RemoteException e) {
            zzb.zzd("Could not call onAdClosed.", e);
        }
    }
}
