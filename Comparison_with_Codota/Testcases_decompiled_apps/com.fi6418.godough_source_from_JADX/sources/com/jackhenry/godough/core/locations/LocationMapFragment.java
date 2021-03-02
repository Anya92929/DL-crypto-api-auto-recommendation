package com.jackhenry.godough.core.locations;

import android.util.DisplayMetrics;
import android.view.View;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;
import com.jackhenry.android.p022a.p023a.C1350b;
import com.jackhenry.godough.core.C1493ah;
import com.jackhenry.godough.core.C1506am;
import com.jackhenry.godough.core.model.GoDoughLocation;
import java.util.HashMap;
import java.util.Map;

public class LocationMapFragment extends SupportMapFragment implements GoogleMap.OnInfoWindowClickListener, C1601ae {

    /* renamed from: a */
    private transient Map<String, GoDoughLocation> f6202a = new HashMap();

    /* renamed from: b */
    private C1350b<GoDoughLocation> f6203b;
    /* access modifiers changed from: private */

    /* renamed from: c */
    public View f6204c;
    /* access modifiers changed from: private */

    /* renamed from: d */
    public Marker f6205d;
    /* access modifiers changed from: private */

    /* renamed from: e */
    public double f6206e = 10.0d;
    /* access modifiers changed from: private */

    /* renamed from: f */
    public GoogleMap f6207f;

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m6246a(GoogleMap googleMap, LatLng latLng) {
        this.f6205d = googleMap.addMarker(new MarkerOptions().title(getString(C1506am.lbl_my_location)).icon(BitmapDescriptorFactory.fromResource(C1493ah.transparent)).position(latLng));
    }

    /* renamed from: m */
    private void m6251m() {
        if (getMap() != null) {
            GoogleMap map = getMap();
            map.clear();
            if (this.f6205d != null) {
                m6246a(map, this.f6205d.getPosition());
            }
            for (int i = 0; i < this.f6203b.getCount(); i++) {
                GoDoughLocation a = this.f6203b.mo9263a(i);
                if ((a.getLatitude() != 0.0d) && (a.getLongitude() != 0.0d)) {
                    Marker addMarker = map.addMarker(new MarkerOptions().position(new LatLng(a.getLatitude(), a.getLongitude())).title(a.getLocationName()).snippet(a.getAddress1()));
                    this.f6202a.put(addMarker.getTitle() + addMarker.getSnippet(), a);
                }
            }
        }
    }

    public GoogleMap getGoogleMap() {
        return this.f6207f;
    }

    public void onInfoWindowClick(Marker marker) {
        GoDoughLocation goDoughLocation = this.f6202a.get(marker.getTitle() + marker.getSnippet());
        if (goDoughLocation != null) {
            ((C1618q) getActivity()).onLocationClicked(goDoughLocation);
        }
    }

    public void onLocationsChanged() {
        if (this.f6207f != null) {
            m6251m();
        }
    }

    public void setGoogleMap(GoogleMap googleMap) {
        this.f6207f = googleMap;
    }

    public void updateMap() {
        this.f6203b = ((LocationResultsFragmentActivity) getActivity()).getLocationAdapter();
        this.f6207f = getMap();
        this.f6204c = getView();
        getActivity().getWindowManager().getDefaultDisplay().getMetrics(new DisplayMetrics());
        if (this.f6207f != null) {
            m6251m();
            this.f6207f.setOnInfoWindowClickListener(this);
            this.f6207f.setInfoWindowAdapter(new C1616o(this, getActivity().getLayoutInflater()));
            this.f6207f.setOnMyLocationChangeListener(new C1614m(this));
            this.f6207f.setOnCameraChangeListener(new C1615n(this));
        }
    }
}
