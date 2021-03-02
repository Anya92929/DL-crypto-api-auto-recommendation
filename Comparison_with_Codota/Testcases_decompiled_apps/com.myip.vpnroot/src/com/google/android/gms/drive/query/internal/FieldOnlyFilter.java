package com.google.android.gms.drive.query.internal;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.drive.metadata.MetadataField;
import com.google.android.gms.drive.metadata.SearchableMetadataField;
import com.google.android.gms.drive.metadata.internal.MetadataBundle;

public class FieldOnlyFilter extends AbstractFilter {
    public static final Parcelable.Creator<FieldOnlyFilter> CREATOR = new C0517b();

    /* renamed from: BR */
    final int f1126BR;

    /* renamed from: QD */
    final MetadataBundle f1127QD;

    /* renamed from: QE */
    private final MetadataField<?> f1128QE;

    FieldOnlyFilter(int versionCode, MetadataBundle value) {
        this.f1126BR = versionCode;
        this.f1127QD = value;
        this.f1128QE = C0520e.m1498b(value);
    }

    public FieldOnlyFilter(SearchableMetadataField<?> field) {
        this(1, MetadataBundle.m1384a(field, null));
    }

    /* renamed from: a */
    public <T> T mo5177a(C0521f<T> fVar) {
        return fVar.mo5212d(this.f1128QE);
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel out, int flags) {
        C0517b.m1489a(this, out, flags);
    }
}
