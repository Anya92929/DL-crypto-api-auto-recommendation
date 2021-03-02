package com.google.android.gms.internal;

import android.os.IBinder;
import android.os.Parcel;
import com.google.android.gms.dynamic.zzd;

/* renamed from: com.google.android.gms.internal.jr */
class C1669jr implements zzhj {

    /* renamed from: a */
    private IBinder f5184a;

    C1669jr(IBinder iBinder) {
        this.f5184a = iBinder;
    }

    public IBinder asBinder() {
        return this.f5184a;
    }

    public IBinder zzn(zzd zzd) {
        Parcel obtain = Parcel.obtain();
        Parcel obtain2 = Parcel.obtain();
        try {
            obtain.writeInterfaceToken("com.google.android.gms.ads.internal.overlay.client.IAdOverlayCreator");
            obtain.writeStrongBinder(zzd != null ? zzd.asBinder() : null);
            this.f5184a.transact(1, obtain, obtain2, 0);
            obtain2.readException();
            return obtain2.readStrongBinder();
        } finally {
            obtain2.recycle();
            obtain.recycle();
        }
    }
}
