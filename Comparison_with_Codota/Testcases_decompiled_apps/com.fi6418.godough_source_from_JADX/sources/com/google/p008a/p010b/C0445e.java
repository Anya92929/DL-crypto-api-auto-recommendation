package com.google.p008a.p010b;

import java.io.Serializable;
import java.lang.reflect.Type;
import java.lang.reflect.WildcardType;

/* renamed from: com.google.a.b.e */
final class C0445e implements Serializable, WildcardType {

    /* renamed from: a */
    private final Type f3520a;

    /* renamed from: b */
    private final Type f3521b;

    public C0445e(Type[] typeArr, Type[] typeArr2) {
        boolean z = true;
        C0366a.m2512a(typeArr2.length <= 1);
        C0366a.m2512a(typeArr.length == 1);
        if (typeArr2.length == 1) {
            C0366a.m2511a(typeArr2[0]);
            C0442b.m2751i(typeArr2[0]);
            C0366a.m2512a(typeArr[0] != Object.class ? false : z);
            this.f3521b = C0442b.m2746d(typeArr2[0]);
            this.f3520a = Object.class;
            return;
        }
        C0366a.m2511a(typeArr[0]);
        C0442b.m2751i(typeArr[0]);
        this.f3521b = null;
        this.f3520a = C0442b.m2746d(typeArr[0]);
    }

    public boolean equals(Object obj) {
        return (obj instanceof WildcardType) && C0442b.m2740a((Type) this, (Type) (WildcardType) obj);
    }

    public Type[] getLowerBounds() {
        if (this.f3521b == null) {
            return C0442b.f3515a;
        }
        return new Type[]{this.f3521b};
    }

    public Type[] getUpperBounds() {
        return new Type[]{this.f3520a};
    }

    public int hashCode() {
        return (this.f3521b != null ? this.f3521b.hashCode() + 31 : 1) ^ (this.f3520a.hashCode() + 31);
    }

    public String toString() {
        return this.f3521b != null ? "? super " + C0442b.m2748f(this.f3521b) : this.f3520a == Object.class ? "?" : "? extends " + C0442b.m2748f(this.f3520a);
    }
}
