package com.google.android.gms.drive.query.internal;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

public class Operator implements SafeParcelable {
    public static final Parcelable.Creator<Operator> CREATOR = new C0527l();

    /* renamed from: QR */
    public static final Operator f1154QR = new Operator("=");

    /* renamed from: QS */
    public static final Operator f1155QS = new Operator("<");

    /* renamed from: QT */
    public static final Operator f1156QT = new Operator("<=");

    /* renamed from: QU */
    public static final Operator f1157QU = new Operator(">");

    /* renamed from: QV */
    public static final Operator f1158QV = new Operator(">=");

    /* renamed from: QW */
    public static final Operator f1159QW = new Operator("and");

    /* renamed from: QX */
    public static final Operator f1160QX = new Operator("or");

    /* renamed from: QY */
    public static final Operator f1161QY = new Operator("not");

    /* renamed from: QZ */
    public static final Operator f1162QZ = new Operator("contains");

    /* renamed from: BR */
    final int f1163BR;
    final String mTag;

    Operator(int versionCode, String tag) {
        this.f1163BR = versionCode;
        this.mTag = tag;
    }

    private Operator(String tag) {
        this(1, tag);
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        Operator operator = (Operator) obj;
        return this.mTag == null ? operator.mTag == null : this.mTag.equals(operator.mTag);
    }

    public String getTag() {
        return this.mTag;
    }

    public int hashCode() {
        return (this.mTag == null ? 0 : this.mTag.hashCode()) + 31;
    }

    public void writeToParcel(Parcel out, int flags) {
        C0527l.m1521a(this, out, flags);
    }
}
