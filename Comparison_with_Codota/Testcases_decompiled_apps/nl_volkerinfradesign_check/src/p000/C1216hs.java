package p000;

import com.google.android.gms.maps.model.GroundOverlay;
import com.google.maps.android.kml.KmlContainer;
import com.google.maps.android.kml.KmlGroundOverlay;
import com.google.maps.android.kml.KmlPlacemark;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

/* renamed from: hs */
public class C1216hs {

    /* renamed from: a */
    private final XmlPullParser f4293a;

    /* renamed from: b */
    private final HashMap<KmlPlacemark, Object> f4294b = new HashMap<>();

    /* renamed from: c */
    private final ArrayList<KmlContainer> f4295c = new ArrayList<>();

    /* renamed from: d */
    private final HashMap<String, C1221hu> f4296d = new HashMap<>();

    /* renamed from: e */
    private final HashMap<String, String> f4297e = new HashMap<>();

    /* renamed from: f */
    private final HashMap<KmlGroundOverlay, GroundOverlay> f4298f = new HashMap<>();

    public C1216hs(XmlPullParser xmlPullParser) {
        this.f4293a = xmlPullParser;
    }

    /* renamed from: a */
    public void mo8307a() throws XmlPullParserException, IOException {
        int eventType = this.f4293a.getEventType();
        while (eventType != 1) {
            if (eventType == 2) {
                if (this.f4293a.getName().matches("altitude|altitudeModeGroup|altitudeMode|begin|bottomFov|cookie|displayName|displayMode|displayMode|end|expires|extrude|flyToView|gridOrigin|httpQuery|leftFov|linkDescription|linkName|linkSnippet|listItemType|maxSnippetLines|maxSessionLength|message|minAltitude|minFadeExtent|minLodPixels|minRefreshPeriod|maxAltitude|maxFadeExtent|maxLodPixels|maxHeight|maxWidth|near|NetworkLink|NetworkLinkControl|overlayXY|range|refreshMode|refreshInterval|refreshVisibility|rightFov|roll|rotationXY|screenXY|shape|sourceHref|state|targetHref|tessellate|tileSize|topFov|viewBoundScale|viewFormat|viewRefreshMode|viewRefreshTime|when")) {
                    m5362a(this.f4293a);
                }
                if (this.f4293a.getName().matches("Folder|Document")) {
                    this.f4295c.add(C1214hq.m5343a(this.f4293a));
                }
                if (this.f4293a.getName().equals("Style")) {
                    C1221hu a = C1222hv.m5460a(this.f4293a);
                    this.f4296d.put(a.mo8332a(), a);
                }
                if (this.f4293a.getName().equals("StyleMap")) {
                    this.f4297e.putAll(C1222hv.m5463b(this.f4293a));
                }
                if (this.f4293a.getName().equals("Placemark")) {
                    this.f4294b.put(C1215hr.m5351a(this.f4293a), (Object) null);
                }
                if (this.f4293a.getName().equals("GroundOverlay")) {
                    this.f4298f.put(C1215hr.m5354b(this.f4293a), (Object) null);
                }
            }
            eventType = this.f4293a.next();
        }
        this.f4296d.put((Object) null, new C1221hu());
    }

    /* renamed from: b */
    public HashMap<String, C1221hu> mo8308b() {
        return this.f4296d;
    }

    /* renamed from: c */
    public HashMap<KmlPlacemark, Object> mo8309c() {
        return this.f4294b;
    }

    /* renamed from: d */
    public HashMap<String, String> mo8310d() {
        return this.f4297e;
    }

    /* renamed from: e */
    public ArrayList<KmlContainer> mo8311e() {
        return this.f4295c;
    }

    /* renamed from: f */
    public HashMap<KmlGroundOverlay, GroundOverlay> mo8312f() {
        return this.f4298f;
    }

    /* renamed from: a */
    static void m5362a(XmlPullParser xmlPullParser) throws XmlPullParserException, IOException {
        if (xmlPullParser.getEventType() != 2) {
            throw new IllegalStateException();
        }
        int i = 1;
        while (i != 0) {
            switch (xmlPullParser.next()) {
                case 2:
                    i++;
                    break;
                case 3:
                    i--;
                    break;
            }
        }
    }
}
