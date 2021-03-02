package com.google.android.gms.ads.internal.client;

import android.os.IBinder;
import android.os.Parcel;
import com.google.android.gms.dynamic.zzd;
import com.google.android.gms.internal.zzgj;

/* renamed from: com.google.android.gms.ads.internal.client.z */
class C1253z implements zzv {

    /* renamed from: a */
    private IBinder f3500a;

    C1253z(IBinder iBinder) {
        this.f3500a = iBinder;
    }

    public IBinder asBinder() {
        return this.f3500a;
    }

    public IBinder zza(zzd zzd, AdSizeParcel adSizeParcel, String str, zzgj zzgj, int i) {
        IBinder iBinder = null;
        Parcel obtain = Parcel.obtain();
        Parcel obtain2 = Parcel.obtain();
        try {
            obtain.writeInterfaceToken("com.google.android.gms.ads.internal.client.IAdManagerCreator");
            obtain.writeStrongBinder(zzd != null ? zzd.asBinder() : null);
            if (adSizeParcel != null) {
                obtain.writeInt(1);
                adSizeParcel.writeToParcel(obtain, 0);
            } else {
                obtain.writeInt(0);
            }
            obtain.writeString(str);
            if (zzgj != null) {
                iBinder = zzgj.asBinder();
            }
            obtain.writeStrongBinder(iBinder);
            obtain.writeInt(i);
            this.f3500a.transact(1, obtain, obtain2, 0);
            obtain2.readException();
            return obtain2.readStrongBinder();
        } finally {
            obtain2.recycle();
            obtain.recycle();
        }
    }

    public IBinder zza(zzd zzd, AdSizeParcel adSizeParcel, String str, zzgj zzgj, int i, int i2) {
        IBinder iBinder = null;
        Parcel obtain = Parcel.obtain();
        Parcel obtain2 = Parcel.obtain();
        try {
            obtain.writeInterfaceToken("com.google.android.gms.ads.internal.client.IAdManagerCreator");
            obtain.writeStrongBinder(zzd != null ? zzd.asBinder() : null);
            if (adSizeParcel != null) {
                obtain.writeInt(1);
                adSizeParcel.writeToParcel(obtain, 0);
            } else {
                obtain.writeInt(0);
            }
            obtain.writeString(str);
            if (zzgj != null) {
                iBinder = zzgj.asBinder();
            }
            obtain.writeStrongBinder(iBinder);
            obtain.writeInt(i);
            obtain.writeInt(i2);
            this.f3500a.transact(2, obtain, obtain2, 0);
            obtain2.readException();
            return obtain2.readStrongBinder();
        } finally {
            obtain2.recycle();
            obtain.recycle();
        }
    }
}
