package com.google.android.gms.ads.internal.formats;

import com.google.android.gms.internal.zzep;
import com.google.android.gms.internal.zzft;
import com.google.android.gms.internal.zzkd;
import com.google.android.gms.internal.zzlh;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: com.google.android.gms.ads.internal.formats.j */
class C1266j implements zzep {

    /* renamed from: a */
    final /* synthetic */ zzft f3635a;

    /* renamed from: b */
    final /* synthetic */ C1260d f3636b;

    C1266j(C1260d dVar, zzft zzft) {
        this.f3636b = dVar;
        this.f3635a = zzft;
    }

    public void zza(zzlh zzlh, Map map) {
        JSONObject jSONObject = new JSONObject();
        try {
            for (String str : map.keySet()) {
                jSONObject.put(str, map.get(str));
            }
            jSONObject.put("id", this.f3636b.f3627a.f3697k);
            this.f3635a.zzb("sendMessageToNativeJs", jSONObject);
        } catch (JSONException e) {
            zzkd.zzb("Unable to dispatch sendMessageToNativeJs event", e);
        }
    }
}
