package com.google.android.gms.p017b;

import android.os.Bundle;
import java.util.Iterator;

/* renamed from: com.google.android.gms.b.c */
class C0598c implements C0609n<T> {

    /* renamed from: a */
    final /* synthetic */ C0597b f3956a;

    C0598c(C0597b bVar) {
        this.f3956a = bVar;
    }

    /* renamed from: a */
    public void mo6963a(T t) {
        C0596a unused = this.f3956a.f3952a = t;
        Iterator it = this.f3956a.f3954c.iterator();
        while (it.hasNext()) {
            ((C0604i) it.next()).mo6965a(this.f3956a.f3952a);
        }
        this.f3956a.f3954c.clear();
        Bundle unused2 = this.f3956a.f3953b = null;
    }
}
