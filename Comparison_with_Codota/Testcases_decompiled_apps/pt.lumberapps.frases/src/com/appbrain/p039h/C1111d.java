package com.appbrain.p039h;

import android.support.p009v4.app.FragmentTransaction;
import android.support.p009v4.app.NotificationCompat;
import com.appbrain.p033b.C0992ag;
import com.appbrain.p033b.C1002f;
import com.appbrain.p033b.C1012p;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* renamed from: com.appbrain.h.d */
public final class C1111d extends C1012p implements C1112e {

    /* renamed from: a */
    private int f3107a;

    /* renamed from: b */
    private int f3108b;

    /* renamed from: c */
    private Object f3109c = "";

    /* renamed from: d */
    private C1002f f3110d = C1002f.f2629a;

    /* renamed from: e */
    private C1002f f3111e = C1002f.f2629a;

    /* renamed from: f */
    private long f3112f;

    /* renamed from: g */
    private C1113f f3113g = C1113f.INTEGRITY_ONLY;

    /* renamed from: h */
    private boolean f3114h;

    /* renamed from: i */
    private Object f3115i = "";

    /* renamed from: j */
    private boolean f3116j;

    /* renamed from: k */
    private boolean f3117k;

    /* renamed from: l */
    private Object f3118l = "";

    /* renamed from: m */
    private Object f3119m = "";

    /* renamed from: n */
    private Object f3120n = "";

    /* renamed from: o */
    private Object f3121o = "";

    /* renamed from: p */
    private Object f3122p = "";

    /* renamed from: q */
    private int f3123q;

    /* renamed from: r */
    private Object f3124r = "";

    /* renamed from: s */
    private List f3125s = Collections.emptyList();

    /* renamed from: t */
    private List f3126t = Collections.emptyList();

    private C1111d() {
    }

    /* renamed from: i */
    static /* synthetic */ C1111d m5180i() {
        return new C1111d();
    }

    /* access modifiers changed from: private */
    /* renamed from: j */
    public C1111d clone() {
        return new C1111d().mo4417a(m5182k());
    }

    /* renamed from: k */
    private C1109b m5182k() {
        int i = 1;
        C1109b bVar = new C1109b((C1012p) this, (byte) 0);
        int i2 = this.f3107a;
        if ((i2 & 1) != 1) {
            i = 0;
        }
        int unused = bVar.f3086f = this.f3108b;
        if ((i2 & 2) == 2) {
            i |= 2;
        }
        Object unused2 = bVar.f3087g = this.f3109c;
        if ((i2 & 4) == 4) {
            i |= 4;
        }
        C1002f unused3 = bVar.f3088h = this.f3110d;
        if ((i2 & 8) == 8) {
            i |= 8;
        }
        C1002f unused4 = bVar.f3089i = this.f3111e;
        if ((i2 & 16) == 16) {
            i |= 16;
        }
        long unused5 = bVar.f3090j = this.f3112f;
        if ((i2 & 32) == 32) {
            i |= 32;
        }
        C1113f unused6 = bVar.f3091k = this.f3113g;
        if ((i2 & 64) == 64) {
            i |= 64;
        }
        boolean unused7 = bVar.f3092l = this.f3114h;
        if ((i2 & NotificationCompat.FLAG_HIGH_PRIORITY) == 128) {
            i |= NotificationCompat.FLAG_HIGH_PRIORITY;
        }
        Object unused8 = bVar.f3093m = this.f3115i;
        if ((i2 & NotificationCompat.FLAG_LOCAL_ONLY) == 256) {
            i |= NotificationCompat.FLAG_LOCAL_ONLY;
        }
        boolean unused9 = bVar.f3094n = this.f3116j;
        if ((i2 & 512) == 512) {
            i |= 512;
        }
        boolean unused10 = bVar.f3095o = this.f3117k;
        if ((i2 & 1024) == 1024) {
            i |= 1024;
        }
        Object unused11 = bVar.f3096p = this.f3118l;
        if ((i2 & 2048) == 2048) {
            i |= 2048;
        }
        Object unused12 = bVar.f3097q = this.f3119m;
        if ((i2 & FragmentTransaction.TRANSIT_ENTER_MASK) == 4096) {
            i |= FragmentTransaction.TRANSIT_ENTER_MASK;
        }
        Object unused13 = bVar.f3098r = this.f3120n;
        if ((i2 & FragmentTransaction.TRANSIT_EXIT_MASK) == 8192) {
            i |= FragmentTransaction.TRANSIT_EXIT_MASK;
        }
        Object unused14 = bVar.f3099s = this.f3121o;
        if ((i2 & 16384) == 16384) {
            i |= 16384;
        }
        Object unused15 = bVar.f3100t = this.f3122p;
        if ((i2 & 32768) == 32768) {
            i |= 32768;
        }
        int unused16 = bVar.f3101u = this.f3123q;
        if ((i2 & 65536) == 65536) {
            i |= 65536;
        }
        Object unused17 = bVar.f3102v = this.f3124r;
        if ((this.f3107a & 131072) == 131072) {
            this.f3125s = Collections.unmodifiableList(this.f3125s);
            this.f3107a &= -131073;
        }
        List unused18 = bVar.f3103w = this.f3125s;
        if ((this.f3107a & 262144) == 262144) {
            this.f3126t = Collections.unmodifiableList(this.f3126t);
            this.f3107a &= -262145;
        }
        List unused19 = bVar.f3104x = this.f3126t;
        int unused20 = bVar.f3085e = i;
        return bVar;
    }

    /* renamed from: l */
    private void m5183l() {
        if ((this.f3107a & 131072) != 131072) {
            this.f3125s = new ArrayList(this.f3125s);
            this.f3107a |= 131072;
        }
    }

    /* renamed from: m */
    private void m5184m() {
        if ((this.f3107a & 262144) != 262144) {
            this.f3126t = new ArrayList(this.f3126t);
            this.f3107a |= 262144;
        }
    }

    /* renamed from: a */
    public final C1111d mo4415a(int i) {
        this.f3107a |= 1;
        this.f3108b = i;
        return this;
    }

    /* renamed from: a */
    public final C1111d mo4416a(long j) {
        this.f3107a |= 16;
        this.f3112f = j;
        return this;
    }

    /* renamed from: a */
    public final C1111d mo4417a(C1109b bVar) {
        if (bVar != C1109b.m5133f()) {
            if (bVar.mo4395g()) {
                mo4415a(bVar.mo4396h());
            }
            if (bVar.mo4397i()) {
                this.f3107a |= 2;
                this.f3109c = bVar.f3087g;
            }
            if (bVar.mo4398j()) {
                mo4421b(bVar.mo4399k());
            }
            if (bVar.mo4400l()) {
                C1002f m = bVar.mo4401m();
                if (m == null) {
                    throw new NullPointerException();
                }
                this.f3107a |= 8;
                this.f3111e = m;
            }
            if (bVar.mo4402n()) {
                mo4416a(bVar.mo4403o());
            }
            if (bVar.mo4404p()) {
                mo4418a(bVar.mo4405q());
            }
            if (bVar.mo4406r()) {
                boolean s = bVar.mo4407s();
                this.f3107a |= 64;
                this.f3114h = s;
            }
            if (bVar.mo4408t()) {
                this.f3107a |= NotificationCompat.FLAG_HIGH_PRIORITY;
                this.f3115i = bVar.f3093m;
            }
            if (bVar.mo4410v()) {
                boolean w = bVar.mo4411w();
                this.f3107a |= NotificationCompat.FLAG_LOCAL_ONLY;
                this.f3116j = w;
            }
            if (bVar.mo4412x()) {
                boolean y = bVar.mo4413y();
                this.f3107a |= 512;
                this.f3117k = y;
            }
            if (bVar.mo4414z()) {
                this.f3107a |= 1024;
                this.f3118l = bVar.f3096p;
            }
            if (bVar.mo4383A()) {
                this.f3107a |= 2048;
                this.f3119m = bVar.f3097q;
            }
            if (bVar.mo4384B()) {
                this.f3107a |= FragmentTransaction.TRANSIT_ENTER_MASK;
                this.f3120n = bVar.f3098r;
            }
            if (bVar.mo4385C()) {
                this.f3107a |= FragmentTransaction.TRANSIT_EXIT_MASK;
                this.f3121o = bVar.f3099s;
            }
            if (bVar.mo4386D()) {
                this.f3107a |= 16384;
                this.f3122p = bVar.f3100t;
            }
            if (bVar.mo4387E()) {
                mo4420b(bVar.mo4388F());
            }
            if (bVar.mo4389G()) {
                this.f3107a |= 65536;
                this.f3124r = bVar.f3102v;
            }
            if (!bVar.f3103w.isEmpty()) {
                if (this.f3125s.isEmpty()) {
                    this.f3125s = bVar.f3103w;
                    this.f3107a &= -131073;
                } else {
                    m5183l();
                    this.f3125s.addAll(bVar.f3103w);
                }
            }
            if (!bVar.f3104x.isEmpty()) {
                if (this.f3126t.isEmpty()) {
                    this.f3126t = bVar.f3104x;
                    this.f3107a &= -262145;
                } else {
                    m5184m();
                    this.f3126t.addAll(bVar.f3104x);
                }
            }
            mo4007a(mo4009c().mo3967a(bVar.f3084d));
        }
        return this;
    }

    /* renamed from: a */
    public final C1111d mo4418a(C1113f fVar) {
        if (fVar == null) {
            throw new NullPointerException();
        }
        this.f3107a |= 32;
        this.f3113g = fVar;
        return this;
    }

    /* renamed from: a */
    public final C1111d mo4419a(String str) {
        if (str == null) {
            throw new NullPointerException();
        }
        this.f3107a |= 2;
        this.f3109c = str;
        return this;
    }

    /* renamed from: b */
    public final C1111d mo4420b(int i) {
        this.f3107a |= 32768;
        this.f3123q = i;
        return this;
    }

    /* renamed from: b */
    public final C1111d mo4421b(C1002f fVar) {
        if (fVar == null) {
            throw new NullPointerException();
        }
        this.f3107a |= 4;
        this.f3110d = fVar;
        return this;
    }

    /* renamed from: c */
    public final C1111d mo4422c(int i) {
        m5183l();
        this.f3125s.add(Integer.valueOf(i));
        return this;
    }

    /* renamed from: c */
    public final C1111d mo4423c(C1002f fVar) {
        if (fVar == null) {
            throw new NullPointerException();
        }
        m5184m();
        this.f3126t.add(fVar);
        return this;
    }

    /* renamed from: e */
    public final boolean mo4029e() {
        return true;
    }

    /* renamed from: f */
    public final C1109b mo4028d() {
        C1109b k = m5182k();
        if (k.mo4029e()) {
            return k;
        }
        throw new C0992ag();
    }

    /* renamed from: g */
    public final C1111d mo4425g() {
        this.f3107a &= -17;
        this.f3112f = 0;
        return this;
    }

    /* renamed from: h */
    public final C1111d mo4426h() {
        this.f3107a &= -33;
        this.f3113g = C1113f.INTEGRITY_ONLY;
        return this;
    }
}
