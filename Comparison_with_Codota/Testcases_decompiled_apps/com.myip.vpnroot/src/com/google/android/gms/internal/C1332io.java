package com.google.android.gms.internal;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.RemoteException;
import com.google.android.gms.cast.ApplicationMetadata;

/* renamed from: com.google.android.gms.internal.io */
public interface C1332io extends IInterface {

    /* renamed from: com.google.android.gms.internal.io$a */
    public static abstract class C1333a extends Binder implements C1332io {
        public C1333a() {
            attachInterface(this, "com.google.android.gms.cast.internal.ICastDeviceControllerListener");
        }

        public IBinder asBinder() {
            return this;
        }

        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v1, resolved type: com.google.android.gms.internal.il} */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v5, resolved type: com.google.android.gms.internal.ig} */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v27, resolved type: com.google.android.gms.cast.ApplicationMetadata} */
        /* JADX WARNING: type inference failed for: r0v0 */
        /* JADX WARNING: type inference failed for: r0v34 */
        /* JADX WARNING: type inference failed for: r0v35 */
        /* JADX WARNING: type inference failed for: r0v36 */
        /* JADX WARNING: Multi-variable type inference failed */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public boolean onTransact(int r7, android.os.Parcel r8, android.os.Parcel r9, int r10) throws android.os.RemoteException {
            /*
                r6 = this;
                r1 = 0
                r0 = 0
                r2 = 1
                switch(r7) {
                    case 1: goto L_0x0011;
                    case 2: goto L_0x001e;
                    case 3: goto L_0x0044;
                    case 4: goto L_0x0051;
                    case 5: goto L_0x0069;
                    case 6: goto L_0x007a;
                    case 7: goto L_0x008b;
                    case 8: goto L_0x0099;
                    case 9: goto L_0x00a7;
                    case 10: goto L_0x00b5;
                    case 11: goto L_0x00cb;
                    case 12: goto L_0x00dd;
                    case 13: goto L_0x00f5;
                    case 1598968902: goto L_0x000b;
                    default: goto L_0x0006;
                }
            L_0x0006:
                boolean r2 = super.onTransact(r7, r8, r9, r10)
            L_0x000a:
                return r2
            L_0x000b:
                java.lang.String r0 = "com.google.android.gms.cast.internal.ICastDeviceControllerListener"
                r9.writeString(r0)
                goto L_0x000a
            L_0x0011:
                java.lang.String r0 = "com.google.android.gms.cast.internal.ICastDeviceControllerListener"
                r8.enforceInterface(r0)
                int r0 = r8.readInt()
                r6.mo8861ac(r0)
                goto L_0x000a
            L_0x001e:
                java.lang.String r3 = "com.google.android.gms.cast.internal.ICastDeviceControllerListener"
                r8.enforceInterface(r3)
                int r3 = r8.readInt()
                if (r3 == 0) goto L_0x0031
                android.os.Parcelable$Creator<com.google.android.gms.cast.ApplicationMetadata> r0 = com.google.android.gms.cast.ApplicationMetadata.CREATOR
                java.lang.Object r0 = r0.createFromParcel(r8)
                com.google.android.gms.cast.ApplicationMetadata r0 = (com.google.android.gms.cast.ApplicationMetadata) r0
            L_0x0031:
                java.lang.String r3 = r8.readString()
                java.lang.String r4 = r8.readString()
                int r5 = r8.readInt()
                if (r5 == 0) goto L_0x0040
                r1 = r2
            L_0x0040:
                r6.mo8857a(r0, r3, r4, r1)
                goto L_0x000a
            L_0x0044:
                java.lang.String r0 = "com.google.android.gms.cast.internal.ICastDeviceControllerListener"
                r8.enforceInterface(r0)
                int r0 = r8.readInt()
                r6.mo8862ad(r0)
                goto L_0x000a
            L_0x0051:
                java.lang.String r0 = "com.google.android.gms.cast.internal.ICastDeviceControllerListener"
                r8.enforceInterface(r0)
                java.lang.String r0 = r8.readString()
                double r3 = r8.readDouble()
                int r5 = r8.readInt()
                if (r5 == 0) goto L_0x0065
                r1 = r2
            L_0x0065:
                r6.mo8858a((java.lang.String) r0, (double) r3, (boolean) r1)
                goto L_0x000a
            L_0x0069:
                java.lang.String r0 = "com.google.android.gms.cast.internal.ICastDeviceControllerListener"
                r8.enforceInterface(r0)
                java.lang.String r0 = r8.readString()
                java.lang.String r1 = r8.readString()
                r6.mo8870k(r0, r1)
                goto L_0x000a
            L_0x007a:
                java.lang.String r0 = "com.google.android.gms.cast.internal.ICastDeviceControllerListener"
                r8.enforceInterface(r0)
                java.lang.String r0 = r8.readString()
                byte[] r1 = r8.createByteArray()
                r6.mo8867b(r0, r1)
                goto L_0x000a
            L_0x008b:
                java.lang.String r0 = "com.google.android.gms.cast.internal.ICastDeviceControllerListener"
                r8.enforceInterface(r0)
                int r0 = r8.readInt()
                r6.mo8864af(r0)
                goto L_0x000a
            L_0x0099:
                java.lang.String r0 = "com.google.android.gms.cast.internal.ICastDeviceControllerListener"
                r8.enforceInterface(r0)
                int r0 = r8.readInt()
                r6.mo8863ae(r0)
                goto L_0x000a
            L_0x00a7:
                java.lang.String r0 = "com.google.android.gms.cast.internal.ICastDeviceControllerListener"
                r8.enforceInterface(r0)
                int r0 = r8.readInt()
                r6.onApplicationDisconnected(r0)
                goto L_0x000a
            L_0x00b5:
                java.lang.String r0 = "com.google.android.gms.cast.internal.ICastDeviceControllerListener"
                r8.enforceInterface(r0)
                java.lang.String r0 = r8.readString()
                long r3 = r8.readLong()
                int r1 = r8.readInt()
                r6.mo8860a((java.lang.String) r0, (long) r3, (int) r1)
                goto L_0x000a
            L_0x00cb:
                java.lang.String r0 = "com.google.android.gms.cast.internal.ICastDeviceControllerListener"
                r8.enforceInterface(r0)
                java.lang.String r0 = r8.readString()
                long r3 = r8.readLong()
                r6.mo8859a(r0, r3)
                goto L_0x000a
            L_0x00dd:
                java.lang.String r1 = "com.google.android.gms.cast.internal.ICastDeviceControllerListener"
                r8.enforceInterface(r1)
                int r1 = r8.readInt()
                if (r1 == 0) goto L_0x00f0
                android.os.Parcelable$Creator<com.google.android.gms.internal.ig> r0 = com.google.android.gms.internal.C1314ig.CREATOR
                java.lang.Object r0 = r0.createFromParcel(r8)
                com.google.android.gms.internal.ig r0 = (com.google.android.gms.internal.C1314ig) r0
            L_0x00f0:
                r6.mo8865b((com.google.android.gms.internal.C1314ig) r0)
                goto L_0x000a
            L_0x00f5:
                java.lang.String r1 = "com.google.android.gms.cast.internal.ICastDeviceControllerListener"
                r8.enforceInterface(r1)
                int r1 = r8.readInt()
                if (r1 == 0) goto L_0x0108
                android.os.Parcelable$Creator<com.google.android.gms.internal.il> r0 = com.google.android.gms.internal.C1327il.CREATOR
                java.lang.Object r0 = r0.createFromParcel(r8)
                com.google.android.gms.internal.il r0 = (com.google.android.gms.internal.C1327il) r0
            L_0x0108:
                r6.mo8866b((com.google.android.gms.internal.C1327il) r0)
                goto L_0x000a
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.C1332io.C1333a.onTransact(int, android.os.Parcel, android.os.Parcel, int):boolean");
        }
    }

    /* renamed from: a */
    void mo8857a(ApplicationMetadata applicationMetadata, String str, String str2, boolean z) throws RemoteException;

    /* renamed from: a */
    void mo8858a(String str, double d, boolean z) throws RemoteException;

    /* renamed from: a */
    void mo8859a(String str, long j) throws RemoteException;

    /* renamed from: a */
    void mo8860a(String str, long j, int i) throws RemoteException;

    /* renamed from: ac */
    void mo8861ac(int i) throws RemoteException;

    /* renamed from: ad */
    void mo8862ad(int i) throws RemoteException;

    /* renamed from: ae */
    void mo8863ae(int i) throws RemoteException;

    /* renamed from: af */
    void mo8864af(int i) throws RemoteException;

    /* renamed from: b */
    void mo8865b(C1314ig igVar) throws RemoteException;

    /* renamed from: b */
    void mo8866b(C1327il ilVar) throws RemoteException;

    /* renamed from: b */
    void mo8867b(String str, byte[] bArr) throws RemoteException;

    /* renamed from: k */
    void mo8870k(String str, String str2) throws RemoteException;

    void onApplicationDisconnected(int i) throws RemoteException;
}
