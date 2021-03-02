package com.google.android.gms.ads.internal;

import android.os.RemoteException;
import com.google.android.gms.ads.internal.formats.zzd;
import com.google.android.gms.internal.zzkd;

/* renamed from: com.google.android.gms.ads.internal.z */
class C1329z implements Runnable {

    /* renamed from: a */
    final /* synthetic */ zzd f4004a;

    /* renamed from: b */
    final /* synthetic */ zzq f4005b;

    C1329z(zzq zzq, zzd zzd) {
        this.f4005b = zzq;
        this.f4004a = zzd;
    }

    public void run() {
        try {
            if (this.f4005b.f4011f.f4119j != null) {
                this.f4005b.f4011f.f4119j.zza(this.f4004a);
            }
        } catch (RemoteException e) {
            zzkd.zzd("Could not call OnAppInstallAdLoadedListener.onAppInstallAdLoaded().", e);
        }
    }
}
