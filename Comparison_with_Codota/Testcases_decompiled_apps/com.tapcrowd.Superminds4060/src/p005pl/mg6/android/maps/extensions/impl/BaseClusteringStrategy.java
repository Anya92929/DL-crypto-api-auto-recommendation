package p005pl.mg6.android.maps.extensions.impl;

import android.support.p000v4.util.SparseArrayCompat;
import com.google.android.gms.maps.model.BitmapDescriptor;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;
import java.util.ArrayList;
import java.util.List;
import p005pl.mg6.android.maps.extensions.ClusteringSettings;

/* renamed from: pl.mg6.android.maps.extensions.impl.BaseClusteringStrategy */
abstract class BaseClusteringStrategy implements ClusteringStrategy {
    private SparseArrayCompat<IconData> iconDataCache = new SparseArrayCompat<>();
    private ClusteringSettings.IconDataProvider iconDataProvider;
    private IGoogleMap map;
    private final MarkerOptions markerOptions = new MarkerOptions();
    private SparseArrayCompat<List<Marker>> markersCache = new SparseArrayCompat<>();

    public BaseClusteringStrategy(ClusteringSettings settings, IGoogleMap map2) {
        this.iconDataProvider = settings.getIconDataProvider();
        this.map = map2;
    }

    public void cleanup() {
        clearCache();
    }

    /* access modifiers changed from: package-private */
    public Marker getFromCacheOrCreate(int markersCount, LatLng position) {
        List<Marker> cacheEntry = this.markersCache.get(markersCount);
        if (cacheEntry == null || cacheEntry.size() <= 0) {
            IconData iconData = getIconData(markersCount);
            return this.map.addMarker(this.markerOptions.position(position).icon(iconData.icon).anchor(iconData.horizAnchor, iconData.vertAnchor));
        }
        Marker marker = cacheEntry.remove(cacheEntry.size() - 1);
        marker.setPosition(position);
        marker.setVisible(true);
        return marker;
    }

    private IconData getIconData(int markersCount) {
        IconData iconData = this.iconDataCache.get(markersCount);
        if (iconData != null) {
            return iconData;
        }
        IconData iconData2 = new IconData(this.iconDataProvider.getIconData(markersCount), (IconData) null);
        this.iconDataCache.put(markersCount, iconData2);
        return iconData2;
    }

    /* access modifiers changed from: package-private */
    public void putInCache(Marker marker, int markersCount) {
        marker.setVisible(false);
        List<Marker> cacheEntry = this.markersCache.get(markersCount);
        if (cacheEntry == null) {
            cacheEntry = new ArrayList<>();
            this.markersCache.put(markersCount, cacheEntry);
        }
        cacheEntry.add(marker);
    }

    private void clearCache() {
        for (int i = 0; i < this.markersCache.size(); i++) {
            for (Marker marker : this.markersCache.valueAt(i)) {
                marker.remove();
            }
        }
        this.markersCache.clear();
    }

    /* renamed from: pl.mg6.android.maps.extensions.impl.BaseClusteringStrategy$IconData */
    private static class IconData {
        /* access modifiers changed from: private */
        public float horizAnchor;
        /* access modifiers changed from: private */
        public BitmapDescriptor icon;
        /* access modifiers changed from: private */
        public float vertAnchor;

        private IconData(MarkerOptions markerOptions) {
            this.icon = markerOptions.getIcon();
            this.horizAnchor = markerOptions.getAnchorU();
            this.vertAnchor = markerOptions.getAnchorV();
        }

        /* synthetic */ IconData(MarkerOptions markerOptions, IconData iconData) {
            this(markerOptions);
        }
    }
}
