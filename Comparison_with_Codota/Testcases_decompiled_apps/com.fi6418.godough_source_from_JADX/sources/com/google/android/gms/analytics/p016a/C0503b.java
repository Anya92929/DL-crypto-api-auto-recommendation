package com.google.android.gms.analytics.p016a;

import com.google.android.gms.common.internal.C1009bf;
import com.google.android.gms.p018c.C0626ao;
import java.util.HashMap;
import java.util.Map;

/* renamed from: com.google.android.gms.analytics.a.b */
public class C0503b {

    /* renamed from: a */
    Map<String, String> f3670a = new HashMap();

    public C0503b(String str) {
        mo6566a("&pa", str);
    }

    /* renamed from: a */
    public Map<String, String> mo6565a() {
        return new HashMap(this.f3670a);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo6566a(String str, String str2) {
        C1009bf.m4529a(str, (Object) "Name should be non-null");
        this.f3670a.put(str, str2);
    }

    public String toString() {
        HashMap hashMap = new HashMap();
        for (Map.Entry next : this.f3670a.entrySet()) {
            if (((String) next.getKey()).startsWith("&")) {
                hashMap.put(((String) next.getKey()).substring(1), next.getValue());
            } else {
                hashMap.put(next.getKey(), next.getValue());
            }
        }
        return C0626ao.m3609a((Map) hashMap);
    }
}
