package org.p004a.p005a.p006a;

import java.io.Serializable;
import java.security.Principal;
import org.p004a.p005a.p007b.p008a.C0250b;

/* renamed from: org.a.a.a.q */
public final class C0236q implements Serializable, C0233n {

    /* renamed from: a */
    private final C0237r f39a;

    /* renamed from: b */
    private final String f40b;

    /* renamed from: c */
    private final String f41c;

    /* renamed from: a */
    public final Principal mo4837a() {
        return this.f39a;
    }

    /* renamed from: b */
    public final String mo4838b() {
        return this.f40b;
    }

    /* renamed from: c */
    public final String mo4839c() {
        return this.f39a.mo4846b();
    }

    /* renamed from: d */
    public final String mo4840d() {
        return this.f39a.mo4845a();
    }

    /* renamed from: e */
    public final String mo4841e() {
        return this.f41c;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof C0236q) {
            C0236q qVar = (C0236q) obj;
            return C0250b.m97a((Object) this.f39a, (Object) qVar.f39a) && C0250b.m97a((Object) this.f41c, (Object) qVar.f41c);
        }
    }

    public final int hashCode() {
        return C0250b.m77a(C0250b.m77a(17, (Object) this.f39a), (Object) this.f41c);
    }

    public final String toString() {
        return "[principal: " + this.f39a + "][workstation: " + this.f41c + "]";
    }
}
