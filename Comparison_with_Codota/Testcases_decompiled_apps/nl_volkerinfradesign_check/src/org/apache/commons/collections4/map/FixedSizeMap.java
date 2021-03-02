package org.apache.commons.collections4.map;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.Collection;
import java.util.Map;
import java.util.Set;
import org.apache.commons.collections4.BoundedMap;
import org.apache.commons.collections4.collection.UnmodifiableCollection;
import org.apache.commons.collections4.set.UnmodifiableSet;

public class FixedSizeMap<K, V> extends AbstractMapDecorator<K, V> implements Serializable, BoundedMap<K, V> {
    private static final long serialVersionUID = 7450927208116179316L;

    public static <K, V> FixedSizeMap<K, V> fixedSizeMap(Map<K, V> map) {
        return new FixedSizeMap<>(map);
    }

    protected FixedSizeMap(Map<K, V> map) {
        super(map);
    }

    private void writeObject(ObjectOutputStream objectOutputStream) throws IOException {
        objectOutputStream.defaultWriteObject();
        objectOutputStream.writeObject(this.f6624a);
    }

    private void readObject(ObjectInputStream objectInputStream) throws IOException, ClassNotFoundException {
        objectInputStream.defaultReadObject();
        this.f6624a = (Map) objectInputStream.readObject();
    }

    public V put(K k, V v) {
        if (this.f6624a.containsKey(k)) {
            return this.f6624a.put(k, v);
        }
        throw new IllegalArgumentException("Cannot put new key/value pair - Map is fixed size");
    }

    public void putAll(Map<? extends K, ? extends V> map) {
        for (Object containsKey : map.keySet()) {
            if (!containsKey(containsKey)) {
                throw new IllegalArgumentException("Cannot put new key/value pair - Map is fixed size");
            }
        }
        this.f6624a.putAll(map);
    }

    public void clear() {
        throw new UnsupportedOperationException("Map is fixed size");
    }

    public V remove(Object obj) {
        throw new UnsupportedOperationException("Map is fixed size");
    }

    public Set<Map.Entry<K, V>> entrySet() {
        return UnmodifiableSet.unmodifiableSet(this.f6624a.entrySet());
    }

    public Set<K> keySet() {
        return UnmodifiableSet.unmodifiableSet(this.f6624a.keySet());
    }

    public Collection<V> values() {
        return UnmodifiableCollection.unmodifiableCollection(this.f6624a.values());
    }

    public boolean isFull() {
        return true;
    }

    public int maxSize() {
        return size();
    }
}
