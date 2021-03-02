package org.p004a.p005a.p022f;

import java.io.Serializable;
import java.nio.charset.Charset;
import java.util.Locale;
import org.p004a.p005a.C0297c;
import org.p004a.p005a.C0344e;
import org.p004a.p005a.C0360f;
import org.p004a.p005a.C0546k;
import org.p004a.p005a.C0576y;
import org.p004a.p005a.p007b.p008a.C0250b;
import org.p004a.p005a.p033i.C0525d;
import org.p004a.p005a.p037m.C0563b;

/* renamed from: org.a.a.f.e */
public final class C0380e implements Serializable {

    /* renamed from: a */
    public static final C0380e f226a = f229d;

    /* renamed from: b */
    public static final C0380e f227b = f228c;

    /* renamed from: c */
    private static C0380e f228c = m468a("application/octet-stream", (Charset) null);

    /* renamed from: d */
    private static C0380e f229d = m468a("text/plain", C0297c.f131c);

    /* renamed from: e */
    private final String f230e;

    /* renamed from: f */
    private final Charset f231f;

    /* renamed from: g */
    private final C0576y[] f232g;

    static {
        m468a("application/atom+xml", C0297c.f131c);
        m468a("application/x-www-form-urlencoded", C0297c.f131c);
        m468a("application/json", C0297c.f129a);
        m468a("application/svg+xml", C0297c.f131c);
        m468a("application/xhtml+xml", C0297c.f131c);
        m468a("application/xml", C0297c.f131c);
        m468a("multipart/form-data", C0297c.f131c);
        m468a("text/html", C0297c.f131c);
        m468a("text/xml", C0297c.f131c);
        m468a("*/*", (Charset) null);
    }

    private C0380e(String str, Charset charset) {
        this.f230e = str;
        this.f231f = charset;
        this.f232g = null;
    }

    private C0380e(String str, C0576y[] yVarArr) {
        this.f230e = str;
        this.f232g = yVarArr;
        String a = m466a("charset");
        this.f231f = !C0250b.m105b((CharSequence) a) ? Charset.forName(a) : null;
    }

    /* renamed from: a */
    private String m466a(String str) {
        C0250b.m82a((CharSequence) str, "Parameter name");
        if (this.f232g == null) {
            return null;
        }
        for (C0576y yVar : this.f232g) {
            if (yVar.mo5357a().equalsIgnoreCase(str)) {
                return yVar.mo5358b();
            }
        }
        return null;
    }

    /* renamed from: a */
    public static C0380e m467a(String str, String str2) {
        return m468a(str, !C0250b.m105b((CharSequence) str2) ? Charset.forName(str2) : null);
    }

    /* renamed from: a */
    public static C0380e m468a(String str, Charset charset) {
        boolean z = false;
        String lowerCase = ((String) C0250b.m101b((CharSequence) str, "MIME type")).toLowerCase(Locale.US);
        int i = 0;
        while (true) {
            if (i >= lowerCase.length()) {
                z = true;
                break;
            }
            char charAt = lowerCase.charAt(i);
            if (charAt == '\"' || charAt == ',' || charAt == ';') {
                break;
            }
            i++;
        }
        C0250b.m95a(z, "MIME type may not contain reserved characters");
        return new C0380e(lowerCase, charset);
    }

    /* renamed from: a */
    public static C0380e m469a(C0546k kVar) {
        C0344e d;
        if (kVar == null || (d = kVar.mo5091d()) == null) {
            return null;
        }
        C0360f[] e = d.mo5042e();
        if (e.length <= 0) {
            return null;
        }
        C0360f fVar = e[0];
        String a = fVar.mo5080a();
        C0576y[] c = fVar.mo5084c();
        if (c == null || c.length <= 0) {
            c = null;
        }
        return new C0380e(a, c);
    }

    /* renamed from: a */
    public final String mo5121a() {
        return this.f230e;
    }

    /* renamed from: b */
    public final Charset mo5122b() {
        return this.f231f;
    }

    public final String toString() {
        C0563b bVar = new C0563b(64);
        bVar.mo5428a(this.f230e);
        if (this.f232g != null) {
            bVar.mo5428a("; ");
            C0525d.f570a.mo5340a(bVar, this.f232g, false);
        } else if (this.f231f != null) {
            bVar.mo5428a("; charset=");
            bVar.mo5428a(this.f231f.name());
        }
        return bVar.toString();
    }
}
