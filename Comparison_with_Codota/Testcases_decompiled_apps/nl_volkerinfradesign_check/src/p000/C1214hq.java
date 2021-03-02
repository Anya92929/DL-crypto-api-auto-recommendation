package p000;

import com.google.maps.android.kml.KmlContainer;
import com.google.maps.android.kml.KmlPlacemark;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

/* renamed from: hq */
class C1214hq {
    /* renamed from: a */
    static KmlContainer m5343a(XmlPullParser xmlPullParser) throws XmlPullParserException, IOException {
        return m5345b(xmlPullParser);
    }

    /* renamed from: b */
    private static KmlContainer m5345b(XmlPullParser xmlPullParser) throws XmlPullParserException, IOException {
        String str;
        String name = xmlPullParser.getName();
        HashMap hashMap = new HashMap();
        HashMap hashMap2 = new HashMap();
        HashMap hashMap3 = new HashMap();
        ArrayList arrayList = new ArrayList();
        HashMap hashMap4 = new HashMap();
        HashMap hashMap5 = new HashMap();
        if (xmlPullParser.getAttributeValue((String) null, "id") != null) {
            str = xmlPullParser.getAttributeValue((String) null, "id");
        } else {
            str = null;
        }
        xmlPullParser.next();
        int eventType = xmlPullParser.getEventType();
        while (true) {
            if (eventType == 3 && xmlPullParser.getName().equals(name)) {
                return new KmlContainer(hashMap, hashMap2, hashMap3, hashMap4, arrayList, hashMap5, str);
            }
            if (eventType == 2) {
                if (xmlPullParser.getName().matches("altitude|altitudeModeGroup|altitudeMode|begin|bottomFov|cookie|displayName|displayMode|displayMode|end|expires|extrude|flyToView|gridOrigin|httpQuery|leftFov|linkDescription|linkName|linkSnippet|listItemType|maxSnippetLines|maxSessionLength|message|minAltitude|minFadeExtent|minLodPixels|minRefreshPeriod|maxAltitude|maxFadeExtent|maxLodPixels|maxHeight|maxWidth|near|overlayXY|range|refreshMode|refreshInterval|refreshVisibility|rightFov|roll|rotationXY|screenXY|shape|sourceHref|state|targetHref|tessellate|tileSize|topFov|viewBoundScale|viewFormat|viewRefreshMode|viewRefreshTime|when")) {
                    C1216hs.m5362a(xmlPullParser);
                } else if (xmlPullParser.getName().matches("Folder|Document")) {
                    arrayList.add(m5345b(xmlPullParser));
                } else if (xmlPullParser.getName().matches("name|description|visibility|open|address|phoneNumber")) {
                    hashMap.put(xmlPullParser.getName(), xmlPullParser.nextText());
                } else if (xmlPullParser.getName().equals("StyleMap")) {
                    m5344a(xmlPullParser, hashMap4);
                } else if (xmlPullParser.getName().equals("Style")) {
                    m5347c(xmlPullParser, hashMap2);
                } else if (xmlPullParser.getName().equals("Placemark")) {
                    m5348d(xmlPullParser, hashMap3);
                } else if (xmlPullParser.getName().equals("ExtendedData")) {
                    m5346b(xmlPullParser, hashMap);
                } else if (xmlPullParser.getName().equals("GroundOverlay")) {
                    hashMap5.put(C1215hr.m5354b(xmlPullParser), (Object) null);
                }
            }
            eventType = xmlPullParser.next();
        }
    }

    /* renamed from: a */
    private static void m5344a(XmlPullParser xmlPullParser, HashMap<String, String> hashMap) throws XmlPullParserException, IOException {
        hashMap.putAll(C1222hv.m5463b(xmlPullParser));
    }

    /* renamed from: b */
    private static void m5346b(XmlPullParser xmlPullParser, HashMap<String, String> hashMap) throws XmlPullParserException, IOException {
        int eventType = xmlPullParser.getEventType();
        String str = null;
        while (true) {
            if (eventType != 3 || !xmlPullParser.getName().equals("ExtendedData")) {
                if (eventType == 2) {
                    if (xmlPullParser.getName().equals("Data")) {
                        str = xmlPullParser.getAttributeValue((String) null, "name");
                    } else if (xmlPullParser.getName().equals("value") && str != null) {
                        hashMap.put(str, xmlPullParser.nextText());
                        str = null;
                    }
                }
                eventType = xmlPullParser.next();
            } else {
                return;
            }
        }
    }

    /* renamed from: c */
    private static void m5347c(XmlPullParser xmlPullParser, HashMap<String, C1221hu> hashMap) throws XmlPullParserException, IOException {
        if (xmlPullParser.getAttributeValue((String) null, "id") != null) {
            C1221hu a = C1222hv.m5460a(xmlPullParser);
            hashMap.put(a.mo8332a(), a);
        }
    }

    /* renamed from: d */
    private static void m5348d(XmlPullParser xmlPullParser, HashMap<KmlPlacemark, Object> hashMap) throws XmlPullParserException, IOException {
        hashMap.put(C1215hr.m5351a(xmlPullParser), (Object) null);
    }
}
