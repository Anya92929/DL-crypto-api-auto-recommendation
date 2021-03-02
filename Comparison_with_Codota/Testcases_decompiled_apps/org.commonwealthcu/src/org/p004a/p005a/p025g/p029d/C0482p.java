package org.p004a.p005a.p025g.p029d;

import java.util.Collection;
import org.p004a.p005a.p021e.C0352h;
import org.p004a.p005a.p021e.C0353i;
import org.p004a.p005a.p021e.C0354j;
import org.p004a.p005a.p034j.C0544b;
import org.p004a.p005a.p036l.C0553e;

/* renamed from: org.a.a.g.d.p */
public final class C0482p implements C0353i, C0354j {

    /* renamed from: a */
    private final String[] f484a;

    /* renamed from: b */
    private final int f485b;

    public C0482p() {
        this((String[]) null, C0483q.f486a);
    }

    private C0482p(String[] strArr, int i) {
        this.f484a = null;
        this.f485b = i;
    }

    /* renamed from: a */
    public final C0352h mo5069a(C0544b bVar) {
        if (bVar == null) {
            return new C0479m((String[]) null, this.f485b);
        }
        Collection collection = (Collection) bVar.mo5196a("http.protocol.cookie-datepatterns");
        return new C0479m(collection != null ? (String[]) collection.toArray(new String[collection.size()]) : null, this.f485b);
    }

    /* renamed from: a */
    public final C0352h mo5070a(C0553e eVar) {
        return new C0479m(this.f484a);
    }
}
