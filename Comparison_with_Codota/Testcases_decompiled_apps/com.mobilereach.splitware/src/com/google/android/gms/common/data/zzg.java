package com.google.android.gms.common.data;

import java.util.NoSuchElementException;

public class zzg<T> extends zzb<T> {
    private T zzajy;

    public zzg(DataBuffer<T> dataBuffer) {
        super(dataBuffer);
    }

    public T next() {
        if (!hasNext()) {
            throw new NoSuchElementException("Cannot advance the iterator beyond " + this.zzajc);
        }
        this.zzajc++;
        if (this.zzajc == 0) {
            this.zzajy = this.zzajb.get(0);
            if (!(this.zzajy instanceof zzc)) {
                throw new IllegalStateException("DataBuffer reference of type " + this.zzajy.getClass() + " is not movable");
            }
        } else {
            ((zzc) this.zzajy).zzbF(this.zzajc);
        }
        return this.zzajy;
    }
}
