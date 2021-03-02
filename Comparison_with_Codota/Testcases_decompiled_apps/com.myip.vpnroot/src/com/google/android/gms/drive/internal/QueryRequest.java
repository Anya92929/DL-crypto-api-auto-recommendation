package com.google.android.gms.drive.internal;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.drive.query.Query;

public class QueryRequest implements SafeParcelable {
    public static final Parcelable.Creator<QueryRequest> CREATOR = new C0410ax();

    /* renamed from: BR */
    final int f965BR;

    /* renamed from: Pq */
    final Query f966Pq;

    QueryRequest(int versionCode, Query query) {
        this.f965BR = versionCode;
        this.f966Pq = query;
    }

    public QueryRequest(Query query) {
        this(1, query);
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel dest, int flags) {
        C0410ax.m1185a(this, dest, flags);
    }
}
