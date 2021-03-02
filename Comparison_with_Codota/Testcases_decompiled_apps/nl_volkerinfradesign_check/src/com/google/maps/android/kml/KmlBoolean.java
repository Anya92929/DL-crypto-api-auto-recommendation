package com.google.maps.android.kml;

public class KmlBoolean {
    public static boolean parseBoolean(String str) {
        if ("1".equals(str) || "true".equals(str)) {
            return true;
        }
        return false;
    }
}
