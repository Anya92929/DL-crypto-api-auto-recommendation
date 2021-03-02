package com.google.android.gms.internal;

import org.json.JSONObject;

/* renamed from: com.google.android.gms.internal.hm */
class C1610hm implements Runnable {

    /* renamed from: a */
    final /* synthetic */ String f5095a;

    /* renamed from: b */
    final /* synthetic */ JSONObject f5096b;

    /* renamed from: c */
    final /* synthetic */ zzfr f5097c;

    C1610hm(zzfr zzfr, String str, JSONObject jSONObject) {
        this.f5097c = zzfr;
        this.f5095a = str;
        this.f5096b = jSONObject;
    }

    public void run() {
        this.f5097c.f6192a.zza(this.f5095a, this.f5096b);
    }
}
