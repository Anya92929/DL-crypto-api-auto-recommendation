package org.p004a.p005a.p036l;

import org.p004a.p005a.p007b.p008a.C0250b;

/* renamed from: org.a.a.l.c */
public final class C0551c implements C0553e {

    /* renamed from: a */
    private final C0553e f620a;

    /* renamed from: b */
    private final C0553e f621b;

    public C0551c(C0553e eVar, C0553e eVar2) {
        this.f620a = (C0553e) C0250b.m84a((Object) eVar, "HTTP context");
        this.f621b = eVar2;
    }

    /* renamed from: a */
    public final Object mo5221a(String str) {
        Object a = this.f620a.mo5221a(str);
        return a == null ? this.f621b.mo5221a(str) : a;
    }

    /* renamed from: a */
    public final void mo5223a(String str, Object obj) {
        this.f620a.mo5223a(str, obj);
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("[local: ").append(this.f620a);
        sb.append("defaults: ").append(this.f621b);
        sb.append("]");
        return sb.toString();
    }
}
