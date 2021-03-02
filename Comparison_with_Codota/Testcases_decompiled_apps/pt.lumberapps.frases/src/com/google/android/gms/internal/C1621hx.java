package com.google.android.gms.internal;

import java.util.Map;

/* renamed from: com.google.android.gms.internal.hx */
class C1621hx implements zzep {

    /* renamed from: a */
    final /* synthetic */ zzfp f5118a;

    /* renamed from: b */
    final /* synthetic */ zzks f5119b;

    /* renamed from: c */
    final /* synthetic */ C1616hs f5120c;

    C1621hx(C1616hs hsVar, zzfp zzfp, zzks zzks) {
        this.f5120c = hsVar;
        this.f5118a = zzfp;
        this.f5119b = zzks;
    }

    public void zza(zzlh zzlh, Map map) {
        synchronized (this.f5120c.f5111c.f6193a) {
            zzkd.zzcw("JS Engine is requesting an update");
            if (this.f5120c.f5111c.f6200h == 0) {
                zzkd.zzcw("Starting reload.");
                int unused = this.f5120c.f5111c.f6200h = 2;
                this.f5120c.f5111c.mo8386a(this.f5120c.f5109a);
            }
            this.f5118a.zzb("/requestReload", (zzep) this.f5119b.get());
        }
    }
}
