package com.google.android.gms.p018c;

import java.util.Map;

/* renamed from: com.google.android.gms.c.s */
class C0677s extends C0679u<K, V> {

    /* renamed from: a */
    final /* synthetic */ C0676r f4379a;

    C0677s(C0676r rVar) {
        this.f4379a = rVar;
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public int mo7250a() {
        return this.f4379a.f4216h;
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public int mo7251a(Object obj) {
        return obj == null ? this.f4379a.mo6971a() : this.f4379a.mo6973a(obj, obj.hashCode());
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public Object mo7252a(int i, int i2) {
        return this.f4379a.f4215g[(i << 1) + i2];
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public V mo7253a(int i, V v) {
        return this.f4379a.mo6974a(i, v);
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public void mo7254a(int i) {
        this.f4379a.mo6981d(i);
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public void mo7255a(K k, V v) {
        this.f4379a.put(k, v);
    }

    /* access modifiers changed from: protected */
    /* renamed from: b */
    public int mo7256b(Object obj) {
        return this.f4379a.mo6972a(obj);
    }

    /* access modifiers changed from: protected */
    /* renamed from: b */
    public Map<K, V> mo7257b() {
        return this.f4379a;
    }

    /* access modifiers changed from: protected */
    /* renamed from: c */
    public void mo7258c() {
        this.f4379a.clear();
    }
}
