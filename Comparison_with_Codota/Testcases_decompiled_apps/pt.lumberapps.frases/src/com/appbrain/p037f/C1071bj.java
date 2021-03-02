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
import com.appbrain.p033b.C1016t;
import com.appbrain.p033b.C1017u;
import com.appbrain.p033b.C1020x;
import com.appbrain.p033b.C1021y;
import java.io.IOException;
import java.io.OutputStream;

/* renamed from: com.appbrain.f.bj */
public final class C1071bj extends C1011o implements C1074bm {

    /* renamed from: b */
    public static C0986aa f2977b = new C1072bk();

    /* renamed from: c */
    private static final C1071bj f2978c;
    /* access modifiers changed from: private */

    /* renamed from: d */
    public final C1002f f2979d;
    /* access modifiers changed from: private */

    /* renamed from: e */
    public int f2980e;
    /* access modifiers changed from: private */

    /* renamed from: f */
    public C1035aa f2981f;
    /* access modifiers changed from: private */

    /* renamed from: g */
    public C1017u f2982g;
    /* access modifiers changed from: private */

    /* renamed from: h */
    public C1017u f2983h;
    /* access modifiers changed from: private */

    /* renamed from: i */
    public Object f2984i;
    /* access modifiers changed from: private */

    /* renamed from: j */
    public long f2985j;
    /* access modifiers changed from: private */

    /* renamed from: k */
    public int f2986k;
    /* access modifiers changed from: private */

    /* renamed from: l */
    public boolean f2987l;

    /* renamed from: m */
    private byte f2988m;

    /* renamed from: n */
    private int f2989n;

    static {
        C1071bj bjVar = new C1071bj();
        f2978c = bjVar;
        bjVar.m4876r();
    }

    private C1071bj() {
        this.f2988m = -1;
        this.f2989n = -1;
        this.f2979d = C1002f.f2629a;
    }

    private C1071bj(C1006j jVar, C1010n nVar) {
        this.f2988m = -1;
        this.f2989n = -1;
        m4876r();
        C1005i g = C1002f.m4164g();
        C1008l a = C1008l.m4211a((OutputStream) g);
        boolean z = false;
        boolean z2 = false;
        while (!z) {
            try {
                int a2 = jVar.mo3978a();
                switch (a2) {
                    case 0:
                        z = true;
                        break;
                    case 10:
                        C1037ac aE = (this.f2980e & 1) == 1 ? this.f2981f.mo4027d() : null;
                        this.f2981f = (C1035aa) jVar.mo3979a(C1035aa.f2695b, nVar);
                        if (aE != null) {
                            aE.mo4139a(this.f2981f);
                            this.f2981f = aE.mo4163g();
                        }
                        this.f2980e |= 1;
                        break;
                    case 18:
                        C1002f f = jVar.mo3988f();
                        if (!(z2 & true)) {
                            this.f2982g = new C1016t();
                            z2 |= true;
                        }
                        this.f2982g.mo3943a(f);
                        break;
                    case 26:
                        C1002f f2 = jVar.mo3988f();
                        if (!(z2 & true)) {
                            this.f2983h = new C1016t();
                            z2 |= true;
                        }
                        this.f2983h.mo3943a(f2);
                        break;
                    case C0515k.AppCompatTheme_actionModePasteDrawable:
                        C1002f f3 = jVar.mo3988f();
                        this.f2980e |= 2;
                        this.f2984i = f3;
                        break;
                    case C0515k.AppCompatTheme_textAppearanceLargePopupMenu:
                        this.f2980e |= 4;
                        this.f2985j = jVar.mo3984c();
                        break;
                    case C0515k.AppCompatTheme_spinnerDropDownItemStyle:
                        this.f2980e |= 8;
                        this.f2986k = jVar.mo3986d();
                        break;
                    case C0515k.AppCompatTheme_dividerVertical:
                        this.f2980e |= 16;
                        this.f2987l = jVar.mo3987e();
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
                if (z2 & true) {
                    this.f2982g = this.f2982g.mo3944b();
                }
                if (z2 & true) {
                    this.f2983h = this.f2983h.mo3944b();
                }
                try {
                    a.mo3992a();
                } catch (IOException e3) {
                } finally {
                    this.f2979d = g.mo3974a();
                }
                throw th;
            }
        }
        if (z2 & true) {
            this.f2982g = this.f2982g.mo3944b();
        }
        if (z2 & true) {
            this.f2983h = this.f2983h.mo3944b();
        }
        try {
            a.mo3992a();
        } catch (IOException e4) {
        } finally {
            this.f2979d = g.mo3974a();
        }
    }

    /* synthetic */ C1071bj(C1006j jVar, C1010n nVar, byte b) {
        this(jVar, nVar);
    }

    private C1071bj(C1012p pVar) {
        super((byte) 0);
        this.f2988m = -1;
        this.f2989n = -1;
        this.f2979d = pVar.mo4009c();
    }

    /* synthetic */ C1071bj(C1012p pVar, byte b) {
        this(pVar);
    }

    /* renamed from: f */
    public static C1071bj m4873f() {
        return f2978c;
    }

    /* renamed from: p */
    public static C1073bl m4874p() {
        return C1073bl.m4891i();
    }

    /* renamed from: q */
    private C1002f m4875q() {
        Object obj = this.f2984i;
        if (!(obj instanceof String)) {
            return (C1002f) obj;
        }
        C1002f a = C1002f.m4159a((String) obj);
        this.f2984i = a;
        return a;
    }

    /* renamed from: r */
    private void m4876r() {
        this.f2981f = C1035aa.m4359f();
        this.f2982g = C1016t.f2665a;
        this.f2983h = C1016t.f2665a;
        this.f2984i = "";
        this.f2985j = 0;
        this.f2986k = 0;
        this.f2987l = false;
    }

    /* renamed from: a */
    public final void mo4025a(C1008l lVar) {
        mo4026c();
        if ((this.f2980e & 1) == 1) {
            lVar.mo3997a(1, (C1020x) this.f2981f);
        }
        for (int i = 0; i < this.f2982g.size(); i++) {
            lVar.mo3996a(2, this.f2982g.mo3941a(i));
        }
        for (int i2 = 0; i2 < this.f2983h.size(); i2++) {
            lVar.mo3996a(3, this.f2983h.mo3941a(i2));
        }
        if ((this.f2980e & 2) == 2) {
            lVar.mo3996a(4, m4875q());
        }
        if ((this.f2980e & 4) == 4) {
            lVar.mo3995a(5, this.f2985j);
        }
        if ((this.f2980e & 8) == 8) {
            lVar.mo3994a(6, this.f2986k);
        }
        if ((this.f2980e & 16) == 16) {
            lVar.mo3998a(7, this.f2987l);
        }
        lVar.mo4003c(this.f2979d);
    }

    /* renamed from: c */
    public final int mo4026c() {
        int i = this.f2989n;
        if (i != -1) {
            return i;
        }
        int b = (this.f2980e & 1) == 1 ? C1008l.m4217b(1, (C1020x) this.f2981f) + 0 : 0;
        int i2 = 0;
        for (int i3 = 0; i3 < this.f2982g.size(); i3++) {
            i2 += C1008l.m4218b(this.f2982g.mo3941a(i3));
        }
        int size = (this.f2982g.size() * 1) + b + i2;
        int i4 = 0;
        for (int i5 = 0; i5 < this.f2983h.size(); i5++) {
            i4 += C1008l.m4218b(this.f2983h.mo3941a(i5));
        }
        int size2 = i4 + size + (this.f2983h.size() * 1);
        if ((this.f2980e & 2) == 2) {
            size2 += C1008l.m4216b(4, m4875q());
        }
        if ((this.f2980e & 4) == 4) {
            size2 += C1008l.m4215b(5, this.f2985j);
        }
        if ((this.f2980e & 8) == 8) {
            size2 += C1008l.m4220c(6, this.f2986k);
        }
        if ((this.f2980e & 16) == 16) {
            size2 += C1008l.m4214b(7);
        }
        int a = size2 + this.f2979d.mo3919a();
        this.f2989n = a;
        return a;
    }

    /* renamed from: d */
    public final /* synthetic */ C1021y mo4027d() {
        return C1073bl.m4891i().mo4319a(this);
    }

    /* renamed from: e */
    public final boolean mo4029e() {
        byte b = this.f2988m;
        if (b == 1) {
            return true;
        }
        if (b == 0) {
            return false;
        }
        this.f2988m = 1;
        return true;
    }

    /* renamed from: g */
    public final boolean mo4307g() {
        return (this.f2980e & 1) == 1;
    }

    /* renamed from: h */
    public final C1035aa mo4308h() {
        return this.f2981f;
    }

    /* renamed from: i */
    public final boolean mo4309i() {
        return (this.f2980e & 2) == 2;
    }

    /* renamed from: j */
    public final boolean mo4310j() {
        return (this.f2980e & 4) == 4;
    }

    /* renamed from: k */
    public final long mo4311k() {
        return this.f2985j;
    }

    /* renamed from: l */
    public final boolean mo4312l() {
        return (this.f2980e & 8) == 8;
    }

    /* renamed from: m */
    public final int mo4313m() {
        return this.f2986k;
    }

    /* renamed from: n */
    public final boolean mo4314n() {
        return (this.f2980e & 16) == 16;
    }

    /* renamed from: o */
    public final boolean mo4315o() {
        return this.f2987l;
    }
}
