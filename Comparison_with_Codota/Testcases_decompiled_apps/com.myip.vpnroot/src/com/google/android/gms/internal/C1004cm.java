package com.google.android.gms.internal;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

@C1130ez
/* renamed from: com.google.android.gms.internal.cm */
public final class C1004cm {

    /* renamed from: qd */
    public final List<C1003cl> f3034qd;

    /* renamed from: qe */
    public final long f3035qe;

    /* renamed from: qf */
    public final List<String> f3036qf;

    /* renamed from: qg */
    public final List<String> f3037qg;

    /* renamed from: qh */
    public final List<String> f3038qh;

    /* renamed from: qi */
    public final String f3039qi;

    /* renamed from: qj */
    public final long f3040qj;

    /* renamed from: qk */
    public int f3041qk;

    /* renamed from: ql */
    public int f3042ql;

    public C1004cm(String str) throws JSONException {
        JSONObject jSONObject = new JSONObject(str);
        if (C1229gs.m4684u(2)) {
            C1229gs.m4678V("Mediation Response JSON: " + jSONObject.toString(2));
        }
        JSONArray jSONArray = jSONObject.getJSONArray("ad_networks");
        ArrayList arrayList = new ArrayList(jSONArray.length());
        int i = -1;
        for (int i2 = 0; i2 < jSONArray.length(); i2++) {
            C1003cl clVar = new C1003cl(jSONArray.getJSONObject(i2));
            arrayList.add(clVar);
            if (i < 0 && m4128a(clVar)) {
                i = i2;
            }
        }
        this.f3041qk = i;
        this.f3042ql = jSONArray.length();
        this.f3034qd = Collections.unmodifiableList(arrayList);
        this.f3039qi = jSONObject.getString("qdata");
        JSONObject optJSONObject = jSONObject.optJSONObject("settings");
        if (optJSONObject != null) {
            this.f3035qe = optJSONObject.optLong("ad_network_timeout_millis", -1);
            this.f3036qf = C1011cr.m4150a(optJSONObject, "click_urls");
            this.f3037qg = C1011cr.m4150a(optJSONObject, "imp_urls");
            this.f3038qh = C1011cr.m4150a(optJSONObject, "nofill_urls");
            long optLong = optJSONObject.optLong("refresh", -1);
            this.f3040qj = optLong > 0 ? optLong * 1000 : -1;
            return;
        }
        this.f3035qe = -1;
        this.f3036qf = null;
        this.f3037qg = null;
        this.f3038qh = null;
        this.f3040qj = -1;
    }

    /* renamed from: a */
    private boolean m4128a(C1003cl clVar) {
        for (String equals : clVar.f3029pY) {
            if (equals.equals("com.google.ads.mediation.admob.AdMobAdapter")) {
                return true;
            }
        }
        return false;
    }
}
