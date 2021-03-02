package com.google.android.gms.ads.internal;

import com.google.android.gms.internal.zzep;
import com.google.android.gms.internal.zzlh;
import java.util.Map;

/* renamed from: com.google.android.gms.ads.internal.m */
class C1274m implements zzep {

    /* renamed from: a */
    final /* synthetic */ zzg f3723a;

    C1274m(zzg zzg) {
        this.f3723a = zzg;
    }

    public void zza(zzlh zzlh, Map map) {
        zzlh.zzb("/appSettingsFetched", (zzep) this);
        synchronized (this.f3723a.f4023a) {
            if (map != null) {
                if ("true".equalsIgnoreCase((String) map.get("isSuccessful"))) {
                    zzu.zzft().zzd(this.f3723a.f4024b, (String) map.get("appSettingsJson"));
                }
            }
        }
    }
}
