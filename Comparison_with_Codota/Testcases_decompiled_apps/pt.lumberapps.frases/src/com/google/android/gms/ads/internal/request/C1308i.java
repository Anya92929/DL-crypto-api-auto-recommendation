package com.google.android.gms.ads.internal.request;

import android.os.IBinder;
import android.os.Parcel;

/* renamed from: com.google.android.gms.ads.internal.request.i */
class C1308i implements zzk {

    /* renamed from: a */
    private IBinder f3922a;

    C1308i(IBinder iBinder) {
        this.f3922a = iBinder;
    }

    public IBinder asBinder() {
        return this.f3922a;
    }

    public void zza(AdRequestInfoParcel adRequestInfoParcel, zzl zzl) {
        Parcel obtain = Parcel.obtain();
        Parcel obtain2 = Parcel.obtain();
        try {
            obtain.writeInterfaceToken("com.google.android.gms.ads.internal.request.IAdRequestService");
            if (adRequestInfoParcel != null) {
                obtain.writeInt(1);
                adRequestInfoParcel.writeToParcel(obtain, 0);
            } else {
                obtain.writeInt(0);
            }
            obtain.writeStrongBinder(zzl != null ? zzl.asBinder() : null);
            this.f3922a.transact(2, obtain, obtain2, 0);
            obtain2.readException();
        } finally {
            obtain2.recycle();
            obtain.recycle();
        }
    }

    public AdResponseParcel zzd(AdRequestInfoParcel adRequestInfoParcel) {
        Parcel obtain = Parcel.obtain();
        Parcel obtain2 = Parcel.obtain();
        try {
            obtain.writeInterfaceToken("com.google.android.gms.ads.internal.request.IAdRequestService");
            if (adRequestInfoParcel != null) {
                obtain.writeInt(1);
                adRequestInfoParcel.writeToParcel(obtain, 0);
            } else {
                obtain.writeInt(0);
            }
            this.f3922a.transact(1, obtain, obtain2, 0);
            obtain2.readException();
            return obtain2.readInt() != 0 ? (AdResponseParcel) AdResponseParcel.CREATOR.createFromParcel(obtain2) : null;
        } finally {
            obtain2.recycle();
            obtain.recycle();
        }
    }
}
