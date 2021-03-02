package com.google.android.gms.internal;

import com.google.android.gms.ads.internal.zze;
import com.google.android.gms.common.util.zzf;
import java.util.Map;

@zzin
public class zzev implements zzep {

    /* renamed from: a */
    static final Map f6156a = zzf.zza("resize", 1, "playVideo", 2, "storePicture", 3, "createCalendarEvent", 4, "setOrientationProperties", 5, "closeResizedAd", 6);

    /* renamed from: b */
    private final zze f6157b;

    /* renamed from: c */
    private final zzha f6158c;

    public zzev(zze zze, zzha zzha) {
        this.f6157b = zze;
        this.f6158c = zzha;
    }

    public void zza(zzlh zzlh, Map map) {
        int intValue = ((Integer) f6156a.get((String) map.get("a"))).intValue();
        if (intValue == 5 || this.f6157b == null || this.f6157b.zzel()) {
            switch (intValue) {
                case 1:
                    this.f6158c.execute(map);
                    return;
                case 3:
                    new zzhc(zzlh, map).execute();
                    return;
                case 4:
                    new zzgz(zzlh, map).execute();
                    return;
                case 5:
                    new zzhb(zzlh, map).execute();
                    return;
                case 6:
                    this.f6158c.zzs(true);
                    return;
                default:
                    zzkd.zzcw("Unknown MRAID command called.");
                    return;
            }
        } else {
            this.f6157b.zzt((String) null);
        }
    }
}
