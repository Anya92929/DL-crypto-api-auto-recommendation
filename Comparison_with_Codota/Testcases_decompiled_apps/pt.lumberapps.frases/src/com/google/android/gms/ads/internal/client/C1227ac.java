package com.google.android.gms.ads.internal.client;

import android.os.IBinder;
import android.os.Parcel;

/* renamed from: com.google.android.gms.ads.internal.client.ac */
class C1227ac implements zzy {

    /* renamed from: a */
    private IBinder f3453a;

    C1227ac(IBinder iBinder) {
        this.f3453a = iBinder;
    }

    public IBinder asBinder() {
        return this.f3453a;
    }

    public long getValue() {
        Parcel obtain = Parcel.obtain();
        Parcel obtain2 = Parcel.obtain();
        try {
            obtain.writeInterfaceToken("com.google.android.gms.ads.internal.client.ICorrelationIdProvider");
            this.f3453a.transact(1, obtain, obtain2, 0);
            obtain2.readException();
            return obtain2.readLong();
        } finally {
            obtain2.recycle();
            obtain.recycle();
        }
    }
}
