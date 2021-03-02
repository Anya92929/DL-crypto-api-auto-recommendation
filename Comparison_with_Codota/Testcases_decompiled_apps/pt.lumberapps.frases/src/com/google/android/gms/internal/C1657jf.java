package com.google.android.gms.internal;

import android.os.RemoteException;
import com.google.android.gms.ads.internal.util.client.zzb;

/* renamed from: com.google.android.gms.internal.jf */
class C1657jf implements Runnable {

    /* renamed from: a */
    final /* synthetic */ zzgw f5169a;

    C1657jf(zzgw zzgw) {
        this.f5169a = zzgw;
    }

    public void run() {
        try {
            this.f5169a.f6287a.onAdClosed();
        } catch (RemoteException e) {
            zzb.zzd("Could not call onAdClosed.", e);
        }
    }
}
