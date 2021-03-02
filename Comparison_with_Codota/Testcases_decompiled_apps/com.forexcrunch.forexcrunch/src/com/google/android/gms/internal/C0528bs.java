package com.google.android.gms.internal;

import android.net.Uri;
import android.os.Binder;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import java.util.List;

/* renamed from: com.google.android.gms.internal.bs */
public interface C0528bs extends IInterface {

    /* renamed from: com.google.android.gms.internal.bs$a */
    public static abstract class C0529a extends Binder implements C0528bs {

        /* renamed from: com.google.android.gms.internal.bs$a$a */
        private static class C0530a implements C0528bs {

            /* renamed from: a */
            private IBinder f1153a;

            C0530a(IBinder iBinder) {
                this.f1153a = iBinder;
            }

            /* renamed from: a */
            public void mo4875a(C0419ak akVar) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.plus.internal.IPlusService");
                    if (akVar != null) {
                        obtain.writeInt(1);
                        akVar.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.f1153a.transact(4, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            /* renamed from: a */
            public void mo4876a(C0519bp bpVar) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.plus.internal.IPlusService");
                    obtain.writeStrongBinder(bpVar != null ? bpVar.asBinder() : null);
                    this.f1153a.transact(8, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            /* renamed from: a */
            public void mo4877a(C0519bp bpVar, int i, int i2, int i3, String str) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.plus.internal.IPlusService");
                    obtain.writeStrongBinder(bpVar != null ? bpVar.asBinder() : null);
                    obtain.writeInt(i);
                    obtain.writeInt(i2);
                    obtain.writeInt(i3);
                    obtain.writeString(str);
                    this.f1153a.transact(16, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            /* renamed from: a */
            public void mo4878a(C0519bp bpVar, int i, int i2, String str) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.plus.internal.IPlusService");
                    obtain.writeStrongBinder(bpVar != null ? bpVar.asBinder() : null);
                    obtain.writeInt(i);
                    obtain.writeInt(i2);
                    obtain.writeString(str);
                    this.f1153a.transact(39, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            /* renamed from: a */
            public void mo4879a(C0519bp bpVar, int i, String str) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.plus.internal.IPlusService");
                    obtain.writeStrongBinder(bpVar != null ? bpVar.asBinder() : null);
                    obtain.writeInt(i);
                    obtain.writeString(str);
                    this.f1153a.transact(20, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            /* renamed from: a */
            public void mo4880a(C0519bp bpVar, int i, String str, Uri uri, String str2) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.plus.internal.IPlusService");
                    obtain.writeStrongBinder(bpVar != null ? bpVar.asBinder() : null);
                    obtain.writeInt(i);
                    obtain.writeString(str);
                    if (uri != null) {
                        obtain.writeInt(1);
                        uri.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    obtain.writeString(str2);
                    this.f1153a.transact(32, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            /* renamed from: a */
            public void mo4881a(C0519bp bpVar, int i, String str, Uri uri, String str2, String str3) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.plus.internal.IPlusService");
                    obtain.writeStrongBinder(bpVar != null ? bpVar.asBinder() : null);
                    obtain.writeInt(i);
                    obtain.writeString(str);
                    if (uri != null) {
                        obtain.writeInt(1);
                        uri.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    obtain.writeString(str2);
                    obtain.writeString(str3);
                    this.f1153a.transact(14, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            /* renamed from: a */
            public void mo4882a(C0519bp bpVar, Uri uri, Bundle bundle) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.plus.internal.IPlusService");
                    obtain.writeStrongBinder(bpVar != null ? bpVar.asBinder() : null);
                    if (uri != null) {
                        obtain.writeInt(1);
                        uri.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    if (bundle != null) {
                        obtain.writeInt(1);
                        bundle.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.f1153a.transact(9, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            /* renamed from: a */
            public void mo4883a(C0519bp bpVar, C0578co coVar) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.plus.internal.IPlusService");
                    obtain.writeStrongBinder(bpVar != null ? bpVar.asBinder() : null);
                    if (coVar != null) {
                        obtain.writeInt(1);
                        coVar.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.f1153a.transact(30, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            /* renamed from: a */
            public void mo4884a(C0519bp bpVar, String str) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.plus.internal.IPlusService");
                    obtain.writeStrongBinder(bpVar != null ? bpVar.asBinder() : null);
                    obtain.writeString(str);
                    this.f1153a.transact(1, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            /* renamed from: a */
            public void mo4885a(C0519bp bpVar, String str, int i, String str2) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.plus.internal.IPlusService");
                    obtain.writeStrongBinder(bpVar != null ? bpVar.asBinder() : null);
                    obtain.writeString(str);
                    obtain.writeInt(i);
                    obtain.writeString(str2);
                    this.f1153a.transact(36, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            /* renamed from: a */
            public void mo4886a(C0519bp bpVar, String str, C0540bv bvVar) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.plus.internal.IPlusService");
                    obtain.writeStrongBinder(bpVar != null ? bpVar.asBinder() : null);
                    obtain.writeString(str);
                    if (bvVar != null) {
                        obtain.writeInt(1);
                        bvVar.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.f1153a.transact(25, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            /* renamed from: a */
            public void mo4887a(C0519bp bpVar, String str, String str2) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.plus.internal.IPlusService");
                    obtain.writeStrongBinder(bpVar != null ? bpVar.asBinder() : null);
                    obtain.writeString(str);
                    obtain.writeString(str2);
                    this.f1153a.transact(2, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            /* renamed from: a */
            public void mo4888a(C0519bp bpVar, String str, String str2, int i, String str3) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.plus.internal.IPlusService");
                    obtain.writeStrongBinder(bpVar != null ? bpVar.asBinder() : null);
                    obtain.writeString(str);
                    obtain.writeString(str2);
                    obtain.writeInt(i);
                    obtain.writeString(str3);
                    this.f1153a.transact(12, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            /* renamed from: a */
            public void mo4889a(C0519bp bpVar, String str, String str2, boolean z, String str3) throws RemoteException {
                int i = 0;
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.plus.internal.IPlusService");
                    obtain.writeStrongBinder(bpVar != null ? bpVar.asBinder() : null);
                    obtain.writeString(str);
                    obtain.writeString(str2);
                    if (z) {
                        i = 1;
                    }
                    obtain.writeInt(i);
                    obtain.writeString(str3);
                    this.f1153a.transact(37, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            /* renamed from: a */
            public void mo4890a(C0519bp bpVar, String str, List<C0626x> list) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.plus.internal.IPlusService");
                    obtain.writeStrongBinder(bpVar != null ? bpVar.asBinder() : null);
                    obtain.writeString(str);
                    obtain.writeTypedList(list);
                    this.f1153a.transact(28, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            /* renamed from: a */
            public void mo4891a(C0519bp bpVar, String str, List<C0626x> list, Bundle bundle) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.plus.internal.IPlusService");
                    obtain.writeStrongBinder(bpVar != null ? bpVar.asBinder() : null);
                    obtain.writeString(str);
                    obtain.writeTypedList(list);
                    if (bundle != null) {
                        obtain.writeInt(1);
                        bundle.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.f1153a.transact(31, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            /* renamed from: a */
            public void mo4892a(C0519bp bpVar, String str, List<String> list, List<String> list2, List<String> list3) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.plus.internal.IPlusService");
                    obtain.writeStrongBinder(bpVar != null ? bpVar.asBinder() : null);
                    obtain.writeString(str);
                    obtain.writeStringList(list);
                    obtain.writeStringList(list2);
                    obtain.writeStringList(list3);
                    this.f1153a.transact(23, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            /* renamed from: a */
            public void mo4893a(C0519bp bpVar, String str, List<C0626x> list, boolean z) throws RemoteException {
                int i = 0;
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.plus.internal.IPlusService");
                    obtain.writeStrongBinder(bpVar != null ? bpVar.asBinder() : null);
                    obtain.writeString(str);
                    obtain.writeTypedList(list);
                    if (z) {
                        i = 1;
                    }
                    obtain.writeInt(i);
                    this.f1153a.transact(29, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            /* renamed from: a */
            public void mo4894a(C0519bp bpVar, String str, boolean z) throws RemoteException {
                int i = 0;
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.plus.internal.IPlusService");
                    obtain.writeStrongBinder(bpVar != null ? bpVar.asBinder() : null);
                    obtain.writeString(str);
                    if (z) {
                        i = 1;
                    }
                    obtain.writeInt(i);
                    this.f1153a.transact(21, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            /* renamed from: a */
            public void mo4895a(C0519bp bpVar, String str, boolean z, String str2) throws RemoteException {
                int i = 0;
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.plus.internal.IPlusService");
                    obtain.writeStrongBinder(bpVar != null ? bpVar.asBinder() : null);
                    obtain.writeString(str);
                    if (z) {
                        i = 1;
                    }
                    obtain.writeInt(i);
                    obtain.writeString(str2);
                    this.f1153a.transact(27, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            /* renamed from: a */
            public void mo4896a(C0519bp bpVar, List<String> list) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.plus.internal.IPlusService");
                    obtain.writeStrongBinder(bpVar != null ? bpVar.asBinder() : null);
                    obtain.writeStringList(list);
                    this.f1153a.transact(34, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            /* renamed from: a */
            public void mo4897a(C0519bp bpVar, boolean z, boolean z2) throws RemoteException {
                int i = 1;
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.plus.internal.IPlusService");
                    obtain.writeStrongBinder(bpVar != null ? bpVar.asBinder() : null);
                    obtain.writeInt(z ? 1 : 0);
                    if (!z2) {
                        i = 0;
                    }
                    obtain.writeInt(i);
                    this.f1153a.transact(22, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public IBinder asBinder() {
                return this.f1153a;
            }

            /* renamed from: b */
            public void mo4898b(C0519bp bpVar) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.plus.internal.IPlusService");
                    obtain.writeStrongBinder(bpVar != null ? bpVar.asBinder() : null);
                    this.f1153a.transact(13, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            /* renamed from: b */
            public void mo4899b(C0519bp bpVar, String str) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.plus.internal.IPlusService");
                    obtain.writeStrongBinder(bpVar != null ? bpVar.asBinder() : null);
                    obtain.writeString(str);
                    this.f1153a.transact(3, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            /* renamed from: c */
            public void mo4900c(C0519bp bpVar) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.plus.internal.IPlusService");
                    obtain.writeStrongBinder(bpVar != null ? bpVar.asBinder() : null);
                    this.f1153a.transact(19, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            /* renamed from: c */
            public void mo4901c(C0519bp bpVar, String str) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.plus.internal.IPlusService");
                    obtain.writeStrongBinder(bpVar != null ? bpVar.asBinder() : null);
                    obtain.writeString(str);
                    this.f1153a.transact(7, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void clearDefaultAccount() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.plus.internal.IPlusService");
                    this.f1153a.transact(6, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            /* renamed from: d */
            public void mo4903d(C0519bp bpVar) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.plus.internal.IPlusService");
                    obtain.writeStrongBinder(bpVar != null ? bpVar.asBinder() : null);
                    this.f1153a.transact(38, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            /* renamed from: d */
            public void mo4904d(C0519bp bpVar, String str) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.plus.internal.IPlusService");
                    obtain.writeStrongBinder(bpVar != null ? bpVar.asBinder() : null);
                    obtain.writeString(str);
                    this.f1153a.transact(10, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            /* renamed from: e */
            public void mo4905e(C0519bp bpVar, String str) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.plus.internal.IPlusService");
                    obtain.writeStrongBinder(bpVar != null ? bpVar.asBinder() : null);
                    obtain.writeString(str);
                    this.f1153a.transact(18, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            /* renamed from: f */
            public void mo4906f(C0519bp bpVar, String str) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.plus.internal.IPlusService");
                    obtain.writeStrongBinder(bpVar != null ? bpVar.asBinder() : null);
                    obtain.writeString(str);
                    this.f1153a.transact(24, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            /* renamed from: f */
            public void mo4907f(String str, String str2) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.plus.internal.IPlusService");
                    obtain.writeString(str);
                    obtain.writeString(str2);
                    this.f1153a.transact(11, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            /* renamed from: g */
            public void mo4908g(C0519bp bpVar, String str) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.plus.internal.IPlusService");
                    obtain.writeStrongBinder(bpVar != null ? bpVar.asBinder() : null);
                    obtain.writeString(str);
                    this.f1153a.transact(26, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public String getAccountName() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.plus.internal.IPlusService");
                    this.f1153a.transact(5, obtain, obtain2, 0);
                    obtain2.readException();
                    return obtain2.readString();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            /* renamed from: h */
            public void mo4910h(C0519bp bpVar, String str) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.plus.internal.IPlusService");
                    obtain.writeStrongBinder(bpVar != null ? bpVar.asBinder() : null);
                    obtain.writeString(str);
                    this.f1153a.transact(33, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            /* renamed from: i */
            public void mo4911i(C0519bp bpVar, String str) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.plus.internal.IPlusService");
                    obtain.writeStrongBinder(bpVar != null ? bpVar.asBinder() : null);
                    obtain.writeString(str);
                    this.f1153a.transact(35, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void removeMoment(String momentId) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.plus.internal.IPlusService");
                    obtain.writeString(momentId);
                    this.f1153a.transact(17, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }
        }

        /* renamed from: ab */
        public static C0528bs m1476ab(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.plus.internal.IPlusService");
            return (queryLocalInterface == null || !(queryLocalInterface instanceof C0528bs)) ? new C0530a(iBinder) : (C0528bs) queryLocalInterface;
        }

        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v5, resolved type: android.net.Uri} */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v7, resolved type: com.google.android.gms.internal.co} */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v10, resolved type: com.google.android.gms.internal.bv} */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v14, resolved type: android.net.Uri} */
        /* JADX WARNING: type inference failed for: r4v0 */
        /* JADX WARNING: type inference failed for: r4v6 */
        /* JADX WARNING: type inference failed for: r4v15 */
        /* JADX WARNING: type inference failed for: r4v17 */
        /* JADX WARNING: type inference failed for: r4v18 */
        /* JADX WARNING: Multi-variable type inference failed */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public boolean onTransact(int r9, android.os.Parcel r10, android.os.Parcel r11, int r12) throws android.os.RemoteException {
            /*
                r8 = this;
                r0 = 0
                r4 = 0
                r7 = 1
                switch(r9) {
                    case 1: goto L_0x0011;
                    case 2: goto L_0x0029;
                    case 3: goto L_0x0045;
                    case 4: goto L_0x005d;
                    case 5: goto L_0x0077;
                    case 6: goto L_0x0087;
                    case 7: goto L_0x0094;
                    case 8: goto L_0x00ad;
                    case 9: goto L_0x00c2;
                    case 10: goto L_0x00f8;
                    case 11: goto L_0x0111;
                    case 12: goto L_0x0126;
                    case 13: goto L_0x014c;
                    case 14: goto L_0x0161;
                    case 16: goto L_0x0196;
                    case 17: goto L_0x01bc;
                    case 18: goto L_0x01cd;
                    case 19: goto L_0x01e6;
                    case 20: goto L_0x01fb;
                    case 21: goto L_0x0218;
                    case 22: goto L_0x0238;
                    case 23: goto L_0x025d;
                    case 24: goto L_0x0283;
                    case 25: goto L_0x029c;
                    case 26: goto L_0x02c1;
                    case 27: goto L_0x02da;
                    case 28: goto L_0x02fe;
                    case 29: goto L_0x031d;
                    case 30: goto L_0x0343;
                    case 31: goto L_0x0364;
                    case 32: goto L_0x0393;
                    case 33: goto L_0x03c4;
                    case 34: goto L_0x03dd;
                    case 35: goto L_0x03f6;
                    case 36: goto L_0x040f;
                    case 37: goto L_0x0430;
                    case 38: goto L_0x045b;
                    case 39: goto L_0x0470;
                    case 1598968902: goto L_0x000b;
                    default: goto L_0x0006;
                }
            L_0x0006:
                boolean r7 = super.onTransact(r9, r10, r11, r12)
            L_0x000a:
                return r7
            L_0x000b:
                java.lang.String r0 = "com.google.android.gms.plus.internal.IPlusService"
                r11.writeString(r0)
                goto L_0x000a
            L_0x0011:
                java.lang.String r0 = "com.google.android.gms.plus.internal.IPlusService"
                r10.enforceInterface(r0)
                android.os.IBinder r0 = r10.readStrongBinder()
                com.google.android.gms.internal.bp r0 = com.google.android.gms.internal.C0519bp.C0520a.m1417Y(r0)
                java.lang.String r1 = r10.readString()
                r8.mo4884a((com.google.android.gms.internal.C0519bp) r0, (java.lang.String) r1)
                r11.writeNoException()
                goto L_0x000a
            L_0x0029:
                java.lang.String r0 = "com.google.android.gms.plus.internal.IPlusService"
                r10.enforceInterface(r0)
                android.os.IBinder r0 = r10.readStrongBinder()
                com.google.android.gms.internal.bp r0 = com.google.android.gms.internal.C0519bp.C0520a.m1417Y(r0)
                java.lang.String r1 = r10.readString()
                java.lang.String r2 = r10.readString()
                r8.mo4887a((com.google.android.gms.internal.C0519bp) r0, (java.lang.String) r1, (java.lang.String) r2)
                r11.writeNoException()
                goto L_0x000a
            L_0x0045:
                java.lang.String r0 = "com.google.android.gms.plus.internal.IPlusService"
                r10.enforceInterface(r0)
                android.os.IBinder r0 = r10.readStrongBinder()
                com.google.android.gms.internal.bp r0 = com.google.android.gms.internal.C0519bp.C0520a.m1417Y(r0)
                java.lang.String r1 = r10.readString()
                r8.mo4899b(r0, r1)
                r11.writeNoException()
                goto L_0x000a
            L_0x005d:
                java.lang.String r0 = "com.google.android.gms.plus.internal.IPlusService"
                r10.enforceInterface(r0)
                int r0 = r10.readInt()
                if (r0 == 0) goto L_0x0075
                com.google.android.gms.internal.al r0 = com.google.android.gms.internal.C0419ak.CREATOR
                com.google.android.gms.internal.ak r0 = r0.createFromParcel(r10)
            L_0x006e:
                r8.mo4875a((com.google.android.gms.internal.C0419ak) r0)
                r11.writeNoException()
                goto L_0x000a
            L_0x0075:
                r0 = r4
                goto L_0x006e
            L_0x0077:
                java.lang.String r0 = "com.google.android.gms.plus.internal.IPlusService"
                r10.enforceInterface(r0)
                java.lang.String r0 = r8.getAccountName()
                r11.writeNoException()
                r11.writeString(r0)
                goto L_0x000a
            L_0x0087:
                java.lang.String r0 = "com.google.android.gms.plus.internal.IPlusService"
                r10.enforceInterface(r0)
                r8.clearDefaultAccount()
                r11.writeNoException()
                goto L_0x000a
            L_0x0094:
                java.lang.String r0 = "com.google.android.gms.plus.internal.IPlusService"
                r10.enforceInterface(r0)
                android.os.IBinder r0 = r10.readStrongBinder()
                com.google.android.gms.internal.bp r0 = com.google.android.gms.internal.C0519bp.C0520a.m1417Y(r0)
                java.lang.String r1 = r10.readString()
                r8.mo4901c(r0, r1)
                r11.writeNoException()
                goto L_0x000a
            L_0x00ad:
                java.lang.String r0 = "com.google.android.gms.plus.internal.IPlusService"
                r10.enforceInterface(r0)
                android.os.IBinder r0 = r10.readStrongBinder()
                com.google.android.gms.internal.bp r0 = com.google.android.gms.internal.C0519bp.C0520a.m1417Y(r0)
                r8.mo4876a((com.google.android.gms.internal.C0519bp) r0)
                r11.writeNoException()
                goto L_0x000a
            L_0x00c2:
                java.lang.String r0 = "com.google.android.gms.plus.internal.IPlusService"
                r10.enforceInterface(r0)
                android.os.IBinder r0 = r10.readStrongBinder()
                com.google.android.gms.internal.bp r2 = com.google.android.gms.internal.C0519bp.C0520a.m1417Y(r0)
                int r0 = r10.readInt()
                if (r0 == 0) goto L_0x00f4
                android.os.Parcelable$Creator r0 = android.net.Uri.CREATOR
                java.lang.Object r0 = r0.createFromParcel(r10)
                android.net.Uri r0 = (android.net.Uri) r0
                r1 = r0
            L_0x00de:
                int r0 = r10.readInt()
                if (r0 == 0) goto L_0x00f6
                android.os.Parcelable$Creator r0 = android.os.Bundle.CREATOR
                java.lang.Object r0 = r0.createFromParcel(r10)
                android.os.Bundle r0 = (android.os.Bundle) r0
            L_0x00ec:
                r8.mo4882a((com.google.android.gms.internal.C0519bp) r2, (android.net.Uri) r1, (android.os.Bundle) r0)
                r11.writeNoException()
                goto L_0x000a
            L_0x00f4:
                r1 = r4
                goto L_0x00de
            L_0x00f6:
                r0 = r4
                goto L_0x00ec
            L_0x00f8:
                java.lang.String r0 = "com.google.android.gms.plus.internal.IPlusService"
                r10.enforceInterface(r0)
                android.os.IBinder r0 = r10.readStrongBinder()
                com.google.android.gms.internal.bp r0 = com.google.android.gms.internal.C0519bp.C0520a.m1417Y(r0)
                java.lang.String r1 = r10.readString()
                r8.mo4904d(r0, r1)
                r11.writeNoException()
                goto L_0x000a
            L_0x0111:
                java.lang.String r0 = "com.google.android.gms.plus.internal.IPlusService"
                r10.enforceInterface(r0)
                java.lang.String r0 = r10.readString()
                java.lang.String r1 = r10.readString()
                r8.mo4907f((java.lang.String) r0, (java.lang.String) r1)
                r11.writeNoException()
                goto L_0x000a
            L_0x0126:
                java.lang.String r0 = "com.google.android.gms.plus.internal.IPlusService"
                r10.enforceInterface(r0)
                android.os.IBinder r0 = r10.readStrongBinder()
                com.google.android.gms.internal.bp r1 = com.google.android.gms.internal.C0519bp.C0520a.m1417Y(r0)
                java.lang.String r2 = r10.readString()
                java.lang.String r3 = r10.readString()
                int r4 = r10.readInt()
                java.lang.String r5 = r10.readString()
                r0 = r8
                r0.mo4888a((com.google.android.gms.internal.C0519bp) r1, (java.lang.String) r2, (java.lang.String) r3, (int) r4, (java.lang.String) r5)
                r11.writeNoException()
                goto L_0x000a
            L_0x014c:
                java.lang.String r0 = "com.google.android.gms.plus.internal.IPlusService"
                r10.enforceInterface(r0)
                android.os.IBinder r0 = r10.readStrongBinder()
                com.google.android.gms.internal.bp r0 = com.google.android.gms.internal.C0519bp.C0520a.m1417Y(r0)
                r8.mo4898b(r0)
                r11.writeNoException()
                goto L_0x000a
            L_0x0161:
                java.lang.String r0 = "com.google.android.gms.plus.internal.IPlusService"
                r10.enforceInterface(r0)
                android.os.IBinder r0 = r10.readStrongBinder()
                com.google.android.gms.internal.bp r1 = com.google.android.gms.internal.C0519bp.C0520a.m1417Y(r0)
                int r2 = r10.readInt()
                java.lang.String r3 = r10.readString()
                int r0 = r10.readInt()
                if (r0 == 0) goto L_0x0185
                android.os.Parcelable$Creator r0 = android.net.Uri.CREATOR
                java.lang.Object r0 = r0.createFromParcel(r10)
                android.net.Uri r0 = (android.net.Uri) r0
                r4 = r0
            L_0x0185:
                java.lang.String r5 = r10.readString()
                java.lang.String r6 = r10.readString()
                r0 = r8
                r0.mo4881a(r1, r2, r3, r4, r5, r6)
                r11.writeNoException()
                goto L_0x000a
            L_0x0196:
                java.lang.String r0 = "com.google.android.gms.plus.internal.IPlusService"
                r10.enforceInterface(r0)
                android.os.IBinder r0 = r10.readStrongBinder()
                com.google.android.gms.internal.bp r1 = com.google.android.gms.internal.C0519bp.C0520a.m1417Y(r0)
                int r2 = r10.readInt()
                int r3 = r10.readInt()
                int r4 = r10.readInt()
                java.lang.String r5 = r10.readString()
                r0 = r8
                r0.mo4877a((com.google.android.gms.internal.C0519bp) r1, (int) r2, (int) r3, (int) r4, (java.lang.String) r5)
                r11.writeNoException()
                goto L_0x000a
            L_0x01bc:
                java.lang.String r0 = "com.google.android.gms.plus.internal.IPlusService"
                r10.enforceInterface(r0)
                java.lang.String r0 = r10.readString()
                r8.removeMoment(r0)
                r11.writeNoException()
                goto L_0x000a
            L_0x01cd:
                java.lang.String r0 = "com.google.android.gms.plus.internal.IPlusService"
                r10.enforceInterface(r0)
                android.os.IBinder r0 = r10.readStrongBinder()
                com.google.android.gms.internal.bp r0 = com.google.android.gms.internal.C0519bp.C0520a.m1417Y(r0)
                java.lang.String r1 = r10.readString()
                r8.mo4905e(r0, r1)
                r11.writeNoException()
                goto L_0x000a
            L_0x01e6:
                java.lang.String r0 = "com.google.android.gms.plus.internal.IPlusService"
                r10.enforceInterface(r0)
                android.os.IBinder r0 = r10.readStrongBinder()
                com.google.android.gms.internal.bp r0 = com.google.android.gms.internal.C0519bp.C0520a.m1417Y(r0)
                r8.mo4900c(r0)
                r11.writeNoException()
                goto L_0x000a
            L_0x01fb:
                java.lang.String r0 = "com.google.android.gms.plus.internal.IPlusService"
                r10.enforceInterface(r0)
                android.os.IBinder r0 = r10.readStrongBinder()
                com.google.android.gms.internal.bp r0 = com.google.android.gms.internal.C0519bp.C0520a.m1417Y(r0)
                int r1 = r10.readInt()
                java.lang.String r2 = r10.readString()
                r8.mo4879a((com.google.android.gms.internal.C0519bp) r0, (int) r1, (java.lang.String) r2)
                r11.writeNoException()
                goto L_0x000a
            L_0x0218:
                java.lang.String r1 = "com.google.android.gms.plus.internal.IPlusService"
                r10.enforceInterface(r1)
                android.os.IBinder r1 = r10.readStrongBinder()
                com.google.android.gms.internal.bp r1 = com.google.android.gms.internal.C0519bp.C0520a.m1417Y(r1)
                java.lang.String r2 = r10.readString()
                int r3 = r10.readInt()
                if (r3 == 0) goto L_0x0230
                r0 = r7
            L_0x0230:
                r8.mo4894a((com.google.android.gms.internal.C0519bp) r1, (java.lang.String) r2, (boolean) r0)
                r11.writeNoException()
                goto L_0x000a
            L_0x0238:
                java.lang.String r1 = "com.google.android.gms.plus.internal.IPlusService"
                r10.enforceInterface(r1)
                android.os.IBinder r1 = r10.readStrongBinder()
                com.google.android.gms.internal.bp r2 = com.google.android.gms.internal.C0519bp.C0520a.m1417Y(r1)
                int r1 = r10.readInt()
                if (r1 == 0) goto L_0x025b
                r1 = r7
            L_0x024c:
                int r3 = r10.readInt()
                if (r3 == 0) goto L_0x0253
                r0 = r7
            L_0x0253:
                r8.mo4897a((com.google.android.gms.internal.C0519bp) r2, (boolean) r1, (boolean) r0)
                r11.writeNoException()
                goto L_0x000a
            L_0x025b:
                r1 = r0
                goto L_0x024c
            L_0x025d:
                java.lang.String r0 = "com.google.android.gms.plus.internal.IPlusService"
                r10.enforceInterface(r0)
                android.os.IBinder r0 = r10.readStrongBinder()
                com.google.android.gms.internal.bp r1 = com.google.android.gms.internal.C0519bp.C0520a.m1417Y(r0)
                java.lang.String r2 = r10.readString()
                java.util.ArrayList r3 = r10.createStringArrayList()
                java.util.ArrayList r4 = r10.createStringArrayList()
                java.util.ArrayList r5 = r10.createStringArrayList()
                r0 = r8
                r0.mo4892a((com.google.android.gms.internal.C0519bp) r1, (java.lang.String) r2, (java.util.List<java.lang.String>) r3, (java.util.List<java.lang.String>) r4, (java.util.List<java.lang.String>) r5)
                r11.writeNoException()
                goto L_0x000a
            L_0x0283:
                java.lang.String r0 = "com.google.android.gms.plus.internal.IPlusService"
                r10.enforceInterface(r0)
                android.os.IBinder r0 = r10.readStrongBinder()
                com.google.android.gms.internal.bp r0 = com.google.android.gms.internal.C0519bp.C0520a.m1417Y(r0)
                java.lang.String r1 = r10.readString()
                r8.mo4906f((com.google.android.gms.internal.C0519bp) r0, (java.lang.String) r1)
                r11.writeNoException()
                goto L_0x000a
            L_0x029c:
                java.lang.String r0 = "com.google.android.gms.plus.internal.IPlusService"
                r10.enforceInterface(r0)
                android.os.IBinder r0 = r10.readStrongBinder()
                com.google.android.gms.internal.bp r0 = com.google.android.gms.internal.C0519bp.C0520a.m1417Y(r0)
                java.lang.String r1 = r10.readString()
                int r2 = r10.readInt()
                if (r2 == 0) goto L_0x02b9
                com.google.android.gms.internal.bw r2 = com.google.android.gms.internal.C0540bv.CREATOR
                com.google.android.gms.internal.bv r4 = r2.createFromParcel(r10)
            L_0x02b9:
                r8.mo4886a((com.google.android.gms.internal.C0519bp) r0, (java.lang.String) r1, (com.google.android.gms.internal.C0540bv) r4)
                r11.writeNoException()
                goto L_0x000a
            L_0x02c1:
                java.lang.String r0 = "com.google.android.gms.plus.internal.IPlusService"
                r10.enforceInterface(r0)
                android.os.IBinder r0 = r10.readStrongBinder()
                com.google.android.gms.internal.bp r0 = com.google.android.gms.internal.C0519bp.C0520a.m1417Y(r0)
                java.lang.String r1 = r10.readString()
                r8.mo4908g(r0, r1)
                r11.writeNoException()
                goto L_0x000a
            L_0x02da:
                java.lang.String r1 = "com.google.android.gms.plus.internal.IPlusService"
                r10.enforceInterface(r1)
                android.os.IBinder r1 = r10.readStrongBinder()
                com.google.android.gms.internal.bp r1 = com.google.android.gms.internal.C0519bp.C0520a.m1417Y(r1)
                java.lang.String r2 = r10.readString()
                int r3 = r10.readInt()
                if (r3 == 0) goto L_0x02f2
                r0 = r7
            L_0x02f2:
                java.lang.String r3 = r10.readString()
                r8.mo4895a((com.google.android.gms.internal.C0519bp) r1, (java.lang.String) r2, (boolean) r0, (java.lang.String) r3)
                r11.writeNoException()
                goto L_0x000a
            L_0x02fe:
                java.lang.String r0 = "com.google.android.gms.plus.internal.IPlusService"
                r10.enforceInterface(r0)
                android.os.IBinder r0 = r10.readStrongBinder()
                com.google.android.gms.internal.bp r0 = com.google.android.gms.internal.C0519bp.C0520a.m1417Y(r0)
                java.lang.String r1 = r10.readString()
                com.google.android.gms.internal.y r2 = com.google.android.gms.internal.C0626x.CREATOR
                java.util.ArrayList r2 = r10.createTypedArrayList(r2)
                r8.mo4890a((com.google.android.gms.internal.C0519bp) r0, (java.lang.String) r1, (java.util.List<com.google.android.gms.internal.C0626x>) r2)
                r11.writeNoException()
                goto L_0x000a
            L_0x031d:
                java.lang.String r1 = "com.google.android.gms.plus.internal.IPlusService"
                r10.enforceInterface(r1)
                android.os.IBinder r1 = r10.readStrongBinder()
                com.google.android.gms.internal.bp r1 = com.google.android.gms.internal.C0519bp.C0520a.m1417Y(r1)
                java.lang.String r2 = r10.readString()
                com.google.android.gms.internal.y r3 = com.google.android.gms.internal.C0626x.CREATOR
                java.util.ArrayList r3 = r10.createTypedArrayList(r3)
                int r4 = r10.readInt()
                if (r4 == 0) goto L_0x033b
                r0 = r7
            L_0x033b:
                r8.mo4893a((com.google.android.gms.internal.C0519bp) r1, (java.lang.String) r2, (java.util.List<com.google.android.gms.internal.C0626x>) r3, (boolean) r0)
                r11.writeNoException()
                goto L_0x000a
            L_0x0343:
                java.lang.String r0 = "com.google.android.gms.plus.internal.IPlusService"
                r10.enforceInterface(r0)
                android.os.IBinder r0 = r10.readStrongBinder()
                com.google.android.gms.internal.bp r0 = com.google.android.gms.internal.C0519bp.C0520a.m1417Y(r0)
                int r1 = r10.readInt()
                if (r1 == 0) goto L_0x035c
                com.google.android.gms.internal.cp r1 = com.google.android.gms.internal.C0578co.CREATOR
                com.google.android.gms.internal.co r4 = r1.createFromParcel(r10)
            L_0x035c:
                r8.mo4883a((com.google.android.gms.internal.C0519bp) r0, (com.google.android.gms.internal.C0578co) r4)
                r11.writeNoException()
                goto L_0x000a
            L_0x0364:
                java.lang.String r0 = "com.google.android.gms.plus.internal.IPlusService"
                r10.enforceInterface(r0)
                android.os.IBinder r0 = r10.readStrongBinder()
                com.google.android.gms.internal.bp r1 = com.google.android.gms.internal.C0519bp.C0520a.m1417Y(r0)
                java.lang.String r2 = r10.readString()
                com.google.android.gms.internal.y r0 = com.google.android.gms.internal.C0626x.CREATOR
                java.util.ArrayList r3 = r10.createTypedArrayList(r0)
                int r0 = r10.readInt()
                if (r0 == 0) goto L_0x0391
                android.os.Parcelable$Creator r0 = android.os.Bundle.CREATOR
                java.lang.Object r0 = r0.createFromParcel(r10)
                android.os.Bundle r0 = (android.os.Bundle) r0
            L_0x0389:
                r8.mo4891a((com.google.android.gms.internal.C0519bp) r1, (java.lang.String) r2, (java.util.List<com.google.android.gms.internal.C0626x>) r3, (android.os.Bundle) r0)
                r11.writeNoException()
                goto L_0x000a
            L_0x0391:
                r0 = r4
                goto L_0x0389
            L_0x0393:
                java.lang.String r0 = "com.google.android.gms.plus.internal.IPlusService"
                r10.enforceInterface(r0)
                android.os.IBinder r0 = r10.readStrongBinder()
                com.google.android.gms.internal.bp r1 = com.google.android.gms.internal.C0519bp.C0520a.m1417Y(r0)
                int r2 = r10.readInt()
                java.lang.String r3 = r10.readString()
                int r0 = r10.readInt()
                if (r0 == 0) goto L_0x03b7
                android.os.Parcelable$Creator r0 = android.net.Uri.CREATOR
                java.lang.Object r0 = r0.createFromParcel(r10)
                android.net.Uri r0 = (android.net.Uri) r0
                r4 = r0
            L_0x03b7:
                java.lang.String r5 = r10.readString()
                r0 = r8
                r0.mo4880a((com.google.android.gms.internal.C0519bp) r1, (int) r2, (java.lang.String) r3, (android.net.Uri) r4, (java.lang.String) r5)
                r11.writeNoException()
                goto L_0x000a
            L_0x03c4:
                java.lang.String r0 = "com.google.android.gms.plus.internal.IPlusService"
                r10.enforceInterface(r0)
                android.os.IBinder r0 = r10.readStrongBinder()
                com.google.android.gms.internal.bp r0 = com.google.android.gms.internal.C0519bp.C0520a.m1417Y(r0)
                java.lang.String r1 = r10.readString()
                r8.mo4910h(r0, r1)
                r11.writeNoException()
                goto L_0x000a
            L_0x03dd:
                java.lang.String r0 = "com.google.android.gms.plus.internal.IPlusService"
                r10.enforceInterface(r0)
                android.os.IBinder r0 = r10.readStrongBinder()
                com.google.android.gms.internal.bp r0 = com.google.android.gms.internal.C0519bp.C0520a.m1417Y(r0)
                java.util.ArrayList r1 = r10.createStringArrayList()
                r8.mo4896a((com.google.android.gms.internal.C0519bp) r0, (java.util.List<java.lang.String>) r1)
                r11.writeNoException()
                goto L_0x000a
            L_0x03f6:
                java.lang.String r0 = "com.google.android.gms.plus.internal.IPlusService"
                r10.enforceInterface(r0)
                android.os.IBinder r0 = r10.readStrongBinder()
                com.google.android.gms.internal.bp r0 = com.google.android.gms.internal.C0519bp.C0520a.m1417Y(r0)
                java.lang.String r1 = r10.readString()
                r8.mo4911i(r0, r1)
                r11.writeNoException()
                goto L_0x000a
            L_0x040f:
                java.lang.String r0 = "com.google.android.gms.plus.internal.IPlusService"
                r10.enforceInterface(r0)
                android.os.IBinder r0 = r10.readStrongBinder()
                com.google.android.gms.internal.bp r0 = com.google.android.gms.internal.C0519bp.C0520a.m1417Y(r0)
                java.lang.String r1 = r10.readString()
                int r2 = r10.readInt()
                java.lang.String r3 = r10.readString()
                r8.mo4885a((com.google.android.gms.internal.C0519bp) r0, (java.lang.String) r1, (int) r2, (java.lang.String) r3)
                r11.writeNoException()
                goto L_0x000a
            L_0x0430:
                java.lang.String r1 = "com.google.android.gms.plus.internal.IPlusService"
                r10.enforceInterface(r1)
                android.os.IBinder r1 = r10.readStrongBinder()
                com.google.android.gms.internal.bp r1 = com.google.android.gms.internal.C0519bp.C0520a.m1417Y(r1)
                java.lang.String r2 = r10.readString()
                java.lang.String r3 = r10.readString()
                int r4 = r10.readInt()
                if (r4 == 0) goto L_0x0459
                r4 = r7
            L_0x044c:
                java.lang.String r5 = r10.readString()
                r0 = r8
                r0.mo4889a((com.google.android.gms.internal.C0519bp) r1, (java.lang.String) r2, (java.lang.String) r3, (boolean) r4, (java.lang.String) r5)
                r11.writeNoException()
                goto L_0x000a
            L_0x0459:
                r4 = r0
                goto L_0x044c
            L_0x045b:
                java.lang.String r0 = "com.google.android.gms.plus.internal.IPlusService"
                r10.enforceInterface(r0)
                android.os.IBinder r0 = r10.readStrongBinder()
                com.google.android.gms.internal.bp r0 = com.google.android.gms.internal.C0519bp.C0520a.m1417Y(r0)
                r8.mo4903d(r0)
                r11.writeNoException()
                goto L_0x000a
            L_0x0470:
                java.lang.String r0 = "com.google.android.gms.plus.internal.IPlusService"
                r10.enforceInterface(r0)
                android.os.IBinder r0 = r10.readStrongBinder()
                com.google.android.gms.internal.bp r0 = com.google.android.gms.internal.C0519bp.C0520a.m1417Y(r0)
                int r1 = r10.readInt()
                int r2 = r10.readInt()
                java.lang.String r3 = r10.readString()
                r8.mo4878a((com.google.android.gms.internal.C0519bp) r0, (int) r1, (int) r2, (java.lang.String) r3)
                r11.writeNoException()
                goto L_0x000a
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.C0528bs.C0529a.onTransact(int, android.os.Parcel, android.os.Parcel, int):boolean");
        }
    }

    /* renamed from: a */
    void mo4875a(C0419ak akVar) throws RemoteException;

    /* renamed from: a */
    void mo4876a(C0519bp bpVar) throws RemoteException;

    /* renamed from: a */
    void mo4877a(C0519bp bpVar, int i, int i2, int i3, String str) throws RemoteException;

    /* renamed from: a */
    void mo4878a(C0519bp bpVar, int i, int i2, String str) throws RemoteException;

    /* renamed from: a */
    void mo4879a(C0519bp bpVar, int i, String str) throws RemoteException;

    /* renamed from: a */
    void mo4880a(C0519bp bpVar, int i, String str, Uri uri, String str2) throws RemoteException;

    /* renamed from: a */
    void mo4881a(C0519bp bpVar, int i, String str, Uri uri, String str2, String str3) throws RemoteException;

    /* renamed from: a */
    void mo4882a(C0519bp bpVar, Uri uri, Bundle bundle) throws RemoteException;

    /* renamed from: a */
    void mo4883a(C0519bp bpVar, C0578co coVar) throws RemoteException;

    /* renamed from: a */
    void mo4884a(C0519bp bpVar, String str) throws RemoteException;

    /* renamed from: a */
    void mo4885a(C0519bp bpVar, String str, int i, String str2) throws RemoteException;

    /* renamed from: a */
    void mo4886a(C0519bp bpVar, String str, C0540bv bvVar) throws RemoteException;

    /* renamed from: a */
    void mo4887a(C0519bp bpVar, String str, String str2) throws RemoteException;

    /* renamed from: a */
    void mo4888a(C0519bp bpVar, String str, String str2, int i, String str3) throws RemoteException;

    /* renamed from: a */
    void mo4889a(C0519bp bpVar, String str, String str2, boolean z, String str3) throws RemoteException;

    /* renamed from: a */
    void mo4890a(C0519bp bpVar, String str, List<C0626x> list) throws RemoteException;

    /* renamed from: a */
    void mo4891a(C0519bp bpVar, String str, List<C0626x> list, Bundle bundle) throws RemoteException;

    /* renamed from: a */
    void mo4892a(C0519bp bpVar, String str, List<String> list, List<String> list2, List<String> list3) throws RemoteException;

    /* renamed from: a */
    void mo4893a(C0519bp bpVar, String str, List<C0626x> list, boolean z) throws RemoteException;

    /* renamed from: a */
    void mo4894a(C0519bp bpVar, String str, boolean z) throws RemoteException;

    /* renamed from: a */
    void mo4895a(C0519bp bpVar, String str, boolean z, String str2) throws RemoteException;

    /* renamed from: a */
    void mo4896a(C0519bp bpVar, List<String> list) throws RemoteException;

    /* renamed from: a */
    void mo4897a(C0519bp bpVar, boolean z, boolean z2) throws RemoteException;

    /* renamed from: b */
    void mo4898b(C0519bp bpVar) throws RemoteException;

    /* renamed from: b */
    void mo4899b(C0519bp bpVar, String str) throws RemoteException;

    /* renamed from: c */
    void mo4900c(C0519bp bpVar) throws RemoteException;

    /* renamed from: c */
    void mo4901c(C0519bp bpVar, String str) throws RemoteException;

    void clearDefaultAccount() throws RemoteException;

    /* renamed from: d */
    void mo4903d(C0519bp bpVar) throws RemoteException;

    /* renamed from: d */
    void mo4904d(C0519bp bpVar, String str) throws RemoteException;

    /* renamed from: e */
    void mo4905e(C0519bp bpVar, String str) throws RemoteException;

    /* renamed from: f */
    void mo4906f(C0519bp bpVar, String str) throws RemoteException;

    /* renamed from: f */
    void mo4907f(String str, String str2) throws RemoteException;

    /* renamed from: g */
    void mo4908g(C0519bp bpVar, String str) throws RemoteException;

    String getAccountName() throws RemoteException;

    /* renamed from: h */
    void mo4910h(C0519bp bpVar, String str) throws RemoteException;

    /* renamed from: i */
    void mo4911i(C0519bp bpVar, String str) throws RemoteException;

    void removeMoment(String str) throws RemoteException;
}
