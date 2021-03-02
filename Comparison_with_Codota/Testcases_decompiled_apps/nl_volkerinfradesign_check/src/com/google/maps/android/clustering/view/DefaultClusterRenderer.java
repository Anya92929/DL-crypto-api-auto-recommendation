package com.google.maps.android.clustering.view;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.TimeInterpolator;
import android.animation.ValueAnimator;
import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.LayerDrawable;
import android.graphics.drawable.ShapeDrawable;
import android.graphics.drawable.shapes.OvalShape;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.MessageQueue;
import android.util.SparseArray;
import android.view.ViewGroup;
import android.view.animation.DecelerateInterpolator;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.Projection;
import com.google.android.gms.maps.model.BitmapDescriptor;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.LatLngBounds;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.maps.android.C0994R;
import com.google.maps.android.MarkerManager;
import com.google.maps.android.clustering.Cluster;
import com.google.maps.android.clustering.ClusterItem;
import com.google.maps.android.clustering.ClusterManager;
import com.google.maps.android.geometry.Point;
import com.google.maps.android.p005ui.IconGenerator;
import com.google.maps.android.p005ui.SquareTextView;
import com.google.maps.android.projection.SphericalMercatorProjection;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import p006nl.volkerinfradesign.checkandroid.database.LogTable;
import p010uk.p011co.senab.photoview.IPhotoView;

public class DefaultClusterRenderer<T extends ClusterItem> implements ClusterRenderer<T> {
    /* access modifiers changed from: private */

    /* renamed from: a */
    public static final boolean f3889a = (Build.VERSION.SDK_INT >= 11);

    /* renamed from: f */
    private static final int[] f3890f = {10, 20, 50, 100, IPhotoView.DEFAULT_ZOOM_DURATION, 500, LogTable.MAX_SIZE};
    /* access modifiers changed from: private */

    /* renamed from: t */
    public static final TimeInterpolator f3891t = new DecelerateInterpolator();
    /* access modifiers changed from: private */

    /* renamed from: b */
    public final GoogleMap f3892b;

    /* renamed from: c */
    private final IconGenerator f3893c;
    /* access modifiers changed from: private */

    /* renamed from: d */
    public final ClusterManager<T> f3894d;

    /* renamed from: e */
    private final float f3895e;

    /* renamed from: g */
    private ShapeDrawable f3896g;
    /* access modifiers changed from: private */

    /* renamed from: h */
    public Set<C1010e> f3897h = Collections.newSetFromMap(new ConcurrentHashMap());

    /* renamed from: i */
    private SparseArray<BitmapDescriptor> f3898i = new SparseArray<>();
    /* access modifiers changed from: private */

    /* renamed from: j */
    public C1008c<T> f3899j = new C1008c<>();
    /* access modifiers changed from: private */

    /* renamed from: k */
    public Set<? extends Cluster<T>> f3900k;
    /* access modifiers changed from: private */

    /* renamed from: l */
    public Map<Marker, Cluster<T>> f3901l = new HashMap();
    /* access modifiers changed from: private */

    /* renamed from: m */
    public Map<Cluster<T>, Marker> f3902m = new HashMap();
    /* access modifiers changed from: private */

    /* renamed from: n */
    public float f3903n;

    /* renamed from: o */
    private final DefaultClusterRenderer<T>.C1144g f3904o = new C1012g();
    /* access modifiers changed from: private */

    /* renamed from: p */
    public ClusterManager.OnClusterClickListener<T> f3905p;
    /* access modifiers changed from: private */

    /* renamed from: q */
    public ClusterManager.OnClusterInfoWindowClickListener<T> f3906q;
    /* access modifiers changed from: private */

    /* renamed from: r */
    public ClusterManager.OnClusterItemClickListener<T> f3907r;
    /* access modifiers changed from: private */

    /* renamed from: s */
    public ClusterManager.OnClusterItemInfoWindowClickListener<T> f3908s;

    public DefaultClusterRenderer(Context context, GoogleMap googleMap, ClusterManager<T> clusterManager) {
        this.f3892b = googleMap;
        this.f3895e = context.getResources().getDisplayMetrics().density;
        this.f3893c = new IconGenerator(context);
        this.f3893c.setContentView(m4485a(context));
        this.f3893c.setTextAppearance(C0994R.style.ClusterIcon_TextAppearance);
        this.f3893c.setBackground(m4492c());
        this.f3894d = clusterManager;
    }

    public void onAdd() {
        this.f3894d.getMarkerCollection().setOnMarkerClickListener(new GoogleMap.OnMarkerClickListener() {
            public boolean onMarkerClick(Marker marker) {
                return DefaultClusterRenderer.this.f3907r != null && DefaultClusterRenderer.this.f3907r.onClusterItemClick((ClusterItem) DefaultClusterRenderer.this.f3899j.mo7803a(marker));
            }
        });
        this.f3894d.getMarkerCollection().setOnInfoWindowClickListener(new GoogleMap.OnInfoWindowClickListener() {
            public void onInfoWindowClick(Marker marker) {
                if (DefaultClusterRenderer.this.f3908s != null) {
                    DefaultClusterRenderer.this.f3908s.onClusterItemInfoWindowClick((ClusterItem) DefaultClusterRenderer.this.f3899j.mo7803a(marker));
                }
            }
        });
        this.f3894d.getClusterMarkerCollection().setOnMarkerClickListener(new GoogleMap.OnMarkerClickListener() {
            public boolean onMarkerClick(Marker marker) {
                return DefaultClusterRenderer.this.f3905p != null && DefaultClusterRenderer.this.f3905p.onClusterClick((Cluster) DefaultClusterRenderer.this.f3901l.get(marker));
            }
        });
        this.f3894d.getClusterMarkerCollection().setOnInfoWindowClickListener(new GoogleMap.OnInfoWindowClickListener() {
            public void onInfoWindowClick(Marker marker) {
                if (DefaultClusterRenderer.this.f3906q != null) {
                    DefaultClusterRenderer.this.f3906q.onClusterInfoWindowClick((Cluster) DefaultClusterRenderer.this.f3901l.get(marker));
                }
            }
        });
    }

    public void onRemove() {
        this.f3894d.getMarkerCollection().setOnMarkerClickListener((GoogleMap.OnMarkerClickListener) null);
        this.f3894d.getClusterMarkerCollection().setOnMarkerClickListener((GoogleMap.OnMarkerClickListener) null);
    }

    /* renamed from: c */
    private LayerDrawable m4492c() {
        this.f3896g = new ShapeDrawable(new OvalShape());
        ShapeDrawable shapeDrawable = new ShapeDrawable(new OvalShape());
        shapeDrawable.getPaint().setColor(-2130706433);
        LayerDrawable layerDrawable = new LayerDrawable(new Drawable[]{shapeDrawable, this.f3896g});
        int i = (int) (this.f3895e * 3.0f);
        layerDrawable.setLayerInset(1, i, i, i, i);
        return layerDrawable;
    }

    /* renamed from: a */
    private SquareTextView m4485a(Context context) {
        SquareTextView squareTextView = new SquareTextView(context);
        squareTextView.setLayoutParams(new ViewGroup.LayoutParams(-2, -2));
        squareTextView.setId(C0994R.C0996id.text);
        int i = (int) (12.0f * this.f3895e);
        squareTextView.setPadding(i, i, i, i);
        return squareTextView;
    }

    /* access modifiers changed from: protected */
    public int getColor(int i) {
        float min = Math.min((float) i, 300.0f);
        return Color.HSVToColor(new float[]{(((300.0f - min) * (300.0f - min)) / 90000.0f) * 220.0f, 1.0f, 0.6f});
    }

    /* access modifiers changed from: protected */
    public String getClusterText(int i) {
        if (i < f3890f[0]) {
            return String.valueOf(i);
        }
        return String.valueOf(String.valueOf(i)).concat("+");
    }

    /* access modifiers changed from: protected */
    public int getBucket(Cluster<T> cluster) {
        int size = cluster.getSize();
        if (size <= f3890f[0]) {
            return size;
        }
        for (int i = 0; i < f3890f.length - 1; i++) {
            if (size < f3890f[i + 1]) {
                return f3890f[i];
            }
        }
        return f3890f[f3890f.length - 1];
    }

    @SuppressLint({"HandlerLeak"})
    /* renamed from: com.google.maps.android.clustering.view.DefaultClusterRenderer$g */
    class C1012g extends Handler {

        /* renamed from: b */
        private boolean f3944b;

        /* renamed from: c */
        private DefaultClusterRenderer<T>.C1106f f3945c;

        private C1012g() {
            this.f3944b = false;
            this.f3945c = null;
        }

        public void handleMessage(Message message) {
            Projection projection;
            DefaultClusterRenderer<T>.C1106f fVar;
            if (message.what == 1) {
                this.f3944b = false;
                if (this.f3945c != null) {
                    sendEmptyMessage(0);
                    return;
                }
                return;
            }
            removeMessages(0);
            if (!this.f3944b && this.f3945c != null && (projection = DefaultClusterRenderer.this.f3892b.getProjection()) != null) {
                synchronized (this) {
                    fVar = this.f3945c;
                    this.f3945c = null;
                    this.f3944b = true;
                }
                fVar.mo7818a((Runnable) new Runnable() {
                    public void run() {
                        C1012g.this.sendEmptyMessage(1);
                    }
                });
                fVar.mo7817a(projection);
                fVar.mo7816a(DefaultClusterRenderer.this.f3892b.getCameraPosition().zoom);
                new Thread(fVar).start();
            }
        }

        /* renamed from: a */
        public void mo7820a(Set<? extends Cluster<T>> set) {
            synchronized (this) {
                this.f3945c = new C1011f(set);
            }
            sendEmptyMessage(0);
        }
    }

    /* access modifiers changed from: protected */
    public boolean shouldRenderAsCluster(Cluster<T> cluster) {
        return cluster.getSize() > 4;
    }

    /* renamed from: com.google.maps.android.clustering.view.DefaultClusterRenderer$f */
    class C1011f implements Runnable {

        /* renamed from: a */
        final Set<? extends Cluster<T>> f3937a;

        /* renamed from: c */
        private Runnable f3939c;

        /* renamed from: d */
        private Projection f3940d;

        /* renamed from: e */
        private SphericalMercatorProjection f3941e;

        /* renamed from: f */
        private float f3942f;

        private C1011f(Set<? extends Cluster<T>> set) {
            this.f3937a = set;
        }

        /* renamed from: a */
        public void mo7818a(Runnable runnable) {
            this.f3939c = runnable;
        }

        /* renamed from: a */
        public void mo7817a(Projection projection) {
            this.f3940d = projection;
        }

        /* renamed from: a */
        public void mo7816a(float f) {
            this.f3942f = f;
            this.f3941e = new SphericalMercatorProjection(256.0d * Math.pow(2.0d, (double) Math.min(f, DefaultClusterRenderer.this.f3903n)));
        }

        @SuppressLint({"NewApi"})
        public void run() {
            boolean z;
            ArrayList arrayList;
            ArrayList arrayList2 = null;
            if (this.f3937a.equals(DefaultClusterRenderer.this.f3900k)) {
                this.f3939c.run();
                return;
            }
            C1009d dVar = new C1009d();
            float f = this.f3942f;
            if (f > DefaultClusterRenderer.this.f3903n) {
                z = true;
            } else {
                z = false;
            }
            float h = f - DefaultClusterRenderer.this.f3903n;
            Set<C1010e> j = DefaultClusterRenderer.this.f3897h;
            LatLngBounds latLngBounds = this.f3940d.getVisibleRegion().latLngBounds;
            if (DefaultClusterRenderer.this.f3900k == null || !DefaultClusterRenderer.f3889a) {
                arrayList = null;
            } else {
                arrayList = new ArrayList();
                for (Cluster cluster : DefaultClusterRenderer.this.f3900k) {
                    if (DefaultClusterRenderer.this.shouldRenderAsCluster(cluster) && latLngBounds.contains(cluster.getPosition())) {
                        arrayList.add(this.f3941e.toPoint(cluster.getPosition()));
                    }
                }
            }
            Set newSetFromMap = Collections.newSetFromMap(new ConcurrentHashMap());
            for (Cluster cluster2 : this.f3937a) {
                boolean contains = latLngBounds.contains(cluster2.getPosition());
                if (!z || !contains || !DefaultClusterRenderer.f3889a) {
                    dVar.mo7808a(contains, (DefaultClusterRenderer<T>.C0608b) new C1007b(cluster2, newSetFromMap, (LatLng) null));
                } else {
                    Point a = DefaultClusterRenderer.m4490b((List<Point>) arrayList, (Point) this.f3941e.toPoint(cluster2.getPosition()));
                    if (a != null) {
                        dVar.mo7808a(true, (DefaultClusterRenderer<T>.C0608b) new C1007b(cluster2, newSetFromMap, this.f3941e.toLatLng(a)));
                    } else {
                        dVar.mo7808a(true, (DefaultClusterRenderer<T>.C0608b) new C1007b(cluster2, newSetFromMap, (LatLng) null));
                    }
                }
            }
            dVar.mo7810b();
            j.removeAll(newSetFromMap);
            if (DefaultClusterRenderer.f3889a) {
                arrayList2 = new ArrayList();
                for (Cluster cluster3 : this.f3937a) {
                    if (DefaultClusterRenderer.this.shouldRenderAsCluster(cluster3) && latLngBounds.contains(cluster3.getPosition())) {
                        arrayList2.add(this.f3941e.toPoint(cluster3.getPosition()));
                    }
                }
            }
            for (C1010e eVar : j) {
                boolean contains2 = latLngBounds.contains(eVar.f3936b);
                if (z || h <= -3.0f || !contains2 || !DefaultClusterRenderer.f3889a) {
                    dVar.mo7807a(contains2, eVar.f3935a);
                } else {
                    Point a2 = DefaultClusterRenderer.m4490b((List<Point>) arrayList2, (Point) this.f3941e.toPoint(eVar.f3936b));
                    if (a2 != null) {
                        dVar.mo7811b(eVar, eVar.f3936b, this.f3941e.toLatLng(a2));
                    } else {
                        dVar.mo7807a(true, eVar.f3935a);
                    }
                }
            }
            dVar.mo7810b();
            Set unused = DefaultClusterRenderer.this.f3897h = newSetFromMap;
            Set unused2 = DefaultClusterRenderer.this.f3900k = this.f3937a;
            float unused3 = DefaultClusterRenderer.this.f3903n = f;
            this.f3939c.run();
        }
    }

    public void onClustersChanged(Set<? extends Cluster<T>> set) {
        this.f3904o.mo7820a(set);
    }

    public void setOnClusterClickListener(ClusterManager.OnClusterClickListener<T> onClusterClickListener) {
        this.f3905p = onClusterClickListener;
    }

    public void setOnClusterInfoWindowClickListener(ClusterManager.OnClusterInfoWindowClickListener<T> onClusterInfoWindowClickListener) {
        this.f3906q = onClusterInfoWindowClickListener;
    }

    public void setOnClusterItemClickListener(ClusterManager.OnClusterItemClickListener<T> onClusterItemClickListener) {
        this.f3907r = onClusterItemClickListener;
    }

    public void setOnClusterItemInfoWindowClickListener(ClusterManager.OnClusterItemInfoWindowClickListener<T> onClusterItemInfoWindowClickListener) {
        this.f3908s = onClusterItemInfoWindowClickListener;
    }

    /* renamed from: a */
    private static double m4481a(Point point, Point point2) {
        return ((point.f3969x - point2.f3969x) * (point.f3969x - point2.f3969x)) + ((point.f3970y - point2.f3970y) * (point.f3970y - point2.f3970y));
    }

    /* access modifiers changed from: private */
    /* renamed from: b */
    public static Point m4490b(List<Point> list, Point point) {
        Point point2 = null;
        if (list != null && !list.isEmpty()) {
            double d = 10000.0d;
            for (Point next : list) {
                double a = m4481a(next, point);
                if (a >= d) {
                    next = point2;
                    a = d;
                }
                point2 = next;
                d = a;
            }
        }
        return point2;
    }

    @SuppressLint({"HandlerLeak"})
    /* renamed from: com.google.maps.android.clustering.view.DefaultClusterRenderer$d */
    class C1009d extends Handler implements MessageQueue.IdleHandler {

        /* renamed from: b */
        private final Lock f3927b;

        /* renamed from: c */
        private final Condition f3928c;

        /* renamed from: d */
        private Queue<DefaultClusterRenderer<T>.C0608b> f3929d;

        /* renamed from: e */
        private Queue<DefaultClusterRenderer<T>.C0608b> f3930e;

        /* renamed from: f */
        private Queue<Marker> f3931f;

        /* renamed from: g */
        private Queue<Marker> f3932g;

        /* renamed from: h */
        private Queue<DefaultClusterRenderer<T>.C0000a> f3933h;

        /* renamed from: i */
        private boolean f3934i;

        private C1009d() {
            super(Looper.getMainLooper());
            this.f3927b = new ReentrantLock();
            this.f3928c = this.f3927b.newCondition();
            this.f3929d = new LinkedList();
            this.f3930e = new LinkedList();
            this.f3931f = new LinkedList();
            this.f3932g = new LinkedList();
            this.f3933h = new LinkedList();
        }

        /* renamed from: a */
        public void mo7808a(boolean z, DefaultClusterRenderer<T>.C0608b bVar) {
            this.f3927b.lock();
            sendEmptyMessage(0);
            if (z) {
                this.f3930e.add(bVar);
            } else {
                this.f3929d.add(bVar);
            }
            this.f3927b.unlock();
        }

        /* renamed from: a */
        public void mo7807a(boolean z, Marker marker) {
            this.f3927b.lock();
            sendEmptyMessage(0);
            if (z) {
                this.f3932g.add(marker);
            } else {
                this.f3931f.add(marker);
            }
            this.f3927b.unlock();
        }

        /* renamed from: a */
        public void mo7806a(C1010e eVar, LatLng latLng, LatLng latLng2) {
            this.f3927b.lock();
            this.f3933h.add(new C1006a(eVar, latLng, latLng2));
            this.f3927b.unlock();
        }

        /* renamed from: b */
        public void mo7811b(C1010e eVar, LatLng latLng, LatLng latLng2) {
            this.f3927b.lock();
            C1006a aVar = new C1006a(eVar, latLng, latLng2);
            aVar.mo7799a(DefaultClusterRenderer.this.f3894d.getMarkerManager());
            this.f3933h.add(aVar);
            this.f3927b.unlock();
        }

        public void handleMessage(Message message) {
            int i = 0;
            if (!this.f3934i) {
                Looper.myQueue().addIdleHandler(this);
                this.f3934i = true;
            }
            removeMessages(0);
            this.f3927b.lock();
            while (i < 10) {
                try {
                    m4512c();
                    i++;
                } catch (Throwable th) {
                    this.f3927b.unlock();
                    throw th;
                }
            }
            if (!mo7809a()) {
                this.f3934i = false;
                Looper.myQueue().removeIdleHandler(this);
                this.f3928c.signalAll();
            } else {
                sendEmptyMessageDelayed(0, 10);
            }
            this.f3927b.unlock();
        }

        /* renamed from: c */
        private void m4512c() {
            if (!this.f3932g.isEmpty()) {
                m4511a(this.f3932g.poll());
            } else if (!this.f3933h.isEmpty()) {
                this.f3933h.poll().mo7798a();
            } else if (!this.f3930e.isEmpty()) {
                this.f3930e.poll().m4506a(this);
            } else if (!this.f3929d.isEmpty()) {
                this.f3929d.poll().m4506a(this);
            } else if (!this.f3931f.isEmpty()) {
                m4511a(this.f3931f.poll());
            }
        }

        /* renamed from: a */
        private void m4511a(Marker marker) {
            DefaultClusterRenderer.this.f3902m.remove((Cluster) DefaultClusterRenderer.this.f3901l.get(marker));
            DefaultClusterRenderer.this.f3899j.mo7805b(marker);
            DefaultClusterRenderer.this.f3901l.remove(marker);
            DefaultClusterRenderer.this.f3894d.getMarkerManager().remove(marker);
        }

        /* renamed from: a */
        public boolean mo7809a() {
            try {
                this.f3927b.lock();
                return !this.f3929d.isEmpty() || !this.f3930e.isEmpty() || !this.f3932g.isEmpty() || !this.f3931f.isEmpty() || !this.f3933h.isEmpty();
            } finally {
                this.f3927b.unlock();
            }
        }

        /* renamed from: b */
        public void mo7810b() {
            while (mo7809a()) {
                sendEmptyMessage(0);
                this.f3927b.lock();
                try {
                    if (mo7809a()) {
                        this.f3928c.await();
                    }
                    this.f3927b.unlock();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                } catch (Throwable th) {
                    this.f3927b.unlock();
                    throw th;
                }
            }
        }

        public boolean queueIdle() {
            sendEmptyMessage(0);
            return true;
        }
    }

    /* renamed from: com.google.maps.android.clustering.view.DefaultClusterRenderer$c */
    static class C1008c<T> {

        /* renamed from: a */
        private Map<T, Marker> f3924a;

        /* renamed from: b */
        private Map<Marker, T> f3925b;

        private C1008c() {
            this.f3924a = new HashMap();
            this.f3925b = new HashMap();
        }

        /* renamed from: a */
        public Marker mo7802a(T t) {
            return this.f3924a.get(t);
        }

        /* renamed from: a */
        public T mo7803a(Marker marker) {
            return this.f3925b.get(marker);
        }

        /* renamed from: a */
        public void mo7804a(T t, Marker marker) {
            this.f3924a.put(t, marker);
            this.f3925b.put(marker, t);
        }

        /* renamed from: b */
        public void mo7805b(Marker marker) {
            T t = this.f3925b.get(marker);
            this.f3925b.remove(marker);
            this.f3924a.remove(t);
        }
    }

    /* access modifiers changed from: protected */
    public void onBeforeClusterItemRendered(T t, MarkerOptions markerOptions) {
    }

    /* access modifiers changed from: protected */
    public void onBeforeClusterRendered(Cluster<T> cluster, MarkerOptions markerOptions) {
        int bucket = getBucket(cluster);
        BitmapDescriptor bitmapDescriptor = this.f3898i.get(bucket);
        if (bitmapDescriptor == null) {
            this.f3896g.getPaint().setColor(getColor(bucket));
            bitmapDescriptor = BitmapDescriptorFactory.fromBitmap(this.f3893c.makeIcon(getClusterText(bucket)));
            this.f3898i.put(bucket, bitmapDescriptor);
        }
        markerOptions.icon(bitmapDescriptor);
    }

    /* access modifiers changed from: protected */
    public void onClusterRendered(Cluster<T> cluster, Marker marker) {
    }

    /* access modifiers changed from: protected */
    public void onClusterItemRendered(T t, Marker marker) {
    }

    public Marker getMarker(T t) {
        return this.f3899j.mo7802a(t);
    }

    public T getClusterItem(Marker marker) {
        return (ClusterItem) this.f3899j.mo7803a(marker);
    }

    public Marker getMarker(Cluster<T> cluster) {
        return this.f3902m.get(cluster);
    }

    public Cluster<T> getCluster(Marker marker) {
        return this.f3901l.get(marker);
    }

    /* renamed from: com.google.maps.android.clustering.view.DefaultClusterRenderer$b */
    class C1007b {

        /* renamed from: b */
        private final Cluster<T> f3921b;

        /* renamed from: c */
        private final Set<C1010e> f3922c;

        /* renamed from: d */
        private final LatLng f3923d;

        public C1007b(Cluster<T> cluster, Set<C1010e> set, LatLng latLng) {
            this.f3921b = cluster;
            this.f3922c = set;
            this.f3923d = latLng;
        }

        /* access modifiers changed from: private */
        /* renamed from: a */
        public void m4506a(DefaultClusterRenderer<T>.C1035d dVar) {
            C1010e eVar;
            if (!DefaultClusterRenderer.this.shouldRenderAsCluster(this.f3921b)) {
                for (T t : this.f3921b.getItems()) {
                    Marker a = DefaultClusterRenderer.this.f3899j.mo7802a(t);
                    if (a == null) {
                        MarkerOptions markerOptions = new MarkerOptions();
                        if (this.f3923d != null) {
                            markerOptions.position(this.f3923d);
                        } else {
                            markerOptions.position(t.getPosition());
                        }
                        DefaultClusterRenderer.this.onBeforeClusterItemRendered(t, markerOptions);
                        a = DefaultClusterRenderer.this.f3894d.getMarkerCollection().addMarker(markerOptions);
                        eVar = new C1010e(a);
                        DefaultClusterRenderer.this.f3899j.mo7804a(t, a);
                        if (this.f3923d != null) {
                            dVar.mo7806a(eVar, this.f3923d, t.getPosition());
                        }
                    } else {
                        eVar = new C1010e(a);
                    }
                    DefaultClusterRenderer.this.onClusterItemRendered(t, a);
                    this.f3922c.add(eVar);
                }
                return;
            }
            MarkerOptions position = new MarkerOptions().position(this.f3923d == null ? this.f3921b.getPosition() : this.f3923d);
            DefaultClusterRenderer.this.onBeforeClusterRendered(this.f3921b, position);
            Marker addMarker = DefaultClusterRenderer.this.f3894d.getClusterMarkerCollection().addMarker(position);
            DefaultClusterRenderer.this.f3901l.put(addMarker, this.f3921b);
            DefaultClusterRenderer.this.f3902m.put(this.f3921b, addMarker);
            C1010e eVar2 = new C1010e(addMarker);
            if (this.f3923d != null) {
                dVar.mo7806a(eVar2, this.f3923d, this.f3921b.getPosition());
            }
            DefaultClusterRenderer.this.onClusterRendered(this.f3921b, addMarker);
            this.f3922c.add(eVar2);
        }
    }

    /* renamed from: com.google.maps.android.clustering.view.DefaultClusterRenderer$e */
    static class C1010e {
        /* access modifiers changed from: private */

        /* renamed from: a */
        public final Marker f3935a;
        /* access modifiers changed from: private */

        /* renamed from: b */
        public LatLng f3936b;

        private C1010e(Marker marker) {
            this.f3935a = marker;
            this.f3936b = marker.getPosition();
        }

        public boolean equals(Object obj) {
            if (obj instanceof C1010e) {
                return this.f3935a.equals(((C1010e) obj).f3935a);
            }
            return false;
        }

        public int hashCode() {
            return this.f3935a.hashCode();
        }
    }

    @TargetApi(12)
    /* renamed from: com.google.maps.android.clustering.view.DefaultClusterRenderer$a */
    class C1006a extends AnimatorListenerAdapter implements ValueAnimator.AnimatorUpdateListener {

        /* renamed from: b */
        private final C1010e f3914b;

        /* renamed from: c */
        private final Marker f3915c;

        /* renamed from: d */
        private final LatLng f3916d;

        /* renamed from: e */
        private final LatLng f3917e;

        /* renamed from: f */
        private boolean f3918f;

        /* renamed from: g */
        private MarkerManager f3919g;

        private C1006a(C1010e eVar, LatLng latLng, LatLng latLng2) {
            this.f3914b = eVar;
            this.f3915c = eVar.f3935a;
            this.f3916d = latLng;
            this.f3917e = latLng2;
        }

        /* renamed from: a */
        public void mo7798a() {
            ValueAnimator ofFloat = ValueAnimator.ofFloat(new float[]{BitmapDescriptorFactory.HUE_RED, 1.0f});
            ofFloat.setInterpolator(DefaultClusterRenderer.f3891t);
            ofFloat.addUpdateListener(this);
            ofFloat.addListener(this);
            ofFloat.start();
        }

        public void onAnimationEnd(Animator animator) {
            if (this.f3918f) {
                DefaultClusterRenderer.this.f3902m.remove((Cluster) DefaultClusterRenderer.this.f3901l.get(this.f3915c));
                DefaultClusterRenderer.this.f3899j.mo7805b(this.f3915c);
                DefaultClusterRenderer.this.f3901l.remove(this.f3915c);
                this.f3919g.remove(this.f3915c);
            }
            LatLng unused = this.f3914b.f3936b = this.f3917e;
        }

        /* renamed from: a */
        public void mo7799a(MarkerManager markerManager) {
            this.f3919g = markerManager;
            this.f3918f = true;
        }

        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            float animatedFraction = valueAnimator.getAnimatedFraction();
            double d = this.f3916d.latitude + ((this.f3917e.latitude - this.f3916d.latitude) * ((double) animatedFraction));
            double d2 = this.f3917e.longitude - this.f3916d.longitude;
            if (Math.abs(d2) > 180.0d) {
                d2 -= Math.signum(d2) * 360.0d;
            }
            this.f3915c.setPosition(new LatLng(d, (d2 * ((double) animatedFraction)) + this.f3916d.longitude));
        }
    }
}
