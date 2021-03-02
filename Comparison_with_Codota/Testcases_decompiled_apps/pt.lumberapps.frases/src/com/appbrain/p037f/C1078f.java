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

/* renamed from: com.appbrain.f.f */
public final class C1078f extends C1011o implements C1081i {

    /* renamed from: b */
    public static C0986aa f3002b = new C1079g();

    /* renamed from: c */
    private static final C1078f f3003c;
    /* access modifiers changed from: private */

    /* renamed from: d */
    public final C1002f f3004d;
    /* access modifiers changed from: private */

    /* renamed from: e */
    public int f3005e;
    /* access modifiers changed from: private */

    /* renamed from: f */
    public Object f3006f;
    /* access modifiers changed from: private */

    /* renamed from: g */
    public int f3007g;
    /* access modifiers changed from: private */

    /* renamed from: h */
    public long f3008h;

    /* renamed from: i */
    private byte f3009i;

    /* renamed from: j */
    private int f3010j;

    static {
        C1078f fVar = new C1078f();
        f3003c = fVar;
        fVar.m4932n();
    }

    private C1078f() {
        this.f3009i = -1;
        this.f3010j = -1;
        this.f3004d = C1002f.f2629a;
    }

    private C1078f(C1006j jVar) {
        this.f3009i = -1;
        this.f3010j = -1;
        m4932n();
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
                        this.f3005e |= 1;
                        this.f3006f = f;
                        break;
                    case 16:
                        this.f3005e |= 2;
                        this.f3007g = jVar.mo3986d();
                        break;
                    case 24:
                        this.f3005e |= 4;
                        this.f3008h = jVar.mo3984c();
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
                    this.f3004d = g.mo3974a();
                }
                throw th;
            }
        }
        try {
            a.mo3992a();
        } catch (IOException e4) {
        } finally {
            this.f3004d = g.mo3974a();
        }
    }

    /* synthetic */ C1078f(C1006j jVar, byte b) {
        this(jVar);
    }

    private C1078f(C1012p pVar) {
        super((byte) 0);
        this.f3009i = -1;
        this.f3010j = -1;
        this.f3004d = pVar.mo4009c();
    }

    /* synthetic */ C1078f(C1012p pVar, byte b) {
        this(pVar);
    }

    /* renamed from: f */
    public static C1078f m4929f() {
        return f3003c;
    }

    /* renamed from: l */
    public static C1080h m4930l() {
        return C1080h.m4943g();
    }

    /* renamed from: m */
    private C1002f m4931m() {
        Object obj = this.f3006f;
        if (!(obj instanceof String)) {
            return (C1002f) obj;
        }
        C1002f a = C1002f.m4159a((String) obj);
        this.f3006f = a;
        return a;
    }

    /* renamed from: n */
    private void m4932n() {
        this.f3006f = "";
        this.f3007g = 0;
        this.f3008h = 0;
    }

    /* renamed from: a */
    public final void mo4025a(C1008l lVar) {
        mo4026c();
        if ((this.f3005e & 1) == 1) {
            lVar.mo3996a(1, m4931m());
        }
        if ((this.f3005e & 2) == 2) {
            lVar.mo3994a(2, this.f3007g);
        }
        if ((this.f3005e & 4) == 4) {
            lVar.mo3995a(3, this.f3008h);
        }
        lVar.mo4003c(this.f3004d);
    }

    /* renamed from: c */
    public final int mo4026c() {
        int i = this.f3010j;
        if (i != -1) {
            return i;
        }
        int i2 = 0;
        if ((this.f3005e & 1) == 1) {
            i2 = C1008l.m4216b(1, m4931m()) + 0;
        }
        if ((this.f3005e & 2) == 2) {
            i2 += C1008l.m4220c(2, this.f3007g);
        }
        if ((this.f3005e & 4) == 4) {
            i2 += C1008l.m4215b(3, this.f3008h);
        }
        int a = i2 + this.f3004d.mo3919a();
        this.f3010j = a;
        return a;
    }

    /* renamed from: d */
    public final /* synthetic */ C1021y mo4027d() {
        return C1080h.m4943g().mo4338a(this);
    }

    /* renamed from: e */
    public final boolean mo4029e() {
        byte b = this.f3009i;
        if (b == 1) {
            return true;
        }
        if (b == 0) {
            return false;
        }
        this.f3009i = 1;
        return true;
    }

    /* renamed from: g */
    public final boolean mo4331g() {
        return (this.f3005e & 1) == 1;
    }

    /* renamed from: h */
    public final boolean mo4332h() {
        return (this.f3005e & 2) == 2;
    }

    /* renamed from: i */
    public final int mo4333i() {
        return this.f3007g;
    }

    /* renamed from: j */
    public final boolean mo4334j() {
        return (this.f3005e & 4) == 4;
    }

    /* renamed from: k */
    public final long mo4335k() {
        return this.f3008h;
    }
}
