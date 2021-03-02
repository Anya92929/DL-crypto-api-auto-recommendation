package com.google.android.gms.common.data;

import java.util.Iterator;

public abstract class DataBuffer<T> implements Iterable<T> {

    /* renamed from: S */
    protected final C0344d f792S;

    protected DataBuffer(C0344d dataHolder) {
        this.f792S = dataHolder;
    }

    public void close() {
        this.f792S.close();
    }

    public int describeContents() {
        return 0;
    }

    public abstract T get(int i);

    public int getCount() {
        return this.f792S.getCount();
    }

    public boolean isClosed() {
        return this.f792S.isClosed();
    }

    public Iterator<T> iterator() {
        return new C0341a(this);
    }
}
