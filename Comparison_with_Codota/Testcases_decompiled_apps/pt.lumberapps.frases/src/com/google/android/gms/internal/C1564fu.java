package com.google.android.gms.internal;

import org.json.JSONObject;

/* renamed from: com.google.android.gms.internal.fu */
class C1564fu implements Runnable {

    /* renamed from: a */
    final /* synthetic */ JSONObject f4996a;

    /* renamed from: b */
    final /* synthetic */ C1563ft f4997b;

    C1564fu(C1563ft ftVar, JSONObject jSONObject) {
        this.f4997b = ftVar;
        this.f4996a = jSONObject;
    }

    public void run() {
        this.f4997b.f4994b.zzb("fetchHttpRequestCompleted", this.f4996a);
        zzkd.zzcv("Dispatched http response.");
    }
}
