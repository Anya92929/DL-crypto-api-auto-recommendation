package com.google.p008a.p010b.p011a;

import com.google.p008a.C0363al;
import com.google.p008a.C0364am;
import com.google.p008a.C0481k;
import com.google.p008a.p012c.C0468a;

/* renamed from: com.google.a.b.a.ay */
final class C0392ay implements C0364am {

    /* renamed from: a */
    final /* synthetic */ Class f3393a;

    /* renamed from: b */
    final /* synthetic */ Class f3394b;

    /* renamed from: c */
    final /* synthetic */ C0363al f3395c;

    C0392ay(Class cls, Class cls2, C0363al alVar) {
        this.f3393a = cls;
        this.f3394b = cls2;
        this.f3395c = alVar;
    }

    /* renamed from: a */
    public <T> C0363al<T> mo6311a(C0481k kVar, C0468a<T> aVar) {
        Class<? super T> a = aVar.mo6494a();
        if (a == this.f3393a || a == this.f3394b) {
            return this.f3395c;
        }
        return null;
    }

    public String toString() {
        return "Factory[type=" + this.f3393a.getName() + "+" + this.f3394b.getName() + ",adapter=" + this.f3395c + "]";
    }
}
