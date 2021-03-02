package com.google.android.gms.common.internal;

import android.accounts.Account;
import android.os.Bundle;
import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.zzp;
import com.google.android.gms.common.zzc;
import java.util.Collection;

public class GetServiceRequest implements SafeParcelable {
    public static final Parcelable.Creator<GetServiceRequest> CREATOR = new zzi();

    /* renamed from: a */
    final int f2908a;

    /* renamed from: b */
    final int f2909b;

    /* renamed from: c */
    int f2910c;

    /* renamed from: d */
    String f2911d;

    /* renamed from: e */
    IBinder f2912e;

    /* renamed from: f */
    Scope[] f2913f;

    /* renamed from: g */
    Bundle f2914g;

    /* renamed from: h */
    Account f2915h;

    public GetServiceRequest(int i) {
        this.f2908a = 2;
        this.f2910c = zzc.GOOGLE_PLAY_SERVICES_VERSION_CODE;
        this.f2909b = i;
    }

    GetServiceRequest(int i, int i2, int i3, String str, IBinder iBinder, Scope[] scopeArr, Bundle bundle, Account account) {
        this.f2908a = i;
        this.f2909b = i2;
        this.f2910c = i3;
        this.f2911d = str;
        if (i < 2) {
            this.f2915h = m3894a(iBinder);
        } else {
            this.f2912e = iBinder;
            this.f2915h = account;
        }
        this.f2913f = scopeArr;
        this.f2914g = bundle;
    }

    /* renamed from: a */
    private Account m3894a(IBinder iBinder) {
        if (iBinder != null) {
            return zza.zza(zzp.zza.zzaP(iBinder));
        }
        return null;
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        zzi.m3912a(this, parcel, i);
    }

    public GetServiceRequest zzb(zzp zzp) {
        if (zzp != null) {
            this.f2912e = zzp.asBinder();
        }
        return this;
    }

    public GetServiceRequest zzc(Account account) {
        this.f2915h = account;
        return this;
    }

    public GetServiceRequest zzcG(String str) {
        this.f2911d = str;
        return this;
    }

    public GetServiceRequest zzd(Collection<Scope> collection) {
        this.f2913f = (Scope[]) collection.toArray(new Scope[collection.size()]);
        return this;
    }

    public GetServiceRequest zzj(Bundle bundle) {
        this.f2914g = bundle;
        return this;
    }
}
