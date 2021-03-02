package org.p004a.p005a.p006a;

import java.io.Serializable;
import java.security.Principal;
import org.p004a.p005a.p007b.p008a.C0250b;

/* renamed from: org.a.a.a.r */
public final class C0237r implements Serializable, Principal {

    /* renamed from: a */
    private final String f42a;

    /* renamed from: b */
    private final String f43b;

    /* renamed from: c */
    private final String f44c;

    /* renamed from: a */
    public final String mo4845a() {
        return this.f43b;
    }

    /* renamed from: b */
    public final String mo4846b() {
        return this.f42a;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof C0237r) {
            C0237r rVar = (C0237r) obj;
            return C0250b.m97a((Object) this.f42a, (Object) rVar.f42a) && C0250b.m97a((Object) this.f43b, (Object) rVar.f43b);
        }
    }

    public final String getName() {
        return this.f44c;
    }

    public final int hashCode() {
        return C0250b.m77a(C0250b.m77a(17, (Object) this.f42a), (Object) this.f43b);
    }

    public final String toString() {
        return this.f44c;
    }
}
