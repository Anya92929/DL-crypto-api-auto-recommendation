package com.p046c.p047a;

import java.util.ArrayList;

/* renamed from: com.c.a.e */
class C1175e extends C1173c {

    /* renamed from: a */
    boolean f3271a = false;

    /* renamed from: b */
    final /* synthetic */ ArrayList f3272b;

    /* renamed from: c */
    final /* synthetic */ C1174d f3273c;

    C1175e(C1174d dVar, ArrayList arrayList) {
        this.f3273c = dVar;
        this.f3272b = arrayList;
    }

    /* renamed from: b */
    public void mo4553b(C1153a aVar) {
        if (!this.f3271a) {
            int size = this.f3272b.size();
            for (int i = 0; i < size; i++) {
                C1180j jVar = (C1180j) this.f3272b.get(i);
                jVar.f3283a.mo4491a();
                this.f3273c.f3261c.add(jVar.f3283a);
            }
        }
    }

    /* renamed from: c */
    public void mo4554c(C1153a aVar) {
        this.f3271a = true;
    }
}
