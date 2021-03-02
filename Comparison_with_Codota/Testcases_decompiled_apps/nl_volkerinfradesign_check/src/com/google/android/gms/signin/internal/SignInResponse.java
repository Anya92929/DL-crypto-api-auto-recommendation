package com.google.android.gms.signin.internal;

import android.app.PendingIntent;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.internal.ResolveAccountResponse;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

public class SignInResponse implements SafeParcelable {
    public static final Parcelable.Creator<SignInResponse> CREATOR = new zzj();

    /* renamed from: a */
    final int f3602a;

    /* renamed from: b */
    private final ConnectionResult f3603b;

    /* renamed from: c */
    private final ResolveAccountResponse f3604c;

    public SignInResponse(int i) {
        this(new ConnectionResult(i, (PendingIntent) null), (ResolveAccountResponse) null);
    }

    SignInResponse(int i, ConnectionResult connectionResult, ResolveAccountResponse resolveAccountResponse) {
        this.f3602a = i;
        this.f3603b = connectionResult;
        this.f3604c = resolveAccountResponse;
    }

    public SignInResponse(ConnectionResult connectionResult, ResolveAccountResponse resolveAccountResponse) {
        this(1, connectionResult, resolveAccountResponse);
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        zzj.m4248a(this, parcel, i);
    }

    public ResolveAccountResponse zzFP() {
        return this.f3604c;
    }

    public ConnectionResult zzqY() {
        return this.f3603b;
    }
}
