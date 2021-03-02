package com.google.android.gms.internal;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.dynamic.C0368b;

/* renamed from: com.google.android.gms.internal.q */
public interface C0615q extends IInterface {

    /* renamed from: com.google.android.gms.internal.q$a */
    public static abstract class C0616a extends Binder implements C0615q {

        /* renamed from: com.google.android.gms.internal.q$a$a */
        private static class C0617a implements C0615q {

            /* renamed from: a */
            private IBinder f1429a;

            C0617a(IBinder iBinder) {
                this.f1429a = iBinder;
            }

            /* renamed from: a */
            public C0368b mo5483a(C0368b bVar, int i, int i2) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.common.internal.ISignInButtonCreator");
                    obtain.writeStrongBinder(bVar != null ? bVar.asBinder() : null);
                    obtain.writeInt(i);
                    obtain.writeInt(i2);
                    this.f1429a.transact(1, obtain, obtain2, 0);
                    obtain2.readException();
                    return C0368b.C0369a.m700l(obtain2.readStrongBinder());
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public IBinder asBinder() {
                return this.f1429a;
            }
        }

        /* renamed from: i */
        public static C0615q m1879i(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.common.internal.ISignInButtonCreator");
            return (queryLocalInterface == null || !(queryLocalInterface instanceof C0615q)) ? new C0617a(iBinder) : (C0615q) queryLocalInterface;
        }

        public boolean onTransact(int code, Parcel data, Parcel reply, int flags) throws RemoteException {
            switch (code) {
                case 1:
                    data.enforceInterface("com.google.android.gms.common.internal.ISignInButtonCreator");
                    C0368b a = mo5483a(C0368b.C0369a.m700l(data.readStrongBinder()), data.readInt(), data.readInt());
                    reply.writeNoException();
                    reply.writeStrongBinder(a != null ? a.asBinder() : null);
                    return true;
                case 1598968902:
                    reply.writeString("com.google.android.gms.common.internal.ISignInButtonCreator");
                    return true;
                default:
                    return super.onTransact(code, data, reply, flags);
            }
        }
    }

    /* renamed from: a */
    C0368b mo5483a(C0368b bVar, int i, int i2) throws RemoteException;
}
