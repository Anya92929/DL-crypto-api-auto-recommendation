package com.google.android.gms.internal;

import android.net.Uri;
import android.os.Binder;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.ParcelFileDescriptor;
import android.os.RemoteException;
import com.google.android.gms.common.data.C0140d;
import com.google.android.gms.games.GamesClient;

/* renamed from: com.google.android.gms.internal.er */
public interface C0493er extends IInterface {

    /* renamed from: com.google.android.gms.internal.er$a */
    public static abstract class C0494a extends Binder implements C0493er {

        /* renamed from: com.google.android.gms.internal.er$a$a */
        private static class C0495a implements C0493er {

            /* renamed from: dG */
            private IBinder f1267dG;

            C0495a(IBinder iBinder) {
                this.f1267dG = iBinder;
            }

            /* renamed from: L */
            public String mo4614L(String str) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
                    obtain.writeString(str);
                    this.f1267dG.transact(5064, obtain, obtain2, 0);
                    obtain2.readException();
                    return obtain2.readString();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            /* renamed from: M */
            public String mo4615M(String str) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
                    obtain.writeString(str);
                    this.f1267dG.transact(5035, obtain, obtain2, 0);
                    obtain2.readException();
                    return obtain2.readString();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            /* renamed from: N */
            public void mo4616N(String str) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
                    obtain.writeString(str);
                    this.f1267dG.transact(5050, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            /* renamed from: O */
            public int mo4617O(String str) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
                    obtain.writeString(str);
                    this.f1267dG.transact(5060, obtain, obtain2, 0);
                    obtain2.readException();
                    return obtain2.readInt();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            /* renamed from: P */
            public Uri mo4618P(String str) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
                    obtain.writeString(str);
                    this.f1267dG.transact(5066, obtain, obtain2, 0);
                    obtain2.readException();
                    return obtain2.readInt() != 0 ? (Uri) Uri.CREATOR.createFromParcel(obtain2) : null;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            /* renamed from: a */
            public int mo4619a(C0490eq eqVar, byte[] bArr, String str, String str2) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
                    obtain.writeStrongBinder(eqVar != null ? eqVar.asBinder() : null);
                    obtain.writeByteArray(bArr);
                    obtain.writeString(str);
                    obtain.writeString(str2);
                    this.f1267dG.transact(5033, obtain, obtain2, 0);
                    obtain2.readException();
                    return obtain2.readInt();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            /* renamed from: a */
            public void mo4620a(IBinder iBinder, Bundle bundle) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
                    obtain.writeStrongBinder(iBinder);
                    if (bundle != null) {
                        obtain.writeInt(1);
                        bundle.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.f1267dG.transact(5005, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            /* renamed from: a */
            public void mo4621a(C0490eq eqVar) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
                    obtain.writeStrongBinder(eqVar != null ? eqVar.asBinder() : null);
                    this.f1267dG.transact(5002, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            /* renamed from: a */
            public void mo4622a(C0490eq eqVar, int i, int i2, boolean z, boolean z2) throws RemoteException {
                int i3 = 1;
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
                    obtain.writeStrongBinder(eqVar != null ? eqVar.asBinder() : null);
                    obtain.writeInt(i);
                    obtain.writeInt(i2);
                    obtain.writeInt(z ? 1 : 0);
                    if (!z2) {
                        i3 = 0;
                    }
                    obtain.writeInt(i3);
                    this.f1267dG.transact(5044, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            /* renamed from: a */
            public void mo4623a(C0490eq eqVar, int i, boolean z, boolean z2) throws RemoteException {
                int i2 = 1;
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
                    obtain.writeStrongBinder(eqVar != null ? eqVar.asBinder() : null);
                    obtain.writeInt(i);
                    obtain.writeInt(z ? 1 : 0);
                    if (!z2) {
                        i2 = 0;
                    }
                    obtain.writeInt(i2);
                    this.f1267dG.transact(5015, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            /* renamed from: a */
            public void mo4624a(C0490eq eqVar, long j) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
                    obtain.writeStrongBinder(eqVar != null ? eqVar.asBinder() : null);
                    obtain.writeLong(j);
                    this.f1267dG.transact(5058, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            /* renamed from: a */
            public void mo4625a(C0490eq eqVar, Bundle bundle, int i, int i2) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
                    obtain.writeStrongBinder(eqVar != null ? eqVar.asBinder() : null);
                    if (bundle != null) {
                        obtain.writeInt(1);
                        bundle.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    obtain.writeInt(i);
                    obtain.writeInt(i2);
                    this.f1267dG.transact(5021, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            /* renamed from: a */
            public void mo4626a(C0490eq eqVar, IBinder iBinder, int i, String[] strArr, Bundle bundle, boolean z, long j) throws RemoteException {
                int i2 = 1;
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
                    obtain.writeStrongBinder(eqVar != null ? eqVar.asBinder() : null);
                    obtain.writeStrongBinder(iBinder);
                    obtain.writeInt(i);
                    obtain.writeStringArray(strArr);
                    if (bundle != null) {
                        obtain.writeInt(1);
                        bundle.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    if (!z) {
                        i2 = 0;
                    }
                    obtain.writeInt(i2);
                    obtain.writeLong(j);
                    this.f1267dG.transact(5030, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            /* renamed from: a */
            public void mo4627a(C0490eq eqVar, IBinder iBinder, String str, boolean z, long j) throws RemoteException {
                int i = 0;
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
                    obtain.writeStrongBinder(eqVar != null ? eqVar.asBinder() : null);
                    obtain.writeStrongBinder(iBinder);
                    obtain.writeString(str);
                    if (z) {
                        i = 1;
                    }
                    obtain.writeInt(i);
                    obtain.writeLong(j);
                    this.f1267dG.transact(5031, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            /* renamed from: a */
            public void mo4628a(C0490eq eqVar, String str) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
                    obtain.writeStrongBinder(eqVar != null ? eqVar.asBinder() : null);
                    obtain.writeString(str);
                    this.f1267dG.transact(5008, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            /* renamed from: a */
            public void mo4629a(C0490eq eqVar, String str, int i, int i2, int i3, boolean z) throws RemoteException {
                int i4 = 0;
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
                    obtain.writeStrongBinder(eqVar != null ? eqVar.asBinder() : null);
                    obtain.writeString(str);
                    obtain.writeInt(i);
                    obtain.writeInt(i2);
                    obtain.writeInt(i3);
                    if (z) {
                        i4 = 1;
                    }
                    obtain.writeInt(i4);
                    this.f1267dG.transact(5019, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            /* renamed from: a */
            public void mo4630a(C0490eq eqVar, String str, int i, IBinder iBinder, Bundle bundle) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
                    obtain.writeStrongBinder(eqVar != null ? eqVar.asBinder() : null);
                    obtain.writeString(str);
                    obtain.writeInt(i);
                    obtain.writeStrongBinder(iBinder);
                    if (bundle != null) {
                        obtain.writeInt(1);
                        bundle.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.f1267dG.transact(5025, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            /* renamed from: a */
            public void mo4631a(C0490eq eqVar, String str, int i, boolean z, boolean z2) throws RemoteException {
                int i2 = 1;
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
                    obtain.writeStrongBinder(eqVar != null ? eqVar.asBinder() : null);
                    obtain.writeString(str);
                    obtain.writeInt(i);
                    obtain.writeInt(z ? 1 : 0);
                    if (!z2) {
                        i2 = 0;
                    }
                    obtain.writeInt(i2);
                    this.f1267dG.transact(5045, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            /* renamed from: a */
            public void mo4632a(C0490eq eqVar, String str, int i, boolean z, boolean z2, boolean z3, boolean z4) throws RemoteException {
                int i2 = 1;
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
                    obtain.writeStrongBinder(eqVar != null ? eqVar.asBinder() : null);
                    obtain.writeString(str);
                    obtain.writeInt(i);
                    obtain.writeInt(z ? 1 : 0);
                    obtain.writeInt(z2 ? 1 : 0);
                    obtain.writeInt(z3 ? 1 : 0);
                    if (!z4) {
                        i2 = 0;
                    }
                    obtain.writeInt(i2);
                    this.f1267dG.transact(6501, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            /* renamed from: a */
            public void mo4633a(C0490eq eqVar, String str, long j) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
                    obtain.writeStrongBinder(eqVar != null ? eqVar.asBinder() : null);
                    obtain.writeString(str);
                    obtain.writeLong(j);
                    this.f1267dG.transact(5016, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            /* renamed from: a */
            public void mo4634a(C0490eq eqVar, String str, long j, String str2) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
                    obtain.writeStrongBinder(eqVar != null ? eqVar.asBinder() : null);
                    obtain.writeString(str);
                    obtain.writeLong(j);
                    obtain.writeString(str2);
                    this.f1267dG.transact(GamesClient.STATUS_INVALID_REAL_TIME_ROOM_ID, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            /* renamed from: a */
            public void mo4635a(C0490eq eqVar, String str, IBinder iBinder, Bundle bundle) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
                    obtain.writeStrongBinder(eqVar != null ? eqVar.asBinder() : null);
                    obtain.writeString(str);
                    obtain.writeStrongBinder(iBinder);
                    if (bundle != null) {
                        obtain.writeInt(1);
                        bundle.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.f1267dG.transact(5023, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            /* renamed from: a */
            public void mo4636a(C0490eq eqVar, String str, String str2) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
                    obtain.writeStrongBinder(eqVar != null ? eqVar.asBinder() : null);
                    obtain.writeString(str);
                    obtain.writeString(str2);
                    this.f1267dG.transact(5009, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            /* renamed from: a */
            public void mo4637a(C0490eq eqVar, String str, String str2, int i, int i2, int i3, boolean z) throws RemoteException {
                int i4 = 0;
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
                    obtain.writeStrongBinder(eqVar != null ? eqVar.asBinder() : null);
                    obtain.writeString(str);
                    obtain.writeString(str2);
                    obtain.writeInt(i);
                    obtain.writeInt(i2);
                    obtain.writeInt(i3);
                    if (z) {
                        i4 = 1;
                    }
                    obtain.writeInt(i4);
                    this.f1267dG.transact(5039, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            /* renamed from: a */
            public void mo4638a(C0490eq eqVar, String str, String str2, boolean z) throws RemoteException {
                int i = 0;
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
                    obtain.writeStrongBinder(eqVar != null ? eqVar.asBinder() : null);
                    obtain.writeString(str);
                    obtain.writeString(str2);
                    if (z) {
                        i = 1;
                    }
                    obtain.writeInt(i);
                    this.f1267dG.transact(6002, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            /* renamed from: a */
            public void mo4639a(C0490eq eqVar, String str, boolean z) throws RemoteException {
                int i = 0;
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
                    obtain.writeStrongBinder(eqVar != null ? eqVar.asBinder() : null);
                    obtain.writeString(str);
                    if (z) {
                        i = 1;
                    }
                    obtain.writeInt(i);
                    this.f1267dG.transact(5054, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            /* renamed from: a */
            public void mo4640a(C0490eq eqVar, String str, boolean z, long[] jArr) throws RemoteException {
                int i = 0;
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
                    obtain.writeStrongBinder(eqVar != null ? eqVar.asBinder() : null);
                    obtain.writeString(str);
                    if (z) {
                        i = 1;
                    }
                    obtain.writeInt(i);
                    obtain.writeLongArray(jArr);
                    this.f1267dG.transact(5011, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            /* renamed from: a */
            public void mo4641a(C0490eq eqVar, boolean z) throws RemoteException {
                int i = 0;
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
                    obtain.writeStrongBinder(eqVar != null ? eqVar.asBinder() : null);
                    if (z) {
                        i = 1;
                    }
                    obtain.writeInt(i);
                    this.f1267dG.transact(5063, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            /* renamed from: a */
            public void mo4642a(String str, String str2, int i) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
                    obtain.writeString(str);
                    obtain.writeString(str2);
                    obtain.writeInt(i);
                    this.f1267dG.transact(5051, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public IBinder asBinder() {
                return this.f1267dG;
            }

            /* renamed from: b */
            public int mo4643b(byte[] bArr, String str, String[] strArr) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
                    obtain.writeByteArray(bArr);
                    obtain.writeString(str);
                    obtain.writeStringArray(strArr);
                    this.f1267dG.transact(5034, obtain, obtain2, 0);
                    obtain2.readException();
                    return obtain2.readInt();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            /* renamed from: b */
            public void mo4644b(C0490eq eqVar) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
                    obtain.writeStrongBinder(eqVar != null ? eqVar.asBinder() : null);
                    this.f1267dG.transact(5017, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            /* renamed from: b */
            public void mo4645b(C0490eq eqVar, int i, boolean z, boolean z2) throws RemoteException {
                int i2 = 1;
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
                    obtain.writeStrongBinder(eqVar != null ? eqVar.asBinder() : null);
                    obtain.writeInt(i);
                    obtain.writeInt(z ? 1 : 0);
                    if (!z2) {
                        i2 = 0;
                    }
                    obtain.writeInt(i2);
                    this.f1267dG.transact(5046, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            /* renamed from: b */
            public void mo4646b(C0490eq eqVar, String str) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
                    obtain.writeStrongBinder(eqVar != null ? eqVar.asBinder() : null);
                    obtain.writeString(str);
                    this.f1267dG.transact(5010, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            /* renamed from: b */
            public void mo4647b(C0490eq eqVar, String str, int i, int i2, int i3, boolean z) throws RemoteException {
                int i4 = 0;
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
                    obtain.writeStrongBinder(eqVar != null ? eqVar.asBinder() : null);
                    obtain.writeString(str);
                    obtain.writeInt(i);
                    obtain.writeInt(i2);
                    obtain.writeInt(i3);
                    if (z) {
                        i4 = 1;
                    }
                    obtain.writeInt(i4);
                    this.f1267dG.transact(5020, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            /* renamed from: b */
            public void mo4648b(C0490eq eqVar, String str, int i, IBinder iBinder, Bundle bundle) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
                    obtain.writeStrongBinder(eqVar != null ? eqVar.asBinder() : null);
                    obtain.writeString(str);
                    obtain.writeInt(i);
                    obtain.writeStrongBinder(iBinder);
                    if (bundle != null) {
                        obtain.writeInt(1);
                        bundle.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.f1267dG.transact(GamesClient.STATUS_PARTICIPANT_NOT_CONNECTED, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            /* renamed from: b */
            public void mo4649b(C0490eq eqVar, String str, int i, boolean z, boolean z2) throws RemoteException {
                int i2 = 1;
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
                    obtain.writeStrongBinder(eqVar != null ? eqVar.asBinder() : null);
                    obtain.writeString(str);
                    obtain.writeInt(i);
                    obtain.writeInt(z ? 1 : 0);
                    if (!z2) {
                        i2 = 0;
                    }
                    obtain.writeInt(i2);
                    this.f1267dG.transact(5501, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            /* renamed from: b */
            public void mo4650b(C0490eq eqVar, String str, IBinder iBinder, Bundle bundle) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
                    obtain.writeStrongBinder(eqVar != null ? eqVar.asBinder() : null);
                    obtain.writeString(str);
                    obtain.writeStrongBinder(iBinder);
                    if (bundle != null) {
                        obtain.writeInt(1);
                        bundle.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.f1267dG.transact(5024, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            /* renamed from: b */
            public void mo4651b(C0490eq eqVar, String str, String str2) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
                    obtain.writeStrongBinder(eqVar != null ? eqVar.asBinder() : null);
                    obtain.writeString(str);
                    obtain.writeString(str2);
                    this.f1267dG.transact(5038, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            /* renamed from: b */
            public void mo4652b(C0490eq eqVar, String str, String str2, int i, int i2, int i3, boolean z) throws RemoteException {
                int i4 = 0;
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
                    obtain.writeStrongBinder(eqVar != null ? eqVar.asBinder() : null);
                    obtain.writeString(str);
                    obtain.writeString(str2);
                    obtain.writeInt(i);
                    obtain.writeInt(i2);
                    obtain.writeInt(i3);
                    if (z) {
                        i4 = 1;
                    }
                    obtain.writeInt(i4);
                    this.f1267dG.transact(5040, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            /* renamed from: b */
            public void mo4653b(C0490eq eqVar, String str, String str2, boolean z) throws RemoteException {
                int i = 0;
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
                    obtain.writeStrongBinder(eqVar != null ? eqVar.asBinder() : null);
                    obtain.writeString(str);
                    obtain.writeString(str2);
                    if (z) {
                        i = 1;
                    }
                    obtain.writeInt(i);
                    this.f1267dG.transact(6506, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            /* renamed from: b */
            public void mo4654b(C0490eq eqVar, String str, boolean z) throws RemoteException {
                int i = 0;
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
                    obtain.writeStrongBinder(eqVar != null ? eqVar.asBinder() : null);
                    obtain.writeString(str);
                    if (z) {
                        i = 1;
                    }
                    obtain.writeInt(i);
                    this.f1267dG.transact(6502, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            /* renamed from: b */
            public void mo4655b(C0490eq eqVar, boolean z) throws RemoteException {
                int i = 0;
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
                    obtain.writeStrongBinder(eqVar != null ? eqVar.asBinder() : null);
                    if (z) {
                        i = 1;
                    }
                    obtain.writeInt(i);
                    this.f1267dG.transact(GamesClient.STATUS_MULTIPLAYER_ERROR_NOT_TRUSTED_TESTER, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            /* renamed from: bT */
            public void mo4656bT() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
                    this.f1267dG.transact(5006, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            /* renamed from: bU */
            public C0140d mo4657bU() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
                    this.f1267dG.transact(5013, obtain, obtain2, 0);
                    obtain2.readException();
                    return obtain2.readInt() != 0 ? C0140d.CREATOR.createFromParcel(obtain2) : null;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            /* renamed from: bV */
            public boolean mo4658bV() throws RemoteException {
                boolean z = false;
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
                    this.f1267dG.transact(5067, obtain, obtain2, 0);
                    obtain2.readException();
                    if (obtain2.readInt() != 0) {
                        z = true;
                    }
                    return z;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            /* renamed from: bW */
            public C0140d mo4659bW() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
                    this.f1267dG.transact(5502, obtain, obtain2, 0);
                    obtain2.readException();
                    return obtain2.readInt() != 0 ? C0140d.CREATOR.createFromParcel(obtain2) : null;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            /* renamed from: ba */
            public Bundle mo4660ba() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
                    this.f1267dG.transact(5004, obtain, obtain2, 0);
                    obtain2.readException();
                    return obtain2.readInt() != 0 ? (Bundle) Bundle.CREATOR.createFromParcel(obtain2) : null;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            /* renamed from: c */
            public void mo4661c(C0490eq eqVar) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
                    obtain.writeStrongBinder(eqVar != null ? eqVar.asBinder() : null);
                    this.f1267dG.transact(5022, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            /* renamed from: c */
            public void mo4662c(C0490eq eqVar, int i, boolean z, boolean z2) throws RemoteException {
                int i2 = 1;
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
                    obtain.writeStrongBinder(eqVar != null ? eqVar.asBinder() : null);
                    obtain.writeInt(i);
                    obtain.writeInt(z ? 1 : 0);
                    if (!z2) {
                        i2 = 0;
                    }
                    obtain.writeInt(i2);
                    this.f1267dG.transact(5048, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            /* renamed from: c */
            public void mo4663c(C0490eq eqVar, String str) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
                    obtain.writeStrongBinder(eqVar != null ? eqVar.asBinder() : null);
                    obtain.writeString(str);
                    this.f1267dG.transact(5014, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            /* renamed from: c */
            public void mo4664c(C0490eq eqVar, String str, String str2) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
                    obtain.writeStrongBinder(eqVar != null ? eqVar.asBinder() : null);
                    obtain.writeString(str);
                    obtain.writeString(str2);
                    this.f1267dG.transact(5041, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            /* renamed from: c */
            public void mo4665c(C0490eq eqVar, String str, boolean z) throws RemoteException {
                int i = 0;
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
                    obtain.writeStrongBinder(eqVar != null ? eqVar.asBinder() : null);
                    obtain.writeString(str);
                    if (z) {
                        i = 1;
                    }
                    obtain.writeInt(i);
                    this.f1267dG.transact(6504, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            /* renamed from: c */
            public void mo4666c(C0490eq eqVar, boolean z) throws RemoteException {
                int i = 0;
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
                    obtain.writeStrongBinder(eqVar != null ? eqVar.asBinder() : null);
                    if (z) {
                        i = 1;
                    }
                    obtain.writeInt(i);
                    this.f1267dG.transact(6503, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void clearNotifications(int notificationTypes) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
                    obtain.writeInt(notificationTypes);
                    this.f1267dG.transact(5036, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            /* renamed from: d */
            public void mo4668d(C0490eq eqVar) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
                    obtain.writeStrongBinder(eqVar != null ? eqVar.asBinder() : null);
                    this.f1267dG.transact(5026, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            /* renamed from: d */
            public void mo4669d(C0490eq eqVar, int i, boolean z, boolean z2) throws RemoteException {
                int i2 = 1;
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
                    obtain.writeStrongBinder(eqVar != null ? eqVar.asBinder() : null);
                    obtain.writeInt(i);
                    obtain.writeInt(z ? 1 : 0);
                    if (!z2) {
                        i2 = 0;
                    }
                    obtain.writeInt(i2);
                    this.f1267dG.transact(6003, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            /* renamed from: d */
            public void mo4670d(C0490eq eqVar, String str) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
                    obtain.writeStrongBinder(eqVar != null ? eqVar.asBinder() : null);
                    obtain.writeString(str);
                    this.f1267dG.transact(5018, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            /* renamed from: d */
            public void mo4671d(C0490eq eqVar, String str, boolean z) throws RemoteException {
                int i = 0;
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
                    obtain.writeStrongBinder(eqVar != null ? eqVar.asBinder() : null);
                    obtain.writeString(str);
                    if (z) {
                        i = 1;
                    }
                    obtain.writeInt(i);
                    this.f1267dG.transact(6505, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            /* renamed from: e */
            public ParcelFileDescriptor mo4672e(Uri uri) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
                    if (uri != null) {
                        obtain.writeInt(1);
                        uri.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.f1267dG.transact(6507, obtain, obtain2, 0);
                    obtain2.readException();
                    return obtain2.readInt() != 0 ? (ParcelFileDescriptor) ParcelFileDescriptor.CREATOR.createFromParcel(obtain2) : null;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            /* renamed from: e */
            public void mo4673e(C0490eq eqVar) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
                    obtain.writeStrongBinder(eqVar != null ? eqVar.asBinder() : null);
                    this.f1267dG.transact(5027, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            /* renamed from: e */
            public void mo4674e(C0490eq eqVar, int i, boolean z, boolean z2) throws RemoteException {
                int i2 = 1;
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
                    obtain.writeStrongBinder(eqVar != null ? eqVar.asBinder() : null);
                    obtain.writeInt(i);
                    obtain.writeInt(z ? 1 : 0);
                    if (!z2) {
                        i2 = 0;
                    }
                    obtain.writeInt(i2);
                    this.f1267dG.transact(6004, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            /* renamed from: e */
            public void mo4675e(C0490eq eqVar, String str) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
                    obtain.writeStrongBinder(eqVar != null ? eqVar.asBinder() : null);
                    obtain.writeString(str);
                    this.f1267dG.transact(5032, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            /* renamed from: f */
            public void mo4676f(long j) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
                    obtain.writeLong(j);
                    this.f1267dG.transact(5001, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            /* renamed from: f */
            public void mo4677f(C0490eq eqVar) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
                    obtain.writeStrongBinder(eqVar != null ? eqVar.asBinder() : null);
                    this.f1267dG.transact(5047, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            /* renamed from: f */
            public void mo4678f(C0490eq eqVar, String str) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
                    obtain.writeStrongBinder(eqVar != null ? eqVar.asBinder() : null);
                    obtain.writeString(str);
                    this.f1267dG.transact(5037, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            /* renamed from: f */
            public void mo4679f(String str, String str2) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
                    obtain.writeString(str);
                    obtain.writeString(str2);
                    this.f1267dG.transact(5065, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            /* renamed from: g */
            public void mo4680g(long j) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
                    obtain.writeLong(j);
                    this.f1267dG.transact(5059, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            /* renamed from: g */
            public void mo4681g(C0490eq eqVar) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
                    obtain.writeStrongBinder(eqVar != null ? eqVar.asBinder() : null);
                    this.f1267dG.transact(5049, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            /* renamed from: g */
            public void mo4682g(C0490eq eqVar, String str) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
                    obtain.writeStrongBinder(eqVar != null ? eqVar.asBinder() : null);
                    obtain.writeString(str);
                    this.f1267dG.transact(5042, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public String getAppId() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
                    this.f1267dG.transact(5003, obtain, obtain2, 0);
                    obtain2.readException();
                    return obtain2.readString();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public String getCurrentAccountName() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
                    this.f1267dG.transact(5007, obtain, obtain2, 0);
                    obtain2.readException();
                    return obtain2.readString();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public String getCurrentPlayerId() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
                    this.f1267dG.transact(5012, obtain, obtain2, 0);
                    obtain2.readException();
                    return obtain2.readString();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            /* renamed from: h */
            public void mo4686h(C0490eq eqVar) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
                    obtain.writeStrongBinder(eqVar != null ? eqVar.asBinder() : null);
                    this.f1267dG.transact(5056, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            /* renamed from: h */
            public void mo4687h(C0490eq eqVar, String str) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
                    obtain.writeStrongBinder(eqVar != null ? eqVar.asBinder() : null);
                    obtain.writeString(str);
                    this.f1267dG.transact(5043, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            /* renamed from: i */
            public void mo4688i(C0490eq eqVar) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
                    obtain.writeStrongBinder(eqVar != null ? eqVar.asBinder() : null);
                    this.f1267dG.transact(5062, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            /* renamed from: i */
            public void mo4689i(C0490eq eqVar, String str) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
                    obtain.writeStrongBinder(eqVar != null ? eqVar.asBinder() : null);
                    obtain.writeString(str);
                    this.f1267dG.transact(5052, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            /* renamed from: i */
            public void mo4690i(String str, int i) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
                    obtain.writeString(str);
                    obtain.writeInt(i);
                    this.f1267dG.transact(5029, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            /* renamed from: j */
            public int mo4691j(C0490eq eqVar, String str) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
                    obtain.writeStrongBinder(eqVar != null ? eqVar.asBinder() : null);
                    obtain.writeString(str);
                    this.f1267dG.transact(5053, obtain, obtain2, 0);
                    obtain2.readException();
                    return obtain2.readInt();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            /* renamed from: j */
            public void mo4692j(String str, int i) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
                    obtain.writeString(str);
                    obtain.writeInt(i);
                    this.f1267dG.transact(5028, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            /* renamed from: k */
            public void mo4693k(C0490eq eqVar, String str) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
                    obtain.writeStrongBinder(eqVar != null ? eqVar.asBinder() : null);
                    obtain.writeString(str);
                    this.f1267dG.transact(5061, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            /* renamed from: k */
            public void mo4694k(String str, int i) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
                    obtain.writeString(str);
                    obtain.writeInt(i);
                    this.f1267dG.transact(5055, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            /* renamed from: l */
            public void mo4695l(C0490eq eqVar, String str) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
                    obtain.writeStrongBinder(eqVar != null ? eqVar.asBinder() : null);
                    obtain.writeString(str);
                    this.f1267dG.transact(5057, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            /* renamed from: m */
            public void mo4696m(C0490eq eqVar, String str) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
                    obtain.writeStrongBinder(eqVar != null ? eqVar.asBinder() : null);
                    obtain.writeString(str);
                    this.f1267dG.transact(GamesClient.STATUS_REAL_TIME_MESSAGE_SEND_FAILED, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void setUseNewPlayerNotificationsFirstParty(boolean newPlayerStyle) throws RemoteException {
                int i = 0;
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
                    if (newPlayerStyle) {
                        i = 1;
                    }
                    obtain.writeInt(i);
                    this.f1267dG.transact(5068, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }
        }

        /* renamed from: C */
        public static C0493er m1396C(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.games.internal.IGamesService");
            return (queryLocalInterface == null || !(queryLocalInterface instanceof C0493er)) ? new C0495a(iBinder) : (C0493er) queryLocalInterface;
        }

        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v11, resolved type: android.net.Uri} */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v198, resolved type: android.os.Bundle} */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v202, resolved type: android.os.Bundle} */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v209, resolved type: android.os.Bundle} */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v266, resolved type: android.os.Bundle} */
        /* JADX WARNING: type inference failed for: r0v0 */
        /* JADX WARNING: type inference failed for: r0v280 */
        /* JADX WARNING: type inference failed for: r0v281 */
        /* JADX WARNING: type inference failed for: r0v282 */
        /* JADX WARNING: type inference failed for: r0v283 */
        /* JADX WARNING: type inference failed for: r0v284 */
        /* JADX WARNING: Multi-variable type inference failed */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public boolean onTransact(int r11, android.os.Parcel r12, android.os.Parcel r13, int r14) throws android.os.RemoteException {
            /*
                r10 = this;
                r0 = 0
                r7 = 0
                r9 = 1
                switch(r11) {
                    case 5001: goto L_0x0011;
                    case 5002: goto L_0x0021;
                    case 5003: goto L_0x0035;
                    case 5004: goto L_0x0045;
                    case 5005: goto L_0x005e;
                    case 5006: goto L_0x007c;
                    case 5007: goto L_0x0088;
                    case 5008: goto L_0x00c3;
                    case 5009: goto L_0x00dc;
                    case 5010: goto L_0x00f9;
                    case 5011: goto L_0x0112;
                    case 5012: goto L_0x0138;
                    case 5013: goto L_0x0149;
                    case 5014: goto L_0x0164;
                    case 5015: goto L_0x017d;
                    case 5016: goto L_0x01a6;
                    case 5017: goto L_0x01c3;
                    case 5018: goto L_0x01d8;
                    case 5019: goto L_0x01f1;
                    case 5020: goto L_0x0220;
                    case 5021: goto L_0x024f;
                    case 5022: goto L_0x027a;
                    case 5023: goto L_0x028f;
                    case 5024: goto L_0x02ba;
                    case 5025: goto L_0x02e5;
                    case 5026: goto L_0x0318;
                    case 5027: goto L_0x032d;
                    case 5028: goto L_0x0342;
                    case 5029: goto L_0x0357;
                    case 5030: goto L_0x0396;
                    case 5031: goto L_0x03d6;
                    case 5032: goto L_0x0401;
                    case 5033: goto L_0x041a;
                    case 5034: goto L_0x043f;
                    case 5035: goto L_0x045c;
                    case 5036: goto L_0x0471;
                    case 5037: goto L_0x0482;
                    case 5038: goto L_0x049b;
                    case 5039: goto L_0x04b8;
                    case 5040: goto L_0x04e9;
                    case 5041: goto L_0x051a;
                    case 5042: goto L_0x0537;
                    case 5043: goto L_0x0550;
                    case 5044: goto L_0x0569;
                    case 5045: goto L_0x0599;
                    case 5046: goto L_0x05c9;
                    case 5047: goto L_0x05f2;
                    case 5048: goto L_0x0607;
                    case 5049: goto L_0x0630;
                    case 5050: goto L_0x0645;
                    case 5051: goto L_0x0656;
                    case 5052: goto L_0x066f;
                    case 5053: goto L_0x0688;
                    case 5054: goto L_0x06ba;
                    case 5055: goto L_0x06f3;
                    case 5056: goto L_0x0730;
                    case 5057: goto L_0x0745;
                    case 5058: goto L_0x036c;
                    case 5059: goto L_0x0385;
                    case 5060: goto L_0x06a5;
                    case 5061: goto L_0x06da;
                    case 5062: goto L_0x075e;
                    case 5063: goto L_0x0773;
                    case 5064: goto L_0x0099;
                    case 5065: goto L_0x00ae;
                    case 5066: goto L_0x078f;
                    case 5067: goto L_0x0708;
                    case 5068: goto L_0x071c;
                    case 5501: goto L_0x07ae;
                    case 5502: goto L_0x07de;
                    case 6001: goto L_0x07f9;
                    case 6002: goto L_0x0815;
                    case 6003: goto L_0x0839;
                    case 6004: goto L_0x0862;
                    case 6501: goto L_0x088b;
                    case 6502: goto L_0x08cb;
                    case 6503: goto L_0x08eb;
                    case 6504: goto L_0x0907;
                    case 6505: goto L_0x0927;
                    case 6506: goto L_0x0947;
                    case 6507: goto L_0x096b;
                    case 7001: goto L_0x0994;
                    case 7002: goto L_0x09ad;
                    case 7003: goto L_0x09cf;
                    case 1598968902: goto L_0x000b;
                    default: goto L_0x0006;
                }
            L_0x0006:
                boolean r9 = super.onTransact(r11, r12, r13, r14)
            L_0x000a:
                return r9
            L_0x000b:
                java.lang.String r0 = "com.google.android.gms.games.internal.IGamesService"
                r13.writeString(r0)
                goto L_0x000a
            L_0x0011:
                java.lang.String r0 = "com.google.android.gms.games.internal.IGamesService"
                r12.enforceInterface(r0)
                long r0 = r12.readLong()
                r10.mo4676f((long) r0)
                r13.writeNoException()
                goto L_0x000a
            L_0x0021:
                java.lang.String r0 = "com.google.android.gms.games.internal.IGamesService"
                r12.enforceInterface(r0)
                android.os.IBinder r0 = r12.readStrongBinder()
                com.google.android.gms.internal.eq r0 = com.google.android.gms.internal.C0490eq.C0491a.m1280B(r0)
                r10.mo4621a(r0)
                r13.writeNoException()
                goto L_0x000a
            L_0x0035:
                java.lang.String r0 = "com.google.android.gms.games.internal.IGamesService"
                r12.enforceInterface(r0)
                java.lang.String r0 = r10.getAppId()
                r13.writeNoException()
                r13.writeString(r0)
                goto L_0x000a
            L_0x0045:
                java.lang.String r0 = "com.google.android.gms.games.internal.IGamesService"
                r12.enforceInterface(r0)
                android.os.Bundle r0 = r10.mo4660ba()
                r13.writeNoException()
                if (r0 == 0) goto L_0x005a
                r13.writeInt(r9)
                r0.writeToParcel(r13, r9)
                goto L_0x000a
            L_0x005a:
                r13.writeInt(r7)
                goto L_0x000a
            L_0x005e:
                java.lang.String r1 = "com.google.android.gms.games.internal.IGamesService"
                r12.enforceInterface(r1)
                android.os.IBinder r1 = r12.readStrongBinder()
                int r2 = r12.readInt()
                if (r2 == 0) goto L_0x0075
                android.os.Parcelable$Creator r0 = android.os.Bundle.CREATOR
                java.lang.Object r0 = r0.createFromParcel(r12)
                android.os.Bundle r0 = (android.os.Bundle) r0
            L_0x0075:
                r10.mo4620a((android.os.IBinder) r1, (android.os.Bundle) r0)
                r13.writeNoException()
                goto L_0x000a
            L_0x007c:
                java.lang.String r0 = "com.google.android.gms.games.internal.IGamesService"
                r12.enforceInterface(r0)
                r10.mo4656bT()
                r13.writeNoException()
                goto L_0x000a
            L_0x0088:
                java.lang.String r0 = "com.google.android.gms.games.internal.IGamesService"
                r12.enforceInterface(r0)
                java.lang.String r0 = r10.getCurrentAccountName()
                r13.writeNoException()
                r13.writeString(r0)
                goto L_0x000a
            L_0x0099:
                java.lang.String r0 = "com.google.android.gms.games.internal.IGamesService"
                r12.enforceInterface(r0)
                java.lang.String r0 = r12.readString()
                java.lang.String r0 = r10.mo4614L(r0)
                r13.writeNoException()
                r13.writeString(r0)
                goto L_0x000a
            L_0x00ae:
                java.lang.String r0 = "com.google.android.gms.games.internal.IGamesService"
                r12.enforceInterface(r0)
                java.lang.String r0 = r12.readString()
                java.lang.String r1 = r12.readString()
                r10.mo4679f((java.lang.String) r0, (java.lang.String) r1)
                r13.writeNoException()
                goto L_0x000a
            L_0x00c3:
                java.lang.String r0 = "com.google.android.gms.games.internal.IGamesService"
                r12.enforceInterface(r0)
                android.os.IBinder r0 = r12.readStrongBinder()
                com.google.android.gms.internal.eq r0 = com.google.android.gms.internal.C0490eq.C0491a.m1280B(r0)
                java.lang.String r1 = r12.readString()
                r10.mo4628a((com.google.android.gms.internal.C0490eq) r0, (java.lang.String) r1)
                r13.writeNoException()
                goto L_0x000a
            L_0x00dc:
                java.lang.String r0 = "com.google.android.gms.games.internal.IGamesService"
                r12.enforceInterface(r0)
                android.os.IBinder r0 = r12.readStrongBinder()
                com.google.android.gms.internal.eq r0 = com.google.android.gms.internal.C0490eq.C0491a.m1280B(r0)
                java.lang.String r1 = r12.readString()
                java.lang.String r2 = r12.readString()
                r10.mo4636a((com.google.android.gms.internal.C0490eq) r0, (java.lang.String) r1, (java.lang.String) r2)
                r13.writeNoException()
                goto L_0x000a
            L_0x00f9:
                java.lang.String r0 = "com.google.android.gms.games.internal.IGamesService"
                r12.enforceInterface(r0)
                android.os.IBinder r0 = r12.readStrongBinder()
                com.google.android.gms.internal.eq r0 = com.google.android.gms.internal.C0490eq.C0491a.m1280B(r0)
                java.lang.String r1 = r12.readString()
                r10.mo4646b((com.google.android.gms.internal.C0490eq) r0, (java.lang.String) r1)
                r13.writeNoException()
                goto L_0x000a
            L_0x0112:
                java.lang.String r0 = "com.google.android.gms.games.internal.IGamesService"
                r12.enforceInterface(r0)
                android.os.IBinder r0 = r12.readStrongBinder()
                com.google.android.gms.internal.eq r1 = com.google.android.gms.internal.C0490eq.C0491a.m1280B(r0)
                java.lang.String r2 = r12.readString()
                int r0 = r12.readInt()
                if (r0 == 0) goto L_0x0136
                r0 = r9
            L_0x012a:
                long[] r3 = r12.createLongArray()
                r10.mo4640a((com.google.android.gms.internal.C0490eq) r1, (java.lang.String) r2, (boolean) r0, (long[]) r3)
                r13.writeNoException()
                goto L_0x000a
            L_0x0136:
                r0 = r7
                goto L_0x012a
            L_0x0138:
                java.lang.String r0 = "com.google.android.gms.games.internal.IGamesService"
                r12.enforceInterface(r0)
                java.lang.String r0 = r10.getCurrentPlayerId()
                r13.writeNoException()
                r13.writeString(r0)
                goto L_0x000a
            L_0x0149:
                java.lang.String r0 = "com.google.android.gms.games.internal.IGamesService"
                r12.enforceInterface(r0)
                com.google.android.gms.common.data.d r0 = r10.mo4657bU()
                r13.writeNoException()
                if (r0 == 0) goto L_0x015f
                r13.writeInt(r9)
                r0.writeToParcel(r13, r9)
                goto L_0x000a
            L_0x015f:
                r13.writeInt(r7)
                goto L_0x000a
            L_0x0164:
                java.lang.String r0 = "com.google.android.gms.games.internal.IGamesService"
                r12.enforceInterface(r0)
                android.os.IBinder r0 = r12.readStrongBinder()
                com.google.android.gms.internal.eq r0 = com.google.android.gms.internal.C0490eq.C0491a.m1280B(r0)
                java.lang.String r1 = r12.readString()
                r10.mo4663c((com.google.android.gms.internal.C0490eq) r0, (java.lang.String) r1)
                r13.writeNoException()
                goto L_0x000a
            L_0x017d:
                java.lang.String r0 = "com.google.android.gms.games.internal.IGamesService"
                r12.enforceInterface(r0)
                android.os.IBinder r0 = r12.readStrongBinder()
                com.google.android.gms.internal.eq r1 = com.google.android.gms.internal.C0490eq.C0491a.m1280B(r0)
                int r2 = r12.readInt()
                int r0 = r12.readInt()
                if (r0 == 0) goto L_0x01a4
                r0 = r9
            L_0x0195:
                int r3 = r12.readInt()
                if (r3 == 0) goto L_0x019c
                r7 = r9
            L_0x019c:
                r10.mo4623a((com.google.android.gms.internal.C0490eq) r1, (int) r2, (boolean) r0, (boolean) r7)
                r13.writeNoException()
                goto L_0x000a
            L_0x01a4:
                r0 = r7
                goto L_0x0195
            L_0x01a6:
                java.lang.String r0 = "com.google.android.gms.games.internal.IGamesService"
                r12.enforceInterface(r0)
                android.os.IBinder r0 = r12.readStrongBinder()
                com.google.android.gms.internal.eq r0 = com.google.android.gms.internal.C0490eq.C0491a.m1280B(r0)
                java.lang.String r1 = r12.readString()
                long r2 = r12.readLong()
                r10.mo4633a((com.google.android.gms.internal.C0490eq) r0, (java.lang.String) r1, (long) r2)
                r13.writeNoException()
                goto L_0x000a
            L_0x01c3:
                java.lang.String r0 = "com.google.android.gms.games.internal.IGamesService"
                r12.enforceInterface(r0)
                android.os.IBinder r0 = r12.readStrongBinder()
                com.google.android.gms.internal.eq r0 = com.google.android.gms.internal.C0490eq.C0491a.m1280B(r0)
                r10.mo4644b(r0)
                r13.writeNoException()
                goto L_0x000a
            L_0x01d8:
                java.lang.String r0 = "com.google.android.gms.games.internal.IGamesService"
                r12.enforceInterface(r0)
                android.os.IBinder r0 = r12.readStrongBinder()
                com.google.android.gms.internal.eq r0 = com.google.android.gms.internal.C0490eq.C0491a.m1280B(r0)
                java.lang.String r1 = r12.readString()
                r10.mo4670d(r0, r1)
                r13.writeNoException()
                goto L_0x000a
            L_0x01f1:
                java.lang.String r0 = "com.google.android.gms.games.internal.IGamesService"
                r12.enforceInterface(r0)
                android.os.IBinder r0 = r12.readStrongBinder()
                com.google.android.gms.internal.eq r1 = com.google.android.gms.internal.C0490eq.C0491a.m1280B(r0)
                java.lang.String r2 = r12.readString()
                int r3 = r12.readInt()
                int r4 = r12.readInt()
                int r5 = r12.readInt()
                int r0 = r12.readInt()
                if (r0 == 0) goto L_0x021e
                r6 = r9
            L_0x0215:
                r0 = r10
                r0.mo4629a(r1, r2, r3, r4, r5, r6)
                r13.writeNoException()
                goto L_0x000a
            L_0x021e:
                r6 = r7
                goto L_0x0215
            L_0x0220:
                java.lang.String r0 = "com.google.android.gms.games.internal.IGamesService"
                r12.enforceInterface(r0)
                android.os.IBinder r0 = r12.readStrongBinder()
                com.google.android.gms.internal.eq r1 = com.google.android.gms.internal.C0490eq.C0491a.m1280B(r0)
                java.lang.String r2 = r12.readString()
                int r3 = r12.readInt()
                int r4 = r12.readInt()
                int r5 = r12.readInt()
                int r0 = r12.readInt()
                if (r0 == 0) goto L_0x024d
                r6 = r9
            L_0x0244:
                r0 = r10
                r0.mo4647b(r1, r2, r3, r4, r5, r6)
                r13.writeNoException()
                goto L_0x000a
            L_0x024d:
                r6 = r7
                goto L_0x0244
            L_0x024f:
                java.lang.String r1 = "com.google.android.gms.games.internal.IGamesService"
                r12.enforceInterface(r1)
                android.os.IBinder r1 = r12.readStrongBinder()
                com.google.android.gms.internal.eq r1 = com.google.android.gms.internal.C0490eq.C0491a.m1280B(r1)
                int r2 = r12.readInt()
                if (r2 == 0) goto L_0x026a
                android.os.Parcelable$Creator r0 = android.os.Bundle.CREATOR
                java.lang.Object r0 = r0.createFromParcel(r12)
                android.os.Bundle r0 = (android.os.Bundle) r0
            L_0x026a:
                int r2 = r12.readInt()
                int r3 = r12.readInt()
                r10.mo4625a((com.google.android.gms.internal.C0490eq) r1, (android.os.Bundle) r0, (int) r2, (int) r3)
                r13.writeNoException()
                goto L_0x000a
            L_0x027a:
                java.lang.String r0 = "com.google.android.gms.games.internal.IGamesService"
                r12.enforceInterface(r0)
                android.os.IBinder r0 = r12.readStrongBinder()
                com.google.android.gms.internal.eq r0 = com.google.android.gms.internal.C0490eq.C0491a.m1280B(r0)
                r10.mo4661c(r0)
                r13.writeNoException()
                goto L_0x000a
            L_0x028f:
                java.lang.String r1 = "com.google.android.gms.games.internal.IGamesService"
                r12.enforceInterface(r1)
                android.os.IBinder r1 = r12.readStrongBinder()
                com.google.android.gms.internal.eq r1 = com.google.android.gms.internal.C0490eq.C0491a.m1280B(r1)
                java.lang.String r2 = r12.readString()
                android.os.IBinder r3 = r12.readStrongBinder()
                int r4 = r12.readInt()
                if (r4 == 0) goto L_0x02b2
                android.os.Parcelable$Creator r0 = android.os.Bundle.CREATOR
                java.lang.Object r0 = r0.createFromParcel(r12)
                android.os.Bundle r0 = (android.os.Bundle) r0
            L_0x02b2:
                r10.mo4635a((com.google.android.gms.internal.C0490eq) r1, (java.lang.String) r2, (android.os.IBinder) r3, (android.os.Bundle) r0)
                r13.writeNoException()
                goto L_0x000a
            L_0x02ba:
                java.lang.String r1 = "com.google.android.gms.games.internal.IGamesService"
                r12.enforceInterface(r1)
                android.os.IBinder r1 = r12.readStrongBinder()
                com.google.android.gms.internal.eq r1 = com.google.android.gms.internal.C0490eq.C0491a.m1280B(r1)
                java.lang.String r2 = r12.readString()
                android.os.IBinder r3 = r12.readStrongBinder()
                int r4 = r12.readInt()
                if (r4 == 0) goto L_0x02dd
                android.os.Parcelable$Creator r0 = android.os.Bundle.CREATOR
                java.lang.Object r0 = r0.createFromParcel(r12)
                android.os.Bundle r0 = (android.os.Bundle) r0
            L_0x02dd:
                r10.mo4650b((com.google.android.gms.internal.C0490eq) r1, (java.lang.String) r2, (android.os.IBinder) r3, (android.os.Bundle) r0)
                r13.writeNoException()
                goto L_0x000a
            L_0x02e5:
                java.lang.String r1 = "com.google.android.gms.games.internal.IGamesService"
                r12.enforceInterface(r1)
                android.os.IBinder r1 = r12.readStrongBinder()
                com.google.android.gms.internal.eq r1 = com.google.android.gms.internal.C0490eq.C0491a.m1280B(r1)
                java.lang.String r2 = r12.readString()
                int r3 = r12.readInt()
                android.os.IBinder r4 = r12.readStrongBinder()
                int r5 = r12.readInt()
                if (r5 == 0) goto L_0x0316
                android.os.Parcelable$Creator r0 = android.os.Bundle.CREATOR
                java.lang.Object r0 = r0.createFromParcel(r12)
                android.os.Bundle r0 = (android.os.Bundle) r0
                r5 = r0
            L_0x030d:
                r0 = r10
                r0.mo4630a((com.google.android.gms.internal.C0490eq) r1, (java.lang.String) r2, (int) r3, (android.os.IBinder) r4, (android.os.Bundle) r5)
                r13.writeNoException()
                goto L_0x000a
            L_0x0316:
                r5 = r0
                goto L_0x030d
            L_0x0318:
                java.lang.String r0 = "com.google.android.gms.games.internal.IGamesService"
                r12.enforceInterface(r0)
                android.os.IBinder r0 = r12.readStrongBinder()
                com.google.android.gms.internal.eq r0 = com.google.android.gms.internal.C0490eq.C0491a.m1280B(r0)
                r10.mo4668d(r0)
                r13.writeNoException()
                goto L_0x000a
            L_0x032d:
                java.lang.String r0 = "com.google.android.gms.games.internal.IGamesService"
                r12.enforceInterface(r0)
                android.os.IBinder r0 = r12.readStrongBinder()
                com.google.android.gms.internal.eq r0 = com.google.android.gms.internal.C0490eq.C0491a.m1280B(r0)
                r10.mo4673e((com.google.android.gms.internal.C0490eq) r0)
                r13.writeNoException()
                goto L_0x000a
            L_0x0342:
                java.lang.String r0 = "com.google.android.gms.games.internal.IGamesService"
                r12.enforceInterface(r0)
                java.lang.String r0 = r12.readString()
                int r1 = r12.readInt()
                r10.mo4692j((java.lang.String) r0, (int) r1)
                r13.writeNoException()
                goto L_0x000a
            L_0x0357:
                java.lang.String r0 = "com.google.android.gms.games.internal.IGamesService"
                r12.enforceInterface(r0)
                java.lang.String r0 = r12.readString()
                int r1 = r12.readInt()
                r10.mo4690i((java.lang.String) r0, (int) r1)
                r13.writeNoException()
                goto L_0x000a
            L_0x036c:
                java.lang.String r0 = "com.google.android.gms.games.internal.IGamesService"
                r12.enforceInterface(r0)
                android.os.IBinder r0 = r12.readStrongBinder()
                com.google.android.gms.internal.eq r0 = com.google.android.gms.internal.C0490eq.C0491a.m1280B(r0)
                long r1 = r12.readLong()
                r10.mo4624a((com.google.android.gms.internal.C0490eq) r0, (long) r1)
                r13.writeNoException()
                goto L_0x000a
            L_0x0385:
                java.lang.String r0 = "com.google.android.gms.games.internal.IGamesService"
                r12.enforceInterface(r0)
                long r0 = r12.readLong()
                r10.mo4680g((long) r0)
                r13.writeNoException()
                goto L_0x000a
            L_0x0396:
                java.lang.String r1 = "com.google.android.gms.games.internal.IGamesService"
                r12.enforceInterface(r1)
                android.os.IBinder r1 = r12.readStrongBinder()
                com.google.android.gms.internal.eq r1 = com.google.android.gms.internal.C0490eq.C0491a.m1280B(r1)
                android.os.IBinder r2 = r12.readStrongBinder()
                int r3 = r12.readInt()
                java.lang.String[] r4 = r12.createStringArray()
                int r5 = r12.readInt()
                if (r5 == 0) goto L_0x03d2
                android.os.Parcelable$Creator r0 = android.os.Bundle.CREATOR
                java.lang.Object r0 = r0.createFromParcel(r12)
                android.os.Bundle r0 = (android.os.Bundle) r0
                r5 = r0
            L_0x03be:
                int r0 = r12.readInt()
                if (r0 == 0) goto L_0x03d4
                r6 = r9
            L_0x03c5:
                long r7 = r12.readLong()
                r0 = r10
                r0.mo4626a((com.google.android.gms.internal.C0490eq) r1, (android.os.IBinder) r2, (int) r3, (java.lang.String[]) r4, (android.os.Bundle) r5, (boolean) r6, (long) r7)
                r13.writeNoException()
                goto L_0x000a
            L_0x03d2:
                r5 = r0
                goto L_0x03be
            L_0x03d4:
                r6 = r7
                goto L_0x03c5
            L_0x03d6:
                java.lang.String r0 = "com.google.android.gms.games.internal.IGamesService"
                r12.enforceInterface(r0)
                android.os.IBinder r0 = r12.readStrongBinder()
                com.google.android.gms.internal.eq r1 = com.google.android.gms.internal.C0490eq.C0491a.m1280B(r0)
                android.os.IBinder r2 = r12.readStrongBinder()
                java.lang.String r3 = r12.readString()
                int r0 = r12.readInt()
                if (r0 == 0) goto L_0x03ff
                r4 = r9
            L_0x03f2:
                long r5 = r12.readLong()
                r0 = r10
                r0.mo4627a((com.google.android.gms.internal.C0490eq) r1, (android.os.IBinder) r2, (java.lang.String) r3, (boolean) r4, (long) r5)
                r13.writeNoException()
                goto L_0x000a
            L_0x03ff:
                r4 = r7
                goto L_0x03f2
            L_0x0401:
                java.lang.String r0 = "com.google.android.gms.games.internal.IGamesService"
                r12.enforceInterface(r0)
                android.os.IBinder r0 = r12.readStrongBinder()
                com.google.android.gms.internal.eq r0 = com.google.android.gms.internal.C0490eq.C0491a.m1280B(r0)
                java.lang.String r1 = r12.readString()
                r10.mo4675e(r0, r1)
                r13.writeNoException()
                goto L_0x000a
            L_0x041a:
                java.lang.String r0 = "com.google.android.gms.games.internal.IGamesService"
                r12.enforceInterface(r0)
                android.os.IBinder r0 = r12.readStrongBinder()
                com.google.android.gms.internal.eq r0 = com.google.android.gms.internal.C0490eq.C0491a.m1280B(r0)
                byte[] r1 = r12.createByteArray()
                java.lang.String r2 = r12.readString()
                java.lang.String r3 = r12.readString()
                int r0 = r10.mo4619a((com.google.android.gms.internal.C0490eq) r0, (byte[]) r1, (java.lang.String) r2, (java.lang.String) r3)
                r13.writeNoException()
                r13.writeInt(r0)
                goto L_0x000a
            L_0x043f:
                java.lang.String r0 = "com.google.android.gms.games.internal.IGamesService"
                r12.enforceInterface(r0)
                byte[] r0 = r12.createByteArray()
                java.lang.String r1 = r12.readString()
                java.lang.String[] r2 = r12.createStringArray()
                int r0 = r10.mo4643b((byte[]) r0, (java.lang.String) r1, (java.lang.String[]) r2)
                r13.writeNoException()
                r13.writeInt(r0)
                goto L_0x000a
            L_0x045c:
                java.lang.String r0 = "com.google.android.gms.games.internal.IGamesService"
                r12.enforceInterface(r0)
                java.lang.String r0 = r12.readString()
                java.lang.String r0 = r10.mo4615M(r0)
                r13.writeNoException()
                r13.writeString(r0)
                goto L_0x000a
            L_0x0471:
                java.lang.String r0 = "com.google.android.gms.games.internal.IGamesService"
                r12.enforceInterface(r0)
                int r0 = r12.readInt()
                r10.clearNotifications(r0)
                r13.writeNoException()
                goto L_0x000a
            L_0x0482:
                java.lang.String r0 = "com.google.android.gms.games.internal.IGamesService"
                r12.enforceInterface(r0)
                android.os.IBinder r0 = r12.readStrongBinder()
                com.google.android.gms.internal.eq r0 = com.google.android.gms.internal.C0490eq.C0491a.m1280B(r0)
                java.lang.String r1 = r12.readString()
                r10.mo4678f((com.google.android.gms.internal.C0490eq) r0, (java.lang.String) r1)
                r13.writeNoException()
                goto L_0x000a
            L_0x049b:
                java.lang.String r0 = "com.google.android.gms.games.internal.IGamesService"
                r12.enforceInterface(r0)
                android.os.IBinder r0 = r12.readStrongBinder()
                com.google.android.gms.internal.eq r0 = com.google.android.gms.internal.C0490eq.C0491a.m1280B(r0)
                java.lang.String r1 = r12.readString()
                java.lang.String r2 = r12.readString()
                r10.mo4651b((com.google.android.gms.internal.C0490eq) r0, (java.lang.String) r1, (java.lang.String) r2)
                r13.writeNoException()
                goto L_0x000a
            L_0x04b8:
                java.lang.String r0 = "com.google.android.gms.games.internal.IGamesService"
                r12.enforceInterface(r0)
                android.os.IBinder r0 = r12.readStrongBinder()
                com.google.android.gms.internal.eq r1 = com.google.android.gms.internal.C0490eq.C0491a.m1280B(r0)
                java.lang.String r2 = r12.readString()
                java.lang.String r3 = r12.readString()
                int r4 = r12.readInt()
                int r5 = r12.readInt()
                int r6 = r12.readInt()
                int r0 = r12.readInt()
                if (r0 == 0) goto L_0x04e0
                r7 = r9
            L_0x04e0:
                r0 = r10
                r0.mo4637a((com.google.android.gms.internal.C0490eq) r1, (java.lang.String) r2, (java.lang.String) r3, (int) r4, (int) r5, (int) r6, (boolean) r7)
                r13.writeNoException()
                goto L_0x000a
            L_0x04e9:
                java.lang.String r0 = "com.google.android.gms.games.internal.IGamesService"
                r12.enforceInterface(r0)
                android.os.IBinder r0 = r12.readStrongBinder()
                com.google.android.gms.internal.eq r1 = com.google.android.gms.internal.C0490eq.C0491a.m1280B(r0)
                java.lang.String r2 = r12.readString()
                java.lang.String r3 = r12.readString()
                int r4 = r12.readInt()
                int r5 = r12.readInt()
                int r6 = r12.readInt()
                int r0 = r12.readInt()
                if (r0 == 0) goto L_0x0511
                r7 = r9
            L_0x0511:
                r0 = r10
                r0.mo4652b(r1, r2, r3, r4, r5, r6, r7)
                r13.writeNoException()
                goto L_0x000a
            L_0x051a:
                java.lang.String r0 = "com.google.android.gms.games.internal.IGamesService"
                r12.enforceInterface(r0)
                android.os.IBinder r0 = r12.readStrongBinder()
                com.google.android.gms.internal.eq r0 = com.google.android.gms.internal.C0490eq.C0491a.m1280B(r0)
                java.lang.String r1 = r12.readString()
                java.lang.String r2 = r12.readString()
                r10.mo4664c((com.google.android.gms.internal.C0490eq) r0, (java.lang.String) r1, (java.lang.String) r2)
                r13.writeNoException()
                goto L_0x000a
            L_0x0537:
                java.lang.String r0 = "com.google.android.gms.games.internal.IGamesService"
                r12.enforceInterface(r0)
                android.os.IBinder r0 = r12.readStrongBinder()
                com.google.android.gms.internal.eq r0 = com.google.android.gms.internal.C0490eq.C0491a.m1280B(r0)
                java.lang.String r1 = r12.readString()
                r10.mo4682g(r0, r1)
                r13.writeNoException()
                goto L_0x000a
            L_0x0550:
                java.lang.String r0 = "com.google.android.gms.games.internal.IGamesService"
                r12.enforceInterface(r0)
                android.os.IBinder r0 = r12.readStrongBinder()
                com.google.android.gms.internal.eq r0 = com.google.android.gms.internal.C0490eq.C0491a.m1280B(r0)
                java.lang.String r1 = r12.readString()
                r10.mo4687h(r0, r1)
                r13.writeNoException()
                goto L_0x000a
            L_0x0569:
                java.lang.String r0 = "com.google.android.gms.games.internal.IGamesService"
                r12.enforceInterface(r0)
                android.os.IBinder r0 = r12.readStrongBinder()
                com.google.android.gms.internal.eq r1 = com.google.android.gms.internal.C0490eq.C0491a.m1280B(r0)
                int r2 = r12.readInt()
                int r3 = r12.readInt()
                int r0 = r12.readInt()
                if (r0 == 0) goto L_0x0595
                r4 = r9
            L_0x0585:
                int r0 = r12.readInt()
                if (r0 == 0) goto L_0x0597
                r5 = r9
            L_0x058c:
                r0 = r10
                r0.mo4622a((com.google.android.gms.internal.C0490eq) r1, (int) r2, (int) r3, (boolean) r4, (boolean) r5)
                r13.writeNoException()
                goto L_0x000a
            L_0x0595:
                r4 = r7
                goto L_0x0585
            L_0x0597:
                r5 = r7
                goto L_0x058c
            L_0x0599:
                java.lang.String r0 = "com.google.android.gms.games.internal.IGamesService"
                r12.enforceInterface(r0)
                android.os.IBinder r0 = r12.readStrongBinder()
                com.google.android.gms.internal.eq r1 = com.google.android.gms.internal.C0490eq.C0491a.m1280B(r0)
                java.lang.String r2 = r12.readString()
                int r3 = r12.readInt()
                int r0 = r12.readInt()
                if (r0 == 0) goto L_0x05c5
                r4 = r9
            L_0x05b5:
                int r0 = r12.readInt()
                if (r0 == 0) goto L_0x05c7
                r5 = r9
            L_0x05bc:
                r0 = r10
                r0.mo4631a((com.google.android.gms.internal.C0490eq) r1, (java.lang.String) r2, (int) r3, (boolean) r4, (boolean) r5)
                r13.writeNoException()
                goto L_0x000a
            L_0x05c5:
                r4 = r7
                goto L_0x05b5
            L_0x05c7:
                r5 = r7
                goto L_0x05bc
            L_0x05c9:
                java.lang.String r0 = "com.google.android.gms.games.internal.IGamesService"
                r12.enforceInterface(r0)
                android.os.IBinder r0 = r12.readStrongBinder()
                com.google.android.gms.internal.eq r1 = com.google.android.gms.internal.C0490eq.C0491a.m1280B(r0)
                int r2 = r12.readInt()
                int r0 = r12.readInt()
                if (r0 == 0) goto L_0x05f0
                r0 = r9
            L_0x05e1:
                int r3 = r12.readInt()
                if (r3 == 0) goto L_0x05e8
                r7 = r9
            L_0x05e8:
                r10.mo4645b((com.google.android.gms.internal.C0490eq) r1, (int) r2, (boolean) r0, (boolean) r7)
                r13.writeNoException()
                goto L_0x000a
            L_0x05f0:
                r0 = r7
                goto L_0x05e1
            L_0x05f2:
                java.lang.String r0 = "com.google.android.gms.games.internal.IGamesService"
                r12.enforceInterface(r0)
                android.os.IBinder r0 = r12.readStrongBinder()
                com.google.android.gms.internal.eq r0 = com.google.android.gms.internal.C0490eq.C0491a.m1280B(r0)
                r10.mo4677f((com.google.android.gms.internal.C0490eq) r0)
                r13.writeNoException()
                goto L_0x000a
            L_0x0607:
                java.lang.String r0 = "com.google.android.gms.games.internal.IGamesService"
                r12.enforceInterface(r0)
                android.os.IBinder r0 = r12.readStrongBinder()
                com.google.android.gms.internal.eq r1 = com.google.android.gms.internal.C0490eq.C0491a.m1280B(r0)
                int r2 = r12.readInt()
                int r0 = r12.readInt()
                if (r0 == 0) goto L_0x062e
                r0 = r9
            L_0x061f:
                int r3 = r12.readInt()
                if (r3 == 0) goto L_0x0626
                r7 = r9
            L_0x0626:
                r10.mo4662c(r1, r2, r0, r7)
                r13.writeNoException()
                goto L_0x000a
            L_0x062e:
                r0 = r7
                goto L_0x061f
            L_0x0630:
                java.lang.String r0 = "com.google.android.gms.games.internal.IGamesService"
                r12.enforceInterface(r0)
                android.os.IBinder r0 = r12.readStrongBinder()
                com.google.android.gms.internal.eq r0 = com.google.android.gms.internal.C0490eq.C0491a.m1280B(r0)
                r10.mo4681g((com.google.android.gms.internal.C0490eq) r0)
                r13.writeNoException()
                goto L_0x000a
            L_0x0645:
                java.lang.String r0 = "com.google.android.gms.games.internal.IGamesService"
                r12.enforceInterface(r0)
                java.lang.String r0 = r12.readString()
                r10.mo4616N(r0)
                r13.writeNoException()
                goto L_0x000a
            L_0x0656:
                java.lang.String r0 = "com.google.android.gms.games.internal.IGamesService"
                r12.enforceInterface(r0)
                java.lang.String r0 = r12.readString()
                java.lang.String r1 = r12.readString()
                int r2 = r12.readInt()
                r10.mo4642a((java.lang.String) r0, (java.lang.String) r1, (int) r2)
                r13.writeNoException()
                goto L_0x000a
            L_0x066f:
                java.lang.String r0 = "com.google.android.gms.games.internal.IGamesService"
                r12.enforceInterface(r0)
                android.os.IBinder r0 = r12.readStrongBinder()
                com.google.android.gms.internal.eq r0 = com.google.android.gms.internal.C0490eq.C0491a.m1280B(r0)
                java.lang.String r1 = r12.readString()
                r10.mo4689i((com.google.android.gms.internal.C0490eq) r0, (java.lang.String) r1)
                r13.writeNoException()
                goto L_0x000a
            L_0x0688:
                java.lang.String r0 = "com.google.android.gms.games.internal.IGamesService"
                r12.enforceInterface(r0)
                android.os.IBinder r0 = r12.readStrongBinder()
                com.google.android.gms.internal.eq r0 = com.google.android.gms.internal.C0490eq.C0491a.m1280B(r0)
                java.lang.String r1 = r12.readString()
                int r0 = r10.mo4691j((com.google.android.gms.internal.C0490eq) r0, (java.lang.String) r1)
                r13.writeNoException()
                r13.writeInt(r0)
                goto L_0x000a
            L_0x06a5:
                java.lang.String r0 = "com.google.android.gms.games.internal.IGamesService"
                r12.enforceInterface(r0)
                java.lang.String r0 = r12.readString()
                int r0 = r10.mo4617O(r0)
                r13.writeNoException()
                r13.writeInt(r0)
                goto L_0x000a
            L_0x06ba:
                java.lang.String r0 = "com.google.android.gms.games.internal.IGamesService"
                r12.enforceInterface(r0)
                android.os.IBinder r0 = r12.readStrongBinder()
                com.google.android.gms.internal.eq r0 = com.google.android.gms.internal.C0490eq.C0491a.m1280B(r0)
                java.lang.String r1 = r12.readString()
                int r2 = r12.readInt()
                if (r2 == 0) goto L_0x06d2
                r7 = r9
            L_0x06d2:
                r10.mo4639a((com.google.android.gms.internal.C0490eq) r0, (java.lang.String) r1, (boolean) r7)
                r13.writeNoException()
                goto L_0x000a
            L_0x06da:
                java.lang.String r0 = "com.google.android.gms.games.internal.IGamesService"
                r12.enforceInterface(r0)
                android.os.IBinder r0 = r12.readStrongBinder()
                com.google.android.gms.internal.eq r0 = com.google.android.gms.internal.C0490eq.C0491a.m1280B(r0)
                java.lang.String r1 = r12.readString()
                r10.mo4693k((com.google.android.gms.internal.C0490eq) r0, (java.lang.String) r1)
                r13.writeNoException()
                goto L_0x000a
            L_0x06f3:
                java.lang.String r0 = "com.google.android.gms.games.internal.IGamesService"
                r12.enforceInterface(r0)
                java.lang.String r0 = r12.readString()
                int r1 = r12.readInt()
                r10.mo4694k((java.lang.String) r0, (int) r1)
                r13.writeNoException()
                goto L_0x000a
            L_0x0708:
                java.lang.String r0 = "com.google.android.gms.games.internal.IGamesService"
                r12.enforceInterface(r0)
                boolean r0 = r10.mo4658bV()
                r13.writeNoException()
                if (r0 == 0) goto L_0x0717
                r7 = r9
            L_0x0717:
                r13.writeInt(r7)
                goto L_0x000a
            L_0x071c:
                java.lang.String r0 = "com.google.android.gms.games.internal.IGamesService"
                r12.enforceInterface(r0)
                int r0 = r12.readInt()
                if (r0 == 0) goto L_0x0728
                r7 = r9
            L_0x0728:
                r10.setUseNewPlayerNotificationsFirstParty(r7)
                r13.writeNoException()
                goto L_0x000a
            L_0x0730:
                java.lang.String r0 = "com.google.android.gms.games.internal.IGamesService"
                r12.enforceInterface(r0)
                android.os.IBinder r0 = r12.readStrongBinder()
                com.google.android.gms.internal.eq r0 = com.google.android.gms.internal.C0490eq.C0491a.m1280B(r0)
                r10.mo4686h(r0)
                r13.writeNoException()
                goto L_0x000a
            L_0x0745:
                java.lang.String r0 = "com.google.android.gms.games.internal.IGamesService"
                r12.enforceInterface(r0)
                android.os.IBinder r0 = r12.readStrongBinder()
                com.google.android.gms.internal.eq r0 = com.google.android.gms.internal.C0490eq.C0491a.m1280B(r0)
                java.lang.String r1 = r12.readString()
                r10.mo4695l(r0, r1)
                r13.writeNoException()
                goto L_0x000a
            L_0x075e:
                java.lang.String r0 = "com.google.android.gms.games.internal.IGamesService"
                r12.enforceInterface(r0)
                android.os.IBinder r0 = r12.readStrongBinder()
                com.google.android.gms.internal.eq r0 = com.google.android.gms.internal.C0490eq.C0491a.m1280B(r0)
                r10.mo4688i(r0)
                r13.writeNoException()
                goto L_0x000a
            L_0x0773:
                java.lang.String r0 = "com.google.android.gms.games.internal.IGamesService"
                r12.enforceInterface(r0)
                android.os.IBinder r0 = r12.readStrongBinder()
                com.google.android.gms.internal.eq r0 = com.google.android.gms.internal.C0490eq.C0491a.m1280B(r0)
                int r1 = r12.readInt()
                if (r1 == 0) goto L_0x0787
                r7 = r9
            L_0x0787:
                r10.mo4641a((com.google.android.gms.internal.C0490eq) r0, (boolean) r7)
                r13.writeNoException()
                goto L_0x000a
            L_0x078f:
                java.lang.String r0 = "com.google.android.gms.games.internal.IGamesService"
                r12.enforceInterface(r0)
                java.lang.String r0 = r12.readString()
                android.net.Uri r0 = r10.mo4618P(r0)
                r13.writeNoException()
                if (r0 == 0) goto L_0x07a9
                r13.writeInt(r9)
                r0.writeToParcel(r13, r9)
                goto L_0x000a
            L_0x07a9:
                r13.writeInt(r7)
                goto L_0x000a
            L_0x07ae:
                java.lang.String r0 = "com.google.android.gms.games.internal.IGamesService"
                r12.enforceInterface(r0)
                android.os.IBinder r0 = r12.readStrongBinder()
                com.google.android.gms.internal.eq r1 = com.google.android.gms.internal.C0490eq.C0491a.m1280B(r0)
                java.lang.String r2 = r12.readString()
                int r3 = r12.readInt()
                int r0 = r12.readInt()
                if (r0 == 0) goto L_0x07da
                r4 = r9
            L_0x07ca:
                int r0 = r12.readInt()
                if (r0 == 0) goto L_0x07dc
                r5 = r9
            L_0x07d1:
                r0 = r10
                r0.mo4649b((com.google.android.gms.internal.C0490eq) r1, (java.lang.String) r2, (int) r3, (boolean) r4, (boolean) r5)
                r13.writeNoException()
                goto L_0x000a
            L_0x07da:
                r4 = r7
                goto L_0x07ca
            L_0x07dc:
                r5 = r7
                goto L_0x07d1
            L_0x07de:
                java.lang.String r0 = "com.google.android.gms.games.internal.IGamesService"
                r12.enforceInterface(r0)
                com.google.android.gms.common.data.d r0 = r10.mo4659bW()
                r13.writeNoException()
                if (r0 == 0) goto L_0x07f4
                r13.writeInt(r9)
                r0.writeToParcel(r13, r9)
                goto L_0x000a
            L_0x07f4:
                r13.writeInt(r7)
                goto L_0x000a
            L_0x07f9:
                java.lang.String r0 = "com.google.android.gms.games.internal.IGamesService"
                r12.enforceInterface(r0)
                android.os.IBinder r0 = r12.readStrongBinder()
                com.google.android.gms.internal.eq r0 = com.google.android.gms.internal.C0490eq.C0491a.m1280B(r0)
                int r1 = r12.readInt()
                if (r1 == 0) goto L_0x080d
                r7 = r9
            L_0x080d:
                r10.mo4655b((com.google.android.gms.internal.C0490eq) r0, (boolean) r7)
                r13.writeNoException()
                goto L_0x000a
            L_0x0815:
                java.lang.String r0 = "com.google.android.gms.games.internal.IGamesService"
                r12.enforceInterface(r0)
                android.os.IBinder r0 = r12.readStrongBinder()
                com.google.android.gms.internal.eq r0 = com.google.android.gms.internal.C0490eq.C0491a.m1280B(r0)
                java.lang.String r1 = r12.readString()
                java.lang.String r2 = r12.readString()
                int r3 = r12.readInt()
                if (r3 == 0) goto L_0x0831
                r7 = r9
            L_0x0831:
                r10.mo4638a((com.google.android.gms.internal.C0490eq) r0, (java.lang.String) r1, (java.lang.String) r2, (boolean) r7)
                r13.writeNoException()
                goto L_0x000a
            L_0x0839:
                java.lang.String r0 = "com.google.android.gms.games.internal.IGamesService"
                r12.enforceInterface(r0)
                android.os.IBinder r0 = r12.readStrongBinder()
                com.google.android.gms.internal.eq r1 = com.google.android.gms.internal.C0490eq.C0491a.m1280B(r0)
                int r2 = r12.readInt()
                int r0 = r12.readInt()
                if (r0 == 0) goto L_0x0860
                r0 = r9
            L_0x0851:
                int r3 = r12.readInt()
                if (r3 == 0) goto L_0x0858
                r7 = r9
            L_0x0858:
                r10.mo4669d(r1, r2, r0, r7)
                r13.writeNoException()
                goto L_0x000a
            L_0x0860:
                r0 = r7
                goto L_0x0851
            L_0x0862:
                java.lang.String r0 = "com.google.android.gms.games.internal.IGamesService"
                r12.enforceInterface(r0)
                android.os.IBinder r0 = r12.readStrongBinder()
                com.google.android.gms.internal.eq r1 = com.google.android.gms.internal.C0490eq.C0491a.m1280B(r0)
                int r2 = r12.readInt()
                int r0 = r12.readInt()
                if (r0 == 0) goto L_0x0889
                r0 = r9
            L_0x087a:
                int r3 = r12.readInt()
                if (r3 == 0) goto L_0x0881
                r7 = r9
            L_0x0881:
                r10.mo4674e(r1, r2, r0, r7)
                r13.writeNoException()
                goto L_0x000a
            L_0x0889:
                r0 = r7
                goto L_0x087a
            L_0x088b:
                java.lang.String r0 = "com.google.android.gms.games.internal.IGamesService"
                r12.enforceInterface(r0)
                android.os.IBinder r0 = r12.readStrongBinder()
                com.google.android.gms.internal.eq r1 = com.google.android.gms.internal.C0490eq.C0491a.m1280B(r0)
                java.lang.String r2 = r12.readString()
                int r3 = r12.readInt()
                int r0 = r12.readInt()
                if (r0 == 0) goto L_0x08c5
                r4 = r9
            L_0x08a7:
                int r0 = r12.readInt()
                if (r0 == 0) goto L_0x08c7
                r5 = r9
            L_0x08ae:
                int r0 = r12.readInt()
                if (r0 == 0) goto L_0x08c9
                r6 = r9
            L_0x08b5:
                int r0 = r12.readInt()
                if (r0 == 0) goto L_0x08bc
                r7 = r9
            L_0x08bc:
                r0 = r10
                r0.mo4632a((com.google.android.gms.internal.C0490eq) r1, (java.lang.String) r2, (int) r3, (boolean) r4, (boolean) r5, (boolean) r6, (boolean) r7)
                r13.writeNoException()
                goto L_0x000a
            L_0x08c5:
                r4 = r7
                goto L_0x08a7
            L_0x08c7:
                r5 = r7
                goto L_0x08ae
            L_0x08c9:
                r6 = r7
                goto L_0x08b5
            L_0x08cb:
                java.lang.String r0 = "com.google.android.gms.games.internal.IGamesService"
                r12.enforceInterface(r0)
                android.os.IBinder r0 = r12.readStrongBinder()
                com.google.android.gms.internal.eq r0 = com.google.android.gms.internal.C0490eq.C0491a.m1280B(r0)
                java.lang.String r1 = r12.readString()
                int r2 = r12.readInt()
                if (r2 == 0) goto L_0x08e3
                r7 = r9
            L_0x08e3:
                r10.mo4654b((com.google.android.gms.internal.C0490eq) r0, (java.lang.String) r1, (boolean) r7)
                r13.writeNoException()
                goto L_0x000a
            L_0x08eb:
                java.lang.String r0 = "com.google.android.gms.games.internal.IGamesService"
                r12.enforceInterface(r0)
                android.os.IBinder r0 = r12.readStrongBinder()
                com.google.android.gms.internal.eq r0 = com.google.android.gms.internal.C0490eq.C0491a.m1280B(r0)
                int r1 = r12.readInt()
                if (r1 == 0) goto L_0x08ff
                r7 = r9
            L_0x08ff:
                r10.mo4666c((com.google.android.gms.internal.C0490eq) r0, (boolean) r7)
                r13.writeNoException()
                goto L_0x000a
            L_0x0907:
                java.lang.String r0 = "com.google.android.gms.games.internal.IGamesService"
                r12.enforceInterface(r0)
                android.os.IBinder r0 = r12.readStrongBinder()
                com.google.android.gms.internal.eq r0 = com.google.android.gms.internal.C0490eq.C0491a.m1280B(r0)
                java.lang.String r1 = r12.readString()
                int r2 = r12.readInt()
                if (r2 == 0) goto L_0x091f
                r7 = r9
            L_0x091f:
                r10.mo4665c((com.google.android.gms.internal.C0490eq) r0, (java.lang.String) r1, (boolean) r7)
                r13.writeNoException()
                goto L_0x000a
            L_0x0927:
                java.lang.String r0 = "com.google.android.gms.games.internal.IGamesService"
                r12.enforceInterface(r0)
                android.os.IBinder r0 = r12.readStrongBinder()
                com.google.android.gms.internal.eq r0 = com.google.android.gms.internal.C0490eq.C0491a.m1280B(r0)
                java.lang.String r1 = r12.readString()
                int r2 = r12.readInt()
                if (r2 == 0) goto L_0x093f
                r7 = r9
            L_0x093f:
                r10.mo4671d(r0, r1, r7)
                r13.writeNoException()
                goto L_0x000a
            L_0x0947:
                java.lang.String r0 = "com.google.android.gms.games.internal.IGamesService"
                r12.enforceInterface(r0)
                android.os.IBinder r0 = r12.readStrongBinder()
                com.google.android.gms.internal.eq r0 = com.google.android.gms.internal.C0490eq.C0491a.m1280B(r0)
                java.lang.String r1 = r12.readString()
                java.lang.String r2 = r12.readString()
                int r3 = r12.readInt()
                if (r3 == 0) goto L_0x0963
                r7 = r9
            L_0x0963:
                r10.mo4653b((com.google.android.gms.internal.C0490eq) r0, (java.lang.String) r1, (java.lang.String) r2, (boolean) r7)
                r13.writeNoException()
                goto L_0x000a
            L_0x096b:
                java.lang.String r1 = "com.google.android.gms.games.internal.IGamesService"
                r12.enforceInterface(r1)
                int r1 = r12.readInt()
                if (r1 == 0) goto L_0x097e
                android.os.Parcelable$Creator r0 = android.net.Uri.CREATOR
                java.lang.Object r0 = r0.createFromParcel(r12)
                android.net.Uri r0 = (android.net.Uri) r0
            L_0x097e:
                android.os.ParcelFileDescriptor r0 = r10.mo4672e((android.net.Uri) r0)
                r13.writeNoException()
                if (r0 == 0) goto L_0x098f
                r13.writeInt(r9)
                r0.writeToParcel(r13, r9)
                goto L_0x000a
            L_0x098f:
                r13.writeInt(r7)
                goto L_0x000a
            L_0x0994:
                java.lang.String r0 = "com.google.android.gms.games.internal.IGamesService"
                r12.enforceInterface(r0)
                android.os.IBinder r0 = r12.readStrongBinder()
                com.google.android.gms.internal.eq r0 = com.google.android.gms.internal.C0490eq.C0491a.m1280B(r0)
                java.lang.String r1 = r12.readString()
                r10.mo4696m(r0, r1)
                r13.writeNoException()
                goto L_0x000a
            L_0x09ad:
                java.lang.String r0 = "com.google.android.gms.games.internal.IGamesService"
                r12.enforceInterface(r0)
                android.os.IBinder r0 = r12.readStrongBinder()
                com.google.android.gms.internal.eq r1 = com.google.android.gms.internal.C0490eq.C0491a.m1280B(r0)
                java.lang.String r2 = r12.readString()
                long r3 = r12.readLong()
                java.lang.String r5 = r12.readString()
                r0 = r10
                r0.mo4634a((com.google.android.gms.internal.C0490eq) r1, (java.lang.String) r2, (long) r3, (java.lang.String) r5)
                r13.writeNoException()
                goto L_0x000a
            L_0x09cf:
                java.lang.String r1 = "com.google.android.gms.games.internal.IGamesService"
                r12.enforceInterface(r1)
                android.os.IBinder r1 = r12.readStrongBinder()
                com.google.android.gms.internal.eq r1 = com.google.android.gms.internal.C0490eq.C0491a.m1280B(r1)
                java.lang.String r2 = r12.readString()
                int r3 = r12.readInt()
                android.os.IBinder r4 = r12.readStrongBinder()
                int r5 = r12.readInt()
                if (r5 == 0) goto L_0x0a00
                android.os.Parcelable$Creator r0 = android.os.Bundle.CREATOR
                java.lang.Object r0 = r0.createFromParcel(r12)
                android.os.Bundle r0 = (android.os.Bundle) r0
                r5 = r0
            L_0x09f7:
                r0 = r10
                r0.mo4648b((com.google.android.gms.internal.C0490eq) r1, (java.lang.String) r2, (int) r3, (android.os.IBinder) r4, (android.os.Bundle) r5)
                r13.writeNoException()
                goto L_0x000a
            L_0x0a00:
                r5 = r0
                goto L_0x09f7
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.C0493er.C0494a.onTransact(int, android.os.Parcel, android.os.Parcel, int):boolean");
        }
    }

    /* renamed from: L */
    String mo4614L(String str) throws RemoteException;

    /* renamed from: M */
    String mo4615M(String str) throws RemoteException;

    /* renamed from: N */
    void mo4616N(String str) throws RemoteException;

    /* renamed from: O */
    int mo4617O(String str) throws RemoteException;

    /* renamed from: P */
    Uri mo4618P(String str) throws RemoteException;

    /* renamed from: a */
    int mo4619a(C0490eq eqVar, byte[] bArr, String str, String str2) throws RemoteException;

    /* renamed from: a */
    void mo4620a(IBinder iBinder, Bundle bundle) throws RemoteException;

    /* renamed from: a */
    void mo4621a(C0490eq eqVar) throws RemoteException;

    /* renamed from: a */
    void mo4622a(C0490eq eqVar, int i, int i2, boolean z, boolean z2) throws RemoteException;

    /* renamed from: a */
    void mo4623a(C0490eq eqVar, int i, boolean z, boolean z2) throws RemoteException;

    /* renamed from: a */
    void mo4624a(C0490eq eqVar, long j) throws RemoteException;

    /* renamed from: a */
    void mo4625a(C0490eq eqVar, Bundle bundle, int i, int i2) throws RemoteException;

    /* renamed from: a */
    void mo4626a(C0490eq eqVar, IBinder iBinder, int i, String[] strArr, Bundle bundle, boolean z, long j) throws RemoteException;

    /* renamed from: a */
    void mo4627a(C0490eq eqVar, IBinder iBinder, String str, boolean z, long j) throws RemoteException;

    /* renamed from: a */
    void mo4628a(C0490eq eqVar, String str) throws RemoteException;

    /* renamed from: a */
    void mo4629a(C0490eq eqVar, String str, int i, int i2, int i3, boolean z) throws RemoteException;

    /* renamed from: a */
    void mo4630a(C0490eq eqVar, String str, int i, IBinder iBinder, Bundle bundle) throws RemoteException;

    /* renamed from: a */
    void mo4631a(C0490eq eqVar, String str, int i, boolean z, boolean z2) throws RemoteException;

    /* renamed from: a */
    void mo4632a(C0490eq eqVar, String str, int i, boolean z, boolean z2, boolean z3, boolean z4) throws RemoteException;

    /* renamed from: a */
    void mo4633a(C0490eq eqVar, String str, long j) throws RemoteException;

    /* renamed from: a */
    void mo4634a(C0490eq eqVar, String str, long j, String str2) throws RemoteException;

    /* renamed from: a */
    void mo4635a(C0490eq eqVar, String str, IBinder iBinder, Bundle bundle) throws RemoteException;

    /* renamed from: a */
    void mo4636a(C0490eq eqVar, String str, String str2) throws RemoteException;

    /* renamed from: a */
    void mo4637a(C0490eq eqVar, String str, String str2, int i, int i2, int i3, boolean z) throws RemoteException;

    /* renamed from: a */
    void mo4638a(C0490eq eqVar, String str, String str2, boolean z) throws RemoteException;

    /* renamed from: a */
    void mo4639a(C0490eq eqVar, String str, boolean z) throws RemoteException;

    /* renamed from: a */
    void mo4640a(C0490eq eqVar, String str, boolean z, long[] jArr) throws RemoteException;

    /* renamed from: a */
    void mo4641a(C0490eq eqVar, boolean z) throws RemoteException;

    /* renamed from: a */
    void mo4642a(String str, String str2, int i) throws RemoteException;

    /* renamed from: b */
    int mo4643b(byte[] bArr, String str, String[] strArr) throws RemoteException;

    /* renamed from: b */
    void mo4644b(C0490eq eqVar) throws RemoteException;

    /* renamed from: b */
    void mo4645b(C0490eq eqVar, int i, boolean z, boolean z2) throws RemoteException;

    /* renamed from: b */
    void mo4646b(C0490eq eqVar, String str) throws RemoteException;

    /* renamed from: b */
    void mo4647b(C0490eq eqVar, String str, int i, int i2, int i3, boolean z) throws RemoteException;

    /* renamed from: b */
    void mo4648b(C0490eq eqVar, String str, int i, IBinder iBinder, Bundle bundle) throws RemoteException;

    /* renamed from: b */
    void mo4649b(C0490eq eqVar, String str, int i, boolean z, boolean z2) throws RemoteException;

    /* renamed from: b */
    void mo4650b(C0490eq eqVar, String str, IBinder iBinder, Bundle bundle) throws RemoteException;

    /* renamed from: b */
    void mo4651b(C0490eq eqVar, String str, String str2) throws RemoteException;

    /* renamed from: b */
    void mo4652b(C0490eq eqVar, String str, String str2, int i, int i2, int i3, boolean z) throws RemoteException;

    /* renamed from: b */
    void mo4653b(C0490eq eqVar, String str, String str2, boolean z) throws RemoteException;

    /* renamed from: b */
    void mo4654b(C0490eq eqVar, String str, boolean z) throws RemoteException;

    /* renamed from: b */
    void mo4655b(C0490eq eqVar, boolean z) throws RemoteException;

    /* renamed from: bT */
    void mo4656bT() throws RemoteException;

    /* renamed from: bU */
    C0140d mo4657bU() throws RemoteException;

    /* renamed from: bV */
    boolean mo4658bV() throws RemoteException;

    /* renamed from: bW */
    C0140d mo4659bW() throws RemoteException;

    /* renamed from: ba */
    Bundle mo4660ba() throws RemoteException;

    /* renamed from: c */
    void mo4661c(C0490eq eqVar) throws RemoteException;

    /* renamed from: c */
    void mo4662c(C0490eq eqVar, int i, boolean z, boolean z2) throws RemoteException;

    /* renamed from: c */
    void mo4663c(C0490eq eqVar, String str) throws RemoteException;

    /* renamed from: c */
    void mo4664c(C0490eq eqVar, String str, String str2) throws RemoteException;

    /* renamed from: c */
    void mo4665c(C0490eq eqVar, String str, boolean z) throws RemoteException;

    /* renamed from: c */
    void mo4666c(C0490eq eqVar, boolean z) throws RemoteException;

    void clearNotifications(int i) throws RemoteException;

    /* renamed from: d */
    void mo4668d(C0490eq eqVar) throws RemoteException;

    /* renamed from: d */
    void mo4669d(C0490eq eqVar, int i, boolean z, boolean z2) throws RemoteException;

    /* renamed from: d */
    void mo4670d(C0490eq eqVar, String str) throws RemoteException;

    /* renamed from: d */
    void mo4671d(C0490eq eqVar, String str, boolean z) throws RemoteException;

    /* renamed from: e */
    ParcelFileDescriptor mo4672e(Uri uri) throws RemoteException;

    /* renamed from: e */
    void mo4673e(C0490eq eqVar) throws RemoteException;

    /* renamed from: e */
    void mo4674e(C0490eq eqVar, int i, boolean z, boolean z2) throws RemoteException;

    /* renamed from: e */
    void mo4675e(C0490eq eqVar, String str) throws RemoteException;

    /* renamed from: f */
    void mo4676f(long j) throws RemoteException;

    /* renamed from: f */
    void mo4677f(C0490eq eqVar) throws RemoteException;

    /* renamed from: f */
    void mo4678f(C0490eq eqVar, String str) throws RemoteException;

    /* renamed from: f */
    void mo4679f(String str, String str2) throws RemoteException;

    /* renamed from: g */
    void mo4680g(long j) throws RemoteException;

    /* renamed from: g */
    void mo4681g(C0490eq eqVar) throws RemoteException;

    /* renamed from: g */
    void mo4682g(C0490eq eqVar, String str) throws RemoteException;

    String getAppId() throws RemoteException;

    String getCurrentAccountName() throws RemoteException;

    String getCurrentPlayerId() throws RemoteException;

    /* renamed from: h */
    void mo4686h(C0490eq eqVar) throws RemoteException;

    /* renamed from: h */
    void mo4687h(C0490eq eqVar, String str) throws RemoteException;

    /* renamed from: i */
    void mo4688i(C0490eq eqVar) throws RemoteException;

    /* renamed from: i */
    void mo4689i(C0490eq eqVar, String str) throws RemoteException;

    /* renamed from: i */
    void mo4690i(String str, int i) throws RemoteException;

    /* renamed from: j */
    int mo4691j(C0490eq eqVar, String str) throws RemoteException;

    /* renamed from: j */
    void mo4692j(String str, int i) throws RemoteException;

    /* renamed from: k */
    void mo4693k(C0490eq eqVar, String str) throws RemoteException;

    /* renamed from: k */
    void mo4694k(String str, int i) throws RemoteException;

    /* renamed from: l */
    void mo4695l(C0490eq eqVar, String str) throws RemoteException;

    /* renamed from: m */
    void mo4696m(C0490eq eqVar, String str) throws RemoteException;

    void setUseNewPlayerNotificationsFirstParty(boolean z) throws RemoteException;
}
