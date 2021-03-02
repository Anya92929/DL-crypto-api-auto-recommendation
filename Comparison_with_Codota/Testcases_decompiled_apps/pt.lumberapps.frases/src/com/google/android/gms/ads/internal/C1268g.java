package com.google.android.gms.ads.internal;

import android.os.RemoteException;
import com.google.android.gms.internal.zzdk;
import com.google.android.gms.internal.zzdl;
import com.google.android.gms.internal.zzjo;
import com.google.android.gms.internal.zzju;
import com.google.android.gms.internal.zzkd;
import com.google.android.gms.internal.zzlh;

/* renamed from: com.google.android.gms.ads.internal.g */
class C1268g implements Runnable {

    /* renamed from: a */
    final /* synthetic */ zzju.zza f3709a;

    /* renamed from: b */
    final /* synthetic */ zzjo f3710b;

    /* renamed from: c */
    final /* synthetic */ zzdk f3711c;

    /* renamed from: d */
    final /* synthetic */ zzc f3712d;

    C1268g(zzc zzc, zzju.zza zza, zzjo zzjo, zzdk zzdk) {
        this.f3712d = zzc;
        this.f3709a = zza;
        this.f3710b = zzjo;
        this.f3711c = zzdk;
    }

    public void run() {
        if (this.f3709a.zzciq.zzcch && this.f3712d.f4011f.f4125p != null) {
            String str = null;
            if (this.f3709a.zzciq.zzbto != null) {
                str = zzu.zzfq().zzco(this.f3709a.zzciq.zzbto);
            }
            zzdl zzdl = new zzdl(this.f3712d, str, this.f3709a.zzciq.body);
            this.f3712d.f4011f.zzapw = 1;
            try {
                this.f3712d.f4009d = false;
                this.f3712d.f4011f.f4125p.zza(zzdl);
                return;
            } catch (RemoteException e) {
                zzkd.zzd("Could not call the onCustomRenderedAdLoadedListener.", e);
                this.f3712d.f4009d = true;
            }
        }
        zze zze = new zze(this.f3712d.f4011f.zzagf, this.f3709a);
        zzlh a = this.f3712d.mo5843a(this.f3709a, zze, this.f3710b);
        a.setOnTouchListener(new C1269h(this, zze));
        a.setOnClickListener(new C1270i(this, zze));
        this.f3712d.f4011f.zzapw = 0;
        this.f3712d.f4011f.zzaoz = zzu.zzfp().zza(this.f3712d.f4011f.zzagf, this.f3712d, this.f3709a, this.f3712d.f4011f.f4111b, a, this.f3712d.f4015j, this.f3712d, this.f3711c);
    }
}
