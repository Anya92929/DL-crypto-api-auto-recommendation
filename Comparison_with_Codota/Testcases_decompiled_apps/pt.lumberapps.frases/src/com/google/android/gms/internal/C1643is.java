package com.google.android.gms.internal;

import android.os.IBinder;
import android.os.Parcel;

/* renamed from: com.google.android.gms.internal.is */
class C1643is implements zzgm {

    /* renamed from: a */
    private IBinder f5153a;

    C1643is(IBinder iBinder) {
        this.f5153a = iBinder;
    }

    public IBinder asBinder() {
        return this.f5153a;
    }

    public int zzmm() {
        Parcel obtain = Parcel.obtain();
        Parcel obtain2 = Parcel.obtain();
        try {
            obtain.writeInterfaceToken("com.google.android.gms.ads.internal.mediation.client.IMediationResponseMetadata");
            this.f5153a.transact(1, obtain, obtain2, 0);
            obtain2.readException();
            return obtain2.readInt();
        } finally {
            obtain2.recycle();
            obtain.recycle();
        }
    }
}
