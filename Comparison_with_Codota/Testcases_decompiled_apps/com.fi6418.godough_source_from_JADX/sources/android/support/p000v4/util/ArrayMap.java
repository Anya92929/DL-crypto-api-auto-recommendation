package android.support.p000v4.util;

import java.util.Collection;
import java.util.Map;
import java.util.Set;

/* renamed from: android.support.v4.util.ArrayMap */
public class ArrayMap<K, V> extends SimpleArrayMap<K, V> implements Map<K, V> {

    /* renamed from: a */
    MapCollections<K, V> f1082a;

    public ArrayMap() {
    }

    public ArrayMap(int i) {
        super(i);
    }

    public ArrayMap(SimpleArrayMap simpleArrayMap) {
        super(simpleArrayMap);
    }

    /* renamed from: b */
    private MapCollections<K, V> m805b() {
        if (this.f1082a == null) {
            this.f1082a = new MapCollections<K, V>() {
                /* access modifiers changed from: protected */
                /* renamed from: a */
                public int mo1917a() {
                    return ArrayMap.this.f1136h;
                }

                /* access modifiers changed from: protected */
                /* renamed from: a */
                public int mo1918a(Object obj) {
                    return ArrayMap.this.indexOfKey(obj);
                }

                /* access modifiers changed from: protected */
                /* renamed from: a */
                public Object mo1919a(int i, int i2) {
                    return ArrayMap.this.f1135g[(i << 1) + i2];
                }

                /* access modifiers changed from: protected */
                /* renamed from: a */
                public V mo1920a(int i, V v) {
                    return ArrayMap.this.setValueAt(i, v);
                }

                /* access modifiers changed from: protected */
                /* renamed from: a */
                public void mo1921a(int i) {
                    ArrayMap.this.removeAt(i);
                }

                /* access modifiers changed from: protected */
                /* renamed from: a */
                public void mo1922a(K k, V v) {
                    ArrayMap.this.put(k, v);
                }

                /* access modifiers changed from: protected */
                /* renamed from: b */
                public int mo1923b(Object obj) {
                    return ArrayMap.this.mo2060a(obj);
                }

                /* access modifiers changed from: protected */
                /* renamed from: b */
                public Map<K, V> mo1924b() {
                    return ArrayMap.this;
                }

                /* access modifiers changed from: protected */
                /* renamed from: c */
                public void mo1925c() {
                    ArrayMap.this.clear();
                }
            };
        }
        return this.f1082a;
    }

    public boolean containsAll(Collection<?> collection) {
        return MapCollections.containsAllHelper(this, collection);
    }

    public Set<Map.Entry<K, V>> entrySet() {
        return m805b().getEntrySet();
    }

    public Set<K> keySet() {
        return m805b().getKeySet();
    }

    public void putAll(Map<? extends K, ? extends V> map) {
        ensureCapacity(this.f1136h + map.size());
        for (Map.Entry next : map.entrySet()) {
            put(next.getKey(), next.getValue());
        }
    }

    public boolean removeAll(Collection<?> collection) {
        return MapCollections.removeAllHelper(this, collection);
    }

    public boolean retainAll(Collection<?> collection) {
        return MapCollections.retainAllHelper(this, collection);
    }

    public Collection<V> values() {
        return m805b().getValues();
    }
}
