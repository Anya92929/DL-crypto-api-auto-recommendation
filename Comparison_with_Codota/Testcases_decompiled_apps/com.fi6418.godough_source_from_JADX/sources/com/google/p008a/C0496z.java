package com.google.p008a;

import com.google.p008a.p010b.C0463w;
import java.util.Map;
import java.util.Set;

/* renamed from: com.google.a.z */
public final class C0496z extends C0493w {

    /* renamed from: a */
    private final C0463w<String, C0493w> f3651a = new C0463w<>();

    /* renamed from: a */
    public void mo6546a(String str, C0493w wVar) {
        if (wVar == null) {
            wVar = C0495y.f3650a;
        }
        this.f3651a.put(str, wVar);
    }

    public boolean equals(Object obj) {
        return obj == this || ((obj instanceof C0496z) && ((C0496z) obj).f3651a.equals(this.f3651a));
    }

    public int hashCode() {
        return this.f3651a.hashCode();
    }

    /* renamed from: o */
    public Set<Map.Entry<String, C0493w>> mo6549o() {
        return this.f3651a.entrySet();
    }
}
