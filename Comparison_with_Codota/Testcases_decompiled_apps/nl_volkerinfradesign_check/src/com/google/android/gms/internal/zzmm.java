package com.google.android.gms.internal;

import android.support.p001v4.util.ArrayMap;
import java.util.AbstractSet;
import java.util.Collection;
import java.util.Iterator;

public class zzmm<E> extends AbstractSet<E> {

    /* renamed from: a */
    private final ArrayMap<E, E> f3219a;

    public zzmm() {
        this.f3219a = new ArrayMap<>();
    }

    public zzmm(int i) {
        this.f3219a = new ArrayMap<>(i);
    }

    public zzmm(Collection<E> collection) {
        this(collection.size());
        addAll(collection);
    }

    public boolean add(E e) {
        if (this.f3219a.containsKey(e)) {
            return false;
        }
        this.f3219a.put(e, e);
        return true;
    }

    public boolean addAll(Collection<? extends E> collection) {
        return collection instanceof zzmm ? zza((zzmm) collection) : super.addAll(collection);
    }

    public void clear() {
        this.f3219a.clear();
    }

    public boolean contains(Object obj) {
        return this.f3219a.containsKey(obj);
    }

    public Iterator<E> iterator() {
        return this.f3219a.keySet().iterator();
    }

    public boolean remove(Object obj) {
        if (!this.f3219a.containsKey(obj)) {
            return false;
        }
        this.f3219a.remove(obj);
        return true;
    }

    public int size() {
        return this.f3219a.size();
    }

    public boolean zza(zzmm<? extends E> zzmm) {
        int size = size();
        this.f3219a.putAll(zzmm.f3219a);
        return size() > size;
    }
}
