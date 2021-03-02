package com.google.p008a.p010b;

import java.lang.reflect.Type;

/* renamed from: com.google.a.b.j */
class C0450j implements C0431ae<T> {

    /* renamed from: a */
    final /* synthetic */ Class f3528a;

    /* renamed from: b */
    final /* synthetic */ Type f3529b;

    /* renamed from: c */
    final /* synthetic */ C0446f f3530c;

    /* renamed from: d */
    private final C0437ak f3531d = C0437ak.m2724a();

    C0450j(C0446f fVar, Class cls, Type type) {
        this.f3530c = fVar;
        this.f3528a = cls;
        this.f3529b = type;
    }

    /* renamed from: a */
    public T mo6436a() {
        try {
            return this.f3531d.mo6444a(this.f3528a);
        } catch (Exception e) {
            throw new RuntimeException("Unable to invoke no-args constructor for " + this.f3529b + ". " + "Register an InstanceCreator with Gson for this type may fix this problem.", e);
        }
    }
}
