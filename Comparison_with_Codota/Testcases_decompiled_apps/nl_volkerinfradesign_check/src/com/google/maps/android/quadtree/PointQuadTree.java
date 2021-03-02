package com.google.maps.android.quadtree;

import com.google.maps.android.geometry.Bounds;
import com.google.maps.android.geometry.Point;
import com.google.maps.android.quadtree.PointQuadTree.Item;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class PointQuadTree<T extends Item> {

    /* renamed from: a */
    private final Bounds f4015a;

    /* renamed from: b */
    private final int f4016b;

    /* renamed from: c */
    private List<T> f4017c;

    /* renamed from: d */
    private List<PointQuadTree<T>> f4018d;

    public interface Item {
        Point getPoint();
    }

    public PointQuadTree(double d, double d2, double d3, double d4) {
        this(new Bounds(d, d2, d3, d4));
    }

    public PointQuadTree(Bounds bounds) {
        this(bounds, 0);
    }

    private PointQuadTree(double d, double d2, double d3, double d4, int i) {
        this(new Bounds(d, d2, d3, d4), i);
    }

    private PointQuadTree(Bounds bounds, int i) {
        this.f4018d = null;
        this.f4015a = bounds;
        this.f4016b = i;
    }

    public void add(T t) {
        Point point = t.getPoint();
        if (this.f4015a.contains(point.f3969x, point.f3970y)) {
            m4558a(point.f3969x, point.f3970y, t);
        }
    }

    /* renamed from: a */
    private void m4558a(double d, double d2, T t) {
        if (this.f4018d == null) {
            if (this.f4017c == null) {
                this.f4017c = new ArrayList();
            }
            this.f4017c.add(t);
            if (this.f4017c.size() > 50 && this.f4016b < 40) {
                m4557a();
            }
        } else if (d2 < this.f4015a.midY) {
            if (d < this.f4015a.midX) {
                this.f4018d.get(0).m4558a(d, d2, t);
            } else {
                this.f4018d.get(1).m4558a(d, d2, t);
            }
        } else if (d < this.f4015a.midX) {
            this.f4018d.get(2).m4558a(d, d2, t);
        } else {
            this.f4018d.get(3).m4558a(d, d2, t);
        }
    }

    /* renamed from: a */
    private void m4557a() {
        this.f4018d = new ArrayList(4);
        this.f4018d.add(new PointQuadTree(this.f4015a.minX, this.f4015a.midX, this.f4015a.minY, this.f4015a.midY, this.f4016b + 1));
        this.f4018d.add(new PointQuadTree(this.f4015a.midX, this.f4015a.maxX, this.f4015a.minY, this.f4015a.midY, this.f4016b + 1));
        this.f4018d.add(new PointQuadTree(this.f4015a.minX, this.f4015a.midX, this.f4015a.midY, this.f4015a.maxY, this.f4016b + 1));
        this.f4018d.add(new PointQuadTree(this.f4015a.midX, this.f4015a.maxX, this.f4015a.midY, this.f4015a.maxY, this.f4016b + 1));
        List<T> list = this.f4017c;
        this.f4017c = null;
        for (T t : list) {
            m4558a(t.getPoint().f3969x, t.getPoint().f3970y, t);
        }
    }

    public boolean remove(T t) {
        Point point = t.getPoint();
        if (!this.f4015a.contains(point.f3969x, point.f3970y)) {
            return false;
        }
        return m4560b(point.f3969x, point.f3970y, t);
    }

    /* renamed from: b */
    private boolean m4560b(double d, double d2, T t) {
        if (this.f4018d == null) {
            return this.f4017c.remove(t);
        }
        if (d2 < this.f4015a.midY) {
            if (d < this.f4015a.midX) {
                return this.f4018d.get(0).m4560b(d, d2, t);
            }
            return this.f4018d.get(1).m4560b(d, d2, t);
        } else if (d < this.f4015a.midX) {
            return this.f4018d.get(2).m4560b(d, d2, t);
        } else {
            return this.f4018d.get(3).m4560b(d, d2, t);
        }
    }

    public void clear() {
        this.f4018d = null;
        if (this.f4017c != null) {
            this.f4017c.clear();
        }
    }

    public Collection<T> search(Bounds bounds) {
        ArrayList arrayList = new ArrayList();
        m4559a(bounds, arrayList);
        return arrayList;
    }

    /* renamed from: a */
    private void m4559a(Bounds bounds, Collection<T> collection) {
        if (this.f4015a.intersects(bounds)) {
            if (this.f4018d != null) {
                for (PointQuadTree<T> a : this.f4018d) {
                    a.m4559a(bounds, collection);
                }
            } else if (this.f4017c == null) {
            } else {
                if (bounds.contains(this.f4015a)) {
                    collection.addAll(this.f4017c);
                    return;
                }
                for (T t : this.f4017c) {
                    if (bounds.contains(t.getPoint())) {
                        collection.add(t);
                    }
                }
            }
        }
    }
}
