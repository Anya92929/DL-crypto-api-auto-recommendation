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
import com.appbrain.p033b.C1021y;
import java.io.IOException;
import java.io.OutputStream;

/* renamed from: com.appbrain.f.j */
public final class C1082j extends C1011o implements C1085m {

    /* renamed from: b */
    public static C0986aa f3015b = new C1083k();

    /* renamed from: c */
    private static final C1082j f3016c;
    /* access modifiers changed from: private */

    /* renamed from: d */
    public final C1002f f3017d;
    /* access modifiers changed from: private */

    /* renamed from: e */
    public int f3018e;
    /* access modifiers changed from: private */

    /* renamed from: f */
    public C1086n f3019f;

    /* renamed from: g */
    private byte f3020g;

    /* renamed from: h */
    private int f3021h;

    static {
        C1082j jVar = new C1082j();
        f3016c = jVar;
        jVar.f3019f = C1086n.m4984f();
    }

    private C1082j() {
        this.f3020g = -1;
        this.f3021h = -1;
        this.f3017d = C1002f.f2629a;
    }

    private C1082j(C1006j jVar, C1010n nVar) {
        this.f3020g = -1;
        this.f3021h = -1;
        this.f3019f = C1086n.m4984f();
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
                        C1088p a3 = (this.f3018e & 1) == 1 ? C1086n.m4976a(this.f3019f) : null;
                        this.f3019f = (C1086n) jVar.mo3979a(C1086n.f3024b, nVar);
                        if (a3 != null) {
                            a3.mo4352a(this.f3019f);
                            this.f3019f = a3.mo4353f();
                        }
                        this.f3018e |= 1;
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
                    this.f3017d = g.mo3974a();
                }
                throw th;
            }
        }
        try {
            a.mo3992a();
        } catch (IOException e4) {
        } finally {
            this.f3017d = g.mo3974a();
        }
    }

    /* synthetic */ C1082j(C1006j jVar, C1010n nVar, byte b) {
        this(jVar, nVar);
    }

    private C1082j(C1012p pVar) {
        super((byte) 0);
        this.f3020g = -1;
        this.f3021h = -1;
        this.f3017d = pVar.mo4009c();
    }

    /* synthetic */ C1082j(C1012p pVar, byte b) {
        this(pVar);
    }

    /* renamed from: a */
    public static C1082j m4957a(byte[] bArr) {
        return (C1082j) f3015b.mo3918a(bArr);
    }

    /* renamed from: f */
    public static C1082j m4959f() {
        return f3016c;
    }

    /* renamed from: a */
    public final void mo4025a(C1008l lVar) {
        mo4026c();
        if ((this.f3018e & 1) == 1) {
            lVar.mo3997a(1, (C1020x) this.f3019f);
        }
        lVar.mo4003c(this.f3017d);
    }

    /* renamed from: c */
    public final int mo4026c() {
        int i = this.f3021h;
        if (i != -1) {
            return i;
        }
        int i2 = 0;
        if ((this.f3018e & 1) == 1) {
            i2 = C1008l.m4217b(1, (C1020x) this.f3019f) + 0;
        }
        int a = i2 + this.f3017d.mo3919a();
        this.f3021h = a;
        return a;
    }

    /* renamed from: d */
    public final /* synthetic */ C1021y mo4027d() {
        return C1084l.m4967f().mo4343a(this);
    }

    /* renamed from: e */
    public final boolean mo4029e() {
        byte b = this.f3020g;
        if (b == 1) {
            return true;
        }
        if (b == 0) {
            return false;
        }
        this.f3020g = 1;
        return true;
    }

    /* renamed from: g */
    public final boolean mo4341g() {
        return (this.f3018e & 1) == 1;
    }

    /* renamed from: h */
    public final C1086n mo4342h() {
        return this.f3019f;
    }
}
