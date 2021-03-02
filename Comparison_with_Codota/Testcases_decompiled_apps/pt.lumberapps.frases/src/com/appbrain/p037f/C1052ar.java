package com.appbrain.p037f;

import com.appbrain.p033b.C0992ag;
import com.appbrain.p033b.C1012p;

/* renamed from: com.appbrain.f.ar */
public final class C1052ar extends C1012p implements C1053as {

    /* renamed from: a */
    private int f2869a;

    /* renamed from: b */
    private C1035aa f2870b = C1035aa.m4359f();

    /* renamed from: c */
    private C1054at f2871c = C1054at.UNKNOWN_SOURCE;

    /* renamed from: d */
    private int f2872d;

    /* renamed from: e */
    private boolean f2873e;

    /* renamed from: f */
    private Object f2874f = "";

    /* renamed from: g */
    private int f2875g;

    /* renamed from: h */
    private int f2876h;

    private C1052ar() {
    }

    /* renamed from: g */
    static /* synthetic */ C1052ar m4666g() {
        return new C1052ar();
    }

    /* access modifiers changed from: private */
    /* renamed from: h */
    public C1052ar clone() {
        return new C1052ar().mo4229a(m4668i());
    }

    /* renamed from: i */
    private C1050ap m4668i() {
        int i = 1;
        C1050ap apVar = new C1050ap((C1012p) this, (byte) 0);
        int i2 = this.f2869a;
        if ((i2 & 1) != 1) {
            i = 0;
        }
        C1035aa unused = apVar.f2860f = this.f2870b;
        if ((i2 & 2) == 2) {
            i |= 2;
        }
        C1054at unused2 = apVar.f2861g = this.f2871c;
        if ((i2 & 4) == 4) {
            i |= 4;
        }
        int unused3 = apVar.f2862h = this.f2872d;
        if ((i2 & 8) == 8) {
            i |= 8;
        }
        boolean unused4 = apVar.f2863i = this.f2873e;
        if ((i2 & 16) == 16) {
            i |= 16;
        }
        Object unused5 = apVar.f2864j = this.f2874f;
        if ((i2 & 32) == 32) {
            i |= 32;
        }
        int unused6 = apVar.f2865k = this.f2875g;
        if ((i2 & 64) == 64) {
            i |= 64;
        }
        int unused7 = apVar.f2866l = this.f2876h;
        int unused8 = apVar.f2859e = i;
        return apVar;
    }

    /* renamed from: a */
    public final C1052ar mo4227a(int i) {
        this.f2869a |= 4;
        this.f2872d = i;
        return this;
    }

    /* renamed from: a */
    public final C1052ar mo4228a(C1035aa aaVar) {
        if (aaVar == null) {
            throw new NullPointerException();
        }
        this.f2870b = aaVar;
        this.f2869a |= 1;
        return this;
    }

    /* renamed from: a */
    public final C1052ar mo4229a(C1050ap apVar) {
        if (apVar != C1050ap.m4644f()) {
            if (apVar.mo4214g()) {
                C1035aa h = apVar.mo4215h();
                if ((this.f2869a & 1) != 1 || this.f2870b == C1035aa.m4359f()) {
                    this.f2870b = h;
                } else {
                    this.f2870b = C1035aa.m4313a(this.f2870b).mo4139a(h).mo4163g();
                }
                this.f2869a |= 1;
            }
            if (apVar.mo4216i()) {
                mo4230a(apVar.mo4217j());
            }
            if (apVar.mo4218k()) {
                mo4227a(apVar.mo4219l());
            }
            if (apVar.mo4220m()) {
                mo4232a(apVar.mo4221n());
            }
            if (apVar.mo4222o()) {
                this.f2869a |= 16;
                this.f2874f = apVar.f2864j;
            }
            if (apVar.mo4223p()) {
                mo4233b(apVar.mo4224q());
            }
            if (apVar.mo4225r()) {
                mo4234c(apVar.mo4226s());
            }
            mo4007a(mo4009c().mo3967a(apVar.f2858d));
        }
        return this;
    }

    /* renamed from: a */
    public final C1052ar mo4230a(C1054at atVar) {
        if (atVar == null) {
            throw new NullPointerException();
        }
        this.f2869a |= 2;
        this.f2871c = atVar;
        return this;
    }

    /* renamed from: a */
    public final C1052ar mo4231a(String str) {
        if (str == null) {
            throw new NullPointerException();
        }
        this.f2869a |= 16;
        this.f2874f = str;
        return this;
    }

    /* renamed from: a */
    public final C1052ar mo4232a(boolean z) {
        this.f2869a |= 8;
        this.f2873e = z;
        return this;
    }

    /* renamed from: b */
    public final C1052ar mo4233b(int i) {
        this.f2869a |= 32;
        this.f2875g = i;
        return this;
    }

    /* renamed from: c */
    public final C1052ar mo4234c(int i) {
        this.f2869a |= 64;
        this.f2876h = i;
        return this;
    }

    /* renamed from: e */
    public final boolean mo4029e() {
        return true;
    }

    /* renamed from: f */
    public final C1050ap mo4028d() {
        C1050ap i = m4668i();
        if (i.mo4029e()) {
            return i;
        }
        throw new C0992ag();
    }
}
