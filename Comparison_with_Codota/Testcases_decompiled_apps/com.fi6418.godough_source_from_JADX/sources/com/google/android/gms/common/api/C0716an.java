package com.google.android.gms.common.api;

import android.os.Bundle;

/* renamed from: com.google.android.gms.common.api.an */
class C0716an implements C0752q {

    /* renamed from: a */
    final /* synthetic */ C0714al f4473a;

    C0716an(C0714al alVar) {
        this.f4473a = alVar;
    }

    public void onConnected(Bundle bundle) {
        this.f4473a.f4456k.lock();
        try {
            this.f4473a.f4467v.mo7366a(bundle);
        } finally {
            this.f4473a.f4456k.unlock();
        }
    }

    public void onConnectionSuspended(int i) {
        this.f4473a.f4456k.lock();
        try {
            this.f4473a.f4467v.mo7365a(i);
        } finally {
            this.f4473a.f4456k.unlock();
        }
    }
}
