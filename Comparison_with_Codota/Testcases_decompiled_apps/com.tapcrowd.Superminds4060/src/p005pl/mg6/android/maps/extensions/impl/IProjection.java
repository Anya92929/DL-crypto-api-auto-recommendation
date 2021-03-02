package p005pl.mg6.android.maps.extensions.impl;

import android.graphics.Point;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.VisibleRegion;

/* renamed from: pl.mg6.android.maps.extensions.impl.IProjection */
interface IProjection {
    LatLng fromScreenLocation(Point point);

    VisibleRegion getVisibleRegion();

    Point toScreenLocation(LatLng latLng);
}
