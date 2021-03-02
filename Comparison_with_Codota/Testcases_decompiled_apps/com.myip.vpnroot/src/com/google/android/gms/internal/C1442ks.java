package com.google.android.gms.internal;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.common.api.Status;

/* renamed from: com.google.android.gms.internal.ks */
public interface C1442ks extends IInterface {

    /* renamed from: com.google.android.gms.internal.ks$a */
    public static abstract class C1443a extends Binder implements C1442ks {

        /* renamed from: com.google.android.gms.internal.ks$a$a */
        private static class C1444a implements C1442ks {

            /* renamed from: lb */
            private IBinder f4195lb;

            C1444a(IBinder iBinder) {
                this.f4195lb = iBinder;
            }

            public IBinder asBinder() {
                return this.f4195lb;
            }

            /* renamed from: k */
            public void mo9098k(Status status) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.fitness.internal.IStatusCallback");
                    if (status != null) {
                        obtain.writeInt(1);
                        status.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.f4195lb.transact(1, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }
        }

        public C1443a() {
            attachInterface(this, "com.google.android.gms.fitness.internal.IStatusCallback");
        }

        /* renamed from: aw */
        public static C1442ks m5331aw(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.fitness.internal.IStatusCallback");
            return (queryLocalInterface == null || !(queryLocalInterface instanceof C1442ks)) ? new C1444a(iBinder) : (C1442ks) queryLocalInterface;
        }

        public IBinder asBinder() {
            return this;
        }

        public boolean onTransact(int code, Parcel data, Parcel reply, int flags) throws RemoteException {
            switch (code) {
                case 1:
                    data.enforceInterface("com.google.android.gms.fitness.internal.IStatusCallback");
                    mo9098k(data.readInt() != 0 ? Status.CREATOR.createFromParcel(data) : null);
                    reply.writeNoException();
                    return true;
                case 1598968902:
                    reply.writeString("com.google.android.gms.fitness.internal.IStatusCallback");
                    return true;
                default:
                    return super.onTransact(code, data, reply, flags);
            }
        }
    }

    /* renamed from: k */
    void mo9098k(Status status) throws RemoteException;
}
