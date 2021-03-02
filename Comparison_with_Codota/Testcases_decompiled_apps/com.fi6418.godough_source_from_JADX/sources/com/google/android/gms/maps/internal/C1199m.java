package com.google.android.gms.maps.internal;

import android.os.IBinder;
import android.os.Parcel;
import com.google.android.gms.maps.model.internal.zzf;
import com.google.android.gms.p017b.C0605j;
import com.google.android.gms.p017b.C0606k;

/* renamed from: com.google.android.gms.maps.internal.m */
class C1199m implements zzd {

    /* renamed from: a */
    private IBinder f5098a;

    C1199m(IBinder iBinder) {
        this.f5098a = iBinder;
    }

    public IBinder asBinder() {
        return this.f5098a;
    }

    public C0605j zzf(zzf zzf) {
        Parcel obtain = Parcel.obtain();
        Parcel obtain2 = Parcel.obtain();
        try {
            obtain.writeInterfaceToken("com.google.android.gms.maps.internal.IInfoWindowAdapter");
            obtain.writeStrongBinder(zzf != null ? zzf.asBinder() : null);
            this.f5098a.transact(1, obtain, obtain2, 0);
            obtain2.readException();
            return C0606k.m3535a(obtain2.readStrongBinder());
        } finally {
            obtain2.recycle();
            obtain.recycle();
        }
    }

    public C0605j zzg(zzf zzf) {
        Parcel obtain = Parcel.obtain();
        Parcel obtain2 = Parcel.obtain();
        try {
            obtain.writeInterfaceToken("com.google.android.gms.maps.internal.IInfoWindowAdapter");
            obtain.writeStrongBinder(zzf != null ? zzf.asBinder() : null);
            this.f5098a.transact(2, obtain, obtain2, 0);
            obtain2.readException();
            return C0606k.m3535a(obtain2.readStrongBinder());
        } finally {
            obtain2.recycle();
            obtain.recycle();
        }
    }
}
