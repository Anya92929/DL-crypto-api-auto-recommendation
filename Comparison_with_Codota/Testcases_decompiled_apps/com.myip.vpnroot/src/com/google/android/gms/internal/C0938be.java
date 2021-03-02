package com.google.android.gms.internal;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.dynamic.C0594d;
import com.google.android.gms.internal.C1013ct;

/* renamed from: com.google.android.gms.internal.be */
public interface C0938be extends IInterface {

    /* renamed from: com.google.android.gms.internal.be$a */
    public static abstract class C0939a extends Binder implements C0938be {

        /* renamed from: com.google.android.gms.internal.be$a$a */
        private static class C0940a implements C0938be {

            /* renamed from: lb */
            private IBinder f2842lb;

            C0940a(IBinder iBinder) {
                this.f2842lb = iBinder;
            }

            /* renamed from: a */
            public IBinder mo8057a(C0594d dVar, C0927ay ayVar, String str, C1013ct ctVar, int i) throws RemoteException {
                IBinder iBinder = null;
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.ads.internal.client.IAdManagerCreator");
                    obtain.writeStrongBinder(dVar != null ? dVar.asBinder() : null);
                    if (ayVar != null) {
                        obtain.writeInt(1);
                        ayVar.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    obtain.writeString(str);
                    if (ctVar != null) {
                        iBinder = ctVar.asBinder();
                    }
                    obtain.writeStrongBinder(iBinder);
                    obtain.writeInt(i);
                    this.f2842lb.transact(1, obtain, obtain2, 0);
                    obtain2.readException();
                    return obtain2.readStrongBinder();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public IBinder asBinder() {
                return this.f2842lb;
            }
        }

        /* renamed from: g */
        public static C0938be m3947g(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.ads.internal.client.IAdManagerCreator");
            return (queryLocalInterface == null || !(queryLocalInterface instanceof C0938be)) ? new C0940a(iBinder) : (C0938be) queryLocalInterface;
        }

        public boolean onTransact(int code, Parcel data, Parcel reply, int flags) throws RemoteException {
            switch (code) {
                case 1:
                    data.enforceInterface("com.google.android.gms.ads.internal.client.IAdManagerCreator");
                    IBinder a = mo8057a(C0594d.C0595a.m1741am(data.readStrongBinder()), data.readInt() != 0 ? C0927ay.CREATOR.createFromParcel(data) : null, data.readString(), C1013ct.C1014a.m4158l(data.readStrongBinder()), data.readInt());
                    reply.writeNoException();
                    reply.writeStrongBinder(a);
                    return true;
                case 1598968902:
                    reply.writeString("com.google.android.gms.ads.internal.client.IAdManagerCreator");
                    return true;
                default:
                    return super.onTransact(code, data, reply, flags);
            }
        }
    }

    /* renamed from: a */
    IBinder mo8057a(C0594d dVar, C0927ay ayVar, String str, C1013ct ctVar, int i) throws RemoteException;
}
