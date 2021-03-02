package com.google.p008a.p010b;

import java.lang.reflect.Method;

/* renamed from: com.google.a.b.am */
final class C0439am extends C0437ak {

    /* renamed from: a */
    final /* synthetic */ Method f3512a;

    /* renamed from: b */
    final /* synthetic */ int f3513b;

    C0439am(Method method, int i) {
        this.f3512a = method;
        this.f3513b = i;
    }

    /* renamed from: a */
    public <T> T mo6444a(Class<T> cls) {
        return this.f3512a.invoke((Object) null, new Object[]{cls, Integer.valueOf(this.f3513b)});
    }
}
