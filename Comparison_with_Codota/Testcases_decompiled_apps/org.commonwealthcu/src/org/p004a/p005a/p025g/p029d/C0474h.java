package org.p004a.p005a.p025g.p029d;

import java.util.Date;
import org.p004a.p005a.p007b.p008a.C0250b;
import org.p004a.p005a.p021e.C0357m;
import org.p004a.p005a.p021e.C0358n;

/* renamed from: org.a.a.g.d.h */
public final class C0474h extends C0457a {
    /* renamed from: a */
    public final void mo5054a(C0358n nVar, String str) {
        C0250b.m84a((Object) nVar, "Cookie");
        if (str == null) {
            throw new C0357m("Missing value for max-age attribute");
        }
        try {
            int parseInt = Integer.parseInt(str);
            if (parseInt < 0) {
                throw new C0357m("Negative max-age attribute: " + str);
            }
            nVar.mo5075b(new Date(System.currentTimeMillis() + (((long) parseInt) * 1000)));
        } catch (NumberFormatException e) {
            throw new C0357m("Invalid max-age attribute: " + str);
        }
    }
}
