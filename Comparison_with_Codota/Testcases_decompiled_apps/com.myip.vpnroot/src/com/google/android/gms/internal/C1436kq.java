package com.google.android.gms.internal;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.fitness.result.SessionReadResult;

/* renamed from: com.google.android.gms.internal.kq */
public interface C1436kq extends IInterface {

    /* renamed from: com.google.android.gms.internal.kq$a */
    public static abstract class C1437a extends Binder implements C1436kq {

        /* renamed from: com.google.android.gms.internal.kq$a$a */
        private static class C1438a implements C1436kq {

            /* renamed from: lb */
            private IBinder f4193lb;

            C1438a(IBinder iBinder) {
                this.f4193lb = iBinder;
            }

            /* renamed from: a */
            public void mo9143a(SessionReadResult sessionReadResult) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.fitness.internal.ISessionReadCallback");
                    if (sessionReadResult != null) {
                        obtain.writeInt(1);
                        sessionReadResult.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.f4193lb.transact(1, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public IBinder asBinder() {
                return this.f4193lb;
            }
        }

        public C1437a() {
            attachInterface(this, "com.google.android.gms.fitness.internal.ISessionReadCallback");
        }

        /* renamed from: au */
        public static C1436kq m5325au(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.fitness.internal.ISessionReadCallback");
            return (queryLocalInterface == null || !(queryLocalInterface instanceof C1436kq)) ? new C1438a(iBinder) : (C1436kq) queryLocalInterface;
        }

        public IBinder asBinder() {
            return this;
        }

        public boolean onTransact(int code, Parcel data, Parcel reply, int flags) throws RemoteException {
            switch (code) {
                case 1:
                    data.enforceInterface("com.google.android.gms.fitness.internal.ISessionReadCallback");
                    mo9143a(data.readInt() != 0 ? SessionReadResult.CREATOR.createFromParcel(data) : null);
                    reply.writeNoException();
                    return true;
                case 1598968902:
                    reply.writeString("com.google.android.gms.fitness.internal.ISessionReadCallback");
                    return true;
                default:
                    return super.onTransact(code, data, reply, flags);
            }
        }
    }

    /* renamed from: a */
    void mo9143a(SessionReadResult sessionReadResult) throws RemoteException;
}
