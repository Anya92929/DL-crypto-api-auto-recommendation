package com.google.p008a.p010b.p011a;

import com.google.p008a.C0363al;
import com.google.p008a.C0364am;
import com.google.p008a.C0481k;
import com.google.p008a.p010b.C0431ae;
import com.google.p008a.p010b.C0442b;
import com.google.p008a.p010b.C0446f;
import com.google.p008a.p012c.C0468a;
import java.lang.reflect.Type;
import java.util.Map;

/* renamed from: com.google.a.b.a.l */
public final class C0412l implements C0364am {

    /* renamed from: a */
    private final C0446f f3417a;
    /* access modifiers changed from: private */

    /* renamed from: b */
    public final boolean f3418b;

    public C0412l(C0446f fVar, boolean z) {
        this.f3417a = fVar;
        this.f3418b = z;
    }

    /* renamed from: a */
    private C0363al<?> m2672a(C0481k kVar, Type type) {
        return (type == Boolean.TYPE || type == Boolean.class) ? C0426z.f3470f : kVar.mo6511a(C0468a.m2794a(type));
    }

    /* renamed from: a */
    public <T> C0363al<T> mo6311a(C0481k kVar, C0468a<T> aVar) {
        Type b = aVar.mo6495b();
        if (!Map.class.isAssignableFrom(aVar.mo6494a())) {
            return null;
        }
        Type[] b2 = C0442b.m2744b(b, C0442b.m2747e(b));
        C0363al<?> a = m2672a(kVar, b2[0]);
        C0363al<?> a2 = kVar.mo6511a(C0468a.m2794a(b2[1]));
        C0431ae<T> a3 = this.f3417a.mo6460a(aVar);
        return new C0413m(this, kVar, b2[0], a, b2[1], a2, a3);
    }
}
