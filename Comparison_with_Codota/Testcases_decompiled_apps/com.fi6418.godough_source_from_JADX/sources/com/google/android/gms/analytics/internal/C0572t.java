package com.google.android.gms.analytics.internal;

import android.content.Context;
import android.content.Intent;
import com.google.android.gms.analytics.C0501a;
import com.google.android.gms.analytics.C0505b;
import com.google.android.gms.common.internal.C1009bf;
import com.google.android.gms.p018c.C0628aq;
import java.util.concurrent.ExecutionException;

/* renamed from: com.google.android.gms.analytics.internal.t */
public class C0572t extends C0514aa {
    /* access modifiers changed from: private */

    /* renamed from: a */
    public final C0528ao f3899a;

    public C0572t(C0516ac acVar, C0518ae aeVar) {
        super(acVar);
        C1009bf.m4528a(aeVar);
        this.f3899a = aeVar.mo6631j(acVar);
    }

    /* renamed from: a */
    public long mo6846a(C0519af afVar) {
        mo6596D();
        C1009bf.m4528a(afVar);
        mo6884m();
        long a = this.f3899a.mo6686a(afVar, true);
        if (a == 0) {
            this.f3899a.mo6687a(afVar);
        }
        return a;
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public void mo6598a() {
        this.f3899a.mo6597E();
    }

    /* renamed from: a */
    public void mo6847a(C0549bi biVar) {
        mo6596D();
        mo6889r().mo7018a((Runnable) new C0576x(this, biVar));
    }

    /* renamed from: a */
    public void mo6848a(C0556d dVar) {
        C1009bf.m4528a(dVar);
        mo6596D();
        mo6870b("Hit delivery requested", dVar);
        mo6889r().mo7018a((Runnable) new C0575w(this, dVar));
    }

    /* renamed from: a */
    public void mo6849a(String str, Runnable runnable) {
        C1009bf.m4531a(str, (Object) "campaign param can't be empty");
        mo6889r().mo7018a((Runnable) new C0574v(this, str, runnable));
    }

    /* renamed from: a */
    public void mo6850a(boolean z) {
        mo6866a("Network connectivity status changed", Boolean.valueOf(z));
        mo6889r().mo7018a((Runnable) new C0573u(this, z));
    }

    /* renamed from: b */
    public void mo6851b() {
        this.f3899a.mo6694b();
    }

    /* renamed from: c */
    public void mo6852c() {
        mo6596D();
        Context o = mo6886o();
        if (!C0501a.m2952a(o) || !C0505b.m2961a(o)) {
            mo6847a((C0549bi) null);
            return;
        }
        Intent intent = new Intent(o, C0505b.class);
        intent.setAction("com.google.android.gms.analytics.ANALYTICS_DISPATCH");
        o.startService(intent);
    }

    /* renamed from: d */
    public boolean mo6853d() {
        mo6596D();
        try {
            mo6889r().mo7016a(new C0577y(this)).get();
            return true;
        } catch (InterruptedException e) {
            mo6877d("syncDispatchLocalHits interrupted", e);
            return false;
        } catch (ExecutionException e2) {
            mo6880e("syncDispatchLocalHits failed", e2);
            return false;
        }
    }

    /* renamed from: e */
    public void mo6854e() {
        mo6596D();
        C0628aq.m3622d();
        this.f3899a.mo6698f();
    }

    /* renamed from: f */
    public void mo6855f() {
        mo6869b("Radio powered up");
        mo6852c();
    }

    /* access modifiers changed from: package-private */
    /* renamed from: g */
    public void mo6856g() {
        mo6884m();
        this.f3899a.mo6697e();
    }

    /* access modifiers changed from: package-private */
    /* renamed from: h */
    public void mo6857h() {
        mo6884m();
        this.f3899a.mo6696d();
    }
}
