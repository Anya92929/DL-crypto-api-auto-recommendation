package com.google.android.gms.internal;

import com.google.android.gms.ads.internal.overlay.zzm;
import com.google.android.gms.ads.internal.zzd;
import java.util.Map;
import org.json.JSONObject;

/* renamed from: com.google.android.gms.internal.fs */
final class C1562fs implements zzep {
    C1562fs() {
    }

    /* renamed from: a */
    private void m6382a(zzlh zzlh) {
        zzm zzm;
        zzkd.zzcw("Received support message, responding.");
        boolean z = false;
        zzd zzug = zzlh.zzug();
        if (!(zzug == null || (zzm = zzug.zzakl) == null)) {
            z = zzm.zzr(zzlh.getContext());
        }
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("event", "checkSupport");
            jSONObject.put("supports", z);
            zzlh.zzb("appStreaming", jSONObject);
        } catch (Throwable th) {
        }
    }

    public void zza(zzlh zzlh, Map map) {
        if ("checkSupport".equals(map.get("action"))) {
            m6382a(zzlh);
            return;
        }
        com.google.android.gms.ads.internal.overlay.zzd zzuh = zzlh.zzuh();
        if (zzuh != null) {
            zzuh.zzf(zzlh, map);
        }
    }
}
