package p006nl.volkerinfradesign.checkandroid.util;

import android.graphics.Bitmap;
import android.graphics.Matrix;
import android.graphics.Point;
import android.media.ExifInterface;
import android.support.p001v4.media.session.PlaybackStateCompat;
import android.support.p001v4.util.LruCache;
import android.util.Pair;
import java.io.File;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;

/* renamed from: nl.volkerinfradesign.checkandroid.util.PictureCache */
public class PictureCache implements Collection<Pair<Point, File>> {

    /* renamed from: a */
    private static PictureCache f5675a;

    /* renamed from: b */
    private final LruCache<Pair<Point, File>, Bitmap> f5676b = new LruCache<Pair<Point, File>, Bitmap>((int) (Runtime.getRuntime().maxMemory() / PlaybackStateCompat.ACTION_SKIP_TO_QUEUE_ITEM)) {
        /* access modifiers changed from: protected */
        /* renamed from: a */
        public Bitmap create(Pair<Point, File> pair) {
            return m6474a(pair, 1);
        }

        /* access modifiers changed from: protected */
        /* renamed from: a */
        public int sizeOf(Pair<Point, File> pair, Bitmap bitmap) {
            return Long.valueOf(((File) pair.second).length() / 1024).intValue();
        }

        /* JADX WARNING: Code restructure failed: missing block: B:10:0x004f, code lost:
            r0 = move-exception;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:11:0x0050, code lost:
            r1 = r0;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:17:?, code lost:
            return m6474a(r8, r9 * 2);
         */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Removed duplicated region for block: B:13:0x0056 A[ExcHandler: OutOfMemoryError (e java.lang.OutOfMemoryError), Splitter:B:1:0x0005] */
        /* renamed from: a */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        private android.graphics.Bitmap m6474a(android.util.Pair<android.graphics.Point, java.io.File> r8, int r9) {
            /*
                r7 = this;
                r2 = 0
                java.lang.Object r0 = r8.second
                java.io.File r0 = (java.io.File) r0
                android.media.ExifInterface r3 = new android.media.ExifInterface     // Catch:{ Exception -> 0x004f, OutOfMemoryError -> 0x0056 }
                java.lang.String r1 = r0.getAbsolutePath()     // Catch:{ Exception -> 0x004f, OutOfMemoryError -> 0x0056 }
                r3.<init>(r1)     // Catch:{ Exception -> 0x004f, OutOfMemoryError -> 0x0056 }
                android.graphics.Matrix r5 = new android.graphics.Matrix     // Catch:{ Exception -> 0x004f, OutOfMemoryError -> 0x0056 }
                r5.<init>()     // Catch:{ Exception -> 0x004f, OutOfMemoryError -> 0x0056 }
                android.graphics.BitmapFactory$Options r4 = new android.graphics.BitmapFactory$Options     // Catch:{ Exception -> 0x004f, OutOfMemoryError -> 0x0056 }
                r4.<init>()     // Catch:{ Exception -> 0x004f, OutOfMemoryError -> 0x0056 }
                java.lang.Object r1 = r8.first     // Catch:{ Exception -> 0x004f, OutOfMemoryError -> 0x0056 }
                if (r1 == 0) goto L_0x0048
                java.lang.Object r1 = r8.first     // Catch:{ Exception -> 0x004f, OutOfMemoryError -> 0x0056 }
                android.graphics.Point r1 = (android.graphics.Point) r1     // Catch:{ Exception -> 0x004f, OutOfMemoryError -> 0x0056 }
            L_0x0020:
                int r1 = r7.m6473a(r3, r1, r9)     // Catch:{ Exception -> 0x004f, OutOfMemoryError -> 0x0056 }
                r4.inSampleSize = r1     // Catch:{ Exception -> 0x004f, OutOfMemoryError -> 0x0056 }
                r1 = 1
                r4.inMutable = r1     // Catch:{ Exception -> 0x004f, OutOfMemoryError -> 0x0056 }
                android.graphics.Bitmap$Config r1 = android.graphics.Bitmap.Config.RGB_565     // Catch:{ Exception -> 0x004f, OutOfMemoryError -> 0x0056 }
                r4.inPreferredConfig = r1     // Catch:{ Exception -> 0x004f, OutOfMemoryError -> 0x0056 }
                java.lang.String r0 = r0.getAbsolutePath()     // Catch:{ Exception -> 0x004f, OutOfMemoryError -> 0x0056 }
                android.graphics.Bitmap r0 = android.graphics.BitmapFactory.decodeFile(r0, r4)     // Catch:{ Exception -> 0x004f, OutOfMemoryError -> 0x0056 }
                r7.m6475a((android.media.ExifInterface) r3, (android.graphics.Matrix) r5)     // Catch:{ Exception -> 0x005e, OutOfMemoryError -> 0x0056 }
                r1 = 0
                r2 = 0
                int r3 = r0.getWidth()     // Catch:{ Exception -> 0x005e, OutOfMemoryError -> 0x0056 }
                int r4 = r0.getHeight()     // Catch:{ Exception -> 0x005e, OutOfMemoryError -> 0x0056 }
                r6 = 1
                android.graphics.Bitmap r0 = android.graphics.Bitmap.createBitmap(r0, r1, r2, r3, r4, r5, r6)     // Catch:{ Exception -> 0x005e, OutOfMemoryError -> 0x0056 }
            L_0x0047:
                return r0
            L_0x0048:
                nl.volkerinfradesign.checkandroid.util.PictureCache r1 = p006nl.volkerinfradesign.checkandroid.util.PictureCache.this     // Catch:{ Exception -> 0x004f, OutOfMemoryError -> 0x0056 }
                android.graphics.Point r1 = r1.f5677c     // Catch:{ Exception -> 0x004f, OutOfMemoryError -> 0x0056 }
                goto L_0x0020
            L_0x004f:
                r0 = move-exception
                r1 = r0
                r0 = r2
            L_0x0052:
                r1.printStackTrace()
                goto L_0x0047
            L_0x0056:
                r0 = move-exception
                int r0 = r9 * 2
                android.graphics.Bitmap r0 = r7.m6474a((android.util.Pair<android.graphics.Point, java.io.File>) r8, (int) r0)
                goto L_0x0047
            L_0x005e:
                r1 = move-exception
                goto L_0x0052
            */
            throw new UnsupportedOperationException("Method not decompiled: p006nl.volkerinfradesign.checkandroid.util.PictureCache.C17471.m6474a(android.util.Pair, int):android.graphics.Bitmap");
        }

        /* renamed from: a */
        private int m6473a(ExifInterface exifInterface, Point point, int i) {
            return Math.max(exifInterface.getAttributeInt("ImageWidth", point.x) / point.x, exifInterface.getAttributeInt("ImageLength", point.y) / point.y) * i;
        }

        /* renamed from: a */
        private boolean m6475a(ExifInterface exifInterface, Matrix matrix) {
            switch (exifInterface.getAttributeInt("Orientation", 0)) {
                case 3:
                    return matrix.postRotate(180.0f);
                case 6:
                    return matrix.postRotate(90.0f);
                case 8:
                    return matrix.postRotate(270.0f);
                default:
                    return false;
            }
        }
    };
    /* access modifiers changed from: private */

    /* renamed from: c */
    public Point f5677c = new Point(240, 240);

    public static PictureCache getInstance() {
        if (f5675a != null) {
            return f5675a;
        }
        PictureCache pictureCache = new PictureCache();
        f5675a = pictureCache;
        return pictureCache;
    }

    private PictureCache() {
    }

    public boolean add(Pair<Point, File> pair) {
        if (contains(pair) || get(pair) == null) {
            return false;
        }
        return true;
    }

    public boolean addAll(Collection<? extends Pair<Point, File>> collection) {
        HashSet hashSet = new HashSet();
        for (Pair add : collection) {
            hashSet.add(Boolean.valueOf(add((Pair<Point, File>) add)));
        }
        return hashSet.isEmpty() || !hashSet.contains(false);
    }

    public void clear() {
        this.f5676b.evictAll();
    }

    public synchronized boolean contains(Object obj) {
        boolean z;
        Iterator<Pair<Point, File>> it = this.f5676b.snapshot().keySet().iterator();
        while (true) {
            if (it.hasNext()) {
                if (it.next().equals(obj)) {
                    z = true;
                    break;
                }
            } else {
                z = false;
                break;
            }
        }
        return z;
    }

    public boolean containsAll(Collection<?> collection) {
        HashSet hashSet = new HashSet();
        for (Object contains : collection) {
            hashSet.add(Boolean.valueOf(contains(contains)));
        }
        if (hashSet.isEmpty() || !hashSet.contains(false)) {
            return true;
        }
        return false;
    }

    public Bitmap get(Pair<Point, File> pair) {
        if (pair != null) {
            return this.f5676b.get(pair);
        }
        return null;
    }

    public boolean isEmpty() {
        return this.f5676b.size() == 0;
    }

    public Iterator<Pair<Point, File>> iterator() {
        return this.f5676b.snapshot().keySet().iterator();
    }

    public boolean remove(Object obj) {
        return this.f5676b.remove((Pair) obj) != null;
    }

    public boolean removeAll(Collection<?> collection) {
        HashSet hashSet = new HashSet();
        for (Object remove : collection) {
            hashSet.add(Boolean.valueOf(remove(remove)));
        }
        if (hashSet.isEmpty() || !hashSet.contains(false)) {
            return true;
        }
        return false;
    }

    public boolean retainAll(Collection<?> collection) {
        throw new UnsupportedOperationException();
    }

    public int size() {
        return this.f5676b.size();
    }

    public Object[] toArray() {
        return this.f5676b.snapshot().keySet().toArray();
    }

    public <T> T[] toArray(T[] tArr) {
        return this.f5676b.snapshot().keySet().toArray(tArr);
    }
}
