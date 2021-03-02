package org.p004a.p005a.p034j;

import java.io.Serializable;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* renamed from: org.a.a.j.a */
public class C0543a extends C0544b implements Serializable, Cloneable {

    /* renamed from: a */
    private final Map f607a = new ConcurrentHashMap();

    /* renamed from: a */
    public Object mo5196a(String str) {
        return this.f607a.get(str);
    }

    /* renamed from: a */
    public C0544b mo5197a(String str, Object obj) {
        if (str != null) {
            if (obj != null) {
                this.f607a.put(str, obj);
            } else {
                this.f607a.remove(str);
            }
        }
        return this;
    }

    public Object clone() {
        C0543a aVar = (C0543a) super.clone();
        for (Map.Entry entry : this.f607a.entrySet()) {
            aVar.mo5197a((String) entry.getKey(), entry.getValue());
        }
        return aVar;
    }
}
