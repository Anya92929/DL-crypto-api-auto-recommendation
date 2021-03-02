package org.p004a.p005a.p036l;

import org.p004a.p005a.C0542j;
import org.p004a.p005a.C0565n;
import org.p004a.p005a.p007b.p008a.C0250b;

/* renamed from: org.a.a.l.f */
public class C0554f implements C0553e {

    /* renamed from: a */
    private final C0553e f624a;

    public C0554f() {
        this.f624a = new C0549a();
    }

    public C0554f(C0553e eVar) {
        this.f624a = eVar;
    }

    /* renamed from: a */
    public final Object mo5221a(String str) {
        return this.f624a.mo5221a(str);
    }

    /* renamed from: a */
    public final Object mo5408a(String str, Class cls) {
        C0250b.m84a((Object) cls, "Attribute class");
        Object a = mo5221a(str);
        if (a == null) {
            return null;
        }
        return cls.cast(a);
    }

    /* renamed from: a */
    public final void mo5223a(String str, Object obj) {
        this.f624a.mo5223a(str, obj);
    }

    /* renamed from: j */
    public final C0542j mo5409j() {
        return (C0542j) mo5408a("http.connection", C0542j.class);
    }

    /* renamed from: k */
    public final C0565n mo5410k() {
        return (C0565n) mo5408a("http.target_host", C0565n.class);
    }
}
