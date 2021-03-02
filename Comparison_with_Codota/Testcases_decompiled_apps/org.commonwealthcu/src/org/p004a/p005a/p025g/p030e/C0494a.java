package org.p004a.p005a.p025g.p030e;

import java.io.InputStream;
import org.p004a.p005a.C0344e;
import org.p004a.p005a.C0546k;
import org.p004a.p005a.C0567p;
import org.p004a.p005a.p007b.p008a.C0250b;
import org.p004a.p005a.p022f.C0377b;
import org.p004a.p005a.p022f.C0379d;
import org.p004a.p005a.p025g.p031f.C0503e;
import org.p004a.p005a.p025g.p031f.C0505g;
import org.p004a.p005a.p025g.p031f.C0509k;
import org.p004a.p005a.p032h.C0519f;

/* renamed from: org.a.a.g.e.a */
public final class C0494a {

    /* renamed from: a */
    private final C0379d f494a;

    public C0494a(C0379d dVar) {
        this.f494a = (C0379d) C0250b.m84a((Object) dVar, "Content length strategy");
    }

    /* renamed from: a */
    public final C0546k mo5273a(C0519f fVar, C0567p pVar) {
        C0250b.m84a((Object) fVar, "Session input buffer");
        C0250b.m84a((Object) pVar, "HTTP message");
        C0377b bVar = new C0377b();
        long a = this.f494a.mo5120a(pVar);
        if (a == -2) {
            bVar.mo5088a(true);
            bVar.mo5118a(-1);
            bVar.mo5119a((InputStream) new C0503e(fVar));
        } else if (a == -1) {
            bVar.mo5088a(false);
            bVar.mo5118a(-1);
            bVar.mo5119a((InputStream) new C0509k(fVar));
        } else {
            bVar.mo5088a(false);
            bVar.mo5118a(a);
            bVar.mo5119a((InputStream) new C0505g(fVar, a));
        }
        C0344e c = pVar.mo5326c("Content-Type");
        if (c != null) {
            bVar.mo5087a(c);
        }
        C0344e c2 = pVar.mo5326c("Content-Encoding");
        if (c2 != null) {
            bVar.mo5089b(c2);
        }
        return bVar;
    }
}
