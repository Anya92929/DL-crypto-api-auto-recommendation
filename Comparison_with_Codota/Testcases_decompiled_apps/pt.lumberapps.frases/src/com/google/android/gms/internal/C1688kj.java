package com.google.android.gms.internal;

import android.text.TextUtils;
import com.google.android.gms.common.internal.zzab;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: com.google.android.gms.internal.kj */
class C1688kj implements zzep {

    /* renamed from: a */
    final /* synthetic */ zzft f5214a;

    /* renamed from: b */
    final /* synthetic */ C1687ki f5215b;

    C1688kj(C1687ki kiVar, zzft zzft) {
        this.f5215b = kiVar;
        this.f5214a = zzft;
    }

    public void zza(zzlh zzlh, Map map) {
        this.f5214a.zzb("/nativeAdPreProcess", this.f5215b.f5210a.f5235a);
        try {
            String str = (String) map.get("success");
            if (!TextUtils.isEmpty(str)) {
                this.f5215b.f5211b.zzh(new JSONObject(str).getJSONArray("ads").getJSONObject(0));
                return;
            }
        } catch (JSONException e) {
            zzkd.zzb("Malformed native JSON response.", e);
        }
        this.f5215b.f5213d.zzan(0);
        zzab.zza(this.f5215b.f5213d.zzqs(), (Object) "Unable to set the ad state error!");
        this.f5215b.f5211b.zzh((Object) null);
    }
}
