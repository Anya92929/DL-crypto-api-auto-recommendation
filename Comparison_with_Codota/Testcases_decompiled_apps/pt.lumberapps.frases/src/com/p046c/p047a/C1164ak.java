package com.p046c.p047a;

import android.os.Looper;
import android.util.AndroidRuntimeException;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.AnimationUtils;
import android.view.animation.Interpolator;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

/* renamed from: com.c.a.ak */
public class C1164ak extends C1153a {

    /* renamed from: h */
    private static ThreadLocal f3231h = new ThreadLocal();
    /* access modifiers changed from: private */

    /* renamed from: i */
    public static final ThreadLocal f3232i = new C1165al();
    /* access modifiers changed from: private */

    /* renamed from: j */
    public static final ThreadLocal f3233j = new C1166am();
    /* access modifiers changed from: private */

    /* renamed from: k */
    public static final ThreadLocal f3234k = new C1167an();
    /* access modifiers changed from: private */

    /* renamed from: l */
    public static final ThreadLocal f3235l = new C1168ao();
    /* access modifiers changed from: private */

    /* renamed from: m */
    public static final ThreadLocal f3236m = new C1169ap();

    /* renamed from: n */
    private static final Interpolator f3237n = new AccelerateDecelerateInterpolator();

    /* renamed from: o */
    private static final C1163aj f3238o = new C1183m();

    /* renamed from: p */
    private static final C1163aj f3239p = new C1181k();
    /* access modifiers changed from: private */

    /* renamed from: z */
    public static long f3240z = 10;

    /* renamed from: A */
    private int f3241A = 0;

    /* renamed from: B */
    private int f3242B = 1;

    /* renamed from: C */
    private Interpolator f3243C = f3237n;

    /* renamed from: D */
    private ArrayList f3244D = null;

    /* renamed from: b */
    long f3245b;

    /* renamed from: c */
    long f3246c = -1;

    /* renamed from: d */
    int f3247d = 0;

    /* renamed from: e */
    boolean f3248e = false;

    /* renamed from: f */
    C1160ag[] f3249f;

    /* renamed from: g */
    HashMap f3250g;

    /* renamed from: q */
    private boolean f3251q = false;

    /* renamed from: r */
    private int f3252r = 0;

    /* renamed from: s */
    private float f3253s = 0.0f;

    /* renamed from: t */
    private boolean f3254t = false;

    /* renamed from: u */
    private long f3255u;
    /* access modifiers changed from: private */

    /* renamed from: v */
    public boolean f3256v = false;

    /* renamed from: w */
    private boolean f3257w = false;

    /* renamed from: x */
    private long f3258x = 300;
    /* access modifiers changed from: private */

    /* renamed from: y */
    public long f3259y = 0;

    /* renamed from: a */
    private void m5312a(boolean z) {
        if (Looper.myLooper() == null) {
            throw new AndroidRuntimeException("Animators may only be run on Looper threads");
        }
        this.f3251q = z;
        this.f3252r = 0;
        this.f3247d = 0;
        this.f3257w = true;
        this.f3254t = false;
        ((ArrayList) f3233j.get()).add(this);
        if (this.f3259y == 0) {
            mo4534d(mo4538k());
            this.f3247d = 0;
            this.f3256v = true;
            if (this.f3210a != null) {
                ArrayList arrayList = (ArrayList) this.f3210a.clone();
                int size = arrayList.size();
                for (int i = 0; i < size; i++) {
                    ((C1172b) arrayList.get(i)).mo4552a(this);
                }
            }
        }
        C1170aq aqVar = (C1170aq) f3231h.get();
        if (aqVar == null) {
            aqVar = new C1170aq((C1165al) null);
            f3231h.set(aqVar);
        }
        aqVar.sendEmptyMessage(0);
    }

    /* renamed from: b */
    public static C1164ak m5315b(float... fArr) {
        C1164ak akVar = new C1164ak();
        akVar.mo4531a(fArr);
        return akVar;
    }

    /* access modifiers changed from: private */
    /* renamed from: b */
    public boolean mo4586b(long j) {
        if (!this.f3254t) {
            this.f3254t = true;
            this.f3255u = j;
        } else {
            long j2 = j - this.f3255u;
            if (j2 > this.f3259y) {
                this.f3245b = j - (j2 - this.f3259y);
                this.f3247d = 1;
                return true;
            }
        }
        return false;
    }

    /* access modifiers changed from: private */
    /* renamed from: i */
    public void mo4587i() {
        ((ArrayList) f3232i.get()).remove(this);
        ((ArrayList) f3233j.get()).remove(this);
        ((ArrayList) f3234k.get()).remove(this);
        this.f3247d = 0;
        if (this.f3256v && this.f3210a != null) {
            ArrayList arrayList = (ArrayList) this.f3210a.clone();
            int size = arrayList.size();
            for (int i = 0; i < size; i++) {
                ((C1172b) arrayList.get(i)).mo4553b(this);
            }
        }
        this.f3256v = false;
        this.f3257w = false;
    }

    /* access modifiers changed from: private */
    /* renamed from: r */
    public void m5326r() {
        mo4536h();
        ((ArrayList) f3232i.get()).add(this);
        if (this.f3259y > 0 && this.f3210a != null) {
            ArrayList arrayList = (ArrayList) this.f3210a.clone();
            int size = arrayList.size();
            for (int i = 0; i < size; i++) {
                ((C1172b) arrayList.get(i)).mo4552a(this);
            }
        }
    }

    /* renamed from: a */
    public void mo4491a() {
        m5312a(false);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo4530a(float f) {
        float interpolation = this.f3243C.getInterpolation(f);
        this.f3253s = interpolation;
        for (C1160ag a : this.f3249f) {
            a.mo4516a(interpolation);
        }
        if (this.f3244D != null) {
            int size = this.f3244D.size();
            for (int i = 0; i < size; i++) {
                ((C1171ar) this.f3244D.get(i)).mo4551a(this);
            }
        }
    }

    /* renamed from: a */
    public void mo4531a(float... fArr) {
        if (fArr != null && fArr.length != 0) {
            if (this.f3249f == null || this.f3249f.length == 0) {
                mo4532a(C1160ag.m5287a("", fArr));
            } else {
                this.f3249f[0].mo4521a(fArr);
            }
            this.f3248e = false;
        }
    }

    /* renamed from: a */
    public void mo4532a(C1160ag... agVarArr) {
        this.f3249f = agVarArr;
        this.f3250g = new HashMap(r2);
        for (C1160ag agVar : agVarArr) {
            this.f3250g.put(agVar.mo4524c(), agVar);
        }
        this.f3248e = false;
    }

    /* renamed from: b */
    public void mo4493b() {
        if (this.f3247d != 0 || ((ArrayList) f3233j.get()).contains(this) || ((ArrayList) f3234k.get()).contains(this)) {
            if (this.f3256v && this.f3210a != null) {
                Iterator it = ((ArrayList) this.f3210a.clone()).iterator();
                while (it.hasNext()) {
                    ((C1172b) it.next()).mo4554c(this);
                }
            }
            mo4587i();
        }
    }

    /* renamed from: c */
    public C1164ak mo4490a(long j) {
        if (j < 0) {
            throw new IllegalArgumentException("Animators cannot have negative duration: " + j);
        }
        this.f3258x = j;
        return this;
    }

    /* renamed from: c */
    public void mo4495c() {
        if (!((ArrayList) f3232i.get()).contains(this) && !((ArrayList) f3233j.get()).contains(this)) {
            this.f3254t = false;
            m5326r();
        } else if (!this.f3248e) {
            mo4536h();
        }
        if (this.f3241A <= 0 || (this.f3241A & 1) != 1) {
            mo4530a(1.0f);
        } else {
            mo4530a(0.0f);
        }
        mo4587i();
    }

    /* renamed from: d */
    public void mo4534d(long j) {
        mo4536h();
        long currentAnimationTimeMillis = AnimationUtils.currentAnimationTimeMillis();
        if (this.f3247d != 1) {
            this.f3246c = j;
            this.f3247d = 2;
        }
        this.f3245b = currentAnimationTimeMillis - j;
        mo4535e(currentAnimationTimeMillis);
    }

    /* renamed from: d */
    public boolean mo4497d() {
        return this.f3247d == 1 || this.f3256v;
    }

    /* renamed from: e */
    public boolean mo4498e() {
        return this.f3257w;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: e */
    public boolean mo4535e(long j) {
        float f;
        boolean z = false;
        if (this.f3247d == 0) {
            this.f3247d = 1;
            if (this.f3246c < 0) {
                this.f3245b = j;
            } else {
                this.f3245b = j - this.f3246c;
                this.f3246c = -1;
            }
        }
        switch (this.f3247d) {
            case 1:
            case 2:
                float f2 = this.f3258x > 0 ? ((float) (j - this.f3245b)) / ((float) this.f3258x) : 1.0f;
                if (f2 < 1.0f) {
                    f = f2;
                } else if (this.f3252r < this.f3241A || this.f3241A == -1) {
                    if (this.f3210a != null) {
                        int size = this.f3210a.size();
                        for (int i = 0; i < size; i++) {
                            ((C1172b) this.f3210a.get(i)).mo4555d(this);
                        }
                    }
                    if (this.f3242B == 2) {
                        this.f3251q = !this.f3251q;
                    }
                    this.f3252r += (int) f2;
                    f = f2 % 1.0f;
                    this.f3245b += this.f3258x;
                } else {
                    f = Math.min(f2, 1.0f);
                    z = true;
                }
                if (this.f3251q) {
                    f = 1.0f - f;
                }
                mo4530a(f);
                break;
        }
        return z;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: h */
    public void mo4536h() {
        if (!this.f3248e) {
            for (C1160ag b : this.f3249f) {
                b.mo4522b();
            }
            this.f3248e = true;
        }
    }

    /* renamed from: j */
    public C1164ak mo4500g() {
        C1164ak akVar = (C1164ak) super.clone();
        if (this.f3244D != null) {
            ArrayList arrayList = this.f3244D;
            akVar.f3244D = new ArrayList();
            int size = arrayList.size();
            for (int i = 0; i < size; i++) {
                akVar.f3244D.add(arrayList.get(i));
            }
        }
        akVar.f3246c = -1;
        akVar.f3251q = false;
        akVar.f3252r = 0;
        akVar.f3248e = false;
        akVar.f3247d = 0;
        akVar.f3254t = false;
        C1160ag[] agVarArr = this.f3249f;
        if (agVarArr != null) {
            int length = agVarArr.length;
            akVar.f3249f = new C1160ag[length];
            akVar.f3250g = new HashMap(length);
            for (int i2 = 0; i2 < length; i2++) {
                C1160ag a = agVarArr[i2].clone();
                akVar.f3249f[i2] = a;
                akVar.f3250g.put(a.mo4524c(), a);
            }
        }
        return akVar;
    }

    /* renamed from: k */
    public long mo4538k() {
        if (!this.f3248e || this.f3247d == 0) {
            return 0;
        }
        return AnimationUtils.currentAnimationTimeMillis() - this.f3245b;
    }

    public String toString() {
        String str = "ValueAnimator@" + Integer.toHexString(hashCode());
        if (this.f3249f != null) {
            for (int i = 0; i < this.f3249f.length; i++) {
                str = str + "\n    " + this.f3249f[i].toString();
            }
        }
        return str;
    }
}
