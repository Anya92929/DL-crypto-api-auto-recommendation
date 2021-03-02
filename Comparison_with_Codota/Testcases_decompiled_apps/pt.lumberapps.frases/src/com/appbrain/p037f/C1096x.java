package com.appbrain.p037f;

import com.appbrain.p033b.C0992ag;
import com.appbrain.p033b.C1012p;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* renamed from: com.appbrain.f.x */
public final class C1096x extends C1012p implements C1097y {

    /* renamed from: a */
    private int f3063a;

    /* renamed from: b */
    private C1035aa f3064b = C1035aa.m4359f();

    /* renamed from: c */
    private boolean f3065c;

    /* renamed from: d */
    private List f3066d = Collections.emptyList();

    /* renamed from: e */
    private boolean f3067e;

    /* renamed from: f */
    private List f3068f = Collections.emptyList();

    private C1096x() {
    }

    /* renamed from: g */
    static /* synthetic */ C1096x m5062g() {
        return new C1096x();
    }

    /* access modifiers changed from: private */
    /* renamed from: h */
    public C1096x clone() {
        return new C1096x().mo4371a(m5064i());
    }

    /* renamed from: i */
    private C1094v m5064i() {
        int i = 1;
        C1094v vVar = new C1094v((C1012p) this, (byte) 0);
        int i2 = this.f3063a;
        if ((i2 & 1) != 1) {
            i = 0;
        }
        C1035aa unused = vVar.f3056f = this.f3064b;
        if ((i2 & 2) == 2) {
            i |= 2;
        }
        boolean unused2 = vVar.f3057g = this.f3065c;
        if ((this.f3063a & 4) == 4) {
            this.f3066d = Collections.unmodifiableList(this.f3066d);
            this.f3063a &= -5;
        }
        List unused3 = vVar.f3058h = this.f3066d;
        if ((i2 & 8) == 8) {
            i |= 4;
        }
        boolean unused4 = vVar.f3059i = this.f3067e;
        if ((this.f3063a & 16) == 16) {
            this.f3068f = Collections.unmodifiableList(this.f3068f);
            this.f3063a &= -17;
        }
        List unused5 = vVar.f3060j = this.f3068f;
        int unused6 = vVar.f3055e = i;
        return vVar;
    }

    /* renamed from: j */
    private void m5065j() {
        if ((this.f3063a & 4) != 4) {
            this.f3066d = new ArrayList(this.f3066d);
            this.f3063a |= 4;
        }
    }

    /* renamed from: k */
    private void m5066k() {
        if ((this.f3063a & 16) != 16) {
            this.f3068f = new ArrayList(this.f3068f);
            this.f3063a |= 16;
        }
    }

    /* renamed from: a */
    public final C1096x mo4368a(C1035aa aaVar) {
        if (aaVar == null) {
            throw new NullPointerException();
        }
        this.f3064b = aaVar;
        this.f3063a |= 1;
        return this;
    }

    /* renamed from: a */
    public final C1096x mo4369a(C1076d dVar) {
        m5065j();
        this.f3066d.add(dVar.mo4028d());
        return this;
    }

    /* renamed from: a */
    public final C1096x mo4370a(C1078f fVar) {
        if (fVar == null) {
            throw new NullPointerException();
        }
        m5066k();
        this.f3068f.add(fVar);
        return this;
    }

    /* renamed from: a */
    public final C1096x mo4371a(C1094v vVar) {
        if (vVar != C1094v.m5047f()) {
            if (vVar.mo4361g()) {
                C1035aa h = vVar.mo4362h();
                if ((this.f3063a & 1) != 1 || this.f3064b == C1035aa.m4359f()) {
                    this.f3064b = h;
                } else {
                    this.f3064b = C1035aa.m4313a(this.f3064b).mo4139a(h).mo4163g();
                }
                this.f3063a |= 1;
            }
            if (vVar.mo4363i()) {
                boolean j = vVar.mo4364j();
                this.f3063a |= 2;
                this.f3065c = j;
            }
            if (!vVar.f3058h.isEmpty()) {
                if (this.f3066d.isEmpty()) {
                    this.f3066d = vVar.f3058h;
                    this.f3063a &= -5;
                } else {
                    m5065j();
                    this.f3066d.addAll(vVar.f3058h);
                }
            }
            if (vVar.mo4365k()) {
                mo4372a(vVar.mo4366l());
            }
            if (!vVar.f3060j.isEmpty()) {
                if (this.f3068f.isEmpty()) {
                    this.f3068f = vVar.f3060j;
                    this.f3063a &= -17;
                } else {
                    m5066k();
                    this.f3068f.addAll(vVar.f3060j);
                }
            }
            mo4007a(mo4009c().mo3967a(vVar.f3054d));
        }
        return this;
    }

    /* renamed from: a */
    public final C1096x mo4372a(boolean z) {
        this.f3063a |= 8;
        this.f3067e = z;
        return this;
    }

    /* renamed from: e */
    public final boolean mo4029e() {
        return true;
    }

    /* renamed from: f */
    public final C1094v mo4028d() {
        C1094v i = m5064i();
        if (i.mo4029e()) {
            return i;
        }
        throw new C0992ag();
    }
}
