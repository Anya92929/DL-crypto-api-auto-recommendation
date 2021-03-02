package com.google.android.gms.internal;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.dynamic.C0164b;
import com.google.android.gms.internal.C0238aw;

/* renamed from: com.google.android.gms.internal.ad */
public interface C0205ad extends IInterface {

    /* renamed from: com.google.android.gms.internal.ad$a */
    public static abstract class C0206a extends Binder implements C0205ad {

        /* renamed from: com.google.android.gms.internal.ad$a$a */
        private static class C0207a implements C0205ad {

            /* renamed from: dG */
            private IBinder f560dG;

            C0207a(IBinder iBinder) {
                this.f560dG = iBinder;
            }

            /* renamed from: a */
            public IBinder mo4030a(C0164b bVar, C0622x xVar, String str, C0238aw awVar, int i) throws RemoteException {
                IBinder iBinder = null;
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.ads.internal.client.IAdManagerCreator");
                    obtain.writeStrongBinder(bVar != null ? bVar.asBinder() : null);
                    if (xVar != null) {
                        obtain.writeInt(1);
                        xVar.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    obtain.writeString(str);
                    if (awVar != null) {
                        iBinder = awVar.asBinder();
                    }
                    obtain.writeStrongBinder(iBinder);
                    obtain.writeInt(i);
                    this.f560dG.transact(1, obtain, obtain2, 0);
                    obtain2.readException();
                    return obtain2.readStrongBinder();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public IBinder asBinder() {
                return this.f560dG;
            }
        }

        /* renamed from: g */
        public static C0205ad m476g(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.ads.internal.client.IAdManagerCreator");
            return (queryLocalInterface == null || !(queryLocalInterface instanceof C0205ad)) ? new C0207a(iBinder) : (C0205ad) queryLocalInterface;
        }

        public boolean onTransact(int code, Parcel data, Parcel reply, int flags) throws RemoteException {
            switch (code) {
                case 1:
                    data.enforceInterface("com.google.android.gms.ads.internal.client.IAdManagerCreator");
                    IBinder a = mo4030a(C0164b.C0165a.m377z(data.readStrongBinder()), data.readInt() != 0 ? C0622x.CREATOR.createFromParcel(data) : null, data.readString(), C0238aw.C0239a.m526i(data.readStrongBinder()), data.readInt());
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
    IBinder mo4030a(C0164b bVar, C0622x xVar, String str, C0238aw awVar, int i) throws RemoteException;
}
