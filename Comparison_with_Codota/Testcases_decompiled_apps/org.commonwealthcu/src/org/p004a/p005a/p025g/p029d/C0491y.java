package org.p004a.p005a.p025g.p029d;

import java.util.Collection;
import org.p004a.p005a.p021e.C0352h;
import org.p004a.p005a.p021e.C0353i;
import org.p004a.p005a.p021e.C0354j;
import org.p004a.p005a.p034j.C0544b;
import org.p004a.p005a.p036l.C0553e;

/* renamed from: org.a.a.g.d.y */
public final class C0491y implements C0353i, C0354j {

    /* renamed from: a */
    private final String[] f491a;

    public C0491y() {
        this((String[]) null);
    }

    private C0491y(String[] strArr) {
        this.f491a = null;
    }

    /* renamed from: a */
    public final C0352h mo5069a(C0544b bVar) {
        if (bVar == null) {
            return new C0490x();
        }
        Collection collection = (Collection) bVar.mo5196a("http.protocol.cookie-datepatterns");
        return new C0490x(collection != null ? (String[]) collection.toArray(new String[collection.size()]) : null);
    }

    /* renamed from: a */
    public final C0352h mo5070a(C0553e eVar) {
        return new C0490x(this.f491a);
    }
}
