package com.google.android.gms.drive.internal;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

/* renamed from: com.google.android.gms.drive.internal.ad */
public interface C0386ad extends IInterface {

    /* renamed from: com.google.android.gms.drive.internal.ad$a */
    public static abstract class C0387a extends Binder implements C0386ad {

        /* renamed from: com.google.android.gms.drive.internal.ad$a$a */
        private static class C0388a implements C0386ad {

            /* renamed from: lb */
            private IBinder f982lb;

            C0388a(IBinder iBinder) {
                this.f982lb = iBinder;
            }

            public IBinder asBinder() {
                return this.f982lb;
            }

            /* renamed from: c */
            public void mo4744c(OnEventResponse onEventResponse) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.drive.internal.IEventCallback");
                    if (onEventResponse != null) {
                        obtain.writeInt(1);
                        onEventResponse.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.f982lb.transact(1, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }
        }

        public C0387a() {
            attachInterface(this, "com.google.android.gms.drive.internal.IEventCallback");
        }

        /* renamed from: W */
        public static C0386ad m1123W(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.drive.internal.IEventCallback");
            return (queryLocalInterface == null || !(queryLocalInterface instanceof C0386ad)) ? new C0388a(iBinder) : (C0386ad) queryLocalInterface;
        }

        public IBinder asBinder() {
            return this;
        }

        public boolean onTransact(int code, Parcel data, Parcel reply, int flags) throws RemoteException {
            switch (code) {
                case 1:
                    data.enforceInterface("com.google.android.gms.drive.internal.IEventCallback");
                    mo4744c(data.readInt() != 0 ? OnEventResponse.CREATOR.createFromParcel(data) : null);
                    reply.writeNoException();
                    return true;
                case 1598968902:
                    reply.writeString("com.google.android.gms.drive.internal.IEventCallback");
                    return true;
                default:
                    return super.onTransact(code, data, reply, flags);
            }
        }
    }

    /* renamed from: c */
    void mo4744c(OnEventResponse onEventResponse) throws RemoteException;
}
