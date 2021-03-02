package com.google.android.gms.ads.internal;

import com.google.android.gms.ads.internal.formats.zze;
import com.google.android.gms.internal.zzkd;
import com.google.android.gms.internal.zzlh;
import com.google.android.gms.internal.zzli;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: com.google.android.gms.ads.internal.u */
final class C1322u implements zzli.zza {

    /* renamed from: a */
    final /* synthetic */ zze f3984a;

    /* renamed from: b */
    final /* synthetic */ String f3985b;

    /* renamed from: c */
    final /* synthetic */ zzlh f3986c;

    C1322u(zze zze, String str, zzlh zzlh) {
        this.f3984a = zze;
        this.f3985b = str;
        this.f3986c = zzlh;
    }

    public void zza(zzlh zzlh, boolean z) {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("headline", this.f3984a.getHeadline());
            jSONObject.put("body", this.f3984a.getBody());
            jSONObject.put("call_to_action", this.f3984a.getCallToAction());
            jSONObject.put("advertiser", this.f3984a.getAdvertiser());
            jSONObject.put("logo", zzn.m5835a(this.f3984a.zzky()));
            JSONArray jSONArray = new JSONArray();
            List<Object> images = this.f3984a.getImages();
            if (images != null) {
                for (Object a : images) {
                    jSONArray.put(zzn.m5835a(zzn.m5842b(a)));
                }
            }
            jSONObject.put("images", jSONArray);
            jSONObject.put("extras", zzn.m5845b(this.f3984a.getExtras(), this.f3985b));
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put("assets", jSONObject);
            jSONObject2.put("template_id", "1");
            this.f3986c.zza("google.afma.nativeExpressAds.loadAssets", jSONObject2);
        } catch (JSONException e) {
            zzkd.zzd("Exception occurred when loading assets", e);
        }
    }
}
