package p005pl.mg6.android.maps.extensions;

/* renamed from: pl.mg6.android.maps.extensions.TileOverlay */
public interface TileOverlay {
    void clearTileCache();

    Object getData();

    @Deprecated
    String getId();

    float getZIndex();

    boolean isVisible();

    void remove();

    void setData(Object obj);

    void setVisible(boolean z);

    void setZIndex(float f);
}
