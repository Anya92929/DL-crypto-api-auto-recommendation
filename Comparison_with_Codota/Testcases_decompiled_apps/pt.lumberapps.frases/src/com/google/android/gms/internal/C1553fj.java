package com.google.android.gms.internal;

import java.util.Map;
import java.util.concurrent.Future;

/* renamed from: com.google.android.gms.internal.fj */
final class C1553fj implements zzep {
    C1553fj() {
    }

    public void zza(zzlh zzlh, Map map) {
        String str = (String) map.get("u");
        if (str == null) {
            zzkd.zzcx("URL missing from httpTrack GMSG.");
        } else {
            Future future = (Future) new zzkq(zzlh.getContext(), zzlh.zzum().zzcs, str).zzpy();
        }
    }
}
