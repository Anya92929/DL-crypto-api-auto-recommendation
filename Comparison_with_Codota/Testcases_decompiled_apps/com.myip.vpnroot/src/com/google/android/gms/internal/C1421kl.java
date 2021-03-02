package com.google.android.gms.internal;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.fitness.result.DataReadResult;

/* renamed from: com.google.android.gms.internal.kl */
public interface C1421kl extends IInterface {

    /* renamed from: com.google.android.gms.internal.kl$a */
    public static abstract class C1422a extends Binder implements C1421kl {

        /* renamed from: com.google.android.gms.internal.kl$a$a */
        private static class C1423a implements C1421kl {

            /* renamed from: lb */
            private IBinder f4188lb;

            C1423a(IBinder iBinder) {
                this.f4188lb = iBinder;
            }

            /* renamed from: a */
            public void mo9101a(DataReadResult dataReadResult) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.fitness.internal.IDataReadCallback");
                    if (dataReadResult != null) {
                        obtain.writeInt(1);
                        dataReadResult.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.f4188lb.transact(1, obtain, (Parcel) null, 1);
                } finally {
                    obtain.recycle();
                }
            }

            public IBinder asBinder() {
                return this.f4188lb;
            }
        }

        public C1422a() {
            attachInterface(this, "com.google.android.gms.fitness.internal.IDataReadCallback");
        }

        /* renamed from: ap */
        public static C1421kl m5264ap(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.fitness.internal.IDataReadCallback");
            return (queryLocalInterface == null || !(queryLocalInterface instanceof C1421kl)) ? new C1423a(iBinder) : (C1421kl) queryLocalInterface;
        }

        public IBinder asBinder() {
            return this;
        }

        public boolean onTransact(int code, Parcel data, Parcel reply, int flags) throws RemoteException {
            switch (code) {
                case 1:
                    data.enforceInterface("com.google.android.gms.fitness.internal.IDataReadCallback");
                    mo9101a(data.readInt() != 0 ? DataReadResult.CREATOR.createFromParcel(data) : null);
                    return true;
                case 1598968902:
                    reply.writeString("com.google.android.gms.fitness.internal.IDataReadCallback");
                    return true;
                default:
                    return super.onTransact(code, data, reply, flags);
            }
        }
    }

    /* renamed from: a */
    void mo9101a(DataReadResult dataReadResult) throws RemoteException;
}
