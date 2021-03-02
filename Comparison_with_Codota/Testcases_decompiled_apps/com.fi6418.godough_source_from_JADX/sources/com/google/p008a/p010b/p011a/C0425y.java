package com.google.p008a.p010b.p011a;

import com.google.p008a.C0363al;
import com.google.p008a.C0481k;
import com.google.p008a.p012c.C0468a;
import com.google.p008a.p013d.C0470a;
import com.google.p008a.p013d.C0473d;
import java.lang.reflect.Type;
import java.lang.reflect.TypeVariable;

/* renamed from: com.google.a.b.a.y */
final class C0425y<T> extends C0363al<T> {

    /* renamed from: a */
    private final C0481k f3444a;

    /* renamed from: b */
    private final C0363al<T> f3445b;

    /* renamed from: c */
    private final Type f3446c;

    C0425y(C0481k kVar, C0363al<T> alVar, Type type) {
        this.f3444a = kVar;
        this.f3445b = alVar;
        this.f3446c = type;
    }

    /* renamed from: a */
    private Type m2706a(Type type, Object obj) {
        return obj != null ? (type == Object.class || (type instanceof TypeVariable) || (type instanceof Class)) ? obj.getClass() : type : type;
    }

    /* renamed from: a */
    public void mo6309a(C0473d dVar, T t) {
        C0363al<T> alVar = this.f3445b;
        Type a = m2706a(this.f3446c, (Object) t);
        if (a != this.f3446c) {
            alVar = this.f3444a.mo6511a(C0468a.m2794a(a));
            if ((alVar instanceof C0419s) && !(this.f3445b instanceof C0419s)) {
                alVar = this.f3445b;
            }
        }
        alVar.mo6309a(dVar, t);
    }

    /* renamed from: b */
    public T mo6310b(C0470a aVar) {
        return this.f3445b.mo6310b(aVar);
    }
}
