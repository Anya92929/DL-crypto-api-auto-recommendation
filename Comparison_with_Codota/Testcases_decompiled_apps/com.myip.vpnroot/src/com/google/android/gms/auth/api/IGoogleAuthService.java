package com.google.android.gms.auth.api;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.auth.api.IGoogleAuthApiCallbacks;

public interface IGoogleAuthService extends IInterface {

    public static abstract class Stub extends Binder implements IGoogleAuthService {

        /* renamed from: com.google.android.gms.auth.api.IGoogleAuthService$Stub$a */
        private static class C0228a implements IGoogleAuthService {

            /* renamed from: lb */
            private IBinder f389lb;

            C0228a(IBinder iBinder) {
                this.f389lb = iBinder;
            }

            public IBinder asBinder() {
                return this.f389lb;
            }

            public void sendConnection(IGoogleAuthApiCallbacks callbacks, GoogleAuthApiRequest request) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(GoogleAuthApiClientImpl.SERVICE_DESCRIPTOR);
                    obtain.writeStrongBinder(callbacks != null ? callbacks.asBinder() : null);
                    if (request != null) {
                        obtain.writeInt(1);
                        request.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.f389lb.transact(1, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }
        }

        public Stub() {
            attachInterface(this, GoogleAuthApiClientImpl.SERVICE_DESCRIPTOR);
        }

        public static IGoogleAuthService asInterface(IBinder obj) {
            if (obj == null) {
                return null;
            }
            IInterface queryLocalInterface = obj.queryLocalInterface(GoogleAuthApiClientImpl.SERVICE_DESCRIPTOR);
            return (queryLocalInterface == null || !(queryLocalInterface instanceof IGoogleAuthService)) ? new C0228a(obj) : (IGoogleAuthService) queryLocalInterface;
        }

        public IBinder asBinder() {
            return this;
        }

        public boolean onTransact(int code, Parcel data, Parcel reply, int flags) throws RemoteException {
            switch (code) {
                case 1:
                    data.enforceInterface(GoogleAuthApiClientImpl.SERVICE_DESCRIPTOR);
                    sendConnection(IGoogleAuthApiCallbacks.Stub.asInterface(data.readStrongBinder()), data.readInt() != 0 ? GoogleAuthApiRequest.CREATOR.createFromParcel(data) : null);
                    reply.writeNoException();
                    return true;
                case 1598968902:
                    reply.writeString(GoogleAuthApiClientImpl.SERVICE_DESCRIPTOR);
                    return true;
                default:
                    return super.onTransact(code, data, reply, flags);
            }
        }
    }

    void sendConnection(IGoogleAuthApiCallbacks iGoogleAuthApiCallbacks, GoogleAuthApiRequest googleAuthApiRequest) throws RemoteException;
}
