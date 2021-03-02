package com.google.android.gms.drive.query.internal;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.drive.query.Filter;

public class FilterHolder implements SafeParcelable {
    public static final Parcelable.Creator<FilterHolder> CREATOR = new C0519d();

    /* renamed from: BR */
    final int f1132BR;

    /* renamed from: QG */
    final ComparisonFilter<?> f1133QG;

    /* renamed from: QH */
    final FieldOnlyFilter f1134QH;

    /* renamed from: QI */
    final LogicalFilter f1135QI;

    /* renamed from: QJ */
    final NotFilter f1136QJ;

    /* renamed from: QK */
    final InFilter<?> f1137QK;

    /* renamed from: QL */
    final MatchAllFilter f1138QL;

    /* renamed from: QM */
    final HasFilter f1139QM;

    /* renamed from: QN */
    private final Filter f1140QN;

    FilterHolder(int versionCode, ComparisonFilter<?> comparisonField, FieldOnlyFilter fieldOnlyFilter, LogicalFilter logicalFilter, NotFilter notFilter, InFilter<?> containsFilter, MatchAllFilter matchAllFilter, HasFilter<?> hasFilter) {
        this.f1132BR = versionCode;
        this.f1133QG = comparisonField;
        this.f1134QH = fieldOnlyFilter;
        this.f1135QI = logicalFilter;
        this.f1136QJ = notFilter;
        this.f1137QK = containsFilter;
        this.f1138QL = matchAllFilter;
        this.f1139QM = hasFilter;
        if (this.f1133QG != null) {
            this.f1140QN = this.f1133QG;
        } else if (this.f1134QH != null) {
            this.f1140QN = this.f1134QH;
        } else if (this.f1135QI != null) {
            this.f1140QN = this.f1135QI;
        } else if (this.f1136QJ != null) {
            this.f1140QN = this.f1136QJ;
        } else if (this.f1137QK != null) {
            this.f1140QN = this.f1137QK;
        } else if (this.f1138QL != null) {
            this.f1140QN = this.f1138QL;
        } else if (this.f1139QM != null) {
            this.f1140QN = this.f1139QM;
        } else {
            throw new IllegalArgumentException("At least one filter must be set.");
        }
    }

    public FilterHolder(Filter filter) {
        this.f1132BR = 2;
        this.f1133QG = filter instanceof ComparisonFilter ? (ComparisonFilter) filter : null;
        this.f1134QH = filter instanceof FieldOnlyFilter ? (FieldOnlyFilter) filter : null;
        this.f1135QI = filter instanceof LogicalFilter ? (LogicalFilter) filter : null;
        this.f1136QJ = filter instanceof NotFilter ? (NotFilter) filter : null;
        this.f1137QK = filter instanceof InFilter ? (InFilter) filter : null;
        this.f1138QL = filter instanceof MatchAllFilter ? (MatchAllFilter) filter : null;
        this.f1139QM = filter instanceof HasFilter ? (HasFilter) filter : null;
        if (this.f1133QG == null && this.f1134QH == null && this.f1135QI == null && this.f1136QJ == null && this.f1137QK == null && this.f1138QL == null && this.f1139QM == null) {
            throw new IllegalArgumentException("Invalid filter type or null filter.");
        }
        this.f1140QN = filter;
    }

    public int describeContents() {
        return 0;
    }

    public Filter getFilter() {
        return this.f1140QN;
    }

    public String toString() {
        return String.format("FilterHolder[%s]", new Object[]{this.f1140QN});
    }

    public void writeToParcel(Parcel out, int flags) {
        C0519d.m1495a(this, out, flags);
    }
}
