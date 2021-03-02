package com.google.maps.android.kml;

public interface KmlGeometry<T> {
    T getGeometryObject();

    String getGeometryType();
}
