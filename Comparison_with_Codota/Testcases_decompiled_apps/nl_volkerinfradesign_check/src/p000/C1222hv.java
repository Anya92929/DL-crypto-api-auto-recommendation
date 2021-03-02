package p000;

import com.google.maps.android.kml.KmlBoolean;
import java.io.IOException;
import java.util.HashMap;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

/* renamed from: hv */
class C1222hv {
    /* renamed from: a */
    static C1221hu m5460a(XmlPullParser xmlPullParser) throws IOException, XmlPullParserException {
        C1221hu huVar = new C1221hu();
        m5461a(xmlPullParser.getAttributeValue((String) null, "id"), huVar);
        int eventType = xmlPullParser.getEventType();
        while (true) {
            if (eventType == 3 && xmlPullParser.getName().equals("Style")) {
                return huVar;
            }
            if (eventType == 2) {
                if (xmlPullParser.getName().equals("IconStyle")) {
                    m5462a(xmlPullParser, huVar);
                } else if (xmlPullParser.getName().equals("LineStyle")) {
                    m5467e(xmlPullParser, huVar);
                } else if (xmlPullParser.getName().equals("PolyStyle")) {
                    m5468f(xmlPullParser, huVar);
                } else if (xmlPullParser.getName().equals("BalloonStyle")) {
                    m5464b(xmlPullParser, huVar);
                }
            }
            eventType = xmlPullParser.next();
        }
    }

    /* renamed from: a */
    private static void m5461a(String str, C1221hu huVar) {
        if (str != null) {
            String valueOf = String.valueOf(str);
            huVar.mo8339b(valueOf.length() != 0 ? "#".concat(valueOf) : new String("#"));
        }
    }

    /* renamed from: a */
    private static void m5462a(XmlPullParser xmlPullParser, C1221hu huVar) throws XmlPullParserException, IOException {
        int eventType = xmlPullParser.getEventType();
        while (true) {
            if (eventType != 3 || !xmlPullParser.getName().equals("IconStyle")) {
                if (eventType == 2) {
                    if (xmlPullParser.getName().equals("heading")) {
                        huVar.mo8334a(Float.parseFloat(xmlPullParser.nextText()));
                    } else if (xmlPullParser.getName().equals("Icon")) {
                        m5465c(xmlPullParser, huVar);
                    } else if (xmlPullParser.getName().equals("hotSpot")) {
                        m5466d(xmlPullParser, huVar);
                    } else if (xmlPullParser.getName().equals("scale")) {
                        huVar.mo8333a(Double.parseDouble(xmlPullParser.nextText()));
                    } else if (xmlPullParser.getName().equals("color")) {
                        huVar.mo8349f(xmlPullParser.nextText());
                    } else if (xmlPullParser.getName().equals("colorMode")) {
                        huVar.mo8350g(xmlPullParser.nextText());
                    }
                }
                eventType = xmlPullParser.next();
            } else {
                return;
            }
        }
    }

    /* renamed from: b */
    static HashMap<String, String> m5463b(XmlPullParser xmlPullParser) throws XmlPullParserException, IOException {
        HashMap<String, String> hashMap = new HashMap<>();
        String valueOf = String.valueOf(xmlPullParser.getAttributeValue((String) null, "id"));
        String concat = valueOf.length() != 0 ? "#".concat(valueOf) : new String("#");
        Boolean bool = false;
        int eventType = xmlPullParser.getEventType();
        while (true) {
            if (eventType == 3 && xmlPullParser.getName().equals("StyleMap")) {
                return hashMap;
            }
            if (eventType == 2) {
                if (xmlPullParser.getName().equals("key") && xmlPullParser.nextText().equals("normal")) {
                    bool = true;
                } else if (xmlPullParser.getName().equals("styleUrl") && bool.booleanValue()) {
                    hashMap.put(concat, xmlPullParser.nextText());
                    bool = false;
                }
            }
            eventType = xmlPullParser.next();
        }
    }

    /* renamed from: b */
    private static void m5464b(XmlPullParser xmlPullParser, C1221hu huVar) throws XmlPullParserException, IOException {
        int eventType = xmlPullParser.getEventType();
        while (true) {
            if (eventType != 3 || !xmlPullParser.getName().equals("BalloonStyle")) {
                if (eventType == 2 && xmlPullParser.getName().equals("text")) {
                    huVar.mo8337a(xmlPullParser.nextText());
                }
                eventType = xmlPullParser.next();
            } else {
                return;
            }
        }
    }

    /* renamed from: c */
    private static void m5465c(XmlPullParser xmlPullParser, C1221hu huVar) throws XmlPullParserException, IOException {
        int eventType = xmlPullParser.getEventType();
        while (true) {
            if (eventType != 3 || !xmlPullParser.getName().equals("Icon")) {
                if (eventType == 2 && xmlPullParser.getName().equals("href")) {
                    huVar.mo8344d(xmlPullParser.nextText());
                }
                eventType = xmlPullParser.next();
            } else {
                return;
            }
        }
    }

    /* renamed from: d */
    private static void m5466d(XmlPullParser xmlPullParser, C1221hu huVar) {
        Float valueOf = Float.valueOf(Float.parseFloat(xmlPullParser.getAttributeValue((String) null, "x")));
        Float valueOf2 = Float.valueOf(Float.parseFloat(xmlPullParser.getAttributeValue((String) null, "y")));
        huVar.mo8335a(valueOf.floatValue(), valueOf2.floatValue(), xmlPullParser.getAttributeValue((String) null, "xunits"), xmlPullParser.getAttributeValue((String) null, "yunits"));
    }

    /* renamed from: e */
    private static void m5467e(XmlPullParser xmlPullParser, C1221hu huVar) throws XmlPullParserException, IOException {
        int eventType = xmlPullParser.getEventType();
        while (true) {
            if (eventType != 3 || !xmlPullParser.getName().equals("LineStyle")) {
                if (eventType == 2) {
                    if (xmlPullParser.getName().equals("color")) {
                        huVar.mo8357j(xmlPullParser.nextText());
                    } else if (xmlPullParser.getName().equals("width")) {
                        huVar.mo8336a(Float.valueOf(xmlPullParser.nextText()));
                    } else if (xmlPullParser.getName().equals("colorMode")) {
                        huVar.mo8352h(xmlPullParser.nextText());
                    }
                }
                eventType = xmlPullParser.next();
            } else {
                return;
            }
        }
    }

    /* renamed from: f */
    private static void m5468f(XmlPullParser xmlPullParser, C1221hu huVar) throws XmlPullParserException, IOException {
        int eventType = xmlPullParser.getEventType();
        while (true) {
            if (eventType != 3 || !xmlPullParser.getName().equals("PolyStyle")) {
                if (eventType == 2) {
                    if (xmlPullParser.getName().equals("color")) {
                        huVar.mo8346e(xmlPullParser.nextText());
                    } else if (xmlPullParser.getName().equals("outline")) {
                        huVar.mo8340b(KmlBoolean.parseBoolean(xmlPullParser.nextText()));
                    } else if (xmlPullParser.getName().equals("fill")) {
                        huVar.mo8338a(KmlBoolean.parseBoolean(xmlPullParser.nextText()));
                    } else if (xmlPullParser.getName().equals("colorMode")) {
                        huVar.mo8354i(xmlPullParser.nextText());
                    }
                }
                eventType = xmlPullParser.next();
            } else {
                return;
            }
        }
    }
}
