package com.p046c.p047a;

/* renamed from: com.c.a.g */
public class C1177g {

    /* renamed from: a */
    final /* synthetic */ C1174d f3276a;

    /* renamed from: b */
    private C1180j f3277b;

    C1177g(C1174d dVar, C1153a aVar) {
        this.f3276a = dVar;
        this.f3277b = (C1180j) dVar.f3262d.get(aVar);
        if (this.f3277b == null) {
            this.f3277b = new C1180j(aVar);
            dVar.f3262d.put(aVar, this.f3277b);
            dVar.f3263e.add(this.f3277b);
        }
    }

    /* renamed from: a */
    public C1177g mo4561a(C1153a aVar) {
        C1180j jVar = (C1180j) this.f3276a.f3262d.get(aVar);
        if (jVar == null) {
            jVar = new C1180j(aVar);
            this.f3276a.f3262d.put(aVar, jVar);
            this.f3276a.f3263e.add(jVar);
        }
        jVar.mo4563a(new C1178h(this.f3277b, 0));
        return this;
    }
}
