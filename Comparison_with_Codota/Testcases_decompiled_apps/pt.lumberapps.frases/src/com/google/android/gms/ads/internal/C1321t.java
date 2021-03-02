package com.google.android.gms.ads.internal;

import com.google.android.gms.ads.internal.formats.zzd;
import com.google.android.gms.internal.zzkd;
import com.google.android.gms.internal.zzlh;
import com.google.android.gms.internal.zzli;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: com.google.android.gms.ads.internal.t */
final class C1321t implements zzli.zza {

    /* renamed from: a */
    final /* synthetic */ zzd f3981a;

    /* renamed from: b */
    final /* synthetic */ String f3982b;

    /* renamed from: c */
    final /* synthetic */ zzlh f3983c;

    C1321t(zzd zzd, String str, zzlh zzlh) {
        this.f3981a = zzd;
        this.f3982b = str;
        this.f3983c = zzlh;
    }

    public void zza(zzlh zzlh, boolean z) {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("headline", this.f3981a.getHeadline());
            jSONObject.put("body", this.f3981a.getBody());
            jSONObject.put("call_to_action", this.f3981a.getCallToAction());
            jSONObject.put("price", this.f3981a.getPrice());
            jSONObject.put("star_rating", String.valueOf(this.f3981a.getStarRating()));
            jSONObject.put("store", this.f3981a.getStore());
            jSONObject.put("icon", zzn.m5835a(this.f3981a.zzku()));
            JSONArray jSONArray = new JSONArray();
            List<Object> images = this.f3981a.getImages();
            if (images != null) {
                for (Object a : images) {
                    jSONArray.put(zzn.m5835a(zzn.m5842b(a)));
                }
            }
            jSONObject.put("images", jSONArray);
            jSONObject.put("extras", zzn.m5845b(this.f3981a.getExtras(), this.f3982b));
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put("assets", jSONObject);
            jSONObject2.put("template_id", "2");
            this.f3983c.zza("google.afma.nativeExpressAds.loadAssets", jSONObject2);
        } catch (JSONException e) {
            zzkd.zzd("Exception occurred when loading assets", e);
        }
    }
}
