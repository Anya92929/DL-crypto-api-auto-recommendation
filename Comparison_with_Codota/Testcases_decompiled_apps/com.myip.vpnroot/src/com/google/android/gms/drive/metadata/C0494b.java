package com.google.android.gms.drive.metadata;

import com.google.android.gms.common.data.DataHolder;
import java.util.Collection;

/* renamed from: com.google.android.gms.drive.metadata.b */
public abstract class C0494b<T> extends C0493a<Collection<T>> {
    protected C0494b(String str, Collection<String> collection, Collection<String> collection2, int i) {
        super(str, collection, collection2, i);
    }

    /* access modifiers changed from: protected */
    /* renamed from: d */
    public Collection<T> mo5120c(DataHolder dataHolder, int i, int i2) {
        throw new UnsupportedOperationException("Cannot read collections from a dataHolder.");
    }
}
