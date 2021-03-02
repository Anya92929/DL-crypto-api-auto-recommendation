package com.google.android.gms.tagmanager;

import android.util.LruCache;
import com.google.android.gms.tagmanager.C2128l;

/* renamed from: com.google.android.gms.tagmanager.bb */
class C2020bb<K, V> implements C2127k<K, V> {
    private LruCache<K, V> apx;

    C2020bb(int i, final C2128l.C2130a<K, V> aVar) {
        this.apx = new LruCache<K, V>(i) {
            /* access modifiers changed from: protected */
            public int sizeOf(K key, V value) {
                return aVar.sizeOf(key, value);
            }
        };
    }

    /* renamed from: e */
    public void mo11569e(K k, V v) {
        this.apx.put(k, v);
    }

    public V get(K key) {
        return this.apx.get(key);
    }
}
