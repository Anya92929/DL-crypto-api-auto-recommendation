package com.google.android.gms.common.internal;

import java.util.ArrayList;
import java.util.List;

/* renamed from: com.google.android.gms.common.internal.s */
class C1028s extends C1016g {

    /* renamed from: p */
    List<C1016g> f4749p;

    C1028s(List<C1016g> list) {
        this.f4749p = list;
    }

    /* renamed from: a */
    public C1016g mo7626a(C1016g gVar) {
        ArrayList arrayList = new ArrayList(this.f4749p);
        arrayList.add(C1009bf.m4528a(gVar));
        return new C1028s(arrayList);
    }

    /* renamed from: b */
    public boolean mo7627b(char c) {
        for (C1016g b : this.f4749p) {
            if (b.mo7627b(c)) {
                return true;
            }
        }
        return false;
    }
}
