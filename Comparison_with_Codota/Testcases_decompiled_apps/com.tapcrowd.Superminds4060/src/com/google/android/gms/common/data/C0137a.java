package com.google.android.gms.common.data;

import com.google.android.gms.internal.C0411dm;
import java.util.Iterator;
import java.util.NoSuchElementException;

/* renamed from: com.google.android.gms.common.data.a */
public final class C0137a<T> implements Iterator<T> {

    /* renamed from: jg */
    private final DataBuffer<T> f367jg;

    /* renamed from: jh */
    private int f368jh = -1;

    public C0137a(DataBuffer<T> dataBuffer) {
        this.f367jg = (DataBuffer) C0411dm.m944e(dataBuffer);
    }

    public boolean hasNext() {
        return this.f368jh < this.f367jg.getCount() + -1;
    }

    public T next() {
        if (!hasNext()) {
            throw new NoSuchElementException("Cannot advance the iterator beyond " + this.f368jh);
        }
        DataBuffer<T> dataBuffer = this.f367jg;
        int i = this.f368jh + 1;
        this.f368jh = i;
        return dataBuffer.get(i);
    }

    public void remove() {
        throw new UnsupportedOperationException("Cannot remove elements from a DataBufferIterator");
    }
}
