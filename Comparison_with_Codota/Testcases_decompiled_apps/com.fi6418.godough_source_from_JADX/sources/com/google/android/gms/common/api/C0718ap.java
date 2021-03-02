package com.google.android.gms.common.api;

import com.google.android.gms.common.ConnectionResult;

/* renamed from: com.google.android.gms.common.api.ap */
class C0718ap implements C0753r {

    /* renamed from: a */
    final /* synthetic */ C0702a f4475a;

    /* renamed from: b */
    final /* synthetic */ int f4476b;

    /* renamed from: c */
    final /* synthetic */ C0714al f4477c;

    C0718ap(C0714al alVar, C0702a aVar, int i) {
        this.f4477c = alVar;
        this.f4475a = aVar;
        this.f4476b = i;
    }

    public void onConnectionFailed(ConnectionResult connectionResult) {
        this.f4477c.f4456k.lock();
        try {
            this.f4477c.f4467v.mo7367a(connectionResult, this.f4475a, this.f4476b);
        } finally {
            this.f4477c.f4456k.unlock();
        }
    }
}
