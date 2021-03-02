package com.google.android.gms.drive.query.internal;

import android.os.Parcel;
import com.google.android.gms.drive.metadata.MetadataField;
import com.google.android.gms.drive.metadata.internal.MetadataBundle;

public class HasFilter<T> extends AbstractFilter {
    public static final C0522g CREATOR = new C0522g();

    /* renamed from: BR */
    final int f1141BR;

    /* renamed from: QD */
    final MetadataBundle f1142QD;

    /* renamed from: QE */
    final MetadataField<T> f1143QE;

    HasFilter(int versionCode, MetadataBundle value) {
        this.f1141BR = versionCode;
        this.f1142QD = value;
        this.f1143QE = C0520e.m1498b(value);
    }

    /* renamed from: a */
    public <F> F mo5177a(C0521f<F> fVar) {
        return fVar.mo5213d(this.f1143QE, getValue());
    }

    public int describeContents() {
        return 0;
    }

    public T getValue() {
        return this.f1142QD.mo5134a(this.f1143QE);
    }

    public void writeToParcel(Parcel out, int flags) {
        C0522g.m1506a(this, out, flags);
    }
}
