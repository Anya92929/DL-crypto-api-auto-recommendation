package com.google.android.gms.tagmanager;

import android.os.Build;

/* renamed from: com.google.android.gms.tagmanager.l */
class C2128l<K, V> {
    final C2130a<K, V> anP = new C2130a<K, V>() {
        public int sizeOf(K k, V v) {
            return 1;
        }
    };

    /* renamed from: com.google.android.gms.tagmanager.l$a */
    public interface C2130a<K, V> {
        int sizeOf(K k, V v);
    }

    /* renamed from: a */
    public C2127k<K, V> mo11752a(int i, C2130a<K, V> aVar) {
        if (i > 0) {
            return mo11753nN() < 12 ? new C2104da(i, aVar) : new C2020bb(i, aVar);
        }
        throw new IllegalArgumentException("maxSize <= 0");
    }

    /* access modifiers changed from: package-private */
    /* renamed from: nN */
    public int mo11753nN() {
        return Build.VERSION.SDK_INT;
    }
}
