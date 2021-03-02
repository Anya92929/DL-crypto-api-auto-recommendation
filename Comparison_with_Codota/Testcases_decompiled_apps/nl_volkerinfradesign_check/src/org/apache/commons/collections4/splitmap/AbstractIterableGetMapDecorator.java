package org.apache.commons.collections4.splitmap;

import java.util.Collection;
import java.util.Map;
import java.util.Set;
import org.apache.commons.collections4.IterableGet;
import org.apache.commons.collections4.MapIterator;
import org.apache.commons.collections4.map.EntrySetToMapIteratorAdapter;

public class AbstractIterableGetMapDecorator<K, V> implements IterableGet<K, V> {

    /* renamed from: a */
    transient Map<K, V> f6762a;

    public AbstractIterableGetMapDecorator(Map<K, V> map) {
        this.f6762a = map;
    }

    protected AbstractIterableGetMapDecorator() {
    }

    /* access modifiers changed from: protected */
    public Map<K, V> decorated() {
        return this.f6762a;
    }

    public boolean containsKey(Object obj) {
        return decorated().containsKey(obj);
    }

    public boolean containsValue(Object obj) {
        return decorated().containsValue(obj);
    }

    public Set<Map.Entry<K, V>> entrySet() {
        return decorated().entrySet();
    }

    public V get(Object obj) {
        return decorated().get(obj);
    }

    public V remove(Object obj) {
        return decorated().remove(obj);
    }

    public boolean isEmpty() {
        return decorated().isEmpty();
    }

    public Set<K> keySet() {
        return decorated().keySet();
    }

    public int size() {
        return decorated().size();
    }

    public Collection<V> values() {
        return decorated().values();
    }

    public MapIterator<K, V> mapIterator() {
        return new EntrySetToMapIteratorAdapter(entrySet());
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        return decorated().equals(obj);
    }

    public int hashCode() {
        return decorated().hashCode();
    }

    public String toString() {
        return decorated().toString();
    }
}
