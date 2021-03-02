package com.google.android.gms.ads.mediation.admob;

import android.os.Bundle;
import com.google.ads.mediation.NetworkExtras;

public final class AdMobExtras implements NetworkExtras {

    /* renamed from: im */
    private final Bundle f326im;

    public AdMobExtras(Bundle extras) {
        this.f326im = extras != null ? new Bundle(extras) : null;
    }

    public Bundle getExtras() {
        return this.f326im;
    }
}
