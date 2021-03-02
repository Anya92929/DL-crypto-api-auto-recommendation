package com.google.maps.android.clustering.algo;

import android.support.p001v4.util.LongSparseArray;
import com.google.maps.android.clustering.Cluster;
import com.google.maps.android.clustering.ClusterItem;
import com.google.maps.android.projection.Point;
import com.google.maps.android.projection.SphericalMercatorProjection;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

public class GridBasedAlgorithm<T extends ClusterItem> implements Algorithm<T> {

    /* renamed from: a */
    private final Set<T> f3874a = Collections.synchronizedSet(new HashSet());

    public void addItem(T t) {
        this.f3874a.add(t);
    }

    public void addItems(Collection<T> collection) {
        this.f3874a.addAll(collection);
    }

    public void clearItems() {
        this.f3874a.clear();
    }

    public void removeItem(T t) {
        this.f3874a.remove(t);
    }

    public Set<? extends Cluster<T>> getClusters(double d) {
        long ceil = (long) Math.ceil((256.0d * Math.pow(2.0d, d)) / 100.0d);
        SphericalMercatorProjection sphericalMercatorProjection = new SphericalMercatorProjection((double) ceil);
        HashSet hashSet = new HashSet();
        LongSparseArray longSparseArray = new LongSparseArray();
        synchronized (this.f3874a) {
            for (T t : this.f3874a) {
                Point point = sphericalMercatorProjection.toPoint(t.getPosition());
                long a = m4472a(ceil, point.f3969x, point.f3970y);
                StaticCluster staticCluster = (StaticCluster) longSparseArray.get(a);
                if (staticCluster == null) {
                    staticCluster = new StaticCluster(sphericalMercatorProjection.toLatLng(new com.google.maps.android.geometry.Point(Math.floor(point.f3969x) + 0.5d, Math.floor(point.f3970y) + 0.5d)));
                    longSparseArray.put(a, staticCluster);
                    hashSet.add(staticCluster);
                }
                staticCluster.add(t);
            }
        }
        return hashSet;
    }

    public Collection<T> getItems() {
        return this.f3874a;
    }

    /* renamed from: a */
    private static long m4472a(long j, double d, double d2) {
        return (long) ((((double) j) * Math.floor(d)) + Math.floor(d2));
    }
}
