package com.appbrain.p037f;

import android.support.p021v7.p023b.C0515k;
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

/* renamed from: com.appbrain.f.ap */
public final class C1050ap extends C1011o implements C1053as {

    /* renamed from: b */
    public static C0986aa f2856b = new C1051aq();

    /* renamed from: c */
    private static final C1050ap f2857c;
    /* access modifiers changed from: private */

    /* renamed from: d */
    public final C1002f f2858d;
    /* access modifiers changed from: private */

    /* renamed from: e */
    public int f2859e;
    /* access modifiers changed from: private */

    /* renamed from: f */
    public C1035aa f2860f;
    /* access modifiers changed from: private */

    /* renamed from: g */
    public C1054at f2861g;
    /* access modifiers changed from: private */

    /* renamed from: h */
    public int f2862h;
    /* access modifiers changed from: private */

    /* renamed from: i */
    public boolean f2863i;
    /* access modifiers changed from: private */

    /* renamed from: j */
    public Object f2864j;
    /* access modifiers changed from: private */

    /* renamed from: k */
    public int f2865k;
    /* access modifiers changed from: private */

    /* renamed from: l */
    public int f2866l;

    /* renamed from: m */
    private byte f2867m;

    /* renamed from: n */
    private int f2868n;

    static {
        C1050ap apVar = new C1050ap();
        f2857c = apVar;
        apVar.m4647v();
    }

    private C1050ap() {
        this.f2867m = -1;
        this.f2868n = -1;
        this.f2858d = C1002f.f2629a;
    }

    private C1050ap(C1006j jVar, C1010n nVar) {
        this.f2867m = -1;
        this.f2868n = -1;
        m4647v();
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
                        C1037ac aE = (this.f2859e & 1) == 1 ? this.f2860f.mo4027d() : null;
                        this.f2860f = (C1035aa) jVar.mo3979a(C1035aa.f2695b, nVar);
                        if (aE != null) {
                            aE.mo4139a(this.f2860f);
                            this.f2860f = aE.mo4163g();
                        }
                        this.f2859e |= 1;
                        break;
                    case C0515k.AppCompatTheme_spinnerDropDownItemStyle:
                        int g2 = jVar.mo3989g();
                        C1054at a3 = C1054at.m4682a(g2);
                        if (a3 != null) {
                            this.f2859e |= 2;
                            this.f2861g = a3;
                            break;
                        } else {
                            a.mo4005e(a2);
                            a.mo4005e(g2);
                            break;
                        }
                    case C0515k.AppCompatTheme_dividerVertical:
                        this.f2859e |= 4;
                        this.f2862h = jVar.mo3986d();
                        break;
                    case 64:
                        this.f2859e |= 8;
                        this.f2863i = jVar.mo3987e();
                        break;
                    case C0515k.AppCompatTheme_listPreferredItemPaddingRight:
                        C1002f f = jVar.mo3988f();
                        this.f2859e |= 16;
                        this.f2864j = f;
                        break;
                    case C0515k.AppCompatTheme_panelMenuListWidth:
                        this.f2859e |= 32;
                        this.f2865k = jVar.mo3986d();
                        break;
                    case C0515k.AppCompatTheme_colorControlHighlight:
                        this.f2859e |= 64;
                        this.f2866l = jVar.mo3986d();
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
                    this.f2858d = g.mo3974a();
                }
                throw th;
            }
        }
        try {
            a.mo3992a();
        } catch (IOException e4) {
        } finally {
            this.f2858d = g.mo3974a();
        }
    }

    /* synthetic */ C1050ap(C1006j jVar, C1010n nVar, byte b) {
        this(jVar, nVar);
    }

    private C1050ap(C1012p pVar) {
        super((byte) 0);
        this.f2867m = -1;
        this.f2868n = -1;
        this.f2858d = pVar.mo4009c();
    }

    /* synthetic */ C1050ap(C1012p pVar, byte b) {
        this(pVar);
    }

    /* renamed from: f */
    public static C1050ap m4644f() {
        return f2857c;
    }

    /* renamed from: t */
    public static C1052ar m4645t() {
        return C1052ar.m4666g();
    }

    /* renamed from: u */
    private C1002f m4646u() {
        Object obj = this.f2864j;
        if (!(obj instanceof String)) {
            return (C1002f) obj;
        }
        C1002f a = C1002f.m4159a((String) obj);
        this.f2864j = a;
        return a;
    }

    /* renamed from: v */
    private void m4647v() {
        this.f2860f = C1035aa.m4359f();
        this.f2861g = C1054at.UNKNOWN_SOURCE;
        this.f2862h = 0;
        this.f2863i = false;
        this.f2864j = "";
        this.f2865k = 0;
        this.f2866l = 0;
    }

    /* renamed from: a */
    public final void mo4025a(C1008l lVar) {
        mo4026c();
        if ((this.f2859e & 1) == 1) {
            lVar.mo3997a(1, (C1020x) this.f2860f);
        }
        if ((this.f2859e & 2) == 2) {
            lVar.mo4002b(6, this.f2861g.mo4236a());
        }
        if ((this.f2859e & 4) == 4) {
            lVar.mo3994a(7, this.f2862h);
        }
        if ((this.f2859e & 8) == 8) {
            lVar.mo3998a(8, this.f2863i);
        }
        if ((this.f2859e & 16) == 16) {
            lVar.mo3996a(9, m4646u());
        }
        if ((this.f2859e & 32) == 32) {
            lVar.mo3994a(10, this.f2865k);
        }
        if ((this.f2859e & 64) == 64) {
            lVar.mo3994a(11, this.f2866l);
        }
        lVar.mo4003c(this.f2858d);
    }

    /* renamed from: c */
    public final int mo4026c() {
        int i = this.f2868n;
        if (i != -1) {
            return i;
        }
        int i2 = 0;
        if ((this.f2859e & 1) == 1) {
            i2 = C1008l.m4217b(1, (C1020x) this.f2860f) + 0;
        }
        if ((this.f2859e & 2) == 2) {
            i2 += C1008l.m4222d(6, this.f2861g.mo4236a());
        }
        if ((this.f2859e & 4) == 4) {
            i2 += C1008l.m4220c(7, this.f2862h);
        }
        if ((this.f2859e & 8) == 8) {
            i2 += C1008l.m4214b(8);
        }
        if ((this.f2859e & 16) == 16) {
            i2 += C1008l.m4216b(9, m4646u());
        }
        if ((this.f2859e & 32) == 32) {
            i2 += C1008l.m4220c(10, this.f2865k);
        }
        if ((this.f2859e & 64) == 64) {
            i2 += C1008l.m4220c(11, this.f2866l);
        }
        int a = i2 + this.f2858d.mo3919a();
        this.f2868n = a;
        return a;
    }

    /* renamed from: d */
    public final /* synthetic */ C1021y mo4027d() {
        return C1052ar.m4666g().mo4229a(this);
    }

    /* renamed from: e */
    public final boolean mo4029e() {
        byte b = this.f2867m;
        if (b == 1) {
            return true;
        }
        if (b == 0) {
            return false;
        }
        this.f2867m = 1;
        return true;
    }

    /* renamed from: g */
    public final boolean mo4214g() {
        return (this.f2859e & 1) == 1;
    }

    /* renamed from: h */
    public final C1035aa mo4215h() {
        return this.f2860f;
    }

    /* renamed from: i */
    public final boolean mo4216i() {
        return (this.f2859e & 2) == 2;
    }

    /* renamed from: j */
    public final C1054at mo4217j() {
        return this.f2861g;
    }

    /* renamed from: k */
    public final boolean mo4218k() {
        return (this.f2859e & 4) == 4;
    }

    /* renamed from: l */
    public final int mo4219l() {
        return this.f2862h;
    }

    /* renamed from: m */
    public final boolean mo4220m() {
        return (this.f2859e & 8) == 8;
    }

    /* renamed from: n */
    public final boolean mo4221n() {
        return this.f2863i;
    }

    /* renamed from: o */
    public final boolean mo4222o() {
        return (this.f2859e & 16) == 16;
    }

    /* renamed from: p */
    public final boolean mo4223p() {
        return (this.f2859e & 32) == 32;
    }

    /* renamed from: q */
    public final int mo4224q() {
        return this.f2865k;
    }

    /* renamed from: r */
    public final boolean mo4225r() {
        return (this.f2859e & 64) == 64;
    }

    /* renamed from: s */
    public final int mo4226s() {
        return this.f2866l;
    }
}
