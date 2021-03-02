package org.apache.commons.collections4.map;

import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import org.apache.commons.collections4.MapIterator;
import org.apache.commons.collections4.ResettableIterator;

public class EntrySetToMapIteratorAdapter<K, V> implements MapIterator<K, V>, ResettableIterator<K> {

    /* renamed from: a */
    Set<Map.Entry<K, V>> f6645a;

    /* renamed from: b */
    transient Iterator<Map.Entry<K, V>> f6646b;

    /* renamed from: c */
    transient Map.Entry<K, V> f6647c;

    public EntrySetToMapIteratorAdapter(Set<Map.Entry<K, V>> set) {
        this.f6645a = set;
        reset();
    }

    public K getKey() {
        return current().getKey();
    }

    public V getValue() {
        return current().getValue();
    }

    public V setValue(V v) {
        return current().setValue(v);
    }

    public boolean hasNext() {
        return this.f6646b.hasNext();
    }

    public K next() {
        this.f6647c = this.f6646b.next();
        return getKey();
    }

    public synchronized void reset() {
        this.f6646b = this.f6645a.iterator();
    }

    public void remove() {
        this.f6646b.remove();
        this.f6647c = null;
    }

    /* access modifiers changed from: protected */
    public synchronized Map.Entry<K, V> current() {
        if (this.f6647c == null) {
            throw new IllegalStateException();
        }
        return this.f6647c;
    }
}
