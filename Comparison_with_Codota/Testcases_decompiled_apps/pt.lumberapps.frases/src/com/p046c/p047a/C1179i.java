package com.p046c.p047a;

/* renamed from: com.c.a.i */
class C1179i implements C1172b {

    /* renamed from: a */
    private C1174d f3280a;

    /* renamed from: b */
    private C1180j f3281b;

    /* renamed from: c */
    private int f3282c;

    public C1179i(C1174d dVar, C1180j jVar, int i) {
        this.f3280a = dVar;
        this.f3281b = jVar;
        this.f3282c = i;
    }

    /* renamed from: e */
    private void m5382e(C1153a aVar) {
        C1178h hVar;
        if (!this.f3280a.f3260b) {
            int size = this.f3281b.f3285c.size();
            int i = 0;
            while (true) {
                if (i >= size) {
                    hVar = null;
                    break;
                }
                hVar = (C1178h) this.f3281b.f3285c.get(i);
                if (hVar.f3279b == this.f3282c && hVar.f3278a.f3283a == aVar) {
                    aVar.mo4494b(this);
                    break;
                }
                i++;
            }
            this.f3281b.f3285c.remove(hVar);
            if (this.f3281b.f3285c.size() == 0) {
                this.f3281b.f3283a.mo4491a();
                this.f3280a.f3261c.add(this.f3281b.f3283a);
            }
        }
    }

    /* renamed from: a */
    public void mo4552a(C1153a aVar) {
        if (this.f3282c == 0) {
            m5382e(aVar);
        }
    }

    /* renamed from: b */
    public void mo4553b(C1153a aVar) {
        if (this.f3282c == 1) {
            m5382e(aVar);
        }
    }

    /* renamed from: c */
    public void mo4554c(C1153a aVar) {
    }

    /* renamed from: d */
    public void mo4555d(C1153a aVar) {
    }
}
