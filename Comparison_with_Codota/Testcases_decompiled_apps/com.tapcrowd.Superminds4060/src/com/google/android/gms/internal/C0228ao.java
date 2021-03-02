package com.google.android.gms.internal;

import com.tapcrowd.app.modules.favorites_v2.DBFavorites;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: com.google.android.gms.internal.ao */
public final class C0228ao {

    /* renamed from: eP */
    public final String f580eP;

    /* renamed from: eQ */
    public final List<String> f581eQ;

    /* renamed from: eR */
    public final String f582eR;

    /* renamed from: eS */
    public final String f583eS;

    /* renamed from: eT */
    public final List<String> f584eT;

    public C0228ao(JSONObject jSONObject) throws JSONException {
        this.f580eP = jSONObject.getString(DBFavorites.KEY_EVENT_ID);
        JSONArray jSONArray = jSONObject.getJSONArray("adapters");
        ArrayList arrayList = new ArrayList(jSONArray.length());
        for (int i = 0; i < jSONArray.length(); i++) {
            arrayList.add(jSONArray.getString(i));
        }
        this.f581eQ = Collections.unmodifiableList(arrayList);
        this.f582eR = jSONObject.optString("allocation_id", (String) null);
        this.f584eT = C0236au.m520a(jSONObject, "imp_urls");
        JSONObject optJSONObject = jSONObject.optJSONObject("data");
        this.f583eS = optJSONObject != null ? optJSONObject.toString() : null;
    }
}
