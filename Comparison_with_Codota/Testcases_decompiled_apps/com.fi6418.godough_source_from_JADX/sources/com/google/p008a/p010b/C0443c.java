package com.google.p008a.p010b;

import java.io.Serializable;
import java.lang.reflect.GenericArrayType;
import java.lang.reflect.Type;

/* renamed from: com.google.a.b.c */
final class C0443c implements Serializable, GenericArrayType {

    /* renamed from: a */
    private final Type f3516a;

    public C0443c(Type type) {
        this.f3516a = C0442b.m2746d(type);
    }

    public boolean equals(Object obj) {
        return (obj instanceof GenericArrayType) && C0442b.m2740a((Type) this, (Type) (GenericArrayType) obj);
    }

    public Type getGenericComponentType() {
        return this.f3516a;
    }

    public int hashCode() {
        return this.f3516a.hashCode();
    }

    public String toString() {
        return C0442b.m2748f(this.f3516a) + "[]";
    }
}
