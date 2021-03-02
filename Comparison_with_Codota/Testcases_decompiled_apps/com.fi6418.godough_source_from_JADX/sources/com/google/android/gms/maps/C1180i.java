package com.google.android.gms.maps;

import android.graphics.Bitmap;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.internal.zzw;
import com.google.android.gms.p017b.C0605j;
import com.google.android.gms.p017b.C0608m;

/* renamed from: com.google.android.gms.maps.i */
class C1180i extends zzw.zza {

    /* renamed from: a */
    final /* synthetic */ GoogleMap.SnapshotReadyCallback f5078a;

    /* renamed from: b */
    final /* synthetic */ GoogleMap f5079b;

    C1180i(GoogleMap googleMap, GoogleMap.SnapshotReadyCallback snapshotReadyCallback) {
        this.f5079b = googleMap;
        this.f5078a = snapshotReadyCallback;
    }

    public void onSnapshotReady(Bitmap bitmap) {
        this.f5078a.onSnapshotReady(bitmap);
    }

    public void zzr(C0605j jVar) {
        this.f5078a.onSnapshotReady((Bitmap) C0608m.m3537a(jVar));
    }
}
