package com.google.android.gms.ads.internal.client;

import android.os.RemoteException;
import com.google.android.gms.ads.internal.util.client.zzb;

/* renamed from: com.google.android.gms.ads.internal.client.g */
class C1234g implements Runnable {

    /* renamed from: a */
    final /* synthetic */ C1233f f3459a;

    C1234g(C1233f fVar) {
        this.f3459a = fVar;
    }

    public void run() {
        if (this.f3459a.f3458a.f3572a != null) {
            try {
                this.f3459a.f3458a.f3572a.onAdFailedToLoad(1);
            } catch (RemoteException e) {
                zzb.zzd("Could not notify onAdFailedToLoad event.", e);
            }
        }
    }
}
