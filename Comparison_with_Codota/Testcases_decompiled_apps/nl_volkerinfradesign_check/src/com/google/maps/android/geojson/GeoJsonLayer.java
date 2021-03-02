package com.google.maps.android.geojson;

import android.content.Context;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.model.LatLngBounds;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Iterator;
import org.json.JSONException;
import org.json.JSONObject;

public class GeoJsonLayer {

    /* renamed from: a */
    private final C1212ho f3955a;

    /* renamed from: b */
    private LatLngBounds f3956b;

    public GeoJsonLayer(GoogleMap googleMap, JSONObject jSONObject) {
        if (jSONObject == null) {
            throw new IllegalArgumentException("GeoJSON file cannot be null");
        }
        this.f3956b = null;
        C1211hn hnVar = new C1211hn(jSONObject);
        this.f3956b = hnVar.mo8294b();
        HashMap hashMap = new HashMap();
        Iterator<GeoJsonFeature> it = hnVar.mo8293a().iterator();
        while (it.hasNext()) {
            hashMap.put(it.next(), (Object) null);
        }
        this.f3955a = new C1212ho(googleMap, hashMap);
    }

    public GeoJsonLayer(GoogleMap googleMap, int i, Context context) throws IOException, JSONException {
        this(googleMap, m4527a(context.getResources().openRawResource(i)));
    }

    /* JADX INFO: finally extract failed */
    /* renamed from: a */
    private static JSONObject m4527a(InputStream inputStream) throws IOException, JSONException {
        StringBuilder sb = new StringBuilder();
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
        while (true) {
            try {
                String readLine = bufferedReader.readLine();
                if (readLine != null) {
                    sb.append(readLine);
                } else {
                    bufferedReader.close();
                    return new JSONObject(sb.toString());
                }
            } catch (Throwable th) {
                bufferedReader.close();
                throw th;
            }
        }
    }

    public Iterable<GeoJsonFeature> getFeatures() {
        return this.f3955a.mo8301d();
    }

    public void addLayerToMap() {
        this.f3955a.mo8300c();
    }

    public void addFeature(GeoJsonFeature geoJsonFeature) {
        if (geoJsonFeature == null) {
            throw new IllegalArgumentException("Feature cannot be null");
        }
        this.f3955a.mo8296a(geoJsonFeature);
    }

    public void removeFeature(GeoJsonFeature geoJsonFeature) {
        if (geoJsonFeature == null) {
            throw new IllegalArgumentException("Feature cannot be null");
        }
        this.f3955a.mo8299b(geoJsonFeature);
    }

    public GoogleMap getMap() {
        return this.f3955a.mo8298b();
    }

    public void setMap(GoogleMap googleMap) {
        this.f3955a.mo8295a(googleMap);
    }

    public void removeLayerFromMap() {
        this.f3955a.mo8302e();
    }

    public boolean isLayerOnMap() {
        return this.f3955a.mo8297a();
    }

    public GeoJsonPointStyle getDefaultPointStyle() {
        return this.f3955a.mo8303f();
    }

    public GeoJsonLineStringStyle getDefaultLineStringStyle() {
        return this.f3955a.mo8304g();
    }

    public GeoJsonPolygonStyle getDefaultPolygonStyle() {
        return this.f3955a.mo8305h();
    }

    public LatLngBounds getBoundingBox() {
        return this.f3956b;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("Collection{");
        sb.append("\n Bounding box=").append(this.f3956b);
        sb.append("\n}\n");
        return sb.toString();
    }
}
