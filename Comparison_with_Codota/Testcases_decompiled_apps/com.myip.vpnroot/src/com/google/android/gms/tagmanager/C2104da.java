package com.google.android.gms.tagmanager;

import com.google.android.gms.tagmanager.C2128l;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/* renamed from: com.google.android.gms.tagmanager.da */
class C2104da<K, V> implements C2127k<K, V> {
    private final Map<K, V> ars = new HashMap();
    private final int art;
    private final C2128l.C2130a<K, V> aru;
    private int arv;

    C2104da(int i, C2128l.C2130a<K, V> aVar) {
        this.art = i;
        this.aru = aVar;
    }

    /* renamed from: e */
    public synchronized void mo11569e(K k, V v) {
        if (k == null || v == null) {
            throw new NullPointerException("key == null || value == null");
        }
        this.arv += this.aru.sizeOf(k, v);
        if (this.arv > this.art) {
            Iterator<Map.Entry<K, V>> it = this.ars.entrySet().iterator();
            while (it.hasNext()) {
                Map.Entry next = it.next();
                this.arv -= this.aru.sizeOf(next.getKey(), next.getValue());
                it.remove();
                if (this.arv <= this.art) {
                    break;
                }
            }
        }
        this.ars.put(k, v);
    }

    public synchronized V get(K key) {
        return this.ars.get(key);
    }
}
