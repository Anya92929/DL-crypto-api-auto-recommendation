package com.google.p008a.p010b;

import com.google.p008a.C0489s;
import com.google.p008a.p012c.C0468a;
import java.lang.reflect.Constructor;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.Collection;
import java.util.EnumSet;
import java.util.Map;
import java.util.Queue;
import java.util.Set;
import java.util.SortedMap;
import java.util.SortedSet;

/* renamed from: com.google.a.b.f */
public final class C0446f {

    /* renamed from: a */
    private final Map<Type, C0489s<?>> f3522a;

    public C0446f(Map<Type, C0489s<?>> map) {
        this.f3522a = map;
    }

    /* renamed from: a */
    private <T> C0431ae<T> m2752a(Class<? super T> cls) {
        try {
            Constructor<? super T> declaredConstructor = cls.getDeclaredConstructor(new Class[0]);
            if (!declaredConstructor.isAccessible()) {
                declaredConstructor.setAccessible(true);
            }
            return new C0452l(this, declaredConstructor);
        } catch (NoSuchMethodException e) {
            return null;
        }
    }

    /* renamed from: a */
    private <T> C0431ae<T> m2753a(Type type, Class<? super T> cls) {
        if (Collection.class.isAssignableFrom(cls)) {
            return SortedSet.class.isAssignableFrom(cls) ? new C0453m(this) : EnumSet.class.isAssignableFrom(cls) ? new C0454n(this, type) : Set.class.isAssignableFrom(cls) ? new C0455o(this) : Queue.class.isAssignableFrom(cls) ? new C0456p(this) : new C0457q(this);
        }
        if (Map.class.isAssignableFrom(cls)) {
            return SortedMap.class.isAssignableFrom(cls) ? new C0458r(this) : (!(type instanceof ParameterizedType) || String.class.isAssignableFrom(C0468a.m2794a(((ParameterizedType) type).getActualTypeArguments()[0]).mo6494a())) ? new C0449i(this) : new C0448h(this);
        }
        return null;
    }

    /* renamed from: b */
    private <T> C0431ae<T> m2754b(Type type, Class<? super T> cls) {
        return new C0450j(this, cls, type);
    }

    /* renamed from: a */
    public <T> C0431ae<T> mo6460a(C0468a<T> aVar) {
        Type b = aVar.mo6495b();
        Class<? super T> a = aVar.mo6494a();
        C0489s sVar = this.f3522a.get(b);
        if (sVar != null) {
            return new C0447g(this, sVar, b);
        }
        C0489s sVar2 = this.f3522a.get(a);
        if (sVar2 != null) {
            return new C0451k(this, sVar2, b);
        }
        C0431ae<T> a2 = m2752a(a);
        if (a2 != null) {
            return a2;
        }
        C0431ae<T> a3 = m2753a(b, a);
        return a3 == null ? m2754b(b, a) : a3;
    }

    public String toString() {
        return this.f3522a.toString();
    }
}
