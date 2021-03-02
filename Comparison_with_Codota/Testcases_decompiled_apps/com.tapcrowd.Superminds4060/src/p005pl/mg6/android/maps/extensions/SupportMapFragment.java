package p005pl.mg6.android.maps.extensions;

import android.os.Bundle;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.GoogleMapOptions;
import p005pl.mg6.android.maps.extensions.impl.DelegatingGoogleMap;

/* renamed from: pl.mg6.android.maps.extensions.SupportMapFragment */
public class SupportMapFragment extends com.google.android.gms.maps.SupportMapFragment {
    private static final String MAP_OPTIONS = "MapOptions";
    private GoogleMap map;

    public static SupportMapFragment newInstance() {
        return new SupportMapFragment();
    }

    public static SupportMapFragment newInstance(GoogleMapOptions options) {
        SupportMapFragment f = new SupportMapFragment();
        Bundle args = new Bundle();
        args.putParcelable(MAP_OPTIONS, options);
        f.setArguments(args);
        return f;
    }

    public GoogleMap getExtendedMap() {
        GoogleMap realMap;
        if (this.map == null && (realMap = super.getMap()) != null) {
            this.map = new DelegatingGoogleMap(realMap);
        }
        return this.map;
    }
}
