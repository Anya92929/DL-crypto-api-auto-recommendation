package com.google.android.gms.maps.internal;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.maps.model.internal.C0731d;

/* renamed from: com.google.android.gms.maps.internal.l */
public interface C0694l extends IInterface {

    /* renamed from: com.google.android.gms.maps.internal.l$a */
    public static abstract class C0695a extends Binder implements C0694l {

        /* renamed from: com.google.android.gms.maps.internal.l$a$a */
        private static class C0696a implements C0694l {

            /* renamed from: dG */
            private IBinder f1693dG;

            C0696a(IBinder iBinder) {
                this.f1693dG = iBinder;
            }

            public IBinder asBinder() {
                return this.f1693dG;
            }

            /* renamed from: b */
            public void mo5465b(C0731d dVar) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.maps.internal.IOnMarkerDragListener");
                    obtain.writeStrongBinder(dVar != null ? dVar.asBinder() : null);
                    this.f1693dG.transact(1, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            /* renamed from: c */
            public void mo5466c(C0731d dVar) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.maps.internal.IOnMarkerDragListener");
                    obtain.writeStrongBinder(dVar != null ? dVar.asBinder() : null);
                    this.f1693dG.transact(3, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            /* renamed from: d */
            public void mo5467d(C0731d dVar) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.maps.internal.IOnMarkerDragListener");
                    obtain.writeStrongBinder(dVar != null ? dVar.asBinder() : null);
                    this.f1693dG.transact(2, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }
        }

        public C0695a() {
            attachInterface(this, "com.google.android.gms.maps.internal.IOnMarkerDragListener");
        }

        /* renamed from: W */
        public static C0694l m2055W(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.maps.internal.IOnMarkerDragListener");
            return (queryLocalInterface == null || !(queryLocalInterface instanceof C0694l)) ? new C0696a(iBinder) : (C0694l) queryLocalInterface;
        }

        public IBinder asBinder() {
            return this;
        }

        public boolean onTransact(int code, Parcel data, Parcel reply, int flags) throws RemoteException {
            switch (code) {
                case 1:
                    data.enforceInterface("com.google.android.gms.maps.internal.IOnMarkerDragListener");
                    mo5465b(C0731d.C0732a.m2141af(data.readStrongBinder()));
                    reply.writeNoException();
                    return true;
                case 2:
                    data.enforceInterface("com.google.android.gms.maps.internal.IOnMarkerDragListener");
                    mo5467d(C0731d.C0732a.m2141af(data.readStrongBinder()));
                    reply.writeNoException();
                    return true;
                case 3:
                    data.enforceInterface("com.google.android.gms.maps.internal.IOnMarkerDragListener");
                    mo5466c(C0731d.C0732a.m2141af(data.readStrongBinder()));
                    reply.writeNoException();
                    return true;
                case 1598968902:
                    reply.writeString("com.google.android.gms.maps.internal.IOnMarkerDragListener");
                    return true;
                default:
                    return super.onTransact(code, data, reply, flags);
            }
        }
    }

    /* renamed from: b */
    void mo5465b(C0731d dVar) throws RemoteException;

    /* renamed from: c */
    void mo5466c(C0731d dVar) throws RemoteException;

    /* renamed from: d */
    void mo5467d(C0731d dVar) throws RemoteException;
}
