package com.google.android.gms.maps.internal;

import android.os.IBinder;
import android.os.Parcel;
import com.google.android.gms.maps.model.internal.zzd;

/* renamed from: com.google.android.gms.maps.internal.o */
class C1201o implements zzf {

    /* renamed from: a */
    private IBinder f5100a;

    C1201o(IBinder iBinder) {
        this.f5100a = iBinder;
    }

    public IBinder asBinder() {
        return this.f5100a;
    }

    public void onIndoorBuildingFocused() {
        Parcel obtain = Parcel.obtain();
        Parcel obtain2 = Parcel.obtain();
        try {
            obtain.writeInterfaceToken("com.google.android.gms.maps.internal.IOnIndoorStateChangeListener");
            this.f5100a.transact(1, obtain, obtain2, 0);
            obtain2.readException();
        } finally {
            obtain2.recycle();
            obtain.recycle();
        }
    }

    public void zza(zzd zzd) {
        Parcel obtain = Parcel.obtain();
        Parcel obtain2 = Parcel.obtain();
        try {
            obtain.writeInterfaceToken("com.google.android.gms.maps.internal.IOnIndoorStateChangeListener");
            obtain.writeStrongBinder(zzd != null ? zzd.asBinder() : null);
            this.f5100a.transact(2, obtain, obtain2, 0);
            obtain2.readException();
        } finally {
            obtain2.recycle();
            obtain.recycle();
        }
    }
}
