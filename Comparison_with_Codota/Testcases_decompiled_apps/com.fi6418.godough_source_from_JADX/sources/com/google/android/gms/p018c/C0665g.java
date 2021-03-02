package com.google.android.gms.p018c;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/* renamed from: com.google.android.gms.c.g */
public final class C0665g extends C0626ao<C0665g> {

    /* renamed from: a */
    private Map<Integer, String> f4360a = new HashMap(4);

    /* renamed from: a */
    public Map<Integer, String> mo7205a() {
        return Collections.unmodifiableMap(this.f4360a);
    }

    /* renamed from: a */
    public void mo7010a(C0665g gVar) {
        gVar.f4360a.putAll(this.f4360a);
    }

    public String toString() {
        HashMap hashMap = new HashMap();
        for (Map.Entry next : this.f4360a.entrySet()) {
            hashMap.put("dimension" + next.getKey(), next.getValue());
        }
        return m3607a((Object) hashMap);
    }
}
