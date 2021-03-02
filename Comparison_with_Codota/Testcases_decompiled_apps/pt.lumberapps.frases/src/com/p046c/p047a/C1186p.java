package com.p046c.p047a;

import android.view.animation.Interpolator;
import java.util.ArrayList;
import java.util.Arrays;

/* renamed from: com.c.a.p */
class C1186p {

    /* renamed from: a */
    int f3298a;

    /* renamed from: b */
    C1184n f3299b;

    /* renamed from: c */
    C1184n f3300c;

    /* renamed from: d */
    Interpolator f3301d;

    /* renamed from: e */
    ArrayList f3302e = new ArrayList();

    /* renamed from: f */
    C1163aj f3303f;

    public C1186p(C1184n... nVarArr) {
        this.f3298a = nVarArr.length;
        this.f3302e.addAll(Arrays.asList(nVarArr));
        this.f3299b = (C1184n) this.f3302e.get(0);
        this.f3300c = (C1184n) this.f3302e.get(this.f3298a - 1);
        this.f3301d = this.f3300c.mo4578d();
    }

    /* renamed from: a */
    public static C1186p m5411a(float... fArr) {
        int length = fArr.length;
        C1185o[] oVarArr = new C1185o[Math.max(length, 2)];
        if (length == 1) {
            oVarArr[0] = (C1185o) C1184n.m5397a(0.0f);
            oVarArr[1] = (C1185o) C1184n.m5398a(1.0f, fArr[0]);
        } else {
            oVarArr[0] = (C1185o) C1184n.m5398a(0.0f, fArr[0]);
            for (int i = 1; i < length; i++) {
                oVarArr[i] = (C1185o) C1184n.m5398a(((float) i) / ((float) (length - 1)), fArr[i]);
            }
        }
        return new C1182l(oVarArr);
    }

    /* renamed from: a */
    public Object mo4567a(float f) {
        if (this.f3298a == 2) {
            if (this.f3301d != null) {
                f = this.f3301d.getInterpolation(f);
            }
            return this.f3303f.mo4529a(f, this.f3299b.mo4575b(), this.f3300c.mo4575b());
        } else if (f <= 0.0f) {
            C1184n nVar = (C1184n) this.f3302e.get(1);
            Interpolator d = nVar.mo4578d();
            if (d != null) {
                f = d.getInterpolation(f);
            }
            float c = this.f3299b.mo4576c();
            return this.f3303f.mo4529a((f - c) / (nVar.mo4576c() - c), this.f3299b.mo4575b(), nVar.mo4575b());
        } else if (f >= 1.0f) {
            C1184n nVar2 = (C1184n) this.f3302e.get(this.f3298a - 2);
            Interpolator d2 = this.f3300c.mo4578d();
            if (d2 != null) {
                f = d2.getInterpolation(f);
            }
            float c2 = nVar2.mo4576c();
            return this.f3303f.mo4529a((f - c2) / (this.f3300c.mo4576c() - c2), nVar2.mo4575b(), this.f3300c.mo4575b());
        } else {
            C1184n nVar3 = this.f3299b;
            int i = 1;
            while (i < this.f3298a) {
                C1184n nVar4 = (C1184n) this.f3302e.get(i);
                if (f < nVar4.mo4576c()) {
                    Interpolator d3 = nVar4.mo4578d();
                    if (d3 != null) {
                        f = d3.getInterpolation(f);
                    }
                    float c3 = nVar3.mo4576c();
                    return this.f3303f.mo4529a((f - c3) / (nVar4.mo4576c() - c3), nVar3.mo4575b(), nVar4.mo4575b());
                }
                i++;
                nVar3 = nVar4;
            }
            return this.f3300c.mo4575b();
        }
    }

    /* renamed from: a */
    public void mo4582a(C1163aj ajVar) {
        this.f3303f = ajVar;
    }

    /* renamed from: b */
    public C1186p clone() {
        ArrayList arrayList = this.f3302e;
        int size = this.f3302e.size();
        C1184n[] nVarArr = new C1184n[size];
        for (int i = 0; i < size; i++) {
            nVarArr[i] = ((C1184n) arrayList.get(i)).clone();
        }
        return new C1186p(nVarArr);
    }

    public String toString() {
        String str = " ";
        int i = 0;
        while (i < this.f3298a) {
            String str2 = str + ((C1184n) this.f3302e.get(i)).mo4575b() + "  ";
            i++;
            str = str2;
        }
        return str;
    }
}
