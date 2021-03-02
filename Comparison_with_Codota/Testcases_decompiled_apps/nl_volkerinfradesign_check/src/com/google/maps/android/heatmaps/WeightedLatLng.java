package com.google.maps.android.heatmaps;

import com.google.android.gms.maps.model.LatLng;
import com.google.maps.android.geometry.Point;
import com.google.maps.android.projection.SphericalMercatorProjection;
import com.google.maps.android.quadtree.PointQuadTree;

public class WeightedLatLng implements PointQuadTree.Item {
    public static final double DEFAULT_INTENSITY = 1.0d;

    /* renamed from: a */
    private static final SphericalMercatorProjection f3990a = new SphericalMercatorProjection(1.0d);

    /* renamed from: b */
    private Point f3991b;

    /* renamed from: c */
    private double f3992c;

    public WeightedLatLng(LatLng latLng, double d) {
        this.f3991b = f3990a.toPoint(latLng);
        if (d >= 0.0d) {
            this.f3992c = d;
        } else {
            this.f3992c = 1.0d;
        }
    }

    public WeightedLatLng(LatLng latLng) {
        this(latLng, 1.0d);
    }

    public Point getPoint() {
        return this.f3991b;
    }

    public double getIntensity() {
        return this.f3992c;
    }
}
