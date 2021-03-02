package org.p004a.p005a.p033i;

import java.io.Serializable;
import org.p004a.p005a.C0241ac;
import org.p004a.p005a.C0244af;
import org.p004a.p005a.p007b.p008a.C0250b;
import org.p004a.p005a.p037m.C0563b;

/* renamed from: org.a.a.i.m */
public final class C0534m implements Serializable, Cloneable, C0244af {

    /* renamed from: a */
    private final C0241ac f593a;

    /* renamed from: b */
    private final int f594b;

    /* renamed from: c */
    private final String f595c;

    public C0534m(C0241ac acVar, int i, String str) {
        this.f593a = (C0241ac) C0250b.m84a((Object) acVar, "Version");
        this.f594b = C0250b.m78a(i, "Status code");
        this.f595c = str;
    }

    /* renamed from: a */
    public final C0241ac mo4866a() {
        return this.f593a;
    }

    /* renamed from: b */
    public final int mo4867b() {
        return this.f594b;
    }

    /* renamed from: c */
    public final String mo4868c() {
        return this.f595c;
    }

    public final Object clone() {
        return super.clone();
    }

    public final String toString() {
        return C0529h.f581a.mo5350a((C0563b) null, (C0244af) this).toString();
    }
}
