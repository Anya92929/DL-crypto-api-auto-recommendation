package com.google.android.gms.signin.internal;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import java.util.List;

public class CheckServerAuthResult implements SafeParcelable {
    public static final Parcelable.Creator<CheckServerAuthResult> CREATOR = new zzc();

    /* renamed from: a */
    final int f3593a;

    /* renamed from: b */
    final boolean f3594b;

    /* renamed from: c */
    final List<Scope> f3595c;

    CheckServerAuthResult(int i, boolean z, List<Scope> list) {
        this.f3593a = i;
        this.f3594b = z;
        this.f3595c = list;
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        zzc.m4244a(this, parcel, i);
    }
}
