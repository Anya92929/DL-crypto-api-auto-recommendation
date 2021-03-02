package org.apache.commons.collections4.map;

import java.util.AbstractCollection;
import java.util.AbstractSet;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Set;
import org.apache.commons.collections4.KeyValue;

public final class StaticBucketMap<K, V> extends AbstractIterableMap<K, V> {
    /* access modifiers changed from: private */

    /* renamed from: a */
    public final C1915g<K, V>[] f6712a;
    /* access modifiers changed from: private */

    /* renamed from: b */
    public final C1914f[] f6713b;

    public StaticBucketMap() {
        this(255);
    }

    public StaticBucketMap(int i) {
        int max = Math.max(17, i);
        max = max % 2 == 0 ? max - 1 : max;
        this.f6712a = new C1915g[max];
        this.f6713b = new C1914f[max];
        for (int i2 = 0; i2 < max; i2++) {
            this.f6713b[i2] = new C1914f();
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public int m7150a(Object obj) {
        if (obj == null) {
            return 0;
        }
        int hashCode = obj.hashCode();
        int i = hashCode + ((hashCode << 15) ^ -1);
        int i2 = i ^ (i >>> 10);
        int i3 = i2 + (i2 << 3);
        int i4 = i3 ^ (i3 >>> 6);
        int i5 = i4 + ((i4 << 11) ^ -1);
        int length = (i5 ^ (i5 >>> 16)) % this.f6712a.length;
        return length < 0 ? length * -1 : length;
    }

    public int size() {
        int i = 0;
        for (int i2 = 0; i2 < this.f6712a.length; i2++) {
            synchronized (this.f6713b[i2]) {
                i += this.f6713b[i2].f6722a;
            }
        }
        return i;
    }

    public boolean isEmpty() {
        return size() == 0;
    }

    public V get(Object obj) {
        int a = m7150a(obj);
        synchronized (this.f6713b[a]) {
            for (C1915g<K, V> gVar = this.f6712a[a]; gVar != null; gVar = gVar.f6725c) {
                if (gVar.f6723a == obj || (gVar.f6723a != null && gVar.f6723a.equals(obj))) {
                    V v = gVar.f6724b;
                    return v;
                }
            }
            return null;
        }
    }

    public boolean containsKey(Object obj) {
        int a = m7150a(obj);
        synchronized (this.f6713b[a]) {
            for (C1915g<K, V> gVar = this.f6712a[a]; gVar != null; gVar = gVar.f6725c) {
                if (gVar.f6723a == obj || (gVar.f6723a != null && gVar.f6723a.equals(obj))) {
                    return true;
                }
            }
            return false;
        }
    }

    public boolean containsValue(Object obj) {
        boolean z = false;
        int i = 0;
        loop0:
        while (true) {
            if (i >= this.f6712a.length) {
                break;
            }
            synchronized (this.f6713b[i]) {
                C1915g<K, V> gVar = this.f6712a[i];
                while (gVar != null) {
                    if (gVar.f6724b == obj || (gVar.f6724b != null && gVar.f6724b.equals(obj))) {
                        z = true;
                    } else {
                        gVar = gVar.f6725c;
                    }
                }
            }
            i++;
        }
        z = true;
        return z;
    }

    public V put(K k, V v) {
        V v2 = null;
        int a = m7150a((Object) k);
        synchronized (this.f6713b[a]) {
            C1915g<K, V> gVar = this.f6712a[a];
            if (gVar == null) {
                C1915g<K, V> gVar2 = new C1915g<>();
                gVar2.f6723a = k;
                gVar2.f6724b = v;
                this.f6712a[a] = gVar2;
                this.f6713b[a].f6722a++;
            } else {
                C1915g<K, V> gVar3 = gVar;
                while (true) {
                    if (gVar == null) {
                        C1915g<K, V> gVar4 = new C1915g<>();
                        gVar4.f6723a = k;
                        gVar4.f6724b = v;
                        gVar3.f6725c = gVar4;
                        this.f6713b[a].f6722a++;
                        break;
                    } else if (gVar.f6723a == k || (gVar.f6723a != null && gVar.f6723a.equals(k))) {
                        v2 = gVar.f6724b;
                        gVar.f6724b = v;
                    } else {
                        gVar3 = gVar;
                        gVar = gVar.f6725c;
                    }
                }
                v2 = gVar.f6724b;
                gVar.f6724b = v;
            }
        }
        return v2;
    }

    /* JADX WARNING: Removed duplicated region for block: B:12:0x0023  */
    /* JADX WARNING: Removed duplicated region for block: B:16:0x0037  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public V remove(java.lang.Object r8) {
        /*
            r7 = this;
            r0 = 0
            int r3 = r7.m7150a((java.lang.Object) r8)
            org.apache.commons.collections4.map.StaticBucketMap$f[] r1 = r7.f6713b
            r4 = r1[r3]
            monitor-enter(r4)
            org.apache.commons.collections4.map.StaticBucketMap$g<K, V>[] r1 = r7.f6712a     // Catch:{ all -> 0x003c }
            r2 = r1[r3]     // Catch:{ all -> 0x003c }
            r1 = r0
        L_0x000f:
            if (r2 == 0) goto L_0x0045
            K r5 = r2.f6723a     // Catch:{ all -> 0x003c }
            if (r5 == r8) goto L_0x0021
            K r5 = r2.f6723a     // Catch:{ all -> 0x003c }
            if (r5 == 0) goto L_0x003f
            K r5 = r2.f6723a     // Catch:{ all -> 0x003c }
            boolean r5 = r5.equals(r8)     // Catch:{ all -> 0x003c }
            if (r5 == 0) goto L_0x003f
        L_0x0021:
            if (r1 != 0) goto L_0x0037
            org.apache.commons.collections4.map.StaticBucketMap$g<K, V>[] r0 = r7.f6712a     // Catch:{ all -> 0x003c }
            org.apache.commons.collections4.map.StaticBucketMap$g<K, V> r1 = r2.f6725c     // Catch:{ all -> 0x003c }
            r0[r3] = r1     // Catch:{ all -> 0x003c }
        L_0x0029:
            org.apache.commons.collections4.map.StaticBucketMap$f[] r0 = r7.f6713b     // Catch:{ all -> 0x003c }
            r0 = r0[r3]     // Catch:{ all -> 0x003c }
            int r1 = r0.f6722a     // Catch:{ all -> 0x003c }
            int r1 = r1 + -1
            r0.f6722a = r1     // Catch:{ all -> 0x003c }
            V r0 = r2.f6724b     // Catch:{ all -> 0x003c }
            monitor-exit(r4)     // Catch:{ all -> 0x003c }
        L_0x0036:
            return r0
        L_0x0037:
            org.apache.commons.collections4.map.StaticBucketMap$g<K, V> r0 = r2.f6725c     // Catch:{ all -> 0x003c }
            r1.f6725c = r0     // Catch:{ all -> 0x003c }
            goto L_0x0029
        L_0x003c:
            r0 = move-exception
            monitor-exit(r4)     // Catch:{ all -> 0x003c }
            throw r0
        L_0x003f:
            org.apache.commons.collections4.map.StaticBucketMap$g<K, V> r1 = r2.f6725c     // Catch:{ all -> 0x003c }
            r6 = r2
            r2 = r1
            r1 = r6
            goto L_0x000f
        L_0x0045:
            monitor-exit(r4)     // Catch:{ all -> 0x003c }
            goto L_0x0036
        */
        throw new UnsupportedOperationException("Method not decompiled: org.apache.commons.collections4.map.StaticBucketMap.remove(java.lang.Object):java.lang.Object");
    }

    public Set<K> keySet() {
        return new C1913e();
    }

    public Collection<V> values() {
        return new C1917i();
    }

    public Set<Map.Entry<K, V>> entrySet() {
        return new C1911c();
    }

    public void putAll(Map<? extends K, ? extends V> map) {
        for (Map.Entry next : map.entrySet()) {
            put(next.getKey(), next.getValue());
        }
    }

    public void clear() {
        for (int i = 0; i < this.f6712a.length; i++) {
            C1914f fVar = this.f6713b[i];
            synchronized (fVar) {
                this.f6712a[i] = null;
                fVar.f6722a = 0;
            }
        }
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof Map)) {
            return false;
        }
        return entrySet().equals(((Map) obj).entrySet());
    }

    public int hashCode() {
        int i = 0;
        for (int i2 = 0; i2 < this.f6712a.length; i2++) {
            synchronized (this.f6713b[i2]) {
                C1915g<K, V> gVar = this.f6712a[i2];
                while (gVar != null) {
                    int hashCode = gVar.hashCode() + i;
                    gVar = gVar.f6725c;
                    i = hashCode;
                }
            }
        }
        return i;
    }

    /* renamed from: org.apache.commons.collections4.map.StaticBucketMap$g */
    static final class C1915g<K, V> implements Map.Entry<K, V>, KeyValue<K, V> {

        /* renamed from: a */
        protected K f6723a;

        /* renamed from: b */
        protected V f6724b;

        /* renamed from: c */
        protected C1915g<K, V> f6725c;

        private C1915g() {
        }

        public K getKey() {
            return this.f6723a;
        }

        public V getValue() {
            return this.f6724b;
        }

        public int hashCode() {
            int i = 0;
            int hashCode = this.f6723a == null ? 0 : this.f6723a.hashCode();
            if (this.f6724b != null) {
                i = this.f6724b.hashCode();
            }
            return hashCode ^ i;
        }

        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof Map.Entry)) {
                return false;
            }
            Map.Entry entry = (Map.Entry) obj;
            if (this.f6723a != null ? this.f6723a.equals(entry.getKey()) : entry.getKey() == null) {
                if (this.f6724b == null) {
                    if (entry.getValue() == null) {
                        return true;
                    }
                } else if (this.f6724b.equals(entry.getValue())) {
                    return true;
                }
            }
            return false;
        }

        public V setValue(V v) {
            V v2 = this.f6724b;
            this.f6724b = v;
            return v2;
        }
    }

    /* renamed from: org.apache.commons.collections4.map.StaticBucketMap$f */
    static final class C1914f {

        /* renamed from: a */
        public int f6722a;

        private C1914f() {
        }
    }

    /* renamed from: org.apache.commons.collections4.map.StaticBucketMap$a */
    class C1909a {

        /* renamed from: b */
        private final ArrayList<Map.Entry<K, V>> f6715b;

        /* renamed from: c */
        private int f6716c;

        /* renamed from: d */
        private Map.Entry<K, V> f6717d;

        private C1909a() {
            this.f6715b = new ArrayList<>();
        }

        public boolean hasNext() {
            if (this.f6715b.size() > 0) {
                return true;
            }
            while (this.f6716c < StaticBucketMap.this.f6712a.length) {
                synchronized (StaticBucketMap.this.f6713b[this.f6716c]) {
                    for (C1915g<K, V> gVar = StaticBucketMap.this.f6712a[this.f6716c]; gVar != null; gVar = gVar.f6725c) {
                        this.f6715b.add(gVar);
                    }
                    this.f6716c++;
                    if (this.f6715b.size() > 0) {
                        return true;
                    }
                }
            }
            return false;
        }

        /* access modifiers changed from: protected */
        /* renamed from: a */
        public Map.Entry<K, V> mo12190a() {
            if (!hasNext()) {
                throw new NoSuchElementException();
            }
            this.f6717d = this.f6715b.remove(this.f6715b.size() - 1);
            return this.f6717d;
        }

        public void remove() {
            if (this.f6717d == null) {
                throw new IllegalStateException();
            }
            StaticBucketMap.this.remove(this.f6717d.getKey());
            this.f6717d = null;
        }
    }

    /* renamed from: org.apache.commons.collections4.map.StaticBucketMap$b */
    class C1910b extends StaticBucketMap<K, V>.C0000a implements Iterator<Map.Entry<K, V>> {
        private C1910b() {
            super();
        }

        /* renamed from: b */
        public Map.Entry<K, V> next() {
            return mo12190a();
        }
    }

    /* renamed from: org.apache.commons.collections4.map.StaticBucketMap$h */
    class C1916h extends StaticBucketMap<K, V>.C0000a implements Iterator<V> {
        private C1916h() {
            super();
        }

        public V next() {
            return mo12190a().getValue();
        }
    }

    /* renamed from: org.apache.commons.collections4.map.StaticBucketMap$d */
    class C1912d extends StaticBucketMap<K, V>.C0000a implements Iterator<K> {
        private C1912d() {
            super();
        }

        public K next() {
            return mo12190a().getKey();
        }
    }

    /* renamed from: org.apache.commons.collections4.map.StaticBucketMap$c */
    class C1911c extends AbstractSet<Map.Entry<K, V>> {
        private C1911c() {
        }

        public int size() {
            return StaticBucketMap.this.size();
        }

        public void clear() {
            StaticBucketMap.this.clear();
        }

        public Iterator<Map.Entry<K, V>> iterator() {
            return new C1910b();
        }

        public boolean contains(Object obj) {
            Map.Entry entry = (Map.Entry) obj;
            int a = StaticBucketMap.this.m7150a(entry.getKey());
            synchronized (StaticBucketMap.this.f6713b[a]) {
                for (C1915g<K, V> gVar = StaticBucketMap.this.f6712a[a]; gVar != null; gVar = gVar.f6725c) {
                    if (gVar.equals(entry)) {
                        return true;
                    }
                }
                return false;
            }
        }

        public boolean remove(Object obj) {
            boolean z = false;
            if (obj instanceof Map.Entry) {
                Map.Entry entry = (Map.Entry) obj;
                int a = StaticBucketMap.this.m7150a(entry.getKey());
                synchronized (StaticBucketMap.this.f6713b[a]) {
                    C1915g<K, V> gVar = StaticBucketMap.this.f6712a[a];
                    while (true) {
                        if (gVar == null) {
                            break;
                        } else if (gVar.equals(entry)) {
                            StaticBucketMap.this.remove(gVar.getKey());
                            z = true;
                            break;
                        } else {
                            gVar = gVar.f6725c;
                        }
                    }
                }
            }
            return z;
        }
    }

    /* renamed from: org.apache.commons.collections4.map.StaticBucketMap$e */
    class C1913e extends AbstractSet<K> {
        private C1913e() {
        }

        public int size() {
            return StaticBucketMap.this.size();
        }

        public void clear() {
            StaticBucketMap.this.clear();
        }

        public Iterator<K> iterator() {
            return new C1912d();
        }

        public boolean contains(Object obj) {
            return StaticBucketMap.this.containsKey(obj);
        }

        public boolean remove(Object obj) {
            int a = StaticBucketMap.this.m7150a(obj);
            synchronized (StaticBucketMap.this.f6713b[a]) {
                for (C1915g<K, V> gVar = StaticBucketMap.this.f6712a[a]; gVar != null; gVar = gVar.f6725c) {
                    K key = gVar.getKey();
                    if (key == obj || (key != null && key.equals(obj))) {
                        StaticBucketMap.this.remove(key);
                        return true;
                    }
                }
                return false;
            }
        }
    }

    /* renamed from: org.apache.commons.collections4.map.StaticBucketMap$i */
    class C1917i extends AbstractCollection<V> {
        private C1917i() {
        }

        public int size() {
            return StaticBucketMap.this.size();
        }

        public void clear() {
            StaticBucketMap.this.clear();
        }

        public Iterator<V> iterator() {
            return new C1916h();
        }
    }

    public void atomic(Runnable runnable) {
        if (runnable == null) {
            throw new NullPointerException();
        }
        m7152a(runnable, 0);
    }

    /* renamed from: a */
    private void m7152a(Runnable runnable, int i) {
        if (i >= this.f6712a.length) {
            runnable.run();
            return;
        }
        synchronized (this.f6713b[i]) {
            m7152a(runnable, i + 1);
        }
    }
}
