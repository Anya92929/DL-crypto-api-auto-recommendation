package com.google.android.gms.maps.model.internal;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.dynamic.zzd;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.LatLngBounds;

public interface zzc extends IInterface {

    public static abstract class zza extends Binder implements zzc {

        /* renamed from: com.google.android.gms.maps.model.internal.zzc$zza$zza  reason: collision with other inner class name */
        private static class C0504zza implements zzc {
            private IBinder zzoz;

            C0504zza(IBinder iBinder) {
                this.zzoz = iBinder;
            }

            public IBinder asBinder() {
                return this.zzoz;
            }

            public float getBearing() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.maps.model.internal.IGroundOverlayDelegate");
                    this.zzoz.transact(12, obtain, obtain2, 0);
                    obtain2.readException();
                    return obtain2.readFloat();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public LatLngBounds getBounds() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.maps.model.internal.IGroundOverlayDelegate");
                    this.zzoz.transact(10, obtain, obtain2, 0);
                    obtain2.readException();
                    return obtain2.readInt() != 0 ? LatLngBounds.CREATOR.createFromParcel(obtain2) : null;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public float getHeight() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.maps.model.internal.IGroundOverlayDelegate");
                    this.zzoz.transact(8, obtain, obtain2, 0);
                    obtain2.readException();
                    return obtain2.readFloat();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public String getId() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.maps.model.internal.IGroundOverlayDelegate");
                    this.zzoz.transact(2, obtain, obtain2, 0);
                    obtain2.readException();
                    return obtain2.readString();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public LatLng getPosition() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.maps.model.internal.IGroundOverlayDelegate");
                    this.zzoz.transact(4, obtain, obtain2, 0);
                    obtain2.readException();
                    return obtain2.readInt() != 0 ? LatLng.CREATOR.createFromParcel(obtain2) : null;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public float getTransparency() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.maps.model.internal.IGroundOverlayDelegate");
                    this.zzoz.transact(18, obtain, obtain2, 0);
                    obtain2.readException();
                    return obtain2.readFloat();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public float getWidth() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.maps.model.internal.IGroundOverlayDelegate");
                    this.zzoz.transact(7, obtain, obtain2, 0);
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
                    obtain.writeInterfaceToken("com.google.android.gms.maps.model.internal.IGroundOverlayDelegate");
                    this.zzoz.transact(14, obtain, obtain2, 0);
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
                    obtain.writeInterfaceToken("com.google.android.gms.maps.model.internal.IGroundOverlayDelegate");
                    this.zzoz.transact(20, obtain, obtain2, 0);
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
                    obtain.writeInterfaceToken("com.google.android.gms.maps.model.internal.IGroundOverlayDelegate");
                    this.zzoz.transact(23, obtain, obtain2, 0);
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
                    obtain.writeInterfaceToken("com.google.android.gms.maps.model.internal.IGroundOverlayDelegate");
                    this.zzoz.transact(16, obtain, obtain2, 0);
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
                    obtain.writeInterfaceToken("com.google.android.gms.maps.model.internal.IGroundOverlayDelegate");
                    this.zzoz.transact(1, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void setBearing(float bearing) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.maps.model.internal.IGroundOverlayDelegate");
                    obtain.writeFloat(bearing);
                    this.zzoz.transact(11, obtain, obtain2, 0);
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
                    obtain.writeInterfaceToken("com.google.android.gms.maps.model.internal.IGroundOverlayDelegate");
                    if (clickable) {
                        i = 1;
                    }
                    obtain.writeInt(i);
                    this.zzoz.transact(22, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void setDimensions(float width) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.maps.model.internal.IGroundOverlayDelegate");
                    obtain.writeFloat(width);
                    this.zzoz.transact(5, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void setPosition(LatLng latlng) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.maps.model.internal.IGroundOverlayDelegate");
                    if (latlng != null) {
                        obtain.writeInt(1);
                        latlng.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.zzoz.transact(3, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void setPositionFromBounds(LatLngBounds bounds) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.maps.model.internal.IGroundOverlayDelegate");
                    if (bounds != null) {
                        obtain.writeInt(1);
                        bounds.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.zzoz.transact(9, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void setTransparency(float transparency) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.maps.model.internal.IGroundOverlayDelegate");
                    obtain.writeFloat(transparency);
                    this.zzoz.transact(17, obtain, obtain2, 0);
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
                    obtain.writeInterfaceToken("com.google.android.gms.maps.model.internal.IGroundOverlayDelegate");
                    if (visible) {
                        i = 1;
                    }
                    obtain.writeInt(i);
                    this.zzoz.transact(15, obtain, obtain2, 0);
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
                    obtain.writeInterfaceToken("com.google.android.gms.maps.model.internal.IGroundOverlayDelegate");
                    obtain.writeFloat(zIndex);
                    this.zzoz.transact(13, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void zza(float f, float f2) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.maps.model.internal.IGroundOverlayDelegate");
                    obtain.writeFloat(f);
                    obtain.writeFloat(f2);
                    this.zzoz.transact(6, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public boolean zzb(zzc zzc) throws RemoteException {
                boolean z = false;
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.maps.model.internal.IGroundOverlayDelegate");
                    obtain.writeStrongBinder(zzc != null ? zzc.asBinder() : null);
                    this.zzoz.transact(19, obtain, obtain2, 0);
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

            public void zzv(zzd zzd) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.maps.model.internal.IGroundOverlayDelegate");
                    obtain.writeStrongBinder(zzd != null ? zzd.asBinder() : null);
                    this.zzoz.transact(21, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }
        }

        public static zzc zzdf(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.maps.model.internal.IGroundOverlayDelegate");
            return (queryLocalInterface == null || !(queryLocalInterface instanceof zzc)) ? new C0504zza(iBinder) : (zzc) queryLocalInterface;
        }

        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v35, resolved type: com.google.android.gms.maps.model.LatLngBounds} */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v48, resolved type: com.google.android.gms.maps.model.LatLng} */
        /* JADX WARNING: type inference failed for: r0v0 */
        /* JADX WARNING: type inference failed for: r0v55 */
        /* JADX WARNING: type inference failed for: r0v56 */
        /* JADX WARNING: Multi-variable type inference failed */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public boolean onTransact(int r4, android.os.Parcel r5, android.os.Parcel r6, int r7) throws android.os.RemoteException {
            /*
                r3 = this;
                r0 = 0
                r2 = 0
                r1 = 1
                switch(r4) {
                    case 1: goto L_0x0011;
                    case 2: goto L_0x001d;
                    case 3: goto L_0x002d;
                    case 4: goto L_0x0045;
                    case 5: goto L_0x005e;
                    case 6: goto L_0x006e;
                    case 7: goto L_0x0082;
                    case 8: goto L_0x0093;
                    case 9: goto L_0x00a4;
                    case 10: goto L_0x00bd;
                    case 11: goto L_0x00d8;
                    case 12: goto L_0x00e9;
                    case 13: goto L_0x00fa;
                    case 14: goto L_0x010b;
                    case 15: goto L_0x011c;
                    case 16: goto L_0x0132;
                    case 17: goto L_0x0146;
                    case 18: goto L_0x0157;
                    case 19: goto L_0x0168;
                    case 20: goto L_0x0184;
                    case 21: goto L_0x0195;
                    case 22: goto L_0x01aa;
                    case 23: goto L_0x01be;
                    case 1598968902: goto L_0x000b;
                    default: goto L_0x0006;
                }
            L_0x0006:
                boolean r1 = super.onTransact(r4, r5, r6, r7)
            L_0x000a:
                return r1
            L_0x000b:
                java.lang.String r0 = "com.google.android.gms.maps.model.internal.IGroundOverlayDelegate"
                r6.writeString(r0)
                goto L_0x000a
            L_0x0011:
                java.lang.String r0 = "com.google.android.gms.maps.model.internal.IGroundOverlayDelegate"
                r5.enforceInterface(r0)
                r3.remove()
                r6.writeNoException()
                goto L_0x000a
            L_0x001d:
                java.lang.String r0 = "com.google.android.gms.maps.model.internal.IGroundOverlayDelegate"
                r5.enforceInterface(r0)
                java.lang.String r0 = r3.getId()
                r6.writeNoException()
                r6.writeString(r0)
                goto L_0x000a
            L_0x002d:
                java.lang.String r2 = "com.google.android.gms.maps.model.internal.IGroundOverlayDelegate"
                r5.enforceInterface(r2)
                int r2 = r5.readInt()
                if (r2 == 0) goto L_0x003e
                com.google.android.gms.maps.model.zze r0 = com.google.android.gms.maps.model.LatLng.CREATOR
                com.google.android.gms.maps.model.LatLng r0 = r0.createFromParcel(r5)
            L_0x003e:
                r3.setPosition(r0)
                r6.writeNoException()
                goto L_0x000a
            L_0x0045:
                java.lang.String r0 = "com.google.android.gms.maps.model.internal.IGroundOverlayDelegate"
                r5.enforceInterface(r0)
                com.google.android.gms.maps.model.LatLng r0 = r3.getPosition()
                r6.writeNoException()
                if (r0 == 0) goto L_0x005a
                r6.writeInt(r1)
                r0.writeToParcel(r6, r1)
                goto L_0x000a
            L_0x005a:
                r6.writeInt(r2)
                goto L_0x000a
            L_0x005e:
                java.lang.String r0 = "com.google.android.gms.maps.model.internal.IGroundOverlayDelegate"
                r5.enforceInterface(r0)
                float r0 = r5.readFloat()
                r3.setDimensions(r0)
                r6.writeNoException()
                goto L_0x000a
            L_0x006e:
                java.lang.String r0 = "com.google.android.gms.maps.model.internal.IGroundOverlayDelegate"
                r5.enforceInterface(r0)
                float r0 = r5.readFloat()
                float r2 = r5.readFloat()
                r3.zza(r0, r2)
                r6.writeNoException()
                goto L_0x000a
            L_0x0082:
                java.lang.String r0 = "com.google.android.gms.maps.model.internal.IGroundOverlayDelegate"
                r5.enforceInterface(r0)
                float r0 = r3.getWidth()
                r6.writeNoException()
                r6.writeFloat(r0)
                goto L_0x000a
            L_0x0093:
                java.lang.String r0 = "com.google.android.gms.maps.model.internal.IGroundOverlayDelegate"
                r5.enforceInterface(r0)
                float r0 = r3.getHeight()
                r6.writeNoException()
                r6.writeFloat(r0)
                goto L_0x000a
            L_0x00a4:
                java.lang.String r2 = "com.google.android.gms.maps.model.internal.IGroundOverlayDelegate"
                r5.enforceInterface(r2)
                int r2 = r5.readInt()
                if (r2 == 0) goto L_0x00b5
                com.google.android.gms.maps.model.zzd r0 = com.google.android.gms.maps.model.LatLngBounds.CREATOR
                com.google.android.gms.maps.model.LatLngBounds r0 = r0.createFromParcel(r5)
            L_0x00b5:
                r3.setPositionFromBounds(r0)
                r6.writeNoException()
                goto L_0x000a
            L_0x00bd:
                java.lang.String r0 = "com.google.android.gms.maps.model.internal.IGroundOverlayDelegate"
                r5.enforceInterface(r0)
                com.google.android.gms.maps.model.LatLngBounds r0 = r3.getBounds()
                r6.writeNoException()
                if (r0 == 0) goto L_0x00d3
                r6.writeInt(r1)
                r0.writeToParcel(r6, r1)
                goto L_0x000a
            L_0x00d3:
                r6.writeInt(r2)
                goto L_0x000a
            L_0x00d8:
                java.lang.String r0 = "com.google.android.gms.maps.model.internal.IGroundOverlayDelegate"
                r5.enforceInterface(r0)
                float r0 = r5.readFloat()
                r3.setBearing(r0)
                r6.writeNoException()
                goto L_0x000a
            L_0x00e9:
                java.lang.String r0 = "com.google.android.gms.maps.model.internal.IGroundOverlayDelegate"
                r5.enforceInterface(r0)
                float r0 = r3.getBearing()
                r6.writeNoException()
                r6.writeFloat(r0)
                goto L_0x000a
            L_0x00fa:
                java.lang.String r0 = "com.google.android.gms.maps.model.internal.IGroundOverlayDelegate"
                r5.enforceInterface(r0)
                float r0 = r5.readFloat()
                r3.setZIndex(r0)
                r6.writeNoException()
                goto L_0x000a
            L_0x010b:
                java.lang.String r0 = "com.google.android.gms.maps.model.internal.IGroundOverlayDelegate"
                r5.enforceInterface(r0)
                float r0 = r3.getZIndex()
                r6.writeNoException()
                r6.writeFloat(r0)
                goto L_0x000a
            L_0x011c:
                java.lang.String r0 = "com.google.android.gms.maps.model.internal.IGroundOverlayDelegate"
                r5.enforceInterface(r0)
                int r0 = r5.readInt()
                if (r0 == 0) goto L_0x0130
                r0 = r1
            L_0x0128:
                r3.setVisible(r0)
                r6.writeNoException()
                goto L_0x000a
            L_0x0130:
                r0 = r2
                goto L_0x0128
            L_0x0132:
                java.lang.String r0 = "com.google.android.gms.maps.model.internal.IGroundOverlayDelegate"
                r5.enforceInterface(r0)
                boolean r0 = r3.isVisible()
                r6.writeNoException()
                if (r0 == 0) goto L_0x0141
                r2 = r1
            L_0x0141:
                r6.writeInt(r2)
                goto L_0x000a
            L_0x0146:
                java.lang.String r0 = "com.google.android.gms.maps.model.internal.IGroundOverlayDelegate"
                r5.enforceInterface(r0)
                float r0 = r5.readFloat()
                r3.setTransparency(r0)
                r6.writeNoException()
                goto L_0x000a
            L_0x0157:
                java.lang.String r0 = "com.google.android.gms.maps.model.internal.IGroundOverlayDelegate"
                r5.enforceInterface(r0)
                float r0 = r3.getTransparency()
                r6.writeNoException()
                r6.writeFloat(r0)
                goto L_0x000a
            L_0x0168:
                java.lang.String r0 = "com.google.android.gms.maps.model.internal.IGroundOverlayDelegate"
                r5.enforceInterface(r0)
                android.os.IBinder r0 = r5.readStrongBinder()
                com.google.android.gms.maps.model.internal.zzc r0 = zzdf(r0)
                boolean r0 = r3.zzb(r0)
                r6.writeNoException()
                if (r0 == 0) goto L_0x017f
                r2 = r1
            L_0x017f:
                r6.writeInt(r2)
                goto L_0x000a
            L_0x0184:
                java.lang.String r0 = "com.google.android.gms.maps.model.internal.IGroundOverlayDelegate"
                r5.enforceInterface(r0)
                int r0 = r3.hashCodeRemote()
                r6.writeNoException()
                r6.writeInt(r0)
                goto L_0x000a
            L_0x0195:
                java.lang.String r0 = "com.google.android.gms.maps.model.internal.IGroundOverlayDelegate"
                r5.enforceInterface(r0)
                android.os.IBinder r0 = r5.readStrongBinder()
                com.google.android.gms.dynamic.zzd r0 = com.google.android.gms.dynamic.zzd.zza.zzbs(r0)
                r3.zzv(r0)
                r6.writeNoException()
                goto L_0x000a
            L_0x01aa:
                java.lang.String r0 = "com.google.android.gms.maps.model.internal.IGroundOverlayDelegate"
                r5.enforceInterface(r0)
                int r0 = r5.readInt()
                if (r0 == 0) goto L_0x01b6
                r2 = r1
            L_0x01b6:
                r3.setClickable(r2)
                r6.writeNoException()
                goto L_0x000a
            L_0x01be:
                java.lang.String r0 = "com.google.android.gms.maps.model.internal.IGroundOverlayDelegate"
                r5.enforceInterface(r0)
                boolean r0 = r3.isClickable()
                r6.writeNoException()
                if (r0 == 0) goto L_0x01cd
                r2 = r1
            L_0x01cd:
                r6.writeInt(r2)
                goto L_0x000a
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.maps.model.internal.zzc.zza.onTransact(int, android.os.Parcel, android.os.Parcel, int):boolean");
        }
    }

    float getBearing() throws RemoteException;

    LatLngBounds getBounds() throws RemoteException;

    float getHeight() throws RemoteException;

    String getId() throws RemoteException;

    LatLng getPosition() throws RemoteException;

    float getTransparency() throws RemoteException;

    float getWidth() throws RemoteException;

    float getZIndex() throws RemoteException;

    int hashCodeRemote() throws RemoteException;

    boolean isClickable() throws RemoteException;

    boolean isVisible() throws RemoteException;

    void remove() throws RemoteException;

    void setBearing(float f) throws RemoteException;

    void setClickable(boolean z) throws RemoteException;

    void setDimensions(float f) throws RemoteException;

    void setPosition(LatLng latLng) throws RemoteException;

    void setPositionFromBounds(LatLngBounds latLngBounds) throws RemoteException;

    void setTransparency(float f) throws RemoteException;

    void setVisible(boolean z) throws RemoteException;

    void setZIndex(float f) throws RemoteException;

    void zza(float f, float f2) throws RemoteException;

    boolean zzb(zzc zzc) throws RemoteException;

    void zzv(zzd zzd) throws RemoteException;
}
