package com.squareup.picasso;

import android.content.Context;
import android.graphics.Bitmap;
import java.util.LinkedHashMap;

public class LruCache implements Cache {
    private int evictionCount;
    private int hitCount;
    final LinkedHashMap<String, Bitmap> map;
    private final int maxSize;
    private int missCount;
    private int putCount;
    private int size;

    public LruCache(Context context) {
        this(Utils.calculateMemoryCacheSize(context));
    }

    public LruCache(int maxSize2) {
        if (maxSize2 <= 0) {
            throw new IllegalArgumentException("Max size must be positive.");
        }
        this.maxSize = maxSize2;
        this.map = new LinkedHashMap<>(0, 0.75f, true);
    }

    public Bitmap get(String key) {
        if (key == null) {
            throw new NullPointerException("key == null");
        }
        synchronized (this) {
            Bitmap mapValue = this.map.get(key);
            if (mapValue != null) {
                this.hitCount++;
                return mapValue;
            }
            this.missCount++;
            return null;
        }
    }

    public void set(String key, Bitmap bitmap) {
        if (key == null || bitmap == null) {
            throw new NullPointerException("key == null || bitmap == null");
        }
        synchronized (this) {
            this.putCount++;
            this.size += Utils.getBitmapBytes(bitmap);
            Bitmap previous = (Bitmap) this.map.put(key, bitmap);
            if (previous != null) {
                this.size -= Utils.getBitmapBytes(previous);
            }
        }
        trimToSize(this.maxSize);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:9:0x0031, code lost:
        throw new java.lang.IllegalStateException(getClass().getName() + ".sizeOf() is reporting inconsistent results!");
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void trimToSize(int r7) {
        /*
            r6 = this;
        L_0x0000:
            monitor-enter(r6)
            int r3 = r6.size     // Catch:{ all -> 0x0032 }
            if (r3 < 0) goto L_0x0011
            java.util.LinkedHashMap<java.lang.String, android.graphics.Bitmap> r3 = r6.map     // Catch:{ all -> 0x0032 }
            boolean r3 = r3.isEmpty()     // Catch:{ all -> 0x0032 }
            if (r3 == 0) goto L_0x0035
            int r3 = r6.size     // Catch:{ all -> 0x0032 }
            if (r3 == 0) goto L_0x0035
        L_0x0011:
            java.lang.IllegalStateException r3 = new java.lang.IllegalStateException     // Catch:{ all -> 0x0032 }
            java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch:{ all -> 0x0032 }
            r4.<init>()     // Catch:{ all -> 0x0032 }
            java.lang.Class r5 = r6.getClass()     // Catch:{ all -> 0x0032 }
            java.lang.String r5 = r5.getName()     // Catch:{ all -> 0x0032 }
            java.lang.StringBuilder r4 = r4.append(r5)     // Catch:{ all -> 0x0032 }
            java.lang.String r5 = ".sizeOf() is reporting inconsistent results!"
            java.lang.StringBuilder r4 = r4.append(r5)     // Catch:{ all -> 0x0032 }
            java.lang.String r4 = r4.toString()     // Catch:{ all -> 0x0032 }
            r3.<init>(r4)     // Catch:{ all -> 0x0032 }
            throw r3     // Catch:{ all -> 0x0032 }
        L_0x0032:
            r3 = move-exception
            monitor-exit(r6)     // Catch:{ all -> 0x0032 }
            throw r3
        L_0x0035:
            int r3 = r6.size     // Catch:{ all -> 0x0032 }
            if (r3 <= r7) goto L_0x0041
            java.util.LinkedHashMap<java.lang.String, android.graphics.Bitmap> r3 = r6.map     // Catch:{ all -> 0x0032 }
            boolean r3 = r3.isEmpty()     // Catch:{ all -> 0x0032 }
            if (r3 == 0) goto L_0x0043
        L_0x0041:
            monitor-exit(r6)     // Catch:{ all -> 0x0032 }
            return
        L_0x0043:
            java.util.LinkedHashMap<java.lang.String, android.graphics.Bitmap> r3 = r6.map     // Catch:{ all -> 0x0032 }
            java.util.Set r3 = r3.entrySet()     // Catch:{ all -> 0x0032 }
            java.util.Iterator r3 = r3.iterator()     // Catch:{ all -> 0x0032 }
            java.lang.Object r1 = r3.next()     // Catch:{ all -> 0x0032 }
            java.util.Map$Entry r1 = (java.util.Map.Entry) r1     // Catch:{ all -> 0x0032 }
            java.lang.Object r0 = r1.getKey()     // Catch:{ all -> 0x0032 }
            java.lang.String r0 = (java.lang.String) r0     // Catch:{ all -> 0x0032 }
            java.lang.Object r2 = r1.getValue()     // Catch:{ all -> 0x0032 }
            android.graphics.Bitmap r2 = (android.graphics.Bitmap) r2     // Catch:{ all -> 0x0032 }
            java.util.LinkedHashMap<java.lang.String, android.graphics.Bitmap> r3 = r6.map     // Catch:{ all -> 0x0032 }
            r3.remove(r0)     // Catch:{ all -> 0x0032 }
            int r3 = r6.size     // Catch:{ all -> 0x0032 }
            int r4 = com.squareup.picasso.Utils.getBitmapBytes(r2)     // Catch:{ all -> 0x0032 }
            int r3 = r3 - r4
            r6.size = r3     // Catch:{ all -> 0x0032 }
            int r3 = r6.evictionCount     // Catch:{ all -> 0x0032 }
            int r3 = r3 + 1
            r6.evictionCount = r3     // Catch:{ all -> 0x0032 }
            monitor-exit(r6)     // Catch:{ all -> 0x0032 }
            goto L_0x0000
        */
        throw new UnsupportedOperationException("Method not decompiled: com.squareup.picasso.LruCache.trimToSize(int):void");
    }

    public final void evictAll() {
        trimToSize(-1);
    }

    public final synchronized int size() {
        return this.size;
    }

    public final synchronized int maxSize() {
        return this.maxSize;
    }

    public final synchronized void clear() {
        evictAll();
    }

    public final synchronized int hitCount() {
        return this.hitCount;
    }

    public final synchronized int missCount() {
        return this.missCount;
    }

    public final synchronized int putCount() {
        return this.putCount;
    }

    public final synchronized int evictionCount() {
        return this.evictionCount;
    }
}
