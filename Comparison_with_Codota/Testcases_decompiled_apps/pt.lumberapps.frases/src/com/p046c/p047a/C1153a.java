package com.p046c.p047a;

import java.util.ArrayList;

/* renamed from: com.c.a.a */
public abstract class C1153a implements Cloneable {

    /* renamed from: a */
    ArrayList f3210a = null;

    /* renamed from: a */
    public abstract C1153a mo4490a(long j);

    /* renamed from: a */
    public void mo4491a() {
    }

    /* renamed from: a */
    public void mo4492a(C1172b bVar) {
        if (this.f3210a == null) {
            this.f3210a = new ArrayList();
        }
        this.f3210a.add(bVar);
    }

    /* renamed from: b */
    public void mo4493b() {
    }

    /* renamed from: b */
    public void mo4494b(C1172b bVar) {
        if (this.f3210a != null) {
            this.f3210a.remove(bVar);
            if (this.f3210a.size() == 0) {
                this.f3210a = null;
            }
        }
    }

    /* renamed from: c */
    public void mo4495c() {
    }

    /* renamed from: d */
    public abstract boolean mo4497d();

    /* renamed from: e */
    public boolean mo4498e() {
        return mo4497d();
    }

    /* renamed from: f */
    public ArrayList mo4499f() {
        return this.f3210a;
    }

    /* renamed from: g */
    public C1153a clone() {
        try {
            C1153a aVar = (C1153a) super.clone();
            if (this.f3210a != null) {
                ArrayList arrayList = this.f3210a;
                aVar.f3210a = new ArrayList();
                int size = arrayList.size();
                for (int i = 0; i < size; i++) {
                    aVar.f3210a.add(arrayList.get(i));
                }
            }
            return aVar;
        } catch (CloneNotSupportedException e) {
            throw new AssertionError();
        }
    }
}
