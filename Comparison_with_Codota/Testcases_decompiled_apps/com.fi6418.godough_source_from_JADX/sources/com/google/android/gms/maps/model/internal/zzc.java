package com.google.android.gms.maps.model.internal;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.LatLngBounds;
import com.google.android.gms.p017b.C0605j;

public interface zzc extends IInterface {

    public abstract class zza extends Binder implements zzc {
        public static zzc zzcQ(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.maps.model.internal.IGroundOverlayDelegate");
            return (queryLocalInterface == null || !(queryLocalInterface instanceof zzc)) ? new C1222d(iBinder) : (zzc) queryLocalInterface;
        }

        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v31, resolved type: com.google.android.gms.maps.model.LatLngBounds} */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v44, resolved type: com.google.android.gms.maps.model.LatLng} */
        /* JADX WARNING: type inference failed for: r0v0 */
        /* JADX WARNING: type inference failed for: r0v51 */
        /* JADX WARNING: type inference failed for: r0v52 */
        /* JADX WARNING: Multi-variable type inference failed */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public boolean onTransact(int r4, android.os.Parcel r5, android.os.Parcel r6, int r7) {
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
                com.google.android.gms.maps.model.internal.zzc r0 = zzcQ(r0)
                boolean r0 = r3.zza(r0)
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
                com.google.android.gms.b.j r0 = com.google.android.gms.p017b.C0606k.m3535a(r0)
                r3.zzw(r0)
                r6.writeNoException()
                goto L_0x000a
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.maps.model.internal.zzc.zza.onTransact(int, android.os.Parcel, android.os.Parcel, int):boolean");
        }
    }

    float getBearing();

    LatLngBounds getBounds();

    float getHeight();

    String getId();

    LatLng getPosition();

    float getTransparency();

    float getWidth();

    float getZIndex();

    int hashCodeRemote();

    boolean isVisible();

    void remove();

    void setBearing(float f);

    void setDimensions(float f);

    void setPosition(LatLng latLng);

    void setPositionFromBounds(LatLngBounds latLngBounds);

    void setTransparency(float f);

    void setVisible(boolean z);

    void setZIndex(float f);

    void zza(float f, float f2);

    boolean zza(zzc zzc);

    void zzw(C0605j jVar);
}
