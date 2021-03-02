package com.google.android.gms.fitness.data;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.internal.C1382jr;
import java.util.Collections;
import java.util.List;

public final class DataType implements SafeParcelable {
    public static final Parcelable.Creator<DataType> CREATOR = new C0615h();

    /* renamed from: BR */
    private final int f1326BR;

    /* renamed from: SN */
    private final List<Field> f1327SN;
    private final String mName;

    DataType(int versionCode, String name, List<Field> fields) {
        this.f1326BR = versionCode;
        this.mName = name;
        this.f1327SN = Collections.unmodifiableList(fields);
    }

    public DataType(String name, Field... fields) {
        this(1, name, C1382jr.m5208b(fields));
    }

    /* renamed from: a */
    private boolean m1794a(DataType dataType) {
        return this.mName.equals(dataType.mName) && this.f1327SN.equals(dataType.f1327SN);
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(Object that) {
        return this == that || ((that instanceof DataType) && m1794a((DataType) that));
    }

    public List<Field> getFields() {
        return this.f1327SN;
    }

    public String getName() {
        return this.mName;
    }

    /* access modifiers changed from: package-private */
    public int getVersionCode() {
        return this.f1326BR;
    }

    public int hashCode() {
        return this.mName.hashCode();
    }

    /* renamed from: iL */
    public String mo5685iL() {
        return this.mName.startsWith("com.google.") ? this.mName.substring(11) : this.mName;
    }

    public int indexOf(Field field) {
        if (this.f1327SN.contains(field)) {
            return this.f1327SN.indexOf(field);
        }
        throw new IllegalArgumentException(String.format("%s not a field of %s", new Object[]{field, this}));
    }

    public String toString() {
        return String.format("DataType{%s%s}", new Object[]{this.mName, this.f1327SN});
    }

    public void writeToParcel(Parcel dest, int flags) {
        C0615h.m1849a(this, dest, flags);
    }
}
