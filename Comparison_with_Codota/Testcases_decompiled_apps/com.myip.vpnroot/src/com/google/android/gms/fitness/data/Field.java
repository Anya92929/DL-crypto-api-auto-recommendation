package com.google.android.gms.fitness.data;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

public final class Field implements SafeParcelable {
    public static final Parcelable.Creator<Field> CREATOR = new C0617j();
    public static final int FORMAT_FLOAT = 2;
    public static final int FORMAT_INT32 = 1;

    /* renamed from: BR */
    private final int f1338BR;

    /* renamed from: ST */
    private final int f1339ST;
    private final String mName;

    Field(int versionCode, String name, int format) {
        this.f1338BR = versionCode;
        this.mName = name;
        this.f1339ST = format;
    }

    public Field(String name, int format) {
        this(1, name, format);
    }

    /* renamed from: a */
    private boolean m1804a(Field field) {
        return this.mName.equals(field.mName) && this.f1339ST == field.f1339ST;
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(Object that) {
        return this == that || ((that instanceof Field) && m1804a((Field) that));
    }

    public int getFormat() {
        return this.f1339ST;
    }

    public String getName() {
        return this.mName;
    }

    /* access modifiers changed from: package-private */
    public int getVersionCode() {
        return this.f1338BR;
    }

    public int hashCode() {
        return this.mName.hashCode();
    }

    public String toString() {
        Object[] objArr = new Object[2];
        objArr[0] = this.mName;
        objArr[1] = this.f1339ST == 1 ? "i" : "f";
        return String.format("%s(%s)", objArr);
    }

    public void writeToParcel(Parcel dest, int flags) {
        C0617j.m1855a(this, dest, flags);
    }
}
