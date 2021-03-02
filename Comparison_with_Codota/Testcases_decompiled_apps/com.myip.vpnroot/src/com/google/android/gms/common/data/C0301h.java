package com.google.android.gms.common.data;

import java.util.NoSuchElementException;

/* renamed from: com.google.android.gms.common.data.h */
public class C0301h<T> extends C0296c<T> {

    /* renamed from: Kk */
    private T f700Kk;

    public C0301h(DataBuffer<T> dataBuffer) {
        super(dataBuffer);
    }

    public T next() {
        if (!hasNext()) {
            throw new NoSuchElementException("Cannot advance the iterator beyond " + this.f692JP);
        }
        this.f692JP++;
        if (this.f692JP == 0) {
            this.f700Kk = this.f691JO.get(0);
            if (!(this.f700Kk instanceof C0297d)) {
                throw new IllegalStateException("DataBuffer reference of type " + this.f700Kk.getClass() + " is not movable");
            }
        } else {
            ((C0297d) this.f700Kk).mo4340ap(this.f692JP);
        }
        return this.f700Kk;
    }
}
