package com.google.android.gms.location;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;

/* renamed from: com.google.android.gms.location.n */
public abstract class C1148n extends Binder implements C1147m {
    /* renamed from: a */
    public static C1147m m4977a(IBinder iBinder) {
        if (iBinder == null) {
            return null;
        }
        IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.location.ILocationCallback");
        return (queryLocalInterface == null || !(queryLocalInterface instanceof C1147m)) ? new C1149o(iBinder) : (C1147m) queryLocalInterface;
    }

    public IBinder asBinder() {
        return this;
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v1, resolved type: com.google.android.gms.location.LocationAvailability} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v5, resolved type: com.google.android.gms.location.LocationResult} */
    /* JADX WARNING: type inference failed for: r0v0 */
    /* JADX WARNING: type inference failed for: r0v13 */
    /* JADX WARNING: type inference failed for: r0v14 */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean onTransact(int r4, android.os.Parcel r5, android.os.Parcel r6, int r7) {
        /*
            r3 = this;
            r0 = 0
            r1 = 1
            switch(r4) {
                case 1: goto L_0x0011;
                case 2: goto L_0x0029;
                case 1598968902: goto L_0x000a;
                default: goto L_0x0005;
            }
        L_0x0005:
            boolean r0 = super.onTransact(r4, r5, r6, r7)
        L_0x0009:
            return r0
        L_0x000a:
            java.lang.String r0 = "com.google.android.gms.location.ILocationCallback"
            r6.writeString(r0)
            r0 = r1
            goto L_0x0009
        L_0x0011:
            java.lang.String r2 = "com.google.android.gms.location.ILocationCallback"
            r5.enforceInterface(r2)
            int r2 = r5.readInt()
            if (r2 == 0) goto L_0x0024
            android.os.Parcelable$Creator<com.google.android.gms.location.LocationResult> r0 = com.google.android.gms.location.LocationResult.CREATOR
            java.lang.Object r0 = r0.createFromParcel(r5)
            com.google.android.gms.location.LocationResult r0 = (com.google.android.gms.location.LocationResult) r0
        L_0x0024:
            r3.mo7889a((com.google.android.gms.location.LocationResult) r0)
            r0 = r1
            goto L_0x0009
        L_0x0029:
            java.lang.String r2 = "com.google.android.gms.location.ILocationCallback"
            r5.enforceInterface(r2)
            int r2 = r5.readInt()
            if (r2 == 0) goto L_0x003a
            com.google.android.gms.location.f r0 = com.google.android.gms.location.LocationAvailability.CREATOR
            com.google.android.gms.location.LocationAvailability r0 = r0.createFromParcel((android.os.Parcel) r5)
        L_0x003a:
            r3.mo7888a((com.google.android.gms.location.LocationAvailability) r0)
            r0 = r1
            goto L_0x0009
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.location.C1148n.onTransact(int, android.os.Parcel, android.os.Parcel, int):boolean");
    }
}
