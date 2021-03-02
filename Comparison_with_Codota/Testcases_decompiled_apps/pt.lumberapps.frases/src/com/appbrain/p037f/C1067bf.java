package com.appbrain.p037f;

import com.appbrain.p033b.C0986aa;
import com.appbrain.p033b.C1002f;
import com.appbrain.p033b.C1005i;
import com.appbrain.p033b.C1006j;
import com.appbrain.p033b.C1008l;
import com.appbrain.p033b.C1010n;
import com.appbrain.p033b.C1011o;
import com.appbrain.p033b.C1012p;
import com.appbrain.p033b.C1015s;
import com.appbrain.p033b.C1020x;
import java.io.IOException;
import java.io.OutputStream;

/* renamed from: com.appbrain.f.bf */
public final class C1067bf extends C1011o implements C1070bi {

    /* renamed from: b */
    public static C0986aa f2964b = new C1068bg();

    /* renamed from: c */
    private static final C1067bf f2965c;
    /* access modifiers changed from: private */

    /* renamed from: d */
    public final C1002f f2966d;
    /* access modifiers changed from: private */

    /* renamed from: e */
    public int f2967e;
    /* access modifiers changed from: private */

    /* renamed from: f */
    public C1063bb f2968f;
    /* access modifiers changed from: private */

    /* renamed from: g */
    public boolean f2969g;
    /* access modifiers changed from: private */

    /* renamed from: h */
    public int f2970h;

    /* renamed from: i */
    private byte f2971i;

    /* renamed from: j */
    private int f2972j;

    static {
        C1067bf bfVar = new C1067bf();
        f2965c = bfVar;
        bfVar.m4831o();
    }

    private C1067bf() {
        this.f2971i = -1;
        this.f2972j = -1;
        this.f2966d = C1002f.f2629a;
    }

    private C1067bf(C1006j jVar, C1010n nVar) {
        this.f2971i = -1;
        this.f2972j = -1;
        m4831o();
        C1005i g = C1002f.m4164g();
        C1008l a = C1008l.m4211a((OutputStream) g);
        boolean z = false;
        while (!z) {
            try {
                int a2 = jVar.mo3978a();
                switch (a2) {
                    case 0:
                        z = true;
                        break;
                    case 10:
                        C1065bd y = (this.f2967e & 1) == 1 ? this.f2968f.mo4027d() : null;
                        this.f2968f = (C1063bb) jVar.mo3979a(C1063bb.f2939b, nVar);
                        if (y != null) {
                            y.mo4286a(this.f2968f);
                            this.f2968f = y.mo4293g();
                        }
                        this.f2967e |= 1;
                        break;
                    case 16:
                        this.f2967e |= 2;
                        this.f2969g = jVar.mo3987e();
                        break;
                    case 24:
                        this.f2967e |= 4;
                        this.f2970h = jVar.mo3986d();
                        break;
                    default:
                        if (jVar.mo3981a(a2, a)) {
                            break;
                        } else {
                            z = true;
                            break;
                        }
                }
            } catch (C1015s e) {
                throw e.mo4010a(this);
            } catch (IOException e2) {
                throw new C1015s(e2.getMessage()).mo4010a(this);
            } catch (Throwable th) {
                try {
                    a.mo3992a();
                } catch (IOException e3) {
                } finally {
                    this.f2966d = g.mo3974a();
                }
                throw th;
            }
        }
        try {
            a.mo3992a();
        } catch (IOException e4) {
        } finally {
            this.f2966d = g.mo3974a();
        }
    }

    /* synthetic */ C1067bf(C1006j jVar, C1010n nVar, byte b) {
        this(jVar, nVar);
    }

    private C1067bf(C1012p pVar) {
        super((byte) 0);
        this.f2971i = -1;
        this.f2972j = -1;
        this.f2966d = pVar.mo4009c();
    }

    /* synthetic */ C1067bf(C1012p pVar, byte b) {
        this(pVar);
    }

    /* renamed from: a */
    public static C1067bf m4826a(byte[] bArr) {
        return (C1067bf) f2964b.mo3918a(bArr);
    }

    /* renamed from: f */
    public static C1067bf m4829f() {
        return f2965c;
    }

    /* renamed from: m */
    public static C1069bh m4830m() {
        return C1069bh.m4844g();
    }

    /* renamed from: o */
    private void m4831o() {
        this.f2968f = C1063bb.m4779f();
        this.f2969g = false;
        this.f2970h = 0;
    }

    /* renamed from: a */
    public final void mo4025a(C1008l lVar) {
        mo4026c();
        if ((this.f2967e & 1) == 1) {
            lVar.mo3997a(1, (C1020x) this.f2968f);
        }
        if ((this.f2967e & 2) == 2) {
            lVar.mo3998a(2, this.f2969g);
        }
        if ((this.f2967e & 4) == 4) {
            lVar.mo3994a(3, this.f2970h);
        }
        lVar.mo4003c(this.f2966d);
    }

    /* renamed from: c */
    public final int mo4026c() {
        int i = this.f2972j;
        if (i != -1) {
            return i;
        }
        int i2 = 0;
        if ((this.f2967e & 1) == 1) {
            i2 = C1008l.m4217b(1, (C1020x) this.f2968f) + 0;
        }
        if ((this.f2967e & 2) == 2) {
            i2 += C1008l.m4214b(2);
        }
        if ((this.f2967e & 4) == 4) {
            i2 += C1008l.m4220c(3, this.f2970h);
        }
        int a = i2 + this.f2966d.mo3919a();
        this.f2972j = a;
        return a;
    }

    /* renamed from: e */
    public final boolean mo4029e() {
        byte b = this.f2971i;
        if (b == 1) {
            return true;
        }
        if (b == 0) {
            return false;
        }
        this.f2971i = 1;
        return true;
    }

    /* renamed from: g */
    public final boolean mo4294g() {
        return (this.f2967e & 1) == 1;
    }

    /* renamed from: h */
    public final C1063bb mo4295h() {
        return this.f2968f;
    }

    /* renamed from: i */
    public final boolean mo4296i() {
        return (this.f2967e & 2) == 2;
    }

    /* renamed from: j */
    public final boolean mo4297j() {
        return this.f2969g;
    }

    /* renamed from: k */
    public final boolean mo4298k() {
        return (this.f2967e & 4) == 4;
    }

    /* renamed from: l */
    public final int mo4299l() {
        return this.f2970h;
    }

    /* renamed from: n */
    public final C1069bh mo4027d() {
        return C1069bh.m4844g().mo4304a(this);
    }
}
