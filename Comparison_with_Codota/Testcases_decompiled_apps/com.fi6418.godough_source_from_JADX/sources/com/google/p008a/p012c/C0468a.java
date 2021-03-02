package com.google.p008a.p012c;

import com.google.p008a.p010b.C0366a;
import com.google.p008a.p010b.C0442b;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

/* renamed from: com.google.a.c.a */
public class C0468a<T> {

    /* renamed from: a */
    final Class<? super T> f3571a;

    /* renamed from: b */
    final Type f3572b;

    /* renamed from: c */
    final int f3573c;

    protected C0468a() {
        this.f3572b = m2795a(getClass());
        this.f3571a = C0442b.m2747e(this.f3572b);
        this.f3573c = this.f3572b.hashCode();
    }

    C0468a(Type type) {
        this.f3572b = C0442b.m2746d((Type) C0366a.m2511a(type));
        this.f3571a = C0442b.m2747e(this.f3572b);
        this.f3573c = this.f3572b.hashCode();
    }

    /* renamed from: a */
    public static C0468a<?> m2794a(Type type) {
        return new C0468a<>(type);
    }

    /* renamed from: a */
    static Type m2795a(Class<?> cls) {
        Type genericSuperclass = cls.getGenericSuperclass();
        if (!(genericSuperclass instanceof Class)) {
            return C0442b.m2746d(((ParameterizedType) genericSuperclass).getActualTypeArguments()[0]);
        }
        throw new RuntimeException("Missing type parameter.");
    }

    /* renamed from: b */
    public static <T> C0468a<T> m2796b(Class<T> cls) {
        return new C0468a<>(cls);
    }

    /* renamed from: a */
    public final Class<? super T> mo6494a() {
        return this.f3571a;
    }

    /* renamed from: b */
    public final Type mo6495b() {
        return this.f3572b;
    }

    public final boolean equals(Object obj) {
        return (obj instanceof C0468a) && C0442b.m2740a(this.f3572b, ((C0468a) obj).f3572b);
    }

    public final int hashCode() {
        return this.f3573c;
    }

    public final String toString() {
        return C0442b.m2748f(this.f3572b);
    }
}
