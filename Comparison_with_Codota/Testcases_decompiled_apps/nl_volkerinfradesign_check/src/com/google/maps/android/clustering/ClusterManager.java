package com.google.maps.android.clustering;

import android.content.Context;
import android.os.AsyncTask;
import android.os.Build;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.model.CameraPosition;
import com.google.android.gms.maps.model.Marker;
import com.google.maps.android.MarkerManager;
import com.google.maps.android.clustering.ClusterItem;
import com.google.maps.android.clustering.algo.Algorithm;
import com.google.maps.android.clustering.algo.NonHierarchicalDistanceBasedAlgorithm;
import com.google.maps.android.clustering.algo.PreCachingAlgorithmDecorator;
import com.google.maps.android.clustering.view.ClusterRenderer;
import com.google.maps.android.clustering.view.DefaultClusterRenderer;
import java.util.Collection;
import java.util.Set;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class ClusterManager<T extends ClusterItem> implements GoogleMap.OnCameraChangeListener, GoogleMap.OnInfoWindowClickListener, GoogleMap.OnMarkerClickListener {

    /* renamed from: a */
    private final MarkerManager f3859a;

    /* renamed from: b */
    private final MarkerManager.Collection f3860b;

    /* renamed from: c */
    private final MarkerManager.Collection f3861c;
    /* access modifiers changed from: private */

    /* renamed from: d */
    public Algorithm<T> f3862d;
    /* access modifiers changed from: private */

    /* renamed from: e */
    public final ReadWriteLock f3863e;
    /* access modifiers changed from: private */

    /* renamed from: f */
    public ClusterRenderer<T> f3864f;

    /* renamed from: g */
    private GoogleMap f3865g;

    /* renamed from: h */
    private CameraPosition f3866h;

    /* renamed from: i */
    private ClusterManager<T>.C0000a f3867i;

    /* renamed from: j */
    private final ReadWriteLock f3868j;

    /* renamed from: k */
    private OnClusterItemClickListener<T> f3869k;

    /* renamed from: l */
    private OnClusterInfoWindowClickListener<T> f3870l;

    /* renamed from: m */
    private OnClusterItemInfoWindowClickListener<T> f3871m;

    /* renamed from: n */
    private OnClusterClickListener<T> f3872n;

    public interface OnClusterClickListener<T extends ClusterItem> {
        boolean onClusterClick(Cluster<T> cluster);
    }

    public interface OnClusterInfoWindowClickListener<T extends ClusterItem> {
        void onClusterInfoWindowClick(Cluster<T> cluster);
    }

    public interface OnClusterItemClickListener<T extends ClusterItem> {
        boolean onClusterItemClick(T t);
    }

    public interface OnClusterItemInfoWindowClickListener<T extends ClusterItem> {
        void onClusterItemInfoWindowClick(T t);
    }

    public ClusterManager(Context context, GoogleMap googleMap) {
        this(context, googleMap, new MarkerManager(googleMap));
    }

    public ClusterManager(Context context, GoogleMap googleMap, MarkerManager markerManager) {
        this.f3863e = new ReentrantReadWriteLock();
        this.f3868j = new ReentrantReadWriteLock();
        this.f3865g = googleMap;
        this.f3859a = markerManager;
        this.f3861c = markerManager.newCollection();
        this.f3860b = markerManager.newCollection();
        this.f3864f = new DefaultClusterRenderer(context, googleMap, this);
        this.f3862d = new PreCachingAlgorithmDecorator(new NonHierarchicalDistanceBasedAlgorithm());
        this.f3867i = new C0998a();
        this.f3864f.onAdd();
    }

    public MarkerManager.Collection getMarkerCollection() {
        return this.f3860b;
    }

    public MarkerManager.Collection getClusterMarkerCollection() {
        return this.f3861c;
    }

    public MarkerManager getMarkerManager() {
        return this.f3859a;
    }

    public void setRenderer(ClusterRenderer<T> clusterRenderer) {
        this.f3864f.setOnClusterClickListener((OnClusterClickListener) null);
        this.f3864f.setOnClusterItemClickListener((OnClusterItemClickListener) null);
        this.f3861c.clear();
        this.f3860b.clear();
        this.f3864f.onRemove();
        this.f3864f = clusterRenderer;
        this.f3864f.onAdd();
        this.f3864f.setOnClusterClickListener(this.f3872n);
        this.f3864f.setOnClusterInfoWindowClickListener(this.f3870l);
        this.f3864f.setOnClusterItemClickListener(this.f3869k);
        this.f3864f.setOnClusterItemInfoWindowClickListener(this.f3871m);
        cluster();
    }

    /* JADX INFO: finally extract failed */
    public void setAlgorithm(Algorithm<T> algorithm) {
        this.f3863e.writeLock().lock();
        try {
            if (this.f3862d != null) {
                algorithm.addItems(this.f3862d.getItems());
            }
            this.f3862d = new PreCachingAlgorithmDecorator(algorithm);
            this.f3863e.writeLock().unlock();
            cluster();
        } catch (Throwable th) {
            this.f3863e.writeLock().unlock();
            throw th;
        }
    }

    public void clearItems() {
        this.f3863e.writeLock().lock();
        try {
            this.f3862d.clearItems();
        } finally {
            this.f3863e.writeLock().unlock();
        }
    }

    public void addItems(Collection<T> collection) {
        this.f3863e.writeLock().lock();
        try {
            this.f3862d.addItems(collection);
        } finally {
            this.f3863e.writeLock().unlock();
        }
    }

    public void addItem(T t) {
        this.f3863e.writeLock().lock();
        try {
            this.f3862d.addItem(t);
        } finally {
            this.f3863e.writeLock().unlock();
        }
    }

    public void removeItem(T t) {
        this.f3863e.writeLock().lock();
        try {
            this.f3862d.removeItem(t);
        } finally {
            this.f3863e.writeLock().unlock();
        }
    }

    public void cluster() {
        this.f3868j.writeLock().lock();
        try {
            this.f3867i.cancel(true);
            this.f3867i = new C0998a();
            if (Build.VERSION.SDK_INT < 11) {
                this.f3867i.execute(new Float[]{Float.valueOf(this.f3865g.getCameraPosition().zoom)});
            } else {
                this.f3867i.executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new Float[]{Float.valueOf(this.f3865g.getCameraPosition().zoom)});
            }
        } finally {
            this.f3868j.writeLock().unlock();
        }
    }

    public void onCameraChange(CameraPosition cameraPosition) {
        if (this.f3864f instanceof GoogleMap.OnCameraChangeListener) {
            ((GoogleMap.OnCameraChangeListener) this.f3864f).onCameraChange(cameraPosition);
        }
        CameraPosition cameraPosition2 = this.f3865g.getCameraPosition();
        if (this.f3866h == null || this.f3866h.zoom != cameraPosition2.zoom) {
            this.f3866h = this.f3865g.getCameraPosition();
            cluster();
        }
    }

    public boolean onMarkerClick(Marker marker) {
        return getMarkerManager().onMarkerClick(marker);
    }

    public void onInfoWindowClick(Marker marker) {
        getMarkerManager().onInfoWindowClick(marker);
    }

    /* renamed from: com.google.maps.android.clustering.ClusterManager$a */
    class C0998a extends AsyncTask<Float, Void, Set<? extends Cluster<T>>> {
        private C0998a() {
        }

        /* access modifiers changed from: protected */
        /* renamed from: a */
        public Set<? extends Cluster<T>> doInBackground(Float... fArr) {
            ClusterManager.this.f3863e.readLock().lock();
            try {
                return ClusterManager.this.f3862d.getClusters((double) fArr[0].floatValue());
            } finally {
                ClusterManager.this.f3863e.readLock().unlock();
            }
        }

        /* access modifiers changed from: protected */
        /* renamed from: a */
        public void onPostExecute(Set<? extends Cluster<T>> set) {
            ClusterManager.this.f3864f.onClustersChanged(set);
        }
    }

    public void setOnClusterClickListener(OnClusterClickListener<T> onClusterClickListener) {
        this.f3872n = onClusterClickListener;
        this.f3864f.setOnClusterClickListener(onClusterClickListener);
    }

    public void setOnClusterInfoWindowClickListener(OnClusterInfoWindowClickListener<T> onClusterInfoWindowClickListener) {
        this.f3870l = onClusterInfoWindowClickListener;
        this.f3864f.setOnClusterInfoWindowClickListener(onClusterInfoWindowClickListener);
    }

    public void setOnClusterItemClickListener(OnClusterItemClickListener<T> onClusterItemClickListener) {
        this.f3869k = onClusterItemClickListener;
        this.f3864f.setOnClusterItemClickListener(onClusterItemClickListener);
    }

    public void setOnClusterItemInfoWindowClickListener(OnClusterItemInfoWindowClickListener<T> onClusterItemInfoWindowClickListener) {
        this.f3871m = onClusterItemInfoWindowClickListener;
        this.f3864f.setOnClusterItemInfoWindowClickListener(onClusterItemInfoWindowClickListener);
    }
}
