package com.google.android.gms.maps.internal;

import android.os.IBinder;
import android.os.Parcel;
import com.google.android.gms.maps.model.StreetViewPanoramaOrientation;

/* renamed from: com.google.android.gms.maps.internal.ac */
class C1184ac implements zzt {

    /* renamed from: a */
    private IBinder f5083a;

    C1184ac(IBinder iBinder) {
        this.f5083a = iBinder;
    }

    public IBinder asBinder() {
        return this.f5083a;
    }

    public void onStreetViewPanoramaClick(StreetViewPanoramaOrientation streetViewPanoramaOrientation) {
        Parcel obtain = Parcel.obtain();
        Parcel obtain2 = Parcel.obtain();
        try {
            obtain.writeInterfaceToken("com.google.android.gms.maps.internal.IOnStreetViewPanoramaClickListener");
            if (streetViewPanoramaOrientation != null) {
                obtain.writeInt(1);
                streetViewPanoramaOrientation.writeToParcel(obtain, 0);
            } else {
                obtain.writeInt(0);
            }
            this.f5083a.transact(1, obtain, obtain2, 0);
            obtain2.readException();
        } finally {
            obtain2.recycle();
            obtain.recycle();
        }
    }
}
