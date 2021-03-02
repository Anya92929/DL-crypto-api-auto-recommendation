package com.google.android.gms.location.internal;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;

/* renamed from: com.google.android.gms.location.internal.j */
public abstract class C1130j extends Binder implements C1129i {
    /* renamed from: a */
    public static C1129i m4915a(IBinder iBinder) {
        if (iBinder == null) {
            return null;
        }
        IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.location.internal.IGoogleLocationManagerService");
        return (queryLocalInterface == null || !(queryLocalInterface instanceof C1129i)) ? new C1131k(iBinder) : (C1129i) queryLocalInterface;
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v4, resolved type: com.google.android.gms.location.internal.LocationRequestUpdateData} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v6, resolved type: com.google.android.gms.location.internal.LocationRequestInternal} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v8, resolved type: com.google.android.gms.location.LocationRequest} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v10, resolved type: com.google.android.gms.location.LocationRequest} */
    /* JADX WARNING: type inference failed for: r1v0 */
    /* JADX WARNING: type inference failed for: r1v21 */
    /* JADX WARNING: type inference failed for: r1v22 */
    /* JADX WARNING: type inference failed for: r1v23 */
    /* JADX WARNING: type inference failed for: r1v24 */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean onTransact(int r7, android.os.Parcel r8, android.os.Parcel r9, int r10) {
        /*
            r6 = this;
            r2 = 0
            r1 = 0
            r3 = 1
            switch(r7) {
                case 1: goto L_0x0011;
                case 2: goto L_0x0074;
                case 3: goto L_0x009d;
                case 4: goto L_0x00ba;
                case 5: goto L_0x00d3;
                case 6: goto L_0x00fb;
                case 7: goto L_0x01f2;
                case 8: goto L_0x020d;
                case 9: goto L_0x0253;
                case 10: goto L_0x02cc;
                case 11: goto L_0x02e1;
                case 12: goto L_0x0317;
                case 13: goto L_0x032b;
                case 20: goto L_0x022e;
                case 21: goto L_0x0348;
                case 26: goto L_0x0367;
                case 34: goto L_0x0388;
                case 51: goto L_0x03a7;
                case 52: goto L_0x027f;
                case 53: goto L_0x02a0;
                case 57: goto L_0x003f;
                case 59: goto L_0x02fe;
                case 60: goto L_0x018d;
                case 61: goto L_0x01c7;
                case 63: goto L_0x03b8;
                case 64: goto L_0x0118;
                case 65: goto L_0x0137;
                case 66: goto L_0x0162;
                case 1598968902: goto L_0x000b;
                default: goto L_0x0006;
            }
        L_0x0006:
            boolean r3 = super.onTransact(r7, r8, r9, r10)
        L_0x000a:
            return r3
        L_0x000b:
            java.lang.String r0 = "com.google.android.gms.location.internal.IGoogleLocationManagerService"
            r9.writeString(r0)
            goto L_0x000a
        L_0x0011:
            java.lang.String r0 = "com.google.android.gms.location.internal.IGoogleLocationManagerService"
            r8.enforceInterface(r0)
            com.google.android.gms.location.internal.u r0 = com.google.android.gms.location.internal.ParcelableGeofence.CREATOR
            java.util.ArrayList r2 = r8.createTypedArrayList(r0)
            int r0 = r8.readInt()
            if (r0 == 0) goto L_0x003d
            android.os.Parcelable$Creator r0 = android.app.PendingIntent.CREATOR
            java.lang.Object r0 = r0.createFromParcel(r8)
            android.app.PendingIntent r0 = (android.app.PendingIntent) r0
        L_0x002a:
            android.os.IBinder r1 = r8.readStrongBinder()
            com.google.android.gms.location.internal.f r1 = com.google.android.gms.location.internal.C1127g.m4883a(r1)
            java.lang.String r4 = r8.readString()
            r6.mo7868a(r2, r0, r1, r4)
            r9.writeNoException()
            goto L_0x000a
        L_0x003d:
            r0 = r1
            goto L_0x002a
        L_0x003f:
            java.lang.String r0 = "com.google.android.gms.location.internal.IGoogleLocationManagerService"
            r8.enforceInterface(r0)
            int r0 = r8.readInt()
            if (r0 == 0) goto L_0x0070
            android.os.Parcelable$Creator<com.google.android.gms.location.GeofencingRequest> r0 = com.google.android.gms.location.GeofencingRequest.CREATOR
            java.lang.Object r0 = r0.createFromParcel(r8)
            com.google.android.gms.location.GeofencingRequest r0 = (com.google.android.gms.location.GeofencingRequest) r0
            r2 = r0
        L_0x0053:
            int r0 = r8.readInt()
            if (r0 == 0) goto L_0x0072
            android.os.Parcelable$Creator r0 = android.app.PendingIntent.CREATOR
            java.lang.Object r0 = r0.createFromParcel(r8)
            android.app.PendingIntent r0 = (android.app.PendingIntent) r0
        L_0x0061:
            android.os.IBinder r1 = r8.readStrongBinder()
            com.google.android.gms.location.internal.f r1 = com.google.android.gms.location.internal.C1127g.m4883a(r1)
            r6.mo7858a((com.google.android.gms.location.GeofencingRequest) r2, (android.app.PendingIntent) r0, (com.google.android.gms.location.internal.C1126f) r1)
            r9.writeNoException()
            goto L_0x000a
        L_0x0070:
            r2 = r1
            goto L_0x0053
        L_0x0072:
            r0 = r1
            goto L_0x0061
        L_0x0074:
            java.lang.String r0 = "com.google.android.gms.location.internal.IGoogleLocationManagerService"
            r8.enforceInterface(r0)
            int r0 = r8.readInt()
            if (r0 == 0) goto L_0x009b
            android.os.Parcelable$Creator r0 = android.app.PendingIntent.CREATOR
            java.lang.Object r0 = r0.createFromParcel(r8)
            android.app.PendingIntent r0 = (android.app.PendingIntent) r0
        L_0x0087:
            android.os.IBinder r1 = r8.readStrongBinder()
            com.google.android.gms.location.internal.f r1 = com.google.android.gms.location.internal.C1127g.m4883a(r1)
            java.lang.String r2 = r8.readString()
            r6.mo7855a((android.app.PendingIntent) r0, (com.google.android.gms.location.internal.C1126f) r1, (java.lang.String) r2)
            r9.writeNoException()
            goto L_0x000a
        L_0x009b:
            r0 = r1
            goto L_0x0087
        L_0x009d:
            java.lang.String r0 = "com.google.android.gms.location.internal.IGoogleLocationManagerService"
            r8.enforceInterface(r0)
            java.lang.String[] r0 = r8.createStringArray()
            android.os.IBinder r1 = r8.readStrongBinder()
            com.google.android.gms.location.internal.f r1 = com.google.android.gms.location.internal.C1127g.m4883a(r1)
            java.lang.String r2 = r8.readString()
            r6.mo7870a((java.lang.String[]) r0, (com.google.android.gms.location.internal.C1126f) r1, (java.lang.String) r2)
            r9.writeNoException()
            goto L_0x000a
        L_0x00ba:
            java.lang.String r0 = "com.google.android.gms.location.internal.IGoogleLocationManagerService"
            r8.enforceInterface(r0)
            android.os.IBinder r0 = r8.readStrongBinder()
            com.google.android.gms.location.internal.f r0 = com.google.android.gms.location.internal.C1127g.m4883a(r0)
            java.lang.String r1 = r8.readString()
            r6.mo7866a((com.google.android.gms.location.internal.C1126f) r0, (java.lang.String) r1)
            r9.writeNoException()
            goto L_0x000a
        L_0x00d3:
            java.lang.String r0 = "com.google.android.gms.location.internal.IGoogleLocationManagerService"
            r8.enforceInterface(r0)
            long r4 = r8.readLong()
            int r0 = r8.readInt()
            if (r0 == 0) goto L_0x00e3
            r2 = r3
        L_0x00e3:
            int r0 = r8.readInt()
            if (r0 == 0) goto L_0x00f9
            android.os.Parcelable$Creator r0 = android.app.PendingIntent.CREATOR
            java.lang.Object r0 = r0.createFromParcel(r8)
            android.app.PendingIntent r0 = (android.app.PendingIntent) r0
        L_0x00f1:
            r6.mo7853a((long) r4, (boolean) r2, (android.app.PendingIntent) r0)
            r9.writeNoException()
            goto L_0x000a
        L_0x00f9:
            r0 = r1
            goto L_0x00f1
        L_0x00fb:
            java.lang.String r0 = "com.google.android.gms.location.internal.IGoogleLocationManagerService"
            r8.enforceInterface(r0)
            int r0 = r8.readInt()
            if (r0 == 0) goto L_0x0116
            android.os.Parcelable$Creator r0 = android.app.PendingIntent.CREATOR
            java.lang.Object r0 = r0.createFromParcel(r8)
            android.app.PendingIntent r0 = (android.app.PendingIntent) r0
        L_0x010e:
            r6.mo7854a((android.app.PendingIntent) r0)
            r9.writeNoException()
            goto L_0x000a
        L_0x0116:
            r0 = r1
            goto L_0x010e
        L_0x0118:
            java.lang.String r0 = "com.google.android.gms.location.internal.IGoogleLocationManagerService"
            r8.enforceInterface(r0)
            java.lang.String r0 = r8.readString()
            com.google.android.gms.location.ActivityRecognitionResult r0 = r6.mo7852a((java.lang.String) r0)
            r9.writeNoException()
            if (r0 == 0) goto L_0x0132
            r9.writeInt(r3)
            r0.writeToParcel(r9, r3)
            goto L_0x000a
        L_0x0132:
            r9.writeInt(r2)
            goto L_0x000a
        L_0x0137:
            java.lang.String r0 = "com.google.android.gms.location.internal.IGoogleLocationManagerService"
            r8.enforceInterface(r0)
            int r0 = r8.readInt()
            if (r0 == 0) goto L_0x015b
            android.os.Parcelable$Creator r0 = android.app.PendingIntent.CREATOR
            java.lang.Object r0 = r0.createFromParcel(r8)
            android.app.PendingIntent r0 = (android.app.PendingIntent) r0
        L_0x014a:
            com.google.android.gms.common.api.Status r0 = r6.mo7873b((android.app.PendingIntent) r0)
            r9.writeNoException()
            if (r0 == 0) goto L_0x015d
            r9.writeInt(r3)
            r0.writeToParcel(r9, r3)
            goto L_0x000a
        L_0x015b:
            r0 = r1
            goto L_0x014a
        L_0x015d:
            r9.writeInt(r2)
            goto L_0x000a
        L_0x0162:
            java.lang.String r0 = "com.google.android.gms.location.internal.IGoogleLocationManagerService"
            r8.enforceInterface(r0)
            int r0 = r8.readInt()
            if (r0 == 0) goto L_0x0186
            android.os.Parcelable$Creator r0 = android.app.PendingIntent.CREATOR
            java.lang.Object r0 = r0.createFromParcel(r8)
            android.app.PendingIntent r0 = (android.app.PendingIntent) r0
        L_0x0175:
            com.google.android.gms.common.api.Status r0 = r6.mo7874c((android.app.PendingIntent) r0)
            r9.writeNoException()
            if (r0 == 0) goto L_0x0188
            r9.writeInt(r3)
            r0.writeToParcel(r9, r3)
            goto L_0x000a
        L_0x0186:
            r0 = r1
            goto L_0x0175
        L_0x0188:
            r9.writeInt(r2)
            goto L_0x000a
        L_0x018d:
            java.lang.String r0 = "com.google.android.gms.location.internal.IGoogleLocationManagerService"
            r8.enforceInterface(r0)
            int r0 = r8.readInt()
            if (r0 == 0) goto L_0x01be
            com.google.android.gms.location.l r0 = com.google.android.gms.location.GestureRequest.CREATOR
            com.google.android.gms.location.GestureRequest r0 = r0.createFromParcel((android.os.Parcel) r8)
            r4 = r0
        L_0x019f:
            int r0 = r8.readInt()
            if (r0 == 0) goto L_0x01c0
            android.os.Parcelable$Creator r0 = android.app.PendingIntent.CREATOR
            java.lang.Object r0 = r0.createFromParcel(r8)
            android.app.PendingIntent r0 = (android.app.PendingIntent) r0
        L_0x01ad:
            com.google.android.gms.common.api.Status r0 = r6.mo7851a((com.google.android.gms.location.GestureRequest) r4, (android.app.PendingIntent) r0)
            r9.writeNoException()
            if (r0 == 0) goto L_0x01c2
            r9.writeInt(r3)
            r0.writeToParcel(r9, r3)
            goto L_0x000a
        L_0x01be:
            r4 = r1
            goto L_0x019f
        L_0x01c0:
            r0 = r1
            goto L_0x01ad
        L_0x01c2:
            r9.writeInt(r2)
            goto L_0x000a
        L_0x01c7:
            java.lang.String r0 = "com.google.android.gms.location.internal.IGoogleLocationManagerService"
            r8.enforceInterface(r0)
            int r0 = r8.readInt()
            if (r0 == 0) goto L_0x01eb
            android.os.Parcelable$Creator r0 = android.app.PendingIntent.CREATOR
            java.lang.Object r0 = r0.createFromParcel(r8)
            android.app.PendingIntent r0 = (android.app.PendingIntent) r0
        L_0x01da:
            com.google.android.gms.common.api.Status r0 = r6.mo7876d(r0)
            r9.writeNoException()
            if (r0 == 0) goto L_0x01ed
            r9.writeInt(r3)
            r0.writeToParcel(r9, r3)
            goto L_0x000a
        L_0x01eb:
            r0 = r1
            goto L_0x01da
        L_0x01ed:
            r9.writeInt(r2)
            goto L_0x000a
        L_0x01f2:
            java.lang.String r0 = "com.google.android.gms.location.internal.IGoogleLocationManagerService"
            r8.enforceInterface(r0)
            android.location.Location r0 = r6.mo7850a()
            r9.writeNoException()
            if (r0 == 0) goto L_0x0208
            r9.writeInt(r3)
            r0.writeToParcel(r9, r3)
            goto L_0x000a
        L_0x0208:
            r9.writeInt(r2)
            goto L_0x000a
        L_0x020d:
            java.lang.String r0 = "com.google.android.gms.location.internal.IGoogleLocationManagerService"
            r8.enforceInterface(r0)
            int r0 = r8.readInt()
            if (r0 == 0) goto L_0x021e
            com.google.android.gms.location.g r0 = com.google.android.gms.location.LocationRequest.CREATOR
            com.google.android.gms.location.LocationRequest r1 = r0.createFromParcel((android.os.Parcel) r8)
        L_0x021e:
            android.os.IBinder r0 = r8.readStrongBinder()
            com.google.android.gms.location.p r0 = com.google.android.gms.location.C1151q.m4981a(r0)
            r6.mo7860a((com.google.android.gms.location.LocationRequest) r1, (com.google.android.gms.location.C1150p) r0)
            r9.writeNoException()
            goto L_0x000a
        L_0x022e:
            java.lang.String r0 = "com.google.android.gms.location.internal.IGoogleLocationManagerService"
            r8.enforceInterface(r0)
            int r0 = r8.readInt()
            if (r0 == 0) goto L_0x023f
            com.google.android.gms.location.g r0 = com.google.android.gms.location.LocationRequest.CREATOR
            com.google.android.gms.location.LocationRequest r1 = r0.createFromParcel((android.os.Parcel) r8)
        L_0x023f:
            android.os.IBinder r0 = r8.readStrongBinder()
            com.google.android.gms.location.p r0 = com.google.android.gms.location.C1151q.m4981a(r0)
            java.lang.String r2 = r8.readString()
            r6.mo7861a((com.google.android.gms.location.LocationRequest) r1, (com.google.android.gms.location.C1150p) r0, (java.lang.String) r2)
            r9.writeNoException()
            goto L_0x000a
        L_0x0253:
            java.lang.String r0 = "com.google.android.gms.location.internal.IGoogleLocationManagerService"
            r8.enforceInterface(r0)
            int r0 = r8.readInt()
            if (r0 == 0) goto L_0x027b
            com.google.android.gms.location.g r0 = com.google.android.gms.location.LocationRequest.CREATOR
            com.google.android.gms.location.LocationRequest r0 = r0.createFromParcel((android.os.Parcel) r8)
            r2 = r0
        L_0x0265:
            int r0 = r8.readInt()
            if (r0 == 0) goto L_0x027d
            android.os.Parcelable$Creator r0 = android.app.PendingIntent.CREATOR
            java.lang.Object r0 = r0.createFromParcel(r8)
            android.app.PendingIntent r0 = (android.app.PendingIntent) r0
        L_0x0273:
            r6.mo7859a((com.google.android.gms.location.LocationRequest) r2, (android.app.PendingIntent) r0)
            r9.writeNoException()
            goto L_0x000a
        L_0x027b:
            r2 = r1
            goto L_0x0265
        L_0x027d:
            r0 = r1
            goto L_0x0273
        L_0x027f:
            java.lang.String r0 = "com.google.android.gms.location.internal.IGoogleLocationManagerService"
            r8.enforceInterface(r0)
            int r0 = r8.readInt()
            if (r0 == 0) goto L_0x0290
            com.google.android.gms.location.internal.s r0 = com.google.android.gms.location.internal.LocationRequestInternal.CREATOR
            com.google.android.gms.location.internal.LocationRequestInternal r1 = r0.createFromParcel((android.os.Parcel) r8)
        L_0x0290:
            android.os.IBinder r0 = r8.readStrongBinder()
            com.google.android.gms.location.p r0 = com.google.android.gms.location.C1151q.m4981a(r0)
            r6.mo7864a((com.google.android.gms.location.internal.LocationRequestInternal) r1, (com.google.android.gms.location.C1150p) r0)
            r9.writeNoException()
            goto L_0x000a
        L_0x02a0:
            java.lang.String r0 = "com.google.android.gms.location.internal.IGoogleLocationManagerService"
            r8.enforceInterface(r0)
            int r0 = r8.readInt()
            if (r0 == 0) goto L_0x02c8
            com.google.android.gms.location.internal.s r0 = com.google.android.gms.location.internal.LocationRequestInternal.CREATOR
            com.google.android.gms.location.internal.LocationRequestInternal r0 = r0.createFromParcel((android.os.Parcel) r8)
            r2 = r0
        L_0x02b2:
            int r0 = r8.readInt()
            if (r0 == 0) goto L_0x02ca
            android.os.Parcelable$Creator r0 = android.app.PendingIntent.CREATOR
            java.lang.Object r0 = r0.createFromParcel(r8)
            android.app.PendingIntent r0 = (android.app.PendingIntent) r0
        L_0x02c0:
            r6.mo7863a((com.google.android.gms.location.internal.LocationRequestInternal) r2, (android.app.PendingIntent) r0)
            r9.writeNoException()
            goto L_0x000a
        L_0x02c8:
            r2 = r1
            goto L_0x02b2
        L_0x02ca:
            r0 = r1
            goto L_0x02c0
        L_0x02cc:
            java.lang.String r0 = "com.google.android.gms.location.internal.IGoogleLocationManagerService"
            r8.enforceInterface(r0)
            android.os.IBinder r0 = r8.readStrongBinder()
            com.google.android.gms.location.p r0 = com.google.android.gms.location.C1151q.m4981a(r0)
            r6.mo7867a((com.google.android.gms.location.C1150p) r0)
            r9.writeNoException()
            goto L_0x000a
        L_0x02e1:
            java.lang.String r0 = "com.google.android.gms.location.internal.IGoogleLocationManagerService"
            r8.enforceInterface(r0)
            int r0 = r8.readInt()
            if (r0 == 0) goto L_0x02fc
            android.os.Parcelable$Creator r0 = android.app.PendingIntent.CREATOR
            java.lang.Object r0 = r0.createFromParcel(r8)
            android.app.PendingIntent r0 = (android.app.PendingIntent) r0
        L_0x02f4:
            r6.mo7877e(r0)
            r9.writeNoException()
            goto L_0x000a
        L_0x02fc:
            r0 = r1
            goto L_0x02f4
        L_0x02fe:
            java.lang.String r0 = "com.google.android.gms.location.internal.IGoogleLocationManagerService"
            r8.enforceInterface(r0)
            int r0 = r8.readInt()
            if (r0 == 0) goto L_0x030f
            com.google.android.gms.location.internal.t r0 = com.google.android.gms.location.internal.LocationRequestUpdateData.CREATOR
            com.google.android.gms.location.internal.LocationRequestUpdateData r1 = r0.createFromParcel((android.os.Parcel) r8)
        L_0x030f:
            r6.mo7865a((com.google.android.gms.location.internal.LocationRequestUpdateData) r1)
            r9.writeNoException()
            goto L_0x000a
        L_0x0317:
            java.lang.String r0 = "com.google.android.gms.location.internal.IGoogleLocationManagerService"
            r8.enforceInterface(r0)
            int r0 = r8.readInt()
            if (r0 == 0) goto L_0x0323
            r2 = r3
        L_0x0323:
            r6.mo7869a((boolean) r2)
            r9.writeNoException()
            goto L_0x000a
        L_0x032b:
            java.lang.String r0 = "com.google.android.gms.location.internal.IGoogleLocationManagerService"
            r8.enforceInterface(r0)
            int r0 = r8.readInt()
            if (r0 == 0) goto L_0x0346
            android.os.Parcelable$Creator r0 = android.location.Location.CREATOR
            java.lang.Object r0 = r0.createFromParcel(r8)
            android.location.Location r0 = (android.location.Location) r0
        L_0x033e:
            r6.mo7856a((android.location.Location) r0)
            r9.writeNoException()
            goto L_0x000a
        L_0x0346:
            r0 = r1
            goto L_0x033e
        L_0x0348:
            java.lang.String r0 = "com.google.android.gms.location.internal.IGoogleLocationManagerService"
            r8.enforceInterface(r0)
            java.lang.String r0 = r8.readString()
            android.location.Location r0 = r6.mo7871b((java.lang.String) r0)
            r9.writeNoException()
            if (r0 == 0) goto L_0x0362
            r9.writeInt(r3)
            r0.writeToParcel(r9, r3)
            goto L_0x000a
        L_0x0362:
            r9.writeInt(r2)
            goto L_0x000a
        L_0x0367:
            java.lang.String r0 = "com.google.android.gms.location.internal.IGoogleLocationManagerService"
            r8.enforceInterface(r0)
            int r0 = r8.readInt()
            if (r0 == 0) goto L_0x0386
            android.os.Parcelable$Creator r0 = android.location.Location.CREATOR
            java.lang.Object r0 = r0.createFromParcel(r8)
            android.location.Location r0 = (android.location.Location) r0
        L_0x037a:
            int r1 = r8.readInt()
            r6.mo7857a((android.location.Location) r0, (int) r1)
            r9.writeNoException()
            goto L_0x000a
        L_0x0386:
            r0 = r1
            goto L_0x037a
        L_0x0388:
            java.lang.String r0 = "com.google.android.gms.location.internal.IGoogleLocationManagerService"
            r8.enforceInterface(r0)
            java.lang.String r0 = r8.readString()
            com.google.android.gms.location.LocationAvailability r0 = r6.mo7875c((java.lang.String) r0)
            r9.writeNoException()
            if (r0 == 0) goto L_0x03a2
            r9.writeInt(r3)
            r0.writeToParcel(r9, r3)
            goto L_0x000a
        L_0x03a2:
            r9.writeInt(r2)
            goto L_0x000a
        L_0x03a7:
            java.lang.String r0 = "com.google.android.gms.location.internal.IGoogleLocationManagerService"
            r8.enforceInterface(r0)
            android.os.IBinder r0 = r6.mo7872b()
            r9.writeNoException()
            r9.writeStrongBinder(r0)
            goto L_0x000a
        L_0x03b8:
            java.lang.String r0 = "com.google.android.gms.location.internal.IGoogleLocationManagerService"
            r8.enforceInterface(r0)
            int r0 = r8.readInt()
            if (r0 == 0) goto L_0x03df
            android.os.Parcelable$Creator<com.google.android.gms.location.LocationSettingsRequest> r0 = com.google.android.gms.location.LocationSettingsRequest.CREATOR
            java.lang.Object r0 = r0.createFromParcel(r8)
            com.google.android.gms.location.LocationSettingsRequest r0 = (com.google.android.gms.location.LocationSettingsRequest) r0
        L_0x03cb:
            android.os.IBinder r1 = r8.readStrongBinder()
            com.google.android.gms.location.internal.l r1 = com.google.android.gms.location.internal.C1133m.m4945a(r1)
            java.lang.String r2 = r8.readString()
            r6.mo7862a((com.google.android.gms.location.LocationSettingsRequest) r0, (com.google.android.gms.location.internal.C1132l) r1, (java.lang.String) r2)
            r9.writeNoException()
            goto L_0x000a
        L_0x03df:
            r0 = r1
            goto L_0x03cb
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.location.internal.C1130j.onTransact(int, android.os.Parcel, android.os.Parcel, int):boolean");
    }
}
