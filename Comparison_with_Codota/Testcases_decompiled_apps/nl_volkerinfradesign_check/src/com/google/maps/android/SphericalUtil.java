package com.google.maps.android;

import com.google.android.gms.maps.model.LatLng;
import java.util.List;

public class SphericalUtil {
    private SphericalUtil() {
    }

    public static double computeHeading(LatLng latLng, LatLng latLng2) {
        double radians = Math.toRadians(latLng.latitude);
        double radians2 = Math.toRadians(latLng.longitude);
        double radians3 = Math.toRadians(latLng2.latitude);
        double radians4 = Math.toRadians(latLng2.longitude) - radians2;
        return C1210hm.m5293b(Math.toDegrees(Math.atan2(Math.sin(radians4) * Math.cos(radians3), (Math.cos(radians) * Math.sin(radians3)) - ((Math.sin(radians) * Math.cos(radians3)) * Math.cos(radians4)))), -180.0d, 180.0d);
    }

    public static LatLng computeOffset(LatLng latLng, double d, double d2) {
        double d3 = d / 6371009.0d;
        double radians = Math.toRadians(d2);
        double radians2 = Math.toRadians(latLng.latitude);
        double radians3 = Math.toRadians(latLng.longitude);
        double cos = Math.cos(d3);
        double sin = Math.sin(d3);
        double sin2 = Math.sin(radians2);
        double cos2 = Math.cos(radians2);
        double cos3 = (cos * sin2) + (sin * cos2 * Math.cos(radians));
        return new LatLng(Math.toDegrees(Math.asin(cos3)), Math.toDegrees(Math.atan2(sin * cos2 * Math.sin(radians), cos - (sin2 * cos3)) + radians3));
    }

    public static LatLng computeOffsetOrigin(LatLng latLng, double d, double d2) {
        double d3;
        double radians = Math.toRadians(d2);
        double d4 = d / 6371009.0d;
        double cos = Math.cos(d4);
        double sin = Math.sin(d4) * Math.cos(radians);
        double sin2 = Math.sin(d4) * Math.sin(radians);
        double sin3 = Math.sin(Math.toRadians(latLng.latitude));
        double d5 = cos * cos;
        double d6 = (((sin * sin) * d5) + (d5 * d5)) - ((d5 * sin3) * sin3);
        if (d6 < 0.0d) {
            return null;
        }
        double sqrt = ((sin * sin3) + Math.sqrt(d6)) / ((cos * cos) + (sin * sin));
        double d7 = (sin3 - (sin * sqrt)) / cos;
        double atan2 = Math.atan2(d7, sqrt);
        if (atan2 < -1.5707963267948966d || atan2 > 1.5707963267948966d) {
            d3 = Math.atan2(d7, ((sin * sin3) - Math.sqrt(d6)) / ((cos * cos) + (sin * sin)));
        } else {
            d3 = atan2;
        }
        if (d3 < -1.5707963267948966d || d3 > 1.5707963267948966d) {
            return null;
        }
        return new LatLng(Math.toDegrees(d3), Math.toDegrees(Math.toRadians(latLng.longitude) - Math.atan2(sin2, (cos * Math.cos(d3)) - (sin * Math.sin(d3)))));
    }

    public static LatLng interpolate(LatLng latLng, LatLng latLng2, double d) {
        double radians = Math.toRadians(latLng.latitude);
        double radians2 = Math.toRadians(latLng.longitude);
        double radians3 = Math.toRadians(latLng2.latitude);
        double radians4 = Math.toRadians(latLng2.longitude);
        double cos = Math.cos(radians);
        double cos2 = Math.cos(radians3);
        double a = m4464a(latLng, latLng2);
        double sin = Math.sin(a);
        if (sin < 1.0E-6d) {
            return latLng;
        }
        double sin2 = Math.sin((1.0d - d) * a) / sin;
        double sin3 = Math.sin(a * d) / sin;
        double cos3 = (sin2 * cos * Math.cos(radians2)) + (sin3 * cos2 * Math.cos(radians4));
        double sin4 = (Math.sin(radians2) * cos * sin2) + (Math.sin(radians4) * sin3 * cos2);
        return new LatLng(Math.toDegrees(Math.atan2((Math.sin(radians) * sin2) + (Math.sin(radians3) * sin3), Math.sqrt((cos3 * cos3) + (sin4 * sin4)))), Math.toDegrees(Math.atan2(sin4, cos3)));
    }

    /* renamed from: a */
    private static double m4463a(double d, double d2, double d3, double d4) {
        return C1210hm.m5296d(C1210hm.m5295c(d, d3, d2 - d4));
    }

    /* renamed from: a */
    static double m4464a(LatLng latLng, LatLng latLng2) {
        return m4463a(Math.toRadians(latLng.latitude), Math.toRadians(latLng.longitude), Math.toRadians(latLng2.latitude), Math.toRadians(latLng2.longitude));
    }

    public static double computeDistanceBetween(LatLng latLng, LatLng latLng2) {
        return m4464a(latLng, latLng2) * 6371009.0d;
    }

    public static double computeLength(List<LatLng> list) {
        if (list.size() < 2) {
            return 0.0d;
        }
        LatLng latLng = list.get(0);
        double radians = Math.toRadians(latLng.latitude);
        double radians2 = Math.toRadians(latLng.longitude);
        double d = radians;
        double d2 = 0.0d;
        for (LatLng next : list) {
            double radians3 = Math.toRadians(next.latitude);
            double radians4 = Math.toRadians(next.longitude);
            radians2 = radians4;
            d2 = m4463a(d, radians2, radians3, radians4) + d2;
            d = radians3;
        }
        return d2 * 6371009.0d;
    }

    public static double computeArea(List<LatLng> list) {
        return Math.abs(computeSignedArea(list));
    }

    public static double computeSignedArea(List<LatLng> list) {
        return m4465a(list, 6371009.0d);
    }

    /* renamed from: a */
    static double m4465a(List<LatLng> list, double d) {
        int size = list.size();
        if (size < 3) {
            return 0.0d;
        }
        LatLng latLng = list.get(size - 1);
        double tan = Math.tan((1.5707963267948966d - Math.toRadians(latLng.latitude)) / 2.0d);
        double radians = Math.toRadians(latLng.longitude);
        double d2 = 0.0d;
        for (LatLng next : list) {
            double tan2 = Math.tan((1.5707963267948966d - Math.toRadians(next.latitude)) / 2.0d);
            double radians2 = Math.toRadians(next.longitude);
            radians = radians2;
            d2 = m4466b(tan2, radians2, tan, radians) + d2;
            tan = tan2;
        }
        return d * d * d2;
    }

    /* renamed from: b */
    private static double m4466b(double d, double d2, double d3, double d4) {
        double d5 = d2 - d4;
        double d6 = d * d3;
        return Math.atan2(Math.sin(d5) * d6, (Math.cos(d5) * d6) + 1.0d) * 2.0d;
    }
}
