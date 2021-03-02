package com.google.android.gms.signin.internal;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.signin.GoogleSignInAccount;

/* renamed from: com.google.android.gms.signin.internal.g */
public abstract class C1256g extends Binder implements C1255f {
    public C1256g() {
        attachInterface(this, "com.google.android.gms.signin.internal.ISignInCallbacks");
    }

    /* renamed from: a */
    public static C1255f m5206a(IBinder iBinder) {
        if (iBinder == null) {
            return null;
        }
        IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.signin.internal.ISignInCallbacks");
        return (queryLocalInterface == null || !(queryLocalInterface instanceof C1255f)) ? new C1257h(iBinder) : (C1255f) queryLocalInterface;
    }

    public IBinder asBinder() {
        return this;
    }

    public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) {
        switch (i) {
            case 3:
                parcel.enforceInterface("com.google.android.gms.signin.internal.ISignInCallbacks");
                mo7456a(parcel.readInt() != 0 ? ConnectionResult.CREATOR.createFromParcel(parcel) : null, parcel.readInt() != 0 ? AuthAccountResult.CREATOR.createFromParcel(parcel) : null);
                parcel2.writeNoException();
                return true;
            case 4:
                parcel.enforceInterface("com.google.android.gms.signin.internal.ISignInCallbacks");
                mo9037a(parcel.readInt() != 0 ? Status.CREATOR.createFromParcel(parcel) : null);
                parcel2.writeNoException();
                return true;
            case 6:
                parcel.enforceInterface("com.google.android.gms.signin.internal.ISignInCallbacks");
                mo9039b(parcel.readInt() != 0 ? Status.CREATOR.createFromParcel(parcel) : null);
                parcel2.writeNoException();
                return true;
            case 7:
                parcel.enforceInterface("com.google.android.gms.signin.internal.ISignInCallbacks");
                mo9038a(parcel.readInt() != 0 ? Status.CREATOR.createFromParcel(parcel) : null, parcel.readInt() != 0 ? GoogleSignInAccount.CREATOR.createFromParcel(parcel) : null);
                parcel2.writeNoException();
                return true;
            case 1598968902:
                parcel2.writeString("com.google.android.gms.signin.internal.ISignInCallbacks");
                return true;
            default:
                return super.onTransact(i, parcel, parcel2, i2);
        }
    }
}
