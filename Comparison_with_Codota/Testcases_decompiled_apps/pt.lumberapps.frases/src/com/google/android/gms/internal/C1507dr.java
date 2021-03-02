package com.google.android.gms.internal;

import android.os.IBinder;
import android.os.Parcel;
import com.google.android.gms.dynamic.zzd;

/* renamed from: com.google.android.gms.internal.dr */
class C1507dr implements zzcb {

    /* renamed from: a */
    private IBinder f4943a;

    C1507dr(IBinder iBinder) {
        this.f4943a = iBinder;
    }

    public IBinder asBinder() {
        return this.f4943a;
    }

    public IBinder zza(String str, zzd zzd) {
        Parcel obtain = Parcel.obtain();
        Parcel obtain2 = Parcel.obtain();
        try {
            obtain.writeInterfaceToken("com.google.android.gms.ads.adshield.internal.IAdShieldCreator");
            obtain.writeString(str);
            obtain.writeStrongBinder(zzd != null ? zzd.asBinder() : null);
            this.f4943a.transact(1, obtain, obtain2, 0);
            obtain2.readException();
            return obtain2.readStrongBinder();
        } finally {
            obtain2.recycle();
            obtain.recycle();
        }
    }

    public IBinder zzb(String str, zzd zzd) {
        Parcel obtain = Parcel.obtain();
        Parcel obtain2 = Parcel.obtain();
        try {
            obtain.writeInterfaceToken("com.google.android.gms.ads.adshield.internal.IAdShieldCreator");
            obtain.writeString(str);
            obtain.writeStrongBinder(zzd != null ? zzd.asBinder() : null);
            this.f4943a.transact(2, obtain, obtain2, 0);
            obtain2.readException();
            return obtain2.readStrongBinder();
        } finally {
            obtain2.recycle();
            obtain.recycle();
        }
    }
}
