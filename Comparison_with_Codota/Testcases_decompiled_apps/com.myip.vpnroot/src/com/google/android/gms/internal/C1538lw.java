package com.google.android.gms.internal;

import android.app.PendingIntent;
import android.location.Location;
import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.location.C1753a;
import com.google.android.gms.location.C1757c;
import com.google.android.gms.location.LocationRequest;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.LatLngBounds;
import java.util.List;

/* renamed from: com.google.android.gms.internal.lw */
public interface C1538lw extends IInterface {

    /* renamed from: com.google.android.gms.internal.lw$a */
    public static abstract class C1539a extends Binder implements C1538lw {

        /* renamed from: com.google.android.gms.internal.lw$a$a */
        private static class C1540a implements C1538lw {

            /* renamed from: lb */
            private IBinder f4273lb;

            C1540a(IBinder iBinder) {
                this.f4273lb = iBinder;
            }

            /* renamed from: a */
            public void mo9281a(long j, boolean z, PendingIntent pendingIntent) throws RemoteException {
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
                    this.f4273lb.transact(5, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            /* renamed from: a */
            public void mo9282a(PendingIntent pendingIntent) throws RemoteException {
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
                    this.f4273lb.transact(11, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            /* renamed from: a */
            public void mo9283a(PendingIntent pendingIntent, C1535lv lvVar, String str) throws RemoteException {
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
                    obtain.writeStrongBinder(lvVar != null ? lvVar.asBinder() : null);
                    obtain.writeString(str);
                    this.f4273lb.transact(2, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            /* renamed from: a */
            public void mo9284a(Location location, int i) throws RemoteException {
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
                    this.f4273lb.transact(26, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            /* renamed from: a */
            public void mo9285a(C1535lv lvVar, String str) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.location.internal.IGoogleLocationManagerService");
                    obtain.writeStrongBinder(lvVar != null ? lvVar.asBinder() : null);
                    obtain.writeString(str);
                    this.f4273lb.transact(4, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            /* renamed from: a */
            public void mo9286a(C1550lz lzVar, PendingIntent pendingIntent) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.location.internal.IGoogleLocationManagerService");
                    if (lzVar != null) {
                        obtain.writeInt(1);
                        lzVar.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    if (pendingIntent != null) {
                        obtain.writeInt(1);
                        pendingIntent.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.f4273lb.transact(53, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            /* renamed from: a */
            public void mo9287a(C1550lz lzVar, C1753a aVar) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.location.internal.IGoogleLocationManagerService");
                    if (lzVar != null) {
                        obtain.writeInt(1);
                        lzVar.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    obtain.writeStrongBinder(aVar != null ? aVar.asBinder() : null);
                    this.f4273lb.transact(52, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            /* renamed from: a */
            public void mo9288a(C1558mg mgVar, C1576mw mwVar, PendingIntent pendingIntent) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.location.internal.IGoogleLocationManagerService");
                    if (mgVar != null) {
                        obtain.writeInt(1);
                        mgVar.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    if (mwVar != null) {
                        obtain.writeInt(1);
                        mwVar.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    if (pendingIntent != null) {
                        obtain.writeInt(1);
                        pendingIntent.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.f4273lb.transact(48, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            /* renamed from: a */
            public void mo9289a(C1560mi miVar, C1576mw mwVar, C1572mu muVar) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.location.internal.IGoogleLocationManagerService");
                    if (miVar != null) {
                        obtain.writeInt(1);
                        miVar.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    if (mwVar != null) {
                        obtain.writeInt(1);
                        mwVar.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    obtain.writeStrongBinder(muVar != null ? muVar.asBinder() : null);
                    this.f4273lb.transact(17, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            /* renamed from: a */
            public void mo9290a(C1562mk mkVar, C1576mw mwVar) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.location.internal.IGoogleLocationManagerService");
                    if (mkVar != null) {
                        obtain.writeInt(1);
                        mkVar.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    if (mwVar != null) {
                        obtain.writeInt(1);
                        mwVar.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.f4273lb.transact(25, obtain, (Parcel) null, 1);
                } finally {
                    obtain.recycle();
                }
            }

            /* renamed from: a */
            public void mo9291a(C1564mm mmVar, C1576mw mwVar, PendingIntent pendingIntent) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.location.internal.IGoogleLocationManagerService");
                    if (mmVar != null) {
                        obtain.writeInt(1);
                        mmVar.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    if (mwVar != null) {
                        obtain.writeInt(1);
                        mwVar.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    if (pendingIntent != null) {
                        obtain.writeInt(1);
                        pendingIntent.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.f4273lb.transact(18, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            /* renamed from: a */
            public void mo9292a(C1568mq mqVar, C1576mw mwVar, C1572mu muVar) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.location.internal.IGoogleLocationManagerService");
                    if (mqVar != null) {
                        obtain.writeInt(1);
                        mqVar.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    if (mwVar != null) {
                        obtain.writeInt(1);
                        mwVar.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    obtain.writeStrongBinder(muVar != null ? muVar.asBinder() : null);
                    this.f4273lb.transact(46, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            /* renamed from: a */
            public void mo9293a(C1570ms msVar, LatLngBounds latLngBounds, List<String> list, C1576mw mwVar, C1572mu muVar) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.location.internal.IGoogleLocationManagerService");
                    if (msVar != null) {
                        obtain.writeInt(1);
                        msVar.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    if (latLngBounds != null) {
                        obtain.writeInt(1);
                        latLngBounds.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    obtain.writeStringList(list);
                    if (mwVar != null) {
                        obtain.writeInt(1);
                        mwVar.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    obtain.writeStrongBinder(muVar != null ? muVar.asBinder() : null);
                    this.f4273lb.transact(50, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            /* renamed from: a */
            public void mo9294a(C1576mw mwVar, PendingIntent pendingIntent) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.location.internal.IGoogleLocationManagerService");
                    if (mwVar != null) {
                        obtain.writeInt(1);
                        mwVar.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    if (pendingIntent != null) {
                        obtain.writeInt(1);
                        pendingIntent.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.f4273lb.transact(19, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            /* renamed from: a */
            public void mo9295a(LocationRequest locationRequest, PendingIntent pendingIntent) throws RemoteException {
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
                    this.f4273lb.transact(9, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            /* renamed from: a */
            public void mo9296a(LocationRequest locationRequest, C1753a aVar) throws RemoteException {
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
                    obtain.writeStrongBinder(aVar != null ? aVar.asBinder() : null);
                    this.f4273lb.transact(8, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            /* renamed from: a */
            public void mo9297a(LocationRequest locationRequest, C1753a aVar, String str) throws RemoteException {
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
                    obtain.writeStrongBinder(aVar != null ? aVar.asBinder() : null);
                    obtain.writeString(str);
                    this.f4273lb.transact(20, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            /* renamed from: a */
            public void mo9298a(C1753a aVar) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.location.internal.IGoogleLocationManagerService");
                    obtain.writeStrongBinder(aVar != null ? aVar.asBinder() : null);
                    this.f4273lb.transact(10, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            /* renamed from: a */
            public void mo9299a(LatLng latLng, C1560mi miVar, C1576mw mwVar, C1572mu muVar) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.location.internal.IGoogleLocationManagerService");
                    if (latLng != null) {
                        obtain.writeInt(1);
                        latLng.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    if (miVar != null) {
                        obtain.writeInt(1);
                        miVar.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    if (mwVar != null) {
                        obtain.writeInt(1);
                        mwVar.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    obtain.writeStrongBinder(muVar != null ? muVar.asBinder() : null);
                    this.f4273lb.transact(16, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            /* renamed from: a */
            public void mo9300a(LatLngBounds latLngBounds, int i, C1560mi miVar, C1576mw mwVar, C1572mu muVar) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.location.internal.IGoogleLocationManagerService");
                    if (latLngBounds != null) {
                        obtain.writeInt(1);
                        latLngBounds.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    obtain.writeInt(i);
                    if (miVar != null) {
                        obtain.writeInt(1);
                        miVar.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    if (mwVar != null) {
                        obtain.writeInt(1);
                        mwVar.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    obtain.writeStrongBinder(muVar != null ? muVar.asBinder() : null);
                    this.f4273lb.transact(14, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            /* renamed from: a */
            public void mo9301a(LatLngBounds latLngBounds, int i, String str, C1560mi miVar, C1576mw mwVar, C1572mu muVar) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.location.internal.IGoogleLocationManagerService");
                    if (latLngBounds != null) {
                        obtain.writeInt(1);
                        latLngBounds.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    obtain.writeInt(i);
                    obtain.writeString(str);
                    if (miVar != null) {
                        obtain.writeInt(1);
                        miVar.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    if (mwVar != null) {
                        obtain.writeInt(1);
                        mwVar.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    obtain.writeStrongBinder(muVar != null ? muVar.asBinder() : null);
                    this.f4273lb.transact(47, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            /* renamed from: a */
            public void mo9302a(String str, C1576mw mwVar, C1572mu muVar) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.location.internal.IGoogleLocationManagerService");
                    obtain.writeString(str);
                    if (mwVar != null) {
                        obtain.writeInt(1);
                        mwVar.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    obtain.writeStrongBinder(muVar != null ? muVar.asBinder() : null);
                    this.f4273lb.transact(15, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            /* renamed from: a */
            public void mo9303a(String str, LatLngBounds latLngBounds, C1556me meVar, C1576mw mwVar, C1572mu muVar) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.location.internal.IGoogleLocationManagerService");
                    obtain.writeString(str);
                    if (latLngBounds != null) {
                        obtain.writeInt(1);
                        latLngBounds.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    if (meVar != null) {
                        obtain.writeInt(1);
                        meVar.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    if (mwVar != null) {
                        obtain.writeInt(1);
                        mwVar.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    obtain.writeStrongBinder(muVar != null ? muVar.asBinder() : null);
                    this.f4273lb.transact(55, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            /* renamed from: a */
            public void mo9304a(List<C1553mb> list, PendingIntent pendingIntent, C1535lv lvVar, String str) throws RemoteException {
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
                    obtain.writeStrongBinder(lvVar != null ? lvVar.asBinder() : null);
                    obtain.writeString(str);
                    this.f4273lb.transact(1, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            /* renamed from: a */
            public void mo9305a(String[] strArr, C1535lv lvVar, String str) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.location.internal.IGoogleLocationManagerService");
                    obtain.writeStringArray(strArr);
                    obtain.writeStrongBinder(lvVar != null ? lvVar.asBinder() : null);
                    obtain.writeString(str);
                    this.f4273lb.transact(3, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public IBinder asBinder() {
                return this.f4273lb;
            }

            /* renamed from: b */
            public void mo9306b(C1576mw mwVar, PendingIntent pendingIntent) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.location.internal.IGoogleLocationManagerService");
                    if (mwVar != null) {
                        obtain.writeInt(1);
                        mwVar.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    if (pendingIntent != null) {
                        obtain.writeInt(1);
                        pendingIntent.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.f4273lb.transact(49, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            /* renamed from: b */
            public void mo9307b(String str, C1576mw mwVar, C1572mu muVar) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.location.internal.IGoogleLocationManagerService");
                    obtain.writeString(str);
                    if (mwVar != null) {
                        obtain.writeInt(1);
                        mwVar.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    obtain.writeStrongBinder(muVar != null ? muVar.asBinder() : null);
                    this.f4273lb.transact(42, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            /* renamed from: bT */
            public Location mo9308bT(String str) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.location.internal.IGoogleLocationManagerService");
                    obtain.writeString(str);
                    this.f4273lb.transact(21, obtain, obtain2, 0);
                    obtain2.readException();
                    return obtain2.readInt() != 0 ? (Location) Location.CREATOR.createFromParcel(obtain2) : null;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            /* renamed from: bU */
            public C1757c mo9309bU(String str) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.location.internal.IGoogleLocationManagerService");
                    obtain.writeString(str);
                    this.f4273lb.transact(34, obtain, obtain2, 0);
                    obtain2.readException();
                    return obtain2.readInt() != 0 ? C1757c.CREATOR.mo10248ct(obtain2) : null;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            /* renamed from: lT */
            public Location mo9310lT() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.location.internal.IGoogleLocationManagerService");
                    this.f4273lb.transact(7, obtain, obtain2, 0);
                    obtain2.readException();
                    return obtain2.readInt() != 0 ? (Location) Location.CREATOR.createFromParcel(obtain2) : null;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            /* renamed from: lU */
            public IBinder mo9311lU() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.location.internal.IGoogleLocationManagerService");
                    this.f4273lb.transact(51, obtain, obtain2, 0);
                    obtain2.readException();
                    return obtain2.readStrongBinder();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            /* renamed from: lV */
            public IBinder mo9312lV() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.location.internal.IGoogleLocationManagerService");
                    this.f4273lb.transact(54, obtain, obtain2, 0);
                    obtain2.readException();
                    return obtain2.readStrongBinder();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void removeActivityUpdates(PendingIntent callbackIntent) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.location.internal.IGoogleLocationManagerService");
                    if (callbackIntent != null) {
                        obtain.writeInt(1);
                        callbackIntent.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.f4273lb.transact(6, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void setMockLocation(Location location) throws RemoteException {
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
                    this.f4273lb.transact(13, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void setMockMode(boolean isMockMode) throws RemoteException {
                int i = 0;
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.location.internal.IGoogleLocationManagerService");
                    if (isMockMode) {
                        i = 1;
                    }
                    obtain.writeInt(i);
                    this.f4273lb.transact(12, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }
        }

        /* renamed from: aK */
        public static C1538lw m5523aK(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.location.internal.IGoogleLocationManagerService");
            return (queryLocalInterface == null || !(queryLocalInterface instanceof C1538lw)) ? new C1540a(iBinder) : (C1538lw) queryLocalInterface;
        }

        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v1, resolved type: com.google.android.gms.internal.mw} */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v3, resolved type: com.google.android.gms.internal.mw} */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v7, resolved type: com.google.android.gms.internal.mw} */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v9, resolved type: com.google.android.gms.internal.mw} */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v11, resolved type: com.google.android.gms.internal.mw} */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v13, resolved type: com.google.android.gms.internal.mw} */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v15, resolved type: com.google.android.gms.internal.mw} */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v18, resolved type: com.google.android.gms.internal.lz} */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v20, resolved type: com.google.android.gms.location.LocationRequest} */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v22, resolved type: com.google.android.gms.location.LocationRequest} */
        /* JADX WARNING: type inference failed for: r5v0 */
        /* JADX WARNING: type inference failed for: r5v24 */
        /* JADX WARNING: type inference failed for: r5v25 */
        /* JADX WARNING: type inference failed for: r5v26 */
        /* JADX WARNING: type inference failed for: r5v27 */
        /* JADX WARNING: type inference failed for: r5v28 */
        /* JADX WARNING: type inference failed for: r5v29 */
        /* JADX WARNING: type inference failed for: r5v30 */
        /* JADX WARNING: type inference failed for: r5v31 */
        /* JADX WARNING: type inference failed for: r5v32 */
        /* JADX WARNING: type inference failed for: r5v33 */
        /* JADX WARNING: Multi-variable type inference failed */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public boolean onTransact(int r9, android.os.Parcel r10, android.os.Parcel r11, int r12) throws android.os.RemoteException {
            /*
                r8 = this;
                r0 = 0
                r7 = 1
                r5 = 0
                switch(r9) {
                    case 1: goto L_0x0011;
                    case 2: goto L_0x003f;
                    case 3: goto L_0x0067;
                    case 4: goto L_0x0083;
                    case 5: goto L_0x009c;
                    case 6: goto L_0x00c6;
                    case 7: goto L_0x00e3;
                    case 8: goto L_0x00fe;
                    case 9: goto L_0x0144;
                    case 10: goto L_0x01bd;
                    case 11: goto L_0x01d2;
                    case 12: goto L_0x01ef;
                    case 13: goto L_0x0203;
                    case 14: goto L_0x0220;
                    case 15: goto L_0x02aa;
                    case 16: goto L_0x02cf;
                    case 17: goto L_0x030c;
                    case 18: goto L_0x03a4;
                    case 19: goto L_0x03df;
                    case 20: goto L_0x011f;
                    case 21: goto L_0x04e7;
                    case 25: goto L_0x0506;
                    case 26: goto L_0x052a;
                    case 34: goto L_0x054b;
                    case 42: goto L_0x033b;
                    case 46: goto L_0x04b6;
                    case 47: goto L_0x0264;
                    case 48: goto L_0x040b;
                    case 49: goto L_0x0446;
                    case 50: goto L_0x0360;
                    case 51: goto L_0x056a;
                    case 52: goto L_0x0170;
                    case 53: goto L_0x0191;
                    case 54: goto L_0x057b;
                    case 55: goto L_0x0472;
                    case 1598968902: goto L_0x000b;
                    default: goto L_0x0006;
                }
            L_0x0006:
                boolean r7 = super.onTransact(r9, r10, r11, r12)
            L_0x000a:
                return r7
            L_0x000b:
                java.lang.String r0 = "com.google.android.gms.location.internal.IGoogleLocationManagerService"
                r11.writeString(r0)
                goto L_0x000a
            L_0x0011:
                java.lang.String r0 = "com.google.android.gms.location.internal.IGoogleLocationManagerService"
                r10.enforceInterface(r0)
                com.google.android.gms.internal.mc r0 = com.google.android.gms.internal.C1553mb.CREATOR
                java.util.ArrayList r1 = r10.createTypedArrayList(r0)
                int r0 = r10.readInt()
                if (r0 == 0) goto L_0x003d
                android.os.Parcelable$Creator r0 = android.app.PendingIntent.CREATOR
                java.lang.Object r0 = r0.createFromParcel(r10)
                android.app.PendingIntent r0 = (android.app.PendingIntent) r0
            L_0x002a:
                android.os.IBinder r2 = r10.readStrongBinder()
                com.google.android.gms.internal.lv r2 = com.google.android.gms.internal.C1535lv.C1536a.m5490aJ(r2)
                java.lang.String r3 = r10.readString()
                r8.mo9304a((java.util.List<com.google.android.gms.internal.C1553mb>) r1, (android.app.PendingIntent) r0, (com.google.android.gms.internal.C1535lv) r2, (java.lang.String) r3)
                r11.writeNoException()
                goto L_0x000a
            L_0x003d:
                r0 = r5
                goto L_0x002a
            L_0x003f:
                java.lang.String r0 = "com.google.android.gms.location.internal.IGoogleLocationManagerService"
                r10.enforceInterface(r0)
                int r0 = r10.readInt()
                if (r0 == 0) goto L_0x0065
                android.os.Parcelable$Creator r0 = android.app.PendingIntent.CREATOR
                java.lang.Object r0 = r0.createFromParcel(r10)
                android.app.PendingIntent r0 = (android.app.PendingIntent) r0
            L_0x0052:
                android.os.IBinder r1 = r10.readStrongBinder()
                com.google.android.gms.internal.lv r1 = com.google.android.gms.internal.C1535lv.C1536a.m5490aJ(r1)
                java.lang.String r2 = r10.readString()
                r8.mo9283a((android.app.PendingIntent) r0, (com.google.android.gms.internal.C1535lv) r1, (java.lang.String) r2)
                r11.writeNoException()
                goto L_0x000a
            L_0x0065:
                r0 = r5
                goto L_0x0052
            L_0x0067:
                java.lang.String r0 = "com.google.android.gms.location.internal.IGoogleLocationManagerService"
                r10.enforceInterface(r0)
                java.lang.String[] r0 = r10.createStringArray()
                android.os.IBinder r1 = r10.readStrongBinder()
                com.google.android.gms.internal.lv r1 = com.google.android.gms.internal.C1535lv.C1536a.m5490aJ(r1)
                java.lang.String r2 = r10.readString()
                r8.mo9305a((java.lang.String[]) r0, (com.google.android.gms.internal.C1535lv) r1, (java.lang.String) r2)
                r11.writeNoException()
                goto L_0x000a
            L_0x0083:
                java.lang.String r0 = "com.google.android.gms.location.internal.IGoogleLocationManagerService"
                r10.enforceInterface(r0)
                android.os.IBinder r0 = r10.readStrongBinder()
                com.google.android.gms.internal.lv r0 = com.google.android.gms.internal.C1535lv.C1536a.m5490aJ(r0)
                java.lang.String r1 = r10.readString()
                r8.mo9285a((com.google.android.gms.internal.C1535lv) r0, (java.lang.String) r1)
                r11.writeNoException()
                goto L_0x000a
            L_0x009c:
                java.lang.String r1 = "com.google.android.gms.location.internal.IGoogleLocationManagerService"
                r10.enforceInterface(r1)
                long r2 = r10.readLong()
                int r1 = r10.readInt()
                if (r1 == 0) goto L_0x00c2
                r1 = r7
            L_0x00ac:
                int r0 = r10.readInt()
                if (r0 == 0) goto L_0x00c4
                android.os.Parcelable$Creator r0 = android.app.PendingIntent.CREATOR
                java.lang.Object r0 = r0.createFromParcel(r10)
                android.app.PendingIntent r0 = (android.app.PendingIntent) r0
            L_0x00ba:
                r8.mo9281a((long) r2, (boolean) r1, (android.app.PendingIntent) r0)
                r11.writeNoException()
                goto L_0x000a
            L_0x00c2:
                r1 = r0
                goto L_0x00ac
            L_0x00c4:
                r0 = r5
                goto L_0x00ba
            L_0x00c6:
                java.lang.String r0 = "com.google.android.gms.location.internal.IGoogleLocationManagerService"
                r10.enforceInterface(r0)
                int r0 = r10.readInt()
                if (r0 == 0) goto L_0x00e1
                android.os.Parcelable$Creator r0 = android.app.PendingIntent.CREATOR
                java.lang.Object r0 = r0.createFromParcel(r10)
                android.app.PendingIntent r0 = (android.app.PendingIntent) r0
            L_0x00d9:
                r8.removeActivityUpdates(r0)
                r11.writeNoException()
                goto L_0x000a
            L_0x00e1:
                r0 = r5
                goto L_0x00d9
            L_0x00e3:
                java.lang.String r1 = "com.google.android.gms.location.internal.IGoogleLocationManagerService"
                r10.enforceInterface(r1)
                android.location.Location r1 = r8.mo9310lT()
                r11.writeNoException()
                if (r1 == 0) goto L_0x00f9
                r11.writeInt(r7)
                r1.writeToParcel(r11, r7)
                goto L_0x000a
            L_0x00f9:
                r11.writeInt(r0)
                goto L_0x000a
            L_0x00fe:
                java.lang.String r0 = "com.google.android.gms.location.internal.IGoogleLocationManagerService"
                r10.enforceInterface(r0)
                int r0 = r10.readInt()
                if (r0 == 0) goto L_0x010f
                com.google.android.gms.location.b r0 = com.google.android.gms.location.LocationRequest.CREATOR
                com.google.android.gms.location.LocationRequest r5 = r0.createFromParcel(r10)
            L_0x010f:
                android.os.IBinder r0 = r10.readStrongBinder()
                com.google.android.gms.location.a r0 = com.google.android.gms.location.C1753a.C1754a.m6249aI(r0)
                r8.mo9296a((com.google.android.gms.location.LocationRequest) r5, (com.google.android.gms.location.C1753a) r0)
                r11.writeNoException()
                goto L_0x000a
            L_0x011f:
                java.lang.String r0 = "com.google.android.gms.location.internal.IGoogleLocationManagerService"
                r10.enforceInterface(r0)
                int r0 = r10.readInt()
                if (r0 == 0) goto L_0x0130
                com.google.android.gms.location.b r0 = com.google.android.gms.location.LocationRequest.CREATOR
                com.google.android.gms.location.LocationRequest r5 = r0.createFromParcel(r10)
            L_0x0130:
                android.os.IBinder r0 = r10.readStrongBinder()
                com.google.android.gms.location.a r0 = com.google.android.gms.location.C1753a.C1754a.m6249aI(r0)
                java.lang.String r1 = r10.readString()
                r8.mo9297a((com.google.android.gms.location.LocationRequest) r5, (com.google.android.gms.location.C1753a) r0, (java.lang.String) r1)
                r11.writeNoException()
                goto L_0x000a
            L_0x0144:
                java.lang.String r0 = "com.google.android.gms.location.internal.IGoogleLocationManagerService"
                r10.enforceInterface(r0)
                int r0 = r10.readInt()
                if (r0 == 0) goto L_0x016c
                com.google.android.gms.location.b r0 = com.google.android.gms.location.LocationRequest.CREATOR
                com.google.android.gms.location.LocationRequest r0 = r0.createFromParcel(r10)
                r1 = r0
            L_0x0156:
                int r0 = r10.readInt()
                if (r0 == 0) goto L_0x016e
                android.os.Parcelable$Creator r0 = android.app.PendingIntent.CREATOR
                java.lang.Object r0 = r0.createFromParcel(r10)
                android.app.PendingIntent r0 = (android.app.PendingIntent) r0
            L_0x0164:
                r8.mo9295a((com.google.android.gms.location.LocationRequest) r1, (android.app.PendingIntent) r0)
                r11.writeNoException()
                goto L_0x000a
            L_0x016c:
                r1 = r5
                goto L_0x0156
            L_0x016e:
                r0 = r5
                goto L_0x0164
            L_0x0170:
                java.lang.String r0 = "com.google.android.gms.location.internal.IGoogleLocationManagerService"
                r10.enforceInterface(r0)
                int r0 = r10.readInt()
                if (r0 == 0) goto L_0x0181
                com.google.android.gms.internal.ma r0 = com.google.android.gms.internal.C1550lz.CREATOR
                com.google.android.gms.internal.lz r5 = r0.createFromParcel(r10)
            L_0x0181:
                android.os.IBinder r0 = r10.readStrongBinder()
                com.google.android.gms.location.a r0 = com.google.android.gms.location.C1753a.C1754a.m6249aI(r0)
                r8.mo9287a((com.google.android.gms.internal.C1550lz) r5, (com.google.android.gms.location.C1753a) r0)
                r11.writeNoException()
                goto L_0x000a
            L_0x0191:
                java.lang.String r0 = "com.google.android.gms.location.internal.IGoogleLocationManagerService"
                r10.enforceInterface(r0)
                int r0 = r10.readInt()
                if (r0 == 0) goto L_0x01b9
                com.google.android.gms.internal.ma r0 = com.google.android.gms.internal.C1550lz.CREATOR
                com.google.android.gms.internal.lz r0 = r0.createFromParcel(r10)
                r1 = r0
            L_0x01a3:
                int r0 = r10.readInt()
                if (r0 == 0) goto L_0x01bb
                android.os.Parcelable$Creator r0 = android.app.PendingIntent.CREATOR
                java.lang.Object r0 = r0.createFromParcel(r10)
                android.app.PendingIntent r0 = (android.app.PendingIntent) r0
            L_0x01b1:
                r8.mo9286a((com.google.android.gms.internal.C1550lz) r1, (android.app.PendingIntent) r0)
                r11.writeNoException()
                goto L_0x000a
            L_0x01b9:
                r1 = r5
                goto L_0x01a3
            L_0x01bb:
                r0 = r5
                goto L_0x01b1
            L_0x01bd:
                java.lang.String r0 = "com.google.android.gms.location.internal.IGoogleLocationManagerService"
                r10.enforceInterface(r0)
                android.os.IBinder r0 = r10.readStrongBinder()
                com.google.android.gms.location.a r0 = com.google.android.gms.location.C1753a.C1754a.m6249aI(r0)
                r8.mo9298a((com.google.android.gms.location.C1753a) r0)
                r11.writeNoException()
                goto L_0x000a
            L_0x01d2:
                java.lang.String r0 = "com.google.android.gms.location.internal.IGoogleLocationManagerService"
                r10.enforceInterface(r0)
                int r0 = r10.readInt()
                if (r0 == 0) goto L_0x01ed
                android.os.Parcelable$Creator r0 = android.app.PendingIntent.CREATOR
                java.lang.Object r0 = r0.createFromParcel(r10)
                android.app.PendingIntent r0 = (android.app.PendingIntent) r0
            L_0x01e5:
                r8.mo9282a((android.app.PendingIntent) r0)
                r11.writeNoException()
                goto L_0x000a
            L_0x01ed:
                r0 = r5
                goto L_0x01e5
            L_0x01ef:
                java.lang.String r1 = "com.google.android.gms.location.internal.IGoogleLocationManagerService"
                r10.enforceInterface(r1)
                int r1 = r10.readInt()
                if (r1 == 0) goto L_0x01fb
                r0 = r7
            L_0x01fb:
                r8.setMockMode(r0)
                r11.writeNoException()
                goto L_0x000a
            L_0x0203:
                java.lang.String r0 = "com.google.android.gms.location.internal.IGoogleLocationManagerService"
                r10.enforceInterface(r0)
                int r0 = r10.readInt()
                if (r0 == 0) goto L_0x021e
                android.os.Parcelable$Creator r0 = android.location.Location.CREATOR
                java.lang.Object r0 = r0.createFromParcel(r10)
                android.location.Location r0 = (android.location.Location) r0
            L_0x0216:
                r8.setMockLocation(r0)
                r11.writeNoException()
                goto L_0x000a
            L_0x021e:
                r0 = r5
                goto L_0x0216
            L_0x0220:
                java.lang.String r0 = "com.google.android.gms.location.internal.IGoogleLocationManagerService"
                r10.enforceInterface(r0)
                int r0 = r10.readInt()
                if (r0 == 0) goto L_0x025e
                com.google.android.gms.maps.model.g r0 = com.google.android.gms.maps.model.LatLngBounds.CREATOR
                com.google.android.gms.maps.model.LatLngBounds r1 = r0.createFromParcel(r10)
            L_0x0231:
                int r2 = r10.readInt()
                int r0 = r10.readInt()
                if (r0 == 0) goto L_0x0260
                com.google.android.gms.internal.mj r0 = com.google.android.gms.internal.C1560mi.CREATOR
                com.google.android.gms.internal.mi r3 = r0.createFromParcel(r10)
            L_0x0241:
                int r0 = r10.readInt()
                if (r0 == 0) goto L_0x0262
                com.google.android.gms.internal.mx r0 = com.google.android.gms.internal.C1576mw.CREATOR
                com.google.android.gms.internal.mw r4 = r0.createFromParcel(r10)
            L_0x024d:
                android.os.IBinder r0 = r10.readStrongBinder()
                com.google.android.gms.internal.mu r5 = com.google.android.gms.internal.C1572mu.C1573a.m5640aM(r0)
                r0 = r8
                r0.mo9300a((com.google.android.gms.maps.model.LatLngBounds) r1, (int) r2, (com.google.android.gms.internal.C1560mi) r3, (com.google.android.gms.internal.C1576mw) r4, (com.google.android.gms.internal.C1572mu) r5)
                r11.writeNoException()
                goto L_0x000a
            L_0x025e:
                r1 = r5
                goto L_0x0231
            L_0x0260:
                r3 = r5
                goto L_0x0241
            L_0x0262:
                r4 = r5
                goto L_0x024d
            L_0x0264:
                java.lang.String r0 = "com.google.android.gms.location.internal.IGoogleLocationManagerService"
                r10.enforceInterface(r0)
                int r0 = r10.readInt()
                if (r0 == 0) goto L_0x02a6
                com.google.android.gms.maps.model.g r0 = com.google.android.gms.maps.model.LatLngBounds.CREATOR
                com.google.android.gms.maps.model.LatLngBounds r1 = r0.createFromParcel(r10)
            L_0x0275:
                int r2 = r10.readInt()
                java.lang.String r3 = r10.readString()
                int r0 = r10.readInt()
                if (r0 == 0) goto L_0x02a8
                com.google.android.gms.internal.mj r0 = com.google.android.gms.internal.C1560mi.CREATOR
                com.google.android.gms.internal.mi r4 = r0.createFromParcel(r10)
            L_0x0289:
                int r0 = r10.readInt()
                if (r0 == 0) goto L_0x0295
                com.google.android.gms.internal.mx r0 = com.google.android.gms.internal.C1576mw.CREATOR
                com.google.android.gms.internal.mw r5 = r0.createFromParcel(r10)
            L_0x0295:
                android.os.IBinder r0 = r10.readStrongBinder()
                com.google.android.gms.internal.mu r6 = com.google.android.gms.internal.C1572mu.C1573a.m5640aM(r0)
                r0 = r8
                r0.mo9301a(r1, r2, r3, r4, r5, r6)
                r11.writeNoException()
                goto L_0x000a
            L_0x02a6:
                r1 = r5
                goto L_0x0275
            L_0x02a8:
                r4 = r5
                goto L_0x0289
            L_0x02aa:
                java.lang.String r0 = "com.google.android.gms.location.internal.IGoogleLocationManagerService"
                r10.enforceInterface(r0)
                java.lang.String r0 = r10.readString()
                int r1 = r10.readInt()
                if (r1 == 0) goto L_0x02bf
                com.google.android.gms.internal.mx r1 = com.google.android.gms.internal.C1576mw.CREATOR
                com.google.android.gms.internal.mw r5 = r1.createFromParcel(r10)
            L_0x02bf:
                android.os.IBinder r1 = r10.readStrongBinder()
                com.google.android.gms.internal.mu r1 = com.google.android.gms.internal.C1572mu.C1573a.m5640aM(r1)
                r8.mo9302a((java.lang.String) r0, (com.google.android.gms.internal.C1576mw) r5, (com.google.android.gms.internal.C1572mu) r1)
                r11.writeNoException()
                goto L_0x000a
            L_0x02cf:
                java.lang.String r0 = "com.google.android.gms.location.internal.IGoogleLocationManagerService"
                r10.enforceInterface(r0)
                int r0 = r10.readInt()
                if (r0 == 0) goto L_0x0308
                com.google.android.gms.maps.model.i r0 = com.google.android.gms.maps.model.LatLng.CREATOR
                com.google.android.gms.maps.model.LatLng r0 = r0.createFromParcel(r10)
            L_0x02e0:
                int r1 = r10.readInt()
                if (r1 == 0) goto L_0x030a
                com.google.android.gms.internal.mj r1 = com.google.android.gms.internal.C1560mi.CREATOR
                com.google.android.gms.internal.mi r1 = r1.createFromParcel(r10)
            L_0x02ec:
                int r2 = r10.readInt()
                if (r2 == 0) goto L_0x02f8
                com.google.android.gms.internal.mx r2 = com.google.android.gms.internal.C1576mw.CREATOR
                com.google.android.gms.internal.mw r5 = r2.createFromParcel(r10)
            L_0x02f8:
                android.os.IBinder r2 = r10.readStrongBinder()
                com.google.android.gms.internal.mu r2 = com.google.android.gms.internal.C1572mu.C1573a.m5640aM(r2)
                r8.mo9299a((com.google.android.gms.maps.model.LatLng) r0, (com.google.android.gms.internal.C1560mi) r1, (com.google.android.gms.internal.C1576mw) r5, (com.google.android.gms.internal.C1572mu) r2)
                r11.writeNoException()
                goto L_0x000a
            L_0x0308:
                r0 = r5
                goto L_0x02e0
            L_0x030a:
                r1 = r5
                goto L_0x02ec
            L_0x030c:
                java.lang.String r0 = "com.google.android.gms.location.internal.IGoogleLocationManagerService"
                r10.enforceInterface(r0)
                int r0 = r10.readInt()
                if (r0 == 0) goto L_0x0339
                com.google.android.gms.internal.mj r0 = com.google.android.gms.internal.C1560mi.CREATOR
                com.google.android.gms.internal.mi r0 = r0.createFromParcel(r10)
            L_0x031d:
                int r1 = r10.readInt()
                if (r1 == 0) goto L_0x0329
                com.google.android.gms.internal.mx r1 = com.google.android.gms.internal.C1576mw.CREATOR
                com.google.android.gms.internal.mw r5 = r1.createFromParcel(r10)
            L_0x0329:
                android.os.IBinder r1 = r10.readStrongBinder()
                com.google.android.gms.internal.mu r1 = com.google.android.gms.internal.C1572mu.C1573a.m5640aM(r1)
                r8.mo9289a((com.google.android.gms.internal.C1560mi) r0, (com.google.android.gms.internal.C1576mw) r5, (com.google.android.gms.internal.C1572mu) r1)
                r11.writeNoException()
                goto L_0x000a
            L_0x0339:
                r0 = r5
                goto L_0x031d
            L_0x033b:
                java.lang.String r0 = "com.google.android.gms.location.internal.IGoogleLocationManagerService"
                r10.enforceInterface(r0)
                java.lang.String r0 = r10.readString()
                int r1 = r10.readInt()
                if (r1 == 0) goto L_0x0350
                com.google.android.gms.internal.mx r1 = com.google.android.gms.internal.C1576mw.CREATOR
                com.google.android.gms.internal.mw r5 = r1.createFromParcel(r10)
            L_0x0350:
                android.os.IBinder r1 = r10.readStrongBinder()
                com.google.android.gms.internal.mu r1 = com.google.android.gms.internal.C1572mu.C1573a.m5640aM(r1)
                r8.mo9307b(r0, r5, r1)
                r11.writeNoException()
                goto L_0x000a
            L_0x0360:
                java.lang.String r0 = "com.google.android.gms.location.internal.IGoogleLocationManagerService"
                r10.enforceInterface(r0)
                int r0 = r10.readInt()
                if (r0 == 0) goto L_0x039e
                com.google.android.gms.internal.mt r0 = com.google.android.gms.internal.C1570ms.CREATOR
                com.google.android.gms.internal.ms r1 = r0.createFromParcel(r10)
            L_0x0371:
                int r0 = r10.readInt()
                if (r0 == 0) goto L_0x03a0
                com.google.android.gms.maps.model.g r0 = com.google.android.gms.maps.model.LatLngBounds.CREATOR
                com.google.android.gms.maps.model.LatLngBounds r2 = r0.createFromParcel(r10)
            L_0x037d:
                java.util.ArrayList r3 = r10.createStringArrayList()
                int r0 = r10.readInt()
                if (r0 == 0) goto L_0x03a2
                com.google.android.gms.internal.mx r0 = com.google.android.gms.internal.C1576mw.CREATOR
                com.google.android.gms.internal.mw r4 = r0.createFromParcel(r10)
            L_0x038d:
                android.os.IBinder r0 = r10.readStrongBinder()
                com.google.android.gms.internal.mu r5 = com.google.android.gms.internal.C1572mu.C1573a.m5640aM(r0)
                r0 = r8
                r0.mo9293a((com.google.android.gms.internal.C1570ms) r1, (com.google.android.gms.maps.model.LatLngBounds) r2, (java.util.List<java.lang.String>) r3, (com.google.android.gms.internal.C1576mw) r4, (com.google.android.gms.internal.C1572mu) r5)
                r11.writeNoException()
                goto L_0x000a
            L_0x039e:
                r1 = r5
                goto L_0x0371
            L_0x03a0:
                r2 = r5
                goto L_0x037d
            L_0x03a2:
                r4 = r5
                goto L_0x038d
            L_0x03a4:
                java.lang.String r0 = "com.google.android.gms.location.internal.IGoogleLocationManagerService"
                r10.enforceInterface(r0)
                int r0 = r10.readInt()
                if (r0 == 0) goto L_0x03d9
                com.google.android.gms.internal.mn r0 = com.google.android.gms.internal.C1564mm.CREATOR
                com.google.android.gms.internal.mm r0 = r0.createFromParcel(r10)
                r1 = r0
            L_0x03b6:
                int r0 = r10.readInt()
                if (r0 == 0) goto L_0x03db
                com.google.android.gms.internal.mx r0 = com.google.android.gms.internal.C1576mw.CREATOR
                com.google.android.gms.internal.mw r0 = r0.createFromParcel(r10)
                r2 = r0
            L_0x03c3:
                int r0 = r10.readInt()
                if (r0 == 0) goto L_0x03dd
                android.os.Parcelable$Creator r0 = android.app.PendingIntent.CREATOR
                java.lang.Object r0 = r0.createFromParcel(r10)
                android.app.PendingIntent r0 = (android.app.PendingIntent) r0
            L_0x03d1:
                r8.mo9291a((com.google.android.gms.internal.C1564mm) r1, (com.google.android.gms.internal.C1576mw) r2, (android.app.PendingIntent) r0)
                r11.writeNoException()
                goto L_0x000a
            L_0x03d9:
                r1 = r5
                goto L_0x03b6
            L_0x03db:
                r2 = r5
                goto L_0x03c3
            L_0x03dd:
                r0 = r5
                goto L_0x03d1
            L_0x03df:
                java.lang.String r0 = "com.google.android.gms.location.internal.IGoogleLocationManagerService"
                r10.enforceInterface(r0)
                int r0 = r10.readInt()
                if (r0 == 0) goto L_0x0407
                com.google.android.gms.internal.mx r0 = com.google.android.gms.internal.C1576mw.CREATOR
                com.google.android.gms.internal.mw r0 = r0.createFromParcel(r10)
                r1 = r0
            L_0x03f1:
                int r0 = r10.readInt()
                if (r0 == 0) goto L_0x0409
                android.os.Parcelable$Creator r0 = android.app.PendingIntent.CREATOR
                java.lang.Object r0 = r0.createFromParcel(r10)
                android.app.PendingIntent r0 = (android.app.PendingIntent) r0
            L_0x03ff:
                r8.mo9294a((com.google.android.gms.internal.C1576mw) r1, (android.app.PendingIntent) r0)
                r11.writeNoException()
                goto L_0x000a
            L_0x0407:
                r1 = r5
                goto L_0x03f1
            L_0x0409:
                r0 = r5
                goto L_0x03ff
            L_0x040b:
                java.lang.String r0 = "com.google.android.gms.location.internal.IGoogleLocationManagerService"
                r10.enforceInterface(r0)
                int r0 = r10.readInt()
                if (r0 == 0) goto L_0x0440
                com.google.android.gms.internal.mh r0 = com.google.android.gms.internal.C1558mg.CREATOR
                com.google.android.gms.internal.mg r0 = r0.createFromParcel(r10)
                r1 = r0
            L_0x041d:
                int r0 = r10.readInt()
                if (r0 == 0) goto L_0x0442
                com.google.android.gms.internal.mx r0 = com.google.android.gms.internal.C1576mw.CREATOR
                com.google.android.gms.internal.mw r0 = r0.createFromParcel(r10)
                r2 = r0
            L_0x042a:
                int r0 = r10.readInt()
                if (r0 == 0) goto L_0x0444
                android.os.Parcelable$Creator r0 = android.app.PendingIntent.CREATOR
                java.lang.Object r0 = r0.createFromParcel(r10)
                android.app.PendingIntent r0 = (android.app.PendingIntent) r0
            L_0x0438:
                r8.mo9288a((com.google.android.gms.internal.C1558mg) r1, (com.google.android.gms.internal.C1576mw) r2, (android.app.PendingIntent) r0)
                r11.writeNoException()
                goto L_0x000a
            L_0x0440:
                r1 = r5
                goto L_0x041d
            L_0x0442:
                r2 = r5
                goto L_0x042a
            L_0x0444:
                r0 = r5
                goto L_0x0438
            L_0x0446:
                java.lang.String r0 = "com.google.android.gms.location.internal.IGoogleLocationManagerService"
                r10.enforceInterface(r0)
                int r0 = r10.readInt()
                if (r0 == 0) goto L_0x046e
                com.google.android.gms.internal.mx r0 = com.google.android.gms.internal.C1576mw.CREATOR
                com.google.android.gms.internal.mw r0 = r0.createFromParcel(r10)
                r1 = r0
            L_0x0458:
                int r0 = r10.readInt()
                if (r0 == 0) goto L_0x0470
                android.os.Parcelable$Creator r0 = android.app.PendingIntent.CREATOR
                java.lang.Object r0 = r0.createFromParcel(r10)
                android.app.PendingIntent r0 = (android.app.PendingIntent) r0
            L_0x0466:
                r8.mo9306b(r1, r0)
                r11.writeNoException()
                goto L_0x000a
            L_0x046e:
                r1 = r5
                goto L_0x0458
            L_0x0470:
                r0 = r5
                goto L_0x0466
            L_0x0472:
                java.lang.String r0 = "com.google.android.gms.location.internal.IGoogleLocationManagerService"
                r10.enforceInterface(r0)
                java.lang.String r1 = r10.readString()
                int r0 = r10.readInt()
                if (r0 == 0) goto L_0x04b0
                com.google.android.gms.maps.model.g r0 = com.google.android.gms.maps.model.LatLngBounds.CREATOR
                com.google.android.gms.maps.model.LatLngBounds r2 = r0.createFromParcel(r10)
            L_0x0487:
                int r0 = r10.readInt()
                if (r0 == 0) goto L_0x04b2
                com.google.android.gms.internal.mf r0 = com.google.android.gms.internal.C1556me.CREATOR
                com.google.android.gms.internal.me r3 = r0.createFromParcel(r10)
            L_0x0493:
                int r0 = r10.readInt()
                if (r0 == 0) goto L_0x04b4
                com.google.android.gms.internal.mx r0 = com.google.android.gms.internal.C1576mw.CREATOR
                com.google.android.gms.internal.mw r4 = r0.createFromParcel(r10)
            L_0x049f:
                android.os.IBinder r0 = r10.readStrongBinder()
                com.google.android.gms.internal.mu r5 = com.google.android.gms.internal.C1572mu.C1573a.m5640aM(r0)
                r0 = r8
                r0.mo9303a((java.lang.String) r1, (com.google.android.gms.maps.model.LatLngBounds) r2, (com.google.android.gms.internal.C1556me) r3, (com.google.android.gms.internal.C1576mw) r4, (com.google.android.gms.internal.C1572mu) r5)
                r11.writeNoException()
                goto L_0x000a
            L_0x04b0:
                r2 = r5
                goto L_0x0487
            L_0x04b2:
                r3 = r5
                goto L_0x0493
            L_0x04b4:
                r4 = r5
                goto L_0x049f
            L_0x04b6:
                java.lang.String r0 = "com.google.android.gms.location.internal.IGoogleLocationManagerService"
                r10.enforceInterface(r0)
                int r0 = r10.readInt()
                if (r0 == 0) goto L_0x04e5
                android.os.Parcelable$Creator<com.google.android.gms.internal.mq> r0 = com.google.android.gms.internal.C1568mq.CREATOR
                java.lang.Object r0 = r0.createFromParcel(r10)
                com.google.android.gms.internal.mq r0 = (com.google.android.gms.internal.C1568mq) r0
            L_0x04c9:
                int r1 = r10.readInt()
                if (r1 == 0) goto L_0x04d5
                com.google.android.gms.internal.mx r1 = com.google.android.gms.internal.C1576mw.CREATOR
                com.google.android.gms.internal.mw r5 = r1.createFromParcel(r10)
            L_0x04d5:
                android.os.IBinder r1 = r10.readStrongBinder()
                com.google.android.gms.internal.mu r1 = com.google.android.gms.internal.C1572mu.C1573a.m5640aM(r1)
                r8.mo9292a((com.google.android.gms.internal.C1568mq) r0, (com.google.android.gms.internal.C1576mw) r5, (com.google.android.gms.internal.C1572mu) r1)
                r11.writeNoException()
                goto L_0x000a
            L_0x04e5:
                r0 = r5
                goto L_0x04c9
            L_0x04e7:
                java.lang.String r1 = "com.google.android.gms.location.internal.IGoogleLocationManagerService"
                r10.enforceInterface(r1)
                java.lang.String r1 = r10.readString()
                android.location.Location r1 = r8.mo9308bT(r1)
                r11.writeNoException()
                if (r1 == 0) goto L_0x0501
                r11.writeInt(r7)
                r1.writeToParcel(r11, r7)
                goto L_0x000a
            L_0x0501:
                r11.writeInt(r0)
                goto L_0x000a
            L_0x0506:
                java.lang.String r0 = "com.google.android.gms.location.internal.IGoogleLocationManagerService"
                r10.enforceInterface(r0)
                int r0 = r10.readInt()
                if (r0 == 0) goto L_0x0528
                com.google.android.gms.internal.ml r0 = com.google.android.gms.internal.C1562mk.CREATOR
                com.google.android.gms.internal.mk r0 = r0.createFromParcel(r10)
            L_0x0517:
                int r1 = r10.readInt()
                if (r1 == 0) goto L_0x0523
                com.google.android.gms.internal.mx r1 = com.google.android.gms.internal.C1576mw.CREATOR
                com.google.android.gms.internal.mw r5 = r1.createFromParcel(r10)
            L_0x0523:
                r8.mo9290a((com.google.android.gms.internal.C1562mk) r0, (com.google.android.gms.internal.C1576mw) r5)
                goto L_0x000a
            L_0x0528:
                r0 = r5
                goto L_0x0517
            L_0x052a:
                java.lang.String r0 = "com.google.android.gms.location.internal.IGoogleLocationManagerService"
                r10.enforceInterface(r0)
                int r0 = r10.readInt()
                if (r0 == 0) goto L_0x0549
                android.os.Parcelable$Creator r0 = android.location.Location.CREATOR
                java.lang.Object r0 = r0.createFromParcel(r10)
                android.location.Location r0 = (android.location.Location) r0
            L_0x053d:
                int r1 = r10.readInt()
                r8.mo9284a((android.location.Location) r0, (int) r1)
                r11.writeNoException()
                goto L_0x000a
            L_0x0549:
                r0 = r5
                goto L_0x053d
            L_0x054b:
                java.lang.String r1 = "com.google.android.gms.location.internal.IGoogleLocationManagerService"
                r10.enforceInterface(r1)
                java.lang.String r1 = r10.readString()
                com.google.android.gms.location.c r1 = r8.mo9309bU(r1)
                r11.writeNoException()
                if (r1 == 0) goto L_0x0565
                r11.writeInt(r7)
                r1.writeToParcel(r11, r7)
                goto L_0x000a
            L_0x0565:
                r11.writeInt(r0)
                goto L_0x000a
            L_0x056a:
                java.lang.String r0 = "com.google.android.gms.location.internal.IGoogleLocationManagerService"
                r10.enforceInterface(r0)
                android.os.IBinder r0 = r8.mo9311lU()
                r11.writeNoException()
                r11.writeStrongBinder(r0)
                goto L_0x000a
            L_0x057b:
                java.lang.String r0 = "com.google.android.gms.location.internal.IGoogleLocationManagerService"
                r10.enforceInterface(r0)
                android.os.IBinder r0 = r8.mo9312lV()
                r11.writeNoException()
                r11.writeStrongBinder(r0)
                goto L_0x000a
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.C1538lw.C1539a.onTransact(int, android.os.Parcel, android.os.Parcel, int):boolean");
        }
    }

    /* renamed from: a */
    void mo9281a(long j, boolean z, PendingIntent pendingIntent) throws RemoteException;

    /* renamed from: a */
    void mo9282a(PendingIntent pendingIntent) throws RemoteException;

    /* renamed from: a */
    void mo9283a(PendingIntent pendingIntent, C1535lv lvVar, String str) throws RemoteException;

    /* renamed from: a */
    void mo9284a(Location location, int i) throws RemoteException;

    /* renamed from: a */
    void mo9285a(C1535lv lvVar, String str) throws RemoteException;

    /* renamed from: a */
    void mo9286a(C1550lz lzVar, PendingIntent pendingIntent) throws RemoteException;

    /* renamed from: a */
    void mo9287a(C1550lz lzVar, C1753a aVar) throws RemoteException;

    /* renamed from: a */
    void mo9288a(C1558mg mgVar, C1576mw mwVar, PendingIntent pendingIntent) throws RemoteException;

    /* renamed from: a */
    void mo9289a(C1560mi miVar, C1576mw mwVar, C1572mu muVar) throws RemoteException;

    /* renamed from: a */
    void mo9290a(C1562mk mkVar, C1576mw mwVar) throws RemoteException;

    /* renamed from: a */
    void mo9291a(C1564mm mmVar, C1576mw mwVar, PendingIntent pendingIntent) throws RemoteException;

    /* renamed from: a */
    void mo9292a(C1568mq mqVar, C1576mw mwVar, C1572mu muVar) throws RemoteException;

    /* renamed from: a */
    void mo9293a(C1570ms msVar, LatLngBounds latLngBounds, List<String> list, C1576mw mwVar, C1572mu muVar) throws RemoteException;

    /* renamed from: a */
    void mo9294a(C1576mw mwVar, PendingIntent pendingIntent) throws RemoteException;

    /* renamed from: a */
    void mo9295a(LocationRequest locationRequest, PendingIntent pendingIntent) throws RemoteException;

    /* renamed from: a */
    void mo9296a(LocationRequest locationRequest, C1753a aVar) throws RemoteException;

    /* renamed from: a */
    void mo9297a(LocationRequest locationRequest, C1753a aVar, String str) throws RemoteException;

    /* renamed from: a */
    void mo9298a(C1753a aVar) throws RemoteException;

    /* renamed from: a */
    void mo9299a(LatLng latLng, C1560mi miVar, C1576mw mwVar, C1572mu muVar) throws RemoteException;

    /* renamed from: a */
    void mo9300a(LatLngBounds latLngBounds, int i, C1560mi miVar, C1576mw mwVar, C1572mu muVar) throws RemoteException;

    /* renamed from: a */
    void mo9301a(LatLngBounds latLngBounds, int i, String str, C1560mi miVar, C1576mw mwVar, C1572mu muVar) throws RemoteException;

    /* renamed from: a */
    void mo9302a(String str, C1576mw mwVar, C1572mu muVar) throws RemoteException;

    /* renamed from: a */
    void mo9303a(String str, LatLngBounds latLngBounds, C1556me meVar, C1576mw mwVar, C1572mu muVar) throws RemoteException;

    /* renamed from: a */
    void mo9304a(List<C1553mb> list, PendingIntent pendingIntent, C1535lv lvVar, String str) throws RemoteException;

    /* renamed from: a */
    void mo9305a(String[] strArr, C1535lv lvVar, String str) throws RemoteException;

    /* renamed from: b */
    void mo9306b(C1576mw mwVar, PendingIntent pendingIntent) throws RemoteException;

    /* renamed from: b */
    void mo9307b(String str, C1576mw mwVar, C1572mu muVar) throws RemoteException;

    /* renamed from: bT */
    Location mo9308bT(String str) throws RemoteException;

    /* renamed from: bU */
    C1757c mo9309bU(String str) throws RemoteException;

    /* renamed from: lT */
    Location mo9310lT() throws RemoteException;

    /* renamed from: lU */
    IBinder mo9311lU() throws RemoteException;

    /* renamed from: lV */
    IBinder mo9312lV() throws RemoteException;

    void removeActivityUpdates(PendingIntent pendingIntent) throws RemoteException;

    void setMockLocation(Location location) throws RemoteException;

    void setMockMode(boolean z) throws RemoteException;
}
