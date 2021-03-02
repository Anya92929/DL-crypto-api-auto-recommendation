package com.google.android.gms.internal;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

/* renamed from: com.google.android.gms.internal.fm */
public interface C1173fm extends IInterface {

    /* renamed from: com.google.android.gms.internal.fm$a */
    public static abstract class C1174a extends Binder implements C1173fm {

        /* renamed from: com.google.android.gms.internal.fm$a$a */
        private static class C1175a implements C1173fm {

            /* renamed from: lb */
            private IBinder f3574lb;

            C1175a(IBinder iBinder) {
                this.f3574lb = iBinder;
            }

            public IBinder asBinder() {
                return this.f3574lb;
            }

            /* renamed from: b */
            public C1171fk mo8507b(C1168fi fiVar) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.ads.internal.request.IAdRequestService");
                    if (fiVar != null) {
                        obtain.writeInt(1);
                        fiVar.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.f3574lb.transact(1, obtain, obtain2, 0);
                    obtain2.readException();
                    return obtain2.readInt() != 0 ? C1171fk.CREATOR.mo8504i(obtain2) : null;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }
        }

        public C1174a() {
            attachInterface(this, "com.google.android.gms.ads.internal.request.IAdRequestService");
        }

        /* renamed from: D */
        public static C1173fm m4465D(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.ads.internal.request.IAdRequestService");
            return (queryLocalInterface == null || !(queryLocalInterface instanceof C1173fm)) ? new C1175a(iBinder) : (C1173fm) queryLocalInterface;
        }

        public IBinder asBinder() {
            return this;
        }

        public boolean onTransact(int code, Parcel data, Parcel reply, int flags) throws RemoteException {
            switch (code) {
                case 1:
                    data.enforceInterface("com.google.android.gms.ads.internal.request.IAdRequestService");
                    C1171fk b = mo8507b(data.readInt() != 0 ? C1168fi.CREATOR.createFromParcel(data) : null);
                    reply.writeNoException();
                    if (b != null) {
                        reply.writeInt(1);
                        b.writeToParcel(reply, 1);
                    } else {
                        reply.writeInt(0);
                    }
                    return true;
                case 1598968902:
                    reply.writeString("com.google.android.gms.ads.internal.request.IAdRequestService");
                    return true;
                default:
                    return super.onTransact(code, data, reply, flags);
            }
        }
    }

    /* renamed from: b */
    C1171fk mo8507b(C1168fi fiVar) throws RemoteException;
}
