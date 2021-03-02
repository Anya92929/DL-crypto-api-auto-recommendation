package com.google.android.gms.maps.internal;

import android.os.IBinder;
import android.os.Parcel;
import com.google.android.gms.maps.model.CameraPosition;

/* renamed from: com.google.android.gms.maps.internal.n */
class C1200n implements zze {

    /* renamed from: a */
    private IBinder f5099a;

    C1200n(IBinder iBinder) {
        this.f5099a = iBinder;
    }

    public IBinder asBinder() {
        return this.f5099a;
    }

    public void onCameraChange(CameraPosition cameraPosition) {
        Parcel obtain = Parcel.obtain();
        Parcel obtain2 = Parcel.obtain();
        try {
            obtain.writeInterfaceToken("com.google.android.gms.maps.internal.IOnCameraChangeListener");
            if (cameraPosition != null) {
                obtain.writeInt(1);
                cameraPosition.writeToParcel(obtain, 0);
            } else {
                obtain.writeInt(0);
            }
            this.f5099a.transact(1, obtain, obtain2, 0);
            obtain2.readException();
        } finally {
            obtain2.recycle();
            obtain.recycle();
        }
    }
}
