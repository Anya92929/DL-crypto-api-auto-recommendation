package com.google.android.gms.ads.internal.client;

import android.os.IBinder;
import android.os.Parcel;
import com.google.android.gms.ads.internal.client.zzr;
import com.google.android.gms.ads.internal.formats.NativeAdOptionsParcel;
import com.google.android.gms.internal.zzeb;
import com.google.android.gms.internal.zzec;
import com.google.android.gms.internal.zzed;
import com.google.android.gms.internal.zzee;

/* renamed from: com.google.android.gms.ads.internal.client.w */
class C1250w implements zzs {

    /* renamed from: a */
    private IBinder f3497a;

    C1250w(IBinder iBinder) {
        this.f3497a = iBinder;
    }

    public IBinder asBinder() {
        return this.f3497a;
    }

    public void zza(NativeAdOptionsParcel nativeAdOptionsParcel) {
        Parcel obtain = Parcel.obtain();
        Parcel obtain2 = Parcel.obtain();
        try {
            obtain.writeInterfaceToken("com.google.android.gms.ads.internal.client.IAdLoaderBuilder");
            if (nativeAdOptionsParcel != null) {
                obtain.writeInt(1);
                nativeAdOptionsParcel.writeToParcel(obtain, 0);
            } else {
                obtain.writeInt(0);
            }
            this.f3497a.transact(6, obtain, obtain2, 0);
            obtain2.readException();
        } finally {
            obtain2.recycle();
            obtain.recycle();
        }
    }

    public void zza(zzeb zzeb) {
        Parcel obtain = Parcel.obtain();
        Parcel obtain2 = Parcel.obtain();
        try {
            obtain.writeInterfaceToken("com.google.android.gms.ads.internal.client.IAdLoaderBuilder");
            obtain.writeStrongBinder(zzeb != null ? zzeb.asBinder() : null);
            this.f3497a.transact(3, obtain, obtain2, 0);
            obtain2.readException();
        } finally {
            obtain2.recycle();
            obtain.recycle();
        }
    }

    public void zza(zzec zzec) {
        Parcel obtain = Parcel.obtain();
        Parcel obtain2 = Parcel.obtain();
        try {
            obtain.writeInterfaceToken("com.google.android.gms.ads.internal.client.IAdLoaderBuilder");
            obtain.writeStrongBinder(zzec != null ? zzec.asBinder() : null);
            this.f3497a.transact(4, obtain, obtain2, 0);
            obtain2.readException();
        } finally {
            obtain2.recycle();
            obtain.recycle();
        }
    }

    public void zza(String str, zzee zzee, zzed zzed) {
        IBinder iBinder = null;
        Parcel obtain = Parcel.obtain();
        Parcel obtain2 = Parcel.obtain();
        try {
            obtain.writeInterfaceToken("com.google.android.gms.ads.internal.client.IAdLoaderBuilder");
            obtain.writeString(str);
            obtain.writeStrongBinder(zzee != null ? zzee.asBinder() : null);
            if (zzed != null) {
                iBinder = zzed.asBinder();
            }
            obtain.writeStrongBinder(iBinder);
            this.f3497a.transact(5, obtain, obtain2, 0);
            obtain2.readException();
        } finally {
            obtain2.recycle();
            obtain.recycle();
        }
    }

    public void zzb(zzq zzq) {
        Parcel obtain = Parcel.obtain();
        Parcel obtain2 = Parcel.obtain();
        try {
            obtain.writeInterfaceToken("com.google.android.gms.ads.internal.client.IAdLoaderBuilder");
            obtain.writeStrongBinder(zzq != null ? zzq.asBinder() : null);
            this.f3497a.transact(2, obtain, obtain2, 0);
            obtain2.readException();
        } finally {
            obtain2.recycle();
            obtain.recycle();
        }
    }

    public void zzb(zzy zzy) {
        Parcel obtain = Parcel.obtain();
        Parcel obtain2 = Parcel.obtain();
        try {
            obtain.writeInterfaceToken("com.google.android.gms.ads.internal.client.IAdLoaderBuilder");
            obtain.writeStrongBinder(zzy != null ? zzy.asBinder() : null);
            this.f3497a.transact(7, obtain, obtain2, 0);
            obtain2.readException();
        } finally {
            obtain2.recycle();
            obtain.recycle();
        }
    }

    public zzr zzes() {
        Parcel obtain = Parcel.obtain();
        Parcel obtain2 = Parcel.obtain();
        try {
            obtain.writeInterfaceToken("com.google.android.gms.ads.internal.client.IAdLoaderBuilder");
            this.f3497a.transact(1, obtain, obtain2, 0);
            obtain2.readException();
            return zzr.zza.zzk(obtain2.readStrongBinder());
        } finally {
            obtain2.recycle();
            obtain.recycle();
        }
    }
}
