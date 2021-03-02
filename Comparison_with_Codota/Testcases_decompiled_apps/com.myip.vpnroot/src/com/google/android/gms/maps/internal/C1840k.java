package com.google.android.gms.maps.internal;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.maps.model.LatLng;

/* renamed from: com.google.android.gms.maps.internal.k */
public interface C1840k extends IInterface {

    /* renamed from: com.google.android.gms.maps.internal.k$a */
    public static abstract class C1841a extends Binder implements C1840k {

        /* renamed from: com.google.android.gms.maps.internal.k$a$a */
        private static class C1842a implements C1840k {

            /* renamed from: lb */
            private IBinder f4457lb;

            C1842a(IBinder iBinder) {
                this.f4457lb = iBinder;
            }

            public IBinder asBinder() {
                return this.f4457lb;
            }

            public void onMapLongClick(LatLng point) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.maps.internal.IOnMapLongClickListener");
                    if (point != null) {
                        obtain.writeInt(1);
                        point.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.f4457lb.transact(1, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }
        }

        public C1841a() {
            attachInterface(this, "com.google.android.gms.maps.internal.IOnMapLongClickListener");
        }

        /* renamed from: bb */
        public static C1840k m6366bb(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.maps.internal.IOnMapLongClickListener");
            return (queryLocalInterface == null || !(queryLocalInterface instanceof C1840k)) ? new C1842a(iBinder) : (C1840k) queryLocalInterface;
        }

        public IBinder asBinder() {
            return this;
        }

        public boolean onTransact(int code, Parcel data, Parcel reply, int flags) throws RemoteException {
            switch (code) {
                case 1:
                    data.enforceInterface("com.google.android.gms.maps.internal.IOnMapLongClickListener");
                    onMapLongClick(data.readInt() != 0 ? LatLng.CREATOR.createFromParcel(data) : null);
                    reply.writeNoException();
                    return true;
                case 1598968902:
                    reply.writeString("com.google.android.gms.maps.internal.IOnMapLongClickListener");
                    return true;
                default:
                    return super.onTransact(code, data, reply, flags);
            }
        }
    }

    void onMapLongClick(LatLng latLng) throws RemoteException;
}
