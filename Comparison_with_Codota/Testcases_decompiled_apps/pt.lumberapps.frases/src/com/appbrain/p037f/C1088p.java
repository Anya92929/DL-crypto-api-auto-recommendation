package com.appbrain.p037f;

import com.appbrain.p033b.C0992ag;
import com.appbrain.p033b.C1012p;
import com.appbrain.p033b.C1020x;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* renamed from: com.appbrain.f.p */
public final class C1088p extends C1012p implements C1089q {

    /* renamed from: a */
    private int f3034a;

    /* renamed from: b */
    private List f3035b = Collections.emptyList();

    /* renamed from: c */
    private List f3036c = Collections.emptyList();

    /* renamed from: d */
    private boolean f3037d;

    /* renamed from: e */
    private boolean f3038e;

    private C1088p() {
    }

    /* renamed from: g */
    static /* synthetic */ C1088p m4999g() {
        return new C1088p();
    }

    /* access modifiers changed from: private */
    /* renamed from: h */
    public C1088p clone() {
        return new C1088p().mo4352a(mo4353f());
    }

    /* renamed from: a */
    public final C1088p mo4352a(C1086n nVar) {
        if (nVar != C1086n.m4984f()) {
            if (!nVar.f3028f.isEmpty()) {
                if (this.f3035b.isEmpty()) {
                    this.f3035b = nVar.f3028f;
                    this.f3034a &= -2;
                } else {
                    if ((this.f3034a & 1) != 1) {
                        this.f3035b = new ArrayList(this.f3035b);
                        this.f3034a |= 1;
                    }
                    this.f3035b.addAll(nVar.f3028f);
                }
            }
            if (!nVar.f3029g.isEmpty()) {
                if (this.f3036c.isEmpty()) {
                    this.f3036c = nVar.f3029g;
                    this.f3034a &= -3;
                } else {
                    if ((this.f3034a & 2) != 2) {
                        this.f3036c = new ArrayList(this.f3036c);
                        this.f3034a |= 2;
                    }
                    this.f3036c.addAll(nVar.f3029g);
                }
            }
            if (nVar.mo4348k()) {
                boolean l = nVar.mo4349l();
                this.f3034a |= 4;
                this.f3037d = l;
            }
            if (nVar.mo4350m()) {
                boolean n = nVar.mo4351n();
                this.f3034a |= 8;
                this.f3038e = n;
            }
            mo4007a(mo4009c().mo3967a(nVar.f3026d));
        }
        return this;
    }

    /* renamed from: d */
    public final /* synthetic */ C1020x mo4028d() {
        C1086n f = mo4353f();
        if (f.mo4029e()) {
            return f;
        }
        throw new C0992ag();
    }

    /* renamed from: e */
    public final boolean mo4029e() {
        return true;
    }

    /* renamed from: f */
    public final C1086n mo4353f() {
        int i = 1;
        C1086n nVar = new C1086n((C1012p) this, (byte) 0);
        int i2 = this.f3034a;
        if ((this.f3034a & 1) == 1) {
            this.f3035b = Collections.unmodifiableList(this.f3035b);
            this.f3034a &= -2;
        }
        List unused = nVar.f3028f = this.f3035b;
        if ((this.f3034a & 2) == 2) {
            this.f3036c = Collections.unmodifiableList(this.f3036c);
            this.f3034a &= -3;
        }
        List unused2 = nVar.f3029g = this.f3036c;
        if ((i2 & 4) != 4) {
            i = 0;
        }
        boolean unused3 = nVar.f3030h = this.f3037d;
        if ((i2 & 8) == 8) {
            i |= 2;
        }
        boolean unused4 = nVar.f3031i = this.f3038e;
        int unused5 = nVar.f3027e = i;
        return nVar;
    }
}
