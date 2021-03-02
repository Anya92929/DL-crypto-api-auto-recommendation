package org.p004a.p005a.p025g.p030e;

import org.p004a.p005a.C0239aa;
import org.p004a.p005a.C0240ab;
import org.p004a.p005a.C0344e;
import org.p004a.p005a.C0360f;
import org.p004a.p005a.C0567p;
import org.p004a.p005a.p007b.p008a.C0250b;
import org.p004a.p005a.p022f.C0379d;

/* renamed from: org.a.a.g.e.c */
public final class C0496c implements C0379d {

    /* renamed from: a */
    private final int f496a;

    static {
        new C0496c();
    }

    public C0496c() {
        this(-1);
    }

    private C0496c(int i) {
        this.f496a = -1;
    }

    /* renamed from: a */
    public final long mo5120a(C0567p pVar) {
        long j;
        C0250b.m84a((Object) pVar, "HTTP message");
        C0344e c = pVar.mo5326c("Transfer-Encoding");
        if (c != null) {
            try {
                C0360f[] e = c.mo5042e();
                int length = e.length;
                return (!"identity".equalsIgnoreCase(c.mo5041d()) && length > 0 && "chunked".equalsIgnoreCase(e[length + -1].mo5080a())) ? -2 : -1;
            } catch (C0239aa e2) {
                throw new C0240ab("Invalid Transfer-Encoding header value: " + c, e2);
            }
        } else if (pVar.mo5326c("Content-Length") == null) {
            return (long) this.f496a;
        } else {
            C0344e[] b = pVar.mo5325b("Content-Length");
            int length2 = b.length - 1;
            while (true) {
                if (length2 < 0) {
                    j = -1;
                    break;
                }
                try {
                    j = Long.parseLong(b[length2].mo5041d());
                    break;
                } catch (NumberFormatException e3) {
                    length2--;
                }
            }
            if (j >= 0) {
                return j;
            }
            return -1;
        }
    }
}
