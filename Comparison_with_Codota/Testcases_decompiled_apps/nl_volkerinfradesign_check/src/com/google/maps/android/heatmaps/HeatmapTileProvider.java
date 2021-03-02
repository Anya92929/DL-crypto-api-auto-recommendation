package com.google.maps.android.heatmaps;

import android.graphics.Bitmap;
import android.graphics.Color;
import android.support.p001v4.util.LongSparseArray;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Tile;
import com.google.android.gms.maps.model.TileProvider;
import com.google.maps.android.geometry.Bounds;
import com.google.maps.android.geometry.Point;
import com.google.maps.android.quadtree.PointQuadTree;
import java.io.ByteArrayOutputStream;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

public class HeatmapTileProvider implements TileProvider {
    public static final Gradient DEFAULT_GRADIENT = new Gradient(f3975a, f3976b);
    public static final double DEFAULT_OPACITY = 0.7d;
    public static final int DEFAULT_RADIUS = 20;

    /* renamed from: a */
    private static final int[] f3975a = {Color.rgb(102, 225, 0), Color.rgb(255, 0, 0)};

    /* renamed from: b */
    private static final float[] f3976b = {0.2f, 1.0f};

    /* renamed from: c */
    private PointQuadTree<WeightedLatLng> f3977c;

    /* renamed from: d */
    private Collection<WeightedLatLng> f3978d;

    /* renamed from: e */
    private Bounds f3979e;

    /* renamed from: f */
    private int f3980f;

    /* renamed from: g */
    private Gradient f3981g;

    /* renamed from: h */
    private int[] f3982h;

    /* renamed from: i */
    private double[] f3983i;

    /* renamed from: j */
    private double f3984j;

    /* renamed from: k */
    private double[] f3985k;

    public static class Builder {
        /* access modifiers changed from: private */

        /* renamed from: a */
        public Collection<WeightedLatLng> f3986a;
        /* access modifiers changed from: private */

        /* renamed from: b */
        public int f3987b = 20;
        /* access modifiers changed from: private */

        /* renamed from: c */
        public Gradient f3988c = HeatmapTileProvider.DEFAULT_GRADIENT;
        /* access modifiers changed from: private */

        /* renamed from: d */
        public double f3989d = 0.7d;

        public Builder data(Collection<LatLng> collection) {
            return weightedData(HeatmapTileProvider.m4545c(collection));
        }

        public Builder weightedData(Collection<WeightedLatLng> collection) {
            this.f3986a = collection;
            if (!this.f3986a.isEmpty()) {
                return this;
            }
            throw new IllegalArgumentException("No input points.");
        }

        public Builder radius(int i) {
            this.f3987b = i;
            if (this.f3987b >= 10 && this.f3987b <= 50) {
                return this;
            }
            throw new IllegalArgumentException("Radius not within bounds.");
        }

        public Builder gradient(Gradient gradient) {
            this.f3988c = gradient;
            return this;
        }

        public Builder opacity(double d) {
            this.f3989d = d;
            if (this.f3989d >= 0.0d && this.f3989d <= 1.0d) {
                return this;
            }
            throw new IllegalArgumentException("Opacity must be in range [0, 1]");
        }

        public HeatmapTileProvider build() {
            if (this.f3986a != null) {
                return new HeatmapTileProvider(this);
            }
            throw new IllegalStateException("No input data: you must use either .data or .weightedData before building");
        }
    }

    private HeatmapTileProvider(Builder builder) {
        this.f3978d = builder.f3986a;
        this.f3980f = builder.f3987b;
        this.f3981g = builder.f3988c;
        this.f3984j = builder.f3989d;
        this.f3983i = m4542a(this.f3980f, ((double) this.f3980f) / 3.0d);
        setGradient(this.f3981g);
        setWeightedData(this.f3978d);
    }

    public void setWeightedData(Collection<WeightedLatLng> collection) {
        this.f3978d = collection;
        if (this.f3978d.isEmpty()) {
            throw new IllegalArgumentException("No input points.");
        }
        this.f3979e = m4540a(this.f3978d);
        this.f3977c = new PointQuadTree<>(this.f3979e);
        for (WeightedLatLng add : this.f3978d) {
            this.f3977c.add(add);
        }
        this.f3985k = m4541a(this.f3980f);
    }

    public void setData(Collection<LatLng> collection) {
        setWeightedData(m4545c(collection));
    }

    /* access modifiers changed from: private */
    /* renamed from: c */
    public static Collection<WeightedLatLng> m4545c(Collection<LatLng> collection) {
        ArrayList arrayList = new ArrayList();
        for (LatLng weightedLatLng : collection) {
            arrayList.add(new WeightedLatLng(weightedLatLng));
        }
        return arrayList;
    }

    public Tile getTile(int i, int i2, int i3) {
        Collection<WeightedLatLng> collection;
        double d;
        double pow = 1.0d / Math.pow(2.0d, (double) i3);
        double d2 = (((double) this.f3980f) * pow) / 512.0d;
        double d3 = ((2.0d * d2) + pow) / ((double) ((this.f3980f * 2) + 512));
        double d4 = (((double) i) * pow) - d2;
        double d5 = (((double) (i + 1)) * pow) + d2;
        double d6 = (((double) i2) * pow) - d2;
        double d7 = (pow * ((double) (i2 + 1))) + d2;
        Collection<WeightedLatLng> arrayList = new ArrayList<>();
        if (d4 < 0.0d) {
            collection = this.f3977c.search(new Bounds(1.0d + d4, 1.0d, d6, d7));
            d = -1.0d;
        } else if (d5 > 1.0d) {
            collection = this.f3977c.search(new Bounds(0.0d, d5 - 1.0d, d6, d7));
            d = 1.0d;
        } else {
            collection = arrayList;
            d = 0.0d;
        }
        Bounds bounds = new Bounds(d4, d5, d6, d7);
        if (!bounds.intersects(new Bounds(this.f3979e.minX - d2, this.f3979e.maxX + d2, this.f3979e.minY - d2, d2 + this.f3979e.maxY))) {
            return TileProvider.NO_TILE;
        }
        Collection<WeightedLatLng> search = this.f3977c.search(bounds);
        if (search.isEmpty()) {
            return TileProvider.NO_TILE;
        }
        double[][] dArr = (double[][]) Array.newInstance(Double.TYPE, new int[]{(this.f3980f * 2) + 512, (this.f3980f * 2) + 512});
        for (WeightedLatLng next : search) {
            Point point = next.getPoint();
            int i4 = (int) ((point.f3970y - d6) / d3);
            double[] dArr2 = dArr[(int) ((point.f3969x - d4) / d3)];
            dArr2[i4] = dArr2[i4] + next.getIntensity();
        }
        for (WeightedLatLng next2 : collection) {
            Point point2 = next2.getPoint();
            int i5 = (int) ((point2.f3970y - d6) / d3);
            double[] dArr3 = dArr[(int) (((point2.f3969x + d) - d4) / d3)];
            dArr3[i5] = dArr3[i5] + next2.getIntensity();
        }
        return m4539a(m4538a(m4543a(dArr, this.f3983i), this.f3982h, this.f3985k[i3]));
    }

    public void setGradient(Gradient gradient) {
        this.f3981g = gradient;
        this.f3982h = gradient.mo7928a(this.f3984j);
    }

    public void setRadius(int i) {
        this.f3980f = i;
        this.f3983i = m4542a(this.f3980f, ((double) this.f3980f) / 3.0d);
        this.f3985k = m4541a(this.f3980f);
    }

    public void setOpacity(double d) {
        this.f3984j = d;
        setGradient(this.f3981g);
    }

    /* renamed from: a */
    private double[] m4541a(int i) {
        double[] dArr = new double[22];
        for (int i2 = 5; i2 < 11; i2++) {
            dArr[i2] = m4537a(this.f3978d, this.f3979e, i, (int) (1280.0d * Math.pow(2.0d, (double) (i2 - 3))));
            if (i2 == 5) {
                for (int i3 = 0; i3 < i2; i3++) {
                    dArr[i3] = dArr[i2];
                }
            }
        }
        for (int i4 = 11; i4 < 22; i4++) {
            dArr[i4] = dArr[10];
        }
        return dArr;
    }

    /* renamed from: a */
    private static Tile m4539a(Bitmap bitmap) {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        bitmap.compress(Bitmap.CompressFormat.PNG, 100, byteArrayOutputStream);
        return new Tile(512, 512, byteArrayOutputStream.toByteArray());
    }

    /* renamed from: a */
    static Bounds m4540a(Collection<WeightedLatLng> collection) {
        Iterator<WeightedLatLng> it = collection.iterator();
        WeightedLatLng next = it.next();
        double d = next.getPoint().f3969x;
        double d2 = next.getPoint().f3969x;
        double d3 = next.getPoint().f3970y;
        double d4 = next.getPoint().f3970y;
        while (it.hasNext()) {
            WeightedLatLng next2 = it.next();
            double d5 = next2.getPoint().f3969x;
            double d6 = next2.getPoint().f3970y;
            if (d5 < d) {
                d = d5;
            }
            if (d5 > d2) {
                d2 = d5;
            }
            if (d6 < d3) {
                d3 = d6;
            }
            if (d6 > d4) {
                d4 = d6;
            }
        }
        return new Bounds(d, d2, d3, d4);
    }

    /* renamed from: a */
    static double[] m4542a(int i, double d) {
        double[] dArr = new double[((i * 2) + 1)];
        for (int i2 = -i; i2 <= i; i2++) {
            dArr[i2 + i] = Math.exp(((double) ((-i2) * i2)) / ((2.0d * d) * d));
        }
        return dArr;
    }

    /* renamed from: a */
    static double[][] m4543a(double[][] dArr, double[] dArr2) {
        int floor = (int) Math.floor(((double) dArr2.length) / 2.0d);
        int length = dArr.length;
        int i = length - (floor * 2);
        int i2 = (floor + i) - 1;
        double[][] dArr3 = (double[][]) Array.newInstance(Double.TYPE, new int[]{length, length});
        for (int i3 = 0; i3 < length; i3++) {
            for (int i4 = 0; i4 < length; i4++) {
                double d = dArr[i3][i4];
                if (d != 0.0d) {
                    int i5 = (i2 < i3 + floor ? i2 : i3 + floor) + 1;
                    for (int i6 = floor > i3 - floor ? floor : i3 - floor; i6 < i5; i6++) {
                        double[] dArr4 = dArr3[i6];
                        dArr4[i4] = dArr4[i4] + (dArr2[i6 - (i3 - floor)] * d);
                    }
                }
            }
        }
        double[][] dArr5 = (double[][]) Array.newInstance(Double.TYPE, new int[]{i, i});
        for (int i7 = floor; i7 < i2 + 1; i7++) {
            for (int i8 = 0; i8 < length; i8++) {
                double d2 = dArr3[i7][i8];
                if (d2 != 0.0d) {
                    int i9 = (i2 < i8 + floor ? i2 : i8 + floor) + 1;
                    for (int i10 = floor > i8 - floor ? floor : i8 - floor; i10 < i9; i10++) {
                        double[] dArr6 = dArr5[i7 - floor];
                        int i11 = i10 - floor;
                        dArr6[i11] = dArr6[i11] + (dArr2[i10 - (i8 - floor)] * d2);
                    }
                }
            }
        }
        return dArr5;
    }

    /* renamed from: a */
    static Bitmap m4538a(double[][] dArr, int[] iArr, double d) {
        int i = iArr[iArr.length - 1];
        double length = ((double) (iArr.length - 1)) / d;
        int length2 = dArr.length;
        int[] iArr2 = new int[(length2 * length2)];
        for (int i2 = 0; i2 < length2; i2++) {
            for (int i3 = 0; i3 < length2; i3++) {
                double d2 = dArr[i3][i2];
                int i4 = (i2 * length2) + i3;
                int i5 = (int) (d2 * length);
                if (d2 == 0.0d) {
                    iArr2[i4] = 0;
                } else if (i5 < iArr.length) {
                    iArr2[i4] = iArr[i5];
                } else {
                    iArr2[i4] = i;
                }
            }
        }
        Bitmap createBitmap = Bitmap.createBitmap(length2, length2, Bitmap.Config.ARGB_8888);
        createBitmap.setPixels(iArr2, 0, length2, 0, 0, length2, length2);
        return createBitmap;
    }

    /* renamed from: a */
    static double m4537a(Collection<WeightedLatLng> collection, Bounds bounds, int i, int i2) {
        LongSparseArray longSparseArray;
        double d = bounds.minX;
        double d2 = bounds.maxX;
        double d3 = bounds.minY;
        double d4 = bounds.maxY;
        double d5 = ((double) ((int) (((double) (i2 / (i * 2))) + 0.5d))) / (d2 - d > d4 - d3 ? d2 - d : d4 - d3);
        LongSparseArray longSparseArray2 = new LongSparseArray();
        double d6 = 0.0d;
        Iterator<WeightedLatLng> it = collection.iterator();
        while (true) {
            double d7 = d6;
            if (!it.hasNext()) {
                return d7;
            }
            WeightedLatLng next = it.next();
            int i3 = (int) ((next.getPoint().f3969x - d) * d5);
            int i4 = (int) ((next.getPoint().f3970y - d3) * d5);
            LongSparseArray longSparseArray3 = (LongSparseArray) longSparseArray2.get((long) i3);
            if (longSparseArray3 == null) {
                LongSparseArray longSparseArray4 = new LongSparseArray();
                longSparseArray2.put((long) i3, longSparseArray4);
                longSparseArray = longSparseArray4;
            } else {
                longSparseArray = longSparseArray3;
            }
            Double d8 = (Double) longSparseArray.get((long) i4);
            if (d8 == null) {
                d8 = Double.valueOf(0.0d);
            }
            Double valueOf = Double.valueOf(next.getIntensity() + d8.doubleValue());
            longSparseArray.put((long) i4, valueOf);
            if (valueOf.doubleValue() > d7) {
                d6 = valueOf.doubleValue();
            } else {
                d6 = d7;
            }
        }
    }
}
