package com.google.android.gms.internal;

import android.text.TextUtils;
import java.util.HashMap;
import java.util.Map;

/* renamed from: com.google.android.gms.internal.gd */
class C1574gd implements Runnable {

    /* renamed from: a */
    final /* synthetic */ String f5023a;

    /* renamed from: b */
    final /* synthetic */ String f5024b;

    /* renamed from: c */
    final /* synthetic */ String f5025c;

    /* renamed from: d */
    final /* synthetic */ String f5026d;

    /* renamed from: e */
    final /* synthetic */ zzfd f5027e;

    C1574gd(zzfd zzfd, String str, String str2, String str3, String str4) {
        this.f5027e = zzfd;
        this.f5023a = str;
        this.f5024b = str2;
        this.f5025c = str3;
        this.f5026d = str4;
    }

    public void run() {
        HashMap hashMap = new HashMap();
        hashMap.put("event", "precacheCanceled");
        hashMap.put("src", this.f5023a);
        if (!TextUtils.isEmpty(this.f5024b)) {
            hashMap.put("cachedSrc", this.f5024b);
        }
        hashMap.put("type", this.f5027e.m7024b(this.f5025c));
        hashMap.put("reason", this.f5025c);
        if (!TextUtils.isEmpty(this.f5026d)) {
            hashMap.put("message", this.f5026d);
        }
        this.f5027e.m7023a("onPrecacheEvent", (Map) hashMap);
    }
}
