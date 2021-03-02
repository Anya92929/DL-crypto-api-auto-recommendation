package com.google.android.gms.common.data;

import java.util.NoSuchElementException;

public class zzg<T> extends zzb<T> {

    /* renamed from: a */
    private T f2858a;

    public zzg(DataBuffer<T> dataBuffer) {
        super(dataBuffer);
    }

    public T next() {
        if (!hasNext()) {
            throw new NoSuchElementException("Cannot advance the iterator beyond " + this.zzajc);
        }
        this.zzajc++;
        if (this.zzajc == 0) {
            this.f2858a = this.zzajb.get(0);
            if (!(this.f2858a instanceof zzc)) {
                throw new IllegalStateException("DataBuffer reference of type " + this.f2858a.getClass() + " is not movable");
            }
        } else {
            ((zzc) this.f2858a).zzbF(this.zzajc);
        }
        return this.f2858a;
    }
}
