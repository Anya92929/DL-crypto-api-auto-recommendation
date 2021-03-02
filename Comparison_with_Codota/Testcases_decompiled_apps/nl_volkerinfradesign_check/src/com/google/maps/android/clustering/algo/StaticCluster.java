package com.google.maps.android.clustering.algo;

import com.google.android.gms.maps.model.LatLng;
import com.google.maps.android.clustering.Cluster;
import com.google.maps.android.clustering.ClusterItem;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class StaticCluster<T extends ClusterItem> implements Cluster<T> {

    /* renamed from: a */
    private final LatLng f3887a;

    /* renamed from: b */
    private final List<T> f3888b = new ArrayList();

    public StaticCluster(LatLng latLng) {
        this.f3887a = latLng;
    }

    public boolean add(T t) {
        return this.f3888b.add(t);
    }

    public LatLng getPosition() {
        return this.f3887a;
    }

    public boolean remove(T t) {
        return this.f3888b.remove(t);
    }

    public Collection<T> getItems() {
        return this.f3888b;
    }

    public int getSize() {
        return this.f3888b.size();
    }

    public String toString() {
        String valueOf = String.valueOf("StaticCluster{mCenter=");
        String valueOf2 = String.valueOf(this.f3887a);
        return new StringBuilder(String.valueOf(valueOf).length() + 26 + String.valueOf(valueOf2).length()).append(valueOf).append(valueOf2).append(", mItems.size=").append(this.f3888b.size()).append("}").toString();
    }

    public int hashCode() {
        return this.f3887a.hashCode() + this.f3888b.hashCode();
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof StaticCluster)) {
            return false;
        }
        return ((StaticCluster) obj).f3887a.equals(this.f3887a) && ((StaticCluster) obj).f3888b.equals(this.f3888b);
    }
}
