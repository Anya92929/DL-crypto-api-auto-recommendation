package com.google.android.gms.common.internal;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.zzq;

public class ResolveAccountResponse extends AbstractSafeParcelable {
    public static final Parcelable.Creator CREATOR = new zzad();

    /* renamed from: a */
    final int f4467a;

    /* renamed from: b */
    IBinder f4468b;

    /* renamed from: c */
    private ConnectionResult f4469c;

    /* renamed from: d */
    private boolean f4470d;

    /* renamed from: e */
    private boolean f4471e;

    ResolveAccountResponse(int i, IBinder iBinder, ConnectionResult connectionResult, boolean z, boolean z2) {
        this.f4467a = i;
        this.f4468b = iBinder;
        this.f4469c = connectionResult;
        this.f4470d = z;
        this.f4471e = z2;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof ResolveAccountResponse)) {
            return false;
        }
        ResolveAccountResponse resolveAccountResponse = (ResolveAccountResponse) obj;
        return this.f4469c.equals(resolveAccountResponse.f4469c) && zzatg().equals(resolveAccountResponse.zzatg());
    }

    public void writeToParcel(Parcel parcel, int i) {
        zzad.m6068a(this, parcel, i);
    }

    public zzq zzatg() {
        return zzq.zza.zzdp(this.f4468b);
    }

    public ConnectionResult zzath() {
        return this.f4469c;
    }

    public boolean zzati() {
        return this.f4470d;
    }

    public boolean zzatj() {
        return this.f4471e;
    }
}
