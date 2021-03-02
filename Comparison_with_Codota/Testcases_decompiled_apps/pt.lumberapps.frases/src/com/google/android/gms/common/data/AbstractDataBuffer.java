package com.google.android.gms.common.data;

import android.os.Bundle;
import java.util.Iterator;

public abstract class AbstractDataBuffer implements DataBuffer {

    /* renamed from: a */
    protected final DataHolder f4364a;

    protected AbstractDataBuffer(DataHolder dataHolder) {
        this.f4364a = dataHolder;
        if (this.f4364a != null) {
        }
    }

    @Deprecated
    public final void close() {
        release();
    }

    public abstract Object get(int i);

    public int getCount() {
        if (this.f4364a == null) {
            return 0;
        }
        return this.f4364a.getCount();
    }

    @Deprecated
    public boolean isClosed() {
        return this.f4364a == null || this.f4364a.isClosed();
    }

    public Iterator iterator() {
        return new zzb(this);
    }

    public void release() {
        if (this.f4364a != null) {
            this.f4364a.close();
        }
    }

    public Iterator singleRefIterator() {
        return new zzg(this);
    }

    public Bundle zzarc() {
        return this.f4364a.zzarc();
    }
}
