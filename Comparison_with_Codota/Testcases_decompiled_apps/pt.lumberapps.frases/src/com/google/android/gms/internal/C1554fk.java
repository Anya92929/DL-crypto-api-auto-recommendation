package com.google.android.gms.internal;

import java.util.Map;

/* renamed from: com.google.android.gms.internal.fk */
final class C1554fk implements zzep {
    C1554fk() {
    }

    public void zza(zzlh zzlh, Map map) {
        String valueOf = String.valueOf((String) map.get("string"));
        zzkd.zzcw(valueOf.length() != 0 ? "Received log message: ".concat(valueOf) : new String("Received log message: "));
    }
}
