package com.google.android.gms.signin.internal;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.ResolveAccountRequest;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

public class SignInRequest implements SafeParcelable {
    public static final Parcelable.Creator<SignInRequest> CREATOR = new zzi();

    /* renamed from: a */
    final int f3600a;

    /* renamed from: b */
    final ResolveAccountRequest f3601b;

    SignInRequest(int i, ResolveAccountRequest resolveAccountRequest) {
        this.f3600a = i;
        this.f3601b = resolveAccountRequest;
    }

    public SignInRequest(ResolveAccountRequest resolveAccountRequest) {
        this(1, resolveAccountRequest);
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        zzi.m4247a(this, parcel, i);
    }

    public ResolveAccountRequest zzFO() {
        return this.f3601b;
    }
}
