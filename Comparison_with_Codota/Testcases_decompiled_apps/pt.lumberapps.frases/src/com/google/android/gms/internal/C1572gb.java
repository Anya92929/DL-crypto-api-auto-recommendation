package com.google.android.gms.internal;

import java.util.HashMap;
import java.util.Map;

/* renamed from: com.google.android.gms.internal.gb */
class C1572gb implements Runnable {

    /* renamed from: a */
    final /* synthetic */ String f5013a;

    /* renamed from: b */
    final /* synthetic */ String f5014b;

    /* renamed from: c */
    final /* synthetic */ int f5015c;

    /* renamed from: d */
    final /* synthetic */ int f5016d;

    /* renamed from: e */
    final /* synthetic */ boolean f5017e;

    /* renamed from: f */
    final /* synthetic */ zzfd f5018f;

    C1572gb(zzfd zzfd, String str, String str2, int i, int i2, boolean z) {
        this.f5018f = zzfd;
        this.f5013a = str;
        this.f5014b = str2;
        this.f5015c = i;
        this.f5016d = i2;
        this.f5017e = z;
    }

    public void run() {
        HashMap hashMap = new HashMap();
        hashMap.put("event", "precacheProgress");
        hashMap.put("src", this.f5013a);
        hashMap.put("cachedSrc", this.f5014b);
        hashMap.put("bytesLoaded", Integer.toString(this.f5015c));
        hashMap.put("totalBytes", Integer.toString(this.f5016d));
        hashMap.put("cacheReady", this.f5017e ? "1" : "0");
        this.f5018f.m7023a("onPrecacheEvent", (Map) hashMap);
    }
}
