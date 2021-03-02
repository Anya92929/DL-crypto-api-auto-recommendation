package com.google.android.gms.p018c;

import com.google.android.gms.analytics.p016a.C0502a;
import com.google.android.gms.analytics.p016a.C0503b;
import com.google.android.gms.analytics.p016a.C0504c;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* renamed from: com.google.android.gms.c.bb */
public final class C0640bb extends C0626ao<C0640bb> {

    /* renamed from: a */
    private final List<C0502a> f4274a = new ArrayList();

    /* renamed from: b */
    private final List<C0504c> f4275b = new ArrayList();

    /* renamed from: c */
    private final Map<String, List<C0502a>> f4276c = new HashMap();

    /* renamed from: d */
    private C0503b f4277d;

    /* renamed from: a */
    public C0503b mo7074a() {
        return this.f4277d;
    }

    /* renamed from: a */
    public void mo7075a(C0502a aVar, String str) {
        if (aVar != null) {
            if (str == null) {
                str = "";
            }
            if (!this.f4276c.containsKey(str)) {
                this.f4276c.put(str, new ArrayList());
            }
            this.f4276c.get(str).add(aVar);
        }
    }

    /* renamed from: a */
    public void mo7010a(C0640bb bbVar) {
        bbVar.f4274a.addAll(this.f4274a);
        bbVar.f4275b.addAll(this.f4275b);
        for (Map.Entry next : this.f4276c.entrySet()) {
            String str = (String) next.getKey();
            for (C0502a a : (List) next.getValue()) {
                bbVar.mo7075a(a, str);
            }
        }
        if (this.f4277d != null) {
            bbVar.f4277d = this.f4277d;
        }
    }

    /* renamed from: b */
    public List<C0502a> mo7077b() {
        return Collections.unmodifiableList(this.f4274a);
    }

    /* renamed from: c */
    public Map<String, List<C0502a>> mo7078c() {
        return this.f4276c;
    }

    /* renamed from: d */
    public List<C0504c> mo7079d() {
        return Collections.unmodifiableList(this.f4275b);
    }

    public String toString() {
        HashMap hashMap = new HashMap();
        if (!this.f4274a.isEmpty()) {
            hashMap.put("products", this.f4274a);
        }
        if (!this.f4275b.isEmpty()) {
            hashMap.put("promotions", this.f4275b);
        }
        if (!this.f4276c.isEmpty()) {
            hashMap.put("impressions", this.f4276c);
        }
        hashMap.put("productAction", this.f4277d);
        return m3607a((Object) hashMap);
    }
}
