package com.google.android.gms.internal;

import android.os.IBinder;
import android.os.Parcel;
import com.google.android.gms.common.api.Status;

/* renamed from: com.google.android.gms.internal.pl */
class C1825pl implements zzqg {

    /* renamed from: a */
    private IBinder f5497a;

    C1825pl(IBinder iBinder) {
        this.f5497a = iBinder;
    }

    public IBinder asBinder() {
        return this.f5497a;
    }

    public void zzp(Status status) {
        Parcel obtain = Parcel.obtain();
        try {
            obtain.writeInterfaceToken("com.google.android.gms.common.api.internal.IStatusCallback");
            if (status != null) {
                obtain.writeInt(1);
                status.writeToParcel(obtain, 0);
            } else {
                obtain.writeInt(0);
            }
            this.f5497a.transact(1, obtain, (Parcel) null, 1);
        } finally {
            obtain.recycle();
        }
    }
}
