package org.apache.commons.collections4.map;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.Map;
import java.util.Set;
import org.apache.commons.collections4.Transformer;

public class TransformedMap<K, V> extends C1322jl<K, V> implements Serializable {
    private static final long serialVersionUID = 7023152376788900464L;
    protected final Transformer<? super K, ? extends K> keyTransformer;
    protected final Transformer<? super V, ? extends V> valueTransformer;

    public /* bridge */ /* synthetic */ Set entrySet() {
        return super.entrySet();
    }

    public static <K, V> TransformedMap<K, V> transformingMap(Map<K, V> map, Transformer<? super K, ? extends K> transformer, Transformer<? super V, ? extends V> transformer2) {
        return new TransformedMap<>(map, transformer, transformer2);
    }

    public static <K, V> TransformedMap<K, V> transformedMap(Map<K, V> map, Transformer<? super K, ? extends K> transformer, Transformer<? super V, ? extends V> transformer2) {
        TransformedMap<K, V> transformedMap = new TransformedMap<>(map, transformer, transformer2);
        if (map.size() > 0) {
            Map<K, V> transformMap = transformedMap.transformMap(map);
            transformedMap.clear();
            transformedMap.decorated().putAll(transformMap);
        }
        return transformedMap;
    }

    protected TransformedMap(Map<K, V> map, Transformer<? super K, ? extends K> transformer, Transformer<? super V, ? extends V> transformer2) {
        super(map);
        this.keyTransformer = transformer;
        this.valueTransformer = transformer2;
    }

    private void writeObject(ObjectOutputStream objectOutputStream) throws IOException {
        objectOutputStream.defaultWriteObject();
        objectOutputStream.writeObject(this.f6624a);
    }

    private void readObject(ObjectInputStream objectInputStream) throws IOException, ClassNotFoundException {
        objectInputStream.defaultReadObject();
        this.f6624a = (Map) objectInputStream.readObject();
    }

    /* access modifiers changed from: protected */
    public K transformKey(K k) {
        return this.keyTransformer == null ? k : this.keyTransformer.transform(k);
    }

    /* access modifiers changed from: protected */
    public V transformValue(V v) {
        return this.valueTransformer == null ? v : this.valueTransformer.transform(v);
    }

    /* access modifiers changed from: protected */
    public Map<K, V> transformMap(Map<? extends K, ? extends V> map) {
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
    public V checkSetValue(V v) {
        return this.valueTransformer.transform(v);
    }

    /* access modifiers changed from: protected */
    public boolean isSetValueChecking() {
        return this.valueTransformer != null;
    }

    public V put(K k, V v) {
        return decorated().put(transformKey(k), transformValue(v));
    }

    public void putAll(Map<? extends K, ? extends V> map) {
        decorated().putAll(transformMap(map));
    }
}
