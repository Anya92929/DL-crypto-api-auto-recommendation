package p005pl.mg6.android.maps.extensions.impl;

import p005pl.mg6.android.maps.extensions.TileOverlay;

/* renamed from: pl.mg6.android.maps.extensions.impl.DelegatingTileOverlay */
class DelegatingTileOverlay implements TileOverlay {
    private Object data;
    private DelegatingGoogleMap map;
    private com.google.android.gms.maps.model.TileOverlay real;

    DelegatingTileOverlay(com.google.android.gms.maps.model.TileOverlay real2, DelegatingGoogleMap map2) {
        this.real = real2;
        this.map = map2;
    }

    public void clearTileCache() {
        this.real.clearTileCache();
    }

    public Object getData() {
        return this.data;
    }

    @Deprecated
    public String getId() {
        return this.real.getId();
    }

    public float getZIndex() {
        return this.real.getZIndex();
    }

    public boolean isVisible() {
        return this.real.isVisible();
    }

    public void remove() {
        this.real.remove();
        this.map.remove(this.real);
    }

    public void setData(Object data2) {
        this.data = data2;
    }

    public void setVisible(boolean visible) {
        this.real.setVisible(visible);
    }

    public void setZIndex(float zIndex) {
        this.real.setZIndex(zIndex);
    }

    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof DelegatingTileOverlay)) {
            return false;
        }
        return this.real.equals(((DelegatingTileOverlay) o).real);
    }

    public int hashCode() {
        return this.real.hashCode();
    }

    public String toString() {
        return this.real.toString();
    }
}
