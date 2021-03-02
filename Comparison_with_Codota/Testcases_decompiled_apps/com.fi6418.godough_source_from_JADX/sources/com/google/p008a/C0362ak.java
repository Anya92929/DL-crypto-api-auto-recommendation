package com.google.p008a;

import com.google.p008a.p010b.C0366a;
import com.google.p008a.p012c.C0468a;

/* renamed from: com.google.a.ak */
class C0362ak implements C0364am {

    /* renamed from: a */
    private final C0468a<?> f3376a;

    /* renamed from: b */
    private final boolean f3377b;

    /* renamed from: c */
    private final Class<?> f3378c;

    /* renamed from: d */
    private final C0355ad<?> f3379d;

    /* renamed from: e */
    private final C0492v<?> f3380e;

    private C0362ak(Object obj, C0468a<?> aVar, boolean z, Class<?> cls) {
        this.f3379d = obj instanceof C0355ad ? (C0355ad) obj : null;
        this.f3380e = obj instanceof C0492v ? (C0492v) obj : null;
        C0366a.m2512a((this.f3379d == null && this.f3380e == null) ? false : true);
        this.f3376a = aVar;
        this.f3377b = z;
        this.f3378c = cls;
    }

    /* renamed from: a */
    public <T> C0363al<T> mo6311a(C0481k kVar, C0468a<T> aVar) {
        if (this.f3376a != null ? this.f3376a.equals(aVar) || (this.f3377b && this.f3376a.mo6495b() == aVar.mo6494a()) : this.f3378c.isAssignableFrom(aVar.mo6494a())) {
            return new C0360ai(this.f3379d, this.f3380e, kVar, aVar, this);
        }
        return null;
    }
}
