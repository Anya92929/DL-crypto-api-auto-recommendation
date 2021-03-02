package com.google.android.gms.p018c;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/* renamed from: com.google.android.gms.c.h */
public final class C0666h extends C0626ao<C0666h> {

    /* renamed from: a */
    private Map<Integer, Double> f4361a = new HashMap(4);

    /* renamed from: a */
    public Map<Integer, Double> mo7208a() {
        return Collections.unmodifiableMap(this.f4361a);
    }

    /* renamed from: a */
    public void mo7010a(C0666h hVar) {
        hVar.f4361a.putAll(this.f4361a);
    }

    public String toString() {
        HashMap hashMap = new HashMap();
        for (Map.Entry next : this.f4361a.entrySet()) {
            hashMap.put("metric" + next.getKey(), next.getValue());
        }
        return m3607a((Object) hashMap);
    }
}
