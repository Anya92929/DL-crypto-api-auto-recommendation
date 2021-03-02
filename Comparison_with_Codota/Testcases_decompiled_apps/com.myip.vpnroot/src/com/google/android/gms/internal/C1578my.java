package com.google.android.gms.internal;

import android.content.Intent;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.panorama.PanoramaApi;

/* renamed from: com.google.android.gms.internal.my */
public class C1578my extends C1596nd implements PanoramaApi.C1928a {
    private final int akm;

    public C1578my(Status status, Intent intent, int i) {
        super(status, intent);
        this.akm = i;
    }

    public /* bridge */ /* synthetic */ Status getStatus() {
        return super.getStatus();
    }

    public /* bridge */ /* synthetic */ Intent getViewerIntent() {
        return super.getViewerIntent();
    }
}
