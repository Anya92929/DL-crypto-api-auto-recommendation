package com.google.android.gms.internal;

import java.util.LinkedHashMap;

/* renamed from: com.google.android.gms.internal.w */
public class C0625w<K, V> {

    /* renamed from: cb */
    private final LinkedHashMap<K, V> f1433cb;

    /* renamed from: cc */
    private int f1434cc;

    /* renamed from: cd */
    private int f1435cd;

    /* renamed from: ce */
    private int f1436ce;

    /* renamed from: cf */
    private int f1437cf;

    /* renamed from: cg */
    private int f1438cg;

    /* renamed from: ch */
    private int f1439ch;
    private int size;

    public C0625w(int i) {
        if (i <= 0) {
            throw new IllegalArgumentException("maxSize <= 0");
        }
        this.f1434cc = i;
        this.f1433cb = new LinkedHashMap<>(0, 0.75f, true);
    }

    /* renamed from: c */
    private int m1901c(K k, V v) {
        int sizeOf = sizeOf(k, v);
        if (sizeOf >= 0) {
            return sizeOf;
        }
        throw new IllegalStateException("Negative size: " + k + "=" + v);
    }

    /* access modifiers changed from: protected */
    public V create(K k) {
        return null;
    }

    /* access modifiers changed from: protected */
    public void entryRemoved(boolean evicted, K k, V v, V v2) {
    }

    public final void evictAll() {
        trimToSize(-1);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:11:0x0022, code lost:
        r1 = create(r5);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:12:0x0026, code lost:
        if (r1 != null) goto L_0x002d;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:13:0x0028, code lost:
        return null;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:18:0x002d, code lost:
        monitor-enter(r4);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:20:?, code lost:
        r4.f1436ce++;
        r0 = r4.f1433cb.put(r5, r1);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:21:0x003a, code lost:
        if (r0 == null) goto L_0x0049;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:22:0x003c, code lost:
        r4.f1433cb.put(r5, r0);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:23:0x0041, code lost:
        monitor-exit(r4);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:24:0x0042, code lost:
        if (r0 == null) goto L_0x0056;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:25:0x0044, code lost:
        entryRemoved(false, r5, r1, r0);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:27:?, code lost:
        r4.size += m1901c(r5, r1);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:31:0x0056, code lost:
        trimToSize(r4.f1434cc);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:36:?, code lost:
        return r0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:37:?, code lost:
        return r1;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final V get(K r5) {
        /*
            r4 = this;
            if (r5 != 0) goto L_0x000a
            java.lang.NullPointerException r0 = new java.lang.NullPointerException
            java.lang.String r1 = "key == null"
            r0.<init>(r1)
            throw r0
        L_0x000a:
            monitor-enter(r4)
            java.util.LinkedHashMap<K, V> r0 = r4.f1433cb     // Catch:{ all -> 0x002a }
            java.lang.Object r0 = r0.get(r5)     // Catch:{ all -> 0x002a }
            if (r0 == 0) goto L_0x001b
            int r1 = r4.f1438cg     // Catch:{ all -> 0x002a }
            int r1 = r1 + 1
            r4.f1438cg = r1     // Catch:{ all -> 0x002a }
            monitor-exit(r4)     // Catch:{ all -> 0x002a }
        L_0x001a:
            return r0
        L_0x001b:
            int r0 = r4.f1439ch     // Catch:{ all -> 0x002a }
            int r0 = r0 + 1
            r4.f1439ch = r0     // Catch:{ all -> 0x002a }
            monitor-exit(r4)     // Catch:{ all -> 0x002a }
            java.lang.Object r1 = r4.create(r5)
            if (r1 != 0) goto L_0x002d
            r0 = 0
            goto L_0x001a
        L_0x002a:
            r0 = move-exception
            monitor-exit(r4)     // Catch:{ all -> 0x002a }
            throw r0
        L_0x002d:
            monitor-enter(r4)
            int r0 = r4.f1436ce     // Catch:{ all -> 0x0053 }
            int r0 = r0 + 1
            r4.f1436ce = r0     // Catch:{ all -> 0x0053 }
            java.util.LinkedHashMap<K, V> r0 = r4.f1433cb     // Catch:{ all -> 0x0053 }
            java.lang.Object r0 = r0.put(r5, r1)     // Catch:{ all -> 0x0053 }
            if (r0 == 0) goto L_0x0049
            java.util.LinkedHashMap<K, V> r2 = r4.f1433cb     // Catch:{ all -> 0x0053 }
            r2.put(r5, r0)     // Catch:{ all -> 0x0053 }
        L_0x0041:
            monitor-exit(r4)     // Catch:{ all -> 0x0053 }
            if (r0 == 0) goto L_0x0056
            r2 = 0
            r4.entryRemoved(r2, r5, r1, r0)
            goto L_0x001a
        L_0x0049:
            int r2 = r4.size     // Catch:{ all -> 0x0053 }
            int r3 = r4.m1901c(r5, r1)     // Catch:{ all -> 0x0053 }
            int r2 = r2 + r3
            r4.size = r2     // Catch:{ all -> 0x0053 }
            goto L_0x0041
        L_0x0053:
            r0 = move-exception
            monitor-exit(r4)     // Catch:{ all -> 0x0053 }
            throw r0
        L_0x0056:
            int r0 = r4.f1434cc
            r4.trimToSize(r0)
            r0 = r1
            goto L_0x001a
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.C0625w.get(java.lang.Object):java.lang.Object");
    }

    public final V put(K key, V value) {
        V put;
        if (key == null || value == null) {
            throw new NullPointerException("key == null || value == null");
        }
        synchronized (this) {
            this.f1435cd++;
            this.size += m1901c(key, value);
            put = this.f1433cb.put(key, value);
            if (put != null) {
                this.size -= m1901c(key, put);
            }
        }
        if (put != null) {
            entryRemoved(false, key, put, value);
        }
        trimToSize(this.f1434cc);
        return put;
    }

    public final synchronized int size() {
        return this.size;
    }

    /* access modifiers changed from: protected */
    public int sizeOf(K k, V v) {
        return 1;
    }

    public final synchronized String toString() {
        String format;
        int i = 0;
        synchronized (this) {
            int i2 = this.f1438cg + this.f1439ch;
            if (i2 != 0) {
                i = (this.f1438cg * 100) / i2;
            }
            format = String.format("LruCache[maxSize=%d,hits=%d,misses=%d,hitRate=%d%%]", new Object[]{Integer.valueOf(this.f1434cc), Integer.valueOf(this.f1438cg), Integer.valueOf(this.f1439ch), Integer.valueOf(i)});
        }
        return format;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:9:0x0031, code lost:
        throw new java.lang.IllegalStateException(getClass().getName() + ".sizeOf() is reporting inconsistent results!");
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void trimToSize(int r5) {
        /*
            r4 = this;
        L_0x0000:
            monitor-enter(r4)
            int r0 = r4.size     // Catch:{ all -> 0x0032 }
            if (r0 < 0) goto L_0x0011
            java.util.LinkedHashMap<K, V> r0 = r4.f1433cb     // Catch:{ all -> 0x0032 }
            boolean r0 = r0.isEmpty()     // Catch:{ all -> 0x0032 }
            if (r0 == 0) goto L_0x0035
            int r0 = r4.size     // Catch:{ all -> 0x0032 }
            if (r0 == 0) goto L_0x0035
        L_0x0011:
            java.lang.IllegalStateException r0 = new java.lang.IllegalStateException     // Catch:{ all -> 0x0032 }
            java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch:{ all -> 0x0032 }
            r1.<init>()     // Catch:{ all -> 0x0032 }
            java.lang.Class r2 = r4.getClass()     // Catch:{ all -> 0x0032 }
            java.lang.String r2 = r2.getName()     // Catch:{ all -> 0x0032 }
            java.lang.StringBuilder r1 = r1.append(r2)     // Catch:{ all -> 0x0032 }
            java.lang.String r2 = ".sizeOf() is reporting inconsistent results!"
            java.lang.StringBuilder r1 = r1.append(r2)     // Catch:{ all -> 0x0032 }
            java.lang.String r1 = r1.toString()     // Catch:{ all -> 0x0032 }
            r0.<init>(r1)     // Catch:{ all -> 0x0032 }
            throw r0     // Catch:{ all -> 0x0032 }
        L_0x0032:
            r0 = move-exception
            monitor-exit(r4)     // Catch:{ all -> 0x0032 }
            throw r0
        L_0x0035:
            int r0 = r4.size     // Catch:{ all -> 0x0032 }
            if (r0 <= r5) goto L_0x0041
            java.util.LinkedHashMap<K, V> r0 = r4.f1433cb     // Catch:{ all -> 0x0032 }
            boolean r0 = r0.isEmpty()     // Catch:{ all -> 0x0032 }
            if (r0 == 0) goto L_0x0043
        L_0x0041:
            monitor-exit(r4)     // Catch:{ all -> 0x0032 }
            return
        L_0x0043:
            java.util.LinkedHashMap<K, V> r0 = r4.f1433cb     // Catch:{ all -> 0x0032 }
            java.util.Set r0 = r0.entrySet()     // Catch:{ all -> 0x0032 }
            java.util.Iterator r0 = r0.iterator()     // Catch:{ all -> 0x0032 }
            java.lang.Object r0 = r0.next()     // Catch:{ all -> 0x0032 }
            java.util.Map$Entry r0 = (java.util.Map.Entry) r0     // Catch:{ all -> 0x0032 }
            java.lang.Object r1 = r0.getKey()     // Catch:{ all -> 0x0032 }
            java.lang.Object r0 = r0.getValue()     // Catch:{ all -> 0x0032 }
            java.util.LinkedHashMap<K, V> r2 = r4.f1433cb     // Catch:{ all -> 0x0032 }
            r2.remove(r1)     // Catch:{ all -> 0x0032 }
            int r2 = r4.size     // Catch:{ all -> 0x0032 }
            int r3 = r4.m1901c(r1, r0)     // Catch:{ all -> 0x0032 }
            int r2 = r2 - r3
            r4.size = r2     // Catch:{ all -> 0x0032 }
            int r2 = r4.f1437cf     // Catch:{ all -> 0x0032 }
            int r2 = r2 + 1
            r4.f1437cf = r2     // Catch:{ all -> 0x0032 }
            monitor-exit(r4)     // Catch:{ all -> 0x0032 }
            r2 = 1
            r3 = 0
            r4.entryRemoved(r2, r1, r0, r3)
            goto L_0x0000
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.C0625w.trimToSize(int):void");
    }
}
