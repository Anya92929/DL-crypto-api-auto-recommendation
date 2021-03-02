package com.google.android.gms.internal;

import android.os.IBinder;
import android.os.Parcel;
import com.google.android.gms.dynamic.zzd;

/* renamed from: com.google.android.gms.internal.dq */
class C1506dq implements zzca {

    /* renamed from: a */
    private IBinder f4942a;

    C1506dq(IBinder iBinder) {
        this.f4942a = iBinder;
    }

    public IBinder asBinder() {
        return this.f4942a;
    }

    public zzd zza(zzd zzd, zzd zzd2) {
        IBinder iBinder = null;
        Parcel obtain = Parcel.obtain();
        Parcel obtain2 = Parcel.obtain();
        try {
            obtain.writeInterfaceToken("com.google.android.gms.ads.adshield.internal.IAdShieldClient");
            obtain.writeStrongBinder(zzd != null ? zzd.asBinder() : null);
            if (zzd2 != null) {
                iBinder = zzd2.asBinder();
            }
            obtain.writeStrongBinder(iBinder);
            this.f4942a.transact(6, obtain, obtain2, 0);
            obtain2.readException();
            return zzd.zza.zzfc(obtain2.readStrongBinder());
        } finally {
            obtain2.recycle();
            obtain.recycle();
        }
    }

    public String zza(zzd zzd, String str) {
        Parcel obtain = Parcel.obtain();
        Parcel obtain2 = Parcel.obtain();
        try {
            obtain.writeInterfaceToken("com.google.android.gms.ads.adshield.internal.IAdShieldClient");
            obtain.writeStrongBinder(zzd != null ? zzd.asBinder() : null);
            obtain.writeString(str);
            this.f4942a.transact(8, obtain, obtain2, 0);
            obtain2.readException();
            return obtain2.readString();
        } finally {
            obtain2.recycle();
            obtain.recycle();
        }
    }

    public boolean zza(zzd zzd) {
        boolean z = false;
        Parcel obtain = Parcel.obtain();
        Parcel obtain2 = Parcel.obtain();
        try {
            obtain.writeInterfaceToken("com.google.android.gms.ads.adshield.internal.IAdShieldClient");
            obtain.writeStrongBinder(zzd != null ? zzd.asBinder() : null);
            this.f4942a.transact(3, obtain, obtain2, 0);
            obtain2.readException();
            if (obtain2.readInt() != 0) {
                z = true;
            }
            return z;
        } finally {
            obtain2.recycle();
            obtain.recycle();
        }
    }

    public zzd zzb(zzd zzd, zzd zzd2) {
        IBinder iBinder = null;
        Parcel obtain = Parcel.obtain();
        Parcel obtain2 = Parcel.obtain();
        try {
            obtain.writeInterfaceToken("com.google.android.gms.ads.adshield.internal.IAdShieldClient");
            obtain.writeStrongBinder(zzd != null ? zzd.asBinder() : null);
            if (zzd2 != null) {
                iBinder = zzd2.asBinder();
            }
            obtain.writeStrongBinder(iBinder);
            this.f4942a.transact(10, obtain, obtain2, 0);
            obtain2.readException();
            return zzd.zza.zzfc(obtain2.readStrongBinder());
        } finally {
            obtain2.recycle();
            obtain.recycle();
        }
    }

    public void zzb(String str, String str2) {
        Parcel obtain = Parcel.obtain();
        Parcel obtain2 = Parcel.obtain();
        try {
            obtain.writeInterfaceToken("com.google.android.gms.ads.adshield.internal.IAdShieldClient");
            obtain.writeString(str);
            obtain.writeString(str2);
            this.f4942a.transact(2, obtain, obtain2, 0);
            obtain2.readException();
        } finally {
            obtain2.recycle();
            obtain.recycle();
        }
    }

    public boolean zzb(zzd zzd) {
        boolean z = false;
        Parcel obtain = Parcel.obtain();
        Parcel obtain2 = Parcel.obtain();
        try {
            obtain.writeInterfaceToken("com.google.android.gms.ads.adshield.internal.IAdShieldClient");
            obtain.writeStrongBinder(zzd != null ? zzd.asBinder() : null);
            this.f4942a.transact(4, obtain, obtain2, 0);
            obtain2.readException();
            if (obtain2.readInt() != 0) {
                z = true;
            }
            return z;
        } finally {
            obtain2.recycle();
            obtain.recycle();
        }
    }

    public boolean zzb(String str, boolean z) {
        boolean z2 = true;
        Parcel obtain = Parcel.obtain();
        Parcel obtain2 = Parcel.obtain();
        try {
            obtain.writeInterfaceToken("com.google.android.gms.ads.adshield.internal.IAdShieldClient");
            obtain.writeString(str);
            obtain.writeInt(z ? 1 : 0);
            this.f4942a.transact(11, obtain, obtain2, 0);
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

    public String zzc(zzd zzd) {
        Parcel obtain = Parcel.obtain();
        Parcel obtain2 = Parcel.obtain();
        try {
            obtain.writeInterfaceToken("com.google.android.gms.ads.adshield.internal.IAdShieldClient");
            obtain.writeStrongBinder(zzd != null ? zzd.asBinder() : null);
            this.f4942a.transact(7, obtain, obtain2, 0);
            obtain2.readException();
            return obtain2.readString();
        } finally {
            obtain2.recycle();
            obtain.recycle();
        }
    }

    public void zzd(zzd zzd) {
        Parcel obtain = Parcel.obtain();
        Parcel obtain2 = Parcel.obtain();
        try {
            obtain.writeInterfaceToken("com.google.android.gms.ads.adshield.internal.IAdShieldClient");
            obtain.writeStrongBinder(zzd != null ? zzd.asBinder() : null);
            this.f4942a.transact(9, obtain, obtain2, 0);
            obtain2.readException();
        } finally {
            obtain2.recycle();
            obtain.recycle();
        }
    }

    public String zzdf() {
        Parcel obtain = Parcel.obtain();
        Parcel obtain2 = Parcel.obtain();
        try {
            obtain.writeInterfaceToken("com.google.android.gms.ads.adshield.internal.IAdShieldClient");
            this.f4942a.transact(1, obtain, obtain2, 0);
            obtain2.readException();
            return obtain2.readString();
        } finally {
            obtain2.recycle();
            obtain.recycle();
        }
    }

    public void zzk(String str) {
        Parcel obtain = Parcel.obtain();
        Parcel obtain2 = Parcel.obtain();
        try {
            obtain.writeInterfaceToken("com.google.android.gms.ads.adshield.internal.IAdShieldClient");
            obtain.writeString(str);
            this.f4942a.transact(5, obtain, obtain2, 0);
            obtain2.readException();
        } finally {
            obtain2.recycle();
            obtain.recycle();
        }
    }
}
