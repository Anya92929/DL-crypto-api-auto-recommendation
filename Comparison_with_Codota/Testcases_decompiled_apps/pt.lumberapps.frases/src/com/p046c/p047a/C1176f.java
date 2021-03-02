package com.p046c.p047a;

import java.util.ArrayList;

/* renamed from: com.c.a.f */
class C1176f implements C1172b {

    /* renamed from: a */
    final /* synthetic */ C1174d f3274a;

    /* renamed from: b */
    private C1174d f3275b;

    C1176f(C1174d dVar, C1174d dVar2) {
        this.f3274a = dVar;
        this.f3275b = dVar2;
    }

    /* renamed from: a */
    public void mo4552a(C1153a aVar) {
    }

    /* renamed from: b */
    public void mo4553b(C1153a aVar) {
        boolean z;
        aVar.mo4494b(this);
        this.f3274a.f3261c.remove(aVar);
        ((C1180j) this.f3275b.f3262d.get(aVar)).f3288f = true;
        if (!this.f3274a.f3260b) {
            ArrayList c = this.f3275b.f3264f;
            int size = c.size();
            int i = 0;
            while (true) {
                if (i >= size) {
                    z = true;
                    break;
                } else if (!((C1180j) c.get(i)).f3288f) {
                    z = false;
                    break;
                } else {
                    i++;
                }
            }
            if (z) {
                if (this.f3274a.f3210a != null) {
                    ArrayList arrayList = (ArrayList) this.f3274a.f3210a.clone();
                    int size2 = arrayList.size();
                    for (int i2 = 0; i2 < size2; i2++) {
                        ((C1172b) arrayList.get(i2)).mo4553b(this.f3275b);
                    }
                }
                boolean unused = this.f3275b.f3267i = false;
            }
        }
    }

    /* renamed from: c */
    public void mo4554c(C1153a aVar) {
        if (!this.f3274a.f3260b && this.f3274a.f3261c.size() == 0 && this.f3274a.f3210a != null) {
            int size = this.f3274a.f3210a.size();
            for (int i = 0; i < size; i++) {
                ((C1172b) this.f3274a.f3210a.get(i)).mo4554c(this.f3275b);
            }
        }
    }

    /* renamed from: d */
    public void mo4555d(C1153a aVar) {
    }
}
