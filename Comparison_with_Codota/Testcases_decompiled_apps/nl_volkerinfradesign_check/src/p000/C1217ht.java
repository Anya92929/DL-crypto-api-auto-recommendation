package p000;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.support.p001v4.app.FragmentActivity;
import android.support.p001v4.util.LruCache;
import android.text.Html;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.model.BitmapDescriptor;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.GroundOverlay;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.android.gms.maps.model.Polygon;
import com.google.android.gms.maps.model.PolygonOptions;
import com.google.android.gms.maps.model.Polyline;
import com.google.android.gms.maps.model.PolylineOptions;
import com.google.maps.android.C0994R;
import com.google.maps.android.kml.KmlContainer;
import com.google.maps.android.kml.KmlGeometry;
import com.google.maps.android.kml.KmlGroundOverlay;
import com.google.maps.android.kml.KmlLineString;
import com.google.maps.android.kml.KmlMultiGeometry;
import com.google.maps.android.kml.KmlPlacemark;
import com.google.maps.android.kml.KmlPoint;
import com.google.maps.android.kml.KmlPolygon;
import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

/* renamed from: ht */
public class C1217ht extends FragmentActivity {
    /* access modifiers changed from: private */

    /* renamed from: k */
    public final LruCache<String, Bitmap> f4299k = new LruCache<>(50);

    /* renamed from: l */
    private final ArrayList<String> f4300l = new ArrayList<>();

    /* renamed from: m */
    private final ArrayList<String> f4301m = new ArrayList<>();

    /* renamed from: n */
    private GoogleMap f4302n;
    /* access modifiers changed from: private */

    /* renamed from: o */
    public HashMap<KmlPlacemark, Object> f4303o;

    /* renamed from: p */
    private HashMap<String, String> f4304p;
    /* access modifiers changed from: private */

    /* renamed from: q */
    public ArrayList<KmlContainer> f4305q;

    /* renamed from: r */
    private HashMap<String, C1221hu> f4306r;

    /* renamed from: s */
    private HashMap<String, C1221hu> f4307s = new HashMap<>();
    /* access modifiers changed from: private */

    /* renamed from: t */
    public HashMap<KmlGroundOverlay, GroundOverlay> f4308t;
    /* access modifiers changed from: private */

    /* renamed from: u */
    public boolean f4309u = false;

    /* renamed from: v */
    private boolean f4310v = false;

    /* renamed from: w */
    private boolean f4311w = false;
    /* access modifiers changed from: private */

    /* renamed from: x */
    public Context f4312x;

    public C1217ht(GoogleMap googleMap, Context context) {
        this.f4312x = context;
        this.f4302n = googleMap;
    }

    /* renamed from: a */
    private static boolean m5397a(KmlPlacemark kmlPlacemark) {
        if (!kmlPlacemark.hasProperty("visibility") || Integer.parseInt(kmlPlacemark.getProperty("visibility")) != 0) {
            return true;
        }
        return false;
    }

    /* renamed from: a */
    private static BitmapDescriptor m5370a(Bitmap bitmap, Double d) {
        return BitmapDescriptorFactory.fromBitmap(Bitmap.createScaledBitmap(bitmap, (int) (((double) bitmap.getWidth()) * d.doubleValue()), (int) (((double) bitmap.getHeight()) * d.doubleValue()), false));
    }

    /* renamed from: a */
    private static void m5394a(HashMap<KmlPlacemark, Object> hashMap) {
        for (Object next : hashMap.values()) {
            if (next instanceof Marker) {
                ((Marker) next).remove();
            } else if (next instanceof Polyline) {
                ((Polyline) next).remove();
            } else if (next instanceof Polygon) {
                ((Polygon) next).remove();
            }
        }
    }

    /* renamed from: a */
    static boolean m5396a(KmlContainer kmlContainer, boolean z) {
        boolean z2;
        if (!kmlContainer.hasProperty("visibility") || Integer.parseInt(kmlContainer.getProperty("visibility")) != 0) {
            z2 = true;
        } else {
            z2 = false;
        }
        if (!z || !z2) {
            return false;
        }
        return true;
    }

    /* renamed from: b */
    private void m5400b(HashMap<KmlGroundOverlay, GroundOverlay> hashMap) {
        for (GroundOverlay remove : hashMap.values()) {
            remove.remove();
        }
    }

    /* renamed from: a */
    private void m5387a(Iterable<KmlContainer> iterable) {
        for (KmlContainer next : iterable) {
            m5394a(next.mo7945d());
            m5400b(next.mo7944c());
            m5387a(next.getContainers());
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo8314a(HashMap<String, String> hashMap, HashMap<String, C1221hu> hashMap2) {
        for (String next : hashMap.keySet()) {
            String str = hashMap.get(next);
            if (hashMap2.containsKey(str)) {
                hashMap2.put(next, hashMap2.get(str));
            }
        }
    }

    /* renamed from: a */
    public void mo8315a(HashMap<String, C1221hu> hashMap, HashMap<String, String> hashMap2, HashMap<KmlPlacemark, Object> hashMap3, ArrayList<KmlContainer> arrayList, HashMap<KmlGroundOverlay, GroundOverlay> hashMap4) {
        this.f4306r = hashMap;
        this.f4304p = hashMap2;
        this.f4303o = hashMap3;
        this.f4305q = arrayList;
        this.f4308t = hashMap4;
    }

    /* renamed from: b */
    public void mo8316b() {
        this.f4307s.putAll(this.f4306r);
        mo8314a(this.f4304p, this.f4307s);
        m5395a(this.f4308t, (Iterable<KmlContainer>) this.f4305q);
        m5388a((Iterable<KmlContainer>) this.f4305q, true);
        m5401c(this.f4303o);
        if (!this.f4311w) {
            m5409l();
        }
        if (!this.f4310v) {
            m5407j();
        }
        this.f4309u = true;
    }

    /* renamed from: c */
    public GoogleMap mo8317c() {
        return this.f4302n;
    }

    /* renamed from: a */
    public void mo8313a(GoogleMap googleMap) {
        mo8323i();
        this.f4302n = googleMap;
        mo8316b();
    }

    /* renamed from: d */
    public boolean mo8318d() {
        return this.f4303o.size() > 0;
    }

    /* renamed from: e */
    public Iterable<KmlPlacemark> mo8319e() {
        return this.f4303o.keySet();
    }

    /* renamed from: f */
    public boolean mo8320f() {
        return this.f4305q.size() > 0;
    }

    /* renamed from: g */
    public Iterable<KmlContainer> mo8321g() {
        return this.f4305q;
    }

    /* renamed from: h */
    public Iterable<KmlGroundOverlay> mo8322h() {
        return this.f4308t.keySet();
    }

    /* renamed from: i */
    public void mo8323i() {
        m5394a(this.f4303o);
        m5400b(this.f4308t);
        if (mo8320f()) {
            m5387a(mo8321g());
        }
        this.f4309u = false;
        this.f4307s.clear();
    }

    /* renamed from: c */
    private void m5401c(HashMap<KmlPlacemark, Object> hashMap) {
        for (KmlPlacemark next : hashMap.keySet()) {
            hashMap.put(next, m5376a(next, m5397a(next)));
        }
    }

    /* renamed from: a */
    private Object m5376a(KmlPlacemark kmlPlacemark, boolean z) {
        if (kmlPlacemark.getGeometry() == null) {
            return null;
        }
        return m5375a(kmlPlacemark, kmlPlacemark.getGeometry(), m5374a(kmlPlacemark.getStyleId()), kmlPlacemark.getInlineStyle(), z);
    }

    /* renamed from: a */
    private void m5388a(Iterable<KmlContainer> iterable, boolean z) {
        for (KmlContainer next : iterable) {
            boolean a = m5396a(next, z);
            if (next.mo7941a() != null) {
                this.f4307s.putAll(next.mo7941a());
            }
            if (next.mo7943b() != null) {
                mo8314a(next.mo7943b(), this.f4307s);
            }
            m5399b(next, a);
            if (next.hasContainers()) {
                m5388a(next.getContainers(), a);
            }
        }
    }

    /* renamed from: b */
    private void m5399b(KmlContainer kmlContainer, boolean z) {
        for (KmlPlacemark next : kmlContainer.getPlacemarks()) {
            kmlContainer.mo7942a(next, m5376a(next, z && m5397a(next)));
        }
    }

    /* renamed from: a */
    private C1221hu m5374a(String str) {
        C1221hu huVar = this.f4307s.get((Object) null);
        if (this.f4307s.get(str) != null) {
            return this.f4307s.get(str);
        }
        return huVar;
    }

    /* renamed from: a */
    private void m5389a(String str, MarkerOptions markerOptions) {
        if (this.f4299k.get(str) != null) {
            markerOptions.icon(BitmapDescriptorFactory.fromBitmap(this.f4299k.get(str)));
        } else if (!this.f4300l.contains(str)) {
            this.f4300l.add(str);
        }
    }

    /* renamed from: j */
    private void m5407j() {
        this.f4310v = true;
        Iterator<String> it = this.f4300l.iterator();
        while (it.hasNext()) {
            new C1220b(it.next()).execute(new String[0]);
            it.remove();
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m5392a(String str, HashMap<KmlPlacemark, Object> hashMap) {
        boolean z;
        boolean z2;
        for (KmlPlacemark next : hashMap.keySet()) {
            C1221hu huVar = this.f4307s.get(next.getStyleId());
            C1221hu inlineStyle = next.getInlineStyle();
            if (KmlPoint.GEOMETRY_TYPE.equals(next.getGeometry().getGeometryType())) {
                if (inlineStyle == null || !str.equals(inlineStyle.mo8348f())) {
                    z = false;
                } else {
                    z = true;
                }
                if (huVar == null || !str.equals(huVar.mo8348f())) {
                    z2 = false;
                } else {
                    z2 = true;
                }
                if (z) {
                    m5386a(inlineStyle, hashMap, next);
                } else if (z2) {
                    m5386a(huVar, hashMap, next);
                }
            }
        }
    }

    /* renamed from: a */
    private void m5386a(C1221hu huVar, HashMap<KmlPlacemark, Object> hashMap, KmlPlacemark kmlPlacemark) {
        double c = huVar.mo8342c();
        ((Marker) hashMap.get(kmlPlacemark)).setIcon(m5370a(this.f4299k.get(huVar.mo8348f()), Double.valueOf(c)));
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m5390a(String str, Iterable<KmlContainer> iterable) {
        for (KmlContainer next : iterable) {
            m5392a(str, next.mo7945d());
            if (next.hasContainers()) {
                m5390a(str, next.getContainers());
            }
        }
    }

    /* renamed from: a */
    private Object m5375a(KmlPlacemark kmlPlacemark, KmlGeometry kmlGeometry, C1221hu huVar, C1221hu huVar2, boolean z) {
        String geometryType = kmlGeometry.getGeometryType();
        if (geometryType.equals(KmlPoint.GEOMETRY_TYPE)) {
            Marker a = m5371a(kmlPlacemark, (KmlPoint) kmlGeometry, huVar, huVar2);
            a.setVisible(z);
            return a;
        } else if (geometryType.equals(KmlLineString.GEOMETRY_TYPE)) {
            Polyline a2 = m5373a((KmlLineString) kmlGeometry, huVar, huVar2);
            a2.setVisible(z);
            return a2;
        } else if (geometryType.equals(KmlPolygon.GEOMETRY_TYPE)) {
            Polygon a3 = m5372a((KmlPolygon) kmlGeometry, huVar, huVar2);
            a3.setVisible(z);
            return a3;
        } else if (!geometryType.equals("MultiGeometry")) {
            return null;
        } else {
            return m5377a(kmlPlacemark, (KmlMultiGeometry) kmlGeometry, huVar, huVar2, z);
        }
    }

    /* renamed from: a */
    private Marker m5371a(KmlPlacemark kmlPlacemark, KmlPoint kmlPoint, C1221hu huVar, C1221hu huVar2) {
        MarkerOptions k = huVar.mo8358k();
        k.position(kmlPoint.getGeometryObject());
        if (huVar2 != null) {
            m5378a(k, huVar2, huVar.mo8348f());
        } else if (huVar.mo8348f() != null) {
            m5389a(huVar.mo8348f(), k);
        }
        Marker addMarker = this.f4302n.addMarker(k);
        m5385a(huVar, addMarker, kmlPlacemark);
        return addMarker;
    }

    /* renamed from: a */
    private void m5385a(C1221hu huVar, Marker marker, KmlPlacemark kmlPlacemark) {
        boolean hasProperty = kmlPlacemark.hasProperty("name");
        boolean hasProperty2 = kmlPlacemark.hasProperty("description");
        boolean e = huVar.mo8347e();
        boolean containsKey = huVar.mo8356j().containsKey("text");
        if (e && containsKey) {
            marker.setTitle(huVar.mo8356j().get("text"));
            m5408k();
        } else if (e && hasProperty) {
            marker.setTitle(kmlPlacemark.getProperty("name"));
            m5408k();
        } else if (hasProperty && hasProperty2) {
            marker.setTitle(kmlPlacemark.getProperty("name"));
            marker.setSnippet(kmlPlacemark.getProperty("description"));
            m5408k();
        } else if (hasProperty2) {
            marker.setTitle(kmlPlacemark.getProperty("description"));
            m5408k();
        }
    }

    /* renamed from: k */
    private void m5408k() {
        this.f4302n.setInfoWindowAdapter(new GoogleMap.InfoWindowAdapter() {
            public View getInfoWindow(Marker marker) {
                return null;
            }

            public View getInfoContents(Marker marker) {
                View inflate = LayoutInflater.from(C1217ht.this.f4312x).inflate(C0994R.layout.info_window, (ViewGroup) null);
                TextView textView = (TextView) inflate.findViewById(C0994R.C0996id.window);
                if (marker.getSnippet() != null) {
                    String valueOf = String.valueOf(marker.getTitle());
                    String valueOf2 = String.valueOf(marker.getSnippet());
                    textView.setText(Html.fromHtml(new StringBuilder(String.valueOf(valueOf).length() + 4 + String.valueOf(valueOf2).length()).append(valueOf).append("<br>").append(valueOf2).toString()));
                } else {
                    textView.setText(Html.fromHtml(marker.getTitle()));
                }
                return inflate;
            }
        });
    }

    /* renamed from: a */
    private void m5378a(MarkerOptions markerOptions, C1221hu huVar, String str) {
        MarkerOptions k = huVar.mo8358k();
        if (huVar.mo8343c("heading")) {
            markerOptions.rotation(k.getRotation());
        }
        if (huVar.mo8343c("hotSpot")) {
            markerOptions.anchor(k.getAnchorU(), k.getAnchorV());
        }
        if (huVar.mo8343c("markerColor")) {
            markerOptions.icon(k.getIcon());
        }
        if (huVar.mo8343c("iconUrl")) {
            m5389a(huVar.mo8348f(), markerOptions);
        } else if (str != null) {
            m5389a(str, markerOptions);
        }
    }

    /* renamed from: a */
    private Polyline m5373a(KmlLineString kmlLineString, C1221hu huVar, C1221hu huVar2) {
        PolylineOptions l = huVar.mo8359l();
        l.addAll(kmlLineString.getGeometryObject());
        if (huVar2 != null) {
            m5380a(l, huVar2);
        } else if (huVar.mo8353h()) {
            l.color(C1221hu.m5425a(l.getColor()));
        }
        return this.f4302n.addPolyline(l);
    }

    /* renamed from: a */
    private void m5380a(PolylineOptions polylineOptions, C1221hu huVar) {
        PolylineOptions l = huVar.mo8359l();
        if (huVar.mo8343c("outlineColor")) {
            polylineOptions.color(l.getColor());
        }
        if (huVar.mo8343c("width")) {
            polylineOptions.width(l.getWidth());
        }
        if (huVar.mo8353h()) {
            polylineOptions.color(C1221hu.m5425a(l.getColor()));
        }
    }

    /* renamed from: a */
    private Polygon m5372a(KmlPolygon kmlPolygon, C1221hu huVar, C1221hu huVar2) {
        PolygonOptions m = huVar.mo8360m();
        m.addAll(kmlPolygon.getOuterBoundaryCoordinates());
        Iterator<ArrayList<LatLng>> it = kmlPolygon.getInnerBoundaryCoordinates().iterator();
        while (it.hasNext()) {
            m.addHole(it.next());
        }
        if (huVar2 != null) {
            m5379a(m, huVar2);
        } else if (huVar.mo8355i()) {
            m.fillColor(C1221hu.m5425a(m.getFillColor()));
        }
        return this.f4302n.addPolygon(m);
    }

    /* renamed from: a */
    private void m5379a(PolygonOptions polygonOptions, C1221hu huVar) {
        PolygonOptions m = huVar.mo8360m();
        if (huVar.mo8341b() && huVar.mo8343c("fillColor")) {
            polygonOptions.fillColor(m.getFillColor());
        }
        if (huVar.mo8345d()) {
            if (huVar.mo8343c("outlineColor")) {
                polygonOptions.strokeColor(m.getStrokeColor());
            }
            if (huVar.mo8343c("width")) {
                polygonOptions.strokeWidth(m.getStrokeWidth());
            }
        }
        if (huVar.mo8355i()) {
            polygonOptions.fillColor(C1221hu.m5425a(m.getFillColor()));
        }
    }

    /* renamed from: a */
    private ArrayList<Object> m5377a(KmlPlacemark kmlPlacemark, KmlMultiGeometry kmlMultiGeometry, C1221hu huVar, C1221hu huVar2, boolean z) {
        ArrayList<Object> arrayList = new ArrayList<>();
        Iterator it = kmlMultiGeometry.getGeometryObject().iterator();
        while (it.hasNext()) {
            arrayList.add(m5375a(kmlPlacemark, (KmlGeometry) it.next(), huVar, huVar2, z));
        }
        return arrayList;
    }

    /* renamed from: a */
    private void m5395a(HashMap<KmlGroundOverlay, GroundOverlay> hashMap, Iterable<KmlContainer> iterable) {
        m5404d(hashMap);
        for (KmlContainer next : iterable) {
            m5395a(next.mo7944c(), next.getContainers());
        }
    }

    /* renamed from: d */
    private void m5404d(HashMap<KmlGroundOverlay, GroundOverlay> hashMap) {
        for (KmlGroundOverlay next : hashMap.keySet()) {
            String imageUrl = next.getImageUrl();
            if (!(imageUrl == null || next.getLatLngBox() == null)) {
                if (this.f4299k.get(imageUrl) != null) {
                    m5393a(imageUrl, this.f4308t, true);
                } else if (!this.f4301m.contains(imageUrl)) {
                    this.f4301m.add(imageUrl);
                }
            }
        }
    }

    /* renamed from: l */
    private void m5409l() {
        this.f4311w = true;
        Iterator<String> it = this.f4301m.iterator();
        while (it.hasNext()) {
            new C1219a(it.next()).execute(new String[0]);
            it.remove();
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m5393a(String str, HashMap<KmlGroundOverlay, GroundOverlay> hashMap, boolean z) {
        BitmapDescriptor fromBitmap = BitmapDescriptorFactory.fromBitmap(this.f4299k.get(str));
        for (KmlGroundOverlay next : hashMap.keySet()) {
            if (next.getImageUrl().equals(str)) {
                GroundOverlay addGroundOverlay = this.f4302n.addGroundOverlay(next.mo7960a().image(fromBitmap));
                if (!z) {
                    addGroundOverlay.setVisible(false);
                }
                hashMap.put(next, addGroundOverlay);
            }
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m5391a(String str, Iterable<KmlContainer> iterable, boolean z) {
        for (KmlContainer next : iterable) {
            boolean a = m5396a(next, z);
            m5393a(str, next.mo7944c(), a);
            if (next.hasContainers()) {
                m5391a(str, next.getContainers(), a);
            }
        }
    }

    /* renamed from: ht$b */
    class C1220b extends AsyncTask<String, Void, Bitmap> {

        /* renamed from: b */
        private final String f4317b;

        public C1220b(String str) {
            this.f4317b = str;
        }

        /* access modifiers changed from: protected */
        /* renamed from: a */
        public Bitmap doInBackground(String... strArr) {
            try {
                return BitmapFactory.decodeStream((InputStream) new URL(this.f4317b).getContent());
            } catch (MalformedURLException e) {
                e.printStackTrace();
            } catch (IOException e2) {
                e2.printStackTrace();
            }
            return null;
        }

        /* access modifiers changed from: protected */
        /* renamed from: a */
        public void onPostExecute(Bitmap bitmap) {
            if (bitmap == null) {
                String valueOf = String.valueOf(this.f4317b);
                Log.e("KmlRenderer", valueOf.length() != 0 ? "Image at this URL could not be found ".concat(valueOf) : new String("Image at this URL could not be found "));
                return;
            }
            C1217ht.this.f4299k.put(this.f4317b, bitmap);
            if (C1217ht.this.f4309u) {
                C1217ht.this.m5392a(this.f4317b, (HashMap<KmlPlacemark, Object>) C1217ht.this.f4303o);
                C1217ht.this.m5390a(this.f4317b, (Iterable<KmlContainer>) C1217ht.this.f4305q);
            }
        }
    }

    /* renamed from: ht$a */
    class C1219a extends AsyncTask<String, Void, Bitmap> {

        /* renamed from: b */
        private final String f4315b;

        public C1219a(String str) {
            this.f4315b = str;
        }

        /* access modifiers changed from: protected */
        /* renamed from: a */
        public Bitmap doInBackground(String... strArr) {
            try {
                return BitmapFactory.decodeStream((InputStream) new URL(this.f4315b).getContent());
            } catch (MalformedURLException e) {
                e.printStackTrace();
            } catch (IOException e2) {
                e2.printStackTrace();
            }
            return null;
        }

        /* access modifiers changed from: protected */
        /* renamed from: a */
        public void onPostExecute(Bitmap bitmap) {
            if (bitmap == null) {
                String valueOf = String.valueOf(this.f4315b);
                Log.e("KmlRenderer", valueOf.length() != 0 ? "Image at this URL could not be found ".concat(valueOf) : new String("Image at this URL could not be found "));
                return;
            }
            C1217ht.this.f4299k.put(this.f4315b, bitmap);
            if (C1217ht.this.f4309u) {
                C1217ht.this.m5393a(this.f4315b, (HashMap<KmlGroundOverlay, GroundOverlay>) C1217ht.this.f4308t, true);
                C1217ht.this.m5391a(this.f4315b, (Iterable<KmlContainer>) C1217ht.this.f4305q, true);
            }
        }
    }
}
