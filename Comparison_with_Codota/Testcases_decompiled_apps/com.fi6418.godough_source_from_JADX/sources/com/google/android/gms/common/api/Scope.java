package com.google.android.gms.common.api;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.C1009bf;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

public final class Scope implements SafeParcelable {
    public static final Parcelable.Creator<Scope> CREATOR = new C0727ay();

    /* renamed from: a */
    final int f4410a;

    /* renamed from: b */
    private final String f4411b;

    Scope(int i, String str) {
        C1009bf.m4531a(str, (Object) "scopeUri must not be null or empty");
        this.f4410a = i;
        this.f4411b = str;
    }

    public Scope(String str) {
        this(1, str);
    }

    /* renamed from: a */
    public String mo7335a() {
        return this.f4411b;
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Scope)) {
            return false;
        }
        return this.f4411b.equals(((Scope) obj).f4411b);
    }

    public int hashCode() {
        return this.f4411b.hashCode();
    }

    public String toString() {
        return this.f4411b;
    }

    public void writeToParcel(Parcel parcel, int i) {
        C0727ay.m4037a(this, parcel, i);
    }
}
