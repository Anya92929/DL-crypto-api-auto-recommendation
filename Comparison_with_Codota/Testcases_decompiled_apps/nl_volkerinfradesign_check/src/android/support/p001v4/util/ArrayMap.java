package android.support.p001v4.util;

import java.util.Collection;
import java.util.Map;
import java.util.Set;

/* renamed from: android.support.v4.util.ArrayMap */
public class ArrayMap<K, V> extends SimpleArrayMap<K, V> implements Map<K, V> {

    /* renamed from: a */
    C1019cr<K, V> f845a;

    public ArrayMap() {
    }

    public ArrayMap(int i) {
        super(i);
    }

    public ArrayMap(SimpleArrayMap simpleArrayMap) {
        super(simpleArrayMap);
    }

    /* renamed from: b */
    private C1019cr<K, V> m972b() {
        if (this.f845a == null) {
            this.f845a = new C1019cr<K, V>() {
                /* access modifiers changed from: protected */
                /* renamed from: a */
                public int mo1561a() {
                    return ArrayMap.this.f881h;
                }

                /* access modifiers changed from: protected */
                /* renamed from: a */
                public Object mo1563a(int i, int i2) {
                    return ArrayMap.this.f880g[(i << 1) + i2];
                }

                /* access modifiers changed from: protected */
                /* renamed from: a */
                public int mo1562a(Object obj) {
                    return ArrayMap.this.indexOfKey(obj);
                }

                /* access modifiers changed from: protected */
                /* renamed from: b */
                public int mo1567b(Object obj) {
                    return ArrayMap.this.mo1643a(obj);
                }

                /* access modifiers changed from: protected */
                /* renamed from: b */
                public Map<K, V> mo1568b() {
                    return ArrayMap.this;
                }

                /* access modifiers changed from: protected */
                /* renamed from: a */
                public void mo1566a(K k, V v) {
                    ArrayMap.this.put(k, v);
                }

                /* access modifiers changed from: protected */
                /* renamed from: a */
                public V mo1564a(int i, V v) {
                    return ArrayMap.this.setValueAt(i, v);
                }

                /* access modifiers changed from: protected */
                /* renamed from: a */
                public void mo1565a(int i) {
                    ArrayMap.this.removeAt(i);
                }

                /* access modifiers changed from: protected */
                /* renamed from: c */
                public void mo1569c() {
                    ArrayMap.this.clear();
                }
            };
        }
        return this.f845a;
    }

    public boolean containsAll(Collection<?> collection) {
        return C1019cr.m4574a(this, collection);
    }

    public void putAll(Map<? extends K, ? extends V> map) {
        ensureCapacity(this.f881h + map.size());
        for (Map.Entry next : map.entrySet()) {
            put(next.getKey(), next.getValue());
        }
    }

    public boolean removeAll(Collection<?> collection) {
        return C1019cr.m4576b(this, collection);
    }

    public boolean retainAll(Collection<?> collection) {
        return C1019cr.m4577c(this, collection);
    }

    public Set<Map.Entry<K, V>> entrySet() {
        return m972b().mo8016d();
    }

    public Set<K> keySet() {
        return m972b().mo8017e();
    }

    public Collection<V> values() {
        return m972b().mo8018f();
    }
}
