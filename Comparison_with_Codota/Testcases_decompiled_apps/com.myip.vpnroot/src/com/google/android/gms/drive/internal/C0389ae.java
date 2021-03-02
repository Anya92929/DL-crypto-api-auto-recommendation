package com.google.android.gms.drive.internal;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

/* renamed from: com.google.android.gms.drive.internal.ae */
public interface C0389ae extends IInterface {

    /* renamed from: com.google.android.gms.drive.internal.ae$a */
    public static abstract class C0390a extends Binder implements C0389ae {

        /* renamed from: com.google.android.gms.drive.internal.ae$a$a */
        private static class C0391a implements C0389ae {

            /* renamed from: lb */
            private IBinder f983lb;

            C0391a(IBinder iBinder) {
                this.f983lb = iBinder;
            }

            /* renamed from: L */
            public void mo4911L(boolean z) throws RemoteException {
                int i = 1;
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.drive.internal.IEventReleaseCallback");
                    if (!z) {
                        i = 0;
                    }
                    obtain.writeInt(i);
                    this.f983lb.transact(1, obtain, (Parcel) null, 1);
                } finally {
                    obtain.recycle();
                }
            }

            public IBinder asBinder() {
                return this.f983lb;
            }
        }

        /* renamed from: X */
        public static C0389ae m1126X(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.drive.internal.IEventReleaseCallback");
            return (queryLocalInterface == null || !(queryLocalInterface instanceof C0389ae)) ? new C0391a(iBinder) : (C0389ae) queryLocalInterface;
        }

        public boolean onTransact(int code, Parcel data, Parcel reply, int flags) throws RemoteException {
            switch (code) {
                case 1:
                    data.enforceInterface("com.google.android.gms.drive.internal.IEventReleaseCallback");
                    mo4911L(data.readInt() != 0);
                    return true;
                case 1598968902:
                    reply.writeString("com.google.android.gms.drive.internal.IEventReleaseCallback");
                    return true;
                default:
                    return super.onTransact(code, data, reply, flags);
            }
        }
    }

    /* renamed from: L */
    void mo4911L(boolean z) throws RemoteException;
}
