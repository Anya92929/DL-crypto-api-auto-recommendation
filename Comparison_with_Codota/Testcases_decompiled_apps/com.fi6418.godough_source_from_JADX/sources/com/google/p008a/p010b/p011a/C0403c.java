package com.google.p008a.p010b.p011a;

import com.google.p008a.C0363al;
import com.google.p008a.C0364am;
import com.google.p008a.C0481k;
import com.google.p008a.p010b.C0442b;
import com.google.p008a.p010b.C0446f;
import com.google.p008a.p012c.C0468a;
import java.lang.reflect.Type;
import java.util.Collection;

/* renamed from: com.google.a.b.a.c */
public final class C0403c implements C0364am {

    /* renamed from: a */
    private final C0446f f3401a;

    public C0403c(C0446f fVar) {
        this.f3401a = fVar;
    }

    /* renamed from: a */
    public <T> C0363al<T> mo6311a(C0481k kVar, C0468a<T> aVar) {
        Type b = aVar.mo6495b();
        Class<? super T> a = aVar.mo6494a();
        if (!Collection.class.isAssignableFrom(a)) {
            return null;
        }
        Type a2 = C0442b.m2735a(b, (Class<?>) a);
        return new C0404d(kVar, a2, kVar.mo6511a(C0468a.m2794a(a2)), this.f3401a.mo6460a(aVar));
    }
}
