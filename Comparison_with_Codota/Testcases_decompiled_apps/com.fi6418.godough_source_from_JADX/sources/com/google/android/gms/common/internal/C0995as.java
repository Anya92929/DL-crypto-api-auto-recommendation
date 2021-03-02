package com.google.android.gms.common.internal;

import android.accounts.Account;
import android.os.IBinder;
import android.os.Parcel;

/* renamed from: com.google.android.gms.common.internal.as */
class C0995as implements C0993aq {

    /* renamed from: a */
    private IBinder f4717a;

    C0995as(IBinder iBinder) {
        this.f4717a = iBinder;
    }

    /* renamed from: a */
    public Account mo7546a() {
        Parcel obtain = Parcel.obtain();
        Parcel obtain2 = Parcel.obtain();
        try {
            obtain.writeInterfaceToken("com.google.android.gms.common.internal.IAccountAccessor");
            this.f4717a.transact(2, obtain, obtain2, 0);
            obtain2.readException();
            return obtain2.readInt() != 0 ? (Account) Account.CREATOR.createFromParcel(obtain2) : null;
        } finally {
            obtain2.recycle();
            obtain.recycle();
        }
    }

    public IBinder asBinder() {
        return this.f4717a;
    }
}
