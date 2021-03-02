package com.google.android.gms.internal;

import com.google.android.gms.ads.internal.zzu;
import java.util.Map;

@zzin
/* renamed from: com.google.android.gms.internal.fz */
class C1569fz implements zzep {
    C1569fz() {
    }

    /* renamed from: a */
    private int m6396a(Map map) {
        int parseInt = Integer.parseInt((String) map.get("playbackState"));
        if (parseInt < 0 || 3 < parseInt) {
            return 0;
        }
        return parseInt;
    }

    public void zza(zzlh zzlh, Map map) {
        zzlm zzlm;
        if (((Boolean) zzdc.zzbbb.get()).booleanValue()) {
            zzlm zzut = zzlh.zzut();
            if (zzut == null) {
                try {
                    zzlm zzlm2 = new zzlm(zzlh, Float.parseFloat((String) map.get("duration")));
                    zzlh.zza(zzlm2);
                    zzlm = zzlm2;
                } catch (NullPointerException | NumberFormatException e) {
                    zzkd.zzb("Unable to parse videoMeta message.", e);
                    zzu.zzft().zzb(e, true);
                    return;
                }
            } else {
                zzlm = zzut;
            }
            zzlm.zza(Float.parseFloat((String) map.get("currentTime")), m6396a(map), "1".equals(map.get("muted")));
        }
    }
}
