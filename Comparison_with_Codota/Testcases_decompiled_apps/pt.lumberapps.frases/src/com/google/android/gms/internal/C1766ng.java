package com.google.android.gms.internal;

import java.util.Map;

/* renamed from: com.google.android.gms.internal.ng */
class C1766ng implements Runnable {

    /* renamed from: a */
    final /* synthetic */ Map f5386a;

    /* renamed from: b */
    final /* synthetic */ zzlm f5387b;

    C1766ng(zzlm zzlm, Map map) {
        this.f5387b = zzlm;
        this.f5386a = map;
    }

    public void run() {
        this.f5387b.f6741a.zza("pubVideoCmd", this.f5386a);
    }
}
