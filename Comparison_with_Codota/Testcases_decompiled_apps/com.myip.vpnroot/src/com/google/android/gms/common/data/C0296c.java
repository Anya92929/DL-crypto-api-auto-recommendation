package com.google.android.gms.common.data;

import com.google.android.gms.common.internal.C0348n;
import java.util.Iterator;
import java.util.NoSuchElementException;

/* renamed from: com.google.android.gms.common.data.c */
public class C0296c<T> implements Iterator<T> {

    /* renamed from: JO */
    protected final DataBuffer<T> f691JO;

    /* renamed from: JP */
    protected int f692JP = -1;

    public C0296c(DataBuffer<T> dataBuffer) {
        this.f691JO = (DataBuffer) C0348n.m861i(dataBuffer);
    }

    public boolean hasNext() {
        return this.f692JP < this.f691JO.getCount() + -1;
    }

    public T next() {
        if (!hasNext()) {
            throw new NoSuchElementException("Cannot advance the iterator beyond " + this.f692JP);
        }
        DataBuffer<T> dataBuffer = this.f691JO;
        int i = this.f692JP + 1;
        this.f692JP = i;
        return dataBuffer.get(i);
    }

    public void remove() {
        throw new UnsupportedOperationException("Cannot remove elements from a DataBufferIterator");
    }
}
