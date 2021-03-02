package com.google.android.gms.internal;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.dynamic.C0164b;

/* renamed from: com.google.android.gms.internal.bo */
public interface C0297bo extends IInterface {

    /* renamed from: com.google.android.gms.internal.bo$a */
    public static abstract class C0298a extends Binder implements C0297bo {

        /* renamed from: com.google.android.gms.internal.bo$a$a */
        private static class C0299a implements C0297bo {

            /* renamed from: dG */
            private IBinder f887dG;

            C0299a(IBinder iBinder) {
                this.f887dG = iBinder;
            }

            /* renamed from: a */
            public IBinder mo4150a(C0164b bVar) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.ads.internal.overlay.client.IAdOverlayCreator");
                    obtain.writeStrongBinder(bVar != null ? bVar.asBinder() : null);
                    this.f887dG.transact(1, obtain, obtain2, 0);
                    obtain2.readException();
                    return obtain2.readStrongBinder();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public IBinder asBinder() {
                return this.f887dG;
            }
        }

        /* renamed from: n */
        public static C0297bo m609n(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.ads.internal.overlay.client.IAdOverlayCreator");
            return (queryLocalInterface == null || !(queryLocalInterface instanceof C0297bo)) ? new C0299a(iBinder) : (C0297bo) queryLocalInterface;
        }

        public boolean onTransact(int code, Parcel data, Parcel reply, int flags) throws RemoteException {
            switch (code) {
                case 1:
                    data.enforceInterface("com.google.android.gms.ads.internal.overlay.client.IAdOverlayCreator");
                    IBinder a = mo4150a(C0164b.C0165a.m377z(data.readStrongBinder()));
                    reply.writeNoException();
                    reply.writeStrongBinder(a);
                    return true;
                case 1598968902:
                    reply.writeString("com.google.android.gms.ads.internal.overlay.client.IAdOverlayCreator");
                    return true;
                default:
                    return super.onTransact(code, data, reply, flags);
            }
        }
    }

    /* renamed from: a */
    IBinder mo4150a(C0164b bVar) throws RemoteException;
}
