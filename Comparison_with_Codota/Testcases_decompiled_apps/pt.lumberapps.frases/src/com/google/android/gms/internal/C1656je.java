package com.google.android.gms.internal;

import android.os.RemoteException;
import com.google.android.gms.ads.internal.util.client.zzb;

/* renamed from: com.google.android.gms.internal.je */
class C1656je implements Runnable {

    /* renamed from: a */
    final /* synthetic */ zzgw f5168a;

    C1656je(zzgw zzgw) {
        this.f5168a = zzgw;
    }

    public void run() {
        try {
            this.f5168a.f6287a.onAdLoaded();
        } catch (RemoteException e) {
            zzb.zzd("Could not call onAdLoaded.", e);
        }
    }
}
