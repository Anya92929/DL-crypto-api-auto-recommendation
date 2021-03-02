package com.google.android.gms.common.internal;

import android.os.IBinder;
import android.os.Parcel;
import com.google.android.gms.dynamic.zzd;

/* renamed from: com.google.android.gms.common.internal.y */
class C1386y implements zzs {

    /* renamed from: a */
    private IBinder f4512a;

    C1386y(IBinder iBinder) {
        this.f4512a = iBinder;
    }

    public IBinder asBinder() {
        return this.f4512a;
    }

    public zzd zzank() {
        Parcel obtain = Parcel.obtain();
        Parcel obtain2 = Parcel.obtain();
        try {
            obtain.writeInterfaceToken("com.google.android.gms.common.internal.ICertData");
            this.f4512a.transact(1, obtain, obtain2, 0);
            obtain2.readException();
            return zzd.zza.zzfc(obtain2.readStrongBinder());
        } finally {
            obtain2.recycle();
            obtain.recycle();
        }
    }

    public int zzanl() {
        Parcel obtain = Parcel.obtain();
        Parcel obtain2 = Parcel.obtain();
        try {
            obtain.writeInterfaceToken("com.google.android.gms.common.internal.ICertData");
            this.f4512a.transact(2, obtain, obtain2, 0);
            obtain2.readException();
            return obtain2.readInt();
        } finally {
            obtain2.recycle();
            obtain.recycle();
        }
    }
}
