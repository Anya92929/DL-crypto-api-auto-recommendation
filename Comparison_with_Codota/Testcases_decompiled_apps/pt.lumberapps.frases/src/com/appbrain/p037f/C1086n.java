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
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* renamed from: com.appbrain.f.n */
public final class C1086n extends C1011o implements C1089q {

    /* renamed from: b */
    public static C0986aa f3024b = new C1087o();

    /* renamed from: c */
    private static final C1086n f3025c;
    /* access modifiers changed from: private */

    /* renamed from: d */
    public final C1002f f3026d;
    /* access modifiers changed from: private */

    /* renamed from: e */
    public int f3027e;
    /* access modifiers changed from: private */

    /* renamed from: f */
    public List f3028f;
    /* access modifiers changed from: private */

    /* renamed from: g */
    public List f3029g;
    /* access modifiers changed from: private */

    /* renamed from: h */
    public boolean f3030h;
    /* access modifiers changed from: private */

    /* renamed from: i */
    public boolean f3031i;

    /* renamed from: j */
    private byte f3032j;

    /* renamed from: k */
    private int f3033k;

    static {
        C1086n nVar = new C1086n();
        f3025c = nVar;
        nVar.m4985o();
    }

    private C1086n() {
        this.f3032j = -1;
        this.f3033k = -1;
        this.f3026d = C1002f.f2629a;
    }

    private C1086n(C1006j jVar, C1010n nVar) {
        boolean z = false;
        this.f3032j = -1;
        this.f3033k = -1;
        m4985o();
        C1005i g = C1002f.m4164g();
        C1008l a = C1008l.m4211a((OutputStream) g);
        boolean z2 = false;
        while (!z) {
            try {
                int a2 = jVar.mo3978a();
                switch (a2) {
                    case 0:
                        z = true;
                        break;
                    case 10:
                        if (!z2 || !true) {
                            this.f3028f = new ArrayList();
                            z2 |= true;
                        }
                        this.f3028f.add(jVar.mo3979a(C1090r.f3039b, nVar));
                        break;
                    case 18:
                        if (!(z2 & true)) {
                            this.f3029g = new ArrayList();
                            z2 |= true;
                        }
                        this.f3029g.add(jVar.mo3979a(C1090r.f3039b, nVar));
                        break;
                    case 24:
                        this.f3027e |= 1;
                        this.f3030h = jVar.mo3987e();
                        break;
                    case 32:
                        this.f3027e |= 2;
                        this.f3031i = jVar.mo3987e();
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
                if (z2 && true) {
                    this.f3028f = Collections.unmodifiableList(this.f3028f);
                }
                if (z2 & true) {
                    this.f3029g = Collections.unmodifiableList(this.f3029g);
                }
                try {
                    a.mo3992a();
                } catch (IOException e3) {
                } finally {
                    this.f3026d = g.mo3974a();
                }
                throw th;
            }
        }
        if (z2 && true) {
            this.f3028f = Collections.unmodifiableList(this.f3028f);
        }
        if (z2 & true) {
            this.f3029g = Collections.unmodifiableList(this.f3029g);
        }
        try {
            a.mo3992a();
        } catch (IOException e4) {
        } finally {
            this.f3026d = g.mo3974a();
        }
    }

    /* synthetic */ C1086n(C1006j jVar, C1010n nVar, byte b) {
        this(jVar, nVar);
    }

    private C1086n(C1012p pVar) {
        super((byte) 0);
        this.f3032j = -1;
        this.f3033k = -1;
        this.f3026d = pVar.mo4009c();
    }

    /* synthetic */ C1086n(C1012p pVar, byte b) {
        this(pVar);
    }

    /* renamed from: a */
    public static C1088p m4976a(C1086n nVar) {
        return C1088p.m4999g().mo4352a(nVar);
    }

    /* renamed from: f */
    public static C1086n m4984f() {
        return f3025c;
    }

    /* renamed from: o */
    private void m4985o() {
        this.f3028f = Collections.emptyList();
        this.f3029g = Collections.emptyList();
        this.f3030h = false;
        this.f3031i = false;
    }

    /* renamed from: a */
    public final void mo4025a(C1008l lVar) {
        mo4026c();
        for (int i = 0; i < this.f3028f.size(); i++) {
            lVar.mo3997a(1, (C1020x) this.f3028f.get(i));
        }
        for (int i2 = 0; i2 < this.f3029g.size(); i2++) {
            lVar.mo3997a(2, (C1020x) this.f3029g.get(i2));
        }
        if ((this.f3027e & 1) == 1) {
            lVar.mo3998a(3, this.f3030h);
        }
        if ((this.f3027e & 2) == 2) {
            lVar.mo3998a(4, this.f3031i);
        }
        lVar.mo4003c(this.f3026d);
    }

    /* renamed from: c */
    public final int mo4026c() {
        int i = this.f3033k;
        if (i != -1) {
            return i;
        }
        int i2 = 0;
        for (int i3 = 0; i3 < this.f3028f.size(); i3++) {
            i2 += C1008l.m4217b(1, (C1020x) this.f3028f.get(i3));
        }
        for (int i4 = 0; i4 < this.f3029g.size(); i4++) {
            i2 += C1008l.m4217b(2, (C1020x) this.f3029g.get(i4));
        }
        if ((this.f3027e & 1) == 1) {
            i2 += C1008l.m4214b(3);
        }
        if ((this.f3027e & 2) == 2) {
            i2 += C1008l.m4214b(4);
        }
        int a = this.f3026d.mo3919a() + i2;
        this.f3033k = a;
        return a;
    }

    /* renamed from: d */
    public final /* synthetic */ C1021y mo4027d() {
        return C1088p.m4999g().mo4352a(this);
    }

    /* renamed from: e */
    public final boolean mo4029e() {
        byte b = this.f3032j;
        if (b == 1) {
            return true;
        }
        if (b == 0) {
            return false;
        }
        this.f3032j = 1;
        return true;
    }

    /* renamed from: g */
    public final List mo4344g() {
        return this.f3028f;
    }

    /* renamed from: h */
    public final int mo4345h() {
        return this.f3028f.size();
    }

    /* renamed from: i */
    public final List mo4346i() {
        return this.f3029g;
    }

    /* renamed from: j */
    public final int mo4347j() {
        return this.f3029g.size();
    }

    /* renamed from: k */
    public final boolean mo4348k() {
        return (this.f3027e & 1) == 1;
    }

    /* renamed from: l */
    public final boolean mo4349l() {
        return this.f3030h;
    }

    /* renamed from: m */
    public final boolean mo4350m() {
        return (this.f3027e & 2) == 2;
    }

    /* renamed from: n */
    public final boolean mo4351n() {
        return this.f3031i;
    }
}
