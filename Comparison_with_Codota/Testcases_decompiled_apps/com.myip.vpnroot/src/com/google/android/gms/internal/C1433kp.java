package com.google.android.gms.internal;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.fitness.result.ListSubscriptionsResult;

/* renamed from: com.google.android.gms.internal.kp */
public interface C1433kp extends IInterface {

    /* renamed from: com.google.android.gms.internal.kp$a */
    public static abstract class C1434a extends Binder implements C1433kp {

        /* renamed from: com.google.android.gms.internal.kp$a$a */
        private static class C1435a implements C1433kp {

            /* renamed from: lb */
            private IBinder f4192lb;

            C1435a(IBinder iBinder) {
                this.f4192lb = iBinder;
            }

            /* renamed from: a */
            public void mo9139a(ListSubscriptionsResult listSubscriptionsResult) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.fitness.internal.IListSubscriptionsCallback");
                    if (listSubscriptionsResult != null) {
                        obtain.writeInt(1);
                        listSubscriptionsResult.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.f4192lb.transact(1, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public IBinder asBinder() {
                return this.f4192lb;
            }
        }

        public C1434a() {
            attachInterface(this, "com.google.android.gms.fitness.internal.IListSubscriptionsCallback");
        }

        /* renamed from: at */
        public static C1433kp m5322at(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.fitness.internal.IListSubscriptionsCallback");
            return (queryLocalInterface == null || !(queryLocalInterface instanceof C1433kp)) ? new C1435a(iBinder) : (C1433kp) queryLocalInterface;
        }

        public IBinder asBinder() {
            return this;
        }

        public boolean onTransact(int code, Parcel data, Parcel reply, int flags) throws RemoteException {
            switch (code) {
                case 1:
                    data.enforceInterface("com.google.android.gms.fitness.internal.IListSubscriptionsCallback");
                    mo9139a(data.readInt() != 0 ? ListSubscriptionsResult.CREATOR.createFromParcel(data) : null);
                    reply.writeNoException();
                    return true;
                case 1598968902:
                    reply.writeString("com.google.android.gms.fitness.internal.IListSubscriptionsCallback");
                    return true;
                default:
                    return super.onTransact(code, data, reply, flags);
            }
        }
    }

    /* renamed from: a */
    void mo9139a(ListSubscriptionsResult listSubscriptionsResult) throws RemoteException;
}
