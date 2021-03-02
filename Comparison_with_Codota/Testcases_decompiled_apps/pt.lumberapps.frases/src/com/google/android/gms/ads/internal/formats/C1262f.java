package com.google.android.gms.ads.internal.formats;

import com.google.android.gms.internal.zzkd;
import com.google.android.gms.internal.zzlh;
import com.google.android.gms.internal.zzli;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: com.google.android.gms.ads.internal.formats.f */
class C1262f implements zzli.zza {

    /* renamed from: a */
    final /* synthetic */ Map f3630a;

    /* renamed from: b */
    final /* synthetic */ C1261e f3631b;

    C1262f(C1261e eVar, Map map) {
        this.f3631b = eVar;
        this.f3630a = map;
    }

    public void zza(zzlh zzlh, boolean z) {
        String unused = this.f3631b.f3629b.f3627a.f3697k = (String) this.f3630a.get("id");
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("messageType", "htmlLoaded");
            jSONObject.put("id", this.f3631b.f3629b.f3627a.f3697k);
            this.f3631b.f3628a.zzb("sendMessageToNativeJs", jSONObject);
        } catch (JSONException e) {
            zzkd.zzb("Unable to dispatch sendMessageToNativeJs event", e);
        }
    }
}
