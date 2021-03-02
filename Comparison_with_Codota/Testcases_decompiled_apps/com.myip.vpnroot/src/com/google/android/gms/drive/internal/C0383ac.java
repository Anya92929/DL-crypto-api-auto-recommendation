package com.google.android.gms.drive.internal;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.drive.realtime.internal.C0570m;

/* renamed from: com.google.android.gms.drive.internal.ac */
public interface C0383ac extends IInterface {

    /* renamed from: com.google.android.gms.drive.internal.ac$a */
    public static abstract class C0384a extends Binder implements C0383ac {

        /* renamed from: com.google.android.gms.drive.internal.ac$a$a */
        private static class C0385a implements C0383ac {

            /* renamed from: lb */
            private IBinder f981lb;

            C0385a(IBinder iBinder) {
                this.f981lb = iBinder;
            }

            /* renamed from: a */
            public void mo4892a(OnContentsResponse onContentsResponse) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.drive.internal.IDriveServiceCallbacks");
                    if (onContentsResponse != null) {
                        obtain.writeInt(1);
                        onContentsResponse.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.f981lb.transact(5, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            /* renamed from: a */
            public void mo4893a(OnDownloadProgressResponse onDownloadProgressResponse) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.drive.internal.IDriveServiceCallbacks");
                    if (onDownloadProgressResponse != null) {
                        obtain.writeInt(1);
                        onDownloadProgressResponse.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.f981lb.transact(1, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            /* renamed from: a */
            public void mo4894a(OnDriveIdResponse onDriveIdResponse) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.drive.internal.IDriveServiceCallbacks");
                    if (onDriveIdResponse != null) {
                        obtain.writeInt(1);
                        onDriveIdResponse.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.f981lb.transact(3, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            /* renamed from: a */
            public void mo4895a(OnDrivePreferencesResponse onDrivePreferencesResponse) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.drive.internal.IDriveServiceCallbacks");
                    if (onDrivePreferencesResponse != null) {
                        obtain.writeInt(1);
                        onDrivePreferencesResponse.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.f981lb.transact(13, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            /* renamed from: a */
            public void mo4896a(OnListEntriesResponse onListEntriesResponse) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.drive.internal.IDriveServiceCallbacks");
                    if (onListEntriesResponse != null) {
                        obtain.writeInt(1);
                        onListEntriesResponse.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.f981lb.transact(2, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            /* renamed from: a */
            public void mo4897a(OnListParentsResponse onListParentsResponse) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.drive.internal.IDriveServiceCallbacks");
                    if (onListParentsResponse != null) {
                        obtain.writeInt(1);
                        onListParentsResponse.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.f981lb.transact(8, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            /* renamed from: a */
            public void mo4898a(OnLoadRealtimeResponse onLoadRealtimeResponse, C0570m mVar) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.drive.internal.IDriveServiceCallbacks");
                    if (onLoadRealtimeResponse != null) {
                        obtain.writeInt(1);
                        onLoadRealtimeResponse.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    obtain.writeStrongBinder(mVar != null ? mVar.asBinder() : null);
                    this.f981lb.transact(11, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            /* renamed from: a */
            public void mo4899a(OnMetadataResponse onMetadataResponse) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.drive.internal.IDriveServiceCallbacks");
                    if (onMetadataResponse != null) {
                        obtain.writeInt(1);
                        onMetadataResponse.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.f981lb.transact(4, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            /* renamed from: a */
            public void mo4900a(OnResourceIdSetResponse onResourceIdSetResponse) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.drive.internal.IDriveServiceCallbacks");
                    if (onResourceIdSetResponse != null) {
                        obtain.writeInt(1);
                        onResourceIdSetResponse.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.f981lb.transact(12, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            /* renamed from: a */
            public void mo4901a(OnStorageStatsResponse onStorageStatsResponse) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.drive.internal.IDriveServiceCallbacks");
                    if (onStorageStatsResponse != null) {
                        obtain.writeInt(1);
                        onStorageStatsResponse.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.f981lb.transact(10, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            /* renamed from: a */
            public void mo4902a(OnSyncMoreResponse onSyncMoreResponse) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.drive.internal.IDriveServiceCallbacks");
                    if (onSyncMoreResponse != null) {
                        obtain.writeInt(1);
                        onSyncMoreResponse.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.f981lb.transact(9, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public IBinder asBinder() {
                return this.f981lb;
            }

            /* renamed from: o */
            public void mo4903o(Status status) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.drive.internal.IDriveServiceCallbacks");
                    if (status != null) {
                        obtain.writeInt(1);
                        status.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.f981lb.transact(6, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void onSuccess() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.drive.internal.IDriveServiceCallbacks");
                    this.f981lb.transact(7, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }
        }

        public C0384a() {
            attachInterface(this, "com.google.android.gms.drive.internal.IDriveServiceCallbacks");
        }

        /* renamed from: V */
        public static C0383ac m1109V(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.drive.internal.IDriveServiceCallbacks");
            return (queryLocalInterface == null || !(queryLocalInterface instanceof C0383ac)) ? new C0385a(iBinder) : (C0383ac) queryLocalInterface;
        }

        public IBinder asBinder() {
            return this;
        }

        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v1, resolved type: com.google.android.gms.drive.internal.OnDrivePreferencesResponse} */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v6, resolved type: com.google.android.gms.drive.internal.OnResourceIdSetResponse} */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v11, resolved type: com.google.android.gms.drive.internal.OnLoadRealtimeResponse} */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v16, resolved type: com.google.android.gms.drive.internal.OnStorageStatsResponse} */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v21, resolved type: com.google.android.gms.drive.internal.OnSyncMoreResponse} */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v26, resolved type: com.google.android.gms.drive.internal.OnListParentsResponse} */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v33, resolved type: com.google.android.gms.common.api.Status} */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v37, resolved type: com.google.android.gms.drive.internal.OnContentsResponse} */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v42, resolved type: com.google.android.gms.drive.internal.OnMetadataResponse} */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v47, resolved type: com.google.android.gms.drive.internal.OnDriveIdResponse} */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v52, resolved type: com.google.android.gms.drive.internal.OnListEntriesResponse} */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v57, resolved type: com.google.android.gms.drive.internal.OnDownloadProgressResponse} */
        /* JADX WARNING: type inference failed for: r0v0 */
        /* JADX WARNING: type inference failed for: r0v65 */
        /* JADX WARNING: type inference failed for: r0v66 */
        /* JADX WARNING: type inference failed for: r0v67 */
        /* JADX WARNING: type inference failed for: r0v68 */
        /* JADX WARNING: type inference failed for: r0v69 */
        /* JADX WARNING: type inference failed for: r0v70 */
        /* JADX WARNING: type inference failed for: r0v71 */
        /* JADX WARNING: type inference failed for: r0v72 */
        /* JADX WARNING: type inference failed for: r0v73 */
        /* JADX WARNING: type inference failed for: r0v74 */
        /* JADX WARNING: type inference failed for: r0v75 */
        /* JADX WARNING: type inference failed for: r0v76 */
        /* JADX WARNING: Multi-variable type inference failed */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public boolean onTransact(int r4, android.os.Parcel r5, android.os.Parcel r6, int r7) throws android.os.RemoteException {
            /*
                r3 = this;
                r0 = 0
                r1 = 1
                switch(r4) {
                    case 1: goto L_0x0011;
                    case 2: goto L_0x002c;
                    case 3: goto L_0x0047;
                    case 4: goto L_0x0062;
                    case 5: goto L_0x007d;
                    case 6: goto L_0x0099;
                    case 7: goto L_0x00b3;
                    case 8: goto L_0x00c1;
                    case 9: goto L_0x00dd;
                    case 10: goto L_0x00f9;
                    case 11: goto L_0x0115;
                    case 12: goto L_0x0139;
                    case 13: goto L_0x0155;
                    case 1598968902: goto L_0x000a;
                    default: goto L_0x0005;
                }
            L_0x0005:
                boolean r0 = super.onTransact(r4, r5, r6, r7)
            L_0x0009:
                return r0
            L_0x000a:
                java.lang.String r0 = "com.google.android.gms.drive.internal.IDriveServiceCallbacks"
                r6.writeString(r0)
                r0 = r1
                goto L_0x0009
            L_0x0011:
                java.lang.String r2 = "com.google.android.gms.drive.internal.IDriveServiceCallbacks"
                r5.enforceInterface(r2)
                int r2 = r5.readInt()
                if (r2 == 0) goto L_0x0024
                android.os.Parcelable$Creator<com.google.android.gms.drive.internal.OnDownloadProgressResponse> r0 = com.google.android.gms.drive.internal.OnDownloadProgressResponse.CREATOR
                java.lang.Object r0 = r0.createFromParcel(r5)
                com.google.android.gms.drive.internal.OnDownloadProgressResponse r0 = (com.google.android.gms.drive.internal.OnDownloadProgressResponse) r0
            L_0x0024:
                r3.mo4893a((com.google.android.gms.drive.internal.OnDownloadProgressResponse) r0)
                r6.writeNoException()
                r0 = r1
                goto L_0x0009
            L_0x002c:
                java.lang.String r2 = "com.google.android.gms.drive.internal.IDriveServiceCallbacks"
                r5.enforceInterface(r2)
                int r2 = r5.readInt()
                if (r2 == 0) goto L_0x003f
                android.os.Parcelable$Creator<com.google.android.gms.drive.internal.OnListEntriesResponse> r0 = com.google.android.gms.drive.internal.OnListEntriesResponse.CREATOR
                java.lang.Object r0 = r0.createFromParcel(r5)
                com.google.android.gms.drive.internal.OnListEntriesResponse r0 = (com.google.android.gms.drive.internal.OnListEntriesResponse) r0
            L_0x003f:
                r3.mo4896a((com.google.android.gms.drive.internal.OnListEntriesResponse) r0)
                r6.writeNoException()
                r0 = r1
                goto L_0x0009
            L_0x0047:
                java.lang.String r2 = "com.google.android.gms.drive.internal.IDriveServiceCallbacks"
                r5.enforceInterface(r2)
                int r2 = r5.readInt()
                if (r2 == 0) goto L_0x005a
                android.os.Parcelable$Creator<com.google.android.gms.drive.internal.OnDriveIdResponse> r0 = com.google.android.gms.drive.internal.OnDriveIdResponse.CREATOR
                java.lang.Object r0 = r0.createFromParcel(r5)
                com.google.android.gms.drive.internal.OnDriveIdResponse r0 = (com.google.android.gms.drive.internal.OnDriveIdResponse) r0
            L_0x005a:
                r3.mo4894a((com.google.android.gms.drive.internal.OnDriveIdResponse) r0)
                r6.writeNoException()
                r0 = r1
                goto L_0x0009
            L_0x0062:
                java.lang.String r2 = "com.google.android.gms.drive.internal.IDriveServiceCallbacks"
                r5.enforceInterface(r2)
                int r2 = r5.readInt()
                if (r2 == 0) goto L_0x0075
                android.os.Parcelable$Creator<com.google.android.gms.drive.internal.OnMetadataResponse> r0 = com.google.android.gms.drive.internal.OnMetadataResponse.CREATOR
                java.lang.Object r0 = r0.createFromParcel(r5)
                com.google.android.gms.drive.internal.OnMetadataResponse r0 = (com.google.android.gms.drive.internal.OnMetadataResponse) r0
            L_0x0075:
                r3.mo4899a((com.google.android.gms.drive.internal.OnMetadataResponse) r0)
                r6.writeNoException()
                r0 = r1
                goto L_0x0009
            L_0x007d:
                java.lang.String r2 = "com.google.android.gms.drive.internal.IDriveServiceCallbacks"
                r5.enforceInterface(r2)
                int r2 = r5.readInt()
                if (r2 == 0) goto L_0x0090
                android.os.Parcelable$Creator<com.google.android.gms.drive.internal.OnContentsResponse> r0 = com.google.android.gms.drive.internal.OnContentsResponse.CREATOR
                java.lang.Object r0 = r0.createFromParcel(r5)
                com.google.android.gms.drive.internal.OnContentsResponse r0 = (com.google.android.gms.drive.internal.OnContentsResponse) r0
            L_0x0090:
                r3.mo4892a((com.google.android.gms.drive.internal.OnContentsResponse) r0)
                r6.writeNoException()
                r0 = r1
                goto L_0x0009
            L_0x0099:
                java.lang.String r2 = "com.google.android.gms.drive.internal.IDriveServiceCallbacks"
                r5.enforceInterface(r2)
                int r2 = r5.readInt()
                if (r2 == 0) goto L_0x00aa
                com.google.android.gms.common.api.StatusCreator r0 = com.google.android.gms.common.api.Status.CREATOR
                com.google.android.gms.common.api.Status r0 = r0.createFromParcel((android.os.Parcel) r5)
            L_0x00aa:
                r3.mo4903o(r0)
                r6.writeNoException()
                r0 = r1
                goto L_0x0009
            L_0x00b3:
                java.lang.String r0 = "com.google.android.gms.drive.internal.IDriveServiceCallbacks"
                r5.enforceInterface(r0)
                r3.onSuccess()
                r6.writeNoException()
                r0 = r1
                goto L_0x0009
            L_0x00c1:
                java.lang.String r2 = "com.google.android.gms.drive.internal.IDriveServiceCallbacks"
                r5.enforceInterface(r2)
                int r2 = r5.readInt()
                if (r2 == 0) goto L_0x00d4
                android.os.Parcelable$Creator<com.google.android.gms.drive.internal.OnListParentsResponse> r0 = com.google.android.gms.drive.internal.OnListParentsResponse.CREATOR
                java.lang.Object r0 = r0.createFromParcel(r5)
                com.google.android.gms.drive.internal.OnListParentsResponse r0 = (com.google.android.gms.drive.internal.OnListParentsResponse) r0
            L_0x00d4:
                r3.mo4897a((com.google.android.gms.drive.internal.OnListParentsResponse) r0)
                r6.writeNoException()
                r0 = r1
                goto L_0x0009
            L_0x00dd:
                java.lang.String r2 = "com.google.android.gms.drive.internal.IDriveServiceCallbacks"
                r5.enforceInterface(r2)
                int r2 = r5.readInt()
                if (r2 == 0) goto L_0x00f0
                android.os.Parcelable$Creator<com.google.android.gms.drive.internal.OnSyncMoreResponse> r0 = com.google.android.gms.drive.internal.OnSyncMoreResponse.CREATOR
                java.lang.Object r0 = r0.createFromParcel(r5)
                com.google.android.gms.drive.internal.OnSyncMoreResponse r0 = (com.google.android.gms.drive.internal.OnSyncMoreResponse) r0
            L_0x00f0:
                r3.mo4902a((com.google.android.gms.drive.internal.OnSyncMoreResponse) r0)
                r6.writeNoException()
                r0 = r1
                goto L_0x0009
            L_0x00f9:
                java.lang.String r2 = "com.google.android.gms.drive.internal.IDriveServiceCallbacks"
                r5.enforceInterface(r2)
                int r2 = r5.readInt()
                if (r2 == 0) goto L_0x010c
                android.os.Parcelable$Creator<com.google.android.gms.drive.internal.OnStorageStatsResponse> r0 = com.google.android.gms.drive.internal.OnStorageStatsResponse.CREATOR
                java.lang.Object r0 = r0.createFromParcel(r5)
                com.google.android.gms.drive.internal.OnStorageStatsResponse r0 = (com.google.android.gms.drive.internal.OnStorageStatsResponse) r0
            L_0x010c:
                r3.mo4901a((com.google.android.gms.drive.internal.OnStorageStatsResponse) r0)
                r6.writeNoException()
                r0 = r1
                goto L_0x0009
            L_0x0115:
                java.lang.String r2 = "com.google.android.gms.drive.internal.IDriveServiceCallbacks"
                r5.enforceInterface(r2)
                int r2 = r5.readInt()
                if (r2 == 0) goto L_0x0128
                android.os.Parcelable$Creator<com.google.android.gms.drive.internal.OnLoadRealtimeResponse> r0 = com.google.android.gms.drive.internal.OnLoadRealtimeResponse.CREATOR
                java.lang.Object r0 = r0.createFromParcel(r5)
                com.google.android.gms.drive.internal.OnLoadRealtimeResponse r0 = (com.google.android.gms.drive.internal.OnLoadRealtimeResponse) r0
            L_0x0128:
                android.os.IBinder r2 = r5.readStrongBinder()
                com.google.android.gms.drive.realtime.internal.m r2 = com.google.android.gms.drive.realtime.internal.C0570m.C0571a.m1647ai(r2)
                r3.mo4898a(r0, r2)
                r6.writeNoException()
                r0 = r1
                goto L_0x0009
            L_0x0139:
                java.lang.String r2 = "com.google.android.gms.drive.internal.IDriveServiceCallbacks"
                r5.enforceInterface(r2)
                int r2 = r5.readInt()
                if (r2 == 0) goto L_0x014c
                android.os.Parcelable$Creator<com.google.android.gms.drive.internal.OnResourceIdSetResponse> r0 = com.google.android.gms.drive.internal.OnResourceIdSetResponse.CREATOR
                java.lang.Object r0 = r0.createFromParcel(r5)
                com.google.android.gms.drive.internal.OnResourceIdSetResponse r0 = (com.google.android.gms.drive.internal.OnResourceIdSetResponse) r0
            L_0x014c:
                r3.mo4900a((com.google.android.gms.drive.internal.OnResourceIdSetResponse) r0)
                r6.writeNoException()
                r0 = r1
                goto L_0x0009
            L_0x0155:
                java.lang.String r2 = "com.google.android.gms.drive.internal.IDriveServiceCallbacks"
                r5.enforceInterface(r2)
                int r2 = r5.readInt()
                if (r2 == 0) goto L_0x0168
                android.os.Parcelable$Creator<com.google.android.gms.drive.internal.OnDrivePreferencesResponse> r0 = com.google.android.gms.drive.internal.OnDrivePreferencesResponse.CREATOR
                java.lang.Object r0 = r0.createFromParcel(r5)
                com.google.android.gms.drive.internal.OnDrivePreferencesResponse r0 = (com.google.android.gms.drive.internal.OnDrivePreferencesResponse) r0
            L_0x0168:
                r3.mo4895a((com.google.android.gms.drive.internal.OnDrivePreferencesResponse) r0)
                r6.writeNoException()
                r0 = r1
                goto L_0x0009
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.drive.internal.C0383ac.C0384a.onTransact(int, android.os.Parcel, android.os.Parcel, int):boolean");
        }
    }

    /* renamed from: a */
    void mo4892a(OnContentsResponse onContentsResponse) throws RemoteException;

    /* renamed from: a */
    void mo4893a(OnDownloadProgressResponse onDownloadProgressResponse) throws RemoteException;

    /* renamed from: a */
    void mo4894a(OnDriveIdResponse onDriveIdResponse) throws RemoteException;

    /* renamed from: a */
    void mo4895a(OnDrivePreferencesResponse onDrivePreferencesResponse) throws RemoteException;

    /* renamed from: a */
    void mo4896a(OnListEntriesResponse onListEntriesResponse) throws RemoteException;

    /* renamed from: a */
    void mo4897a(OnListParentsResponse onListParentsResponse) throws RemoteException;

    /* renamed from: a */
    void mo4898a(OnLoadRealtimeResponse onLoadRealtimeResponse, C0570m mVar) throws RemoteException;

    /* renamed from: a */
    void mo4899a(OnMetadataResponse onMetadataResponse) throws RemoteException;

    /* renamed from: a */
    void mo4900a(OnResourceIdSetResponse onResourceIdSetResponse) throws RemoteException;

    /* renamed from: a */
    void mo4901a(OnStorageStatsResponse onStorageStatsResponse) throws RemoteException;

    /* renamed from: a */
    void mo4902a(OnSyncMoreResponse onSyncMoreResponse) throws RemoteException;

    /* renamed from: o */
    void mo4903o(Status status) throws RemoteException;

    void onSuccess() throws RemoteException;
}
