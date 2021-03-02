package com.google.android.gms.internal;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.fitness.request.C0647ac;
import com.google.android.gms.fitness.request.C0649ae;
import com.google.android.gms.fitness.request.C0654ah;
import com.google.android.gms.fitness.request.C0658b;
import com.google.android.gms.fitness.request.C0665i;
import com.google.android.gms.fitness.request.C0670l;
import com.google.android.gms.fitness.request.C0674n;
import com.google.android.gms.fitness.request.C0676p;
import com.google.android.gms.fitness.request.C0680t;
import com.google.android.gms.fitness.request.C0682v;
import com.google.android.gms.fitness.request.C0686x;
import com.google.android.gms.fitness.request.C0690z;
import com.google.android.gms.fitness.request.DataDeleteRequest;
import com.google.android.gms.fitness.request.DataInsertRequest;
import com.google.android.gms.fitness.request.DataReadRequest;
import com.google.android.gms.fitness.request.DataSourcesRequest;
import com.google.android.gms.fitness.request.DataTypeCreateRequest;
import com.google.android.gms.fitness.request.SessionInsertRequest;
import com.google.android.gms.fitness.request.SessionReadRequest;
import com.google.android.gms.fitness.request.StartBleScanRequest;
import com.google.android.gms.fitness.request.UnclaimBleDeviceRequest;

/* renamed from: com.google.android.gms.internal.ko */
public interface C1430ko extends IInterface {

    /* renamed from: com.google.android.gms.internal.ko$a */
    public static abstract class C1431a extends Binder implements C1430ko {

        /* renamed from: com.google.android.gms.internal.ko$a$a */
        private static class C1432a implements C1430ko {

            /* renamed from: lb */
            private IBinder f4191lb;

            C1432a(IBinder iBinder) {
                this.f4191lb = iBinder;
            }

            /* renamed from: a */
            public void mo9113a(DataDeleteRequest dataDeleteRequest, C1442ks ksVar, String str) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.fitness.internal.IGoogleFitnessService");
                    if (dataDeleteRequest != null) {
                        obtain.writeInt(1);
                        dataDeleteRequest.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    obtain.writeStrongBinder(ksVar != null ? ksVar.asBinder() : null);
                    obtain.writeString(str);
                    this.f4191lb.transact(19, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            /* renamed from: a */
            public void mo9114a(DataInsertRequest dataInsertRequest, C1442ks ksVar, String str) throws RemoteException {
                IBinder iBinder = null;
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.fitness.internal.IGoogleFitnessService");
                    if (dataInsertRequest != null) {
                        obtain.writeInt(1);
                        dataInsertRequest.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    if (ksVar != null) {
                        iBinder = ksVar.asBinder();
                    }
                    obtain.writeStrongBinder(iBinder);
                    obtain.writeString(str);
                    this.f4191lb.transact(7, obtain, (Parcel) null, 1);
                } finally {
                    obtain.recycle();
                }
            }

            /* renamed from: a */
            public void mo9115a(DataReadRequest dataReadRequest, C1421kl klVar, String str) throws RemoteException {
                IBinder iBinder = null;
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.fitness.internal.IGoogleFitnessService");
                    if (dataReadRequest != null) {
                        obtain.writeInt(1);
                        dataReadRequest.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    if (klVar != null) {
                        iBinder = klVar.asBinder();
                    }
                    obtain.writeStrongBinder(iBinder);
                    obtain.writeString(str);
                    this.f4191lb.transact(8, obtain, (Parcel) null, 1);
                } finally {
                    obtain.recycle();
                }
            }

            /* renamed from: a */
            public void mo9116a(DataSourcesRequest dataSourcesRequest, C1424km kmVar, String str) throws RemoteException {
                IBinder iBinder = null;
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.fitness.internal.IGoogleFitnessService");
                    if (dataSourcesRequest != null) {
                        obtain.writeInt(1);
                        dataSourcesRequest.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    if (kmVar != null) {
                        iBinder = kmVar.asBinder();
                    }
                    obtain.writeStrongBinder(iBinder);
                    obtain.writeString(str);
                    this.f4191lb.transact(1, obtain, (Parcel) null, 1);
                } finally {
                    obtain.recycle();
                }
            }

            /* renamed from: a */
            public void mo9117a(DataTypeCreateRequest dataTypeCreateRequest, C1427kn knVar, String str) throws RemoteException {
                IBinder iBinder = null;
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.fitness.internal.IGoogleFitnessService");
                    if (dataTypeCreateRequest != null) {
                        obtain.writeInt(1);
                        dataTypeCreateRequest.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    if (knVar != null) {
                        iBinder = knVar.asBinder();
                    }
                    obtain.writeStrongBinder(iBinder);
                    obtain.writeString(str);
                    this.f4191lb.transact(13, obtain, (Parcel) null, 1);
                } finally {
                    obtain.recycle();
                }
            }

            /* renamed from: a */
            public void mo9118a(SessionInsertRequest sessionInsertRequest, C1442ks ksVar, String str) throws RemoteException {
                IBinder iBinder = null;
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.fitness.internal.IGoogleFitnessService");
                    if (sessionInsertRequest != null) {
                        obtain.writeInt(1);
                        sessionInsertRequest.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    if (ksVar != null) {
                        iBinder = ksVar.asBinder();
                    }
                    obtain.writeStrongBinder(iBinder);
                    obtain.writeString(str);
                    this.f4191lb.transact(9, obtain, (Parcel) null, 1);
                } finally {
                    obtain.recycle();
                }
            }

            /* renamed from: a */
            public void mo9119a(SessionReadRequest sessionReadRequest, C1436kq kqVar, String str) throws RemoteException {
                IBinder iBinder = null;
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.fitness.internal.IGoogleFitnessService");
                    if (sessionReadRequest != null) {
                        obtain.writeInt(1);
                        sessionReadRequest.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    if (kqVar != null) {
                        iBinder = kqVar.asBinder();
                    }
                    obtain.writeStrongBinder(iBinder);
                    obtain.writeString(str);
                    this.f4191lb.transact(10, obtain, (Parcel) null, 1);
                } finally {
                    obtain.recycle();
                }
            }

            /* renamed from: a */
            public void mo9120a(StartBleScanRequest startBleScanRequest, C1442ks ksVar, String str) throws RemoteException {
                IBinder iBinder = null;
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.fitness.internal.IGoogleFitnessService");
                    if (startBleScanRequest != null) {
                        obtain.writeInt(1);
                        startBleScanRequest.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    if (ksVar != null) {
                        iBinder = ksVar.asBinder();
                    }
                    obtain.writeStrongBinder(iBinder);
                    obtain.writeString(str);
                    this.f4191lb.transact(15, obtain, (Parcel) null, 1);
                } finally {
                    obtain.recycle();
                }
            }

            /* renamed from: a */
            public void mo9121a(UnclaimBleDeviceRequest unclaimBleDeviceRequest, C1442ks ksVar, String str) throws RemoteException {
                IBinder iBinder = null;
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.fitness.internal.IGoogleFitnessService");
                    if (unclaimBleDeviceRequest != null) {
                        obtain.writeInt(1);
                        unclaimBleDeviceRequest.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    if (ksVar != null) {
                        iBinder = ksVar.asBinder();
                    }
                    obtain.writeStrongBinder(iBinder);
                    obtain.writeString(str);
                    this.f4191lb.transact(18, obtain, (Parcel) null, 1);
                } finally {
                    obtain.recycle();
                }
            }

            /* renamed from: a */
            public void mo9122a(C0647ac acVar, C1442ks ksVar, String str) throws RemoteException {
                IBinder iBinder = null;
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.fitness.internal.IGoogleFitnessService");
                    if (acVar != null) {
                        obtain.writeInt(1);
                        acVar.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    if (ksVar != null) {
                        iBinder = ksVar.asBinder();
                    }
                    obtain.writeStrongBinder(iBinder);
                    obtain.writeString(str);
                    this.f4191lb.transact(16, obtain, (Parcel) null, 1);
                } finally {
                    obtain.recycle();
                }
            }

            /* renamed from: a */
            public void mo9123a(C0649ae aeVar, C1442ks ksVar, String str) throws RemoteException {
                IBinder iBinder = null;
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.fitness.internal.IGoogleFitnessService");
                    if (aeVar != null) {
                        obtain.writeInt(1);
                        aeVar.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    if (ksVar != null) {
                        iBinder = ksVar.asBinder();
                    }
                    obtain.writeStrongBinder(iBinder);
                    obtain.writeString(str);
                    this.f4191lb.transact(4, obtain, (Parcel) null, 1);
                } finally {
                    obtain.recycle();
                }
            }

            /* renamed from: a */
            public void mo9124a(C0654ah ahVar, C1442ks ksVar, String str) throws RemoteException {
                IBinder iBinder = null;
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.fitness.internal.IGoogleFitnessService");
                    if (ahVar != null) {
                        obtain.writeInt(1);
                        ahVar.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    if (ksVar != null) {
                        iBinder = ksVar.asBinder();
                    }
                    obtain.writeStrongBinder(iBinder);
                    obtain.writeString(str);
                    this.f4191lb.transact(5, obtain, (Parcel) null, 1);
                } finally {
                    obtain.recycle();
                }
            }

            /* renamed from: a */
            public void mo9125a(C0658b bVar, C1442ks ksVar, String str) throws RemoteException {
                IBinder iBinder = null;
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.fitness.internal.IGoogleFitnessService");
                    if (bVar != null) {
                        obtain.writeInt(1);
                        bVar.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    if (ksVar != null) {
                        iBinder = ksVar.asBinder();
                    }
                    obtain.writeStrongBinder(iBinder);
                    obtain.writeString(str);
                    this.f4191lb.transact(17, obtain, (Parcel) null, 1);
                } finally {
                    obtain.recycle();
                }
            }

            /* renamed from: a */
            public void mo9126a(C0665i iVar, C1427kn knVar, String str) throws RemoteException {
                IBinder iBinder = null;
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.fitness.internal.IGoogleFitnessService");
                    if (iVar != null) {
                        obtain.writeInt(1);
                        iVar.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    if (knVar != null) {
                        iBinder = knVar.asBinder();
                    }
                    obtain.writeStrongBinder(iBinder);
                    obtain.writeString(str);
                    this.f4191lb.transact(14, obtain, (Parcel) null, 1);
                } finally {
                    obtain.recycle();
                }
            }

            /* renamed from: a */
            public void mo9127a(C0670l lVar, C1433kp kpVar, String str) throws RemoteException {
                IBinder iBinder = null;
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.fitness.internal.IGoogleFitnessService");
                    if (lVar != null) {
                        obtain.writeInt(1);
                        lVar.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    if (kpVar != null) {
                        iBinder = kpVar.asBinder();
                    }
                    obtain.writeStrongBinder(iBinder);
                    obtain.writeString(str);
                    this.f4191lb.transact(6, obtain, (Parcel) null, 1);
                } finally {
                    obtain.recycle();
                }
            }

            /* renamed from: a */
            public void mo9128a(C0674n nVar, C1442ks ksVar, String str) throws RemoteException {
                IBinder iBinder = null;
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.fitness.internal.IGoogleFitnessService");
                    if (nVar != null) {
                        obtain.writeInt(1);
                        nVar.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    if (ksVar != null) {
                        iBinder = ksVar.asBinder();
                    }
                    obtain.writeStrongBinder(iBinder);
                    obtain.writeString(str);
                    this.f4191lb.transact(2, obtain, (Parcel) null, 1);
                } finally {
                    obtain.recycle();
                }
            }

            /* renamed from: a */
            public void mo9129a(C0676p pVar, C1442ks ksVar, String str) throws RemoteException {
                IBinder iBinder = null;
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.fitness.internal.IGoogleFitnessService");
                    if (pVar != null) {
                        obtain.writeInt(1);
                        pVar.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    if (ksVar != null) {
                        iBinder = ksVar.asBinder();
                    }
                    obtain.writeStrongBinder(iBinder);
                    obtain.writeString(str);
                    this.f4191lb.transact(3, obtain, (Parcel) null, 1);
                } finally {
                    obtain.recycle();
                }
            }

            /* renamed from: a */
            public void mo9130a(C0680t tVar, C1442ks ksVar, String str) throws RemoteException {
                IBinder iBinder = null;
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.fitness.internal.IGoogleFitnessService");
                    if (tVar != null) {
                        obtain.writeInt(1);
                        tVar.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    if (ksVar != null) {
                        iBinder = ksVar.asBinder();
                    }
                    obtain.writeStrongBinder(iBinder);
                    obtain.writeString(str);
                    this.f4191lb.transact(20, obtain, (Parcel) null, 1);
                } finally {
                    obtain.recycle();
                }
            }

            /* renamed from: a */
            public void mo9131a(C0682v vVar, C1442ks ksVar, String str) throws RemoteException {
                IBinder iBinder = null;
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.fitness.internal.IGoogleFitnessService");
                    if (vVar != null) {
                        obtain.writeInt(1);
                        vVar.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    if (ksVar != null) {
                        iBinder = ksVar.asBinder();
                    }
                    obtain.writeStrongBinder(iBinder);
                    obtain.writeString(str);
                    this.f4191lb.transact(11, obtain, (Parcel) null, 1);
                } finally {
                    obtain.recycle();
                }
            }

            /* renamed from: a */
            public void mo9132a(C0686x xVar, C1439kr krVar, String str) throws RemoteException {
                IBinder iBinder = null;
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.fitness.internal.IGoogleFitnessService");
                    if (xVar != null) {
                        obtain.writeInt(1);
                        xVar.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    if (krVar != null) {
                        iBinder = krVar.asBinder();
                    }
                    obtain.writeStrongBinder(iBinder);
                    obtain.writeString(str);
                    this.f4191lb.transact(12, obtain, (Parcel) null, 1);
                } finally {
                    obtain.recycle();
                }
            }

            /* renamed from: a */
            public void mo9133a(C0690z zVar, C1442ks ksVar, String str) throws RemoteException {
                IBinder iBinder = null;
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.fitness.internal.IGoogleFitnessService");
                    if (zVar != null) {
                        obtain.writeInt(1);
                        zVar.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    if (ksVar != null) {
                        iBinder = ksVar.asBinder();
                    }
                    obtain.writeStrongBinder(iBinder);
                    obtain.writeString(str);
                    this.f4191lb.transact(21, obtain, (Parcel) null, 1);
                } finally {
                    obtain.recycle();
                }
            }

            /* renamed from: a */
            public void mo9134a(C1442ks ksVar, String str) throws RemoteException {
                IBinder iBinder = null;
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.fitness.internal.IGoogleFitnessService");
                    if (ksVar != null) {
                        iBinder = ksVar.asBinder();
                    }
                    obtain.writeStrongBinder(iBinder);
                    obtain.writeString(str);
                    this.f4191lb.transact(22, obtain, (Parcel) null, 1);
                } finally {
                    obtain.recycle();
                }
            }

            /* renamed from: a */
            public void mo9135a(C1490le leVar, String str) throws RemoteException {
                IBinder iBinder = null;
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.fitness.internal.IGoogleFitnessService");
                    if (leVar != null) {
                        iBinder = leVar.asBinder();
                    }
                    obtain.writeStrongBinder(iBinder);
                    obtain.writeString(str);
                    this.f4191lb.transact(24, obtain, (Parcel) null, 1);
                } finally {
                    obtain.recycle();
                }
            }

            public IBinder asBinder() {
                return this.f4191lb;
            }

            /* renamed from: b */
            public void mo9136b(C1442ks ksVar, String str) throws RemoteException {
                IBinder iBinder = null;
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.fitness.internal.IGoogleFitnessService");
                    if (ksVar != null) {
                        iBinder = ksVar.asBinder();
                    }
                    obtain.writeStrongBinder(iBinder);
                    obtain.writeString(str);
                    this.f4191lb.transact(23, obtain, (Parcel) null, 1);
                } finally {
                    obtain.recycle();
                }
            }
        }

        /* renamed from: as */
        public static C1430ko m5296as(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.fitness.internal.IGoogleFitnessService");
            return (queryLocalInterface == null || !(queryLocalInterface instanceof C1430ko)) ? new C1432a(iBinder) : (C1430ko) queryLocalInterface;
        }

        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v13, resolved type: com.google.android.gms.fitness.request.z} */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v18, resolved type: com.google.android.gms.fitness.request.t} */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v23, resolved type: com.google.android.gms.fitness.request.UnclaimBleDeviceRequest} */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v28, resolved type: com.google.android.gms.fitness.request.b} */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v33, resolved type: com.google.android.gms.fitness.request.ac} */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v38, resolved type: com.google.android.gms.fitness.request.StartBleScanRequest} */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v43, resolved type: com.google.android.gms.fitness.request.x} */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v48, resolved type: com.google.android.gms.fitness.request.v} */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v53, resolved type: com.google.android.gms.fitness.request.SessionReadRequest} */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v58, resolved type: com.google.android.gms.fitness.request.SessionInsertRequest} */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v63, resolved type: com.google.android.gms.fitness.request.DataReadRequest} */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v68, resolved type: com.google.android.gms.fitness.request.i} */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v73, resolved type: com.google.android.gms.fitness.request.DataTypeCreateRequest} */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v78, resolved type: com.google.android.gms.fitness.request.DataDeleteRequest} */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v83, resolved type: com.google.android.gms.fitness.request.DataInsertRequest} */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v88, resolved type: com.google.android.gms.fitness.request.l} */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v93, resolved type: com.google.android.gms.fitness.request.ah} */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v98, resolved type: com.google.android.gms.fitness.request.ae} */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v103, resolved type: com.google.android.gms.fitness.request.p} */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v108, resolved type: com.google.android.gms.fitness.request.n} */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v113, resolved type: com.google.android.gms.fitness.request.DataSourcesRequest} */
        /* JADX WARNING: type inference failed for: r0v0 */
        /* JADX WARNING: type inference failed for: r0v121 */
        /* JADX WARNING: type inference failed for: r0v122 */
        /* JADX WARNING: type inference failed for: r0v123 */
        /* JADX WARNING: type inference failed for: r0v124 */
        /* JADX WARNING: type inference failed for: r0v125 */
        /* JADX WARNING: type inference failed for: r0v126 */
        /* JADX WARNING: type inference failed for: r0v127 */
        /* JADX WARNING: type inference failed for: r0v128 */
        /* JADX WARNING: type inference failed for: r0v129 */
        /* JADX WARNING: type inference failed for: r0v130 */
        /* JADX WARNING: type inference failed for: r0v131 */
        /* JADX WARNING: type inference failed for: r0v132 */
        /* JADX WARNING: type inference failed for: r0v133 */
        /* JADX WARNING: type inference failed for: r0v134 */
        /* JADX WARNING: type inference failed for: r0v135 */
        /* JADX WARNING: type inference failed for: r0v136 */
        /* JADX WARNING: type inference failed for: r0v137 */
        /* JADX WARNING: type inference failed for: r0v138 */
        /* JADX WARNING: type inference failed for: r0v139 */
        /* JADX WARNING: type inference failed for: r0v140 */
        /* JADX WARNING: type inference failed for: r0v141 */
        /* JADX WARNING: Multi-variable type inference failed */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public boolean onTransact(int r5, android.os.Parcel r6, android.os.Parcel r7, int r8) throws android.os.RemoteException {
            /*
                r4 = this;
                r0 = 0
                r1 = 1
                switch(r5) {
                    case 1: goto L_0x0011;
                    case 2: goto L_0x0035;
                    case 3: goto L_0x0059;
                    case 4: goto L_0x007d;
                    case 5: goto L_0x00a2;
                    case 6: goto L_0x00c7;
                    case 7: goto L_0x00ec;
                    case 8: goto L_0x0183;
                    case 9: goto L_0x01a8;
                    case 10: goto L_0x01cd;
                    case 11: goto L_0x01f2;
                    case 12: goto L_0x0217;
                    case 13: goto L_0x0139;
                    case 14: goto L_0x015e;
                    case 15: goto L_0x023c;
                    case 16: goto L_0x0261;
                    case 17: goto L_0x0286;
                    case 18: goto L_0x02ab;
                    case 19: goto L_0x0111;
                    case 20: goto L_0x02d0;
                    case 21: goto L_0x02f5;
                    case 22: goto L_0x031a;
                    case 23: goto L_0x0331;
                    case 24: goto L_0x0348;
                    case 1598968902: goto L_0x000a;
                    default: goto L_0x0005;
                }
            L_0x0005:
                boolean r0 = super.onTransact(r5, r6, r7, r8)
            L_0x0009:
                return r0
            L_0x000a:
                java.lang.String r0 = "com.google.android.gms.fitness.internal.IGoogleFitnessService"
                r7.writeString(r0)
                r0 = r1
                goto L_0x0009
            L_0x0011:
                java.lang.String r2 = "com.google.android.gms.fitness.internal.IGoogleFitnessService"
                r6.enforceInterface(r2)
                int r2 = r6.readInt()
                if (r2 == 0) goto L_0x0024
                android.os.Parcelable$Creator<com.google.android.gms.fitness.request.DataSourcesRequest> r0 = com.google.android.gms.fitness.request.DataSourcesRequest.CREATOR
                java.lang.Object r0 = r0.createFromParcel(r6)
                com.google.android.gms.fitness.request.DataSourcesRequest r0 = (com.google.android.gms.fitness.request.DataSourcesRequest) r0
            L_0x0024:
                android.os.IBinder r2 = r6.readStrongBinder()
                com.google.android.gms.internal.km r2 = com.google.android.gms.internal.C1424km.C1425a.m5267aq(r2)
                java.lang.String r3 = r6.readString()
                r4.mo9116a((com.google.android.gms.fitness.request.DataSourcesRequest) r0, (com.google.android.gms.internal.C1424km) r2, (java.lang.String) r3)
                r0 = r1
                goto L_0x0009
            L_0x0035:
                java.lang.String r2 = "com.google.android.gms.fitness.internal.IGoogleFitnessService"
                r6.enforceInterface(r2)
                int r2 = r6.readInt()
                if (r2 == 0) goto L_0x0048
                android.os.Parcelable$Creator<com.google.android.gms.fitness.request.n> r0 = com.google.android.gms.fitness.request.C0674n.CREATOR
                java.lang.Object r0 = r0.createFromParcel(r6)
                com.google.android.gms.fitness.request.n r0 = (com.google.android.gms.fitness.request.C0674n) r0
            L_0x0048:
                android.os.IBinder r2 = r6.readStrongBinder()
                com.google.android.gms.internal.ks r2 = com.google.android.gms.internal.C1442ks.C1443a.m5331aw(r2)
                java.lang.String r3 = r6.readString()
                r4.mo9128a((com.google.android.gms.fitness.request.C0674n) r0, (com.google.android.gms.internal.C1442ks) r2, (java.lang.String) r3)
                r0 = r1
                goto L_0x0009
            L_0x0059:
                java.lang.String r2 = "com.google.android.gms.fitness.internal.IGoogleFitnessService"
                r6.enforceInterface(r2)
                int r2 = r6.readInt()
                if (r2 == 0) goto L_0x006c
                android.os.Parcelable$Creator<com.google.android.gms.fitness.request.p> r0 = com.google.android.gms.fitness.request.C0676p.CREATOR
                java.lang.Object r0 = r0.createFromParcel(r6)
                com.google.android.gms.fitness.request.p r0 = (com.google.android.gms.fitness.request.C0676p) r0
            L_0x006c:
                android.os.IBinder r2 = r6.readStrongBinder()
                com.google.android.gms.internal.ks r2 = com.google.android.gms.internal.C1442ks.C1443a.m5331aw(r2)
                java.lang.String r3 = r6.readString()
                r4.mo9129a((com.google.android.gms.fitness.request.C0676p) r0, (com.google.android.gms.internal.C1442ks) r2, (java.lang.String) r3)
                r0 = r1
                goto L_0x0009
            L_0x007d:
                java.lang.String r2 = "com.google.android.gms.fitness.internal.IGoogleFitnessService"
                r6.enforceInterface(r2)
                int r2 = r6.readInt()
                if (r2 == 0) goto L_0x0090
                android.os.Parcelable$Creator<com.google.android.gms.fitness.request.ae> r0 = com.google.android.gms.fitness.request.C0649ae.CREATOR
                java.lang.Object r0 = r0.createFromParcel(r6)
                com.google.android.gms.fitness.request.ae r0 = (com.google.android.gms.fitness.request.C0649ae) r0
            L_0x0090:
                android.os.IBinder r2 = r6.readStrongBinder()
                com.google.android.gms.internal.ks r2 = com.google.android.gms.internal.C1442ks.C1443a.m5331aw(r2)
                java.lang.String r3 = r6.readString()
                r4.mo9123a((com.google.android.gms.fitness.request.C0649ae) r0, (com.google.android.gms.internal.C1442ks) r2, (java.lang.String) r3)
                r0 = r1
                goto L_0x0009
            L_0x00a2:
                java.lang.String r2 = "com.google.android.gms.fitness.internal.IGoogleFitnessService"
                r6.enforceInterface(r2)
                int r2 = r6.readInt()
                if (r2 == 0) goto L_0x00b5
                android.os.Parcelable$Creator<com.google.android.gms.fitness.request.ah> r0 = com.google.android.gms.fitness.request.C0654ah.CREATOR
                java.lang.Object r0 = r0.createFromParcel(r6)
                com.google.android.gms.fitness.request.ah r0 = (com.google.android.gms.fitness.request.C0654ah) r0
            L_0x00b5:
                android.os.IBinder r2 = r6.readStrongBinder()
                com.google.android.gms.internal.ks r2 = com.google.android.gms.internal.C1442ks.C1443a.m5331aw(r2)
                java.lang.String r3 = r6.readString()
                r4.mo9124a((com.google.android.gms.fitness.request.C0654ah) r0, (com.google.android.gms.internal.C1442ks) r2, (java.lang.String) r3)
                r0 = r1
                goto L_0x0009
            L_0x00c7:
                java.lang.String r2 = "com.google.android.gms.fitness.internal.IGoogleFitnessService"
                r6.enforceInterface(r2)
                int r2 = r6.readInt()
                if (r2 == 0) goto L_0x00da
                android.os.Parcelable$Creator<com.google.android.gms.fitness.request.l> r0 = com.google.android.gms.fitness.request.C0670l.CREATOR
                java.lang.Object r0 = r0.createFromParcel(r6)
                com.google.android.gms.fitness.request.l r0 = (com.google.android.gms.fitness.request.C0670l) r0
            L_0x00da:
                android.os.IBinder r2 = r6.readStrongBinder()
                com.google.android.gms.internal.kp r2 = com.google.android.gms.internal.C1433kp.C1434a.m5322at(r2)
                java.lang.String r3 = r6.readString()
                r4.mo9127a((com.google.android.gms.fitness.request.C0670l) r0, (com.google.android.gms.internal.C1433kp) r2, (java.lang.String) r3)
                r0 = r1
                goto L_0x0009
            L_0x00ec:
                java.lang.String r2 = "com.google.android.gms.fitness.internal.IGoogleFitnessService"
                r6.enforceInterface(r2)
                int r2 = r6.readInt()
                if (r2 == 0) goto L_0x00ff
                android.os.Parcelable$Creator<com.google.android.gms.fitness.request.DataInsertRequest> r0 = com.google.android.gms.fitness.request.DataInsertRequest.CREATOR
                java.lang.Object r0 = r0.createFromParcel(r6)
                com.google.android.gms.fitness.request.DataInsertRequest r0 = (com.google.android.gms.fitness.request.DataInsertRequest) r0
            L_0x00ff:
                android.os.IBinder r2 = r6.readStrongBinder()
                com.google.android.gms.internal.ks r2 = com.google.android.gms.internal.C1442ks.C1443a.m5331aw(r2)
                java.lang.String r3 = r6.readString()
                r4.mo9114a((com.google.android.gms.fitness.request.DataInsertRequest) r0, (com.google.android.gms.internal.C1442ks) r2, (java.lang.String) r3)
                r0 = r1
                goto L_0x0009
            L_0x0111:
                java.lang.String r2 = "com.google.android.gms.fitness.internal.IGoogleFitnessService"
                r6.enforceInterface(r2)
                int r2 = r6.readInt()
                if (r2 == 0) goto L_0x0124
                android.os.Parcelable$Creator<com.google.android.gms.fitness.request.DataDeleteRequest> r0 = com.google.android.gms.fitness.request.DataDeleteRequest.CREATOR
                java.lang.Object r0 = r0.createFromParcel(r6)
                com.google.android.gms.fitness.request.DataDeleteRequest r0 = (com.google.android.gms.fitness.request.DataDeleteRequest) r0
            L_0x0124:
                android.os.IBinder r2 = r6.readStrongBinder()
                com.google.android.gms.internal.ks r2 = com.google.android.gms.internal.C1442ks.C1443a.m5331aw(r2)
                java.lang.String r3 = r6.readString()
                r4.mo9113a((com.google.android.gms.fitness.request.DataDeleteRequest) r0, (com.google.android.gms.internal.C1442ks) r2, (java.lang.String) r3)
                r7.writeNoException()
                r0 = r1
                goto L_0x0009
            L_0x0139:
                java.lang.String r2 = "com.google.android.gms.fitness.internal.IGoogleFitnessService"
                r6.enforceInterface(r2)
                int r2 = r6.readInt()
                if (r2 == 0) goto L_0x014c
                android.os.Parcelable$Creator<com.google.android.gms.fitness.request.DataTypeCreateRequest> r0 = com.google.android.gms.fitness.request.DataTypeCreateRequest.CREATOR
                java.lang.Object r0 = r0.createFromParcel(r6)
                com.google.android.gms.fitness.request.DataTypeCreateRequest r0 = (com.google.android.gms.fitness.request.DataTypeCreateRequest) r0
            L_0x014c:
                android.os.IBinder r2 = r6.readStrongBinder()
                com.google.android.gms.internal.kn r2 = com.google.android.gms.internal.C1427kn.C1428a.m5270ar(r2)
                java.lang.String r3 = r6.readString()
                r4.mo9117a((com.google.android.gms.fitness.request.DataTypeCreateRequest) r0, (com.google.android.gms.internal.C1427kn) r2, (java.lang.String) r3)
                r0 = r1
                goto L_0x0009
            L_0x015e:
                java.lang.String r2 = "com.google.android.gms.fitness.internal.IGoogleFitnessService"
                r6.enforceInterface(r2)
                int r2 = r6.readInt()
                if (r2 == 0) goto L_0x0171
                android.os.Parcelable$Creator<com.google.android.gms.fitness.request.i> r0 = com.google.android.gms.fitness.request.C0665i.CREATOR
                java.lang.Object r0 = r0.createFromParcel(r6)
                com.google.android.gms.fitness.request.i r0 = (com.google.android.gms.fitness.request.C0665i) r0
            L_0x0171:
                android.os.IBinder r2 = r6.readStrongBinder()
                com.google.android.gms.internal.kn r2 = com.google.android.gms.internal.C1427kn.C1428a.m5270ar(r2)
                java.lang.String r3 = r6.readString()
                r4.mo9126a((com.google.android.gms.fitness.request.C0665i) r0, (com.google.android.gms.internal.C1427kn) r2, (java.lang.String) r3)
                r0 = r1
                goto L_0x0009
            L_0x0183:
                java.lang.String r2 = "com.google.android.gms.fitness.internal.IGoogleFitnessService"
                r6.enforceInterface(r2)
                int r2 = r6.readInt()
                if (r2 == 0) goto L_0x0196
                android.os.Parcelable$Creator<com.google.android.gms.fitness.request.DataReadRequest> r0 = com.google.android.gms.fitness.request.DataReadRequest.CREATOR
                java.lang.Object r0 = r0.createFromParcel(r6)
                com.google.android.gms.fitness.request.DataReadRequest r0 = (com.google.android.gms.fitness.request.DataReadRequest) r0
            L_0x0196:
                android.os.IBinder r2 = r6.readStrongBinder()
                com.google.android.gms.internal.kl r2 = com.google.android.gms.internal.C1421kl.C1422a.m5264ap(r2)
                java.lang.String r3 = r6.readString()
                r4.mo9115a((com.google.android.gms.fitness.request.DataReadRequest) r0, (com.google.android.gms.internal.C1421kl) r2, (java.lang.String) r3)
                r0 = r1
                goto L_0x0009
            L_0x01a8:
                java.lang.String r2 = "com.google.android.gms.fitness.internal.IGoogleFitnessService"
                r6.enforceInterface(r2)
                int r2 = r6.readInt()
                if (r2 == 0) goto L_0x01bb
                android.os.Parcelable$Creator<com.google.android.gms.fitness.request.SessionInsertRequest> r0 = com.google.android.gms.fitness.request.SessionInsertRequest.CREATOR
                java.lang.Object r0 = r0.createFromParcel(r6)
                com.google.android.gms.fitness.request.SessionInsertRequest r0 = (com.google.android.gms.fitness.request.SessionInsertRequest) r0
            L_0x01bb:
                android.os.IBinder r2 = r6.readStrongBinder()
                com.google.android.gms.internal.ks r2 = com.google.android.gms.internal.C1442ks.C1443a.m5331aw(r2)
                java.lang.String r3 = r6.readString()
                r4.mo9118a((com.google.android.gms.fitness.request.SessionInsertRequest) r0, (com.google.android.gms.internal.C1442ks) r2, (java.lang.String) r3)
                r0 = r1
                goto L_0x0009
            L_0x01cd:
                java.lang.String r2 = "com.google.android.gms.fitness.internal.IGoogleFitnessService"
                r6.enforceInterface(r2)
                int r2 = r6.readInt()
                if (r2 == 0) goto L_0x01e0
                android.os.Parcelable$Creator<com.google.android.gms.fitness.request.SessionReadRequest> r0 = com.google.android.gms.fitness.request.SessionReadRequest.CREATOR
                java.lang.Object r0 = r0.createFromParcel(r6)
                com.google.android.gms.fitness.request.SessionReadRequest r0 = (com.google.android.gms.fitness.request.SessionReadRequest) r0
            L_0x01e0:
                android.os.IBinder r2 = r6.readStrongBinder()
                com.google.android.gms.internal.kq r2 = com.google.android.gms.internal.C1436kq.C1437a.m5325au(r2)
                java.lang.String r3 = r6.readString()
                r4.mo9119a((com.google.android.gms.fitness.request.SessionReadRequest) r0, (com.google.android.gms.internal.C1436kq) r2, (java.lang.String) r3)
                r0 = r1
                goto L_0x0009
            L_0x01f2:
                java.lang.String r2 = "com.google.android.gms.fitness.internal.IGoogleFitnessService"
                r6.enforceInterface(r2)
                int r2 = r6.readInt()
                if (r2 == 0) goto L_0x0205
                android.os.Parcelable$Creator<com.google.android.gms.fitness.request.v> r0 = com.google.android.gms.fitness.request.C0682v.CREATOR
                java.lang.Object r0 = r0.createFromParcel(r6)
                com.google.android.gms.fitness.request.v r0 = (com.google.android.gms.fitness.request.C0682v) r0
            L_0x0205:
                android.os.IBinder r2 = r6.readStrongBinder()
                com.google.android.gms.internal.ks r2 = com.google.android.gms.internal.C1442ks.C1443a.m5331aw(r2)
                java.lang.String r3 = r6.readString()
                r4.mo9131a((com.google.android.gms.fitness.request.C0682v) r0, (com.google.android.gms.internal.C1442ks) r2, (java.lang.String) r3)
                r0 = r1
                goto L_0x0009
            L_0x0217:
                java.lang.String r2 = "com.google.android.gms.fitness.internal.IGoogleFitnessService"
                r6.enforceInterface(r2)
                int r2 = r6.readInt()
                if (r2 == 0) goto L_0x022a
                android.os.Parcelable$Creator<com.google.android.gms.fitness.request.x> r0 = com.google.android.gms.fitness.request.C0686x.CREATOR
                java.lang.Object r0 = r0.createFromParcel(r6)
                com.google.android.gms.fitness.request.x r0 = (com.google.android.gms.fitness.request.C0686x) r0
            L_0x022a:
                android.os.IBinder r2 = r6.readStrongBinder()
                com.google.android.gms.internal.kr r2 = com.google.android.gms.internal.C1439kr.C1440a.m5328av(r2)
                java.lang.String r3 = r6.readString()
                r4.mo9132a((com.google.android.gms.fitness.request.C0686x) r0, (com.google.android.gms.internal.C1439kr) r2, (java.lang.String) r3)
                r0 = r1
                goto L_0x0009
            L_0x023c:
                java.lang.String r2 = "com.google.android.gms.fitness.internal.IGoogleFitnessService"
                r6.enforceInterface(r2)
                int r2 = r6.readInt()
                if (r2 == 0) goto L_0x024f
                android.os.Parcelable$Creator<com.google.android.gms.fitness.request.StartBleScanRequest> r0 = com.google.android.gms.fitness.request.StartBleScanRequest.CREATOR
                java.lang.Object r0 = r0.createFromParcel(r6)
                com.google.android.gms.fitness.request.StartBleScanRequest r0 = (com.google.android.gms.fitness.request.StartBleScanRequest) r0
            L_0x024f:
                android.os.IBinder r2 = r6.readStrongBinder()
                com.google.android.gms.internal.ks r2 = com.google.android.gms.internal.C1442ks.C1443a.m5331aw(r2)
                java.lang.String r3 = r6.readString()
                r4.mo9120a((com.google.android.gms.fitness.request.StartBleScanRequest) r0, (com.google.android.gms.internal.C1442ks) r2, (java.lang.String) r3)
                r0 = r1
                goto L_0x0009
            L_0x0261:
                java.lang.String r2 = "com.google.android.gms.fitness.internal.IGoogleFitnessService"
                r6.enforceInterface(r2)
                int r2 = r6.readInt()
                if (r2 == 0) goto L_0x0274
                android.os.Parcelable$Creator<com.google.android.gms.fitness.request.ac> r0 = com.google.android.gms.fitness.request.C0647ac.CREATOR
                java.lang.Object r0 = r0.createFromParcel(r6)
                com.google.android.gms.fitness.request.ac r0 = (com.google.android.gms.fitness.request.C0647ac) r0
            L_0x0274:
                android.os.IBinder r2 = r6.readStrongBinder()
                com.google.android.gms.internal.ks r2 = com.google.android.gms.internal.C1442ks.C1443a.m5331aw(r2)
                java.lang.String r3 = r6.readString()
                r4.mo9122a((com.google.android.gms.fitness.request.C0647ac) r0, (com.google.android.gms.internal.C1442ks) r2, (java.lang.String) r3)
                r0 = r1
                goto L_0x0009
            L_0x0286:
                java.lang.String r2 = "com.google.android.gms.fitness.internal.IGoogleFitnessService"
                r6.enforceInterface(r2)
                int r2 = r6.readInt()
                if (r2 == 0) goto L_0x0299
                android.os.Parcelable$Creator<com.google.android.gms.fitness.request.b> r0 = com.google.android.gms.fitness.request.C0658b.CREATOR
                java.lang.Object r0 = r0.createFromParcel(r6)
                com.google.android.gms.fitness.request.b r0 = (com.google.android.gms.fitness.request.C0658b) r0
            L_0x0299:
                android.os.IBinder r2 = r6.readStrongBinder()
                com.google.android.gms.internal.ks r2 = com.google.android.gms.internal.C1442ks.C1443a.m5331aw(r2)
                java.lang.String r3 = r6.readString()
                r4.mo9125a((com.google.android.gms.fitness.request.C0658b) r0, (com.google.android.gms.internal.C1442ks) r2, (java.lang.String) r3)
                r0 = r1
                goto L_0x0009
            L_0x02ab:
                java.lang.String r2 = "com.google.android.gms.fitness.internal.IGoogleFitnessService"
                r6.enforceInterface(r2)
                int r2 = r6.readInt()
                if (r2 == 0) goto L_0x02be
                android.os.Parcelable$Creator<com.google.android.gms.fitness.request.UnclaimBleDeviceRequest> r0 = com.google.android.gms.fitness.request.UnclaimBleDeviceRequest.CREATOR
                java.lang.Object r0 = r0.createFromParcel(r6)
                com.google.android.gms.fitness.request.UnclaimBleDeviceRequest r0 = (com.google.android.gms.fitness.request.UnclaimBleDeviceRequest) r0
            L_0x02be:
                android.os.IBinder r2 = r6.readStrongBinder()
                com.google.android.gms.internal.ks r2 = com.google.android.gms.internal.C1442ks.C1443a.m5331aw(r2)
                java.lang.String r3 = r6.readString()
                r4.mo9121a((com.google.android.gms.fitness.request.UnclaimBleDeviceRequest) r0, (com.google.android.gms.internal.C1442ks) r2, (java.lang.String) r3)
                r0 = r1
                goto L_0x0009
            L_0x02d0:
                java.lang.String r2 = "com.google.android.gms.fitness.internal.IGoogleFitnessService"
                r6.enforceInterface(r2)
                int r2 = r6.readInt()
                if (r2 == 0) goto L_0x02e3
                android.os.Parcelable$Creator<com.google.android.gms.fitness.request.t> r0 = com.google.android.gms.fitness.request.C0680t.CREATOR
                java.lang.Object r0 = r0.createFromParcel(r6)
                com.google.android.gms.fitness.request.t r0 = (com.google.android.gms.fitness.request.C0680t) r0
            L_0x02e3:
                android.os.IBinder r2 = r6.readStrongBinder()
                com.google.android.gms.internal.ks r2 = com.google.android.gms.internal.C1442ks.C1443a.m5331aw(r2)
                java.lang.String r3 = r6.readString()
                r4.mo9130a((com.google.android.gms.fitness.request.C0680t) r0, (com.google.android.gms.internal.C1442ks) r2, (java.lang.String) r3)
                r0 = r1
                goto L_0x0009
            L_0x02f5:
                java.lang.String r2 = "com.google.android.gms.fitness.internal.IGoogleFitnessService"
                r6.enforceInterface(r2)
                int r2 = r6.readInt()
                if (r2 == 0) goto L_0x0308
                android.os.Parcelable$Creator<com.google.android.gms.fitness.request.z> r0 = com.google.android.gms.fitness.request.C0690z.CREATOR
                java.lang.Object r0 = r0.createFromParcel(r6)
                com.google.android.gms.fitness.request.z r0 = (com.google.android.gms.fitness.request.C0690z) r0
            L_0x0308:
                android.os.IBinder r2 = r6.readStrongBinder()
                com.google.android.gms.internal.ks r2 = com.google.android.gms.internal.C1442ks.C1443a.m5331aw(r2)
                java.lang.String r3 = r6.readString()
                r4.mo9133a((com.google.android.gms.fitness.request.C0690z) r0, (com.google.android.gms.internal.C1442ks) r2, (java.lang.String) r3)
                r0 = r1
                goto L_0x0009
            L_0x031a:
                java.lang.String r0 = "com.google.android.gms.fitness.internal.IGoogleFitnessService"
                r6.enforceInterface(r0)
                android.os.IBinder r0 = r6.readStrongBinder()
                com.google.android.gms.internal.ks r0 = com.google.android.gms.internal.C1442ks.C1443a.m5331aw(r0)
                java.lang.String r2 = r6.readString()
                r4.mo9134a((com.google.android.gms.internal.C1442ks) r0, (java.lang.String) r2)
                r0 = r1
                goto L_0x0009
            L_0x0331:
                java.lang.String r0 = "com.google.android.gms.fitness.internal.IGoogleFitnessService"
                r6.enforceInterface(r0)
                android.os.IBinder r0 = r6.readStrongBinder()
                com.google.android.gms.internal.ks r0 = com.google.android.gms.internal.C1442ks.C1443a.m5331aw(r0)
                java.lang.String r2 = r6.readString()
                r4.mo9136b(r0, r2)
                r0 = r1
                goto L_0x0009
            L_0x0348:
                java.lang.String r0 = "com.google.android.gms.fitness.internal.IGoogleFitnessService"
                r6.enforceInterface(r0)
                android.os.IBinder r0 = r6.readStrongBinder()
                com.google.android.gms.internal.le r0 = com.google.android.gms.internal.C1490le.C1491a.m5420ax(r0)
                java.lang.String r2 = r6.readString()
                r4.mo9135a((com.google.android.gms.internal.C1490le) r0, (java.lang.String) r2)
                r0 = r1
                goto L_0x0009
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.C1430ko.C1431a.onTransact(int, android.os.Parcel, android.os.Parcel, int):boolean");
        }
    }

    /* renamed from: a */
    void mo9113a(DataDeleteRequest dataDeleteRequest, C1442ks ksVar, String str) throws RemoteException;

    /* renamed from: a */
    void mo9114a(DataInsertRequest dataInsertRequest, C1442ks ksVar, String str) throws RemoteException;

    /* renamed from: a */
    void mo9115a(DataReadRequest dataReadRequest, C1421kl klVar, String str) throws RemoteException;

    /* renamed from: a */
    void mo9116a(DataSourcesRequest dataSourcesRequest, C1424km kmVar, String str) throws RemoteException;

    /* renamed from: a */
    void mo9117a(DataTypeCreateRequest dataTypeCreateRequest, C1427kn knVar, String str) throws RemoteException;

    /* renamed from: a */
    void mo9118a(SessionInsertRequest sessionInsertRequest, C1442ks ksVar, String str) throws RemoteException;

    /* renamed from: a */
    void mo9119a(SessionReadRequest sessionReadRequest, C1436kq kqVar, String str) throws RemoteException;

    /* renamed from: a */
    void mo9120a(StartBleScanRequest startBleScanRequest, C1442ks ksVar, String str) throws RemoteException;

    /* renamed from: a */
    void mo9121a(UnclaimBleDeviceRequest unclaimBleDeviceRequest, C1442ks ksVar, String str) throws RemoteException;

    /* renamed from: a */
    void mo9122a(C0647ac acVar, C1442ks ksVar, String str) throws RemoteException;

    /* renamed from: a */
    void mo9123a(C0649ae aeVar, C1442ks ksVar, String str) throws RemoteException;

    /* renamed from: a */
    void mo9124a(C0654ah ahVar, C1442ks ksVar, String str) throws RemoteException;

    /* renamed from: a */
    void mo9125a(C0658b bVar, C1442ks ksVar, String str) throws RemoteException;

    /* renamed from: a */
    void mo9126a(C0665i iVar, C1427kn knVar, String str) throws RemoteException;

    /* renamed from: a */
    void mo9127a(C0670l lVar, C1433kp kpVar, String str) throws RemoteException;

    /* renamed from: a */
    void mo9128a(C0674n nVar, C1442ks ksVar, String str) throws RemoteException;

    /* renamed from: a */
    void mo9129a(C0676p pVar, C1442ks ksVar, String str) throws RemoteException;

    /* renamed from: a */
    void mo9130a(C0680t tVar, C1442ks ksVar, String str) throws RemoteException;

    /* renamed from: a */
    void mo9131a(C0682v vVar, C1442ks ksVar, String str) throws RemoteException;

    /* renamed from: a */
    void mo9132a(C0686x xVar, C1439kr krVar, String str) throws RemoteException;

    /* renamed from: a */
    void mo9133a(C0690z zVar, C1442ks ksVar, String str) throws RemoteException;

    /* renamed from: a */
    void mo9134a(C1442ks ksVar, String str) throws RemoteException;

    /* renamed from: a */
    void mo9135a(C1490le leVar, String str) throws RemoteException;

    /* renamed from: b */
    void mo9136b(C1442ks ksVar, String str) throws RemoteException;
}
