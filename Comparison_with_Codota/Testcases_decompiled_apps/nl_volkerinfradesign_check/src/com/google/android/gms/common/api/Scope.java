package com.google.android.gms.common.api;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.zzx;

public final class Scope implements SafeParcelable {
    public static final Parcelable.Creator<Scope> CREATOR = new zzb();

    /* renamed from: a */
    final int f2648a;

    /* renamed from: b */
    private final String f2649b;

    Scope(int i, String str) {
        zzx.zzh(str, "scopeUri must not be null or empty");
        this.f2648a = i;
        this.f2649b = str;
    }

    public Scope(String str) {
        this(1, str);
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
        return this.f2649b.equals(((Scope) obj).f2649b);
    }

    public int hashCode() {
        return this.f2649b.hashCode();
    }

    public String toString() {
        return this.f2649b;
    }

    public void writeToParcel(Parcel parcel, int i) {
        zzb.m3845a(this, parcel, i);
    }

    public String zzpb() {
        return this.f2649b;
    }
}
