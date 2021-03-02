package com.google.android.gms.internal;

import com.google.android.gms.ads.internal.overlay.zzd;
import java.util.Map;

/* renamed from: com.google.android.gms.internal.fr */
final class C1561fr implements zzep {
    C1561fr() {
    }

    public void zza(zzlh zzlh, Map map) {
        zzd zzuh = zzlh.zzuh();
        if (zzuh != null) {
            zzuh.close();
            return;
        }
        zzd zzui = zzlh.zzui();
        if (zzui != null) {
            zzui.close();
        } else {
            zzkd.zzcx("A GMSG tried to close something that wasn't an overlay.");
        }
    }
}
