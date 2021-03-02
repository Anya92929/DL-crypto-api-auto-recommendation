package com.google.android.gms.internal;

import java.util.Map;

@zzin
public class zzes implements zzep {

    /* renamed from: a */
    private final zzet f6154a;

    public zzes(zzet zzet) {
        this.f6154a = zzet;
    }

    public void zza(zzlh zzlh, Map map) {
        float f;
        boolean equals = "1".equals(map.get("transparentBackground"));
        boolean equals2 = "1".equals(map.get("blur"));
        try {
            if (map.get("blurRadius") != null) {
                f = Float.parseFloat((String) map.get("blurRadius"));
                this.f6154a.zzg(equals);
                this.f6154a.zza(equals2, f);
            }
        } catch (NumberFormatException e) {
            zzkd.zzb("Fail to parse float", e);
        }
        f = 0.0f;
        this.f6154a.zzg(equals);
        this.f6154a.zza(equals2, f);
    }
}
