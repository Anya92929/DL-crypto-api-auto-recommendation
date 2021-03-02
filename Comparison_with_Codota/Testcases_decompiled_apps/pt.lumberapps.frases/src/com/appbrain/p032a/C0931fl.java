package com.appbrain.p032a;

import android.os.Bundle;
import android.os.SystemClock;
import android.view.View;

/* renamed from: com.appbrain.a.fl */
public final class C0931fl {

    /* renamed from: a */
    private C0930fk f2441a;

    /* renamed from: b */
    private C0929fj f2442b;

    /* renamed from: c */
    private long f2443c;

    /* renamed from: a */
    public final View mo3831a() {
        if (this.f2442b == null) {
            return null;
        }
        return this.f2442b.mo3661a();
    }

    /* renamed from: a */
    public final View mo3832a(C0930fk fkVar, Bundle bundle) {
        this.f2441a = fkVar;
        if (!C0926fg.m3925a().mo3820d() || fkVar.mo3583a()) {
            this.f2442b = null;
            return new View(fkVar.getContext());
        }
        this.f2442b = C0934fo.m3995a(fkVar);
        if (this.f2442b == null) {
            return new View(fkVar.getContext());
        }
        View a = this.f2442b.mo3662a(fkVar.getArguments(), bundle);
        if (bundle == null) {
            this.f2443c = SystemClock.elapsedRealtime();
            if (C0929fj.f2436d != null) {
                C0929fj.f2436d.mo3385a(this.f2442b);
            }
            C0794aj.m3604a(this.f2442b.f2439g, C0799ao.PRESENTED);
            return a;
        }
        this.f2443c = bundle.getLong("StartTime");
        return a;
    }

    /* renamed from: a */
    public final void mo3833a(Bundle bundle) {
        bundle.putLong("StartTime", this.f2443c);
        if (this.f2442b != null) {
            this.f2442b.mo3825a(bundle);
        }
    }

    /* renamed from: b */
    public final boolean mo3834b() {
        return this.f2442b != null && (this.f2442b.mo3699e() || (this.f2442b.mo3665d() && SystemClock.elapsedRealtime() < this.f2443c + 1500));
    }

    /* renamed from: c */
    public final void mo3835c() {
        if (this.f2442b == null) {
            this.f2441a.mo3584b();
        }
    }

    /* renamed from: d */
    public final void mo3836d() {
        if (this.f2442b != null) {
            C0929fj.m3941b(this.f2442b);
            this.f2442b.mo3663b();
        }
    }

    /* renamed from: e */
    public final void mo3837e() {
        if (this.f2442b != null) {
            C0929fj.m3941b(this.f2442b);
        }
    }

    /* renamed from: f */
    public final void mo3838f() {
        if (this.f2442b != null) {
            C0929fj.m3941b(this.f2442b);
            this.f2442b.mo3664c();
        }
    }
}
