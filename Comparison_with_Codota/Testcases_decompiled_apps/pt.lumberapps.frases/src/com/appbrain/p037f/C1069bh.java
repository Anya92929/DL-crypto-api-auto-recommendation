package com.appbrain.p037f;

import com.appbrain.p033b.C0992ag;
import com.appbrain.p033b.C1012p;

/* renamed from: com.appbrain.f.bh */
public final class C1069bh extends C1012p implements C1070bi {

    /* renamed from: a */
    private int f2973a;

    /* renamed from: b */
    private C1063bb f2974b = C1063bb.m4779f();

    /* renamed from: c */
    private boolean f2975c;

    /* renamed from: d */
    private int f2976d;

    private C1069bh() {
    }

    /* renamed from: g */
    static /* synthetic */ C1069bh m4844g() {
        return new C1069bh();
    }

    /* access modifiers changed from: private */
    /* renamed from: i */
    public C1069bh clone() {
        return new C1069bh().mo4304a(m4846j());
    }

    /* renamed from: j */
    private C1067bf m4846j() {
        int i = 1;
        C1067bf bfVar = new C1067bf((C1012p) this, (byte) 0);
        int i2 = this.f2973a;
        if ((i2 & 1) != 1) {
            i = 0;
        }
        C1063bb unused = bfVar.f2968f = this.f2974b;
        if ((i2 & 2) == 2) {
            i |= 2;
        }
        boolean unused2 = bfVar.f2969g = this.f2975c;
        if ((i2 & 4) == 4) {
            i |= 4;
        }
        int unused3 = bfVar.f2970h = this.f2976d;
        int unused4 = bfVar.f2967e = i;
        return bfVar;
    }

    /* renamed from: a */
    public final C1069bh mo4301a(int i) {
        this.f2973a |= 4;
        this.f2976d = i;
        return this;
    }

    /* renamed from: a */
    public final C1069bh mo4302a(C1063bb bbVar) {
        if (bbVar == null) {
            throw new NullPointerException();
        }
        this.f2974b = bbVar;
        this.f2973a |= 1;
        return this;
    }

    /* renamed from: a */
    public final C1069bh mo4303a(C1065bd bdVar) {
        this.f2974b = bdVar.mo4028d();
        this.f2973a |= 1;
        return this;
    }

    /* renamed from: a */
    public final C1069bh mo4304a(C1067bf bfVar) {
        if (bfVar != C1067bf.m4829f()) {
            if (bfVar.mo4294g()) {
                C1063bb h = bfVar.mo4295h();
                if ((this.f2973a & 1) != 1 || this.f2974b == C1063bb.m4779f()) {
                    this.f2974b = h;
                } else {
                    this.f2974b = C1063bb.m4768a(this.f2974b).mo4286a(h).mo4293g();
                }
                this.f2973a |= 1;
            }
            if (bfVar.mo4296i()) {
                mo4305a(bfVar.mo4297j());
            }
            if (bfVar.mo4298k()) {
                mo4301a(bfVar.mo4299l());
            }
            mo4007a(mo4009c().mo3967a(bfVar.f2966d));
        }
        return this;
    }

    /* renamed from: a */
    public final C1069bh mo4305a(boolean z) {
        this.f2973a |= 2;
        this.f2975c = z;
        return this;
    }

    /* renamed from: e */
    public final boolean mo4029e() {
        return true;
    }

    /* renamed from: f */
    public final C1067bf mo4028d() {
        C1067bf j = m4846j();
        if (j.mo4029e()) {
            return j;
        }
        throw new C0992ag();
    }

    /* renamed from: h */
    public final C1063bb mo4295h() {
        return this.f2974b;
    }

    /* renamed from: l */
    public final int mo4299l() {
        return this.f2976d;
    }
}
