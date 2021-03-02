package com.jackhenry.godough.core.locations;

import android.location.Location;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.LatLngBounds;
import com.jackhenry.godough.core.GoDoughApp;
import com.jackhenry.godough.core.model.GoDoughLocation;
import com.jackhenry.godough.core.model.LocationSearchCriteria;
import java.util.Iterator;

/* renamed from: com.jackhenry.godough.core.locations.s */
public class C1620s {
    /* renamed from: a */
    public static double m6281a(LocationSearchCriteria locationSearchCriteria) {
        double d;
        double d2 = 0.0d;
        float[] fArr = new float[3];
        boolean z = false;
        Iterator<GoDoughLocation> it = GoDoughApp.getLocations().iterator();
        while (true) {
            boolean z2 = z;
            d = d2;
            if (!it.hasNext()) {
                break;
            }
            GoDoughLocation next = it.next();
            if (m6284a(next.getLatitude(), next.getLongitude())) {
                Location.distanceBetween(locationSearchCriteria.getLatLng().latitude, locationSearchCriteria.getLatLng().longitude, next.getLatitude(), next.getLongitude(), fArr);
                if (!z2) {
                    d = (double) fArr[0];
                    z2 = true;
                } else if (((double) fArr[0]) > d) {
                    d = (double) fArr[0];
                }
            }
            z = z2;
            d2 = d;
        }
        if (d == 0.0d) {
            return 20.0d;
        }
        return 6.2137E-4d * d * 1.15d;
    }

    /* renamed from: a */
    public static LatLng m6282a(LatLng latLng, boolean z, double d) {
        double d2 = d / 69.0d;
        if (!z) {
            d2 = -d2;
        }
        return new LatLng(latLng.latitude + d2, d2 + latLng.longitude);
    }

    /* renamed from: a */
    public static LatLngBounds m6283a() {
        boolean z = false;
        double d = 0.0d;
        double d2 = 0.0d;
        double d3 = 0.0d;
        double d4 = 0.0d;
        float[] fArr = new float[3];
        Iterator<GoDoughLocation> it = GoDoughApp.getLocations().iterator();
        while (true) {
            double d5 = d;
            double d6 = d2;
            double d7 = d3;
            double d8 = d4;
            boolean z2 = z;
            if (it.hasNext()) {
                GoDoughLocation next = it.next();
                if (m6284a(next.getLatitude(), next.getLongitude())) {
                    if (!z2) {
                        d5 = next.getLatitude();
                        d6 = next.getLatitude();
                        d7 = next.getLongitude();
                        d8 = next.getLongitude();
                        z2 = true;
                    } else {
                        if (next.getLongitude() < d7) {
                            d7 = next.getLongitude();
                        } else if (next.getLongitude() > d8) {
                            d8 = next.getLongitude();
                        }
                        if (next.getLatitude() > d5) {
                            d5 = next.getLatitude();
                        } else if (next.getLatitude() < d6) {
                            d6 = next.getLatitude();
                        }
                    }
                }
                z = z2;
                d4 = d8;
                d3 = d7;
                d2 = d6;
                d = d5;
            } else {
                LatLng latLng = new LatLng(d5, d8);
                LatLng latLng2 = new LatLng(d6, d7);
                Location.distanceBetween(latLng.latitude, latLng.longitude, latLng2.latitude, latLng2.longitude, fArr);
                double d9 = ((((double) fArr[0]) * 6.2137E-4d) * 0.2d) / 2.0d;
                return new LatLngBounds(m6282a(latLng2, false, d9), m6282a(latLng, true, d9));
            }
        }
    }

    /* renamed from: a */
    public static boolean m6284a(double d, double d2) {
        return d2 < -50.0d && d2 > -170.0d && d < 75.0d && d > 15.0d;
    }
}
