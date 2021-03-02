package com.google.android.gms.fitness.data;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

/* renamed from: com.google.android.gms.fitness.data.k */
public interface C0618k extends IInterface {

    /* renamed from: com.google.android.gms.fitness.data.k$a */
    public static abstract class C0619a extends Binder implements C0618k {

        /* renamed from: com.google.android.gms.fitness.data.k$a$a */
        private static class C0620a implements C0618k {

            /* renamed from: lb */
            private IBinder f1396lb;

            C0620a(IBinder iBinder) {
                this.f1396lb = iBinder;
            }

            public IBinder asBinder() {
                return this.f1396lb;
            }

            public void onEvent(DataPoint dataPoint) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.fitness.data.IDataSourceListener");
                    if (dataPoint != null) {
                        obtain.writeInt(1);
                        dataPoint.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.f1396lb.transact(1, obtain, (Parcel) null, 1);
                } finally {
                    obtain.recycle();
                }
            }
        }

        public C0619a() {
            attachInterface(this, "com.google.android.gms.fitness.data.IDataSourceListener");
        }

        /* renamed from: an */
        public static C0618k m1858an(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.fitness.data.IDataSourceListener");
            return (queryLocalInterface == null || !(queryLocalInterface instanceof C0618k)) ? new C0620a(iBinder) : (C0618k) queryLocalInterface;
        }

        public IBinder asBinder() {
            return this;
        }

        public boolean onTransact(int code, Parcel data, Parcel reply, int flags) throws RemoteException {
            switch (code) {
                case 1:
                    data.enforceInterface("com.google.android.gms.fitness.data.IDataSourceListener");
                    onEvent(data.readInt() != 0 ? DataPoint.CREATOR.createFromParcel(data) : null);
                    return true;
                case 1598968902:
                    reply.writeString("com.google.android.gms.fitness.data.IDataSourceListener");
                    return true;
                default:
                    return super.onTransact(code, data, reply, flags);
            }
        }
    }

    void onEvent(DataPoint dataPoint) throws RemoteException;
}
