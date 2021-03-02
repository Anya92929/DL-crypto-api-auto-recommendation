package com.google.android.gms.internal;

import com.google.android.gms.internal.C1178fo;
import java.util.concurrent.ExecutionException;
import org.json.JSONException;
import org.json.JSONObject;

@C1130ez
/* renamed from: com.google.android.gms.internal.fq */
public class C1183fq implements C1178fo.C1181a<C0954bp> {
    /* renamed from: c */
    public C0954bp mo8523a(C1178fo foVar, JSONObject jSONObject) throws JSONException, InterruptedException, ExecutionException {
        return new C0954bp(jSONObject.getString("headline"), foVar.mo8512a(jSONObject, "image", true).get(), jSONObject.getString("body"), foVar.mo8512a(jSONObject, "secondary_image", false).get(), jSONObject.getString("call_to_action"), jSONObject.getString("attribution"));
    }
}
