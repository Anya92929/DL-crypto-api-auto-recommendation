package com.google.android.gms.common.internal;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.dynamic.C0594d;

/* renamed from: com.google.android.gms.common.internal.l */
public interface C0342l extends IInterface {

    /* renamed from: com.google.android.gms.common.internal.l$a */
    public static abstract class C0343a extends Binder implements C0342l {

        /* renamed from: com.google.android.gms.common.internal.l$a$a */
        private static class C0344a implements C0342l {

            /* renamed from: lb */
            private IBinder f793lb;

            C0344a(IBinder iBinder) {
                this.f793lb = iBinder;
            }

            /* renamed from: a */
            public C0594d mo4546a(C0594d dVar, int i, int i2) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.common.internal.ISignInButtonCreator");
                    obtain.writeStrongBinder(dVar != null ? dVar.asBinder() : null);
                    obtain.writeInt(i);
                    obtain.writeInt(i2);
                    this.f793lb.transact(1, obtain, obtain2, 0);
                    obtain2.readException();
                    return C0594d.C0595a.m1741am(obtain2.readStrongBinder());
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public IBinder asBinder() {
                return this.f793lb;
            }
        }

        /* renamed from: R */
        public static C0342l m846R(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.common.internal.ISignInButtonCreator");
            return (queryLocalInterface == null || !(queryLocalInterface instanceof C0342l)) ? new C0344a(iBinder) : (C0342l) queryLocalInterface;
        }

        public boolean onTransact(int code, Parcel data, Parcel reply, int flags) throws RemoteException {
            switch (code) {
                case 1:
                    data.enforceInterface("com.google.android.gms.common.internal.ISignInButtonCreator");
                    C0594d a = mo4546a(C0594d.C0595a.m1741am(data.readStrongBinder()), data.readInt(), data.readInt());
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
    C0594d mo4546a(C0594d dVar, int i, int i2) throws RemoteException;
}
