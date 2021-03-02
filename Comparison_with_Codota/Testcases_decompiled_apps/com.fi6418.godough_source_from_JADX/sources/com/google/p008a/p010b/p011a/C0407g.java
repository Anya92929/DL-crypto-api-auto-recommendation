package com.google.p008a.p010b.p011a;

import com.google.p008a.C0363al;
import com.google.p008a.C0364am;
import com.google.p008a.C0481k;
import com.google.p008a.p009a.C0348b;
import com.google.p008a.p010b.C0446f;
import com.google.p008a.p012c.C0468a;

/* renamed from: com.google.a.b.a.g */
public final class C0407g implements C0364am {

    /* renamed from: a */
    private final C0446f f3408a;

    public C0407g(C0446f fVar) {
        this.f3408a = fVar;
    }

    /* renamed from: a */
    static C0363al<?> m2639a(C0446f fVar, C0481k kVar, C0468a<?> aVar, C0348b bVar) {
        Class<?> a = bVar.mo6292a();
        if (C0363al.class.isAssignableFrom(a)) {
            return (C0363al) fVar.mo6460a(C0468a.m2796b(a)).mo6436a();
        }
        if (C0364am.class.isAssignableFrom(a)) {
            return ((C0364am) fVar.mo6460a(C0468a.m2796b(a)).mo6436a()).mo6311a(kVar, aVar);
        }
        throw new IllegalArgumentException("@JsonAdapter value must be TypeAdapter or TypeAdapterFactory reference.");
    }

    /* renamed from: a */
    public <T> C0363al<T> mo6311a(C0481k kVar, C0468a<T> aVar) {
        C0348b bVar = (C0348b) aVar.mo6494a().getAnnotation(C0348b.class);
        if (bVar == null) {
            return null;
        }
        return m2639a(this.f3408a, kVar, aVar, bVar);
    }
}
