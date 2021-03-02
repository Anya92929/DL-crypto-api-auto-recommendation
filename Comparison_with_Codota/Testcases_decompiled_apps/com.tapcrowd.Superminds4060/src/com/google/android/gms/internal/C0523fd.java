package com.google.android.gms.internal;

import android.content.Intent;
import android.os.Binder;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

/* renamed from: com.google.android.gms.internal.fd */
public interface C0523fd extends IInterface {

    /* renamed from: com.google.android.gms.internal.fd$a */
    public static abstract class C0524a extends Binder implements C0523fd {

        /* renamed from: com.google.android.gms.internal.fd$a$a */
        private static class C0525a implements C0523fd {

            /* renamed from: dG */
            private IBinder f1318dG;

            C0525a(IBinder iBinder) {
                this.f1318dG = iBinder;
            }

            /* renamed from: a */
            public void mo4782a(int i, Bundle bundle, int i2, Intent intent) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.panorama.internal.IPanoramaCallbacks");
                    obtain.writeInt(i);
                    if (bundle != null) {
                        obtain.writeInt(1);
                        bundle.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    obtain.writeInt(i2);
                    if (intent != null) {
                        obtain.writeInt(1);
                        intent.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.f1318dG.transact(1, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public IBinder asBinder() {
                return this.f1318dG;
            }
        }

        public C0524a() {
            attachInterface(this, "com.google.android.gms.panorama.internal.IPanoramaCallbacks");
        }

        /* renamed from: ak */
        public static C0523fd m1558ak(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.panorama.internal.IPanoramaCallbacks");
            return (queryLocalInterface == null || !(queryLocalInterface instanceof C0523fd)) ? new C0525a(iBinder) : (C0523fd) queryLocalInterface;
        }

        public IBinder asBinder() {
            return this;
        }

        public boolean onTransact(int code, Parcel data, Parcel reply, int flags) throws RemoteException {
            switch (code) {
                case 1:
                    data.enforceInterface("com.google.android.gms.panorama.internal.IPanoramaCallbacks");
                    mo4782a(data.readInt(), data.readInt() != 0 ? (Bundle) Bundle.CREATOR.createFromParcel(data) : null, data.readInt(), data.readInt() != 0 ? (Intent) Intent.CREATOR.createFromParcel(data) : null);
                    reply.writeNoException();
                    return true;
                case 1598968902:
                    reply.writeString("com.google.android.gms.panorama.internal.IPanoramaCallbacks");
                    return true;
                default:
                    return super.onTransact(code, data, reply, flags);
            }
        }
    }

    /* renamed from: a */
    void mo4782a(int i, Bundle bundle, int i2, Intent intent) throws RemoteException;
}
