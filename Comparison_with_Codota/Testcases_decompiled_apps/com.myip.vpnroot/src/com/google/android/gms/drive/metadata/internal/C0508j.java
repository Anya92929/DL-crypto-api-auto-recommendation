package com.google.android.gms.drive.metadata.internal;

import android.os.Bundle;
import android.os.Parcelable;
import com.google.android.gms.drive.metadata.C0493a;
import java.util.Collection;

/* renamed from: com.google.android.gms.drive.metadata.internal.j */
public abstract class C0508j<T extends Parcelable> extends C0493a<T> {
    public C0508j(String str, Collection<String> collection, Collection<String> collection2, int i) {
        super(str, collection, collection2, i);
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public void mo5118a(Bundle bundle, T t) {
        bundle.putParcelable(getName(), t);
    }

    /* access modifiers changed from: protected */
    /* renamed from: m */
    public T mo5121g(Bundle bundle) {
        return bundle.getParcelable(getName());
    }
}
