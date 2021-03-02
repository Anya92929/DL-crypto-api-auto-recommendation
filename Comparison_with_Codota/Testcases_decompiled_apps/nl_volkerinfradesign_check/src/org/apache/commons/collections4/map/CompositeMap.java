package org.apache.commons.collections4.map;

import java.io.Serializable;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.collections4.collection.CompositeCollection;
import org.apache.commons.collections4.set.CompositeSet;

public class CompositeMap<K, V> extends AbstractIterableMap<K, V> implements Serializable {
    private static final long serialVersionUID = -6096931280583808322L;

    /* renamed from: a */
    private Map<K, V>[] f6642a;

    /* renamed from: b */
    private MapMutator<K, V> f6643b;

    public interface MapMutator<K, V> extends Serializable {
        V put(CompositeMap<K, V> compositeMap, Map<K, V>[] mapArr, K k, V v);

        void putAll(CompositeMap<K, V> compositeMap, Map<K, V>[] mapArr, Map<? extends K, ? extends V> map);

        void resolveCollision(CompositeMap<K, V> compositeMap, Map<K, V> map, Map<K, V> map2, Collection<K> collection);
    }

    public CompositeMap() {
        this((Map<K, V>[]) new Map[0], (MapMutator) null);
    }

    public CompositeMap(Map<K, V> map, Map<K, V> map2) {
        this((Map<K, V>[]) new Map[]{map, map2}, (MapMutator) null);
    }

    public CompositeMap(Map<K, V> map, Map<K, V> map2, MapMutator<K, V> mapMutator) {
        this((Map<K, V>[]) new Map[]{map, map2}, mapMutator);
    }

    public CompositeMap(Map<K, V>... mapArr) {
        this(mapArr, (MapMutator) null);
    }

    public CompositeMap(Map<K, V>[] mapArr, MapMutator<K, V> mapMutator) {
        this.f6643b = mapMutator;
        this.f6642a = new Map[0];
        for (int length = mapArr.length - 1; length >= 0; length--) {
            addComposited(mapArr[length]);
        }
    }

    public void setMutator(MapMutator<K, V> mapMutator) {
        this.f6643b = mapMutator;
    }

    public synchronized void addComposited(Map<K, V> map) throws IllegalArgumentException {
        for (int length = this.f6642a.length - 1; length >= 0; length--) {
            Collection<O> intersection = CollectionUtils.intersection(this.f6642a[length].keySet(), map.keySet());
            if (intersection.size() != 0) {
                if (this.f6643b == null) {
                    throw new IllegalArgumentException("Key collision adding Map to CompositeMap");
                }
                this.f6643b.resolveCollision(this, this.f6642a[length], map, intersection);
            }
        }
        Map<K, V>[] mapArr = new Map[(this.f6642a.length + 1)];
        System.arraycopy(this.f6642a, 0, mapArr, 0, this.f6642a.length);
        mapArr[mapArr.length - 1] = map;
        this.f6642a = mapArr;
    }

    public synchronized Map<K, V> removeComposited(Map<K, V> map) {
        int i = 0;
        synchronized (this) {
            int length = this.f6642a.length;
            while (true) {
                if (i >= length) {
                    map = null;
                    break;
                } else if (this.f6642a[i].equals(map)) {
                    Map<K, V>[] mapArr = new Map[(length - 1)];
                    System.arraycopy(this.f6642a, 0, mapArr, 0, i);
                    System.arraycopy(this.f6642a, i + 1, mapArr, i, (length - i) - 1);
                    this.f6642a = mapArr;
                    break;
                } else {
                    i++;
                }
            }
        }
        return map;
    }

    public void clear() {
        for (int length = this.f6642a.length - 1; length >= 0; length--) {
            this.f6642a[length].clear();
        }
    }

    public boolean containsKey(Object obj) {
        for (int length = this.f6642a.length - 1; length >= 0; length--) {
            if (this.f6642a[length].containsKey(obj)) {
                return true;
            }
        }
        return false;
    }

    public boolean containsValue(Object obj) {
        for (int length = this.f6642a.length - 1; length >= 0; length--) {
            if (this.f6642a[length].containsValue(obj)) {
                return true;
            }
        }
        return false;
    }

    public Set<Map.Entry<K, V>> entrySet() {
        CompositeSet compositeSet = new CompositeSet();
        for (int length = this.f6642a.length - 1; length >= 0; length--) {
            compositeSet.addComposited(this.f6642a[length].entrySet());
        }
        return compositeSet;
    }

    public V get(Object obj) {
        for (int length = this.f6642a.length - 1; length >= 0; length--) {
            if (this.f6642a[length].containsKey(obj)) {
                return this.f6642a[length].get(obj);
            }
        }
        return null;
    }

    public boolean isEmpty() {
        for (int length = this.f6642a.length - 1; length >= 0; length--) {
            if (!this.f6642a[length].isEmpty()) {
                return false;
            }
        }
        return true;
    }

    public Set<K> keySet() {
        CompositeSet compositeSet = new CompositeSet();
        for (int length = this.f6642a.length - 1; length >= 0; length--) {
            compositeSet.addComposited(this.f6642a[length].keySet());
        }
        return compositeSet;
    }

    public V put(K k, V v) {
        if (this.f6643b != null) {
            return this.f6643b.put(this, this.f6642a, k, v);
        }
        throw new UnsupportedOperationException("No mutator specified");
    }

    public void putAll(Map<? extends K, ? extends V> map) {
        if (this.f6643b == null) {
            throw new UnsupportedOperationException("No mutator specified");
        }
        this.f6643b.putAll(this, this.f6642a, map);
    }

    public V remove(Object obj) {
        for (int length = this.f6642a.length - 1; length >= 0; length--) {
            if (this.f6642a[length].containsKey(obj)) {
                return this.f6642a[length].remove(obj);
            }
        }
        return null;
    }

    public int size() {
        int i = 0;
        for (int length = this.f6642a.length - 1; length >= 0; length--) {
            i += this.f6642a[length].size();
        }
        return i;
    }

    public Collection<V> values() {
        CompositeCollection compositeCollection = new CompositeCollection();
        for (int length = this.f6642a.length - 1; length >= 0; length--) {
            compositeCollection.addComposited(this.f6642a[length].values());
        }
        return compositeCollection;
    }

    public boolean equals(Object obj) {
        if (obj instanceof Map) {
            return entrySet().equals(((Map) obj).entrySet());
        }
        return false;
    }

    public int hashCode() {
        int i = 0;
        Iterator it = entrySet().iterator();
        while (true) {
            int i2 = i;
            if (!it.hasNext()) {
                return i2;
            }
            i = ((Map.Entry) it.next()).hashCode() + i2;
        }
    }
}
