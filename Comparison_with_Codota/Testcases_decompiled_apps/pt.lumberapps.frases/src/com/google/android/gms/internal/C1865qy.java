package com.google.android.gms.internal;

import android.os.IBinder;
import android.os.Parcel;
import com.google.android.gms.dynamic.zzd;

/* renamed from: com.google.android.gms.internal.qy */
class C1865qy implements zzty {

    /* renamed from: a */
    private IBinder f5531a;

    C1865qy(IBinder iBinder) {
        this.f5531a = iBinder;
    }

    public IBinder asBinder() {
        return this.f5531a;
    }

    public boolean getBooleanFlagValue(String str, boolean z, int i) {
        boolean z2 = true;
        Parcel obtain = Parcel.obtain();
        Parcel obtain2 = Parcel.obtain();
        try {
            obtain.writeInterfaceToken("com.google.android.gms.flags.IFlagProvider");
            obtain.writeString(str);
            obtain.writeInt(z ? 1 : 0);
            obtain.writeInt(i);
            this.f5531a.transact(2, obtain, obtain2, 0);
            obtain2.readException();
            if (obtain2.readInt() == 0) {
                z2 = false;
            }
            return z2;
        } finally {
            obtain2.recycle();
            obtain.recycle();
        }
    }

    public int getIntFlagValue(String str, int i, int i2) {
        Parcel obtain = Parcel.obtain();
        Parcel obtain2 = Parcel.obtain();
        try {
            obtain.writeInterfaceToken("com.google.android.gms.flags.IFlagProvider");
            obtain.writeString(str);
            obtain.writeInt(i);
            obtain.writeInt(i2);
            this.f5531a.transact(3, obtain, obtain2, 0);
            obtain2.readException();
            return obtain2.readInt();
        } finally {
            obtain2.recycle();
            obtain.recycle();
        }
    }

    public long getLongFlagValue(String str, long j, int i) {
        Parcel obtain = Parcel.obtain();
        Parcel obtain2 = Parcel.obtain();
        try {
            obtain.writeInterfaceToken("com.google.android.gms.flags.IFlagProvider");
            obtain.writeString(str);
            obtain.writeLong(j);
            obtain.writeInt(i);
            this.f5531a.transact(4, obtain, obtain2, 0);
            obtain2.readException();
            return obtain2.readLong();
        } finally {
            obtain2.recycle();
            obtain.recycle();
        }
    }

    public String getStringFlagValue(String str, String str2, int i) {
        Parcel obtain = Parcel.obtain();
        Parcel obtain2 = Parcel.obtain();
        try {
            obtain.writeInterfaceToken("com.google.android.gms.flags.IFlagProvider");
            obtain.writeString(str);
            obtain.writeString(str2);
            obtain.writeInt(i);
            this.f5531a.transact(5, obtain, obtain2, 0);
            obtain2.readException();
            return obtain2.readString();
        } finally {
            obtain2.recycle();
            obtain.recycle();
        }
    }

    public void init(zzd zzd) {
        Parcel obtain = Parcel.obtain();
        Parcel obtain2 = Parcel.obtain();
        try {
            obtain.writeInterfaceToken("com.google.android.gms.flags.IFlagProvider");
            obtain.writeStrongBinder(zzd != null ? zzd.asBinder() : null);
            this.f5531a.transact(1, obtain, obtain2, 0);
            obtain2.readException();
        } finally {
            obtain2.recycle();
            obtain.recycle();
        }
    }
}
