package com.google.android.gms.analytics.p016a;

import com.google.android.gms.common.internal.C1009bf;
import com.google.android.gms.p018c.C0626ao;
import java.util.HashMap;
import java.util.Map;

/* renamed from: com.google.android.gms.analytics.a.a */
public class C0502a {

    /* renamed from: a */
    Map<String, String> f3669a = new HashMap();

    /* renamed from: a */
    public C0502a mo6561a(String str) {
        mo6562a("nm", str);
        return this;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo6562a(String str, String str2) {
        C1009bf.m4529a(str, (Object) "Name should be non-null");
        this.f3669a.put(str, str2);
    }

    /* renamed from: b */
    public Map<String, String> mo6563b(String str) {
        HashMap hashMap = new HashMap();
        for (Map.Entry next : this.f3669a.entrySet()) {
            hashMap.put(str + ((String) next.getKey()), next.getValue());
        }
        return hashMap;
    }

    public String toString() {
        return C0626ao.m3609a((Map) this.f3669a);
    }
}
