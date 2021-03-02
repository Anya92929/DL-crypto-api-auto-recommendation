package p005pl.mg6.android.maps.extensions.impl;

import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.LatLngBounds;
import java.util.ArrayList;
import java.util.List;
import p005pl.mg6.android.maps.extensions.Marker;

/* renamed from: pl.mg6.android.maps.extensions.impl.ClusterMarker */
class ClusterMarker implements Marker {
    private long clusterId;
    private int lastCount = -1;
    private List<DelegatingMarker> markers = new ArrayList();
    private BaseClusteringStrategy strategy;
    private com.google.android.gms.maps.model.Marker virtual;

    public ClusterMarker(BaseClusteringStrategy strategy2) {
        this.strategy = strategy2;
    }

    /* access modifiers changed from: package-private */
    public long getClusterId() {
        return this.clusterId;
    }

    /* access modifiers changed from: package-private */
    public void setClusterId(long clusterId2) {
        this.clusterId = clusterId2;
    }

    /* access modifiers changed from: package-private */
    public com.google.android.gms.maps.model.Marker getVirtual() {
        return this.virtual;
    }

    /* access modifiers changed from: package-private */
    public void add(DelegatingMarker marker) {
        this.markers.add(marker);
    }

    /* access modifiers changed from: package-private */
    public void remove(DelegatingMarker marker) {
        this.markers.remove(marker);
    }

    /* access modifiers changed from: package-private */
    public void refresh() {
        int count = this.markers.size();
        if (count == 0) {
            cacheVirtual();
        } else if (count == 1) {
            cacheVirtual();
            this.markers.get(0).changeVisible(true);
        } else {
            LatLngBounds.Builder builder = LatLngBounds.builder();
            for (DelegatingMarker m : this.markers) {
                builder.include(m.getPosition());
                m.changeVisible(false);
            }
            LatLng position = calculateCenter(builder.build());
            if (this.virtual == null || this.lastCount != count) {
                cacheVirtual();
                this.lastCount = count;
                this.virtual = this.strategy.getFromCacheOrCreate(count, position);
                return;
            }
            this.virtual.setPosition(position);
        }
    }

    /* access modifiers changed from: package-private */
    public Marker getDisplayedMarker() {
        int count = this.markers.size();
        if (count == 0) {
            return null;
        }
        return count == 1 ? this.markers.get(0) : this;
    }

    /* access modifiers changed from: package-private */
    public void cacheVirtual() {
        if (this.virtual != null) {
            this.strategy.putInCache(this.virtual, this.lastCount);
            this.virtual = null;
        }
    }

    /* access modifiers changed from: package-private */
    public LatLng calculateCenter(LatLngBounds bounds) {
        if (bounds.southwest.longitude > bounds.northeast.longitude) {
            return new LatLng((bounds.southwest.latitude + bounds.northeast.latitude) / 2.0d, (bounds.southwest.longitude + bounds.northeast.longitude) / 2.0d);
        }
        return new LatLng((bounds.southwest.latitude + bounds.northeast.latitude) / 2.0d, (bounds.southwest.longitude + bounds.northeast.longitude) / 2.0d);
    }

    /* access modifiers changed from: package-private */
    public void cleanup() {
        if (this.virtual != null) {
            this.virtual.remove();
        }
    }

    /* access modifiers changed from: package-private */
    public void reset() {
        this.markers.clear();
    }

    /* access modifiers changed from: package-private */
    public List<DelegatingMarker> getMarkersInternal() {
        return new ArrayList(this.markers);
    }

    public Object getData() {
        return null;
    }

    @Deprecated
    public String getId() {
        throw new UnsupportedOperationException();
    }

    public List<Marker> getMarkers() {
        return new ArrayList(this.markers);
    }

    public LatLng getPosition() {
        if (this.virtual != null) {
            return this.virtual.getPosition();
        }
        LatLngBounds.Builder builder = LatLngBounds.builder();
        for (DelegatingMarker m : this.markers) {
            builder.include(m.getPosition());
        }
        return calculateCenter(builder.build());
    }

    public String getSnippet() {
        return null;
    }

    public String getTitle() {
        return null;
    }

    public void hideInfoWindow() {
        if (this.virtual != null) {
            this.virtual.hideInfoWindow();
        }
        throw new UnsupportedOperationException();
    }

    public boolean isCluster() {
        return true;
    }

    public boolean isDraggable() {
        return false;
    }

    public boolean isInfoWindowShown() {
        if (this.virtual != null) {
            return this.virtual.isInfoWindowShown();
        }
        return false;
    }

    public boolean isVisible() {
        if (this.virtual != null) {
            return this.virtual.isVisible();
        }
        return false;
    }

    public void remove() {
        throw new UnsupportedOperationException();
    }

    public void setData(Object data) {
        throw new UnsupportedOperationException();
    }

    public void setDraggable(boolean draggable) {
        throw new UnsupportedOperationException();
    }

    public void setPosition(LatLng position) {
        throw new UnsupportedOperationException();
    }

    public void setSnippet(String snippet) {
        throw new UnsupportedOperationException();
    }

    public void setTitle(String title) {
        throw new UnsupportedOperationException();
    }

    public void setVisible(boolean visible) {
        throw new UnsupportedOperationException();
    }

    public void showInfoWindow() {
        if (this.virtual != null) {
            this.virtual.showInfoWindow();
        }
        throw new UnsupportedOperationException();
    }
}
