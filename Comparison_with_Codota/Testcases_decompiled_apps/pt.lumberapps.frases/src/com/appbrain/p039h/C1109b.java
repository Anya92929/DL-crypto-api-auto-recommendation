package com.appbrain.p039h;

import android.support.p009v4.app.FragmentTransaction;
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
import java.io.IOException;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* renamed from: com.appbrain.h.b */
public final class C1109b extends C1011o implements C1112e {

    /* renamed from: b */
    public static C0986aa f3082b = new C1110c();

    /* renamed from: c */
    private static final C1109b f3083c;
    /* access modifiers changed from: private */

    /* renamed from: d */
    public final C1002f f3084d;
    /* access modifiers changed from: private */

    /* renamed from: e */
    public int f3085e;
    /* access modifiers changed from: private */

    /* renamed from: f */
    public int f3086f;
    /* access modifiers changed from: private */

    /* renamed from: g */
    public Object f3087g;
    /* access modifiers changed from: private */

    /* renamed from: h */
    public C1002f f3088h;
    /* access modifiers changed from: private */

    /* renamed from: i */
    public C1002f f3089i;
    /* access modifiers changed from: private */

    /* renamed from: j */
    public long f3090j;
    /* access modifiers changed from: private */

    /* renamed from: k */
    public C1113f f3091k;
    /* access modifiers changed from: private */

    /* renamed from: l */
    public boolean f3092l;
    /* access modifiers changed from: private */

    /* renamed from: m */
    public Object f3093m;
    /* access modifiers changed from: private */

    /* renamed from: n */
    public boolean f3094n;
    /* access modifiers changed from: private */

    /* renamed from: o */
    public boolean f3095o;
    /* access modifiers changed from: private */

    /* renamed from: p */
    public Object f3096p;
    /* access modifiers changed from: private */

    /* renamed from: q */
    public Object f3097q;
    /* access modifiers changed from: private */

    /* renamed from: r */
    public Object f3098r;
    /* access modifiers changed from: private */

    /* renamed from: s */
    public Object f3099s;
    /* access modifiers changed from: private */

    /* renamed from: t */
    public Object f3100t;
    /* access modifiers changed from: private */

    /* renamed from: u */
    public int f3101u;
    /* access modifiers changed from: private */

    /* renamed from: v */
    public Object f3102v;
    /* access modifiers changed from: private */

    /* renamed from: w */
    public List f3103w;
    /* access modifiers changed from: private */

    /* renamed from: x */
    public List f3104x;

    /* renamed from: y */
    private byte f3105y;

    /* renamed from: z */
    private int f3106z;

    static {
        C1109b bVar = new C1109b();
        f3083c = bVar;
        bVar.m5109T();
    }

    private C1109b() {
        this.f3105y = -1;
        this.f3106z = -1;
        this.f3084d = C1002f.f2629a;
    }

    private C1109b(C1006j jVar) {
        boolean z = false;
        this.f3105y = -1;
        this.f3106z = -1;
        m5109T();
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
                        C1002f f = jVar.mo3988f();
                        this.f3085e |= 1024;
                        this.f3096p = f;
                        break;
                    case 18:
                        C1002f f2 = jVar.mo3988f();
                        this.f3085e |= 2048;
                        this.f3097q = f2;
                        break;
                    case 26:
                        C1002f f3 = jVar.mo3988f();
                        this.f3085e |= FragmentTransaction.TRANSIT_ENTER_MASK;
                        this.f3098r = f3;
                        break;
                    case C0515k.AppCompatTheme_actionModePasteDrawable:
                        C1002f f4 = jVar.mo3988f();
                        this.f3085e |= FragmentTransaction.TRANSIT_EXIT_MASK;
                        this.f3099s = f4;
                        break;
                    case C0515k.AppCompatTheme_textAppearancePopupMenuHeader:
                        C1002f f5 = jVar.mo3988f();
                        this.f3085e |= 16384;
                        this.f3100t = f5;
                        break;
                    case C0515k.AppCompatTheme_spinnerDropDownItemStyle:
                        this.f3085e |= 32768;
                        this.f3101u = jVar.mo3986d();
                        break;
                    case C0515k.AppCompatTheme_activityChooserViewStyle:
                        C1002f f6 = jVar.mo3988f();
                        this.f3085e |= 65536;
                        this.f3102v = f6;
                        break;
                    case C0515k.AppCompatTheme_listPreferredItemPaddingRight:
                        C1002f f7 = jVar.mo3988f();
                        this.f3085e |= 2;
                        this.f3087g = f7;
                        break;
                    case C0515k.AppCompatTheme_listChoiceBackgroundIndicator:
                        this.f3085e |= 4;
                        this.f3088h = jVar.mo3988f();
                        break;
                    case C0515k.AppCompatTheme_colorControlHighlight:
                        this.f3085e |= 16;
                        this.f3090j = jVar.mo3984c();
                        break;
                    case C0515k.AppCompatTheme_alertDialogTheme:
                        int g2 = jVar.mo3989g();
                        C1113f a3 = C1113f.m5201a(g2);
                        if (a3 != null) {
                            this.f3085e |= 32;
                            this.f3091k = a3;
                            break;
                        } else {
                            a.mo4005e(a2);
                            a.mo4005e(g2);
                            break;
                        }
                    case C0515k.AppCompatTheme_checkboxStyle:
                        this.f3085e |= 64;
                        this.f3092l = jVar.mo3987e();
                        break;
                    case C0515k.AppCompatTheme_listMenuViewStyle:
                        C1002f f8 = jVar.mo3988f();
                        this.f3085e |= NotificationCompat.FLAG_HIGH_PRIORITY;
                        this.f3093m = f8;
                        break;
                    case 120:
                        this.f3085e |= NotificationCompat.FLAG_LOCAL_ONLY;
                        this.f3094n = jVar.mo3987e();
                        break;
                    case 130:
                        this.f3085e |= 8;
                        this.f3089i = jVar.mo3988f();
                        break;
                    case 136:
                        this.f3085e |= 512;
                        this.f3095o = jVar.mo3987e();
                        break;
                    case 152:
                        if (!(z2 & true)) {
                            this.f3103w = new ArrayList();
                            z2 |= true;
                        }
                        this.f3103w.add(Integer.valueOf(jVar.mo3986d()));
                        break;
                    case 154:
                        int b = jVar.mo3983b(jVar.mo3990h());
                        if (!(z2 & true) && jVar.mo3991i() > 0) {
                            this.f3103w = new ArrayList();
                            z2 |= true;
                        }
                        while (jVar.mo3991i() > 0) {
                            this.f3103w.add(Integer.valueOf(jVar.mo3986d()));
                        }
                        jVar.mo3985c(b);
                        break;
                    case 162:
                        if (!(z2 & true)) {
                            this.f3104x = new ArrayList();
                            z2 |= true;
                        }
                        this.f3104x.add(jVar.mo3988f());
                        break;
                    case 168:
                        this.f3085e |= 1;
                        this.f3086f = jVar.mo3986d();
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
                    this.f3103w = Collections.unmodifiableList(this.f3103w);
                }
                if (z2 & true) {
                    this.f3104x = Collections.unmodifiableList(this.f3104x);
                }
                try {
                    a.mo3992a();
                } catch (IOException e3) {
                } finally {
                    this.f3084d = g.mo3974a();
                }
                throw th;
            }
        }
        if (z2 & true) {
            this.f3103w = Collections.unmodifiableList(this.f3103w);
        }
        if (z2 & true) {
            this.f3104x = Collections.unmodifiableList(this.f3104x);
        }
        try {
            a.mo3992a();
        } catch (IOException e4) {
        } finally {
            this.f3084d = g.mo3974a();
        }
    }

    /* synthetic */ C1109b(C1006j jVar, byte b) {
        this(jVar);
    }

    private C1109b(C1012p pVar) {
        super((byte) 0);
        this.f3105y = -1;
        this.f3106z = -1;
        this.f3084d = pVar.mo4009c();
    }

    /* synthetic */ C1109b(C1012p pVar, byte b) {
        this(pVar);
    }

    /* renamed from: J */
    public static C1111d m5100J() {
        return C1111d.m5180i();
    }

    /* renamed from: L */
    private C1002f m5101L() {
        Object obj = this.f3087g;
        if (!(obj instanceof String)) {
            return (C1002f) obj;
        }
        C1002f a = C1002f.m4159a((String) obj);
        this.f3087g = a;
        return a;
    }

    /* renamed from: M */
    private C1002f m5102M() {
        Object obj = this.f3093m;
        if (!(obj instanceof String)) {
            return (C1002f) obj;
        }
        C1002f a = C1002f.m4159a((String) obj);
        this.f3093m = a;
        return a;
    }

    @Deprecated
    /* renamed from: N */
    private C1002f m5103N() {
        Object obj = this.f3096p;
        if (!(obj instanceof String)) {
            return (C1002f) obj;
        }
        C1002f a = C1002f.m4159a((String) obj);
        this.f3096p = a;
        return a;
    }

    @Deprecated
    /* renamed from: O */
    private C1002f m5104O() {
        Object obj = this.f3097q;
        if (!(obj instanceof String)) {
            return (C1002f) obj;
        }
        C1002f a = C1002f.m4159a((String) obj);
        this.f3097q = a;
        return a;
    }

    @Deprecated
    /* renamed from: P */
    private C1002f m5105P() {
        Object obj = this.f3098r;
        if (!(obj instanceof String)) {
            return (C1002f) obj;
        }
        C1002f a = C1002f.m4159a((String) obj);
        this.f3098r = a;
        return a;
    }

    @Deprecated
    /* renamed from: Q */
    private C1002f m5106Q() {
        Object obj = this.f3099s;
        if (!(obj instanceof String)) {
            return (C1002f) obj;
        }
        C1002f a = C1002f.m4159a((String) obj);
        this.f3099s = a;
        return a;
    }

    @Deprecated
    /* renamed from: R */
    private C1002f m5107R() {
        Object obj = this.f3100t;
        if (!(obj instanceof String)) {
            return (C1002f) obj;
        }
        C1002f a = C1002f.m4159a((String) obj);
        this.f3100t = a;
        return a;
    }

    @Deprecated
    /* renamed from: S */
    private C1002f m5108S() {
        Object obj = this.f3102v;
        if (!(obj instanceof String)) {
            return (C1002f) obj;
        }
        C1002f a = C1002f.m4159a((String) obj);
        this.f3102v = a;
        return a;
    }

    /* renamed from: T */
    private void m5109T() {
        this.f3086f = 0;
        this.f3087g = "";
        this.f3088h = C1002f.f2629a;
        this.f3089i = C1002f.f2629a;
        this.f3090j = 0;
        this.f3091k = C1113f.INTEGRITY_ONLY;
        this.f3092l = false;
        this.f3093m = "";
        this.f3094n = false;
        this.f3095o = false;
        this.f3096p = "";
        this.f3097q = "";
        this.f3098r = "";
        this.f3099s = "";
        this.f3100t = "";
        this.f3101u = 0;
        this.f3102v = "";
        this.f3103w = Collections.emptyList();
        this.f3104x = Collections.emptyList();
    }

    /* renamed from: a */
    public static C1109b m5113a(byte[] bArr) {
        return (C1109b) f3082b.mo3918a(bArr);
    }

    /* renamed from: f */
    public static C1109b m5133f() {
        return f3083c;
    }

    @Deprecated
    /* renamed from: A */
    public final boolean mo4383A() {
        return (this.f3085e & 2048) == 2048;
    }

    @Deprecated
    /* renamed from: B */
    public final boolean mo4384B() {
        return (this.f3085e & FragmentTransaction.TRANSIT_ENTER_MASK) == 4096;
    }

    @Deprecated
    /* renamed from: C */
    public final boolean mo4385C() {
        return (this.f3085e & FragmentTransaction.TRANSIT_EXIT_MASK) == 8192;
    }

    @Deprecated
    /* renamed from: D */
    public final boolean mo4386D() {
        return (this.f3085e & 16384) == 16384;
    }

    /* renamed from: E */
    public final boolean mo4387E() {
        return (this.f3085e & 32768) == 32768;
    }

    /* renamed from: F */
    public final int mo4388F() {
        return this.f3101u;
    }

    @Deprecated
    /* renamed from: G */
    public final boolean mo4389G() {
        return (this.f3085e & 65536) == 65536;
    }

    /* renamed from: H */
    public final int mo4390H() {
        return this.f3103w.size();
    }

    /* renamed from: I */
    public final int mo4391I() {
        return this.f3104x.size();
    }

    /* renamed from: K */
    public final C1111d mo4027d() {
        return C1111d.m5180i().mo4417a(this);
    }

    /* renamed from: a */
    public final int mo4393a(int i) {
        return ((Integer) this.f3103w.get(i)).intValue();
    }

    /* renamed from: a */
    public final void mo4025a(C1008l lVar) {
        mo4026c();
        if ((this.f3085e & 1024) == 1024) {
            lVar.mo3996a(1, m5103N());
        }
        if ((this.f3085e & 2048) == 2048) {
            lVar.mo3996a(2, m5104O());
        }
        if ((this.f3085e & FragmentTransaction.TRANSIT_ENTER_MASK) == 4096) {
            lVar.mo3996a(3, m5105P());
        }
        if ((this.f3085e & FragmentTransaction.TRANSIT_EXIT_MASK) == 8192) {
            lVar.mo3996a(4, m5106Q());
        }
        if ((this.f3085e & 16384) == 16384) {
            lVar.mo3996a(5, m5107R());
        }
        if ((this.f3085e & 32768) == 32768) {
            lVar.mo3994a(6, this.f3101u);
        }
        if ((this.f3085e & 65536) == 65536) {
            lVar.mo3996a(7, m5108S());
        }
        if ((this.f3085e & 2) == 2) {
            lVar.mo3996a(9, m5101L());
        }
        if ((this.f3085e & 4) == 4) {
            lVar.mo3996a(10, this.f3088h);
        }
        if ((this.f3085e & 16) == 16) {
            lVar.mo3995a(11, this.f3090j);
        }
        if ((this.f3085e & 32) == 32) {
            lVar.mo4002b(12, this.f3091k.mo4427a());
        }
        if ((this.f3085e & 64) == 64) {
            lVar.mo3998a(13, this.f3092l);
        }
        if ((this.f3085e & NotificationCompat.FLAG_HIGH_PRIORITY) == 128) {
            lVar.mo3996a(14, m5102M());
        }
        if ((this.f3085e & NotificationCompat.FLAG_LOCAL_ONLY) == 256) {
            lVar.mo3998a(15, this.f3094n);
        }
        if ((this.f3085e & 8) == 8) {
            lVar.mo3996a(16, this.f3089i);
        }
        if ((this.f3085e & 512) == 512) {
            lVar.mo3998a(17, this.f3095o);
        }
        for (int i = 0; i < this.f3103w.size(); i++) {
            lVar.mo3994a(19, ((Integer) this.f3103w.get(i)).intValue());
        }
        for (int i2 = 0; i2 < this.f3104x.size(); i2++) {
            lVar.mo3996a(20, (C1002f) this.f3104x.get(i2));
        }
        if ((this.f3085e & 1) == 1) {
            lVar.mo3994a(21, this.f3086f);
        }
        lVar.mo4003c(this.f3084d);
    }

    /* renamed from: b */
    public final C1002f mo4394b(int i) {
        return (C1002f) this.f3104x.get(i);
    }

    /* renamed from: c */
    public final int mo4026c() {
        int i = 0;
        int i2 = this.f3106z;
        if (i2 != -1) {
            return i2;
        }
        int b = (this.f3085e & 1024) == 1024 ? C1008l.m4216b(1, m5103N()) + 0 : 0;
        if ((this.f3085e & 2048) == 2048) {
            b += C1008l.m4216b(2, m5104O());
        }
        if ((this.f3085e & FragmentTransaction.TRANSIT_ENTER_MASK) == 4096) {
            b += C1008l.m4216b(3, m5105P());
        }
        if ((this.f3085e & FragmentTransaction.TRANSIT_EXIT_MASK) == 8192) {
            b += C1008l.m4216b(4, m5106Q());
        }
        if ((this.f3085e & 16384) == 16384) {
            b += C1008l.m4216b(5, m5107R());
        }
        if ((this.f3085e & 32768) == 32768) {
            b += C1008l.m4220c(6, this.f3101u);
        }
        if ((this.f3085e & 65536) == 65536) {
            b += C1008l.m4216b(7, m5108S());
        }
        if ((this.f3085e & 2) == 2) {
            b += C1008l.m4216b(9, m5101L());
        }
        if ((this.f3085e & 4) == 4) {
            b += C1008l.m4216b(10, this.f3088h);
        }
        if ((this.f3085e & 16) == 16) {
            b += C1008l.m4215b(11, this.f3090j);
        }
        if ((this.f3085e & 32) == 32) {
            b += C1008l.m4222d(12, this.f3091k.mo4427a());
        }
        if ((this.f3085e & 64) == 64) {
            b += C1008l.m4214b(13);
        }
        if ((this.f3085e & NotificationCompat.FLAG_HIGH_PRIORITY) == 128) {
            b += C1008l.m4216b(14, m5102M());
        }
        if ((this.f3085e & NotificationCompat.FLAG_LOCAL_ONLY) == 256) {
            b += C1008l.m4214b(15);
        }
        if ((this.f3085e & 8) == 8) {
            b += C1008l.m4216b(16, this.f3089i);
        }
        int b2 = (this.f3085e & 512) == 512 ? b + C1008l.m4214b(17) : b;
        int i3 = 0;
        for (int i4 = 0; i4 < this.f3103w.size(); i4++) {
            i3 += C1008l.m4219c(((Integer) this.f3103w.get(i4)).intValue());
        }
        int size = b2 + i3 + (this.f3103w.size() * 2);
        int i5 = 0;
        while (i < this.f3104x.size()) {
            i++;
            i5 = C1008l.m4218b((C1002f) this.f3104x.get(i)) + i5;
        }
        int size2 = size + i5 + (this.f3104x.size() * 2);
        if ((this.f3085e & 1) == 1) {
            size2 += C1008l.m4220c(21, this.f3086f);
        }
        int a = size2 + this.f3084d.mo3919a();
        this.f3106z = a;
        return a;
    }

    /* renamed from: e */
    public final boolean mo4029e() {
        byte b = this.f3105y;
        if (b == 1) {
            return true;
        }
        if (b == 0) {
            return false;
        }
        this.f3105y = 1;
        return true;
    }

    /* renamed from: g */
    public final boolean mo4395g() {
        return (this.f3085e & 1) == 1;
    }

    /* renamed from: h */
    public final int mo4396h() {
        return this.f3086f;
    }

    /* renamed from: i */
    public final boolean mo4397i() {
        return (this.f3085e & 2) == 2;
    }

    /* renamed from: j */
    public final boolean mo4398j() {
        return (this.f3085e & 4) == 4;
    }

    /* renamed from: k */
    public final C1002f mo4399k() {
        return this.f3088h;
    }

    /* renamed from: l */
    public final boolean mo4400l() {
        return (this.f3085e & 8) == 8;
    }

    /* renamed from: m */
    public final C1002f mo4401m() {
        return this.f3089i;
    }

    /* renamed from: n */
    public final boolean mo4402n() {
        return (this.f3085e & 16) == 16;
    }

    /* renamed from: o */
    public final long mo4403o() {
        return this.f3090j;
    }

    /* renamed from: p */
    public final boolean mo4404p() {
        return (this.f3085e & 32) == 32;
    }

    /* renamed from: q */
    public final C1113f mo4405q() {
        return this.f3091k;
    }

    /* renamed from: r */
    public final boolean mo4406r() {
        return (this.f3085e & 64) == 64;
    }

    /* renamed from: s */
    public final boolean mo4407s() {
        return this.f3092l;
    }

    /* renamed from: t */
    public final boolean mo4408t() {
        return (this.f3085e & NotificationCompat.FLAG_HIGH_PRIORITY) == 128;
    }

    /* renamed from: u */
    public final String mo4409u() {
        Object obj = this.f3093m;
        if (obj instanceof String) {
            return (String) obj;
        }
        C1002f fVar = (C1002f) obj;
        String e = fVar.mo3970e();
        if (fVar.mo3927f()) {
            this.f3093m = e;
        }
        return e;
    }

    /* renamed from: v */
    public final boolean mo4410v() {
        return (this.f3085e & NotificationCompat.FLAG_LOCAL_ONLY) == 256;
    }

    /* renamed from: w */
    public final boolean mo4411w() {
        return this.f3094n;
    }

    /* renamed from: x */
    public final boolean mo4412x() {
        return (this.f3085e & 512) == 512;
    }

    /* renamed from: y */
    public final boolean mo4413y() {
        return this.f3095o;
    }

    @Deprecated
    /* renamed from: z */
    public final boolean mo4414z() {
        return (this.f3085e & 1024) == 1024;
    }
}
