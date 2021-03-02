package com.google.android.gms.maps.internal;

import android.os.IBinder;
import android.os.Parcel;
import com.google.android.gms.maps.model.internal.zzf;

/* renamed from: com.google.android.gms.maps.internal.w */
class C1209w implements zzn {

    /* renamed from: a */
    private IBinder f5108a;

    C1209w(IBinder iBinder) {
        this.f5108a = iBinder;
    }

    public IBinder asBinder() {
        return this.f5108a;
    }

    public void zzb(zzf zzf) {
        Parcel obtain = Parcel.obtain();
        Parcel obtain2 = Parcel.obtain();
        try {
            obtain.writeInterfaceToken("com.google.android.gms.maps.internal.IOnMarkerDragListener");
            obtain.writeStrongBinder(zzf != null ? zzf.asBinder() : null);
            this.f5108a.transact(1, obtain, obtain2, 0);
            obtain2.readException();
        } finally {
            obtain2.recycle();
            obtain.recycle();
        }
    }

    public void zzc(zzf zzf) {
        Parcel obtain = Parcel.obtain();
        Parcel obtain2 = Parcel.obtain();
        try {
            obtain.writeInterfaceToken("com.google.android.gms.maps.internal.IOnMarkerDragListener");
            obtain.writeStrongBinder(zzf != null ? zzf.asBinder() : null);
            this.f5108a.transact(3, obtain, obtain2, 0);
            obtain2.readException();
        } finally {
            obtain2.recycle();
            obtain.recycle();
        }
    }

    public void zzd(zzf zzf) {
        Parcel obtain = Parcel.obtain();
        Parcel obtain2 = Parcel.obtain();
        try {
            obtain.writeInterfaceToken("com.google.android.gms.maps.internal.IOnMarkerDragListener");
            obtain.writeStrongBinder(zzf != null ? zzf.asBinder() : null);
            this.f5108a.transact(2, obtain, obtain2, 0);
            obtain2.readException();
        } finally {
            obtain2.recycle();
            obtain.recycle();
        }
    }
}
