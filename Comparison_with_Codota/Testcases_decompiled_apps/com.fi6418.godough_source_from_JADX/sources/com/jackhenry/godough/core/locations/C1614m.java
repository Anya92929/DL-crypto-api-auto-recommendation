package com.jackhenry.godough.core.locations;

import android.location.Location;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.model.LatLng;

/* renamed from: com.jackhenry.godough.core.locations.m */
class C1614m implements GoogleMap.OnMyLocationChangeListener {

    /* renamed from: a */
    final /* synthetic */ LocationMapFragment f6251a;

    C1614m(LocationMapFragment locationMapFragment) {
        this.f6251a = locationMapFragment;
    }

    public void onMyLocationChange(Location location) {
        if (this.f6251a.f6205d == null) {
            this.f6251a.m6246a(this.f6251a.f6207f, new LatLng(location.getLatitude(), location.getLongitude()));
        } else {
            this.f6251a.f6205d.setPosition(new LatLng(location.getLatitude(), location.getLongitude()));
        }
    }
}
