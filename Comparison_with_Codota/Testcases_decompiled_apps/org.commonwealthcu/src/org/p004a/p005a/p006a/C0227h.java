package org.p004a.p005a.p006a;

import java.util.Locale;
import org.p004a.p005a.C0565n;
import org.p004a.p005a.p007b.p008a.C0250b;

/* renamed from: org.a.a.a.h */
public final class C0227h {

    /* renamed from: a */
    public static final String f25a = null;

    /* renamed from: b */
    private static String f26b = null;

    /* renamed from: c */
    private static String f27c = null;

    /* renamed from: d */
    private final String f28d;

    /* renamed from: e */
    private final String f29e;

    /* renamed from: f */
    private final String f30f;

    /* renamed from: g */
    private final int f31g;

    static {
        new C0227h((String) null, -1, (String) null, (String) null);
    }

    public C0227h(String str, int i, String str2, String str3) {
        String str4 = null;
        this.f30f = str == null ? null : str.toLowerCase(Locale.ENGLISH);
        this.f31g = i < 0 ? -1 : i;
        this.f29e = str2 == null ? null : str2;
        this.f28d = str3 != null ? str3.toUpperCase(Locale.ENGLISH) : str4;
    }

    public C0227h(C0565n nVar, String str, String str2) {
        this(nVar.mo5441a(), nVar.mo5442b(), str, str2);
    }

    /* renamed from: a */
    public final int mo4819a(C0227h hVar) {
        int i = 0;
        if (C0250b.m97a((Object) this.f28d, (Object) hVar.f28d)) {
            i = 1;
        } else if (!(this.f28d == null || hVar.f28d == null)) {
            return -1;
        }
        if (C0250b.m97a((Object) this.f29e, (Object) hVar.f29e)) {
            i += 2;
        } else if (!(this.f29e == null || hVar.f29e == null)) {
            return -1;
        }
        if (this.f31g == hVar.f31g) {
            i += 4;
        } else if (!(this.f31g == -1 || hVar.f31g == -1)) {
            return -1;
        }
        if (C0250b.m97a((Object) this.f30f, (Object) hVar.f30f)) {
            return i + 8;
        }
        if (this.f30f == null || hVar.f30f == null) {
            return i;
        }
        return -1;
    }

    public final boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof C0227h)) {
            return super.equals(obj);
        }
        C0227h hVar = (C0227h) obj;
        return C0250b.m97a((Object) this.f30f, (Object) hVar.f30f) && this.f31g == hVar.f31g && C0250b.m97a((Object) this.f29e, (Object) hVar.f29e) && C0250b.m97a((Object) this.f28d, (Object) hVar.f28d);
    }

    public final int hashCode() {
        return C0250b.m77a(C0250b.m77a((C0250b.m77a(17, (Object) this.f30f) * 37) + this.f31g, (Object) this.f29e), (Object) this.f28d);
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder();
        if (this.f28d != null) {
            sb.append(this.f28d.toUpperCase(Locale.ENGLISH));
            sb.append(' ');
        }
        if (this.f29e != null) {
            sb.append('\'');
            sb.append(this.f29e);
            sb.append('\'');
        } else {
            sb.append("<any realm>");
        }
        if (this.f30f != null) {
            sb.append('@');
            sb.append(this.f30f);
            if (this.f31g >= 0) {
                sb.append(':');
                sb.append(this.f31g);
            }
        }
        return sb.toString();
    }
}
