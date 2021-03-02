package com.google.android.gms.maps.internal;

import com.google.android.gms.maps.OnStreetViewPanoramaReadyCallback;
import com.google.android.gms.p017b.C0596a;

public interface StreetViewLifecycleDelegate extends C0596a {
    void getStreetViewPanoramaAsync(OnStreetViewPanoramaReadyCallback onStreetViewPanoramaReadyCallback);
}
