package com.google.android.gms.location.internal;

import android.os.IBinder;
import android.os.Parcel;
import com.google.android.gms.location.LocationSettingsResult;

/* renamed from: com.google.android.gms.location.internal.n */
class C1134n implements C1132l {

    /* renamed from: a */
    private IBinder f4972a;

    C1134n(IBinder iBinder) {
        this.f4972a = iBinder;
    }

    /* renamed from: a */
    public void mo7880a(LocationSettingsResult locationSettingsResult) {
        Parcel obtain = Parcel.obtain();
        Parcel obtain2 = Parcel.obtain();
        try {
            obtain.writeInterfaceToken("com.google.android.gms.location.internal.ISettingsCallbacks");
            if (locationSettingsResult != null) {
                obtain.writeInt(1);
                locationSettingsResult.writeToParcel(obtain, 0);
            } else {
                obtain.writeInt(0);
            }
            this.f4972a.transact(1, obtain, obtain2, 0);
            obtain2.readException();
        } finally {
            obtain2.recycle();
            obtain.recycle();
        }
    }

    public IBinder asBinder() {
        return this.f4972a;
    }
}
