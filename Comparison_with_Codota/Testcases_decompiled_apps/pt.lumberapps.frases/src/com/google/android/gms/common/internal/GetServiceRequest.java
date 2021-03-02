package com.google.android.gms.common.internal;

import android.accounts.Account;
import android.os.Bundle;
import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.zzq;
import com.google.android.gms.common.zzc;
import java.util.Collection;

public class GetServiceRequest extends AbstractSafeParcelable {
    public static final Parcelable.Creator CREATOR = new zzj();

    /* renamed from: a */
    final int f4454a;

    /* renamed from: b */
    final int f4455b;

    /* renamed from: c */
    int f4456c;

    /* renamed from: d */
    String f4457d;

    /* renamed from: e */
    IBinder f4458e;

    /* renamed from: f */
    Scope[] f4459f;

    /* renamed from: g */
    Bundle f4460g;

    /* renamed from: h */
    Account f4461h;

    /* renamed from: i */
    long f4462i;

    public GetServiceRequest(int i) {
        this.f4454a = 3;
        this.f4456c = zzc.GOOGLE_PLAY_SERVICES_VERSION_CODE;
        this.f4455b = i;
    }

    GetServiceRequest(int i, int i2, int i3, String str, IBinder iBinder, Scope[] scopeArr, Bundle bundle, Account account, long j) {
        this.f4454a = i;
        this.f4455b = i2;
        this.f4456c = i3;
        this.f4457d = str;
        if (i < 2) {
            this.f4461h = m6050a(iBinder);
        } else {
            this.f4458e = iBinder;
            this.f4461h = account;
        }
        this.f4459f = scopeArr;
        this.f4460g = bundle;
        this.f4462i = j;
    }

    /* renamed from: a */
    private Account m6050a(IBinder iBinder) {
        if (iBinder != null) {
            return zza.zza(zzq.zza.zzdp(iBinder));
        }
        return null;
    }

    public void writeToParcel(Parcel parcel, int i) {
        zzj.m6114a(this, parcel, i);
    }

    public GetServiceRequest zzb(zzq zzq) {
        if (zzq != null) {
            this.f4458e = zzq.asBinder();
        }
        return this;
    }

    public GetServiceRequest zzd(Account account) {
        this.f4461h = account;
        return this;
    }

    public GetServiceRequest zzf(Collection collection) {
        this.f4459f = (Scope[]) collection.toArray(new Scope[collection.size()]);
        return this;
    }

    public GetServiceRequest zzhl(String str) {
        this.f4457d = str;
        return this;
    }

    public GetServiceRequest zzn(Bundle bundle) {
        this.f4460g = bundle;
        return this;
    }
}
