package com.google.android.gms.internal;

import android.os.RemoteException;
import com.google.android.gms.ads.internal.util.client.zzb;

/* renamed from: com.google.android.gms.internal.iv */
class C1646iv implements Runnable {

    /* renamed from: a */
    final /* synthetic */ zzgw f5156a;

    C1646iv(zzgw zzgw) {
        this.f5156a = zzgw;
    }

    public void run() {
        try {
            this.f5156a.f6287a.onAdClicked();
        } catch (RemoteException e) {
            zzb.zzd("Could not call onAdClicked.", e);
        }
    }
}
