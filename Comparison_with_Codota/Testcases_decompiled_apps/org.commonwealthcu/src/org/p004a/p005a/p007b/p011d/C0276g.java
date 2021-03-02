package org.p004a.p005a.p007b.p011d;

import java.util.Collection;
import org.p004a.p005a.C0344e;
import org.p004a.p005a.C0568q;
import org.p004a.p005a.C0569r;
import org.p004a.p005a.p007b.p008a.C0250b;
import org.p004a.p005a.p036l.C0553e;

/* renamed from: org.a.a.b.d.g */
public final class C0276g implements C0569r {

    /* renamed from: a */
    private final Collection f102a;

    public C0276g() {
        this((Collection) null);
    }

    private C0276g(Collection collection) {
        this.f102a = null;
    }

    /* renamed from: a */
    public final void mo4917a(C0568q qVar, C0553e eVar) {
        C0250b.m84a((Object) qVar, "HTTP request");
        if (!qVar.mo4902g().mo4863a().equalsIgnoreCase("CONNECT")) {
            Collection<C0344e> collection = (Collection) qVar.mo5331f().mo5196a("http.default-headers");
            if (collection == null) {
                collection = this.f102a;
            }
            if (collection != null) {
                for (C0344e a : collection) {
                    qVar.mo5320a(a);
                }
            }
        }
    }
}
