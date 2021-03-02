package p000;

import android.util.Log;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.LatLngBounds;
import com.google.maps.android.geojson.GeoJsonFeature;
import com.google.maps.android.geojson.GeoJsonGeometry;
import com.google.maps.android.geojson.GeoJsonGeometryCollection;
import com.google.maps.android.geojson.GeoJsonLineString;
import com.google.maps.android.geojson.GeoJsonMultiLineString;
import com.google.maps.android.geojson.GeoJsonMultiPoint;
import com.google.maps.android.geojson.GeoJsonMultiPolygon;
import com.google.maps.android.geojson.GeoJsonPoint;
import com.google.maps.android.geojson.GeoJsonPolygon;
import com.google.maps.android.kml.KmlLineString;
import com.google.maps.android.kml.KmlPoint;
import com.google.maps.android.kml.KmlPolygon;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: hn */
public class C1211hn {

    /* renamed from: a */
    private final JSONObject f4283a;

    /* renamed from: b */
    private final ArrayList<GeoJsonFeature> f4284b = new ArrayList<>();

    /* renamed from: c */
    private LatLngBounds f4285c = null;

    public C1211hn(JSONObject jSONObject) {
        this.f4283a = jSONObject;
        m5307c();
    }

    /* renamed from: a */
    private static boolean m5302a(String str) {
        return str.matches("Point|MultiPoint|LineString|MultiLineString|Polygon|MultiPolygon|GeometryCollection");
    }

    /* renamed from: a */
    private static GeoJsonFeature m5300a(JSONObject jSONObject) {
        String str;
        LatLngBounds latLngBounds;
        GeoJsonGeometry geoJsonGeometry;
        HashMap<String, String> hashMap = new HashMap<>();
        try {
            if (jSONObject.has("id")) {
                str = jSONObject.getString("id");
            } else {
                str = null;
            }
            if (jSONObject.has("bbox")) {
                latLngBounds = m5299a(jSONObject.getJSONArray("bbox"));
            } else {
                latLngBounds = null;
            }
            if (!jSONObject.has("geometry") || jSONObject.isNull("geometry")) {
                geoJsonGeometry = null;
            } else {
                geoJsonGeometry = m5303b(jSONObject.getJSONObject("geometry"));
            }
            if (jSONObject.has("properties") && !jSONObject.isNull("properties")) {
                hashMap = m5309d(jSONObject.getJSONObject("properties"));
            }
            return new GeoJsonFeature(geoJsonGeometry, str, hashMap, latLngBounds);
        } catch (JSONException e) {
            String valueOf = String.valueOf(jSONObject.toString());
            Log.w("GeoJsonParser", valueOf.length() != 0 ? "Feature could not be successfully parsed ".concat(valueOf) : new String("Feature could not be successfully parsed "));
            return null;
        }
    }

    /* renamed from: a */
    private static LatLngBounds m5299a(JSONArray jSONArray) throws JSONException {
        return new LatLngBounds(new LatLng(jSONArray.getDouble(1), jSONArray.getDouble(0)), new LatLng(jSONArray.getDouble(3), jSONArray.getDouble(2)));
    }

    /* renamed from: b */
    private static GeoJsonGeometry m5303b(JSONObject jSONObject) {
        JSONArray jSONArray;
        try {
            String string = jSONObject.getString("type");
            if (string.equals("GeometryCollection")) {
                jSONArray = jSONObject.getJSONArray("geometries");
            } else if (!m5302a(string)) {
                return null;
            } else {
                jSONArray = jSONObject.getJSONArray("coordinates");
            }
            return m5301a(string, jSONArray);
        } catch (JSONException e) {
            return null;
        }
    }

    /* renamed from: c */
    private static GeoJsonFeature m5305c(JSONObject jSONObject) {
        GeoJsonGeometry b = m5303b(jSONObject);
        if (b != null) {
            return new GeoJsonFeature(b, (String) null, new HashMap(), (LatLngBounds) null);
        }
        Log.w("GeoJsonParser", "Geometry could not be parsed");
        return null;
    }

    /* renamed from: d */
    private static HashMap<String, String> m5309d(JSONObject jSONObject) throws JSONException {
        HashMap<String, String> hashMap = new HashMap<>();
        Iterator<String> keys = jSONObject.keys();
        while (keys.hasNext()) {
            String next = keys.next();
            hashMap.put(next, jSONObject.getString(next));
        }
        return hashMap;
    }

    /* renamed from: a */
    private static GeoJsonGeometry m5301a(String str, JSONArray jSONArray) throws JSONException {
        if (str.equals(KmlPoint.GEOMETRY_TYPE)) {
            return m5304b(jSONArray);
        }
        if (str.equals("MultiPoint")) {
            return m5306c(jSONArray);
        }
        if (str.equals(KmlLineString.GEOMETRY_TYPE)) {
            return m5308d(jSONArray);
        }
        if (str.equals("MultiLineString")) {
            return m5310e(jSONArray);
        }
        if (str.equals(KmlPolygon.GEOMETRY_TYPE)) {
            return m5312f(jSONArray);
        }
        if (str.equals("MultiPolygon")) {
            return m5313g(jSONArray);
        }
        if (str.equals("GeometryCollection")) {
            return m5314h(jSONArray);
        }
        return null;
    }

    /* renamed from: b */
    private static GeoJsonPoint m5304b(JSONArray jSONArray) throws JSONException {
        return new GeoJsonPoint(m5315i(jSONArray));
    }

    /* renamed from: c */
    private static GeoJsonMultiPoint m5306c(JSONArray jSONArray) throws JSONException {
        ArrayList arrayList = new ArrayList();
        for (int i = 0; i < jSONArray.length(); i++) {
            arrayList.add(m5304b(jSONArray.getJSONArray(i)));
        }
        return new GeoJsonMultiPoint(arrayList);
    }

    /* renamed from: d */
    private static GeoJsonLineString m5308d(JSONArray jSONArray) throws JSONException {
        return new GeoJsonLineString(m5316j(jSONArray));
    }

    /* renamed from: e */
    private static GeoJsonMultiLineString m5310e(JSONArray jSONArray) throws JSONException {
        ArrayList arrayList = new ArrayList();
        for (int i = 0; i < jSONArray.length(); i++) {
            arrayList.add(m5308d(jSONArray.getJSONArray(i)));
        }
        return new GeoJsonMultiLineString(arrayList);
    }

    /* renamed from: f */
    private static GeoJsonPolygon m5312f(JSONArray jSONArray) throws JSONException {
        return new GeoJsonPolygon(m5317k(jSONArray));
    }

    /* renamed from: g */
    private static GeoJsonMultiPolygon m5313g(JSONArray jSONArray) throws JSONException {
        ArrayList arrayList = new ArrayList();
        for (int i = 0; i < jSONArray.length(); i++) {
            arrayList.add(m5312f(jSONArray.getJSONArray(i)));
        }
        return new GeoJsonMultiPolygon(arrayList);
    }

    /* renamed from: h */
    private static GeoJsonGeometryCollection m5314h(JSONArray jSONArray) throws JSONException {
        ArrayList arrayList = new ArrayList();
        for (int i = 0; i < jSONArray.length(); i++) {
            GeoJsonGeometry b = m5303b(jSONArray.getJSONObject(i));
            if (b != null) {
                arrayList.add(b);
            }
        }
        return new GeoJsonGeometryCollection(arrayList);
    }

    /* renamed from: i */
    private static LatLng m5315i(JSONArray jSONArray) throws JSONException {
        return new LatLng(jSONArray.getDouble(1), jSONArray.getDouble(0));
    }

    /* renamed from: j */
    private static ArrayList<LatLng> m5316j(JSONArray jSONArray) throws JSONException {
        ArrayList<LatLng> arrayList = new ArrayList<>();
        for (int i = 0; i < jSONArray.length(); i++) {
            arrayList.add(m5315i(jSONArray.getJSONArray(i)));
        }
        return arrayList;
    }

    /* renamed from: k */
    private static ArrayList<ArrayList<LatLng>> m5317k(JSONArray jSONArray) throws JSONException {
        ArrayList<ArrayList<LatLng>> arrayList = new ArrayList<>();
        for (int i = 0; i < jSONArray.length(); i++) {
            arrayList.add(m5316j(jSONArray.getJSONArray(i)));
        }
        return arrayList;
    }

    /* renamed from: c */
    private void m5307c() {
        try {
            String string = this.f4283a.getString("type");
            if (string.equals("Feature")) {
                GeoJsonFeature a = m5300a(this.f4283a);
                if (a != null) {
                    this.f4284b.add(a);
                }
            } else if (string.equals("FeatureCollection")) {
                this.f4284b.addAll(m5311e(this.f4283a));
            } else if (m5302a(string)) {
                GeoJsonFeature c = m5305c(this.f4283a);
                if (c != null) {
                    this.f4284b.add(c);
                }
            } else {
                Log.w("GeoJsonParser", "GeoJSON file could not be parsed.");
            }
        } catch (JSONException e) {
            Log.w("GeoJsonParser", "GeoJSON file could not be parsed.");
        }
    }

    /* renamed from: e */
    private ArrayList<GeoJsonFeature> m5311e(JSONObject jSONObject) {
        ArrayList<GeoJsonFeature> arrayList = new ArrayList<>();
        try {
            JSONArray jSONArray = jSONObject.getJSONArray("features");
            if (jSONObject.has("bbox")) {
                this.f4285c = m5299a(jSONObject.getJSONArray("bbox"));
            }
            for (int i = 0; i < jSONArray.length(); i++) {
                try {
                    JSONObject jSONObject2 = jSONArray.getJSONObject(i);
                    if (jSONObject2.getString("type").equals("Feature")) {
                        GeoJsonFeature a = m5300a(jSONObject2);
                        if (a != null) {
                            arrayList.add(a);
                        } else {
                            Log.w("GeoJsonParser", new StringBuilder(77).append("Index of Feature in Feature Collection that could not be created: ").append(i).toString());
                        }
                    }
                } catch (JSONException e) {
                    Log.w("GeoJsonParser", new StringBuilder(77).append("Index of Feature in Feature Collection that could not be created: ").append(i).toString());
                }
            }
            return arrayList;
        } catch (JSONException e2) {
            Log.w("GeoJsonParser", "Feature Collection could not be created.");
            return arrayList;
        }
    }

    /* renamed from: a */
    public ArrayList<GeoJsonFeature> mo8293a() {
        return this.f4284b;
    }

    /* renamed from: b */
    public LatLngBounds mo8294b() {
        return this.f4285c;
    }
}
