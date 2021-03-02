package org.p004a.p005a;

import java.io.Serializable;
import java.util.Locale;
import org.p004a.p005a.p007b.p008a.C0250b;

/* renamed from: org.a.a.n */
public final class C0565n implements Serializable, Cloneable {

    /* renamed from: a */
    private String f640a;

    /* renamed from: b */
    private String f641b;

    /* renamed from: c */
    private int f642c;

    /* renamed from: d */
    private String f643d;

    public C0565n(String str, int i) {
        this(str, i, (String) null);
    }

    public C0565n(String str, int i, String str2) {
        this.f640a = (String) C0250b.m84a((Object) str, "Host name");
        this.f641b = str.toLowerCase(Locale.ENGLISH);
        if (str2 != null) {
            this.f643d = str2.toLowerCase(Locale.ENGLISH);
        } else {
            this.f643d = "http";
        }
        this.f642c = i;
    }

    /* renamed from: a */
    public final String mo5441a() {
        return this.f640a;
    }

    /* renamed from: b */
    public final int mo5442b() {
        return this.f642c;
    }

    /* renamed from: c */
    public final String mo5443c() {
        return this.f643d;
    }

    public final Object clone() {
        return super.clone();
    }

    /* renamed from: d */
    public final String mo5445d() {
        if (this.f642c == -1) {
            return this.f640a;
        }
        StringBuilder sb = new StringBuilder(this.f640a.length() + 6);
        sb.append(this.f640a);
        sb.append(":");
        sb.append(Integer.toString(this.f642c));
        return sb.toString();
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof C0565n)) {
            return false;
        }
        C0565n nVar = (C0565n) obj;
        return this.f641b.equals(nVar.f641b) && this.f642c == nVar.f642c && this.f643d.equals(nVar.f643d);
    }

    public final int hashCode() {
        return C0250b.m77a((C0250b.m77a(17, (Object) this.f641b) * 37) + this.f642c, (Object) this.f643d);
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(this.f643d);
        sb.append("://");
        sb.append(this.f640a);
        if (this.f642c != -1) {
            sb.append(':');
            sb.append(Integer.toString(this.f642c));
        }
        return sb.toString();
    }
}
