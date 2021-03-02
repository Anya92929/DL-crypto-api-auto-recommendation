package com.google.android.gms.common.internal;

import android.accounts.Account;
import android.os.Bundle;
import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.C0772b;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import java.util.Collection;

public class GetServiceRequest implements SafeParcelable {
    public static final Parcelable.Creator<GetServiceRequest> CREATOR = new C1036x();

    /* renamed from: a */
    final int f4653a;

    /* renamed from: b */
    final int f4654b;

    /* renamed from: c */
    int f4655c;

    /* renamed from: d */
    String f4656d;

    /* renamed from: e */
    IBinder f4657e;

    /* renamed from: f */
    Scope[] f4658f;

    /* renamed from: g */
    Bundle f4659g;

    /* renamed from: h */
    Account f4660h;

    public GetServiceRequest(int i) {
        this.f4653a = 2;
        this.f4655c = C0772b.f4563a;
        this.f4654b = i;
    }

    GetServiceRequest(int i, int i2, int i3, String str, IBinder iBinder, Scope[] scopeArr, Bundle bundle, Account account) {
        this.f4653a = i;
        this.f4654b = i2;
        this.f4655c = i3;
        this.f4656d = str;
        if (i < 2) {
            this.f4660h = m4342a(iBinder);
        } else {
            this.f4657e = iBinder;
            this.f4660h = account;
        }
        this.f4658f = scopeArr;
        this.f4659g = bundle;
    }

    /* renamed from: a */
    private Account m4342a(IBinder iBinder) {
        if (iBinder != null) {
            return C1003b.m4519a(C0994ar.m4420a(iBinder));
        }
        return null;
    }

    /* renamed from: a */
    public GetServiceRequest mo7473a(Account account) {
        this.f4660h = account;
        return this;
    }

    /* renamed from: a */
    public GetServiceRequest mo7474a(Bundle bundle) {
        this.f4659g = bundle;
        return this;
    }

    /* renamed from: a */
    public GetServiceRequest mo7475a(C0993aq aqVar) {
        if (aqVar != null) {
            this.f4657e = aqVar.asBinder();
        }
        return this;
    }

    /* renamed from: a */
    public GetServiceRequest mo7476a(String str) {
        this.f4656d = str;
        return this;
    }

    /* renamed from: a */
    public GetServiceRequest mo7477a(Collection<Scope> collection) {
        this.f4658f = (Scope[]) collection.toArray(new Scope[collection.size()]);
        return this;
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        C1036x.m4643a(this, parcel, i);
    }
}
