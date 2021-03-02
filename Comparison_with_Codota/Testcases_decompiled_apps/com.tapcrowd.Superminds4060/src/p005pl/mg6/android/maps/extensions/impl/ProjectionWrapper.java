package p005pl.mg6.android.maps.extensions.impl;

import android.graphics.Point;
import com.google.android.gms.maps.Projection;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.VisibleRegion;

/* renamed from: pl.mg6.android.maps.extensions.impl.ProjectionWrapper */
class ProjectionWrapper implements IProjection {
    private Projection projection;

    public ProjectionWrapper(Projection projection2) {
        this.projection = projection2;
    }

    public LatLng fromScreenLocation(Point arg0) {
        return this.projection.fromScreenLocation(arg0);
    }

    public VisibleRegion getVisibleRegion() {
        return this.projection.getVisibleRegion();
    }

    public Point toScreenLocation(LatLng arg0) {
        return this.projection.toScreenLocation(arg0);
    }

    public Projection getProjection() {
        return this.projection;
    }
}
