package com.google.android.gms.fitness.request;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.fitness.data.BleDevice;

/* renamed from: com.google.android.gms.fitness.request.k */
public interface C0667k extends IInterface {

    /* renamed from: com.google.android.gms.fitness.request.k$a */
    public static abstract class C0668a extends Binder implements C0667k {

        /* renamed from: com.google.android.gms.fitness.request.k$a$a */
        private static class C0669a implements C0667k {

            /* renamed from: lb */
            private IBinder f1529lb;

            C0669a(IBinder iBinder) {
                this.f1529lb = iBinder;
            }

            public IBinder asBinder() {
                return this.f1529lb;
            }

            public void onDeviceFound(BleDevice device) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.fitness.request.IBleScanCallback");
                    if (device != null) {
                        obtain.writeInt(1);
                        device.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.f1529lb.transact(1, obtain, (Parcel) null, 1);
                } finally {
                    obtain.recycle();
                }
            }

            public void onScanStopped() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.fitness.request.IBleScanCallback");
                    this.f1529lb.transact(2, obtain, (Parcel) null, 1);
                } finally {
                    obtain.recycle();
                }
            }
        }

        public C0668a() {
            attachInterface(this, "com.google.android.gms.fitness.request.IBleScanCallback");
        }

        /* renamed from: ay */
        public static C0667k m2029ay(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.fitness.request.IBleScanCallback");
            return (queryLocalInterface == null || !(queryLocalInterface instanceof C0667k)) ? new C0669a(iBinder) : (C0667k) queryLocalInterface;
        }

        public IBinder asBinder() {
            return this;
        }

        public boolean onTransact(int code, Parcel data, Parcel reply, int flags) throws RemoteException {
            switch (code) {
                case 1:
                    data.enforceInterface("com.google.android.gms.fitness.request.IBleScanCallback");
                    onDeviceFound(data.readInt() != 0 ? BleDevice.CREATOR.createFromParcel(data) : null);
                    return true;
                case 2:
                    data.enforceInterface("com.google.android.gms.fitness.request.IBleScanCallback");
                    onScanStopped();
                    return true;
                case 1598968902:
                    reply.writeString("com.google.android.gms.fitness.request.IBleScanCallback");
                    return true;
                default:
                    return super.onTransact(code, data, reply, flags);
            }
        }
    }

    void onDeviceFound(BleDevice bleDevice) throws RemoteException;

    void onScanStopped() throws RemoteException;
}
