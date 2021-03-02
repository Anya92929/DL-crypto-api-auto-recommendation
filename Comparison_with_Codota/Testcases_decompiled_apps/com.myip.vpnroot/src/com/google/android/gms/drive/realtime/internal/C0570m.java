package com.google.android.gms.drive.realtime.internal;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.common.data.DataHolder;

/* renamed from: com.google.android.gms.drive.realtime.internal.m */
public interface C0570m extends IInterface {

    /* renamed from: com.google.android.gms.drive.realtime.internal.m$a */
    public static abstract class C0571a extends Binder implements C0570m {

        /* renamed from: com.google.android.gms.drive.realtime.internal.m$a$a */
        private static class C0572a implements C0570m {

            /* renamed from: lb */
            private IBinder f1236lb;

            C0572a(IBinder iBinder) {
                this.f1236lb = iBinder;
            }

            /* renamed from: a */
            public void mo5414a(int i, C0561j jVar) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.drive.realtime.internal.IRealtimeService");
                    obtain.writeInt(i);
                    obtain.writeStrongBinder(jVar != null ? jVar.asBinder() : null);
                    this.f1236lb.transact(30, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            /* renamed from: a */
            public void mo5415a(BeginCompoundOperationRequest beginCompoundOperationRequest, C0576o oVar) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.drive.realtime.internal.IRealtimeService");
                    if (beginCompoundOperationRequest != null) {
                        obtain.writeInt(1);
                        beginCompoundOperationRequest.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    obtain.writeStrongBinder(oVar != null ? oVar.asBinder() : null);
                    this.f1236lb.transact(18, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            /* renamed from: a */
            public void mo5416a(EndCompoundOperationRequest endCompoundOperationRequest, C0561j jVar) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.drive.realtime.internal.IRealtimeService");
                    if (endCompoundOperationRequest != null) {
                        obtain.writeInt(1);
                        endCompoundOperationRequest.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    obtain.writeStrongBinder(jVar != null ? jVar.asBinder() : null);
                    this.f1236lb.transact(41, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            /* renamed from: a */
            public void mo5417a(EndCompoundOperationRequest endCompoundOperationRequest, C0576o oVar) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.drive.realtime.internal.IRealtimeService");
                    if (endCompoundOperationRequest != null) {
                        obtain.writeInt(1);
                        endCompoundOperationRequest.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    obtain.writeStrongBinder(oVar != null ? oVar.asBinder() : null);
                    this.f1236lb.transact(19, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            /* renamed from: a */
            public void mo5418a(ParcelableIndexReference parcelableIndexReference, C0573n nVar) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.drive.realtime.internal.IRealtimeService");
                    if (parcelableIndexReference != null) {
                        obtain.writeInt(1);
                        parcelableIndexReference.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    obtain.writeStrongBinder(nVar != null ? nVar.asBinder() : null);
                    this.f1236lb.transact(26, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            /* renamed from: a */
            public void mo5419a(C0530c cVar) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.drive.realtime.internal.IRealtimeService");
                    obtain.writeStrongBinder(cVar != null ? cVar.asBinder() : null);
                    this.f1236lb.transact(2, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            /* renamed from: a */
            public void mo5420a(C0533d dVar) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.drive.realtime.internal.IRealtimeService");
                    obtain.writeStrongBinder(dVar != null ? dVar.asBinder() : null);
                    this.f1236lb.transact(32, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            /* renamed from: a */
            public void mo5421a(C0536e eVar) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.drive.realtime.internal.IRealtimeService");
                    obtain.writeStrongBinder(eVar != null ? eVar.asBinder() : null);
                    this.f1236lb.transact(31, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            /* renamed from: a */
            public void mo5422a(C0555h hVar) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.drive.realtime.internal.IRealtimeService");
                    obtain.writeStrongBinder(hVar != null ? hVar.asBinder() : null);
                    this.f1236lb.transact(36, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            /* renamed from: a */
            public void mo5423a(C0558i iVar) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.drive.realtime.internal.IRealtimeService");
                    obtain.writeStrongBinder(iVar != null ? iVar.asBinder() : null);
                    this.f1236lb.transact(34, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            /* renamed from: a */
            public void mo5424a(C0561j jVar) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.drive.realtime.internal.IRealtimeService");
                    obtain.writeStrongBinder(jVar != null ? jVar.asBinder() : null);
                    this.f1236lb.transact(22, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            /* renamed from: a */
            public void mo5425a(C0567l lVar) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.drive.realtime.internal.IRealtimeService");
                    obtain.writeStrongBinder(lVar != null ? lVar.asBinder() : null);
                    this.f1236lb.transact(40, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            /* renamed from: a */
            public void mo5426a(C0576o oVar) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.drive.realtime.internal.IRealtimeService");
                    obtain.writeStrongBinder(oVar != null ? oVar.asBinder() : null);
                    this.f1236lb.transact(3, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            /* renamed from: a */
            public void mo5427a(String str, int i, int i2, C0552g gVar) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.drive.realtime.internal.IRealtimeService");
                    obtain.writeString(str);
                    obtain.writeInt(i);
                    obtain.writeInt(i2);
                    obtain.writeStrongBinder(gVar != null ? gVar.asBinder() : null);
                    this.f1236lb.transact(17, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            /* renamed from: a */
            public void mo5428a(String str, int i, int i2, C0561j jVar) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.drive.realtime.internal.IRealtimeService");
                    obtain.writeString(str);
                    obtain.writeInt(i);
                    obtain.writeInt(i2);
                    obtain.writeStrongBinder(jVar != null ? jVar.asBinder() : null);
                    this.f1236lb.transact(11, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            /* renamed from: a */
            public void mo5429a(String str, int i, DataHolder dataHolder, C0552g gVar) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.drive.realtime.internal.IRealtimeService");
                    obtain.writeString(str);
                    obtain.writeInt(i);
                    if (dataHolder != null) {
                        obtain.writeInt(1);
                        dataHolder.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    obtain.writeStrongBinder(gVar != null ? gVar.asBinder() : null);
                    this.f1236lb.transact(16, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            /* renamed from: a */
            public void mo5430a(String str, int i, DataHolder dataHolder, C0561j jVar) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.drive.realtime.internal.IRealtimeService");
                    obtain.writeString(str);
                    obtain.writeInt(i);
                    if (dataHolder != null) {
                        obtain.writeInt(1);
                        dataHolder.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    obtain.writeStrongBinder(jVar != null ? jVar.asBinder() : null);
                    this.f1236lb.transact(15, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            /* renamed from: a */
            public void mo5431a(String str, int i, C0576o oVar) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.drive.realtime.internal.IRealtimeService");
                    obtain.writeString(str);
                    obtain.writeInt(i);
                    obtain.writeStrongBinder(oVar != null ? oVar.asBinder() : null);
                    this.f1236lb.transact(28, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            /* renamed from: a */
            public void mo5432a(String str, int i, String str2, int i2, C0561j jVar) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.drive.realtime.internal.IRealtimeService");
                    obtain.writeString(str);
                    obtain.writeInt(i);
                    obtain.writeString(str2);
                    obtain.writeInt(i2);
                    obtain.writeStrongBinder(jVar != null ? jVar.asBinder() : null);
                    this.f1236lb.transact(37, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            /* renamed from: a */
            public void mo5433a(String str, int i, String str2, C0561j jVar) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.drive.realtime.internal.IRealtimeService");
                    obtain.writeString(str);
                    obtain.writeInt(i);
                    obtain.writeString(str2);
                    obtain.writeStrongBinder(jVar != null ? jVar.asBinder() : null);
                    this.f1236lb.transact(10, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            /* renamed from: a */
            public void mo5434a(String str, DataHolder dataHolder, C0561j jVar) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.drive.realtime.internal.IRealtimeService");
                    obtain.writeString(str);
                    if (dataHolder != null) {
                        obtain.writeInt(1);
                        dataHolder.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    obtain.writeStrongBinder(jVar != null ? jVar.asBinder() : null);
                    this.f1236lb.transact(6, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            /* renamed from: a */
            public void mo5435a(String str, C0549f fVar) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.drive.realtime.internal.IRealtimeService");
                    obtain.writeString(str);
                    obtain.writeStrongBinder(fVar != null ? fVar.asBinder() : null);
                    this.f1236lb.transact(20, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            /* renamed from: a */
            public void mo5436a(String str, C0561j jVar) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.drive.realtime.internal.IRealtimeService");
                    obtain.writeString(str);
                    obtain.writeStrongBinder(jVar != null ? jVar.asBinder() : null);
                    this.f1236lb.transact(7, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            /* renamed from: a */
            public void mo5437a(String str, C0564k kVar) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.drive.realtime.internal.IRealtimeService");
                    obtain.writeString(str);
                    obtain.writeStrongBinder(kVar != null ? kVar.asBinder() : null);
                    this.f1236lb.transact(27, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            /* renamed from: a */
            public void mo5438a(String str, C0567l lVar) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.drive.realtime.internal.IRealtimeService");
                    obtain.writeString(str);
                    obtain.writeStrongBinder(lVar != null ? lVar.asBinder() : null);
                    this.f1236lb.transact(5, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            /* renamed from: a */
            public void mo5439a(String str, C0573n nVar) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.drive.realtime.internal.IRealtimeService");
                    obtain.writeString(str);
                    obtain.writeStrongBinder(nVar != null ? nVar.asBinder() : null);
                    this.f1236lb.transact(1, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            /* renamed from: a */
            public void mo5440a(String str, C0576o oVar) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.drive.realtime.internal.IRealtimeService");
                    obtain.writeString(str);
                    obtain.writeStrongBinder(oVar != null ? oVar.asBinder() : null);
                    this.f1236lb.transact(38, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            /* renamed from: a */
            public void mo5441a(String str, String str2, C0549f fVar) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.drive.realtime.internal.IRealtimeService");
                    obtain.writeString(str);
                    obtain.writeString(str2);
                    obtain.writeStrongBinder(fVar != null ? fVar.asBinder() : null);
                    this.f1236lb.transact(4, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            /* renamed from: a */
            public void mo5442a(String str, String str2, C0552g gVar) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.drive.realtime.internal.IRealtimeService");
                    obtain.writeString(str);
                    obtain.writeString(str2);
                    obtain.writeStrongBinder(gVar != null ? gVar.asBinder() : null);
                    this.f1236lb.transact(21, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            /* renamed from: a */
            public void mo5443a(String str, String str2, C0561j jVar) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.drive.realtime.internal.IRealtimeService");
                    obtain.writeString(str);
                    obtain.writeString(str2);
                    obtain.writeStrongBinder(jVar != null ? jVar.asBinder() : null);
                    this.f1236lb.transact(12, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public IBinder asBinder() {
                return this.f1236lb;
            }

            /* renamed from: b */
            public void mo5444b(C0530c cVar) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.drive.realtime.internal.IRealtimeService");
                    obtain.writeStrongBinder(cVar != null ? cVar.asBinder() : null);
                    this.f1236lb.transact(33, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            /* renamed from: b */
            public void mo5445b(C0561j jVar) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.drive.realtime.internal.IRealtimeService");
                    obtain.writeStrongBinder(jVar != null ? jVar.asBinder() : null);
                    this.f1236lb.transact(23, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            /* renamed from: b */
            public void mo5446b(C0567l lVar) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.drive.realtime.internal.IRealtimeService");
                    obtain.writeStrongBinder(lVar != null ? lVar.asBinder() : null);
                    this.f1236lb.transact(29, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            /* renamed from: b */
            public void mo5447b(C0576o oVar) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.drive.realtime.internal.IRealtimeService");
                    obtain.writeStrongBinder(oVar != null ? oVar.asBinder() : null);
                    this.f1236lb.transact(35, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            /* renamed from: b */
            public void mo5448b(String str, C0549f fVar) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.drive.realtime.internal.IRealtimeService");
                    obtain.writeString(str);
                    obtain.writeStrongBinder(fVar != null ? fVar.asBinder() : null);
                    this.f1236lb.transact(13, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            /* renamed from: b */
            public void mo5449b(String str, C0567l lVar) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.drive.realtime.internal.IRealtimeService");
                    obtain.writeString(str);
                    obtain.writeStrongBinder(lVar != null ? lVar.asBinder() : null);
                    this.f1236lb.transact(8, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            /* renamed from: b */
            public void mo5450b(String str, C0573n nVar) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.drive.realtime.internal.IRealtimeService");
                    obtain.writeString(str);
                    obtain.writeStrongBinder(nVar != null ? nVar.asBinder() : null);
                    this.f1236lb.transact(9, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            /* renamed from: b */
            public void mo5451b(String str, C0576o oVar) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.drive.realtime.internal.IRealtimeService");
                    obtain.writeString(str);
                    obtain.writeStrongBinder(oVar != null ? oVar.asBinder() : null);
                    this.f1236lb.transact(39, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            /* renamed from: c */
            public void mo5452c(C0530c cVar) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.drive.realtime.internal.IRealtimeService");
                    obtain.writeStrongBinder(cVar != null ? cVar.asBinder() : null);
                    this.f1236lb.transact(24, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            /* renamed from: c */
            public void mo5453c(String str, C0567l lVar) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.drive.realtime.internal.IRealtimeService");
                    obtain.writeString(str);
                    obtain.writeStrongBinder(lVar != null ? lVar.asBinder() : null);
                    this.f1236lb.transact(14, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            /* renamed from: d */
            public void mo5454d(C0530c cVar) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.drive.realtime.internal.IRealtimeService");
                    obtain.writeStrongBinder(cVar != null ? cVar.asBinder() : null);
                    this.f1236lb.transact(25, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }
        }

        /* renamed from: ai */
        public static C0570m m1647ai(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.drive.realtime.internal.IRealtimeService");
            return (queryLocalInterface == null || !(queryLocalInterface instanceof C0570m)) ? new C0572a(iBinder) : (C0570m) queryLocalInterface;
        }

        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v1, resolved type: com.google.android.gms.drive.realtime.internal.EndCompoundOperationRequest} */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v41, resolved type: com.google.android.gms.drive.realtime.internal.ParcelableIndexReference} */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v62, resolved type: com.google.android.gms.drive.realtime.internal.EndCompoundOperationRequest} */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v67, resolved type: com.google.android.gms.drive.realtime.internal.BeginCompoundOperationRequest} */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v79, resolved type: com.google.android.gms.common.data.DataHolder} */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v83, resolved type: com.google.android.gms.common.data.DataHolder} */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v117, resolved type: com.google.android.gms.common.data.DataHolder} */
        /* JADX WARNING: type inference failed for: r0v0 */
        /* JADX WARNING: type inference failed for: r0v153 */
        /* JADX WARNING: type inference failed for: r0v154 */
        /* JADX WARNING: type inference failed for: r0v155 */
        /* JADX WARNING: type inference failed for: r0v156 */
        /* JADX WARNING: type inference failed for: r0v157 */
        /* JADX WARNING: type inference failed for: r0v158 */
        /* JADX WARNING: type inference failed for: r0v159 */
        /* JADX WARNING: Multi-variable type inference failed */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public boolean onTransact(int r8, android.os.Parcel r9, android.os.Parcel r10, int r11) throws android.os.RemoteException {
            /*
                r7 = this;
                r0 = 0
                r6 = 1
                switch(r8) {
                    case 1: goto L_0x0011;
                    case 2: goto L_0x002a;
                    case 3: goto L_0x003f;
                    case 4: goto L_0x0094;
                    case 5: goto L_0x00b2;
                    case 6: goto L_0x00cc;
                    case 7: goto L_0x00f2;
                    case 8: goto L_0x0144;
                    case 9: goto L_0x015e;
                    case 10: goto L_0x0178;
                    case 11: goto L_0x019a;
                    case 12: goto L_0x01bc;
                    case 13: goto L_0x01da;
                    case 14: goto L_0x01f4;
                    case 15: goto L_0x020e;
                    case 16: goto L_0x0238;
                    case 17: goto L_0x0262;
                    case 18: goto L_0x02ab;
                    case 19: goto L_0x0463;
                    case 20: goto L_0x010c;
                    case 21: goto L_0x0126;
                    case 22: goto L_0x02f3;
                    case 23: goto L_0x0309;
                    case 24: goto L_0x031f;
                    case 25: goto L_0x0335;
                    case 26: goto L_0x034b;
                    case 27: goto L_0x036f;
                    case 28: goto L_0x0389;
                    case 29: goto L_0x03a7;
                    case 30: goto L_0x03bd;
                    case 31: goto L_0x03d7;
                    case 32: goto L_0x03ed;
                    case 33: goto L_0x0054;
                    case 34: goto L_0x0403;
                    case 35: goto L_0x0069;
                    case 36: goto L_0x0419;
                    case 37: goto L_0x0284;
                    case 38: goto L_0x042f;
                    case 39: goto L_0x0449;
                    case 40: goto L_0x007e;
                    case 41: goto L_0x02cf;
                    case 1598968902: goto L_0x000a;
                    default: goto L_0x0005;
                }
            L_0x0005:
                boolean r0 = super.onTransact(r8, r9, r10, r11)
            L_0x0009:
                return r0
            L_0x000a:
                java.lang.String r0 = "com.google.android.gms.drive.realtime.internal.IRealtimeService"
                r10.writeString(r0)
                r0 = r6
                goto L_0x0009
            L_0x0011:
                java.lang.String r0 = "com.google.android.gms.drive.realtime.internal.IRealtimeService"
                r9.enforceInterface(r0)
                java.lang.String r0 = r9.readString()
                android.os.IBinder r1 = r9.readStrongBinder()
                com.google.android.gms.drive.realtime.internal.n r1 = com.google.android.gms.drive.realtime.internal.C0573n.C0574a.m1691aj(r1)
                r7.mo5439a((java.lang.String) r0, (com.google.android.gms.drive.realtime.internal.C0573n) r1)
                r10.writeNoException()
                r0 = r6
                goto L_0x0009
            L_0x002a:
                java.lang.String r0 = "com.google.android.gms.drive.realtime.internal.IRealtimeService"
                r9.enforceInterface(r0)
                android.os.IBinder r0 = r9.readStrongBinder()
                com.google.android.gms.drive.realtime.internal.c r0 = com.google.android.gms.drive.realtime.internal.C0530c.C0531a.m1532Y(r0)
                r7.mo5419a((com.google.android.gms.drive.realtime.internal.C0530c) r0)
                r10.writeNoException()
                r0 = r6
                goto L_0x0009
            L_0x003f:
                java.lang.String r0 = "com.google.android.gms.drive.realtime.internal.IRealtimeService"
                r9.enforceInterface(r0)
                android.os.IBinder r0 = r9.readStrongBinder()
                com.google.android.gms.drive.realtime.internal.o r0 = com.google.android.gms.drive.realtime.internal.C0576o.C0577a.m1695ak(r0)
                r7.mo5426a((com.google.android.gms.drive.realtime.internal.C0576o) r0)
                r10.writeNoException()
                r0 = r6
                goto L_0x0009
            L_0x0054:
                java.lang.String r0 = "com.google.android.gms.drive.realtime.internal.IRealtimeService"
                r9.enforceInterface(r0)
                android.os.IBinder r0 = r9.readStrongBinder()
                com.google.android.gms.drive.realtime.internal.c r0 = com.google.android.gms.drive.realtime.internal.C0530c.C0531a.m1532Y(r0)
                r7.mo5444b((com.google.android.gms.drive.realtime.internal.C0530c) r0)
                r10.writeNoException()
                r0 = r6
                goto L_0x0009
            L_0x0069:
                java.lang.String r0 = "com.google.android.gms.drive.realtime.internal.IRealtimeService"
                r9.enforceInterface(r0)
                android.os.IBinder r0 = r9.readStrongBinder()
                com.google.android.gms.drive.realtime.internal.o r0 = com.google.android.gms.drive.realtime.internal.C0576o.C0577a.m1695ak(r0)
                r7.mo5447b((com.google.android.gms.drive.realtime.internal.C0576o) r0)
                r10.writeNoException()
                r0 = r6
                goto L_0x0009
            L_0x007e:
                java.lang.String r0 = "com.google.android.gms.drive.realtime.internal.IRealtimeService"
                r9.enforceInterface(r0)
                android.os.IBinder r0 = r9.readStrongBinder()
                com.google.android.gms.drive.realtime.internal.l r0 = com.google.android.gms.drive.realtime.internal.C0567l.C0568a.m1603ah(r0)
                r7.mo5425a((com.google.android.gms.drive.realtime.internal.C0567l) r0)
                r10.writeNoException()
                r0 = r6
                goto L_0x0009
            L_0x0094:
                java.lang.String r0 = "com.google.android.gms.drive.realtime.internal.IRealtimeService"
                r9.enforceInterface(r0)
                java.lang.String r0 = r9.readString()
                java.lang.String r1 = r9.readString()
                android.os.IBinder r2 = r9.readStrongBinder()
                com.google.android.gms.drive.realtime.internal.f r2 = com.google.android.gms.drive.realtime.internal.C0549f.C0550a.m1577ab(r2)
                r7.mo5441a((java.lang.String) r0, (java.lang.String) r1, (com.google.android.gms.drive.realtime.internal.C0549f) r2)
                r10.writeNoException()
                r0 = r6
                goto L_0x0009
            L_0x00b2:
                java.lang.String r0 = "com.google.android.gms.drive.realtime.internal.IRealtimeService"
                r9.enforceInterface(r0)
                java.lang.String r0 = r9.readString()
                android.os.IBinder r1 = r9.readStrongBinder()
                com.google.android.gms.drive.realtime.internal.l r1 = com.google.android.gms.drive.realtime.internal.C0567l.C0568a.m1603ah(r1)
                r7.mo5438a((java.lang.String) r0, (com.google.android.gms.drive.realtime.internal.C0567l) r1)
                r10.writeNoException()
                r0 = r6
                goto L_0x0009
            L_0x00cc:
                java.lang.String r1 = "com.google.android.gms.drive.realtime.internal.IRealtimeService"
                r9.enforceInterface(r1)
                java.lang.String r1 = r9.readString()
                int r2 = r9.readInt()
                if (r2 == 0) goto L_0x00e1
                com.google.android.gms.common.data.f r0 = com.google.android.gms.common.data.DataHolder.CREATOR
                com.google.android.gms.common.data.DataHolder r0 = r0.createFromParcel(r9)
            L_0x00e1:
                android.os.IBinder r2 = r9.readStrongBinder()
                com.google.android.gms.drive.realtime.internal.j r2 = com.google.android.gms.drive.realtime.internal.C0561j.C0562a.m1593af(r2)
                r7.mo5434a((java.lang.String) r1, (com.google.android.gms.common.data.DataHolder) r0, (com.google.android.gms.drive.realtime.internal.C0561j) r2)
                r10.writeNoException()
                r0 = r6
                goto L_0x0009
            L_0x00f2:
                java.lang.String r0 = "com.google.android.gms.drive.realtime.internal.IRealtimeService"
                r9.enforceInterface(r0)
                java.lang.String r0 = r9.readString()
                android.os.IBinder r1 = r9.readStrongBinder()
                com.google.android.gms.drive.realtime.internal.j r1 = com.google.android.gms.drive.realtime.internal.C0561j.C0562a.m1593af(r1)
                r7.mo5436a((java.lang.String) r0, (com.google.android.gms.drive.realtime.internal.C0561j) r1)
                r10.writeNoException()
                r0 = r6
                goto L_0x0009
            L_0x010c:
                java.lang.String r0 = "com.google.android.gms.drive.realtime.internal.IRealtimeService"
                r9.enforceInterface(r0)
                java.lang.String r0 = r9.readString()
                android.os.IBinder r1 = r9.readStrongBinder()
                com.google.android.gms.drive.realtime.internal.f r1 = com.google.android.gms.drive.realtime.internal.C0549f.C0550a.m1577ab(r1)
                r7.mo5435a((java.lang.String) r0, (com.google.android.gms.drive.realtime.internal.C0549f) r1)
                r10.writeNoException()
                r0 = r6
                goto L_0x0009
            L_0x0126:
                java.lang.String r0 = "com.google.android.gms.drive.realtime.internal.IRealtimeService"
                r9.enforceInterface(r0)
                java.lang.String r0 = r9.readString()
                java.lang.String r1 = r9.readString()
                android.os.IBinder r2 = r9.readStrongBinder()
                com.google.android.gms.drive.realtime.internal.g r2 = com.google.android.gms.drive.realtime.internal.C0552g.C0553a.m1582ac(r2)
                r7.mo5442a((java.lang.String) r0, (java.lang.String) r1, (com.google.android.gms.drive.realtime.internal.C0552g) r2)
                r10.writeNoException()
                r0 = r6
                goto L_0x0009
            L_0x0144:
                java.lang.String r0 = "com.google.android.gms.drive.realtime.internal.IRealtimeService"
                r9.enforceInterface(r0)
                java.lang.String r0 = r9.readString()
                android.os.IBinder r1 = r9.readStrongBinder()
                com.google.android.gms.drive.realtime.internal.l r1 = com.google.android.gms.drive.realtime.internal.C0567l.C0568a.m1603ah(r1)
                r7.mo5449b((java.lang.String) r0, (com.google.android.gms.drive.realtime.internal.C0567l) r1)
                r10.writeNoException()
                r0 = r6
                goto L_0x0009
            L_0x015e:
                java.lang.String r0 = "com.google.android.gms.drive.realtime.internal.IRealtimeService"
                r9.enforceInterface(r0)
                java.lang.String r0 = r9.readString()
                android.os.IBinder r1 = r9.readStrongBinder()
                com.google.android.gms.drive.realtime.internal.n r1 = com.google.android.gms.drive.realtime.internal.C0573n.C0574a.m1691aj(r1)
                r7.mo5450b((java.lang.String) r0, (com.google.android.gms.drive.realtime.internal.C0573n) r1)
                r10.writeNoException()
                r0 = r6
                goto L_0x0009
            L_0x0178:
                java.lang.String r0 = "com.google.android.gms.drive.realtime.internal.IRealtimeService"
                r9.enforceInterface(r0)
                java.lang.String r0 = r9.readString()
                int r1 = r9.readInt()
                java.lang.String r2 = r9.readString()
                android.os.IBinder r3 = r9.readStrongBinder()
                com.google.android.gms.drive.realtime.internal.j r3 = com.google.android.gms.drive.realtime.internal.C0561j.C0562a.m1593af(r3)
                r7.mo5433a((java.lang.String) r0, (int) r1, (java.lang.String) r2, (com.google.android.gms.drive.realtime.internal.C0561j) r3)
                r10.writeNoException()
                r0 = r6
                goto L_0x0009
            L_0x019a:
                java.lang.String r0 = "com.google.android.gms.drive.realtime.internal.IRealtimeService"
                r9.enforceInterface(r0)
                java.lang.String r0 = r9.readString()
                int r1 = r9.readInt()
                int r2 = r9.readInt()
                android.os.IBinder r3 = r9.readStrongBinder()
                com.google.android.gms.drive.realtime.internal.j r3 = com.google.android.gms.drive.realtime.internal.C0561j.C0562a.m1593af(r3)
                r7.mo5428a((java.lang.String) r0, (int) r1, (int) r2, (com.google.android.gms.drive.realtime.internal.C0561j) r3)
                r10.writeNoException()
                r0 = r6
                goto L_0x0009
            L_0x01bc:
                java.lang.String r0 = "com.google.android.gms.drive.realtime.internal.IRealtimeService"
                r9.enforceInterface(r0)
                java.lang.String r0 = r9.readString()
                java.lang.String r1 = r9.readString()
                android.os.IBinder r2 = r9.readStrongBinder()
                com.google.android.gms.drive.realtime.internal.j r2 = com.google.android.gms.drive.realtime.internal.C0561j.C0562a.m1593af(r2)
                r7.mo5443a((java.lang.String) r0, (java.lang.String) r1, (com.google.android.gms.drive.realtime.internal.C0561j) r2)
                r10.writeNoException()
                r0 = r6
                goto L_0x0009
            L_0x01da:
                java.lang.String r0 = "com.google.android.gms.drive.realtime.internal.IRealtimeService"
                r9.enforceInterface(r0)
                java.lang.String r0 = r9.readString()
                android.os.IBinder r1 = r9.readStrongBinder()
                com.google.android.gms.drive.realtime.internal.f r1 = com.google.android.gms.drive.realtime.internal.C0549f.C0550a.m1577ab(r1)
                r7.mo5448b((java.lang.String) r0, (com.google.android.gms.drive.realtime.internal.C0549f) r1)
                r10.writeNoException()
                r0 = r6
                goto L_0x0009
            L_0x01f4:
                java.lang.String r0 = "com.google.android.gms.drive.realtime.internal.IRealtimeService"
                r9.enforceInterface(r0)
                java.lang.String r0 = r9.readString()
                android.os.IBinder r1 = r9.readStrongBinder()
                com.google.android.gms.drive.realtime.internal.l r1 = com.google.android.gms.drive.realtime.internal.C0567l.C0568a.m1603ah(r1)
                r7.mo5453c(r0, r1)
                r10.writeNoException()
                r0 = r6
                goto L_0x0009
            L_0x020e:
                java.lang.String r1 = "com.google.android.gms.drive.realtime.internal.IRealtimeService"
                r9.enforceInterface(r1)
                java.lang.String r1 = r9.readString()
                int r2 = r9.readInt()
                int r3 = r9.readInt()
                if (r3 == 0) goto L_0x0227
                com.google.android.gms.common.data.f r0 = com.google.android.gms.common.data.DataHolder.CREATOR
                com.google.android.gms.common.data.DataHolder r0 = r0.createFromParcel(r9)
            L_0x0227:
                android.os.IBinder r3 = r9.readStrongBinder()
                com.google.android.gms.drive.realtime.internal.j r3 = com.google.android.gms.drive.realtime.internal.C0561j.C0562a.m1593af(r3)
                r7.mo5430a((java.lang.String) r1, (int) r2, (com.google.android.gms.common.data.DataHolder) r0, (com.google.android.gms.drive.realtime.internal.C0561j) r3)
                r10.writeNoException()
                r0 = r6
                goto L_0x0009
            L_0x0238:
                java.lang.String r1 = "com.google.android.gms.drive.realtime.internal.IRealtimeService"
                r9.enforceInterface(r1)
                java.lang.String r1 = r9.readString()
                int r2 = r9.readInt()
                int r3 = r9.readInt()
                if (r3 == 0) goto L_0x0251
                com.google.android.gms.common.data.f r0 = com.google.android.gms.common.data.DataHolder.CREATOR
                com.google.android.gms.common.data.DataHolder r0 = r0.createFromParcel(r9)
            L_0x0251:
                android.os.IBinder r3 = r9.readStrongBinder()
                com.google.android.gms.drive.realtime.internal.g r3 = com.google.android.gms.drive.realtime.internal.C0552g.C0553a.m1582ac(r3)
                r7.mo5429a((java.lang.String) r1, (int) r2, (com.google.android.gms.common.data.DataHolder) r0, (com.google.android.gms.drive.realtime.internal.C0552g) r3)
                r10.writeNoException()
                r0 = r6
                goto L_0x0009
            L_0x0262:
                java.lang.String r0 = "com.google.android.gms.drive.realtime.internal.IRealtimeService"
                r9.enforceInterface(r0)
                java.lang.String r0 = r9.readString()
                int r1 = r9.readInt()
                int r2 = r9.readInt()
                android.os.IBinder r3 = r9.readStrongBinder()
                com.google.android.gms.drive.realtime.internal.g r3 = com.google.android.gms.drive.realtime.internal.C0552g.C0553a.m1582ac(r3)
                r7.mo5427a((java.lang.String) r0, (int) r1, (int) r2, (com.google.android.gms.drive.realtime.internal.C0552g) r3)
                r10.writeNoException()
                r0 = r6
                goto L_0x0009
            L_0x0284:
                java.lang.String r0 = "com.google.android.gms.drive.realtime.internal.IRealtimeService"
                r9.enforceInterface(r0)
                java.lang.String r1 = r9.readString()
                int r2 = r9.readInt()
                java.lang.String r3 = r9.readString()
                int r4 = r9.readInt()
                android.os.IBinder r0 = r9.readStrongBinder()
                com.google.android.gms.drive.realtime.internal.j r5 = com.google.android.gms.drive.realtime.internal.C0561j.C0562a.m1593af(r0)
                r0 = r7
                r0.mo5432a(r1, r2, r3, r4, r5)
                r10.writeNoException()
                r0 = r6
                goto L_0x0009
            L_0x02ab:
                java.lang.String r1 = "com.google.android.gms.drive.realtime.internal.IRealtimeService"
                r9.enforceInterface(r1)
                int r1 = r9.readInt()
                if (r1 == 0) goto L_0x02be
                android.os.Parcelable$Creator<com.google.android.gms.drive.realtime.internal.BeginCompoundOperationRequest> r0 = com.google.android.gms.drive.realtime.internal.BeginCompoundOperationRequest.CREATOR
                java.lang.Object r0 = r0.createFromParcel(r9)
                com.google.android.gms.drive.realtime.internal.BeginCompoundOperationRequest r0 = (com.google.android.gms.drive.realtime.internal.BeginCompoundOperationRequest) r0
            L_0x02be:
                android.os.IBinder r1 = r9.readStrongBinder()
                com.google.android.gms.drive.realtime.internal.o r1 = com.google.android.gms.drive.realtime.internal.C0576o.C0577a.m1695ak(r1)
                r7.mo5415a((com.google.android.gms.drive.realtime.internal.BeginCompoundOperationRequest) r0, (com.google.android.gms.drive.realtime.internal.C0576o) r1)
                r10.writeNoException()
                r0 = r6
                goto L_0x0009
            L_0x02cf:
                java.lang.String r1 = "com.google.android.gms.drive.realtime.internal.IRealtimeService"
                r9.enforceInterface(r1)
                int r1 = r9.readInt()
                if (r1 == 0) goto L_0x02e2
                android.os.Parcelable$Creator<com.google.android.gms.drive.realtime.internal.EndCompoundOperationRequest> r0 = com.google.android.gms.drive.realtime.internal.EndCompoundOperationRequest.CREATOR
                java.lang.Object r0 = r0.createFromParcel(r9)
                com.google.android.gms.drive.realtime.internal.EndCompoundOperationRequest r0 = (com.google.android.gms.drive.realtime.internal.EndCompoundOperationRequest) r0
            L_0x02e2:
                android.os.IBinder r1 = r9.readStrongBinder()
                com.google.android.gms.drive.realtime.internal.j r1 = com.google.android.gms.drive.realtime.internal.C0561j.C0562a.m1593af(r1)
                r7.mo5416a((com.google.android.gms.drive.realtime.internal.EndCompoundOperationRequest) r0, (com.google.android.gms.drive.realtime.internal.C0561j) r1)
                r10.writeNoException()
                r0 = r6
                goto L_0x0009
            L_0x02f3:
                java.lang.String r0 = "com.google.android.gms.drive.realtime.internal.IRealtimeService"
                r9.enforceInterface(r0)
                android.os.IBinder r0 = r9.readStrongBinder()
                com.google.android.gms.drive.realtime.internal.j r0 = com.google.android.gms.drive.realtime.internal.C0561j.C0562a.m1593af(r0)
                r7.mo5424a((com.google.android.gms.drive.realtime.internal.C0561j) r0)
                r10.writeNoException()
                r0 = r6
                goto L_0x0009
            L_0x0309:
                java.lang.String r0 = "com.google.android.gms.drive.realtime.internal.IRealtimeService"
                r9.enforceInterface(r0)
                android.os.IBinder r0 = r9.readStrongBinder()
                com.google.android.gms.drive.realtime.internal.j r0 = com.google.android.gms.drive.realtime.internal.C0561j.C0562a.m1593af(r0)
                r7.mo5445b((com.google.android.gms.drive.realtime.internal.C0561j) r0)
                r10.writeNoException()
                r0 = r6
                goto L_0x0009
            L_0x031f:
                java.lang.String r0 = "com.google.android.gms.drive.realtime.internal.IRealtimeService"
                r9.enforceInterface(r0)
                android.os.IBinder r0 = r9.readStrongBinder()
                com.google.android.gms.drive.realtime.internal.c r0 = com.google.android.gms.drive.realtime.internal.C0530c.C0531a.m1532Y(r0)
                r7.mo5452c(r0)
                r10.writeNoException()
                r0 = r6
                goto L_0x0009
            L_0x0335:
                java.lang.String r0 = "com.google.android.gms.drive.realtime.internal.IRealtimeService"
                r9.enforceInterface(r0)
                android.os.IBinder r0 = r9.readStrongBinder()
                com.google.android.gms.drive.realtime.internal.c r0 = com.google.android.gms.drive.realtime.internal.C0530c.C0531a.m1532Y(r0)
                r7.mo5454d(r0)
                r10.writeNoException()
                r0 = r6
                goto L_0x0009
            L_0x034b:
                java.lang.String r1 = "com.google.android.gms.drive.realtime.internal.IRealtimeService"
                r9.enforceInterface(r1)
                int r1 = r9.readInt()
                if (r1 == 0) goto L_0x035e
                android.os.Parcelable$Creator<com.google.android.gms.drive.realtime.internal.ParcelableIndexReference> r0 = com.google.android.gms.drive.realtime.internal.ParcelableIndexReference.CREATOR
                java.lang.Object r0 = r0.createFromParcel(r9)
                com.google.android.gms.drive.realtime.internal.ParcelableIndexReference r0 = (com.google.android.gms.drive.realtime.internal.ParcelableIndexReference) r0
            L_0x035e:
                android.os.IBinder r1 = r9.readStrongBinder()
                com.google.android.gms.drive.realtime.internal.n r1 = com.google.android.gms.drive.realtime.internal.C0573n.C0574a.m1691aj(r1)
                r7.mo5418a((com.google.android.gms.drive.realtime.internal.ParcelableIndexReference) r0, (com.google.android.gms.drive.realtime.internal.C0573n) r1)
                r10.writeNoException()
                r0 = r6
                goto L_0x0009
            L_0x036f:
                java.lang.String r0 = "com.google.android.gms.drive.realtime.internal.IRealtimeService"
                r9.enforceInterface(r0)
                java.lang.String r0 = r9.readString()
                android.os.IBinder r1 = r9.readStrongBinder()
                com.google.android.gms.drive.realtime.internal.k r1 = com.google.android.gms.drive.realtime.internal.C0564k.C0565a.m1598ag(r1)
                r7.mo5437a((java.lang.String) r0, (com.google.android.gms.drive.realtime.internal.C0564k) r1)
                r10.writeNoException()
                r0 = r6
                goto L_0x0009
            L_0x0389:
                java.lang.String r0 = "com.google.android.gms.drive.realtime.internal.IRealtimeService"
                r9.enforceInterface(r0)
                java.lang.String r0 = r9.readString()
                int r1 = r9.readInt()
                android.os.IBinder r2 = r9.readStrongBinder()
                com.google.android.gms.drive.realtime.internal.o r2 = com.google.android.gms.drive.realtime.internal.C0576o.C0577a.m1695ak(r2)
                r7.mo5431a((java.lang.String) r0, (int) r1, (com.google.android.gms.drive.realtime.internal.C0576o) r2)
                r10.writeNoException()
                r0 = r6
                goto L_0x0009
            L_0x03a7:
                java.lang.String r0 = "com.google.android.gms.drive.realtime.internal.IRealtimeService"
                r9.enforceInterface(r0)
                android.os.IBinder r0 = r9.readStrongBinder()
                com.google.android.gms.drive.realtime.internal.l r0 = com.google.android.gms.drive.realtime.internal.C0567l.C0568a.m1603ah(r0)
                r7.mo5446b((com.google.android.gms.drive.realtime.internal.C0567l) r0)
                r10.writeNoException()
                r0 = r6
                goto L_0x0009
            L_0x03bd:
                java.lang.String r0 = "com.google.android.gms.drive.realtime.internal.IRealtimeService"
                r9.enforceInterface(r0)
                int r0 = r9.readInt()
                android.os.IBinder r1 = r9.readStrongBinder()
                com.google.android.gms.drive.realtime.internal.j r1 = com.google.android.gms.drive.realtime.internal.C0561j.C0562a.m1593af(r1)
                r7.mo5414a((int) r0, (com.google.android.gms.drive.realtime.internal.C0561j) r1)
                r10.writeNoException()
                r0 = r6
                goto L_0x0009
            L_0x03d7:
                java.lang.String r0 = "com.google.android.gms.drive.realtime.internal.IRealtimeService"
                r9.enforceInterface(r0)
                android.os.IBinder r0 = r9.readStrongBinder()
                com.google.android.gms.drive.realtime.internal.e r0 = com.google.android.gms.drive.realtime.internal.C0536e.C0537a.m1542aa(r0)
                r7.mo5421a((com.google.android.gms.drive.realtime.internal.C0536e) r0)
                r10.writeNoException()
                r0 = r6
                goto L_0x0009
            L_0x03ed:
                java.lang.String r0 = "com.google.android.gms.drive.realtime.internal.IRealtimeService"
                r9.enforceInterface(r0)
                android.os.IBinder r0 = r9.readStrongBinder()
                com.google.android.gms.drive.realtime.internal.d r0 = com.google.android.gms.drive.realtime.internal.C0533d.C0534a.m1537Z(r0)
                r7.mo5420a((com.google.android.gms.drive.realtime.internal.C0533d) r0)
                r10.writeNoException()
                r0 = r6
                goto L_0x0009
            L_0x0403:
                java.lang.String r0 = "com.google.android.gms.drive.realtime.internal.IRealtimeService"
                r9.enforceInterface(r0)
                android.os.IBinder r0 = r9.readStrongBinder()
                com.google.android.gms.drive.realtime.internal.i r0 = com.google.android.gms.drive.realtime.internal.C0558i.C0559a.m1589ae(r0)
                r7.mo5423a((com.google.android.gms.drive.realtime.internal.C0558i) r0)
                r10.writeNoException()
                r0 = r6
                goto L_0x0009
            L_0x0419:
                java.lang.String r0 = "com.google.android.gms.drive.realtime.internal.IRealtimeService"
                r9.enforceInterface(r0)
                android.os.IBinder r0 = r9.readStrongBinder()
                com.google.android.gms.drive.realtime.internal.h r0 = com.google.android.gms.drive.realtime.internal.C0555h.C0556a.m1586ad(r0)
                r7.mo5422a((com.google.android.gms.drive.realtime.internal.C0555h) r0)
                r10.writeNoException()
                r0 = r6
                goto L_0x0009
            L_0x042f:
                java.lang.String r0 = "com.google.android.gms.drive.realtime.internal.IRealtimeService"
                r9.enforceInterface(r0)
                java.lang.String r0 = r9.readString()
                android.os.IBinder r1 = r9.readStrongBinder()
                com.google.android.gms.drive.realtime.internal.o r1 = com.google.android.gms.drive.realtime.internal.C0576o.C0577a.m1695ak(r1)
                r7.mo5440a((java.lang.String) r0, (com.google.android.gms.drive.realtime.internal.C0576o) r1)
                r10.writeNoException()
                r0 = r6
                goto L_0x0009
            L_0x0449:
                java.lang.String r0 = "com.google.android.gms.drive.realtime.internal.IRealtimeService"
                r9.enforceInterface(r0)
                java.lang.String r0 = r9.readString()
                android.os.IBinder r1 = r9.readStrongBinder()
                com.google.android.gms.drive.realtime.internal.o r1 = com.google.android.gms.drive.realtime.internal.C0576o.C0577a.m1695ak(r1)
                r7.mo5451b((java.lang.String) r0, (com.google.android.gms.drive.realtime.internal.C0576o) r1)
                r10.writeNoException()
                r0 = r6
                goto L_0x0009
            L_0x0463:
                java.lang.String r1 = "com.google.android.gms.drive.realtime.internal.IRealtimeService"
                r9.enforceInterface(r1)
                int r1 = r9.readInt()
                if (r1 == 0) goto L_0x0476
                android.os.Parcelable$Creator<com.google.android.gms.drive.realtime.internal.EndCompoundOperationRequest> r0 = com.google.android.gms.drive.realtime.internal.EndCompoundOperationRequest.CREATOR
                java.lang.Object r0 = r0.createFromParcel(r9)
                com.google.android.gms.drive.realtime.internal.EndCompoundOperationRequest r0 = (com.google.android.gms.drive.realtime.internal.EndCompoundOperationRequest) r0
            L_0x0476:
                android.os.IBinder r1 = r9.readStrongBinder()
                com.google.android.gms.drive.realtime.internal.o r1 = com.google.android.gms.drive.realtime.internal.C0576o.C0577a.m1695ak(r1)
                r7.mo5417a((com.google.android.gms.drive.realtime.internal.EndCompoundOperationRequest) r0, (com.google.android.gms.drive.realtime.internal.C0576o) r1)
                r10.writeNoException()
                r0 = r6
                goto L_0x0009
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.drive.realtime.internal.C0570m.C0571a.onTransact(int, android.os.Parcel, android.os.Parcel, int):boolean");
        }
    }

    /* renamed from: a */
    void mo5414a(int i, C0561j jVar) throws RemoteException;

    /* renamed from: a */
    void mo5415a(BeginCompoundOperationRequest beginCompoundOperationRequest, C0576o oVar) throws RemoteException;

    /* renamed from: a */
    void mo5416a(EndCompoundOperationRequest endCompoundOperationRequest, C0561j jVar) throws RemoteException;

    /* renamed from: a */
    void mo5417a(EndCompoundOperationRequest endCompoundOperationRequest, C0576o oVar) throws RemoteException;

    /* renamed from: a */
    void mo5418a(ParcelableIndexReference parcelableIndexReference, C0573n nVar) throws RemoteException;

    /* renamed from: a */
    void mo5419a(C0530c cVar) throws RemoteException;

    /* renamed from: a */
    void mo5420a(C0533d dVar) throws RemoteException;

    /* renamed from: a */
    void mo5421a(C0536e eVar) throws RemoteException;

    /* renamed from: a */
    void mo5422a(C0555h hVar) throws RemoteException;

    /* renamed from: a */
    void mo5423a(C0558i iVar) throws RemoteException;

    /* renamed from: a */
    void mo5424a(C0561j jVar) throws RemoteException;

    /* renamed from: a */
    void mo5425a(C0567l lVar) throws RemoteException;

    /* renamed from: a */
    void mo5426a(C0576o oVar) throws RemoteException;

    /* renamed from: a */
    void mo5427a(String str, int i, int i2, C0552g gVar) throws RemoteException;

    /* renamed from: a */
    void mo5428a(String str, int i, int i2, C0561j jVar) throws RemoteException;

    /* renamed from: a */
    void mo5429a(String str, int i, DataHolder dataHolder, C0552g gVar) throws RemoteException;

    /* renamed from: a */
    void mo5430a(String str, int i, DataHolder dataHolder, C0561j jVar) throws RemoteException;

    /* renamed from: a */
    void mo5431a(String str, int i, C0576o oVar) throws RemoteException;

    /* renamed from: a */
    void mo5432a(String str, int i, String str2, int i2, C0561j jVar) throws RemoteException;

    /* renamed from: a */
    void mo5433a(String str, int i, String str2, C0561j jVar) throws RemoteException;

    /* renamed from: a */
    void mo5434a(String str, DataHolder dataHolder, C0561j jVar) throws RemoteException;

    /* renamed from: a */
    void mo5435a(String str, C0549f fVar) throws RemoteException;

    /* renamed from: a */
    void mo5436a(String str, C0561j jVar) throws RemoteException;

    /* renamed from: a */
    void mo5437a(String str, C0564k kVar) throws RemoteException;

    /* renamed from: a */
    void mo5438a(String str, C0567l lVar) throws RemoteException;

    /* renamed from: a */
    void mo5439a(String str, C0573n nVar) throws RemoteException;

    /* renamed from: a */
    void mo5440a(String str, C0576o oVar) throws RemoteException;

    /* renamed from: a */
    void mo5441a(String str, String str2, C0549f fVar) throws RemoteException;

    /* renamed from: a */
    void mo5442a(String str, String str2, C0552g gVar) throws RemoteException;

    /* renamed from: a */
    void mo5443a(String str, String str2, C0561j jVar) throws RemoteException;

    /* renamed from: b */
    void mo5444b(C0530c cVar) throws RemoteException;

    /* renamed from: b */
    void mo5445b(C0561j jVar) throws RemoteException;

    /* renamed from: b */
    void mo5446b(C0567l lVar) throws RemoteException;

    /* renamed from: b */
    void mo5447b(C0576o oVar) throws RemoteException;

    /* renamed from: b */
    void mo5448b(String str, C0549f fVar) throws RemoteException;

    /* renamed from: b */
    void mo5449b(String str, C0567l lVar) throws RemoteException;

    /* renamed from: b */
    void mo5450b(String str, C0573n nVar) throws RemoteException;

    /* renamed from: b */
    void mo5451b(String str, C0576o oVar) throws RemoteException;

    /* renamed from: c */
    void mo5452c(C0530c cVar) throws RemoteException;

    /* renamed from: c */
    void mo5453c(String str, C0567l lVar) throws RemoteException;

    /* renamed from: d */
    void mo5454d(C0530c cVar) throws RemoteException;
}
