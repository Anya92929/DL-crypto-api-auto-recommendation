package com.google.android.gms.maps.internal;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.maps.model.LatLng;

/* renamed from: com.google.android.gms.maps.internal.h */
public interface C0682h extends IInterface {

    /* renamed from: com.google.android.gms.maps.internal.h$a */
    public static abstract class C0683a extends Binder implements C0682h {

        /* renamed from: com.google.android.gms.maps.internal.h$a$a */
        private static class C0684a implements C0682h {

            /* renamed from: dG */
            private IBinder f1689dG;

            C0684a(IBinder iBinder) {
                this.f1689dG = iBinder;
            }

            public IBinder asBinder() {
                return this.f1689dG;
            }

            public void onMapClick(LatLng point) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.maps.internal.IOnMapClickListener");
                    if (point != null) {
                        obtain.writeInt(1);
                        point.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.f1689dG.transact(1, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }
        }

        public C0683a() {
            attachInterface(this, "com.google.android.gms.maps.internal.IOnMapClickListener");
        }

        /* renamed from: S */
        public static C0682h m2046S(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.maps.internal.IOnMapClickListener");
            return (queryLocalInterface == null || !(queryLocalInterface instanceof C0682h)) ? new C0684a(iBinder) : (C0682h) queryLocalInterface;
        }

        public IBinder asBinder() {
            return this;
        }

        public boolean onTransact(int code, Parcel data, Parcel reply, int flags) throws RemoteException {
            switch (code) {
                case 1:
                    data.enforceInterface("com.google.android.gms.maps.internal.IOnMapClickListener");
                    onMapClick(data.readInt() != 0 ? LatLng.CREATOR.createFromParcel(data) : null);
                    reply.writeNoException();
                    return true;
                case 1598968902:
                    reply.writeString("com.google.android.gms.maps.internal.IOnMapClickListener");
                    return true;
                default:
                    return super.onTransact(code, data, reply, flags);
            }
        }
    }

    void onMapClick(LatLng latLng) throws RemoteException;
}
