package com.google.android.gms.drive.realtime.internal;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.common.api.Status;

/* renamed from: com.google.android.gms.drive.realtime.internal.n */
public interface C0573n extends IInterface {

    /* renamed from: com.google.android.gms.drive.realtime.internal.n$a */
    public static abstract class C0574a extends Binder implements C0573n {

        /* renamed from: com.google.android.gms.drive.realtime.internal.n$a$a */
        private static class C0575a implements C0573n {

            /* renamed from: lb */
            private IBinder f1237lb;

            C0575a(IBinder iBinder) {
                this.f1237lb = iBinder;
            }

            public IBinder asBinder() {
                return this.f1237lb;
            }

            /* renamed from: bo */
            public void mo5457bo(String str) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.drive.realtime.internal.IStringCallback");
                    obtain.writeString(str);
                    this.f1237lb.transact(1, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            /* renamed from: o */
            public void mo5458o(Status status) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.drive.realtime.internal.IStringCallback");
                    if (status != null) {
                        obtain.writeInt(1);
                        status.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.f1237lb.transact(2, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }
        }

        /* renamed from: aj */
        public static C0573n m1691aj(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.drive.realtime.internal.IStringCallback");
            return (queryLocalInterface == null || !(queryLocalInterface instanceof C0573n)) ? new C0575a(iBinder) : (C0573n) queryLocalInterface;
        }

        public IBinder asBinder() {
            return this;
        }

        public boolean onTransact(int code, Parcel data, Parcel reply, int flags) throws RemoteException {
            switch (code) {
                case 1:
                    data.enforceInterface("com.google.android.gms.drive.realtime.internal.IStringCallback");
                    mo5457bo(data.readString());
                    reply.writeNoException();
                    return true;
                case 2:
                    data.enforceInterface("com.google.android.gms.drive.realtime.internal.IStringCallback");
                    mo5458o(data.readInt() != 0 ? Status.CREATOR.createFromParcel(data) : null);
                    reply.writeNoException();
                    return true;
                case 1598968902:
                    reply.writeString("com.google.android.gms.drive.realtime.internal.IStringCallback");
                    return true;
                default:
                    return super.onTransact(code, data, reply, flags);
            }
        }
    }

    /* renamed from: bo */
    void mo5457bo(String str) throws RemoteException;

    /* renamed from: o */
    void mo5458o(Status status) throws RemoteException;
}
