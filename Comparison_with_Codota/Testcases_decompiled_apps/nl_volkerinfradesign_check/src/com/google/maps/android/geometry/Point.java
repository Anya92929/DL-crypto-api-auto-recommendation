package com.google.maps.android.geometry;

public class Point {

    /* renamed from: x */
    public final double f3969x;

    /* renamed from: y */
    public final double f3970y;

    public Point(double d, double d2) {
        this.f3969x = d;
        this.f3970y = d2;
    }

    public String toString() {
        String valueOf = String.valueOf("Point{x=");
        double d = this.f3969x;
        return new StringBuilder(String.valueOf(valueOf).length() + 53).append(valueOf).append(d).append(", y=").append(this.f3970y).append("}").toString();
    }
}
