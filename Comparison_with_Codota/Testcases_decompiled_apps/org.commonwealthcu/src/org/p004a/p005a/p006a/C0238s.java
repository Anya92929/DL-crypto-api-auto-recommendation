package org.p004a.p005a.p006a;

import java.io.Serializable;
import java.security.Principal;
import org.p004a.p005a.p007b.p008a.C0250b;

/* renamed from: org.a.a.a.s */
public final class C0238s implements Serializable, C0233n {

    /* renamed from: a */
    private final C0230k f45a;

    /* renamed from: b */
    private final String f46b;

    public C0238s(String str) {
        C0250b.m84a((Object) str, "Username:password string");
        int indexOf = str.indexOf(58);
        if (indexOf >= 0) {
            this.f45a = new C0230k(str.substring(0, indexOf));
            this.f46b = str.substring(indexOf + 1);
            return;
        }
        this.f45a = new C0230k(str);
        this.f46b = null;
    }

    /* renamed from: a */
    public final Principal mo4837a() {
        return this.f45a;
    }

    /* renamed from: b */
    public final String mo4838b() {
        return this.f46b;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof C0238s) && C0250b.m97a((Object) this.f45a, (Object) ((C0238s) obj).f45a);
    }

    public final int hashCode() {
        return this.f45a.hashCode();
    }

    public final String toString() {
        return this.f45a.toString();
    }
}
