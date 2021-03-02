package com.google.android.gms.maps.internal;

import android.location.Location;
import android.os.IBinder;
import android.os.Parcel;
import com.google.android.gms.p017b.C0605j;

/* renamed from: com.google.android.gms.maps.internal.q */
class C1203q implements zzh {

    /* renamed from: a */
    private IBinder f5102a;

    C1203q(IBinder iBinder) {
        this.f5102a = iBinder;
    }

    public IBinder asBinder() {
        return this.f5102a;
    }

    public void zzc(Location location) {
        Parcel obtain = Parcel.obtain();
        Parcel obtain2 = Parcel.obtain();
        try {
            obtain.writeInterfaceToken("com.google.android.gms.maps.internal.IOnLocationChangeListener");
            if (location != null) {
                obtain.writeInt(1);
                location.writeToParcel(obtain, 0);
            } else {
                obtain.writeInt(0);
            }
            this.f5102a.transact(2, obtain, obtain2, 0);
            obtain2.readException();
        } finally {
            obtain2.recycle();
            obtain.recycle();
        }
    }

    public void zzv(C0605j jVar) {
        Parcel obtain = Parcel.obtain();
        Parcel obtain2 = Parcel.obtain();
        try {
            obtain.writeInterfaceToken("com.google.android.gms.maps.internal.IOnLocationChangeListener");
            obtain.writeStrongBinder(jVar != null ? jVar.asBinder() : null);
            this.f5102a.transact(1, obtain, obtain2, 0);
            obtain2.readException();
        } finally {
            obtain2.recycle();
            obtain.recycle();
        }
    }
}
