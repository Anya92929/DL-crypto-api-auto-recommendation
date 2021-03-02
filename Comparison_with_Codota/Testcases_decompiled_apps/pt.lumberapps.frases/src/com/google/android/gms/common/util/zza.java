package com.google.android.gms.common.util;

import android.support.p009v4.p019f.C0136a;
import android.support.p009v4.p019f.C0150o;
import java.util.AbstractSet;
import java.util.Collection;
import java.util.Iterator;

public class zza extends AbstractSet {

    /* renamed from: a */
    private final C0136a f4724a;

    public zza() {
        this.f4724a = new C0136a();
    }

    public zza(int i) {
        this.f4724a = new C0136a(i);
    }

    public zza(Collection collection) {
        this(collection.size());
        addAll(collection);
    }

    public boolean add(Object obj) {
        if (this.f4724a.containsKey(obj)) {
            return false;
        }
        this.f4724a.put(obj, obj);
        return true;
    }

    public boolean addAll(Collection collection) {
        return collection instanceof zza ? zza((zza) collection) : super.addAll(collection);
    }

    public void clear() {
        this.f4724a.clear();
    }

    public boolean contains(Object obj) {
        return this.f4724a.containsKey(obj);
    }

    public Iterator iterator() {
        return this.f4724a.keySet().iterator();
    }

    public boolean remove(Object obj) {
        if (!this.f4724a.containsKey(obj)) {
            return false;
        }
        this.f4724a.remove(obj);
        return true;
    }

    public int size() {
        return this.f4724a.size();
    }

    public boolean zza(zza zza) {
        int size = size();
        this.f4724a.mo1150a((C0150o) zza.f4724a);
        return size() > size;
    }
}
