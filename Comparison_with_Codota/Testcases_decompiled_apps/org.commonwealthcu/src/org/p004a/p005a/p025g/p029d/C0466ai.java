package org.p004a.p005a.p025g.p029d;

import java.util.Collection;
import org.p004a.p005a.p021e.C0352h;
import org.p004a.p005a.p021e.C0353i;
import org.p004a.p005a.p021e.C0354j;
import org.p004a.p005a.p034j.C0544b;
import org.p004a.p005a.p036l.C0553e;

/* renamed from: org.a.a.g.d.ai */
public final class C0466ai implements C0353i, C0354j {

    /* renamed from: a */
    private final String[] f460a;

    /* renamed from: b */
    private final boolean f461b;

    public C0466ai() {
        this((String[]) null, false);
    }

    private C0466ai(String[] strArr, boolean z) {
        this.f460a = null;
        this.f461b = false;
    }

    /* renamed from: a */
    public final C0352h mo5069a(C0544b bVar) {
        if (bVar == null) {
            return new C0465ah();
        }
        Collection collection = (Collection) bVar.mo5196a("http.protocol.cookie-datepatterns");
        return new C0465ah(collection != null ? (String[]) collection.toArray(new String[collection.size()]) : null, bVar.mo5390a("http.protocol.single-cookie-header", false));
    }

    /* renamed from: a */
    public final C0352h mo5070a(C0553e eVar) {
        return new C0465ah(this.f460a, this.f461b);
    }
}
