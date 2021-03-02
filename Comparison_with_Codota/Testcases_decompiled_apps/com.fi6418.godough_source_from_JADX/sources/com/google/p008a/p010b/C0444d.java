package com.google.p008a.p010b;

import java.io.Serializable;
import java.lang.reflect.Modifier;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.Arrays;

/* renamed from: com.google.a.b.d */
final class C0444d implements Serializable, ParameterizedType {

    /* renamed from: a */
    private final Type f3517a;

    /* renamed from: b */
    private final Type f3518b;

    /* renamed from: c */
    private final Type[] f3519c;

    public C0444d(Type type, Type type2, Type... typeArr) {
        if (type2 instanceof Class) {
            Class cls = (Class) type2;
            C0366a.m2512a(type != null || (Modifier.isStatic(cls.getModifiers()) || cls.getEnclosingClass() == null));
        }
        this.f3517a = type == null ? null : C0442b.m2746d(type);
        this.f3518b = C0442b.m2746d(type2);
        this.f3519c = (Type[]) typeArr.clone();
        for (int i = 0; i < this.f3519c.length; i++) {
            C0366a.m2511a(this.f3519c[i]);
            C0442b.m2751i(this.f3519c[i]);
            this.f3519c[i] = C0442b.m2746d(this.f3519c[i]);
        }
    }

    public boolean equals(Object obj) {
        return (obj instanceof ParameterizedType) && C0442b.m2740a((Type) this, (Type) (ParameterizedType) obj);
    }

    public Type[] getActualTypeArguments() {
        return (Type[]) this.f3519c.clone();
    }

    public Type getOwnerType() {
        return this.f3517a;
    }

    public Type getRawType() {
        return this.f3518b;
    }

    public int hashCode() {
        return (Arrays.hashCode(this.f3519c) ^ this.f3518b.hashCode()) ^ C0442b.m2741b((Object) this.f3517a);
    }

    public String toString() {
        StringBuilder sb = new StringBuilder((this.f3519c.length + 1) * 30);
        sb.append(C0442b.m2748f(this.f3518b));
        if (this.f3519c.length == 0) {
            return sb.toString();
        }
        sb.append("<").append(C0442b.m2748f(this.f3519c[0]));
        for (int i = 1; i < this.f3519c.length; i++) {
            sb.append(", ").append(C0442b.m2748f(this.f3519c[i]));
        }
        return sb.append(">").toString();
    }
}
