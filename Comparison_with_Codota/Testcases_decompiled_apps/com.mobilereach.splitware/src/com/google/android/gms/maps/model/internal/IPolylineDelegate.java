package com.google.android.gms.maps.model.internal;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.maps.model.LatLng;
import java.util.List;

public interface IPolylineDelegate extends IInterface {

    public static abstract class zza extends Binder implements IPolylineDelegate {

        /* renamed from: com.google.android.gms.maps.model.internal.IPolylineDelegate$zza$zza  reason: collision with other inner class name */
        private static class C0500zza implements IPolylineDelegate {
            private IBinder zzoz;

            C0500zza(IBinder iBinder) {
                this.zzoz = iBinder;
            }

            public IBinder asBinder() {
                return this.zzoz;
            }

            public boolean equalsRemote(IPolylineDelegate other) throws RemoteException {
                boolean z = false;
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.maps.model.internal.IPolylineDelegate");
                    obtain.writeStrongBinder(other != null ? other.asBinder() : null);
                    this.zzoz.transact(15, obtain, obtain2, 0);
                    obtain2.readException();
                    if (obtain2.readInt() != 0) {
                        z = true;
                    }
                    return z;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public int getColor() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.maps.model.internal.IPolylineDelegate");
                    this.zzoz.transact(8, obtain, obtain2, 0);
                    obtain2.readException();
                    return obtain2.readInt();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public String getId() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.maps.model.internal.IPolylineDelegate");
                    this.zzoz.transact(2, obtain, obtain2, 0);
                    obtain2.readException();
                    return obtain2.readString();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public List<LatLng> getPoints() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.maps.model.internal.IPolylineDelegate");
                    this.zzoz.transact(4, obtain, obtain2, 0);
                    obtain2.readException();
                    return obtain2.createTypedArrayList(LatLng.CREATOR);
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public float getWidth() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.maps.model.internal.IPolylineDelegate");
                    this.zzoz.transact(6, obtain, obtain2, 0);
                    obtain2.readException();
                    return obtain2.readFloat();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public float getZIndex() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.maps.model.internal.IPolylineDelegate");
                    this.zzoz.transact(10, obtain, obtain2, 0);
                    obtain2.readException();
                    return obtain2.readFloat();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public int hashCodeRemote() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.maps.model.internal.IPolylineDelegate");
                    this.zzoz.transact(16, obtain, obtain2, 0);
                    obtain2.readException();
                    return obtain2.readInt();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public boolean isClickable() throws RemoteException {
                boolean z = false;
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.maps.model.internal.IPolylineDelegate");
                    this.zzoz.transact(18, obtain, obtain2, 0);
                    obtain2.readException();
                    if (obtain2.readInt() != 0) {
                        z = true;
                    }
                    return z;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public boolean isGeodesic() throws RemoteException {
                boolean z = false;
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.maps.model.internal.IPolylineDelegate");
                    this.zzoz.transact(14, obtain, obtain2, 0);
                    obtain2.readException();
                    if (obtain2.readInt() != 0) {
                        z = true;
                    }
                    return z;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public boolean isVisible() throws RemoteException {
                boolean z = false;
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.maps.model.internal.IPolylineDelegate");
                    this.zzoz.transact(12, obtain, obtain2, 0);
                    obtain2.readException();
                    if (obtain2.readInt() != 0) {
                        z = true;
                    }
                    return z;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void remove() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.maps.model.internal.IPolylineDelegate");
                    this.zzoz.transact(1, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void setClickable(boolean clickable) throws RemoteException {
                int i = 0;
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.maps.model.internal.IPolylineDelegate");
                    if (clickable) {
                        i = 1;
                    }
                    obtain.writeInt(i);
                    this.zzoz.transact(17, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void setColor(int color) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.maps.model.internal.IPolylineDelegate");
                    obtain.writeInt(color);
                    this.zzoz.transact(7, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void setGeodesic(boolean geodesic) throws RemoteException {
                int i = 0;
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.maps.model.internal.IPolylineDelegate");
                    if (geodesic) {
                        i = 1;
                    }
                    obtain.writeInt(i);
                    this.zzoz.transact(13, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void setPoints(List<LatLng> points) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.maps.model.internal.IPolylineDelegate");
                    obtain.writeTypedList(points);
                    this.zzoz.transact(3, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void setVisible(boolean visible) throws RemoteException {
                int i = 0;
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.maps.model.internal.IPolylineDelegate");
                    if (visible) {
                        i = 1;
                    }
                    obtain.writeInt(i);
                    this.zzoz.transact(11, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void setWidth(float width) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.maps.model.internal.IPolylineDelegate");
                    obtain.writeFloat(width);
                    this.zzoz.transact(5, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void setZIndex(float zIndex) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.maps.model.internal.IPolylineDelegate");
                    obtain.writeFloat(zIndex);
                    this.zzoz.transact(9, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }
        }

        public static IPolylineDelegate zzdk(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.maps.model.internal.IPolylineDelegate");
            return (queryLocalInterface == null || !(queryLocalInterface instanceof IPolylineDelegate)) ? new C0500zza(iBinder) : (IPolylineDelegate) queryLocalInterface;
        }

        public boolean onTransact(int code, Parcel data, Parcel reply, int flags) throws RemoteException {
            boolean z = false;
            switch (code) {
                case 1:
                    data.enforceInterface("com.google.android.gms.maps.model.internal.IPolylineDelegate");
                    remove();
                    reply.writeNoException();
                    return true;
                case 2:
                    data.enforceInterface("com.google.android.gms.maps.model.internal.IPolylineDelegate");
                    String id = getId();
                    reply.writeNoException();
                    reply.writeString(id);
                    return true;
                case 3:
                    data.enforceInterface("com.google.android.gms.maps.model.internal.IPolylineDelegate");
                    setPoints(data.createTypedArrayList(LatLng.CREATOR));
                    reply.writeNoException();
                    return true;
                case 4:
                    data.enforceInterface("com.google.android.gms.maps.model.internal.IPolylineDelegate");
                    List<LatLng> points = getPoints();
                    reply.writeNoException();
                    reply.writeTypedList(points);
                    return true;
                case 5:
                    data.enforceInterface("com.google.android.gms.maps.model.internal.IPolylineDelegate");
                    setWidth(data.readFloat());
                    reply.writeNoException();
                    return true;
                case 6:
                    data.enforceInterface("com.google.android.gms.maps.model.internal.IPolylineDelegate");
                    float width = getWidth();
                    reply.writeNoException();
                    reply.writeFloat(width);
                    return true;
                case 7:
                    data.enforceInterface("com.google.android.gms.maps.model.internal.IPolylineDelegate");
                    setColor(data.readInt());
                    reply.writeNoException();
                    return true;
                case 8:
                    data.enforceInterface("com.google.android.gms.maps.model.internal.IPolylineDelegate");
                    int color = getColor();
                    reply.writeNoException();
                    reply.writeInt(color);
                    return true;
                case 9:
                    data.enforceInterface("com.google.android.gms.maps.model.internal.IPolylineDelegate");
                    setZIndex(data.readFloat());
                    reply.writeNoException();
                    return true;
                case 10:
                    data.enforceInterface("com.google.android.gms.maps.model.internal.IPolylineDelegate");
                    float zIndex = getZIndex();
                    reply.writeNoException();
                    reply.writeFloat(zIndex);
                    return true;
                case 11:
                    data.enforceInterface("com.google.android.gms.maps.model.internal.IPolylineDelegate");
                    if (data.readInt() != 0) {
                        z = true;
                    }
                    setVisible(z);
                    reply.writeNoException();
                    return true;
                case 12:
                    data.enforceInterface("com.google.android.gms.maps.model.internal.IPolylineDelegate");
                    boolean isVisible = isVisible();
                    reply.writeNoException();
                    if (isVisible) {
                        z = true;
                    }
                    reply.writeInt(z ? 1 : 0);
                    return true;
                case 13:
                    data.enforceInterface("com.google.android.gms.maps.model.internal.IPolylineDelegate");
                    if (data.readInt() != 0) {
                        z = true;
                    }
                    setGeodesic(z);
                    reply.writeNoException();
                    return true;
                case 14:
                    data.enforceInterface("com.google.android.gms.maps.model.internal.IPolylineDelegate");
                    boolean isGeodesic = isGeodesic();
                    reply.writeNoException();
                    if (isGeodesic) {
                        z = true;
                    }
                    reply.writeInt(z ? 1 : 0);
                    return true;
                case 15:
                    data.enforceInterface("com.google.android.gms.maps.model.internal.IPolylineDelegate");
                    boolean equalsRemote = equalsRemote(zzdk(data.readStrongBinder()));
                    reply.writeNoException();
                    if (equalsRemote) {
                        z = true;
                    }
                    reply.writeInt(z ? 1 : 0);
                    return true;
                case 16:
                    data.enforceInterface("com.google.android.gms.maps.model.internal.IPolylineDelegate");
                    int hashCodeRemote = hashCodeRemote();
                    reply.writeNoException();
                    reply.writeInt(hashCodeRemote);
                    return true;
                case 17:
                    data.enforceInterface("com.google.android.gms.maps.model.internal.IPolylineDelegate");
                    if (data.readInt() != 0) {
                        z = true;
                    }
                    setClickable(z);
                    reply.writeNoException();
                    return true;
                case 18:
                    data.enforceInterface("com.google.android.gms.maps.model.internal.IPolylineDelegate");
                    boolean isClickable = isClickable();
                    reply.writeNoException();
                    if (isClickable) {
                        z = true;
                    }
                    reply.writeInt(z ? 1 : 0);
                    return true;
                case 1598968902:
                    reply.writeString("com.google.android.gms.maps.model.internal.IPolylineDelegate");
                    return true;
                default:
                    return super.onTransact(code, data, reply, flags);
            }
        }
    }

    boolean equalsRemote(IPolylineDelegate iPolylineDelegate) throws RemoteException;

    int getColor() throws RemoteException;

    String getId() throws RemoteException;

    List<LatLng> getPoints() throws RemoteException;

    float getWidth() throws RemoteException;

    float getZIndex() throws RemoteException;

    int hashCodeRemote() throws RemoteException;

    boolean isClickable() throws RemoteException;

    boolean isGeodesic() throws RemoteException;

    boolean isVisible() throws RemoteException;

    void remove() throws RemoteException;

    void setClickable(boolean z) throws RemoteException;

    void setColor(int i) throws RemoteException;

    void setGeodesic(boolean z) throws RemoteException;

    void setPoints(List<LatLng> list) throws RemoteException;

    void setVisible(boolean z) throws RemoteException;

    void setWidth(float f) throws RemoteException;

    void setZIndex(float f) throws RemoteException;
}
