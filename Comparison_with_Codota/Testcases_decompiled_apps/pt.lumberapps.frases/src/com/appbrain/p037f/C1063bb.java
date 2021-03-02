package com.appbrain.p037f;

import android.support.p009v4.app.NotificationCompat;
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
import java.io.IOException;
import java.io.OutputStream;

/* renamed from: com.appbrain.f.bb */
public final class C1063bb extends C1011o implements C1066be {

    /* renamed from: b */
    public static C0986aa f2939b = new C1064bc();

    /* renamed from: c */
    private static final C1063bb f2940c;
    /* access modifiers changed from: private */

    /* renamed from: d */
    public final C1002f f2941d;
    /* access modifiers changed from: private */

    /* renamed from: e */
    public int f2942e;
    /* access modifiers changed from: private */

    /* renamed from: f */
    public C1035aa f2943f;
    /* access modifiers changed from: private */

    /* renamed from: g */
    public Object f2944g;
    /* access modifiers changed from: private */

    /* renamed from: h */
    public C1040af f2945h;
    /* access modifiers changed from: private */

    /* renamed from: i */
    public long f2946i;
    /* access modifiers changed from: private */

    /* renamed from: j */
    public long f2947j;
    /* access modifiers changed from: private */

    /* renamed from: k */
    public Object f2948k;
    /* access modifiers changed from: private */

    /* renamed from: l */
    public Object f2949l;
    /* access modifiers changed from: private */

    /* renamed from: m */
    public boolean f2950m;
    /* access modifiers changed from: private */

    /* renamed from: n */
    public int f2951n;

    /* renamed from: o */
    private byte f2952o;

    /* renamed from: p */
    private int f2953p;

    static {
        C1063bb bbVar = new C1063bb();
        f2940c = bbVar;
        bbVar.m4763C();
    }

    private C1063bb() {
        this.f2952o = -1;
        this.f2953p = -1;
        this.f2941d = C1002f.f2629a;
    }

    private C1063bb(C1006j jVar, C1010n nVar) {
        this.f2952o = -1;
        this.f2953p = -1;
        m4763C();
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
                        C1037ac aE = (this.f2942e & 1) == 1 ? this.f2943f.mo4027d() : null;
                        this.f2943f = (C1035aa) jVar.mo3979a(C1035aa.f2695b, nVar);
                        if (aE != null) {
                            aE.mo4139a(this.f2943f);
                            this.f2943f = aE.mo4163g();
                        }
                        this.f2942e |= 1;
                        break;
                    case 18:
                        C1002f f = jVar.mo3988f();
                        this.f2942e |= 2;
                        this.f2944g = f;
                        break;
                    case 32:
                        int g2 = jVar.mo3989g();
                        C1040af a3 = C1040af.m4541a(g2);
                        if (a3 != null) {
                            this.f2942e |= 4;
                            this.f2945h = a3;
                            break;
                        } else {
                            a.mo4005e(a2);
                            a.mo4005e(g2);
                            break;
                        }
                    case C0515k.AppCompatTheme_textAppearanceLargePopupMenu:
                        this.f2942e |= 8;
                        this.f2946i = jVar.mo3984c();
                        break;
                    case C0515k.AppCompatTheme_spinnerDropDownItemStyle:
                        this.f2942e |= 16;
                        this.f2947j = jVar.mo3984c();
                        break;
                    case C0515k.AppCompatTheme_activityChooserViewStyle:
                        C1002f f2 = jVar.mo3988f();
                        this.f2942e |= 32;
                        this.f2948k = f2;
                        break;
                    case C0515k.AppCompatTheme_textAppearanceSearchResultTitle:
                        C1002f f3 = jVar.mo3988f();
                        this.f2942e |= 64;
                        this.f2949l = f3;
                        break;
                    case C0515k.AppCompatTheme_listPreferredItemHeightLarge:
                        this.f2942e |= NotificationCompat.FLAG_HIGH_PRIORITY;
                        this.f2950m = jVar.mo3987e();
                        break;
                    case C0515k.AppCompatTheme_panelMenuListWidth:
                        this.f2942e |= NotificationCompat.FLAG_LOCAL_ONLY;
                        this.f2951n = jVar.mo3986d();
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
                    this.f2941d = g.mo3974a();
                }
                throw th;
            }
        }
        try {
            a.mo3992a();
        } catch (IOException e4) {
        } finally {
            this.f2941d = g.mo3974a();
        }
    }

    /* synthetic */ C1063bb(C1006j jVar, C1010n nVar, byte b) {
        this(jVar, nVar);
    }

    private C1063bb(C1012p pVar) {
        super((byte) 0);
        this.f2952o = -1;
        this.f2953p = -1;
        this.f2941d = pVar.mo4009c();
    }

    /* synthetic */ C1063bb(C1012p pVar, byte b) {
        this(pVar);
    }

    /* renamed from: A */
    private C1002f m4761A() {
        Object obj = this.f2948k;
        if (!(obj instanceof String)) {
            return (C1002f) obj;
        }
        C1002f a = C1002f.m4159a((String) obj);
        this.f2948k = a;
        return a;
    }

    /* renamed from: B */
    private C1002f m4762B() {
        Object obj = this.f2949l;
        if (!(obj instanceof String)) {
            return (C1002f) obj;
        }
        C1002f a = C1002f.m4159a((String) obj);
        this.f2949l = a;
        return a;
    }

    /* renamed from: C */
    private void m4763C() {
        this.f2943f = C1035aa.m4359f();
        this.f2944g = "";
        this.f2945h = C1040af.DEPRECATED_SELECT;
        this.f2946i = 0;
        this.f2947j = 0;
        this.f2948k = "";
        this.f2949l = "";
        this.f2950m = false;
        this.f2951n = 0;
    }

    /* renamed from: a */
    public static C1065bd m4768a(C1063bb bbVar) {
        return C1065bd.m4805h().mo4286a(bbVar);
    }

    /* renamed from: f */
    public static C1063bb m4779f() {
        return f2940c;
    }

    /* renamed from: x */
    public static C1065bd m4780x() {
        return C1065bd.m4805h();
    }

    /* renamed from: z */
    private C1002f m4781z() {
        Object obj = this.f2944g;
        if (!(obj instanceof String)) {
            return (C1002f) obj;
        }
        C1002f a = C1002f.m4159a((String) obj);
        this.f2944g = a;
        return a;
    }

    /* renamed from: a */
    public final void mo4025a(C1008l lVar) {
        mo4026c();
        if ((this.f2942e & 1) == 1) {
            lVar.mo3997a(1, (C1020x) this.f2943f);
        }
        if ((this.f2942e & 2) == 2) {
            lVar.mo3996a(2, m4781z());
        }
        if ((this.f2942e & 4) == 4) {
            lVar.mo4002b(4, this.f2945h.mo4187a());
        }
        if ((this.f2942e & 8) == 8) {
            lVar.mo3995a(5, this.f2946i);
        }
        if ((this.f2942e & 16) == 16) {
            lVar.mo3995a(6, this.f2947j);
        }
        if ((this.f2942e & 32) == 32) {
            lVar.mo3996a(7, m4761A());
        }
        if ((this.f2942e & 64) == 64) {
            lVar.mo3996a(8, m4762B());
        }
        if ((this.f2942e & NotificationCompat.FLAG_HIGH_PRIORITY) == 128) {
            lVar.mo3998a(9, this.f2950m);
        }
        if ((this.f2942e & NotificationCompat.FLAG_LOCAL_ONLY) == 256) {
            lVar.mo3994a(10, this.f2951n);
        }
        lVar.mo4003c(this.f2941d);
    }

    /* renamed from: c */
    public final int mo4026c() {
        int i = this.f2953p;
        if (i != -1) {
            return i;
        }
        int i2 = 0;
        if ((this.f2942e & 1) == 1) {
            i2 = C1008l.m4217b(1, (C1020x) this.f2943f) + 0;
        }
        if ((this.f2942e & 2) == 2) {
            i2 += C1008l.m4216b(2, m4781z());
        }
        if ((this.f2942e & 4) == 4) {
            i2 += C1008l.m4222d(4, this.f2945h.mo4187a());
        }
        if ((this.f2942e & 8) == 8) {
            i2 += C1008l.m4215b(5, this.f2946i);
        }
        if ((this.f2942e & 16) == 16) {
            i2 += C1008l.m4215b(6, this.f2947j);
        }
        if ((this.f2942e & 32) == 32) {
            i2 += C1008l.m4216b(7, m4761A());
        }
        if ((this.f2942e & 64) == 64) {
            i2 += C1008l.m4216b(8, m4762B());
        }
        if ((this.f2942e & NotificationCompat.FLAG_HIGH_PRIORITY) == 128) {
            i2 += C1008l.m4214b(9);
        }
        if ((this.f2942e & NotificationCompat.FLAG_LOCAL_ONLY) == 256) {
            i2 += C1008l.m4220c(10, this.f2951n);
        }
        int a = i2 + this.f2941d.mo3919a();
        this.f2953p = a;
        return a;
    }

    /* renamed from: e */
    public final boolean mo4029e() {
        byte b = this.f2952o;
        if (b == 1) {
            return true;
        }
        if (b == 0) {
            return false;
        }
        this.f2952o = 1;
        return true;
    }

    /* renamed from: g */
    public final boolean mo4264g() {
        return (this.f2942e & 1) == 1;
    }

    /* renamed from: h */
    public final C1035aa mo4265h() {
        return this.f2943f;
    }

    /* renamed from: i */
    public final boolean mo4266i() {
        return (this.f2942e & 2) == 2;
    }

    /* renamed from: j */
    public final String mo4267j() {
        Object obj = this.f2944g;
        if (obj instanceof String) {
            return (String) obj;
        }
        C1002f fVar = (C1002f) obj;
        String e = fVar.mo3970e();
        if (fVar.mo3927f()) {
            this.f2944g = e;
        }
        return e;
    }

    /* renamed from: k */
    public final boolean mo4268k() {
        return (this.f2942e & 4) == 4;
    }

    /* renamed from: l */
    public final C1040af mo4269l() {
        return this.f2945h;
    }

    /* renamed from: m */
    public final boolean mo4270m() {
        return (this.f2942e & 8) == 8;
    }

    /* renamed from: n */
    public final long mo4271n() {
        return this.f2946i;
    }

    /* renamed from: o */
    public final boolean mo4272o() {
        return (this.f2942e & 16) == 16;
    }

    /* renamed from: p */
    public final long mo4273p() {
        return this.f2947j;
    }

    /* renamed from: q */
    public final boolean mo4274q() {
        return (this.f2942e & 32) == 32;
    }

    /* renamed from: r */
    public final boolean mo4275r() {
        return (this.f2942e & 64) == 64;
    }

    /* renamed from: s */
    public final String mo4276s() {
        Object obj = this.f2949l;
        if (obj instanceof String) {
            return (String) obj;
        }
        C1002f fVar = (C1002f) obj;
        String e = fVar.mo3970e();
        if (fVar.mo3927f()) {
            this.f2949l = e;
        }
        return e;
    }

    /* renamed from: t */
    public final boolean mo4277t() {
        return (this.f2942e & NotificationCompat.FLAG_HIGH_PRIORITY) == 128;
    }

    /* renamed from: u */
    public final boolean mo4278u() {
        return this.f2950m;
    }

    /* renamed from: v */
    public final boolean mo4279v() {
        return (this.f2942e & NotificationCompat.FLAG_LOCAL_ONLY) == 256;
    }

    /* renamed from: w */
    public final int mo4280w() {
        return this.f2951n;
    }

    /* renamed from: y */
    public final C1065bd mo4027d() {
        return C1065bd.m4805h().mo4286a(this);
    }
}
