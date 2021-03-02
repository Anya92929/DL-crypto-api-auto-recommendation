package android.support.p009v4.p019f;

import java.util.LinkedHashMap;
import java.util.Map;

/* renamed from: android.support.v4.f.g */
public class C0142g {

    /* renamed from: a */
    private final LinkedHashMap f198a;

    /* renamed from: b */
    private int f199b;

    /* renamed from: c */
    private int f200c;

    /* renamed from: d */
    private int f201d;

    /* renamed from: e */
    private int f202e;

    /* renamed from: f */
    private int f203f;

    /* renamed from: g */
    private int f204g;

    /* renamed from: h */
    private int f205h;

    public C0142g(int i) {
        if (i <= 0) {
            throw new IllegalArgumentException("maxSize <= 0");
        }
        this.f200c = i;
        this.f198a = new LinkedHashMap(0, 0.75f, true);
    }

    /* renamed from: b */
    private int m352b(Object obj, Object obj2) {
        int a = mo1063a(obj, obj2);
        if (a >= 0) {
            return a;
        }
        throw new IllegalStateException("Negative size: " + obj + "=" + obj2);
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public int mo1063a(Object obj, Object obj2) {
        return 1;
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public Object mo1064a(Object obj) {
        return null;
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public void mo1065a(boolean z, Object obj, Object obj2, Object obj3) {
    }

    public final synchronized int createCount() {
        return this.f202e;
    }

    public final void evictAll() {
        trimToSize(-1);
    }

    public final synchronized int evictionCount() {
        return this.f203f;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:11:0x0022, code lost:
        r1 = mo1064a(r5);
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
        r4.f202e++;
        r0 = r4.f198a.put(r5, r1);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:21:0x003a, code lost:
        if (r0 == null) goto L_0x0049;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:22:0x003c, code lost:
        r4.f198a.put(r5, r0);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:23:0x0041, code lost:
        monitor-exit(r4);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:24:0x0042, code lost:
        if (r0 == null) goto L_0x0056;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:25:0x0044, code lost:
        mo1065a(false, r5, r1, r0);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:27:?, code lost:
        r4.f199b += m352b(r5, r1);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:31:0x0056, code lost:
        trimToSize(r4.f200c);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:36:?, code lost:
        return r0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:37:?, code lost:
        return r1;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object get(java.lang.Object r5) {
        /*
            r4 = this;
            if (r5 != 0) goto L_0x000a
            java.lang.NullPointerException r0 = new java.lang.NullPointerException
            java.lang.String r1 = "key == null"
            r0.<init>(r1)
            throw r0
        L_0x000a:
            monitor-enter(r4)
            java.util.LinkedHashMap r0 = r4.f198a     // Catch:{ all -> 0x002a }
            java.lang.Object r0 = r0.get(r5)     // Catch:{ all -> 0x002a }
            if (r0 == 0) goto L_0x001b
            int r1 = r4.f204g     // Catch:{ all -> 0x002a }
            int r1 = r1 + 1
            r4.f204g = r1     // Catch:{ all -> 0x002a }
            monitor-exit(r4)     // Catch:{ all -> 0x002a }
        L_0x001a:
            return r0
        L_0x001b:
            int r0 = r4.f205h     // Catch:{ all -> 0x002a }
            int r0 = r0 + 1
            r4.f205h = r0     // Catch:{ all -> 0x002a }
            monitor-exit(r4)     // Catch:{ all -> 0x002a }
            java.lang.Object r1 = r4.mo1064a(r5)
            if (r1 != 0) goto L_0x002d
            r0 = 0
            goto L_0x001a
        L_0x002a:
            r0 = move-exception
            monitor-exit(r4)     // Catch:{ all -> 0x002a }
            throw r0
        L_0x002d:
            monitor-enter(r4)
            int r0 = r4.f202e     // Catch:{ all -> 0x0053 }
            int r0 = r0 + 1
            r4.f202e = r0     // Catch:{ all -> 0x0053 }
            java.util.LinkedHashMap r0 = r4.f198a     // Catch:{ all -> 0x0053 }
            java.lang.Object r0 = r0.put(r5, r1)     // Catch:{ all -> 0x0053 }
            if (r0 == 0) goto L_0x0049
            java.util.LinkedHashMap r2 = r4.f198a     // Catch:{ all -> 0x0053 }
            r2.put(r5, r0)     // Catch:{ all -> 0x0053 }
        L_0x0041:
            monitor-exit(r4)     // Catch:{ all -> 0x0053 }
            if (r0 == 0) goto L_0x0056
            r2 = 0
            r4.mo1065a(r2, r5, r1, r0)
            goto L_0x001a
        L_0x0049:
            int r2 = r4.f199b     // Catch:{ all -> 0x0053 }
            int r3 = r4.m352b(r5, r1)     // Catch:{ all -> 0x0053 }
            int r2 = r2 + r3
            r4.f199b = r2     // Catch:{ all -> 0x0053 }
            goto L_0x0041
        L_0x0053:
            r0 = move-exception
            monitor-exit(r4)     // Catch:{ all -> 0x0053 }
            throw r0
        L_0x0056:
            int r0 = r4.f200c
            r4.trimToSize(r0)
            r0 = r1
            goto L_0x001a
        */
        throw new UnsupportedOperationException("Method not decompiled: android.support.p009v4.p019f.C0142g.get(java.lang.Object):java.lang.Object");
    }

    public final synchronized int hitCount() {
        return this.f204g;
    }

    public final synchronized int maxSize() {
        return this.f200c;
    }

    public final synchronized int missCount() {
        return this.f205h;
    }

    public final Object put(Object obj, Object obj2) {
        Object put;
        if (obj == null || obj2 == null) {
            throw new NullPointerException("key == null || value == null");
        }
        synchronized (this) {
            this.f201d++;
            this.f199b += m352b(obj, obj2);
            put = this.f198a.put(obj, obj2);
            if (put != null) {
                this.f199b -= m352b(obj, put);
            }
        }
        if (put != null) {
            mo1065a(false, obj, put, obj2);
        }
        trimToSize(this.f200c);
        return put;
    }

    public final synchronized int putCount() {
        return this.f201d;
    }

    public final Object remove(Object obj) {
        Object remove;
        if (obj == null) {
            throw new NullPointerException("key == null");
        }
        synchronized (this) {
            remove = this.f198a.remove(obj);
            if (remove != null) {
                this.f199b -= m352b(obj, remove);
            }
        }
        if (remove != null) {
            mo1065a(false, obj, remove, (Object) null);
        }
        return remove;
    }

    public void resize(int i) {
        if (i <= 0) {
            throw new IllegalArgumentException("maxSize <= 0");
        }
        synchronized (this) {
            this.f200c = i;
        }
        trimToSize(i);
    }

    public final synchronized int size() {
        return this.f199b;
    }

    public final synchronized Map snapshot() {
        return new LinkedHashMap(this.f198a);
    }

    public final synchronized String toString() {
        String format;
        int i = 0;
        synchronized (this) {
            int i2 = this.f204g + this.f205h;
            if (i2 != 0) {
                i = (this.f204g * 100) / i2;
            }
            format = String.format("LruCache[maxSize=%d,hits=%d,misses=%d,hitRate=%d%%]", new Object[]{Integer.valueOf(this.f200c), Integer.valueOf(this.f204g), Integer.valueOf(this.f205h), Integer.valueOf(i)});
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
            int r0 = r4.f199b     // Catch:{ all -> 0x0032 }
            if (r0 < 0) goto L_0x0011
            java.util.LinkedHashMap r0 = r4.f198a     // Catch:{ all -> 0x0032 }
            boolean r0 = r0.isEmpty()     // Catch:{ all -> 0x0032 }
            if (r0 == 0) goto L_0x0035
            int r0 = r4.f199b     // Catch:{ all -> 0x0032 }
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
            int r0 = r4.f199b     // Catch:{ all -> 0x0032 }
            if (r0 <= r5) goto L_0x0041
            java.util.LinkedHashMap r0 = r4.f198a     // Catch:{ all -> 0x0032 }
            boolean r0 = r0.isEmpty()     // Catch:{ all -> 0x0032 }
            if (r0 == 0) goto L_0x0043
        L_0x0041:
            monitor-exit(r4)     // Catch:{ all -> 0x0032 }
            return
        L_0x0043:
            java.util.LinkedHashMap r0 = r4.f198a     // Catch:{ all -> 0x0032 }
            java.util.Set r0 = r0.entrySet()     // Catch:{ all -> 0x0032 }
            java.util.Iterator r0 = r0.iterator()     // Catch:{ all -> 0x0032 }
            java.lang.Object r0 = r0.next()     // Catch:{ all -> 0x0032 }
            java.util.Map$Entry r0 = (java.util.Map.Entry) r0     // Catch:{ all -> 0x0032 }
            java.lang.Object r1 = r0.getKey()     // Catch:{ all -> 0x0032 }
            java.lang.Object r0 = r0.getValue()     // Catch:{ all -> 0x0032 }
            java.util.LinkedHashMap r2 = r4.f198a     // Catch:{ all -> 0x0032 }
            r2.remove(r1)     // Catch:{ all -> 0x0032 }
            int r2 = r4.f199b     // Catch:{ all -> 0x0032 }
            int r3 = r4.m352b(r1, r0)     // Catch:{ all -> 0x0032 }
            int r2 = r2 - r3
            r4.f199b = r2     // Catch:{ all -> 0x0032 }
            int r2 = r4.f203f     // Catch:{ all -> 0x0032 }
            int r2 = r2 + 1
            r4.f203f = r2     // Catch:{ all -> 0x0032 }
            monitor-exit(r4)     // Catch:{ all -> 0x0032 }
            r2 = 1
            r3 = 0
            r4.mo1065a(r2, r1, r0, r3)
            goto L_0x0000
        */
        throw new UnsupportedOperationException("Method not decompiled: android.support.p009v4.p019f.C0142g.trimToSize(int):void");
    }
}
