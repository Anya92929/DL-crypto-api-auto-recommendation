package com.google.android.gms.internal;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.internal.C0241ax;

/* renamed from: com.google.android.gms.internal.aw */
public interface C0238aw extends IInterface {

    /* renamed from: com.google.android.gms.internal.aw$a */
    public static abstract class C0239a extends Binder implements C0238aw {

        /* renamed from: com.google.android.gms.internal.aw$a$a */
        private static class C0240a implements C0238aw {

            /* renamed from: dG */
            private IBinder f612dG;

            C0240a(IBinder iBinder) {
                this.f612dG = iBinder;
            }

            public IBinder asBinder() {
                return this.f612dG;
            }

            /* renamed from: g */
            public C0241ax mo4062g(String str) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.ads.internal.mediation.client.IAdapterCreator");
                    obtain.writeString(str);
                    this.f612dG.transact(1, obtain, obtain2, 0);
                    obtain2.readException();
                    return C0241ax.C0242a.m530j(obtain2.readStrongBinder());
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }
        }

        public C0239a() {
            attachInterface(this, "com.google.android.gms.ads.internal.mediation.client.IAdapterCreator");
        }

        /* renamed from: i */
        public static C0238aw m526i(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.ads.internal.mediation.client.IAdapterCreator");
            return (queryLocalInterface == null || !(queryLocalInterface instanceof C0238aw)) ? new C0240a(iBinder) : (C0238aw) queryLocalInterface;
        }

        public IBinder asBinder() {
            return this;
        }

        public boolean onTransact(int code, Parcel data, Parcel reply, int flags) throws RemoteException {
            switch (code) {
                case 1:
                    data.enforceInterface("com.google.android.gms.ads.internal.mediation.client.IAdapterCreator");
                    C0241ax g = mo4062g(data.readString());
                    reply.writeNoException();
                    reply.writeStrongBinder(g != null ? g.asBinder() : null);
                    return true;
                case 1598968902:
                    reply.writeString("com.google.android.gms.ads.internal.mediation.client.IAdapterCreator");
                    return true;
                default:
                    return super.onTransact(code, data, reply, flags);
            }
        }
    }

    /* renamed from: g */
    C0241ax mo4062g(String str) throws RemoteException;
}
