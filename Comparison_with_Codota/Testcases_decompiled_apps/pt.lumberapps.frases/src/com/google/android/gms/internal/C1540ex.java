package com.google.android.gms.internal;

import android.os.IBinder;
import android.os.Parcel;
import com.google.android.gms.dynamic.zzd;

/* renamed from: com.google.android.gms.internal.ex */
class C1540ex implements zzdu {

    /* renamed from: a */
    private IBinder f4979a;

    C1540ex(IBinder iBinder) {
        this.f4979a = iBinder;
    }

    public IBinder asBinder() {
        return this.f4979a;
    }

    public IBinder zza(zzd zzd, zzd zzd2, zzd zzd3, int i) {
        IBinder iBinder = null;
        Parcel obtain = Parcel.obtain();
        Parcel obtain2 = Parcel.obtain();
        try {
            obtain.writeInterfaceToken("com.google.android.gms.ads.internal.formats.client.INativeAdViewDelegateCreator");
            obtain.writeStrongBinder(zzd != null ? zzd.asBinder() : null);
            obtain.writeStrongBinder(zzd2 != null ? zzd2.asBinder() : null);
            if (zzd3 != null) {
                iBinder = zzd3.asBinder();
            }
            obtain.writeStrongBinder(iBinder);
            obtain.writeInt(i);
            this.f4979a.transact(1, obtain, obtain2, 0);
            obtain2.readException();
            return obtain2.readStrongBinder();
        } finally {
            obtain2.recycle();
            obtain.recycle();
        }
    }
}
