package com.google.android.gms.maps.internal;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.maps.model.StreetViewPanoramaCamera;

/* renamed from: com.google.android.gms.maps.internal.p */
public interface C1855p extends IInterface {

    /* renamed from: com.google.android.gms.maps.internal.p$a */
    public static abstract class C1856a extends Binder implements C1855p {

        /* renamed from: com.google.android.gms.maps.internal.p$a$a */
        private static class C1857a implements C1855p {

            /* renamed from: lb */
            private IBinder f4462lb;

            C1857a(IBinder iBinder) {
                this.f4462lb = iBinder;
            }

            public IBinder asBinder() {
                return this.f4462lb;
            }

            public void onStreetViewPanoramaCameraChange(StreetViewPanoramaCamera camera) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.maps.internal.IOnStreetViewPanoramaCameraChangeListener");
                    if (camera != null) {
                        obtain.writeInt(1);
                        camera.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.f4462lb.transact(1, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }
        }

        public C1856a() {
            attachInterface(this, "com.google.android.gms.maps.internal.IOnStreetViewPanoramaCameraChangeListener");
        }

        /* renamed from: bg */
        public static C1855p m6381bg(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.maps.internal.IOnStreetViewPanoramaCameraChangeListener");
            return (queryLocalInterface == null || !(queryLocalInterface instanceof C1855p)) ? new C1857a(iBinder) : (C1855p) queryLocalInterface;
        }

        public IBinder asBinder() {
            return this;
        }

        public boolean onTransact(int code, Parcel data, Parcel reply, int flags) throws RemoteException {
            switch (code) {
                case 1:
                    data.enforceInterface("com.google.android.gms.maps.internal.IOnStreetViewPanoramaCameraChangeListener");
                    onStreetViewPanoramaCameraChange(data.readInt() != 0 ? StreetViewPanoramaCamera.CREATOR.createFromParcel(data) : null);
                    reply.writeNoException();
                    return true;
                case 1598968902:
                    reply.writeString("com.google.android.gms.maps.internal.IOnStreetViewPanoramaCameraChangeListener");
                    return true;
                default:
                    return super.onTransact(code, data, reply, flags);
            }
        }
    }

    void onStreetViewPanoramaCameraChange(StreetViewPanoramaCamera streetViewPanoramaCamera) throws RemoteException;
}
