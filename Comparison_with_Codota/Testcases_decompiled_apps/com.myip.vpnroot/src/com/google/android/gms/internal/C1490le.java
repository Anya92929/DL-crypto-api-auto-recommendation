package com.google.android.gms.internal;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.fitness.result.BleDevicesResult;

/* renamed from: com.google.android.gms.internal.le */
public interface C1490le extends IInterface {

    /* renamed from: com.google.android.gms.internal.le$a */
    public static abstract class C1491a extends Binder implements C1490le {

        /* renamed from: com.google.android.gms.internal.le$a$a */
        private static class C1492a implements C1490le {

            /* renamed from: lb */
            private IBinder f4257lb;

            C1492a(IBinder iBinder) {
                this.f4257lb = iBinder;
            }

            /* renamed from: a */
            public void mo9161a(BleDevicesResult bleDevicesResult) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.fitness.internal.ble.IBleDevicesCallback");
                    if (bleDevicesResult != null) {
                        obtain.writeInt(1);
                        bleDevicesResult.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.f4257lb.transact(1, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public IBinder asBinder() {
                return this.f4257lb;
            }
        }

        public C1491a() {
            attachInterface(this, "com.google.android.gms.fitness.internal.ble.IBleDevicesCallback");
        }

        /* renamed from: ax */
        public static C1490le m5420ax(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.fitness.internal.ble.IBleDevicesCallback");
            return (queryLocalInterface == null || !(queryLocalInterface instanceof C1490le)) ? new C1492a(iBinder) : (C1490le) queryLocalInterface;
        }

        public IBinder asBinder() {
            return this;
        }

        public boolean onTransact(int code, Parcel data, Parcel reply, int flags) throws RemoteException {
            switch (code) {
                case 1:
                    data.enforceInterface("com.google.android.gms.fitness.internal.ble.IBleDevicesCallback");
                    mo9161a(data.readInt() != 0 ? BleDevicesResult.CREATOR.createFromParcel(data) : null);
                    reply.writeNoException();
                    return true;
                case 1598968902:
                    reply.writeString("com.google.android.gms.fitness.internal.ble.IBleDevicesCallback");
                    return true;
                default:
                    return super.onTransact(code, data, reply, flags);
            }
        }
    }

    /* renamed from: a */
    void mo9161a(BleDevicesResult bleDevicesResult) throws RemoteException;
}
