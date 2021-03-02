package com.google.android.gms.maps.internal;

import android.os.IBinder;
import android.os.Parcel;
import com.google.android.gms.maps.model.StreetViewPanoramaLocation;

/* renamed from: com.google.android.gms.maps.internal.ab */
class C1183ab implements zzs {

    /* renamed from: a */
    private IBinder f5082a;

    C1183ab(IBinder iBinder) {
        this.f5082a = iBinder;
    }

    public IBinder asBinder() {
        return this.f5082a;
    }

    public void onStreetViewPanoramaChange(StreetViewPanoramaLocation streetViewPanoramaLocation) {
        Parcel obtain = Parcel.obtain();
        Parcel obtain2 = Parcel.obtain();
        try {
            obtain.writeInterfaceToken("com.google.android.gms.maps.internal.IOnStreetViewPanoramaChangeListener");
            if (streetViewPanoramaLocation != null) {
                obtain.writeInt(1);
                streetViewPanoramaLocation.writeToParcel(obtain, 0);
            } else {
                obtain.writeInt(0);
            }
            this.f5082a.transact(1, obtain, obtain2, 0);
            obtain2.readException();
        } finally {
            obtain2.recycle();
            obtain.recycle();
        }
    }
}
