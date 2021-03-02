package com.google.android.gms.internal;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.dynamic.C0594d;

/* renamed from: com.google.android.gms.internal.es */
public interface C1117es extends IInterface {

    /* renamed from: com.google.android.gms.internal.es$a */
    public static abstract class C1118a extends Binder implements C1117es {

        /* renamed from: com.google.android.gms.internal.es$a$a */
        private static class C1119a implements C1117es {

            /* renamed from: lb */
            private IBinder f3261lb;

            C1119a(IBinder iBinder) {
                this.f3261lb = iBinder;
            }

            /* renamed from: ar */
            public void mo8441ar() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.ads.internal.rawhtmlad.client.IRawHtmlAd");
                    this.f3261lb.transact(4, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            /* renamed from: as */
            public void mo8442as() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.ads.internal.rawhtmlad.client.IRawHtmlAd");
                    this.f3261lb.transact(5, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public IBinder asBinder() {
                return this.f3261lb;
            }

            /* renamed from: c */
            public void mo8443c(C0594d dVar) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.ads.internal.rawhtmlad.client.IRawHtmlAd");
                    obtain.writeStrongBinder(dVar != null ? dVar.asBinder() : null);
                    this.f3261lb.transact(3, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            /* renamed from: cv */
            public String mo8444cv() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.ads.internal.rawhtmlad.client.IRawHtmlAd");
                    this.f3261lb.transact(1, obtain, obtain2, 0);
                    obtain2.readException();
                    return obtain2.readString();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            /* renamed from: cw */
            public String mo8445cw() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.ads.internal.rawhtmlad.client.IRawHtmlAd");
                    this.f3261lb.transact(2, obtain, obtain2, 0);
                    obtain2.readException();
                    return obtain2.readString();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }
        }

        public C1118a() {
            attachInterface(this, "com.google.android.gms.ads.internal.rawhtmlad.client.IRawHtmlAd");
        }

        /* renamed from: z */
        public static C1117es m4360z(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.ads.internal.rawhtmlad.client.IRawHtmlAd");
            return (queryLocalInterface == null || !(queryLocalInterface instanceof C1117es)) ? new C1119a(iBinder) : (C1117es) queryLocalInterface;
        }

        public IBinder asBinder() {
            return this;
        }

        public boolean onTransact(int code, Parcel data, Parcel reply, int flags) throws RemoteException {
            switch (code) {
                case 1:
                    data.enforceInterface("com.google.android.gms.ads.internal.rawhtmlad.client.IRawHtmlAd");
                    String cv = mo8444cv();
                    reply.writeNoException();
                    reply.writeString(cv);
                    return true;
                case 2:
                    data.enforceInterface("com.google.android.gms.ads.internal.rawhtmlad.client.IRawHtmlAd");
                    String cw = mo8445cw();
                    reply.writeNoException();
                    reply.writeString(cw);
                    return true;
                case 3:
                    data.enforceInterface("com.google.android.gms.ads.internal.rawhtmlad.client.IRawHtmlAd");
                    mo8443c(C0594d.C0595a.m1741am(data.readStrongBinder()));
                    reply.writeNoException();
                    return true;
                case 4:
                    data.enforceInterface("com.google.android.gms.ads.internal.rawhtmlad.client.IRawHtmlAd");
                    mo8441ar();
                    reply.writeNoException();
                    return true;
                case 5:
                    data.enforceInterface("com.google.android.gms.ads.internal.rawhtmlad.client.IRawHtmlAd");
                    mo8442as();
                    reply.writeNoException();
                    return true;
                case 1598968902:
                    reply.writeString("com.google.android.gms.ads.internal.rawhtmlad.client.IRawHtmlAd");
                    return true;
                default:
                    return super.onTransact(code, data, reply, flags);
            }
        }
    }

    /* renamed from: ar */
    void mo8441ar() throws RemoteException;

    /* renamed from: as */
    void mo8442as() throws RemoteException;

    /* renamed from: c */
    void mo8443c(C0594d dVar) throws RemoteException;

    /* renamed from: cv */
    String mo8444cv() throws RemoteException;

    /* renamed from: cw */
    String mo8445cw() throws RemoteException;
}
