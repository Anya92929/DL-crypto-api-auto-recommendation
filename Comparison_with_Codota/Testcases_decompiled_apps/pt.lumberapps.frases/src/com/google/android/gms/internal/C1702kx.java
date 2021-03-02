package com.google.android.gms.internal;

import java.util.Map;

/* renamed from: com.google.android.gms.internal.kx */
class C1702kx implements zzep {

    /* renamed from: a */
    final /* synthetic */ zzir f5257a;

    C1702kx(zzir zzir) {
        this.f5257a = zzir;
    }

    public void zza(zzlh zzlh, Map map) {
        synchronized (this.f5257a.f6440b) {
            if (!this.f5257a.f6443e.isDone()) {
                if (this.f5257a.f6441c.equals(map.get("request_id"))) {
                    C1706la laVar = new C1706la(1, map);
                    String valueOf = String.valueOf(laVar.mo7457e());
                    String valueOf2 = String.valueOf(laVar.mo7454b());
                    zzkd.zzcx(new StringBuilder(String.valueOf(valueOf).length() + 24 + String.valueOf(valueOf2).length()).append("Invalid ").append(valueOf).append(" request error: ").append(valueOf2).toString());
                    this.f5257a.f6443e.zzh(laVar);
                }
            }
        }
    }
}
