package com.google.android.gms.common.internal;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import java.util.Set;

public class AuthAccountRequest implements SafeParcelable {
    public static final Parcelable.Creator<AuthAccountRequest> CREATOR = new C1014e();

    /* renamed from: a */
    final int f4649a;

    /* renamed from: b */
    final IBinder f4650b;

    /* renamed from: c */
    final Scope[] f4651c;

    AuthAccountRequest(int i, IBinder iBinder, Scope[] scopeArr) {
        this.f4649a = i;
        this.f4650b = iBinder;
        this.f4651c = scopeArr;
    }

    public AuthAccountRequest(C0993aq aqVar, Set<Scope> set) {
        this(1, aqVar.asBinder(), (Scope[]) set.toArray(new Scope[set.size()]));
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        C1014e.m4552a(this, parcel, i);
    }
}
