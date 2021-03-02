package com.google.p008a.p010b.p011a;

import com.google.p008a.C0363al;
import com.google.p008a.C0364am;
import com.google.p008a.C0481k;
import com.google.p008a.p013d.C0470a;
import com.google.p008a.p013d.C0472c;
import com.google.p008a.p013d.C0473d;
import java.lang.reflect.Array;
import java.util.ArrayList;

/* renamed from: com.google.a.b.a.a */
public final class C0367a<E> extends C0363al<Object> {

    /* renamed from: a */
    public static final C0364am f3381a = new C0394b();

    /* renamed from: b */
    private final Class<E> f3382b;

    /* renamed from: c */
    private final C0363al<E> f3383c;

    public C0367a(C0481k kVar, C0363al<E> alVar, Class<E> cls) {
        this.f3383c = new C0425y(kVar, alVar, cls);
        this.f3382b = cls;
    }

    /* renamed from: a */
    public void mo6309a(C0473d dVar, Object obj) {
        if (obj == null) {
            dVar.mo6405f();
            return;
        }
        dVar.mo6399b();
        int length = Array.getLength(obj);
        for (int i = 0; i < length; i++) {
            this.f3383c.mo6309a(dVar, Array.get(obj, i));
        }
        dVar.mo6401c();
    }

    /* renamed from: b */
    public Object mo6310b(C0470a aVar) {
        if (aVar.mo6381f() == C0472c.NULL) {
            aVar.mo6385j();
            return null;
        }
        ArrayList arrayList = new ArrayList();
        aVar.mo6375a();
        while (aVar.mo6380e()) {
            arrayList.add(this.f3383c.mo6310b(aVar));
        }
        aVar.mo6376b();
        Object newInstance = Array.newInstance(this.f3382b, arrayList.size());
        for (int i = 0; i < arrayList.size(); i++) {
            Array.set(newInstance, i, arrayList.get(i));
        }
        return newInstance;
    }
}
