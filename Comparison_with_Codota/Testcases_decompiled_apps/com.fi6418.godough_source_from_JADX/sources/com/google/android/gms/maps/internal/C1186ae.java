package com.google.android.gms.maps.internal;

import android.os.IBinder;
import android.os.Parcel;

/* renamed from: com.google.android.gms.maps.internal.ae */
class C1186ae implements zzv {

    /* renamed from: a */
    private IBinder f5085a;

    C1186ae(IBinder iBinder) {
        this.f5085a = iBinder;
    }

    public IBinder asBinder() {
        return this.f5085a;
    }

    public void zza(IStreetViewPanoramaDelegate iStreetViewPanoramaDelegate) {
        Parcel obtain = Parcel.obtain();
        Parcel obtain2 = Parcel.obtain();
        try {
            obtain.writeInterfaceToken("com.google.android.gms.maps.internal.IOnStreetViewPanoramaReadyCallback");
            obtain.writeStrongBinder(iStreetViewPanoramaDelegate != null ? iStreetViewPanoramaDelegate.asBinder() : null);
            this.f5085a.transact(1, obtain, obtain2, 0);
            obtain2.readException();
        } finally {
            obtain2.recycle();
            obtain.recycle();
        }
    }
}
