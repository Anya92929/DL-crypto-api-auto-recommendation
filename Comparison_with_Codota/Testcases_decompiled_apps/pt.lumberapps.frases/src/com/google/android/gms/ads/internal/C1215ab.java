package com.google.android.gms.ads.internal;

import android.os.RemoteException;
import com.google.android.gms.ads.internal.formats.zzf;
import com.google.android.gms.internal.zzee;
import com.google.android.gms.internal.zzju;
import com.google.android.gms.internal.zzkd;

/* renamed from: com.google.android.gms.ads.internal.ab */
class C1215ab implements Runnable {

    /* renamed from: a */
    final /* synthetic */ String f3434a;

    /* renamed from: b */
    final /* synthetic */ zzju f3435b;

    /* renamed from: c */
    final /* synthetic */ zzq f3436c;

    C1215ab(zzq zzq, String str, zzju zzju) {
        this.f3436c = zzq;
        this.f3434a = str;
        this.f3435b = zzju;
    }

    public void run() {
        try {
            ((zzee) this.f3436c.f4011f.f4122m.get(this.f3434a)).zza((zzf) this.f3435b.zzcim);
        } catch (RemoteException e) {
            zzkd.zzd("Could not call onCustomTemplateAdLoadedListener.onCustomTemplateAdLoaded().", e);
        }
    }
}
