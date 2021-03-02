package com.google.android.gms.internal;

import com.google.android.gms.internal.zzm;

/* renamed from: com.google.android.gms.internal.mn */
class C1746mn implements zzm.zza {

    /* renamed from: a */
    final /* synthetic */ String f5348a;

    /* renamed from: b */
    final /* synthetic */ C1750mr f5349b;

    /* renamed from: c */
    final /* synthetic */ zzkn f5350c;

    C1746mn(zzkn zzkn, String str, C1750mr mrVar) {
        this.f5350c = zzkn;
        this.f5348a = str;
        this.f5349b = mrVar;
    }

    public void zze(zzr zzr) {
        String str = this.f5348a;
        String valueOf = String.valueOf(zzr.toString());
        zzkd.zzcx(new StringBuilder(String.valueOf(str).length() + 21 + String.valueOf(valueOf).length()).append("Failed to load URL: ").append(str).append("\n").append(valueOf).toString());
        this.f5349b.zzb((Object) null);
    }
}
