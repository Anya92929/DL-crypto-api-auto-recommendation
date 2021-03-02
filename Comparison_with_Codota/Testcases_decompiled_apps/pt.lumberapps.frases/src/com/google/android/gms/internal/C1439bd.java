package com.google.android.gms.internal;

import java.util.AbstractSet;
import java.util.Iterator;

/* renamed from: com.google.android.gms.internal.bd */
final class C1439bd extends AbstractSet {

    /* renamed from: a */
    final /* synthetic */ zzant f4869a;

    C1439bd(zzant zzant) {
        this.f4869a = zzant;
    }

    public void clear() {
        this.f4869a.clear();
    }

    public boolean contains(Object obj) {
        return this.f4869a.containsKey(obj);
    }

    public Iterator iterator() {
        return new C1440be(this);
    }

    public boolean remove(Object obj) {
        return this.f4869a.mo7889b(obj) != null;
    }

    public int size() {
        return this.f4869a.f5807c;
    }
}
