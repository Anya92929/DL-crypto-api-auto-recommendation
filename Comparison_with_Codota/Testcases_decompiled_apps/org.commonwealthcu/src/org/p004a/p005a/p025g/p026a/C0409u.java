package org.p004a.p005a.p025g.p026a;

import java.io.UnsupportedEncodingException;
import java.util.Locale;

/* renamed from: org.a.a.g.a.u */
final class C0409u extends C0408t {
    C0409u(String str, String str2) {
        try {
            String c = C0404p.m581e(str2);
            String d = C0404p.m581e(str);
            if (c != null) {
                c.getBytes("ASCII");
            }
            if (d != null) {
                d.toUpperCase(Locale.US).getBytes("ASCII");
            }
        } catch (UnsupportedEncodingException e) {
            throw new C0403o("Unicode unsupported: " + e.getMessage(), e);
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: b */
    public final String mo5177b() {
        mo5174a(40, 1);
        mo5180d(-1576500735);
        mo5179c(0);
        mo5179c(0);
        mo5180d(40);
        mo5179c(0);
        mo5179c(0);
        mo5180d(40);
        mo5179c(261);
        mo5180d(2600);
        mo5179c(3840);
        return super.mo5177b();
    }
}
