package org.p004a.p005a.p025g;

import org.p004a.p005a.C0239aa;
import org.p004a.p005a.C0241ac;
import org.p004a.p005a.C0247b;
import org.p004a.p005a.C0344e;
import org.p004a.p005a.C0513h;
import org.p004a.p005a.C0570s;
import org.p004a.p005a.C0573v;
import org.p004a.p005a.p007b.p008a.C0250b;
import org.p004a.p005a.p033i.C0535n;
import org.p004a.p005a.p036l.C0553e;

/* renamed from: org.a.a.g.b */
public final class C0415b implements C0247b {
    static {
        new C0415b();
    }

    /* renamed from: a */
    public final boolean mo4871a(C0570s sVar, C0553e eVar) {
        C0250b.m84a((Object) sVar, "HTTP response");
        C0250b.m84a((Object) eVar, "HTTP context");
        C0241ac a = sVar.mo5345a().mo4866a();
        C0344e c = sVar.mo5326c("Transfer-Encoding");
        if (c == null) {
            int b = sVar.mo5345a().mo4867b();
            if ((b < 200 || b == 204 || b == 304 || b == 205) ? false : true) {
                C0344e[] b2 = sVar.mo5325b("Content-Length");
                if (b2.length != 1) {
                    return false;
                }
                try {
                    if (Integer.parseInt(b2[0].mo5041d()) < 0) {
                        return false;
                    }
                } catch (NumberFormatException e) {
                    return false;
                }
            }
        } else if (!"chunked".equalsIgnoreCase(c.mo5041d())) {
            return false;
        }
        C0513h e2 = sVar.mo5330e("Connection");
        if (!e2.hasNext()) {
            e2 = sVar.mo5330e("Proxy-Connection");
        }
        if (e2.hasNext()) {
            try {
                C0535n nVar = new C0535n(e2);
                boolean z = false;
                while (nVar.hasNext()) {
                    String a2 = nVar.mo4869a();
                    if ("Close".equalsIgnoreCase(a2)) {
                        return false;
                    }
                    if ("Keep-Alive".equalsIgnoreCase(a2)) {
                        z = true;
                    }
                }
                if (z) {
                    return true;
                }
            } catch (C0239aa e3) {
                return false;
            }
        }
        return !a.mo4856a(C0573v.f644a);
    }
}
