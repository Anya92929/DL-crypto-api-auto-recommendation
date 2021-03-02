package org.apache.commons.collections4.splitmap;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.Map;
import org.apache.commons.collections4.Put;
import org.apache.commons.collections4.Transformer;
import org.apache.commons.collections4.map.LinkedMap;

public class TransformedSplitMap<J, K, U, V> extends AbstractIterableGetMapDecorator<K, V> implements Serializable, Put<J, U> {
    private static final long serialVersionUID = 5966875321133456994L;

    /* renamed from: b */
    private final Transformer<? super J, ? extends K> f6763b;

    /* renamed from: c */
    private final Transformer<? super U, ? extends V> f6764c;

    public static <J, K, U, V> TransformedSplitMap<J, K, U, V> transformingMap(Map<K, V> map, Transformer<? super J, ? extends K> transformer, Transformer<? super U, ? extends V> transformer2) {
        return new TransformedSplitMap<>(map, transformer, transformer2);
    }

    protected TransformedSplitMap(Map<K, V> map, Transformer<? super J, ? extends K> transformer, Transformer<? super U, ? extends V> transformer2) {
        super(map);
        if (transformer == null) {
            throw new IllegalArgumentException("keyTransformer cannot be null");
        }
        this.f6763b = transformer;
        if (transformer2 == null) {
            throw new IllegalArgumentException("valueTransformer cannot be null");
        }
        this.f6764c = transformer2;
    }

    private void writeObject(ObjectOutputStream objectOutputStream) throws IOException {
        objectOutputStream.defaultWriteObject();
        objectOutputStream.writeObject(decorated());
    }

    private void readObject(ObjectInputStream objectInputStream) throws IOException, ClassNotFoundException {
        objectInputStream.defaultReadObject();
        this.f6762a = (Map) objectInputStream.readObject();
    }

    /* access modifiers changed from: protected */
    public K transformKey(J j) {
        return this.f6763b.transform(j);
    }

    /* access modifiers changed from: protected */
    public V transformValue(U u) {
        return this.f6764c.transform(u);
    }

    /* access modifiers changed from: protected */
    public Map<K, V> transformMap(Map<? extends J, ? extends U> map) {
        if (map.isEmpty()) {
            return map;
        }
        LinkedMap linkedMap = new LinkedMap(map.size());
        for (Map.Entry next : map.entrySet()) {
            linkedMap.put(transformKey(next.getKey()), transformValue(next.getValue()));
        }
        return linkedMap;
    }

    /* access modifiers changed from: protected */
    public V checkSetValue(U u) {
        return this.f6764c.transform(u);
    }

    public V put(J j, U u) {
        return decorated().put(transformKey(j), transformValue(u));
    }

    public void putAll(Map<? extends J, ? extends U> map) {
        decorated().putAll(transformMap(map));
    }

    public void clear() {
        decorated().clear();
    }
}
