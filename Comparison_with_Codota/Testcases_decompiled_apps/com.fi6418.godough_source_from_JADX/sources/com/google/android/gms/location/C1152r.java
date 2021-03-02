package com.google.android.gms.location;

import android.location.Location;
import android.os.IBinder;
import android.os.Parcel;

/* renamed from: com.google.android.gms.location.r */
class C1152r implements C1150p {

    /* renamed from: a */
    private IBinder f4984a;

    C1152r(IBinder iBinder) {
        this.f4984a = iBinder;
    }

    /* renamed from: a */
    public void mo7890a(Location location) {
        Parcel obtain = Parcel.obtain();
        try {
            obtain.writeInterfaceToken("com.google.android.gms.location.ILocationListener");
            if (location != null) {
                obtain.writeInt(1);
                location.writeToParcel(obtain, 0);
            } else {
                obtain.writeInt(0);
            }
            this.f4984a.transact(1, obtain, (Parcel) null, 1);
        } finally {
            obtain.recycle();
        }
    }

    public IBinder asBinder() {
        return this.f4984a;
    }
}
