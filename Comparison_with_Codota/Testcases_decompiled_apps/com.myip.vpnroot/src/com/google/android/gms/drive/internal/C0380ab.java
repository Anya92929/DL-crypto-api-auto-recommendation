package com.google.android.gms.drive.internal;

import android.content.IntentSender;
import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.drive.RealtimeDocumentSyncRequest;

/* renamed from: com.google.android.gms.drive.internal.ab */
public interface C0380ab extends IInterface {

    /* renamed from: com.google.android.gms.drive.internal.ab$a */
    public static abstract class C0381a extends Binder implements C0380ab {

        /* renamed from: com.google.android.gms.drive.internal.ab$a$a */
        private static class C0382a implements C0380ab {

            /* renamed from: lb */
            private IBinder f980lb;

            C0382a(IBinder iBinder) {
                this.f980lb = iBinder;
            }

            /* renamed from: a */
            public IntentSender mo4858a(CreateFileIntentSenderRequest createFileIntentSenderRequest) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.drive.internal.IDriveService");
                    if (createFileIntentSenderRequest != null) {
                        obtain.writeInt(1);
                        createFileIntentSenderRequest.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.f980lb.transact(11, obtain, obtain2, 0);
                    obtain2.readException();
                    return obtain2.readInt() != 0 ? (IntentSender) IntentSender.CREATOR.createFromParcel(obtain2) : null;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            /* renamed from: a */
            public IntentSender mo4859a(OpenFileIntentSenderRequest openFileIntentSenderRequest) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.drive.internal.IDriveService");
                    if (openFileIntentSenderRequest != null) {
                        obtain.writeInt(1);
                        openFileIntentSenderRequest.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.f980lb.transact(10, obtain, obtain2, 0);
                    obtain2.readException();
                    return obtain2.readInt() != 0 ? (IntentSender) IntentSender.CREATOR.createFromParcel(obtain2) : null;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            /* renamed from: a */
            public void mo4860a(RealtimeDocumentSyncRequest realtimeDocumentSyncRequest, C0383ac acVar) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.drive.internal.IDriveService");
                    if (realtimeDocumentSyncRequest != null) {
                        obtain.writeInt(1);
                        realtimeDocumentSyncRequest.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    obtain.writeStrongBinder(acVar != null ? acVar.asBinder() : null);
                    this.f980lb.transact(34, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            /* renamed from: a */
            public void mo4861a(AddEventListenerRequest addEventListenerRequest, C0386ad adVar, String str, C0383ac acVar) throws RemoteException {
                IBinder iBinder = null;
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.drive.internal.IDriveService");
                    if (addEventListenerRequest != null) {
                        obtain.writeInt(1);
                        addEventListenerRequest.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    obtain.writeStrongBinder(adVar != null ? adVar.asBinder() : null);
                    obtain.writeString(str);
                    if (acVar != null) {
                        iBinder = acVar.asBinder();
                    }
                    obtain.writeStrongBinder(iBinder);
                    this.f980lb.transact(14, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            /* renamed from: a */
            public void mo4862a(AuthorizeAccessRequest authorizeAccessRequest, C0383ac acVar) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.drive.internal.IDriveService");
                    if (authorizeAccessRequest != null) {
                        obtain.writeInt(1);
                        authorizeAccessRequest.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    obtain.writeStrongBinder(acVar != null ? acVar.asBinder() : null);
                    this.f980lb.transact(12, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            /* renamed from: a */
            public void mo4863a(CheckResourceIdsExistRequest checkResourceIdsExistRequest, C0383ac acVar) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.drive.internal.IDriveService");
                    if (checkResourceIdsExistRequest != null) {
                        obtain.writeInt(1);
                        checkResourceIdsExistRequest.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    obtain.writeStrongBinder(acVar != null ? acVar.asBinder() : null);
                    this.f980lb.transact(30, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            /* renamed from: a */
            public void mo4864a(CloseContentsAndUpdateMetadataRequest closeContentsAndUpdateMetadataRequest, C0383ac acVar) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.drive.internal.IDriveService");
                    if (closeContentsAndUpdateMetadataRequest != null) {
                        obtain.writeInt(1);
                        closeContentsAndUpdateMetadataRequest.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    obtain.writeStrongBinder(acVar != null ? acVar.asBinder() : null);
                    this.f980lb.transact(18, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            /* renamed from: a */
            public void mo4865a(CloseContentsRequest closeContentsRequest, C0383ac acVar) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.drive.internal.IDriveService");
                    if (closeContentsRequest != null) {
                        obtain.writeInt(1);
                        closeContentsRequest.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    obtain.writeStrongBinder(acVar != null ? acVar.asBinder() : null);
                    this.f980lb.transact(8, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            /* renamed from: a */
            public void mo4866a(CreateContentsRequest createContentsRequest, C0383ac acVar) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.drive.internal.IDriveService");
                    if (createContentsRequest != null) {
                        obtain.writeInt(1);
                        createContentsRequest.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    obtain.writeStrongBinder(acVar != null ? acVar.asBinder() : null);
                    this.f980lb.transact(4, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            /* renamed from: a */
            public void mo4867a(CreateFileRequest createFileRequest, C0383ac acVar) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.drive.internal.IDriveService");
                    if (createFileRequest != null) {
                        obtain.writeInt(1);
                        createFileRequest.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    obtain.writeStrongBinder(acVar != null ? acVar.asBinder() : null);
                    this.f980lb.transact(5, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            /* renamed from: a */
            public void mo4868a(CreateFolderRequest createFolderRequest, C0383ac acVar) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.drive.internal.IDriveService");
                    if (createFolderRequest != null) {
                        obtain.writeInt(1);
                        createFolderRequest.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    obtain.writeStrongBinder(acVar != null ? acVar.asBinder() : null);
                    this.f980lb.transact(6, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            /* renamed from: a */
            public void mo4869a(DeleteResourceRequest deleteResourceRequest, C0383ac acVar) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.drive.internal.IDriveService");
                    if (deleteResourceRequest != null) {
                        obtain.writeInt(1);
                        deleteResourceRequest.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    obtain.writeStrongBinder(acVar != null ? acVar.asBinder() : null);
                    this.f980lb.transact(24, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            /* renamed from: a */
            public void mo4870a(DisconnectRequest disconnectRequest) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.drive.internal.IDriveService");
                    if (disconnectRequest != null) {
                        obtain.writeInt(1);
                        disconnectRequest.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.f980lb.transact(16, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            /* renamed from: a */
            public void mo4871a(GetDriveIdFromUniqueIdentifierRequest getDriveIdFromUniqueIdentifierRequest, C0383ac acVar) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.drive.internal.IDriveService");
                    if (getDriveIdFromUniqueIdentifierRequest != null) {
                        obtain.writeInt(1);
                        getDriveIdFromUniqueIdentifierRequest.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    obtain.writeStrongBinder(acVar != null ? acVar.asBinder() : null);
                    this.f980lb.transact(29, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            /* renamed from: a */
            public void mo4872a(GetMetadataRequest getMetadataRequest, C0383ac acVar) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.drive.internal.IDriveService");
                    if (getMetadataRequest != null) {
                        obtain.writeInt(1);
                        getMetadataRequest.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    obtain.writeStrongBinder(acVar != null ? acVar.asBinder() : null);
                    this.f980lb.transact(1, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            /* renamed from: a */
            public void mo4873a(ListParentsRequest listParentsRequest, C0383ac acVar) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.drive.internal.IDriveService");
                    if (listParentsRequest != null) {
                        obtain.writeInt(1);
                        listParentsRequest.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    obtain.writeStrongBinder(acVar != null ? acVar.asBinder() : null);
                    this.f980lb.transact(13, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            /* renamed from: a */
            public void mo4874a(LoadRealtimeRequest loadRealtimeRequest, C0383ac acVar) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.drive.internal.IDriveService");
                    if (loadRealtimeRequest != null) {
                        obtain.writeInt(1);
                        loadRealtimeRequest.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    obtain.writeStrongBinder(acVar != null ? acVar.asBinder() : null);
                    this.f980lb.transact(27, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            /* renamed from: a */
            public void mo4875a(OpenContentsRequest openContentsRequest, C0383ac acVar) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.drive.internal.IDriveService");
                    if (openContentsRequest != null) {
                        obtain.writeInt(1);
                        openContentsRequest.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    obtain.writeStrongBinder(acVar != null ? acVar.asBinder() : null);
                    this.f980lb.transact(7, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            /* renamed from: a */
            public void mo4876a(QueryRequest queryRequest, C0383ac acVar) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.drive.internal.IDriveService");
                    if (queryRequest != null) {
                        obtain.writeInt(1);
                        queryRequest.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    obtain.writeStrongBinder(acVar != null ? acVar.asBinder() : null);
                    this.f980lb.transact(2, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            /* renamed from: a */
            public void mo4877a(RemoveEventListenerRequest removeEventListenerRequest, C0386ad adVar, String str, C0383ac acVar) throws RemoteException {
                IBinder iBinder = null;
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.drive.internal.IDriveService");
                    if (removeEventListenerRequest != null) {
                        obtain.writeInt(1);
                        removeEventListenerRequest.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    obtain.writeStrongBinder(adVar != null ? adVar.asBinder() : null);
                    obtain.writeString(str);
                    if (acVar != null) {
                        iBinder = acVar.asBinder();
                    }
                    obtain.writeStrongBinder(iBinder);
                    this.f980lb.transact(15, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            /* renamed from: a */
            public void mo4878a(SetDrivePreferencesRequest setDrivePreferencesRequest, C0383ac acVar) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.drive.internal.IDriveService");
                    if (setDrivePreferencesRequest != null) {
                        obtain.writeInt(1);
                        setDrivePreferencesRequest.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    obtain.writeStrongBinder(acVar != null ? acVar.asBinder() : null);
                    this.f980lb.transact(33, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            /* renamed from: a */
            public void mo4879a(SetResourceParentsRequest setResourceParentsRequest, C0383ac acVar) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.drive.internal.IDriveService");
                    if (setResourceParentsRequest != null) {
                        obtain.writeInt(1);
                        setResourceParentsRequest.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    obtain.writeStrongBinder(acVar != null ? acVar.asBinder() : null);
                    this.f980lb.transact(28, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            /* renamed from: a */
            public void mo4880a(TrashResourceRequest trashResourceRequest, C0383ac acVar) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.drive.internal.IDriveService");
                    if (trashResourceRequest != null) {
                        obtain.writeInt(1);
                        trashResourceRequest.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    obtain.writeStrongBinder(acVar != null ? acVar.asBinder() : null);
                    this.f980lb.transact(17, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            /* renamed from: a */
            public void mo4881a(UpdateMetadataRequest updateMetadataRequest, C0383ac acVar) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.drive.internal.IDriveService");
                    if (updateMetadataRequest != null) {
                        obtain.writeInt(1);
                        updateMetadataRequest.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    obtain.writeStrongBinder(acVar != null ? acVar.asBinder() : null);
                    this.f980lb.transact(3, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            /* renamed from: a */
            public void mo4882a(C0383ac acVar) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.drive.internal.IDriveService");
                    obtain.writeStrongBinder(acVar != null ? acVar.asBinder() : null);
                    this.f980lb.transact(9, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public IBinder asBinder() {
                return this.f980lb;
            }

            /* renamed from: b */
            public void mo4883b(QueryRequest queryRequest, C0383ac acVar) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.drive.internal.IDriveService");
                    if (queryRequest != null) {
                        obtain.writeInt(1);
                        queryRequest.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    obtain.writeStrongBinder(acVar != null ? acVar.asBinder() : null);
                    this.f980lb.transact(19, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            /* renamed from: b */
            public void mo4884b(C0383ac acVar) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.drive.internal.IDriveService");
                    obtain.writeStrongBinder(acVar != null ? acVar.asBinder() : null);
                    this.f980lb.transact(20, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            /* renamed from: c */
            public void mo4885c(C0383ac acVar) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.drive.internal.IDriveService");
                    obtain.writeStrongBinder(acVar != null ? acVar.asBinder() : null);
                    this.f980lb.transact(21, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            /* renamed from: d */
            public void mo4886d(C0383ac acVar) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.drive.internal.IDriveService");
                    obtain.writeStrongBinder(acVar != null ? acVar.asBinder() : null);
                    this.f980lb.transact(22, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            /* renamed from: e */
            public void mo4887e(C0383ac acVar) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.drive.internal.IDriveService");
                    obtain.writeStrongBinder(acVar != null ? acVar.asBinder() : null);
                    this.f980lb.transact(23, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            /* renamed from: f */
            public void mo4888f(C0383ac acVar) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.drive.internal.IDriveService");
                    obtain.writeStrongBinder(acVar != null ? acVar.asBinder() : null);
                    this.f980lb.transact(31, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            /* renamed from: g */
            public void mo4889g(C0383ac acVar) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.drive.internal.IDriveService");
                    obtain.writeStrongBinder(acVar != null ? acVar.asBinder() : null);
                    this.f980lb.transact(32, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }
        }

        /* renamed from: U */
        public static C0380ab m1064U(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.drive.internal.IDriveService");
            return (queryLocalInterface == null || !(queryLocalInterface instanceof C0380ab)) ? new C0382a(iBinder) : (C0380ab) queryLocalInterface;
        }

        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v1, resolved type: com.google.android.gms.drive.RealtimeDocumentSyncRequest} */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v6, resolved type: com.google.android.gms.drive.internal.SetDrivePreferencesRequest} */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v19, resolved type: com.google.android.gms.drive.internal.CheckResourceIdsExistRequest} */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v24, resolved type: com.google.android.gms.drive.internal.GetDriveIdFromUniqueIdentifierRequest} */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v29, resolved type: com.google.android.gms.drive.internal.SetResourceParentsRequest} */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v34, resolved type: com.google.android.gms.drive.internal.LoadRealtimeRequest} */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v39, resolved type: com.google.android.gms.drive.internal.DeleteResourceRequest} */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v60, resolved type: com.google.android.gms.drive.internal.QueryRequest} */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v65, resolved type: com.google.android.gms.drive.internal.CloseContentsAndUpdateMetadataRequest} */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v70, resolved type: com.google.android.gms.drive.internal.TrashResourceRequest} */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v75, resolved type: com.google.android.gms.drive.internal.DisconnectRequest} */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v80, resolved type: com.google.android.gms.drive.internal.RemoveEventListenerRequest} */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v85, resolved type: com.google.android.gms.drive.internal.AddEventListenerRequest} */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v90, resolved type: com.google.android.gms.drive.internal.ListParentsRequest} */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v95, resolved type: com.google.android.gms.drive.internal.AuthorizeAccessRequest} */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v100, resolved type: com.google.android.gms.drive.internal.CreateFileIntentSenderRequest} */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v106, resolved type: com.google.android.gms.drive.internal.OpenFileIntentSenderRequest} */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v116, resolved type: com.google.android.gms.drive.internal.CloseContentsRequest} */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v121, resolved type: com.google.android.gms.drive.internal.OpenContentsRequest} */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v126, resolved type: com.google.android.gms.drive.internal.CreateFolderRequest} */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v131, resolved type: com.google.android.gms.drive.internal.CreateFileRequest} */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v136, resolved type: com.google.android.gms.drive.internal.CreateContentsRequest} */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v141, resolved type: com.google.android.gms.drive.internal.UpdateMetadataRequest} */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v146, resolved type: com.google.android.gms.drive.internal.QueryRequest} */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v151, resolved type: com.google.android.gms.drive.internal.GetMetadataRequest} */
        /* JADX WARNING: type inference failed for: r0v0 */
        /* JADX WARNING: type inference failed for: r0v159 */
        /* JADX WARNING: type inference failed for: r0v160 */
        /* JADX WARNING: type inference failed for: r0v161 */
        /* JADX WARNING: type inference failed for: r0v162 */
        /* JADX WARNING: type inference failed for: r0v163 */
        /* JADX WARNING: type inference failed for: r0v164 */
        /* JADX WARNING: type inference failed for: r0v165 */
        /* JADX WARNING: type inference failed for: r0v166 */
        /* JADX WARNING: type inference failed for: r0v167 */
        /* JADX WARNING: type inference failed for: r0v168 */
        /* JADX WARNING: type inference failed for: r0v169 */
        /* JADX WARNING: type inference failed for: r0v170 */
        /* JADX WARNING: type inference failed for: r0v171 */
        /* JADX WARNING: type inference failed for: r0v172 */
        /* JADX WARNING: type inference failed for: r0v173 */
        /* JADX WARNING: type inference failed for: r0v174 */
        /* JADX WARNING: type inference failed for: r0v175 */
        /* JADX WARNING: type inference failed for: r0v176 */
        /* JADX WARNING: type inference failed for: r0v177 */
        /* JADX WARNING: type inference failed for: r0v178 */
        /* JADX WARNING: type inference failed for: r0v179 */
        /* JADX WARNING: type inference failed for: r0v180 */
        /* JADX WARNING: type inference failed for: r0v181 */
        /* JADX WARNING: type inference failed for: r0v182 */
        /* JADX WARNING: type inference failed for: r0v183 */
        /* JADX WARNING: Multi-variable type inference failed */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public boolean onTransact(int r6, android.os.Parcel r7, android.os.Parcel r8, int r9) throws android.os.RemoteException {
            /*
                r5 = this;
                r3 = 0
                r0 = 0
                r1 = 1
                switch(r6) {
                    case 1: goto L_0x0012;
                    case 2: goto L_0x0035;
                    case 3: goto L_0x0058;
                    case 4: goto L_0x007b;
                    case 5: goto L_0x009f;
                    case 6: goto L_0x00c3;
                    case 7: goto L_0x00e7;
                    case 8: goto L_0x010b;
                    case 9: goto L_0x012f;
                    case 10: goto L_0x0145;
                    case 11: goto L_0x016e;
                    case 12: goto L_0x0197;
                    case 13: goto L_0x01bb;
                    case 14: goto L_0x01df;
                    case 15: goto L_0x020f;
                    case 16: goto L_0x023f;
                    case 17: goto L_0x025b;
                    case 18: goto L_0x027f;
                    case 19: goto L_0x02a3;
                    case 20: goto L_0x02c7;
                    case 21: goto L_0x02dd;
                    case 22: goto L_0x02f3;
                    case 23: goto L_0x0309;
                    case 24: goto L_0x031f;
                    case 27: goto L_0x0343;
                    case 28: goto L_0x0367;
                    case 29: goto L_0x038b;
                    case 30: goto L_0x03af;
                    case 31: goto L_0x03d3;
                    case 32: goto L_0x03e9;
                    case 33: goto L_0x03ff;
                    case 34: goto L_0x0423;
                    case 1598968902: goto L_0x000b;
                    default: goto L_0x0006;
                }
            L_0x0006:
                boolean r0 = super.onTransact(r6, r7, r8, r9)
            L_0x000a:
                return r0
            L_0x000b:
                java.lang.String r0 = "com.google.android.gms.drive.internal.IDriveService"
                r8.writeString(r0)
                r0 = r1
                goto L_0x000a
            L_0x0012:
                java.lang.String r2 = "com.google.android.gms.drive.internal.IDriveService"
                r7.enforceInterface(r2)
                int r2 = r7.readInt()
                if (r2 == 0) goto L_0x0025
                android.os.Parcelable$Creator<com.google.android.gms.drive.internal.GetMetadataRequest> r0 = com.google.android.gms.drive.internal.GetMetadataRequest.CREATOR
                java.lang.Object r0 = r0.createFromParcel(r7)
                com.google.android.gms.drive.internal.GetMetadataRequest r0 = (com.google.android.gms.drive.internal.GetMetadataRequest) r0
            L_0x0025:
                android.os.IBinder r2 = r7.readStrongBinder()
                com.google.android.gms.drive.internal.ac r2 = com.google.android.gms.drive.internal.C0383ac.C0384a.m1109V(r2)
                r5.mo4872a((com.google.android.gms.drive.internal.GetMetadataRequest) r0, (com.google.android.gms.drive.internal.C0383ac) r2)
                r8.writeNoException()
                r0 = r1
                goto L_0x000a
            L_0x0035:
                java.lang.String r2 = "com.google.android.gms.drive.internal.IDriveService"
                r7.enforceInterface(r2)
                int r2 = r7.readInt()
                if (r2 == 0) goto L_0x0048
                android.os.Parcelable$Creator<com.google.android.gms.drive.internal.QueryRequest> r0 = com.google.android.gms.drive.internal.QueryRequest.CREATOR
                java.lang.Object r0 = r0.createFromParcel(r7)
                com.google.android.gms.drive.internal.QueryRequest r0 = (com.google.android.gms.drive.internal.QueryRequest) r0
            L_0x0048:
                android.os.IBinder r2 = r7.readStrongBinder()
                com.google.android.gms.drive.internal.ac r2 = com.google.android.gms.drive.internal.C0383ac.C0384a.m1109V(r2)
                r5.mo4876a((com.google.android.gms.drive.internal.QueryRequest) r0, (com.google.android.gms.drive.internal.C0383ac) r2)
                r8.writeNoException()
                r0 = r1
                goto L_0x000a
            L_0x0058:
                java.lang.String r2 = "com.google.android.gms.drive.internal.IDriveService"
                r7.enforceInterface(r2)
                int r2 = r7.readInt()
                if (r2 == 0) goto L_0x006b
                android.os.Parcelable$Creator<com.google.android.gms.drive.internal.UpdateMetadataRequest> r0 = com.google.android.gms.drive.internal.UpdateMetadataRequest.CREATOR
                java.lang.Object r0 = r0.createFromParcel(r7)
                com.google.android.gms.drive.internal.UpdateMetadataRequest r0 = (com.google.android.gms.drive.internal.UpdateMetadataRequest) r0
            L_0x006b:
                android.os.IBinder r2 = r7.readStrongBinder()
                com.google.android.gms.drive.internal.ac r2 = com.google.android.gms.drive.internal.C0383ac.C0384a.m1109V(r2)
                r5.mo4881a((com.google.android.gms.drive.internal.UpdateMetadataRequest) r0, (com.google.android.gms.drive.internal.C0383ac) r2)
                r8.writeNoException()
                r0 = r1
                goto L_0x000a
            L_0x007b:
                java.lang.String r2 = "com.google.android.gms.drive.internal.IDriveService"
                r7.enforceInterface(r2)
                int r2 = r7.readInt()
                if (r2 == 0) goto L_0x008e
                android.os.Parcelable$Creator<com.google.android.gms.drive.internal.CreateContentsRequest> r0 = com.google.android.gms.drive.internal.CreateContentsRequest.CREATOR
                java.lang.Object r0 = r0.createFromParcel(r7)
                com.google.android.gms.drive.internal.CreateContentsRequest r0 = (com.google.android.gms.drive.internal.CreateContentsRequest) r0
            L_0x008e:
                android.os.IBinder r2 = r7.readStrongBinder()
                com.google.android.gms.drive.internal.ac r2 = com.google.android.gms.drive.internal.C0383ac.C0384a.m1109V(r2)
                r5.mo4866a((com.google.android.gms.drive.internal.CreateContentsRequest) r0, (com.google.android.gms.drive.internal.C0383ac) r2)
                r8.writeNoException()
                r0 = r1
                goto L_0x000a
            L_0x009f:
                java.lang.String r2 = "com.google.android.gms.drive.internal.IDriveService"
                r7.enforceInterface(r2)
                int r2 = r7.readInt()
                if (r2 == 0) goto L_0x00b2
                android.os.Parcelable$Creator<com.google.android.gms.drive.internal.CreateFileRequest> r0 = com.google.android.gms.drive.internal.CreateFileRequest.CREATOR
                java.lang.Object r0 = r0.createFromParcel(r7)
                com.google.android.gms.drive.internal.CreateFileRequest r0 = (com.google.android.gms.drive.internal.CreateFileRequest) r0
            L_0x00b2:
                android.os.IBinder r2 = r7.readStrongBinder()
                com.google.android.gms.drive.internal.ac r2 = com.google.android.gms.drive.internal.C0383ac.C0384a.m1109V(r2)
                r5.mo4867a((com.google.android.gms.drive.internal.CreateFileRequest) r0, (com.google.android.gms.drive.internal.C0383ac) r2)
                r8.writeNoException()
                r0 = r1
                goto L_0x000a
            L_0x00c3:
                java.lang.String r2 = "com.google.android.gms.drive.internal.IDriveService"
                r7.enforceInterface(r2)
                int r2 = r7.readInt()
                if (r2 == 0) goto L_0x00d6
                android.os.Parcelable$Creator<com.google.android.gms.drive.internal.CreateFolderRequest> r0 = com.google.android.gms.drive.internal.CreateFolderRequest.CREATOR
                java.lang.Object r0 = r0.createFromParcel(r7)
                com.google.android.gms.drive.internal.CreateFolderRequest r0 = (com.google.android.gms.drive.internal.CreateFolderRequest) r0
            L_0x00d6:
                android.os.IBinder r2 = r7.readStrongBinder()
                com.google.android.gms.drive.internal.ac r2 = com.google.android.gms.drive.internal.C0383ac.C0384a.m1109V(r2)
                r5.mo4868a((com.google.android.gms.drive.internal.CreateFolderRequest) r0, (com.google.android.gms.drive.internal.C0383ac) r2)
                r8.writeNoException()
                r0 = r1
                goto L_0x000a
            L_0x00e7:
                java.lang.String r2 = "com.google.android.gms.drive.internal.IDriveService"
                r7.enforceInterface(r2)
                int r2 = r7.readInt()
                if (r2 == 0) goto L_0x00fa
                android.os.Parcelable$Creator<com.google.android.gms.drive.internal.OpenContentsRequest> r0 = com.google.android.gms.drive.internal.OpenContentsRequest.CREATOR
                java.lang.Object r0 = r0.createFromParcel(r7)
                com.google.android.gms.drive.internal.OpenContentsRequest r0 = (com.google.android.gms.drive.internal.OpenContentsRequest) r0
            L_0x00fa:
                android.os.IBinder r2 = r7.readStrongBinder()
                com.google.android.gms.drive.internal.ac r2 = com.google.android.gms.drive.internal.C0383ac.C0384a.m1109V(r2)
                r5.mo4875a((com.google.android.gms.drive.internal.OpenContentsRequest) r0, (com.google.android.gms.drive.internal.C0383ac) r2)
                r8.writeNoException()
                r0 = r1
                goto L_0x000a
            L_0x010b:
                java.lang.String r2 = "com.google.android.gms.drive.internal.IDriveService"
                r7.enforceInterface(r2)
                int r2 = r7.readInt()
                if (r2 == 0) goto L_0x011e
                android.os.Parcelable$Creator<com.google.android.gms.drive.internal.CloseContentsRequest> r0 = com.google.android.gms.drive.internal.CloseContentsRequest.CREATOR
                java.lang.Object r0 = r0.createFromParcel(r7)
                com.google.android.gms.drive.internal.CloseContentsRequest r0 = (com.google.android.gms.drive.internal.CloseContentsRequest) r0
            L_0x011e:
                android.os.IBinder r2 = r7.readStrongBinder()
                com.google.android.gms.drive.internal.ac r2 = com.google.android.gms.drive.internal.C0383ac.C0384a.m1109V(r2)
                r5.mo4865a((com.google.android.gms.drive.internal.CloseContentsRequest) r0, (com.google.android.gms.drive.internal.C0383ac) r2)
                r8.writeNoException()
                r0 = r1
                goto L_0x000a
            L_0x012f:
                java.lang.String r0 = "com.google.android.gms.drive.internal.IDriveService"
                r7.enforceInterface(r0)
                android.os.IBinder r0 = r7.readStrongBinder()
                com.google.android.gms.drive.internal.ac r0 = com.google.android.gms.drive.internal.C0383ac.C0384a.m1109V(r0)
                r5.mo4882a((com.google.android.gms.drive.internal.C0383ac) r0)
                r8.writeNoException()
                r0 = r1
                goto L_0x000a
            L_0x0145:
                java.lang.String r2 = "com.google.android.gms.drive.internal.IDriveService"
                r7.enforceInterface(r2)
                int r2 = r7.readInt()
                if (r2 == 0) goto L_0x0158
                android.os.Parcelable$Creator<com.google.android.gms.drive.internal.OpenFileIntentSenderRequest> r0 = com.google.android.gms.drive.internal.OpenFileIntentSenderRequest.CREATOR
                java.lang.Object r0 = r0.createFromParcel(r7)
                com.google.android.gms.drive.internal.OpenFileIntentSenderRequest r0 = (com.google.android.gms.drive.internal.OpenFileIntentSenderRequest) r0
            L_0x0158:
                android.content.IntentSender r0 = r5.mo4859a((com.google.android.gms.drive.internal.OpenFileIntentSenderRequest) r0)
                r8.writeNoException()
                if (r0 == 0) goto L_0x016a
                r8.writeInt(r1)
                r0.writeToParcel(r8, r1)
            L_0x0167:
                r0 = r1
                goto L_0x000a
            L_0x016a:
                r8.writeInt(r3)
                goto L_0x0167
            L_0x016e:
                java.lang.String r2 = "com.google.android.gms.drive.internal.IDriveService"
                r7.enforceInterface(r2)
                int r2 = r7.readInt()
                if (r2 == 0) goto L_0x0181
                android.os.Parcelable$Creator<com.google.android.gms.drive.internal.CreateFileIntentSenderRequest> r0 = com.google.android.gms.drive.internal.CreateFileIntentSenderRequest.CREATOR
                java.lang.Object r0 = r0.createFromParcel(r7)
                com.google.android.gms.drive.internal.CreateFileIntentSenderRequest r0 = (com.google.android.gms.drive.internal.CreateFileIntentSenderRequest) r0
            L_0x0181:
                android.content.IntentSender r0 = r5.mo4858a((com.google.android.gms.drive.internal.CreateFileIntentSenderRequest) r0)
                r8.writeNoException()
                if (r0 == 0) goto L_0x0193
                r8.writeInt(r1)
                r0.writeToParcel(r8, r1)
            L_0x0190:
                r0 = r1
                goto L_0x000a
            L_0x0193:
                r8.writeInt(r3)
                goto L_0x0190
            L_0x0197:
                java.lang.String r2 = "com.google.android.gms.drive.internal.IDriveService"
                r7.enforceInterface(r2)
                int r2 = r7.readInt()
                if (r2 == 0) goto L_0x01aa
                android.os.Parcelable$Creator<com.google.android.gms.drive.internal.AuthorizeAccessRequest> r0 = com.google.android.gms.drive.internal.AuthorizeAccessRequest.CREATOR
                java.lang.Object r0 = r0.createFromParcel(r7)
                com.google.android.gms.drive.internal.AuthorizeAccessRequest r0 = (com.google.android.gms.drive.internal.AuthorizeAccessRequest) r0
            L_0x01aa:
                android.os.IBinder r2 = r7.readStrongBinder()
                com.google.android.gms.drive.internal.ac r2 = com.google.android.gms.drive.internal.C0383ac.C0384a.m1109V(r2)
                r5.mo4862a((com.google.android.gms.drive.internal.AuthorizeAccessRequest) r0, (com.google.android.gms.drive.internal.C0383ac) r2)
                r8.writeNoException()
                r0 = r1
                goto L_0x000a
            L_0x01bb:
                java.lang.String r2 = "com.google.android.gms.drive.internal.IDriveService"
                r7.enforceInterface(r2)
                int r2 = r7.readInt()
                if (r2 == 0) goto L_0x01ce
                android.os.Parcelable$Creator<com.google.android.gms.drive.internal.ListParentsRequest> r0 = com.google.android.gms.drive.internal.ListParentsRequest.CREATOR
                java.lang.Object r0 = r0.createFromParcel(r7)
                com.google.android.gms.drive.internal.ListParentsRequest r0 = (com.google.android.gms.drive.internal.ListParentsRequest) r0
            L_0x01ce:
                android.os.IBinder r2 = r7.readStrongBinder()
                com.google.android.gms.drive.internal.ac r2 = com.google.android.gms.drive.internal.C0383ac.C0384a.m1109V(r2)
                r5.mo4873a((com.google.android.gms.drive.internal.ListParentsRequest) r0, (com.google.android.gms.drive.internal.C0383ac) r2)
                r8.writeNoException()
                r0 = r1
                goto L_0x000a
            L_0x01df:
                java.lang.String r2 = "com.google.android.gms.drive.internal.IDriveService"
                r7.enforceInterface(r2)
                int r2 = r7.readInt()
                if (r2 == 0) goto L_0x01f2
                android.os.Parcelable$Creator<com.google.android.gms.drive.internal.AddEventListenerRequest> r0 = com.google.android.gms.drive.internal.AddEventListenerRequest.CREATOR
                java.lang.Object r0 = r0.createFromParcel(r7)
                com.google.android.gms.drive.internal.AddEventListenerRequest r0 = (com.google.android.gms.drive.internal.AddEventListenerRequest) r0
            L_0x01f2:
                android.os.IBinder r2 = r7.readStrongBinder()
                com.google.android.gms.drive.internal.ad r2 = com.google.android.gms.drive.internal.C0386ad.C0387a.m1123W(r2)
                java.lang.String r3 = r7.readString()
                android.os.IBinder r4 = r7.readStrongBinder()
                com.google.android.gms.drive.internal.ac r4 = com.google.android.gms.drive.internal.C0383ac.C0384a.m1109V(r4)
                r5.mo4861a((com.google.android.gms.drive.internal.AddEventListenerRequest) r0, (com.google.android.gms.drive.internal.C0386ad) r2, (java.lang.String) r3, (com.google.android.gms.drive.internal.C0383ac) r4)
                r8.writeNoException()
                r0 = r1
                goto L_0x000a
            L_0x020f:
                java.lang.String r2 = "com.google.android.gms.drive.internal.IDriveService"
                r7.enforceInterface(r2)
                int r2 = r7.readInt()
                if (r2 == 0) goto L_0x0222
                android.os.Parcelable$Creator<com.google.android.gms.drive.internal.RemoveEventListenerRequest> r0 = com.google.android.gms.drive.internal.RemoveEventListenerRequest.CREATOR
                java.lang.Object r0 = r0.createFromParcel(r7)
                com.google.android.gms.drive.internal.RemoveEventListenerRequest r0 = (com.google.android.gms.drive.internal.RemoveEventListenerRequest) r0
            L_0x0222:
                android.os.IBinder r2 = r7.readStrongBinder()
                com.google.android.gms.drive.internal.ad r2 = com.google.android.gms.drive.internal.C0386ad.C0387a.m1123W(r2)
                java.lang.String r3 = r7.readString()
                android.os.IBinder r4 = r7.readStrongBinder()
                com.google.android.gms.drive.internal.ac r4 = com.google.android.gms.drive.internal.C0383ac.C0384a.m1109V(r4)
                r5.mo4877a((com.google.android.gms.drive.internal.RemoveEventListenerRequest) r0, (com.google.android.gms.drive.internal.C0386ad) r2, (java.lang.String) r3, (com.google.android.gms.drive.internal.C0383ac) r4)
                r8.writeNoException()
                r0 = r1
                goto L_0x000a
            L_0x023f:
                java.lang.String r2 = "com.google.android.gms.drive.internal.IDriveService"
                r7.enforceInterface(r2)
                int r2 = r7.readInt()
                if (r2 == 0) goto L_0x0252
                android.os.Parcelable$Creator<com.google.android.gms.drive.internal.DisconnectRequest> r0 = com.google.android.gms.drive.internal.DisconnectRequest.CREATOR
                java.lang.Object r0 = r0.createFromParcel(r7)
                com.google.android.gms.drive.internal.DisconnectRequest r0 = (com.google.android.gms.drive.internal.DisconnectRequest) r0
            L_0x0252:
                r5.mo4870a((com.google.android.gms.drive.internal.DisconnectRequest) r0)
                r8.writeNoException()
                r0 = r1
                goto L_0x000a
            L_0x025b:
                java.lang.String r2 = "com.google.android.gms.drive.internal.IDriveService"
                r7.enforceInterface(r2)
                int r2 = r7.readInt()
                if (r2 == 0) goto L_0x026e
                android.os.Parcelable$Creator<com.google.android.gms.drive.internal.TrashResourceRequest> r0 = com.google.android.gms.drive.internal.TrashResourceRequest.CREATOR
                java.lang.Object r0 = r0.createFromParcel(r7)
                com.google.android.gms.drive.internal.TrashResourceRequest r0 = (com.google.android.gms.drive.internal.TrashResourceRequest) r0
            L_0x026e:
                android.os.IBinder r2 = r7.readStrongBinder()
                com.google.android.gms.drive.internal.ac r2 = com.google.android.gms.drive.internal.C0383ac.C0384a.m1109V(r2)
                r5.mo4880a((com.google.android.gms.drive.internal.TrashResourceRequest) r0, (com.google.android.gms.drive.internal.C0383ac) r2)
                r8.writeNoException()
                r0 = r1
                goto L_0x000a
            L_0x027f:
                java.lang.String r2 = "com.google.android.gms.drive.internal.IDriveService"
                r7.enforceInterface(r2)
                int r2 = r7.readInt()
                if (r2 == 0) goto L_0x0292
                android.os.Parcelable$Creator<com.google.android.gms.drive.internal.CloseContentsAndUpdateMetadataRequest> r0 = com.google.android.gms.drive.internal.CloseContentsAndUpdateMetadataRequest.CREATOR
                java.lang.Object r0 = r0.createFromParcel(r7)
                com.google.android.gms.drive.internal.CloseContentsAndUpdateMetadataRequest r0 = (com.google.android.gms.drive.internal.CloseContentsAndUpdateMetadataRequest) r0
            L_0x0292:
                android.os.IBinder r2 = r7.readStrongBinder()
                com.google.android.gms.drive.internal.ac r2 = com.google.android.gms.drive.internal.C0383ac.C0384a.m1109V(r2)
                r5.mo4864a((com.google.android.gms.drive.internal.CloseContentsAndUpdateMetadataRequest) r0, (com.google.android.gms.drive.internal.C0383ac) r2)
                r8.writeNoException()
                r0 = r1
                goto L_0x000a
            L_0x02a3:
                java.lang.String r2 = "com.google.android.gms.drive.internal.IDriveService"
                r7.enforceInterface(r2)
                int r2 = r7.readInt()
                if (r2 == 0) goto L_0x02b6
                android.os.Parcelable$Creator<com.google.android.gms.drive.internal.QueryRequest> r0 = com.google.android.gms.drive.internal.QueryRequest.CREATOR
                java.lang.Object r0 = r0.createFromParcel(r7)
                com.google.android.gms.drive.internal.QueryRequest r0 = (com.google.android.gms.drive.internal.QueryRequest) r0
            L_0x02b6:
                android.os.IBinder r2 = r7.readStrongBinder()
                com.google.android.gms.drive.internal.ac r2 = com.google.android.gms.drive.internal.C0383ac.C0384a.m1109V(r2)
                r5.mo4883b(r0, r2)
                r8.writeNoException()
                r0 = r1
                goto L_0x000a
            L_0x02c7:
                java.lang.String r0 = "com.google.android.gms.drive.internal.IDriveService"
                r7.enforceInterface(r0)
                android.os.IBinder r0 = r7.readStrongBinder()
                com.google.android.gms.drive.internal.ac r0 = com.google.android.gms.drive.internal.C0383ac.C0384a.m1109V(r0)
                r5.mo4884b(r0)
                r8.writeNoException()
                r0 = r1
                goto L_0x000a
            L_0x02dd:
                java.lang.String r0 = "com.google.android.gms.drive.internal.IDriveService"
                r7.enforceInterface(r0)
                android.os.IBinder r0 = r7.readStrongBinder()
                com.google.android.gms.drive.internal.ac r0 = com.google.android.gms.drive.internal.C0383ac.C0384a.m1109V(r0)
                r5.mo4885c(r0)
                r8.writeNoException()
                r0 = r1
                goto L_0x000a
            L_0x02f3:
                java.lang.String r0 = "com.google.android.gms.drive.internal.IDriveService"
                r7.enforceInterface(r0)
                android.os.IBinder r0 = r7.readStrongBinder()
                com.google.android.gms.drive.internal.ac r0 = com.google.android.gms.drive.internal.C0383ac.C0384a.m1109V(r0)
                r5.mo4886d(r0)
                r8.writeNoException()
                r0 = r1
                goto L_0x000a
            L_0x0309:
                java.lang.String r0 = "com.google.android.gms.drive.internal.IDriveService"
                r7.enforceInterface(r0)
                android.os.IBinder r0 = r7.readStrongBinder()
                com.google.android.gms.drive.internal.ac r0 = com.google.android.gms.drive.internal.C0383ac.C0384a.m1109V(r0)
                r5.mo4887e(r0)
                r8.writeNoException()
                r0 = r1
                goto L_0x000a
            L_0x031f:
                java.lang.String r2 = "com.google.android.gms.drive.internal.IDriveService"
                r7.enforceInterface(r2)
                int r2 = r7.readInt()
                if (r2 == 0) goto L_0x0332
                android.os.Parcelable$Creator<com.google.android.gms.drive.internal.DeleteResourceRequest> r0 = com.google.android.gms.drive.internal.DeleteResourceRequest.CREATOR
                java.lang.Object r0 = r0.createFromParcel(r7)
                com.google.android.gms.drive.internal.DeleteResourceRequest r0 = (com.google.android.gms.drive.internal.DeleteResourceRequest) r0
            L_0x0332:
                android.os.IBinder r2 = r7.readStrongBinder()
                com.google.android.gms.drive.internal.ac r2 = com.google.android.gms.drive.internal.C0383ac.C0384a.m1109V(r2)
                r5.mo4869a((com.google.android.gms.drive.internal.DeleteResourceRequest) r0, (com.google.android.gms.drive.internal.C0383ac) r2)
                r8.writeNoException()
                r0 = r1
                goto L_0x000a
            L_0x0343:
                java.lang.String r2 = "com.google.android.gms.drive.internal.IDriveService"
                r7.enforceInterface(r2)
                int r2 = r7.readInt()
                if (r2 == 0) goto L_0x0356
                android.os.Parcelable$Creator<com.google.android.gms.drive.internal.LoadRealtimeRequest> r0 = com.google.android.gms.drive.internal.LoadRealtimeRequest.CREATOR
                java.lang.Object r0 = r0.createFromParcel(r7)
                com.google.android.gms.drive.internal.LoadRealtimeRequest r0 = (com.google.android.gms.drive.internal.LoadRealtimeRequest) r0
            L_0x0356:
                android.os.IBinder r2 = r7.readStrongBinder()
                com.google.android.gms.drive.internal.ac r2 = com.google.android.gms.drive.internal.C0383ac.C0384a.m1109V(r2)
                r5.mo4874a((com.google.android.gms.drive.internal.LoadRealtimeRequest) r0, (com.google.android.gms.drive.internal.C0383ac) r2)
                r8.writeNoException()
                r0 = r1
                goto L_0x000a
            L_0x0367:
                java.lang.String r2 = "com.google.android.gms.drive.internal.IDriveService"
                r7.enforceInterface(r2)
                int r2 = r7.readInt()
                if (r2 == 0) goto L_0x037a
                android.os.Parcelable$Creator<com.google.android.gms.drive.internal.SetResourceParentsRequest> r0 = com.google.android.gms.drive.internal.SetResourceParentsRequest.CREATOR
                java.lang.Object r0 = r0.createFromParcel(r7)
                com.google.android.gms.drive.internal.SetResourceParentsRequest r0 = (com.google.android.gms.drive.internal.SetResourceParentsRequest) r0
            L_0x037a:
                android.os.IBinder r2 = r7.readStrongBinder()
                com.google.android.gms.drive.internal.ac r2 = com.google.android.gms.drive.internal.C0383ac.C0384a.m1109V(r2)
                r5.mo4879a((com.google.android.gms.drive.internal.SetResourceParentsRequest) r0, (com.google.android.gms.drive.internal.C0383ac) r2)
                r8.writeNoException()
                r0 = r1
                goto L_0x000a
            L_0x038b:
                java.lang.String r2 = "com.google.android.gms.drive.internal.IDriveService"
                r7.enforceInterface(r2)
                int r2 = r7.readInt()
                if (r2 == 0) goto L_0x039e
                android.os.Parcelable$Creator<com.google.android.gms.drive.internal.GetDriveIdFromUniqueIdentifierRequest> r0 = com.google.android.gms.drive.internal.GetDriveIdFromUniqueIdentifierRequest.CREATOR
                java.lang.Object r0 = r0.createFromParcel(r7)
                com.google.android.gms.drive.internal.GetDriveIdFromUniqueIdentifierRequest r0 = (com.google.android.gms.drive.internal.GetDriveIdFromUniqueIdentifierRequest) r0
            L_0x039e:
                android.os.IBinder r2 = r7.readStrongBinder()
                com.google.android.gms.drive.internal.ac r2 = com.google.android.gms.drive.internal.C0383ac.C0384a.m1109V(r2)
                r5.mo4871a((com.google.android.gms.drive.internal.GetDriveIdFromUniqueIdentifierRequest) r0, (com.google.android.gms.drive.internal.C0383ac) r2)
                r8.writeNoException()
                r0 = r1
                goto L_0x000a
            L_0x03af:
                java.lang.String r2 = "com.google.android.gms.drive.internal.IDriveService"
                r7.enforceInterface(r2)
                int r2 = r7.readInt()
                if (r2 == 0) goto L_0x03c2
                android.os.Parcelable$Creator<com.google.android.gms.drive.internal.CheckResourceIdsExistRequest> r0 = com.google.android.gms.drive.internal.CheckResourceIdsExistRequest.CREATOR
                java.lang.Object r0 = r0.createFromParcel(r7)
                com.google.android.gms.drive.internal.CheckResourceIdsExistRequest r0 = (com.google.android.gms.drive.internal.CheckResourceIdsExistRequest) r0
            L_0x03c2:
                android.os.IBinder r2 = r7.readStrongBinder()
                com.google.android.gms.drive.internal.ac r2 = com.google.android.gms.drive.internal.C0383ac.C0384a.m1109V(r2)
                r5.mo4863a((com.google.android.gms.drive.internal.CheckResourceIdsExistRequest) r0, (com.google.android.gms.drive.internal.C0383ac) r2)
                r8.writeNoException()
                r0 = r1
                goto L_0x000a
            L_0x03d3:
                java.lang.String r0 = "com.google.android.gms.drive.internal.IDriveService"
                r7.enforceInterface(r0)
                android.os.IBinder r0 = r7.readStrongBinder()
                com.google.android.gms.drive.internal.ac r0 = com.google.android.gms.drive.internal.C0383ac.C0384a.m1109V(r0)
                r5.mo4888f(r0)
                r8.writeNoException()
                r0 = r1
                goto L_0x000a
            L_0x03e9:
                java.lang.String r0 = "com.google.android.gms.drive.internal.IDriveService"
                r7.enforceInterface(r0)
                android.os.IBinder r0 = r7.readStrongBinder()
                com.google.android.gms.drive.internal.ac r0 = com.google.android.gms.drive.internal.C0383ac.C0384a.m1109V(r0)
                r5.mo4889g(r0)
                r8.writeNoException()
                r0 = r1
                goto L_0x000a
            L_0x03ff:
                java.lang.String r2 = "com.google.android.gms.drive.internal.IDriveService"
                r7.enforceInterface(r2)
                int r2 = r7.readInt()
                if (r2 == 0) goto L_0x0412
                android.os.Parcelable$Creator<com.google.android.gms.drive.internal.SetDrivePreferencesRequest> r0 = com.google.android.gms.drive.internal.SetDrivePreferencesRequest.CREATOR
                java.lang.Object r0 = r0.createFromParcel(r7)
                com.google.android.gms.drive.internal.SetDrivePreferencesRequest r0 = (com.google.android.gms.drive.internal.SetDrivePreferencesRequest) r0
            L_0x0412:
                android.os.IBinder r2 = r7.readStrongBinder()
                com.google.android.gms.drive.internal.ac r2 = com.google.android.gms.drive.internal.C0383ac.C0384a.m1109V(r2)
                r5.mo4878a((com.google.android.gms.drive.internal.SetDrivePreferencesRequest) r0, (com.google.android.gms.drive.internal.C0383ac) r2)
                r8.writeNoException()
                r0 = r1
                goto L_0x000a
            L_0x0423:
                java.lang.String r2 = "com.google.android.gms.drive.internal.IDriveService"
                r7.enforceInterface(r2)
                int r2 = r7.readInt()
                if (r2 == 0) goto L_0x0436
                android.os.Parcelable$Creator<com.google.android.gms.drive.RealtimeDocumentSyncRequest> r0 = com.google.android.gms.drive.RealtimeDocumentSyncRequest.CREATOR
                java.lang.Object r0 = r0.createFromParcel(r7)
                com.google.android.gms.drive.RealtimeDocumentSyncRequest r0 = (com.google.android.gms.drive.RealtimeDocumentSyncRequest) r0
            L_0x0436:
                android.os.IBinder r2 = r7.readStrongBinder()
                com.google.android.gms.drive.internal.ac r2 = com.google.android.gms.drive.internal.C0383ac.C0384a.m1109V(r2)
                r5.mo4860a((com.google.android.gms.drive.RealtimeDocumentSyncRequest) r0, (com.google.android.gms.drive.internal.C0383ac) r2)
                r8.writeNoException()
                r0 = r1
                goto L_0x000a
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.drive.internal.C0380ab.C0381a.onTransact(int, android.os.Parcel, android.os.Parcel, int):boolean");
        }
    }

    /* renamed from: a */
    IntentSender mo4858a(CreateFileIntentSenderRequest createFileIntentSenderRequest) throws RemoteException;

    /* renamed from: a */
    IntentSender mo4859a(OpenFileIntentSenderRequest openFileIntentSenderRequest) throws RemoteException;

    /* renamed from: a */
    void mo4860a(RealtimeDocumentSyncRequest realtimeDocumentSyncRequest, C0383ac acVar) throws RemoteException;

    /* renamed from: a */
    void mo4861a(AddEventListenerRequest addEventListenerRequest, C0386ad adVar, String str, C0383ac acVar) throws RemoteException;

    /* renamed from: a */
    void mo4862a(AuthorizeAccessRequest authorizeAccessRequest, C0383ac acVar) throws RemoteException;

    /* renamed from: a */
    void mo4863a(CheckResourceIdsExistRequest checkResourceIdsExistRequest, C0383ac acVar) throws RemoteException;

    /* renamed from: a */
    void mo4864a(CloseContentsAndUpdateMetadataRequest closeContentsAndUpdateMetadataRequest, C0383ac acVar) throws RemoteException;

    /* renamed from: a */
    void mo4865a(CloseContentsRequest closeContentsRequest, C0383ac acVar) throws RemoteException;

    /* renamed from: a */
    void mo4866a(CreateContentsRequest createContentsRequest, C0383ac acVar) throws RemoteException;

    /* renamed from: a */
    void mo4867a(CreateFileRequest createFileRequest, C0383ac acVar) throws RemoteException;

    /* renamed from: a */
    void mo4868a(CreateFolderRequest createFolderRequest, C0383ac acVar) throws RemoteException;

    /* renamed from: a */
    void mo4869a(DeleteResourceRequest deleteResourceRequest, C0383ac acVar) throws RemoteException;

    /* renamed from: a */
    void mo4870a(DisconnectRequest disconnectRequest) throws RemoteException;

    /* renamed from: a */
    void mo4871a(GetDriveIdFromUniqueIdentifierRequest getDriveIdFromUniqueIdentifierRequest, C0383ac acVar) throws RemoteException;

    /* renamed from: a */
    void mo4872a(GetMetadataRequest getMetadataRequest, C0383ac acVar) throws RemoteException;

    /* renamed from: a */
    void mo4873a(ListParentsRequest listParentsRequest, C0383ac acVar) throws RemoteException;

    /* renamed from: a */
    void mo4874a(LoadRealtimeRequest loadRealtimeRequest, C0383ac acVar) throws RemoteException;

    /* renamed from: a */
    void mo4875a(OpenContentsRequest openContentsRequest, C0383ac acVar) throws RemoteException;

    /* renamed from: a */
    void mo4876a(QueryRequest queryRequest, C0383ac acVar) throws RemoteException;

    /* renamed from: a */
    void mo4877a(RemoveEventListenerRequest removeEventListenerRequest, C0386ad adVar, String str, C0383ac acVar) throws RemoteException;

    /* renamed from: a */
    void mo4878a(SetDrivePreferencesRequest setDrivePreferencesRequest, C0383ac acVar) throws RemoteException;

    /* renamed from: a */
    void mo4879a(SetResourceParentsRequest setResourceParentsRequest, C0383ac acVar) throws RemoteException;

    /* renamed from: a */
    void mo4880a(TrashResourceRequest trashResourceRequest, C0383ac acVar) throws RemoteException;

    /* renamed from: a */
    void mo4881a(UpdateMetadataRequest updateMetadataRequest, C0383ac acVar) throws RemoteException;

    /* renamed from: a */
    void mo4882a(C0383ac acVar) throws RemoteException;

    /* renamed from: b */
    void mo4883b(QueryRequest queryRequest, C0383ac acVar) throws RemoteException;

    /* renamed from: b */
    void mo4884b(C0383ac acVar) throws RemoteException;

    /* renamed from: c */
    void mo4885c(C0383ac acVar) throws RemoteException;

    /* renamed from: d */
    void mo4886d(C0383ac acVar) throws RemoteException;

    /* renamed from: e */
    void mo4887e(C0383ac acVar) throws RemoteException;

    /* renamed from: f */
    void mo4888f(C0383ac acVar) throws RemoteException;

    /* renamed from: g */
    void mo4889g(C0383ac acVar) throws RemoteException;
}
