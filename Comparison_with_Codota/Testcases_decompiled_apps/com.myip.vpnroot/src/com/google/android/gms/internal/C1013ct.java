package com.google.android.gms.internal;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.internal.C1016cu;

/* renamed from: com.google.android.gms.internal.ct */
public interface C1013ct extends IInterface {

    /* renamed from: com.google.android.gms.internal.ct$a */
    public static abstract class C1014a extends Binder implements C1013ct {

        /* renamed from: com.google.android.gms.internal.ct$a$a */
        private static class C1015a implements C1013ct {

            /* renamed from: lb */
            private IBinder f3064lb;

            C1015a(IBinder iBinder) {
                this.f3064lb = iBinder;
            }

            public IBinder asBinder() {
                return this.f3064lb;
            }

            /* renamed from: x */
            public C1016cu mo8237x(String str) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.ads.internal.mediation.client.IAdapterCreator");
                    obtain.writeString(str);
                    this.f3064lb.transact(1, obtain, obtain2, 0);
                    obtain2.readException();
                    return C1016cu.C1017a.m4165m(obtain2.readStrongBinder());
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            /* renamed from: y */
            public boolean mo8238y(String str) throws RemoteException {
                boolean z = false;
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.ads.internal.mediation.client.IAdapterCreator");
                    obtain.writeString(str);
                    this.f3064lb.transact(2, obtain, obtain2, 0);
                    obtain2.readException();
                    if (obtain2.readInt() != 0) {
                        z = true;
                    }
                    return z;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }
        }

        public C1014a() {
            attachInterface(this, "com.google.android.gms.ads.internal.mediation.client.IAdapterCreator");
        }

        /* renamed from: l */
        public static C1013ct m4158l(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.ads.internal.mediation.client.IAdapterCreator");
            return (queryLocalInterface == null || !(queryLocalInterface instanceof C1013ct)) ? new C1015a(iBinder) : (C1013ct) queryLocalInterface;
        }

        public IBinder asBinder() {
            return this;
        }

        public boolean onTransact(int code, Parcel data, Parcel reply, int flags) throws RemoteException {
            switch (code) {
                case 1:
                    data.enforceInterface("com.google.android.gms.ads.internal.mediation.client.IAdapterCreator");
                    C1016cu x = mo8237x(data.readString());
                    reply.writeNoException();
                    reply.writeStrongBinder(x != null ? x.asBinder() : null);
                    return true;
                case 2:
                    data.enforceInterface("com.google.android.gms.ads.internal.mediation.client.IAdapterCreator");
                    boolean y = mo8238y(data.readString());
                    reply.writeNoException();
                    reply.writeInt(y ? 1 : 0);
                    return true;
                case 1598968902:
                    reply.writeString("com.google.android.gms.ads.internal.mediation.client.IAdapterCreator");
                    return true;
                default:
                    return super.onTransact(code, data, reply, flags);
            }
        }
    }

    /* renamed from: x */
    C1016cu mo8237x(String str) throws RemoteException;

    /* renamed from: y */
    boolean mo8238y(String str) throws RemoteException;
}
