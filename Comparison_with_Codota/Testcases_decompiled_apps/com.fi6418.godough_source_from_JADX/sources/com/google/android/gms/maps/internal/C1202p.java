package com.google.android.gms.maps.internal;

import android.os.IBinder;
import android.os.Parcel;
import com.google.android.gms.maps.model.internal.zzf;

/* renamed from: com.google.android.gms.maps.internal.p */
class C1202p implements zzg {

    /* renamed from: a */
    private IBinder f5101a;

    C1202p(IBinder iBinder) {
        this.f5101a = iBinder;
    }

    public IBinder asBinder() {
        return this.f5101a;
    }

    public void zze(zzf zzf) {
        Parcel obtain = Parcel.obtain();
        Parcel obtain2 = Parcel.obtain();
        try {
            obtain.writeInterfaceToken("com.google.android.gms.maps.internal.IOnInfoWindowClickListener");
            obtain.writeStrongBinder(zzf != null ? zzf.asBinder() : null);
            this.f5101a.transact(1, obtain, obtain2, 0);
            obtain2.readException();
        } finally {
            obtain2.recycle();
            obtain.recycle();
        }
    }
}
