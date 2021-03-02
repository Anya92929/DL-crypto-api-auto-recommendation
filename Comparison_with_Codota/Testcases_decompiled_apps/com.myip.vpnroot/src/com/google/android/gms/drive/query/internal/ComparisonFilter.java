package com.google.android.gms.drive.query.internal;

import android.os.Parcel;
import com.google.android.gms.drive.metadata.MetadataField;
import com.google.android.gms.drive.metadata.SearchableMetadataField;
import com.google.android.gms.drive.metadata.internal.MetadataBundle;

public class ComparisonFilter<T> extends AbstractFilter {
    public static final C0516a CREATOR = new C0516a();

    /* renamed from: BR */
    final int f1122BR;

    /* renamed from: QC */
    final Operator f1123QC;

    /* renamed from: QD */
    final MetadataBundle f1124QD;

    /* renamed from: QE */
    final MetadataField<T> f1125QE;

    ComparisonFilter(int versionCode, Operator operator, MetadataBundle value) {
        this.f1122BR = versionCode;
        this.f1123QC = operator;
        this.f1124QD = value;
        this.f1125QE = C0520e.m1498b(value);
    }

    public ComparisonFilter(Operator operator, SearchableMetadataField<T> field, T value) {
        this(1, operator, MetadataBundle.m1384a(field, value));
    }

    /* renamed from: a */
    public <F> F mo5177a(C0521f<F> fVar) {
        return fVar.mo5207b(this.f1123QC, this.f1125QE, getValue());
    }

    public int describeContents() {
        return 0;
    }

    public T getValue() {
        return this.f1124QD.mo5134a(this.f1125QE);
    }

    public void writeToParcel(Parcel out, int flags) {
        C0516a.m1486a(this, out, flags);
    }
}
