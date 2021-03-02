package com.google.android.gms.internal;

import java.util.Map;

@zzin
public final class zzek implements zzep {

    /* renamed from: a */
    private final zzel f6151a;

    public zzek(zzel zzel) {
        this.f6151a = zzel;
    }

    public void zza(zzlh zzlh, Map map) {
        String str = (String) map.get("name");
        if (str == null) {
            zzkd.zzcx("App event with no name parameter.");
        } else {
            this.f6151a.onAppEvent(str, (String) map.get("info"));
        }
    }
}
