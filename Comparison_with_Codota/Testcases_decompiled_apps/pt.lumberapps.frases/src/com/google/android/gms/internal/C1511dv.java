package com.google.android.gms.internal;

import java.util.Map;

/* renamed from: com.google.android.gms.internal.dv */
class C1511dv implements zzep {

    /* renamed from: a */
    final /* synthetic */ zzcd f4947a;

    C1511dv(zzcd zzcd) {
        this.f4947a = zzcd;
    }

    public void zza(zzlh zzlh, Map map) {
        if (this.f4947a.mo8148a(map)) {
            String valueOf = String.valueOf(this.f4947a.f6002b.zzhn());
            zzkd.zzcv(valueOf.length() != 0 ? "Received request to untrack: ".concat(valueOf) : new String("Received request to untrack: "));
            this.f4947a.mo8152c();
        }
    }
}
