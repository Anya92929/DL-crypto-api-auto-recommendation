package com.google.android.gms.p018c;

import java.util.Iterator;
import java.util.Map;

/* renamed from: com.google.android.gms.c.y */
final class C0683y implements Iterator<Map.Entry<K, V>>, Map.Entry<K, V> {

    /* renamed from: a */
    int f4393a;

    /* renamed from: b */
    int f4394b;

    /* renamed from: c */
    boolean f4395c = false;

    /* renamed from: d */
    final /* synthetic */ C0679u f4396d;

    C0683y(C0679u uVar) {
        this.f4396d = uVar;
        this.f4393a = uVar.mo7250a() - 1;
        this.f4394b = -1;
    }

    /* renamed from: a */
    public Map.Entry<K, V> next() {
        this.f4394b++;
        this.f4395c = true;
        return this;
    }

    public final boolean equals(Object obj) {
        boolean z = true;
        if (!this.f4395c) {
            throw new IllegalStateException("This container does not support retaining Map.Entry objects");
        } else if (!(obj instanceof Map.Entry)) {
            return false;
        } else {
            Map.Entry entry = (Map.Entry) obj;
            if (!C0678t.m3919a(entry.getKey(), this.f4396d.mo7252a(this.f4394b, 0)) || !C0678t.m3919a(entry.getValue(), this.f4396d.mo7252a(this.f4394b, 1))) {
                z = false;
            }
            return z;
        }
    }

    public K getKey() {
        if (this.f4395c) {
            return this.f4396d.mo7252a(this.f4394b, 0);
        }
        throw new IllegalStateException("This container does not support retaining Map.Entry objects");
    }

    public V getValue() {
        if (this.f4395c) {
            return this.f4396d.mo7252a(this.f4394b, 1);
        }
        throw new IllegalStateException("This container does not support retaining Map.Entry objects");
    }

    public boolean hasNext() {
        return this.f4394b < this.f4393a;
    }

    public final int hashCode() {
        int i = 0;
        if (!this.f4395c) {
            throw new IllegalStateException("This container does not support retaining Map.Entry objects");
        }
        Object a = this.f4396d.mo7252a(this.f4394b, 0);
        Object a2 = this.f4396d.mo7252a(this.f4394b, 1);
        int hashCode = a == null ? 0 : a.hashCode();
        if (a2 != null) {
            i = a2.hashCode();
        }
        return i ^ hashCode;
    }

    public void remove() {
        if (!this.f4395c) {
            throw new IllegalStateException();
        }
        this.f4396d.mo7254a(this.f4394b);
        this.f4394b--;
        this.f4393a--;
        this.f4395c = false;
    }

    public V setValue(V v) {
        if (this.f4395c) {
            return this.f4396d.mo7253a(this.f4394b, v);
        }
        throw new IllegalStateException("This container does not support retaining Map.Entry objects");
    }

    public final String toString() {
        return getKey() + "=" + getValue();
    }
}
