package org.p004a.p005a;

import java.io.Serializable;
import org.p004a.p005a.p007b.p008a.C0250b;

/* renamed from: org.a.a.ac */
public class C0241ac implements Serializable, Cloneable {

    /* renamed from: a */
    private String f47a;

    /* renamed from: c */
    protected final int f48c;

    /* renamed from: d */
    protected final int f49d;

    public C0241ac(String str, int i, int i2) {
        this.f47a = (String) C0250b.m84a((Object) str, "Protocol name");
        this.f48c = C0250b.m78a(i, "Protocol minor version");
        this.f49d = C0250b.m78a(i2, "Protocol minor version");
    }

    /* renamed from: a */
    public final String mo4854a() {
        return this.f47a;
    }

    /* renamed from: a */
    public C0241ac mo4855a(int i, int i2) {
        return (i == this.f48c && i2 == this.f49d) ? this : new C0241ac(this.f47a, i, i2);
    }

    /* renamed from: a */
    public final boolean mo4856a(C0241ac acVar) {
        if (acVar != null && this.f47a.equals(acVar.f47a)) {
            C0250b.m84a((Object) acVar, "Protocol version");
            Object[] objArr = {this, acVar};
            if (!this.f47a.equals(acVar.f47a)) {
                throw new IllegalArgumentException(String.format("Versions for different protocols cannot be compared: %s %s", objArr));
            }
            int i = this.f48c - acVar.f48c;
            if (i == 0) {
                i = this.f49d - acVar.f49d;
            }
            if (i <= 0) {
                return true;
            }
        }
        return false;
    }

    /* renamed from: b */
    public final int mo4857b() {
        return this.f48c;
    }

    /* renamed from: c */
    public final int mo4858c() {
        return this.f49d;
    }

    public Object clone() {
        return super.clone();
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof C0241ac)) {
            return false;
        }
        C0241ac acVar = (C0241ac) obj;
        return this.f47a.equals(acVar.f47a) && this.f48c == acVar.f48c && this.f49d == acVar.f49d;
    }

    public final int hashCode() {
        return (this.f47a.hashCode() ^ (this.f48c * 100000)) ^ this.f49d;
    }

    public String toString() {
        return this.f47a + '/' + Integer.toString(this.f48c) + '.' + Integer.toString(this.f49d);
    }
}
