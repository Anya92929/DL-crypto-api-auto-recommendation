package com.appbrain.p037f;

import android.support.p009v4.app.NotificationCompat;
import com.appbrain.p033b.C0992ag;
import com.appbrain.p033b.C1012p;

/* renamed from: com.appbrain.f.bd */
public final class C1065bd extends C1012p implements C1066be {

    /* renamed from: a */
    private int f2954a;

    /* renamed from: b */
    private C1035aa f2955b = C1035aa.m4359f();

    /* renamed from: c */
    private Object f2956c = "";

    /* renamed from: d */
    private C1040af f2957d = C1040af.DEPRECATED_SELECT;

    /* renamed from: e */
    private long f2958e;

    /* renamed from: f */
    private long f2959f;

    /* renamed from: g */
    private Object f2960g = "";

    /* renamed from: h */
    private Object f2961h = "";

    /* renamed from: i */
    private boolean f2962i;

    /* renamed from: j */
    private int f2963j;

    private C1065bd() {
    }

    /* renamed from: h */
    static /* synthetic */ C1065bd m4805h() {
        return new C1065bd();
    }

    /* access modifiers changed from: private */
    /* renamed from: i */
    public C1065bd clone() {
        return new C1065bd().mo4286a(mo4293g());
    }

    /* renamed from: a */
    public final C1065bd mo4282a(int i) {
        this.f2954a |= NotificationCompat.FLAG_LOCAL_ONLY;
        this.f2963j = i;
        return this;
    }

    /* renamed from: a */
    public final C1065bd mo4283a(long j) {
        this.f2954a |= 8;
        this.f2958e = j;
        return this;
    }

    /* renamed from: a */
    public final C1065bd mo4284a(C1035aa aaVar) {
        if (aaVar == null) {
            throw new NullPointerException();
        }
        this.f2955b = aaVar;
        this.f2954a |= 1;
        return this;
    }

    /* renamed from: a */
    public final C1065bd mo4285a(C1040af afVar) {
        if (afVar == null) {
            throw new NullPointerException();
        }
        this.f2954a |= 4;
        this.f2957d = afVar;
        return this;
    }

    /* renamed from: a */
    public final C1065bd mo4286a(C1063bb bbVar) {
        if (bbVar != C1063bb.m4779f()) {
            if (bbVar.mo4264g()) {
                C1035aa h = bbVar.mo4265h();
                if ((this.f2954a & 1) != 1 || this.f2955b == C1035aa.m4359f()) {
                    this.f2955b = h;
                } else {
                    this.f2955b = C1035aa.m4313a(this.f2955b).mo4139a(h).mo4163g();
                }
                this.f2954a |= 1;
            }
            if (bbVar.mo4266i()) {
                this.f2954a |= 2;
                this.f2956c = bbVar.f2944g;
            }
            if (bbVar.mo4268k()) {
                mo4285a(bbVar.mo4269l());
            }
            if (bbVar.mo4270m()) {
                mo4283a(bbVar.mo4271n());
            }
            if (bbVar.mo4272o()) {
                mo4289b(bbVar.mo4273p());
            }
            if (bbVar.mo4274q()) {
                this.f2954a |= 32;
                this.f2960g = bbVar.f2948k;
            }
            if (bbVar.mo4275r()) {
                this.f2954a |= 64;
                this.f2961h = bbVar.f2949l;
            }
            if (bbVar.mo4277t()) {
                mo4288a(bbVar.mo4278u());
            }
            if (bbVar.mo4279v()) {
                mo4282a(bbVar.mo4280w());
            }
            mo4007a(mo4009c().mo3967a(bbVar.f2941d));
        }
        return this;
    }

    /* renamed from: a */
    public final C1065bd mo4287a(String str) {
        if (str == null) {
            throw new NullPointerException();
        }
        this.f2954a |= 2;
        this.f2956c = str;
        return this;
    }

    /* renamed from: a */
    public final C1065bd mo4288a(boolean z) {
        this.f2954a |= NotificationCompat.FLAG_HIGH_PRIORITY;
        this.f2962i = z;
        return this;
    }

    /* renamed from: b */
    public final C1065bd mo4289b(long j) {
        this.f2954a |= 16;
        this.f2959f = j;
        return this;
    }

    /* renamed from: b */
    public final C1065bd mo4290b(String str) {
        if (str == null) {
            throw new NullPointerException();
        }
        this.f2954a |= 32;
        this.f2960g = str;
        return this;
    }

    /* renamed from: c */
    public final C1065bd mo4291c(String str) {
        if (str == null) {
            throw new NullPointerException();
        }
        this.f2954a |= 64;
        this.f2961h = str;
        return this;
    }

    /* renamed from: e */
    public final boolean mo4029e() {
        return true;
    }

    /* renamed from: f */
    public final C1063bb mo4028d() {
        C1063bb g = mo4293g();
        if (g.mo4029e()) {
            return g;
        }
        throw new C0992ag();
    }

    /* renamed from: g */
    public final C1063bb mo4293g() {
        int i = 1;
        C1063bb bbVar = new C1063bb((C1012p) this, (byte) 0);
        int i2 = this.f2954a;
        if ((i2 & 1) != 1) {
            i = 0;
        }
        C1035aa unused = bbVar.f2943f = this.f2955b;
        if ((i2 & 2) == 2) {
            i |= 2;
        }
        Object unused2 = bbVar.f2944g = this.f2956c;
        if ((i2 & 4) == 4) {
            i |= 4;
        }
        C1040af unused3 = bbVar.f2945h = this.f2957d;
        if ((i2 & 8) == 8) {
            i |= 8;
        }
        long unused4 = bbVar.f2946i = this.f2958e;
        if ((i2 & 16) == 16) {
            i |= 16;
        }
        long unused5 = bbVar.f2947j = this.f2959f;
        if ((i2 & 32) == 32) {
            i |= 32;
        }
        Object unused6 = bbVar.f2948k = this.f2960g;
        if ((i2 & 64) == 64) {
            i |= 64;
        }
        Object unused7 = bbVar.f2949l = this.f2961h;
        if ((i2 & NotificationCompat.FLAG_HIGH_PRIORITY) == 128) {
            i |= NotificationCompat.FLAG_HIGH_PRIORITY;
        }
        boolean unused8 = bbVar.f2950m = this.f2962i;
        if ((i2 & NotificationCompat.FLAG_LOCAL_ONLY) == 256) {
            i |= NotificationCompat.FLAG_LOCAL_ONLY;
        }
        int unused9 = bbVar.f2951n = this.f2963j;
        int unused10 = bbVar.f2942e = i;
        return bbVar;
    }
}
