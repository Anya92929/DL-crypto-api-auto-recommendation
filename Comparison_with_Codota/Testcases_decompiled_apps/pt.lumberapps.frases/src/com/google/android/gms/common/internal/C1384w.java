package com.google.android.gms.common.internal;

import android.accounts.Account;
import android.os.IBinder;
import android.os.Parcel;

/* renamed from: com.google.android.gms.common.internal.w */
class C1384w implements zzq {

    /* renamed from: a */
    private IBinder f4510a;

    C1384w(IBinder iBinder) {
        this.f4510a = iBinder;
    }

    public IBinder asBinder() {
        return this.f4510a;
    }

    public Account getAccount() {
        Parcel obtain = Parcel.obtain();
        Parcel obtain2 = Parcel.obtain();
        try {
            obtain.writeInterfaceToken("com.google.android.gms.common.internal.IAccountAccessor");
            this.f4510a.transact(2, obtain, obtain2, 0);
            obtain2.readException();
            return obtain2.readInt() != 0 ? (Account) Account.CREATOR.createFromParcel(obtain2) : null;
        } finally {
            obtain2.recycle();
            obtain.recycle();
        }
    }
}
