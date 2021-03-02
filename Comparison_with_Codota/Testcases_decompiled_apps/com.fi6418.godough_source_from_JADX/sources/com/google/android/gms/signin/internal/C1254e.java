package com.google.android.gms.signin.internal;

import android.os.Binder;
import android.os.IBinder;
import android.os.Parcel;
import com.google.android.gms.common.api.Scope;
import java.util.List;

/* renamed from: com.google.android.gms.signin.internal.e */
public abstract class C1254e extends Binder implements C1253d {
    public C1254e() {
        attachInterface(this, "com.google.android.gms.signin.internal.IOfflineAccessCallbacks");
    }

    public IBinder asBinder() {
        return this;
    }

    public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) {
        switch (i) {
            case 2:
                parcel.enforceInterface("com.google.android.gms.signin.internal.IOfflineAccessCallbacks");
                mo9045a(parcel.readString(), (List<Scope>) parcel.createTypedArrayList(Scope.CREATOR), C1259j.m5220a(parcel.readStrongBinder()));
                parcel2.writeNoException();
                return true;
            case 3:
                parcel.enforceInterface("com.google.android.gms.signin.internal.IOfflineAccessCallbacks");
                mo9044a(parcel.readString(), parcel.readString(), C1259j.m5220a(parcel.readStrongBinder()));
                parcel2.writeNoException();
                return true;
            case 1598968902:
                parcel2.writeString("com.google.android.gms.signin.internal.IOfflineAccessCallbacks");
                return true;
            default:
                return super.onTransact(i, parcel, parcel2, i2);
        }
    }
}
