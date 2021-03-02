package com.google.android.gms.maps.internal;

import android.os.IBinder;
import android.os.Parcel;
import com.google.android.gms.maps.model.PointOfInterest;

/* renamed from: com.google.android.gms.maps.internal.z */
class C1212z implements zzq {

    /* renamed from: a */
    private IBinder f5111a;

    C1212z(IBinder iBinder) {
        this.f5111a = iBinder;
    }

    public IBinder asBinder() {
        return this.f5111a;
    }

    public void zza(PointOfInterest pointOfInterest) {
        Parcel obtain = Parcel.obtain();
        Parcel obtain2 = Parcel.obtain();
        try {
            obtain.writeInterfaceToken("com.google.android.gms.maps.internal.IOnPoiClickListener");
            if (pointOfInterest != null) {
                obtain.writeInt(1);
                pointOfInterest.writeToParcel(obtain, 0);
            } else {
                obtain.writeInt(0);
            }
            this.f5111a.transact(1, obtain, obtain2, 0);
            obtain2.readException();
        } finally {
            obtain2.recycle();
            obtain.recycle();
        }
    }
}
