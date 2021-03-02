package com.appbrain.p037f;

import com.appbrain.p033b.C0992ag;
import com.appbrain.p033b.C1012p;
import com.appbrain.p033b.C1016t;
import com.appbrain.p033b.C1017u;
import com.appbrain.p033b.C1020x;

/* renamed from: com.appbrain.f.an */
public final class C1048an extends C1012p implements C1049ao {

    /* renamed from: a */
    private int f2852a;

    /* renamed from: b */
    private Object f2853b = "";

    /* renamed from: c */
    private long f2854c;

    /* renamed from: d */
    private C1017u f2855d = C1016t.f2665a;

    private C1048an() {
    }

    /* renamed from: f */
    static /* synthetic */ C1048an m4626f() {
        return new C1048an();
    }

    /* access modifiers changed from: private */
    /* renamed from: g */
    public C1048an clone() {
        return new C1048an().mo4213a(m4628h());
    }

    /* renamed from: h */
    private C1046al m4628h() {
        int i = 1;
        C1046al alVar = new C1046al((C1012p) this, (byte) 0);
        int i2 = this.f2852a;
        if ((i2 & 1) != 1) {
            i = 0;
        }
        Object unused = alVar.f2847f = this.f2853b;
        if ((i2 & 2) == 2) {
            i |= 2;
        }
        long unused2 = alVar.f2848g = this.f2854c;
        if ((this.f2852a & 4) == 4) {
            this.f2855d = this.f2855d.mo3944b();
            this.f2852a &= -5;
        }
        C1017u unused3 = alVar.f2849h = this.f2855d;
        int unused4 = alVar.f2846e = i;
        return alVar;
    }

    /* renamed from: a */
    public final C1048an mo4213a(C1046al alVar) {
        if (alVar != C1046al.m4614f()) {
            if (alVar.mo4209g()) {
                this.f2852a |= 1;
                this.f2853b = alVar.f2847f;
            }
            if (alVar.mo4211i()) {
                long j = alVar.mo4212j();
                this.f2852a |= 2;
                this.f2854c = j;
            }
            if (!alVar.f2849h.isEmpty()) {
                if (this.f2855d.isEmpty()) {
                    this.f2855d = alVar.f2849h;
                    this.f2852a &= -5;
                } else {
                    if ((this.f2852a & 4) != 4) {
                        this.f2855d = new C1016t(this.f2855d);
                        this.f2852a |= 4;
                    }
                    this.f2855d.addAll(alVar.f2849h);
                }
            }
            mo4007a(mo4009c().mo3967a(alVar.f2845d));
        }
        return this;
    }

    /* renamed from: d */
    public final /* synthetic */ C1020x mo4028d() {
        C1046al h = m4628h();
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
