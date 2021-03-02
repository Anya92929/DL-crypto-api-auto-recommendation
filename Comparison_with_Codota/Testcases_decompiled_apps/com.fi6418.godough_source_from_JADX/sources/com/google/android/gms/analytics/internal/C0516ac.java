package com.google.android.gms.analytics.internal;

import android.app.Application;
import android.content.Context;
import com.google.android.gms.analytics.C0581l;
import com.google.android.gms.common.internal.C1009bf;
import com.google.android.gms.p018c.C0615ad;
import com.google.android.gms.p018c.C0616ae;
import com.google.android.gms.p018c.C0628aq;
import java.lang.Thread;

/* renamed from: com.google.android.gms.analytics.internal.ac */
public class C0516ac {

    /* renamed from: a */
    private static C0516ac f3702a;

    /* renamed from: b */
    private final Context f3703b;

    /* renamed from: c */
    private final Context f3704c;

    /* renamed from: d */
    private final C0615ad f3705d;

    /* renamed from: e */
    private final C0543bc f3706e;

    /* renamed from: f */
    private final C0562j f3707f;

    /* renamed from: g */
    private final C0628aq f3708g;

    /* renamed from: h */
    private final C0572t f3709h;

    /* renamed from: i */
    private final C0548bh f3710i;

    /* renamed from: j */
    private final C0571s f3711j;

    /* renamed from: k */
    private final C0566n f3712k;

    /* renamed from: l */
    private final C0581l f3713l;

    /* renamed from: m */
    private final C0535av f3714m;

    /* renamed from: n */
    private final C0540b f3715n;

    /* renamed from: o */
    private final C0527an f3716o;

    /* renamed from: p */
    private final C0547bg f3717p;

    protected C0516ac(C0518ae aeVar) {
        Context a = aeVar.mo6619a();
        C1009bf.m4529a(a, (Object) "Application context can't be null");
        C1009bf.m4537b(a instanceof Application, "getApplicationContext didn't return the application");
        Context b = aeVar.mo6622b();
        C1009bf.m4528a(b);
        this.f3703b = a;
        this.f3704c = b;
        this.f3705d = aeVar.mo6629h(this);
        this.f3706e = aeVar.mo6628g(this);
        C0562j f = aeVar.mo6627f(this);
        f.mo6597E();
        this.f3707f = f;
        if (mo6603e().mo6731a()) {
            mo6604f().mo6876d("Google Analytics " + C0515ab.f3700a + " is starting up.");
        } else {
            mo6604f().mo6876d("Google Analytics " + C0515ab.f3700a + " is starting up. " + "To enable debug logging on a device run:\n" + "  adb shell setprop log.tag.GAv4 DEBUG\n" + "  adb logcat -s GAv4");
        }
        C0566n q = aeVar.mo6638q(this);
        q.mo6597E();
        this.f3712k = q;
        C0571s e = aeVar.mo6626e(this);
        e.mo6597E();
        this.f3711j = e;
        C0572t l = aeVar.mo6633l(this);
        C0535av d = aeVar.mo6625d(this);
        C0540b c = aeVar.mo6624c(this);
        C0527an b2 = aeVar.mo6623b(this);
        C0547bg a2 = aeVar.mo6620a(this);
        C0628aq a3 = aeVar.mo6621a(a);
        a3.mo7019a(mo6599a());
        this.f3708g = a3;
        C0581l i = aeVar.mo6630i(this);
        d.mo6597E();
        this.f3714m = d;
        c.mo6597E();
        this.f3715n = c;
        b2.mo6597E();
        this.f3716o = b2;
        a2.mo6597E();
        this.f3717p = a2;
        C0548bh p = aeVar.mo6637p(this);
        p.mo6597E();
        this.f3710i = p;
        l.mo6597E();
        this.f3709h = l;
        if (mo6603e().mo6731a()) {
            mo6604f().mo6870b("Device AnalyticsService version", C0515ab.f3700a);
        }
        i.mo6903a();
        this.f3713l = i;
        l.mo6851b();
    }

    /* renamed from: a */
    public static C0516ac m2979a(Context context) {
        C1009bf.m4528a(context);
        if (f3702a == null) {
            synchronized (C0516ac.class) {
                if (f3702a == null) {
                    C0615ad c = C0616ae.m3557c();
                    long b = c.mo6991b();
                    C0516ac acVar = new C0516ac(new C0518ae(context.getApplicationContext()));
                    f3702a = acVar;
                    C0581l.m3408d();
                    long b2 = c.mo6991b() - b;
                    long longValue = C0551bk.f3816Q.mo6775a().longValue();
                    if (b2 > longValue) {
                        acVar.mo6604f().mo6875c("Slow initialization (ms)", Long.valueOf(b2), Long.valueOf(longValue));
                    }
                }
            }
        }
        return f3702a;
    }

    /* renamed from: a */
    private void m2980a(C0514aa aaVar) {
        C1009bf.m4529a(aaVar, (Object) "Analytics service not created/initialized");
        C1009bf.m4537b(aaVar.mo6595C(), "Analytics service not initialized");
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public Thread.UncaughtExceptionHandler mo6599a() {
        return new C0517ad(this);
    }

    /* renamed from: b */
    public Context mo6600b() {
        return this.f3703b;
    }

    /* renamed from: c */
    public Context mo6601c() {
        return this.f3704c;
    }

    /* renamed from: d */
    public C0615ad mo6602d() {
        return this.f3705d;
    }

    /* renamed from: e */
    public C0543bc mo6603e() {
        return this.f3706e;
    }

    /* renamed from: f */
    public C0562j mo6604f() {
        m2980a((C0514aa) this.f3707f);
        return this.f3707f;
    }

    /* renamed from: g */
    public C0562j mo6605g() {
        return this.f3707f;
    }

    /* renamed from: h */
    public C0628aq mo6606h() {
        C1009bf.m4528a(this.f3708g);
        return this.f3708g;
    }

    /* renamed from: i */
    public C0572t mo6607i() {
        m2980a((C0514aa) this.f3709h);
        return this.f3709h;
    }

    /* renamed from: j */
    public C0548bh mo6608j() {
        m2980a((C0514aa) this.f3710i);
        return this.f3710i;
    }

    /* renamed from: k */
    public C0581l mo6609k() {
        C1009bf.m4528a(this.f3713l);
        C1009bf.m4537b(this.f3713l.mo6906c(), "Analytics instance not initialized");
        return this.f3713l;
    }

    /* renamed from: l */
    public C0571s mo6610l() {
        m2980a((C0514aa) this.f3711j);
        return this.f3711j;
    }

    /* renamed from: m */
    public C0566n mo6611m() {
        m2980a((C0514aa) this.f3712k);
        return this.f3712k;
    }

    /* renamed from: n */
    public C0566n mo6612n() {
        if (this.f3712k == null || !this.f3712k.mo6595C()) {
            return null;
        }
        return this.f3712k;
    }

    /* renamed from: o */
    public C0540b mo6613o() {
        m2980a((C0514aa) this.f3715n);
        return this.f3715n;
    }

    /* renamed from: p */
    public C0535av mo6614p() {
        m2980a((C0514aa) this.f3714m);
        return this.f3714m;
    }

    /* renamed from: q */
    public C0527an mo6615q() {
        m2980a((C0514aa) this.f3716o);
        return this.f3716o;
    }

    /* renamed from: r */
    public C0547bg mo6616r() {
        return this.f3717p;
    }

    /* renamed from: s */
    public void mo6617s() {
        C0628aq.m3622d();
    }
}
