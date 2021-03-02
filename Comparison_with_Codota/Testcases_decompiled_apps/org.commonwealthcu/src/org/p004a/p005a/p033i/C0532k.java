package org.p004a.p005a.p033i;

import java.io.Serializable;
import org.p004a.p005a.C0576y;
import org.p004a.p005a.p007b.p008a.C0250b;

/* renamed from: org.a.a.i.k */
public final class C0532k implements Serializable, Cloneable, C0576y {

    /* renamed from: a */
    private final String f588a;

    /* renamed from: b */
    private final String f589b;

    public C0532k(String str, String str2) {
        this.f588a = (String) C0250b.m84a((Object) str, "Name");
        this.f589b = str2;
    }

    /* renamed from: a */
    public final String mo5357a() {
        return this.f588a;
    }

    /* renamed from: b */
    public final String mo5358b() {
        return this.f589b;
    }

    public final Object clone() {
        return super.clone();
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof C0576y)) {
            return false;
        }
        C0532k kVar = (C0532k) obj;
        return this.f588a.equals(kVar.f588a) && C0250b.m97a((Object) this.f589b, (Object) kVar.f589b);
    }

    public final int hashCode() {
        return C0250b.m77a(C0250b.m77a(17, (Object) this.f588a), (Object) this.f589b);
    }

    public final String toString() {
        if (this.f589b == null) {
            return this.f588a;
        }
        StringBuilder sb = new StringBuilder(this.f588a.length() + 1 + this.f589b.length());
        sb.append(this.f588a);
        sb.append("=");
        sb.append(this.f589b);
        return sb.toString();
    }
}
