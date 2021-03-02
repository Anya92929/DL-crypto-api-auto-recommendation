package com.google.android.gms.common.internal;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;

/* renamed from: com.google.android.gms.common.internal.ba */
public abstract class C1004ba extends Binder implements C1002az {
    public C1004ba() {
        attachInterface(this, "com.google.android.gms.common.internal.IResolveAccountCallbacks");
    }

    /* renamed from: a */
    public static C1002az m4521a(IBinder iBinder) {
        if (iBinder == null) {
            return null;
        }
        IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.common.internal.IResolveAccountCallbacks");
        return (queryLocalInterface == null || !(queryLocalInterface instanceof C1002az)) ? new C1005bb(iBinder) : (C1002az) queryLocalInterface;
    }

    public IBinder asBinder() {
        return this;
    }

    public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) {
        switch (i) {
            case 2:
                parcel.enforceInterface("com.google.android.gms.common.internal.IResolveAccountCallbacks");
                mo7355a(parcel.readInt() != 0 ? ResolveAccountResponse.CREATOR.createFromParcel(parcel) : null);
                parcel2.writeNoException();
                return true;
            case 1598968902:
                parcel2.writeString("com.google.android.gms.common.internal.IResolveAccountCallbacks");
                return true;
            default:
                return super.onTransact(i, parcel, parcel2, i2);
        }
    }
}
