package com.google.maps.android.kml;

import com.google.android.gms.maps.model.GroundOverlayOptions;
import com.google.android.gms.maps.model.LatLngBounds;
import java.util.HashMap;
import java.util.Map;

public class KmlGroundOverlay {

    /* renamed from: a */
    private final Map<String, String> f4000a;

    /* renamed from: b */
    private final GroundOverlayOptions f4001b = new GroundOverlayOptions();

    /* renamed from: c */
    private String f4002c;

    /* renamed from: d */
    private LatLngBounds f4003d;

    public KmlGroundOverlay(String str, LatLngBounds latLngBounds, float f, int i, HashMap<String, String> hashMap, float f2) {
        this.f4002c = str;
        this.f4000a = hashMap;
        if (latLngBounds == null) {
            throw new IllegalArgumentException("No LatLonBox given");
        }
        this.f4003d = latLngBounds;
        this.f4001b.positionFromBounds(latLngBounds);
        this.f4001b.bearing(f2);
        this.f4001b.zIndex(f);
        this.f4001b.visible(i != 0);
    }

    public String getImageUrl() {
        return this.f4002c;
    }

    public LatLngBounds getLatLngBox() {
        return this.f4003d;
    }

    public Iterable<String> getProperties() {
        return this.f4000a.keySet();
    }

    public String getProperty(String str) {
        return this.f4000a.get(str);
    }

    public boolean hasProperty(String str) {
        return this.f4000a.get(str) != null;
    }

    /* renamed from: a */
    public GroundOverlayOptions mo7960a() {
        return this.f4001b;
    }

    public String toString() {
        StringBuilder append = new StringBuilder("GroundOverlay").append("{");
        append.append("\n properties=").append(this.f4000a);
        append.append(",\n image url=").append(this.f4002c);
        append.append(",\n LatLngBox=").append(this.f4003d);
        append.append("\n}\n");
        return append.toString();
    }
}
