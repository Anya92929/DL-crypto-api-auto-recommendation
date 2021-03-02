package com.google.p008a.p010b.p011a;

import com.google.p008a.C0363al;
import com.google.p008a.C0481k;
import com.google.p008a.p010b.C0431ae;
import com.google.p008a.p013d.C0470a;
import com.google.p008a.p013d.C0472c;
import com.google.p008a.p013d.C0473d;
import java.lang.reflect.Type;
import java.util.Collection;

/* renamed from: com.google.a.b.a.d */
final class C0404d<E> extends C0363al<Collection<E>> {

    /* renamed from: a */
    private final C0363al<E> f3402a;

    /* renamed from: b */
    private final C0431ae<? extends Collection<E>> f3403b;

    public C0404d(C0481k kVar, Type type, C0363al<E> alVar, C0431ae<? extends Collection<E>> aeVar) {
        this.f3402a = new C0425y(kVar, alVar, type);
        this.f3403b = aeVar;
    }

    /* renamed from: a */
    public Collection<E> mo6310b(C0470a aVar) {
        if (aVar.mo6381f() == C0472c.NULL) {
            aVar.mo6385j();
            return null;
        }
        Collection<E> collection = (Collection) this.f3403b.mo6436a();
        aVar.mo6375a();
        while (aVar.mo6380e()) {
            collection.add(this.f3402a.mo6310b(aVar));
        }
        aVar.mo6376b();
        return collection;
    }

    /* renamed from: a */
    public void mo6309a(C0473d dVar, Collection<E> collection) {
        if (collection == null) {
            dVar.mo6405f();
            return;
        }
        dVar.mo6399b();
        for (E a : collection) {
            this.f3402a.mo6309a(dVar, a);
        }
        dVar.mo6401c();
    }
}
