package com.google.android.gms.common.data;

import android.os.Bundle;
import com.google.android.gms.common.api.Releasable;
import java.util.Iterator;

public abstract class DataBuffer<T> implements Releasable, Iterable<T> {

    /* renamed from: IC */
    protected final DataHolder f667IC;

    protected DataBuffer(DataHolder dataHolder) {
        this.f667IC = dataHolder;
        if (this.f667IC != null) {
            this.f667IC.mo4311e(this);
        }
    }

    @Deprecated
    public final void close() {
        release();
    }

    public int describeContents() {
        return 0;
    }

    public abstract T get(int i);

    public int getCount() {
        if (this.f667IC == null) {
            return 0;
        }
        return this.f667IC.getCount();
    }

    /* renamed from: gz */
    public Bundle mo4297gz() {
        return this.f667IC.mo4321gz();
    }

    @Deprecated
    public boolean isClosed() {
        if (this.f667IC == null) {
            return true;
        }
        return this.f667IC.isClosed();
    }

    public Iterator<T> iterator() {
        return new C0296c(this);
    }

    public void release() {
        if (this.f667IC != null) {
            this.f667IC.close();
        }
    }

    public Iterator<T> singleRefIterator() {
        return new C0301h(this);
    }
}
