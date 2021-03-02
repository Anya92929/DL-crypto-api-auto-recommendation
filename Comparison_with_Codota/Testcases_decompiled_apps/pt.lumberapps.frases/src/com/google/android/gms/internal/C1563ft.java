package com.google.android.gms.internal;

import java.util.Map;
import org.json.JSONObject;

/* renamed from: com.google.android.gms.internal.ft */
class C1563ft implements Runnable {

    /* renamed from: a */
    final /* synthetic */ Map f4993a;

    /* renamed from: b */
    final /* synthetic */ zzlh f4994b;

    /* renamed from: c */
    final /* synthetic */ zzeq f4995c;

    C1563ft(zzeq zzeq, Map map, zzlh zzlh) {
        this.f4995c = zzeq;
        this.f4993a = map;
        this.f4994b = zzlh;
    }

    public void run() {
        zzkd.zzcv("Received Http request.");
        JSONObject zzav = this.f4995c.zzav((String) this.f4993a.get("http_request"));
        if (zzav == null) {
            zzkd.m5769e("Response should not be null.");
        } else {
            zzkh.zzclc.post(new C1564fu(this, zzav));
        }
    }
}
