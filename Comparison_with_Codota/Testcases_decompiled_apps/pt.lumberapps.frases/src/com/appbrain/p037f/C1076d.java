package com.appbrain.p037f;

import com.appbrain.p033b.C0992ag;
import com.appbrain.p033b.C1012p;

/* renamed from: com.appbrain.f.d */
public final class C1076d extends C1012p implements C1077e {

    /* renamed from: a */
    private int f2998a;

    /* renamed from: b */
    private int f2999b;

    /* renamed from: c */
    private int f3000c;

    /* renamed from: d */
    private Object f3001d = "";

    private C1076d() {
    }

    /* renamed from: g */
    static /* synthetic */ C1076d m4912g() {
        return new C1076d();
    }

    /* access modifiers changed from: private */
    /* renamed from: h */
    public C1076d clone() {
        return new C1076d().mo4328a(m4914i());
    }

    /* renamed from: i */
    private C1061b m4914i() {
        int i = 1;
        C1061b bVar = new C1061b((C1012p) this, (byte) 0);
        int i2 = this.f2998a;
        if ((i2 & 1) != 1) {
            i = 0;
        }
        int unused = bVar.f2934f = this.f2999b;
        if ((i2 & 2) == 2) {
            i |= 2;
        }
        int unused2 = bVar.f2935g = this.f3000c;
        if ((i2 & 4) == 4) {
            i |= 4;
        }
        Object unused3 = bVar.f2936h = this.f3001d;
        int unused4 = bVar.f2933e = i;
        return bVar;
    }

    /* renamed from: a */
    public final C1076d mo4327a(int i) {
        this.f2998a |= 2;
        this.f3000c = i;
        return this;
    }

    /* renamed from: a */
    public final C1076d mo4328a(C1061b bVar) {
        if (bVar != C1061b.m4748f()) {
            if (bVar.mo4259g()) {
                int h = bVar.mo4260h();
                this.f2998a |= 1;
                this.f2999b = h;
            }
            if (bVar.mo4261i()) {
                mo4327a(bVar.mo4262j());
            }
            if (bVar.mo4263k()) {
                this.f2998a |= 4;
                this.f3001d = bVar.f2936h;
            }
            mo4007a(mo4009c().mo3967a(bVar.f2932d));
        }
        return this;
    }

    /* renamed from: a */
    public final C1076d mo4329a(String str) {
        if (str == null) {
            throw new NullPointerException();
        }
        this.f2998a |= 4;
        this.f3001d = str;
        return this;
    }

    /* renamed from: e */
    public final boolean mo4029e() {
        return true;
    }

    /* renamed from: f */
    public final C1061b mo4028d() {
        C1061b i = m4914i();
        if (i.mo4029e()) {
            return i;
        }
        throw new C0992ag();
    }
}
