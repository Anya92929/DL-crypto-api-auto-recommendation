package com.google.p008a.p010b.p011a;

import com.google.p008a.C0363al;
import com.google.p008a.C0364am;
import com.google.p008a.C0481k;
import com.google.p008a.p012c.C0468a;

/* renamed from: com.google.a.b.a.av */
final class C0389av implements C0364am {

    /* renamed from: a */
    final /* synthetic */ Class f3388a;

    /* renamed from: b */
    final /* synthetic */ C0363al f3389b;

    C0389av(Class cls, C0363al alVar) {
        this.f3388a = cls;
        this.f3389b = alVar;
    }

    /* renamed from: a */
    public <T> C0363al<T> mo6311a(C0481k kVar, C0468a<T> aVar) {
        if (aVar.mo6494a() == this.f3388a) {
            return this.f3389b;
        }
        return null;
    }

    public String toString() {
        return "Factory[type=" + this.f3388a.getName() + ",adapter=" + this.f3389b + "]";
    }
}
