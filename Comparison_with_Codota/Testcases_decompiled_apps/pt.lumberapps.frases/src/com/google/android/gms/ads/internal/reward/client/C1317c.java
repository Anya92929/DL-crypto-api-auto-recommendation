package com.google.android.gms.ads.internal.reward.client;

import android.os.IBinder;
import android.os.Parcel;
import com.google.android.gms.dynamic.zzd;
import com.google.android.gms.internal.zzgj;

/* renamed from: com.google.android.gms.ads.internal.reward.client.c */
class C1317c implements zzc {

    /* renamed from: a */
    private IBinder f3969a;

    C1317c(IBinder iBinder) {
        this.f3969a = iBinder;
    }

    public IBinder asBinder() {
        return this.f3969a;
    }

    public IBinder zza(zzd zzd, zzgj zzgj, int i) {
        IBinder iBinder = null;
        Parcel obtain = Parcel.obtain();
        Parcel obtain2 = Parcel.obtain();
        try {
            obtain.writeInterfaceToken("com.google.android.gms.ads.internal.reward.client.IRewardedVideoAdCreator");
            obtain.writeStrongBinder(zzd != null ? zzd.asBinder() : null);
            if (zzgj != null) {
                iBinder = zzgj.asBinder();
            }
            obtain.writeStrongBinder(iBinder);
            obtain.writeInt(i);
            this.f3969a.transact(1, obtain, obtain2, 0);
            obtain2.readException();
            return obtain2.readStrongBinder();
        } finally {
            obtain2.recycle();
            obtain.recycle();
        }
    }
}
