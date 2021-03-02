package com.appbrain.p037f;

import com.appbrain.p033b.C0992ag;
import com.appbrain.p033b.C1012p;
import com.appbrain.p033b.C1020x;

/* renamed from: com.appbrain.f.l */
public final class C1084l extends C1012p implements C1085m {

    /* renamed from: a */
    private int f3022a;

    /* renamed from: b */
    private C1086n f3023b = C1086n.m4984f();

    private C1084l() {
    }

    /* renamed from: f */
    static /* synthetic */ C1084l m4967f() {
        return new C1084l();
    }

    /* access modifiers changed from: private */
    /* renamed from: g */
    public C1084l clone() {
        return new C1084l().mo4343a(m4969h());
    }

    /* renamed from: h */
    private C1082j m4969h() {
        int i = 1;
        C1082j jVar = new C1082j((C1012p) this, (byte) 0);
        if ((this.f3022a & 1) != 1) {
            i = 0;
        }
        C1086n unused = jVar.f3019f = this.f3023b;
        int unused2 = jVar.f3018e = i;
        return jVar;
    }

    /* renamed from: a */
    public final C1084l mo4343a(C1082j jVar) {
        if (jVar != C1082j.m4959f()) {
            if (jVar.mo4341g()) {
                C1086n h = jVar.mo4342h();
                if ((this.f3022a & 1) != 1 || this.f3023b == C1086n.m4984f()) {
                    this.f3023b = h;
                } else {
                    this.f3023b = C1086n.m4976a(this.f3023b).mo4352a(h).mo4353f();
                }
                this.f3022a |= 1;
            }
            mo4007a(mo4009c().mo3967a(jVar.f3017d));
        }
        return this;
    }

    /* renamed from: d */
    public final /* synthetic */ C1020x mo4028d() {
        C1082j h = m4969h();
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
