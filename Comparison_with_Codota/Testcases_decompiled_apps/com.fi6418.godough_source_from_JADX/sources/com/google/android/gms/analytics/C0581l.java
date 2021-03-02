package com.google.android.gms.analytics;

import android.content.Context;
import com.google.android.gms.analytics.internal.C0516ac;
import com.google.android.gms.analytics.internal.C0560h;
import com.google.android.gms.analytics.internal.C0561i;
import com.google.android.gms.analytics.internal.C0571s;
import com.google.android.gms.analytics.internal.C0572t;
import com.google.android.gms.common.internal.C1009bf;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/* renamed from: com.google.android.gms.analytics.l */
public final class C0581l extends C0592w {

    /* renamed from: b */
    private static List<Runnable> f3916b = new ArrayList();

    /* renamed from: c */
    private boolean f3917c;

    /* renamed from: d */
    private boolean f3918d;

    /* renamed from: e */
    private Set<Object> f3919e = new HashSet();

    /* renamed from: f */
    private boolean f3920f;

    /* renamed from: g */
    private volatile boolean f3921g;

    public C0581l(C0516ac acVar) {
        super(acVar);
    }

    /* renamed from: a */
    public static C0581l m3407a(Context context) {
        return C0516ac.m2979a(context).mo6609k();
    }

    /* renamed from: d */
    public static void m3408d() {
        synchronized (C0581l.class) {
            if (f3916b != null) {
                for (Runnable run : f3916b) {
                    run.run();
                }
                f3916b = null;
            }
        }
    }

    /* renamed from: p */
    private C0572t m3409p() {
        return mo6938k().mo6607i();
    }

    /* renamed from: q */
    private C0571s m3410q() {
        return mo6938k().mo6610l();
    }

    /* renamed from: a */
    public C0589t mo6902a(String str) {
        C0589t tVar;
        synchronized (this) {
            tVar = new C0589t(mo6938k(), str, (C0560h) null);
            tVar.mo6597E();
        }
        return tVar;
    }

    /* renamed from: a */
    public void mo6903a() {
        mo6905b();
        this.f3917c = true;
    }

    /* renamed from: a */
    public void mo6904a(boolean z) {
        this.f3920f = z;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: b */
    public void mo6905b() {
        C0587r a;
        C0571s q = m3410q();
        if (q.mo6839d()) {
            mo6909g().mo6758a(q.mo6840e());
        }
        if (q.mo6843h()) {
            mo6904a(q.mo6844i());
        }
        if (q.mo6839d() && (a = C0561i.m3257a()) != null) {
            a.mo6758a(q.mo6840e());
        }
    }

    /* renamed from: c */
    public boolean mo6906c() {
        return this.f3917c && !this.f3918d;
    }

    /* renamed from: e */
    public boolean mo6907e() {
        return this.f3920f;
    }

    /* renamed from: f */
    public boolean mo6908f() {
        return this.f3921g;
    }

    @Deprecated
    /* renamed from: g */
    public C0587r mo6909g() {
        return C0561i.m3257a();
    }

    /* renamed from: h */
    public String mo6910h() {
        C1009bf.m4538c("getClientId can not be called from the main thread");
        return mo6938k().mo6614p().mo6706b();
    }

    /* renamed from: i */
    public void mo6911i() {
        m3409p().mo6852c();
    }

    /* access modifiers changed from: package-private */
    /* renamed from: j */
    public void mo6912j() {
        m3409p().mo6853d();
    }
}
