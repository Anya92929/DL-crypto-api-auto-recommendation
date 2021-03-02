package com.google.android.gms.drive.query.internal;

import android.os.Parcel;
import com.google.android.gms.drive.metadata.C0494b;
import com.google.android.gms.drive.metadata.SearchableCollectionMetadataField;
import com.google.android.gms.drive.metadata.internal.MetadataBundle;
import java.util.Collection;
import java.util.Collections;

public class InFilter<T> extends AbstractFilter {
    public static final C0523h CREATOR = new C0523h();

    /* renamed from: BR */
    final int f1144BR;

    /* renamed from: QD */
    final MetadataBundle f1145QD;

    /* renamed from: QO */
    private final C0494b<T> f1146QO;

    InFilter(int versionCode, MetadataBundle value) {
        this.f1144BR = versionCode;
        this.f1145QD = value;
        this.f1146QO = (C0494b) C0520e.m1498b(value);
    }

    public InFilter(SearchableCollectionMetadataField<T> field, T value) {
        this(1, MetadataBundle.m1384a(field, Collections.singleton(value)));
    }

    /* renamed from: a */
    public <F> F mo5177a(C0521f<F> fVar) {
        return fVar.mo5206b(this.f1146QO, getValue());
    }

    public int describeContents() {
        return 0;
    }

    public T getValue() {
        return ((Collection) this.f1145QD.mo5134a(this.f1146QO)).iterator().next();
    }

    public void writeToParcel(Parcel out, int flags) {
        C0523h.m1509a(this, out, flags);
    }
}
