package p005pl.mg6.android.maps.extensions.impl;

import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.LatLngBounds;
import com.google.android.gms.maps.model.Polyline;
import com.google.android.gms.maps.model.PolylineOptions;
import java.util.ArrayList;
import java.util.List;
import p005pl.mg6.android.maps.extensions.utils.SphericalMercator;

/* renamed from: pl.mg6.android.maps.extensions.impl.DebugHelper */
class DebugHelper {
    private List<Polyline> gridLines = new ArrayList();

    DebugHelper() {
    }

    /* access modifiers changed from: package-private */
    public void drawDebugGrid(IGoogleMap map, double clusterSize) {
        cleanup();
        LatLngBounds bounds = map.getProjection().getVisibleRegion().latLngBounds;
        double minY = -180.0d + (((double) ((int) (SphericalMercator.scaleLatitude(bounds.southwest.latitude) / clusterSize))) * clusterSize);
        double minX = -180.0d + (((double) ((int) (SphericalMercator.scaleLongitude(bounds.southwest.longitude) / clusterSize))) * clusterSize);
        double maxY = -180.0d + (((double) ((int) (SphericalMercator.scaleLatitude(bounds.northeast.latitude) / clusterSize))) * clusterSize);
        double maxX = -180.0d + (((double) ((int) (SphericalMercator.scaleLongitude(bounds.northeast.longitude) / clusterSize))) * clusterSize);
        double y = minY;
        while (y <= maxY) {
            this.gridLines.add(map.addPolyline(new PolylineOptions().width(1.0f).add(new LatLng(SphericalMercator.toLatitude(y), bounds.southwest.longitude), new LatLng(SphericalMercator.toLatitude(y), bounds.northeast.longitude))));
            y += clusterSize;
        }
        if (minX <= maxX) {
            double x = minX;
            while (x <= maxX) {
                this.gridLines.add(map.addPolyline(new PolylineOptions().width(1.0f).add(new LatLng(bounds.southwest.latitude, x), new LatLng(bounds.northeast.latitude, x))));
                x += clusterSize;
            }
            return;
        }
        double x2 = -180.0d;
        while (x2 <= minX) {
            this.gridLines.add(map.addPolyline(new PolylineOptions().width(1.0f).add(new LatLng(bounds.southwest.latitude, x2), new LatLng(bounds.northeast.latitude, x2))));
            x2 += clusterSize;
        }
        double x3 = maxX;
        while (x3 < 180.0d) {
            this.gridLines.add(map.addPolyline(new PolylineOptions().width(1.0f).add(new LatLng(bounds.southwest.latitude, x3), new LatLng(bounds.northeast.latitude, x3))));
            x3 += clusterSize;
        }
    }

    /* access modifiers changed from: package-private */
    public void cleanup() {
        for (Polyline polyline : this.gridLines) {
            polyline.remove();
        }
        this.gridLines.clear();
    }
}
