package p005pl.mg6.android.maps.extensions.impl;

import android.support.p000v4.util.LongSparseArray;
import com.google.android.gms.maps.model.CameraPosition;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.LatLngBounds;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import p005pl.mg6.android.maps.extensions.ClusteringSettings;
import p005pl.mg6.android.maps.extensions.Marker;
import p005pl.mg6.android.maps.extensions.utils.SphericalMercator;

/* renamed from: pl.mg6.android.maps.extensions.impl.GridClusteringStrategy */
class GridClusteringStrategy extends BaseClusteringStrategy {
    private static final boolean DEBUG_GRID = false;
    private boolean addMarkersDynamically;
    private double baseClusterSize;
    private double clusterSize;
    private LongSparseArray<ClusterMarker> clusters = new LongSparseArray<>();
    private DebugHelper debugHelper;
    private IGoogleMap map;
    private Map<DelegatingMarker, ClusterMarker> markers;
    private int oldZoom;
    private ClusterRefresher refresher;
    private int[] visibleClusters = new int[4];
    private int zoom;

    public GridClusteringStrategy(ClusteringSettings settings, IGoogleMap map2, List<DelegatingMarker> markers2, ClusterRefresher refresher2) {
        super(settings, map2);
        this.addMarkersDynamically = settings.isAddMarkersDynamically();
        this.baseClusterSize = settings.getClusterSize();
        this.map = map2;
        this.markers = new HashMap();
        for (DelegatingMarker m : markers2) {
            if (m.isVisible()) {
                this.markers.put(m, (Object) null);
            }
        }
        this.refresher = refresher2;
        this.oldZoom = -1;
        this.zoom = Math.round(map2.getCameraPosition().zoom);
        this.clusterSize = calculateClusterSize(this.zoom);
        recalculate();
    }

    public void cleanup() {
        for (int i = 0; i < this.clusters.size(); i++) {
            this.clusters.valueAt(i).cleanup();
        }
        this.clusters.clear();
        this.markers.clear();
        this.refresher.cleanup();
        super.cleanup();
    }

    public void onCameraChange(CameraPosition cameraPosition) {
        this.oldZoom = this.zoom;
        this.zoom = Math.round(cameraPosition.zoom);
        double clusterSize2 = calculateClusterSize(this.zoom);
        if (this.clusterSize != clusterSize2) {
            this.clusterSize = clusterSize2;
            recalculate();
        } else if (this.addMarkersDynamically) {
            addMarkersInVisibleRegion();
        }
    }

    public void onAdd(DelegatingMarker marker) {
        if (marker.isVisible()) {
            addMarker(marker);
        }
    }

    private void addMarker(DelegatingMarker marker) {
        LatLng position = marker.getPosition();
        ClusterMarker cluster = findClusterById(calculateClusterId(position));
        cluster.add(marker);
        this.markers.put(marker, cluster);
        if (!this.addMarkersDynamically || isPositionInVisibleClusters(position)) {
            refresh(cluster);
        }
    }

    private boolean isPositionInVisibleClusters(LatLng position) {
        int y = convLat(position.latitude);
        int x = convLng(position.longitude);
        int[] b = this.visibleClusters;
        if (b[0] <= y && y <= b[2]) {
            if (b[1] <= x && x <= b[3]) {
                return true;
            }
            if (b[1] > b[3] && (b[1] <= x || x <= b[3])) {
                return true;
            }
        }
        return false;
    }

    public void onRemove(DelegatingMarker marker) {
        if (marker.isVisible()) {
            removeMarker(marker);
        }
    }

    private void removeMarker(DelegatingMarker marker) {
        ClusterMarker cluster = this.markers.remove(marker);
        if (cluster != null) {
            cluster.remove(marker);
            refresh(cluster);
        }
    }

    public void onPositionChange(DelegatingMarker marker) {
        if (marker.isVisible()) {
            ClusterMarker oldCluster = this.markers.get(marker);
            if (oldCluster == null || !isMarkerInCluster(marker, oldCluster)) {
                if (oldCluster != null) {
                    oldCluster.remove(marker);
                    refresh(oldCluster);
                }
                addMarker(marker);
                return;
            }
            refresh(oldCluster);
        }
    }

    public Marker map(com.google.android.gms.maps.model.Marker original) {
        for (int i = 0; i < this.clusters.size(); i++) {
            ClusterMarker cluster = this.clusters.valueAt(i);
            if (original.equals(cluster.getVirtual())) {
                return cluster;
            }
        }
        return null;
    }

    public List<Marker> getDisplayedMarkers() {
        List<Marker> displayedMarkers = new ArrayList<>();
        for (int i = 0; i < this.clusters.size(); i++) {
            Marker displayedMarker = this.clusters.valueAt(i).getDisplayedMarker();
            if (displayedMarker != null) {
                displayedMarkers.add(displayedMarker);
            }
        }
        return displayedMarkers;
    }

    public float getMinZoomLevelNotClustered(Marker marker) {
        if (!this.markers.containsKey(marker)) {
            throw new UnsupportedOperationException("marker is not visible or is a cluster");
        }
        int zoom2 = 0;
        while (zoom2 <= 25 && hasCollision(marker, zoom2)) {
            zoom2++;
        }
        if (zoom2 > 25) {
            return Float.POSITIVE_INFINITY;
        }
        return (float) zoom2;
    }

    private boolean hasCollision(Marker marker, int zoom2) {
        double clusterSize2 = calculateClusterSize(zoom2);
        LatLng position = marker.getPosition();
        int x = (int) (SphericalMercator.scaleLongitude(position.longitude) / clusterSize2);
        int y = (int) (SphericalMercator.scaleLatitude(position.latitude) / clusterSize2);
        for (DelegatingMarker m : this.markers.keySet()) {
            if (!m.equals(marker)) {
                LatLng mPosition = m.getPosition();
                if (x == ((int) (SphericalMercator.scaleLongitude(mPosition.longitude) / clusterSize2)) && y == ((int) (SphericalMercator.scaleLatitude(mPosition.latitude) / clusterSize2))) {
                    return true;
                }
            }
        }
        return false;
    }

    private boolean isMarkerInCluster(DelegatingMarker marker, ClusterMarker cluster) {
        return cluster.getClusterId() == calculateClusterId(marker.getPosition());
    }

    private ClusterMarker findClusterById(long clusterId) {
        ClusterMarker cluster = this.clusters.get(clusterId);
        if (cluster != null) {
            return cluster;
        }
        ClusterMarker cluster2 = new ClusterMarker(this);
        cluster2.setClusterId(clusterId);
        this.clusters.put(clusterId, cluster2);
        return cluster2;
    }

    public void onVisibilityChangeRequest(DelegatingMarker marker, boolean visible) {
        if (visible) {
            addMarker(marker);
            return;
        }
        removeMarker(marker);
        marker.changeVisible(false);
    }

    private void refresh(ClusterMarker cluster) {
        this.refresher.refresh(cluster);
    }

    private void recalculate() {
        if (this.addMarkersDynamically) {
            calculateVisibleClusters();
        }
        if (this.oldZoom == -1) {
            for (DelegatingMarker marker : this.markers.keySet()) {
                addMarker(marker);
            }
        } else {
            LongSparseArray<ClusterMarker> newClusters = new LongSparseArray<>();
            for (int i = 0; i < this.clusters.size(); i++) {
                ClusterMarker cluster = this.clusters.valueAt(i);
                List<DelegatingMarker> ms = cluster.getMarkersInternal();
                if (ms.size() == 0) {
                    this.refresher.refreshAll();
                    return;
                }
                DelegatingMarker first = ms.get(0);
                LatLng firstPosition = first.getPosition();
                long firstClusterId = calculateClusterId(firstPosition);
                if (newClusters.get(firstClusterId) != null) {
                    cluster.cacheVirtual();
                    cluster = newClusters.get(firstClusterId);
                } else {
                    cluster.reset();
                    cluster.setClusterId(firstClusterId);
                }
                cluster.add(first);
                this.markers.put(first, cluster);
                if (!this.addMarkersDynamically || isPositionInVisibleClusters(firstPosition)) {
                    refresh(cluster);
                } else {
                    cluster.cacheVirtual();
                }
                newClusters.put(firstClusterId, cluster);
                for (int j = 1; j < ms.size(); j++) {
                    DelegatingMarker m = ms.get(j);
                    LatLng position = m.getPosition();
                    long clusterId = calculateClusterId(position);
                    if (clusterId == firstClusterId) {
                        cluster.add(m);
                        this.markers.put(m, cluster);
                    } else {
                        ClusterMarker newCluster = newClusters.get(clusterId);
                        if (newCluster == null) {
                            newCluster = new ClusterMarker(this);
                            newCluster.setClusterId(clusterId);
                            newClusters.put(clusterId, newCluster);
                            if (!this.addMarkersDynamically || isPositionInVisibleClusters(position)) {
                                refresh(newCluster);
                            }
                        }
                        newCluster.add(m);
                        this.markers.put(m, newCluster);
                    }
                }
            }
            this.clusters = newClusters;
        }
        this.refresher.refreshAll();
    }

    private void addMarkersInVisibleRegion() {
        calculateVisibleClusters();
        for (DelegatingMarker marker : this.markers.keySet()) {
            if (isPositionInVisibleClusters(marker.getPosition())) {
                refresh(this.markers.get(marker));
            }
        }
        this.refresher.refreshAll();
    }

    private void calculateVisibleClusters() {
        LatLngBounds bounds = this.map.getProjection().getVisibleRegion().latLngBounds;
        this.visibleClusters[0] = convLat(bounds.southwest.latitude);
        this.visibleClusters[1] = convLng(bounds.southwest.longitude);
        this.visibleClusters[2] = convLat(bounds.northeast.latitude);
        this.visibleClusters[3] = convLng(bounds.northeast.longitude);
    }

    private long calculateClusterId(LatLng position) {
        long y = (long) convLat(position.latitude);
        return (y << 32) + ((long) convLng(position.longitude));
    }

    private int convLat(double lat) {
        return (int) (SphericalMercator.scaleLatitude(lat) / this.clusterSize);
    }

    private int convLng(double lng) {
        return (int) (SphericalMercator.scaleLongitude(lng) / this.clusterSize);
    }

    private double calculateClusterSize(int zoom2) {
        return this.baseClusterSize / ((double) (1 << zoom2));
    }
}
