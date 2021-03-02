package com.google.android.gms.internal;

import android.os.Binder;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.identity.intents.UserAddressRequest;
import com.google.android.gms.internal.C1504lm;

/* renamed from: com.google.android.gms.internal.ln */
public interface C1507ln extends IInterface {

    /* renamed from: com.google.android.gms.internal.ln$a */
    public static abstract class C1508a extends Binder implements C1507ln {

        /* renamed from: com.google.android.gms.internal.ln$a$a */
        private static class C1509a implements C1507ln {

            /* renamed from: lb */
            private IBinder f4267lb;

            C1509a(IBinder iBinder) {
                this.f4267lb = iBinder;
            }

            /* renamed from: a */
            public void mo9231a(C1504lm lmVar, UserAddressRequest userAddressRequest, Bundle bundle) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.identity.intents.internal.IAddressService");
                    obtain.writeStrongBinder(lmVar != null ? lmVar.asBinder() : null);
                    if (userAddressRequest != null) {
                        obtain.writeInt(1);
                        userAddressRequest.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    if (bundle != null) {
                        obtain.writeInt(1);
                        bundle.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.f4267lb.transact(2, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public IBinder asBinder() {
                return this.f4267lb;
            }
        }

        /* renamed from: aH */
        public static C1507ln m5454aH(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.identity.intents.internal.IAddressService");
            return (queryLocalInterface == null || !(queryLocalInterface instanceof C1507ln)) ? new C1509a(iBinder) : (C1507ln) queryLocalInterface;
        }

        public boolean onTransact(int code, Parcel data, Parcel reply, int flags) throws RemoteException {
            switch (code) {
                case 2:
                    data.enforceInterface("com.google.android.gms.identity.intents.internal.IAddressService");
                    mo9231a(C1504lm.C1505a.m5451aG(data.readStrongBinder()), data.readInt() != 0 ? UserAddressRequest.CREATOR.createFromParcel(data) : null, data.readInt() != 0 ? (Bundle) Bundle.CREATOR.createFromParcel(data) : null);
                    reply.writeNoException();
                    return true;
                case 1598968902:
                    reply.writeString("com.google.android.gms.identity.intents.internal.IAddressService");
                    return true;
                default:
                    return super.onTransact(code, data, reply, flags);
            }
        }
    }

    /* renamed from: a */
    void mo9231a(C1504lm lmVar, UserAddressRequest userAddressRequest, Bundle bundle) throws RemoteException;
}
