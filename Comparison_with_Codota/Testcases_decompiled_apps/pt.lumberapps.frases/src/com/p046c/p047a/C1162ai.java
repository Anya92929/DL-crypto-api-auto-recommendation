package com.p046c.p047a;

import android.util.Log;
import com.p046c.p048b.C1197a;
import com.p046c.p048b.C1199c;
import java.lang.reflect.InvocationTargetException;

/* renamed from: com.c.a.ai */
class C1162ai extends C1160ag {

    /* renamed from: h */
    C1182l f3228h;

    /* renamed from: i */
    float f3229i;

    /* renamed from: j */
    private C1197a f3230j;

    public C1162ai(C1199c cVar, float... fArr) {
        super(cVar);
        mo4521a(fArr);
        if (cVar instanceof C1197a) {
            this.f3230j = (C1197a) this.f3219b;
        }
    }

    public C1162ai(String str, float... fArr) {
        super(str);
        mo4521a(fArr);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo4516a(float f) {
        this.f3229i = this.f3228h.mo4568b(f);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo4518a(Class cls) {
        if (this.f3219b == null) {
            super.mo4518a(cls);
        }
    }

    /* renamed from: a */
    public void mo4521a(float... fArr) {
        super.mo4521a(fArr);
        this.f3228h = (C1182l) this.f3222e;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: b */
    public void mo4523b(Object obj) {
        if (this.f3230j != null) {
            this.f3230j.mo4504a(obj, this.f3229i);
        } else if (this.f3219b != null) {
            this.f3219b.mo4603a(obj, Float.valueOf(this.f3229i));
        } else if (this.f3220c != null) {
            try {
                this.f3224g[0] = Float.valueOf(this.f3229i);
                this.f3220c.invoke(obj, this.f3224g);
            } catch (InvocationTargetException e) {
                Log.e("PropertyValuesHolder", e.toString());
            } catch (IllegalAccessException e2) {
                Log.e("PropertyValuesHolder", e2.toString());
            }
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: d */
    public Object mo4526d() {
        return Float.valueOf(this.f3229i);
    }

    /* renamed from: e */
    public C1162ai clone() {
        C1162ai aiVar = (C1162ai) super.clone();
        aiVar.f3228h = (C1182l) aiVar.f3222e;
        return aiVar;
    }
}
