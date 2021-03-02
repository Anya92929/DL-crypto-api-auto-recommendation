package com.google.android.gms.internal;

import java.util.Map;

/* renamed from: com.google.android.gms.internal.fl */
final class C1555fl implements zzep {
    C1555fl() {
    }

    public void zza(zzlh zzlh, Map map) {
        String str = (String) map.get("tx");
        String str2 = (String) map.get("ty");
        String str3 = (String) map.get("td");
        try {
            int parseInt = Integer.parseInt(str);
            int parseInt2 = Integer.parseInt(str2);
            int parseInt3 = Integer.parseInt(str3);
            zzas zzul = zzlh.zzul();
            if (zzul != null) {
                zzul.zzaw().zza(parseInt, parseInt2, parseInt3);
            }
        } catch (NumberFormatException e) {
            zzkd.zzcx("Could not parse touch parameters from gmsg.");
        }
    }
}
