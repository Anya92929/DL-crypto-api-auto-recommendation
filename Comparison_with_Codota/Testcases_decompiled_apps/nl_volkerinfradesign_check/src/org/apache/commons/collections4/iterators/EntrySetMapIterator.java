package org.apache.commons.collections4.iterators;

import java.util.Iterator;
import java.util.Map;
import org.apache.commons.collections4.MapIterator;
import org.apache.commons.collections4.ResettableIterator;

public class EntrySetMapIterator<K, V> implements MapIterator<K, V>, ResettableIterator<K> {

    /* renamed from: a */
    private final Map<K, V> f6482a;

    /* renamed from: b */
    private Iterator<Map.Entry<K, V>> f6483b;

    /* renamed from: c */
    private Map.Entry<K, V> f6484c;

    /* renamed from: d */
    private boolean f6485d = false;

    public EntrySetMapIterator(Map<K, V> map) {
        this.f6482a = map;
        this.f6483b = map.entrySet().iterator();
    }

    public boolean hasNext() {
        return this.f6483b.hasNext();
    }

    public K next() {
        this.f6484c = this.f6483b.next();
        this.f6485d = true;
        return this.f6484c.getKey();
    }

    public void remove() {
        if (!this.f6485d) {
            throw new IllegalStateException("Iterator remove() can only be called once after next()");
        }
        this.f6483b.remove();
        this.f6484c = null;
        this.f6485d = false;
    }

    public K getKey() {
        if (this.f6484c != null) {
            return this.f6484c.getKey();
        }
        throw new IllegalStateException("Iterator getKey() can only be called after next() and before remove()");
    }

    public V getValue() {
        if (this.f6484c != null) {
            return this.f6484c.getValue();
        }
        throw new IllegalStateException("Iterator getValue() can only be called after next() and before remove()");
    }

    public V setValue(V v) {
        if (this.f6484c != null) {
            return this.f6484c.setValue(v);
        }
        throw new IllegalStateException("Iterator setValue() can only be called after next() and before remove()");
    }

    public void reset() {
        this.f6483b = this.f6482a.entrySet().iterator();
        this.f6484c = null;
        this.f6485d = false;
    }

    public String toString() {
        if (this.f6484c != null) {
            return "MapIterator[" + getKey() + "=" + getValue() + "]";
        }
        return "MapIterator[]";
    }
}
