package com.google.android.gms.internal;

import java.util.HashMap;
import java.util.Map;

/* renamed from: com.google.android.gms.internal.gc */
class C1573gc implements Runnable {

    /* renamed from: a */
    final /* synthetic */ String f5019a;

    /* renamed from: b */
    final /* synthetic */ String f5020b;

    /* renamed from: c */
    final /* synthetic */ int f5021c;

    /* renamed from: d */
    final /* synthetic */ zzfd f5022d;

    C1573gc(zzfd zzfd, String str, String str2, int i) {
        this.f5022d = zzfd;
        this.f5019a = str;
        this.f5020b = str2;
        this.f5021c = i;
    }

    public void run() {
        HashMap hashMap = new HashMap();
        hashMap.put("event", "precacheComplete");
        hashMap.put("src", this.f5019a);
        hashMap.put("cachedSrc", this.f5020b);
        hashMap.put("totalBytes", Integer.toString(this.f5021c));
        this.f5022d.m7023a("onPrecacheEvent", (Map) hashMap);
    }
}
