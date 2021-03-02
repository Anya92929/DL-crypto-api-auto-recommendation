package com.google.android.gms.maps;

import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.internal.zze;
import com.google.android.gms.maps.model.CameraPosition;

/* renamed from: com.google.android.gms.maps.l */
class C1215l extends zze.zza {

    /* renamed from: a */
    final /* synthetic */ GoogleMap.OnCameraChangeListener f5118a;

    /* renamed from: b */
    final /* synthetic */ GoogleMap f5119b;

    C1215l(GoogleMap googleMap, GoogleMap.OnCameraChangeListener onCameraChangeListener) {
        this.f5119b = googleMap;
        this.f5118a = onCameraChangeListener;
    }

    public void onCameraChange(CameraPosition cameraPosition) {
        this.f5118a.onCameraChange(cameraPosition);
    }
}
