package com.google.android.gms.internal;

import android.net.Uri;
import android.os.Binder;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.ParcelFileDescriptor;
import android.os.RemoteException;
import com.google.android.gms.common.data.C0344d;
import com.google.android.gms.games.GamesClient;

/* renamed from: com.google.android.gms.internal.az */
public interface C0479az extends IInterface {

    /* renamed from: com.google.android.gms.internal.az$a */
    public static abstract class C0480a extends Binder implements C0479az {

        /* renamed from: com.google.android.gms.internal.az$a$a */
        private static class C0481a implements C0479az {

            /* renamed from: a */
            private IBinder f1098a;

            C0481a(IBinder iBinder) {
                this.f1098a = iBinder;
            }

            /* renamed from: a */
            public int mo4667a(C0476ay ayVar, byte[] bArr, String str, String str2) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
                    obtain.writeStrongBinder(ayVar != null ? ayVar.asBinder() : null);
                    obtain.writeByteArray(bArr);
                    obtain.writeString(str);
                    obtain.writeString(str2);
                    this.f1098a.transact(5033, obtain, obtain2, 0);
                    obtain2.readException();
                    return obtain2.readInt();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            /* renamed from: a */
            public void mo4668a(long j) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
                    obtain.writeLong(j);
                    this.f1098a.transact(5001, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            /* renamed from: a */
            public void mo4669a(IBinder iBinder, Bundle bundle) throws RemoteException {
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
                    this.f1098a.transact(5005, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            /* renamed from: a */
            public void mo4670a(C0476ay ayVar) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
                    obtain.writeStrongBinder(ayVar != null ? ayVar.asBinder() : null);
                    this.f1098a.transact(5002, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            /* renamed from: a */
            public void mo4671a(C0476ay ayVar, int i, int i2, boolean z, boolean z2) throws RemoteException {
                int i3 = 1;
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
                    obtain.writeStrongBinder(ayVar != null ? ayVar.asBinder() : null);
                    obtain.writeInt(i);
                    obtain.writeInt(i2);
                    obtain.writeInt(z ? 1 : 0);
                    if (!z2) {
                        i3 = 0;
                    }
                    obtain.writeInt(i3);
                    this.f1098a.transact(5044, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            /* renamed from: a */
            public void mo4672a(C0476ay ayVar, int i, boolean z, boolean z2) throws RemoteException {
                int i2 = 1;
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
                    obtain.writeStrongBinder(ayVar != null ? ayVar.asBinder() : null);
                    obtain.writeInt(i);
                    obtain.writeInt(z ? 1 : 0);
                    if (!z2) {
                        i2 = 0;
                    }
                    obtain.writeInt(i2);
                    this.f1098a.transact(5015, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            /* renamed from: a */
            public void mo4673a(C0476ay ayVar, long j) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
                    obtain.writeStrongBinder(ayVar != null ? ayVar.asBinder() : null);
                    obtain.writeLong(j);
                    this.f1098a.transact(5058, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            /* renamed from: a */
            public void mo4674a(C0476ay ayVar, Bundle bundle, int i, int i2) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
                    obtain.writeStrongBinder(ayVar != null ? ayVar.asBinder() : null);
                    if (bundle != null) {
                        obtain.writeInt(1);
                        bundle.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    obtain.writeInt(i);
                    obtain.writeInt(i2);
                    this.f1098a.transact(5021, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            /* renamed from: a */
            public void mo4675a(C0476ay ayVar, IBinder iBinder, int i, String[] strArr, Bundle bundle, boolean z, long j) throws RemoteException {
                int i2 = 1;
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
                    obtain.writeStrongBinder(ayVar != null ? ayVar.asBinder() : null);
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
                    this.f1098a.transact(5030, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            /* renamed from: a */
            public void mo4676a(C0476ay ayVar, IBinder iBinder, String str, boolean z, long j) throws RemoteException {
                int i = 0;
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
                    obtain.writeStrongBinder(ayVar != null ? ayVar.asBinder() : null);
                    obtain.writeStrongBinder(iBinder);
                    obtain.writeString(str);
                    if (z) {
                        i = 1;
                    }
                    obtain.writeInt(i);
                    obtain.writeLong(j);
                    this.f1098a.transact(5031, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            /* renamed from: a */
            public void mo4677a(C0476ay ayVar, String str) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
                    obtain.writeStrongBinder(ayVar != null ? ayVar.asBinder() : null);
                    obtain.writeString(str);
                    this.f1098a.transact(5008, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            /* renamed from: a */
            public void mo4678a(C0476ay ayVar, String str, int i, int i2, int i3, boolean z) throws RemoteException {
                int i4 = 0;
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
                    obtain.writeStrongBinder(ayVar != null ? ayVar.asBinder() : null);
                    obtain.writeString(str);
                    obtain.writeInt(i);
                    obtain.writeInt(i2);
                    obtain.writeInt(i3);
                    if (z) {
                        i4 = 1;
                    }
                    obtain.writeInt(i4);
                    this.f1098a.transact(5019, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            /* renamed from: a */
            public void mo4679a(C0476ay ayVar, String str, int i, IBinder iBinder, Bundle bundle) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
                    obtain.writeStrongBinder(ayVar != null ? ayVar.asBinder() : null);
                    obtain.writeString(str);
                    obtain.writeInt(i);
                    obtain.writeStrongBinder(iBinder);
                    if (bundle != null) {
                        obtain.writeInt(1);
                        bundle.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.f1098a.transact(5025, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            /* renamed from: a */
            public void mo4680a(C0476ay ayVar, String str, int i, boolean z, boolean z2) throws RemoteException {
                int i2 = 1;
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
                    obtain.writeStrongBinder(ayVar != null ? ayVar.asBinder() : null);
                    obtain.writeString(str);
                    obtain.writeInt(i);
                    obtain.writeInt(z ? 1 : 0);
                    if (!z2) {
                        i2 = 0;
                    }
                    obtain.writeInt(i2);
                    this.f1098a.transact(5045, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            /* renamed from: a */
            public void mo4681a(C0476ay ayVar, String str, int i, boolean z, boolean z2, boolean z3, boolean z4) throws RemoteException {
                int i2 = 1;
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
                    obtain.writeStrongBinder(ayVar != null ? ayVar.asBinder() : null);
                    obtain.writeString(str);
                    obtain.writeInt(i);
                    obtain.writeInt(z ? 1 : 0);
                    obtain.writeInt(z2 ? 1 : 0);
                    obtain.writeInt(z3 ? 1 : 0);
                    if (!z4) {
                        i2 = 0;
                    }
                    obtain.writeInt(i2);
                    this.f1098a.transact(6501, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            /* renamed from: a */
            public void mo4682a(C0476ay ayVar, String str, long j) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
                    obtain.writeStrongBinder(ayVar != null ? ayVar.asBinder() : null);
                    obtain.writeString(str);
                    obtain.writeLong(j);
                    this.f1098a.transact(5016, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            /* renamed from: a */
            public void mo4683a(C0476ay ayVar, String str, IBinder iBinder, Bundle bundle) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
                    obtain.writeStrongBinder(ayVar != null ? ayVar.asBinder() : null);
                    obtain.writeString(str);
                    obtain.writeStrongBinder(iBinder);
                    if (bundle != null) {
                        obtain.writeInt(1);
                        bundle.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.f1098a.transact(5023, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            /* renamed from: a */
            public void mo4684a(C0476ay ayVar, String str, String str2) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
                    obtain.writeStrongBinder(ayVar != null ? ayVar.asBinder() : null);
                    obtain.writeString(str);
                    obtain.writeString(str2);
                    this.f1098a.transact(5009, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            /* renamed from: a */
            public void mo4685a(C0476ay ayVar, String str, String str2, int i, int i2, int i3, boolean z) throws RemoteException {
                int i4 = 0;
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
                    obtain.writeStrongBinder(ayVar != null ? ayVar.asBinder() : null);
                    obtain.writeString(str);
                    obtain.writeString(str2);
                    obtain.writeInt(i);
                    obtain.writeInt(i2);
                    obtain.writeInt(i3);
                    if (z) {
                        i4 = 1;
                    }
                    obtain.writeInt(i4);
                    this.f1098a.transact(5039, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            /* renamed from: a */
            public void mo4686a(C0476ay ayVar, String str, String str2, boolean z) throws RemoteException {
                int i = 0;
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
                    obtain.writeStrongBinder(ayVar != null ? ayVar.asBinder() : null);
                    obtain.writeString(str);
                    obtain.writeString(str2);
                    if (z) {
                        i = 1;
                    }
                    obtain.writeInt(i);
                    this.f1098a.transact(6002, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            /* renamed from: a */
            public void mo4687a(C0476ay ayVar, String str, boolean z) throws RemoteException {
                int i = 0;
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
                    obtain.writeStrongBinder(ayVar != null ? ayVar.asBinder() : null);
                    obtain.writeString(str);
                    if (z) {
                        i = 1;
                    }
                    obtain.writeInt(i);
                    this.f1098a.transact(5054, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            /* renamed from: a */
            public void mo4688a(C0476ay ayVar, String str, boolean z, long[] jArr) throws RemoteException {
                int i = 0;
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
                    obtain.writeStrongBinder(ayVar != null ? ayVar.asBinder() : null);
                    obtain.writeString(str);
                    if (z) {
                        i = 1;
                    }
                    obtain.writeInt(i);
                    obtain.writeLongArray(jArr);
                    this.f1098a.transact(5011, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            /* renamed from: a */
            public void mo4689a(C0476ay ayVar, boolean z) throws RemoteException {
                int i = 0;
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
                    obtain.writeStrongBinder(ayVar != null ? ayVar.asBinder() : null);
                    if (z) {
                        i = 1;
                    }
                    obtain.writeInt(i);
                    this.f1098a.transact(5063, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            /* renamed from: a */
            public void mo4690a(String str, String str2, int i) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
                    obtain.writeString(str);
                    obtain.writeString(str2);
                    obtain.writeInt(i);
                    this.f1098a.transact(5051, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            /* renamed from: aA */
            public C0344d mo4691aA() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
                    this.f1098a.transact(5502, obtain, obtain2, 0);
                    obtain2.readException();
                    return obtain2.readInt() != 0 ? C0344d.CREATOR.createFromParcel(obtain2) : null;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public IBinder asBinder() {
                return this.f1098a;
            }

            /* renamed from: ax */
            public void mo4692ax() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
                    this.f1098a.transact(5006, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            /* renamed from: ay */
            public C0344d mo4693ay() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
                    this.f1098a.transact(5013, obtain, obtain2, 0);
                    obtain2.readException();
                    return obtain2.readInt() != 0 ? C0344d.CREATOR.createFromParcel(obtain2) : null;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            /* renamed from: az */
            public boolean mo4694az() throws RemoteException {
                boolean z = false;
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
                    this.f1098a.transact(5067, obtain, obtain2, 0);
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

            /* renamed from: b */
            public int mo4695b(byte[] bArr, String str, String[] strArr) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
                    obtain.writeByteArray(bArr);
                    obtain.writeString(str);
                    obtain.writeStringArray(strArr);
                    this.f1098a.transact(5034, obtain, obtain2, 0);
                    obtain2.readException();
                    return obtain2.readInt();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            /* renamed from: b */
            public ParcelFileDescriptor mo4696b(Uri uri) throws RemoteException {
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
                    this.f1098a.transact(6507, obtain, obtain2, 0);
                    obtain2.readException();
                    return obtain2.readInt() != 0 ? (ParcelFileDescriptor) ParcelFileDescriptor.CREATOR.createFromParcel(obtain2) : null;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            /* renamed from: b */
            public void mo4697b(long j) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
                    obtain.writeLong(j);
                    this.f1098a.transact(5059, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            /* renamed from: b */
            public void mo4698b(C0476ay ayVar) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
                    obtain.writeStrongBinder(ayVar != null ? ayVar.asBinder() : null);
                    this.f1098a.transact(5017, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            /* renamed from: b */
            public void mo4699b(C0476ay ayVar, int i, boolean z, boolean z2) throws RemoteException {
                int i2 = 1;
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
                    obtain.writeStrongBinder(ayVar != null ? ayVar.asBinder() : null);
                    obtain.writeInt(i);
                    obtain.writeInt(z ? 1 : 0);
                    if (!z2) {
                        i2 = 0;
                    }
                    obtain.writeInt(i2);
                    this.f1098a.transact(5046, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            /* renamed from: b */
            public void mo4700b(C0476ay ayVar, String str) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
                    obtain.writeStrongBinder(ayVar != null ? ayVar.asBinder() : null);
                    obtain.writeString(str);
                    this.f1098a.transact(5010, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            /* renamed from: b */
            public void mo4701b(C0476ay ayVar, String str, int i, int i2, int i3, boolean z) throws RemoteException {
                int i4 = 0;
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
                    obtain.writeStrongBinder(ayVar != null ? ayVar.asBinder() : null);
                    obtain.writeString(str);
                    obtain.writeInt(i);
                    obtain.writeInt(i2);
                    obtain.writeInt(i3);
                    if (z) {
                        i4 = 1;
                    }
                    obtain.writeInt(i4);
                    this.f1098a.transact(5020, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            /* renamed from: b */
            public void mo4702b(C0476ay ayVar, String str, int i, boolean z, boolean z2) throws RemoteException {
                int i2 = 1;
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
                    obtain.writeStrongBinder(ayVar != null ? ayVar.asBinder() : null);
                    obtain.writeString(str);
                    obtain.writeInt(i);
                    obtain.writeInt(z ? 1 : 0);
                    if (!z2) {
                        i2 = 0;
                    }
                    obtain.writeInt(i2);
                    this.f1098a.transact(5501, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            /* renamed from: b */
            public void mo4703b(C0476ay ayVar, String str, IBinder iBinder, Bundle bundle) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
                    obtain.writeStrongBinder(ayVar != null ? ayVar.asBinder() : null);
                    obtain.writeString(str);
                    obtain.writeStrongBinder(iBinder);
                    if (bundle != null) {
                        obtain.writeInt(1);
                        bundle.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.f1098a.transact(5024, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            /* renamed from: b */
            public void mo4704b(C0476ay ayVar, String str, String str2) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
                    obtain.writeStrongBinder(ayVar != null ? ayVar.asBinder() : null);
                    obtain.writeString(str);
                    obtain.writeString(str2);
                    this.f1098a.transact(5038, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            /* renamed from: b */
            public void mo4705b(C0476ay ayVar, String str, String str2, int i, int i2, int i3, boolean z) throws RemoteException {
                int i4 = 0;
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
                    obtain.writeStrongBinder(ayVar != null ? ayVar.asBinder() : null);
                    obtain.writeString(str);
                    obtain.writeString(str2);
                    obtain.writeInt(i);
                    obtain.writeInt(i2);
                    obtain.writeInt(i3);
                    if (z) {
                        i4 = 1;
                    }
                    obtain.writeInt(i4);
                    this.f1098a.transact(5040, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            /* renamed from: b */
            public void mo4706b(C0476ay ayVar, String str, String str2, boolean z) throws RemoteException {
                int i = 0;
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
                    obtain.writeStrongBinder(ayVar != null ? ayVar.asBinder() : null);
                    obtain.writeString(str);
                    obtain.writeString(str2);
                    if (z) {
                        i = 1;
                    }
                    obtain.writeInt(i);
                    this.f1098a.transact(6506, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            /* renamed from: b */
            public void mo4707b(C0476ay ayVar, String str, boolean z) throws RemoteException {
                int i = 0;
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
                    obtain.writeStrongBinder(ayVar != null ? ayVar.asBinder() : null);
                    obtain.writeString(str);
                    if (z) {
                        i = 1;
                    }
                    obtain.writeInt(i);
                    this.f1098a.transact(6502, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            /* renamed from: b */
            public void mo4708b(C0476ay ayVar, boolean z) throws RemoteException {
                int i = 0;
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
                    obtain.writeStrongBinder(ayVar != null ? ayVar.asBinder() : null);
                    if (z) {
                        i = 1;
                    }
                    obtain.writeInt(i);
                    this.f1098a.transact(GamesClient.STATUS_MULTIPLAYER_ERROR_NOT_TRUSTED_TESTER, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            /* renamed from: c */
            public void mo4709c(C0476ay ayVar) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
                    obtain.writeStrongBinder(ayVar != null ? ayVar.asBinder() : null);
                    this.f1098a.transact(5022, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            /* renamed from: c */
            public void mo4710c(C0476ay ayVar, int i, boolean z, boolean z2) throws RemoteException {
                int i2 = 1;
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
                    obtain.writeStrongBinder(ayVar != null ? ayVar.asBinder() : null);
                    obtain.writeInt(i);
                    obtain.writeInt(z ? 1 : 0);
                    if (!z2) {
                        i2 = 0;
                    }
                    obtain.writeInt(i2);
                    this.f1098a.transact(5048, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            /* renamed from: c */
            public void mo4711c(C0476ay ayVar, String str) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
                    obtain.writeStrongBinder(ayVar != null ? ayVar.asBinder() : null);
                    obtain.writeString(str);
                    this.f1098a.transact(5014, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            /* renamed from: c */
            public void mo4712c(C0476ay ayVar, String str, String str2) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
                    obtain.writeStrongBinder(ayVar != null ? ayVar.asBinder() : null);
                    obtain.writeString(str);
                    obtain.writeString(str2);
                    this.f1098a.transact(5041, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            /* renamed from: c */
            public void mo4713c(C0476ay ayVar, String str, boolean z) throws RemoteException {
                int i = 0;
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
                    obtain.writeStrongBinder(ayVar != null ? ayVar.asBinder() : null);
                    obtain.writeString(str);
                    if (z) {
                        i = 1;
                    }
                    obtain.writeInt(i);
                    this.f1098a.transact(6504, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            /* renamed from: c */
            public void mo4714c(C0476ay ayVar, boolean z) throws RemoteException {
                int i = 0;
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
                    obtain.writeStrongBinder(ayVar != null ? ayVar.asBinder() : null);
                    if (z) {
                        i = 1;
                    }
                    obtain.writeInt(i);
                    this.f1098a.transact(6503, obtain, obtain2, 0);
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
                    this.f1098a.transact(5036, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            /* renamed from: d */
            public void mo4716d(C0476ay ayVar) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
                    obtain.writeStrongBinder(ayVar != null ? ayVar.asBinder() : null);
                    this.f1098a.transact(5026, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            /* renamed from: d */
            public void mo4717d(C0476ay ayVar, int i, boolean z, boolean z2) throws RemoteException {
                int i2 = 1;
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
                    obtain.writeStrongBinder(ayVar != null ? ayVar.asBinder() : null);
                    obtain.writeInt(i);
                    obtain.writeInt(z ? 1 : 0);
                    if (!z2) {
                        i2 = 0;
                    }
                    obtain.writeInt(i2);
                    this.f1098a.transact(6003, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            /* renamed from: d */
            public void mo4718d(C0476ay ayVar, String str) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
                    obtain.writeStrongBinder(ayVar != null ? ayVar.asBinder() : null);
                    obtain.writeString(str);
                    this.f1098a.transact(5018, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            /* renamed from: d */
            public void mo4719d(C0476ay ayVar, String str, boolean z) throws RemoteException {
                int i = 0;
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
                    obtain.writeStrongBinder(ayVar != null ? ayVar.asBinder() : null);
                    obtain.writeString(str);
                    if (z) {
                        i = 1;
                    }
                    obtain.writeInt(i);
                    this.f1098a.transact(6505, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            /* renamed from: e */
            public void mo4720e(C0476ay ayVar) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
                    obtain.writeStrongBinder(ayVar != null ? ayVar.asBinder() : null);
                    this.f1098a.transact(5027, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            /* renamed from: e */
            public void mo4721e(C0476ay ayVar, int i, boolean z, boolean z2) throws RemoteException {
                int i2 = 1;
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
                    obtain.writeStrongBinder(ayVar != null ? ayVar.asBinder() : null);
                    obtain.writeInt(i);
                    obtain.writeInt(z ? 1 : 0);
                    if (!z2) {
                        i2 = 0;
                    }
                    obtain.writeInt(i2);
                    this.f1098a.transact(6004, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            /* renamed from: e */
            public void mo4722e(C0476ay ayVar, String str) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
                    obtain.writeStrongBinder(ayVar != null ? ayVar.asBinder() : null);
                    obtain.writeString(str);
                    this.f1098a.transact(5032, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            /* renamed from: e */
            public void mo4723e(String str, String str2) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
                    obtain.writeString(str);
                    obtain.writeString(str2);
                    this.f1098a.transact(5065, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            /* renamed from: f */
            public void mo4724f(C0476ay ayVar) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
                    obtain.writeStrongBinder(ayVar != null ? ayVar.asBinder() : null);
                    this.f1098a.transact(5047, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            /* renamed from: f */
            public void mo4725f(C0476ay ayVar, String str) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
                    obtain.writeStrongBinder(ayVar != null ? ayVar.asBinder() : null);
                    obtain.writeString(str);
                    this.f1098a.transact(5037, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            /* renamed from: g */
            public void mo4726g(C0476ay ayVar) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
                    obtain.writeStrongBinder(ayVar != null ? ayVar.asBinder() : null);
                    this.f1098a.transact(5049, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            /* renamed from: g */
            public void mo4727g(C0476ay ayVar, String str) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
                    obtain.writeStrongBinder(ayVar != null ? ayVar.asBinder() : null);
                    obtain.writeString(str);
                    this.f1098a.transact(5042, obtain, obtain2, 0);
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
                    this.f1098a.transact(5003, obtain, obtain2, 0);
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
                    this.f1098a.transact(5007, obtain, obtain2, 0);
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
                    this.f1098a.transact(5012, obtain, obtain2, 0);
                    obtain2.readException();
                    return obtain2.readString();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            /* renamed from: h */
            public void mo4731h(C0476ay ayVar) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
                    obtain.writeStrongBinder(ayVar != null ? ayVar.asBinder() : null);
                    this.f1098a.transact(5056, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            /* renamed from: h */
            public void mo4732h(C0476ay ayVar, String str) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
                    obtain.writeStrongBinder(ayVar != null ? ayVar.asBinder() : null);
                    obtain.writeString(str);
                    this.f1098a.transact(5043, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            /* renamed from: h */
            public void mo4733h(String str, int i) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
                    obtain.writeString(str);
                    obtain.writeInt(i);
                    this.f1098a.transact(5029, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            /* renamed from: i */
            public void mo4734i(C0476ay ayVar) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
                    obtain.writeStrongBinder(ayVar != null ? ayVar.asBinder() : null);
                    this.f1098a.transact(5062, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            /* renamed from: i */
            public void mo4735i(C0476ay ayVar, String str) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
                    obtain.writeStrongBinder(ayVar != null ? ayVar.asBinder() : null);
                    obtain.writeString(str);
                    this.f1098a.transact(5052, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            /* renamed from: i */
            public void mo4736i(String str, int i) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
                    obtain.writeString(str);
                    obtain.writeInt(i);
                    this.f1098a.transact(5028, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            /* renamed from: j */
            public int mo4737j(C0476ay ayVar, String str) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
                    obtain.writeStrongBinder(ayVar != null ? ayVar.asBinder() : null);
                    obtain.writeString(str);
                    this.f1098a.transact(5053, obtain, obtain2, 0);
                    obtain2.readException();
                    return obtain2.readInt();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            /* renamed from: j */
            public void mo4738j(String str, int i) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
                    obtain.writeString(str);
                    obtain.writeInt(i);
                    this.f1098a.transact(5055, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            /* renamed from: k */
            public void mo4739k(C0476ay ayVar, String str) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
                    obtain.writeStrongBinder(ayVar != null ? ayVar.asBinder() : null);
                    obtain.writeString(str);
                    this.f1098a.transact(5061, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            /* renamed from: l */
            public void mo4740l(C0476ay ayVar, String str) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
                    obtain.writeStrongBinder(ayVar != null ? ayVar.asBinder() : null);
                    obtain.writeString(str);
                    this.f1098a.transact(5057, obtain, obtain2, 0);
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
                    this.f1098a.transact(5068, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            /* renamed from: u */
            public String mo4742u(String str) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
                    obtain.writeString(str);
                    this.f1098a.transact(5064, obtain, obtain2, 0);
                    obtain2.readException();
                    return obtain2.readString();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            /* renamed from: v */
            public String mo4743v(String str) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
                    obtain.writeString(str);
                    this.f1098a.transact(5035, obtain, obtain2, 0);
                    obtain2.readException();
                    return obtain2.readString();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            /* renamed from: w */
            public void mo4744w(String str) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
                    obtain.writeString(str);
                    this.f1098a.transact(5050, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            /* renamed from: x */
            public int mo4745x(String str) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
                    obtain.writeString(str);
                    this.f1098a.transact(5060, obtain, obtain2, 0);
                    obtain2.readException();
                    return obtain2.readInt();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            /* renamed from: y */
            public Uri mo4746y(String str) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
                    obtain.writeString(str);
                    this.f1098a.transact(5066, obtain, obtain2, 0);
                    obtain2.readException();
                    return obtain2.readInt() != 0 ? (Uri) Uri.CREATOR.createFromParcel(obtain2) : null;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            /* renamed from: z */
            public Bundle mo4747z() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
                    this.f1098a.transact(5004, obtain, obtain2, 0);
                    obtain2.readException();
                    return obtain2.readInt() != 0 ? (Bundle) Bundle.CREATOR.createFromParcel(obtain2) : null;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }
        }

        /* renamed from: o */
        public static C0479az m1216o(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.games.internal.IGamesService");
            return (queryLocalInterface == null || !(queryLocalInterface instanceof C0479az)) ? new C0481a(iBinder) : (C0479az) queryLocalInterface;
        }

        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v1, resolved type: android.net.Uri} */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v188, resolved type: android.os.Bundle} */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v192, resolved type: android.os.Bundle} */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v199, resolved type: android.os.Bundle} */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v256, resolved type: android.os.Bundle} */
        /* JADX WARNING: type inference failed for: r0v0 */
        /* JADX WARNING: type inference failed for: r0v270 */
        /* JADX WARNING: type inference failed for: r0v271 */
        /* JADX WARNING: type inference failed for: r0v272 */
        /* JADX WARNING: type inference failed for: r0v273 */
        /* JADX WARNING: type inference failed for: r0v274 */
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
                r10.mo4668a((long) r0)
                r13.writeNoException()
                goto L_0x000a
            L_0x0021:
                java.lang.String r0 = "com.google.android.gms.games.internal.IGamesService"
                r12.enforceInterface(r0)
                android.os.IBinder r0 = r12.readStrongBinder()
                com.google.android.gms.internal.ay r0 = com.google.android.gms.internal.C0476ay.C0477a.m1103n(r0)
                r10.mo4670a((com.google.android.gms.internal.C0476ay) r0)
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
                android.os.Bundle r0 = r10.mo4747z()
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
                r10.mo4669a((android.os.IBinder) r1, (android.os.Bundle) r0)
                r13.writeNoException()
                goto L_0x000a
            L_0x007c:
                java.lang.String r0 = "com.google.android.gms.games.internal.IGamesService"
                r12.enforceInterface(r0)
                r10.mo4692ax()
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
                java.lang.String r0 = r10.mo4742u(r0)
                r13.writeNoException()
                r13.writeString(r0)
                goto L_0x000a
            L_0x00ae:
                java.lang.String r0 = "com.google.android.gms.games.internal.IGamesService"
                r12.enforceInterface(r0)
                java.lang.String r0 = r12.readString()
                java.lang.String r1 = r12.readString()
                r10.mo4723e((java.lang.String) r0, (java.lang.String) r1)
                r13.writeNoException()
                goto L_0x000a
            L_0x00c3:
                java.lang.String r0 = "com.google.android.gms.games.internal.IGamesService"
                r12.enforceInterface(r0)
                android.os.IBinder r0 = r12.readStrongBinder()
                com.google.android.gms.internal.ay r0 = com.google.android.gms.internal.C0476ay.C0477a.m1103n(r0)
                java.lang.String r1 = r12.readString()
                r10.mo4677a((com.google.android.gms.internal.C0476ay) r0, (java.lang.String) r1)
                r13.writeNoException()
                goto L_0x000a
            L_0x00dc:
                java.lang.String r0 = "com.google.android.gms.games.internal.IGamesService"
                r12.enforceInterface(r0)
                android.os.IBinder r0 = r12.readStrongBinder()
                com.google.android.gms.internal.ay r0 = com.google.android.gms.internal.C0476ay.C0477a.m1103n(r0)
                java.lang.String r1 = r12.readString()
                java.lang.String r2 = r12.readString()
                r10.mo4684a((com.google.android.gms.internal.C0476ay) r0, (java.lang.String) r1, (java.lang.String) r2)
                r13.writeNoException()
                goto L_0x000a
            L_0x00f9:
                java.lang.String r0 = "com.google.android.gms.games.internal.IGamesService"
                r12.enforceInterface(r0)
                android.os.IBinder r0 = r12.readStrongBinder()
                com.google.android.gms.internal.ay r0 = com.google.android.gms.internal.C0476ay.C0477a.m1103n(r0)
                java.lang.String r1 = r12.readString()
                r10.mo4700b((com.google.android.gms.internal.C0476ay) r0, (java.lang.String) r1)
                r13.writeNoException()
                goto L_0x000a
            L_0x0112:
                java.lang.String r0 = "com.google.android.gms.games.internal.IGamesService"
                r12.enforceInterface(r0)
                android.os.IBinder r0 = r12.readStrongBinder()
                com.google.android.gms.internal.ay r1 = com.google.android.gms.internal.C0476ay.C0477a.m1103n(r0)
                java.lang.String r2 = r12.readString()
                int r0 = r12.readInt()
                if (r0 == 0) goto L_0x0136
                r0 = r9
            L_0x012a:
                long[] r3 = r12.createLongArray()
                r10.mo4688a((com.google.android.gms.internal.C0476ay) r1, (java.lang.String) r2, (boolean) r0, (long[]) r3)
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
                com.google.android.gms.common.data.d r0 = r10.mo4693ay()
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
                com.google.android.gms.internal.ay r0 = com.google.android.gms.internal.C0476ay.C0477a.m1103n(r0)
                java.lang.String r1 = r12.readString()
                r10.mo4711c((com.google.android.gms.internal.C0476ay) r0, (java.lang.String) r1)
                r13.writeNoException()
                goto L_0x000a
            L_0x017d:
                java.lang.String r0 = "com.google.android.gms.games.internal.IGamesService"
                r12.enforceInterface(r0)
                android.os.IBinder r0 = r12.readStrongBinder()
                com.google.android.gms.internal.ay r1 = com.google.android.gms.internal.C0476ay.C0477a.m1103n(r0)
                int r2 = r12.readInt()
                int r0 = r12.readInt()
                if (r0 == 0) goto L_0x01a4
                r0 = r9
            L_0x0195:
                int r3 = r12.readInt()
                if (r3 == 0) goto L_0x019c
                r7 = r9
            L_0x019c:
                r10.mo4672a((com.google.android.gms.internal.C0476ay) r1, (int) r2, (boolean) r0, (boolean) r7)
                r13.writeNoException()
                goto L_0x000a
            L_0x01a4:
                r0 = r7
                goto L_0x0195
            L_0x01a6:
                java.lang.String r0 = "com.google.android.gms.games.internal.IGamesService"
                r12.enforceInterface(r0)
                android.os.IBinder r0 = r12.readStrongBinder()
                com.google.android.gms.internal.ay r0 = com.google.android.gms.internal.C0476ay.C0477a.m1103n(r0)
                java.lang.String r1 = r12.readString()
                long r2 = r12.readLong()
                r10.mo4682a((com.google.android.gms.internal.C0476ay) r0, (java.lang.String) r1, (long) r2)
                r13.writeNoException()
                goto L_0x000a
            L_0x01c3:
                java.lang.String r0 = "com.google.android.gms.games.internal.IGamesService"
                r12.enforceInterface(r0)
                android.os.IBinder r0 = r12.readStrongBinder()
                com.google.android.gms.internal.ay r0 = com.google.android.gms.internal.C0476ay.C0477a.m1103n(r0)
                r10.mo4698b((com.google.android.gms.internal.C0476ay) r0)
                r13.writeNoException()
                goto L_0x000a
            L_0x01d8:
                java.lang.String r0 = "com.google.android.gms.games.internal.IGamesService"
                r12.enforceInterface(r0)
                android.os.IBinder r0 = r12.readStrongBinder()
                com.google.android.gms.internal.ay r0 = com.google.android.gms.internal.C0476ay.C0477a.m1103n(r0)
                java.lang.String r1 = r12.readString()
                r10.mo4718d(r0, r1)
                r13.writeNoException()
                goto L_0x000a
            L_0x01f1:
                java.lang.String r0 = "com.google.android.gms.games.internal.IGamesService"
                r12.enforceInterface(r0)
                android.os.IBinder r0 = r12.readStrongBinder()
                com.google.android.gms.internal.ay r1 = com.google.android.gms.internal.C0476ay.C0477a.m1103n(r0)
                java.lang.String r2 = r12.readString()
                int r3 = r12.readInt()
                int r4 = r12.readInt()
                int r5 = r12.readInt()
                int r0 = r12.readInt()
                if (r0 == 0) goto L_0x021e
                r6 = r9
            L_0x0215:
                r0 = r10
                r0.mo4678a(r1, r2, r3, r4, r5, r6)
                r13.writeNoException()
                goto L_0x000a
            L_0x021e:
                r6 = r7
                goto L_0x0215
            L_0x0220:
                java.lang.String r0 = "com.google.android.gms.games.internal.IGamesService"
                r12.enforceInterface(r0)
                android.os.IBinder r0 = r12.readStrongBinder()
                com.google.android.gms.internal.ay r1 = com.google.android.gms.internal.C0476ay.C0477a.m1103n(r0)
                java.lang.String r2 = r12.readString()
                int r3 = r12.readInt()
                int r4 = r12.readInt()
                int r5 = r12.readInt()
                int r0 = r12.readInt()
                if (r0 == 0) goto L_0x024d
                r6 = r9
            L_0x0244:
                r0 = r10
                r0.mo4701b(r1, r2, r3, r4, r5, r6)
                r13.writeNoException()
                goto L_0x000a
            L_0x024d:
                r6 = r7
                goto L_0x0244
            L_0x024f:
                java.lang.String r1 = "com.google.android.gms.games.internal.IGamesService"
                r12.enforceInterface(r1)
                android.os.IBinder r1 = r12.readStrongBinder()
                com.google.android.gms.internal.ay r1 = com.google.android.gms.internal.C0476ay.C0477a.m1103n(r1)
                int r2 = r12.readInt()
                if (r2 == 0) goto L_0x026a
                android.os.Parcelable$Creator r0 = android.os.Bundle.CREATOR
                java.lang.Object r0 = r0.createFromParcel(r12)
                android.os.Bundle r0 = (android.os.Bundle) r0
            L_0x026a:
                int r2 = r12.readInt()
                int r3 = r12.readInt()
                r10.mo4674a((com.google.android.gms.internal.C0476ay) r1, (android.os.Bundle) r0, (int) r2, (int) r3)
                r13.writeNoException()
                goto L_0x000a
            L_0x027a:
                java.lang.String r0 = "com.google.android.gms.games.internal.IGamesService"
                r12.enforceInterface(r0)
                android.os.IBinder r0 = r12.readStrongBinder()
                com.google.android.gms.internal.ay r0 = com.google.android.gms.internal.C0476ay.C0477a.m1103n(r0)
                r10.mo4709c(r0)
                r13.writeNoException()
                goto L_0x000a
            L_0x028f:
                java.lang.String r1 = "com.google.android.gms.games.internal.IGamesService"
                r12.enforceInterface(r1)
                android.os.IBinder r1 = r12.readStrongBinder()
                com.google.android.gms.internal.ay r1 = com.google.android.gms.internal.C0476ay.C0477a.m1103n(r1)
                java.lang.String r2 = r12.readString()
                android.os.IBinder r3 = r12.readStrongBinder()
                int r4 = r12.readInt()
                if (r4 == 0) goto L_0x02b2
                android.os.Parcelable$Creator r0 = android.os.Bundle.CREATOR
                java.lang.Object r0 = r0.createFromParcel(r12)
                android.os.Bundle r0 = (android.os.Bundle) r0
            L_0x02b2:
                r10.mo4683a((com.google.android.gms.internal.C0476ay) r1, (java.lang.String) r2, (android.os.IBinder) r3, (android.os.Bundle) r0)
                r13.writeNoException()
                goto L_0x000a
            L_0x02ba:
                java.lang.String r1 = "com.google.android.gms.games.internal.IGamesService"
                r12.enforceInterface(r1)
                android.os.IBinder r1 = r12.readStrongBinder()
                com.google.android.gms.internal.ay r1 = com.google.android.gms.internal.C0476ay.C0477a.m1103n(r1)
                java.lang.String r2 = r12.readString()
                android.os.IBinder r3 = r12.readStrongBinder()
                int r4 = r12.readInt()
                if (r4 == 0) goto L_0x02dd
                android.os.Parcelable$Creator r0 = android.os.Bundle.CREATOR
                java.lang.Object r0 = r0.createFromParcel(r12)
                android.os.Bundle r0 = (android.os.Bundle) r0
            L_0x02dd:
                r10.mo4703b((com.google.android.gms.internal.C0476ay) r1, (java.lang.String) r2, (android.os.IBinder) r3, (android.os.Bundle) r0)
                r13.writeNoException()
                goto L_0x000a
            L_0x02e5:
                java.lang.String r1 = "com.google.android.gms.games.internal.IGamesService"
                r12.enforceInterface(r1)
                android.os.IBinder r1 = r12.readStrongBinder()
                com.google.android.gms.internal.ay r1 = com.google.android.gms.internal.C0476ay.C0477a.m1103n(r1)
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
                r0.mo4679a((com.google.android.gms.internal.C0476ay) r1, (java.lang.String) r2, (int) r3, (android.os.IBinder) r4, (android.os.Bundle) r5)
                r13.writeNoException()
                goto L_0x000a
            L_0x0316:
                r5 = r0
                goto L_0x030d
            L_0x0318:
                java.lang.String r0 = "com.google.android.gms.games.internal.IGamesService"
                r12.enforceInterface(r0)
                android.os.IBinder r0 = r12.readStrongBinder()
                com.google.android.gms.internal.ay r0 = com.google.android.gms.internal.C0476ay.C0477a.m1103n(r0)
                r10.mo4716d(r0)
                r13.writeNoException()
                goto L_0x000a
            L_0x032d:
                java.lang.String r0 = "com.google.android.gms.games.internal.IGamesService"
                r12.enforceInterface(r0)
                android.os.IBinder r0 = r12.readStrongBinder()
                com.google.android.gms.internal.ay r0 = com.google.android.gms.internal.C0476ay.C0477a.m1103n(r0)
                r10.mo4720e(r0)
                r13.writeNoException()
                goto L_0x000a
            L_0x0342:
                java.lang.String r0 = "com.google.android.gms.games.internal.IGamesService"
                r12.enforceInterface(r0)
                java.lang.String r0 = r12.readString()
                int r1 = r12.readInt()
                r10.mo4736i((java.lang.String) r0, (int) r1)
                r13.writeNoException()
                goto L_0x000a
            L_0x0357:
                java.lang.String r0 = "com.google.android.gms.games.internal.IGamesService"
                r12.enforceInterface(r0)
                java.lang.String r0 = r12.readString()
                int r1 = r12.readInt()
                r10.mo4733h((java.lang.String) r0, (int) r1)
                r13.writeNoException()
                goto L_0x000a
            L_0x036c:
                java.lang.String r0 = "com.google.android.gms.games.internal.IGamesService"
                r12.enforceInterface(r0)
                android.os.IBinder r0 = r12.readStrongBinder()
                com.google.android.gms.internal.ay r0 = com.google.android.gms.internal.C0476ay.C0477a.m1103n(r0)
                long r1 = r12.readLong()
                r10.mo4673a((com.google.android.gms.internal.C0476ay) r0, (long) r1)
                r13.writeNoException()
                goto L_0x000a
            L_0x0385:
                java.lang.String r0 = "com.google.android.gms.games.internal.IGamesService"
                r12.enforceInterface(r0)
                long r0 = r12.readLong()
                r10.mo4697b((long) r0)
                r13.writeNoException()
                goto L_0x000a
            L_0x0396:
                java.lang.String r1 = "com.google.android.gms.games.internal.IGamesService"
                r12.enforceInterface(r1)
                android.os.IBinder r1 = r12.readStrongBinder()
                com.google.android.gms.internal.ay r1 = com.google.android.gms.internal.C0476ay.C0477a.m1103n(r1)
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
                r0.mo4675a((com.google.android.gms.internal.C0476ay) r1, (android.os.IBinder) r2, (int) r3, (java.lang.String[]) r4, (android.os.Bundle) r5, (boolean) r6, (long) r7)
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
                com.google.android.gms.internal.ay r1 = com.google.android.gms.internal.C0476ay.C0477a.m1103n(r0)
                android.os.IBinder r2 = r12.readStrongBinder()
                java.lang.String r3 = r12.readString()
                int r0 = r12.readInt()
                if (r0 == 0) goto L_0x03ff
                r4 = r9
            L_0x03f2:
                long r5 = r12.readLong()
                r0 = r10
                r0.mo4676a((com.google.android.gms.internal.C0476ay) r1, (android.os.IBinder) r2, (java.lang.String) r3, (boolean) r4, (long) r5)
                r13.writeNoException()
                goto L_0x000a
            L_0x03ff:
                r4 = r7
                goto L_0x03f2
            L_0x0401:
                java.lang.String r0 = "com.google.android.gms.games.internal.IGamesService"
                r12.enforceInterface(r0)
                android.os.IBinder r0 = r12.readStrongBinder()
                com.google.android.gms.internal.ay r0 = com.google.android.gms.internal.C0476ay.C0477a.m1103n(r0)
                java.lang.String r1 = r12.readString()
                r10.mo4722e((com.google.android.gms.internal.C0476ay) r0, (java.lang.String) r1)
                r13.writeNoException()
                goto L_0x000a
            L_0x041a:
                java.lang.String r0 = "com.google.android.gms.games.internal.IGamesService"
                r12.enforceInterface(r0)
                android.os.IBinder r0 = r12.readStrongBinder()
                com.google.android.gms.internal.ay r0 = com.google.android.gms.internal.C0476ay.C0477a.m1103n(r0)
                byte[] r1 = r12.createByteArray()
                java.lang.String r2 = r12.readString()
                java.lang.String r3 = r12.readString()
                int r0 = r10.mo4667a((com.google.android.gms.internal.C0476ay) r0, (byte[]) r1, (java.lang.String) r2, (java.lang.String) r3)
                r13.writeNoException()
                r13.writeInt(r0)
                goto L_0x000a
            L_0x043f:
                java.lang.String r0 = "com.google.android.gms.games.internal.IGamesService"
                r12.enforceInterface(r0)
                byte[] r0 = r12.createByteArray()
                java.lang.String r1 = r12.readString()
                java.lang.String[] r2 = r12.createStringArray()
                int r0 = r10.mo4695b((byte[]) r0, (java.lang.String) r1, (java.lang.String[]) r2)
                r13.writeNoException()
                r13.writeInt(r0)
                goto L_0x000a
            L_0x045c:
                java.lang.String r0 = "com.google.android.gms.games.internal.IGamesService"
                r12.enforceInterface(r0)
                java.lang.String r0 = r12.readString()
                java.lang.String r0 = r10.mo4743v(r0)
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
                com.google.android.gms.internal.ay r0 = com.google.android.gms.internal.C0476ay.C0477a.m1103n(r0)
                java.lang.String r1 = r12.readString()
                r10.mo4725f(r0, r1)
                r13.writeNoException()
                goto L_0x000a
            L_0x049b:
                java.lang.String r0 = "com.google.android.gms.games.internal.IGamesService"
                r12.enforceInterface(r0)
                android.os.IBinder r0 = r12.readStrongBinder()
                com.google.android.gms.internal.ay r0 = com.google.android.gms.internal.C0476ay.C0477a.m1103n(r0)
                java.lang.String r1 = r12.readString()
                java.lang.String r2 = r12.readString()
                r10.mo4704b((com.google.android.gms.internal.C0476ay) r0, (java.lang.String) r1, (java.lang.String) r2)
                r13.writeNoException()
                goto L_0x000a
            L_0x04b8:
                java.lang.String r0 = "com.google.android.gms.games.internal.IGamesService"
                r12.enforceInterface(r0)
                android.os.IBinder r0 = r12.readStrongBinder()
                com.google.android.gms.internal.ay r1 = com.google.android.gms.internal.C0476ay.C0477a.m1103n(r0)
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
                r0.mo4685a((com.google.android.gms.internal.C0476ay) r1, (java.lang.String) r2, (java.lang.String) r3, (int) r4, (int) r5, (int) r6, (boolean) r7)
                r13.writeNoException()
                goto L_0x000a
            L_0x04e9:
                java.lang.String r0 = "com.google.android.gms.games.internal.IGamesService"
                r12.enforceInterface(r0)
                android.os.IBinder r0 = r12.readStrongBinder()
                com.google.android.gms.internal.ay r1 = com.google.android.gms.internal.C0476ay.C0477a.m1103n(r0)
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
                r0.mo4705b(r1, r2, r3, r4, r5, r6, r7)
                r13.writeNoException()
                goto L_0x000a
            L_0x051a:
                java.lang.String r0 = "com.google.android.gms.games.internal.IGamesService"
                r12.enforceInterface(r0)
                android.os.IBinder r0 = r12.readStrongBinder()
                com.google.android.gms.internal.ay r0 = com.google.android.gms.internal.C0476ay.C0477a.m1103n(r0)
                java.lang.String r1 = r12.readString()
                java.lang.String r2 = r12.readString()
                r10.mo4712c((com.google.android.gms.internal.C0476ay) r0, (java.lang.String) r1, (java.lang.String) r2)
                r13.writeNoException()
                goto L_0x000a
            L_0x0537:
                java.lang.String r0 = "com.google.android.gms.games.internal.IGamesService"
                r12.enforceInterface(r0)
                android.os.IBinder r0 = r12.readStrongBinder()
                com.google.android.gms.internal.ay r0 = com.google.android.gms.internal.C0476ay.C0477a.m1103n(r0)
                java.lang.String r1 = r12.readString()
                r10.mo4727g(r0, r1)
                r13.writeNoException()
                goto L_0x000a
            L_0x0550:
                java.lang.String r0 = "com.google.android.gms.games.internal.IGamesService"
                r12.enforceInterface(r0)
                android.os.IBinder r0 = r12.readStrongBinder()
                com.google.android.gms.internal.ay r0 = com.google.android.gms.internal.C0476ay.C0477a.m1103n(r0)
                java.lang.String r1 = r12.readString()
                r10.mo4732h((com.google.android.gms.internal.C0476ay) r0, (java.lang.String) r1)
                r13.writeNoException()
                goto L_0x000a
            L_0x0569:
                java.lang.String r0 = "com.google.android.gms.games.internal.IGamesService"
                r12.enforceInterface(r0)
                android.os.IBinder r0 = r12.readStrongBinder()
                com.google.android.gms.internal.ay r1 = com.google.android.gms.internal.C0476ay.C0477a.m1103n(r0)
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
                r0.mo4671a((com.google.android.gms.internal.C0476ay) r1, (int) r2, (int) r3, (boolean) r4, (boolean) r5)
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
                com.google.android.gms.internal.ay r1 = com.google.android.gms.internal.C0476ay.C0477a.m1103n(r0)
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
                r0.mo4680a((com.google.android.gms.internal.C0476ay) r1, (java.lang.String) r2, (int) r3, (boolean) r4, (boolean) r5)
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
                com.google.android.gms.internal.ay r1 = com.google.android.gms.internal.C0476ay.C0477a.m1103n(r0)
                int r2 = r12.readInt()
                int r0 = r12.readInt()
                if (r0 == 0) goto L_0x05f0
                r0 = r9
            L_0x05e1:
                int r3 = r12.readInt()
                if (r3 == 0) goto L_0x05e8
                r7 = r9
            L_0x05e8:
                r10.mo4699b((com.google.android.gms.internal.C0476ay) r1, (int) r2, (boolean) r0, (boolean) r7)
                r13.writeNoException()
                goto L_0x000a
            L_0x05f0:
                r0 = r7
                goto L_0x05e1
            L_0x05f2:
                java.lang.String r0 = "com.google.android.gms.games.internal.IGamesService"
                r12.enforceInterface(r0)
                android.os.IBinder r0 = r12.readStrongBinder()
                com.google.android.gms.internal.ay r0 = com.google.android.gms.internal.C0476ay.C0477a.m1103n(r0)
                r10.mo4724f(r0)
                r13.writeNoException()
                goto L_0x000a
            L_0x0607:
                java.lang.String r0 = "com.google.android.gms.games.internal.IGamesService"
                r12.enforceInterface(r0)
                android.os.IBinder r0 = r12.readStrongBinder()
                com.google.android.gms.internal.ay r1 = com.google.android.gms.internal.C0476ay.C0477a.m1103n(r0)
                int r2 = r12.readInt()
                int r0 = r12.readInt()
                if (r0 == 0) goto L_0x062e
                r0 = r9
            L_0x061f:
                int r3 = r12.readInt()
                if (r3 == 0) goto L_0x0626
                r7 = r9
            L_0x0626:
                r10.mo4710c(r1, r2, r0, r7)
                r13.writeNoException()
                goto L_0x000a
            L_0x062e:
                r0 = r7
                goto L_0x061f
            L_0x0630:
                java.lang.String r0 = "com.google.android.gms.games.internal.IGamesService"
                r12.enforceInterface(r0)
                android.os.IBinder r0 = r12.readStrongBinder()
                com.google.android.gms.internal.ay r0 = com.google.android.gms.internal.C0476ay.C0477a.m1103n(r0)
                r10.mo4726g(r0)
                r13.writeNoException()
                goto L_0x000a
            L_0x0645:
                java.lang.String r0 = "com.google.android.gms.games.internal.IGamesService"
                r12.enforceInterface(r0)
                java.lang.String r0 = r12.readString()
                r10.mo4744w(r0)
                r13.writeNoException()
                goto L_0x000a
            L_0x0656:
                java.lang.String r0 = "com.google.android.gms.games.internal.IGamesService"
                r12.enforceInterface(r0)
                java.lang.String r0 = r12.readString()
                java.lang.String r1 = r12.readString()
                int r2 = r12.readInt()
                r10.mo4690a((java.lang.String) r0, (java.lang.String) r1, (int) r2)
                r13.writeNoException()
                goto L_0x000a
            L_0x066f:
                java.lang.String r0 = "com.google.android.gms.games.internal.IGamesService"
                r12.enforceInterface(r0)
                android.os.IBinder r0 = r12.readStrongBinder()
                com.google.android.gms.internal.ay r0 = com.google.android.gms.internal.C0476ay.C0477a.m1103n(r0)
                java.lang.String r1 = r12.readString()
                r10.mo4735i((com.google.android.gms.internal.C0476ay) r0, (java.lang.String) r1)
                r13.writeNoException()
                goto L_0x000a
            L_0x0688:
                java.lang.String r0 = "com.google.android.gms.games.internal.IGamesService"
                r12.enforceInterface(r0)
                android.os.IBinder r0 = r12.readStrongBinder()
                com.google.android.gms.internal.ay r0 = com.google.android.gms.internal.C0476ay.C0477a.m1103n(r0)
                java.lang.String r1 = r12.readString()
                int r0 = r10.mo4737j((com.google.android.gms.internal.C0476ay) r0, (java.lang.String) r1)
                r13.writeNoException()
                r13.writeInt(r0)
                goto L_0x000a
            L_0x06a5:
                java.lang.String r0 = "com.google.android.gms.games.internal.IGamesService"
                r12.enforceInterface(r0)
                java.lang.String r0 = r12.readString()
                int r0 = r10.mo4745x(r0)
                r13.writeNoException()
                r13.writeInt(r0)
                goto L_0x000a
            L_0x06ba:
                java.lang.String r0 = "com.google.android.gms.games.internal.IGamesService"
                r12.enforceInterface(r0)
                android.os.IBinder r0 = r12.readStrongBinder()
                com.google.android.gms.internal.ay r0 = com.google.android.gms.internal.C0476ay.C0477a.m1103n(r0)
                java.lang.String r1 = r12.readString()
                int r2 = r12.readInt()
                if (r2 == 0) goto L_0x06d2
                r7 = r9
            L_0x06d2:
                r10.mo4687a((com.google.android.gms.internal.C0476ay) r0, (java.lang.String) r1, (boolean) r7)
                r13.writeNoException()
                goto L_0x000a
            L_0x06da:
                java.lang.String r0 = "com.google.android.gms.games.internal.IGamesService"
                r12.enforceInterface(r0)
                android.os.IBinder r0 = r12.readStrongBinder()
                com.google.android.gms.internal.ay r0 = com.google.android.gms.internal.C0476ay.C0477a.m1103n(r0)
                java.lang.String r1 = r12.readString()
                r10.mo4739k(r0, r1)
                r13.writeNoException()
                goto L_0x000a
            L_0x06f3:
                java.lang.String r0 = "com.google.android.gms.games.internal.IGamesService"
                r12.enforceInterface(r0)
                java.lang.String r0 = r12.readString()
                int r1 = r12.readInt()
                r10.mo4738j((java.lang.String) r0, (int) r1)
                r13.writeNoException()
                goto L_0x000a
            L_0x0708:
                java.lang.String r0 = "com.google.android.gms.games.internal.IGamesService"
                r12.enforceInterface(r0)
                boolean r0 = r10.mo4694az()
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
                com.google.android.gms.internal.ay r0 = com.google.android.gms.internal.C0476ay.C0477a.m1103n(r0)
                r10.mo4731h(r0)
                r13.writeNoException()
                goto L_0x000a
            L_0x0745:
                java.lang.String r0 = "com.google.android.gms.games.internal.IGamesService"
                r12.enforceInterface(r0)
                android.os.IBinder r0 = r12.readStrongBinder()
                com.google.android.gms.internal.ay r0 = com.google.android.gms.internal.C0476ay.C0477a.m1103n(r0)
                java.lang.String r1 = r12.readString()
                r10.mo4740l(r0, r1)
                r13.writeNoException()
                goto L_0x000a
            L_0x075e:
                java.lang.String r0 = "com.google.android.gms.games.internal.IGamesService"
                r12.enforceInterface(r0)
                android.os.IBinder r0 = r12.readStrongBinder()
                com.google.android.gms.internal.ay r0 = com.google.android.gms.internal.C0476ay.C0477a.m1103n(r0)
                r10.mo4734i(r0)
                r13.writeNoException()
                goto L_0x000a
            L_0x0773:
                java.lang.String r0 = "com.google.android.gms.games.internal.IGamesService"
                r12.enforceInterface(r0)
                android.os.IBinder r0 = r12.readStrongBinder()
                com.google.android.gms.internal.ay r0 = com.google.android.gms.internal.C0476ay.C0477a.m1103n(r0)
                int r1 = r12.readInt()
                if (r1 == 0) goto L_0x0787
                r7 = r9
            L_0x0787:
                r10.mo4689a((com.google.android.gms.internal.C0476ay) r0, (boolean) r7)
                r13.writeNoException()
                goto L_0x000a
            L_0x078f:
                java.lang.String r0 = "com.google.android.gms.games.internal.IGamesService"
                r12.enforceInterface(r0)
                java.lang.String r0 = r12.readString()
                android.net.Uri r0 = r10.mo4746y(r0)
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
                com.google.android.gms.internal.ay r1 = com.google.android.gms.internal.C0476ay.C0477a.m1103n(r0)
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
                r0.mo4702b(r1, r2, r3, r4, r5)
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
                com.google.android.gms.common.data.d r0 = r10.mo4691aA()
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
                com.google.android.gms.internal.ay r0 = com.google.android.gms.internal.C0476ay.C0477a.m1103n(r0)
                int r1 = r12.readInt()
                if (r1 == 0) goto L_0x080d
                r7 = r9
            L_0x080d:
                r10.mo4708b((com.google.android.gms.internal.C0476ay) r0, (boolean) r7)
                r13.writeNoException()
                goto L_0x000a
            L_0x0815:
                java.lang.String r0 = "com.google.android.gms.games.internal.IGamesService"
                r12.enforceInterface(r0)
                android.os.IBinder r0 = r12.readStrongBinder()
                com.google.android.gms.internal.ay r0 = com.google.android.gms.internal.C0476ay.C0477a.m1103n(r0)
                java.lang.String r1 = r12.readString()
                java.lang.String r2 = r12.readString()
                int r3 = r12.readInt()
                if (r3 == 0) goto L_0x0831
                r7 = r9
            L_0x0831:
                r10.mo4686a((com.google.android.gms.internal.C0476ay) r0, (java.lang.String) r1, (java.lang.String) r2, (boolean) r7)
                r13.writeNoException()
                goto L_0x000a
            L_0x0839:
                java.lang.String r0 = "com.google.android.gms.games.internal.IGamesService"
                r12.enforceInterface(r0)
                android.os.IBinder r0 = r12.readStrongBinder()
                com.google.android.gms.internal.ay r1 = com.google.android.gms.internal.C0476ay.C0477a.m1103n(r0)
                int r2 = r12.readInt()
                int r0 = r12.readInt()
                if (r0 == 0) goto L_0x0860
                r0 = r9
            L_0x0851:
                int r3 = r12.readInt()
                if (r3 == 0) goto L_0x0858
                r7 = r9
            L_0x0858:
                r10.mo4717d(r1, r2, r0, r7)
                r13.writeNoException()
                goto L_0x000a
            L_0x0860:
                r0 = r7
                goto L_0x0851
            L_0x0862:
                java.lang.String r0 = "com.google.android.gms.games.internal.IGamesService"
                r12.enforceInterface(r0)
                android.os.IBinder r0 = r12.readStrongBinder()
                com.google.android.gms.internal.ay r1 = com.google.android.gms.internal.C0476ay.C0477a.m1103n(r0)
                int r2 = r12.readInt()
                int r0 = r12.readInt()
                if (r0 == 0) goto L_0x0889
                r0 = r9
            L_0x087a:
                int r3 = r12.readInt()
                if (r3 == 0) goto L_0x0881
                r7 = r9
            L_0x0881:
                r10.mo4721e(r1, r2, r0, r7)
                r13.writeNoException()
                goto L_0x000a
            L_0x0889:
                r0 = r7
                goto L_0x087a
            L_0x088b:
                java.lang.String r0 = "com.google.android.gms.games.internal.IGamesService"
                r12.enforceInterface(r0)
                android.os.IBinder r0 = r12.readStrongBinder()
                com.google.android.gms.internal.ay r1 = com.google.android.gms.internal.C0476ay.C0477a.m1103n(r0)
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
                r0.mo4681a((com.google.android.gms.internal.C0476ay) r1, (java.lang.String) r2, (int) r3, (boolean) r4, (boolean) r5, (boolean) r6, (boolean) r7)
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
                com.google.android.gms.internal.ay r0 = com.google.android.gms.internal.C0476ay.C0477a.m1103n(r0)
                java.lang.String r1 = r12.readString()
                int r2 = r12.readInt()
                if (r2 == 0) goto L_0x08e3
                r7 = r9
            L_0x08e3:
                r10.mo4707b((com.google.android.gms.internal.C0476ay) r0, (java.lang.String) r1, (boolean) r7)
                r13.writeNoException()
                goto L_0x000a
            L_0x08eb:
                java.lang.String r0 = "com.google.android.gms.games.internal.IGamesService"
                r12.enforceInterface(r0)
                android.os.IBinder r0 = r12.readStrongBinder()
                com.google.android.gms.internal.ay r0 = com.google.android.gms.internal.C0476ay.C0477a.m1103n(r0)
                int r1 = r12.readInt()
                if (r1 == 0) goto L_0x08ff
                r7 = r9
            L_0x08ff:
                r10.mo4714c((com.google.android.gms.internal.C0476ay) r0, (boolean) r7)
                r13.writeNoException()
                goto L_0x000a
            L_0x0907:
                java.lang.String r0 = "com.google.android.gms.games.internal.IGamesService"
                r12.enforceInterface(r0)
                android.os.IBinder r0 = r12.readStrongBinder()
                com.google.android.gms.internal.ay r0 = com.google.android.gms.internal.C0476ay.C0477a.m1103n(r0)
                java.lang.String r1 = r12.readString()
                int r2 = r12.readInt()
                if (r2 == 0) goto L_0x091f
                r7 = r9
            L_0x091f:
                r10.mo4713c((com.google.android.gms.internal.C0476ay) r0, (java.lang.String) r1, (boolean) r7)
                r13.writeNoException()
                goto L_0x000a
            L_0x0927:
                java.lang.String r0 = "com.google.android.gms.games.internal.IGamesService"
                r12.enforceInterface(r0)
                android.os.IBinder r0 = r12.readStrongBinder()
                com.google.android.gms.internal.ay r0 = com.google.android.gms.internal.C0476ay.C0477a.m1103n(r0)
                java.lang.String r1 = r12.readString()
                int r2 = r12.readInt()
                if (r2 == 0) goto L_0x093f
                r7 = r9
            L_0x093f:
                r10.mo4719d(r0, r1, r7)
                r13.writeNoException()
                goto L_0x000a
            L_0x0947:
                java.lang.String r0 = "com.google.android.gms.games.internal.IGamesService"
                r12.enforceInterface(r0)
                android.os.IBinder r0 = r12.readStrongBinder()
                com.google.android.gms.internal.ay r0 = com.google.android.gms.internal.C0476ay.C0477a.m1103n(r0)
                java.lang.String r1 = r12.readString()
                java.lang.String r2 = r12.readString()
                int r3 = r12.readInt()
                if (r3 == 0) goto L_0x0963
                r7 = r9
            L_0x0963:
                r10.mo4706b((com.google.android.gms.internal.C0476ay) r0, (java.lang.String) r1, (java.lang.String) r2, (boolean) r7)
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
                android.os.ParcelFileDescriptor r0 = r10.mo4696b((android.net.Uri) r0)
                r13.writeNoException()
                if (r0 == 0) goto L_0x098f
                r13.writeInt(r9)
                r0.writeToParcel(r13, r9)
                goto L_0x000a
            L_0x098f:
                r13.writeInt(r7)
                goto L_0x000a
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.C0479az.C0480a.onTransact(int, android.os.Parcel, android.os.Parcel, int):boolean");
        }
    }

    /* renamed from: a */
    int mo4667a(C0476ay ayVar, byte[] bArr, String str, String str2) throws RemoteException;

    /* renamed from: a */
    void mo4668a(long j) throws RemoteException;

    /* renamed from: a */
    void mo4669a(IBinder iBinder, Bundle bundle) throws RemoteException;

    /* renamed from: a */
    void mo4670a(C0476ay ayVar) throws RemoteException;

    /* renamed from: a */
    void mo4671a(C0476ay ayVar, int i, int i2, boolean z, boolean z2) throws RemoteException;

    /* renamed from: a */
    void mo4672a(C0476ay ayVar, int i, boolean z, boolean z2) throws RemoteException;

    /* renamed from: a */
    void mo4673a(C0476ay ayVar, long j) throws RemoteException;

    /* renamed from: a */
    void mo4674a(C0476ay ayVar, Bundle bundle, int i, int i2) throws RemoteException;

    /* renamed from: a */
    void mo4675a(C0476ay ayVar, IBinder iBinder, int i, String[] strArr, Bundle bundle, boolean z, long j) throws RemoteException;

    /* renamed from: a */
    void mo4676a(C0476ay ayVar, IBinder iBinder, String str, boolean z, long j) throws RemoteException;

    /* renamed from: a */
    void mo4677a(C0476ay ayVar, String str) throws RemoteException;

    /* renamed from: a */
    void mo4678a(C0476ay ayVar, String str, int i, int i2, int i3, boolean z) throws RemoteException;

    /* renamed from: a */
    void mo4679a(C0476ay ayVar, String str, int i, IBinder iBinder, Bundle bundle) throws RemoteException;

    /* renamed from: a */
    void mo4680a(C0476ay ayVar, String str, int i, boolean z, boolean z2) throws RemoteException;

    /* renamed from: a */
    void mo4681a(C0476ay ayVar, String str, int i, boolean z, boolean z2, boolean z3, boolean z4) throws RemoteException;

    /* renamed from: a */
    void mo4682a(C0476ay ayVar, String str, long j) throws RemoteException;

    /* renamed from: a */
    void mo4683a(C0476ay ayVar, String str, IBinder iBinder, Bundle bundle) throws RemoteException;

    /* renamed from: a */
    void mo4684a(C0476ay ayVar, String str, String str2) throws RemoteException;

    /* renamed from: a */
    void mo4685a(C0476ay ayVar, String str, String str2, int i, int i2, int i3, boolean z) throws RemoteException;

    /* renamed from: a */
    void mo4686a(C0476ay ayVar, String str, String str2, boolean z) throws RemoteException;

    /* renamed from: a */
    void mo4687a(C0476ay ayVar, String str, boolean z) throws RemoteException;

    /* renamed from: a */
    void mo4688a(C0476ay ayVar, String str, boolean z, long[] jArr) throws RemoteException;

    /* renamed from: a */
    void mo4689a(C0476ay ayVar, boolean z) throws RemoteException;

    /* renamed from: a */
    void mo4690a(String str, String str2, int i) throws RemoteException;

    /* renamed from: aA */
    C0344d mo4691aA() throws RemoteException;

    /* renamed from: ax */
    void mo4692ax() throws RemoteException;

    /* renamed from: ay */
    C0344d mo4693ay() throws RemoteException;

    /* renamed from: az */
    boolean mo4694az() throws RemoteException;

    /* renamed from: b */
    int mo4695b(byte[] bArr, String str, String[] strArr) throws RemoteException;

    /* renamed from: b */
    ParcelFileDescriptor mo4696b(Uri uri) throws RemoteException;

    /* renamed from: b */
    void mo4697b(long j) throws RemoteException;

    /* renamed from: b */
    void mo4698b(C0476ay ayVar) throws RemoteException;

    /* renamed from: b */
    void mo4699b(C0476ay ayVar, int i, boolean z, boolean z2) throws RemoteException;

    /* renamed from: b */
    void mo4700b(C0476ay ayVar, String str) throws RemoteException;

    /* renamed from: b */
    void mo4701b(C0476ay ayVar, String str, int i, int i2, int i3, boolean z) throws RemoteException;

    /* renamed from: b */
    void mo4702b(C0476ay ayVar, String str, int i, boolean z, boolean z2) throws RemoteException;

    /* renamed from: b */
    void mo4703b(C0476ay ayVar, String str, IBinder iBinder, Bundle bundle) throws RemoteException;

    /* renamed from: b */
    void mo4704b(C0476ay ayVar, String str, String str2) throws RemoteException;

    /* renamed from: b */
    void mo4705b(C0476ay ayVar, String str, String str2, int i, int i2, int i3, boolean z) throws RemoteException;

    /* renamed from: b */
    void mo4706b(C0476ay ayVar, String str, String str2, boolean z) throws RemoteException;

    /* renamed from: b */
    void mo4707b(C0476ay ayVar, String str, boolean z) throws RemoteException;

    /* renamed from: b */
    void mo4708b(C0476ay ayVar, boolean z) throws RemoteException;

    /* renamed from: c */
    void mo4709c(C0476ay ayVar) throws RemoteException;

    /* renamed from: c */
    void mo4710c(C0476ay ayVar, int i, boolean z, boolean z2) throws RemoteException;

    /* renamed from: c */
    void mo4711c(C0476ay ayVar, String str) throws RemoteException;

    /* renamed from: c */
    void mo4712c(C0476ay ayVar, String str, String str2) throws RemoteException;

    /* renamed from: c */
    void mo4713c(C0476ay ayVar, String str, boolean z) throws RemoteException;

    /* renamed from: c */
    void mo4714c(C0476ay ayVar, boolean z) throws RemoteException;

    void clearNotifications(int i) throws RemoteException;

    /* renamed from: d */
    void mo4716d(C0476ay ayVar) throws RemoteException;

    /* renamed from: d */
    void mo4717d(C0476ay ayVar, int i, boolean z, boolean z2) throws RemoteException;

    /* renamed from: d */
    void mo4718d(C0476ay ayVar, String str) throws RemoteException;

    /* renamed from: d */
    void mo4719d(C0476ay ayVar, String str, boolean z) throws RemoteException;

    /* renamed from: e */
    void mo4720e(C0476ay ayVar) throws RemoteException;

    /* renamed from: e */
    void mo4721e(C0476ay ayVar, int i, boolean z, boolean z2) throws RemoteException;

    /* renamed from: e */
    void mo4722e(C0476ay ayVar, String str) throws RemoteException;

    /* renamed from: e */
    void mo4723e(String str, String str2) throws RemoteException;

    /* renamed from: f */
    void mo4724f(C0476ay ayVar) throws RemoteException;

    /* renamed from: f */
    void mo4725f(C0476ay ayVar, String str) throws RemoteException;

    /* renamed from: g */
    void mo4726g(C0476ay ayVar) throws RemoteException;

    /* renamed from: g */
    void mo4727g(C0476ay ayVar, String str) throws RemoteException;

    String getAppId() throws RemoteException;

    String getCurrentAccountName() throws RemoteException;

    String getCurrentPlayerId() throws RemoteException;

    /* renamed from: h */
    void mo4731h(C0476ay ayVar) throws RemoteException;

    /* renamed from: h */
    void mo4732h(C0476ay ayVar, String str) throws RemoteException;

    /* renamed from: h */
    void mo4733h(String str, int i) throws RemoteException;

    /* renamed from: i */
    void mo4734i(C0476ay ayVar) throws RemoteException;

    /* renamed from: i */
    void mo4735i(C0476ay ayVar, String str) throws RemoteException;

    /* renamed from: i */
    void mo4736i(String str, int i) throws RemoteException;

    /* renamed from: j */
    int mo4737j(C0476ay ayVar, String str) throws RemoteException;

    /* renamed from: j */
    void mo4738j(String str, int i) throws RemoteException;

    /* renamed from: k */
    void mo4739k(C0476ay ayVar, String str) throws RemoteException;

    /* renamed from: l */
    void mo4740l(C0476ay ayVar, String str) throws RemoteException;

    void setUseNewPlayerNotificationsFirstParty(boolean z) throws RemoteException;

    /* renamed from: u */
    String mo4742u(String str) throws RemoteException;

    /* renamed from: v */
    String mo4743v(String str) throws RemoteException;

    /* renamed from: w */
    void mo4744w(String str) throws RemoteException;

    /* renamed from: x */
    int mo4745x(String str) throws RemoteException;

    /* renamed from: y */
    Uri mo4746y(String str) throws RemoteException;

    /* renamed from: z */
    Bundle mo4747z() throws RemoteException;
}
