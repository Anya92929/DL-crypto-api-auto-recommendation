package com.google.android.gms.drive.realtime.internal;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

/* renamed from: com.google.android.gms.drive.realtime.internal.h */
public interface C0555h extends IInterface {

    /* renamed from: com.google.android.gms.drive.realtime.internal.h$a */
    public static abstract class C0556a extends Binder implements C0555h {

        /* renamed from: com.google.android.gms.drive.realtime.internal.h$a$a */
        private static class C0557a implements C0555h {

            /* renamed from: lb */
            private IBinder f1231lb;

            C0557a(IBinder iBinder) {
                this.f1231lb = iBinder;
            }

            public IBinder asBinder() {
                return this.f1231lb;
            }

            /* renamed from: c */
            public void mo5391c(boolean z, boolean z2) throws RemoteException {
                int i = 1;
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.drive.realtime.internal.IDocumentSaveStateEventCallback");
                    obtain.writeInt(z ? 1 : 0);
                    if (!z2) {
                        i = 0;
                    }
                    obtain.writeInt(i);
                    this.f1231lb.transact(1, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }
        }

        /* renamed from: ad */
        public static C0555h m1586ad(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.drive.realtime.internal.IDocumentSaveStateEventCallback");
            return (queryLocalInterface == null || !(queryLocalInterface instanceof C0555h)) ? new C0557a(iBinder) : (C0555h) queryLocalInterface;
        }

        public IBinder asBinder() {
            return this;
        }

        public boolean onTransact(int code, Parcel data, Parcel reply, int flags) throws RemoteException {
            boolean z = false;
            switch (code) {
                case 1:
                    data.enforceInterface("com.google.android.gms.drive.realtime.internal.IDocumentSaveStateEventCallback");
                    boolean z2 = data.readInt() != 0;
                    if (data.readInt() != 0) {
                        z = true;
                    }
                    mo5391c(z2, z);
                    reply.writeNoException();
                    return true;
                case 1598968902:
                    reply.writeString("com.google.android.gms.drive.realtime.internal.IDocumentSaveStateEventCallback");
                    return true;
                default:
                    return super.onTransact(code, data, reply, flags);
            }
        }
    }

    /* renamed from: c */
    void mo5391c(boolean z, boolean z2) throws RemoteException;
}
