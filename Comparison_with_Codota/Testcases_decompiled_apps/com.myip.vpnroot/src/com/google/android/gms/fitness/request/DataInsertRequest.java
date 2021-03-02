package com.google.android.gms.fitness.request;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.C0345m;
import com.google.android.gms.common.internal.C0348n;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.fitness.data.DataSet;

public class DataInsertRequest implements SafeParcelable {
    public static final Parcelable.Creator<DataInsertRequest> CREATOR = new C0661e();

    /* renamed from: BR */
    private final int f1418BR;

    /* renamed from: Th */
    private final DataSet f1419Th;

    public static class Builder {
        /* access modifiers changed from: private */

        /* renamed from: Th */
        public DataSet f1420Th;

        public DataInsertRequest build() {
            boolean z = true;
            C0348n.m852a(this.f1420Th != null, "Must set the data set");
            C0348n.m852a(!this.f1420Th.getDataPoints().isEmpty(), "Cannot use an empty data set");
            if (this.f1420Th.getDataSource().mo5664iH() == null) {
                z = false;
            }
            C0348n.m852a(z, "Must set the app package name for the data source");
            return new DataInsertRequest(this);
        }

        public Builder setDataSet(DataSet dataSet) {
            this.f1420Th = dataSet;
            return this;
        }
    }

    DataInsertRequest(int versionCode, DataSet dataSet) {
        this.f1418BR = versionCode;
        this.f1419Th = dataSet;
    }

    private DataInsertRequest(Builder builder) {
        this.f1418BR = 1;
        this.f1419Th = builder.f1420Th;
    }

    /* renamed from: a */
    private boolean m1898a(DataInsertRequest dataInsertRequest) {
        return C0345m.equal(this.f1419Th, dataInsertRequest.f1419Th);
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(Object o) {
        return o == this || ((o instanceof DataInsertRequest) && m1898a((DataInsertRequest) o));
    }

    /* access modifiers changed from: package-private */
    public int getVersionCode() {
        return this.f1418BR;
    }

    public int hashCode() {
        return C0345m.hashCode(this.f1419Th);
    }

    /* renamed from: iP */
    public DataSet mo5888iP() {
        return this.f1419Th;
    }

    public String toString() {
        return C0345m.m848h(this).mo4549a("dataSet", this.f1419Th).toString();
    }

    public void writeToParcel(Parcel dest, int flags) {
        C0661e.m2013a(this, dest, flags);
    }
}
