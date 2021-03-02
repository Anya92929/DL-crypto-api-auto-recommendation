package com.google.android.gms.internal;

import java.util.AbstractSet;
import java.util.Iterator;
import java.util.Map;

/* renamed from: com.google.android.gms.internal.bb */
class C1437bb extends AbstractSet {

    /* renamed from: a */
    final /* synthetic */ zzant f4867a;

    C1437bb(zzant zzant) {
        this.f4867a = zzant;
    }

    public void clear() {
        this.f4867a.clear();
    }

    public boolean contains(Object obj) {
        return (obj instanceof Map.Entry) && this.f4867a.mo7887a((Map.Entry) obj) != null;
    }

    public Iterator iterator() {
        return new C1438bc(this);
    }

    public boolean remove(Object obj) {
        C1442bg a;
        if (!(obj instanceof Map.Entry) || (a = this.f4867a.mo7887a((Map.Entry) obj)) == null) {
            return false;
        }
        this.f4867a.mo7888a(a, true);
        return true;
    }

    public int size() {
        return this.f4867a.f5807c;
    }
}
