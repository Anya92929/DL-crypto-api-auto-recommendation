package com.google.android.gms.maps.internal;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.maps.model.StreetViewPanoramaOrientation;

/* renamed from: com.google.android.gms.maps.internal.r */
public interface C1861r extends IInterface {

    /* renamed from: com.google.android.gms.maps.internal.r$a */
    public static abstract class C1862a extends Binder implements C1861r {

        /* renamed from: com.google.android.gms.maps.internal.r$a$a */
        private static class C1863a implements C1861r {

            /* renamed from: lb */
            private IBinder f4464lb;

            C1863a(IBinder iBinder) {
                this.f4464lb = iBinder;
            }

            public IBinder asBinder() {
                return this.f4464lb;
            }

            public void onStreetViewPanoramaClick(StreetViewPanoramaOrientation orientation) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.maps.internal.IOnStreetViewPanoramaClickListener");
                    if (orientation != null) {
                        obtain.writeInt(1);
                        orientation.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.f4464lb.transact(1, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }
        }

        public C1862a() {
            attachInterface(this, "com.google.android.gms.maps.internal.IOnStreetViewPanoramaClickListener");
        }

        /* renamed from: bi */
        public static C1861r m6383bi(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.maps.internal.IOnStreetViewPanoramaClickListener");
            return (queryLocalInterface == null || !(queryLocalInterface instanceof C1861r)) ? new C1863a(iBinder) : (C1861r) queryLocalInterface;
        }

        public IBinder asBinder() {
            return this;
        }

        public boolean onTransact(int code, Parcel data, Parcel reply, int flags) throws RemoteException {
            switch (code) {
                case 1:
                    data.enforceInterface("com.google.android.gms.maps.internal.IOnStreetViewPanoramaClickListener");
                    onStreetViewPanoramaClick(data.readInt() != 0 ? StreetViewPanoramaOrientation.CREATOR.createFromParcel(data) : null);
                    reply.writeNoException();
                    return true;
                case 1598968902:
                    reply.writeString("com.google.android.gms.maps.internal.IOnStreetViewPanoramaClickListener");
                    return true;
                default:
                    return super.onTransact(code, data, reply, flags);
            }
        }
    }

    void onStreetViewPanoramaClick(StreetViewPanoramaOrientation streetViewPanoramaOrientation) throws RemoteException;
}
