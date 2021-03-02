package com.google.android.gms.internal;

import java.util.Map;

/* renamed from: com.google.android.gms.internal.nd */
class C1763nd implements zzep {

    /* renamed from: a */
    final /* synthetic */ zzli f5382a;

    private C1763nd(zzli zzli) {
        this.f5382a = zzli;
    }

    /* synthetic */ C1763nd(zzli zzli, C1760na naVar) {
        this(zzli);
    }

    public void zza(zzlh zzlh, Map map) {
        if (map.keySet().contains("start")) {
            this.f5382a.m7340a();
        } else if (map.keySet().contains("stop")) {
            this.f5382a.m7344b();
        } else if (map.keySet().contains("cancel")) {
            this.f5382a.m7346c();
        }
    }
}
