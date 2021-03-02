package com.google.android.gms.internal;

import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import org.json.JSONObject;

@zzin
public class zzhl extends Handler {

    /* renamed from: a */
    private final zzhk f6348a;

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public zzhl(Context context) {
        this((zzhk) new zzhm(context.getApplicationContext() != null ? context.getApplicationContext() : context));
    }

    public zzhl(zzhk zzhk) {
        this.f6348a = zzhk;
    }

    /* renamed from: a */
    private void m7141a(JSONObject jSONObject) {
        try {
            this.f6348a.zza(jSONObject.getString("request_id"), jSONObject.getString("base_url"), jSONObject.getString("html"));
        } catch (Exception e) {
        }
    }

    public void handleMessage(Message message) {
        try {
            Bundle data = message.getData();
            if (data != null) {
                JSONObject jSONObject = new JSONObject(data.getString("data"));
                if ("fetch_html".equals(jSONObject.getString("message_name"))) {
                    m7141a(jSONObject);
                }
            }
        } catch (Exception e) {
        }
    }
}
