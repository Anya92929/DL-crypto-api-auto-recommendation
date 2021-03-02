package com.google.android.gms.ads.internal;

import android.os.RemoteException;
import com.google.android.gms.ads.internal.formats.zze;
import com.google.android.gms.internal.zzkd;

/* renamed from: com.google.android.gms.ads.internal.aa */
class C1214aa implements Runnable {

    /* renamed from: a */
    final /* synthetic */ zze f3432a;

    /* renamed from: b */
    final /* synthetic */ zzq f3433b;

    C1214aa(zzq zzq, zze zze) {
        this.f3433b = zzq;
        this.f3432a = zze;
    }

    public void run() {
        try {
            if (this.f3433b.f4011f.f4120k != null) {
                this.f3433b.f4011f.f4120k.zza(this.f3432a);
            }
        } catch (RemoteException e) {
            zzkd.zzd("Could not call OnContentAdLoadedListener.onContentAdLoaded().", e);
        }
    }
}
