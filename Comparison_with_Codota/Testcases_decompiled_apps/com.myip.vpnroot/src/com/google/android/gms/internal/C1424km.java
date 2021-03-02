package com.google.android.gms.internal;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.fitness.result.DataSourcesResult;

/* renamed from: com.google.android.gms.internal.km */
public interface C1424km extends IInterface {

    /* renamed from: com.google.android.gms.internal.km$a */
    public static abstract class C1425a extends Binder implements C1424km {

        /* renamed from: com.google.android.gms.internal.km$a$a */
        private static class C1426a implements C1424km {

            /* renamed from: lb */
            private IBinder f4189lb;

            C1426a(IBinder iBinder) {
                this.f4189lb = iBinder;
            }

            /* renamed from: a */
            public void mo9105a(DataSourcesResult dataSourcesResult) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.fitness.internal.IDataSourcesCallback");
                    if (dataSourcesResult != null) {
                        obtain.writeInt(1);
                        dataSourcesResult.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.f4189lb.transact(1, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public IBinder asBinder() {
                return this.f4189lb;
            }
        }

        public C1425a() {
            attachInterface(this, "com.google.android.gms.fitness.internal.IDataSourcesCallback");
        }

        /* renamed from: aq */
        public static C1424km m5267aq(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.fitness.internal.IDataSourcesCallback");
            return (queryLocalInterface == null || !(queryLocalInterface instanceof C1424km)) ? new C1426a(iBinder) : (C1424km) queryLocalInterface;
        }

        public IBinder asBinder() {
            return this;
        }

        public boolean onTransact(int code, Parcel data, Parcel reply, int flags) throws RemoteException {
            switch (code) {
                case 1:
                    data.enforceInterface("com.google.android.gms.fitness.internal.IDataSourcesCallback");
                    mo9105a(data.readInt() != 0 ? DataSourcesResult.CREATOR.createFromParcel(data) : null);
                    reply.writeNoException();
                    return true;
                case 1598968902:
                    reply.writeString("com.google.android.gms.fitness.internal.IDataSourcesCallback");
                    return true;
                default:
                    return super.onTransact(code, data, reply, flags);
            }
        }
    }

    /* renamed from: a */
    void mo9105a(DataSourcesResult dataSourcesResult) throws RemoteException;
}
