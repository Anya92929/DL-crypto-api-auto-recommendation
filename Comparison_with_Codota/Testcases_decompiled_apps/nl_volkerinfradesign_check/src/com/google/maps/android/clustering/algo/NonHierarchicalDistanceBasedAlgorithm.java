package com.google.maps.android.clustering.algo;

import com.google.android.gms.maps.model.LatLng;
import com.google.maps.android.clustering.Cluster;
import com.google.maps.android.clustering.ClusterItem;
import com.google.maps.android.geometry.Bounds;
import com.google.maps.android.geometry.Point;
import com.google.maps.android.projection.SphericalMercatorProjection;
import com.google.maps.android.quadtree.PointQuadTree;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

public class NonHierarchicalDistanceBasedAlgorithm<T extends ClusterItem> implements Algorithm<T> {
    public static final int MAX_DISTANCE_AT_ZOOM = 100;
    /* access modifiers changed from: private */

    /* renamed from: c */
    public static final SphericalMercatorProjection f3875c = new SphericalMercatorProjection(1.0d);

    /* renamed from: a */
    private final Collection<C1000a<T>> f3876a = new ArrayList();

    /* renamed from: b */
    private final PointQuadTree<C1000a<T>> f3877b = new PointQuadTree<>(0.0d, 1.0d, 0.0d, 1.0d);

    public void addItem(T t) {
        C1000a aVar = new C1000a(t);
        synchronized (this.f3877b) {
            this.f3876a.add(aVar);
            this.f3877b.add(aVar);
        }
    }

    public void addItems(Collection<T> collection) {
        for (T addItem : collection) {
            addItem(addItem);
        }
    }

    public void clearItems() {
        synchronized (this.f3877b) {
            this.f3876a.clear();
            this.f3877b.clear();
        }
    }

    public void removeItem(T t) {
        C1000a aVar = new C1000a(t);
        synchronized (this.f3877b) {
            this.f3876a.remove(aVar);
            this.f3877b.remove(aVar);
        }
    }

    public Set<? extends Cluster<T>> getClusters(double d) {
        double pow = (100.0d / Math.pow(2.0d, (double) ((int) d))) / 256.0d;
        HashSet hashSet = new HashSet();
        HashSet hashSet2 = new HashSet();
        HashMap hashMap = new HashMap();
        HashMap hashMap2 = new HashMap();
        synchronized (this.f3877b) {
            for (C1000a next : this.f3876a) {
                if (!hashSet.contains(next)) {
                    Collection<C1000a<T>> search = this.f3877b.search(m4474a(next.getPoint(), pow));
                    if (search.size() == 1) {
                        hashSet2.add(next);
                        hashSet.add(next);
                        hashMap.put(next, Double.valueOf(0.0d));
                    } else {
                        StaticCluster staticCluster = new StaticCluster(next.f3878a.getPosition());
                        hashSet2.add(staticCluster);
                        for (C1000a next2 : search) {
                            Double d2 = (Double) hashMap.get(next2);
                            double a = m4473a(next2.getPoint(), next.getPoint());
                            if (d2 != null) {
                                if (d2.doubleValue() >= a) {
                                    ((StaticCluster) hashMap2.get(next2)).remove(next2.f3878a);
                                }
                            }
                            hashMap.put(next2, Double.valueOf(a));
                            staticCluster.add(next2.f3878a);
                            hashMap2.put(next2, staticCluster);
                        }
                        hashSet.addAll(search);
                    }
                }
            }
        }
        return hashSet2;
    }

    public Collection<T> getItems() {
        ArrayList arrayList = new ArrayList();
        synchronized (this.f3877b) {
            for (C1000a<T> a : this.f3876a) {
                arrayList.add(a.f3878a);
            }
        }
        return arrayList;
    }

    /* renamed from: a */
    private double m4473a(Point point, Point point2) {
        return ((point.f3969x - point2.f3969x) * (point.f3969x - point2.f3969x)) + ((point.f3970y - point2.f3970y) * (point.f3970y - point2.f3970y));
    }

    /* renamed from: a */
    private Bounds m4474a(Point point, double d) {
        double d2 = d / 2.0d;
        return new Bounds(point.f3969x - d2, point.f3969x + d2, point.f3970y - d2, d2 + point.f3970y);
    }

    /* renamed from: com.google.maps.android.clustering.algo.NonHierarchicalDistanceBasedAlgorithm$a */
    static class C1000a<T extends ClusterItem> implements Cluster<T>, PointQuadTree.Item {
        /* access modifiers changed from: private */

        /* renamed from: a */
        public final T f3878a;

        /* renamed from: b */
        private final Point f3879b;

        /* renamed from: c */
        private final LatLng f3880c;

        /* renamed from: d */
        private Set<T> f3881d;

        private C1000a(T t) {
            this.f3878a = t;
            this.f3880c = t.getPosition();
            this.f3879b = NonHierarchicalDistanceBasedAlgorithm.f3875c.toPoint(this.f3880c);
            this.f3881d = Collections.singleton(this.f3878a);
        }

        public Point getPoint() {
            return this.f3879b;
        }

        public LatLng getPosition() {
            return this.f3880c;
        }

        /* renamed from: a */
        public Set<T> getItems() {
            return this.f3881d;
        }

        public int getSize() {
            return 1;
        }

        public int hashCode() {
            return this.f3878a.hashCode();
        }

        public boolean equals(Object obj) {
            if (!(obj instanceof C1000a)) {
                return false;
            }
            return ((C1000a) obj).f3878a.equals(this.f3878a);
        }
    }
}
