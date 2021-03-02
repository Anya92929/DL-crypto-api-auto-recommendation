package com.google.android.gms.internal;

import android.app.PendingIntent;
import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

/* renamed from: com.google.android.gms.internal.fj */
public interface C0540fj extends IInterface {

    /* renamed from: com.google.android.gms.internal.fj$a */
    public static abstract class C0541a extends Binder implements C0540fj {

        /* renamed from: com.google.android.gms.internal.fj$a$a */
        private static class C0542a implements C0540fj {

            /* renamed from: dG */
            private IBinder f1332dG;

            C0542a(IBinder iBinder) {
                this.f1332dG = iBinder;
            }

            public IBinder asBinder() {
                return this.f1332dG;
            }

            public void cancelClick() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.plus.internal.IPlusOneDelegate");
                    this.f1332dG.transact(2, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public PendingIntent getResolution() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.plus.internal.IPlusOneDelegate");
                    this.f1332dG.transact(1, obtain, obtain2, 0);
                    obtain2.readException();
                    return obtain2.readInt() != 0 ? (PendingIntent) PendingIntent.CREATOR.createFromParcel(obtain2) : null;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void reinitialize() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.plus.internal.IPlusOneDelegate");
                    this.f1332dG.transact(3, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }
        }

        /* renamed from: ap */
        public static C0540fj m1607ap(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.plus.internal.IPlusOneDelegate");
            return (queryLocalInterface == null || !(queryLocalInterface instanceof C0540fj)) ? new C0542a(iBinder) : (C0540fj) queryLocalInterface;
        }

        public boolean onTransact(int code, Parcel data, Parcel reply, int flags) throws RemoteException {
            switch (code) {
                case 1:
                    data.enforceInterface("com.google.android.gms.plus.internal.IPlusOneDelegate");
                    PendingIntent resolution = getResolution();
                    reply.writeNoException();
                    if (resolution != null) {
                        reply.writeInt(1);
                        resolution.writeToParcel(reply, 1);
                        return true;
                    }
                    reply.writeInt(0);
                    return true;
                case 2:
                    data.enforceInterface("com.google.android.gms.plus.internal.IPlusOneDelegate");
                    cancelClick();
                    reply.writeNoException();
                    return true;
                case 3:
                    data.enforceInterface("com.google.android.gms.plus.internal.IPlusOneDelegate");
                    reinitialize();
                    reply.writeNoException();
                    return true;
                case 1598968902:
                    reply.writeString("com.google.android.gms.plus.internal.IPlusOneDelegate");
                    return true;
                default:
                    return super.onTransact(code, data, reply, flags);
            }
        }
    }

    void cancelClick() throws RemoteException;

    PendingIntent getResolution() throws RemoteException;

    void reinitialize() throws RemoteException;
}
