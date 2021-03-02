package com.google.android.gms.analytics.internal;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;

/* renamed from: com.google.android.gms.analytics.internal.f */
public abstract class C0558f extends Binder implements C0557e {
    /* renamed from: a */
    public static C0557e m3252a(IBinder iBinder) {
        if (iBinder == null) {
            return null;
        }
        IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.analytics.internal.IAnalyticsService");
        return (queryLocalInterface == null || !(queryLocalInterface instanceof C0557e)) ? new C0559g(iBinder) : (C0557e) queryLocalInterface;
    }

    public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) {
        switch (i) {
            case 1:
                parcel.enforceInterface("com.google.android.gms.analytics.internal.IAnalyticsService");
                mo6797a(parcel.readHashMap(getClass().getClassLoader()), parcel.readLong(), parcel.readString(), parcel.createTypedArrayList(Command.CREATOR));
                parcel2.writeNoException();
                return true;
            case 2:
                parcel.enforceInterface("com.google.android.gms.analytics.internal.IAnalyticsService");
                mo6796a();
                parcel2.writeNoException();
                return true;
            case 3:
                parcel.enforceInterface("com.google.android.gms.analytics.internal.IAnalyticsService");
                String b = mo6798b();
                parcel2.writeNoException();
                parcel2.writeString(b);
                return true;
            case 1598968902:
                parcel2.writeString("com.google.android.gms.analytics.internal.IAnalyticsService");
                return true;
            default:
                return super.onTransact(i, parcel, parcel2, i2);
        }
    }
}
