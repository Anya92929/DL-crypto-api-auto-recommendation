package com.google.android.gms.common.internal;

import android.os.IBinder;
import android.os.Parcel;
import com.google.android.gms.dynamic.zzd;

/* renamed from: com.google.android.gms.common.internal.ad */
class C1362ad implements zzx {

    /* renamed from: a */
    private IBinder f4485a;

    C1362ad(IBinder iBinder) {
        this.f4485a = iBinder;
    }

    public IBinder asBinder() {
        return this.f4485a;
    }

    public zzd zza(zzd zzd, int i, int i2) {
        Parcel obtain = Parcel.obtain();
        Parcel obtain2 = Parcel.obtain();
        try {
            obtain.writeInterfaceToken("com.google.android.gms.common.internal.ISignInButtonCreator");
            obtain.writeStrongBinder(zzd != null ? zzd.asBinder() : null);
            obtain.writeInt(i);
            obtain.writeInt(i2);
            this.f4485a.transact(1, obtain, obtain2, 0);
            obtain2.readException();
            return zzd.zza.zzfc(obtain2.readStrongBinder());
        } finally {
            obtain2.recycle();
            obtain.recycle();
        }
    }

    public zzd zza(zzd zzd, SignInButtonConfig signInButtonConfig) {
        Parcel obtain = Parcel.obtain();
        Parcel obtain2 = Parcel.obtain();
        try {
            obtain.writeInterfaceToken("com.google.android.gms.common.internal.ISignInButtonCreator");
            obtain.writeStrongBinder(zzd != null ? zzd.asBinder() : null);
            if (signInButtonConfig != null) {
                obtain.writeInt(1);
                signInButtonConfig.writeToParcel(obtain, 0);
            } else {
                obtain.writeInt(0);
            }
            this.f4485a.transact(2, obtain, obtain2, 0);
            obtain2.readException();
            return zzd.zza.zzfc(obtain2.readStrongBinder());
        } finally {
            obtain2.recycle();
            obtain.recycle();
        }
    }
}
