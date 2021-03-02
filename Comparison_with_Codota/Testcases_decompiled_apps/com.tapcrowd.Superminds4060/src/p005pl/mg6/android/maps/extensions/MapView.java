package p005pl.mg6.android.maps.extensions;

import android.content.Context;
import android.util.AttributeSet;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.GoogleMapOptions;
import p005pl.mg6.android.maps.extensions.impl.DelegatingGoogleMap;

/* renamed from: pl.mg6.android.maps.extensions.MapView */
public class MapView extends com.google.android.gms.maps.MapView {
    private GoogleMap map;

    public MapView(Context context) {
        super(context);
    }

    public MapView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public MapView(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
    }

    public MapView(Context context, GoogleMapOptions options) {
        super(context, options);
    }

    public GoogleMap getExtendedMap() {
        GoogleMap realMap;
        if (this.map == null && (realMap = super.getMap()) != null) {
            this.map = new DelegatingGoogleMap(realMap);
        }
        return this.map;
    }
}
