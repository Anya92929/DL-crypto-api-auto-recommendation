package com.google.android.gms.common.data;

import android.os.Bundle;
import com.google.android.gms.common.api.Releasable;
import java.util.Iterator;

public interface DataBuffer extends Releasable, Iterable {
    @Deprecated
    void close();

    Object get(int i);

    int getCount();

    @Deprecated
    boolean isClosed();

    Iterator iterator();

    void release();

    Iterator singleRefIterator();

    Bundle zzarc();
}
