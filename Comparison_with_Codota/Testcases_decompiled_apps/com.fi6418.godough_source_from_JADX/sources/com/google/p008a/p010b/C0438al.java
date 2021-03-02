package com.google.p008a.p010b;

import java.lang.reflect.Method;

/* renamed from: com.google.a.b.al */
final class C0438al extends C0437ak {

    /* renamed from: a */
    final /* synthetic */ Method f3510a;

    /* renamed from: b */
    final /* synthetic */ Object f3511b;

    C0438al(Method method, Object obj) {
        this.f3510a = method;
        this.f3511b = obj;
    }

    /* renamed from: a */
    public <T> T mo6444a(Class<T> cls) {
        return this.f3510a.invoke(this.f3511b, new Object[]{cls});
    }
}
