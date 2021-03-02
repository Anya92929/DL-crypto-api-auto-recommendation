package com.google.p008a.p010b;

import com.google.p008a.C0494x;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.EnumSet;

/* renamed from: com.google.a.b.n */
class C0454n implements C0431ae<T> {

    /* renamed from: a */
    final /* synthetic */ Type f3538a;

    /* renamed from: b */
    final /* synthetic */ C0446f f3539b;

    C0454n(C0446f fVar, Type type) {
        this.f3539b = fVar;
        this.f3538a = type;
    }

    /* renamed from: a */
    public T mo6436a() {
        if (this.f3538a instanceof ParameterizedType) {
            Type type = ((ParameterizedType) this.f3538a).getActualTypeArguments()[0];
            if (type instanceof Class) {
                return EnumSet.noneOf((Class) type);
            }
            throw new C0494x("Invalid EnumSet type: " + this.f3538a.toString());
        }
        throw new C0494x("Invalid EnumSet type: " + this.f3538a.toString());
    }
}
