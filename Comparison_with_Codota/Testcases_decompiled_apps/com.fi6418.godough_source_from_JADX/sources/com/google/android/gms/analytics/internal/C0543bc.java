package com.google.android.gms.analytics.internal;

import android.content.pm.ApplicationInfo;
import android.os.Process;
import android.text.TextUtils;
import com.google.android.gms.common.internal.C1009bf;
import com.google.android.gms.common.internal.C1015f;
import com.google.android.gms.p018c.C0619ah;
import java.util.HashSet;
import java.util.Set;

/* renamed from: com.google.android.gms.analytics.internal.bc */
public class C0543bc {

    /* renamed from: a */
    private final C0516ac f3785a;

    /* renamed from: b */
    private volatile Boolean f3786b;

    /* renamed from: c */
    private String f3787c;

    /* renamed from: d */
    private Set<Integer> f3788d;

    protected C0543bc(C0516ac acVar) {
        C1009bf.m4528a(acVar);
        this.f3785a = acVar;
    }

    /* renamed from: A */
    public String mo6724A() {
        return "google_analytics_v4.db";
    }

    /* renamed from: B */
    public String mo6725B() {
        return "google_analytics2_v4.db";
    }

    /* renamed from: C */
    public long mo6726C() {
        return 86400000;
    }

    /* renamed from: D */
    public int mo6727D() {
        return C0551bk.f3804E.mo6775a().intValue();
    }

    /* renamed from: E */
    public int mo6728E() {
        return C0551bk.f3805F.mo6775a().intValue();
    }

    /* renamed from: F */
    public long mo6729F() {
        return C0551bk.f3806G.mo6775a().longValue();
    }

    /* renamed from: G */
    public long mo6730G() {
        return C0551bk.f3815P.mo6775a().longValue();
    }

    /* renamed from: a */
    public boolean mo6731a() {
        return C1015f.f4727a;
    }

    /* renamed from: b */
    public boolean mo6732b() {
        if (this.f3786b == null) {
            synchronized (this) {
                if (this.f3786b == null) {
                    ApplicationInfo applicationInfo = this.f3785a.mo6600b().getApplicationInfo();
                    String a = C0619ah.m3572a(this.f3785a.mo6600b(), Process.myPid());
                    if (applicationInfo != null) {
                        String str = applicationInfo.processName;
                        this.f3786b = Boolean.valueOf(str != null && str.equals(a));
                    }
                    if ((this.f3786b == null || !this.f3786b.booleanValue()) && "com.google.android.gms.analytics".equals(a)) {
                        this.f3786b = Boolean.TRUE;
                    }
                    if (this.f3786b == null) {
                        this.f3786b = Boolean.TRUE;
                        this.f3785a.mo6604f().mo6881f("My process not in the list of running processes");
                    }
                }
            }
        }
        return this.f3786b.booleanValue();
    }

    /* renamed from: c */
    public boolean mo6733c() {
        return C0551bk.f3818b.mo6775a().booleanValue();
    }

    /* renamed from: d */
    public int mo6734d() {
        return C0551bk.f3837u.mo6775a().intValue();
    }

    /* renamed from: e */
    public int mo6735e() {
        return C0551bk.f3841y.mo6775a().intValue();
    }

    /* renamed from: f */
    public int mo6736f() {
        return C0551bk.f3842z.mo6775a().intValue();
    }

    /* renamed from: g */
    public int mo6737g() {
        return C0551bk.f3800A.mo6775a().intValue();
    }

    /* renamed from: h */
    public long mo6738h() {
        return C0551bk.f3826j.mo6775a().longValue();
    }

    /* renamed from: i */
    public long mo6739i() {
        return C0551bk.f3825i.mo6775a().longValue();
    }

    /* renamed from: j */
    public long mo6740j() {
        return C0551bk.f3829m.mo6775a().longValue();
    }

    /* renamed from: k */
    public long mo6741k() {
        return C0551bk.f3830n.mo6775a().longValue();
    }

    /* renamed from: l */
    public int mo6742l() {
        return C0551bk.f3831o.mo6775a().intValue();
    }

    /* renamed from: m */
    public int mo6743m() {
        return C0551bk.f3832p.mo6775a().intValue();
    }

    /* renamed from: n */
    public long mo6744n() {
        return (long) C0551bk.f3802C.mo6775a().intValue();
    }

    /* renamed from: o */
    public String mo6745o() {
        return C0551bk.f3834r.mo6775a();
    }

    /* renamed from: p */
    public String mo6746p() {
        return C0551bk.f3833q.mo6775a();
    }

    /* renamed from: q */
    public String mo6747q() {
        return C0551bk.f3835s.mo6775a();
    }

    /* renamed from: r */
    public String mo6748r() {
        return C0551bk.f3836t.mo6775a();
    }

    /* renamed from: s */
    public C0534au mo6749s() {
        return C0534au.m3118a(C0551bk.f3838v.mo6775a());
    }

    /* renamed from: t */
    public C0538ay mo6750t() {
        return C0538ay.m3130a(C0551bk.f3839w.mo6775a());
    }

    /* renamed from: u */
    public Set<Integer> mo6751u() {
        String a = C0551bk.f3801B.mo6775a();
        if (this.f3788d == null || this.f3787c == null || !this.f3787c.equals(a)) {
            String[] split = TextUtils.split(a, ",");
            HashSet hashSet = new HashSet();
            for (String parseInt : split) {
                try {
                    hashSet.add(Integer.valueOf(Integer.parseInt(parseInt)));
                } catch (NumberFormatException e) {
                }
            }
            this.f3787c = a;
            this.f3788d = hashSet;
        }
        return this.f3788d;
    }

    /* renamed from: v */
    public long mo6752v() {
        return C0551bk.f3810K.mo6775a().longValue();
    }

    /* renamed from: w */
    public long mo6753w() {
        return C0551bk.f3811L.mo6775a().longValue();
    }

    /* renamed from: x */
    public long mo6754x() {
        return C0551bk.f3814O.mo6775a().longValue();
    }

    /* renamed from: y */
    public int mo6755y() {
        return C0551bk.f3822f.mo6775a().intValue();
    }

    /* renamed from: z */
    public int mo6756z() {
        return C0551bk.f3824h.mo6775a().intValue();
    }
}
