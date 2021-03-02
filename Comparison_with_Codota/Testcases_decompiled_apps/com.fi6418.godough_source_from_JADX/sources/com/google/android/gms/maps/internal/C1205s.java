package com.google.android.gms.maps.internal;

import android.os.IBinder;
import android.os.Parcel;

/* renamed from: com.google.android.gms.maps.internal.s */
class C1205s implements zzj {

    /* renamed from: a */
    private IBinder f5104a;

    C1205s(IBinder iBinder) {
        this.f5104a = iBinder;
    }

    public IBinder asBinder() {
        return this.f5104a;
    }

    public void onMapLoaded() {
        Parcel obtain = Parcel.obtain();
        Parcel obtain2 = Parcel.obtain();
        try {
            obtain.writeInterfaceToken("com.google.android.gms.maps.internal.IOnMapLoadedCallback");
            this.f5104a.transact(1, obtain, obtain2, 0);
            obtain2.readException();
        } finally {
            obtain2.recycle();
            obtain.recycle();
        }
    }
}
