package p000;

import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.android.gms.maps.model.Polygon;
import com.google.android.gms.maps.model.PolygonOptions;
import com.google.android.gms.maps.model.Polyline;
import com.google.android.gms.maps.model.PolylineOptions;
import com.google.maps.android.geojson.GeoJsonFeature;
import com.google.maps.android.geojson.GeoJsonGeometry;
import com.google.maps.android.geojson.GeoJsonGeometryCollection;
import com.google.maps.android.geojson.GeoJsonLineString;
import com.google.maps.android.geojson.GeoJsonLineStringStyle;
import com.google.maps.android.geojson.GeoJsonMultiLineString;
import com.google.maps.android.geojson.GeoJsonMultiPoint;
import com.google.maps.android.geojson.GeoJsonMultiPolygon;
import com.google.maps.android.geojson.GeoJsonPoint;
import com.google.maps.android.geojson.GeoJsonPointStyle;
import com.google.maps.android.geojson.GeoJsonPolygon;
import com.google.maps.android.geojson.GeoJsonPolygonStyle;
import com.google.maps.android.kml.KmlLineString;
import com.google.maps.android.kml.KmlPoint;
import com.google.maps.android.kml.KmlPolygon;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Observable;
import java.util.Observer;
import java.util.Set;

/* renamed from: ho */
public class C1212ho implements Observer {

    /* renamed from: a */
    private static final Object f4286a = null;

    /* renamed from: b */
    private final HashMap<GeoJsonFeature, Object> f4287b;

    /* renamed from: c */
    private final GeoJsonPointStyle f4288c = new GeoJsonPointStyle();

    /* renamed from: d */
    private final GeoJsonLineStringStyle f4289d = new GeoJsonLineStringStyle();

    /* renamed from: e */
    private final GeoJsonPolygonStyle f4290e = new GeoJsonPolygonStyle();

    /* renamed from: f */
    private boolean f4291f = false;

    /* renamed from: g */
    private GoogleMap f4292g;

    public C1212ho(GoogleMap googleMap, HashMap<GeoJsonFeature, Object> hashMap) {
        this.f4292g = googleMap;
        this.f4287b = hashMap;
        for (GeoJsonFeature c : mo8301d()) {
            m5330c(c);
        }
    }

    /* renamed from: a */
    private static void m5329a(Object obj) {
        if (obj instanceof Marker) {
            ((Marker) obj).remove();
        } else if (obj instanceof Polyline) {
            ((Polyline) obj).remove();
        } else if (obj instanceof Polygon) {
            ((Polygon) obj).remove();
        } else if (obj instanceof ArrayList) {
            Iterator it = ((ArrayList) obj).iterator();
            while (it.hasNext()) {
                m5329a(it.next());
            }
        }
    }

    /* renamed from: a */
    public boolean mo8297a() {
        return this.f4291f;
    }

    /* renamed from: b */
    public GoogleMap mo8298b() {
        return this.f4292g;
    }

    /* renamed from: a */
    public void mo8295a(GoogleMap googleMap) {
        for (GeoJsonFeature a : mo8301d()) {
            m5328a(a, googleMap);
        }
    }

    /* renamed from: c */
    public void mo8300c() {
        if (!this.f4291f) {
            this.f4291f = true;
            for (GeoJsonFeature a : mo8301d()) {
                mo8296a(a);
            }
        }
    }

    /* renamed from: d */
    public Set<GeoJsonFeature> mo8301d() {
        return this.f4287b.keySet();
    }

    /* renamed from: c */
    private void m5330c(GeoJsonFeature geoJsonFeature) {
        if (geoJsonFeature.getPointStyle() == null) {
            geoJsonFeature.setPointStyle(this.f4288c);
        }
        if (geoJsonFeature.getLineStringStyle() == null) {
            geoJsonFeature.setLineStringStyle(this.f4289d);
        }
        if (geoJsonFeature.getPolygonStyle() == null) {
            geoJsonFeature.setPolygonStyle(this.f4290e);
        }
    }

    /* renamed from: a */
    public void mo8296a(GeoJsonFeature geoJsonFeature) {
        Object obj = f4286a;
        m5330c(geoJsonFeature);
        if (this.f4291f) {
            geoJsonFeature.addObserver(this);
            if (this.f4287b.containsKey(geoJsonFeature)) {
                m5329a(this.f4287b.get(geoJsonFeature));
            }
            if (geoJsonFeature.hasGeometry()) {
                obj = m5323a(geoJsonFeature, geoJsonFeature.getGeometry());
            }
        }
        this.f4287b.put(geoJsonFeature, obj);
    }

    /* renamed from: e */
    public void mo8302e() {
        if (this.f4291f) {
            for (GeoJsonFeature next : this.f4287b.keySet()) {
                m5329a(this.f4287b.get(next));
                next.deleteObserver(this);
            }
            this.f4291f = false;
        }
    }

    /* renamed from: b */
    public void mo8299b(GeoJsonFeature geoJsonFeature) {
        if (this.f4287b.containsKey(geoJsonFeature)) {
            m5329a(this.f4287b.remove(geoJsonFeature));
            geoJsonFeature.deleteObserver(this);
        }
    }

    /* renamed from: f */
    public GeoJsonPointStyle mo8303f() {
        return this.f4288c;
    }

    /* renamed from: g */
    public GeoJsonLineStringStyle mo8304g() {
        return this.f4289d;
    }

    /* renamed from: h */
    public GeoJsonPolygonStyle mo8305h() {
        return this.f4290e;
    }

    /* renamed from: a */
    private Object m5323a(GeoJsonFeature geoJsonFeature, GeoJsonGeometry geoJsonGeometry) {
        String type = geoJsonGeometry.getType();
        if (type.equals(KmlPoint.GEOMETRY_TYPE)) {
            return m5320a(geoJsonFeature.getPointStyle(), (GeoJsonPoint) geoJsonGeometry);
        }
        if (type.equals(KmlLineString.GEOMETRY_TYPE)) {
            return m5322a(geoJsonFeature.getLineStringStyle(), (GeoJsonLineString) geoJsonGeometry);
        }
        if (type.equals(KmlPolygon.GEOMETRY_TYPE)) {
            return m5321a(geoJsonFeature.getPolygonStyle(), (GeoJsonPolygon) geoJsonGeometry);
        }
        if (type.equals("MultiPoint")) {
            return m5326a(geoJsonFeature.getPointStyle(), (GeoJsonMultiPoint) geoJsonGeometry);
        }
        if (type.equals("MultiLineString")) {
            return m5325a(geoJsonFeature.getLineStringStyle(), (GeoJsonMultiLineString) geoJsonGeometry);
        }
        if (type.equals("MultiPolygon")) {
            return m5327a(geoJsonFeature.getPolygonStyle(), (GeoJsonMultiPolygon) geoJsonGeometry);
        }
        if (type.equals("GeometryCollection")) {
            return m5324a(geoJsonFeature, ((GeoJsonGeometryCollection) geoJsonGeometry).getGeometries());
        }
        return null;
    }

    /* renamed from: a */
    private Marker m5320a(GeoJsonPointStyle geoJsonPointStyle, GeoJsonPoint geoJsonPoint) {
        MarkerOptions markerOptions = geoJsonPointStyle.toMarkerOptions();
        markerOptions.position(geoJsonPoint.getCoordinates());
        return this.f4292g.addMarker(markerOptions);
    }

    /* renamed from: a */
    private ArrayList<Marker> m5326a(GeoJsonPointStyle geoJsonPointStyle, GeoJsonMultiPoint geoJsonMultiPoint) {
        ArrayList<Marker> arrayList = new ArrayList<>();
        for (GeoJsonPoint a : geoJsonMultiPoint.getPoints()) {
            arrayList.add(m5320a(geoJsonPointStyle, a));
        }
        return arrayList;
    }

    /* renamed from: a */
    private Polyline m5322a(GeoJsonLineStringStyle geoJsonLineStringStyle, GeoJsonLineString geoJsonLineString) {
        PolylineOptions polylineOptions = geoJsonLineStringStyle.toPolylineOptions();
        polylineOptions.addAll(geoJsonLineString.getCoordinates());
        return this.f4292g.addPolyline(polylineOptions);
    }

    /* renamed from: a */
    private ArrayList<Polyline> m5325a(GeoJsonLineStringStyle geoJsonLineStringStyle, GeoJsonMultiLineString geoJsonMultiLineString) {
        ArrayList<Polyline> arrayList = new ArrayList<>();
        for (GeoJsonLineString a : geoJsonMultiLineString.getLineStrings()) {
            arrayList.add(m5322a(geoJsonLineStringStyle, a));
        }
        return arrayList;
    }

    /* renamed from: a */
    private Polygon m5321a(GeoJsonPolygonStyle geoJsonPolygonStyle, GeoJsonPolygon geoJsonPolygon) {
        PolygonOptions polygonOptions = geoJsonPolygonStyle.toPolygonOptions();
        polygonOptions.addAll((Iterable) geoJsonPolygon.getCoordinates().get(0));
        int i = 1;
        while (true) {
            int i2 = i;
            if (i2 >= geoJsonPolygon.getCoordinates().size()) {
                return this.f4292g.addPolygon(polygonOptions);
            }
            polygonOptions.addHole((Iterable) geoJsonPolygon.getCoordinates().get(i2));
            i = i2 + 1;
        }
    }

    /* renamed from: a */
    private ArrayList<Polygon> m5327a(GeoJsonPolygonStyle geoJsonPolygonStyle, GeoJsonMultiPolygon geoJsonMultiPolygon) {
        ArrayList<Polygon> arrayList = new ArrayList<>();
        for (GeoJsonPolygon a : geoJsonMultiPolygon.getPolygons()) {
            arrayList.add(m5321a(geoJsonPolygonStyle, a));
        }
        return arrayList;
    }

    /* renamed from: a */
    private ArrayList<Object> m5324a(GeoJsonFeature geoJsonFeature, List<GeoJsonGeometry> list) {
        ArrayList<Object> arrayList = new ArrayList<>();
        for (GeoJsonGeometry a : list) {
            arrayList.add(m5323a(geoJsonFeature, a));
        }
        return arrayList;
    }

    /* renamed from: d */
    private void m5331d(GeoJsonFeature geoJsonFeature) {
        m5328a(geoJsonFeature, this.f4292g);
    }

    /* renamed from: a */
    private void m5328a(GeoJsonFeature geoJsonFeature, GoogleMap googleMap) {
        m5329a(this.f4287b.get(geoJsonFeature));
        this.f4287b.put(geoJsonFeature, f4286a);
        this.f4292g = googleMap;
        if (googleMap != null && geoJsonFeature.hasGeometry()) {
            this.f4287b.put(geoJsonFeature, m5323a(geoJsonFeature, geoJsonFeature.getGeometry()));
        }
    }

    public void update(Observable observable, Object obj) {
        if (observable instanceof GeoJsonFeature) {
            GeoJsonFeature geoJsonFeature = (GeoJsonFeature) observable;
            boolean z = this.f4287b.get(geoJsonFeature) != f4286a;
            if (z && geoJsonFeature.hasGeometry()) {
                m5331d(geoJsonFeature);
            } else if (z && !geoJsonFeature.hasGeometry()) {
                m5329a(this.f4287b.get(geoJsonFeature));
                this.f4287b.put(geoJsonFeature, f4286a);
            } else if (!z && geoJsonFeature.hasGeometry()) {
                mo8296a(geoJsonFeature);
            }
        }
    }
}
