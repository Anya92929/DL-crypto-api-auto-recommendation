package com.google.android.gms.fitness.data;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.C0345m;
import com.google.android.gms.common.internal.C0348n;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

public final class Value implements SafeParcelable {
    public static final Parcelable.Creator<Value> CREATOR = new C0632u();

    /* renamed from: BR */
    private final int f1387BR;

    /* renamed from: ST */
    private final int f1388ST;

    /* renamed from: Tk */
    private boolean f1389Tk;

    /* renamed from: Tl */
    private float f1390Tl;

    Value(int format) {
        this(1, format, false, 0.0f);
    }

    Value(int versionCode, int format, boolean isSet, float value) {
        this.f1387BR = versionCode;
        this.f1388ST = format;
        this.f1389Tk = isSet;
        this.f1390Tl = value;
    }

    /* renamed from: a */
    private boolean m1826a(Value value) {
        if (this.f1388ST != value.f1388ST || this.f1389Tk != value.f1389Tk) {
            return false;
        }
        switch (this.f1388ST) {
            case 1:
                return asInt() == value.asInt();
            case 2:
                return asFloat() == value.asFloat();
            default:
                return this.f1390Tl == value.f1390Tl;
        }
    }

    public float asFloat() {
        C0348n.m852a(this.f1388ST == 2, "Value is not in float format");
        return this.f1390Tl;
    }

    public int asInt() {
        boolean z = true;
        if (this.f1388ST != 1) {
            z = false;
        }
        C0348n.m852a(z, "Value is not in int format");
        return Float.floatToRawIntBits(this.f1390Tl);
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(Object o) {
        return this == o || ((o instanceof Value) && m1826a((Value) o));
    }

    public int getFormat() {
        return this.f1388ST;
    }

    /* access modifiers changed from: package-private */
    public int getVersionCode() {
        return this.f1387BR;
    }

    public int hashCode() {
        return C0345m.hashCode(Float.valueOf(this.f1390Tl), Integer.valueOf(this.f1388ST), Boolean.valueOf(this.f1389Tk));
    }

    /* access modifiers changed from: package-private */
    /* renamed from: iS */
    public float mo5768iS() {
        return this.f1390Tl;
    }

    public boolean isSet() {
        return this.f1389Tk;
    }

    public void setFloat(float value) {
        C0348n.m852a(this.f1388ST == 2, "Attempting to set an float value to a field that is not in FLOAT format.  Please check the data type definition and use the right format.");
        this.f1389Tk = true;
        this.f1390Tl = value;
    }

    public void setInt(int value) {
        C0348n.m852a(this.f1388ST == 1, "Attempting to set an int value to a field that is not in INT32 format.  Please check the data type definition and use the right format.");
        this.f1389Tk = true;
        this.f1390Tl = Float.intBitsToFloat(value);
    }

    public String toString() {
        switch (this.f1388ST) {
            case 1:
                return Integer.toString(asInt());
            case 2:
                return Float.toString(asFloat());
            default:
                return "unknown";
        }
    }

    public void writeToParcel(Parcel dest, int flags) {
        C0632u.m1884a(this, dest, flags);
    }
}
