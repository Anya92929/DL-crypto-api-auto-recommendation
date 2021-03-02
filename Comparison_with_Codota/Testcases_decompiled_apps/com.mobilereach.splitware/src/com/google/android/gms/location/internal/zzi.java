package com.google.android.gms.location.internal;

import android.app.PendingIntent;
import android.location.Location;
import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.common.api.internal.zzo;
import com.google.android.gms.location.ActivityRecognitionResult;
import com.google.android.gms.location.GeofencingRequest;
import com.google.android.gms.location.GestureRequest;
import com.google.android.gms.location.LocationAvailability;
import com.google.android.gms.location.LocationRequest;
import com.google.android.gms.location.LocationSettingsRequest;
import com.google.android.gms.location.zzd;
import java.util.List;

public interface zzi extends IInterface {

    public static abstract class zza extends Binder implements zzi {

        /* renamed from: com.google.android.gms.location.internal.zzi$zza$zza  reason: collision with other inner class name */
        private static class C0452zza implements zzi {
            private IBinder zzoz;

            C0452zza(IBinder iBinder) {
                this.zzoz = iBinder;
            }

            public IBinder asBinder() {
                return this.zzoz;
            }

            public void zza(long j, boolean z, PendingIntent pendingIntent) throws RemoteException {
                int i = 1;
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.location.internal.IGoogleLocationManagerService");
                    obtain.writeLong(j);
                    if (!z) {
                        i = 0;
                    }
                    obtain.writeInt(i);
                    if (pendingIntent != null) {
                        obtain.writeInt(1);
                        pendingIntent.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.zzoz.transact(5, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void zza(PendingIntent pendingIntent) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.location.internal.IGoogleLocationManagerService");
                    if (pendingIntent != null) {
                        obtain.writeInt(1);
                        pendingIntent.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.zzoz.transact(6, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void zza(PendingIntent pendingIntent, zzo zzo) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.location.internal.IGoogleLocationManagerService");
                    if (pendingIntent != null) {
                        obtain.writeInt(1);
                        pendingIntent.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    obtain.writeStrongBinder(zzo != null ? zzo.asBinder() : null);
                    this.zzoz.transact(65, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void zza(PendingIntent pendingIntent, zzh zzh, String str) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.location.internal.IGoogleLocationManagerService");
                    if (pendingIntent != null) {
                        obtain.writeInt(1);
                        pendingIntent.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    obtain.writeStrongBinder(zzh != null ? zzh.asBinder() : null);
                    obtain.writeString(str);
                    this.zzoz.transact(2, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void zza(Location location, int i) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.location.internal.IGoogleLocationManagerService");
                    if (location != null) {
                        obtain.writeInt(1);
                        location.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    obtain.writeInt(i);
                    this.zzoz.transact(26, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void zza(GeofencingRequest geofencingRequest, PendingIntent pendingIntent, zzh zzh) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.location.internal.IGoogleLocationManagerService");
                    if (geofencingRequest != null) {
                        obtain.writeInt(1);
                        geofencingRequest.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    if (pendingIntent != null) {
                        obtain.writeInt(1);
                        pendingIntent.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    obtain.writeStrongBinder(zzh != null ? zzh.asBinder() : null);
                    this.zzoz.transact(57, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void zza(GestureRequest gestureRequest, PendingIntent pendingIntent, zzo zzo) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.location.internal.IGoogleLocationManagerService");
                    if (gestureRequest != null) {
                        obtain.writeInt(1);
                        gestureRequest.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    if (pendingIntent != null) {
                        obtain.writeInt(1);
                        pendingIntent.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    obtain.writeStrongBinder(zzo != null ? zzo.asBinder() : null);
                    this.zzoz.transact(60, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void zza(LocationRequest locationRequest, PendingIntent pendingIntent) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.location.internal.IGoogleLocationManagerService");
                    if (locationRequest != null) {
                        obtain.writeInt(1);
                        locationRequest.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    if (pendingIntent != null) {
                        obtain.writeInt(1);
                        pendingIntent.writeToParcel(obtain, 0);
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

            public void zza(LocationRequest locationRequest, zzd zzd) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.location.internal.IGoogleLocationManagerService");
                    if (locationRequest != null) {
                        obtain.writeInt(1);
                        locationRequest.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    obtain.writeStrongBinder(zzd != null ? zzd.asBinder() : null);
                    this.zzoz.transact(8, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void zza(LocationRequest locationRequest, zzd zzd, String str) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.location.internal.IGoogleLocationManagerService");
                    if (locationRequest != null) {
                        obtain.writeInt(1);
                        locationRequest.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    obtain.writeStrongBinder(zzd != null ? zzd.asBinder() : null);
                    obtain.writeString(str);
                    this.zzoz.transact(20, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void zza(LocationSettingsRequest locationSettingsRequest, zzj zzj, String str) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.location.internal.IGoogleLocationManagerService");
                    if (locationSettingsRequest != null) {
                        obtain.writeInt(1);
                        locationSettingsRequest.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    obtain.writeStrongBinder(zzj != null ? zzj.asBinder() : null);
                    obtain.writeString(str);
                    this.zzoz.transact(63, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void zza(LocationRequestInternal locationRequestInternal, PendingIntent pendingIntent) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.location.internal.IGoogleLocationManagerService");
                    if (locationRequestInternal != null) {
                        obtain.writeInt(1);
                        locationRequestInternal.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    if (pendingIntent != null) {
                        obtain.writeInt(1);
                        pendingIntent.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.zzoz.transact(53, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void zza(LocationRequestInternal locationRequestInternal, zzd zzd) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.location.internal.IGoogleLocationManagerService");
                    if (locationRequestInternal != null) {
                        obtain.writeInt(1);
                        locationRequestInternal.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    obtain.writeStrongBinder(zzd != null ? zzd.asBinder() : null);
                    this.zzoz.transact(52, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void zza(LocationRequestUpdateData locationRequestUpdateData) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.location.internal.IGoogleLocationManagerService");
                    if (locationRequestUpdateData != null) {
                        obtain.writeInt(1);
                        locationRequestUpdateData.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.zzoz.transact(59, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void zza(zzg zzg) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.location.internal.IGoogleLocationManagerService");
                    obtain.writeStrongBinder(zzg != null ? zzg.asBinder() : null);
                    this.zzoz.transact(67, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void zza(zzh zzh, String str) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.location.internal.IGoogleLocationManagerService");
                    obtain.writeStrongBinder(zzh != null ? zzh.asBinder() : null);
                    obtain.writeString(str);
                    this.zzoz.transact(4, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void zza(zzd zzd) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.location.internal.IGoogleLocationManagerService");
                    obtain.writeStrongBinder(zzd != null ? zzd.asBinder() : null);
                    this.zzoz.transact(10, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void zza(List<ParcelableGeofence> list, PendingIntent pendingIntent, zzh zzh, String str) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.location.internal.IGoogleLocationManagerService");
                    obtain.writeTypedList(list);
                    if (pendingIntent != null) {
                        obtain.writeInt(1);
                        pendingIntent.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    obtain.writeStrongBinder(zzh != null ? zzh.asBinder() : null);
                    obtain.writeString(str);
                    this.zzoz.transact(1, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void zza(String[] strArr, zzh zzh, String str) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.location.internal.IGoogleLocationManagerService");
                    obtain.writeStringArray(strArr);
                    obtain.writeStrongBinder(zzh != null ? zzh.asBinder() : null);
                    obtain.writeString(str);
                    this.zzoz.transact(3, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void zzam(boolean z) throws RemoteException {
                int i = 0;
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.location.internal.IGoogleLocationManagerService");
                    if (z) {
                        i = 1;
                    }
                    obtain.writeInt(i);
                    this.zzoz.transact(12, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void zzb(PendingIntent pendingIntent) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.location.internal.IGoogleLocationManagerService");
                    if (pendingIntent != null) {
                        obtain.writeInt(1);
                        pendingIntent.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.zzoz.transact(11, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void zzb(PendingIntent pendingIntent, zzo zzo) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.location.internal.IGoogleLocationManagerService");
                    if (pendingIntent != null) {
                        obtain.writeInt(1);
                        pendingIntent.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    obtain.writeStrongBinder(zzo != null ? zzo.asBinder() : null);
                    this.zzoz.transact(66, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void zzc(PendingIntent pendingIntent, zzo zzo) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.location.internal.IGoogleLocationManagerService");
                    if (pendingIntent != null) {
                        obtain.writeInt(1);
                        pendingIntent.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    obtain.writeStrongBinder(zzo != null ? zzo.asBinder() : null);
                    this.zzoz.transact(61, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void zzc(Location location) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.location.internal.IGoogleLocationManagerService");
                    if (location != null) {
                        obtain.writeInt(1);
                        location.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.zzoz.transact(13, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void zzd(PendingIntent pendingIntent, zzo zzo) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.location.internal.IGoogleLocationManagerService");
                    if (pendingIntent != null) {
                        obtain.writeInt(1);
                        pendingIntent.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    obtain.writeStrongBinder(zzo != null ? zzo.asBinder() : null);
                    this.zzoz.transact(68, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void zze(PendingIntent pendingIntent, zzo zzo) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.location.internal.IGoogleLocationManagerService");
                    if (pendingIntent != null) {
                        obtain.writeInt(1);
                        pendingIntent.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    obtain.writeStrongBinder(zzo != null ? zzo.asBinder() : null);
                    this.zzoz.transact(69, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public ActivityRecognitionResult zzeh(String str) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.location.internal.IGoogleLocationManagerService");
                    obtain.writeString(str);
                    this.zzoz.transact(64, obtain, obtain2, 0);
                    obtain2.readException();
                    return obtain2.readInt() != 0 ? ActivityRecognitionResult.CREATOR.createFromParcel(obtain2) : null;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public Location zzei(String str) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.location.internal.IGoogleLocationManagerService");
                    obtain.writeString(str);
                    this.zzoz.transact(21, obtain, obtain2, 0);
                    obtain2.readException();
                    return obtain2.readInt() != 0 ? (Location) Location.CREATOR.createFromParcel(obtain2) : null;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public LocationAvailability zzej(String str) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.location.internal.IGoogleLocationManagerService");
                    obtain.writeString(str);
                    this.zzoz.transact(34, obtain, obtain2, 0);
                    obtain2.readException();
                    return obtain2.readInt() != 0 ? LocationAvailability.CREATOR.createFromParcel(obtain2) : null;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public Location zzyN() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.location.internal.IGoogleLocationManagerService");
                    this.zzoz.transact(7, obtain, obtain2, 0);
                    obtain2.readException();
                    return obtain2.readInt() != 0 ? (Location) Location.CREATOR.createFromParcel(obtain2) : null;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }
        }

        public static zzi zzcj(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.location.internal.IGoogleLocationManagerService");
            return (queryLocalInterface == null || !(queryLocalInterface instanceof zzi)) ? new C0452zza(iBinder) : (zzi) queryLocalInterface;
        }

        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v12, resolved type: com.google.android.gms.location.internal.LocationRequestUpdateData} */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v14, resolved type: com.google.android.gms.location.internal.LocationRequestInternal} */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v16, resolved type: com.google.android.gms.location.LocationRequest} */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v18, resolved type: com.google.android.gms.location.LocationRequest} */
        /* JADX WARNING: type inference failed for: r1v0 */
        /* JADX WARNING: type inference failed for: r1v46 */
        /* JADX WARNING: type inference failed for: r1v47 */
        /* JADX WARNING: type inference failed for: r1v48 */
        /* JADX WARNING: type inference failed for: r1v49 */
        /* JADX WARNING: Multi-variable type inference failed */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public boolean onTransact(int r7, android.os.Parcel r8, android.os.Parcel r9, int r10) throws android.os.RemoteException {
            /*
                r6 = this;
                r0 = 0
                r1 = 0
                r3 = 1
                switch(r7) {
                    case 1: goto L_0x0011;
                    case 2: goto L_0x0074;
                    case 3: goto L_0x009d;
                    case 4: goto L_0x00ba;
                    case 5: goto L_0x00d3;
                    case 6: goto L_0x00fd;
                    case 7: goto L_0x0226;
                    case 8: goto L_0x0241;
                    case 9: goto L_0x0287;
                    case 10: goto L_0x0300;
                    case 11: goto L_0x0315;
                    case 12: goto L_0x034b;
                    case 13: goto L_0x035f;
                    case 20: goto L_0x0262;
                    case 21: goto L_0x037c;
                    case 26: goto L_0x039b;
                    case 34: goto L_0x03d1;
                    case 52: goto L_0x02b3;
                    case 53: goto L_0x02d4;
                    case 57: goto L_0x003f;
                    case 59: goto L_0x0332;
                    case 60: goto L_0x0183;
                    case 61: goto L_0x01b7;
                    case 63: goto L_0x03f0;
                    case 64: goto L_0x011a;
                    case 65: goto L_0x0139;
                    case 66: goto L_0x015e;
                    case 67: goto L_0x03bc;
                    case 68: goto L_0x01dc;
                    case 69: goto L_0x0201;
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
                com.google.android.gms.location.internal.zzo r0 = com.google.android.gms.location.internal.ParcelableGeofence.CREATOR
                java.util.ArrayList r2 = r8.createTypedArrayList(r0)
                int r0 = r8.readInt()
                if (r0 == 0) goto L_0x003d
                android.os.Parcelable$Creator r0 = android.app.PendingIntent.CREATOR
                java.lang.Object r0 = r0.createFromParcel(r8)
                android.app.PendingIntent r0 = (android.app.PendingIntent) r0
            L_0x002a:
                android.os.IBinder r1 = r8.readStrongBinder()
                com.google.android.gms.location.internal.zzh r1 = com.google.android.gms.location.internal.zzh.zza.zzci(r1)
                java.lang.String r4 = r8.readString()
                r6.zza(r2, r0, r1, r4)
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
                com.google.android.gms.location.internal.zzh r1 = com.google.android.gms.location.internal.zzh.zza.zzci(r1)
                r6.zza((com.google.android.gms.location.GeofencingRequest) r2, (android.app.PendingIntent) r0, (com.google.android.gms.location.internal.zzh) r1)
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
                com.google.android.gms.location.internal.zzh r1 = com.google.android.gms.location.internal.zzh.zza.zzci(r1)
                java.lang.String r2 = r8.readString()
                r6.zza((android.app.PendingIntent) r0, (com.google.android.gms.location.internal.zzh) r1, (java.lang.String) r2)
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
                com.google.android.gms.location.internal.zzh r1 = com.google.android.gms.location.internal.zzh.zza.zzci(r1)
                java.lang.String r2 = r8.readString()
                r6.zza((java.lang.String[]) r0, (com.google.android.gms.location.internal.zzh) r1, (java.lang.String) r2)
                r9.writeNoException()
                goto L_0x000a
            L_0x00ba:
                java.lang.String r0 = "com.google.android.gms.location.internal.IGoogleLocationManagerService"
                r8.enforceInterface(r0)
                android.os.IBinder r0 = r8.readStrongBinder()
                com.google.android.gms.location.internal.zzh r0 = com.google.android.gms.location.internal.zzh.zza.zzci(r0)
                java.lang.String r1 = r8.readString()
                r6.zza((com.google.android.gms.location.internal.zzh) r0, (java.lang.String) r1)
                r9.writeNoException()
                goto L_0x000a
            L_0x00d3:
                java.lang.String r2 = "com.google.android.gms.location.internal.IGoogleLocationManagerService"
                r8.enforceInterface(r2)
                long r4 = r8.readLong()
                int r2 = r8.readInt()
                if (r2 == 0) goto L_0x00f9
                r2 = r3
            L_0x00e3:
                int r0 = r8.readInt()
                if (r0 == 0) goto L_0x00fb
                android.os.Parcelable$Creator r0 = android.app.PendingIntent.CREATOR
                java.lang.Object r0 = r0.createFromParcel(r8)
                android.app.PendingIntent r0 = (android.app.PendingIntent) r0
            L_0x00f1:
                r6.zza((long) r4, (boolean) r2, (android.app.PendingIntent) r0)
                r9.writeNoException()
                goto L_0x000a
            L_0x00f9:
                r2 = r0
                goto L_0x00e3
            L_0x00fb:
                r0 = r1
                goto L_0x00f1
            L_0x00fd:
                java.lang.String r0 = "com.google.android.gms.location.internal.IGoogleLocationManagerService"
                r8.enforceInterface(r0)
                int r0 = r8.readInt()
                if (r0 == 0) goto L_0x0118
                android.os.Parcelable$Creator r0 = android.app.PendingIntent.CREATOR
                java.lang.Object r0 = r0.createFromParcel(r8)
                android.app.PendingIntent r0 = (android.app.PendingIntent) r0
            L_0x0110:
                r6.zza((android.app.PendingIntent) r0)
                r9.writeNoException()
                goto L_0x000a
            L_0x0118:
                r0 = r1
                goto L_0x0110
            L_0x011a:
                java.lang.String r1 = "com.google.android.gms.location.internal.IGoogleLocationManagerService"
                r8.enforceInterface(r1)
                java.lang.String r1 = r8.readString()
                com.google.android.gms.location.ActivityRecognitionResult r1 = r6.zzeh(r1)
                r9.writeNoException()
                if (r1 == 0) goto L_0x0134
                r9.writeInt(r3)
                r1.writeToParcel(r9, r3)
                goto L_0x000a
            L_0x0134:
                r9.writeInt(r0)
                goto L_0x000a
            L_0x0139:
                java.lang.String r0 = "com.google.android.gms.location.internal.IGoogleLocationManagerService"
                r8.enforceInterface(r0)
                int r0 = r8.readInt()
                if (r0 == 0) goto L_0x015c
                android.os.Parcelable$Creator r0 = android.app.PendingIntent.CREATOR
                java.lang.Object r0 = r0.createFromParcel(r8)
                android.app.PendingIntent r0 = (android.app.PendingIntent) r0
            L_0x014c:
                android.os.IBinder r1 = r8.readStrongBinder()
                com.google.android.gms.common.api.internal.zzo r1 = com.google.android.gms.common.api.internal.zzo.zza.zzaN(r1)
                r6.zza((android.app.PendingIntent) r0, (com.google.android.gms.common.api.internal.zzo) r1)
                r9.writeNoException()
                goto L_0x000a
            L_0x015c:
                r0 = r1
                goto L_0x014c
            L_0x015e:
                java.lang.String r0 = "com.google.android.gms.location.internal.IGoogleLocationManagerService"
                r8.enforceInterface(r0)
                int r0 = r8.readInt()
                if (r0 == 0) goto L_0x0181
                android.os.Parcelable$Creator r0 = android.app.PendingIntent.CREATOR
                java.lang.Object r0 = r0.createFromParcel(r8)
                android.app.PendingIntent r0 = (android.app.PendingIntent) r0
            L_0x0171:
                android.os.IBinder r1 = r8.readStrongBinder()
                com.google.android.gms.common.api.internal.zzo r1 = com.google.android.gms.common.api.internal.zzo.zza.zzaN(r1)
                r6.zzb(r0, r1)
                r9.writeNoException()
                goto L_0x000a
            L_0x0181:
                r0 = r1
                goto L_0x0171
            L_0x0183:
                java.lang.String r0 = "com.google.android.gms.location.internal.IGoogleLocationManagerService"
                r8.enforceInterface(r0)
                int r0 = r8.readInt()
                if (r0 == 0) goto L_0x01b3
                com.google.android.gms.location.zzb r0 = com.google.android.gms.location.GestureRequest.CREATOR
                com.google.android.gms.location.GestureRequest r0 = r0.createFromParcel(r8)
                r2 = r0
            L_0x0195:
                int r0 = r8.readInt()
                if (r0 == 0) goto L_0x01b5
                android.os.Parcelable$Creator r0 = android.app.PendingIntent.CREATOR
                java.lang.Object r0 = r0.createFromParcel(r8)
                android.app.PendingIntent r0 = (android.app.PendingIntent) r0
            L_0x01a3:
                android.os.IBinder r1 = r8.readStrongBinder()
                com.google.android.gms.common.api.internal.zzo r1 = com.google.android.gms.common.api.internal.zzo.zza.zzaN(r1)
                r6.zza((com.google.android.gms.location.GestureRequest) r2, (android.app.PendingIntent) r0, (com.google.android.gms.common.api.internal.zzo) r1)
                r9.writeNoException()
                goto L_0x000a
            L_0x01b3:
                r2 = r1
                goto L_0x0195
            L_0x01b5:
                r0 = r1
                goto L_0x01a3
            L_0x01b7:
                java.lang.String r0 = "com.google.android.gms.location.internal.IGoogleLocationManagerService"
                r8.enforceInterface(r0)
                int r0 = r8.readInt()
                if (r0 == 0) goto L_0x01da
                android.os.Parcelable$Creator r0 = android.app.PendingIntent.CREATOR
                java.lang.Object r0 = r0.createFromParcel(r8)
                android.app.PendingIntent r0 = (android.app.PendingIntent) r0
            L_0x01ca:
                android.os.IBinder r1 = r8.readStrongBinder()
                com.google.android.gms.common.api.internal.zzo r1 = com.google.android.gms.common.api.internal.zzo.zza.zzaN(r1)
                r6.zzc(r0, r1)
                r9.writeNoException()
                goto L_0x000a
            L_0x01da:
                r0 = r1
                goto L_0x01ca
            L_0x01dc:
                java.lang.String r0 = "com.google.android.gms.location.internal.IGoogleLocationManagerService"
                r8.enforceInterface(r0)
                int r0 = r8.readInt()
                if (r0 == 0) goto L_0x01ff
                android.os.Parcelable$Creator r0 = android.app.PendingIntent.CREATOR
                java.lang.Object r0 = r0.createFromParcel(r8)
                android.app.PendingIntent r0 = (android.app.PendingIntent) r0
            L_0x01ef:
                android.os.IBinder r1 = r8.readStrongBinder()
                com.google.android.gms.common.api.internal.zzo r1 = com.google.android.gms.common.api.internal.zzo.zza.zzaN(r1)
                r6.zzd(r0, r1)
                r9.writeNoException()
                goto L_0x000a
            L_0x01ff:
                r0 = r1
                goto L_0x01ef
            L_0x0201:
                java.lang.String r0 = "com.google.android.gms.location.internal.IGoogleLocationManagerService"
                r8.enforceInterface(r0)
                int r0 = r8.readInt()
                if (r0 == 0) goto L_0x0224
                android.os.Parcelable$Creator r0 = android.app.PendingIntent.CREATOR
                java.lang.Object r0 = r0.createFromParcel(r8)
                android.app.PendingIntent r0 = (android.app.PendingIntent) r0
            L_0x0214:
                android.os.IBinder r1 = r8.readStrongBinder()
                com.google.android.gms.common.api.internal.zzo r1 = com.google.android.gms.common.api.internal.zzo.zza.zzaN(r1)
                r6.zze(r0, r1)
                r9.writeNoException()
                goto L_0x000a
            L_0x0224:
                r0 = r1
                goto L_0x0214
            L_0x0226:
                java.lang.String r1 = "com.google.android.gms.location.internal.IGoogleLocationManagerService"
                r8.enforceInterface(r1)
                android.location.Location r1 = r6.zzyN()
                r9.writeNoException()
                if (r1 == 0) goto L_0x023c
                r9.writeInt(r3)
                r1.writeToParcel(r9, r3)
                goto L_0x000a
            L_0x023c:
                r9.writeInt(r0)
                goto L_0x000a
            L_0x0241:
                java.lang.String r0 = "com.google.android.gms.location.internal.IGoogleLocationManagerService"
                r8.enforceInterface(r0)
                int r0 = r8.readInt()
                if (r0 == 0) goto L_0x0252
                com.google.android.gms.location.LocationRequestCreator r0 = com.google.android.gms.location.LocationRequest.CREATOR
                com.google.android.gms.location.LocationRequest r1 = r0.createFromParcel((android.os.Parcel) r8)
            L_0x0252:
                android.os.IBinder r0 = r8.readStrongBinder()
                com.google.android.gms.location.zzd r0 = com.google.android.gms.location.zzd.zza.zzcf(r0)
                r6.zza((com.google.android.gms.location.LocationRequest) r1, (com.google.android.gms.location.zzd) r0)
                r9.writeNoException()
                goto L_0x000a
            L_0x0262:
                java.lang.String r0 = "com.google.android.gms.location.internal.IGoogleLocationManagerService"
                r8.enforceInterface(r0)
                int r0 = r8.readInt()
                if (r0 == 0) goto L_0x0273
                com.google.android.gms.location.LocationRequestCreator r0 = com.google.android.gms.location.LocationRequest.CREATOR
                com.google.android.gms.location.LocationRequest r1 = r0.createFromParcel((android.os.Parcel) r8)
            L_0x0273:
                android.os.IBinder r0 = r8.readStrongBinder()
                com.google.android.gms.location.zzd r0 = com.google.android.gms.location.zzd.zza.zzcf(r0)
                java.lang.String r2 = r8.readString()
                r6.zza((com.google.android.gms.location.LocationRequest) r1, (com.google.android.gms.location.zzd) r0, (java.lang.String) r2)
                r9.writeNoException()
                goto L_0x000a
            L_0x0287:
                java.lang.String r0 = "com.google.android.gms.location.internal.IGoogleLocationManagerService"
                r8.enforceInterface(r0)
                int r0 = r8.readInt()
                if (r0 == 0) goto L_0x02af
                com.google.android.gms.location.LocationRequestCreator r0 = com.google.android.gms.location.LocationRequest.CREATOR
                com.google.android.gms.location.LocationRequest r0 = r0.createFromParcel((android.os.Parcel) r8)
                r2 = r0
            L_0x0299:
                int r0 = r8.readInt()
                if (r0 == 0) goto L_0x02b1
                android.os.Parcelable$Creator r0 = android.app.PendingIntent.CREATOR
                java.lang.Object r0 = r0.createFromParcel(r8)
                android.app.PendingIntent r0 = (android.app.PendingIntent) r0
            L_0x02a7:
                r6.zza((com.google.android.gms.location.LocationRequest) r2, (android.app.PendingIntent) r0)
                r9.writeNoException()
                goto L_0x000a
            L_0x02af:
                r2 = r1
                goto L_0x0299
            L_0x02b1:
                r0 = r1
                goto L_0x02a7
            L_0x02b3:
                java.lang.String r0 = "com.google.android.gms.location.internal.IGoogleLocationManagerService"
                r8.enforceInterface(r0)
                int r0 = r8.readInt()
                if (r0 == 0) goto L_0x02c4
                com.google.android.gms.location.internal.zzm r0 = com.google.android.gms.location.internal.LocationRequestInternal.CREATOR
                com.google.android.gms.location.internal.LocationRequestInternal r1 = r0.createFromParcel(r8)
            L_0x02c4:
                android.os.IBinder r0 = r8.readStrongBinder()
                com.google.android.gms.location.zzd r0 = com.google.android.gms.location.zzd.zza.zzcf(r0)
                r6.zza((com.google.android.gms.location.internal.LocationRequestInternal) r1, (com.google.android.gms.location.zzd) r0)
                r9.writeNoException()
                goto L_0x000a
            L_0x02d4:
                java.lang.String r0 = "com.google.android.gms.location.internal.IGoogleLocationManagerService"
                r8.enforceInterface(r0)
                int r0 = r8.readInt()
                if (r0 == 0) goto L_0x02fc
                com.google.android.gms.location.internal.zzm r0 = com.google.android.gms.location.internal.LocationRequestInternal.CREATOR
                com.google.android.gms.location.internal.LocationRequestInternal r0 = r0.createFromParcel(r8)
                r2 = r0
            L_0x02e6:
                int r0 = r8.readInt()
                if (r0 == 0) goto L_0x02fe
                android.os.Parcelable$Creator r0 = android.app.PendingIntent.CREATOR
                java.lang.Object r0 = r0.createFromParcel(r8)
                android.app.PendingIntent r0 = (android.app.PendingIntent) r0
            L_0x02f4:
                r6.zza((com.google.android.gms.location.internal.LocationRequestInternal) r2, (android.app.PendingIntent) r0)
                r9.writeNoException()
                goto L_0x000a
            L_0x02fc:
                r2 = r1
                goto L_0x02e6
            L_0x02fe:
                r0 = r1
                goto L_0x02f4
            L_0x0300:
                java.lang.String r0 = "com.google.android.gms.location.internal.IGoogleLocationManagerService"
                r8.enforceInterface(r0)
                android.os.IBinder r0 = r8.readStrongBinder()
                com.google.android.gms.location.zzd r0 = com.google.android.gms.location.zzd.zza.zzcf(r0)
                r6.zza((com.google.android.gms.location.zzd) r0)
                r9.writeNoException()
                goto L_0x000a
            L_0x0315:
                java.lang.String r0 = "com.google.android.gms.location.internal.IGoogleLocationManagerService"
                r8.enforceInterface(r0)
                int r0 = r8.readInt()
                if (r0 == 0) goto L_0x0330
                android.os.Parcelable$Creator r0 = android.app.PendingIntent.CREATOR
                java.lang.Object r0 = r0.createFromParcel(r8)
                android.app.PendingIntent r0 = (android.app.PendingIntent) r0
            L_0x0328:
                r6.zzb(r0)
                r9.writeNoException()
                goto L_0x000a
            L_0x0330:
                r0 = r1
                goto L_0x0328
            L_0x0332:
                java.lang.String r0 = "com.google.android.gms.location.internal.IGoogleLocationManagerService"
                r8.enforceInterface(r0)
                int r0 = r8.readInt()
                if (r0 == 0) goto L_0x0343
                com.google.android.gms.location.internal.zzn r0 = com.google.android.gms.location.internal.LocationRequestUpdateData.CREATOR
                com.google.android.gms.location.internal.LocationRequestUpdateData r1 = r0.createFromParcel(r8)
            L_0x0343:
                r6.zza((com.google.android.gms.location.internal.LocationRequestUpdateData) r1)
                r9.writeNoException()
                goto L_0x000a
            L_0x034b:
                java.lang.String r1 = "com.google.android.gms.location.internal.IGoogleLocationManagerService"
                r8.enforceInterface(r1)
                int r1 = r8.readInt()
                if (r1 == 0) goto L_0x0357
                r0 = r3
            L_0x0357:
                r6.zzam(r0)
                r9.writeNoException()
                goto L_0x000a
            L_0x035f:
                java.lang.String r0 = "com.google.android.gms.location.internal.IGoogleLocationManagerService"
                r8.enforceInterface(r0)
                int r0 = r8.readInt()
                if (r0 == 0) goto L_0x037a
                android.os.Parcelable$Creator r0 = android.location.Location.CREATOR
                java.lang.Object r0 = r0.createFromParcel(r8)
                android.location.Location r0 = (android.location.Location) r0
            L_0x0372:
                r6.zzc(r0)
                r9.writeNoException()
                goto L_0x000a
            L_0x037a:
                r0 = r1
                goto L_0x0372
            L_0x037c:
                java.lang.String r1 = "com.google.android.gms.location.internal.IGoogleLocationManagerService"
                r8.enforceInterface(r1)
                java.lang.String r1 = r8.readString()
                android.location.Location r1 = r6.zzei(r1)
                r9.writeNoException()
                if (r1 == 0) goto L_0x0396
                r9.writeInt(r3)
                r1.writeToParcel(r9, r3)
                goto L_0x000a
            L_0x0396:
                r9.writeInt(r0)
                goto L_0x000a
            L_0x039b:
                java.lang.String r0 = "com.google.android.gms.location.internal.IGoogleLocationManagerService"
                r8.enforceInterface(r0)
                int r0 = r8.readInt()
                if (r0 == 0) goto L_0x03ba
                android.os.Parcelable$Creator r0 = android.location.Location.CREATOR
                java.lang.Object r0 = r0.createFromParcel(r8)
                android.location.Location r0 = (android.location.Location) r0
            L_0x03ae:
                int r1 = r8.readInt()
                r6.zza((android.location.Location) r0, (int) r1)
                r9.writeNoException()
                goto L_0x000a
            L_0x03ba:
                r0 = r1
                goto L_0x03ae
            L_0x03bc:
                java.lang.String r0 = "com.google.android.gms.location.internal.IGoogleLocationManagerService"
                r8.enforceInterface(r0)
                android.os.IBinder r0 = r8.readStrongBinder()
                com.google.android.gms.location.internal.zzg r0 = com.google.android.gms.location.internal.zzg.zza.zzch(r0)
                r6.zza((com.google.android.gms.location.internal.zzg) r0)
                r9.writeNoException()
                goto L_0x000a
            L_0x03d1:
                java.lang.String r1 = "com.google.android.gms.location.internal.IGoogleLocationManagerService"
                r8.enforceInterface(r1)
                java.lang.String r1 = r8.readString()
                com.google.android.gms.location.LocationAvailability r1 = r6.zzej(r1)
                r9.writeNoException()
                if (r1 == 0) goto L_0x03eb
                r9.writeInt(r3)
                r1.writeToParcel(r9, r3)
                goto L_0x000a
            L_0x03eb:
                r9.writeInt(r0)
                goto L_0x000a
            L_0x03f0:
                java.lang.String r0 = "com.google.android.gms.location.internal.IGoogleLocationManagerService"
                r8.enforceInterface(r0)
                int r0 = r8.readInt()
                if (r0 == 0) goto L_0x0417
                android.os.Parcelable$Creator<com.google.android.gms.location.LocationSettingsRequest> r0 = com.google.android.gms.location.LocationSettingsRequest.CREATOR
                java.lang.Object r0 = r0.createFromParcel(r8)
                com.google.android.gms.location.LocationSettingsRequest r0 = (com.google.android.gms.location.LocationSettingsRequest) r0
            L_0x0403:
                android.os.IBinder r1 = r8.readStrongBinder()
                com.google.android.gms.location.internal.zzj r1 = com.google.android.gms.location.internal.zzj.zza.zzck(r1)
                java.lang.String r2 = r8.readString()
                r6.zza((com.google.android.gms.location.LocationSettingsRequest) r0, (com.google.android.gms.location.internal.zzj) r1, (java.lang.String) r2)
                r9.writeNoException()
                goto L_0x000a
            L_0x0417:
                r0 = r1
                goto L_0x0403
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.location.internal.zzi.zza.onTransact(int, android.os.Parcel, android.os.Parcel, int):boolean");
        }
    }

    void zza(long j, boolean z, PendingIntent pendingIntent) throws RemoteException;

    void zza(PendingIntent pendingIntent) throws RemoteException;

    void zza(PendingIntent pendingIntent, zzo zzo) throws RemoteException;

    void zza(PendingIntent pendingIntent, zzh zzh, String str) throws RemoteException;

    void zza(Location location, int i) throws RemoteException;

    void zza(GeofencingRequest geofencingRequest, PendingIntent pendingIntent, zzh zzh) throws RemoteException;

    void zza(GestureRequest gestureRequest, PendingIntent pendingIntent, zzo zzo) throws RemoteException;

    void zza(LocationRequest locationRequest, PendingIntent pendingIntent) throws RemoteException;

    void zza(LocationRequest locationRequest, zzd zzd) throws RemoteException;

    void zza(LocationRequest locationRequest, zzd zzd, String str) throws RemoteException;

    void zza(LocationSettingsRequest locationSettingsRequest, zzj zzj, String str) throws RemoteException;

    void zza(LocationRequestInternal locationRequestInternal, PendingIntent pendingIntent) throws RemoteException;

    void zza(LocationRequestInternal locationRequestInternal, zzd zzd) throws RemoteException;

    void zza(LocationRequestUpdateData locationRequestUpdateData) throws RemoteException;

    void zza(zzg zzg) throws RemoteException;

    void zza(zzh zzh, String str) throws RemoteException;

    void zza(zzd zzd) throws RemoteException;

    void zza(List<ParcelableGeofence> list, PendingIntent pendingIntent, zzh zzh, String str) throws RemoteException;

    void zza(String[] strArr, zzh zzh, String str) throws RemoteException;

    void zzam(boolean z) throws RemoteException;

    void zzb(PendingIntent pendingIntent) throws RemoteException;

    void zzb(PendingIntent pendingIntent, zzo zzo) throws RemoteException;

    void zzc(PendingIntent pendingIntent, zzo zzo) throws RemoteException;

    void zzc(Location location) throws RemoteException;

    void zzd(PendingIntent pendingIntent, zzo zzo) throws RemoteException;

    void zze(PendingIntent pendingIntent, zzo zzo) throws RemoteException;

    ActivityRecognitionResult zzeh(String str) throws RemoteException;

    Location zzei(String str) throws RemoteException;

    LocationAvailability zzej(String str) throws RemoteException;

    Location zzyN() throws RemoteException;
}
