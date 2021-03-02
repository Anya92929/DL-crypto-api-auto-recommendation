package com.google.android.gms.maps.internal;

import android.os.IBinder;
import android.os.Parcel;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.VisibleRegion;
import com.google.android.gms.p017b.C0605j;
import com.google.android.gms.p017b.C0606k;

/* renamed from: com.google.android.gms.maps.internal.f */
class C1192f implements IProjectionDelegate {

    /* renamed from: a */
    private IBinder f5091a;

    C1192f(IBinder iBinder) {
        this.f5091a = iBinder;
    }

    public IBinder asBinder() {
        return this.f5091a;
    }

    public LatLng fromScreenLocation(C0605j jVar) {
        LatLng latLng = null;
        Parcel obtain = Parcel.obtain();
        Parcel obtain2 = Parcel.obtain();
        try {
            obtain.writeInterfaceToken("com.google.android.gms.maps.internal.IProjectionDelegate");
            obtain.writeStrongBinder(jVar != null ? jVar.asBinder() : null);
            this.f5091a.transact(1, obtain, obtain2, 0);
            obtain2.readException();
            if (obtain2.readInt() != 0) {
                latLng = LatLng.CREATOR.createFromParcel(obtain2);
            }
            return latLng;
        } finally {
            obtain2.recycle();
            obtain.recycle();
        }
    }

    public VisibleRegion getVisibleRegion() {
        Parcel obtain = Parcel.obtain();
        Parcel obtain2 = Parcel.obtain();
        try {
            obtain.writeInterfaceToken("com.google.android.gms.maps.internal.IProjectionDelegate");
            this.f5091a.transact(3, obtain, obtain2, 0);
            obtain2.readException();
            return obtain2.readInt() != 0 ? VisibleRegion.CREATOR.createFromParcel(obtain2) : null;
        } finally {
            obtain2.recycle();
            obtain.recycle();
        }
    }

    public C0605j toScreenLocation(LatLng latLng) {
        Parcel obtain = Parcel.obtain();
        Parcel obtain2 = Parcel.obtain();
        try {
            obtain.writeInterfaceToken("com.google.android.gms.maps.internal.IProjectionDelegate");
            if (latLng != null) {
                obtain.writeInt(1);
                latLng.writeToParcel(obtain, 0);
            } else {
                obtain.writeInt(0);
            }
            this.f5091a.transact(2, obtain, obtain2, 0);
            obtain2.readException();
            return C0606k.m3535a(obtain2.readStrongBinder());
        } finally {
            obtain2.recycle();
            obtain.recycle();
        }
    }
}
