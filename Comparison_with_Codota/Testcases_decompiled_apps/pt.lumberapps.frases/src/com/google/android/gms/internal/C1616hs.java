package com.google.android.gms.internal;

import com.google.android.gms.internal.zzfs;

/* renamed from: com.google.android.gms.internal.hs */
class C1616hs implements Runnable {

    /* renamed from: a */
    final /* synthetic */ zzas f5109a;

    /* renamed from: b */
    final /* synthetic */ zzfs.zzd f5110b;

    /* renamed from: c */
    final /* synthetic */ zzfs f5111c;

    C1616hs(zzfs zzfs, zzas zzas, zzfs.zzd zzd) {
        this.f5111c = zzfs;
        this.f5109a = zzas;
        this.f5110b = zzd;
    }

    public void run() {
        zzfp a = this.f5111c.mo8385a(this.f5111c.f6194b, this.f5111c.f6196d, this.f5109a);
        a.zza(new C1617ht(this, a));
        a.zza("/jsLoaded", (zzep) new C1620hw(this, a));
        zzks zzks = new zzks();
        C1621hx hxVar = new C1621hx(this, a, zzks);
        zzks.set(hxVar);
        a.zza("/requestReload", (zzep) hxVar);
        if (this.f5111c.f6195c.endsWith(".js")) {
            a.zzbg(this.f5111c.f6195c);
        } else if (this.f5111c.f6195c.startsWith("<html>")) {
            a.zzbi(this.f5111c.f6195c);
        } else {
            a.zzbh(this.f5111c.f6195c);
        }
        zzkh.zzclc.postDelayed(new C1622hy(this, a), (long) C1627ic.f5129a);
    }
}
