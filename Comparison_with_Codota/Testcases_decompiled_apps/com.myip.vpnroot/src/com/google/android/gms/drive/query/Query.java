package com.google.android.gms.drive.query;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.drive.query.internal.LogicalFilter;
import com.google.android.gms.drive.query.internal.MatchAllFilter;
import com.google.android.gms.drive.query.internal.Operator;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class Query implements SafeParcelable {
    public static final Parcelable.Creator<Query> CREATOR = new C0513a();

    /* renamed from: BR */
    final int f1106BR;

    /* renamed from: Qt */
    final LogicalFilter f1107Qt;

    /* renamed from: Qu */
    final String f1108Qu;

    /* renamed from: Qv */
    final SortOrder f1109Qv;

    /* renamed from: Qw */
    final List<String> f1110Qw;

    public static class Builder {

        /* renamed from: Qu */
        private String f1111Qu;

        /* renamed from: Qv */
        private SortOrder f1112Qv;

        /* renamed from: Qw */
        private List<String> f1113Qw;

        /* renamed from: Qx */
        private final List<Filter> f1114Qx = new ArrayList();

        public Builder() {
        }

        public Builder(Query query) {
            this.f1114Qx.add(query.getFilter());
            this.f1111Qu = query.getPageToken();
            this.f1112Qv = query.getSortOrder();
            this.f1113Qw = query.mo5182iq();
        }

        public Builder addFilter(Filter filter) {
            if (!(filter instanceof MatchAllFilter)) {
                this.f1114Qx.add(filter);
            }
            return this;
        }

        public Query build() {
            return new Query(new LogicalFilter(Operator.f1159QW, this.f1114Qx), this.f1111Qu, this.f1112Qv, this.f1113Qw);
        }

        public Builder setPageToken(String token) {
            this.f1111Qu = token;
            return this;
        }

        public Builder setSortOrder(SortOrder sortOrder) {
            this.f1112Qv = sortOrder;
            return this;
        }
    }

    Query(int versionCode, LogicalFilter clause, String pageToken, SortOrder sortOrder, List<String> requestedMetadataFields) {
        this.f1106BR = versionCode;
        this.f1107Qt = clause;
        this.f1108Qu = pageToken;
        this.f1109Qv = sortOrder;
        this.f1110Qw = requestedMetadataFields;
    }

    Query(LogicalFilter clause, String pageToken, SortOrder sortOrder, List<String> requestedMetadataFields) {
        this(1, clause, pageToken, sortOrder, requestedMetadataFields);
    }

    public int describeContents() {
        return 0;
    }

    public Filter getFilter() {
        return this.f1107Qt;
    }

    public String getPageToken() {
        return this.f1108Qu;
    }

    public SortOrder getSortOrder() {
        return this.f1109Qv;
    }

    /* renamed from: iq */
    public List<String> mo5182iq() {
        return this.f1110Qw;
    }

    public String toString() {
        return String.format(Locale.US, "Query[%s,%s,PageToken=%s]", new Object[]{this.f1107Qt, this.f1109Qv, this.f1108Qu});
    }

    public void writeToParcel(Parcel out, int flags) {
        C0513a.m1459a(this, out, flags);
    }
}
