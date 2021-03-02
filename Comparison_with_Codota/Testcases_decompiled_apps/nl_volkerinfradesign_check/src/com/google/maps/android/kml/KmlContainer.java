package com.google.maps.android.kml;

import com.google.android.gms.maps.model.GroundOverlay;
import java.util.ArrayList;
import java.util.HashMap;

public class KmlContainer {

    /* renamed from: a */
    private final HashMap<String, String> f3993a;

    /* renamed from: b */
    private final HashMap<KmlPlacemark, Object> f3994b;

    /* renamed from: c */
    private final ArrayList<KmlContainer> f3995c;

    /* renamed from: d */
    private final HashMap<KmlGroundOverlay, GroundOverlay> f3996d;

    /* renamed from: e */
    private final HashMap<String, String> f3997e;

    /* renamed from: f */
    private HashMap<String, C1221hu> f3998f;

    /* renamed from: g */
    private String f3999g;

    public KmlContainer(HashMap<String, String> hashMap, HashMap<String, C1221hu> hashMap2, HashMap<KmlPlacemark, Object> hashMap3, HashMap<String, String> hashMap4, ArrayList<KmlContainer> arrayList, HashMap<KmlGroundOverlay, GroundOverlay> hashMap5, String str) {
        this.f3993a = hashMap;
        this.f3994b = hashMap3;
        this.f3998f = hashMap2;
        this.f3997e = hashMap4;
        this.f3995c = arrayList;
        this.f3996d = hashMap5;
        this.f3999g = str;
    }

    /* renamed from: a */
    public HashMap<String, C1221hu> mo7941a() {
        return this.f3998f;
    }

    /* renamed from: a */
    public void mo7942a(KmlPlacemark kmlPlacemark, Object obj) {
        this.f3994b.put(kmlPlacemark, obj);
    }

    /* renamed from: b */
    public HashMap<String, String> mo7943b() {
        return this.f3997e;
    }

    /* renamed from: c */
    public HashMap<KmlGroundOverlay, GroundOverlay> mo7944c() {
        return this.f3996d;
    }

    public String getContainerId() {
        return this.f3999g;
    }

    public C1221hu getStyle(String str) {
        return this.f3998f.get(str);
    }

    /* renamed from: d */
    public HashMap<KmlPlacemark, Object> mo7945d() {
        return this.f3994b;
    }

    public String getProperty(String str) {
        return this.f3993a.get(str);
    }

    public boolean hasProperties() {
        return this.f3993a.size() > 0;
    }

    public boolean hasProperty(String str) {
        return this.f3993a.containsKey(str);
    }

    public boolean hasContainers() {
        return this.f3995c.size() > 0;
    }

    public Iterable<KmlContainer> getContainers() {
        return this.f3995c;
    }

    public Iterable<String> getProperties() {
        return this.f3993a.keySet();
    }

    public Iterable<KmlPlacemark> getPlacemarks() {
        return this.f3994b.keySet();
    }

    public boolean hasPlacemarks() {
        return this.f3994b.size() > 0;
    }

    public Iterable<KmlGroundOverlay> getGroundOverlays() {
        return this.f3996d.keySet();
    }

    public String toString() {
        StringBuilder append = new StringBuilder("Container").append("{");
        append.append("\n properties=").append(this.f3993a);
        append.append(",\n placemarks=").append(this.f3994b);
        append.append(",\n containers=").append(this.f3995c);
        append.append(",\n ground overlays=").append(this.f3996d);
        append.append(",\n style maps=").append(this.f3997e);
        append.append(",\n styles=").append(this.f3998f);
        append.append("\n}\n");
        return append.toString();
    }
}
