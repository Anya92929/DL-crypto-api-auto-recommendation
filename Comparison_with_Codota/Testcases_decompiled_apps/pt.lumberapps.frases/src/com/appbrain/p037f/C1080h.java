package com.appbrain.p037f;

import com.appbrain.p033b.C0992ag;
import com.appbrain.p033b.C1012p;

/* renamed from: com.appbrain.f.h */
public final class C1080h extends C1012p implements C1081i {

    /* renamed from: a */
    private int f3011a;

    /* renamed from: b */
    private Object f3012b = "";

    /* renamed from: c */
    private int f3013c;

    /* renamed from: d */
    private long f3014d;

    private C1080h() {
    }

    /* renamed from: g */
    static /* synthetic */ C1080h m4943g() {
        return new C1080h();
    }

    /* access modifiers changed from: private */
    /* renamed from: h */
    public C1080h clone() {
        return new C1080h().mo4338a(m4945i());
    }

    /* renamed from: i */
    private C1078f m4945i() {
        int i = 1;
        C1078f fVar = new C1078f((C1012p) this, (byte) 0);
        int i2 = this.f3011a;
        if ((i2 & 1) != 1) {
            i = 0;
        }
        Object unused = fVar.f3006f = this.f3012b;
        if ((i2 & 2) == 2) {
            i |= 2;
        }
        int unused2 = fVar.f3007g = this.f3013c;
        if ((i2 & 4) == 4) {
            i |= 4;
        }
        long unused3 = fVar.f3008h = this.f3014d;
        int unused4 = fVar.f3005e = i;
        return fVar;
    }

    /* renamed from: a */
    public final C1080h mo4336a(int i) {
        this.f3011a |= 2;
        this.f3013c = i;
        return this;
    }

    /* renamed from: a */
    public final C1080h mo4337a(long j) {
        this.f3011a |= 4;
        this.f3014d = j;
        return this;
    }

    /* renamed from: a */
    public final C1080h mo4338a(C1078f fVar) {
        if (fVar != C1078f.m4929f()) {
            if (fVar.mo4331g()) {
                this.f3011a |= 1;
                this.f3012b = fVar.f3006f;
            }
            if (fVar.mo4332h()) {
                mo4336a(fVar.mo4333i());
            }
            if (fVar.mo4334j()) {
                mo4337a(fVar.mo4335k());
            }
            mo4007a(mo4009c().mo3967a(fVar.f3004d));
        }
        return this;
    }

    /* renamed from: a */
    public final C1080h mo4339a(String str) {
        if (str == null) {
            throw new NullPointerException();
        }
        this.f3011a |= 1;
        this.f3012b = str;
        return this;
    }

    /* renamed from: e */
    public final boolean mo4029e() {
        return true;
    }

    /* renamed from: f */
    public final C1078f mo4028d() {
        C1078f i = m4945i();
        if (i.mo4029e()) {
            return i;
        }
        throw new C0992ag();
    }
}
