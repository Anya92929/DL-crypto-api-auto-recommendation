package p005pl.mg6.android.maps.extensions.impl;

import com.google.android.gms.maps.model.LatLng;
import java.util.List;
import p005pl.mg6.android.maps.extensions.Marker;
import p005pl.mg6.android.maps.extensions.lazy.LazyMarker;

/* renamed from: pl.mg6.android.maps.extensions.impl.DelegatingMarker */
class DelegatingMarker implements Marker {
    private Object data;
    private DelegatingGoogleMap map;
    private LazyMarker real;
    private boolean visible;

    DelegatingMarker(LazyMarker real2, DelegatingGoogleMap map2) {
        this.real = real2;
        this.map = map2;
        this.visible = real2.isVisible();
    }

    public Object getData() {
        return this.data;
    }

    @Deprecated
    public String getId() {
        return this.real.getId();
    }

    public List<Marker> getMarkers() {
        return null;
    }

    public LatLng getPosition() {
        return this.real.getPosition();
    }

    public String getSnippet() {
        return this.real.getSnippet();
    }

    public String getTitle() {
        return this.real.getTitle();
    }

    public void hideInfoWindow() {
        this.real.hideInfoWindow();
    }

    public boolean isCluster() {
        return false;
    }

    public boolean isDraggable() {
        return this.real.isDraggable();
    }

    public boolean isInfoWindowShown() {
        return this.real.isInfoWindowShown();
    }

    public boolean isVisible() {
        return this.visible;
    }

    public void remove() {
        this.real.remove();
        this.map.onRemove(this);
    }

    public void setData(Object data2) {
        this.data = data2;
    }

    public void setDraggable(boolean draggable) {
        this.real.setDraggable(draggable);
    }

    public void setPosition(LatLng position) {
        this.real.setPosition(position);
        this.map.onPositionChange(this);
    }

    public void setSnippet(String snippet) {
        this.real.setSnippet(snippet);
    }

    public void setTitle(String title) {
        this.real.setTitle(title);
    }

    public void setVisible(boolean visible2) {
        if (this.visible != visible2) {
            this.visible = visible2;
            this.map.onVisibilityChangeRequest(this, visible2);
        }
    }

    public void showInfoWindow() {
        this.real.showInfoWindow();
    }

    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof DelegatingMarker)) {
            return false;
        }
        return this.real.equals(((DelegatingMarker) o).real);
    }

    public int hashCode() {
        return this.real.hashCode();
    }

    public String toString() {
        return this.real.toString();
    }

    /* access modifiers changed from: package-private */
    public LazyMarker getReal() {
        return this.real;
    }

    /* access modifiers changed from: package-private */
    public void changeVisible(boolean visible2) {
        this.real.setVisible(this.visible && visible2);
    }
}
