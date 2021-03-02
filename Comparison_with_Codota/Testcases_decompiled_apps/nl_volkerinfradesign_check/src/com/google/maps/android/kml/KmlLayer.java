package com.google.maps.android.kml;

import android.content.Context;
import com.google.android.gms.maps.GoogleMap;
import java.io.IOException;
import java.io.InputStream;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;
import org.xmlpull.v1.XmlPullParserFactory;

public class KmlLayer {

    /* renamed from: a */
    private final C1217ht f4004a;

    public KmlLayer(GoogleMap googleMap, int i, Context context) throws XmlPullParserException, IOException {
        this(googleMap, context.getResources().openRawResource(i), context);
    }

    public KmlLayer(GoogleMap googleMap, InputStream inputStream, Context context) throws XmlPullParserException, IOException {
        if (inputStream == null) {
            throw new IllegalArgumentException("KML InputStream cannot be null");
        }
        this.f4004a = new C1217ht(googleMap, context);
        C1216hs hsVar = new C1216hs(m4556a(inputStream));
        hsVar.mo8307a();
        inputStream.close();
        this.f4004a.mo8315a(hsVar.mo8308b(), hsVar.mo8310d(), hsVar.mo8309c(), hsVar.mo8311e(), hsVar.mo8312f());
    }

    /* renamed from: a */
    private static XmlPullParser m4556a(InputStream inputStream) throws XmlPullParserException {
        XmlPullParserFactory newInstance = XmlPullParserFactory.newInstance();
        newInstance.setNamespaceAware(true);
        XmlPullParser newPullParser = newInstance.newPullParser();
        newPullParser.setInput(inputStream, (String) null);
        return newPullParser;
    }

    public void addLayerToMap() throws IOException, XmlPullParserException {
        this.f4004a.mo8316b();
    }

    public void removeLayerFromMap() {
        this.f4004a.mo8323i();
    }

    public boolean hasPlacemarks() {
        return this.f4004a.mo8318d();
    }

    public Iterable<KmlPlacemark> getPlacemarks() {
        return this.f4004a.mo8319e();
    }

    public boolean hasContainers() {
        return this.f4004a.mo8320f();
    }

    public Iterable<KmlContainer> getContainers() {
        return this.f4004a.mo8321g();
    }

    public Iterable<KmlGroundOverlay> getGroundOverlays() {
        return this.f4004a.mo8322h();
    }

    public GoogleMap getMap() {
        return this.f4004a.mo8317c();
    }

    public void setMap(GoogleMap googleMap) {
        this.f4004a.mo8313a(googleMap);
    }
}
