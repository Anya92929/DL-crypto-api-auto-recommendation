package com.google.android.gms.common.data;

import java.util.Iterator;

public abstract class DataBuffer<T> implements Iterable<T> {

    /* renamed from: jf */
    protected final C0140d f366jf;

    protected DataBuffer(C0140d dataHolder) {
        this.f366jf = dataHolder;
        if (this.f366jf != null) {
            this.f366jf.mo3601b(this);
        }
    }

    public void close() {
        this.f366jf.close();
    }

    public int describeContents() {
        return 0;
    }

    public abstract T get(int i);

    public int getCount() {
        return this.f366jf.getCount();
    }

    public boolean isClosed() {
        return this.f366jf.isClosed();
    }

    public Iterator<T> iterator() {
        return new C0137a(this);
    }
}
