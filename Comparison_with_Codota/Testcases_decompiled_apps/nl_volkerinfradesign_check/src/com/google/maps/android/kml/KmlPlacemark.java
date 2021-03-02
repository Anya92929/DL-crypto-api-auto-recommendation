package com.google.maps.android.kml;

import java.util.HashMap;

public class KmlPlacemark {

    /* renamed from: a */
    private final KmlGeometry f4007a;

    /* renamed from: b */
    private final String f4008b;

    /* renamed from: c */
    private final C1221hu f4009c;

    /* renamed from: d */
    private HashMap<String, String> f4010d = new HashMap<>();

    public KmlPlacemark(KmlGeometry kmlGeometry, String str, C1221hu huVar, HashMap<String, String> hashMap) {
        this.f4007a = kmlGeometry;
        this.f4008b = str;
        this.f4009c = huVar;
        this.f4010d = hashMap;
    }

    public String getStyleId() {
        return this.f4008b;
    }

    public C1221hu getInlineStyle() {
        return this.f4009c;
    }

    public Iterable getProperties() {
        return this.f4010d.entrySet();
    }

    public String getProperty(String str) {
        return this.f4010d.get(str);
    }

    public KmlGeometry getGeometry() {
        return this.f4007a;
    }

    public boolean hasProperty(String str) {
        return this.f4010d.containsKey(str);
    }

    public boolean hasProperties() {
        return this.f4010d.size() > 0;
    }

    public String toString() {
        StringBuilder append = new StringBuilder("Placemark").append("{");
        append.append("\n style id=").append(this.f4008b);
        append.append(",\n inline style=").append(this.f4009c);
        append.append(",\n properties=").append(this.f4010d);
        append.append(",\n geometry=").append(this.f4007a);
        append.append("\n}\n");
        return append.toString();
    }
}
