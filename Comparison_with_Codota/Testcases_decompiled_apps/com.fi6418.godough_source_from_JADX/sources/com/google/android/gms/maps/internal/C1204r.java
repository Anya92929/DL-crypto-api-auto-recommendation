package com.google.android.gms.maps.internal;

import android.os.IBinder;
import android.os.Parcel;
import com.google.android.gms.maps.model.LatLng;

/* renamed from: com.google.android.gms.maps.internal.r */
class C1204r implements zzi {

    /* renamed from: a */
    private IBinder f5103a;

    C1204r(IBinder iBinder) {
        this.f5103a = iBinder;
    }

    public IBinder asBinder() {
        return this.f5103a;
    }

    public void onMapClick(LatLng latLng) {
        Parcel obtain = Parcel.obtain();
        Parcel obtain2 = Parcel.obtain();
        try {
            obtain.writeInterfaceToken("com.google.android.gms.maps.internal.IOnMapClickListener");
            if (latLng != null) {
                obtain.writeInt(1);
                latLng.writeToParcel(obtain, 0);
            } else {
                obtain.writeInt(0);
            }
            this.f5103a.transact(1, obtain, obtain2, 0);
            obtain2.readException();
        } finally {
            obtain2.recycle();
            obtain.recycle();
        }
    }
}
