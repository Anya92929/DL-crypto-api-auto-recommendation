package com.google.p008a.p010b.p011a;

import com.google.p008a.C0363al;
import com.google.p008a.C0364am;
import com.google.p008a.C0481k;
import com.google.p008a.p012c.C0468a;

/* renamed from: com.google.a.b.a.aw */
final class C0390aw implements C0364am {

    /* renamed from: a */
    final /* synthetic */ Class f3390a;

    /* renamed from: b */
    final /* synthetic */ Class f3391b;

    /* renamed from: c */
    final /* synthetic */ C0363al f3392c;

    C0390aw(Class cls, Class cls2, C0363al alVar) {
        this.f3390a = cls;
        this.f3391b = cls2;
        this.f3392c = alVar;
    }

    /* renamed from: a */
    public <T> C0363al<T> mo6311a(C0481k kVar, C0468a<T> aVar) {
        Class<? super T> a = aVar.mo6494a();
        if (a == this.f3390a || a == this.f3391b) {
            return this.f3392c;
        }
        return null;
    }

    public String toString() {
        return "Factory[type=" + this.f3391b.getName() + "+" + this.f3390a.getName() + ",adapter=" + this.f3392c + "]";
    }
}
