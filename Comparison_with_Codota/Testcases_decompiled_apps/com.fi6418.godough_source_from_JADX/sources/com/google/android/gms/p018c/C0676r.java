package com.google.android.gms.p018c;

import java.util.Collection;
import java.util.Map;
import java.util.Set;

/* renamed from: com.google.android.gms.c.r */
public class C0676r<K, V> extends C0612aa<K, V> implements Map<K, V> {

    /* renamed from: a */
    C0679u<K, V> f4378a;

    /* renamed from: b */
    private C0679u<K, V> m3908b() {
        if (this.f4378a == null) {
            this.f4378a = new C0677s(this);
        }
        return this.f4378a;
    }

    public Set<Map.Entry<K, V>> entrySet() {
        return m3908b().mo7261d();
    }

    public Set<K> keySet() {
        return m3908b().mo7262e();
    }

    public void putAll(Map<? extends K, ? extends V> map) {
        mo6975a(this.f4216h + map.size());
        for (Map.Entry next : map.entrySet()) {
            put(next.getKey(), next.getValue());
        }
    }

    public Collection<V> values() {
        return m3908b().mo7263f();
    }
}
