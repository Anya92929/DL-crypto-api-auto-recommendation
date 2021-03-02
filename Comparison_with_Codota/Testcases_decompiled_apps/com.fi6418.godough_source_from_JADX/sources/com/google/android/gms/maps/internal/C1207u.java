package com.google.android.gms.maps.internal;

import android.os.IBinder;
import android.os.Parcel;

/* renamed from: com.google.android.gms.maps.internal.u */
class C1207u implements zzl {

    /* renamed from: a */
    private IBinder f5106a;

    C1207u(IBinder iBinder) {
        this.f5106a = iBinder;
    }

    public IBinder asBinder() {
        return this.f5106a;
    }

    public void zza(IGoogleMapDelegate iGoogleMapDelegate) {
        Parcel obtain = Parcel.obtain();
        Parcel obtain2 = Parcel.obtain();
        try {
            obtain.writeInterfaceToken("com.google.android.gms.maps.internal.IOnMapReadyCallback");
            obtain.writeStrongBinder(iGoogleMapDelegate != null ? iGoogleMapDelegate.asBinder() : null);
            this.f5106a.transact(1, obtain, obtain2, 0);
            obtain2.readException();
        } finally {
            obtain2.recycle();
            obtain.recycle();
        }
    }
}
