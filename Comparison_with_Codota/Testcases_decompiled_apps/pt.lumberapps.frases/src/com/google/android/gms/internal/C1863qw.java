package com.google.android.gms.internal;

import android.os.IBinder;
import android.os.Parcel;
import com.google.android.gms.dynamic.zzd;

/* renamed from: com.google.android.gms.internal.qw */
class C1863qw implements zzsc {

    /* renamed from: a */
    private IBinder f5530a;

    C1863qw(IBinder iBinder) {
        this.f5530a = iBinder;
    }

    public IBinder asBinder() {
        return this.f5530a;
    }

    public int zza(zzd zzd, String str, boolean z) {
        int i = 0;
        Parcel obtain = Parcel.obtain();
        Parcel obtain2 = Parcel.obtain();
        try {
            obtain.writeInterfaceToken("com.google.android.gms.dynamite.IDynamiteLoader");
            obtain.writeStrongBinder(zzd != null ? zzd.asBinder() : null);
            obtain.writeString(str);
            if (z) {
                i = 1;
            }
            obtain.writeInt(i);
            this.f5530a.transact(3, obtain, obtain2, 0);
            obtain2.readException();
            return obtain2.readInt();
        } finally {
            obtain2.recycle();
            obtain.recycle();
        }
    }

    public zzd zza(zzd zzd, String str, int i) {
        Parcel obtain = Parcel.obtain();
        Parcel obtain2 = Parcel.obtain();
        try {
            obtain.writeInterfaceToken("com.google.android.gms.dynamite.IDynamiteLoader");
            obtain.writeStrongBinder(zzd != null ? zzd.asBinder() : null);
            obtain.writeString(str);
            obtain.writeInt(i);
            this.f5530a.transact(2, obtain, obtain2, 0);
            obtain2.readException();
            return zzd.zza.zzfc(obtain2.readStrongBinder());
        } finally {
            obtain2.recycle();
            obtain.recycle();
        }
    }

    public int zzd(zzd zzd, String str) {
        Parcel obtain = Parcel.obtain();
        Parcel obtain2 = Parcel.obtain();
        try {
            obtain.writeInterfaceToken("com.google.android.gms.dynamite.IDynamiteLoader");
            obtain.writeStrongBinder(zzd != null ? zzd.asBinder() : null);
            obtain.writeString(str);
            this.f5530a.transact(1, obtain, obtain2, 0);
            obtain2.readException();
            return obtain2.readInt();
        } finally {
            obtain2.recycle();
            obtain.recycle();
        }
    }
}
