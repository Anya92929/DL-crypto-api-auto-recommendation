package com.google.android.gms.measurement.internal;

import java.util.Iterator;

/* renamed from: com.google.android.gms.measurement.internal.a */
class C1882a implements Iterator {

    /* renamed from: a */
    Iterator f7066a = this.f7067b.f7064a.keySet().iterator();

    /* renamed from: b */
    final /* synthetic */ EventParams f7067b;

    C1882a(EventParams eventParams) {
        this.f7067b = eventParams;
    }

    /* renamed from: a */
    public String next() {
        return (String) this.f7066a.next();
    }

    public boolean hasNext() {
        return this.f7066a.hasNext();
    }

    public void remove() {
        throw new UnsupportedOperationException("Remove not supported");
    }
}
