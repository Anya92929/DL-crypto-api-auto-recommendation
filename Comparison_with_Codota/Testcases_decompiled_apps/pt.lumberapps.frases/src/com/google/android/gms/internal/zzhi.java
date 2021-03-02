package com.google.android.gms.internal;

import android.content.Intent;
import android.os.Binder;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;

public interface zzhi extends IInterface {

    public abstract class zza extends Binder implements zzhi {
        public zza() {
            attachInterface(this, "com.google.android.gms.ads.internal.overlay.client.IAdOverlay");
        }

        public static zzhi zzaq(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.ads.internal.overlay.client.IAdOverlay");
            return (queryLocalInterface == null || !(queryLocalInterface instanceof zzhi)) ? new C1668jq(iBinder) : (zzhi) queryLocalInterface;
        }

        public IBinder asBinder() {
            return this;
        }

        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v14, resolved type: android.os.Bundle} */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v22, resolved type: android.os.Bundle} */
        /* JADX WARNING: type inference failed for: r0v0 */
        /* JADX WARNING: type inference failed for: r0v1, types: [android.content.Intent] */
        /* JADX WARNING: type inference failed for: r0v27 */
        /* JADX WARNING: type inference failed for: r0v28 */
        /* JADX WARNING: type inference failed for: r0v29 */
        /* JADX WARNING: Multi-variable type inference failed */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public boolean onTransact(int r6, android.os.Parcel r7, android.os.Parcel r8, int r9) {
            /*
                r5 = this;
                r2 = 0
                r0 = 0
                r1 = 1
                switch(r6) {
                    case 1: goto L_0x0011;
                    case 2: goto L_0x002b;
                    case 3: goto L_0x0037;
                    case 4: goto L_0x0043;
                    case 5: goto L_0x004f;
                    case 6: goto L_0x005b;
                    case 7: goto L_0x0081;
                    case 8: goto L_0x008e;
                    case 9: goto L_0x009b;
                    case 10: goto L_0x00a8;
                    case 11: goto L_0x00b5;
                    case 12: goto L_0x00cb;
                    case 1598968902: goto L_0x000b;
                    default: goto L_0x0006;
                }
            L_0x0006:
                boolean r1 = super.onTransact(r6, r7, r8, r9)
            L_0x000a:
                return r1
            L_0x000b:
                java.lang.String r0 = "com.google.android.gms.ads.internal.overlay.client.IAdOverlay"
                r8.writeString(r0)
                goto L_0x000a
            L_0x0011:
                java.lang.String r2 = "com.google.android.gms.ads.internal.overlay.client.IAdOverlay"
                r7.enforceInterface(r2)
                int r2 = r7.readInt()
                if (r2 == 0) goto L_0x0024
                android.os.Parcelable$Creator r0 = android.os.Bundle.CREATOR
                java.lang.Object r0 = r0.createFromParcel(r7)
                android.os.Bundle r0 = (android.os.Bundle) r0
            L_0x0024:
                r5.onCreate(r0)
                r8.writeNoException()
                goto L_0x000a
            L_0x002b:
                java.lang.String r0 = "com.google.android.gms.ads.internal.overlay.client.IAdOverlay"
                r7.enforceInterface(r0)
                r5.onRestart()
                r8.writeNoException()
                goto L_0x000a
            L_0x0037:
                java.lang.String r0 = "com.google.android.gms.ads.internal.overlay.client.IAdOverlay"
                r7.enforceInterface(r0)
                r5.onStart()
                r8.writeNoException()
                goto L_0x000a
            L_0x0043:
                java.lang.String r0 = "com.google.android.gms.ads.internal.overlay.client.IAdOverlay"
                r7.enforceInterface(r0)
                r5.onResume()
                r8.writeNoException()
                goto L_0x000a
            L_0x004f:
                java.lang.String r0 = "com.google.android.gms.ads.internal.overlay.client.IAdOverlay"
                r7.enforceInterface(r0)
                r5.onPause()
                r8.writeNoException()
                goto L_0x000a
            L_0x005b:
                java.lang.String r3 = "com.google.android.gms.ads.internal.overlay.client.IAdOverlay"
                r7.enforceInterface(r3)
                int r3 = r7.readInt()
                if (r3 == 0) goto L_0x006e
                android.os.Parcelable$Creator r0 = android.os.Bundle.CREATOR
                java.lang.Object r0 = r0.createFromParcel(r7)
                android.os.Bundle r0 = (android.os.Bundle) r0
            L_0x006e:
                r5.onSaveInstanceState(r0)
                r8.writeNoException()
                if (r0 == 0) goto L_0x007d
                r8.writeInt(r1)
                r0.writeToParcel(r8, r1)
                goto L_0x000a
            L_0x007d:
                r8.writeInt(r2)
                goto L_0x000a
            L_0x0081:
                java.lang.String r0 = "com.google.android.gms.ads.internal.overlay.client.IAdOverlay"
                r7.enforceInterface(r0)
                r5.onStop()
                r8.writeNoException()
                goto L_0x000a
            L_0x008e:
                java.lang.String r0 = "com.google.android.gms.ads.internal.overlay.client.IAdOverlay"
                r7.enforceInterface(r0)
                r5.onDestroy()
                r8.writeNoException()
                goto L_0x000a
            L_0x009b:
                java.lang.String r0 = "com.google.android.gms.ads.internal.overlay.client.IAdOverlay"
                r7.enforceInterface(r0)
                r5.zzdb()
                r8.writeNoException()
                goto L_0x000a
            L_0x00a8:
                java.lang.String r0 = "com.google.android.gms.ads.internal.overlay.client.IAdOverlay"
                r7.enforceInterface(r0)
                r5.onBackPressed()
                r8.writeNoException()
                goto L_0x000a
            L_0x00b5:
                java.lang.String r0 = "com.google.android.gms.ads.internal.overlay.client.IAdOverlay"
                r7.enforceInterface(r0)
                boolean r0 = r5.zznw()
                r8.writeNoException()
                if (r0 == 0) goto L_0x00c9
                r0 = r1
            L_0x00c4:
                r8.writeInt(r0)
                goto L_0x000a
            L_0x00c9:
                r0 = r2
                goto L_0x00c4
            L_0x00cb:
                java.lang.String r2 = "com.google.android.gms.ads.internal.overlay.client.IAdOverlay"
                r7.enforceInterface(r2)
                int r2 = r7.readInt()
                int r3 = r7.readInt()
                int r4 = r7.readInt()
                if (r4 == 0) goto L_0x00e6
                android.os.Parcelable$Creator r0 = android.content.Intent.CREATOR
                java.lang.Object r0 = r0.createFromParcel(r7)
                android.content.Intent r0 = (android.content.Intent) r0
            L_0x00e6:
                r5.onActivityResult(r2, r3, r0)
                r8.writeNoException()
                goto L_0x000a
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.zzhi.zza.onTransact(int, android.os.Parcel, android.os.Parcel, int):boolean");
        }
    }

    void onActivityResult(int i, int i2, Intent intent);

    void onBackPressed();

    void onCreate(Bundle bundle);

    void onDestroy();

    void onPause();

    void onRestart();

    void onResume();

    void onSaveInstanceState(Bundle bundle);

    void onStart();

    void onStop();

    void zzdb();

    boolean zznw();
}
