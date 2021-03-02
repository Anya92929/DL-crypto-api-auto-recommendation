package com.p046c.p047a;

import android.view.animation.Interpolator;
import java.util.ArrayList;

/* renamed from: com.c.a.l */
class C1182l extends C1186p {

    /* renamed from: g */
    private float f3289g;

    /* renamed from: h */
    private float f3290h;

    /* renamed from: i */
    private float f3291i;

    /* renamed from: j */
    private boolean f3292j = true;

    public C1182l(C1185o... oVarArr) {
        super(oVarArr);
    }

    /* renamed from: a */
    public C1182l clone() {
        ArrayList arrayList = this.f3302e;
        int size = this.f3302e.size();
        C1185o[] oVarArr = new C1185o[size];
        for (int i = 0; i < size; i++) {
            oVarArr[i] = (C1185o) ((C1184n) arrayList.get(i)).clone();
        }
        return new C1182l(oVarArr);
    }

    /* renamed from: a */
    public Object mo4567a(float f) {
        return Float.valueOf(mo4568b(f));
    }

    /* renamed from: b */
    public float mo4568b(float f) {
        int i = 1;
        if (this.f3298a == 2) {
            if (this.f3292j) {
                this.f3292j = false;
                this.f3289g = ((C1185o) this.f3302e.get(0)).mo4580f();
                this.f3290h = ((C1185o) this.f3302e.get(1)).mo4580f();
                this.f3291i = this.f3290h - this.f3289g;
            }
            if (this.f3301d != null) {
                f = this.f3301d.getInterpolation(f);
            }
            return this.f3303f == null ? this.f3289g + (this.f3291i * f) : ((Number) this.f3303f.mo4529a(f, Float.valueOf(this.f3289g), Float.valueOf(this.f3290h))).floatValue();
        } else if (f <= 0.0f) {
            C1185o oVar = (C1185o) this.f3302e.get(0);
            C1185o oVar2 = (C1185o) this.f3302e.get(1);
            float f2 = oVar.mo4580f();
            float f3 = oVar2.mo4580f();
            float c = oVar.mo4576c();
            float c2 = oVar2.mo4576c();
            Interpolator d = oVar2.mo4578d();
            if (d != null) {
                f = d.getInterpolation(f);
            }
            float f4 = (f - c) / (c2 - c);
            return this.f3303f == null ? (f4 * (f3 - f2)) + f2 : ((Number) this.f3303f.mo4529a(f4, Float.valueOf(f2), Float.valueOf(f3))).floatValue();
        } else if (f >= 1.0f) {
            C1185o oVar3 = (C1185o) this.f3302e.get(this.f3298a - 2);
            C1185o oVar4 = (C1185o) this.f3302e.get(this.f3298a - 1);
            float f5 = oVar3.mo4580f();
            float f6 = oVar4.mo4580f();
            float c3 = oVar3.mo4576c();
            float c4 = oVar4.mo4576c();
            Interpolator d2 = oVar4.mo4578d();
            if (d2 != null) {
                f = d2.getInterpolation(f);
            }
            float f7 = (f - c3) / (c4 - c3);
            return this.f3303f == null ? (f7 * (f6 - f5)) + f5 : ((Number) this.f3303f.mo4529a(f7, Float.valueOf(f5), Float.valueOf(f6))).floatValue();
        } else {
            C1185o oVar5 = (C1185o) this.f3302e.get(0);
            while (true) {
                C1185o oVar6 = oVar5;
                if (i >= this.f3298a) {
                    return ((Number) ((C1184n) this.f3302e.get(this.f3298a - 1)).mo4575b()).floatValue();
                }
                oVar5 = (C1185o) this.f3302e.get(i);
                if (f < oVar5.mo4576c()) {
                    Interpolator d3 = oVar5.mo4578d();
                    if (d3 != null) {
                        f = d3.getInterpolation(f);
                    }
                    float c5 = (f - oVar6.mo4576c()) / (oVar5.mo4576c() - oVar6.mo4576c());
                    float f8 = oVar6.mo4580f();
                    float f9 = oVar5.mo4580f();
                    return this.f3303f == null ? ((f9 - f8) * c5) + f8 : ((Number) this.f3303f.mo4529a(c5, Float.valueOf(f8), Float.valueOf(f9))).floatValue();
                }
                i++;
            }
        }
    }
}
