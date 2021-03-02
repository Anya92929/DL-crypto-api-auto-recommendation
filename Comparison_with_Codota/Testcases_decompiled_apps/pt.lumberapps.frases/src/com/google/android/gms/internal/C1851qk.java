package com.google.android.gms.internal;

import android.os.IBinder;
import android.os.Parcel;

/* renamed from: com.google.android.gms.internal.qk */
class C1851qk implements zzrj {

    /* renamed from: a */
    private IBinder f5519a;

    C1851qk(IBinder iBinder) {
        this.f5519a = iBinder;
    }

    public IBinder asBinder() {
        return this.f5519a;
    }

    public void zzgn(int i) {
        Parcel obtain = Parcel.obtain();
        Parcel obtain2 = Parcel.obtain();
        try {
            obtain.writeInterfaceToken("com.google.android.gms.common.internal.service.ICommonCallbacks");
            obtain.writeInt(i);
            this.f5519a.transact(1, obtain, obtain2, 0);
            obtain2.readException();
        } finally {
            obtain2.recycle();
            obtain.recycle();
        }
    }
}
