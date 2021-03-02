package com.google.android.gms.maps;

import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.internal.zzb;

/* renamed from: com.google.android.gms.maps.o */
final class C1230o extends zzb.zza {

    /* renamed from: a */
    private final GoogleMap.CancelableCallback f5225a;

    C1230o(GoogleMap.CancelableCallback cancelableCallback) {
        this.f5225a = cancelableCallback;
    }

    public void onCancel() {
        this.f5225a.onCancel();
    }

    public void onFinish() {
        this.f5225a.onFinish();
    }
}
