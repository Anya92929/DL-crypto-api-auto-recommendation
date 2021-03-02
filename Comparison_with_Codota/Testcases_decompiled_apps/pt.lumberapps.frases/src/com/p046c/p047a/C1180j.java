package com.p046c.p047a;

import java.util.ArrayList;

/* renamed from: com.c.a.j */
class C1180j implements Cloneable {

    /* renamed from: a */
    public C1153a f3283a;

    /* renamed from: b */
    public ArrayList f3284b = null;

    /* renamed from: c */
    public ArrayList f3285c = null;

    /* renamed from: d */
    public ArrayList f3286d = null;

    /* renamed from: e */
    public ArrayList f3287e = null;

    /* renamed from: f */
    public boolean f3288f = false;

    public C1180j(C1153a aVar) {
        this.f3283a = aVar;
    }

    /* renamed from: a */
    public C1180j clone() {
        try {
            C1180j jVar = (C1180j) super.clone();
            jVar.f3283a = this.f3283a.clone();
            return jVar;
        } catch (CloneNotSupportedException e) {
            throw new AssertionError();
        }
    }

    /* renamed from: a */
    public void mo4563a(C1178h hVar) {
        if (this.f3284b == null) {
            this.f3284b = new ArrayList();
            this.f3286d = new ArrayList();
        }
        this.f3284b.add(hVar);
        if (!this.f3286d.contains(hVar.f3278a)) {
            this.f3286d.add(hVar.f3278a);
        }
        C1180j jVar = hVar.f3278a;
        if (jVar.f3287e == null) {
            jVar.f3287e = new ArrayList();
        }
        jVar.f3287e.add(this);
    }
}
