package com.google.android.gms.games.internal;

import android.os.Binder;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.drive.Contents;
import com.google.android.gms.fitness.FitnessStatusCodes;
import com.google.android.gms.games.GamesActivityResultCodes;
import com.google.android.gms.games.GamesStatusCodes;
import com.google.android.gms.games.multiplayer.realtime.RealTimeMessage;

public interface IGamesCallbacks extends IInterface {

    public static abstract class Stub extends Binder implements IGamesCallbacks {

        private static class Proxy implements IGamesCallbacks {

            /* renamed from: lb */
            private IBinder f1935lb;

            Proxy(IBinder remote) {
                this.f1935lb = remote;
            }

            /* renamed from: A */
            public void mo6514A(DataHolder dataHolder) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.games.internal.IGamesCallbacks");
                    if (dataHolder != null) {
                        obtain.writeInt(1);
                        dataHolder.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.f1935lb.transact(5025, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            /* renamed from: B */
            public void mo6515B(DataHolder dataHolder) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.games.internal.IGamesCallbacks");
                    if (dataHolder != null) {
                        obtain.writeInt(1);
                        dataHolder.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.f1935lb.transact(5038, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            /* renamed from: C */
            public void mo6516C(DataHolder dataHolder) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.games.internal.IGamesCallbacks");
                    if (dataHolder != null) {
                        obtain.writeInt(1);
                        dataHolder.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.f1935lb.transact(5035, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            /* renamed from: D */
            public void mo6517D(DataHolder dataHolder) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.games.internal.IGamesCallbacks");
                    if (dataHolder != null) {
                        obtain.writeInt(1);
                        dataHolder.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.f1935lb.transact(5039, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            /* renamed from: E */
            public void mo6518E(DataHolder dataHolder) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.games.internal.IGamesCallbacks");
                    if (dataHolder != null) {
                        obtain.writeInt(1);
                        dataHolder.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.f1935lb.transact(GamesStatusCodes.STATUS_MILESTONE_CLAIM_FAILED, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            /* renamed from: F */
            public void mo6519F(DataHolder dataHolder) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.games.internal.IGamesCallbacks");
                    if (dataHolder != null) {
                        obtain.writeInt(1);
                        dataHolder.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.f1935lb.transact(GamesActivityResultCodes.RESULT_LICENSE_FAILED, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            /* renamed from: G */
            public void mo6520G(DataHolder dataHolder) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.games.internal.IGamesCallbacks");
                    if (dataHolder != null) {
                        obtain.writeInt(1);
                        dataHolder.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.f1935lb.transact(GamesActivityResultCodes.RESULT_APP_MISCONFIGURED, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            /* renamed from: H */
            public void mo6521H(DataHolder dataHolder) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.games.internal.IGamesCallbacks");
                    if (dataHolder != null) {
                        obtain.writeInt(1);
                        dataHolder.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.f1935lb.transact(GamesActivityResultCodes.RESULT_NETWORK_FAILURE, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            /* renamed from: I */
            public void mo6522I(DataHolder dataHolder) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.games.internal.IGamesCallbacks");
                    if (dataHolder != null) {
                        obtain.writeInt(1);
                        dataHolder.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.f1935lb.transact(12001, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            /* renamed from: J */
            public void mo6523J(DataHolder dataHolder) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.games.internal.IGamesCallbacks");
                    if (dataHolder != null) {
                        obtain.writeInt(1);
                        dataHolder.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.f1935lb.transact(12005, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            /* renamed from: K */
            public void mo6524K(DataHolder dataHolder) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.games.internal.IGamesCallbacks");
                    if (dataHolder != null) {
                        obtain.writeInt(1);
                        dataHolder.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.f1935lb.transact(12006, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            /* renamed from: L */
            public void mo6525L(DataHolder dataHolder) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.games.internal.IGamesCallbacks");
                    if (dataHolder != null) {
                        obtain.writeInt(1);
                        dataHolder.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.f1935lb.transact(12007, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            /* renamed from: M */
            public void mo6526M(DataHolder dataHolder) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.games.internal.IGamesCallbacks");
                    if (dataHolder != null) {
                        obtain.writeInt(1);
                        dataHolder.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.f1935lb.transact(12014, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            /* renamed from: N */
            public void mo6527N(DataHolder dataHolder) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.games.internal.IGamesCallbacks");
                    if (dataHolder != null) {
                        obtain.writeInt(1);
                        dataHolder.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.f1935lb.transact(12016, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            /* renamed from: O */
            public void mo6528O(DataHolder dataHolder) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.games.internal.IGamesCallbacks");
                    if (dataHolder != null) {
                        obtain.writeInt(1);
                        dataHolder.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.f1935lb.transact(12008, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            /* renamed from: P */
            public void mo6529P(DataHolder dataHolder) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.games.internal.IGamesCallbacks");
                    if (dataHolder != null) {
                        obtain.writeInt(1);
                        dataHolder.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.f1935lb.transact(12013, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            /* renamed from: Q */
            public void mo6530Q(DataHolder dataHolder) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.games.internal.IGamesCallbacks");
                    if (dataHolder != null) {
                        obtain.writeInt(1);
                        dataHolder.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.f1935lb.transact(13001, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            /* renamed from: a */
            public void mo6531a(int i, String str, boolean z) throws RemoteException {
                int i2 = 0;
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.games.internal.IGamesCallbacks");
                    obtain.writeInt(i);
                    obtain.writeString(str);
                    if (z) {
                        i2 = 1;
                    }
                    obtain.writeInt(i2);
                    this.f1935lb.transact(5034, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            /* renamed from: a */
            public void mo6532a(DataHolder dataHolder, DataHolder dataHolder2) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.games.internal.IGamesCallbacks");
                    if (dataHolder != null) {
                        obtain.writeInt(1);
                        dataHolder.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    if (dataHolder2 != null) {
                        obtain.writeInt(1);
                        dataHolder2.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.f1935lb.transact(FitnessStatusCodes.UNKNOWN_AUTH_ERROR, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            /* renamed from: a */
            public void mo6533a(DataHolder dataHolder, Contents contents) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.games.internal.IGamesCallbacks");
                    if (dataHolder != null) {
                        obtain.writeInt(1);
                        dataHolder.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    if (contents != null) {
                        obtain.writeInt(1);
                        contents.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.f1935lb.transact(12004, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            /* renamed from: a */
            public void mo6534a(DataHolder dataHolder, String str, Contents contents, Contents contents2, Contents contents3) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.games.internal.IGamesCallbacks");
                    if (dataHolder != null) {
                        obtain.writeInt(1);
                        dataHolder.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    obtain.writeString(str);
                    if (contents != null) {
                        obtain.writeInt(1);
                        contents.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    if (contents2 != null) {
                        obtain.writeInt(1);
                        contents2.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    if (contents3 != null) {
                        obtain.writeInt(1);
                        contents3.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.f1935lb.transact(12017, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            /* renamed from: a */
            public void mo6535a(DataHolder dataHolder, String[] strArr) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.games.internal.IGamesCallbacks");
                    if (dataHolder != null) {
                        obtain.writeInt(1);
                        dataHolder.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    obtain.writeStringArray(strArr);
                    this.f1935lb.transact(5026, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public IBinder asBinder() {
                return this.f1935lb;
            }

            /* renamed from: b */
            public void mo6536b(int i, int i2, String str) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.games.internal.IGamesCallbacks");
                    obtain.writeInt(i);
                    obtain.writeInt(i2);
                    obtain.writeString(str);
                    this.f1935lb.transact(5033, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            /* renamed from: b */
            public void mo6537b(int i, Bundle bundle) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.games.internal.IGamesCallbacks");
                    obtain.writeInt(i);
                    if (bundle != null) {
                        obtain.writeInt(1);
                        bundle.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.f1935lb.transact(GamesStatusCodes.STATUS_QUEST_NO_LONGER_AVAILABLE, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            /* renamed from: b */
            public void mo6538b(DataHolder dataHolder, String[] strArr) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.games.internal.IGamesCallbacks");
                    if (dataHolder != null) {
                        obtain.writeInt(1);
                        dataHolder.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    obtain.writeStringArray(strArr);
                    this.f1935lb.transact(5027, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            /* renamed from: c */
            public void mo6539c(int i, Bundle bundle) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.games.internal.IGamesCallbacks");
                    obtain.writeInt(i);
                    if (bundle != null) {
                        obtain.writeInt(1);
                        bundle.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.f1935lb.transact(GamesActivityResultCodes.RESULT_LEFT_ROOM, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            /* renamed from: c */
            public void mo6540c(DataHolder dataHolder) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.games.internal.IGamesCallbacks");
                    if (dataHolder != null) {
                        obtain.writeInt(1);
                        dataHolder.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.f1935lb.transact(FitnessStatusCodes.INCONSISTENT_DATA_TYPE, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            /* renamed from: c */
            public void mo6541c(DataHolder dataHolder, String[] strArr) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.games.internal.IGamesCallbacks");
                    if (dataHolder != null) {
                        obtain.writeInt(1);
                        dataHolder.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    obtain.writeStringArray(strArr);
                    this.f1935lb.transact(5028, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            /* renamed from: d */
            public void mo6542d(int i, Bundle bundle) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.games.internal.IGamesCallbacks");
                    obtain.writeInt(i);
                    if (bundle != null) {
                        obtain.writeInt(1);
                        bundle.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.f1935lb.transact(11001, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            /* renamed from: d */
            public void mo6543d(DataHolder dataHolder) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.games.internal.IGamesCallbacks");
                    if (dataHolder != null) {
                        obtain.writeInt(1);
                        dataHolder.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.f1935lb.transact(12011, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            /* renamed from: d */
            public void mo6544d(DataHolder dataHolder, String[] strArr) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.games.internal.IGamesCallbacks");
                    if (dataHolder != null) {
                        obtain.writeInt(1);
                        dataHolder.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    obtain.writeStringArray(strArr);
                    this.f1935lb.transact(5029, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            /* renamed from: dx */
            public void mo6545dx(int i) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.games.internal.IGamesCallbacks");
                    obtain.writeInt(i);
                    this.f1935lb.transact(5036, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            /* renamed from: dy */
            public void mo6546dy(int i) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.games.internal.IGamesCallbacks");
                    obtain.writeInt(i);
                    this.f1935lb.transact(5040, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            /* renamed from: dz */
            public void mo6547dz(int i) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.games.internal.IGamesCallbacks");
                    obtain.writeInt(i);
                    this.f1935lb.transact(13002, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            /* renamed from: e */
            public void mo6548e(int i, Bundle bundle) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.games.internal.IGamesCallbacks");
                    obtain.writeInt(i);
                    if (bundle != null) {
                        obtain.writeInt(1);
                        bundle.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.f1935lb.transact(12003, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            /* renamed from: e */
            public void mo6549e(DataHolder dataHolder) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.games.internal.IGamesCallbacks");
                    if (dataHolder != null) {
                        obtain.writeInt(1);
                        dataHolder.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.f1935lb.transact(FitnessStatusCodes.APP_MISMATCH, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            /* renamed from: e */
            public void mo6550e(DataHolder dataHolder, String[] strArr) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.games.internal.IGamesCallbacks");
                    if (dataHolder != null) {
                        obtain.writeInt(1);
                        dataHolder.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    obtain.writeStringArray(strArr);
                    this.f1935lb.transact(5030, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            /* renamed from: f */
            public void mo6551f(int i, Bundle bundle) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.games.internal.IGamesCallbacks");
                    obtain.writeInt(i);
                    if (bundle != null) {
                        obtain.writeInt(1);
                        bundle.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.f1935lb.transact(12015, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            /* renamed from: f */
            public void mo6552f(int i, String str) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.games.internal.IGamesCallbacks");
                    obtain.writeInt(i);
                    obtain.writeString(str);
                    this.f1935lb.transact(FitnessStatusCodes.CONFLICTING_DATA_TYPE, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            /* renamed from: f */
            public void mo6553f(DataHolder dataHolder) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.games.internal.IGamesCallbacks");
                    if (dataHolder != null) {
                        obtain.writeInt(1);
                        dataHolder.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.f1935lb.transact(FitnessStatusCodes.MISSING_BLE_PERMISSION, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            /* renamed from: f */
            public void mo6554f(DataHolder dataHolder, String[] strArr) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.games.internal.IGamesCallbacks");
                    if (dataHolder != null) {
                        obtain.writeInt(1);
                        dataHolder.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    obtain.writeStringArray(strArr);
                    this.f1935lb.transact(5031, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            /* renamed from: fq */
            public void mo6555fq() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.games.internal.IGamesCallbacks");
                    this.f1935lb.transact(5016, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            /* renamed from: g */
            public void mo6556g(int i, String str) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.games.internal.IGamesCallbacks");
                    obtain.writeInt(i);
                    obtain.writeString(str);
                    this.f1935lb.transact(FitnessStatusCodes.DATA_TYPE_NOT_FOUND, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            /* renamed from: g */
            public void mo6557g(DataHolder dataHolder) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.games.internal.IGamesCallbacks");
                    if (dataHolder != null) {
                        obtain.writeInt(1);
                        dataHolder.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.f1935lb.transact(FitnessStatusCodes.UNSUPPORTED_PLATFORM, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            /* renamed from: h */
            public void mo6558h(int i, String str) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.games.internal.IGamesCallbacks");
                    obtain.writeInt(i);
                    obtain.writeString(str);
                    this.f1935lb.transact(8007, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            /* renamed from: h */
            public void mo6559h(DataHolder dataHolder) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.games.internal.IGamesCallbacks");
                    if (dataHolder != null) {
                        obtain.writeInt(1);
                        dataHolder.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.f1935lb.transact(FitnessStatusCodes.TRANSIENT_ERROR, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            /* renamed from: i */
            public void mo6560i(int i, String str) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.games.internal.IGamesCallbacks");
                    obtain.writeInt(i);
                    obtain.writeString(str);
                    this.f1935lb.transact(12012, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            /* renamed from: i */
            public void mo6561i(DataHolder dataHolder) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.games.internal.IGamesCallbacks");
                    if (dataHolder != null) {
                        obtain.writeInt(1);
                        dataHolder.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.f1935lb.transact(FitnessStatusCodes.EQUIVALENT_SESSION_ENDED, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            /* renamed from: j */
            public void mo6562j(DataHolder dataHolder) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.games.internal.IGamesCallbacks");
                    if (dataHolder != null) {
                        obtain.writeInt(1);
                        dataHolder.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.f1935lb.transact(FitnessStatusCodes.APP_NOT_FIT_ENABLED, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            /* renamed from: k */
            public void mo6563k(DataHolder dataHolder) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.games.internal.IGamesCallbacks");
                    if (dataHolder != null) {
                        obtain.writeInt(1);
                        dataHolder.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.f1935lb.transact(FitnessStatusCodes.API_EXCEPTION, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            /* renamed from: l */
            public void mo6564l(DataHolder dataHolder) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.games.internal.IGamesCallbacks");
                    if (dataHolder != null) {
                        obtain.writeInt(1);
                        dataHolder.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.f1935lb.transact(9001, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            /* renamed from: m */
            public void mo6565m(DataHolder dataHolder) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.games.internal.IGamesCallbacks");
                    if (dataHolder != null) {
                        obtain.writeInt(1);
                        dataHolder.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.f1935lb.transact(5017, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            /* renamed from: n */
            public void mo6566n(DataHolder dataHolder) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.games.internal.IGamesCallbacks");
                    if (dataHolder != null) {
                        obtain.writeInt(1);
                        dataHolder.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.f1935lb.transact(5037, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            /* renamed from: o */
            public void mo6567o(DataHolder dataHolder) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.games.internal.IGamesCallbacks");
                    if (dataHolder != null) {
                        obtain.writeInt(1);
                        dataHolder.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.f1935lb.transact(GamesActivityResultCodes.RESULT_RECONNECT_REQUIRED, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void onInvitationRemoved(String invitationId) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.games.internal.IGamesCallbacks");
                    obtain.writeString(invitationId);
                    this.f1935lb.transact(8010, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void onLeftRoom(int statusCode, String roomId) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.games.internal.IGamesCallbacks");
                    obtain.writeInt(statusCode);
                    obtain.writeString(roomId);
                    this.f1935lb.transact(5020, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void onP2PConnected(String participantId) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.games.internal.IGamesCallbacks");
                    obtain.writeString(participantId);
                    this.f1935lb.transact(GamesStatusCodes.STATUS_MULTIPLAYER_ERROR_NOT_TRUSTED_TESTER, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void onP2PDisconnected(String participantId) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.games.internal.IGamesCallbacks");
                    obtain.writeString(participantId);
                    this.f1935lb.transact(GamesStatusCodes.STATUS_MULTIPLAYER_ERROR_INVALID_MULTIPLAYER_TYPE, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void onRealTimeMessageReceived(RealTimeMessage message) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.games.internal.IGamesCallbacks");
                    if (message != null) {
                        obtain.writeInt(1);
                        message.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.f1935lb.transact(5032, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void onRequestRemoved(String requestId) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.games.internal.IGamesCallbacks");
                    obtain.writeString(requestId);
                    this.f1935lb.transact(GamesActivityResultCodes.RESULT_SIGN_IN_FAILED, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void onTurnBasedMatchRemoved(String matchId) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.games.internal.IGamesCallbacks");
                    obtain.writeString(matchId);
                    this.f1935lb.transact(8009, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            /* renamed from: p */
            public void mo6575p(DataHolder dataHolder) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.games.internal.IGamesCallbacks");
                    if (dataHolder != null) {
                        obtain.writeInt(1);
                        dataHolder.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.f1935lb.transact(GamesStatusCodes.STATUS_QUEST_NOT_STARTED, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            /* renamed from: q */
            public void mo6576q(DataHolder dataHolder) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.games.internal.IGamesCallbacks");
                    if (dataHolder != null) {
                        obtain.writeInt(1);
                        dataHolder.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.f1935lb.transact(8004, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            /* renamed from: r */
            public void mo6577r(DataHolder dataHolder) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.games.internal.IGamesCallbacks");
                    if (dataHolder != null) {
                        obtain.writeInt(1);
                        dataHolder.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.f1935lb.transact(8005, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            /* renamed from: s */
            public void mo6578s(DataHolder dataHolder) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.games.internal.IGamesCallbacks");
                    if (dataHolder != null) {
                        obtain.writeInt(1);
                        dataHolder.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.f1935lb.transact(8006, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            /* renamed from: t */
            public void mo6579t(DataHolder dataHolder) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.games.internal.IGamesCallbacks");
                    if (dataHolder != null) {
                        obtain.writeInt(1);
                        dataHolder.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.f1935lb.transact(8008, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            /* renamed from: u */
            public void mo6580u(DataHolder dataHolder) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.games.internal.IGamesCallbacks");
                    if (dataHolder != null) {
                        obtain.writeInt(1);
                        dataHolder.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.f1935lb.transact(5018, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            /* renamed from: v */
            public void mo6581v(DataHolder dataHolder) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.games.internal.IGamesCallbacks");
                    if (dataHolder != null) {
                        obtain.writeInt(1);
                        dataHolder.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.f1935lb.transact(5019, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            /* renamed from: w */
            public void mo6582w(DataHolder dataHolder) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.games.internal.IGamesCallbacks");
                    if (dataHolder != null) {
                        obtain.writeInt(1);
                        dataHolder.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.f1935lb.transact(5021, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            /* renamed from: x */
            public void mo6583x(DataHolder dataHolder) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.games.internal.IGamesCallbacks");
                    if (dataHolder != null) {
                        obtain.writeInt(1);
                        dataHolder.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.f1935lb.transact(5022, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            /* renamed from: y */
            public void mo6584y(DataHolder dataHolder) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.games.internal.IGamesCallbacks");
                    if (dataHolder != null) {
                        obtain.writeInt(1);
                        dataHolder.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.f1935lb.transact(5023, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            /* renamed from: z */
            public void mo6585z(DataHolder dataHolder) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.games.internal.IGamesCallbacks");
                    if (dataHolder != null) {
                        obtain.writeInt(1);
                        dataHolder.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.f1935lb.transact(5024, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }
        }

        public Stub() {
            attachInterface(this, "com.google.android.gms.games.internal.IGamesCallbacks");
        }

        /* renamed from: aA */
        public static IGamesCallbacks m2620aA(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.games.internal.IGamesCallbacks");
            return (queryLocalInterface == null || !(queryLocalInterface instanceof IGamesCallbacks)) ? new Proxy(iBinder) : (IGamesCallbacks) queryLocalInterface;
        }

        public IBinder asBinder() {
            return this;
        }

        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v1, resolved type: com.google.android.gms.common.data.DataHolder} */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v3, resolved type: com.google.android.gms.common.data.DataHolder} */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v5, resolved type: com.google.android.gms.common.data.DataHolder} */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v7, resolved type: com.google.android.gms.common.data.DataHolder} */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v9, resolved type: com.google.android.gms.common.data.DataHolder} */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v11, resolved type: com.google.android.gms.common.data.DataHolder} */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v13, resolved type: com.google.android.gms.common.data.DataHolder} */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v15, resolved type: com.google.android.gms.common.data.DataHolder} */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v17, resolved type: com.google.android.gms.common.data.DataHolder} */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v19, resolved type: com.google.android.gms.drive.Contents} */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v21, resolved type: com.google.android.gms.common.data.DataHolder} */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v23, resolved type: com.google.android.gms.common.data.DataHolder} */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v25, resolved type: com.google.android.gms.common.data.DataHolder} */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v27, resolved type: com.google.android.gms.common.data.DataHolder} */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v29, resolved type: com.google.android.gms.common.data.DataHolder} */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v31, resolved type: com.google.android.gms.common.data.DataHolder} */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v33, resolved type: com.google.android.gms.common.data.DataHolder} */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v35, resolved type: com.google.android.gms.common.data.DataHolder} */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v37, resolved type: com.google.android.gms.common.data.DataHolder} */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v39, resolved type: com.google.android.gms.common.data.DataHolder} */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v41, resolved type: com.google.android.gms.common.data.DataHolder} */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v43, resolved type: com.google.android.gms.common.data.DataHolder} */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v45, resolved type: com.google.android.gms.common.data.DataHolder} */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v47, resolved type: com.google.android.gms.common.data.DataHolder} */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v49, resolved type: com.google.android.gms.common.data.DataHolder} */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v51, resolved type: com.google.android.gms.common.data.DataHolder} */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v53, resolved type: com.google.android.gms.common.data.DataHolder} */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v55, resolved type: com.google.android.gms.common.data.DataHolder} */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v57, resolved type: com.google.android.gms.common.data.DataHolder} */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v59, resolved type: com.google.android.gms.common.data.DataHolder} */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v61, resolved type: com.google.android.gms.common.data.DataHolder} */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v63, resolved type: com.google.android.gms.common.data.DataHolder} */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v65, resolved type: com.google.android.gms.common.data.DataHolder} */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v67, resolved type: com.google.android.gms.common.data.DataHolder} */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v69, resolved type: com.google.android.gms.common.data.DataHolder} */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v71, resolved type: com.google.android.gms.common.data.DataHolder} */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v73, resolved type: com.google.android.gms.common.data.DataHolder} */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v75, resolved type: com.google.android.gms.common.data.DataHolder} */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v77, resolved type: com.google.android.gms.common.data.DataHolder} */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v79, resolved type: com.google.android.gms.common.data.DataHolder} */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v81, resolved type: com.google.android.gms.common.data.DataHolder} */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v83, resolved type: com.google.android.gms.common.data.DataHolder} */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v85, resolved type: com.google.android.gms.common.data.DataHolder} */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v87, resolved type: com.google.android.gms.common.data.DataHolder} */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v89, resolved type: com.google.android.gms.common.data.DataHolder} */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v91, resolved type: com.google.android.gms.common.data.DataHolder} */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v93, resolved type: com.google.android.gms.common.data.DataHolder} */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v95, resolved type: com.google.android.gms.common.data.DataHolder} */
        /* JADX WARNING: type inference failed for: r5v0 */
        /* JADX WARNING: type inference failed for: r5v20 */
        /* JADX WARNING: type inference failed for: r5v97 */
        /* JADX WARNING: type inference failed for: r5v98 */
        /* JADX WARNING: type inference failed for: r5v99 */
        /* JADX WARNING: type inference failed for: r5v100 */
        /* JADX WARNING: type inference failed for: r5v101 */
        /* JADX WARNING: type inference failed for: r5v102 */
        /* JADX WARNING: type inference failed for: r5v103 */
        /* JADX WARNING: type inference failed for: r5v104 */
        /* JADX WARNING: type inference failed for: r5v105 */
        /* JADX WARNING: type inference failed for: r5v106 */
        /* JADX WARNING: type inference failed for: r5v107 */
        /* JADX WARNING: type inference failed for: r5v108 */
        /* JADX WARNING: type inference failed for: r5v109 */
        /* JADX WARNING: type inference failed for: r5v110 */
        /* JADX WARNING: type inference failed for: r5v111 */
        /* JADX WARNING: type inference failed for: r5v112 */
        /* JADX WARNING: type inference failed for: r5v113 */
        /* JADX WARNING: type inference failed for: r5v114 */
        /* JADX WARNING: type inference failed for: r5v115 */
        /* JADX WARNING: type inference failed for: r5v116 */
        /* JADX WARNING: type inference failed for: r5v117 */
        /* JADX WARNING: type inference failed for: r5v118 */
        /* JADX WARNING: type inference failed for: r5v119 */
        /* JADX WARNING: type inference failed for: r5v120 */
        /* JADX WARNING: type inference failed for: r5v121 */
        /* JADX WARNING: type inference failed for: r5v122 */
        /* JADX WARNING: type inference failed for: r5v123 */
        /* JADX WARNING: type inference failed for: r5v124 */
        /* JADX WARNING: type inference failed for: r5v125 */
        /* JADX WARNING: type inference failed for: r5v126 */
        /* JADX WARNING: type inference failed for: r5v127 */
        /* JADX WARNING: type inference failed for: r5v128 */
        /* JADX WARNING: type inference failed for: r5v129 */
        /* JADX WARNING: type inference failed for: r5v130 */
        /* JADX WARNING: type inference failed for: r5v131 */
        /* JADX WARNING: type inference failed for: r5v132 */
        /* JADX WARNING: type inference failed for: r5v133 */
        /* JADX WARNING: type inference failed for: r5v134 */
        /* JADX WARNING: type inference failed for: r5v135 */
        /* JADX WARNING: type inference failed for: r5v136 */
        /* JADX WARNING: type inference failed for: r5v137 */
        /* JADX WARNING: type inference failed for: r5v138 */
        /* JADX WARNING: type inference failed for: r5v139 */
        /* JADX WARNING: type inference failed for: r5v140 */
        /* JADX WARNING: type inference failed for: r5v141 */
        /* JADX WARNING: type inference failed for: r5v142 */
        /* JADX WARNING: type inference failed for: r5v143 */
        /* JADX WARNING: Multi-variable type inference failed */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public boolean onTransact(int r8, android.os.Parcel r9, android.os.Parcel r10, int r11) throws android.os.RemoteException {
            /*
                r7 = this;
                r5 = 0
                r6 = 1
                switch(r8) {
                    case 5001: goto L_0x0010;
                    case 5002: goto L_0x0024;
                    case 5003: goto L_0x003e;
                    case 5004: goto L_0x0052;
                    case 5005: goto L_0x006a;
                    case 5006: goto L_0x0091;
                    case 5007: goto L_0x00aa;
                    case 5008: goto L_0x00c3;
                    case 5009: goto L_0x00dc;
                    case 5010: goto L_0x00f5;
                    case 5011: goto L_0x010e;
                    case 5016: goto L_0x0127;
                    case 5017: goto L_0x0134;
                    case 5018: goto L_0x0166;
                    case 5019: goto L_0x017f;
                    case 5020: goto L_0x0198;
                    case 5021: goto L_0x01ad;
                    case 5022: goto L_0x01c6;
                    case 5023: goto L_0x01df;
                    case 5024: goto L_0x01f8;
                    case 5025: goto L_0x0211;
                    case 5026: goto L_0x022a;
                    case 5027: goto L_0x0247;
                    case 5028: goto L_0x0264;
                    case 5029: goto L_0x0281;
                    case 5030: goto L_0x029e;
                    case 5031: goto L_0x02bb;
                    case 5032: goto L_0x02d8;
                    case 5033: goto L_0x02f5;
                    case 5034: goto L_0x030e;
                    case 5035: goto L_0x0345;
                    case 5036: goto L_0x035e;
                    case 5037: goto L_0x014d;
                    case 5038: goto L_0x032c;
                    case 5039: goto L_0x036f;
                    case 5040: goto L_0x0388;
                    case 6001: goto L_0x0399;
                    case 6002: goto L_0x03aa;
                    case 8001: goto L_0x03bb;
                    case 8002: goto L_0x03d4;
                    case 8003: goto L_0x03f5;
                    case 8004: goto L_0x040e;
                    case 8005: goto L_0x0427;
                    case 8006: goto L_0x0440;
                    case 8007: goto L_0x0459;
                    case 8008: goto L_0x046e;
                    case 8009: goto L_0x0487;
                    case 8010: goto L_0x0498;
                    case 9001: goto L_0x04a9;
                    case 10001: goto L_0x04c2;
                    case 10002: goto L_0x04db;
                    case 10003: goto L_0x04ec;
                    case 10004: goto L_0x0505;
                    case 10005: goto L_0x051e;
                    case 10006: goto L_0x053f;
                    case 11001: goto L_0x0558;
                    case 12001: goto L_0x0579;
                    case 12003: goto L_0x063d;
                    case 12004: goto L_0x0592;
                    case 12005: goto L_0x060f;
                    case 12006: goto L_0x0690;
                    case 12007: goto L_0x06a9;
                    case 12008: goto L_0x06f4;
                    case 12011: goto L_0x0677;
                    case 12012: goto L_0x0628;
                    case 12013: goto L_0x065e;
                    case 12014: goto L_0x06c2;
                    case 12015: goto L_0x070d;
                    case 12016: goto L_0x06db;
                    case 12017: goto L_0x05be;
                    case 13001: goto L_0x072e;
                    case 13002: goto L_0x0747;
                    case 1598968902: goto L_0x000a;
                    default: goto L_0x0005;
                }
            L_0x0005:
                boolean r6 = super.onTransact(r8, r9, r10, r11)
            L_0x0009:
                return r6
            L_0x000a:
                java.lang.String r0 = "com.google.android.gms.games.internal.IGamesCallbacks"
                r10.writeString(r0)
                goto L_0x0009
            L_0x0010:
                java.lang.String r0 = "com.google.android.gms.games.internal.IGamesCallbacks"
                r9.enforceInterface(r0)
                int r0 = r9.readInt()
                java.lang.String r1 = r9.readString()
                r7.mo6552f((int) r0, (java.lang.String) r1)
                r10.writeNoException()
                goto L_0x0009
            L_0x0024:
                java.lang.String r0 = "com.google.android.gms.games.internal.IGamesCallbacks"
                r9.enforceInterface(r0)
                int r0 = r9.readInt()
                if (r0 == 0) goto L_0x003c
                com.google.android.gms.common.data.f r0 = com.google.android.gms.common.data.DataHolder.CREATOR
                com.google.android.gms.common.data.DataHolder r0 = r0.createFromParcel(r9)
            L_0x0035:
                r7.mo6540c(r0)
                r10.writeNoException()
                goto L_0x0009
            L_0x003c:
                r0 = r5
                goto L_0x0035
            L_0x003e:
                java.lang.String r0 = "com.google.android.gms.games.internal.IGamesCallbacks"
                r9.enforceInterface(r0)
                int r0 = r9.readInt()
                java.lang.String r1 = r9.readString()
                r7.mo6556g(r0, r1)
                r10.writeNoException()
                goto L_0x0009
            L_0x0052:
                java.lang.String r0 = "com.google.android.gms.games.internal.IGamesCallbacks"
                r9.enforceInterface(r0)
                int r0 = r9.readInt()
                if (r0 == 0) goto L_0x0063
                com.google.android.gms.common.data.f r0 = com.google.android.gms.common.data.DataHolder.CREATOR
                com.google.android.gms.common.data.DataHolder r5 = r0.createFromParcel(r9)
            L_0x0063:
                r7.mo6549e(r5)
                r10.writeNoException()
                goto L_0x0009
            L_0x006a:
                java.lang.String r0 = "com.google.android.gms.games.internal.IGamesCallbacks"
                r9.enforceInterface(r0)
                int r0 = r9.readInt()
                if (r0 == 0) goto L_0x008f
                com.google.android.gms.common.data.f r0 = com.google.android.gms.common.data.DataHolder.CREATOR
                com.google.android.gms.common.data.DataHolder r0 = r0.createFromParcel(r9)
            L_0x007b:
                int r1 = r9.readInt()
                if (r1 == 0) goto L_0x0087
                com.google.android.gms.common.data.f r1 = com.google.android.gms.common.data.DataHolder.CREATOR
                com.google.android.gms.common.data.DataHolder r5 = r1.createFromParcel(r9)
            L_0x0087:
                r7.mo6532a((com.google.android.gms.common.data.DataHolder) r0, (com.google.android.gms.common.data.DataHolder) r5)
                r10.writeNoException()
                goto L_0x0009
            L_0x008f:
                r0 = r5
                goto L_0x007b
            L_0x0091:
                java.lang.String r0 = "com.google.android.gms.games.internal.IGamesCallbacks"
                r9.enforceInterface(r0)
                int r0 = r9.readInt()
                if (r0 == 0) goto L_0x00a2
                com.google.android.gms.common.data.f r0 = com.google.android.gms.common.data.DataHolder.CREATOR
                com.google.android.gms.common.data.DataHolder r5 = r0.createFromParcel(r9)
            L_0x00a2:
                r7.mo6553f(r5)
                r10.writeNoException()
                goto L_0x0009
            L_0x00aa:
                java.lang.String r0 = "com.google.android.gms.games.internal.IGamesCallbacks"
                r9.enforceInterface(r0)
                int r0 = r9.readInt()
                if (r0 == 0) goto L_0x00bb
                com.google.android.gms.common.data.f r0 = com.google.android.gms.common.data.DataHolder.CREATOR
                com.google.android.gms.common.data.DataHolder r5 = r0.createFromParcel(r9)
            L_0x00bb:
                r7.mo6557g(r5)
                r10.writeNoException()
                goto L_0x0009
            L_0x00c3:
                java.lang.String r0 = "com.google.android.gms.games.internal.IGamesCallbacks"
                r9.enforceInterface(r0)
                int r0 = r9.readInt()
                if (r0 == 0) goto L_0x00d4
                com.google.android.gms.common.data.f r0 = com.google.android.gms.common.data.DataHolder.CREATOR
                com.google.android.gms.common.data.DataHolder r5 = r0.createFromParcel(r9)
            L_0x00d4:
                r7.mo6559h(r5)
                r10.writeNoException()
                goto L_0x0009
            L_0x00dc:
                java.lang.String r0 = "com.google.android.gms.games.internal.IGamesCallbacks"
                r9.enforceInterface(r0)
                int r0 = r9.readInt()
                if (r0 == 0) goto L_0x00ed
                com.google.android.gms.common.data.f r0 = com.google.android.gms.common.data.DataHolder.CREATOR
                com.google.android.gms.common.data.DataHolder r5 = r0.createFromParcel(r9)
            L_0x00ed:
                r7.mo6561i(r5)
                r10.writeNoException()
                goto L_0x0009
            L_0x00f5:
                java.lang.String r0 = "com.google.android.gms.games.internal.IGamesCallbacks"
                r9.enforceInterface(r0)
                int r0 = r9.readInt()
                if (r0 == 0) goto L_0x0106
                com.google.android.gms.common.data.f r0 = com.google.android.gms.common.data.DataHolder.CREATOR
                com.google.android.gms.common.data.DataHolder r5 = r0.createFromParcel(r9)
            L_0x0106:
                r7.mo6562j(r5)
                r10.writeNoException()
                goto L_0x0009
            L_0x010e:
                java.lang.String r0 = "com.google.android.gms.games.internal.IGamesCallbacks"
                r9.enforceInterface(r0)
                int r0 = r9.readInt()
                if (r0 == 0) goto L_0x011f
                com.google.android.gms.common.data.f r0 = com.google.android.gms.common.data.DataHolder.CREATOR
                com.google.android.gms.common.data.DataHolder r5 = r0.createFromParcel(r9)
            L_0x011f:
                r7.mo6563k(r5)
                r10.writeNoException()
                goto L_0x0009
            L_0x0127:
                java.lang.String r0 = "com.google.android.gms.games.internal.IGamesCallbacks"
                r9.enforceInterface(r0)
                r7.mo6555fq()
                r10.writeNoException()
                goto L_0x0009
            L_0x0134:
                java.lang.String r0 = "com.google.android.gms.games.internal.IGamesCallbacks"
                r9.enforceInterface(r0)
                int r0 = r9.readInt()
                if (r0 == 0) goto L_0x0145
                com.google.android.gms.common.data.f r0 = com.google.android.gms.common.data.DataHolder.CREATOR
                com.google.android.gms.common.data.DataHolder r5 = r0.createFromParcel(r9)
            L_0x0145:
                r7.mo6565m(r5)
                r10.writeNoException()
                goto L_0x0009
            L_0x014d:
                java.lang.String r0 = "com.google.android.gms.games.internal.IGamesCallbacks"
                r9.enforceInterface(r0)
                int r0 = r9.readInt()
                if (r0 == 0) goto L_0x015e
                com.google.android.gms.common.data.f r0 = com.google.android.gms.common.data.DataHolder.CREATOR
                com.google.android.gms.common.data.DataHolder r5 = r0.createFromParcel(r9)
            L_0x015e:
                r7.mo6566n(r5)
                r10.writeNoException()
                goto L_0x0009
            L_0x0166:
                java.lang.String r0 = "com.google.android.gms.games.internal.IGamesCallbacks"
                r9.enforceInterface(r0)
                int r0 = r9.readInt()
                if (r0 == 0) goto L_0x0177
                com.google.android.gms.common.data.f r0 = com.google.android.gms.common.data.DataHolder.CREATOR
                com.google.android.gms.common.data.DataHolder r5 = r0.createFromParcel(r9)
            L_0x0177:
                r7.mo6580u(r5)
                r10.writeNoException()
                goto L_0x0009
            L_0x017f:
                java.lang.String r0 = "com.google.android.gms.games.internal.IGamesCallbacks"
                r9.enforceInterface(r0)
                int r0 = r9.readInt()
                if (r0 == 0) goto L_0x0190
                com.google.android.gms.common.data.f r0 = com.google.android.gms.common.data.DataHolder.CREATOR
                com.google.android.gms.common.data.DataHolder r5 = r0.createFromParcel(r9)
            L_0x0190:
                r7.mo6581v(r5)
                r10.writeNoException()
                goto L_0x0009
            L_0x0198:
                java.lang.String r0 = "com.google.android.gms.games.internal.IGamesCallbacks"
                r9.enforceInterface(r0)
                int r0 = r9.readInt()
                java.lang.String r1 = r9.readString()
                r7.onLeftRoom(r0, r1)
                r10.writeNoException()
                goto L_0x0009
            L_0x01ad:
                java.lang.String r0 = "com.google.android.gms.games.internal.IGamesCallbacks"
                r9.enforceInterface(r0)
                int r0 = r9.readInt()
                if (r0 == 0) goto L_0x01be
                com.google.android.gms.common.data.f r0 = com.google.android.gms.common.data.DataHolder.CREATOR
                com.google.android.gms.common.data.DataHolder r5 = r0.createFromParcel(r9)
            L_0x01be:
                r7.mo6582w(r5)
                r10.writeNoException()
                goto L_0x0009
            L_0x01c6:
                java.lang.String r0 = "com.google.android.gms.games.internal.IGamesCallbacks"
                r9.enforceInterface(r0)
                int r0 = r9.readInt()
                if (r0 == 0) goto L_0x01d7
                com.google.android.gms.common.data.f r0 = com.google.android.gms.common.data.DataHolder.CREATOR
                com.google.android.gms.common.data.DataHolder r5 = r0.createFromParcel(r9)
            L_0x01d7:
                r7.mo6583x(r5)
                r10.writeNoException()
                goto L_0x0009
            L_0x01df:
                java.lang.String r0 = "com.google.android.gms.games.internal.IGamesCallbacks"
                r9.enforceInterface(r0)
                int r0 = r9.readInt()
                if (r0 == 0) goto L_0x01f0
                com.google.android.gms.common.data.f r0 = com.google.android.gms.common.data.DataHolder.CREATOR
                com.google.android.gms.common.data.DataHolder r5 = r0.createFromParcel(r9)
            L_0x01f0:
                r7.mo6584y(r5)
                r10.writeNoException()
                goto L_0x0009
            L_0x01f8:
                java.lang.String r0 = "com.google.android.gms.games.internal.IGamesCallbacks"
                r9.enforceInterface(r0)
                int r0 = r9.readInt()
                if (r0 == 0) goto L_0x0209
                com.google.android.gms.common.data.f r0 = com.google.android.gms.common.data.DataHolder.CREATOR
                com.google.android.gms.common.data.DataHolder r5 = r0.createFromParcel(r9)
            L_0x0209:
                r7.mo6585z(r5)
                r10.writeNoException()
                goto L_0x0009
            L_0x0211:
                java.lang.String r0 = "com.google.android.gms.games.internal.IGamesCallbacks"
                r9.enforceInterface(r0)
                int r0 = r9.readInt()
                if (r0 == 0) goto L_0x0222
                com.google.android.gms.common.data.f r0 = com.google.android.gms.common.data.DataHolder.CREATOR
                com.google.android.gms.common.data.DataHolder r5 = r0.createFromParcel(r9)
            L_0x0222:
                r7.mo6514A(r5)
                r10.writeNoException()
                goto L_0x0009
            L_0x022a:
                java.lang.String r0 = "com.google.android.gms.games.internal.IGamesCallbacks"
                r9.enforceInterface(r0)
                int r0 = r9.readInt()
                if (r0 == 0) goto L_0x023b
                com.google.android.gms.common.data.f r0 = com.google.android.gms.common.data.DataHolder.CREATOR
                com.google.android.gms.common.data.DataHolder r5 = r0.createFromParcel(r9)
            L_0x023b:
                java.lang.String[] r0 = r9.createStringArray()
                r7.mo6535a((com.google.android.gms.common.data.DataHolder) r5, (java.lang.String[]) r0)
                r10.writeNoException()
                goto L_0x0009
            L_0x0247:
                java.lang.String r0 = "com.google.android.gms.games.internal.IGamesCallbacks"
                r9.enforceInterface(r0)
                int r0 = r9.readInt()
                if (r0 == 0) goto L_0x0258
                com.google.android.gms.common.data.f r0 = com.google.android.gms.common.data.DataHolder.CREATOR
                com.google.android.gms.common.data.DataHolder r5 = r0.createFromParcel(r9)
            L_0x0258:
                java.lang.String[] r0 = r9.createStringArray()
                r7.mo6538b((com.google.android.gms.common.data.DataHolder) r5, (java.lang.String[]) r0)
                r10.writeNoException()
                goto L_0x0009
            L_0x0264:
                java.lang.String r0 = "com.google.android.gms.games.internal.IGamesCallbacks"
                r9.enforceInterface(r0)
                int r0 = r9.readInt()
                if (r0 == 0) goto L_0x0275
                com.google.android.gms.common.data.f r0 = com.google.android.gms.common.data.DataHolder.CREATOR
                com.google.android.gms.common.data.DataHolder r5 = r0.createFromParcel(r9)
            L_0x0275:
                java.lang.String[] r0 = r9.createStringArray()
                r7.mo6541c((com.google.android.gms.common.data.DataHolder) r5, (java.lang.String[]) r0)
                r10.writeNoException()
                goto L_0x0009
            L_0x0281:
                java.lang.String r0 = "com.google.android.gms.games.internal.IGamesCallbacks"
                r9.enforceInterface(r0)
                int r0 = r9.readInt()
                if (r0 == 0) goto L_0x0292
                com.google.android.gms.common.data.f r0 = com.google.android.gms.common.data.DataHolder.CREATOR
                com.google.android.gms.common.data.DataHolder r5 = r0.createFromParcel(r9)
            L_0x0292:
                java.lang.String[] r0 = r9.createStringArray()
                r7.mo6544d((com.google.android.gms.common.data.DataHolder) r5, (java.lang.String[]) r0)
                r10.writeNoException()
                goto L_0x0009
            L_0x029e:
                java.lang.String r0 = "com.google.android.gms.games.internal.IGamesCallbacks"
                r9.enforceInterface(r0)
                int r0 = r9.readInt()
                if (r0 == 0) goto L_0x02af
                com.google.android.gms.common.data.f r0 = com.google.android.gms.common.data.DataHolder.CREATOR
                com.google.android.gms.common.data.DataHolder r5 = r0.createFromParcel(r9)
            L_0x02af:
                java.lang.String[] r0 = r9.createStringArray()
                r7.mo6550e((com.google.android.gms.common.data.DataHolder) r5, (java.lang.String[]) r0)
                r10.writeNoException()
                goto L_0x0009
            L_0x02bb:
                java.lang.String r0 = "com.google.android.gms.games.internal.IGamesCallbacks"
                r9.enforceInterface(r0)
                int r0 = r9.readInt()
                if (r0 == 0) goto L_0x02cc
                com.google.android.gms.common.data.f r0 = com.google.android.gms.common.data.DataHolder.CREATOR
                com.google.android.gms.common.data.DataHolder r5 = r0.createFromParcel(r9)
            L_0x02cc:
                java.lang.String[] r0 = r9.createStringArray()
                r7.mo6554f((com.google.android.gms.common.data.DataHolder) r5, (java.lang.String[]) r0)
                r10.writeNoException()
                goto L_0x0009
            L_0x02d8:
                java.lang.String r0 = "com.google.android.gms.games.internal.IGamesCallbacks"
                r9.enforceInterface(r0)
                int r0 = r9.readInt()
                if (r0 == 0) goto L_0x02f3
                android.os.Parcelable$Creator<com.google.android.gms.games.multiplayer.realtime.RealTimeMessage> r0 = com.google.android.gms.games.multiplayer.realtime.RealTimeMessage.CREATOR
                java.lang.Object r0 = r0.createFromParcel(r9)
                com.google.android.gms.games.multiplayer.realtime.RealTimeMessage r0 = (com.google.android.gms.games.multiplayer.realtime.RealTimeMessage) r0
            L_0x02eb:
                r7.onRealTimeMessageReceived(r0)
                r10.writeNoException()
                goto L_0x0009
            L_0x02f3:
                r0 = r5
                goto L_0x02eb
            L_0x02f5:
                java.lang.String r0 = "com.google.android.gms.games.internal.IGamesCallbacks"
                r9.enforceInterface(r0)
                int r0 = r9.readInt()
                int r1 = r9.readInt()
                java.lang.String r2 = r9.readString()
                r7.mo6536b(r0, r1, r2)
                r10.writeNoException()
                goto L_0x0009
            L_0x030e:
                java.lang.String r0 = "com.google.android.gms.games.internal.IGamesCallbacks"
                r9.enforceInterface(r0)
                int r1 = r9.readInt()
                java.lang.String r2 = r9.readString()
                int r0 = r9.readInt()
                if (r0 == 0) goto L_0x032a
                r0 = r6
            L_0x0322:
                r7.mo6531a(r1, r2, r0)
                r10.writeNoException()
                goto L_0x0009
            L_0x032a:
                r0 = 0
                goto L_0x0322
            L_0x032c:
                java.lang.String r0 = "com.google.android.gms.games.internal.IGamesCallbacks"
                r9.enforceInterface(r0)
                int r0 = r9.readInt()
                if (r0 == 0) goto L_0x033d
                com.google.android.gms.common.data.f r0 = com.google.android.gms.common.data.DataHolder.CREATOR
                com.google.android.gms.common.data.DataHolder r5 = r0.createFromParcel(r9)
            L_0x033d:
                r7.mo6515B(r5)
                r10.writeNoException()
                goto L_0x0009
            L_0x0345:
                java.lang.String r0 = "com.google.android.gms.games.internal.IGamesCallbacks"
                r9.enforceInterface(r0)
                int r0 = r9.readInt()
                if (r0 == 0) goto L_0x0356
                com.google.android.gms.common.data.f r0 = com.google.android.gms.common.data.DataHolder.CREATOR
                com.google.android.gms.common.data.DataHolder r5 = r0.createFromParcel(r9)
            L_0x0356:
                r7.mo6516C(r5)
                r10.writeNoException()
                goto L_0x0009
            L_0x035e:
                java.lang.String r0 = "com.google.android.gms.games.internal.IGamesCallbacks"
                r9.enforceInterface(r0)
                int r0 = r9.readInt()
                r7.mo6545dx(r0)
                r10.writeNoException()
                goto L_0x0009
            L_0x036f:
                java.lang.String r0 = "com.google.android.gms.games.internal.IGamesCallbacks"
                r9.enforceInterface(r0)
                int r0 = r9.readInt()
                if (r0 == 0) goto L_0x0380
                com.google.android.gms.common.data.f r0 = com.google.android.gms.common.data.DataHolder.CREATOR
                com.google.android.gms.common.data.DataHolder r5 = r0.createFromParcel(r9)
            L_0x0380:
                r7.mo6517D(r5)
                r10.writeNoException()
                goto L_0x0009
            L_0x0388:
                java.lang.String r0 = "com.google.android.gms.games.internal.IGamesCallbacks"
                r9.enforceInterface(r0)
                int r0 = r9.readInt()
                r7.mo6546dy(r0)
                r10.writeNoException()
                goto L_0x0009
            L_0x0399:
                java.lang.String r0 = "com.google.android.gms.games.internal.IGamesCallbacks"
                r9.enforceInterface(r0)
                java.lang.String r0 = r9.readString()
                r7.onP2PConnected(r0)
                r10.writeNoException()
                goto L_0x0009
            L_0x03aa:
                java.lang.String r0 = "com.google.android.gms.games.internal.IGamesCallbacks"
                r9.enforceInterface(r0)
                java.lang.String r0 = r9.readString()
                r7.onP2PDisconnected(r0)
                r10.writeNoException()
                goto L_0x0009
            L_0x03bb:
                java.lang.String r0 = "com.google.android.gms.games.internal.IGamesCallbacks"
                r9.enforceInterface(r0)
                int r0 = r9.readInt()
                if (r0 == 0) goto L_0x03cc
                com.google.android.gms.common.data.f r0 = com.google.android.gms.common.data.DataHolder.CREATOR
                com.google.android.gms.common.data.DataHolder r5 = r0.createFromParcel(r9)
            L_0x03cc:
                r7.mo6518E(r5)
                r10.writeNoException()
                goto L_0x0009
            L_0x03d4:
                java.lang.String r0 = "com.google.android.gms.games.internal.IGamesCallbacks"
                r9.enforceInterface(r0)
                int r1 = r9.readInt()
                int r0 = r9.readInt()
                if (r0 == 0) goto L_0x03f3
                android.os.Parcelable$Creator r0 = android.os.Bundle.CREATOR
                java.lang.Object r0 = r0.createFromParcel(r9)
                android.os.Bundle r0 = (android.os.Bundle) r0
            L_0x03eb:
                r7.mo6537b((int) r1, (android.os.Bundle) r0)
                r10.writeNoException()
                goto L_0x0009
            L_0x03f3:
                r0 = r5
                goto L_0x03eb
            L_0x03f5:
                java.lang.String r0 = "com.google.android.gms.games.internal.IGamesCallbacks"
                r9.enforceInterface(r0)
                int r0 = r9.readInt()
                if (r0 == 0) goto L_0x0406
                com.google.android.gms.common.data.f r0 = com.google.android.gms.common.data.DataHolder.CREATOR
                com.google.android.gms.common.data.DataHolder r5 = r0.createFromParcel(r9)
            L_0x0406:
                r7.mo6575p(r5)
                r10.writeNoException()
                goto L_0x0009
            L_0x040e:
                java.lang.String r0 = "com.google.android.gms.games.internal.IGamesCallbacks"
                r9.enforceInterface(r0)
                int r0 = r9.readInt()
                if (r0 == 0) goto L_0x041f
                com.google.android.gms.common.data.f r0 = com.google.android.gms.common.data.DataHolder.CREATOR
                com.google.android.gms.common.data.DataHolder r5 = r0.createFromParcel(r9)
            L_0x041f:
                r7.mo6576q(r5)
                r10.writeNoException()
                goto L_0x0009
            L_0x0427:
                java.lang.String r0 = "com.google.android.gms.games.internal.IGamesCallbacks"
                r9.enforceInterface(r0)
                int r0 = r9.readInt()
                if (r0 == 0) goto L_0x0438
                com.google.android.gms.common.data.f r0 = com.google.android.gms.common.data.DataHolder.CREATOR
                com.google.android.gms.common.data.DataHolder r5 = r0.createFromParcel(r9)
            L_0x0438:
                r7.mo6577r(r5)
                r10.writeNoException()
                goto L_0x0009
            L_0x0440:
                java.lang.String r0 = "com.google.android.gms.games.internal.IGamesCallbacks"
                r9.enforceInterface(r0)
                int r0 = r9.readInt()
                if (r0 == 0) goto L_0x0451
                com.google.android.gms.common.data.f r0 = com.google.android.gms.common.data.DataHolder.CREATOR
                com.google.android.gms.common.data.DataHolder r5 = r0.createFromParcel(r9)
            L_0x0451:
                r7.mo6578s(r5)
                r10.writeNoException()
                goto L_0x0009
            L_0x0459:
                java.lang.String r0 = "com.google.android.gms.games.internal.IGamesCallbacks"
                r9.enforceInterface(r0)
                int r0 = r9.readInt()
                java.lang.String r1 = r9.readString()
                r7.mo6558h(r0, r1)
                r10.writeNoException()
                goto L_0x0009
            L_0x046e:
                java.lang.String r0 = "com.google.android.gms.games.internal.IGamesCallbacks"
                r9.enforceInterface(r0)
                int r0 = r9.readInt()
                if (r0 == 0) goto L_0x047f
                com.google.android.gms.common.data.f r0 = com.google.android.gms.common.data.DataHolder.CREATOR
                com.google.android.gms.common.data.DataHolder r5 = r0.createFromParcel(r9)
            L_0x047f:
                r7.mo6579t(r5)
                r10.writeNoException()
                goto L_0x0009
            L_0x0487:
                java.lang.String r0 = "com.google.android.gms.games.internal.IGamesCallbacks"
                r9.enforceInterface(r0)
                java.lang.String r0 = r9.readString()
                r7.onTurnBasedMatchRemoved(r0)
                r10.writeNoException()
                goto L_0x0009
            L_0x0498:
                java.lang.String r0 = "com.google.android.gms.games.internal.IGamesCallbacks"
                r9.enforceInterface(r0)
                java.lang.String r0 = r9.readString()
                r7.onInvitationRemoved(r0)
                r10.writeNoException()
                goto L_0x0009
            L_0x04a9:
                java.lang.String r0 = "com.google.android.gms.games.internal.IGamesCallbacks"
                r9.enforceInterface(r0)
                int r0 = r9.readInt()
                if (r0 == 0) goto L_0x04ba
                com.google.android.gms.common.data.f r0 = com.google.android.gms.common.data.DataHolder.CREATOR
                com.google.android.gms.common.data.DataHolder r5 = r0.createFromParcel(r9)
            L_0x04ba:
                r7.mo6564l(r5)
                r10.writeNoException()
                goto L_0x0009
            L_0x04c2:
                java.lang.String r0 = "com.google.android.gms.games.internal.IGamesCallbacks"
                r9.enforceInterface(r0)
                int r0 = r9.readInt()
                if (r0 == 0) goto L_0x04d3
                com.google.android.gms.common.data.f r0 = com.google.android.gms.common.data.DataHolder.CREATOR
                com.google.android.gms.common.data.DataHolder r5 = r0.createFromParcel(r9)
            L_0x04d3:
                r7.mo6567o(r5)
                r10.writeNoException()
                goto L_0x0009
            L_0x04db:
                java.lang.String r0 = "com.google.android.gms.games.internal.IGamesCallbacks"
                r9.enforceInterface(r0)
                java.lang.String r0 = r9.readString()
                r7.onRequestRemoved(r0)
                r10.writeNoException()
                goto L_0x0009
            L_0x04ec:
                java.lang.String r0 = "com.google.android.gms.games.internal.IGamesCallbacks"
                r9.enforceInterface(r0)
                int r0 = r9.readInt()
                if (r0 == 0) goto L_0x04fd
                com.google.android.gms.common.data.f r0 = com.google.android.gms.common.data.DataHolder.CREATOR
                com.google.android.gms.common.data.DataHolder r5 = r0.createFromParcel(r9)
            L_0x04fd:
                r7.mo6519F(r5)
                r10.writeNoException()
                goto L_0x0009
            L_0x0505:
                java.lang.String r0 = "com.google.android.gms.games.internal.IGamesCallbacks"
                r9.enforceInterface(r0)
                int r0 = r9.readInt()
                if (r0 == 0) goto L_0x0516
                com.google.android.gms.common.data.f r0 = com.google.android.gms.common.data.DataHolder.CREATOR
                com.google.android.gms.common.data.DataHolder r5 = r0.createFromParcel(r9)
            L_0x0516:
                r7.mo6520G(r5)
                r10.writeNoException()
                goto L_0x0009
            L_0x051e:
                java.lang.String r0 = "com.google.android.gms.games.internal.IGamesCallbacks"
                r9.enforceInterface(r0)
                int r1 = r9.readInt()
                int r0 = r9.readInt()
                if (r0 == 0) goto L_0x053d
                android.os.Parcelable$Creator r0 = android.os.Bundle.CREATOR
                java.lang.Object r0 = r0.createFromParcel(r9)
                android.os.Bundle r0 = (android.os.Bundle) r0
            L_0x0535:
                r7.mo6539c((int) r1, (android.os.Bundle) r0)
                r10.writeNoException()
                goto L_0x0009
            L_0x053d:
                r0 = r5
                goto L_0x0535
            L_0x053f:
                java.lang.String r0 = "com.google.android.gms.games.internal.IGamesCallbacks"
                r9.enforceInterface(r0)
                int r0 = r9.readInt()
                if (r0 == 0) goto L_0x0550
                com.google.android.gms.common.data.f r0 = com.google.android.gms.common.data.DataHolder.CREATOR
                com.google.android.gms.common.data.DataHolder r5 = r0.createFromParcel(r9)
            L_0x0550:
                r7.mo6521H(r5)
                r10.writeNoException()
                goto L_0x0009
            L_0x0558:
                java.lang.String r0 = "com.google.android.gms.games.internal.IGamesCallbacks"
                r9.enforceInterface(r0)
                int r1 = r9.readInt()
                int r0 = r9.readInt()
                if (r0 == 0) goto L_0x0577
                android.os.Parcelable$Creator r0 = android.os.Bundle.CREATOR
                java.lang.Object r0 = r0.createFromParcel(r9)
                android.os.Bundle r0 = (android.os.Bundle) r0
            L_0x056f:
                r7.mo6542d((int) r1, (android.os.Bundle) r0)
                r10.writeNoException()
                goto L_0x0009
            L_0x0577:
                r0 = r5
                goto L_0x056f
            L_0x0579:
                java.lang.String r0 = "com.google.android.gms.games.internal.IGamesCallbacks"
                r9.enforceInterface(r0)
                int r0 = r9.readInt()
                if (r0 == 0) goto L_0x058a
                com.google.android.gms.common.data.f r0 = com.google.android.gms.common.data.DataHolder.CREATOR
                com.google.android.gms.common.data.DataHolder r5 = r0.createFromParcel(r9)
            L_0x058a:
                r7.mo6522I(r5)
                r10.writeNoException()
                goto L_0x0009
            L_0x0592:
                java.lang.String r0 = "com.google.android.gms.games.internal.IGamesCallbacks"
                r9.enforceInterface(r0)
                int r0 = r9.readInt()
                if (r0 == 0) goto L_0x05ba
                com.google.android.gms.common.data.f r0 = com.google.android.gms.common.data.DataHolder.CREATOR
                com.google.android.gms.common.data.DataHolder r0 = r0.createFromParcel(r9)
                r1 = r0
            L_0x05a4:
                int r0 = r9.readInt()
                if (r0 == 0) goto L_0x05bc
                android.os.Parcelable$Creator<com.google.android.gms.drive.Contents> r0 = com.google.android.gms.drive.Contents.CREATOR
                java.lang.Object r0 = r0.createFromParcel(r9)
                com.google.android.gms.drive.Contents r0 = (com.google.android.gms.drive.Contents) r0
            L_0x05b2:
                r7.mo6533a((com.google.android.gms.common.data.DataHolder) r1, (com.google.android.gms.drive.Contents) r0)
                r10.writeNoException()
                goto L_0x0009
            L_0x05ba:
                r1 = r5
                goto L_0x05a4
            L_0x05bc:
                r0 = r5
                goto L_0x05b2
            L_0x05be:
                java.lang.String r0 = "com.google.android.gms.games.internal.IGamesCallbacks"
                r9.enforceInterface(r0)
                int r0 = r9.readInt()
                if (r0 == 0) goto L_0x0609
                com.google.android.gms.common.data.f r0 = com.google.android.gms.common.data.DataHolder.CREATOR
                com.google.android.gms.common.data.DataHolder r1 = r0.createFromParcel(r9)
            L_0x05cf:
                java.lang.String r2 = r9.readString()
                int r0 = r9.readInt()
                if (r0 == 0) goto L_0x060b
                android.os.Parcelable$Creator<com.google.android.gms.drive.Contents> r0 = com.google.android.gms.drive.Contents.CREATOR
                java.lang.Object r0 = r0.createFromParcel(r9)
                com.google.android.gms.drive.Contents r0 = (com.google.android.gms.drive.Contents) r0
                r3 = r0
            L_0x05e2:
                int r0 = r9.readInt()
                if (r0 == 0) goto L_0x060d
                android.os.Parcelable$Creator<com.google.android.gms.drive.Contents> r0 = com.google.android.gms.drive.Contents.CREATOR
                java.lang.Object r0 = r0.createFromParcel(r9)
                com.google.android.gms.drive.Contents r0 = (com.google.android.gms.drive.Contents) r0
                r4 = r0
            L_0x05f1:
                int r0 = r9.readInt()
                if (r0 == 0) goto L_0x0600
                android.os.Parcelable$Creator<com.google.android.gms.drive.Contents> r0 = com.google.android.gms.drive.Contents.CREATOR
                java.lang.Object r0 = r0.createFromParcel(r9)
                com.google.android.gms.drive.Contents r0 = (com.google.android.gms.drive.Contents) r0
                r5 = r0
            L_0x0600:
                r0 = r7
                r0.mo6534a(r1, r2, r3, r4, r5)
                r10.writeNoException()
                goto L_0x0009
            L_0x0609:
                r1 = r5
                goto L_0x05cf
            L_0x060b:
                r3 = r5
                goto L_0x05e2
            L_0x060d:
                r4 = r5
                goto L_0x05f1
            L_0x060f:
                java.lang.String r0 = "com.google.android.gms.games.internal.IGamesCallbacks"
                r9.enforceInterface(r0)
                int r0 = r9.readInt()
                if (r0 == 0) goto L_0x0620
                com.google.android.gms.common.data.f r0 = com.google.android.gms.common.data.DataHolder.CREATOR
                com.google.android.gms.common.data.DataHolder r5 = r0.createFromParcel(r9)
            L_0x0620:
                r7.mo6523J(r5)
                r10.writeNoException()
                goto L_0x0009
            L_0x0628:
                java.lang.String r0 = "com.google.android.gms.games.internal.IGamesCallbacks"
                r9.enforceInterface(r0)
                int r0 = r9.readInt()
                java.lang.String r1 = r9.readString()
                r7.mo6560i(r0, r1)
                r10.writeNoException()
                goto L_0x0009
            L_0x063d:
                java.lang.String r0 = "com.google.android.gms.games.internal.IGamesCallbacks"
                r9.enforceInterface(r0)
                int r1 = r9.readInt()
                int r0 = r9.readInt()
                if (r0 == 0) goto L_0x065c
                android.os.Parcelable$Creator r0 = android.os.Bundle.CREATOR
                java.lang.Object r0 = r0.createFromParcel(r9)
                android.os.Bundle r0 = (android.os.Bundle) r0
            L_0x0654:
                r7.mo6548e((int) r1, (android.os.Bundle) r0)
                r10.writeNoException()
                goto L_0x0009
            L_0x065c:
                r0 = r5
                goto L_0x0654
            L_0x065e:
                java.lang.String r0 = "com.google.android.gms.games.internal.IGamesCallbacks"
                r9.enforceInterface(r0)
                int r0 = r9.readInt()
                if (r0 == 0) goto L_0x066f
                com.google.android.gms.common.data.f r0 = com.google.android.gms.common.data.DataHolder.CREATOR
                com.google.android.gms.common.data.DataHolder r5 = r0.createFromParcel(r9)
            L_0x066f:
                r7.mo6529P(r5)
                r10.writeNoException()
                goto L_0x0009
            L_0x0677:
                java.lang.String r0 = "com.google.android.gms.games.internal.IGamesCallbacks"
                r9.enforceInterface(r0)
                int r0 = r9.readInt()
                if (r0 == 0) goto L_0x0688
                com.google.android.gms.common.data.f r0 = com.google.android.gms.common.data.DataHolder.CREATOR
                com.google.android.gms.common.data.DataHolder r5 = r0.createFromParcel(r9)
            L_0x0688:
                r7.mo6543d(r5)
                r10.writeNoException()
                goto L_0x0009
            L_0x0690:
                java.lang.String r0 = "com.google.android.gms.games.internal.IGamesCallbacks"
                r9.enforceInterface(r0)
                int r0 = r9.readInt()
                if (r0 == 0) goto L_0x06a1
                com.google.android.gms.common.data.f r0 = com.google.android.gms.common.data.DataHolder.CREATOR
                com.google.android.gms.common.data.DataHolder r5 = r0.createFromParcel(r9)
            L_0x06a1:
                r7.mo6524K(r5)
                r10.writeNoException()
                goto L_0x0009
            L_0x06a9:
                java.lang.String r0 = "com.google.android.gms.games.internal.IGamesCallbacks"
                r9.enforceInterface(r0)
                int r0 = r9.readInt()
                if (r0 == 0) goto L_0x06ba
                com.google.android.gms.common.data.f r0 = com.google.android.gms.common.data.DataHolder.CREATOR
                com.google.android.gms.common.data.DataHolder r5 = r0.createFromParcel(r9)
            L_0x06ba:
                r7.mo6525L(r5)
                r10.writeNoException()
                goto L_0x0009
            L_0x06c2:
                java.lang.String r0 = "com.google.android.gms.games.internal.IGamesCallbacks"
                r9.enforceInterface(r0)
                int r0 = r9.readInt()
                if (r0 == 0) goto L_0x06d3
                com.google.android.gms.common.data.f r0 = com.google.android.gms.common.data.DataHolder.CREATOR
                com.google.android.gms.common.data.DataHolder r5 = r0.createFromParcel(r9)
            L_0x06d3:
                r7.mo6526M(r5)
                r10.writeNoException()
                goto L_0x0009
            L_0x06db:
                java.lang.String r0 = "com.google.android.gms.games.internal.IGamesCallbacks"
                r9.enforceInterface(r0)
                int r0 = r9.readInt()
                if (r0 == 0) goto L_0x06ec
                com.google.android.gms.common.data.f r0 = com.google.android.gms.common.data.DataHolder.CREATOR
                com.google.android.gms.common.data.DataHolder r5 = r0.createFromParcel(r9)
            L_0x06ec:
                r7.mo6527N(r5)
                r10.writeNoException()
                goto L_0x0009
            L_0x06f4:
                java.lang.String r0 = "com.google.android.gms.games.internal.IGamesCallbacks"
                r9.enforceInterface(r0)
                int r0 = r9.readInt()
                if (r0 == 0) goto L_0x0705
                com.google.android.gms.common.data.f r0 = com.google.android.gms.common.data.DataHolder.CREATOR
                com.google.android.gms.common.data.DataHolder r5 = r0.createFromParcel(r9)
            L_0x0705:
                r7.mo6528O(r5)
                r10.writeNoException()
                goto L_0x0009
            L_0x070d:
                java.lang.String r0 = "com.google.android.gms.games.internal.IGamesCallbacks"
                r9.enforceInterface(r0)
                int r1 = r9.readInt()
                int r0 = r9.readInt()
                if (r0 == 0) goto L_0x072c
                android.os.Parcelable$Creator r0 = android.os.Bundle.CREATOR
                java.lang.Object r0 = r0.createFromParcel(r9)
                android.os.Bundle r0 = (android.os.Bundle) r0
            L_0x0724:
                r7.mo6551f((int) r1, (android.os.Bundle) r0)
                r10.writeNoException()
                goto L_0x0009
            L_0x072c:
                r0 = r5
                goto L_0x0724
            L_0x072e:
                java.lang.String r0 = "com.google.android.gms.games.internal.IGamesCallbacks"
                r9.enforceInterface(r0)
                int r0 = r9.readInt()
                if (r0 == 0) goto L_0x073f
                com.google.android.gms.common.data.f r0 = com.google.android.gms.common.data.DataHolder.CREATOR
                com.google.android.gms.common.data.DataHolder r5 = r0.createFromParcel(r9)
            L_0x073f:
                r7.mo6530Q(r5)
                r10.writeNoException()
                goto L_0x0009
            L_0x0747:
                java.lang.String r0 = "com.google.android.gms.games.internal.IGamesCallbacks"
                r9.enforceInterface(r0)
                int r0 = r9.readInt()
                r7.mo6547dz(r0)
                r10.writeNoException()
                goto L_0x0009
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.games.internal.IGamesCallbacks.Stub.onTransact(int, android.os.Parcel, android.os.Parcel, int):boolean");
        }
    }

    /* renamed from: A */
    void mo6514A(DataHolder dataHolder) throws RemoteException;

    /* renamed from: B */
    void mo6515B(DataHolder dataHolder) throws RemoteException;

    /* renamed from: C */
    void mo6516C(DataHolder dataHolder) throws RemoteException;

    /* renamed from: D */
    void mo6517D(DataHolder dataHolder) throws RemoteException;

    /* renamed from: E */
    void mo6518E(DataHolder dataHolder) throws RemoteException;

    /* renamed from: F */
    void mo6519F(DataHolder dataHolder) throws RemoteException;

    /* renamed from: G */
    void mo6520G(DataHolder dataHolder) throws RemoteException;

    /* renamed from: H */
    void mo6521H(DataHolder dataHolder) throws RemoteException;

    /* renamed from: I */
    void mo6522I(DataHolder dataHolder) throws RemoteException;

    /* renamed from: J */
    void mo6523J(DataHolder dataHolder) throws RemoteException;

    /* renamed from: K */
    void mo6524K(DataHolder dataHolder) throws RemoteException;

    /* renamed from: L */
    void mo6525L(DataHolder dataHolder) throws RemoteException;

    /* renamed from: M */
    void mo6526M(DataHolder dataHolder) throws RemoteException;

    /* renamed from: N */
    void mo6527N(DataHolder dataHolder) throws RemoteException;

    /* renamed from: O */
    void mo6528O(DataHolder dataHolder) throws RemoteException;

    /* renamed from: P */
    void mo6529P(DataHolder dataHolder) throws RemoteException;

    /* renamed from: Q */
    void mo6530Q(DataHolder dataHolder) throws RemoteException;

    /* renamed from: a */
    void mo6531a(int i, String str, boolean z) throws RemoteException;

    /* renamed from: a */
    void mo6532a(DataHolder dataHolder, DataHolder dataHolder2) throws RemoteException;

    /* renamed from: a */
    void mo6533a(DataHolder dataHolder, Contents contents) throws RemoteException;

    /* renamed from: a */
    void mo6534a(DataHolder dataHolder, String str, Contents contents, Contents contents2, Contents contents3) throws RemoteException;

    /* renamed from: a */
    void mo6535a(DataHolder dataHolder, String[] strArr) throws RemoteException;

    /* renamed from: b */
    void mo6536b(int i, int i2, String str) throws RemoteException;

    /* renamed from: b */
    void mo6537b(int i, Bundle bundle) throws RemoteException;

    /* renamed from: b */
    void mo6538b(DataHolder dataHolder, String[] strArr) throws RemoteException;

    /* renamed from: c */
    void mo6539c(int i, Bundle bundle) throws RemoteException;

    /* renamed from: c */
    void mo6540c(DataHolder dataHolder) throws RemoteException;

    /* renamed from: c */
    void mo6541c(DataHolder dataHolder, String[] strArr) throws RemoteException;

    /* renamed from: d */
    void mo6542d(int i, Bundle bundle) throws RemoteException;

    /* renamed from: d */
    void mo6543d(DataHolder dataHolder) throws RemoteException;

    /* renamed from: d */
    void mo6544d(DataHolder dataHolder, String[] strArr) throws RemoteException;

    /* renamed from: dx */
    void mo6545dx(int i) throws RemoteException;

    /* renamed from: dy */
    void mo6546dy(int i) throws RemoteException;

    /* renamed from: dz */
    void mo6547dz(int i) throws RemoteException;

    /* renamed from: e */
    void mo6548e(int i, Bundle bundle) throws RemoteException;

    /* renamed from: e */
    void mo6549e(DataHolder dataHolder) throws RemoteException;

    /* renamed from: e */
    void mo6550e(DataHolder dataHolder, String[] strArr) throws RemoteException;

    /* renamed from: f */
    void mo6551f(int i, Bundle bundle) throws RemoteException;

    /* renamed from: f */
    void mo6552f(int i, String str) throws RemoteException;

    /* renamed from: f */
    void mo6553f(DataHolder dataHolder) throws RemoteException;

    /* renamed from: f */
    void mo6554f(DataHolder dataHolder, String[] strArr) throws RemoteException;

    /* renamed from: fq */
    void mo6555fq() throws RemoteException;

    /* renamed from: g */
    void mo6556g(int i, String str) throws RemoteException;

    /* renamed from: g */
    void mo6557g(DataHolder dataHolder) throws RemoteException;

    /* renamed from: h */
    void mo6558h(int i, String str) throws RemoteException;

    /* renamed from: h */
    void mo6559h(DataHolder dataHolder) throws RemoteException;

    /* renamed from: i */
    void mo6560i(int i, String str) throws RemoteException;

    /* renamed from: i */
    void mo6561i(DataHolder dataHolder) throws RemoteException;

    /* renamed from: j */
    void mo6562j(DataHolder dataHolder) throws RemoteException;

    /* renamed from: k */
    void mo6563k(DataHolder dataHolder) throws RemoteException;

    /* renamed from: l */
    void mo6564l(DataHolder dataHolder) throws RemoteException;

    /* renamed from: m */
    void mo6565m(DataHolder dataHolder) throws RemoteException;

    /* renamed from: n */
    void mo6566n(DataHolder dataHolder) throws RemoteException;

    /* renamed from: o */
    void mo6567o(DataHolder dataHolder) throws RemoteException;

    void onInvitationRemoved(String str) throws RemoteException;

    void onLeftRoom(int i, String str) throws RemoteException;

    void onP2PConnected(String str) throws RemoteException;

    void onP2PDisconnected(String str) throws RemoteException;

    void onRealTimeMessageReceived(RealTimeMessage realTimeMessage) throws RemoteException;

    void onRequestRemoved(String str) throws RemoteException;

    void onTurnBasedMatchRemoved(String str) throws RemoteException;

    /* renamed from: p */
    void mo6575p(DataHolder dataHolder) throws RemoteException;

    /* renamed from: q */
    void mo6576q(DataHolder dataHolder) throws RemoteException;

    /* renamed from: r */
    void mo6577r(DataHolder dataHolder) throws RemoteException;

    /* renamed from: s */
    void mo6578s(DataHolder dataHolder) throws RemoteException;

    /* renamed from: t */
    void mo6579t(DataHolder dataHolder) throws RemoteException;

    /* renamed from: u */
    void mo6580u(DataHolder dataHolder) throws RemoteException;

    /* renamed from: v */
    void mo6581v(DataHolder dataHolder) throws RemoteException;

    /* renamed from: w */
    void mo6582w(DataHolder dataHolder) throws RemoteException;

    /* renamed from: x */
    void mo6583x(DataHolder dataHolder) throws RemoteException;

    /* renamed from: y */
    void mo6584y(DataHolder dataHolder) throws RemoteException;

    /* renamed from: z */
    void mo6585z(DataHolder dataHolder) throws RemoteException;
}
