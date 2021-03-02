package com.google.android.gms.p018c;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;

/* renamed from: com.google.android.gms.c.e */
public abstract class C0663e extends Binder implements C0662d {
    /* renamed from: a */
    public static C0662d m3848a(IBinder iBinder) {
        if (iBinder == null) {
            return null;
        }
        IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.ads.identifier.internal.IAdvertisingIdService");
        return (queryLocalInterface == null || !(queryLocalInterface instanceof C0662d)) ? new C0664f(iBinder) : (C0662d) queryLocalInterface;
    }

    public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) {
        boolean z = false;
        switch (i) {
            case 1:
                parcel.enforceInterface("com.google.android.gms.ads.identifier.internal.IAdvertisingIdService");
                String a = mo7199a();
                parcel2.writeNoException();
                parcel2.writeString(a);
                return true;
            case 2:
                parcel.enforceInterface("com.google.android.gms.ads.identifier.internal.IAdvertisingIdService");
                boolean a2 = mo7202a(parcel.readInt() != 0);
                parcel2.writeNoException();
                if (a2) {
                    z = true;
                }
                parcel2.writeInt(z ? 1 : 0);
                return true;
            case 3:
                parcel.enforceInterface("com.google.android.gms.ads.identifier.internal.IAdvertisingIdService");
                String a3 = mo7200a(parcel.readString());
                parcel2.writeNoException();
                parcel2.writeString(a3);
                return true;
            case 4:
                parcel.enforceInterface("com.google.android.gms.ads.identifier.internal.IAdvertisingIdService");
                String readString = parcel.readString();
                if (parcel.readInt() != 0) {
                    z = true;
                }
                mo7201a(readString, z);
                parcel2.writeNoException();
                return true;
            case 1598968902:
                parcel2.writeString("com.google.android.gms.ads.identifier.internal.IAdvertisingIdService");
                return true;
            default:
                return super.onTransact(i, parcel, parcel2, i2);
        }
    }
}
