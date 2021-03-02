package com.google.android.gms.ads.internal.purchase;

import android.content.Intent;
import android.os.RemoteException;
import com.google.android.gms.internal.zzkd;

/* renamed from: com.google.android.gms.ads.internal.purchase.a */
class C1296a implements Runnable {

    /* renamed from: a */
    final /* synthetic */ zzf f3858a;

    /* renamed from: b */
    final /* synthetic */ Intent f3859b;

    /* renamed from: c */
    final /* synthetic */ zzc f3860c;

    C1296a(zzc zzc, zzf zzf, Intent intent) {
        this.f3860c = zzc;
        this.f3858a = zzf;
        this.f3859b = intent;
    }

    public void run() {
        try {
            if (this.f3860c.f3873h.zza(this.f3858a.zzbxg, -1, this.f3859b)) {
                this.f3860c.f3869d.zza(new zzg(this.f3860c.f3868c, this.f3858a.zzbxh, true, -1, this.f3859b, this.f3858a));
            } else {
                this.f3860c.f3869d.zza(new zzg(this.f3860c.f3868c, this.f3858a.zzbxh, false, -1, this.f3859b, this.f3858a));
            }
        } catch (RemoteException e) {
            zzkd.zzcx("Fail to verify and dispatch pending transaction");
        }
    }
}
