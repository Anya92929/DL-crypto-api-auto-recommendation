package com.appbrain.p037f;

import com.appbrain.p033b.C0992ag;
import com.appbrain.p033b.C1012p;
import com.appbrain.p033b.C1020x;

/* renamed from: com.appbrain.f.t */
public final class C1092t extends C1012p implements C1093u {

    /* renamed from: a */
    private int f3048a;

    /* renamed from: b */
    private Object f3049b = "";

    /* renamed from: c */
    private Object f3050c = "";

    /* renamed from: d */
    private boolean f3051d;

    private C1092t() {
    }

    /* renamed from: f */
    static /* synthetic */ C1092t m5029f() {
        return new C1092t();
    }

    /* access modifiers changed from: private */
    /* renamed from: g */
    public C1092t clone() {
        return new C1092t().mo4360a(m5031h());
    }

    /* renamed from: h */
    private C1090r m5031h() {
        int i = 1;
        C1090r rVar = new C1090r((C1012p) this, (byte) 0);
        int i2 = this.f3048a;
        if ((i2 & 1) != 1) {
            i = 0;
        }
        Object unused = rVar.f3043f = this.f3049b;
        if ((i2 & 2) == 2) {
            i |= 2;
        }
        Object unused2 = rVar.f3044g = this.f3050c;
        if ((i2 & 4) == 4) {
            i |= 4;
        }
        boolean unused3 = rVar.f3045h = this.f3051d;
        int unused4 = rVar.f3042e = i;
        return rVar;
    }

    /* renamed from: a */
    public final C1092t mo4360a(C1090r rVar) {
        if (rVar != C1090r.m5014f()) {
            if (rVar.mo4354g()) {
                this.f3048a |= 1;
                this.f3049b = rVar.f3043f;
            }
            if (rVar.mo4356i()) {
                this.f3048a |= 2;
                this.f3050c = rVar.f3044g;
            }
            if (rVar.mo4358k()) {
                boolean l = rVar.mo4359l();
                this.f3048a |= 4;
                this.f3051d = l;
            }
            mo4007a(mo4009c().mo3967a(rVar.f3041d));
        }
        return this;
    }

    /* renamed from: d */
    public final /* synthetic */ C1020x mo4028d() {
        C1090r h = m5031h();
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
