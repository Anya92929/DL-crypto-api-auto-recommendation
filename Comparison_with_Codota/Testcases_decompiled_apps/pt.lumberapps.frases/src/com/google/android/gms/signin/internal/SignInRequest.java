package com.google.android.gms.signin.internal;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.ResolveAccountRequest;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;

public class SignInRequest extends AbstractSafeParcelable {
    public static final Parcelable.Creator CREATOR = new zzh();

    /* renamed from: a */
    final int f7417a;

    /* renamed from: b */
    final ResolveAccountRequest f7418b;

    SignInRequest(int i, ResolveAccountRequest resolveAccountRequest) {
        this.f7417a = i;
        this.f7418b = resolveAccountRequest;
    }

    public SignInRequest(ResolveAccountRequest resolveAccountRequest) {
        this(1, resolveAccountRequest);
    }

    public void writeToParcel(Parcel parcel, int i) {
        zzh.m8033a(this, parcel, i);
    }

    public ResolveAccountRequest zzbzy() {
        return this.f7418b;
    }
}
