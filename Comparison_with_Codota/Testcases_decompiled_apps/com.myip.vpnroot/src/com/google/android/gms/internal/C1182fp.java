package com.google.android.gms.internal;

import com.google.android.gms.internal.C1178fo;
import java.util.concurrent.ExecutionException;
import org.json.JSONException;
import org.json.JSONObject;

@C1130ez
/* renamed from: com.google.android.gms.internal.fp */
public class C1182fp implements C1178fo.C1181a<C0953bo> {
    /* renamed from: b */
    public C0953bo mo8523a(C1178fo foVar, JSONObject jSONObject) throws JSONException, InterruptedException, ExecutionException {
        return new C0953bo(jSONObject.getString("headline"), foVar.mo8512a(jSONObject, "image", true).get(), jSONObject.getString("body"), foVar.mo8512a(jSONObject, "app_icon", true).get(), jSONObject.getString("call_to_action"), jSONObject.optDouble("rating", -1.0d), jSONObject.optString("store"), jSONObject.optString("price"));
    }
}
