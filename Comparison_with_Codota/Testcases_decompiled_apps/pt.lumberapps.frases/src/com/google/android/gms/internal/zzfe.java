package com.google.android.gms.internal;

import com.google.android.gms.ads.internal.zzu;
import com.google.android.gms.common.internal.zzb;
import java.util.Map;
import java.util.concurrent.Future;

@zzin
public class zzfe implements zzep {
    public void zza(zzlh zzlh, Map map) {
        int i;
        zzfc zzgj = zzu.zzgj();
        if (!map.containsKey("abort")) {
            String str = (String) map.get("src");
            if (str == null) {
                zzkd.zzcx("Precache video action is missing the src parameter.");
                return;
            }
            try {
                i = Integer.parseInt((String) map.get("player"));
            } catch (NumberFormatException e) {
                i = 0;
            }
            String str2 = map.containsKey("mimetype") ? (String) map.get("mimetype") : "";
            if (zzgj.zze(zzlh)) {
                zzkd.zzcx("Precache task already running.");
                return;
            }
            zzb.zzu(zzlh.zzug());
            Future future = (Future) new zzfb(zzlh, zzlh.zzug().zzakj.zza(zzlh, i, str2), str).zzpy();
        } else if (!zzgj.zzd(zzlh)) {
            zzkd.zzcx("Precache abort but no preload task running.");
        }
    }
}
