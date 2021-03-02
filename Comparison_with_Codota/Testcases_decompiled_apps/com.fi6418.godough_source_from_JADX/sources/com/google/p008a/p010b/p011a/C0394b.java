package com.google.p008a.p010b.p011a;

import com.google.p008a.C0363al;
import com.google.p008a.C0364am;
import com.google.p008a.C0481k;
import com.google.p008a.p010b.C0442b;
import com.google.p008a.p012c.C0468a;
import java.lang.reflect.GenericArrayType;
import java.lang.reflect.Type;

/* renamed from: com.google.a.b.a.b */
final class C0394b implements C0364am {
    C0394b() {
    }

    /* renamed from: a */
    public <T> C0363al<T> mo6311a(C0481k kVar, C0468a<T> aVar) {
        Type b = aVar.mo6495b();
        if (!(b instanceof GenericArrayType) && (!(b instanceof Class) || !((Class) b).isArray())) {
            return null;
        }
        Type g = C0442b.m2749g(b);
        return new C0367a(kVar, kVar.mo6511a(C0468a.m2794a(g)), C0442b.m2747e(g));
    }
}
