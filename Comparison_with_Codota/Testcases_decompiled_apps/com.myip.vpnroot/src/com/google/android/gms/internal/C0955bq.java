package com.google.android.gms.internal;

import org.json.JSONException;
import org.json.JSONObject;

@C1130ez
/* renamed from: com.google.android.gms.internal.bq */
public class C0955bq {

    /* renamed from: pw */
    private C1735u f2938pw;

    /* renamed from: px */
    private C0897ah f2939px;

    /* renamed from: py */
    private JSONObject f2940py;

    /* renamed from: com.google.android.gms.internal.bq$a */
    public interface C0956a {
        /* renamed from: a */
        void mo8137a(C0955bq bqVar);
    }

    public C0955bq(C1735u uVar, C0897ah ahVar, JSONObject jSONObject) {
        this.f2938pw = uVar;
        this.f2939px = ahVar;
        this.f2940py = jSONObject;
    }

    /* renamed from: as */
    public void mo8156as() {
        this.f2938pw.mo8046aj();
    }

    /* renamed from: b */
    public void mo8157b(String str, int i) {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("asset", i);
            jSONObject.put("template", str);
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put("ad", this.f2940py);
            jSONObject2.put("click", jSONObject);
            this.f2939px.mo7946a("google.afma.nativeAds.handleClick", jSONObject2);
        } catch (JSONException e) {
            C1229gs.m4681b("Unable to create click JSON.", e);
        }
    }
}
