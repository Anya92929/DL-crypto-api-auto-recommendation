package com.google.android.gms.common.internal;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.zzp;

public class ResolveAccountResponse implements SafeParcelable {
    public static final Parcelable.Creator<ResolveAccountResponse> CREATOR = new zzz();

    /* renamed from: a */
    final int f2920a;

    /* renamed from: b */
    IBinder f2921b;

    /* renamed from: c */
    private ConnectionResult f2922c;

    /* renamed from: d */
    private boolean f2923d;

    /* renamed from: e */
    private boolean f2924e;

    ResolveAccountResponse(int i, IBinder iBinder, ConnectionResult connectionResult, boolean z, boolean z2) {
        this.f2920a = i;
        this.f2921b = iBinder;
        this.f2922c = connectionResult;
        this.f2923d = z;
        this.f2924e = z2;
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof ResolveAccountResponse)) {
            return false;
        }
        ResolveAccountResponse resolveAccountResponse = (ResolveAccountResponse) obj;
        return this.f2922c.equals(resolveAccountResponse.f2922c) && zzqX().equals(resolveAccountResponse.zzqX());
    }

    public void writeToParcel(Parcel parcel, int i) {
        zzz.m3955a(this, parcel, i);
    }

    public zzp zzqX() {
        return zzp.zza.zzaP(this.f2921b);
    }

    public ConnectionResult zzqY() {
        return this.f2922c;
    }

    public boolean zzqZ() {
        return this.f2923d;
    }

    public boolean zzra() {
        return this.f2924e;
    }
}
