package com.google.android.gms.internal;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.fitness.result.DataTypeResult;

/* renamed from: com.google.android.gms.internal.kn */
public interface C1427kn extends IInterface {

    /* renamed from: com.google.android.gms.internal.kn$a */
    public static abstract class C1428a extends Binder implements C1427kn {

        /* renamed from: com.google.android.gms.internal.kn$a$a */
        private static class C1429a implements C1427kn {

            /* renamed from: lb */
            private IBinder f4190lb;

            C1429a(IBinder iBinder) {
                this.f4190lb = iBinder;
            }

            /* renamed from: a */
            public void mo9109a(DataTypeResult dataTypeResult) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.fitness.internal.IDataTypeCallback");
                    if (dataTypeResult != null) {
                        obtain.writeInt(1);
                        dataTypeResult.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.f4190lb.transact(1, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public IBinder asBinder() {
                return this.f4190lb;
            }
        }

        public C1428a() {
            attachInterface(this, "com.google.android.gms.fitness.internal.IDataTypeCallback");
        }

        /* renamed from: ar */
        public static C1427kn m5270ar(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.fitness.internal.IDataTypeCallback");
            return (queryLocalInterface == null || !(queryLocalInterface instanceof C1427kn)) ? new C1429a(iBinder) : (C1427kn) queryLocalInterface;
        }

        public IBinder asBinder() {
            return this;
        }

        public boolean onTransact(int code, Parcel data, Parcel reply, int flags) throws RemoteException {
            switch (code) {
                case 1:
                    data.enforceInterface("com.google.android.gms.fitness.internal.IDataTypeCallback");
                    mo9109a(data.readInt() != 0 ? DataTypeResult.CREATOR.createFromParcel(data) : null);
                    reply.writeNoException();
                    return true;
                case 1598968902:
                    reply.writeString("com.google.android.gms.fitness.internal.IDataTypeCallback");
                    return true;
                default:
                    return super.onTransact(code, data, reply, flags);
            }
        }
    }

    /* renamed from: a */
    void mo9109a(DataTypeResult dataTypeResult) throws RemoteException;
}
