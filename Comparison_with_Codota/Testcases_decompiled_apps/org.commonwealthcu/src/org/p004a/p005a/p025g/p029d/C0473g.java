package org.p004a.p005a.p025g.p029d;

import java.util.Date;
import org.p004a.p005a.p007b.p008a.C0250b;
import org.p004a.p005a.p007b.p012e.C0281a;
import org.p004a.p005a.p021e.C0357m;
import org.p004a.p005a.p021e.C0358n;

/* renamed from: org.a.a.g.d.g */
public final class C0473g extends C0457a {

    /* renamed from: a */
    private final String[] f473a;

    public C0473g(String[] strArr) {
        C0250b.m84a((Object) strArr, "Array of date patterns");
        this.f473a = strArr;
    }

    /* renamed from: a */
    public final void mo5054a(C0358n nVar, String str) {
        C0250b.m84a((Object) nVar, "Cookie");
        if (str == null) {
            throw new C0357m("Missing value for expires attribute");
        }
        Date a = C0281a.m173a(str, this.f473a);
        if (a == null) {
            throw new C0357m("Unable to parse expires attribute: " + str);
        }
        nVar.mo5075b(a);
    }
}
