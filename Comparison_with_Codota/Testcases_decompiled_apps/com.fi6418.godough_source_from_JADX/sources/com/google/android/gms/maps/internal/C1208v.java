package com.google.android.gms.maps.internal;

import android.os.IBinder;
import android.os.Parcel;
import com.google.android.gms.maps.model.internal.zzf;

/* renamed from: com.google.android.gms.maps.internal.v */
class C1208v implements zzm {

    /* renamed from: a */
    private IBinder f5107a;

    C1208v(IBinder iBinder) {
        this.f5107a = iBinder;
    }

    public IBinder asBinder() {
        return this.f5107a;
    }

    public boolean zza(zzf zzf) {
        boolean z = true;
        Parcel obtain = Parcel.obtain();
        Parcel obtain2 = Parcel.obtain();
        try {
            obtain.writeInterfaceToken("com.google.android.gms.maps.internal.IOnMarkerClickListener");
            obtain.writeStrongBinder(zzf != null ? zzf.asBinder() : null);
            this.f5107a.transact(1, obtain, obtain2, 0);
            obtain2.readException();
            if (obtain2.readInt() == 0) {
                z = false;
            }
            return z;
        } finally {
            obtain2.recycle();
            obtain.recycle();
        }
    }
}
