package com.google.android.gms.analytics.p016a;

import com.google.android.gms.p018c.C0626ao;
import java.util.HashMap;
import java.util.Map;

/* renamed from: com.google.android.gms.analytics.a.c */
public class C0504c {

    /* renamed from: a */
    Map<String, String> f3671a = new HashMap();

    /* renamed from: a */
    public Map<String, String> mo6568a(String str) {
        HashMap hashMap = new HashMap();
        for (Map.Entry next : this.f3671a.entrySet()) {
            hashMap.put(str + ((String) next.getKey()), next.getValue());
        }
        return hashMap;
    }

    public String toString() {
        return C0626ao.m3609a((Map) this.f3671a);
    }
}
