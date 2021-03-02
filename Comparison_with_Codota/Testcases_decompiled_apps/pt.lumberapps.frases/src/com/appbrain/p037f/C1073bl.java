package com.appbrain.p037f;

import com.appbrain.p033b.C0992ag;
import com.appbrain.p033b.C1012p;
import com.appbrain.p033b.C1016t;
import com.appbrain.p033b.C1017u;

/* renamed from: com.appbrain.f.bl */
public final class C1073bl extends C1012p implements C1074bm {

    /* renamed from: a */
    private int f2990a;

    /* renamed from: b */
    private C1035aa f2991b = C1035aa.m4359f();

    /* renamed from: c */
    private C1017u f2992c = C1016t.f2665a;

    /* renamed from: d */
    private C1017u f2993d = C1016t.f2665a;

    /* renamed from: e */
    private Object f2994e = "";

    /* renamed from: f */
    private long f2995f;

    /* renamed from: g */
    private int f2996g;

    /* renamed from: h */
    private boolean f2997h;

    private C1073bl() {
    }

    /* renamed from: i */
    static /* synthetic */ C1073bl m4891i() {
        return new C1073bl();
    }

    /* access modifiers changed from: private */
    /* renamed from: j */
    public C1073bl clone() {
        return new C1073bl().mo4319a(m4893k());
    }

    /* renamed from: k */
    private C1071bj m4893k() {
        int i = 1;
        C1071bj bjVar = new C1071bj((C1012p) this, (byte) 0);
        int i2 = this.f2990a;
        if ((i2 & 1) != 1) {
            i = 0;
        }
        C1035aa unused = bjVar.f2981f = this.f2991b;
        if ((this.f2990a & 2) == 2) {
            this.f2992c = this.f2992c.mo3944b();
            this.f2990a &= -3;
        }
        C1017u unused2 = bjVar.f2982g = this.f2992c;
        if ((this.f2990a & 4) == 4) {
            this.f2993d = this.f2993d.mo3944b();
            this.f2990a &= -5;
        }
        C1017u unused3 = bjVar.f2983h = this.f2993d;
        if ((i2 & 8) == 8) {
            i |= 2;
        }
        Object unused4 = bjVar.f2984i = this.f2994e;
        if ((i2 & 16) == 16) {
            i |= 4;
        }
        long unused5 = bjVar.f2985j = this.f2995f;
        if ((i2 & 32) == 32) {
            i |= 8;
        }
        int unused6 = bjVar.f2986k = this.f2996g;
        if ((i2 & 64) == 64) {
            i |= 16;
        }
        boolean unused7 = bjVar.f2987l = this.f2997h;
        int unused8 = bjVar.f2980e = i;
        return bjVar;
    }

    /* renamed from: l */
    private void m4894l() {
        if ((this.f2990a & 2) != 2) {
            this.f2992c = new C1016t(this.f2992c);
            this.f2990a |= 2;
        }
    }

    /* renamed from: m */
    private void m4895m() {
        if ((this.f2990a & 4) != 4) {
            this.f2993d = new C1016t(this.f2993d);
            this.f2990a |= 4;
        }
    }

    /* renamed from: a */
    public final C1073bl mo4316a(int i) {
        this.f2990a |= 32;
        this.f2996g = i;
        return this;
    }

    /* renamed from: a */
    public final C1073bl mo4317a(long j) {
        this.f2990a |= 16;
        this.f2995f = j;
        return this;
    }

    /* renamed from: a */
    public final C1073bl mo4318a(C1035aa aaVar) {
        if (aaVar == null) {
            throw new NullPointerException();
        }
        this.f2991b = aaVar;
        this.f2990a |= 1;
        return this;
    }

    /* renamed from: a */
    public final C1073bl mo4319a(C1071bj bjVar) {
        if (bjVar != C1071bj.m4873f()) {
            if (bjVar.mo4307g()) {
                C1035aa h = bjVar.mo4308h();
                if ((this.f2990a & 1) != 1 || this.f2991b == C1035aa.m4359f()) {
                    this.f2991b = h;
                } else {
                    this.f2991b = C1035aa.m4313a(this.f2991b).mo4139a(h).mo4163g();
                }
                this.f2990a |= 1;
            }
            if (!bjVar.f2982g.isEmpty()) {
                if (this.f2992c.isEmpty()) {
                    this.f2992c = bjVar.f2982g;
                    this.f2990a &= -3;
                } else {
                    m4894l();
                    this.f2992c.addAll(bjVar.f2982g);
                }
            }
            if (!bjVar.f2983h.isEmpty()) {
                if (this.f2993d.isEmpty()) {
                    this.f2993d = bjVar.f2983h;
                    this.f2990a &= -5;
                } else {
                    m4895m();
                    this.f2993d.addAll(bjVar.f2983h);
                }
            }
            if (bjVar.mo4309i()) {
                this.f2990a |= 8;
                this.f2994e = bjVar.f2984i;
            }
            if (bjVar.mo4310j()) {
                mo4317a(bjVar.mo4311k());
            }
            if (bjVar.mo4312l()) {
                mo4316a(bjVar.mo4313m());
            }
            if (bjVar.mo4314n()) {
                mo4321a(bjVar.mo4315o());
            }
            mo4007a(mo4009c().mo3967a(bjVar.f2979d));
        }
        return this;
    }

    /* renamed from: a */
    public final C1073bl mo4320a(String str) {
        if (str == null) {
            throw new NullPointerException();
        }
        m4894l();
        this.f2992c.add(str);
        return this;
    }

    /* renamed from: a */
    public final C1073bl mo4321a(boolean z) {
        this.f2990a |= 64;
        this.f2997h = z;
        return this;
    }

    /* renamed from: b */
    public final C1073bl mo4322b(String str) {
        if (str == null) {
            throw new NullPointerException();
        }
        m4895m();
        this.f2993d.add(str);
        return this;
    }

    /* renamed from: c */
    public final C1073bl mo4323c(String str) {
        if (str == null) {
            throw new NullPointerException();
        }
        this.f2990a |= 8;
        this.f2994e = str;
        return this;
    }

    /* renamed from: e */
    public final boolean mo4029e() {
        return true;
    }

    /* renamed from: f */
    public final C1071bj mo4028d() {
        C1071bj k = m4893k();
        if (k.mo4029e()) {
            return k;
        }
        throw new C0992ag();
    }

    /* renamed from: g */
    public final boolean mo4325g() {
        return (this.f2990a & 32) == 32;
    }

    /* renamed from: h */
    public final int mo4326h() {
        return this.f2996g;
    }
}
