package org.apache.commons.collections4.bidimap;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.lang.Comparable;
import java.util.AbstractSet;
import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Set;
import org.apache.commons.collections4.KeyValue;
import org.apache.commons.collections4.MapIterator;
import org.apache.commons.collections4.OrderedBidiMap;
import org.apache.commons.collections4.OrderedIterator;
import org.apache.commons.collections4.OrderedMapIterator;
import org.apache.commons.collections4.iterators.EmptyOrderedMapIterator;
import org.apache.commons.collections4.keyvalue.UnmodifiableMapEntry;

public class TreeBidiMap<K extends Comparable<K>, V extends Comparable<V>> implements Serializable, OrderedBidiMap<K, V> {
    private static final long serialVersionUID = 721969328361807L;
    /* access modifiers changed from: private */

    /* renamed from: a */
    public transient C1854h<K, V>[] f6343a;
    /* access modifiers changed from: private */

    /* renamed from: b */
    public transient int f6344b;
    /* access modifiers changed from: private */

    /* renamed from: c */
    public transient int f6345c;

    /* renamed from: d */
    private transient Set<K> f6346d;

    /* renamed from: e */
    private transient Set<V> f6347e;

    /* renamed from: f */
    private transient Set<Map.Entry<K, V>> f6348f;

    /* renamed from: g */
    private transient TreeBidiMap<K, V>.C0650c f6349g;

    /* renamed from: org.apache.commons.collections4.bidimap.TreeBidiMap$a */
    enum C1847a {
        KEY("key"),
        VALUE("value");
        

        /* renamed from: c */
        private final String f6354c;

        private C1847a(String str) {
            this.f6354c = str;
        }

        public String toString() {
            return this.f6354c;
        }
    }

    public TreeBidiMap() {
        this.f6344b = 0;
        this.f6345c = 0;
        this.f6349g = null;
        this.f6343a = new C1854h[2];
    }

    public TreeBidiMap(Map<? extends K, ? extends V> map) {
        this();
        putAll(map);
    }

    public int size() {
        return this.f6344b;
    }

    public boolean isEmpty() {
        return this.f6344b == 0;
    }

    public boolean containsKey(Object obj) {
        m6973f(obj);
        return m6967d(obj) != null;
    }

    public boolean containsValue(Object obj) {
        m6975g(obj);
        return m6971e(obj) != null;
    }

    public V get(Object obj) {
        m6973f(obj);
        C1854h d = m6967d(obj);
        if (d == null) {
            return null;
        }
        return d.getValue();
    }

    public V put(K k, V v) {
        V v2 = get((Object) k);
        m6937a(k, v);
        return v2;
    }

    public void putAll(Map<? extends K, ? extends V> map) {
        for (Map.Entry next : map.entrySet()) {
            put((Comparable) next.getKey(), (Comparable) next.getValue());
        }
    }

    public V remove(Object obj) {
        return m6946b(obj);
    }

    public void clear() {
        m6936a();
        this.f6344b = 0;
        this.f6343a[C1847a.KEY.ordinal()] = null;
        this.f6343a[C1847a.VALUE.ordinal()] = null;
    }

    public K getKey(Object obj) {
        m6975g(obj);
        C1854h e = m6971e(obj);
        if (e == null) {
            return null;
        }
        return e.getKey();
    }

    public K removeValue(Object obj) {
        return m6959c(obj);
    }

    public K firstKey() {
        if (this.f6344b != 0) {
            return m6961c(this.f6343a[C1847a.KEY.ordinal()], C1847a.KEY).getKey();
        }
        throw new NoSuchElementException("Map is empty");
    }

    public K lastKey() {
        if (this.f6344b != 0) {
            return m6968d(this.f6343a[C1847a.KEY.ordinal()], C1847a.KEY).getKey();
        }
        throw new NoSuchElementException("Map is empty");
    }

    public K nextKey(K k) {
        m6973f(k);
        C1854h a = m6932a(m6967d(k), C1847a.KEY);
        if (a == null) {
            return null;
        }
        return a.getKey();
    }

    public K previousKey(K k) {
        m6973f(k);
        C1854h b = m6951b(m6967d(k), C1847a.KEY);
        if (b == null) {
            return null;
        }
        return b.getKey();
    }

    public Set<K> keySet() {
        if (this.f6346d == null) {
            this.f6346d = new C1853g(C1847a.KEY);
        }
        return this.f6346d;
    }

    public Set<V> values() {
        if (this.f6347e == null) {
            this.f6347e = new C1855i(C1847a.KEY);
        }
        return this.f6347e;
    }

    public Set<Map.Entry<K, V>> entrySet() {
        if (this.f6348f == null) {
            this.f6348f = new C1848b();
        }
        return this.f6348f;
    }

    public OrderedMapIterator<K, V> mapIterator() {
        if (isEmpty()) {
            return EmptyOrderedMapIterator.emptyOrderedMapIterator();
        }
        return new C1859m(C1847a.KEY);
    }

    public OrderedBidiMap<V, K> inverseBidiMap() {
        if (this.f6349g == null) {
            this.f6349g = new C1849c();
        }
        return this.f6349g;
    }

    public boolean equals(Object obj) {
        return m6970d(obj, C1847a.KEY);
    }

    public int hashCode() {
        return m6929a(C1847a.KEY);
    }

    public String toString() {
        return m6948b(C1847a.KEY);
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: CFG modification limit reached, blocks count: 121 */
    /* JADX WARNING: Code restructure failed: missing block: B:14:0x008c, code lost:
        if (org.apache.commons.collections4.bidimap.TreeBidiMap.C1854h.m7007b(r0, org.apache.commons.collections4.bidimap.TreeBidiMap.C1847a.f6351a) == null) goto L_0x0095;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:15:0x008e, code lost:
        r0 = org.apache.commons.collections4.bidimap.TreeBidiMap.C1854h.m7007b(r0, org.apache.commons.collections4.bidimap.TreeBidiMap.C1847a.f6351a);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:16:0x0095, code lost:
        r1 = new org.apache.commons.collections4.bidimap.TreeBidiMap.C1854h(r4, r5);
        m6954b(r1);
        org.apache.commons.collections4.bidimap.TreeBidiMap.C1854h.m7011c(r0, r1, org.apache.commons.collections4.bidimap.TreeBidiMap.C1847a.f6351a);
        org.apache.commons.collections4.bidimap.TreeBidiMap.C1854h.m7008b(r1, r0, org.apache.commons.collections4.bidimap.TreeBidiMap.C1847a.f6351a);
        m6984o(r1, org.apache.commons.collections4.bidimap.TreeBidiMap.C1847a.f6351a);
        m6953b();
     */
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void m6937a(K r4, V r5) {
        /*
            r3 = this;
            m6939a((java.lang.Object) r4, (java.lang.Object) r5)
            r3.m6946b((java.lang.Object) r4)
            r3.m6959c((java.lang.Object) r5)
            org.apache.commons.collections4.bidimap.TreeBidiMap$h<K, V>[] r0 = r3.f6343a
            org.apache.commons.collections4.bidimap.TreeBidiMap$a r1 = org.apache.commons.collections4.bidimap.TreeBidiMap.C1847a.KEY
            int r1 = r1.ordinal()
            r0 = r0[r1]
            if (r0 != 0) goto L_0x0042
            org.apache.commons.collections4.bidimap.TreeBidiMap$h r0 = new org.apache.commons.collections4.bidimap.TreeBidiMap$h
            r0.<init>(r4, r5)
            org.apache.commons.collections4.bidimap.TreeBidiMap$h<K, V>[] r1 = r3.f6343a
            org.apache.commons.collections4.bidimap.TreeBidiMap$a r2 = org.apache.commons.collections4.bidimap.TreeBidiMap.C1847a.KEY
            int r2 = r2.ordinal()
            r1[r2] = r0
            org.apache.commons.collections4.bidimap.TreeBidiMap$h<K, V>[] r1 = r3.f6343a
            org.apache.commons.collections4.bidimap.TreeBidiMap$a r2 = org.apache.commons.collections4.bidimap.TreeBidiMap.C1847a.VALUE
            int r2 = r2.ordinal()
            r1[r2] = r0
            r3.m6953b()
        L_0x0031:
            return
        L_0x0032:
            if (r1 >= 0) goto L_0x0086
            org.apache.commons.collections4.bidimap.TreeBidiMap$a r1 = org.apache.commons.collections4.bidimap.TreeBidiMap.C1847a.KEY
            org.apache.commons.collections4.bidimap.TreeBidiMap$h r1 = r0.m7006b(r1)
            if (r1 == 0) goto L_0x006b
            org.apache.commons.collections4.bidimap.TreeBidiMap$a r1 = org.apache.commons.collections4.bidimap.TreeBidiMap.C1847a.KEY
            org.apache.commons.collections4.bidimap.TreeBidiMap$h r0 = r0.m7006b(r1)
        L_0x0042:
            java.lang.Comparable r1 = r0.getKey()
            int r1 = m6945b(r4, r1)
            if (r1 != 0) goto L_0x0032
            java.lang.IllegalArgumentException r0 = new java.lang.IllegalArgumentException
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.String r2 = "Cannot store a duplicate key (\""
            java.lang.StringBuilder r1 = r1.append(r2)
            java.lang.StringBuilder r1 = r1.append(r4)
            java.lang.String r2 = "\") in this Map"
            java.lang.StringBuilder r1 = r1.append(r2)
            java.lang.String r1 = r1.toString()
            r0.<init>(r1)
            throw r0
        L_0x006b:
            org.apache.commons.collections4.bidimap.TreeBidiMap$h r1 = new org.apache.commons.collections4.bidimap.TreeBidiMap$h
            r1.<init>(r4, r5)
            r3.m6954b(r1)
            org.apache.commons.collections4.bidimap.TreeBidiMap$a r2 = org.apache.commons.collections4.bidimap.TreeBidiMap.C1847a.KEY
            r0.m7028k(r1, r2)
            org.apache.commons.collections4.bidimap.TreeBidiMap$a r2 = org.apache.commons.collections4.bidimap.TreeBidiMap.C1847a.KEY
            r1.m7030m(r0, r2)
            org.apache.commons.collections4.bidimap.TreeBidiMap$a r0 = org.apache.commons.collections4.bidimap.TreeBidiMap.C1847a.KEY
            r3.m6984o(r1, r0)
            r3.m6953b()
            goto L_0x0031
        L_0x0086:
            org.apache.commons.collections4.bidimap.TreeBidiMap$a r1 = org.apache.commons.collections4.bidimap.TreeBidiMap.C1847a.KEY
            org.apache.commons.collections4.bidimap.TreeBidiMap$h r1 = r0.m7010c(r1)
            if (r1 == 0) goto L_0x0095
            org.apache.commons.collections4.bidimap.TreeBidiMap$a r1 = org.apache.commons.collections4.bidimap.TreeBidiMap.C1847a.KEY
            org.apache.commons.collections4.bidimap.TreeBidiMap$h r0 = r0.m7010c(r1)
            goto L_0x0042
        L_0x0095:
            org.apache.commons.collections4.bidimap.TreeBidiMap$h r1 = new org.apache.commons.collections4.bidimap.TreeBidiMap$h
            r1.<init>(r4, r5)
            r3.m6954b(r1)
            org.apache.commons.collections4.bidimap.TreeBidiMap$a r2 = org.apache.commons.collections4.bidimap.TreeBidiMap.C1847a.KEY
            r0.m7029l(r1, r2)
            org.apache.commons.collections4.bidimap.TreeBidiMap$a r2 = org.apache.commons.collections4.bidimap.TreeBidiMap.C1847a.KEY
            r1.m7030m(r0, r2)
            org.apache.commons.collections4.bidimap.TreeBidiMap$a r0 = org.apache.commons.collections4.bidimap.TreeBidiMap.C1847a.KEY
            r3.m6984o(r1, r0)
            r3.m6953b()
            goto L_0x0031
        */
        throw new UnsupportedOperationException("Method not decompiled: org.apache.commons.collections4.bidimap.TreeBidiMap.m6937a(java.lang.Comparable, java.lang.Comparable):void");
    }

    /* access modifiers changed from: private */
    /* renamed from: b */
    public V m6946b(Object obj) {
        C1854h d = m6967d(obj);
        if (d == null) {
            return null;
        }
        m6941a(d);
        return d.getValue();
    }

    /* access modifiers changed from: private */
    /* renamed from: c */
    public K m6959c(Object obj) {
        C1854h e = m6971e(obj);
        if (e == null) {
            return null;
        }
        m6941a(e);
        return e.getKey();
    }

    /* access modifiers changed from: private */
    /* renamed from: b */
    public <T extends Comparable<T>> C1854h<K, V> m6950b(Object obj, C1847a aVar) {
        C1854h<K, V> hVar = this.f6343a[aVar.ordinal()];
        while (hVar != null) {
            int b = m6945b((Comparable) obj, (Comparable) hVar.m7003a(aVar));
            if (b == 0) {
                return hVar;
            }
            hVar = b < 0 ? hVar.m7006b(aVar) : hVar.m7010c(aVar);
        }
        return null;
    }

    /* access modifiers changed from: private */
    /* renamed from: d */
    public C1854h<K, V> m6967d(Object obj) {
        return m6950b(obj, C1847a.KEY);
    }

    /* access modifiers changed from: private */
    /* renamed from: e */
    public C1854h<K, V> m6971e(Object obj) {
        return m6950b(obj, C1847a.VALUE);
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public C1854h<K, V> m6932a(C1854h<K, V> hVar, C1847a aVar) {
        if (hVar == null) {
            return null;
        }
        if (hVar.m7010c(aVar) != null) {
            return m6961c(hVar.m7010c(aVar), aVar);
        }
        C1854h<K, V> d = hVar.m7012d(aVar);
        while (d != null && hVar == d.m7010c(aVar)) {
            hVar = d;
            d = d.m7012d(aVar);
        }
        return d;
    }

    /* access modifiers changed from: private */
    /* renamed from: b */
    public C1854h<K, V> m6951b(C1854h<K, V> hVar, C1847a aVar) {
        if (hVar == null) {
            return null;
        }
        if (hVar.m7006b(aVar) != null) {
            return m6968d(hVar.m7006b(aVar), aVar);
        }
        C1854h<K, V> d = hVar.m7012d(aVar);
        while (d != null && hVar == d.m7006b(aVar)) {
            hVar = d;
            d = d.m7012d(aVar);
        }
        return d;
    }

    /* renamed from: b */
    private static <T extends Comparable<T>> int m6945b(T t, T t2) {
        return t.compareTo(t2);
    }

    /* access modifiers changed from: private */
    /* renamed from: c */
    public C1854h<K, V> m6961c(C1854h<K, V> hVar, C1847a aVar) {
        if (hVar != null) {
            while (hVar.m7006b(aVar) != null) {
                hVar = hVar.m7006b(aVar);
            }
        }
        return hVar;
    }

    /* access modifiers changed from: private */
    /* renamed from: d */
    public C1854h<K, V> m6968d(C1854h<K, V> hVar, C1847a aVar) {
        if (hVar != null) {
            while (hVar.m7010c(aVar) != null) {
                hVar = hVar.m7010c(aVar);
            }
        }
        return hVar;
    }

    /* renamed from: a */
    private void m6942a(C1854h<K, V> hVar, C1854h<K, V> hVar2, C1847a aVar) {
        if (hVar2 == null) {
            return;
        }
        if (hVar == null) {
            hVar2.m7020g(aVar);
        } else {
            hVar2.m7032o(hVar, aVar);
        }
    }

    /* renamed from: e */
    private static boolean m6972e(C1854h<?, ?> hVar, C1847a aVar) {
        return hVar != null && hVar.m7018f(aVar);
    }

    /* renamed from: f */
    private static boolean m6974f(C1854h<?, ?> hVar, C1847a aVar) {
        return hVar == null || hVar.m7017e(aVar);
    }

    /* renamed from: g */
    private static void m6976g(C1854h<?, ?> hVar, C1847a aVar) {
        if (hVar != null) {
            hVar.m7022h(aVar);
        }
    }

    /* renamed from: h */
    private static void m6977h(C1854h<?, ?> hVar, C1847a aVar) {
        if (hVar != null) {
            hVar.m7020g(aVar);
        }
    }

    /* renamed from: i */
    private C1854h<K, V> m6978i(C1854h<K, V> hVar, C1847a aVar) {
        return m6979j(m6979j(hVar, aVar), aVar);
    }

    /* renamed from: j */
    private C1854h<K, V> m6979j(C1854h<K, V> hVar, C1847a aVar) {
        if (hVar == null) {
            return null;
        }
        return hVar.m7012d(aVar);
    }

    /* renamed from: k */
    private C1854h<K, V> m6980k(C1854h<K, V> hVar, C1847a aVar) {
        if (hVar == null) {
            return null;
        }
        return hVar.m7010c(aVar);
    }

    /* renamed from: l */
    private C1854h<K, V> m6981l(C1854h<K, V> hVar, C1847a aVar) {
        if (hVar == null) {
            return null;
        }
        return hVar.m7006b(aVar);
    }

    /* renamed from: m */
    private void m6982m(C1854h<K, V> hVar, C1847a aVar) {
        C1854h<K, V> b = hVar.m7010c(aVar);
        hVar.m7029l(b.m7006b(aVar), aVar);
        if (b.m7006b(aVar) != null) {
            b.m7006b(aVar).m7030m(hVar, aVar);
        }
        b.m7030m(hVar.m7012d(aVar), aVar);
        if (hVar.m7012d(aVar) == null) {
            this.f6343a[aVar.ordinal()] = b;
        } else if (hVar.m7012d(aVar).m7006b(aVar) == hVar) {
            hVar.m7012d(aVar).m7028k(b, aVar);
        } else {
            hVar.m7012d(aVar).m7029l(b, aVar);
        }
        b.m7028k(hVar, aVar);
        hVar.m7030m(b, aVar);
    }

    /* renamed from: n */
    private void m6983n(C1854h<K, V> hVar, C1847a aVar) {
        C1854h<K, V> a = hVar.m7006b(aVar);
        hVar.m7028k(a.m7010c(aVar), aVar);
        if (a.m7010c(aVar) != null) {
            a.m7010c(aVar).m7030m(hVar, aVar);
        }
        a.m7030m(hVar.m7012d(aVar), aVar);
        if (hVar.m7012d(aVar) == null) {
            this.f6343a[aVar.ordinal()] = a;
        } else if (hVar.m7012d(aVar).m7010c(aVar) == hVar) {
            hVar.m7012d(aVar).m7029l(a, aVar);
        } else {
            hVar.m7012d(aVar).m7028k(a, aVar);
        }
        a.m7029l(hVar, aVar);
        hVar.m7030m(a, aVar);
    }

    /* renamed from: o */
    private void m6984o(C1854h<K, V> hVar, C1847a aVar) {
        m6976g(hVar, aVar);
        C1854h<K, V> hVar2 = hVar;
        while (hVar2 != null && hVar2 != this.f6343a[aVar.ordinal()] && m6972e(hVar2.m7012d(aVar), aVar)) {
            if (hVar2.m7024i(aVar)) {
                C1854h<K, V> k = m6980k(m6978i(hVar2, aVar), aVar);
                if (m6972e(k, aVar)) {
                    m6977h(m6979j(hVar2, aVar), aVar);
                    m6977h(k, aVar);
                    m6976g(m6978i(hVar2, aVar), aVar);
                    hVar2 = m6978i(hVar2, aVar);
                } else {
                    if (hVar2.m7026j(aVar)) {
                        hVar2 = m6979j(hVar2, aVar);
                        m6982m(hVar2, aVar);
                    }
                    m6977h(m6979j(hVar2, aVar), aVar);
                    m6976g(m6978i(hVar2, aVar), aVar);
                    if (m6978i(hVar2, aVar) != null) {
                        m6983n(m6978i(hVar2, aVar), aVar);
                    }
                }
            } else {
                C1854h<K, V> l = m6981l(m6978i(hVar2, aVar), aVar);
                if (m6972e(l, aVar)) {
                    m6977h(m6979j(hVar2, aVar), aVar);
                    m6977h(l, aVar);
                    m6976g(m6978i(hVar2, aVar), aVar);
                    hVar2 = m6978i(hVar2, aVar);
                } else {
                    if (hVar2.m7024i(aVar)) {
                        hVar2 = m6979j(hVar2, aVar);
                        m6983n(hVar2, aVar);
                    }
                    m6977h(m6979j(hVar2, aVar), aVar);
                    m6976g(m6978i(hVar2, aVar), aVar);
                    if (m6978i(hVar2, aVar) != null) {
                        m6982m(m6978i(hVar2, aVar), aVar);
                    }
                }
            }
        }
        m6977h(this.f6343a[aVar.ordinal()], aVar);
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m6941a(C1854h<K, V> hVar) {
        for (C1847a aVar : C1847a.values()) {
            if (!(hVar.m7006b(aVar) == null || hVar.m7010c(aVar) == null)) {
                m6955b(m6932a(hVar, aVar), hVar, aVar);
            }
            C1854h<K, V> a = hVar.m7006b(aVar) != null ? hVar.m7006b(aVar) : hVar.m7010c(aVar);
            if (a != null) {
                a.m7030m(hVar.m7012d(aVar), aVar);
                if (hVar.m7012d(aVar) == null) {
                    this.f6343a[aVar.ordinal()] = a;
                } else if (hVar == hVar.m7012d(aVar).m7006b(aVar)) {
                    hVar.m7012d(aVar).m7028k(a, aVar);
                } else {
                    hVar.m7012d(aVar).m7029l(a, aVar);
                }
                hVar.m7028k((C1854h<K, V>) null, aVar);
                hVar.m7029l((C1854h<K, V>) null, aVar);
                hVar.m7030m((C1854h<K, V>) null, aVar);
                if (m6974f(hVar, aVar)) {
                    m6985p(a, aVar);
                }
            } else if (hVar.m7012d(aVar) == null) {
                this.f6343a[aVar.ordinal()] = null;
            } else {
                if (m6974f(hVar, aVar)) {
                    m6985p(hVar, aVar);
                }
                if (hVar.m7012d(aVar) != null) {
                    if (hVar == hVar.m7012d(aVar).m7006b(aVar)) {
                        hVar.m7012d(aVar).m7028k((C1854h) null, aVar);
                    } else {
                        hVar.m7012d(aVar).m7029l((C1854h) null, aVar);
                    }
                    hVar.m7030m((C1854h<K, V>) null, aVar);
                }
            }
        }
        m6964c();
    }

    /* renamed from: p */
    private void m6985p(C1854h<K, V> hVar, C1847a aVar) {
        while (hVar != this.f6343a[aVar.ordinal()] && m6974f(hVar, aVar)) {
            if (hVar.m7024i(aVar)) {
                C1854h<K, V> k = m6980k(m6979j(hVar, aVar), aVar);
                if (m6972e(k, aVar)) {
                    m6977h(k, aVar);
                    m6976g(m6979j(hVar, aVar), aVar);
                    m6982m(m6979j(hVar, aVar), aVar);
                    k = m6980k(m6979j(hVar, aVar), aVar);
                }
                if (!m6974f(m6981l(k, aVar), aVar) || !m6974f(m6980k(k, aVar), aVar)) {
                    if (m6974f(m6980k(k, aVar), aVar)) {
                        m6977h(m6981l(k, aVar), aVar);
                        m6976g(k, aVar);
                        m6983n(k, aVar);
                        k = m6980k(m6979j(hVar, aVar), aVar);
                    }
                    m6942a(m6979j(hVar, aVar), k, aVar);
                    m6977h(m6979j(hVar, aVar), aVar);
                    m6977h(m6980k(k, aVar), aVar);
                    m6982m(m6979j(hVar, aVar), aVar);
                    hVar = this.f6343a[aVar.ordinal()];
                } else {
                    m6976g(k, aVar);
                    hVar = m6979j(hVar, aVar);
                }
            } else {
                C1854h<K, V> l = m6981l(m6979j(hVar, aVar), aVar);
                if (m6972e(l, aVar)) {
                    m6977h(l, aVar);
                    m6976g(m6979j(hVar, aVar), aVar);
                    m6983n(m6979j(hVar, aVar), aVar);
                    l = m6981l(m6979j(hVar, aVar), aVar);
                }
                if (!m6974f(m6980k(l, aVar), aVar) || !m6974f(m6981l(l, aVar), aVar)) {
                    if (m6974f(m6981l(l, aVar), aVar)) {
                        m6977h(m6980k(l, aVar), aVar);
                        m6976g(l, aVar);
                        m6982m(l, aVar);
                        l = m6981l(m6979j(hVar, aVar), aVar);
                    }
                    m6942a(m6979j(hVar, aVar), l, aVar);
                    m6977h(m6979j(hVar, aVar), aVar);
                    m6977h(m6981l(l, aVar), aVar);
                    m6983n(m6979j(hVar, aVar), aVar);
                    hVar = this.f6343a[aVar.ordinal()];
                } else {
                    m6976g(l, aVar);
                    hVar = m6979j(hVar, aVar);
                }
            }
        }
        m6977h(hVar, aVar);
    }

    /* renamed from: b */
    private void m6955b(C1854h<K, V> hVar, C1854h<K, V> hVar2, C1847a aVar) {
        boolean z = true;
        C1854h<K, V> d = hVar.m7012d(aVar);
        C1854h a = hVar.m7006b(aVar);
        C1854h b = hVar.m7010c(aVar);
        C1854h<K, V> d2 = hVar2.m7012d(aVar);
        C1854h a2 = hVar2.m7006b(aVar);
        C1854h b2 = hVar2.m7010c(aVar);
        boolean z2 = hVar.m7012d(aVar) != null && hVar == hVar.m7012d(aVar).m7006b(aVar);
        if (hVar2.m7012d(aVar) == null || hVar2 != hVar2.m7012d(aVar).m7006b(aVar)) {
            z = false;
        }
        if (hVar == d2) {
            hVar.m7030m(hVar2, aVar);
            if (z) {
                hVar2.m7028k(hVar, aVar);
                hVar2.m7029l(b, aVar);
            } else {
                hVar2.m7029l(hVar, aVar);
                hVar2.m7028k(a, aVar);
            }
        } else {
            hVar.m7030m(d2, aVar);
            if (d2 != null) {
                if (z) {
                    d2.m7028k(hVar, aVar);
                } else {
                    d2.m7029l(hVar, aVar);
                }
            }
            hVar2.m7028k(a, aVar);
            hVar2.m7029l(b, aVar);
        }
        if (hVar2 == d) {
            hVar2.m7030m(hVar, aVar);
            if (z2) {
                hVar.m7028k(hVar2, aVar);
                hVar.m7029l(b2, aVar);
            } else {
                hVar.m7029l(hVar2, aVar);
                hVar.m7028k(a2, aVar);
            }
        } else {
            hVar2.m7030m(d, aVar);
            if (d != null) {
                if (z2) {
                    d.m7028k(hVar2, aVar);
                } else {
                    d.m7029l(hVar2, aVar);
                }
            }
            hVar.m7028k(a2, aVar);
            hVar.m7029l(b2, aVar);
        }
        if (hVar.m7006b(aVar) != null) {
            hVar.m7006b(aVar).m7030m(hVar, aVar);
        }
        if (hVar.m7010c(aVar) != null) {
            hVar.m7010c(aVar).m7030m(hVar, aVar);
        }
        if (hVar2.m7006b(aVar) != null) {
            hVar2.m7006b(aVar).m7030m(hVar2, aVar);
        }
        if (hVar2.m7010c(aVar) != null) {
            hVar2.m7010c(aVar).m7030m(hVar2, aVar);
        }
        hVar.m7031n(hVar2, aVar);
        if (this.f6343a[aVar.ordinal()] == hVar) {
            this.f6343a[aVar.ordinal()] = hVar2;
        } else if (this.f6343a[aVar.ordinal()] == hVar2) {
            this.f6343a[aVar.ordinal()] = hVar;
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: c */
    public static void m6965c(Object obj, C1847a aVar) {
        if (obj == null) {
            throw new NullPointerException(aVar + " cannot be null");
        } else if (!(obj instanceof Comparable)) {
            throw new ClassCastException(aVar + " must be Comparable");
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: f */
    public static void m6973f(Object obj) {
        m6965c(obj, C1847a.KEY);
    }

    /* renamed from: g */
    private static void m6975g(Object obj) {
        m6965c(obj, C1847a.VALUE);
    }

    /* renamed from: a */
    private static void m6939a(Object obj, Object obj2) {
        m6973f(obj);
        m6975g(obj2);
    }

    /* renamed from: a */
    private void m6936a() {
        this.f6345c++;
    }

    /* renamed from: b */
    private void m6953b() {
        m6936a();
        this.f6344b++;
    }

    /* renamed from: c */
    private void m6964c() {
        m6936a();
        this.f6344b--;
    }

    /* renamed from: b */
    private void m6954b(C1854h<K, V> hVar) throws IllegalArgumentException {
        C1854h<K, V> hVar2 = this.f6343a[C1847a.VALUE.ordinal()];
        while (true) {
            int b = m6945b(hVar.getValue(), hVar2.getValue());
            if (b == 0) {
                throw new IllegalArgumentException("Cannot store a duplicate value (\"" + hVar.m7003a(C1847a.VALUE) + "\") in this Map");
            } else if (b < 0) {
                if (hVar2.m7006b(C1847a.VALUE) != null) {
                    hVar2 = hVar2.m7006b(C1847a.VALUE);
                } else {
                    hVar2.m7028k(hVar, C1847a.VALUE);
                    hVar.m7030m(hVar2, C1847a.VALUE);
                    m6984o(hVar, C1847a.VALUE);
                    return;
                }
            } else if (hVar2.m7010c(C1847a.VALUE) != null) {
                hVar2 = hVar2.m7010c(C1847a.VALUE);
            } else {
                hVar2.m7029l(hVar, C1847a.VALUE);
                hVar.m7030m(hVar2, C1847a.VALUE);
                m6984o(hVar, C1847a.VALUE);
                return;
            }
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: d */
    public boolean m6970d(Object obj, C1847a aVar) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof Map)) {
            return false;
        }
        Map map = (Map) obj;
        if (map.size() != size()) {
            return false;
        }
        if (this.f6344b <= 0) {
            return true;
        }
        try {
            MapIterator<?, ?> c = m6960c(aVar);
            while (c.hasNext()) {
                if (!c.getValue().equals(map.get(c.next()))) {
                    return false;
                }
            }
            return true;
        } catch (ClassCastException e) {
            return false;
        } catch (NullPointerException e2) {
            return false;
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public int m6929a(C1847a aVar) {
        int i = 0;
        if (this.f6344b > 0) {
            MapIterator<?, ?> c = m6960c(aVar);
            while (c.hasNext()) {
                i += c.next().hashCode() ^ c.getValue().hashCode();
            }
        }
        return i;
    }

    /* access modifiers changed from: private */
    /* renamed from: b */
    public String m6948b(C1847a aVar) {
        if (this.f6344b == 0) {
            return "{}";
        }
        StringBuilder sb = new StringBuilder(this.f6344b * 32);
        sb.append('{');
        MapIterator<?, ?> c = m6960c(aVar);
        boolean hasNext = c.hasNext();
        while (hasNext) {
            Object next = c.next();
            Object value = c.getValue();
            if (next == this) {
                next = "(this Map)";
            }
            sb.append(next).append('=').append(value == this ? "(this Map)" : value);
            hasNext = c.hasNext();
            if (hasNext) {
                sb.append(", ");
            }
        }
        sb.append('}');
        return sb.toString();
    }

    /* renamed from: c */
    private MapIterator<?, ?> m6960c(C1847a aVar) {
        switch (aVar) {
            case KEY:
                return new C1859m(C1847a.KEY);
            case VALUE:
                return new C1852f(C1847a.VALUE);
            default:
                throw new IllegalArgumentException();
        }
    }

    private void readObject(ObjectInputStream objectInputStream) throws IOException, ClassNotFoundException {
        objectInputStream.defaultReadObject();
        this.f6343a = new C1854h[2];
        int readInt = objectInputStream.readInt();
        for (int i = 0; i < readInt; i++) {
            put((Comparable) objectInputStream.readObject(), (Comparable) objectInputStream.readObject());
        }
    }

    private void writeObject(ObjectOutputStream objectOutputStream) throws IOException {
        objectOutputStream.defaultWriteObject();
        objectOutputStream.writeInt(size());
        for (Map.Entry entry : entrySet()) {
            objectOutputStream.writeObject(entry.getKey());
            objectOutputStream.writeObject(entry.getValue());
        }
    }

    /* renamed from: org.apache.commons.collections4.bidimap.TreeBidiMap$j */
    abstract class C1856j<E> extends AbstractSet<E> {

        /* renamed from: b */
        final C1847a f6373b;

        C1856j(C1847a aVar) {
            this.f6373b = aVar;
        }

        public int size() {
            return TreeBidiMap.this.size();
        }

        public void clear() {
            TreeBidiMap.this.clear();
        }
    }

    /* renamed from: org.apache.commons.collections4.bidimap.TreeBidiMap$g */
    class C1853g extends TreeBidiMap<K, V>.C1306j<K> {
        public C1853g(C1847a aVar) {
            super(aVar);
        }

        public Iterator<K> iterator() {
            return new C1859m(this.f6373b);
        }

        public boolean contains(Object obj) {
            TreeBidiMap.m6965c(obj, C1847a.KEY);
            return TreeBidiMap.this.m6967d(obj) != null;
        }

        public boolean remove(Object obj) {
            return TreeBidiMap.this.m6946b(obj) != null;
        }
    }

    /* renamed from: org.apache.commons.collections4.bidimap.TreeBidiMap$i */
    class C1855i extends TreeBidiMap<K, V>.C1306j<V> {
        public C1855i(C1847a aVar) {
            super(aVar);
        }

        public Iterator<V> iterator() {
            return new C1852f(this.f6373b);
        }

        public boolean contains(Object obj) {
            TreeBidiMap.m6965c(obj, C1847a.VALUE);
            return TreeBidiMap.this.m6971e(obj) != null;
        }

        public boolean remove(Object obj) {
            return TreeBidiMap.this.m6959c(obj) != null;
        }
    }

    /* renamed from: org.apache.commons.collections4.bidimap.TreeBidiMap$b */
    class C1848b extends TreeBidiMap<K, V>.C1306j<Map.Entry<K, V>> {
        C1848b() {
            super(C1847a.KEY);
        }

        public boolean contains(Object obj) {
            if (!(obj instanceof Map.Entry)) {
                return false;
            }
            Map.Entry entry = (Map.Entry) obj;
            Object value = entry.getValue();
            C1854h a = TreeBidiMap.this.m6967d(entry.getKey());
            if (a == null || !a.getValue().equals(value)) {
                return false;
            }
            return true;
        }

        public boolean remove(Object obj) {
            if (!(obj instanceof Map.Entry)) {
                return false;
            }
            Map.Entry entry = (Map.Entry) obj;
            Object value = entry.getValue();
            C1854h a = TreeBidiMap.this.m6967d(entry.getKey());
            if (a == null || !a.getValue().equals(value)) {
                return false;
            }
            TreeBidiMap.this.m6941a(a);
            return true;
        }

        public Iterator<Map.Entry<K, V>> iterator() {
            return new C1858l();
        }
    }

    /* renamed from: org.apache.commons.collections4.bidimap.TreeBidiMap$d */
    class C1850d extends TreeBidiMap<K, V>.C1306j<Map.Entry<V, K>> {
        C1850d() {
            super(C1847a.VALUE);
        }

        public boolean contains(Object obj) {
            if (!(obj instanceof Map.Entry)) {
                return false;
            }
            Map.Entry entry = (Map.Entry) obj;
            Object value = entry.getValue();
            C1854h c = TreeBidiMap.this.m6971e(entry.getKey());
            if (c == null || !c.getKey().equals(value)) {
                return false;
            }
            return true;
        }

        public boolean remove(Object obj) {
            if (!(obj instanceof Map.Entry)) {
                return false;
            }
            Map.Entry entry = (Map.Entry) obj;
            Object value = entry.getValue();
            C1854h c = TreeBidiMap.this.m6971e(entry.getKey());
            if (c == null || !c.getKey().equals(value)) {
                return false;
            }
            TreeBidiMap.this.m6941a(c);
            return true;
        }

        public Iterator<Map.Entry<V, K>> iterator() {
            return new C1851e();
        }
    }

    /* renamed from: org.apache.commons.collections4.bidimap.TreeBidiMap$k */
    abstract class C1857k {

        /* renamed from: a */
        private final C1847a f6375a;

        /* renamed from: b */
        C1854h<K, V> f6376b = null;

        /* renamed from: d */
        private C1854h<K, V> f6378d;

        /* renamed from: e */
        private C1854h<K, V> f6379e = null;

        /* renamed from: f */
        private int f6380f;

        C1857k(C1847a aVar) {
            this.f6375a = aVar;
            this.f6380f = TreeBidiMap.this.f6345c;
            this.f6378d = TreeBidiMap.this.m6961c(TreeBidiMap.this.f6343a[aVar.ordinal()], aVar);
        }

        public final boolean hasNext() {
            return this.f6378d != null;
        }

        /* access modifiers changed from: protected */
        /* renamed from: e */
        public C1854h<K, V> mo11416e() {
            if (this.f6378d == null) {
                throw new NoSuchElementException();
            } else if (TreeBidiMap.this.f6345c != this.f6380f) {
                throw new ConcurrentModificationException();
            } else {
                this.f6376b = this.f6378d;
                this.f6379e = this.f6378d;
                this.f6378d = TreeBidiMap.this.m6932a(this.f6378d, this.f6375a);
                return this.f6376b;
            }
        }

        public boolean hasPrevious() {
            return this.f6379e != null;
        }

        /* access modifiers changed from: protected */
        /* renamed from: f */
        public C1854h<K, V> mo11417f() {
            if (this.f6379e == null) {
                throw new NoSuchElementException();
            } else if (TreeBidiMap.this.f6345c != this.f6380f) {
                throw new ConcurrentModificationException();
            } else {
                this.f6378d = this.f6376b;
                if (this.f6378d == null) {
                    this.f6378d = TreeBidiMap.this.m6932a(this.f6379e, this.f6375a);
                }
                this.f6376b = this.f6379e;
                this.f6379e = TreeBidiMap.this.m6951b(this.f6379e, this.f6375a);
                return this.f6376b;
            }
        }

        public final void remove() {
            if (this.f6376b == null) {
                throw new IllegalStateException();
            } else if (TreeBidiMap.this.f6345c != this.f6380f) {
                throw new ConcurrentModificationException();
            } else {
                TreeBidiMap.this.m6941a(this.f6376b);
                this.f6380f++;
                this.f6376b = null;
                if (this.f6378d == null) {
                    this.f6379e = TreeBidiMap.this.m6968d(TreeBidiMap.this.f6343a[this.f6375a.ordinal()], this.f6375a);
                } else {
                    this.f6379e = TreeBidiMap.this.m6951b(this.f6378d, this.f6375a);
                }
            }
        }
    }

    /* renamed from: org.apache.commons.collections4.bidimap.TreeBidiMap$m */
    class C1859m extends TreeBidiMap<K, V>.C1337k implements OrderedMapIterator<K, V> {
        C1859m(C1847a aVar) {
            super(aVar);
        }

        /* renamed from: a */
        public K getKey() {
            if (this.f6376b != null) {
                return this.f6376b.getKey();
            }
            throw new IllegalStateException("Iterator getKey() can only be called after next() and before remove()");
        }

        /* renamed from: b */
        public V getValue() {
            if (this.f6376b != null) {
                return this.f6376b.getValue();
            }
            throw new IllegalStateException("Iterator getValue() can only be called after next() and before remove()");
        }

        /* renamed from: a */
        public V setValue(V v) {
            throw new UnsupportedOperationException();
        }

        /* renamed from: c */
        public K next() {
            return mo11416e().getKey();
        }

        /* renamed from: d */
        public K previous() {
            return mo11417f().getKey();
        }
    }

    /* renamed from: org.apache.commons.collections4.bidimap.TreeBidiMap$f */
    class C1852f extends TreeBidiMap<K, V>.C1337k implements OrderedMapIterator<V, K> {
        public C1852f(C1847a aVar) {
            super(aVar);
        }

        /* renamed from: a */
        public V getKey() {
            if (this.f6376b != null) {
                return this.f6376b.getValue();
            }
            throw new IllegalStateException("Iterator getKey() can only be called after next() and before remove()");
        }

        /* renamed from: b */
        public K getValue() {
            if (this.f6376b != null) {
                return this.f6376b.getKey();
            }
            throw new IllegalStateException("Iterator getValue() can only be called after next() and before remove()");
        }

        /* renamed from: a */
        public K setValue(K k) {
            throw new UnsupportedOperationException();
        }

        /* renamed from: c */
        public V next() {
            return mo11416e().getValue();
        }

        /* renamed from: d */
        public V previous() {
            return mo11417f().getValue();
        }
    }

    /* renamed from: org.apache.commons.collections4.bidimap.TreeBidiMap$l */
    class C1858l extends TreeBidiMap<K, V>.C1337k implements OrderedIterator<Map.Entry<K, V>> {
        C1858l() {
            super(C1847a.KEY);
        }

        /* renamed from: a */
        public Map.Entry<K, V> next() {
            return mo11416e();
        }

        /* renamed from: b */
        public Map.Entry<K, V> previous() {
            return mo11417f();
        }
    }

    /* renamed from: org.apache.commons.collections4.bidimap.TreeBidiMap$e */
    class C1851e extends TreeBidiMap<K, V>.C1337k implements OrderedIterator<Map.Entry<V, K>> {
        C1851e() {
            super(C1847a.VALUE);
        }

        /* renamed from: a */
        public Map.Entry<V, K> next() {
            return m6995a(mo11416e());
        }

        /* renamed from: b */
        public Map.Entry<V, K> previous() {
            return m6995a(mo11417f());
        }

        /* renamed from: a */
        private Map.Entry<V, K> m6995a(C1854h<K, V> hVar) {
            return new UnmodifiableMapEntry(hVar.getValue(), hVar.getKey());
        }
    }

    /* renamed from: org.apache.commons.collections4.bidimap.TreeBidiMap$h */
    static class C1854h<K extends Comparable<K>, V extends Comparable<V>> implements Map.Entry<K, V>, KeyValue<K, V> {

        /* renamed from: a */
        private final K f6364a;

        /* renamed from: b */
        private final V f6365b;

        /* renamed from: c */
        private final C1854h<K, V>[] f6366c = new C1854h[2];

        /* renamed from: d */
        private final C1854h<K, V>[] f6367d = new C1854h[2];

        /* renamed from: e */
        private final C1854h<K, V>[] f6368e = new C1854h[2];

        /* renamed from: f */
        private final boolean[] f6369f = {true, true};

        /* renamed from: g */
        private int f6370g;

        /* renamed from: h */
        private boolean f6371h = false;

        C1854h(K k, V v) {
            this.f6364a = k;
            this.f6365b = v;
        }

        /* access modifiers changed from: private */
        /* renamed from: a */
        public Object m7003a(C1847a aVar) {
            switch (aVar) {
                case KEY:
                    return getKey();
                case VALUE:
                    return getValue();
                default:
                    throw new IllegalArgumentException();
            }
        }

        /* access modifiers changed from: private */
        /* renamed from: k */
        public void m7028k(C1854h<K, V> hVar, C1847a aVar) {
            this.f6366c[aVar.ordinal()] = hVar;
        }

        /* access modifiers changed from: private */
        /* renamed from: b */
        public C1854h<K, V> m7006b(C1847a aVar) {
            return this.f6366c[aVar.ordinal()];
        }

        /* access modifiers changed from: private */
        /* renamed from: l */
        public void m7029l(C1854h<K, V> hVar, C1847a aVar) {
            this.f6367d[aVar.ordinal()] = hVar;
        }

        /* access modifiers changed from: private */
        /* renamed from: c */
        public C1854h<K, V> m7010c(C1847a aVar) {
            return this.f6367d[aVar.ordinal()];
        }

        /* access modifiers changed from: private */
        /* renamed from: m */
        public void m7030m(C1854h<K, V> hVar, C1847a aVar) {
            this.f6368e[aVar.ordinal()] = hVar;
        }

        /* access modifiers changed from: private */
        /* renamed from: d */
        public C1854h<K, V> m7012d(C1847a aVar) {
            return this.f6368e[aVar.ordinal()];
        }

        /* access modifiers changed from: private */
        /* renamed from: n */
        public void m7031n(C1854h<K, V> hVar, C1847a aVar) {
            boolean[] zArr = this.f6369f;
            int ordinal = aVar.ordinal();
            zArr[ordinal] = zArr[ordinal] ^ hVar.f6369f[aVar.ordinal()];
            boolean[] zArr2 = hVar.f6369f;
            int ordinal2 = aVar.ordinal();
            zArr2[ordinal2] = zArr2[ordinal2] ^ this.f6369f[aVar.ordinal()];
            boolean[] zArr3 = this.f6369f;
            int ordinal3 = aVar.ordinal();
            zArr3[ordinal3] = zArr3[ordinal3] ^ hVar.f6369f[aVar.ordinal()];
        }

        /* access modifiers changed from: private */
        /* renamed from: e */
        public boolean m7017e(C1847a aVar) {
            return this.f6369f[aVar.ordinal()];
        }

        /* access modifiers changed from: private */
        /* renamed from: f */
        public boolean m7018f(C1847a aVar) {
            return !this.f6369f[aVar.ordinal()];
        }

        /* access modifiers changed from: private */
        /* renamed from: g */
        public void m7020g(C1847a aVar) {
            this.f6369f[aVar.ordinal()] = true;
        }

        /* access modifiers changed from: private */
        /* renamed from: h */
        public void m7022h(C1847a aVar) {
            this.f6369f[aVar.ordinal()] = false;
        }

        /* access modifiers changed from: private */
        /* renamed from: o */
        public void m7032o(C1854h<K, V> hVar, C1847a aVar) {
            this.f6369f[aVar.ordinal()] = hVar.f6369f[aVar.ordinal()];
        }

        /* access modifiers changed from: private */
        /* renamed from: i */
        public boolean m7024i(C1847a aVar) {
            return this.f6368e[aVar.ordinal()] != null && this.f6368e[aVar.ordinal()].f6366c[aVar.ordinal()] == this;
        }

        /* access modifiers changed from: private */
        /* renamed from: j */
        public boolean m7026j(C1847a aVar) {
            return this.f6368e[aVar.ordinal()] != null && this.f6368e[aVar.ordinal()].f6367d[aVar.ordinal()] == this;
        }

        /* renamed from: a */
        public K getKey() {
            return this.f6364a;
        }

        /* renamed from: b */
        public V getValue() {
            return this.f6365b;
        }

        /* renamed from: a */
        public V setValue(V v) throws UnsupportedOperationException {
            throw new UnsupportedOperationException("Map.Entry.setValue is not supported");
        }

        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof Map.Entry)) {
                return false;
            }
            Map.Entry entry = (Map.Entry) obj;
            if (!getKey().equals(entry.getKey()) || !getValue().equals(entry.getValue())) {
                return false;
            }
            return true;
        }

        public int hashCode() {
            if (!this.f6371h) {
                this.f6370g = getKey().hashCode() ^ getValue().hashCode();
                this.f6371h = true;
            }
            return this.f6370g;
        }
    }

    /* renamed from: org.apache.commons.collections4.bidimap.TreeBidiMap$c */
    class C1849c implements OrderedBidiMap<V, K> {

        /* renamed from: b */
        private Set<V> f6357b;

        /* renamed from: c */
        private Set<K> f6358c;

        /* renamed from: d */
        private Set<Map.Entry<V, K>> f6359d;

        C1849c() {
        }

        public int size() {
            return TreeBidiMap.this.size();
        }

        public boolean isEmpty() {
            return TreeBidiMap.this.isEmpty();
        }

        /* renamed from: a */
        public K get(Object obj) {
            return TreeBidiMap.this.getKey(obj);
        }

        /* renamed from: b */
        public V getKey(Object obj) {
            return TreeBidiMap.this.get(obj);
        }

        public boolean containsKey(Object obj) {
            return TreeBidiMap.this.containsValue(obj);
        }

        public boolean containsValue(Object obj) {
            return TreeBidiMap.this.containsKey(obj);
        }

        /* renamed from: a */
        public V firstKey() {
            if (TreeBidiMap.this.f6344b != 0) {
                return TreeBidiMap.this.m6961c(TreeBidiMap.this.f6343a[C1847a.VALUE.ordinal()], C1847a.VALUE).getValue();
            }
            throw new NoSuchElementException("Map is empty");
        }

        /* renamed from: b */
        public V lastKey() {
            if (TreeBidiMap.this.f6344b != 0) {
                return TreeBidiMap.this.m6968d(TreeBidiMap.this.f6343a[C1847a.VALUE.ordinal()], C1847a.VALUE).getValue();
            }
            throw new NoSuchElementException("Map is empty");
        }

        /* renamed from: a */
        public V nextKey(V v) {
            TreeBidiMap.m6973f(v);
            C1854h b = TreeBidiMap.this.m6932a(TreeBidiMap.this.m6950b((Object) v, C1847a.VALUE), C1847a.VALUE);
            if (b == null) {
                return null;
            }
            return b.getValue();
        }

        /* renamed from: b */
        public V previousKey(V v) {
            TreeBidiMap.m6973f(v);
            C1854h c = TreeBidiMap.this.m6951b(TreeBidiMap.this.m6950b((Object) v, C1847a.VALUE), C1847a.VALUE);
            if (c == null) {
                return null;
            }
            return c.getValue();
        }

        /* renamed from: a */
        public K put(V v, K k) {
            K a = get((Object) v);
            TreeBidiMap.this.m6937a(k, v);
            return a;
        }

        public void putAll(Map<? extends V, ? extends K> map) {
            for (Map.Entry next : map.entrySet()) {
                put((Comparable) next.getKey(), (Comparable) next.getValue());
            }
        }

        /* renamed from: c */
        public K remove(Object obj) {
            return TreeBidiMap.this.removeValue(obj);
        }

        /* renamed from: d */
        public V removeValue(Object obj) {
            return TreeBidiMap.this.remove(obj);
        }

        public void clear() {
            TreeBidiMap.this.clear();
        }

        public Set<V> keySet() {
            if (this.f6357b == null) {
                this.f6357b = new C1855i(C1847a.VALUE);
            }
            return this.f6357b;
        }

        public Set<K> values() {
            if (this.f6358c == null) {
                this.f6358c = new C1853g(C1847a.VALUE);
            }
            return this.f6358c;
        }

        public Set<Map.Entry<V, K>> entrySet() {
            if (this.f6359d == null) {
                this.f6359d = new C1850d();
            }
            return this.f6359d;
        }

        public OrderedMapIterator<V, K> mapIterator() {
            if (isEmpty()) {
                return EmptyOrderedMapIterator.emptyOrderedMapIterator();
            }
            return new C1852f(C1847a.VALUE);
        }

        public OrderedBidiMap<K, V> inverseBidiMap() {
            return TreeBidiMap.this;
        }

        public boolean equals(Object obj) {
            return TreeBidiMap.this.m6970d(obj, C1847a.VALUE);
        }

        public int hashCode() {
            return TreeBidiMap.this.m6929a(C1847a.VALUE);
        }

        public String toString() {
            return TreeBidiMap.this.m6948b(C1847a.VALUE);
        }
    }
}
