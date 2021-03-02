package com.google.android.gms.internal;

import java.util.Map;

/* renamed from: com.google.android.gms.internal.fn */
final class C1557fn implements zzep {
    C1557fn() {
    }

    public void zza(zzlh zzlh, Map map) {
        String str = (String) map.get("action");
        if ("pause".equals(str)) {
            zzlh.zzef();
        } else if ("resume".equals(str)) {
            zzlh.zzeg();
        }
    }
}
