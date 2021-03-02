package com.google.android.gms.internal;

import android.os.RemoteException;
import com.google.android.gms.ads.internal.util.client.zzb;

/* renamed from: com.google.android.gms.internal.ix */
class C1648ix implements Runnable {

    /* renamed from: a */
    final /* synthetic */ zzgw f5159a;

    C1648ix(zzgw zzgw) {
        this.f5159a = zzgw;
    }

    public void run() {
        try {
            this.f5159a.f6287a.onAdLeftApplication();
        } catch (RemoteException e) {
            zzb.zzd("Could not call onAdLeftApplication.", e);
        }
    }
}
