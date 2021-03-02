package com.google.p008a.p010b;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

/* renamed from: com.google.a.b.l */
class C0452l implements C0431ae<T> {

    /* renamed from: a */
    final /* synthetic */ Constructor f3535a;

    /* renamed from: b */
    final /* synthetic */ C0446f f3536b;

    C0452l(C0446f fVar, Constructor constructor) {
        this.f3536b = fVar;
        this.f3535a = constructor;
    }

    /* renamed from: a */
    public T mo6436a() {
        try {
            return this.f3535a.newInstance((Object[]) null);
        } catch (InstantiationException e) {
            throw new RuntimeException("Failed to invoke " + this.f3535a + " with no args", e);
        } catch (InvocationTargetException e2) {
            throw new RuntimeException("Failed to invoke " + this.f3535a + " with no args", e2.getTargetException());
        } catch (IllegalAccessException e3) {
            throw new AssertionError(e3);
        }
    }
}
