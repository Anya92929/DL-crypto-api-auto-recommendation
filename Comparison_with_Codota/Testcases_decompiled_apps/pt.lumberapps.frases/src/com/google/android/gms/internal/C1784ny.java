package com.google.android.gms.internal;

import android.os.IBinder;
import android.os.Parcel;
import com.google.android.gms.common.api.Status;

/* renamed from: com.google.android.gms.internal.ny */
class C1784ny implements zzpe {

    /* renamed from: a */
    private IBinder f5410a;

    C1784ny(IBinder iBinder) {
        this.f5410a = iBinder;
    }

    public IBinder asBinder() {
        return this.f5410a;
    }

    public void zzw(Status status) {
        Parcel obtain = Parcel.obtain();
        try {
            obtain.writeInterfaceToken("com.google.android.gms.clearcut.internal.IClearcutLoggerCallbacks");
            if (status != null) {
                obtain.writeInt(1);
                status.writeToParcel(obtain, 0);
            } else {
                obtain.writeInt(0);
            }
            this.f5410a.transact(1, obtain, (Parcel) null, 1);
        } finally {
            obtain.recycle();
        }
    }
}
