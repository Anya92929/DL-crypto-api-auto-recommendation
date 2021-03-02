package com.google.android.gms.internal;

import java.util.Map;

/* renamed from: com.google.android.gms.internal.dw */
class C1512dw implements zzep {

    /* renamed from: a */
    final /* synthetic */ zzcd f4948a;

    C1512dw(zzcd zzcd) {
        this.f4948a = zzcd;
    }

    public void zza(zzlh zzlh, Map map) {
        if (this.f4948a.mo8148a(map) && map.containsKey("isVisible")) {
            this.f4948a.mo8147a(Boolean.valueOf("1".equals(map.get("isVisible")) || "true".equals(map.get("isVisible"))).booleanValue());
        }
    }
}
