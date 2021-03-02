package com.appbrain.p037f;

import android.support.p009v4.app.NotificationCompat;
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

/* renamed from: com.appbrain.f.av */
public final class C1056av extends C1011o implements C1062ba {

    /* renamed from: b */
    public static C0986aa f2895b = new C1057aw();

    /* renamed from: c */
    private static final C1056av f2896c;
    /* access modifiers changed from: private */

    /* renamed from: d */
    public final C1002f f2897d;
    /* access modifiers changed from: private */

    /* renamed from: e */
    public int f2898e;
    /* access modifiers changed from: private */

    /* renamed from: f */
    public int f2899f;
    /* access modifiers changed from: private */

    /* renamed from: g */
    public Object f2900g;
    /* access modifiers changed from: private */

    /* renamed from: h */
    public Object f2901h;
    /* access modifiers changed from: private */

    /* renamed from: i */
    public Object f2902i;
    /* access modifiers changed from: private */

    /* renamed from: j */
    public Object f2903j;
    /* access modifiers changed from: private */

    /* renamed from: k */
    public C1058ax f2904k;
    /* access modifiers changed from: private */

    /* renamed from: l */
    public int f2905l;
    /* access modifiers changed from: private */

    /* renamed from: m */
    public boolean f2906m;
    /* access modifiers changed from: private */

    /* renamed from: n */
    public int f2907n;
    /* access modifiers changed from: private */

    /* renamed from: o */
    public boolean f2908o;

    /* renamed from: p */
    private byte f2909p;

    /* renamed from: q */
    private int f2910q;

    static {
        C1056av avVar = new C1056av();
        f2896c = avVar;
        avVar.m4688E();
    }

    private C1056av() {
        this.f2909p = -1;
        this.f2910q = -1;
        this.f2897d = C1002f.f2629a;
    }

    private C1056av(C1006j jVar) {
        this.f2909p = -1;
        this.f2910q = -1;
        m4688E();
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
                    case 8:
                        this.f2898e |= 1;
                        this.f2899f = jVar.mo3986d();
                        break;
                    case 18:
                        C1002f f = jVar.mo3988f();
                        this.f2898e |= 2;
                        this.f2900g = f;
                        break;
                    case 26:
                        C1002f f2 = jVar.mo3988f();
                        this.f2898e |= 4;
                        this.f2901h = f2;
                        break;
                    case C0515k.AppCompatTheme_actionModePasteDrawable:
                        C1002f f3 = jVar.mo3988f();
                        this.f2898e |= 8;
                        this.f2902i = f3;
                        break;
                    case C0515k.AppCompatTheme_textAppearancePopupMenuHeader:
                        C1002f f4 = jVar.mo3988f();
                        this.f2898e |= 16;
                        this.f2903j = f4;
                        break;
                    case C0515k.AppCompatTheme_spinnerDropDownItemStyle:
                        int g2 = jVar.mo3989g();
                        C1058ax a3 = C1058ax.m4732a(g2);
                        if (a3 != null) {
                            this.f2898e |= 32;
                            this.f2904k = a3;
                            break;
                        } else {
                            a.mo4005e(a2);
                            a.mo4005e(g2);
                            break;
                        }
                    case C0515k.AppCompatTheme_dividerVertical:
                        this.f2898e |= 64;
                        this.f2905l = jVar.mo3986d();
                        break;
                    case 64:
                        this.f2898e |= NotificationCompat.FLAG_HIGH_PRIORITY;
                        this.f2906m = jVar.mo3987e();
                        break;
                    case C0515k.AppCompatTheme_listPreferredItemHeightLarge:
                        this.f2898e |= NotificationCompat.FLAG_LOCAL_ONLY;
                        this.f2907n = jVar.mo3986d();
                        break;
                    case C0515k.AppCompatTheme_panelMenuListWidth:
                        this.f2898e |= 512;
                        this.f2908o = jVar.mo3987e();
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
                    this.f2897d = g.mo3974a();
                }
                throw th;
            }
        }
        try {
            a.mo3992a();
        } catch (IOException e4) {
        } finally {
            this.f2897d = g.mo3974a();
        }
    }

    /* synthetic */ C1056av(C1006j jVar, byte b) {
        this(jVar);
    }

    private C1056av(C1012p pVar) {
        super((byte) 0);
        this.f2909p = -1;
        this.f2910q = -1;
        this.f2897d = pVar.mo4009c();
    }

    /* synthetic */ C1056av(C1012p pVar, byte b) {
        this(pVar);
    }

    /* renamed from: A */
    private C1002f m4684A() {
        Object obj = this.f2900g;
        if (!(obj instanceof String)) {
            return (C1002f) obj;
        }
        C1002f a = C1002f.m4159a((String) obj);
        this.f2900g = a;
        return a;
    }

    /* renamed from: B */
    private C1002f m4685B() {
        Object obj = this.f2901h;
        if (!(obj instanceof String)) {
            return (C1002f) obj;
        }
        C1002f a = C1002f.m4159a((String) obj);
        this.f2901h = a;
        return a;
    }

    /* renamed from: C */
    private C1002f m4686C() {
        Object obj = this.f2902i;
        if (!(obj instanceof String)) {
            return (C1002f) obj;
        }
        C1002f a = C1002f.m4159a((String) obj);
        this.f2902i = a;
        return a;
    }

    /* renamed from: D */
    private C1002f m4687D() {
        Object obj = this.f2903j;
        if (!(obj instanceof String)) {
            return (C1002f) obj;
        }
        C1002f a = C1002f.m4159a((String) obj);
        this.f2903j = a;
        return a;
    }

    /* renamed from: E */
    private void m4688E() {
        this.f2899f = 0;
        this.f2900g = "";
        this.f2901h = "";
        this.f2902i = "";
        this.f2903j = "";
        this.f2904k = C1058ax.DIALOG;
        this.f2905l = 0;
        this.f2906m = false;
        this.f2907n = 0;
        this.f2908o = false;
    }

    /* renamed from: a */
    public static C1056av m4690a(byte[] bArr) {
        return (C1056av) f2895b.mo3918a(bArr);
    }

    /* renamed from: f */
    public static C1056av m4706f() {
        return f2896c;
    }

    /* renamed from: a */
    public final void mo4025a(C1008l lVar) {
        mo4026c();
        if ((this.f2898e & 1) == 1) {
            lVar.mo3994a(1, this.f2899f);
        }
        if ((this.f2898e & 2) == 2) {
            lVar.mo3996a(2, m4684A());
        }
        if ((this.f2898e & 4) == 4) {
            lVar.mo3996a(3, m4685B());
        }
        if ((this.f2898e & 8) == 8) {
            lVar.mo3996a(4, m4686C());
        }
        if ((this.f2898e & 16) == 16) {
            lVar.mo3996a(5, m4687D());
        }
        if ((this.f2898e & 32) == 32) {
            lVar.mo4002b(6, this.f2904k.mo4257a());
        }
        if ((this.f2898e & 64) == 64) {
            lVar.mo3994a(7, this.f2905l);
        }
        if ((this.f2898e & NotificationCompat.FLAG_HIGH_PRIORITY) == 128) {
            lVar.mo3998a(8, this.f2906m);
        }
        if ((this.f2898e & NotificationCompat.FLAG_LOCAL_ONLY) == 256) {
            lVar.mo3994a(9, this.f2907n);
        }
        if ((this.f2898e & 512) == 512) {
            lVar.mo3998a(10, this.f2908o);
        }
        lVar.mo4003c(this.f2897d);
    }

    /* renamed from: c */
    public final int mo4026c() {
        int i = this.f2910q;
        if (i != -1) {
            return i;
        }
        int i2 = 0;
        if ((this.f2898e & 1) == 1) {
            i2 = C1008l.m4220c(1, this.f2899f) + 0;
        }
        if ((this.f2898e & 2) == 2) {
            i2 += C1008l.m4216b(2, m4684A());
        }
        if ((this.f2898e & 4) == 4) {
            i2 += C1008l.m4216b(3, m4685B());
        }
        if ((this.f2898e & 8) == 8) {
            i2 += C1008l.m4216b(4, m4686C());
        }
        if ((this.f2898e & 16) == 16) {
            i2 += C1008l.m4216b(5, m4687D());
        }
        if ((this.f2898e & 32) == 32) {
            i2 += C1008l.m4222d(6, this.f2904k.mo4257a());
        }
        if ((this.f2898e & 64) == 64) {
            i2 += C1008l.m4220c(7, this.f2905l);
        }
        if ((this.f2898e & NotificationCompat.FLAG_HIGH_PRIORITY) == 128) {
            i2 += C1008l.m4214b(8);
        }
        if ((this.f2898e & NotificationCompat.FLAG_LOCAL_ONLY) == 256) {
            i2 += C1008l.m4220c(9, this.f2907n);
        }
        if ((this.f2898e & 512) == 512) {
            i2 += C1008l.m4214b(10);
        }
        int a = i2 + this.f2897d.mo3919a();
        this.f2910q = a;
        return a;
    }

    /* renamed from: d */
    public final /* synthetic */ C1021y mo4027d() {
        return C1060az.m4734f().mo4258a(this);
    }

    /* renamed from: e */
    public final boolean mo4029e() {
        byte b = this.f2909p;
        if (b == 1) {
            return true;
        }
        if (b == 0) {
            return false;
        }
        this.f2909p = 1;
        return true;
    }

    /* renamed from: g */
    public final boolean mo4237g() {
        return (this.f2898e & 1) == 1;
    }

    /* renamed from: h */
    public final int mo4238h() {
        return this.f2899f;
    }

    /* renamed from: i */
    public final boolean mo4239i() {
        return (this.f2898e & 2) == 2;
    }

    /* renamed from: j */
    public final String mo4240j() {
        Object obj = this.f2900g;
        if (obj instanceof String) {
            return (String) obj;
        }
        C1002f fVar = (C1002f) obj;
        String e = fVar.mo3970e();
        if (fVar.mo3927f()) {
            this.f2900g = e;
        }
        return e;
    }

    /* renamed from: k */
    public final boolean mo4241k() {
        return (this.f2898e & 4) == 4;
    }

    /* renamed from: l */
    public final String mo4242l() {
        Object obj = this.f2901h;
        if (obj instanceof String) {
            return (String) obj;
        }
        C1002f fVar = (C1002f) obj;
        String e = fVar.mo3970e();
        if (fVar.mo3927f()) {
            this.f2901h = e;
        }
        return e;
    }

    /* renamed from: m */
    public final boolean mo4243m() {
        return (this.f2898e & 8) == 8;
    }

    /* renamed from: n */
    public final String mo4244n() {
        Object obj = this.f2902i;
        if (obj instanceof String) {
            return (String) obj;
        }
        C1002f fVar = (C1002f) obj;
        String e = fVar.mo3970e();
        if (fVar.mo3927f()) {
            this.f2902i = e;
        }
        return e;
    }

    /* renamed from: o */
    public final boolean mo4245o() {
        return (this.f2898e & 16) == 16;
    }

    /* renamed from: p */
    public final String mo4246p() {
        Object obj = this.f2903j;
        if (obj instanceof String) {
            return (String) obj;
        }
        C1002f fVar = (C1002f) obj;
        String e = fVar.mo3970e();
        if (fVar.mo3927f()) {
            this.f2903j = e;
        }
        return e;
    }

    /* renamed from: q */
    public final boolean mo4247q() {
        return (this.f2898e & 32) == 32;
    }

    /* renamed from: r */
    public final C1058ax mo4248r() {
        return this.f2904k;
    }

    /* renamed from: s */
    public final boolean mo4249s() {
        return (this.f2898e & 64) == 64;
    }

    /* renamed from: t */
    public final int mo4250t() {
        return this.f2905l;
    }

    /* renamed from: u */
    public final boolean mo4251u() {
        return (this.f2898e & NotificationCompat.FLAG_HIGH_PRIORITY) == 128;
    }

    /* renamed from: v */
    public final boolean mo4252v() {
        return this.f2906m;
    }

    /* renamed from: w */
    public final boolean mo4253w() {
        return (this.f2898e & NotificationCompat.FLAG_LOCAL_ONLY) == 256;
    }

    /* renamed from: x */
    public final int mo4254x() {
        return this.f2907n;
    }

    /* renamed from: y */
    public final boolean mo4255y() {
        return (this.f2898e & 512) == 512;
    }

    /* renamed from: z */
    public final boolean mo4256z() {
        return this.f2908o;
    }
}
