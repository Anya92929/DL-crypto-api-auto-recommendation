package com.google.android.gms.drive.query.internal;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import java.util.Locale;

public class FieldWithSortOrder implements SafeParcelable {
    public static final C0518c CREATOR = new C0518c();

    /* renamed from: BR */
    final int f1129BR;

    /* renamed from: Pt */
    final String f1130Pt;

    /* renamed from: QF */
    final boolean f1131QF;

    FieldWithSortOrder(int versionCode, String fieldName, boolean isSortAscending) {
        this.f1129BR = versionCode;
        this.f1130Pt = fieldName;
        this.f1131QF = isSortAscending;
    }

    public FieldWithSortOrder(String fieldName, boolean isSortAscending) {
        this(1, fieldName, isSortAscending);
    }

    public int describeContents() {
        return 0;
    }

    public String toString() {
        Locale locale = Locale.US;
        Object[] objArr = new Object[2];
        objArr[0] = this.f1130Pt;
        objArr[1] = this.f1131QF ? "ASC" : "DESC";
        return String.format(locale, "FieldWithSortOrder[%s %s]", objArr);
    }

    public void writeToParcel(Parcel out, int flags) {
        C0518c.m1492a(this, out, flags);
    }
}
