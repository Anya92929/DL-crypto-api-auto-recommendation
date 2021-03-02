package com.google.android.gms.p018c;

import java.lang.reflect.Array;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

/* renamed from: com.google.android.gms.c.u */
abstract class C0679u<K, V> {

    /* renamed from: b */
    C0679u<K, V>.C0681w f4383b;

    /* renamed from: c */
    C0679u<K, V>.C0682x f4384c;

    /* renamed from: d */
    C0679u<K, V>.C0684z f4385d;

    C0679u() {
    }

    /* renamed from: a */
    public static <K, V> boolean m3920a(Map<K, V> map, Collection<?> collection) {
        for (Object containsKey : collection) {
            if (!map.containsKey(containsKey)) {
                return false;
            }
        }
        return true;
    }

    /* renamed from: a */
    public static <T> boolean m3921a(Set<T> set, Object obj) {
        boolean z = true;
        if (set == obj) {
            return true;
        }
        if (!(obj instanceof Set)) {
            return false;
        }
        Set set2 = (Set) obj;
        try {
            if (set.size() != set2.size() || !set.containsAll(set2)) {
                z = false;
            }
            return z;
        } catch (ClassCastException | NullPointerException e) {
            return false;
        }
    }

    /* renamed from: b */
    public static <K, V> boolean m3922b(Map<K, V> map, Collection<?> collection) {
        int size = map.size();
        for (Object remove : collection) {
            map.remove(remove);
        }
        return size != map.size();
    }

    /* renamed from: c */
    public static <K, V> boolean m3923c(Map<K, V> map, Collection<?> collection) {
        int size = map.size();
        Iterator<K> it = map.keySet().iterator();
        while (it.hasNext()) {
            if (!collection.contains(it.next())) {
                it.remove();
            }
        }
        return size != map.size();
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public abstract int mo7250a();

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public abstract int mo7251a(Object obj);

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public abstract Object mo7252a(int i, int i2);

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public abstract V mo7253a(int i, V v);

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public abstract void mo7254a(int i);

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public abstract void mo7255a(K k, V v);

    /* renamed from: a */
    public <T> T[] mo7259a(T[] tArr, int i) {
        int a = mo7250a();
        T[] tArr2 = tArr.length < a ? (Object[]) Array.newInstance(tArr.getClass().getComponentType(), a) : tArr;
        for (int i2 = 0; i2 < a; i2++) {
            tArr2[i2] = mo7252a(i2, i);
        }
        if (tArr2.length > a) {
            tArr2[a] = null;
        }
        return tArr2;
    }

    /* access modifiers changed from: protected */
    /* renamed from: b */
    public abstract int mo7256b(Object obj);

    /* access modifiers changed from: protected */
    /* renamed from: b */
    public abstract Map<K, V> mo7257b();

    /* renamed from: b */
    public Object[] mo7260b(int i) {
        int a = mo7250a();
        Object[] objArr = new Object[a];
        for (int i2 = 0; i2 < a; i2++) {
            objArr[i2] = mo7252a(i2, i);
        }
        return objArr;
    }

    /* access modifiers changed from: protected */
    /* renamed from: c */
    public abstract void mo7258c();

    /* renamed from: d */
    public Set<Map.Entry<K, V>> mo7261d() {
        if (this.f4383b == null) {
            this.f4383b = new C0681w(this);
        }
        return this.f4383b;
    }

    /* renamed from: e */
    public Set<K> mo7262e() {
        if (this.f4384c == null) {
            this.f4384c = new C0682x(this);
        }
        return this.f4384c;
    }

    /* renamed from: f */
    public Collection<V> mo7263f() {
        if (this.f4385d == null) {
            this.f4385d = new C0684z(this);
        }
        return this.f4385d;
    }
}
