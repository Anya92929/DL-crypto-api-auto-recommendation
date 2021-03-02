package org.p004a.p005a.p033i;

import java.io.Serializable;
import org.p004a.p005a.C0344e;
import org.p004a.p005a.C0360f;
import org.p004a.p005a.p007b.p008a.C0250b;
import org.p004a.p005a.p037m.C0563b;

/* renamed from: org.a.a.i.b */
public final class C0523b implements Serializable, Cloneable, C0344e {

    /* renamed from: a */
    private final String f565a;

    /* renamed from: b */
    private final String f566b;

    public C0523b(String str, String str2) {
        this.f565a = (String) C0250b.m84a((Object) str, "Name");
        this.f566b = str2;
    }

    /* renamed from: c */
    public final String mo5040c() {
        return this.f565a;
    }

    public final Object clone() {
        return super.clone();
    }

    /* renamed from: d */
    public final String mo5041d() {
        return this.f566b;
    }

    /* renamed from: e */
    public final C0360f[] mo5042e() {
        return this.f566b != null ? C0526e.m1044a(this.f566b, (C0538q) null) : new C0360f[0];
    }

    public final String toString() {
        return C0529h.f581a.mo5351a((C0563b) null, (C0344e) this).toString();
    }
}
