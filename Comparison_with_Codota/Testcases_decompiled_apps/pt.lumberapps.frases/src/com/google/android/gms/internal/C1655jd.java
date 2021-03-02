package com.google.android.gms.internal;

import android.os.RemoteException;
import com.google.android.gms.ads.internal.util.client.zzb;

/* renamed from: com.google.android.gms.internal.jd */
class C1655jd implements Runnable {

    /* renamed from: a */
    final /* synthetic */ zzgw f5167a;

    C1655jd(zzgw zzgw) {
        this.f5167a = zzgw;
    }

    public void run() {
        try {
            this.f5167a.f6287a.onAdOpened();
        } catch (RemoteException e) {
            zzb.zzd("Could not call onAdOpened.", e);
        }
    }
}
