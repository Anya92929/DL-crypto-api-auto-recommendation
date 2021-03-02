package com.google.android.gms.maps.internal;

import android.os.IBinder;
import android.os.Parcel;

/* renamed from: com.google.android.gms.maps.internal.x */
class C1210x implements zzo {

    /* renamed from: a */
    private IBinder f5109a;

    C1210x(IBinder iBinder) {
        this.f5109a = iBinder;
    }

    public IBinder asBinder() {
        return this.f5109a;
    }

    public boolean onMyLocationButtonClick() {
        boolean z = true;
        Parcel obtain = Parcel.obtain();
        Parcel obtain2 = Parcel.obtain();
        try {
            obtain.writeInterfaceToken("com.google.android.gms.maps.internal.IOnMyLocationButtonClickListener");
            this.f5109a.transact(1, obtain, obtain2, 0);
            obtain2.readException();
            if (obtain2.readInt() == 0) {
                z = false;
            }
            return z;
        } finally {
            obtain2.recycle();
            obtain.recycle();
        }
    }
}
