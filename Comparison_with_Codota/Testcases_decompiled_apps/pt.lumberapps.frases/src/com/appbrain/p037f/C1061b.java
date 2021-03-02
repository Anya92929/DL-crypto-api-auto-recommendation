package com.appbrain.p037f;

import android.support.p021v7.p023b.C0515k;
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

/* renamed from: com.appbrain.f.b */
public final class C1061b extends C1011o implements C1077e {

    /* renamed from: b */
    public static C0986aa f2930b = new C1075c();

    /* renamed from: c */
    private static final C1061b f2931c;
    /* access modifiers changed from: private */

    /* renamed from: d */
    public final C1002f f2932d;
    /* access modifiers changed from: private */

    /* renamed from: e */
    public int f2933e;
    /* access modifiers changed from: private */

    /* renamed from: f */
    public int f2934f;
    /* access modifiers changed from: private */

    /* renamed from: g */
    public int f2935g;
    /* access modifiers changed from: private */

    /* renamed from: h */
    public Object f2936h;

    /* renamed from: i */
    private byte f2937i;

    /* renamed from: j */
    private int f2938j;

    static {
        C1061b bVar = new C1061b();
        f2931c = bVar;
        bVar.m4751n();
    }

    private C1061b() {
        this.f2937i = -1;
        this.f2938j = -1;
        this.f2932d = C1002f.f2629a;
    }

    private C1061b(C1006j jVar) {
        this.f2937i = -1;
        this.f2938j = -1;
        m4751n();
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
                    case 16:
                        this.f2933e |= 1;
                        this.f2934f = jVar.mo3986d();
                        break;
                    case 24:
                        this.f2933e |= 2;
                        this.f2935g = jVar.mo3986d();
                        break;
                    case C0515k.AppCompatTheme_actionModePasteDrawable:
                        C1002f f = jVar.mo3988f();
                        this.f2933e |= 4;
                        this.f2936h = f;
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
                    this.f2932d = g.mo3974a();
                }
                throw th;
            }
        }
        try {
            a.mo3992a();
        } catch (IOException e4) {
        } finally {
            this.f2932d = g.mo3974a();
        }
    }

    /* synthetic */ C1061b(C1006j jVar, byte b) {
        this(jVar);
    }

    private C1061b(C1012p pVar) {
        super((byte) 0);
        this.f2937i = -1;
        this.f2938j = -1;
        this.f2932d = pVar.mo4009c();
    }

    /* synthetic */ C1061b(C1012p pVar, byte b) {
        this(pVar);
    }

    /* renamed from: f */
    public static C1061b m4748f() {
        return f2931c;
    }

    /* renamed from: l */
    public static C1076d m4749l() {
        return C1076d.m4912g();
    }

    /* renamed from: m */
    private C1002f m4750m() {
        Object obj = this.f2936h;
        if (!(obj instanceof String)) {
            return (C1002f) obj;
        }
        C1002f a = C1002f.m4159a((String) obj);
        this.f2936h = a;
        return a;
    }

    /* renamed from: n */
    private void m4751n() {
        this.f2934f = 0;
        this.f2935g = 0;
        this.f2936h = "";
    }

    /* renamed from: a */
    public final void mo4025a(C1008l lVar) {
        mo4026c();
        if ((this.f2933e & 1) == 1) {
            lVar.mo3994a(2, this.f2934f);
        }
        if ((this.f2933e & 2) == 2) {
            lVar.mo3994a(3, this.f2935g);
        }
        if ((this.f2933e & 4) == 4) {
            lVar.mo3996a(4, m4750m());
        }
        lVar.mo4003c(this.f2932d);
    }

    /* renamed from: c */
    public final int mo4026c() {
        int i = this.f2938j;
        if (i != -1) {
            return i;
        }
        int i2 = 0;
        if ((this.f2933e & 1) == 1) {
            i2 = C1008l.m4220c(2, this.f2934f) + 0;
        }
        if ((this.f2933e & 2) == 2) {
            i2 += C1008l.m4220c(3, this.f2935g);
        }
        if ((this.f2933e & 4) == 4) {
            i2 += C1008l.m4216b(4, m4750m());
        }
        int a = i2 + this.f2932d.mo3919a();
        this.f2938j = a;
        return a;
    }

    /* renamed from: d */
    public final /* synthetic */ C1021y mo4027d() {
        return C1076d.m4912g().mo4328a(this);
    }

    /* renamed from: e */
    public final boolean mo4029e() {
        byte b = this.f2937i;
        if (b == 1) {
            return true;
        }
        if (b == 0) {
            return false;
        }
        this.f2937i = 1;
        return true;
    }

    @Deprecated
    /* renamed from: g */
    public final boolean mo4259g() {
        return (this.f2933e & 1) == 1;
    }

    @Deprecated
    /* renamed from: h */
    public final int mo4260h() {
        return this.f2934f;
    }

    /* renamed from: i */
    public final boolean mo4261i() {
        return (this.f2933e & 2) == 2;
    }

    /* renamed from: j */
    public final int mo4262j() {
        return this.f2935g;
    }

    /* renamed from: k */
    public final boolean mo4263k() {
        return (this.f2933e & 4) == 4;
    }
}
