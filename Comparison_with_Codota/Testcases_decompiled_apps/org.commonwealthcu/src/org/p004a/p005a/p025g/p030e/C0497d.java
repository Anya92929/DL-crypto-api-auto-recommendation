package org.p004a.p005a.p025g.p030e;

import org.p004a.p005a.C0240ab;
import org.p004a.p005a.C0344e;
import org.p004a.p005a.C0567p;
import org.p004a.p005a.C0573v;
import org.p004a.p005a.p007b.p008a.C0250b;
import org.p004a.p005a.p022f.C0379d;

/* renamed from: org.a.a.g.e.d */
public final class C0497d implements C0379d {

    /* renamed from: a */
    private final int f497a;

    static {
        new C0497d();
    }

    public C0497d() {
        this(-1);
    }

    private C0497d(int i) {
        this.f497a = -1;
    }

    /* renamed from: a */
    public final long mo5120a(C0567p pVar) {
        C0250b.m84a((Object) pVar, "HTTP message");
        C0344e c = pVar.mo5326c("Transfer-Encoding");
        if (c != null) {
            String d = c.mo5041d();
            if ("chunked".equalsIgnoreCase(d)) {
                if (!pVar.mo4901c().mo4856a(C0573v.f644a)) {
                    return -2;
                }
                throw new C0240ab("Chunked transfer encoding not allowed for " + pVar.mo4901c());
            } else if ("identity".equalsIgnoreCase(d)) {
                return -1;
            } else {
                throw new C0240ab("Unsupported transfer encoding: " + d);
            }
        } else {
            C0344e c2 = pVar.mo5326c("Content-Length");
            if (c2 == null) {
                return (long) this.f497a;
            }
            String d2 = c2.mo5041d();
            try {
                long parseLong = Long.parseLong(d2);
                if (parseLong >= 0) {
                    return parseLong;
                }
                throw new C0240ab("Negative content length: " + d2);
            } catch (NumberFormatException e) {
                throw new C0240ab("Invalid content length: " + d2);
            }
        }
    }
}
