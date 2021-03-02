package com.google.android.gms.signin.internal;

import android.app.PendingIntent;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.internal.ResolveAccountResponse;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;

public class SignInResponse extends AbstractSafeParcelable {
    public static final Parcelable.Creator CREATOR = new zzi();

    /* renamed from: a */
    final int f7419a;

    /* renamed from: b */
    private final ConnectionResult f7420b;

    /* renamed from: c */
    private final ResolveAccountResponse f7421c;

    public SignInResponse(int i) {
        this(new ConnectionResult(i, (PendingIntent) null), (ResolveAccountResponse) null);
    }

    SignInResponse(int i, ConnectionResult connectionResult, ResolveAccountResponse resolveAccountResponse) {
        this.f7419a = i;
        this.f7420b = connectionResult;
        this.f7421c = resolveAccountResponse;
    }

    public SignInResponse(ConnectionResult connectionResult, ResolveAccountResponse resolveAccountResponse) {
        this(1, connectionResult, resolveAccountResponse);
    }

    public void writeToParcel(Parcel parcel, int i) {
        zzi.m8034a(this, parcel, i);
    }

    public ConnectionResult zzath() {
        return this.f7420b;
    }

    public ResolveAccountResponse zzbzz() {
        return this.f7421c;
    }
}
