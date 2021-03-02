package com.google.p008a.p010b.p011a;

import com.google.p008a.C0363al;
import com.google.p008a.C0364am;
import com.google.p008a.C0481k;
import com.google.p008a.p012c.C0468a;

/* renamed from: com.google.a.b.a.az */
final class C0393az implements C0364am {

    /* renamed from: a */
    final /* synthetic */ Class f3396a;

    /* renamed from: b */
    final /* synthetic */ C0363al f3397b;

    C0393az(Class cls, C0363al alVar) {
        this.f3396a = cls;
        this.f3397b = alVar;
    }

    /* renamed from: a */
    public <T> C0363al<T> mo6311a(C0481k kVar, C0468a<T> aVar) {
        if (this.f3396a.isAssignableFrom(aVar.mo6494a())) {
            return this.f3397b;
        }
        return null;
    }

    public String toString() {
        return "Factory[typeHierarchy=" + this.f3396a.getName() + ",adapter=" + this.f3397b + "]";
    }
}
