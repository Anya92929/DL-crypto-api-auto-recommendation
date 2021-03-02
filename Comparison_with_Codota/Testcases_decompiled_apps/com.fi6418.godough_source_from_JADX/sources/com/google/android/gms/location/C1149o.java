package com.google.android.gms.location;

import android.os.IBinder;
import android.os.Parcel;

/* renamed from: com.google.android.gms.location.o */
class C1149o implements C1147m {

    /* renamed from: a */
    private IBinder f4983a;

    C1149o(IBinder iBinder) {
        this.f4983a = iBinder;
    }

    /* renamed from: a */
    public void mo7888a(LocationAvailability locationAvailability) {
        Parcel obtain = Parcel.obtain();
        try {
            obtain.writeInterfaceToken("com.google.android.gms.location.ILocationCallback");
            if (locationAvailability != null) {
                obtain.writeInt(1);
                locationAvailability.writeToParcel(obtain, 0);
            } else {
                obtain.writeInt(0);
            }
            this.f4983a.transact(2, obtain, (Parcel) null, 1);
        } finally {
            obtain.recycle();
        }
    }

    /* renamed from: a */
    public void mo7889a(LocationResult locationResult) {
        Parcel obtain = Parcel.obtain();
        try {
            obtain.writeInterfaceToken("com.google.android.gms.location.ILocationCallback");
            if (locationResult != null) {
                obtain.writeInt(1);
                locationResult.writeToParcel(obtain, 0);
            } else {
                obtain.writeInt(0);
            }
            this.f4983a.transact(1, obtain, (Parcel) null, 1);
        } finally {
            obtain.recycle();
        }
    }

    public IBinder asBinder() {
        return this.f4983a;
    }
}
