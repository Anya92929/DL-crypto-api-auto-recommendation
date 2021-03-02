package org.p004a.p005a.p006a;

import java.io.Serializable;
import java.security.Principal;
import org.p004a.p005a.p007b.p008a.C0250b;

/* renamed from: org.a.a.a.k */
public final class C0230k implements Serializable, Principal {

    /* renamed from: a */
    private final String f36a;

    public C0230k(String str) {
        C0250b.m84a((Object) str, "User name");
        this.f36a = str;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof C0230k) && C0250b.m97a((Object) this.f36a, (Object) ((C0230k) obj).f36a);
    }

    public final String getName() {
        return this.f36a;
    }

    public final int hashCode() {
        return C0250b.m77a(17, (Object) this.f36a);
    }

    public final String toString() {
        return "[principal: " + this.f36a + "]";
    }
}
