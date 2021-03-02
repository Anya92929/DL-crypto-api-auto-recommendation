package com.google.android.gms.internal;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

@C1130ez
/* renamed from: com.google.android.gms.internal.cl */
public final class C1003cl {

    /* renamed from: pW */
    public final String f3027pW;

    /* renamed from: pX */
    public final String f3028pX;

    /* renamed from: pY */
    public final List<String> f3029pY;

    /* renamed from: pZ */
    public final String f3030pZ;

    /* renamed from: qa */
    public final String f3031qa;

    /* renamed from: qb */
    public final List<String> f3032qb;

    /* renamed from: qc */
    public final String f3033qc;

    public C1003cl(JSONObject jSONObject) throws JSONException {
        String str = null;
        this.f3028pX = jSONObject.getString("id");
        JSONArray jSONArray = jSONObject.getJSONArray("adapters");
        ArrayList arrayList = new ArrayList(jSONArray.length());
        for (int i = 0; i < jSONArray.length(); i++) {
            arrayList.add(jSONArray.getString(i));
        }
        this.f3029pY = Collections.unmodifiableList(arrayList);
        this.f3030pZ = jSONObject.optString("allocation_id", (String) null);
        this.f3032qb = C1011cr.m4150a(jSONObject, "imp_urls");
        JSONObject optJSONObject = jSONObject.optJSONObject("ad");
        this.f3027pW = optJSONObject != null ? optJSONObject.toString() : null;
        JSONObject optJSONObject2 = jSONObject.optJSONObject("data");
        this.f3033qc = optJSONObject2 != null ? optJSONObject2.toString() : null;
        this.f3031qa = optJSONObject2 != null ? optJSONObject2.optString("class_name") : str;
    }
}
