package com.google.android.gms.maps.internal;

import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.p017b.C0596a;

public interface MapLifecycleDelegate extends C0596a {
    void getMapAsync(OnMapReadyCallback onMapReadyCallback);
}
