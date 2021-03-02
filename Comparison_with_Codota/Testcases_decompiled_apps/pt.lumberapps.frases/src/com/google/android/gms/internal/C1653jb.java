package com.google.android.gms.internal;

import android.os.RemoteException;
import com.google.ads.AdRequest;
import com.google.android.gms.ads.internal.util.client.zzb;

/* renamed from: com.google.android.gms.internal.jb */
class C1653jb implements Runnable {

    /* renamed from: a */
    final /* synthetic */ AdRequest.ErrorCode f5164a;

    /* renamed from: b */
    final /* synthetic */ zzgw f5165b;

    C1653jb(zzgw zzgw, AdRequest.ErrorCode errorCode) {
        this.f5165b = zzgw;
        this.f5164a = errorCode;
    }

    public void run() {
        try {
            this.f5165b.f6287a.onAdFailedToLoad(zzgx.zza(this.f5164a));
        } catch (RemoteException e) {
            zzb.zzd("Could not call onAdFailedToLoad.", e);
        }
    }
}
