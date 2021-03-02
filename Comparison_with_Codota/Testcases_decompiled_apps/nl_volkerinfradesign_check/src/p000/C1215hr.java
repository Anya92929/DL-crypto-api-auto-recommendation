package p000;

import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.LatLngBounds;
import com.google.maps.android.kml.KmlGeometry;
import com.google.maps.android.kml.KmlGroundOverlay;
import com.google.maps.android.kml.KmlLineString;
import com.google.maps.android.kml.KmlMultiGeometry;
import com.google.maps.android.kml.KmlPlacemark;
import com.google.maps.android.kml.KmlPoint;
import com.google.maps.android.kml.KmlPolygon;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

/* renamed from: hr */
class C1215hr {
    /* renamed from: a */
    static KmlPlacemark m5351a(XmlPullParser xmlPullParser) throws IOException, XmlPullParserException {
        C1221hu huVar = null;
        HashMap hashMap = new HashMap();
        int eventType = xmlPullParser.getEventType();
        String str = null;
        KmlGeometry kmlGeometry = null;
        while (true) {
            if (eventType == 3 && xmlPullParser.getName().equals("Placemark")) {
                return new KmlPlacemark(kmlGeometry, str, huVar, hashMap);
            }
            if (eventType == 2) {
                if (xmlPullParser.getName().equals("styleUrl")) {
                    str = xmlPullParser.nextText();
                } else if (xmlPullParser.getName().matches("Point|LineString|Polygon|MultiGeometry")) {
                    kmlGeometry = m5350a(xmlPullParser, xmlPullParser.getName());
                } else if (xmlPullParser.getName().matches("name|description|visibility|open|address|phoneNumber")) {
                    hashMap.put(xmlPullParser.getName(), xmlPullParser.nextText());
                } else if (xmlPullParser.getName().equals("ExtendedData")) {
                    hashMap.putAll(m5357e(xmlPullParser));
                } else if (xmlPullParser.getName().equals("Style")) {
                    huVar = C1222hv.m5460a(xmlPullParser);
                }
            }
            eventType = xmlPullParser.next();
        }
    }

    /* renamed from: b */
    static KmlGroundOverlay m5354b(XmlPullParser xmlPullParser) throws IOException, XmlPullParserException {
        float f = BitmapDescriptorFactory.HUE_RED;
        int i = 1;
        String str = null;
        HashMap hashMap = new HashMap();
        HashMap hashMap2 = new HashMap();
        int eventType = xmlPullParser.getEventType();
        float f2 = 0.0f;
        while (true) {
            if (eventType == 3 && xmlPullParser.getName().equals("GroundOverlay")) {
                return new KmlGroundOverlay(str, m5349a((Double) hashMap2.get("north"), (Double) hashMap2.get("south"), (Double) hashMap2.get("east"), (Double) hashMap2.get("west")), f2, i, hashMap, f);
            }
            if (eventType == 2) {
                if (xmlPullParser.getName().equals("Icon")) {
                    str = m5356d(xmlPullParser);
                } else if (xmlPullParser.getName().equals("drawOrder")) {
                    f2 = Float.parseFloat(xmlPullParser.nextText());
                } else if (xmlPullParser.getName().equals("visibility")) {
                    i = Integer.parseInt(xmlPullParser.nextText());
                } else if (xmlPullParser.getName().equals("ExtendedData")) {
                    hashMap.putAll(m5357e(xmlPullParser));
                } else if (xmlPullParser.getName().equals("rotation")) {
                    f = m5355c(xmlPullParser);
                } else if (xmlPullParser.getName().matches("name|description|visibility|open|address|phoneNumber") || xmlPullParser.getName().equals("color")) {
                    hashMap.put(xmlPullParser.getName(), xmlPullParser.nextText());
                } else if (xmlPullParser.getName().matches("north|south|east|west")) {
                    hashMap2.put(xmlPullParser.getName(), Double.valueOf(Double.parseDouble(xmlPullParser.nextText())));
                }
            }
            eventType = xmlPullParser.next();
        }
    }

    /* renamed from: c */
    private static float m5355c(XmlPullParser xmlPullParser) throws IOException, XmlPullParserException {
        return -Float.parseFloat(xmlPullParser.nextText());
    }

    /* renamed from: d */
    private static String m5356d(XmlPullParser xmlPullParser) throws IOException, XmlPullParserException {
        int eventType = xmlPullParser.getEventType();
        while (true) {
            if (eventType == 3 && xmlPullParser.getName().equals("Icon")) {
                return null;
            }
            if (eventType == 2 && xmlPullParser.getName().equals("href")) {
                return xmlPullParser.nextText();
            }
            eventType = xmlPullParser.next();
        }
    }

    /* renamed from: a */
    private static KmlGeometry m5350a(XmlPullParser xmlPullParser, String str) throws IOException, XmlPullParserException {
        int eventType = xmlPullParser.getEventType();
        while (true) {
            if (eventType == 3 && xmlPullParser.getName().equals(str)) {
                return null;
            }
            if (eventType == 2) {
                if (xmlPullParser.getName().equals(KmlPoint.GEOMETRY_TYPE)) {
                    return m5358f(xmlPullParser);
                }
                if (xmlPullParser.getName().equals(KmlLineString.GEOMETRY_TYPE)) {
                    return m5359g(xmlPullParser);
                }
                if (xmlPullParser.getName().equals(KmlPolygon.GEOMETRY_TYPE)) {
                    return m5360h(xmlPullParser);
                }
                if (xmlPullParser.getName().equals("MultiGeometry")) {
                    return m5361i(xmlPullParser);
                }
            }
            eventType = xmlPullParser.next();
        }
    }

    /* renamed from: e */
    private static HashMap<String, String> m5357e(XmlPullParser xmlPullParser) throws XmlPullParserException, IOException {
        HashMap<String, String> hashMap = new HashMap<>();
        int eventType = xmlPullParser.getEventType();
        String str = null;
        while (true) {
            if (eventType == 3 && xmlPullParser.getName().equals("ExtendedData")) {
                return hashMap;
            }
            if (eventType == 2) {
                if (xmlPullParser.getName().equals("Data")) {
                    str = xmlPullParser.getAttributeValue((String) null, "name");
                } else if (xmlPullParser.getName().equals("value") && str != null) {
                    hashMap.put(str, xmlPullParser.nextText());
                    str = null;
                }
            }
            eventType = xmlPullParser.next();
        }
    }

    /* renamed from: f */
    private static KmlPoint m5358f(XmlPullParser xmlPullParser) throws XmlPullParserException, IOException {
        LatLng latLng = null;
        int eventType = xmlPullParser.getEventType();
        while (true) {
            if (eventType == 3 && xmlPullParser.getName().equals(KmlPoint.GEOMETRY_TYPE)) {
                return new KmlPoint(latLng);
            }
            if (eventType == 2 && xmlPullParser.getName().equals("coordinates")) {
                latLng = m5353b(xmlPullParser.nextText());
            }
            eventType = xmlPullParser.next();
        }
    }

    /* renamed from: g */
    private static KmlLineString m5359g(XmlPullParser xmlPullParser) throws XmlPullParserException, IOException {
        ArrayList<LatLng> arrayList = new ArrayList<>();
        ArrayList<LatLng> arrayList2 = arrayList;
        int eventType = xmlPullParser.getEventType();
        while (true) {
            if (eventType == 3 && xmlPullParser.getName().equals(KmlLineString.GEOMETRY_TYPE)) {
                return new KmlLineString(arrayList2);
            }
            if (eventType == 2 && xmlPullParser.getName().equals("coordinates")) {
                arrayList2 = m5352a(xmlPullParser.nextText());
            }
            eventType = xmlPullParser.next();
        }
    }

    /* renamed from: h */
    private static KmlPolygon m5360h(XmlPullParser xmlPullParser) throws XmlPullParserException, IOException {
        ArrayList<LatLng> arrayList = new ArrayList<>();
        ArrayList arrayList2 = new ArrayList();
        ArrayList<LatLng> arrayList3 = arrayList;
        Boolean bool = false;
        int eventType = xmlPullParser.getEventType();
        while (true) {
            if (eventType == 3 && xmlPullParser.getName().equals(KmlPolygon.GEOMETRY_TYPE)) {
                return new KmlPolygon(arrayList3, arrayList2);
            }
            if (eventType == 2) {
                if (xmlPullParser.getName().matches("outerBoundaryIs|innerBoundaryIs")) {
                    bool = Boolean.valueOf(xmlPullParser.getName().equals("outerBoundaryIs"));
                } else if (xmlPullParser.getName().equals("coordinates")) {
                    if (bool.booleanValue()) {
                        arrayList3 = m5352a(xmlPullParser.nextText());
                    } else {
                        arrayList2.add(m5352a(xmlPullParser.nextText()));
                    }
                }
            }
            eventType = xmlPullParser.next();
        }
    }

    /* renamed from: i */
    private static KmlMultiGeometry m5361i(XmlPullParser xmlPullParser) throws XmlPullParserException, IOException {
        ArrayList arrayList = new ArrayList();
        int next = xmlPullParser.next();
        while (true) {
            if (next == 3 && xmlPullParser.getName().equals("MultiGeometry")) {
                return new KmlMultiGeometry(arrayList);
            }
            if (next == 2 && xmlPullParser.getName().matches("Point|LineString|Polygon|MultiGeometry")) {
                arrayList.add(m5350a(xmlPullParser, xmlPullParser.getName()));
            }
            next = xmlPullParser.next();
        }
    }

    /* renamed from: a */
    private static ArrayList<LatLng> m5352a(String str) {
        ArrayList<LatLng> arrayList = new ArrayList<>();
        for (String b : str.trim().split("(\\s+)")) {
            arrayList.add(m5353b(b));
        }
        return arrayList;
    }

    /* renamed from: b */
    private static LatLng m5353b(String str) {
        String[] split = str.split(",");
        return new LatLng(Double.valueOf(Double.parseDouble(split[1])).doubleValue(), Double.valueOf(Double.parseDouble(split[0])).doubleValue());
    }

    /* renamed from: a */
    private static LatLngBounds m5349a(Double d, Double d2, Double d3, Double d4) {
        return new LatLngBounds(new LatLng(d2.doubleValue(), d4.doubleValue()), new LatLng(d.doubleValue(), d3.doubleValue()));
    }
}
