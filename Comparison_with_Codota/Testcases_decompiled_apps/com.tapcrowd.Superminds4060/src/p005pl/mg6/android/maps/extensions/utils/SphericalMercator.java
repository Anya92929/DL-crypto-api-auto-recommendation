package p005pl.mg6.android.maps.extensions.utils;

/* renamed from: pl.mg6.android.maps.extensions.utils.SphericalMercator */
public class SphericalMercator {
    private static final double MAX_LATITUDE = 85.0511287798d;
    private static final double MIN_LATITUDE = -85.0511287798d;

    private SphericalMercator() {
    }

    public static double fromLatitude(double latitude) {
        return Math.toDegrees(Math.log(Math.tan(Math.toRadians(90.0d + latitude) / 2.0d)));
    }

    public static double toLatitude(double mercator) {
        return Math.toDegrees(2.0d * Math.atan(Math.exp(Math.toRadians(mercator)))) - 90.0d;
    }

    public static double scaleLatitude(double latitude) {
        if (latitude < MIN_LATITUDE) {
            latitude = MIN_LATITUDE;
        } else if (latitude > MAX_LATITUDE) {
            latitude = MAX_LATITUDE;
        }
        return fromLatitude(latitude) + 180.0d;
    }

    public static double scaleLongitude(double longitude) {
        return 180.0d + longitude;
    }
}
