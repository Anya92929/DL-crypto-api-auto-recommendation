package com.appbrain.p037f;

import android.support.p009v4.app.FragmentTransaction;
import android.support.p009v4.app.NotificationCompat;
import com.appbrain.p033b.C0992ag;
import com.appbrain.p033b.C1012p;
import com.appbrain.p033b.C1016t;
import com.appbrain.p033b.C1017u;
import com.appbrain.p033b.C1020x;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* renamed from: com.appbrain.f.aj */
public final class C1044aj extends C1012p implements C1045ak {

    /* renamed from: a */
    private int f2829a;

    /* renamed from: b */
    private C1017u f2830b = C1016t.f2665a;

    /* renamed from: c */
    private C1017u f2831c = C1016t.f2665a;

    /* renamed from: d */
    private C1017u f2832d = C1016t.f2665a;

    /* renamed from: e */
    private C1017u f2833e = C1016t.f2665a;

    /* renamed from: f */
    private C1017u f2834f = C1016t.f2665a;

    /* renamed from: g */
    private C1017u f2835g = C1016t.f2665a;

    /* renamed from: h */
    private List f2836h = Collections.emptyList();

    /* renamed from: i */
    private Object f2837i = "";

    /* renamed from: j */
    private boolean f2838j;

    /* renamed from: k */
    private C1017u f2839k = C1016t.f2665a;

    /* renamed from: l */
    private List f2840l = Collections.emptyList();

    /* renamed from: m */
    private Object f2841m = "";

    /* renamed from: n */
    private List f2842n = Collections.emptyList();

    private C1044aj() {
    }

    /* renamed from: f */
    static /* synthetic */ C1044aj m4599f() {
        return new C1044aj();
    }

    /* access modifiers changed from: private */
    /* renamed from: g */
    public C1044aj clone() {
        return new C1044aj().mo4208a(m4601h());
    }

    /* renamed from: h */
    private C1042ah m4601h() {
        int i = 1;
        C1042ah ahVar = new C1042ah((C1012p) this, (byte) 0);
        int i2 = this.f2829a;
        if ((this.f2829a & 1) == 1) {
            this.f2830b = this.f2830b.mo3944b();
            this.f2829a &= -2;
        }
        C1017u unused = ahVar.f2814f = this.f2830b;
        if ((this.f2829a & 2) == 2) {
            this.f2831c = this.f2831c.mo3944b();
            this.f2829a &= -3;
        }
        C1017u unused2 = ahVar.f2815g = this.f2831c;
        if ((this.f2829a & 4) == 4) {
            this.f2832d = this.f2832d.mo3944b();
            this.f2829a &= -5;
        }
        C1017u unused3 = ahVar.f2816h = this.f2832d;
        if ((this.f2829a & 8) == 8) {
            this.f2833e = this.f2833e.mo3944b();
            this.f2829a &= -9;
        }
        C1017u unused4 = ahVar.f2817i = this.f2833e;
        if ((this.f2829a & 16) == 16) {
            this.f2834f = this.f2834f.mo3944b();
            this.f2829a &= -17;
        }
        C1017u unused5 = ahVar.f2818j = this.f2834f;
        if ((this.f2829a & 32) == 32) {
            this.f2835g = this.f2835g.mo3944b();
            this.f2829a &= -33;
        }
        C1017u unused6 = ahVar.f2819k = this.f2835g;
        if ((this.f2829a & 64) == 64) {
            this.f2836h = Collections.unmodifiableList(this.f2836h);
            this.f2829a &= -65;
        }
        List unused7 = ahVar.f2820l = this.f2836h;
        if ((i2 & NotificationCompat.FLAG_HIGH_PRIORITY) != 128) {
            i = 0;
        }
        Object unused8 = ahVar.f2821m = this.f2837i;
        if ((i2 & NotificationCompat.FLAG_LOCAL_ONLY) == 256) {
            i |= 2;
        }
        boolean unused9 = ahVar.f2822n = this.f2838j;
        if ((this.f2829a & 512) == 512) {
            this.f2839k = this.f2839k.mo3944b();
            this.f2829a &= -513;
        }
        C1017u unused10 = ahVar.f2823o = this.f2839k;
        if ((this.f2829a & 1024) == 1024) {
            this.f2840l = Collections.unmodifiableList(this.f2840l);
            this.f2829a &= -1025;
        }
        List unused11 = ahVar.f2824p = this.f2840l;
        if ((i2 & 2048) == 2048) {
            i |= 4;
        }
        Object unused12 = ahVar.f2825q = this.f2841m;
        if ((this.f2829a & FragmentTransaction.TRANSIT_ENTER_MASK) == 4096) {
            this.f2842n = Collections.unmodifiableList(this.f2842n);
            this.f2829a &= -4097;
        }
        List unused13 = ahVar.f2826r = this.f2842n;
        int unused14 = ahVar.f2813e = i;
        return ahVar;
    }

    /* renamed from: a */
    public final C1044aj mo4208a(C1042ah ahVar) {
        if (ahVar != C1042ah.m4562f()) {
            if (!ahVar.f2814f.isEmpty()) {
                if (this.f2830b.isEmpty()) {
                    this.f2830b = ahVar.f2814f;
                    this.f2829a &= -2;
                } else {
                    if ((this.f2829a & 1) != 1) {
                        this.f2830b = new C1016t(this.f2830b);
                        this.f2829a |= 1;
                    }
                    this.f2830b.addAll(ahVar.f2814f);
                }
            }
            if (!ahVar.f2815g.isEmpty()) {
                if (this.f2831c.isEmpty()) {
                    this.f2831c = ahVar.f2815g;
                    this.f2829a &= -3;
                } else {
                    if ((this.f2829a & 2) != 2) {
                        this.f2831c = new C1016t(this.f2831c);
                        this.f2829a |= 2;
                    }
                    this.f2831c.addAll(ahVar.f2815g);
                }
            }
            if (!ahVar.f2816h.isEmpty()) {
                if (this.f2832d.isEmpty()) {
                    this.f2832d = ahVar.f2816h;
                    this.f2829a &= -5;
                } else {
                    if ((this.f2829a & 4) != 4) {
                        this.f2832d = new C1016t(this.f2832d);
                        this.f2829a |= 4;
                    }
                    this.f2832d.addAll(ahVar.f2816h);
                }
            }
            if (!ahVar.f2817i.isEmpty()) {
                if (this.f2833e.isEmpty()) {
                    this.f2833e = ahVar.f2817i;
                    this.f2829a &= -9;
                } else {
                    if ((this.f2829a & 8) != 8) {
                        this.f2833e = new C1016t(this.f2833e);
                        this.f2829a |= 8;
                    }
                    this.f2833e.addAll(ahVar.f2817i);
                }
            }
            if (!ahVar.f2818j.isEmpty()) {
                if (this.f2834f.isEmpty()) {
                    this.f2834f = ahVar.f2818j;
                    this.f2829a &= -17;
                } else {
                    if ((this.f2829a & 16) != 16) {
                        this.f2834f = new C1016t(this.f2834f);
                        this.f2829a |= 16;
                    }
                    this.f2834f.addAll(ahVar.f2818j);
                }
            }
            if (!ahVar.f2819k.isEmpty()) {
                if (this.f2835g.isEmpty()) {
                    this.f2835g = ahVar.f2819k;
                    this.f2829a &= -33;
                } else {
                    if ((this.f2829a & 32) != 32) {
                        this.f2835g = new C1016t(this.f2835g);
                        this.f2829a |= 32;
                    }
                    this.f2835g.addAll(ahVar.f2819k);
                }
            }
            if (!ahVar.f2820l.isEmpty()) {
                if (this.f2836h.isEmpty()) {
                    this.f2836h = ahVar.f2820l;
                    this.f2829a &= -65;
                } else {
                    if ((this.f2829a & 64) != 64) {
                        this.f2836h = new ArrayList(this.f2836h);
                        this.f2829a |= 64;
                    }
                    this.f2836h.addAll(ahVar.f2820l);
                }
            }
            if (ahVar.mo4197h()) {
                this.f2829a |= NotificationCompat.FLAG_HIGH_PRIORITY;
                this.f2837i = ahVar.f2821m;
            }
            if (ahVar.mo4201j()) {
                boolean k = ahVar.mo4202k();
                this.f2829a |= NotificationCompat.FLAG_LOCAL_ONLY;
                this.f2838j = k;
            }
            if (!ahVar.f2823o.isEmpty()) {
                if (this.f2839k.isEmpty()) {
                    this.f2839k = ahVar.f2823o;
                    this.f2829a &= -513;
                } else {
                    if ((this.f2829a & 512) != 512) {
                        this.f2839k = new C1016t(this.f2839k);
                        this.f2829a |= 512;
                    }
                    this.f2839k.addAll(ahVar.f2823o);
                }
            }
            if (!ahVar.f2824p.isEmpty()) {
                if (this.f2840l.isEmpty()) {
                    this.f2840l = ahVar.f2824p;
                    this.f2829a &= -1025;
                } else {
                    if ((this.f2829a & 1024) != 1024) {
                        this.f2840l = new ArrayList(this.f2840l);
                        this.f2829a |= 1024;
                    }
                    this.f2840l.addAll(ahVar.f2824p);
                }
            }
            if (ahVar.mo4205n()) {
                this.f2829a |= 2048;
                this.f2841m = ahVar.f2825q;
            }
            if (!ahVar.f2826r.isEmpty()) {
                if (this.f2842n.isEmpty()) {
                    this.f2842n = ahVar.f2826r;
                    this.f2829a &= -4097;
                } else {
                    if ((this.f2829a & FragmentTransaction.TRANSIT_ENTER_MASK) != 4096) {
                        this.f2842n = new ArrayList(this.f2842n);
                        this.f2829a |= FragmentTransaction.TRANSIT_ENTER_MASK;
                    }
                    this.f2842n.addAll(ahVar.f2826r);
                }
            }
            mo4007a(mo4009c().mo3967a(ahVar.f2812d));
        }
        return this;
    }

    /* renamed from: d */
    public final /* synthetic */ C1020x mo4028d() {
        C1042ah h = m4601h();
        if (h.mo4029e()) {
            return h;
        }
        throw new C0992ag();
    }

    /* renamed from: e */
    public final boolean mo4029e() {
        return true;
    }
}
