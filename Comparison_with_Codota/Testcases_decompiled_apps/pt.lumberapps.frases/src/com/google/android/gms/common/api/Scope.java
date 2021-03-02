package com.google.android.gms.common.api;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.ReflectedParcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.zzab;

public final class Scope extends AbstractSafeParcelable implements ReflectedParcelable {
    public static final Parcelable.Creator CREATOR = new zze();

    /* renamed from: a */
    final int f4326a;

    /* renamed from: b */
    private final String f4327b;

    Scope(int i, String str) {
        zzab.zzh(str, "scopeUri must not be null or empty");
        this.f4326a = i;
        this.f4327b = str;
    }

    public Scope(String str) {
        this(1, str);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Scope)) {
            return false;
        }
        return this.f4327b.equals(((Scope) obj).f4327b);
    }

    public int hashCode() {
        return this.f4327b.hashCode();
    }

    public String toString() {
        return this.f4327b;
    }

    public void writeToParcel(Parcel parcel, int i) {
        zze.m5979a(this, parcel, i);
    }

    public String zzaok() {
        return this.f4327b;
    }
}
