package com.google.android.gms.maps.internal;

import android.os.IBinder;
import android.os.Parcel;

/* renamed from: com.google.android.gms.maps.internal.k */
class C1197k implements zzb {

    /* renamed from: a */
    private IBinder f5096a;

    C1197k(IBinder iBinder) {
        this.f5096a = iBinder;
    }

    public IBinder asBinder() {
        return this.f5096a;
    }

    public void onCancel() {
        Parcel obtain = Parcel.obtain();
        Parcel obtain2 = Parcel.obtain();
        try {
            obtain.writeInterfaceToken("com.google.android.gms.maps.internal.ICancelableCallback");
            this.f5096a.transact(2, obtain, obtain2, 0);
            obtain2.readException();
        } finally {
            obtain2.recycle();
            obtain.recycle();
        }
    }

    public void onFinish() {
        Parcel obtain = Parcel.obtain();
        Parcel obtain2 = Parcel.obtain();
        try {
            obtain.writeInterfaceToken("com.google.android.gms.maps.internal.ICancelableCallback");
            this.f5096a.transact(1, obtain, obtain2, 0);
            obtain2.readException();
        } finally {
            obtain2.recycle();
            obtain.recycle();
        }
    }
}
