package com.google.maps.android.projection;

import com.google.android.gms.maps.model.LatLng;
import com.google.maps.android.geometry.Point;

public class SphericalMercatorProjection {

    /* renamed from: a */
    final double f4014a;

    public SphericalMercatorProjection(double d) {
        this.f4014a = d;
    }

    public Point toPoint(LatLng latLng) {
        double sin = Math.sin(Math.toRadians(latLng.latitude));
        return new Point(((latLng.longitude / 360.0d) + 0.5d) * this.f4014a, (((Math.log((1.0d + sin) / (1.0d - sin)) * 0.5d) / -6.283185307179586d) + 0.5d) * this.f4014a);
    }

    public LatLng toLatLng(Point point) {
        return new LatLng(90.0d - Math.toDegrees(Math.atan(Math.exp(((-(0.5d - (point.f3970y / this.f4014a))) * 2.0d) * 3.141592653589793d)) * 2.0d), ((point.f3969x / this.f4014a) - 0.5d) * 360.0d);
    }
}
