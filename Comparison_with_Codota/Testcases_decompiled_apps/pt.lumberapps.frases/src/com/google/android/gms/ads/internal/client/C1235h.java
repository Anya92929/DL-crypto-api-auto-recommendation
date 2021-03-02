package com.google.android.gms.ads.internal.client;

import android.os.RemoteException;
import com.google.android.gms.ads.internal.util.client.zzb;

/* renamed from: com.google.android.gms.ads.internal.client.h */
class C1235h implements Runnable {

    /* renamed from: a */
    final /* synthetic */ zzak f3460a;

    C1235h(zzak zzak) {
        this.f3460a = zzak;
    }

    public void run() {
        if (this.f3460a.f3573a != null) {
            try {
                this.f3460a.f3573a.onAdFailedToLoad(1);
            } catch (RemoteException e) {
                zzb.zzd("Could not notify onAdFailedToLoad event.", e);
            }
        }
    }
}
