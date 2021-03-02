package com.p046c.p047a;

import android.view.View;
import com.p046c.p048b.C1199c;
import com.p046c.p049c.p050a.C1201a;
import java.util.HashMap;
import java.util.Map;

/* renamed from: com.c.a.q */
public final class C1187q extends C1164ak {

    /* renamed from: h */
    private static final Map f3304h = new HashMap();

    /* renamed from: i */
    private Object f3305i;

    /* renamed from: j */
    private String f3306j;

    /* renamed from: k */
    private C1199c f3307k;

    static {
        f3304h.put("alpha", C1188r.f3308a);
        f3304h.put("pivotX", C1188r.f3309b);
        f3304h.put("pivotY", C1188r.f3310c);
        f3304h.put("translationX", C1188r.f3311d);
        f3304h.put("translationY", C1188r.f3312e);
        f3304h.put("rotation", C1188r.f3313f);
        f3304h.put("rotationX", C1188r.f3314g);
        f3304h.put("rotationY", C1188r.f3315h);
        f3304h.put("scaleX", C1188r.f3316i);
        f3304h.put("scaleY", C1188r.f3317j);
        f3304h.put("scrollX", C1188r.f3318k);
        f3304h.put("scrollY", C1188r.f3319l);
        f3304h.put("x", C1188r.f3320m);
        f3304h.put("y", C1188r.f3321n);
    }

    public C1187q() {
    }

    private C1187q(Object obj, String str) {
        this.f3305i = obj;
        mo4585a(str);
    }

    /* renamed from: a */
    public static C1187q m5415a(Object obj, String str, float... fArr) {
        C1187q qVar = new C1187q(obj, str);
        qVar.mo4531a(fArr);
        return qVar;
    }

    /* renamed from: a */
    public void mo4491a() {
        super.mo4491a();
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo4530a(float f) {
        super.mo4530a(f);
        for (C1160ag b : this.f3249f) {
            b.mo4523b(this.f3305i);
        }
    }

    /* renamed from: a */
    public void mo4584a(C1199c cVar) {
        if (this.f3249f != null) {
            C1160ag agVar = this.f3249f[0];
            String c = agVar.mo4524c();
            agVar.mo4517a(cVar);
            this.f3250g.remove(c);
            this.f3250g.put(this.f3306j, agVar);
        }
        if (this.f3307k != null) {
            this.f3306j = cVar.mo4605a();
        }
        this.f3307k = cVar;
        this.f3248e = false;
    }

    /* renamed from: a */
    public void mo4585a(String str) {
        if (this.f3249f != null) {
            C1160ag agVar = this.f3249f[0];
            String c = agVar.mo4524c();
            agVar.mo4520a(str);
            this.f3250g.remove(c);
            this.f3250g.put(str, agVar);
        }
        this.f3306j = str;
        this.f3248e = false;
    }

    /* renamed from: a */
    public void mo4531a(float... fArr) {
        if (this.f3249f != null && this.f3249f.length != 0) {
            super.mo4531a(fArr);
        } else if (this.f3307k != null) {
            mo4532a(C1160ag.m5286a(this.f3307k, fArr));
        } else {
            mo4532a(C1160ag.m5287a(this.f3306j, fArr));
        }
    }

    /* renamed from: b */
    public C1187q mo4533c(long j) {
        super.mo4490a(j);
        return this;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: h */
    public void mo4536h() {
        if (!this.f3248e) {
            if (this.f3307k == null && C1201a.f3324a && (this.f3305i instanceof View) && f3304h.containsKey(this.f3306j)) {
                mo4584a((C1199c) f3304h.get(this.f3306j));
            }
            for (C1160ag a : this.f3249f) {
                a.mo4519a(this.f3305i);
            }
            super.mo4536h();
        }
    }

    /* renamed from: i */
    public C1187q mo4537j() {
        return (C1187q) super.mo4500g();
    }

    public String toString() {
        String str = "ObjectAnimator@" + Integer.toHexString(hashCode()) + ", target " + this.f3305i;
        if (this.f3249f != null) {
            for (int i = 0; i < this.f3249f.length; i++) {
                str = str + "\n    " + this.f3249f[i].toString();
            }
        }
        return str;
    }
}
