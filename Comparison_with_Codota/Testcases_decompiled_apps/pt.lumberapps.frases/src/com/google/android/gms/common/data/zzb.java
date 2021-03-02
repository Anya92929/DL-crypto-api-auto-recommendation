package com.google.android.gms.common.data;

import com.google.android.gms.common.internal.zzab;
import java.util.Iterator;
import java.util.NoSuchElementException;

public class zzb implements Iterator {

    /* renamed from: a */
    protected final DataBuffer f4389a;

    /* renamed from: b */
    protected int f4390b = -1;

    public zzb(DataBuffer dataBuffer) {
        this.f4389a = (DataBuffer) zzab.zzy(dataBuffer);
    }

    public boolean hasNext() {
        return this.f4390b < this.f4389a.getCount() + -1;
    }

    public Object next() {
        if (!hasNext()) {
            throw new NoSuchElementException(new StringBuilder(46).append("Cannot advance the iterator beyond ").append(this.f4390b).toString());
        }
        DataBuffer dataBuffer = this.f4389a;
        int i = this.f4390b + 1;
        this.f4390b = i;
        return dataBuffer.get(i);
    }

    public void remove() {
        throw new UnsupportedOperationException("Cannot remove elements from a DataBufferIterator");
    }
}
