package org.p004a.p005a.p036l;

import java.util.HashMap;
import java.util.Map;
import org.p004a.p005a.p007b.p008a.C0250b;

/* renamed from: org.a.a.l.a */
public final class C0549a implements C0553e {

    /* renamed from: a */
    private final C0553e f616a;

    /* renamed from: b */
    private Map f617b;

    public C0549a() {
        this((C0553e) null);
    }

    private C0549a(C0553e eVar) {
        this.f617b = null;
        this.f616a = null;
    }

    /* renamed from: a */
    public final Object mo5221a(String str) {
        C0250b.m84a((Object) str, "Id");
        Object obj = null;
        if (this.f617b != null) {
            obj = this.f617b.get(str);
        }
        return (obj != null || this.f616a == null) ? obj : this.f616a.mo5221a(str);
    }

    /* renamed from: a */
    public final void mo5223a(String str, Object obj) {
        C0250b.m84a((Object) str, "Id");
        if (this.f617b == null) {
            this.f617b = new HashMap();
        }
        this.f617b.put(str, obj);
    }

    public final String toString() {
        return this.f617b != null ? this.f617b.toString() : "{}";
    }
}
