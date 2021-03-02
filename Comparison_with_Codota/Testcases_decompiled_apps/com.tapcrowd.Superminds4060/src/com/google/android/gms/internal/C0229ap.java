package com.google.android.gms.internal;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: com.google.android.gms.internal.ap */
public final class C0229ap {

    /* renamed from: eU */
    public final List<C0228ao> f585eU;

    /* renamed from: eV */
    public final long f586eV;

    /* renamed from: eW */
    public final List<String> f587eW;

    /* renamed from: eX */
    public final List<String> f588eX;

    /* renamed from: eY */
    public final List<String> f589eY;

    /* renamed from: eZ */
    public final String f590eZ;

    /* renamed from: fa */
    public final long f591fa;

    public C0229ap(String str) throws JSONException {
        JSONObject jSONObject = new JSONObject(str);
        if (C0344cn.m732k(2)) {
            C0344cn.m736p("Mediation Response JSON: " + jSONObject.toString(2));
        }
        JSONArray jSONArray = jSONObject.getJSONArray("ad_networks");
        ArrayList arrayList = new ArrayList(jSONArray.length());
        for (int i = 0; i < jSONArray.length(); i++) {
            arrayList.add(new C0228ao(jSONArray.getJSONObject(i)));
        }
        this.f585eU = Collections.unmodifiableList(arrayList);
        this.f590eZ = jSONObject.getString("qdata");
        JSONObject optJSONObject = jSONObject.optJSONObject("settings");
        if (optJSONObject != null) {
            this.f586eV = optJSONObject.optLong("ad_network_timeout_millis", -1);
            this.f587eW = C0236au.m520a(optJSONObject, "click_urls");
            this.f588eX = C0236au.m520a(optJSONObject, "imp_urls");
            this.f589eY = C0236au.m520a(optJSONObject, "nofill_urls");
            long optLong = optJSONObject.optLong("refresh", -1);
            this.f591fa = optLong > 0 ? 1000 * optLong : -1;
            return;
        }
        this.f586eV = -1;
        this.f587eW = null;
        this.f588eX = null;
        this.f589eY = null;
        this.f591fa = -1;
    }
}
