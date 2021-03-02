package com.google.android.gms.ads.internal.reward.client;

import android.os.IBinder;
import android.os.Parcel;

/* renamed from: com.google.android.gms.ads.internal.reward.client.a */
class C1315a implements zza {

    /* renamed from: a */
    private IBinder f3967a;

    C1315a(IBinder iBinder) {
        this.f3967a = iBinder;
    }

    public IBinder asBinder() {
        return this.f3967a;
    }

    public int getAmount() {
        Parcel obtain = Parcel.obtain();
        Parcel obtain2 = Parcel.obtain();
        try {
            obtain.writeInterfaceToken("com.google.android.gms.ads.internal.reward.client.IRewardItem");
            this.f3967a.transact(2, obtain, obtain2, 0);
            obtain2.readException();
            return obtain2.readInt();
        } finally {
            obtain2.recycle();
            obtain.recycle();
        }
    }

    public String getType() {
        Parcel obtain = Parcel.obtain();
        Parcel obtain2 = Parcel.obtain();
        try {
            obtain.writeInterfaceToken("com.google.android.gms.ads.internal.reward.client.IRewardItem");
            this.f3967a.transact(1, obtain, obtain2, 0);
            obtain2.readException();
            return obtain2.readString();
        } finally {
            obtain2.recycle();
            obtain.recycle();
        }
    }
}
