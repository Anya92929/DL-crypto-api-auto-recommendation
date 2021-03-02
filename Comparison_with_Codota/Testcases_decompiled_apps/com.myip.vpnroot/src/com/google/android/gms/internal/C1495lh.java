package com.google.android.gms.internal;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.fitness.data.DataSource;

/* renamed from: com.google.android.gms.internal.lh */
public class C1495lh implements SafeParcelable {
    public static final Parcelable.Creator<C1495lh> CREATOR = new C1496li();

    /* renamed from: BR */
    private final int f4260BR;

    /* renamed from: Sh */
    private final DataSource f4261Sh;

    C1495lh(int i, DataSource dataSource) {
        this.f4260BR = i;
        this.f4261Sh = dataSource;
    }

    public int describeContents() {
        return 0;
    }

    public DataSource getDataSource() {
        return this.f4261Sh;
    }

    /* access modifiers changed from: package-private */
    public int getVersionCode() {
        return this.f4260BR;
    }

    public String toString() {
        return String.format("ApplicationUnregistrationRequest{%s}", new Object[]{this.f4261Sh});
    }

    public void writeToParcel(Parcel parcel, int flags) {
        C1496li.m5425a(this, parcel, flags);
    }
}
