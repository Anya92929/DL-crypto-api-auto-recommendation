package com.google.android.gms.maps.model.internal;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import com.google.android.gms.maps.model.LatLng;
import java.util.List;

public interface IPolylineDelegate extends IInterface {

    public abstract class zza extends Binder implements IPolylineDelegate {
        public static IPolylineDelegate zzcV(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.maps.model.internal.IPolylineDelegate");
            return (queryLocalInterface == null || !(queryLocalInterface instanceof IPolylineDelegate)) ? new C1219a(iBinder) : (IPolylineDelegate) queryLocalInterface;
        }

        public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) {
            boolean z = false;
            switch (i) {
                case 1:
                    parcel.enforceInterface("com.google.android.gms.maps.model.internal.IPolylineDelegate");
                    remove();
                    parcel2.writeNoException();
                    return true;
                case 2:
                    parcel.enforceInterface("com.google.android.gms.maps.model.internal.IPolylineDelegate");
                    String id = getId();
                    parcel2.writeNoException();
                    parcel2.writeString(id);
                    return true;
                case 3:
                    parcel.enforceInterface("com.google.android.gms.maps.model.internal.IPolylineDelegate");
                    setPoints(parcel.createTypedArrayList(LatLng.CREATOR));
                    parcel2.writeNoException();
                    return true;
                case 4:
                    parcel.enforceInterface("com.google.android.gms.maps.model.internal.IPolylineDelegate");
                    List<LatLng> points = getPoints();
                    parcel2.writeNoException();
                    parcel2.writeTypedList(points);
                    return true;
                case 5:
                    parcel.enforceInterface("com.google.android.gms.maps.model.internal.IPolylineDelegate");
                    setWidth(parcel.readFloat());
                    parcel2.writeNoException();
                    return true;
                case 6:
                    parcel.enforceInterface("com.google.android.gms.maps.model.internal.IPolylineDelegate");
                    float width = getWidth();
                    parcel2.writeNoException();
                    parcel2.writeFloat(width);
                    return true;
                case 7:
                    parcel.enforceInterface("com.google.android.gms.maps.model.internal.IPolylineDelegate");
                    setColor(parcel.readInt());
                    parcel2.writeNoException();
                    return true;
                case 8:
                    parcel.enforceInterface("com.google.android.gms.maps.model.internal.IPolylineDelegate");
                    int color = getColor();
                    parcel2.writeNoException();
                    parcel2.writeInt(color);
                    return true;
                case 9:
                    parcel.enforceInterface("com.google.android.gms.maps.model.internal.IPolylineDelegate");
                    setZIndex(parcel.readFloat());
                    parcel2.writeNoException();
                    return true;
                case 10:
                    parcel.enforceInterface("com.google.android.gms.maps.model.internal.IPolylineDelegate");
                    float zIndex = getZIndex();
                    parcel2.writeNoException();
                    parcel2.writeFloat(zIndex);
                    return true;
                case 11:
                    parcel.enforceInterface("com.google.android.gms.maps.model.internal.IPolylineDelegate");
                    if (parcel.readInt() != 0) {
                        z = true;
                    }
                    setVisible(z);
                    parcel2.writeNoException();
                    return true;
                case 12:
                    parcel.enforceInterface("com.google.android.gms.maps.model.internal.IPolylineDelegate");
                    boolean isVisible = isVisible();
                    parcel2.writeNoException();
                    if (isVisible) {
                        z = true;
                    }
                    parcel2.writeInt(z ? 1 : 0);
                    return true;
                case 13:
                    parcel.enforceInterface("com.google.android.gms.maps.model.internal.IPolylineDelegate");
                    if (parcel.readInt() != 0) {
                        z = true;
                    }
                    setGeodesic(z);
                    parcel2.writeNoException();
                    return true;
                case 14:
                    parcel.enforceInterface("com.google.android.gms.maps.model.internal.IPolylineDelegate");
                    boolean isGeodesic = isGeodesic();
                    parcel2.writeNoException();
                    if (isGeodesic) {
                        z = true;
                    }
                    parcel2.writeInt(z ? 1 : 0);
                    return true;
                case 15:
                    parcel.enforceInterface("com.google.android.gms.maps.model.internal.IPolylineDelegate");
                    boolean equalsRemote = equalsRemote(zzcV(parcel.readStrongBinder()));
                    parcel2.writeNoException();
                    if (equalsRemote) {
                        z = true;
                    }
                    parcel2.writeInt(z ? 1 : 0);
                    return true;
                case 16:
                    parcel.enforceInterface("com.google.android.gms.maps.model.internal.IPolylineDelegate");
                    int hashCodeRemote = hashCodeRemote();
                    parcel2.writeNoException();
                    parcel2.writeInt(hashCodeRemote);
                    return true;
                case 1598968902:
                    parcel2.writeString("com.google.android.gms.maps.model.internal.IPolylineDelegate");
                    return true;
                default:
                    return super.onTransact(i, parcel, parcel2, i2);
            }
        }
    }

    boolean equalsRemote(IPolylineDelegate iPolylineDelegate);

    int getColor();

    String getId();

    List<LatLng> getPoints();

    float getWidth();

    float getZIndex();

    int hashCodeRemote();

    boolean isGeodesic();

    boolean isVisible();

    void remove();

    void setColor(int i);

    void setGeodesic(boolean z);

    void setPoints(List<LatLng> list);

    void setVisible(boolean z);

    void setWidth(float f);

    void setZIndex(float f);
}
