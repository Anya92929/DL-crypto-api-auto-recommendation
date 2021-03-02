package com.jackhenry.godough.core.locations;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.model.CameraPosition;
import com.google.android.gms.maps.model.LatLngBounds;
import com.jackhenry.godough.core.model.LocationSearchCriteria;

/* renamed from: com.jackhenry.godough.core.locations.n */
class C1615n implements GoogleMap.OnCameraChangeListener {

    /* renamed from: a */
    final /* synthetic */ LocationMapFragment f6252a;

    C1615n(LocationMapFragment locationMapFragment) {
        this.f6252a = locationMapFragment;
    }

    public void onCameraChange(CameraPosition cameraPosition) {
        if (this.f6252a.f6207f != null) {
            this.f6252a.f6207f.setMyLocationEnabled(true);
            LocationSearchCriteria locationSearchCriteria = (LocationSearchCriteria) this.f6252a.getActivity().getIntent().getExtras().getSerializable(LocationSearchCriteria.KEY_LOCATION_SEARCH_CRITERIA);
            boolean booleanExtra = this.f6252a.getActivity().getIntent().getBooleanExtra(LocationResultsFragmentActivity.PARAM_SHOW_ALL, false);
            if (locationSearchCriteria != null && locationSearchCriteria.getLatLng() != null) {
                double unused = this.f6252a.f6206e = 10.0d;
                if (booleanExtra) {
                    double unused2 = this.f6252a.f6206e = C1620s.m6281a(locationSearchCriteria);
                }
                this.f6252a.f6207f.moveCamera(CameraUpdateFactory.newLatLngBounds(new LatLngBounds(C1620s.m6282a(locationSearchCriteria.getLatLng(), false, this.f6252a.f6206e), C1620s.m6282a(locationSearchCriteria.getLatLng(), true, this.f6252a.f6206e)), this.f6252a.f6204c.getWidth(), this.f6252a.f6204c.getHeight(), 5));
            } else if (locationSearchCriteria == null || locationSearchCriteria.getLatLng() == null) {
                this.f6252a.f6207f.moveCamera(CameraUpdateFactory.newLatLngBounds(C1620s.m6283a(), this.f6252a.f6204c.getWidth(), this.f6252a.f6204c.getHeight(), 5));
            }
        }
        this.f6252a.f6207f.setOnCameraChangeListener((GoogleMap.OnCameraChangeListener) null);
    }
}
