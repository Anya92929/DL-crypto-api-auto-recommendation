package org.p004a.p005a.p021e;

import java.util.Locale;
import org.p004a.p005a.p007b.p008a.C0250b;

/* renamed from: org.a.a.e.e */
public final class C0349e {

    /* renamed from: a */
    private final String f178a;

    /* renamed from: b */
    private final int f179b;

    /* renamed from: c */
    private final String f180c;

    /* renamed from: d */
    private final boolean f181d;

    public C0349e(String str, int i, String str2, boolean z) {
        C0250b.m101b((CharSequence) str, "Host");
        C0250b.m78a(i, "Port");
        C0250b.m84a((Object) str2, "Path");
        this.f178a = str.toLowerCase(Locale.ENGLISH);
        this.f179b = i;
        if (str2.trim().length() != 0) {
            this.f180c = str2;
        } else {
            this.f180c = "/";
        }
        this.f181d = z;
    }

    /* renamed from: a */
    public final String mo5057a() {
        return this.f178a;
    }

    /* renamed from: b */
    public final String mo5058b() {
        return this.f180c;
    }

    /* renamed from: c */
    public final int mo5059c() {
        return this.f179b;
    }

    /* renamed from: d */
    public final boolean mo5060d() {
        return this.f181d;
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append('[');
        if (this.f181d) {
            sb.append("(secure)");
        }
        sb.append(this.f178a);
        sb.append(':');
        sb.append(Integer.toString(this.f179b));
        sb.append(this.f180c);
        sb.append(']');
        return sb.toString();
    }
}
