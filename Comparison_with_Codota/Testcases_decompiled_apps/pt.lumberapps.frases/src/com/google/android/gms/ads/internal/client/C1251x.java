package com.google.android.gms.ads.internal.client;

import android.os.IBinder;
import android.os.Parcel;
import com.google.android.gms.dynamic.zzd;
import com.google.android.gms.internal.zzgj;

/* renamed from: com.google.android.gms.ads.internal.client.x */
class C1251x implements zzt {

    /* renamed from: a */
    private IBinder f3498a;

    C1251x(IBinder iBinder) {
        this.f3498a = iBinder;
    }

    public IBinder asBinder() {
        return this.f3498a;
    }

    public IBinder zza(zzd zzd, String str, zzgj zzgj, int i) {
        IBinder iBinder = null;
        Parcel obtain = Parcel.obtain();
        Parcel obtain2 = Parcel.obtain();
        try {
            obtain.writeInterfaceToken("com.google.android.gms.ads.internal.client.IAdLoaderBuilderCreator");
            obtain.writeStrongBinder(zzd != null ? zzd.asBinder() : null);
            obtain.writeString(str);
            if (zzgj != null) {
                iBinder = zzgj.asBinder();
            }
            obtain.writeStrongBinder(iBinder);
            obtain.writeInt(i);
            this.f3498a.transact(1, obtain, obtain2, 0);
            obtain2.readException();
            return obtain2.readStrongBinder();
        } finally {
            obtain2.recycle();
            obtain.recycle();
        }
    }
}
