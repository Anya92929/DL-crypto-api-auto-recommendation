package com.google.android.gms.analytics.internal;

import android.content.ComponentName;
import android.content.ServiceConnection;
import android.os.RemoteException;
import com.google.android.gms.common.internal.C1009bf;
import com.google.android.gms.common.stats.C1093b;
import java.util.Collections;

/* renamed from: com.google.android.gms.analytics.internal.ag */
public class C0520ag extends C0514aa {
    /* access modifiers changed from: private */

    /* renamed from: a */
    public final C0522ai f3727a = new C0522ai(this);

    /* renamed from: b */
    private C0557e f3728b;

    /* renamed from: c */
    private final C0545be f3729c;

    /* renamed from: d */
    private C0569q f3730d;

    protected C0520ag(C0516ac acVar) {
        super(acVar);
        this.f3730d = new C0569q(acVar.mo6602d());
        this.f3729c = new C0521ah(this, acVar);
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m3028a(ComponentName componentName) {
        mo6884m();
        if (this.f3728b != null) {
            this.f3728b = null;
            mo6866a("Disconnected from device AnalyticsService", componentName);
            m3035g();
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m3031a(C0557e eVar) {
        mo6884m();
        this.f3728b = eVar;
        m3033e();
        mo6891t().mo6856g();
    }

    /* renamed from: e */
    private void m3033e() {
        this.f3730d.mo6833a();
        this.f3729c.mo6763a(mo6888q().mo6752v());
    }

    /* access modifiers changed from: private */
    /* renamed from: f */
    public void m3034f() {
        mo6884m();
        if (mo6647b()) {
            mo6869b("Inactivity, disconnecting from device AnalyticsService");
            mo6649d();
        }
    }

    /* renamed from: g */
    private void m3035g() {
        mo6891t().mo6854e();
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public void mo6598a() {
    }

    /* renamed from: a */
    public boolean mo6646a(C0556d dVar) {
        C1009bf.m4528a(dVar);
        mo6884m();
        mo6596D();
        C0557e eVar = this.f3728b;
        if (eVar == null) {
            return false;
        }
        try {
            eVar.mo6797a(dVar.mo6788b(), dVar.mo6790d(), dVar.mo6792f() ? mo6888q().mo6745o() : mo6888q().mo6746p(), Collections.emptyList());
            m3033e();
            return true;
        } catch (RemoteException e) {
            mo6869b("Failed to send hits to AnalyticsService");
            return false;
        }
    }

    /* renamed from: b */
    public boolean mo6647b() {
        mo6884m();
        mo6596D();
        return this.f3728b != null;
    }

    /* renamed from: c */
    public boolean mo6648c() {
        mo6884m();
        mo6596D();
        if (this.f3728b != null) {
            return true;
        }
        C0557e a = this.f3727a.mo6651a();
        if (a == null) {
            return false;
        }
        this.f3728b = a;
        m3033e();
        return true;
    }

    /* renamed from: d */
    public void mo6649d() {
        mo6884m();
        mo6596D();
        try {
            C1093b.m4761a().mo7701a(mo6886o(), (ServiceConnection) this.f3727a);
        } catch (IllegalArgumentException | IllegalStateException e) {
        }
        if (this.f3728b != null) {
            this.f3728b = null;
            m3035g();
        }
    }
}
