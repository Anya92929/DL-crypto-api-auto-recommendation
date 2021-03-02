package com.google.maps.android.clustering.algo;

import android.support.p001v4.util.LruCache;
import com.google.maps.android.clustering.Cluster;
import com.google.maps.android.clustering.ClusterItem;
import java.util.Collection;
import java.util.Set;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class PreCachingAlgorithmDecorator<T extends ClusterItem> implements Algorithm<T> {

    /* renamed from: a */
    private final Algorithm<T> f3882a;

    /* renamed from: b */
    private final LruCache<Integer, Set<? extends Cluster<T>>> f3883b = new LruCache<>(5);

    /* renamed from: c */
    private final ReadWriteLock f3884c = new ReentrantReadWriteLock();

    public PreCachingAlgorithmDecorator(Algorithm<T> algorithm) {
        this.f3882a = algorithm;
    }

    public void addItem(T t) {
        this.f3882a.addItem(t);
        m4480a();
    }

    public void addItems(Collection<T> collection) {
        this.f3882a.addItems(collection);
        m4480a();
    }

    public void clearItems() {
        this.f3882a.clearItems();
        m4480a();
    }

    public void removeItem(T t) {
        this.f3882a.removeItem(t);
        m4480a();
    }

    /* renamed from: a */
    private void m4480a() {
        this.f3883b.evictAll();
    }

    public Set<? extends Cluster<T>> getClusters(double d) {
        int i = (int) d;
        Set<? extends Cluster<T>> a = m4478a(i);
        if (this.f3883b.get(Integer.valueOf(i + 1)) == null) {
            new Thread(new C1001a(i + 1)).start();
        }
        if (this.f3883b.get(Integer.valueOf(i - 1)) == null) {
            new Thread(new C1001a(i - 1)).start();
        }
        return a;
    }

    public Collection<T> getItems() {
        return this.f3882a.getItems();
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public Set<? extends Cluster<T>> m4478a(int i) {
        this.f3884c.readLock().lock();
        Set<? extends Cluster<T>> set = this.f3883b.get(Integer.valueOf(i));
        this.f3884c.readLock().unlock();
        if (set == null) {
            this.f3884c.writeLock().lock();
            set = this.f3883b.get(Integer.valueOf(i));
            if (set == null) {
                set = this.f3882a.getClusters((double) i);
                this.f3883b.put(Integer.valueOf(i), set);
            }
            this.f3884c.writeLock().unlock();
        }
        return set;
    }

    /* renamed from: com.google.maps.android.clustering.algo.PreCachingAlgorithmDecorator$a */
    class C1001a implements Runnable {

        /* renamed from: b */
        private final int f3886b;

        public C1001a(int i) {
            this.f3886b = i;
        }

        public void run() {
            try {
                Thread.sleep((long) ((Math.random() * 500.0d) + 500.0d));
            } catch (InterruptedException e) {
            }
            Set unused = PreCachingAlgorithmDecorator.this.m4478a(this.f3886b);
        }
    }
}
