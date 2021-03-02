package com.google.android.gms.common.internal;

import android.util.Log;

/* renamed from: com.google.android.gms.common.internal.ab */
public abstract class C0978ab<TListener> {

    /* renamed from: a */
    private TListener f4676a;

    /* renamed from: b */
    private boolean f4677b = false;

    /* renamed from: d */
    final /* synthetic */ C1037y f4678d;

    public C0978ab(C1037y yVar, TListener tlistener) {
        this.f4678d = yVar;
        this.f4676a = tlistener;
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public abstract void mo7502a(TListener tlistener);

    /* access modifiers changed from: protected */
    /* renamed from: b */
    public abstract void mo7503b();

    /* renamed from: c */
    public void mo7504c() {
        TListener tlistener;
        synchronized (this) {
            tlistener = this.f4676a;
            if (this.f4677b) {
                Log.w("GmsClient", "Callback proxy " + this + " being reused. This is not safe.");
            }
        }
        if (tlistener != null) {
            try {
                mo7502a(tlistener);
            } catch (RuntimeException e) {
                mo7503b();
                throw e;
            }
        } else {
            mo7503b();
        }
        synchronized (this) {
            this.f4677b = true;
        }
        mo7505d();
    }

    /* renamed from: d */
    public void mo7505d() {
        mo7506e();
        synchronized (this.f4678d.f4778m) {
            this.f4678d.f4778m.remove(this);
        }
    }

    /* renamed from: e */
    public void mo7506e() {
        synchronized (this) {
            this.f4676a = null;
        }
    }
}
