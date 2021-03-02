package com.google.android.gms.ads.internal.request;

import com.google.android.gms.internal.zzfs;
import org.json.JSONObject;

/* renamed from: com.google.android.gms.ads.internal.request.l */
class C1311l implements Runnable {

    /* renamed from: a */
    final /* synthetic */ JSONObject f3926a;

    /* renamed from: b */
    final /* synthetic */ String f3927b;

    /* renamed from: c */
    final /* synthetic */ zzn f3928c;

    C1311l(zzn zzn, JSONObject jSONObject, String str) {
        this.f3928c = zzn;
        this.f3926a = jSONObject;
        this.f3927b = str;
    }

    public void run() {
        zzfs.zzc unused = this.f3928c.f3966l = zzn.f3958d.zzma();
        this.f3928c.f3966l.zza(new C1312m(this), new C1313n(this));
    }
}
