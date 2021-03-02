package com.google.android.gms.fitness.request;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.C0345m;
import com.google.android.gms.common.internal.C0348n;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.fitness.data.DataType;
import com.google.android.gms.internal.C1382jr;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class DataSourcesRequest implements SafeParcelable {
    public static final Parcelable.Creator<DataSourcesRequest> CREATOR = new C0663g();

    /* renamed from: BR */
    private final int f1448BR;

    /* renamed from: Su */
    private final List<DataType> f1449Su;

    /* renamed from: Ul */
    private final List<Integer> f1450Ul;

    /* renamed from: Um */
    private final boolean f1451Um;

    public static class Builder {
        /* access modifiers changed from: private */

        /* renamed from: Um */
        public boolean f1452Um = false;
        /* access modifiers changed from: private */

        /* renamed from: Un */
        public DataType[] f1453Un = new DataType[0];
        /* access modifiers changed from: private */

        /* renamed from: Uo */
        public int[] f1454Uo = {0, 1};

        public DataSourcesRequest build() {
            boolean z = true;
            C0348n.m852a(this.f1453Un.length > 0, "Must add at least one data type");
            if (this.f1454Uo.length <= 0) {
                z = false;
            }
            C0348n.m852a(z, "Must add at least one data source type");
            return new DataSourcesRequest(this);
        }

        public Builder setDataSourceTypes(int... dataSourceTypes) {
            this.f1454Uo = dataSourceTypes;
            return this;
        }

        public Builder setDataTypes(DataType... dataTypes) {
            this.f1453Un = dataTypes;
            return this;
        }
    }

    DataSourcesRequest(int versionCode, List<DataType> dataTypes, List<Integer> dataSourceTypes, boolean includeDbOnlySources) {
        this.f1448BR = versionCode;
        this.f1449Su = dataTypes;
        this.f1450Ul = dataSourceTypes;
        this.f1451Um = includeDbOnlySources;
    }

    private DataSourcesRequest(Builder builder) {
        this.f1448BR = 2;
        this.f1449Su = C1382jr.m5208b(builder.f1453Un);
        this.f1450Ul = Arrays.asList(C1382jr.m5207a(builder.f1454Uo));
        this.f1451Um = builder.f1452Um;
    }

    public int describeContents() {
        return 0;
    }

    public List<DataType> getDataTypes() {
        return Collections.unmodifiableList(this.f1449Su);
    }

    /* access modifiers changed from: package-private */
    public int getVersionCode() {
        return this.f1448BR;
    }

    /* renamed from: ji */
    public boolean mo5929ji() {
        return this.f1451Um;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: jj */
    public List<Integer> mo5930jj() {
        return this.f1450Ul;
    }

    public String toString() {
        C0345m.C0347a a = C0345m.m848h(this).mo4549a("dataTypes", this.f1449Su).mo4549a("sourceTypes", this.f1450Ul);
        if (this.f1451Um) {
            a.mo4549a("includeDbOnlySources", "true");
        }
        return a.toString();
    }

    public void writeToParcel(Parcel parcel, int flags) {
        C0663g.m2019a(this, parcel, flags);
    }
}
