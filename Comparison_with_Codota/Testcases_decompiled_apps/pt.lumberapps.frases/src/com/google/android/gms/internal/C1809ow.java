package com.google.android.gms.internal;

import android.os.Bundle;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.GoogleApiClient;

/* renamed from: com.google.android.gms.internal.ow */
class C1809ow implements GoogleApiClient.ConnectionCallbacks, GoogleApiClient.OnConnectionFailedListener {

    /* renamed from: a */
    final /* synthetic */ zzpw f5460a;

    private C1809ow(zzpw zzpw) {
        this.f5460a = zzpw;
    }

    /* synthetic */ C1809ow(zzpw zzpw, C1801oo ooVar) {
        this(zzpw);
    }

    public void onConnected(Bundle bundle) {
        this.f5460a.f6825k.zza(new C1807ou(this.f5460a));
    }

    public void onConnectionFailed(ConnectionResult connectionResult) {
        this.f5460a.f6816b.lock();
        try {
            if (this.f5460a.m7449b(connectionResult)) {
                this.f5460a.m7456e();
                this.f5460a.m7448b();
            } else {
                this.f5460a.m7453c(connectionResult);
            }
        } finally {
            this.f5460a.f6816b.unlock();
        }
    }

    public void onConnectionSuspended(int i) {
    }
}
