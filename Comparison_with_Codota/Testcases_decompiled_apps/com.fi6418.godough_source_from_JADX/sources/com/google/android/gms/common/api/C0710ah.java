package com.google.android.gms.common.api;

import android.os.Bundle;
import com.google.android.gms.common.ConnectionResult;

/* renamed from: com.google.android.gms.common.api.ah */
class C0710ah implements C0752q, C0753r {

    /* renamed from: a */
    final /* synthetic */ C0758w f4440a;

    private C0710ah(C0758w wVar) {
        this.f4440a = wVar;
    }

    /* synthetic */ C0710ah(C0758w wVar, C0759x xVar) {
        this(wVar);
    }

    public void onConnected(Bundle bundle) {
        this.f4440a.f4544l.mo9016a(new C0703aa(this.f4440a));
    }

    public void onConnectionFailed(ConnectionResult connectionResult) {
        this.f4440a.f4534b.lock();
        try {
            if (this.f4440a.m4143c(connectionResult)) {
                this.f4440a.m4158k();
                this.f4440a.m4154i();
            } else {
                this.f4440a.m4145d(connectionResult);
            }
        } finally {
            this.f4440a.f4534b.unlock();
        }
    }

    public void onConnectionSuspended(int i) {
    }
}
