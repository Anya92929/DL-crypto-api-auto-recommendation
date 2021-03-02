package com.google.android.gms.internal;

import android.os.RemoteException;
import com.google.ads.AdRequest;
import com.google.android.gms.ads.internal.util.client.zzb;

/* renamed from: com.google.android.gms.internal.iw */
class C1647iw implements Runnable {

    /* renamed from: a */
    final /* synthetic */ AdRequest.ErrorCode f5157a;

    /* renamed from: b */
    final /* synthetic */ zzgw f5158b;

    C1647iw(zzgw zzgw, AdRequest.ErrorCode errorCode) {
        this.f5158b = zzgw;
        this.f5157a = errorCode;
    }

    public void run() {
        try {
            this.f5158b.f6287a.onAdFailedToLoad(zzgx.zza(this.f5157a));
        } catch (RemoteException e) {
            zzb.zzd("Could not call onAdFailedToLoad.", e);
        }
    }
}
