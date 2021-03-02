package com.google.android.gms.common.data;

import com.google.android.gms.internal.C0621s;
import java.util.Iterator;
import java.util.NoSuchElementException;

/* renamed from: com.google.android.gms.common.data.a */
public final class C0341a<T> implements Iterator<T> {

    /* renamed from: T */
    private final DataBuffer<T> f793T;

    /* renamed from: U */
    private int f794U = -1;

    public C0341a(DataBuffer<T> dataBuffer) {
        this.f793T = (DataBuffer) C0621s.m1890d(dataBuffer);
    }

    public boolean hasNext() {
        return this.f794U < this.f793T.getCount() + -1;
    }

    public T next() {
        if (!hasNext()) {
            throw new NoSuchElementException("Cannot advance the iterator beyond " + this.f794U);
        }
        DataBuffer<T> dataBuffer = this.f793T;
        int i = this.f794U + 1;
        this.f794U = i;
        return dataBuffer.get(i);
    }

    public void remove() {
        throw new UnsupportedOperationException("Cannot remove elements from a DataBufferIterator");
    }
}
