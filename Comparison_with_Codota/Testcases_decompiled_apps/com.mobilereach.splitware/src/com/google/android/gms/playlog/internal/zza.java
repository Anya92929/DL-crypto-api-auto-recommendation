package com.google.android.gms.playlog.internal;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import java.util.List;

public interface zza extends IInterface {

    /* renamed from: com.google.android.gms.playlog.internal.zza$zza  reason: collision with other inner class name */
    public static abstract class C0511zza extends Binder implements zza {

        /* renamed from: com.google.android.gms.playlog.internal.zza$zza$zza  reason: collision with other inner class name */
        private static class C0512zza implements zza {
            private IBinder zzoz;

            C0512zza(IBinder iBinder) {
                this.zzoz = iBinder;
            }

            public IBinder asBinder() {
                return this.zzoz;
            }

            public void zza(String str, PlayLoggerContext playLoggerContext, LogEvent logEvent) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.playlog.internal.IPlayLogService");
                    obtain.writeString(str);
                    if (playLoggerContext != null) {
                        obtain.writeInt(1);
                        playLoggerContext.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    if (logEvent != null) {
                        obtain.writeInt(1);
                        logEvent.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.zzoz.transact(2, obtain, (Parcel) null, 1);
                } finally {
                    obtain.recycle();
                }
            }

            public void zza(String str, PlayLoggerContext playLoggerContext, List<LogEvent> list) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.playlog.internal.IPlayLogService");
                    obtain.writeString(str);
                    if (playLoggerContext != null) {
                        obtain.writeInt(1);
                        playLoggerContext.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    obtain.writeTypedList(list);
                    this.zzoz.transact(3, obtain, (Parcel) null, 1);
                } finally {
                    obtain.recycle();
                }
            }

            public void zza(String str, PlayLoggerContext playLoggerContext, byte[] bArr) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.playlog.internal.IPlayLogService");
                    obtain.writeString(str);
                    if (playLoggerContext != null) {
                        obtain.writeInt(1);
                        playLoggerContext.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    obtain.writeByteArray(bArr);
                    this.zzoz.transact(4, obtain, (Parcel) null, 1);
                } finally {
                    obtain.recycle();
                }
            }
        }

        public static zza zzdN(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.playlog.internal.IPlayLogService");
            return (queryLocalInterface == null || !(queryLocalInterface instanceof zza)) ? new C0512zza(iBinder) : (zza) queryLocalInterface;
        }

        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v1, resolved type: com.google.android.gms.playlog.internal.PlayLoggerContext} */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v4, resolved type: com.google.android.gms.playlog.internal.PlayLoggerContext} */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v7, resolved type: com.google.android.gms.playlog.internal.LogEvent} */
        /* JADX WARNING: type inference failed for: r1v0 */
        /* JADX WARNING: type inference failed for: r1v10 */
        /* JADX WARNING: type inference failed for: r1v11 */
        /* JADX WARNING: type inference failed for: r1v12 */
        /* JADX WARNING: Multi-variable type inference failed */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public boolean onTransact(int r6, android.os.Parcel r7, android.os.Parcel r8, int r9) throws android.os.RemoteException {
            /*
                r5 = this;
                r1 = 0
                r2 = 1
                switch(r6) {
                    case 2: goto L_0x0011;
                    case 3: goto L_0x0039;
                    case 4: goto L_0x0059;
                    case 1598968902: goto L_0x000a;
                    default: goto L_0x0005;
                }
            L_0x0005:
                boolean r0 = super.onTransact(r6, r7, r8, r9)
            L_0x0009:
                return r0
            L_0x000a:
                java.lang.String r0 = "com.google.android.gms.playlog.internal.IPlayLogService"
                r8.writeString(r0)
                r0 = r2
                goto L_0x0009
            L_0x0011:
                java.lang.String r0 = "com.google.android.gms.playlog.internal.IPlayLogService"
                r7.enforceInterface(r0)
                java.lang.String r3 = r7.readString()
                int r0 = r7.readInt()
                if (r0 == 0) goto L_0x0037
                com.google.android.gms.playlog.internal.zze r0 = com.google.android.gms.playlog.internal.PlayLoggerContext.CREATOR
                com.google.android.gms.playlog.internal.PlayLoggerContext r0 = r0.createFromParcel(r7)
            L_0x0026:
                int r4 = r7.readInt()
                if (r4 == 0) goto L_0x0032
                com.google.android.gms.playlog.internal.zzc r1 = com.google.android.gms.playlog.internal.LogEvent.CREATOR
                com.google.android.gms.playlog.internal.LogEvent r1 = r1.createFromParcel(r7)
            L_0x0032:
                r5.zza((java.lang.String) r3, (com.google.android.gms.playlog.internal.PlayLoggerContext) r0, (com.google.android.gms.playlog.internal.LogEvent) r1)
                r0 = r2
                goto L_0x0009
            L_0x0037:
                r0 = r1
                goto L_0x0026
            L_0x0039:
                java.lang.String r0 = "com.google.android.gms.playlog.internal.IPlayLogService"
                r7.enforceInterface(r0)
                java.lang.String r0 = r7.readString()
                int r3 = r7.readInt()
                if (r3 == 0) goto L_0x004e
                com.google.android.gms.playlog.internal.zze r1 = com.google.android.gms.playlog.internal.PlayLoggerContext.CREATOR
                com.google.android.gms.playlog.internal.PlayLoggerContext r1 = r1.createFromParcel(r7)
            L_0x004e:
                com.google.android.gms.playlog.internal.zzc r3 = com.google.android.gms.playlog.internal.LogEvent.CREATOR
                java.util.ArrayList r3 = r7.createTypedArrayList(r3)
                r5.zza((java.lang.String) r0, (com.google.android.gms.playlog.internal.PlayLoggerContext) r1, (java.util.List<com.google.android.gms.playlog.internal.LogEvent>) r3)
                r0 = r2
                goto L_0x0009
            L_0x0059:
                java.lang.String r0 = "com.google.android.gms.playlog.internal.IPlayLogService"
                r7.enforceInterface(r0)
                java.lang.String r0 = r7.readString()
                int r3 = r7.readInt()
                if (r3 == 0) goto L_0x006e
                com.google.android.gms.playlog.internal.zze r1 = com.google.android.gms.playlog.internal.PlayLoggerContext.CREATOR
                com.google.android.gms.playlog.internal.PlayLoggerContext r1 = r1.createFromParcel(r7)
            L_0x006e:
                byte[] r3 = r7.createByteArray()
                r5.zza((java.lang.String) r0, (com.google.android.gms.playlog.internal.PlayLoggerContext) r1, (byte[]) r3)
                r0 = r2
                goto L_0x0009
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.playlog.internal.zza.C0511zza.onTransact(int, android.os.Parcel, android.os.Parcel, int):boolean");
        }
    }

    void zza(String str, PlayLoggerContext playLoggerContext, LogEvent logEvent) throws RemoteException;

    void zza(String str, PlayLoggerContext playLoggerContext, List<LogEvent> list) throws RemoteException;

    void zza(String str, PlayLoggerContext playLoggerContext, byte[] bArr) throws RemoteException;
}
