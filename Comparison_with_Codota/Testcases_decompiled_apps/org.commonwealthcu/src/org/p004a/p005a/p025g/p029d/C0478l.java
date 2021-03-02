package org.p004a.p005a.p025g.p029d;

import java.util.Collection;
import org.p004a.p005a.p021e.C0352h;
import org.p004a.p005a.p021e.C0353i;
import org.p004a.p005a.p021e.C0354j;
import org.p004a.p005a.p034j.C0544b;
import org.p004a.p005a.p036l.C0553e;

/* renamed from: org.a.a.g.d.l */
public final class C0478l implements C0353i, C0354j {

    /* renamed from: a */
    private final String[] f479a;

    /* renamed from: b */
    private final boolean f480b;

    public C0478l() {
        this((String[]) null, false);
    }

    private C0478l(String[] strArr, boolean z) {
        this.f479a = null;
        this.f480b = false;
    }

    /* renamed from: a */
    public final C0352h mo5069a(C0544b bVar) {
        if (bVar == null) {
            return new C0477k();
        }
        Collection collection = (Collection) bVar.mo5196a("http.protocol.cookie-datepatterns");
        return new C0477k(collection != null ? (String[]) collection.toArray(new String[collection.size()]) : null, bVar.mo5390a("http.protocol.single-cookie-header", false));
    }

    /* renamed from: a */
    public final C0352h mo5070a(C0553e eVar) {
        return new C0477k(this.f479a, this.f480b);
    }
}
