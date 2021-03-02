package p005pl.mg6.android.maps.extensions.lazy;

import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;

/* renamed from: pl.mg6.android.maps.extensions.lazy.LazyMarker */
public class LazyMarker {
    private OnMarkerCreateListener listener;
    private GoogleMap map;
    private Marker marker;
    private MarkerOptions markerOptions;

    /* renamed from: pl.mg6.android.maps.extensions.lazy.LazyMarker$OnMarkerCreateListener */
    public interface OnMarkerCreateListener {
        void onMarkerCreate(LazyMarker lazyMarker);
    }

    public LazyMarker(GoogleMap map2, MarkerOptions options) {
        this(map2, options, (OnMarkerCreateListener) null);
    }

    public LazyMarker(GoogleMap map2, MarkerOptions options, OnMarkerCreateListener listener2) {
        if (options.isVisible()) {
            createMarker(map2, options, listener2);
            return;
        }
        this.map = map2;
        this.markerOptions = copy(options);
        this.listener = listener2;
    }

    @Deprecated
    public String getId() {
        createMarker();
        return this.marker.getId();
    }

    public Marker getMarker() {
        return this.marker;
    }

    public LatLng getPosition() {
        if (this.marker != null) {
            return this.marker.getPosition();
        }
        return this.markerOptions.getPosition();
    }

    public String getSnippet() {
        if (this.marker != null) {
            return this.marker.getSnippet();
        }
        return this.markerOptions.getSnippet();
    }

    public String getTitle() {
        if (this.marker != null) {
            return this.marker.getTitle();
        }
        return this.markerOptions.getTitle();
    }

    public void hideInfoWindow() {
        if (this.marker != null) {
            this.marker.hideInfoWindow();
        }
    }

    public boolean isDraggable() {
        if (this.marker != null) {
            return this.marker.isDraggable();
        }
        return this.markerOptions.isDraggable();
    }

    public boolean isInfoWindowShown() {
        if (this.marker != null) {
            return this.marker.isInfoWindowShown();
        }
        return false;
    }

    public boolean isVisible() {
        if (this.marker != null) {
            return this.marker.isVisible();
        }
        return false;
    }

    public void remove() {
        if (this.marker != null) {
            this.marker.remove();
            this.marker = null;
            return;
        }
        this.map = null;
        this.markerOptions = null;
        this.listener = null;
    }

    public void setDraggable(boolean draggable) {
        if (this.marker != null) {
            this.marker.setDraggable(draggable);
        } else {
            this.markerOptions.draggable(draggable);
        }
    }

    public void setPosition(LatLng position) {
        if (this.marker != null) {
            this.marker.setPosition(position);
        } else {
            this.markerOptions.position(position);
        }
    }

    public void setSnippet(String snippet) {
        if (this.marker != null) {
            this.marker.setSnippet(snippet);
        } else {
            this.markerOptions.snippet(snippet);
        }
    }

    public void setTitle(String title) {
        if (this.marker != null) {
            this.marker.setTitle(title);
        } else {
            this.markerOptions.title(title);
        }
    }

    public void setVisible(boolean visible) {
        if (this.marker != null) {
            this.marker.setVisible(visible);
        } else if (visible) {
            this.markerOptions.visible(true);
            createMarker();
        }
    }

    public void showInfoWindow() {
        if (this.marker != null) {
            this.marker.showInfoWindow();
        }
    }

    private void createMarker() {
        if (this.marker == null) {
            createMarker(this.map, this.markerOptions, this.listener);
            this.map = null;
            this.markerOptions = null;
            this.listener = null;
        }
    }

    private void createMarker(GoogleMap map2, MarkerOptions options, OnMarkerCreateListener listener2) {
        this.marker = map2.addMarker(options);
        if (listener2 != null) {
            listener2.onMarkerCreate(this);
        }
    }

    private MarkerOptions copy(MarkerOptions options) {
        MarkerOptions copy = new MarkerOptions();
        copy.anchor(options.getAnchorU(), options.getAnchorV());
        copy.draggable(options.isDraggable());
        copy.icon(options.getIcon());
        copy.position(options.getPosition());
        copy.snippet(options.getSnippet());
        copy.title(options.getTitle());
        copy.visible(options.isVisible());
        return copy;
    }
}
