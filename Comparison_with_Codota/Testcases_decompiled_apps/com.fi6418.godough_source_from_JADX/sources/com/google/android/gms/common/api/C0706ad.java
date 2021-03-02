package com.google.android.gms.common.api;

import android.os.Looper;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.internal.C1009bf;
import java.lang.ref.WeakReference;

/* renamed from: com.google.android.gms.common.api.ad */
class C0706ad implements C0756u {

    /* renamed from: a */
    private final WeakReference<C0758w> f4431a;

    /* renamed from: b */
    private final C0702a<?> f4432b;

    /* renamed from: c */
    private final int f4433c;

    public C0706ad(C0758w wVar, C0702a<?> aVar, int i) {
        this.f4431a = new WeakReference<>(wVar);
        this.f4432b = aVar;
        this.f4433c = i;
    }

    /* renamed from: a */
    public void mo7358a(ConnectionResult connectionResult) {
        boolean z = false;
        C0758w wVar = (C0758w) this.f4431a.get();
        if (wVar != null) {
            if (Looper.myLooper() == wVar.f4533a.mo7392l()) {
                z = true;
            }
            C1009bf.m4533a(z, (Object) "onReportServiceBinding must be called on the GoogleApiClient handler thread");
            wVar.f4534b.lock();
            try {
                if (wVar.m4137b(0)) {
                    if (!connectionResult.mo7323b()) {
                        wVar.m4136b(connectionResult, this.f4432b, this.f4433c);
                    }
                    if (wVar.m4146e()) {
                        wVar.m4149f();
                    }
                    wVar.f4534b.unlock();
                }
            } finally {
                wVar.f4534b.unlock();
            }
        }
    }

    /* renamed from: b */
    public void mo7359b(ConnectionResult connectionResult) {
        boolean z = true;
        C0758w wVar = (C0758w) this.f4431a.get();
        if (wVar != null) {
            if (Looper.myLooper() != wVar.f4533a.mo7392l()) {
                z = false;
            }
            C1009bf.m4533a(z, (Object) "onReportAccountValidation must be called on the GoogleApiClient handler thread");
            wVar.f4534b.lock();
            try {
                if (wVar.m4137b(1)) {
                    if (!connectionResult.mo7323b()) {
                        wVar.m4136b(connectionResult, this.f4432b, this.f4433c);
                    }
                    if (wVar.m4146e()) {
                        wVar.m4153h();
                    }
                    wVar.f4534b.unlock();
                }
            } finally {
                wVar.f4534b.unlock();
            }
        }
    }
}
