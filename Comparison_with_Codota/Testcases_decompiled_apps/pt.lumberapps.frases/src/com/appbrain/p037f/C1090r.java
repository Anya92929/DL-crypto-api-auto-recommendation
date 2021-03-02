package com.appbrain.p037f;

import com.appbrain.p033b.C0986aa;
import com.appbrain.p033b.C1002f;
import com.appbrain.p033b.C1005i;
import com.appbrain.p033b.C1006j;
import com.appbrain.p033b.C1008l;
import com.appbrain.p033b.C1011o;
import com.appbrain.p033b.C1012p;
import com.appbrain.p033b.C1015s;
import com.appbrain.p033b.C1021y;
import java.io.IOException;
import java.io.OutputStream;

/* renamed from: com.appbrain.f.r */
public final class C1090r extends C1011o implements C1093u {

    /* renamed from: b */
    public static C0986aa f3039b = new C1091s();

    /* renamed from: c */
    private static final C1090r f3040c;
    /* access modifiers changed from: private */

    /* renamed from: d */
    public final C1002f f3041d;
    /* access modifiers changed from: private */

    /* renamed from: e */
    public int f3042e;
    /* access modifiers changed from: private */

    /* renamed from: f */
    public Object f3043f;
    /* access modifiers changed from: private */

    /* renamed from: g */
    public Object f3044g;
    /* access modifiers changed from: private */

    /* renamed from: h */
    public boolean f3045h;

    /* renamed from: i */
    private byte f3046i;

    /* renamed from: j */
    private int f3047j;

    static {
        C1090r rVar = new C1090r();
        f3040c = rVar;
        rVar.m5017o();
    }

    private C1090r() {
        this.f3046i = -1;
        this.f3047j = -1;
        this.f3041d = C1002f.f2629a;
    }

    private C1090r(C1006j jVar) {
        this.f3046i = -1;
        this.f3047j = -1;
        m5017o();
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
                        C1002f f = jVar.mo3988f();
                        this.f3042e |= 1;
                        this.f3043f = f;
                        break;
                    case 18:
                        C1002f f2 = jVar.mo3988f();
                        this.f3042e |= 2;
                        this.f3044g = f2;
                        break;
                    case 32:
                        this.f3042e |= 4;
                        this.f3045h = jVar.mo3987e();
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
                    this.f3041d = g.mo3974a();
                }
                throw th;
            }
        }
        try {
            a.mo3992a();
        } catch (IOException e4) {
        } finally {
            this.f3041d = g.mo3974a();
        }
    }

    /* synthetic */ C1090r(C1006j jVar, byte b) {
        this(jVar);
    }

    private C1090r(C1012p pVar) {
        super((byte) 0);
        this.f3046i = -1;
        this.f3047j = -1;
        this.f3041d = pVar.mo4009c();
    }

    /* synthetic */ C1090r(C1012p pVar, byte b) {
        this(pVar);
    }

    /* renamed from: f */
    public static C1090r m5014f() {
        return f3040c;
    }

    /* renamed from: m */
    private C1002f m5015m() {
        Object obj = this.f3043f;
        if (!(obj instanceof String)) {
            return (C1002f) obj;
        }
        C1002f a = C1002f.m4159a((String) obj);
        this.f3043f = a;
        return a;
    }

    /* renamed from: n */
    private C1002f m5016n() {
        Object obj = this.f3044g;
        if (!(obj instanceof String)) {
            return (C1002f) obj;
        }
        C1002f a = C1002f.m4159a((String) obj);
        this.f3044g = a;
        return a;
    }

    /* renamed from: o */
    private void m5017o() {
        this.f3043f = "";
        this.f3044g = "";
        this.f3045h = false;
    }

    /* renamed from: a */
    public final void mo4025a(C1008l lVar) {
        mo4026c();
        if ((this.f3042e & 1) == 1) {
            lVar.mo3996a(1, m5015m());
        }
        if ((this.f3042e & 2) == 2) {
            lVar.mo3996a(2, m5016n());
        }
        if ((this.f3042e & 4) == 4) {
            lVar.mo3998a(4, this.f3045h);
        }
        lVar.mo4003c(this.f3041d);
    }

    /* renamed from: c */
    public final int mo4026c() {
        int i = this.f3047j;
        if (i != -1) {
            return i;
        }
        int i2 = 0;
        if ((this.f3042e & 1) == 1) {
            i2 = C1008l.m4216b(1, m5015m()) + 0;
        }
        if ((this.f3042e & 2) == 2) {
            i2 += C1008l.m4216b(2, m5016n());
        }
        if ((this.f3042e & 4) == 4) {
            i2 += C1008l.m4214b(4);
        }
        int a = i2 + this.f3041d.mo3919a();
        this.f3047j = a;
        return a;
    }

    /* renamed from: d */
    public final /* synthetic */ C1021y mo4027d() {
        return C1092t.m5029f().mo4360a(this);
    }

    /* renamed from: e */
    public final boolean mo4029e() {
        byte b = this.f3046i;
        if (b == 1) {
            return true;
        }
        if (b == 0) {
            return false;
        }
        this.f3046i = 1;
        return true;
    }

    /* renamed from: g */
    public final boolean mo4354g() {
        return (this.f3042e & 1) == 1;
    }

    /* renamed from: h */
    public final String mo4355h() {
        Object obj = this.f3043f;
        if (obj instanceof String) {
            return (String) obj;
        }
        C1002f fVar = (C1002f) obj;
        String e = fVar.mo3970e();
        if (fVar.mo3927f()) {
            this.f3043f = e;
        }
        return e;
    }

    /* renamed from: i */
    public final boolean mo4356i() {
        return (this.f3042e & 2) == 2;
    }

    /* renamed from: j */
    public final String mo4357j() {
        Object obj = this.f3044g;
        if (obj instanceof String) {
            return (String) obj;
        }
        C1002f fVar = (C1002f) obj;
        String e = fVar.mo3970e();
        if (fVar.mo3927f()) {
            this.f3044g = e;
        }
        return e;
    }

    /* renamed from: k */
    public final boolean mo4358k() {
        return (this.f3042e & 4) == 4;
    }

    /* renamed from: l */
    public final boolean mo4359l() {
        return this.f3045h;
    }
}
