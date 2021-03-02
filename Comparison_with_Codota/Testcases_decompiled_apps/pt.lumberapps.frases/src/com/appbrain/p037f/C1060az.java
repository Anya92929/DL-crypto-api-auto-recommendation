package com.appbrain.p037f;

import android.support.p009v4.app.NotificationCompat;
import com.appbrain.p033b.C0992ag;
import com.appbrain.p033b.C1012p;
import com.appbrain.p033b.C1020x;

/* renamed from: com.appbrain.f.az */
public final class C1060az extends C1012p implements C1062ba {

    /* renamed from: a */
    private int f2919a;

    /* renamed from: b */
    private int f2920b;

    /* renamed from: c */
    private Object f2921c = "";

    /* renamed from: d */
    private Object f2922d = "";

    /* renamed from: e */
    private Object f2923e = "";

    /* renamed from: f */
    private Object f2924f = "";

    /* renamed from: g */
    private C1058ax f2925g = C1058ax.DIALOG;

    /* renamed from: h */
    private int f2926h;

    /* renamed from: i */
    private boolean f2927i;

    /* renamed from: j */
    private int f2928j;

    /* renamed from: k */
    private boolean f2929k;

    private C1060az() {
    }

    /* renamed from: f */
    static /* synthetic */ C1060az m4734f() {
        return new C1060az();
    }

    /* access modifiers changed from: private */
    /* renamed from: g */
    public C1060az clone() {
        return new C1060az().mo4258a(m4736h());
    }

    /* renamed from: h */
    private C1056av m4736h() {
        int i = 1;
        C1056av avVar = new C1056av((C1012p) this, (byte) 0);
        int i2 = this.f2919a;
        if ((i2 & 1) != 1) {
            i = 0;
        }
        int unused = avVar.f2899f = this.f2920b;
        if ((i2 & 2) == 2) {
            i |= 2;
        }
        Object unused2 = avVar.f2900g = this.f2921c;
        if ((i2 & 4) == 4) {
            i |= 4;
        }
        Object unused3 = avVar.f2901h = this.f2922d;
        if ((i2 & 8) == 8) {
            i |= 8;
        }
        Object unused4 = avVar.f2902i = this.f2923e;
        if ((i2 & 16) == 16) {
            i |= 16;
        }
        Object unused5 = avVar.f2903j = this.f2924f;
        if ((i2 & 32) == 32) {
            i |= 32;
        }
        C1058ax unused6 = avVar.f2904k = this.f2925g;
        if ((i2 & 64) == 64) {
            i |= 64;
        }
        int unused7 = avVar.f2905l = this.f2926h;
        if ((i2 & NotificationCompat.FLAG_HIGH_PRIORITY) == 128) {
            i |= NotificationCompat.FLAG_HIGH_PRIORITY;
        }
        boolean unused8 = avVar.f2906m = this.f2927i;
        if ((i2 & NotificationCompat.FLAG_LOCAL_ONLY) == 256) {
            i |= NotificationCompat.FLAG_LOCAL_ONLY;
        }
        int unused9 = avVar.f2907n = this.f2928j;
        if ((i2 & 512) == 512) {
            i |= 512;
        }
        boolean unused10 = avVar.f2908o = this.f2929k;
        int unused11 = avVar.f2898e = i;
        return avVar;
    }

    /* renamed from: a */
    public final C1060az mo4258a(C1056av avVar) {
        if (avVar != C1056av.m4706f()) {
            if (avVar.mo4237g()) {
                int h = avVar.mo4238h();
                this.f2919a |= 1;
                this.f2920b = h;
            }
            if (avVar.mo4239i()) {
                this.f2919a |= 2;
                this.f2921c = avVar.f2900g;
            }
            if (avVar.mo4241k()) {
                this.f2919a |= 4;
                this.f2922d = avVar.f2901h;
            }
            if (avVar.mo4243m()) {
                this.f2919a |= 8;
                this.f2923e = avVar.f2902i;
            }
            if (avVar.mo4245o()) {
                this.f2919a |= 16;
                this.f2924f = avVar.f2903j;
            }
            if (avVar.mo4247q()) {
                C1058ax r = avVar.mo4248r();
                if (r == null) {
                    throw new NullPointerException();
                }
                this.f2919a |= 32;
                this.f2925g = r;
            }
            if (avVar.mo4249s()) {
                int t = avVar.mo4250t();
                this.f2919a |= 64;
                this.f2926h = t;
            }
            if (avVar.mo4251u()) {
                boolean v = avVar.mo4252v();
                this.f2919a |= NotificationCompat.FLAG_HIGH_PRIORITY;
                this.f2927i = v;
            }
            if (avVar.mo4253w()) {
                int x = avVar.mo4254x();
                this.f2919a |= NotificationCompat.FLAG_LOCAL_ONLY;
                this.f2928j = x;
            }
            if (avVar.mo4255y()) {
                boolean z = avVar.mo4256z();
                this.f2919a |= 512;
                this.f2929k = z;
            }
            mo4007a(mo4009c().mo3967a(avVar.f2897d));
        }
        return this;
    }

    /* renamed from: d */
    public final /* synthetic */ C1020x mo4028d() {
        C1056av h = m4736h();
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
