package com.google.android.gms.internal;

import android.content.Intent;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.internal.C0348n;
import com.google.android.gms.panorama.PanoramaApi;

/* renamed from: com.google.android.gms.internal.nd */
class C1596nd implements PanoramaApi.PanoramaResult {

    /* renamed from: CM */
    private final Status f4301CM;
    private final Intent akr;

    public C1596nd(Status status, Intent intent) {
        this.f4301CM = (Status) C0348n.m861i(status);
        this.akr = intent;
    }

    public Status getStatus() {
        return this.f4301CM;
    }

    public Intent getViewerIntent() {
        return this.akr;
    }
}
