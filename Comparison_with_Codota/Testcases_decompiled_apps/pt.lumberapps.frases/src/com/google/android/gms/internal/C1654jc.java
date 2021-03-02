package com.google.android.gms.internal;

import android.os.RemoteException;
import com.google.android.gms.ads.internal.util.client.zzb;

/* renamed from: com.google.android.gms.internal.jc */
class C1654jc implements Runnable {

    /* renamed from: a */
    final /* synthetic */ zzgw f5166a;

    C1654jc(zzgw zzgw) {
        this.f5166a = zzgw;
    }

    public void run() {
        try {
            this.f5166a.f6287a.onAdLeftApplication();
        } catch (RemoteException e) {
            zzb.zzd("Could not call onAdLeftApplication.", e);
        }
    }
}
