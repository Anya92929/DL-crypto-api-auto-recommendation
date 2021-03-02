package com.appbrain.p037f;

import android.support.p009v4.app.FragmentTransaction;
import android.support.p009v4.app.NotificationCompat;
import com.appbrain.p033b.C0992ag;
import com.appbrain.p033b.C1002f;
import com.appbrain.p033b.C1012p;
import com.appbrain.p033b.C1016t;
import com.appbrain.p033b.C1017u;

/* renamed from: com.appbrain.f.ac */
public final class C1037ac extends C1012p implements C1038ad {

    /* renamed from: A */
    private int f2750A;

    /* renamed from: B */
    private int f2751B;

    /* renamed from: C */
    private int f2752C;

    /* renamed from: D */
    private int f2753D;

    /* renamed from: E */
    private int f2754E;

    /* renamed from: F */
    private int f2755F;

    /* renamed from: G */
    private Object f2756G = "";

    /* renamed from: H */
    private int f2757H;

    /* renamed from: I */
    private Object f2758I = "";

    /* renamed from: J */
    private C1002f f2759J = C1002f.f2629a;

    /* renamed from: K */
    private C1002f f2760K = C1002f.f2629a;

    /* renamed from: L */
    private int f2761L;

    /* renamed from: M */
    private int f2762M;

    /* renamed from: N */
    private long f2763N;

    /* renamed from: O */
    private boolean f2764O;

    /* renamed from: P */
    private Object f2765P = "";

    /* renamed from: Q */
    private boolean f2766Q;

    /* renamed from: R */
    private Object f2767R = "";

    /* renamed from: S */
    private C1017u f2768S = C1016t.f2665a;

    /* renamed from: T */
    private long f2769T;

    /* renamed from: U */
    private boolean f2770U;

    /* renamed from: V */
    private float f2771V;

    /* renamed from: W */
    private float f2772W;

    /* renamed from: X */
    private boolean f2773X;

    /* renamed from: a */
    private int f2774a;

    /* renamed from: b */
    private int f2775b;

    /* renamed from: c */
    private long f2776c;

    /* renamed from: d */
    private long f2777d;

    /* renamed from: e */
    private Object f2778e = "";

    /* renamed from: f */
    private Object f2779f = "";

    /* renamed from: g */
    private Object f2780g = "";

    /* renamed from: h */
    private Object f2781h = "";

    /* renamed from: i */
    private Object f2782i = "";

    /* renamed from: j */
    private Object f2783j = "";

    /* renamed from: k */
    private Object f2784k = "";

    /* renamed from: l */
    private int f2785l;

    /* renamed from: m */
    private int f2786m;

    /* renamed from: n */
    private Object f2787n = "";

    /* renamed from: o */
    private Object f2788o = "";

    /* renamed from: p */
    private Object f2789p = "";

    /* renamed from: q */
    private Object f2790q = "";

    /* renamed from: r */
    private Object f2791r = "";

    /* renamed from: s */
    private Object f2792s = "";

    /* renamed from: t */
    private Object f2793t = "";

    /* renamed from: u */
    private int f2794u;

    /* renamed from: v */
    private Object f2795v = "";

    /* renamed from: w */
    private int f2796w;

    /* renamed from: x */
    private int f2797x;

    /* renamed from: y */
    private long f2798y;

    /* renamed from: z */
    private int f2799z;

    private C1037ac() {
    }

    /* renamed from: i */
    static /* synthetic */ C1037ac m4483i() {
        return new C1037ac();
    }

    /* access modifiers changed from: private */
    /* renamed from: j */
    public C1037ac clone() {
        return new C1037ac().mo4139a(mo4163g());
    }

    /* renamed from: k */
    private void m4485k() {
        if ((this.f2775b & 1024) != 1024) {
            this.f2768S = new C1016t(this.f2768S);
            this.f2775b |= 1024;
        }
    }

    /* renamed from: a */
    public final C1037ac mo4136a(float f) {
        this.f2775b |= FragmentTransaction.TRANSIT_EXIT_MASK;
        this.f2771V = f;
        return this;
    }

    /* renamed from: a */
    public final C1037ac mo4137a(int i) {
        this.f2774a |= 512;
        this.f2785l = i;
        return this;
    }

    /* renamed from: a */
    public final C1037ac mo4138a(long j) {
        this.f2774a |= 1;
        this.f2776c = j;
        return this;
    }

    /* renamed from: a */
    public final C1037ac mo4139a(C1035aa aaVar) {
        if (aaVar != C1035aa.m4359f()) {
            if (aaVar.mo4116g()) {
                mo4138a(aaVar.mo4117h());
            }
            if (aaVar.mo4118i()) {
                mo4144b(aaVar.mo4119j());
            }
            if (aaVar.mo4120k()) {
                this.f2774a |= 4;
                this.f2778e = aaVar.f2732i;
            }
            if (aaVar.mo4121l()) {
                this.f2774a |= 8;
                this.f2779f = aaVar.f2733j;
            }
            if (aaVar.mo4122m()) {
                this.f2774a |= 16;
                this.f2780g = aaVar.f2734k;
            }
            if (aaVar.mo4123n()) {
                this.f2774a |= 32;
                this.f2781h = aaVar.f2735l;
            }
            if (aaVar.mo4124o()) {
                this.f2774a |= 64;
                this.f2782i = aaVar.f2736m;
            }
            if (aaVar.mo4125p()) {
                this.f2774a |= NotificationCompat.FLAG_HIGH_PRIORITY;
                this.f2783j = aaVar.f2737n;
            }
            if (aaVar.mo4126q()) {
                this.f2774a |= NotificationCompat.FLAG_LOCAL_ONLY;
                this.f2784k = aaVar.f2738o;
            }
            if (aaVar.mo4127r()) {
                mo4137a(aaVar.mo4128s());
            }
            if (aaVar.mo4129t()) {
                mo4143b(aaVar.mo4130u());
            }
            if (aaVar.mo4131v()) {
                this.f2774a |= 2048;
                this.f2787n = aaVar.f2741r;
            }
            if (aaVar.mo4132w()) {
                this.f2774a |= FragmentTransaction.TRANSIT_ENTER_MASK;
                this.f2788o = aaVar.f2742s;
            }
            if (aaVar.mo4133x()) {
                this.f2774a |= FragmentTransaction.TRANSIT_EXIT_MASK;
                this.f2789p = aaVar.f2743t;
            }
            if (aaVar.mo4134y()) {
                this.f2774a |= 16384;
                this.f2790q = aaVar.f2744u;
            }
            if (aaVar.mo4135z()) {
                this.f2774a |= 32768;
                this.f2791r = aaVar.f2745v;
            }
            if (aaVar.mo4060A()) {
                this.f2774a |= 65536;
                this.f2792s = aaVar.f2746w;
            }
            if (aaVar.mo4061B()) {
                this.f2774a |= 131072;
                this.f2793t = aaVar.f2747x;
            }
            if (aaVar.mo4062C()) {
                mo4148c(aaVar.mo4063D());
            }
            if (aaVar.mo4064E()) {
                this.f2774a |= 524288;
                this.f2795v = aaVar.f2749z;
            }
            if (aaVar.mo4065F()) {
                mo4153d(aaVar.mo4066G());
            }
            if (aaVar.mo4067H()) {
                mo4157e(aaVar.mo4068I());
            }
            if (aaVar.mo4069J()) {
                mo4149c(aaVar.mo4070K());
            }
            if (aaVar.mo4071L()) {
                mo4161f(aaVar.mo4072M());
            }
            if (aaVar.mo4073N()) {
                mo4164g(aaVar.mo4074O());
            }
            if (aaVar.mo4075P()) {
                mo4166h(aaVar.mo4076Q());
            }
            if (aaVar.mo4077R()) {
                mo4169i(aaVar.mo4078S());
            }
            if (aaVar.mo4079T()) {
                mo4171j(aaVar.mo4080U());
            }
            if (aaVar.mo4081V()) {
                mo4173k(aaVar.mo4082W());
            }
            if (aaVar.mo4083X()) {
                mo4175l(aaVar.mo4084Y());
            }
            if (aaVar.mo4085Z()) {
                this.f2774a |= 1073741824;
                this.f2756G = aaVar.f2707K;
            }
            if (aaVar.mo4090aa()) {
                mo4177m(aaVar.mo4091ab());
            }
            if (aaVar.mo4092ac()) {
                this.f2775b |= 1;
                this.f2758I = aaVar.f2709M;
            }
            if (aaVar.mo4093ad()) {
                mo4145b(aaVar.mo4094ae());
            }
            if (aaVar.mo4095af()) {
                mo4150c(aaVar.mo4096ag());
            }
            if (aaVar.mo4097ah()) {
                mo4179n(aaVar.mo4098ai());
            }
            if (aaVar.mo4099aj()) {
                mo4181o(aaVar.mo4100ak());
            }
            if (aaVar.mo4101al()) {
                mo4154d(aaVar.mo4102am());
            }
            if (aaVar.mo4103an()) {
                mo4141a(aaVar.mo4104ao());
            }
            if (aaVar.mo4105ap()) {
                this.f2775b |= NotificationCompat.FLAG_HIGH_PRIORITY;
                this.f2765P = aaVar.f2716T;
            }
            if (aaVar.mo4106aq()) {
                mo4147b(aaVar.mo4107ar());
            }
            if (aaVar.mo4108as()) {
                this.f2775b |= 512;
                this.f2767R = aaVar.f2718V;
            }
            if (!aaVar.f2719W.isEmpty()) {
                if (this.f2768S.isEmpty()) {
                    this.f2768S = aaVar.f2719W;
                    this.f2775b &= -1025;
                } else {
                    m4485k();
                    this.f2768S.addAll(aaVar.f2719W);
                }
            }
            if (aaVar.mo4109at()) {
                mo4158e(aaVar.mo4110au());
            }
            if (aaVar.mo4111av()) {
                mo4152c(aaVar.mo4112aw());
            }
            if (aaVar.mo4113ax()) {
                mo4136a(aaVar.mo4114ay());
            }
            if (aaVar.mo4115az()) {
                mo4142b(aaVar.mo4086aA());
            }
            if (aaVar.mo4087aB()) {
                mo4156d(aaVar.mo4088aC());
            }
            mo4007a(mo4009c().mo3967a(aaVar.f2727d));
        }
        return this;
    }

    /* renamed from: a */
    public final C1037ac mo4140a(String str) {
        if (str == null) {
            throw new NullPointerException();
        }
        this.f2774a |= 4;
        this.f2778e = str;
        return this;
    }

    /* renamed from: a */
    public final C1037ac mo4141a(boolean z) {
        this.f2775b |= 64;
        this.f2764O = z;
        return this;
    }

    /* renamed from: b */
    public final C1037ac mo4142b(float f) {
        this.f2775b |= 16384;
        this.f2772W = f;
        return this;
    }

    /* renamed from: b */
    public final C1037ac mo4143b(int i) {
        this.f2774a |= 1024;
        this.f2786m = i;
        return this;
    }

    /* renamed from: b */
    public final C1037ac mo4144b(long j) {
        this.f2774a |= 2;
        this.f2777d = j;
        return this;
    }

    /* renamed from: b */
    public final C1037ac mo4145b(C1002f fVar) {
        if (fVar == null) {
            throw new NullPointerException();
        }
        this.f2775b |= 2;
        this.f2759J = fVar;
        return this;
    }

    /* renamed from: b */
    public final C1037ac mo4146b(String str) {
        if (str == null) {
            throw new NullPointerException();
        }
        this.f2774a |= 8;
        this.f2779f = str;
        return this;
    }

    /* renamed from: b */
    public final C1037ac mo4147b(boolean z) {
        this.f2775b |= NotificationCompat.FLAG_LOCAL_ONLY;
        this.f2766Q = z;
        return this;
    }

    /* renamed from: c */
    public final C1037ac mo4148c(int i) {
        this.f2774a |= 262144;
        this.f2794u = i;
        return this;
    }

    /* renamed from: c */
    public final C1037ac mo4149c(long j) {
        this.f2774a |= 4194304;
        this.f2798y = j;
        return this;
    }

    /* renamed from: c */
    public final C1037ac mo4150c(C1002f fVar) {
        if (fVar == null) {
            throw new NullPointerException();
        }
        this.f2775b |= 4;
        this.f2760K = fVar;
        return this;
    }

    /* renamed from: c */
    public final C1037ac mo4151c(String str) {
        if (str == null) {
            throw new NullPointerException();
        }
        this.f2774a |= 16;
        this.f2780g = str;
        return this;
    }

    /* renamed from: c */
    public final C1037ac mo4152c(boolean z) {
        this.f2775b |= FragmentTransaction.TRANSIT_ENTER_MASK;
        this.f2770U = z;
        return this;
    }

    /* renamed from: d */
    public final C1037ac mo4153d(int i) {
        this.f2774a |= 1048576;
        this.f2796w = i;
        return this;
    }

    /* renamed from: d */
    public final C1037ac mo4154d(long j) {
        this.f2775b |= 32;
        this.f2763N = j;
        return this;
    }

    /* renamed from: d */
    public final C1037ac mo4155d(String str) {
        if (str == null) {
            throw new NullPointerException();
        }
        this.f2774a |= 32;
        this.f2781h = str;
        return this;
    }

    /* renamed from: d */
    public final C1037ac mo4156d(boolean z) {
        this.f2775b |= 32768;
        this.f2773X = z;
        return this;
    }

    /* renamed from: e */
    public final C1037ac mo4157e(int i) {
        this.f2774a |= 2097152;
        this.f2797x = i;
        return this;
    }

    /* renamed from: e */
    public final C1037ac mo4158e(long j) {
        this.f2775b |= 2048;
        this.f2769T = j;
        return this;
    }

    /* renamed from: e */
    public final C1037ac mo4159e(String str) {
        if (str == null) {
            throw new NullPointerException();
        }
        this.f2774a |= 64;
        this.f2782i = str;
        return this;
    }

    /* renamed from: e */
    public final boolean mo4029e() {
        return true;
    }

    /* renamed from: f */
    public final C1035aa mo4028d() {
        C1035aa g = mo4163g();
        if (g.mo4029e()) {
            return g;
        }
        throw new C0992ag();
    }

    /* renamed from: f */
    public final C1037ac mo4161f(int i) {
        this.f2774a |= 8388608;
        this.f2799z = i;
        return this;
    }

    /* renamed from: f */
    public final C1037ac mo4162f(String str) {
        if (str == null) {
            throw new NullPointerException();
        }
        this.f2774a |= NotificationCompat.FLAG_HIGH_PRIORITY;
        this.f2783j = str;
        return this;
    }

    /* renamed from: g */
    public final C1035aa mo4163g() {
        int i = 1;
        C1035aa aaVar = new C1035aa((C1012p) this, (byte) 0);
        int i2 = this.f2774a;
        int i3 = this.f2775b;
        int i4 = (i2 & 1) == 1 ? 1 : 0;
        long unused = aaVar.f2730g = this.f2776c;
        if ((i2 & 2) == 2) {
            i4 |= 2;
        }
        long unused2 = aaVar.f2731h = this.f2777d;
        if ((i2 & 4) == 4) {
            i4 |= 4;
        }
        Object unused3 = aaVar.f2732i = this.f2778e;
        if ((i2 & 8) == 8) {
            i4 |= 8;
        }
        Object unused4 = aaVar.f2733j = this.f2779f;
        if ((i2 & 16) == 16) {
            i4 |= 16;
        }
        Object unused5 = aaVar.f2734k = this.f2780g;
        if ((i2 & 32) == 32) {
            i4 |= 32;
        }
        Object unused6 = aaVar.f2735l = this.f2781h;
        if ((i2 & 64) == 64) {
            i4 |= 64;
        }
        Object unused7 = aaVar.f2736m = this.f2782i;
        if ((i2 & NotificationCompat.FLAG_HIGH_PRIORITY) == 128) {
            i4 |= NotificationCompat.FLAG_HIGH_PRIORITY;
        }
        Object unused8 = aaVar.f2737n = this.f2783j;
        if ((i2 & NotificationCompat.FLAG_LOCAL_ONLY) == 256) {
            i4 |= NotificationCompat.FLAG_LOCAL_ONLY;
        }
        Object unused9 = aaVar.f2738o = this.f2784k;
        if ((i2 & 512) == 512) {
            i4 |= 512;
        }
        int unused10 = aaVar.f2739p = this.f2785l;
        if ((i2 & 1024) == 1024) {
            i4 |= 1024;
        }
        int unused11 = aaVar.f2740q = this.f2786m;
        if ((i2 & 2048) == 2048) {
            i4 |= 2048;
        }
        Object unused12 = aaVar.f2741r = this.f2787n;
        if ((i2 & FragmentTransaction.TRANSIT_ENTER_MASK) == 4096) {
            i4 |= FragmentTransaction.TRANSIT_ENTER_MASK;
        }
        Object unused13 = aaVar.f2742s = this.f2788o;
        if ((i2 & FragmentTransaction.TRANSIT_EXIT_MASK) == 8192) {
            i4 |= FragmentTransaction.TRANSIT_EXIT_MASK;
        }
        Object unused14 = aaVar.f2743t = this.f2789p;
        if ((i2 & 16384) == 16384) {
            i4 |= 16384;
        }
        Object unused15 = aaVar.f2744u = this.f2790q;
        if ((i2 & 32768) == 32768) {
            i4 |= 32768;
        }
        Object unused16 = aaVar.f2745v = this.f2791r;
        if ((i2 & 65536) == 65536) {
            i4 |= 65536;
        }
        Object unused17 = aaVar.f2746w = this.f2792s;
        if ((131072 & i2) == 131072) {
            i4 |= 131072;
        }
        Object unused18 = aaVar.f2747x = this.f2793t;
        if ((262144 & i2) == 262144) {
            i4 |= 262144;
        }
        int unused19 = aaVar.f2748y = this.f2794u;
        if ((524288 & i2) == 524288) {
            i4 |= 524288;
        }
        Object unused20 = aaVar.f2749z = this.f2795v;
        if ((1048576 & i2) == 1048576) {
            i4 |= 1048576;
        }
        int unused21 = aaVar.f2697A = this.f2796w;
        if ((2097152 & i2) == 2097152) {
            i4 |= 2097152;
        }
        int unused22 = aaVar.f2698B = this.f2797x;
        if ((4194304 & i2) == 4194304) {
            i4 |= 4194304;
        }
        long unused23 = aaVar.f2699C = this.f2798y;
        if ((8388608 & i2) == 8388608) {
            i4 |= 8388608;
        }
        int unused24 = aaVar.f2700D = this.f2799z;
        if ((16777216 & i2) == 16777216) {
            i4 |= 16777216;
        }
        int unused25 = aaVar.f2701E = this.f2750A;
        if ((33554432 & i2) == 33554432) {
            i4 |= 33554432;
        }
        int unused26 = aaVar.f2702F = this.f2751B;
        if ((67108864 & i2) == 67108864) {
            i4 |= 67108864;
        }
        int unused27 = aaVar.f2703G = this.f2752C;
        if ((134217728 & i2) == 134217728) {
            i4 |= 134217728;
        }
        int unused28 = aaVar.f2704H = this.f2753D;
        if ((268435456 & i2) == 268435456) {
            i4 |= 268435456;
        }
        int unused29 = aaVar.f2705I = this.f2754E;
        if ((536870912 & i2) == 536870912) {
            i4 |= 536870912;
        }
        int unused30 = aaVar.f2706J = this.f2755F;
        if ((1073741824 & i2) == 1073741824) {
            i4 |= 1073741824;
        }
        Object unused31 = aaVar.f2707K = this.f2756G;
        if ((i2 & Integer.MIN_VALUE) == Integer.MIN_VALUE) {
            i4 |= Integer.MIN_VALUE;
        }
        int unused32 = aaVar.f2708L = this.f2757H;
        if ((i3 & 1) != 1) {
            i = 0;
        }
        Object unused33 = aaVar.f2709M = this.f2758I;
        if ((i3 & 2) == 2) {
            i |= 2;
        }
        C1002f unused34 = aaVar.f2710N = this.f2759J;
        if ((i3 & 4) == 4) {
            i |= 4;
        }
        C1002f unused35 = aaVar.f2711O = this.f2760K;
        if ((i3 & 8) == 8) {
            i |= 8;
        }
        int unused36 = aaVar.f2712P = this.f2761L;
        if ((i3 & 16) == 16) {
            i |= 16;
        }
        int unused37 = aaVar.f2713Q = this.f2762M;
        if ((i3 & 32) == 32) {
            i |= 32;
        }
        long unused38 = aaVar.f2714R = this.f2763N;
        if ((i3 & 64) == 64) {
            i |= 64;
        }
        boolean unused39 = aaVar.f2715S = this.f2764O;
        if ((i3 & NotificationCompat.FLAG_HIGH_PRIORITY) == 128) {
            i |= NotificationCompat.FLAG_HIGH_PRIORITY;
        }
        Object unused40 = aaVar.f2716T = this.f2765P;
        if ((i3 & NotificationCompat.FLAG_LOCAL_ONLY) == 256) {
            i |= NotificationCompat.FLAG_LOCAL_ONLY;
        }
        boolean unused41 = aaVar.f2717U = this.f2766Q;
        if ((i3 & 512) == 512) {
            i |= 512;
        }
        Object unused42 = aaVar.f2718V = this.f2767R;
        if ((this.f2775b & 1024) == 1024) {
            this.f2768S = this.f2768S.mo3944b();
            this.f2775b &= -1025;
        }
        C1017u unused43 = aaVar.f2719W = this.f2768S;
        if ((i3 & 2048) == 2048) {
            i |= 1024;
        }
        long unused44 = aaVar.f2720X = this.f2769T;
        if ((i3 & FragmentTransaction.TRANSIT_ENTER_MASK) == 4096) {
            i |= 2048;
        }
        boolean unused45 = aaVar.f2721Y = this.f2770U;
        if ((i3 & FragmentTransaction.TRANSIT_EXIT_MASK) == 8192) {
            i |= FragmentTransaction.TRANSIT_ENTER_MASK;
        }
        float unused46 = aaVar.f2722Z = this.f2771V;
        if ((i3 & 16384) == 16384) {
            i |= FragmentTransaction.TRANSIT_EXIT_MASK;
        }
        float unused47 = aaVar.f2723aa = this.f2772W;
        if ((i3 & 32768) == 32768) {
            i |= 16384;
        }
        boolean unused48 = aaVar.f2724ab = this.f2773X;
        int unused49 = aaVar.f2728e = i4;
        int unused50 = aaVar.f2729f = i;
        return aaVar;
    }

    /* renamed from: g */
    public final C1037ac mo4164g(int i) {
        this.f2774a |= 16777216;
        this.f2750A = i;
        return this;
    }

    /* renamed from: g */
    public final C1037ac mo4165g(String str) {
        if (str == null) {
            throw new NullPointerException();
        }
        this.f2774a |= NotificationCompat.FLAG_LOCAL_ONLY;
        this.f2784k = str;
        return this;
    }

    /* renamed from: h */
    public final C1037ac mo4166h(int i) {
        this.f2774a |= 33554432;
        this.f2751B = i;
        return this;
    }

    /* renamed from: h */
    public final C1037ac mo4167h(String str) {
        if (str == null) {
            throw new NullPointerException();
        }
        this.f2774a |= FragmentTransaction.TRANSIT_ENTER_MASK;
        this.f2788o = str;
        return this;
    }

    /* renamed from: h */
    public final boolean mo4168h() {
        return (this.f2775b & FragmentTransaction.TRANSIT_EXIT_MASK) == 8192;
    }

    /* renamed from: i */
    public final C1037ac mo4169i(int i) {
        this.f2774a |= 67108864;
        this.f2752C = i;
        return this;
    }

    /* renamed from: i */
    public final C1037ac mo4170i(String str) {
        if (str == null) {
            throw new NullPointerException();
        }
        this.f2774a |= FragmentTransaction.TRANSIT_EXIT_MASK;
        this.f2789p = str;
        return this;
    }

    /* renamed from: j */
    public final C1037ac mo4171j(int i) {
        this.f2774a |= 134217728;
        this.f2753D = i;
        return this;
    }

    /* renamed from: j */
    public final C1037ac mo4172j(String str) {
        if (str == null) {
            throw new NullPointerException();
        }
        this.f2774a |= 16384;
        this.f2790q = str;
        return this;
    }

    /* renamed from: k */
    public final C1037ac mo4173k(int i) {
        this.f2774a |= 268435456;
        this.f2754E = i;
        return this;
    }

    /* renamed from: k */
    public final C1037ac mo4174k(String str) {
        if (str == null) {
            throw new NullPointerException();
        }
        this.f2774a |= 32768;
        this.f2791r = str;
        return this;
    }

    /* renamed from: l */
    public final C1037ac mo4175l(int i) {
        this.f2774a |= 536870912;
        this.f2755F = i;
        return this;
    }

    /* renamed from: l */
    public final C1037ac mo4176l(String str) {
        if (str == null) {
            throw new NullPointerException();
        }
        this.f2774a |= 65536;
        this.f2792s = str;
        return this;
    }

    /* renamed from: m */
    public final C1037ac mo4177m(int i) {
        this.f2774a |= Integer.MIN_VALUE;
        this.f2757H = i;
        return this;
    }

    /* renamed from: m */
    public final C1037ac mo4178m(String str) {
        if (str == null) {
            throw new NullPointerException();
        }
        this.f2774a |= 131072;
        this.f2793t = str;
        return this;
    }

    /* renamed from: n */
    public final C1037ac mo4179n(int i) {
        this.f2775b |= 8;
        this.f2761L = i;
        return this;
    }

    /* renamed from: n */
    public final C1037ac mo4180n(String str) {
        if (str == null) {
            throw new NullPointerException();
        }
        this.f2774a |= 524288;
        this.f2795v = str;
        return this;
    }

    /* renamed from: o */
    public final C1037ac mo4181o(int i) {
        this.f2775b |= 16;
        this.f2762M = i;
        return this;
    }

    /* renamed from: o */
    public final C1037ac mo4182o(String str) {
        if (str == null) {
            throw new NullPointerException();
        }
        this.f2774a |= 1073741824;
        this.f2756G = str;
        return this;
    }

    /* renamed from: p */
    public final C1037ac mo4183p(String str) {
        if (str == null) {
            throw new NullPointerException();
        }
        this.f2775b |= 1;
        this.f2758I = str;
        return this;
    }

    /* renamed from: q */
    public final C1037ac mo4184q(String str) {
        if (str == null) {
            throw new NullPointerException();
        }
        this.f2775b |= NotificationCompat.FLAG_HIGH_PRIORITY;
        this.f2765P = str;
        return this;
    }

    /* renamed from: r */
    public final C1037ac mo4185r(String str) {
        if (str == null) {
            throw new NullPointerException();
        }
        this.f2775b |= 512;
        this.f2767R = str;
        return this;
    }

    /* renamed from: s */
    public final C1037ac mo4186s(String str) {
        if (str == null) {
            throw new NullPointerException();
        }
        m4485k();
        this.f2768S.add(str);
        return this;
    }
}
