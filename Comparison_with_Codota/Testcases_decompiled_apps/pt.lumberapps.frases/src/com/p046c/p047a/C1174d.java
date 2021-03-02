package com.p046c.p047a;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

/* renamed from: com.c.a.d */
public final class C1174d extends C1153a {

    /* renamed from: b */
    boolean f3260b = false;
    /* access modifiers changed from: private */

    /* renamed from: c */
    public ArrayList f3261c = new ArrayList();
    /* access modifiers changed from: private */

    /* renamed from: d */
    public HashMap f3262d = new HashMap();
    /* access modifiers changed from: private */

    /* renamed from: e */
    public ArrayList f3263e = new ArrayList();
    /* access modifiers changed from: private */

    /* renamed from: f */
    public ArrayList f3264f = new ArrayList();

    /* renamed from: g */
    private boolean f3265g = true;

    /* renamed from: h */
    private C1176f f3266h = null;
    /* access modifiers changed from: private */

    /* renamed from: i */
    public boolean f3267i = false;

    /* renamed from: j */
    private long f3268j = 0;

    /* renamed from: k */
    private C1164ak f3269k = null;

    /* renamed from: l */
    private long f3270l = -1;

    /* renamed from: i */
    private void m5362i() {
        if (this.f3265g) {
            this.f3264f.clear();
            ArrayList arrayList = new ArrayList();
            int size = this.f3263e.size();
            for (int i = 0; i < size; i++) {
                C1180j jVar = (C1180j) this.f3263e.get(i);
                if (jVar.f3284b == null || jVar.f3284b.size() == 0) {
                    arrayList.add(jVar);
                }
            }
            ArrayList arrayList2 = new ArrayList();
            while (arrayList.size() > 0) {
                int size2 = arrayList.size();
                for (int i2 = 0; i2 < size2; i2++) {
                    C1180j jVar2 = (C1180j) arrayList.get(i2);
                    this.f3264f.add(jVar2);
                    if (jVar2.f3287e != null) {
                        int size3 = jVar2.f3287e.size();
                        for (int i3 = 0; i3 < size3; i3++) {
                            C1180j jVar3 = (C1180j) jVar2.f3287e.get(i3);
                            jVar3.f3286d.remove(jVar2);
                            if (jVar3.f3286d.size() == 0) {
                                arrayList2.add(jVar3);
                            }
                        }
                    }
                }
                arrayList.clear();
                arrayList.addAll(arrayList2);
                arrayList2.clear();
            }
            this.f3265g = false;
            if (this.f3264f.size() != this.f3263e.size()) {
                throw new IllegalStateException("Circular dependencies cannot exist in AnimatorSet");
            }
            return;
        }
        int size4 = this.f3263e.size();
        for (int i4 = 0; i4 < size4; i4++) {
            C1180j jVar4 = (C1180j) this.f3263e.get(i4);
            if (jVar4.f3284b != null && jVar4.f3284b.size() > 0) {
                int size5 = jVar4.f3284b.size();
                for (int i5 = 0; i5 < size5; i5++) {
                    C1178h hVar = (C1178h) jVar4.f3284b.get(i5);
                    if (jVar4.f3286d == null) {
                        jVar4.f3286d = new ArrayList();
                    }
                    if (!jVar4.f3286d.contains(hVar.f3278a)) {
                        jVar4.f3286d.add(hVar.f3278a);
                    }
                }
            }
            jVar4.f3288f = false;
        }
    }

    /* renamed from: a */
    public C1177g mo4556a(C1153a aVar) {
        if (aVar == null) {
            return null;
        }
        this.f3265g = true;
        return new C1177g(this, aVar);
    }

    /* renamed from: a */
    public void mo4491a() {
        this.f3260b = false;
        this.f3267i = true;
        m5362i();
        int size = this.f3264f.size();
        for (int i = 0; i < size; i++) {
            C1180j jVar = (C1180j) this.f3264f.get(i);
            ArrayList f = jVar.f3283a.mo4499f();
            if (f != null && f.size() > 0) {
                Iterator it = new ArrayList(f).iterator();
                while (it.hasNext()) {
                    C1172b bVar = (C1172b) it.next();
                    if ((bVar instanceof C1179i) || (bVar instanceof C1176f)) {
                        jVar.f3283a.mo4494b(bVar);
                    }
                }
            }
        }
        ArrayList arrayList = new ArrayList();
        for (int i2 = 0; i2 < size; i2++) {
            C1180j jVar2 = (C1180j) this.f3264f.get(i2);
            if (this.f3266h == null) {
                this.f3266h = new C1176f(this, this);
            }
            if (jVar2.f3284b == null || jVar2.f3284b.size() == 0) {
                arrayList.add(jVar2);
            } else {
                int size2 = jVar2.f3284b.size();
                for (int i3 = 0; i3 < size2; i3++) {
                    C1178h hVar = (C1178h) jVar2.f3284b.get(i3);
                    hVar.f3278a.f3283a.mo4492a((C1172b) new C1179i(this, jVar2, hVar.f3279b));
                }
                jVar2.f3285c = (ArrayList) jVar2.f3284b.clone();
            }
            jVar2.f3283a.mo4492a((C1172b) this.f3266h);
        }
        if (this.f3268j <= 0) {
            Iterator it2 = arrayList.iterator();
            while (it2.hasNext()) {
                C1180j jVar3 = (C1180j) it2.next();
                jVar3.f3283a.mo4491a();
                this.f3261c.add(jVar3.f3283a);
            }
        } else {
            this.f3269k = C1164ak.m5315b(0.0f, 1.0f);
            this.f3269k.mo4490a(this.f3268j);
            this.f3269k.mo4492a((C1172b) new C1175e(this, arrayList));
            this.f3269k.mo4491a();
        }
        if (this.f3210a != null) {
            ArrayList arrayList2 = (ArrayList) this.f3210a.clone();
            int size3 = arrayList2.size();
            for (int i4 = 0; i4 < size3; i4++) {
                ((C1172b) arrayList2.get(i4)).mo4552a(this);
            }
        }
        if (this.f3263e.size() == 0 && this.f3268j == 0) {
            this.f3267i = false;
            if (this.f3210a != null) {
                ArrayList arrayList3 = (ArrayList) this.f3210a.clone();
                int size4 = arrayList3.size();
                for (int i5 = 0; i5 < size4; i5++) {
                    ((C1172b) arrayList3.get(i5)).mo4553b(this);
                }
            }
        }
    }

    /* renamed from: a */
    public void mo4557a(C1153a... aVarArr) {
        if (aVarArr != null) {
            this.f3265g = true;
            C1177g a = mo4556a(aVarArr[0]);
            for (int i = 1; i < aVarArr.length; i++) {
                a.mo4561a(aVarArr[i]);
            }
        }
    }

    /* renamed from: b */
    public void mo4493b() {
        ArrayList arrayList;
        this.f3260b = true;
        if (mo4498e()) {
            if (this.f3210a != null) {
                ArrayList arrayList2 = (ArrayList) this.f3210a.clone();
                Iterator it = arrayList2.iterator();
                while (it.hasNext()) {
                    ((C1172b) it.next()).mo4554c(this);
                }
                arrayList = arrayList2;
            } else {
                arrayList = null;
            }
            if (this.f3269k != null && this.f3269k.mo4497d()) {
                this.f3269k.mo4493b();
            } else if (this.f3264f.size() > 0) {
                Iterator it2 = this.f3264f.iterator();
                while (it2.hasNext()) {
                    ((C1180j) it2.next()).f3283a.mo4493b();
                }
            }
            if (arrayList != null) {
                Iterator it3 = arrayList.iterator();
                while (it3.hasNext()) {
                    ((C1172b) it3.next()).mo4553b(this);
                }
            }
            this.f3267i = false;
        }
    }

    /* renamed from: b */
    public void mo4558b(long j) {
        this.f3268j = j;
    }

    /* renamed from: c */
    public C1174d mo4490a(long j) {
        if (j < 0) {
            throw new IllegalArgumentException("duration must be a value of zero or greater");
        }
        Iterator it = this.f3263e.iterator();
        while (it.hasNext()) {
            ((C1180j) it.next()).f3283a.mo4490a(j);
        }
        this.f3270l = j;
        return this;
    }

    /* renamed from: c */
    public void mo4495c() {
        this.f3260b = true;
        if (mo4498e()) {
            if (this.f3264f.size() != this.f3263e.size()) {
                m5362i();
                Iterator it = this.f3264f.iterator();
                while (it.hasNext()) {
                    C1180j jVar = (C1180j) it.next();
                    if (this.f3266h == null) {
                        this.f3266h = new C1176f(this, this);
                    }
                    jVar.f3283a.mo4492a((C1172b) this.f3266h);
                }
            }
            if (this.f3269k != null) {
                this.f3269k.mo4493b();
            }
            if (this.f3264f.size() > 0) {
                Iterator it2 = this.f3264f.iterator();
                while (it2.hasNext()) {
                    ((C1180j) it2.next()).f3283a.mo4495c();
                }
            }
            if (this.f3210a != null) {
                Iterator it3 = ((ArrayList) this.f3210a.clone()).iterator();
                while (it3.hasNext()) {
                    ((C1172b) it3.next()).mo4553b(this);
                }
            }
            this.f3267i = false;
        }
    }

    /* renamed from: d */
    public boolean mo4497d() {
        Iterator it = this.f3263e.iterator();
        while (it.hasNext()) {
            if (((C1180j) it.next()).f3283a.mo4497d()) {
                return true;
            }
        }
        return false;
    }

    /* renamed from: e */
    public boolean mo4498e() {
        return this.f3267i;
    }

    /* renamed from: h */
    public C1174d mo4500g() {
        C1174d dVar = (C1174d) super.clone();
        dVar.f3265g = true;
        dVar.f3260b = false;
        dVar.f3267i = false;
        dVar.f3261c = new ArrayList();
        dVar.f3262d = new HashMap();
        dVar.f3263e = new ArrayList();
        dVar.f3264f = new ArrayList();
        HashMap hashMap = new HashMap();
        Iterator it = this.f3263e.iterator();
        while (it.hasNext()) {
            C1180j jVar = (C1180j) it.next();
            C1180j a = jVar.clone();
            hashMap.put(jVar, a);
            dVar.f3263e.add(a);
            dVar.f3262d.put(a.f3283a, a);
            a.f3284b = null;
            a.f3285c = null;
            a.f3287e = null;
            a.f3286d = null;
            ArrayList f = a.f3283a.mo4499f();
            if (f != null) {
                Iterator it2 = f.iterator();
                ArrayList arrayList = null;
                while (it2.hasNext()) {
                    C1172b bVar = (C1172b) it2.next();
                    if (bVar instanceof C1176f) {
                        if (arrayList == null) {
                            arrayList = new ArrayList();
                        }
                        arrayList.add(bVar);
                    }
                }
                if (arrayList != null) {
                    Iterator it3 = arrayList.iterator();
                    while (it3.hasNext()) {
                        f.remove((C1172b) it3.next());
                    }
                }
            }
        }
        Iterator it4 = this.f3263e.iterator();
        while (it4.hasNext()) {
            C1180j jVar2 = (C1180j) it4.next();
            C1180j jVar3 = (C1180j) hashMap.get(jVar2);
            if (jVar2.f3284b != null) {
                Iterator it5 = jVar2.f3284b.iterator();
                while (it5.hasNext()) {
                    C1178h hVar = (C1178h) it5.next();
                    jVar3.mo4563a(new C1178h((C1180j) hashMap.get(hVar.f3278a), hVar.f3279b));
                }
            }
        }
        return dVar;
    }
}
