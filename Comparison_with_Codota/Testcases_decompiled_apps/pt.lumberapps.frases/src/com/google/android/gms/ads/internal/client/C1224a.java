package com.google.android.gms.ads.internal.client;

import android.os.IBinder;
import android.os.Parcel;
import com.google.android.gms.dynamic.zzd;

/* renamed from: com.google.android.gms.ads.internal.client.a */
class C1224a implements zzaa {

    /* renamed from: a */
    private IBinder f3450a;

    C1224a(IBinder iBinder) {
        this.f3450a = iBinder;
    }

    public IBinder asBinder() {
        return this.f3450a;
    }

    public IBinder zza(zzd zzd, int i) {
        Parcel obtain = Parcel.obtain();
        Parcel obtain2 = Parcel.obtain();
        try {
            obtain.writeInterfaceToken("com.google.android.gms.ads.internal.client.IMobileAdsSettingManagerCreator");
            obtain.writeStrongBinder(zzd != null ? zzd.asBinder() : null);
            obtain.writeInt(i);
            this.f3450a.transact(1, obtain, obtain2, 0);
            obtain2.readException();
            return obtain2.readStrongBinder();
        } finally {
            obtain2.recycle();
            obtain.recycle();
        }
    }
}
