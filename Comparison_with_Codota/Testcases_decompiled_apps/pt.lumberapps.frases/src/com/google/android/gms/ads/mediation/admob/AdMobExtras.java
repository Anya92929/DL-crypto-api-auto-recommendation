package com.google.android.gms.ads.mediation.admob;

import android.os.Bundle;
import com.google.ads.mediation.NetworkExtras;

@Deprecated
public final class AdMobExtras implements NetworkExtras {

    /* renamed from: a */
    private final Bundle f4139a;

    public AdMobExtras(Bundle bundle) {
        this.f4139a = bundle != null ? new Bundle(bundle) : null;
    }

    public Bundle getExtras() {
        return this.f4139a;
    }
}
