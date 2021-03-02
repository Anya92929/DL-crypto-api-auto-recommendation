package com.google.android.gms.common.data;

import java.util.NoSuchElementException;

public class zzg extends zzb {

    /* renamed from: c */
    private Object f4398c;

    public zzg(DataBuffer dataBuffer) {
        super(dataBuffer);
    }

    public Object next() {
        if (!hasNext()) {
            throw new NoSuchElementException(new StringBuilder(46).append("Cannot advance the iterator beyond ").append(this.f4390b).toString());
        }
        this.f4390b++;
        if (this.f4390b == 0) {
            this.f4398c = this.f4389a.get(0);
            if (!(this.f4398c instanceof zzc)) {
                String valueOf = String.valueOf(this.f4398c.getClass());
                throw new IllegalStateException(new StringBuilder(String.valueOf(valueOf).length() + 44).append("DataBuffer reference of type ").append(valueOf).append(" is not movable").toString());
            }
        } else {
            ((zzc) this.f4398c).mo6461a(this.f4390b);
        }
        return this.f4398c;
    }
}
