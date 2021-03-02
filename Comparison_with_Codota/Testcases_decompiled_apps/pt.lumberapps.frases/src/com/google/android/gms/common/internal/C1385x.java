package com.google.android.gms.common.internal;

import android.os.IBinder;
import android.os.Parcel;

/* renamed from: com.google.android.gms.common.internal.x */
class C1385x implements zzr {

    /* renamed from: a */
    private IBinder f4511a;

    C1385x(IBinder iBinder) {
        this.f4511a = iBinder;
    }

    public IBinder asBinder() {
        return this.f4511a;
    }

    public void cancel() {
        Parcel obtain = Parcel.obtain();
        try {
            obtain.writeInterfaceToken("com.google.android.gms.common.internal.ICancelToken");
            this.f4511a.transact(2, obtain, (Parcel) null, 1);
        } finally {
            obtain.recycle();
        }
    }
}
