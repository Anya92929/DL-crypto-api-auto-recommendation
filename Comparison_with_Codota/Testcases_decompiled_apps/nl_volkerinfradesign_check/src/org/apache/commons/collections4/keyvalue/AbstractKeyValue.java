package org.apache.commons.collections4.keyvalue;

import org.apache.commons.collections4.KeyValue;

public abstract class AbstractKeyValue<K, V> implements KeyValue<K, V> {

    /* renamed from: a */
    private K f6562a;

    /* renamed from: b */
    private V f6563b;

    protected AbstractKeyValue(K k, V v) {
        this.f6562a = k;
        this.f6563b = v;
    }

    public K getKey() {
        return this.f6562a;
    }

    /* access modifiers changed from: protected */
    public K setKey(K k) {
        K k2 = this.f6562a;
        this.f6562a = k;
        return k2;
    }

    public V getValue() {
        return this.f6563b;
    }

    public V setValue(V v) {
        V v2 = this.f6563b;
        this.f6563b = v;
        return v2;
    }

    public String toString() {
        return new StringBuilder().append(getKey()).append('=').append(getValue()).toString();
    }
}
