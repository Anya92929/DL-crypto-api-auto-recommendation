package com.google.android.gms.internal;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.dynamic.C0164b;

/* renamed from: com.google.android.gms.internal.fi */
public interface C0537fi extends IInterface {

    /* renamed from: com.google.android.gms.internal.fi$a */
    public static abstract class C0538a extends Binder implements C0537fi {

        /* renamed from: com.google.android.gms.internal.fi$a$a */
        private static class C0539a implements C0537fi {

            /* renamed from: dG */
            private IBinder f1331dG;

            C0539a(IBinder iBinder) {
                this.f1331dG = iBinder;
            }

            /* renamed from: a */
            public C0164b mo4805a(C0164b bVar, int i, int i2, String str, int i3) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.plus.internal.IPlusOneButtonCreator");
                    obtain.writeStrongBinder(bVar != null ? bVar.asBinder() : null);
                    obtain.writeInt(i);
                    obtain.writeInt(i2);
                    obtain.writeString(str);
                    obtain.writeInt(i3);
                    this.f1331dG.transact(1, obtain, obtain2, 0);
                    obtain2.readException();
                    return C0164b.C0165a.m377z(obtain2.readStrongBinder());
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            /* renamed from: a */
            public C0164b mo4806a(C0164b bVar, int i, int i2, String str, String str2) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.plus.internal.IPlusOneButtonCreator");
                    obtain.writeStrongBinder(bVar != null ? bVar.asBinder() : null);
                    obtain.writeInt(i);
                    obtain.writeInt(i2);
                    obtain.writeString(str);
                    obtain.writeString(str2);
                    this.f1331dG.transact(2, obtain, obtain2, 0);
                    obtain2.readException();
                    return C0164b.C0165a.m377z(obtain2.readStrongBinder());
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public IBinder asBinder() {
                return this.f1331dG;
            }
        }

        /* renamed from: ao */
        public static C0537fi m1604ao(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.plus.internal.IPlusOneButtonCreator");
            return (queryLocalInterface == null || !(queryLocalInterface instanceof C0537fi)) ? new C0539a(iBinder) : (C0537fi) queryLocalInterface;
        }

        public boolean onTransact(int code, Parcel data, Parcel reply, int flags) throws RemoteException {
            IBinder iBinder = null;
            switch (code) {
                case 1:
                    data.enforceInterface("com.google.android.gms.plus.internal.IPlusOneButtonCreator");
                    C0164b a = mo4805a(C0164b.C0165a.m377z(data.readStrongBinder()), data.readInt(), data.readInt(), data.readString(), data.readInt());
                    reply.writeNoException();
                    reply.writeStrongBinder(a != null ? a.asBinder() : null);
                    return true;
                case 2:
                    data.enforceInterface("com.google.android.gms.plus.internal.IPlusOneButtonCreator");
                    C0164b a2 = mo4806a(C0164b.C0165a.m377z(data.readStrongBinder()), data.readInt(), data.readInt(), data.readString(), data.readString());
                    reply.writeNoException();
                    if (a2 != null) {
                        iBinder = a2.asBinder();
                    }
                    reply.writeStrongBinder(iBinder);
                    return true;
                case 1598968902:
                    reply.writeString("com.google.android.gms.plus.internal.IPlusOneButtonCreator");
                    return true;
                default:
                    return super.onTransact(code, data, reply, flags);
            }
        }
    }

    /* renamed from: a */
    C0164b mo4805a(C0164b bVar, int i, int i2, String str, int i3) throws RemoteException;

    /* renamed from: a */
    C0164b mo4806a(C0164b bVar, int i, int i2, String str, String str2) throws RemoteException;
}
