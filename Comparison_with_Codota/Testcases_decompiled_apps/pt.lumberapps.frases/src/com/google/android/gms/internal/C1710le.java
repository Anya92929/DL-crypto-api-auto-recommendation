package com.google.android.gms.internal;

import android.os.RemoteException;
import com.google.android.gms.ads.internal.client.AdRequestParcel;
import com.google.android.gms.ads.internal.reward.mediation.client.zza;
import com.google.android.gms.dynamic.zze;

/* renamed from: com.google.android.gms.internal.le */
class C1710le implements Runnable {

    /* renamed from: a */
    final /* synthetic */ zzgk f5281a;

    /* renamed from: b */
    final /* synthetic */ AdRequestParcel f5282b;

    /* renamed from: c */
    final /* synthetic */ zzjj f5283c;

    /* renamed from: d */
    final /* synthetic */ zzjg f5284d;

    C1710le(zzjg zzjg, zzgk zzgk, AdRequestParcel adRequestParcel, zzjj zzjj) {
        this.f5284d = zzjg;
        this.f5281a = zzgk;
        this.f5282b = adRequestParcel;
        this.f5283c = zzjj;
    }

    public void run() {
        try {
            this.f5281a.zza(zze.zzac(this.f5284d.f6513b), this.f5282b, (String) null, (zza) this.f5283c, this.f5284d.f6518g);
        } catch (RemoteException e) {
            RemoteException remoteException = e;
            String valueOf = String.valueOf(this.f5284d.f6517f);
            zzkd.zzd(valueOf.length() != 0 ? "Fail to initialize adapter ".concat(valueOf) : new String("Fail to initialize adapter "), remoteException);
            this.f5284d.zza(this.f5284d.f6517f, 0);
        }
    }
}
