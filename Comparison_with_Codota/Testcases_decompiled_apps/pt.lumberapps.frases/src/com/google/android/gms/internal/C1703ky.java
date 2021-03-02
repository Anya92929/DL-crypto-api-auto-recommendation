package com.google.android.gms.internal;

import java.util.Map;

/* renamed from: com.google.android.gms.internal.ky */
class C1703ky implements zzep {

    /* renamed from: a */
    final /* synthetic */ zzir f5258a;

    C1703ky(zzir zzir) {
        this.f5258a = zzir;
    }

    public void zza(zzlh zzlh, Map map) {
        synchronized (this.f5258a.f6440b) {
            if (!this.f5258a.f6443e.isDone()) {
                C1706la laVar = new C1706la(-2, map);
                if (this.f5258a.f6441c.equals(laVar.mo7459g())) {
                    String d = laVar.mo7456d();
                    if (d == null) {
                        zzkd.zzcx("URL missing in loadAdUrl GMSG.");
                        return;
                    }
                    if (d.contains("%40mediation_adapters%40")) {
                        String replaceAll = d.replaceAll("%40mediation_adapters%40", zzkb.zza(zzlh.getContext(), (String) map.get("check_adapters"), this.f5258a.f6442d));
                        laVar.mo7453a(replaceAll);
                        String valueOf = String.valueOf(replaceAll);
                        zzkd.m7303v(valueOf.length() != 0 ? "Ad request URL modified to ".concat(valueOf) : new String("Ad request URL modified to "));
                    }
                    this.f5258a.f6443e.zzh(laVar);
                }
            }
        }
    }
}
