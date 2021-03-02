package com.google.android.gms.fitness.request;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.C0345m;
import com.google.android.gms.common.internal.C0348n;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.fitness.data.Field;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class DataTypeCreateRequest implements SafeParcelable {
    public static final Parcelable.Creator<DataTypeCreateRequest> CREATOR = new C0664h();

    /* renamed from: BR */
    private final int f1455BR;

    /* renamed from: SN */
    private final List<Field> f1456SN;
    private final String mName;

    public static class Builder {
        /* access modifiers changed from: private */

        /* renamed from: SN */
        public List<Field> f1457SN = new ArrayList();
        /* access modifiers changed from: private */
        public String mName;

        public Builder addField(Field field) {
            if (!this.f1457SN.contains(field)) {
                this.f1457SN.add(field);
            }
            return this;
        }

        public Builder addField(String name, int format) {
            C0348n.m859b(name != null || !name.isEmpty(), (Object) "Invalid name specified");
            return addField(new Field(name, format));
        }

        public DataTypeCreateRequest build() {
            boolean z = true;
            C0348n.m852a(this.mName != null, "Must set the name");
            if (this.f1457SN.isEmpty()) {
                z = false;
            }
            C0348n.m852a(z, "Must specify the data fields");
            return new DataTypeCreateRequest(this);
        }

        public Builder setName(String name) {
            this.mName = name;
            return this;
        }
    }

    DataTypeCreateRequest(int versionCode, String name, List<Field> fields) {
        this.f1455BR = versionCode;
        this.mName = name;
        this.f1456SN = Collections.unmodifiableList(fields);
    }

    private DataTypeCreateRequest(Builder builder) {
        this.f1455BR = 1;
        this.mName = builder.mName;
        this.f1456SN = Collections.unmodifiableList(builder.f1457SN);
    }

    /* renamed from: a */
    private boolean m1928a(DataTypeCreateRequest dataTypeCreateRequest) {
        return C0345m.equal(this.mName, dataTypeCreateRequest.mName) && C0345m.equal(this.f1456SN, dataTypeCreateRequest.f1456SN);
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(Object o) {
        return o == this || ((o instanceof DataTypeCreateRequest) && m1928a((DataTypeCreateRequest) o));
    }

    public List<Field> getFields() {
        return this.f1456SN;
    }

    public String getName() {
        return this.mName;
    }

    /* access modifiers changed from: package-private */
    public int getVersionCode() {
        return this.f1455BR;
    }

    public int hashCode() {
        return C0345m.hashCode(this.mName, this.f1456SN);
    }

    public String toString() {
        return C0345m.m848h(this).mo4549a("name", this.mName).mo4549a("fields", this.f1456SN).toString();
    }

    public void writeToParcel(Parcel dest, int flags) {
        C0664h.m2022a(this, dest, flags);
    }
}
