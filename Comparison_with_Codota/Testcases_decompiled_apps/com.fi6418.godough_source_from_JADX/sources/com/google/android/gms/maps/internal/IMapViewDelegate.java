package com.google.android.gms.maps.internal;

import android.os.Binder;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import com.google.android.gms.p017b.C0605j;

public interface IMapViewDelegate extends IInterface {

    public abstract class zza extends Binder implements IMapViewDelegate {
        public static IMapViewDelegate zzcp(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.maps.internal.IMapViewDelegate");
            return (queryLocalInterface == null || !(queryLocalInterface instanceof IMapViewDelegate)) ? new C1191e(iBinder) : (IMapViewDelegate) queryLocalInterface;
        }

        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v8, resolved type: android.os.Bundle} */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v22, resolved type: android.os.Bundle} */
        /* JADX WARNING: type inference failed for: r0v0 */
        /* JADX WARNING: type inference failed for: r0v5, types: [android.os.IBinder] */
        /* JADX WARNING: type inference failed for: r0v27, types: [android.os.IBinder] */
        /* JADX WARNING: type inference failed for: r0v33 */
        /* JADX WARNING: type inference failed for: r0v34 */
        /* JADX WARNING: type inference failed for: r0v35 */
        /* JADX WARNING: type inference failed for: r0v36 */
        /* JADX WARNING: Multi-variable type inference failed */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public boolean onTransact(int r4, android.os.Parcel r5, android.os.Parcel r6, int r7) {
            /*
                r3 = this;
                r0 = 0
                r1 = 1
                switch(r4) {
                    case 1: goto L_0x0011;
                    case 2: goto L_0x0028;
                    case 3: goto L_0x0043;
                    case 4: goto L_0x0050;
                    case 5: goto L_0x005d;
                    case 6: goto L_0x006a;
                    case 7: goto L_0x0077;
                    case 8: goto L_0x00a0;
                    case 9: goto L_0x00b8;
                    case 1598968902: goto L_0x000a;
                    default: goto L_0x0005;
                }
            L_0x0005:
                boolean r0 = super.onTransact(r4, r5, r6, r7)
            L_0x0009:
                return r0
            L_0x000a:
                java.lang.String r0 = "com.google.android.gms.maps.internal.IMapViewDelegate"
                r6.writeString(r0)
                r0 = r1
                goto L_0x0009
            L_0x0011:
                java.lang.String r2 = "com.google.android.gms.maps.internal.IMapViewDelegate"
                r5.enforceInterface(r2)
                com.google.android.gms.maps.internal.IGoogleMapDelegate r2 = r3.getMap()
                r6.writeNoException()
                if (r2 == 0) goto L_0x0023
                android.os.IBinder r0 = r2.asBinder()
            L_0x0023:
                r6.writeStrongBinder(r0)
                r0 = r1
                goto L_0x0009
            L_0x0028:
                java.lang.String r2 = "com.google.android.gms.maps.internal.IMapViewDelegate"
                r5.enforceInterface(r2)
                int r2 = r5.readInt()
                if (r2 == 0) goto L_0x003b
                android.os.Parcelable$Creator r0 = android.os.Bundle.CREATOR
                java.lang.Object r0 = r0.createFromParcel(r5)
                android.os.Bundle r0 = (android.os.Bundle) r0
            L_0x003b:
                r3.onCreate(r0)
                r6.writeNoException()
                r0 = r1
                goto L_0x0009
            L_0x0043:
                java.lang.String r0 = "com.google.android.gms.maps.internal.IMapViewDelegate"
                r5.enforceInterface(r0)
                r3.onResume()
                r6.writeNoException()
                r0 = r1
                goto L_0x0009
            L_0x0050:
                java.lang.String r0 = "com.google.android.gms.maps.internal.IMapViewDelegate"
                r5.enforceInterface(r0)
                r3.onPause()
                r6.writeNoException()
                r0 = r1
                goto L_0x0009
            L_0x005d:
                java.lang.String r0 = "com.google.android.gms.maps.internal.IMapViewDelegate"
                r5.enforceInterface(r0)
                r3.onDestroy()
                r6.writeNoException()
                r0 = r1
                goto L_0x0009
            L_0x006a:
                java.lang.String r0 = "com.google.android.gms.maps.internal.IMapViewDelegate"
                r5.enforceInterface(r0)
                r3.onLowMemory()
                r6.writeNoException()
                r0 = r1
                goto L_0x0009
            L_0x0077:
                java.lang.String r2 = "com.google.android.gms.maps.internal.IMapViewDelegate"
                r5.enforceInterface(r2)
                int r2 = r5.readInt()
                if (r2 == 0) goto L_0x008a
                android.os.Parcelable$Creator r0 = android.os.Bundle.CREATOR
                java.lang.Object r0 = r0.createFromParcel(r5)
                android.os.Bundle r0 = (android.os.Bundle) r0
            L_0x008a:
                r3.onSaveInstanceState(r0)
                r6.writeNoException()
                if (r0 == 0) goto L_0x009b
                r6.writeInt(r1)
                r0.writeToParcel(r6, r1)
            L_0x0098:
                r0 = r1
                goto L_0x0009
            L_0x009b:
                r0 = 0
                r6.writeInt(r0)
                goto L_0x0098
            L_0x00a0:
                java.lang.String r2 = "com.google.android.gms.maps.internal.IMapViewDelegate"
                r5.enforceInterface(r2)
                com.google.android.gms.b.j r2 = r3.getView()
                r6.writeNoException()
                if (r2 == 0) goto L_0x00b2
                android.os.IBinder r0 = r2.asBinder()
            L_0x00b2:
                r6.writeStrongBinder(r0)
                r0 = r1
                goto L_0x0009
            L_0x00b8:
                java.lang.String r0 = "com.google.android.gms.maps.internal.IMapViewDelegate"
                r5.enforceInterface(r0)
                android.os.IBinder r0 = r5.readStrongBinder()
                com.google.android.gms.maps.internal.zzl r0 = com.google.android.gms.maps.internal.zzl.zza.zzcx(r0)
                r3.getMapAsync(r0)
                r6.writeNoException()
                r0 = r1
                goto L_0x0009
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.maps.internal.IMapViewDelegate.zza.onTransact(int, android.os.Parcel, android.os.Parcel, int):boolean");
        }
    }

    IGoogleMapDelegate getMap();

    void getMapAsync(zzl zzl);

    C0605j getView();

    void onCreate(Bundle bundle);

    void onDestroy();

    void onLowMemory();

    void onPause();

    void onResume();

    void onSaveInstanceState(Bundle bundle);
}
