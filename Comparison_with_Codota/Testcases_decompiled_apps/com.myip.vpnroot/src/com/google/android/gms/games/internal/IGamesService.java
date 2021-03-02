package com.google.android.gms.games.internal;

import android.content.Intent;
import android.net.Uri;
import android.os.Binder;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.ParcelFileDescriptor;
import android.os.RemoteException;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.drive.Contents;
import com.google.android.gms.fitness.FitnessStatusCodes;
import com.google.android.gms.games.GamesActivityResultCodes;
import com.google.android.gms.games.GamesStatusCodes;
import com.google.android.gms.games.achievement.AchievementEntity;
import com.google.android.gms.games.internal.multiplayer.ZInvitationCluster;
import com.google.android.gms.games.internal.request.GameRequestCluster;
import com.google.android.gms.games.multiplayer.ParticipantEntity;
import com.google.android.gms.games.multiplayer.ParticipantResult;
import com.google.android.gms.games.multiplayer.realtime.RoomEntity;
import com.google.android.gms.games.snapshot.SnapshotMetadataChange;

public interface IGamesService extends IInterface {

    public static abstract class Stub extends Binder implements IGamesService {

        private static class Proxy implements IGamesService {

            /* renamed from: lb */
            private IBinder f1936lb;

            Proxy(IBinder remote) {
                this.f1936lb = remote;
            }

            /* renamed from: N */
            public void mo6787N(boolean z) throws RemoteException {
                int i = 0;
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
                    if (z) {
                        i = 1;
                    }
                    obtain.writeInt(i);
                    this.f1936lb.transact(5068, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            /* renamed from: O */
            public void mo6788O(boolean z) throws RemoteException {
                int i = 0;
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
                    if (z) {
                        i = 1;
                    }
                    obtain.writeInt(i);
                    this.f1936lb.transact(12026, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            /* renamed from: P */
            public void mo6789P(boolean z) throws RemoteException {
                int i = 0;
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
                    if (z) {
                        i = 1;
                    }
                    obtain.writeInt(i);
                    this.f1936lb.transact(13001, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            /* renamed from: a */
            public int mo6790a(IGamesCallbacks iGamesCallbacks, byte[] bArr, String str, String str2) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
                    obtain.writeStrongBinder(iGamesCallbacks != null ? iGamesCallbacks.asBinder() : null);
                    obtain.writeByteArray(bArr);
                    obtain.writeString(str);
                    obtain.writeString(str2);
                    this.f1936lb.transact(5033, obtain, obtain2, 0);
                    obtain2.readException();
                    return obtain2.readInt();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            /* renamed from: a */
            public Intent mo6791a(int i, int i2, boolean z) throws RemoteException {
                int i3 = 0;
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
                    obtain.writeInt(i);
                    obtain.writeInt(i2);
                    if (z) {
                        i3 = 1;
                    }
                    obtain.writeInt(i3);
                    this.f1936lb.transact(9008, obtain, obtain2, 0);
                    obtain2.readException();
                    return obtain2.readInt() != 0 ? (Intent) Intent.CREATOR.createFromParcel(obtain2) : null;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            /* renamed from: a */
            public Intent mo6792a(int i, byte[] bArr, int i2, String str) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
                    obtain.writeInt(i);
                    obtain.writeByteArray(bArr);
                    obtain.writeInt(i2);
                    obtain.writeString(str);
                    this.f1936lb.transact(10012, obtain, obtain2, 0);
                    obtain2.readException();
                    return obtain2.readInt() != 0 ? (Intent) Intent.CREATOR.createFromParcel(obtain2) : null;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            /* renamed from: a */
            public Intent mo6793a(AchievementEntity achievementEntity) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
                    if (achievementEntity != null) {
                        obtain.writeInt(1);
                        achievementEntity.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.f1936lb.transact(13005, obtain, obtain2, 0);
                    obtain2.readException();
                    return obtain2.readInt() != 0 ? (Intent) Intent.CREATOR.createFromParcel(obtain2) : null;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            /* renamed from: a */
            public Intent mo6794a(ZInvitationCluster zInvitationCluster, String str, String str2) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
                    if (zInvitationCluster != null) {
                        obtain.writeInt(1);
                        zInvitationCluster.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    obtain.writeString(str);
                    obtain.writeString(str2);
                    this.f1936lb.transact(10021, obtain, obtain2, 0);
                    obtain2.readException();
                    return obtain2.readInt() != 0 ? (Intent) Intent.CREATOR.createFromParcel(obtain2) : null;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            /* renamed from: a */
            public Intent mo6795a(GameRequestCluster gameRequestCluster, String str) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
                    if (gameRequestCluster != null) {
                        obtain.writeInt(1);
                        gameRequestCluster.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    obtain.writeString(str);
                    this.f1936lb.transact(10022, obtain, obtain2, 0);
                    obtain2.readException();
                    return obtain2.readInt() != 0 ? (Intent) Intent.CREATOR.createFromParcel(obtain2) : null;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            /* renamed from: a */
            public Intent mo6796a(RoomEntity roomEntity, int i) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
                    if (roomEntity != null) {
                        obtain.writeInt(1);
                        roomEntity.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    obtain.writeInt(i);
                    this.f1936lb.transact(9011, obtain, obtain2, 0);
                    obtain2.readException();
                    return obtain2.readInt() != 0 ? (Intent) Intent.CREATOR.createFromParcel(obtain2) : null;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            /* renamed from: a */
            public Intent mo6797a(String str, boolean z, boolean z2, int i) throws RemoteException {
                int i2 = 1;
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
                    obtain.writeString(str);
                    obtain.writeInt(z ? 1 : 0);
                    if (!z2) {
                        i2 = 0;
                    }
                    obtain.writeInt(i2);
                    obtain.writeInt(i);
                    this.f1936lb.transact(12001, obtain, obtain2, 0);
                    obtain2.readException();
                    return obtain2.readInt() != 0 ? (Intent) Intent.CREATOR.createFromParcel(obtain2) : null;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            /* renamed from: a */
            public Intent mo6798a(ParticipantEntity[] participantEntityArr, String str, String str2, Uri uri, Uri uri2) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
                    obtain.writeTypedArray(participantEntityArr, 0);
                    obtain.writeString(str);
                    obtain.writeString(str2);
                    if (uri != null) {
                        obtain.writeInt(1);
                        uri.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    if (uri2 != null) {
                        obtain.writeInt(1);
                        uri2.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.f1936lb.transact(9031, obtain, obtain2, 0);
                    obtain2.readException();
                    return obtain2.readInt() != 0 ? (Intent) Intent.CREATOR.createFromParcel(obtain2) : null;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            /* renamed from: a */
            public void mo6799a(long j, String str) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
                    obtain.writeLong(j);
                    obtain.writeString(str);
                    this.f1936lb.transact(8019, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            /* renamed from: a */
            public void mo6800a(IBinder iBinder, Bundle bundle) throws RemoteException {
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
                    this.f1936lb.transact(FitnessStatusCodes.UNKNOWN_AUTH_ERROR, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            /* renamed from: a */
            public void mo6801a(Contents contents) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
                    if (contents != null) {
                        obtain.writeInt(1);
                        contents.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.f1936lb.transact(12019, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            /* renamed from: a */
            public void mo6802a(IGamesCallbacks iGamesCallbacks) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
                    obtain.writeStrongBinder(iGamesCallbacks != null ? iGamesCallbacks.asBinder() : null);
                    this.f1936lb.transact(FitnessStatusCodes.INCONSISTENT_DATA_TYPE, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            /* renamed from: a */
            public void mo6803a(IGamesCallbacks iGamesCallbacks, int i) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
                    obtain.writeStrongBinder(iGamesCallbacks != null ? iGamesCallbacks.asBinder() : null);
                    obtain.writeInt(i);
                    this.f1936lb.transact(10016, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            /* renamed from: a */
            public void mo6804a(IGamesCallbacks iGamesCallbacks, int i, int i2, int i3) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
                    obtain.writeStrongBinder(iGamesCallbacks != null ? iGamesCallbacks.asBinder() : null);
                    obtain.writeInt(i);
                    obtain.writeInt(i2);
                    obtain.writeInt(i3);
                    this.f1936lb.transact(10009, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            /* renamed from: a */
            public void mo6805a(IGamesCallbacks iGamesCallbacks, int i, int i2, boolean z, boolean z2) throws RemoteException {
                int i3 = 1;
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
                    obtain.writeStrongBinder(iGamesCallbacks != null ? iGamesCallbacks.asBinder() : null);
                    obtain.writeInt(i);
                    obtain.writeInt(i2);
                    obtain.writeInt(z ? 1 : 0);
                    if (!z2) {
                        i3 = 0;
                    }
                    obtain.writeInt(i3);
                    this.f1936lb.transact(5044, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            /* renamed from: a */
            public void mo6806a(IGamesCallbacks iGamesCallbacks, int i, int i2, String[] strArr, Bundle bundle) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
                    obtain.writeStrongBinder(iGamesCallbacks != null ? iGamesCallbacks.asBinder() : null);
                    obtain.writeInt(i);
                    obtain.writeInt(i2);
                    obtain.writeStringArray(strArr);
                    if (bundle != null) {
                        obtain.writeInt(1);
                        bundle.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.f1936lb.transact(8004, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            /* renamed from: a */
            public void mo6807a(IGamesCallbacks iGamesCallbacks, int i, boolean z, boolean z2) throws RemoteException {
                int i2 = 1;
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
                    obtain.writeStrongBinder(iGamesCallbacks != null ? iGamesCallbacks.asBinder() : null);
                    obtain.writeInt(i);
                    obtain.writeInt(z ? 1 : 0);
                    if (!z2) {
                        i2 = 0;
                    }
                    obtain.writeInt(i2);
                    this.f1936lb.transact(5015, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            /* renamed from: a */
            public void mo6808a(IGamesCallbacks iGamesCallbacks, int i, int[] iArr) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
                    obtain.writeStrongBinder(iGamesCallbacks != null ? iGamesCallbacks.asBinder() : null);
                    obtain.writeInt(i);
                    obtain.writeIntArray(iArr);
                    this.f1936lb.transact(10018, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            /* renamed from: a */
            public void mo6809a(IGamesCallbacks iGamesCallbacks, long j) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
                    obtain.writeStrongBinder(iGamesCallbacks != null ? iGamesCallbacks.asBinder() : null);
                    obtain.writeLong(j);
                    this.f1936lb.transact(5058, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            /* renamed from: a */
            public void mo6810a(IGamesCallbacks iGamesCallbacks, long j, String str) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
                    obtain.writeStrongBinder(iGamesCallbacks != null ? iGamesCallbacks.asBinder() : null);
                    obtain.writeLong(j);
                    obtain.writeString(str);
                    this.f1936lb.transact(8018, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            /* renamed from: a */
            public void mo6811a(IGamesCallbacks iGamesCallbacks, Bundle bundle, int i, int i2) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
                    obtain.writeStrongBinder(iGamesCallbacks != null ? iGamesCallbacks.asBinder() : null);
                    if (bundle != null) {
                        obtain.writeInt(1);
                        bundle.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    obtain.writeInt(i);
                    obtain.writeInt(i2);
                    this.f1936lb.transact(5021, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            /* renamed from: a */
            public void mo6812a(IGamesCallbacks iGamesCallbacks, IBinder iBinder, int i, String[] strArr, Bundle bundle, boolean z, long j) throws RemoteException {
                int i2 = 1;
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
                    obtain.writeStrongBinder(iGamesCallbacks != null ? iGamesCallbacks.asBinder() : null);
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
                    this.f1936lb.transact(5030, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            /* renamed from: a */
            public void mo6813a(IGamesCallbacks iGamesCallbacks, IBinder iBinder, String str, boolean z, long j) throws RemoteException {
                int i = 0;
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
                    obtain.writeStrongBinder(iGamesCallbacks != null ? iGamesCallbacks.asBinder() : null);
                    obtain.writeStrongBinder(iBinder);
                    obtain.writeString(str);
                    if (z) {
                        i = 1;
                    }
                    obtain.writeInt(i);
                    obtain.writeLong(j);
                    this.f1936lb.transact(5031, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            /* renamed from: a */
            public void mo6814a(IGamesCallbacks iGamesCallbacks, String str) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
                    obtain.writeStrongBinder(iGamesCallbacks != null ? iGamesCallbacks.asBinder() : null);
                    obtain.writeString(str);
                    this.f1936lb.transact(FitnessStatusCodes.DISABLED_BLUETOOTH, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            /* renamed from: a */
            public void mo6815a(IGamesCallbacks iGamesCallbacks, String str, int i) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
                    obtain.writeStrongBinder(iGamesCallbacks != null ? iGamesCallbacks.asBinder() : null);
                    obtain.writeString(str);
                    obtain.writeInt(i);
                    this.f1936lb.transact(10011, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            /* renamed from: a */
            public void mo6816a(IGamesCallbacks iGamesCallbacks, String str, int i, int i2, int i3, boolean z) throws RemoteException {
                int i4 = 0;
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
                    obtain.writeStrongBinder(iGamesCallbacks != null ? iGamesCallbacks.asBinder() : null);
                    obtain.writeString(str);
                    obtain.writeInt(i);
                    obtain.writeInt(i2);
                    obtain.writeInt(i3);
                    if (z) {
                        i4 = 1;
                    }
                    obtain.writeInt(i4);
                    this.f1936lb.transact(5019, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            /* renamed from: a */
            public void mo6817a(IGamesCallbacks iGamesCallbacks, String str, int i, IBinder iBinder, Bundle bundle) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
                    obtain.writeStrongBinder(iGamesCallbacks != null ? iGamesCallbacks.asBinder() : null);
                    obtain.writeString(str);
                    obtain.writeInt(i);
                    obtain.writeStrongBinder(iBinder);
                    if (bundle != null) {
                        obtain.writeInt(1);
                        bundle.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.f1936lb.transact(5025, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            /* renamed from: a */
            public void mo6818a(IGamesCallbacks iGamesCallbacks, String str, int i, boolean z) throws RemoteException {
                int i2 = 0;
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
                    obtain.writeStrongBinder(iGamesCallbacks != null ? iGamesCallbacks.asBinder() : null);
                    obtain.writeString(str);
                    obtain.writeInt(i);
                    if (z) {
                        i2 = 1;
                    }
                    obtain.writeInt(i2);
                    this.f1936lb.transact(8023, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            /* renamed from: a */
            public void mo6819a(IGamesCallbacks iGamesCallbacks, String str, int i, boolean z, boolean z2) throws RemoteException {
                int i2 = 1;
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
                    obtain.writeStrongBinder(iGamesCallbacks != null ? iGamesCallbacks.asBinder() : null);
                    obtain.writeString(str);
                    obtain.writeInt(i);
                    obtain.writeInt(z ? 1 : 0);
                    if (!z2) {
                        i2 = 0;
                    }
                    obtain.writeInt(i2);
                    this.f1936lb.transact(5045, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            /* renamed from: a */
            public void mo6820a(IGamesCallbacks iGamesCallbacks, String str, int i, boolean z, boolean z2, boolean z3, boolean z4) throws RemoteException {
                int i2 = 1;
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
                    obtain.writeStrongBinder(iGamesCallbacks != null ? iGamesCallbacks.asBinder() : null);
                    obtain.writeString(str);
                    obtain.writeInt(i);
                    obtain.writeInt(z ? 1 : 0);
                    obtain.writeInt(z2 ? 1 : 0);
                    obtain.writeInt(z3 ? 1 : 0);
                    if (!z4) {
                        i2 = 0;
                    }
                    obtain.writeInt(i2);
                    this.f1936lb.transact(GamesStatusCodes.STATUS_MATCH_ERROR_INACTIVE_MATCH, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            /* renamed from: a */
            public void mo6821a(IGamesCallbacks iGamesCallbacks, String str, int i, int[] iArr) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
                    obtain.writeStrongBinder(iGamesCallbacks != null ? iGamesCallbacks.asBinder() : null);
                    obtain.writeString(str);
                    obtain.writeInt(i);
                    obtain.writeIntArray(iArr);
                    this.f1936lb.transact(10019, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            /* renamed from: a */
            public void mo6822a(IGamesCallbacks iGamesCallbacks, String str, long j) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
                    obtain.writeStrongBinder(iGamesCallbacks != null ? iGamesCallbacks.asBinder() : null);
                    obtain.writeString(str);
                    obtain.writeLong(j);
                    this.f1936lb.transact(5016, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            /* renamed from: a */
            public void mo6823a(IGamesCallbacks iGamesCallbacks, String str, long j, String str2) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
                    obtain.writeStrongBinder(iGamesCallbacks != null ? iGamesCallbacks.asBinder() : null);
                    obtain.writeString(str);
                    obtain.writeLong(j);
                    obtain.writeString(str2);
                    this.f1936lb.transact(GamesStatusCodes.STATUS_INVALID_REAL_TIME_ROOM_ID, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            /* renamed from: a */
            public void mo6824a(IGamesCallbacks iGamesCallbacks, String str, IBinder iBinder, Bundle bundle) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
                    obtain.writeStrongBinder(iGamesCallbacks != null ? iGamesCallbacks.asBinder() : null);
                    obtain.writeString(str);
                    obtain.writeStrongBinder(iBinder);
                    if (bundle != null) {
                        obtain.writeInt(1);
                        bundle.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.f1936lb.transact(5023, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            /* renamed from: a */
            public void mo6825a(IGamesCallbacks iGamesCallbacks, String str, SnapshotMetadataChange snapshotMetadataChange, Contents contents) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
                    obtain.writeStrongBinder(iGamesCallbacks != null ? iGamesCallbacks.asBinder() : null);
                    obtain.writeString(str);
                    if (snapshotMetadataChange != null) {
                        obtain.writeInt(1);
                        snapshotMetadataChange.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    if (contents != null) {
                        obtain.writeInt(1);
                        contents.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.f1936lb.transact(12007, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            /* renamed from: a */
            public void mo6826a(IGamesCallbacks iGamesCallbacks, String str, String str2) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
                    obtain.writeStrongBinder(iGamesCallbacks != null ? iGamesCallbacks.asBinder() : null);
                    obtain.writeString(str);
                    obtain.writeString(str2);
                    this.f1936lb.transact(5038, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            /* renamed from: a */
            public void mo6827a(IGamesCallbacks iGamesCallbacks, String str, String str2, int i, int i2) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
                    obtain.writeStrongBinder(iGamesCallbacks != null ? iGamesCallbacks.asBinder() : null);
                    obtain.writeString(str);
                    obtain.writeString(str2);
                    obtain.writeInt(i);
                    obtain.writeInt(i2);
                    this.f1936lb.transact(GamesStatusCodes.STATUS_MILESTONE_CLAIM_FAILED, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            /* renamed from: a */
            public void mo6828a(IGamesCallbacks iGamesCallbacks, String str, String str2, int i, int i2, int i3) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
                    obtain.writeStrongBinder(iGamesCallbacks != null ? iGamesCallbacks.asBinder() : null);
                    obtain.writeString(str);
                    obtain.writeString(str2);
                    obtain.writeInt(i);
                    obtain.writeInt(i2);
                    obtain.writeInt(i3);
                    this.f1936lb.transact(10010, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            /* renamed from: a */
            public void mo6829a(IGamesCallbacks iGamesCallbacks, String str, String str2, int i, int i2, int i3, boolean z) throws RemoteException {
                int i4 = 0;
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
                    obtain.writeStrongBinder(iGamesCallbacks != null ? iGamesCallbacks.asBinder() : null);
                    obtain.writeString(str);
                    obtain.writeString(str2);
                    obtain.writeInt(i);
                    obtain.writeInt(i2);
                    obtain.writeInt(i3);
                    if (z) {
                        i4 = 1;
                    }
                    obtain.writeInt(i4);
                    this.f1936lb.transact(5039, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            /* renamed from: a */
            public void mo6830a(IGamesCallbacks iGamesCallbacks, String str, String str2, int i, boolean z, boolean z2) throws RemoteException {
                int i2 = 1;
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
                    obtain.writeStrongBinder(iGamesCallbacks != null ? iGamesCallbacks.asBinder() : null);
                    obtain.writeString(str);
                    obtain.writeString(str2);
                    obtain.writeInt(i);
                    obtain.writeInt(z ? 1 : 0);
                    if (!z2) {
                        i2 = 0;
                    }
                    obtain.writeInt(i2);
                    this.f1936lb.transact(9028, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            /* renamed from: a */
            public void mo6831a(IGamesCallbacks iGamesCallbacks, String str, String str2, SnapshotMetadataChange snapshotMetadataChange, Contents contents) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
                    obtain.writeStrongBinder(iGamesCallbacks != null ? iGamesCallbacks.asBinder() : null);
                    obtain.writeString(str);
                    obtain.writeString(str2);
                    if (snapshotMetadataChange != null) {
                        obtain.writeInt(1);
                        snapshotMetadataChange.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    if (contents != null) {
                        obtain.writeInt(1);
                        contents.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.f1936lb.transact(12033, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            /* renamed from: a */
            public void mo6832a(IGamesCallbacks iGamesCallbacks, String str, String str2, boolean z) throws RemoteException {
                int i = 0;
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
                    obtain.writeStrongBinder(iGamesCallbacks != null ? iGamesCallbacks.asBinder() : null);
                    obtain.writeString(str);
                    obtain.writeString(str2);
                    if (z) {
                        i = 1;
                    }
                    obtain.writeInt(i);
                    this.f1936lb.transact(GamesStatusCodes.STATUS_MULTIPLAYER_ERROR_INVALID_MULTIPLAYER_TYPE, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            /* renamed from: a */
            public void mo6833a(IGamesCallbacks iGamesCallbacks, String str, String str2, int[] iArr, int i, boolean z) throws RemoteException {
                int i2 = 0;
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
                    obtain.writeStrongBinder(iGamesCallbacks != null ? iGamesCallbacks.asBinder() : null);
                    obtain.writeString(str);
                    obtain.writeString(str2);
                    obtain.writeIntArray(iArr);
                    obtain.writeInt(i);
                    if (z) {
                        i2 = 1;
                    }
                    obtain.writeInt(i2);
                    this.f1936lb.transact(12015, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            /* renamed from: a */
            public void mo6834a(IGamesCallbacks iGamesCallbacks, String str, String str2, String[] strArr) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
                    obtain.writeStrongBinder(iGamesCallbacks != null ? iGamesCallbacks.asBinder() : null);
                    obtain.writeString(str);
                    obtain.writeString(str2);
                    obtain.writeStringArray(strArr);
                    this.f1936lb.transact(GamesActivityResultCodes.RESULT_INVALID_ROOM, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            /* renamed from: a */
            public void mo6835a(IGamesCallbacks iGamesCallbacks, String str, String str2, String[] strArr, boolean z) throws RemoteException {
                int i = 0;
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
                    obtain.writeStrongBinder(iGamesCallbacks != null ? iGamesCallbacks.asBinder() : null);
                    obtain.writeString(str);
                    obtain.writeString(str2);
                    obtain.writeStringArray(strArr);
                    if (z) {
                        i = 1;
                    }
                    obtain.writeInt(i);
                    this.f1936lb.transact(12028, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            /* renamed from: a */
            public void mo6836a(IGamesCallbacks iGamesCallbacks, String str, boolean z) throws RemoteException {
                int i = 0;
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
                    obtain.writeStrongBinder(iGamesCallbacks != null ? iGamesCallbacks.asBinder() : null);
                    obtain.writeString(str);
                    if (z) {
                        i = 1;
                    }
                    obtain.writeInt(i);
                    this.f1936lb.transact(5054, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            /* renamed from: a */
            public void mo6837a(IGamesCallbacks iGamesCallbacks, String str, byte[] bArr, String str2, ParticipantResult[] participantResultArr) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
                    obtain.writeStrongBinder(iGamesCallbacks != null ? iGamesCallbacks.asBinder() : null);
                    obtain.writeString(str);
                    obtain.writeByteArray(bArr);
                    obtain.writeString(str2);
                    obtain.writeTypedArray(participantResultArr, 0);
                    this.f1936lb.transact(8007, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            /* renamed from: a */
            public void mo6838a(IGamesCallbacks iGamesCallbacks, String str, byte[] bArr, ParticipantResult[] participantResultArr) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
                    obtain.writeStrongBinder(iGamesCallbacks != null ? iGamesCallbacks.asBinder() : null);
                    obtain.writeString(str);
                    obtain.writeByteArray(bArr);
                    obtain.writeTypedArray(participantResultArr, 0);
                    this.f1936lb.transact(8008, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            /* renamed from: a */
            public void mo6839a(IGamesCallbacks iGamesCallbacks, String str, int[] iArr) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
                    obtain.writeStrongBinder(iGamesCallbacks != null ? iGamesCallbacks.asBinder() : null);
                    obtain.writeString(str);
                    obtain.writeIntArray(iArr);
                    this.f1936lb.transact(8017, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            /* renamed from: a */
            public void mo6840a(IGamesCallbacks iGamesCallbacks, String str, String[] strArr, int i, byte[] bArr, int i2) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
                    obtain.writeStrongBinder(iGamesCallbacks != null ? iGamesCallbacks.asBinder() : null);
                    obtain.writeString(str);
                    obtain.writeStringArray(strArr);
                    obtain.writeInt(i);
                    obtain.writeByteArray(bArr);
                    obtain.writeInt(i2);
                    this.f1936lb.transact(GamesActivityResultCodes.RESULT_LEFT_ROOM, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            /* renamed from: a */
            public void mo6841a(IGamesCallbacks iGamesCallbacks, boolean z) throws RemoteException {
                int i = 0;
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
                    obtain.writeStrongBinder(iGamesCallbacks != null ? iGamesCallbacks.asBinder() : null);
                    if (z) {
                        i = 1;
                    }
                    obtain.writeInt(i);
                    this.f1936lb.transact(GamesStatusCodes.STATUS_MULTIPLAYER_ERROR_NOT_TRUSTED_TESTER, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            /* renamed from: a */
            public void mo6842a(IGamesCallbacks iGamesCallbacks, boolean z, Bundle bundle) throws RemoteException {
                int i = 1;
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
                    obtain.writeStrongBinder(iGamesCallbacks != null ? iGamesCallbacks.asBinder() : null);
                    if (!z) {
                        i = 0;
                    }
                    obtain.writeInt(i);
                    if (bundle != null) {
                        obtain.writeInt(1);
                        bundle.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.f1936lb.transact(5063, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            /* renamed from: a */
            public void mo6843a(IGamesCallbacks iGamesCallbacks, boolean z, String[] strArr) throws RemoteException {
                int i = 0;
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
                    obtain.writeStrongBinder(iGamesCallbacks != null ? iGamesCallbacks.asBinder() : null);
                    if (z) {
                        i = 1;
                    }
                    obtain.writeInt(i);
                    obtain.writeStringArray(strArr);
                    this.f1936lb.transact(12031, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            /* renamed from: a */
            public void mo6844a(IGamesCallbacks iGamesCallbacks, int[] iArr) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
                    obtain.writeStrongBinder(iGamesCallbacks != null ? iGamesCallbacks.asBinder() : null);
                    obtain.writeIntArray(iArr);
                    this.f1936lb.transact(GamesStatusCodes.STATUS_QUEST_NOT_STARTED, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            /* renamed from: a */
            public void mo6845a(IGamesCallbacks iGamesCallbacks, int[] iArr, int i, boolean z) throws RemoteException {
                int i2 = 0;
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
                    obtain.writeStrongBinder(iGamesCallbacks != null ? iGamesCallbacks.asBinder() : null);
                    obtain.writeIntArray(iArr);
                    obtain.writeInt(i);
                    if (z) {
                        i2 = 1;
                    }
                    obtain.writeInt(i2);
                    this.f1936lb.transact(12010, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            /* renamed from: a */
            public void mo6846a(IGamesCallbacks iGamesCallbacks, String[] strArr) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
                    obtain.writeStrongBinder(iGamesCallbacks != null ? iGamesCallbacks.asBinder() : null);
                    obtain.writeStringArray(strArr);
                    this.f1936lb.transact(GamesActivityResultCodes.RESULT_NETWORK_FAILURE, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            /* renamed from: a */
            public void mo6847a(IGamesCallbacks iGamesCallbacks, String[] strArr, boolean z) throws RemoteException {
                int i = 0;
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
                    obtain.writeStrongBinder(iGamesCallbacks != null ? iGamesCallbacks.asBinder() : null);
                    obtain.writeStringArray(strArr);
                    if (z) {
                        i = 1;
                    }
                    obtain.writeInt(i);
                    this.f1936lb.transact(12029, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            /* renamed from: a */
            public void mo6848a(String str, IBinder iBinder, Bundle bundle) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
                    obtain.writeString(str);
                    obtain.writeStrongBinder(iBinder);
                    if (bundle != null) {
                        obtain.writeInt(1);
                        bundle.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.f1936lb.transact(13002, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public IBinder asBinder() {
                return this.f1936lb;
            }

            /* renamed from: b */
            public int mo6849b(byte[] bArr, String str, String[] strArr) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
                    obtain.writeByteArray(bArr);
                    obtain.writeString(str);
                    obtain.writeStringArray(strArr);
                    this.f1936lb.transact(5034, obtain, obtain2, 0);
                    obtain2.readException();
                    return obtain2.readInt();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            /* renamed from: b */
            public Intent mo6850b(int i, int i2, boolean z) throws RemoteException {
                int i3 = 0;
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
                    obtain.writeInt(i);
                    obtain.writeInt(i2);
                    if (z) {
                        i3 = 1;
                    }
                    obtain.writeInt(i3);
                    this.f1936lb.transact(9009, obtain, obtain2, 0);
                    obtain2.readException();
                    return obtain2.readInt() != 0 ? (Intent) Intent.CREATOR.createFromParcel(obtain2) : null;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            /* renamed from: b */
            public Intent mo6851b(int[] iArr) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
                    obtain.writeIntArray(iArr);
                    this.f1936lb.transact(12030, obtain, obtain2, 0);
                    obtain2.readException();
                    return obtain2.readInt() != 0 ? (Intent) Intent.CREATOR.createFromParcel(obtain2) : null;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            /* renamed from: b */
            public void mo6852b(long j, String str) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
                    obtain.writeLong(j);
                    obtain.writeString(str);
                    this.f1936lb.transact(8021, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            /* renamed from: b */
            public void mo6853b(IGamesCallbacks iGamesCallbacks) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
                    obtain.writeStrongBinder(iGamesCallbacks != null ? iGamesCallbacks.asBinder() : null);
                    this.f1936lb.transact(5017, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            /* renamed from: b */
            public void mo6854b(IGamesCallbacks iGamesCallbacks, int i, boolean z, boolean z2) throws RemoteException {
                int i2 = 1;
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
                    obtain.writeStrongBinder(iGamesCallbacks != null ? iGamesCallbacks.asBinder() : null);
                    obtain.writeInt(i);
                    obtain.writeInt(z ? 1 : 0);
                    if (!z2) {
                        i2 = 0;
                    }
                    obtain.writeInt(i2);
                    this.f1936lb.transact(5046, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            /* renamed from: b */
            public void mo6855b(IGamesCallbacks iGamesCallbacks, long j) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
                    obtain.writeStrongBinder(iGamesCallbacks != null ? iGamesCallbacks.asBinder() : null);
                    obtain.writeLong(j);
                    this.f1936lb.transact(8012, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            /* renamed from: b */
            public void mo6856b(IGamesCallbacks iGamesCallbacks, long j, String str) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
                    obtain.writeStrongBinder(iGamesCallbacks != null ? iGamesCallbacks.asBinder() : null);
                    obtain.writeLong(j);
                    obtain.writeString(str);
                    this.f1936lb.transact(8020, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            /* renamed from: b */
            public void mo6857b(IGamesCallbacks iGamesCallbacks, String str) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
                    obtain.writeStrongBinder(iGamesCallbacks != null ? iGamesCallbacks.asBinder() : null);
                    obtain.writeString(str);
                    this.f1936lb.transact(5018, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            /* renamed from: b */
            public void mo6858b(IGamesCallbacks iGamesCallbacks, String str, int i) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
                    obtain.writeStrongBinder(iGamesCallbacks != null ? iGamesCallbacks.asBinder() : null);
                    obtain.writeString(str);
                    obtain.writeInt(i);
                    this.f1936lb.transact(12023, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            /* renamed from: b */
            public void mo6859b(IGamesCallbacks iGamesCallbacks, String str, int i, int i2, int i3, boolean z) throws RemoteException {
                int i4 = 0;
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
                    obtain.writeStrongBinder(iGamesCallbacks != null ? iGamesCallbacks.asBinder() : null);
                    obtain.writeString(str);
                    obtain.writeInt(i);
                    obtain.writeInt(i2);
                    obtain.writeInt(i3);
                    if (z) {
                        i4 = 1;
                    }
                    obtain.writeInt(i4);
                    this.f1936lb.transact(5020, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            /* renamed from: b */
            public void mo6860b(IGamesCallbacks iGamesCallbacks, String str, int i, IBinder iBinder, Bundle bundle) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
                    obtain.writeStrongBinder(iGamesCallbacks != null ? iGamesCallbacks.asBinder() : null);
                    obtain.writeString(str);
                    obtain.writeInt(i);
                    obtain.writeStrongBinder(iBinder);
                    if (bundle != null) {
                        obtain.writeInt(1);
                        bundle.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.f1936lb.transact(GamesStatusCodes.STATUS_PARTICIPANT_NOT_CONNECTED, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            /* renamed from: b */
            public void mo6861b(IGamesCallbacks iGamesCallbacks, String str, int i, boolean z) throws RemoteException {
                int i2 = 0;
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
                    obtain.writeStrongBinder(iGamesCallbacks != null ? iGamesCallbacks.asBinder() : null);
                    obtain.writeString(str);
                    obtain.writeInt(i);
                    if (z) {
                        i2 = 1;
                    }
                    obtain.writeInt(i2);
                    this.f1936lb.transact(10017, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            /* renamed from: b */
            public void mo6862b(IGamesCallbacks iGamesCallbacks, String str, int i, boolean z, boolean z2) throws RemoteException {
                int i2 = 1;
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
                    obtain.writeStrongBinder(iGamesCallbacks != null ? iGamesCallbacks.asBinder() : null);
                    obtain.writeString(str);
                    obtain.writeInt(i);
                    obtain.writeInt(z ? 1 : 0);
                    if (!z2) {
                        i2 = 0;
                    }
                    obtain.writeInt(i2);
                    this.f1936lb.transact(5501, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            /* renamed from: b */
            public void mo6863b(IGamesCallbacks iGamesCallbacks, String str, IBinder iBinder, Bundle bundle) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
                    obtain.writeStrongBinder(iGamesCallbacks != null ? iGamesCallbacks.asBinder() : null);
                    obtain.writeString(str);
                    obtain.writeStrongBinder(iBinder);
                    if (bundle != null) {
                        obtain.writeInt(1);
                        bundle.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.f1936lb.transact(5024, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            /* renamed from: b */
            public void mo6864b(IGamesCallbacks iGamesCallbacks, String str, String str2) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
                    obtain.writeStrongBinder(iGamesCallbacks != null ? iGamesCallbacks.asBinder() : null);
                    obtain.writeString(str);
                    obtain.writeString(str2);
                    this.f1936lb.transact(5041, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            /* renamed from: b */
            public void mo6865b(IGamesCallbacks iGamesCallbacks, String str, String str2, int i, int i2, int i3, boolean z) throws RemoteException {
                int i4 = 0;
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
                    obtain.writeStrongBinder(iGamesCallbacks != null ? iGamesCallbacks.asBinder() : null);
                    obtain.writeString(str);
                    obtain.writeString(str2);
                    obtain.writeInt(i);
                    obtain.writeInt(i2);
                    obtain.writeInt(i3);
                    if (z) {
                        i4 = 1;
                    }
                    obtain.writeInt(i4);
                    this.f1936lb.transact(5040, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            /* renamed from: b */
            public void mo6866b(IGamesCallbacks iGamesCallbacks, String str, String str2, int i, boolean z, boolean z2) throws RemoteException {
                int i2 = 1;
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
                    obtain.writeStrongBinder(iGamesCallbacks != null ? iGamesCallbacks.asBinder() : null);
                    obtain.writeString(str);
                    obtain.writeString(str2);
                    obtain.writeInt(i);
                    obtain.writeInt(z ? 1 : 0);
                    if (!z2) {
                        i2 = 0;
                    }
                    obtain.writeInt(i2);
                    this.f1936lb.transact(12018, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            /* renamed from: b */
            public void mo6867b(IGamesCallbacks iGamesCallbacks, String str, String str2, boolean z) throws RemoteException {
                int i = 0;
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
                    obtain.writeStrongBinder(iGamesCallbacks != null ? iGamesCallbacks.asBinder() : null);
                    obtain.writeString(str);
                    obtain.writeString(str2);
                    if (z) {
                        i = 1;
                    }
                    obtain.writeInt(i);
                    this.f1936lb.transact(GamesStatusCodes.STATUS_MATCH_NOT_FOUND, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            /* renamed from: b */
            public void mo6868b(IGamesCallbacks iGamesCallbacks, String str, boolean z) throws RemoteException {
                int i = 0;
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
                    obtain.writeStrongBinder(iGamesCallbacks != null ? iGamesCallbacks.asBinder() : null);
                    obtain.writeString(str);
                    if (z) {
                        i = 1;
                    }
                    obtain.writeInt(i);
                    this.f1936lb.transact(GamesStatusCodes.STATUS_MATCH_ERROR_INVALID_MATCH_STATE, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            /* renamed from: b */
            public void mo6869b(IGamesCallbacks iGamesCallbacks, boolean z) throws RemoteException {
                int i = 0;
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
                    obtain.writeStrongBinder(iGamesCallbacks != null ? iGamesCallbacks.asBinder() : null);
                    if (z) {
                        i = 1;
                    }
                    obtain.writeInt(i);
                    this.f1936lb.transact(GamesStatusCodes.STATUS_MATCH_ERROR_OUT_OF_DATE_VERSION, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            /* renamed from: b */
            public void mo6870b(IGamesCallbacks iGamesCallbacks, String[] strArr) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
                    obtain.writeStrongBinder(iGamesCallbacks != null ? iGamesCallbacks.asBinder() : null);
                    obtain.writeStringArray(strArr);
                    this.f1936lb.transact(GamesActivityResultCodes.RESULT_SEND_REQUEST_FAILED, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            /* renamed from: b */
            public void mo6871b(String str, String str2, int i) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
                    obtain.writeString(str);
                    obtain.writeString(str2);
                    obtain.writeInt(i);
                    this.f1936lb.transact(5051, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            /* renamed from: bB */
            public String mo6872bB(String str) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
                    obtain.writeString(str);
                    this.f1936lb.transact(5064, obtain, obtain2, 0);
                    obtain2.readException();
                    return obtain2.readString();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            /* renamed from: bC */
            public String mo6873bC(String str) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
                    obtain.writeString(str);
                    this.f1936lb.transact(5035, obtain, obtain2, 0);
                    obtain2.readException();
                    return obtain2.readString();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            /* renamed from: bD */
            public void mo6874bD(String str) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
                    obtain.writeString(str);
                    this.f1936lb.transact(5050, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            /* renamed from: bE */
            public int mo6875bE(String str) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
                    obtain.writeString(str);
                    this.f1936lb.transact(5060, obtain, obtain2, 0);
                    obtain2.readException();
                    return obtain2.readInt();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            /* renamed from: bF */
            public Uri mo6876bF(String str) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
                    obtain.writeString(str);
                    this.f1936lb.transact(5066, obtain, obtain2, 0);
                    obtain2.readException();
                    return obtain2.readInt() != 0 ? (Uri) Uri.CREATOR.createFromParcel(obtain2) : null;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            /* renamed from: bG */
            public void mo6877bG(String str) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
                    obtain.writeString(str);
                    this.f1936lb.transact(GamesStatusCodes.STATUS_QUEST_NO_LONGER_AVAILABLE, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            /* renamed from: bH */
            public ParcelFileDescriptor mo6878bH(String str) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
                    obtain.writeString(str);
                    this.f1936lb.transact(9030, obtain, obtain2, 0);
                    obtain2.readException();
                    return obtain2.readInt() != 0 ? (ParcelFileDescriptor) ParcelFileDescriptor.CREATOR.createFromParcel(obtain2) : null;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            /* renamed from: bu */
            public Intent mo6879bu(String str) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
                    obtain.writeString(str);
                    this.f1936lb.transact(9004, obtain, obtain2, 0);
                    obtain2.readException();
                    return obtain2.readInt() != 0 ? (Intent) Intent.CREATOR.createFromParcel(obtain2) : null;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            /* renamed from: bz */
            public Intent mo6880bz(String str) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
                    obtain.writeString(str);
                    this.f1936lb.transact(12034, obtain, obtain2, 0);
                    obtain2.readException();
                    return obtain2.readInt() != 0 ? (Intent) Intent.CREATOR.createFromParcel(obtain2) : null;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            /* renamed from: c */
            public void mo6881c(long j, String str) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
                    obtain.writeLong(j);
                    obtain.writeString(str);
                    this.f1936lb.transact(GamesActivityResultCodes.RESULT_APP_MISCONFIGURED, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            /* renamed from: c */
            public void mo6882c(IGamesCallbacks iGamesCallbacks) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
                    obtain.writeStrongBinder(iGamesCallbacks != null ? iGamesCallbacks.asBinder() : null);
                    this.f1936lb.transact(5022, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            /* renamed from: c */
            public void mo6883c(IGamesCallbacks iGamesCallbacks, int i, boolean z, boolean z2) throws RemoteException {
                int i2 = 1;
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
                    obtain.writeStrongBinder(iGamesCallbacks != null ? iGamesCallbacks.asBinder() : null);
                    obtain.writeInt(i);
                    obtain.writeInt(z ? 1 : 0);
                    if (!z2) {
                        i2 = 0;
                    }
                    obtain.writeInt(i2);
                    this.f1936lb.transact(5048, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            /* renamed from: c */
            public void mo6884c(IGamesCallbacks iGamesCallbacks, long j) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
                    obtain.writeStrongBinder(iGamesCallbacks != null ? iGamesCallbacks.asBinder() : null);
                    obtain.writeLong(j);
                    this.f1936lb.transact(GamesActivityResultCodes.RESULT_RECONNECT_REQUIRED, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            /* renamed from: c */
            public void mo6885c(IGamesCallbacks iGamesCallbacks, long j, String str) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
                    obtain.writeStrongBinder(iGamesCallbacks != null ? iGamesCallbacks.asBinder() : null);
                    obtain.writeLong(j);
                    obtain.writeString(str);
                    this.f1936lb.transact(GamesActivityResultCodes.RESULT_LICENSE_FAILED, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            /* renamed from: c */
            public void mo6886c(IGamesCallbacks iGamesCallbacks, String str) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
                    obtain.writeStrongBinder(iGamesCallbacks != null ? iGamesCallbacks.asBinder() : null);
                    obtain.writeString(str);
                    this.f1936lb.transact(5032, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            /* renamed from: c */
            public void mo6887c(IGamesCallbacks iGamesCallbacks, String str, int i) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
                    obtain.writeStrongBinder(iGamesCallbacks != null ? iGamesCallbacks.asBinder() : null);
                    obtain.writeString(str);
                    obtain.writeInt(i);
                    this.f1936lb.transact(12024, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            /* renamed from: c */
            public void mo6888c(IGamesCallbacks iGamesCallbacks, String str, int i, boolean z, boolean z2) throws RemoteException {
                int i2 = 1;
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
                    obtain.writeStrongBinder(iGamesCallbacks != null ? iGamesCallbacks.asBinder() : null);
                    obtain.writeString(str);
                    obtain.writeInt(i);
                    obtain.writeInt(z ? 1 : 0);
                    if (!z2) {
                        i2 = 0;
                    }
                    obtain.writeInt(i2);
                    this.f1936lb.transact(9001, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            /* renamed from: c */
            public void mo6889c(IGamesCallbacks iGamesCallbacks, String str, String str2) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
                    obtain.writeStrongBinder(iGamesCallbacks != null ? iGamesCallbacks.asBinder() : null);
                    obtain.writeString(str);
                    obtain.writeString(str2);
                    this.f1936lb.transact(8011, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            /* renamed from: c */
            public void mo6890c(IGamesCallbacks iGamesCallbacks, String str, String str2, boolean z) throws RemoteException {
                int i = 0;
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
                    obtain.writeStrongBinder(iGamesCallbacks != null ? iGamesCallbacks.asBinder() : null);
                    obtain.writeString(str);
                    obtain.writeString(str2);
                    if (z) {
                        i = 1;
                    }
                    obtain.writeInt(i);
                    this.f1936lb.transact(12003, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            /* renamed from: c */
            public void mo6891c(IGamesCallbacks iGamesCallbacks, String str, boolean z) throws RemoteException {
                int i = 0;
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
                    obtain.writeStrongBinder(iGamesCallbacks != null ? iGamesCallbacks.asBinder() : null);
                    obtain.writeString(str);
                    if (z) {
                        i = 1;
                    }
                    obtain.writeInt(i);
                    this.f1936lb.transact(GamesStatusCodes.STATUS_MATCH_ERROR_INVALID_MATCH_RESULTS, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            /* renamed from: c */
            public void mo6892c(IGamesCallbacks iGamesCallbacks, boolean z) throws RemoteException {
                int i = 0;
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
                    obtain.writeStrongBinder(iGamesCallbacks != null ? iGamesCallbacks.asBinder() : null);
                    if (z) {
                        i = 1;
                    }
                    obtain.writeInt(i);
                    this.f1936lb.transact(8027, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            /* renamed from: c */
            public void mo6893c(IGamesCallbacks iGamesCallbacks, String[] strArr) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
                    obtain.writeStrongBinder(iGamesCallbacks != null ? iGamesCallbacks.asBinder() : null);
                    obtain.writeStringArray(strArr);
                    this.f1936lb.transact(10020, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            /* renamed from: c */
            public void mo6894c(String str, String str2, int i) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
                    obtain.writeString(str);
                    obtain.writeString(str2);
                    obtain.writeInt(i);
                    this.f1936lb.transact(8026, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            /* renamed from: d */
            public void mo6895d(long j, String str) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
                    obtain.writeLong(j);
                    obtain.writeString(str);
                    this.f1936lb.transact(12014, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            /* renamed from: d */
            public void mo6896d(IGamesCallbacks iGamesCallbacks) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
                    obtain.writeStrongBinder(iGamesCallbacks != null ? iGamesCallbacks.asBinder() : null);
                    this.f1936lb.transact(5026, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            /* renamed from: d */
            public void mo6897d(IGamesCallbacks iGamesCallbacks, int i, boolean z, boolean z2) throws RemoteException {
                int i2 = 1;
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
                    obtain.writeStrongBinder(iGamesCallbacks != null ? iGamesCallbacks.asBinder() : null);
                    obtain.writeInt(i);
                    obtain.writeInt(z ? 1 : 0);
                    if (!z2) {
                        i2 = 0;
                    }
                    obtain.writeInt(i2);
                    this.f1936lb.transact(GamesStatusCodes.STATUS_MULTIPLAYER_DISABLED, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            /* renamed from: d */
            public void mo6898d(IGamesCallbacks iGamesCallbacks, long j) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
                    obtain.writeStrongBinder(iGamesCallbacks != null ? iGamesCallbacks.asBinder() : null);
                    obtain.writeLong(j);
                    this.f1936lb.transact(12011, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            /* renamed from: d */
            public void mo6899d(IGamesCallbacks iGamesCallbacks, long j, String str) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
                    obtain.writeStrongBinder(iGamesCallbacks != null ? iGamesCallbacks.asBinder() : null);
                    obtain.writeLong(j);
                    obtain.writeString(str);
                    this.f1936lb.transact(12013, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            /* renamed from: d */
            public void mo6900d(IGamesCallbacks iGamesCallbacks, String str) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
                    obtain.writeStrongBinder(iGamesCallbacks != null ? iGamesCallbacks.asBinder() : null);
                    obtain.writeString(str);
                    this.f1936lb.transact(5037, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            /* renamed from: d */
            public void mo6901d(IGamesCallbacks iGamesCallbacks, String str, int i, boolean z, boolean z2) throws RemoteException {
                int i2 = 1;
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
                    obtain.writeStrongBinder(iGamesCallbacks != null ? iGamesCallbacks.asBinder() : null);
                    obtain.writeString(str);
                    obtain.writeInt(i);
                    obtain.writeInt(z ? 1 : 0);
                    if (!z2) {
                        i2 = 0;
                    }
                    obtain.writeInt(i2);
                    this.f1936lb.transact(9020, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            /* renamed from: d */
            public void mo6902d(IGamesCallbacks iGamesCallbacks, String str, String str2) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
                    obtain.writeStrongBinder(iGamesCallbacks != null ? iGamesCallbacks.asBinder() : null);
                    obtain.writeString(str);
                    obtain.writeString(str2);
                    this.f1936lb.transact(8015, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            /* renamed from: d */
            public void mo6903d(IGamesCallbacks iGamesCallbacks, String str, boolean z) throws RemoteException {
                int i = 0;
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
                    obtain.writeStrongBinder(iGamesCallbacks != null ? iGamesCallbacks.asBinder() : null);
                    obtain.writeString(str);
                    if (z) {
                        i = 1;
                    }
                    obtain.writeInt(i);
                    this.f1936lb.transact(GamesStatusCodes.STATUS_MATCH_ERROR_ALREADY_REMATCHED, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            /* renamed from: d */
            public void mo6904d(IGamesCallbacks iGamesCallbacks, boolean z) throws RemoteException {
                int i = 0;
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
                    obtain.writeStrongBinder(iGamesCallbacks != null ? iGamesCallbacks.asBinder() : null);
                    if (z) {
                        i = 1;
                    }
                    obtain.writeInt(i);
                    this.f1936lb.transact(12002, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            /* renamed from: dC */
            public void mo6905dC(int i) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
                    obtain.writeInt(i);
                    this.f1936lb.transact(5036, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            /* renamed from: e */
            public void mo6906e(IGamesCallbacks iGamesCallbacks) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
                    obtain.writeStrongBinder(iGamesCallbacks != null ? iGamesCallbacks.asBinder() : null);
                    this.f1936lb.transact(5027, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            /* renamed from: e */
            public void mo6907e(IGamesCallbacks iGamesCallbacks, int i, boolean z, boolean z2) throws RemoteException {
                int i2 = 1;
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
                    obtain.writeStrongBinder(iGamesCallbacks != null ? iGamesCallbacks.asBinder() : null);
                    obtain.writeInt(i);
                    obtain.writeInt(z ? 1 : 0);
                    if (!z2) {
                        i2 = 0;
                    }
                    obtain.writeInt(i2);
                    this.f1936lb.transact(GamesStatusCodes.STATUS_MULTIPLAYER_ERROR_INVALID_OPERATION, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            /* renamed from: e */
            public void mo6908e(IGamesCallbacks iGamesCallbacks, String str) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
                    obtain.writeStrongBinder(iGamesCallbacks != null ? iGamesCallbacks.asBinder() : null);
                    obtain.writeString(str);
                    this.f1936lb.transact(5042, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            /* renamed from: e */
            public void mo6909e(IGamesCallbacks iGamesCallbacks, String str, int i, boolean z, boolean z2) throws RemoteException {
                int i2 = 1;
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
                    obtain.writeStrongBinder(iGamesCallbacks != null ? iGamesCallbacks.asBinder() : null);
                    obtain.writeString(str);
                    obtain.writeInt(i);
                    obtain.writeInt(z ? 1 : 0);
                    if (!z2) {
                        i2 = 0;
                    }
                    obtain.writeInt(i2);
                    this.f1936lb.transact(12021, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            /* renamed from: e */
            public void mo6910e(IGamesCallbacks iGamesCallbacks, String str, String str2) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
                    obtain.writeStrongBinder(iGamesCallbacks != null ? iGamesCallbacks.asBinder() : null);
                    obtain.writeString(str);
                    obtain.writeString(str2);
                    this.f1936lb.transact(8016, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            /* renamed from: e */
            public void mo6911e(IGamesCallbacks iGamesCallbacks, String str, boolean z) throws RemoteException {
                int i = 0;
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
                    obtain.writeStrongBinder(iGamesCallbacks != null ? iGamesCallbacks.asBinder() : null);
                    obtain.writeString(str);
                    if (z) {
                        i = 1;
                    }
                    obtain.writeInt(i);
                    this.f1936lb.transact(12006, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            /* renamed from: e */
            public void mo6912e(IGamesCallbacks iGamesCallbacks, boolean z) throws RemoteException {
                int i = 0;
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
                    obtain.writeStrongBinder(iGamesCallbacks != null ? iGamesCallbacks.asBinder() : null);
                    if (z) {
                        i = 1;
                    }
                    obtain.writeInt(i);
                    this.f1936lb.transact(12032, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            /* renamed from: f */
            public void mo6913f(IGamesCallbacks iGamesCallbacks) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
                    obtain.writeStrongBinder(iGamesCallbacks != null ? iGamesCallbacks.asBinder() : null);
                    this.f1936lb.transact(5047, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            /* renamed from: f */
            public void mo6914f(IGamesCallbacks iGamesCallbacks, String str) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
                    obtain.writeStrongBinder(iGamesCallbacks != null ? iGamesCallbacks.asBinder() : null);
                    obtain.writeString(str);
                    this.f1936lb.transact(5043, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            /* renamed from: f */
            public void mo6915f(IGamesCallbacks iGamesCallbacks, String str, int i, boolean z, boolean z2) throws RemoteException {
                int i2 = 1;
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
                    obtain.writeStrongBinder(iGamesCallbacks != null ? iGamesCallbacks.asBinder() : null);
                    obtain.writeString(str);
                    obtain.writeInt(i);
                    obtain.writeInt(z ? 1 : 0);
                    if (!z2) {
                        i2 = 0;
                    }
                    obtain.writeInt(i2);
                    this.f1936lb.transact(12022, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            /* renamed from: f */
            public void mo6916f(IGamesCallbacks iGamesCallbacks, String str, String str2) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
                    obtain.writeStrongBinder(iGamesCallbacks != null ? iGamesCallbacks.asBinder() : null);
                    obtain.writeString(str);
                    obtain.writeString(str2);
                    this.f1936lb.transact(12009, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            /* renamed from: f */
            public void mo6917f(IGamesCallbacks iGamesCallbacks, boolean z) throws RemoteException {
                int i = 0;
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
                    obtain.writeStrongBinder(iGamesCallbacks != null ? iGamesCallbacks.asBinder() : null);
                    if (z) {
                        i = 1;
                    }
                    obtain.writeInt(i);
                    this.f1936lb.transact(12016, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            /* renamed from: fD */
            public Bundle mo6918fD() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
                    this.f1936lb.transact(FitnessStatusCodes.APP_MISMATCH, obtain, obtain2, 0);
                    obtain2.readException();
                    return obtain2.readInt() != 0 ? (Bundle) Bundle.CREATOR.createFromParcel(obtain2) : null;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            /* renamed from: g */
            public void mo6919g(IGamesCallbacks iGamesCallbacks) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
                    obtain.writeStrongBinder(iGamesCallbacks != null ? iGamesCallbacks.asBinder() : null);
                    this.f1936lb.transact(5049, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            /* renamed from: g */
            public void mo6920g(IGamesCallbacks iGamesCallbacks, String str) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
                    obtain.writeStrongBinder(iGamesCallbacks != null ? iGamesCallbacks.asBinder() : null);
                    obtain.writeString(str);
                    this.f1936lb.transact(5052, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            /* renamed from: g */
            public void mo6921g(IGamesCallbacks iGamesCallbacks, boolean z) throws RemoteException {
                int i = 0;
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
                    obtain.writeStrongBinder(iGamesCallbacks != null ? iGamesCallbacks.asBinder() : null);
                    if (z) {
                        i = 1;
                    }
                    obtain.writeInt(i);
                    this.f1936lb.transact(13003, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            /* renamed from: h */
            public ParcelFileDescriptor mo6922h(Uri uri) throws RemoteException {
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
                    this.f1936lb.transact(GamesStatusCodes.STATUS_MATCH_ERROR_LOCALLY_MODIFIED, obtain, obtain2, 0);
                    obtain2.readException();
                    return obtain2.readInt() != 0 ? (ParcelFileDescriptor) ParcelFileDescriptor.CREATOR.createFromParcel(obtain2) : null;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            /* renamed from: h */
            public RoomEntity mo6923h(IGamesCallbacks iGamesCallbacks, String str) throws RemoteException {
                RoomEntity roomEntity = null;
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
                    obtain.writeStrongBinder(iGamesCallbacks != null ? iGamesCallbacks.asBinder() : null);
                    obtain.writeString(str);
                    this.f1936lb.transact(5053, obtain, obtain2, 0);
                    obtain2.readException();
                    if (obtain2.readInt() != 0) {
                        roomEntity = RoomEntity.CREATOR.createFromParcel(obtain2);
                    }
                    return roomEntity;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            /* renamed from: h */
            public void mo6924h(IGamesCallbacks iGamesCallbacks) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
                    obtain.writeStrongBinder(iGamesCallbacks != null ? iGamesCallbacks.asBinder() : null);
                    this.f1936lb.transact(5056, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            /* renamed from: h */
            public void mo6925h(IGamesCallbacks iGamesCallbacks, boolean z) throws RemoteException {
                int i = 0;
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
                    obtain.writeStrongBinder(iGamesCallbacks != null ? iGamesCallbacks.asBinder() : null);
                    if (z) {
                        i = 1;
                    }
                    obtain.writeInt(i);
                    this.f1936lb.transact(13004, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            /* renamed from: i */
            public void mo6926i(IGamesCallbacks iGamesCallbacks) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
                    obtain.writeStrongBinder(iGamesCallbacks != null ? iGamesCallbacks.asBinder() : null);
                    this.f1936lb.transact(5062, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            /* renamed from: i */
            public void mo6927i(IGamesCallbacks iGamesCallbacks, String str) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
                    obtain.writeStrongBinder(iGamesCallbacks != null ? iGamesCallbacks.asBinder() : null);
                    obtain.writeString(str);
                    this.f1936lb.transact(5061, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            /* renamed from: j */
            public void mo6928j(IGamesCallbacks iGamesCallbacks) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
                    obtain.writeStrongBinder(iGamesCallbacks != null ? iGamesCallbacks.asBinder() : null);
                    this.f1936lb.transact(11001, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            /* renamed from: j */
            public void mo6929j(IGamesCallbacks iGamesCallbacks, String str) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
                    obtain.writeStrongBinder(iGamesCallbacks != null ? iGamesCallbacks.asBinder() : null);
                    obtain.writeString(str);
                    this.f1936lb.transact(5057, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            /* renamed from: jX */
            public String mo6930jX() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
                    this.f1936lb.transact(FitnessStatusCodes.UNSUPPORTED_PLATFORM, obtain, obtain2, 0);
                    obtain2.readException();
                    return obtain2.readString();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            /* renamed from: jY */
            public String mo6931jY() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
                    this.f1936lb.transact(FitnessStatusCodes.AGGREGATION_NOT_SUPPORTED, obtain, obtain2, 0);
                    obtain2.readException();
                    return obtain2.readString();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            /* renamed from: k */
            public void mo6932k(IGamesCallbacks iGamesCallbacks, String str) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
                    obtain.writeStrongBinder(iGamesCallbacks != null ? iGamesCallbacks.asBinder() : null);
                    obtain.writeString(str);
                    this.f1936lb.transact(GamesStatusCodes.STATUS_REAL_TIME_MESSAGE_SEND_FAILED, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            /* renamed from: kA */
            public Intent mo6933kA() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
                    this.f1936lb.transact(9013, obtain, obtain2, 0);
                    obtain2.readException();
                    return obtain2.readInt() != 0 ? (Intent) Intent.CREATOR.createFromParcel(obtain2) : null;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            /* renamed from: kB */
            public void mo6934kB() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
                    this.f1936lb.transact(11002, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            /* renamed from: kC */
            public boolean mo6935kC() throws RemoteException {
                boolean z = false;
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
                    this.f1936lb.transact(12025, obtain, obtain2, 0);
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

            /* renamed from: kb */
            public Intent mo6936kb() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
                    this.f1936lb.transact(9003, obtain, obtain2, 0);
                    obtain2.readException();
                    return obtain2.readInt() != 0 ? (Intent) Intent.CREATOR.createFromParcel(obtain2) : null;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            /* renamed from: kc */
            public Intent mo6937kc() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
                    this.f1936lb.transact(9005, obtain, obtain2, 0);
                    obtain2.readException();
                    return obtain2.readInt() != 0 ? (Intent) Intent.CREATOR.createFromParcel(obtain2) : null;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            /* renamed from: kd */
            public Intent mo6938kd() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
                    this.f1936lb.transact(9006, obtain, obtain2, 0);
                    obtain2.readException();
                    return obtain2.readInt() != 0 ? (Intent) Intent.CREATOR.createFromParcel(obtain2) : null;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            /* renamed from: ke */
            public Intent mo6939ke() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
                    this.f1936lb.transact(9007, obtain, obtain2, 0);
                    obtain2.readException();
                    return obtain2.readInt() != 0 ? (Intent) Intent.CREATOR.createFromParcel(obtain2) : null;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            /* renamed from: kj */
            public Intent mo6940kj() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
                    this.f1936lb.transact(9010, obtain, obtain2, 0);
                    obtain2.readException();
                    return obtain2.readInt() != 0 ? (Intent) Intent.CREATOR.createFromParcel(obtain2) : null;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            /* renamed from: kk */
            public Intent mo6941kk() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
                    this.f1936lb.transact(9012, obtain, obtain2, 0);
                    obtain2.readException();
                    return obtain2.readInt() != 0 ? (Intent) Intent.CREATOR.createFromParcel(obtain2) : null;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            /* renamed from: kl */
            public int mo6942kl() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
                    this.f1936lb.transact(9019, obtain, obtain2, 0);
                    obtain2.readException();
                    return obtain2.readInt();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            /* renamed from: km */
            public String mo6943km() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
                    this.f1936lb.transact(FitnessStatusCodes.DATA_TYPE_NOT_FOUND, obtain, obtain2, 0);
                    obtain2.readException();
                    return obtain2.readString();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            /* renamed from: kn */
            public int mo6944kn() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
                    this.f1936lb.transact(8024, obtain, obtain2, 0);
                    obtain2.readException();
                    return obtain2.readInt();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            /* renamed from: ko */
            public Intent mo6945ko() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
                    this.f1936lb.transact(10015, obtain, obtain2, 0);
                    obtain2.readException();
                    return obtain2.readInt() != 0 ? (Intent) Intent.CREATOR.createFromParcel(obtain2) : null;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            /* renamed from: kp */
            public int mo6946kp() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
                    this.f1936lb.transact(10013, obtain, obtain2, 0);
                    obtain2.readException();
                    return obtain2.readInt();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            /* renamed from: kq */
            public int mo6947kq() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
                    this.f1936lb.transact(10023, obtain, obtain2, 0);
                    obtain2.readException();
                    return obtain2.readInt();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            /* renamed from: kr */
            public int mo6948kr() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
                    this.f1936lb.transact(12035, obtain, obtain2, 0);
                    obtain2.readException();
                    return obtain2.readInt();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            /* renamed from: ks */
            public int mo6949ks() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
                    this.f1936lb.transact(12036, obtain, obtain2, 0);
                    obtain2.readException();
                    return obtain2.readInt();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            /* renamed from: ku */
            public void mo6950ku() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
                    this.f1936lb.transact(FitnessStatusCodes.MISSING_BLE_PERMISSION, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            /* renamed from: kw */
            public DataHolder mo6951kw() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
                    this.f1936lb.transact(FitnessStatusCodes.UNSUPPORTED_ACCOUNT, obtain, obtain2, 0);
                    obtain2.readException();
                    return obtain2.readInt() != 0 ? DataHolder.CREATOR.createFromParcel(obtain2) : null;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            /* renamed from: kx */
            public boolean mo6952kx() throws RemoteException {
                boolean z = false;
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
                    this.f1936lb.transact(5067, obtain, obtain2, 0);
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

            /* renamed from: ky */
            public DataHolder mo6953ky() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
                    this.f1936lb.transact(5502, obtain, obtain2, 0);
                    obtain2.readException();
                    return obtain2.readInt() != 0 ? DataHolder.CREATOR.createFromParcel(obtain2) : null;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            /* renamed from: kz */
            public void mo6954kz() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
                    this.f1936lb.transact(8022, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            /* renamed from: l */
            public void mo6955l(IGamesCallbacks iGamesCallbacks, String str) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
                    obtain.writeStrongBinder(iGamesCallbacks != null ? iGamesCallbacks.asBinder() : null);
                    obtain.writeString(str);
                    this.f1936lb.transact(8005, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            /* renamed from: m */
            public void mo6956m(IGamesCallbacks iGamesCallbacks, String str) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
                    obtain.writeStrongBinder(iGamesCallbacks != null ? iGamesCallbacks.asBinder() : null);
                    obtain.writeString(str);
                    this.f1936lb.transact(8006, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            /* renamed from: n */
            public void mo6957n(IGamesCallbacks iGamesCallbacks, String str) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
                    obtain.writeStrongBinder(iGamesCallbacks != null ? iGamesCallbacks.asBinder() : null);
                    obtain.writeString(str);
                    this.f1936lb.transact(8009, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            /* renamed from: n */
            public void mo6958n(String str, int i) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
                    obtain.writeString(str);
                    obtain.writeInt(i);
                    this.f1936lb.transact(12017, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            /* renamed from: o */
            public void mo6959o(IGamesCallbacks iGamesCallbacks, String str) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
                    obtain.writeStrongBinder(iGamesCallbacks != null ? iGamesCallbacks.asBinder() : null);
                    obtain.writeString(str);
                    this.f1936lb.transact(8010, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            /* renamed from: o */
            public void mo6960o(String str, int i) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
                    obtain.writeString(str);
                    obtain.writeInt(i);
                    this.f1936lb.transact(5029, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            /* renamed from: p */
            public void mo6961p(IGamesCallbacks iGamesCallbacks, String str) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
                    obtain.writeStrongBinder(iGamesCallbacks != null ? iGamesCallbacks.asBinder() : null);
                    obtain.writeString(str);
                    this.f1936lb.transact(8014, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            /* renamed from: p */
            public void mo6962p(String str, int i) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
                    obtain.writeString(str);
                    obtain.writeInt(i);
                    this.f1936lb.transact(5028, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            /* renamed from: q */
            public void mo6963q(long j) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
                    obtain.writeLong(j);
                    this.f1936lb.transact(FitnessStatusCodes.CONFLICTING_DATA_TYPE, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            /* renamed from: q */
            public void mo6964q(IGamesCallbacks iGamesCallbacks, String str) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
                    obtain.writeStrongBinder(iGamesCallbacks != null ? iGamesCallbacks.asBinder() : null);
                    obtain.writeString(str);
                    this.f1936lb.transact(9002, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            /* renamed from: r */
            public void mo6965r(long j) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
                    obtain.writeLong(j);
                    this.f1936lb.transact(5059, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            /* renamed from: r */
            public void mo6966r(IGamesCallbacks iGamesCallbacks, String str) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
                    obtain.writeStrongBinder(iGamesCallbacks != null ? iGamesCallbacks.asBinder() : null);
                    obtain.writeString(str);
                    this.f1936lb.transact(12020, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            /* renamed from: r */
            public void mo6967r(String str, int i) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
                    obtain.writeString(str);
                    obtain.writeInt(i);
                    this.f1936lb.transact(5055, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            /* renamed from: s */
            public void mo6968s(long j) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
                    obtain.writeLong(j);
                    this.f1936lb.transact(8013, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            /* renamed from: s */
            public void mo6969s(IGamesCallbacks iGamesCallbacks, String str) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
                    obtain.writeStrongBinder(iGamesCallbacks != null ? iGamesCallbacks.asBinder() : null);
                    obtain.writeString(str);
                    this.f1936lb.transact(12005, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            /* renamed from: s */
            public void mo6970s(String str, int i) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
                    obtain.writeString(str);
                    obtain.writeInt(i);
                    this.f1936lb.transact(10014, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            /* renamed from: t */
            public void mo6971t(long j) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
                    obtain.writeLong(j);
                    this.f1936lb.transact(GamesActivityResultCodes.RESULT_SIGN_IN_FAILED, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            /* renamed from: t */
            public void mo6972t(IGamesCallbacks iGamesCallbacks, String str) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
                    obtain.writeStrongBinder(iGamesCallbacks != null ? iGamesCallbacks.asBinder() : null);
                    obtain.writeString(str);
                    this.f1936lb.transact(12027, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            /* renamed from: u */
            public void mo6973u(long j) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
                    obtain.writeLong(j);
                    this.f1936lb.transact(12012, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            /* renamed from: u */
            public void mo6974u(IGamesCallbacks iGamesCallbacks, String str) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
                    obtain.writeStrongBinder(iGamesCallbacks != null ? iGamesCallbacks.asBinder() : null);
                    obtain.writeString(str);
                    this.f1936lb.transact(12008, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            /* renamed from: u */
            public void mo6975u(String str, String str2) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
                    obtain.writeString(str);
                    obtain.writeString(str2);
                    this.f1936lb.transact(5065, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            /* renamed from: v */
            public void mo6976v(String str, String str2) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
                    obtain.writeString(str);
                    obtain.writeString(str2);
                    this.f1936lb.transact(8025, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }
        }

        public Stub() {
            attachInterface(this, "com.google.android.gms.games.internal.IGamesService");
        }

        /* renamed from: aB */
        public static IGamesService m2876aB(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.games.internal.IGamesService");
            return (queryLocalInterface == null || !(queryLocalInterface instanceof IGamesService)) ? new Proxy(iBinder) : (IGamesService) queryLocalInterface;
        }

        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v1, resolved type: com.google.android.gms.games.achievement.AchievementEntity} */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v16, resolved type: com.google.android.gms.drive.Contents} */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v18, resolved type: com.google.android.gms.games.internal.multiplayer.ZInvitationCluster} */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v20, resolved type: com.google.android.gms.games.internal.request.GameRequestCluster} */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v30, resolved type: android.net.Uri} */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v37, resolved type: android.os.Bundle} */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v40, resolved type: android.os.Bundle} */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v58, resolved type: android.os.Bundle} */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v60, resolved type: android.os.Bundle} */
        /* JADX WARNING: type inference failed for: r5v0 */
        /* JADX WARNING: type inference failed for: r5v17 */
        /* JADX WARNING: type inference failed for: r5v31 */
        /* JADX WARNING: type inference failed for: r5v38 */
        /* JADX WARNING: type inference failed for: r5v41 */
        /* JADX WARNING: type inference failed for: r5v59 */
        /* JADX WARNING: type inference failed for: r5v61 */
        /* JADX WARNING: type inference failed for: r5v64 */
        /* JADX WARNING: type inference failed for: r5v65 */
        /* JADX WARNING: type inference failed for: r5v66 */
        /* JADX WARNING: Multi-variable type inference failed */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public boolean onTransact(int r11, android.os.Parcel r12, android.os.Parcel r13, int r14) throws android.os.RemoteException {
            /*
                r10 = this;
                r5 = 0
                r7 = 0
                r9 = 1
                switch(r11) {
                    case 5001: goto L_0x0011;
                    case 5002: goto L_0x0021;
                    case 5003: goto L_0x0035;
                    case 5004: goto L_0x0045;
                    case 5005: goto L_0x005e;
                    case 5006: goto L_0x007e;
                    case 5007: goto L_0x008a;
                    case 5012: goto L_0x00c5;
                    case 5013: goto L_0x00d6;
                    case 5014: goto L_0x00f1;
                    case 5015: goto L_0x010a;
                    case 5016: goto L_0x0133;
                    case 5017: goto L_0x0150;
                    case 5018: goto L_0x0165;
                    case 5019: goto L_0x017e;
                    case 5020: goto L_0x01ad;
                    case 5021: goto L_0x01dc;
                    case 5022: goto L_0x0209;
                    case 5023: goto L_0x021e;
                    case 5024: goto L_0x024b;
                    case 5025: goto L_0x0278;
                    case 5026: goto L_0x02a9;
                    case 5027: goto L_0x02be;
                    case 5028: goto L_0x02d3;
                    case 5029: goto L_0x02e8;
                    case 5030: goto L_0x0327;
                    case 5031: goto L_0x0365;
                    case 5032: goto L_0x0390;
                    case 5033: goto L_0x03a9;
                    case 5034: goto L_0x03ce;
                    case 5035: goto L_0x03eb;
                    case 5036: goto L_0x0400;
                    case 5037: goto L_0x0411;
                    case 5038: goto L_0x042a;
                    case 5039: goto L_0x0447;
                    case 5040: goto L_0x0478;
                    case 5041: goto L_0x04a9;
                    case 5042: goto L_0x04c6;
                    case 5043: goto L_0x04df;
                    case 5044: goto L_0x04f8;
                    case 5045: goto L_0x0528;
                    case 5046: goto L_0x0558;
                    case 5047: goto L_0x0581;
                    case 5048: goto L_0x0596;
                    case 5049: goto L_0x05bf;
                    case 5050: goto L_0x05d4;
                    case 5051: goto L_0x05e5;
                    case 5052: goto L_0x05fe;
                    case 5053: goto L_0x0617;
                    case 5054: goto L_0x0653;
                    case 5055: goto L_0x068c;
                    case 5056: goto L_0x06c9;
                    case 5057: goto L_0x06de;
                    case 5058: goto L_0x02fd;
                    case 5059: goto L_0x0316;
                    case 5060: goto L_0x063e;
                    case 5061: goto L_0x0673;
                    case 5062: goto L_0x06f7;
                    case 5063: goto L_0x070c;
                    case 5064: goto L_0x009b;
                    case 5065: goto L_0x00b0;
                    case 5066: goto L_0x0738;
                    case 5067: goto L_0x06a1;
                    case 5068: goto L_0x06b5;
                    case 5501: goto L_0x0757;
                    case 5502: goto L_0x0787;
                    case 6001: goto L_0x07a2;
                    case 6002: goto L_0x07be;
                    case 6003: goto L_0x07e2;
                    case 6004: goto L_0x080b;
                    case 6501: goto L_0x0834;
                    case 6502: goto L_0x0874;
                    case 6503: goto L_0x0894;
                    case 6504: goto L_0x08b0;
                    case 6505: goto L_0x08d0;
                    case 6506: goto L_0x08f0;
                    case 6507: goto L_0x0914;
                    case 7001: goto L_0x093f;
                    case 7002: goto L_0x0958;
                    case 7003: goto L_0x097a;
                    case 8001: goto L_0x09ab;
                    case 8002: goto L_0x09d1;
                    case 8003: goto L_0x09e2;
                    case 8004: goto L_0x09fb;
                    case 8005: goto L_0x0a2c;
                    case 8006: goto L_0x0a45;
                    case 8007: goto L_0x0a5e;
                    case 8008: goto L_0x0a88;
                    case 8009: goto L_0x0aad;
                    case 8010: goto L_0x0ac6;
                    case 8011: goto L_0x0adf;
                    case 8012: goto L_0x0afc;
                    case 8013: goto L_0x0b15;
                    case 8014: goto L_0x0b26;
                    case 8015: goto L_0x0b65;
                    case 8016: goto L_0x0b82;
                    case 8017: goto L_0x0b9f;
                    case 8018: goto L_0x0bd5;
                    case 8019: goto L_0x0bf2;
                    case 8020: goto L_0x0c07;
                    case 8021: goto L_0x0c24;
                    case 8022: goto L_0x0c39;
                    case 8023: goto L_0x0c46;
                    case 8024: goto L_0x0b3f;
                    case 8025: goto L_0x0b50;
                    case 8026: goto L_0x0bbc;
                    case 8027: goto L_0x0c6a;
                    case 9001: goto L_0x0c86;
                    case 9002: goto L_0x0cb6;
                    case 9003: goto L_0x0ccf;
                    case 9004: goto L_0x0cea;
                    case 9005: goto L_0x0d09;
                    case 9006: goto L_0x0d24;
                    case 9007: goto L_0x0d3f;
                    case 9008: goto L_0x0d5a;
                    case 9009: goto L_0x0d86;
                    case 9010: goto L_0x0db2;
                    case 9011: goto L_0x0dcd;
                    case 9012: goto L_0x0dfc;
                    case 9013: goto L_0x0e17;
                    case 9019: goto L_0x0e7e;
                    case 9020: goto L_0x0e8f;
                    case 9028: goto L_0x0ebf;
                    case 9030: goto L_0x0ef3;
                    case 9031: goto L_0x0e32;
                    case 10001: goto L_0x0f12;
                    case 10002: goto L_0x0f2b;
                    case 10003: goto L_0x0f3c;
                    case 10004: goto L_0x0f59;
                    case 10005: goto L_0x0f6e;
                    case 10006: goto L_0x0f98;
                    case 10007: goto L_0x0fb1;
                    case 10008: goto L_0x0fca;
                    case 10009: goto L_0x0feb;
                    case 10010: goto L_0x100c;
                    case 10011: goto L_0x1036;
                    case 10012: goto L_0x1053;
                    case 10013: goto L_0x107e;
                    case 10014: goto L_0x10e6;
                    case 10015: goto L_0x10a0;
                    case 10016: goto L_0x10fb;
                    case 10017: goto L_0x1114;
                    case 10018: goto L_0x1167;
                    case 10019: goto L_0x1184;
                    case 10020: goto L_0x11a5;
                    case 10021: goto L_0x1138;
                    case 10022: goto L_0x10bb;
                    case 10023: goto L_0x108f;
                    case 11001: goto L_0x11be;
                    case 11002: goto L_0x11d3;
                    case 12001: goto L_0x11e0;
                    case 12002: goto L_0x1215;
                    case 12003: goto L_0x1231;
                    case 12005: goto L_0x1340;
                    case 12006: goto L_0x1255;
                    case 12007: goto L_0x1275;
                    case 12008: goto L_0x14a1;
                    case 12009: goto L_0x14ba;
                    case 12010: goto L_0x14d7;
                    case 12011: goto L_0x1575;
                    case 12012: goto L_0x15ab;
                    case 12013: goto L_0x158e;
                    case 12014: goto L_0x15bc;
                    case 12015: goto L_0x151b;
                    case 12016: goto L_0x1450;
                    case 12017: goto L_0x148c;
                    case 12018: goto L_0x160f;
                    case 12019: goto L_0x12ad;
                    case 12020: goto L_0x12ca;
                    case 12021: goto L_0x1393;
                    case 12022: goto L_0x13c3;
                    case 12023: goto L_0x1359;
                    case 12024: goto L_0x1376;
                    case 12025: goto L_0x13f3;
                    case 12026: goto L_0x1407;
                    case 12027: goto L_0x141b;
                    case 12028: goto L_0x154a;
                    case 12029: goto L_0x14fb;
                    case 12030: goto L_0x15d1;
                    case 12031: goto L_0x146c;
                    case 12032: goto L_0x1434;
                    case 12033: goto L_0x12e3;
                    case 12034: goto L_0x15f0;
                    case 12035: goto L_0x131e;
                    case 12036: goto L_0x132f;
                    case 13001: goto L_0x1643;
                    case 13002: goto L_0x1657;
                    case 13003: goto L_0x167c;
                    case 13004: goto L_0x1698;
                    case 13005: goto L_0x16b4;
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
                r10.mo6963q(r0)
                r13.writeNoException()
                goto L_0x000a
            L_0x0021:
                java.lang.String r0 = "com.google.android.gms.games.internal.IGamesService"
                r12.enforceInterface(r0)
                android.os.IBinder r0 = r12.readStrongBinder()
                com.google.android.gms.games.internal.IGamesCallbacks r0 = com.google.android.gms.games.internal.IGamesCallbacks.Stub.m2620aA(r0)
                r10.mo6802a((com.google.android.gms.games.internal.IGamesCallbacks) r0)
                r13.writeNoException()
                goto L_0x000a
            L_0x0035:
                java.lang.String r0 = "com.google.android.gms.games.internal.IGamesService"
                r12.enforceInterface(r0)
                java.lang.String r0 = r10.mo6943km()
                r13.writeNoException()
                r13.writeString(r0)
                goto L_0x000a
            L_0x0045:
                java.lang.String r0 = "com.google.android.gms.games.internal.IGamesService"
                r12.enforceInterface(r0)
                android.os.Bundle r0 = r10.mo6918fD()
                r13.writeNoException()
                if (r0 == 0) goto L_0x005a
                r13.writeInt(r9)
                r0.writeToParcel(r13, r9)
                goto L_0x000a
            L_0x005a:
                r13.writeInt(r7)
                goto L_0x000a
            L_0x005e:
                java.lang.String r0 = "com.google.android.gms.games.internal.IGamesService"
                r12.enforceInterface(r0)
                android.os.IBinder r1 = r12.readStrongBinder()
                int r0 = r12.readInt()
                if (r0 == 0) goto L_0x007c
                android.os.Parcelable$Creator r0 = android.os.Bundle.CREATOR
                java.lang.Object r0 = r0.createFromParcel(r12)
                android.os.Bundle r0 = (android.os.Bundle) r0
            L_0x0075:
                r10.mo6800a((android.os.IBinder) r1, (android.os.Bundle) r0)
                r13.writeNoException()
                goto L_0x000a
            L_0x007c:
                r0 = r5
                goto L_0x0075
            L_0x007e:
                java.lang.String r0 = "com.google.android.gms.games.internal.IGamesService"
                r12.enforceInterface(r0)
                r10.mo6950ku()
                r13.writeNoException()
                goto L_0x000a
            L_0x008a:
                java.lang.String r0 = "com.google.android.gms.games.internal.IGamesService"
                r12.enforceInterface(r0)
                java.lang.String r0 = r10.mo6930jX()
                r13.writeNoException()
                r13.writeString(r0)
                goto L_0x000a
            L_0x009b:
                java.lang.String r0 = "com.google.android.gms.games.internal.IGamesService"
                r12.enforceInterface(r0)
                java.lang.String r0 = r12.readString()
                java.lang.String r0 = r10.mo6872bB(r0)
                r13.writeNoException()
                r13.writeString(r0)
                goto L_0x000a
            L_0x00b0:
                java.lang.String r0 = "com.google.android.gms.games.internal.IGamesService"
                r12.enforceInterface(r0)
                java.lang.String r0 = r12.readString()
                java.lang.String r1 = r12.readString()
                r10.mo6975u((java.lang.String) r0, (java.lang.String) r1)
                r13.writeNoException()
                goto L_0x000a
            L_0x00c5:
                java.lang.String r0 = "com.google.android.gms.games.internal.IGamesService"
                r12.enforceInterface(r0)
                java.lang.String r0 = r10.mo6931jY()
                r13.writeNoException()
                r13.writeString(r0)
                goto L_0x000a
            L_0x00d6:
                java.lang.String r0 = "com.google.android.gms.games.internal.IGamesService"
                r12.enforceInterface(r0)
                com.google.android.gms.common.data.DataHolder r0 = r10.mo6951kw()
                r13.writeNoException()
                if (r0 == 0) goto L_0x00ec
                r13.writeInt(r9)
                r0.writeToParcel(r13, r9)
                goto L_0x000a
            L_0x00ec:
                r13.writeInt(r7)
                goto L_0x000a
            L_0x00f1:
                java.lang.String r0 = "com.google.android.gms.games.internal.IGamesService"
                r12.enforceInterface(r0)
                android.os.IBinder r0 = r12.readStrongBinder()
                com.google.android.gms.games.internal.IGamesCallbacks r0 = com.google.android.gms.games.internal.IGamesCallbacks.Stub.m2620aA(r0)
                java.lang.String r1 = r12.readString()
                r10.mo6814a((com.google.android.gms.games.internal.IGamesCallbacks) r0, (java.lang.String) r1)
                r13.writeNoException()
                goto L_0x000a
            L_0x010a:
                java.lang.String r0 = "com.google.android.gms.games.internal.IGamesService"
                r12.enforceInterface(r0)
                android.os.IBinder r0 = r12.readStrongBinder()
                com.google.android.gms.games.internal.IGamesCallbacks r1 = com.google.android.gms.games.internal.IGamesCallbacks.Stub.m2620aA(r0)
                int r2 = r12.readInt()
                int r0 = r12.readInt()
                if (r0 == 0) goto L_0x0131
                r0 = r9
            L_0x0122:
                int r3 = r12.readInt()
                if (r3 == 0) goto L_0x0129
                r7 = r9
            L_0x0129:
                r10.mo6807a((com.google.android.gms.games.internal.IGamesCallbacks) r1, (int) r2, (boolean) r0, (boolean) r7)
                r13.writeNoException()
                goto L_0x000a
            L_0x0131:
                r0 = r7
                goto L_0x0122
            L_0x0133:
                java.lang.String r0 = "com.google.android.gms.games.internal.IGamesService"
                r12.enforceInterface(r0)
                android.os.IBinder r0 = r12.readStrongBinder()
                com.google.android.gms.games.internal.IGamesCallbacks r0 = com.google.android.gms.games.internal.IGamesCallbacks.Stub.m2620aA(r0)
                java.lang.String r1 = r12.readString()
                long r2 = r12.readLong()
                r10.mo6822a((com.google.android.gms.games.internal.IGamesCallbacks) r0, (java.lang.String) r1, (long) r2)
                r13.writeNoException()
                goto L_0x000a
            L_0x0150:
                java.lang.String r0 = "com.google.android.gms.games.internal.IGamesService"
                r12.enforceInterface(r0)
                android.os.IBinder r0 = r12.readStrongBinder()
                com.google.android.gms.games.internal.IGamesCallbacks r0 = com.google.android.gms.games.internal.IGamesCallbacks.Stub.m2620aA(r0)
                r10.mo6853b((com.google.android.gms.games.internal.IGamesCallbacks) r0)
                r13.writeNoException()
                goto L_0x000a
            L_0x0165:
                java.lang.String r0 = "com.google.android.gms.games.internal.IGamesService"
                r12.enforceInterface(r0)
                android.os.IBinder r0 = r12.readStrongBinder()
                com.google.android.gms.games.internal.IGamesCallbacks r0 = com.google.android.gms.games.internal.IGamesCallbacks.Stub.m2620aA(r0)
                java.lang.String r1 = r12.readString()
                r10.mo6857b((com.google.android.gms.games.internal.IGamesCallbacks) r0, (java.lang.String) r1)
                r13.writeNoException()
                goto L_0x000a
            L_0x017e:
                java.lang.String r0 = "com.google.android.gms.games.internal.IGamesService"
                r12.enforceInterface(r0)
                android.os.IBinder r0 = r12.readStrongBinder()
                com.google.android.gms.games.internal.IGamesCallbacks r1 = com.google.android.gms.games.internal.IGamesCallbacks.Stub.m2620aA(r0)
                java.lang.String r2 = r12.readString()
                int r3 = r12.readInt()
                int r4 = r12.readInt()
                int r5 = r12.readInt()
                int r0 = r12.readInt()
                if (r0 == 0) goto L_0x01ab
                r6 = r9
            L_0x01a2:
                r0 = r10
                r0.mo6816a((com.google.android.gms.games.internal.IGamesCallbacks) r1, (java.lang.String) r2, (int) r3, (int) r4, (int) r5, (boolean) r6)
                r13.writeNoException()
                goto L_0x000a
            L_0x01ab:
                r6 = r7
                goto L_0x01a2
            L_0x01ad:
                java.lang.String r0 = "com.google.android.gms.games.internal.IGamesService"
                r12.enforceInterface(r0)
                android.os.IBinder r0 = r12.readStrongBinder()
                com.google.android.gms.games.internal.IGamesCallbacks r1 = com.google.android.gms.games.internal.IGamesCallbacks.Stub.m2620aA(r0)
                java.lang.String r2 = r12.readString()
                int r3 = r12.readInt()
                int r4 = r12.readInt()
                int r5 = r12.readInt()
                int r0 = r12.readInt()
                if (r0 == 0) goto L_0x01da
                r6 = r9
            L_0x01d1:
                r0 = r10
                r0.mo6859b((com.google.android.gms.games.internal.IGamesCallbacks) r1, (java.lang.String) r2, (int) r3, (int) r4, (int) r5, (boolean) r6)
                r13.writeNoException()
                goto L_0x000a
            L_0x01da:
                r6 = r7
                goto L_0x01d1
            L_0x01dc:
                java.lang.String r0 = "com.google.android.gms.games.internal.IGamesService"
                r12.enforceInterface(r0)
                android.os.IBinder r0 = r12.readStrongBinder()
                com.google.android.gms.games.internal.IGamesCallbacks r1 = com.google.android.gms.games.internal.IGamesCallbacks.Stub.m2620aA(r0)
                int r0 = r12.readInt()
                if (r0 == 0) goto L_0x0207
                android.os.Parcelable$Creator r0 = android.os.Bundle.CREATOR
                java.lang.Object r0 = r0.createFromParcel(r12)
                android.os.Bundle r0 = (android.os.Bundle) r0
            L_0x01f7:
                int r2 = r12.readInt()
                int r3 = r12.readInt()
                r10.mo6811a((com.google.android.gms.games.internal.IGamesCallbacks) r1, (android.os.Bundle) r0, (int) r2, (int) r3)
                r13.writeNoException()
                goto L_0x000a
            L_0x0207:
                r0 = r5
                goto L_0x01f7
            L_0x0209:
                java.lang.String r0 = "com.google.android.gms.games.internal.IGamesService"
                r12.enforceInterface(r0)
                android.os.IBinder r0 = r12.readStrongBinder()
                com.google.android.gms.games.internal.IGamesCallbacks r0 = com.google.android.gms.games.internal.IGamesCallbacks.Stub.m2620aA(r0)
                r10.mo6882c(r0)
                r13.writeNoException()
                goto L_0x000a
            L_0x021e:
                java.lang.String r0 = "com.google.android.gms.games.internal.IGamesService"
                r12.enforceInterface(r0)
                android.os.IBinder r0 = r12.readStrongBinder()
                com.google.android.gms.games.internal.IGamesCallbacks r1 = com.google.android.gms.games.internal.IGamesCallbacks.Stub.m2620aA(r0)
                java.lang.String r2 = r12.readString()
                android.os.IBinder r3 = r12.readStrongBinder()
                int r0 = r12.readInt()
                if (r0 == 0) goto L_0x0249
                android.os.Parcelable$Creator r0 = android.os.Bundle.CREATOR
                java.lang.Object r0 = r0.createFromParcel(r12)
                android.os.Bundle r0 = (android.os.Bundle) r0
            L_0x0241:
                r10.mo6824a((com.google.android.gms.games.internal.IGamesCallbacks) r1, (java.lang.String) r2, (android.os.IBinder) r3, (android.os.Bundle) r0)
                r13.writeNoException()
                goto L_0x000a
            L_0x0249:
                r0 = r5
                goto L_0x0241
            L_0x024b:
                java.lang.String r0 = "com.google.android.gms.games.internal.IGamesService"
                r12.enforceInterface(r0)
                android.os.IBinder r0 = r12.readStrongBinder()
                com.google.android.gms.games.internal.IGamesCallbacks r1 = com.google.android.gms.games.internal.IGamesCallbacks.Stub.m2620aA(r0)
                java.lang.String r2 = r12.readString()
                android.os.IBinder r3 = r12.readStrongBinder()
                int r0 = r12.readInt()
                if (r0 == 0) goto L_0x0276
                android.os.Parcelable$Creator r0 = android.os.Bundle.CREATOR
                java.lang.Object r0 = r0.createFromParcel(r12)
                android.os.Bundle r0 = (android.os.Bundle) r0
            L_0x026e:
                r10.mo6863b((com.google.android.gms.games.internal.IGamesCallbacks) r1, (java.lang.String) r2, (android.os.IBinder) r3, (android.os.Bundle) r0)
                r13.writeNoException()
                goto L_0x000a
            L_0x0276:
                r0 = r5
                goto L_0x026e
            L_0x0278:
                java.lang.String r0 = "com.google.android.gms.games.internal.IGamesService"
                r12.enforceInterface(r0)
                android.os.IBinder r0 = r12.readStrongBinder()
                com.google.android.gms.games.internal.IGamesCallbacks r1 = com.google.android.gms.games.internal.IGamesCallbacks.Stub.m2620aA(r0)
                java.lang.String r2 = r12.readString()
                int r3 = r12.readInt()
                android.os.IBinder r4 = r12.readStrongBinder()
                int r0 = r12.readInt()
                if (r0 == 0) goto L_0x02a0
                android.os.Parcelable$Creator r0 = android.os.Bundle.CREATOR
                java.lang.Object r0 = r0.createFromParcel(r12)
                android.os.Bundle r0 = (android.os.Bundle) r0
                r5 = r0
            L_0x02a0:
                r0 = r10
                r0.mo6817a((com.google.android.gms.games.internal.IGamesCallbacks) r1, (java.lang.String) r2, (int) r3, (android.os.IBinder) r4, (android.os.Bundle) r5)
                r13.writeNoException()
                goto L_0x000a
            L_0x02a9:
                java.lang.String r0 = "com.google.android.gms.games.internal.IGamesService"
                r12.enforceInterface(r0)
                android.os.IBinder r0 = r12.readStrongBinder()
                com.google.android.gms.games.internal.IGamesCallbacks r0 = com.google.android.gms.games.internal.IGamesCallbacks.Stub.m2620aA(r0)
                r10.mo6896d(r0)
                r13.writeNoException()
                goto L_0x000a
            L_0x02be:
                java.lang.String r0 = "com.google.android.gms.games.internal.IGamesService"
                r12.enforceInterface(r0)
                android.os.IBinder r0 = r12.readStrongBinder()
                com.google.android.gms.games.internal.IGamesCallbacks r0 = com.google.android.gms.games.internal.IGamesCallbacks.Stub.m2620aA(r0)
                r10.mo6906e(r0)
                r13.writeNoException()
                goto L_0x000a
            L_0x02d3:
                java.lang.String r0 = "com.google.android.gms.games.internal.IGamesService"
                r12.enforceInterface(r0)
                java.lang.String r0 = r12.readString()
                int r1 = r12.readInt()
                r10.mo6962p((java.lang.String) r0, (int) r1)
                r13.writeNoException()
                goto L_0x000a
            L_0x02e8:
                java.lang.String r0 = "com.google.android.gms.games.internal.IGamesService"
                r12.enforceInterface(r0)
                java.lang.String r0 = r12.readString()
                int r1 = r12.readInt()
                r10.mo6960o((java.lang.String) r0, (int) r1)
                r13.writeNoException()
                goto L_0x000a
            L_0x02fd:
                java.lang.String r0 = "com.google.android.gms.games.internal.IGamesService"
                r12.enforceInterface(r0)
                android.os.IBinder r0 = r12.readStrongBinder()
                com.google.android.gms.games.internal.IGamesCallbacks r0 = com.google.android.gms.games.internal.IGamesCallbacks.Stub.m2620aA(r0)
                long r1 = r12.readLong()
                r10.mo6809a((com.google.android.gms.games.internal.IGamesCallbacks) r0, (long) r1)
                r13.writeNoException()
                goto L_0x000a
            L_0x0316:
                java.lang.String r0 = "com.google.android.gms.games.internal.IGamesService"
                r12.enforceInterface(r0)
                long r0 = r12.readLong()
                r10.mo6965r(r0)
                r13.writeNoException()
                goto L_0x000a
            L_0x0327:
                java.lang.String r0 = "com.google.android.gms.games.internal.IGamesService"
                r12.enforceInterface(r0)
                android.os.IBinder r0 = r12.readStrongBinder()
                com.google.android.gms.games.internal.IGamesCallbacks r1 = com.google.android.gms.games.internal.IGamesCallbacks.Stub.m2620aA(r0)
                android.os.IBinder r2 = r12.readStrongBinder()
                int r3 = r12.readInt()
                java.lang.String[] r4 = r12.createStringArray()
                int r0 = r12.readInt()
                if (r0 == 0) goto L_0x034f
                android.os.Parcelable$Creator r0 = android.os.Bundle.CREATOR
                java.lang.Object r0 = r0.createFromParcel(r12)
                android.os.Bundle r0 = (android.os.Bundle) r0
                r5 = r0
            L_0x034f:
                int r0 = r12.readInt()
                if (r0 == 0) goto L_0x0363
                r6 = r9
            L_0x0356:
                long r7 = r12.readLong()
                r0 = r10
                r0.mo6812a((com.google.android.gms.games.internal.IGamesCallbacks) r1, (android.os.IBinder) r2, (int) r3, (java.lang.String[]) r4, (android.os.Bundle) r5, (boolean) r6, (long) r7)
                r13.writeNoException()
                goto L_0x000a
            L_0x0363:
                r6 = r7
                goto L_0x0356
            L_0x0365:
                java.lang.String r0 = "com.google.android.gms.games.internal.IGamesService"
                r12.enforceInterface(r0)
                android.os.IBinder r0 = r12.readStrongBinder()
                com.google.android.gms.games.internal.IGamesCallbacks r1 = com.google.android.gms.games.internal.IGamesCallbacks.Stub.m2620aA(r0)
                android.os.IBinder r2 = r12.readStrongBinder()
                java.lang.String r3 = r12.readString()
                int r0 = r12.readInt()
                if (r0 == 0) goto L_0x038e
                r4 = r9
            L_0x0381:
                long r5 = r12.readLong()
                r0 = r10
                r0.mo6813a((com.google.android.gms.games.internal.IGamesCallbacks) r1, (android.os.IBinder) r2, (java.lang.String) r3, (boolean) r4, (long) r5)
                r13.writeNoException()
                goto L_0x000a
            L_0x038e:
                r4 = r7
                goto L_0x0381
            L_0x0390:
                java.lang.String r0 = "com.google.android.gms.games.internal.IGamesService"
                r12.enforceInterface(r0)
                android.os.IBinder r0 = r12.readStrongBinder()
                com.google.android.gms.games.internal.IGamesCallbacks r0 = com.google.android.gms.games.internal.IGamesCallbacks.Stub.m2620aA(r0)
                java.lang.String r1 = r12.readString()
                r10.mo6886c((com.google.android.gms.games.internal.IGamesCallbacks) r0, (java.lang.String) r1)
                r13.writeNoException()
                goto L_0x000a
            L_0x03a9:
                java.lang.String r0 = "com.google.android.gms.games.internal.IGamesService"
                r12.enforceInterface(r0)
                android.os.IBinder r0 = r12.readStrongBinder()
                com.google.android.gms.games.internal.IGamesCallbacks r0 = com.google.android.gms.games.internal.IGamesCallbacks.Stub.m2620aA(r0)
                byte[] r1 = r12.createByteArray()
                java.lang.String r2 = r12.readString()
                java.lang.String r3 = r12.readString()
                int r0 = r10.mo6790a((com.google.android.gms.games.internal.IGamesCallbacks) r0, (byte[]) r1, (java.lang.String) r2, (java.lang.String) r3)
                r13.writeNoException()
                r13.writeInt(r0)
                goto L_0x000a
            L_0x03ce:
                java.lang.String r0 = "com.google.android.gms.games.internal.IGamesService"
                r12.enforceInterface(r0)
                byte[] r0 = r12.createByteArray()
                java.lang.String r1 = r12.readString()
                java.lang.String[] r2 = r12.createStringArray()
                int r0 = r10.mo6849b((byte[]) r0, (java.lang.String) r1, (java.lang.String[]) r2)
                r13.writeNoException()
                r13.writeInt(r0)
                goto L_0x000a
            L_0x03eb:
                java.lang.String r0 = "com.google.android.gms.games.internal.IGamesService"
                r12.enforceInterface(r0)
                java.lang.String r0 = r12.readString()
                java.lang.String r0 = r10.mo6873bC(r0)
                r13.writeNoException()
                r13.writeString(r0)
                goto L_0x000a
            L_0x0400:
                java.lang.String r0 = "com.google.android.gms.games.internal.IGamesService"
                r12.enforceInterface(r0)
                int r0 = r12.readInt()
                r10.mo6905dC(r0)
                r13.writeNoException()
                goto L_0x000a
            L_0x0411:
                java.lang.String r0 = "com.google.android.gms.games.internal.IGamesService"
                r12.enforceInterface(r0)
                android.os.IBinder r0 = r12.readStrongBinder()
                com.google.android.gms.games.internal.IGamesCallbacks r0 = com.google.android.gms.games.internal.IGamesCallbacks.Stub.m2620aA(r0)
                java.lang.String r1 = r12.readString()
                r10.mo6900d((com.google.android.gms.games.internal.IGamesCallbacks) r0, (java.lang.String) r1)
                r13.writeNoException()
                goto L_0x000a
            L_0x042a:
                java.lang.String r0 = "com.google.android.gms.games.internal.IGamesService"
                r12.enforceInterface(r0)
                android.os.IBinder r0 = r12.readStrongBinder()
                com.google.android.gms.games.internal.IGamesCallbacks r0 = com.google.android.gms.games.internal.IGamesCallbacks.Stub.m2620aA(r0)
                java.lang.String r1 = r12.readString()
                java.lang.String r2 = r12.readString()
                r10.mo6826a((com.google.android.gms.games.internal.IGamesCallbacks) r0, (java.lang.String) r1, (java.lang.String) r2)
                r13.writeNoException()
                goto L_0x000a
            L_0x0447:
                java.lang.String r0 = "com.google.android.gms.games.internal.IGamesService"
                r12.enforceInterface(r0)
                android.os.IBinder r0 = r12.readStrongBinder()
                com.google.android.gms.games.internal.IGamesCallbacks r1 = com.google.android.gms.games.internal.IGamesCallbacks.Stub.m2620aA(r0)
                java.lang.String r2 = r12.readString()
                java.lang.String r3 = r12.readString()
                int r4 = r12.readInt()
                int r5 = r12.readInt()
                int r6 = r12.readInt()
                int r0 = r12.readInt()
                if (r0 == 0) goto L_0x046f
                r7 = r9
            L_0x046f:
                r0 = r10
                r0.mo6829a((com.google.android.gms.games.internal.IGamesCallbacks) r1, (java.lang.String) r2, (java.lang.String) r3, (int) r4, (int) r5, (int) r6, (boolean) r7)
                r13.writeNoException()
                goto L_0x000a
            L_0x0478:
                java.lang.String r0 = "com.google.android.gms.games.internal.IGamesService"
                r12.enforceInterface(r0)
                android.os.IBinder r0 = r12.readStrongBinder()
                com.google.android.gms.games.internal.IGamesCallbacks r1 = com.google.android.gms.games.internal.IGamesCallbacks.Stub.m2620aA(r0)
                java.lang.String r2 = r12.readString()
                java.lang.String r3 = r12.readString()
                int r4 = r12.readInt()
                int r5 = r12.readInt()
                int r6 = r12.readInt()
                int r0 = r12.readInt()
                if (r0 == 0) goto L_0x04a0
                r7 = r9
            L_0x04a0:
                r0 = r10
                r0.mo6865b(r1, r2, r3, r4, r5, r6, r7)
                r13.writeNoException()
                goto L_0x000a
            L_0x04a9:
                java.lang.String r0 = "com.google.android.gms.games.internal.IGamesService"
                r12.enforceInterface(r0)
                android.os.IBinder r0 = r12.readStrongBinder()
                com.google.android.gms.games.internal.IGamesCallbacks r0 = com.google.android.gms.games.internal.IGamesCallbacks.Stub.m2620aA(r0)
                java.lang.String r1 = r12.readString()
                java.lang.String r2 = r12.readString()
                r10.mo6864b((com.google.android.gms.games.internal.IGamesCallbacks) r0, (java.lang.String) r1, (java.lang.String) r2)
                r13.writeNoException()
                goto L_0x000a
            L_0x04c6:
                java.lang.String r0 = "com.google.android.gms.games.internal.IGamesService"
                r12.enforceInterface(r0)
                android.os.IBinder r0 = r12.readStrongBinder()
                com.google.android.gms.games.internal.IGamesCallbacks r0 = com.google.android.gms.games.internal.IGamesCallbacks.Stub.m2620aA(r0)
                java.lang.String r1 = r12.readString()
                r10.mo6908e((com.google.android.gms.games.internal.IGamesCallbacks) r0, (java.lang.String) r1)
                r13.writeNoException()
                goto L_0x000a
            L_0x04df:
                java.lang.String r0 = "com.google.android.gms.games.internal.IGamesService"
                r12.enforceInterface(r0)
                android.os.IBinder r0 = r12.readStrongBinder()
                com.google.android.gms.games.internal.IGamesCallbacks r0 = com.google.android.gms.games.internal.IGamesCallbacks.Stub.m2620aA(r0)
                java.lang.String r1 = r12.readString()
                r10.mo6914f((com.google.android.gms.games.internal.IGamesCallbacks) r0, (java.lang.String) r1)
                r13.writeNoException()
                goto L_0x000a
            L_0x04f8:
                java.lang.String r0 = "com.google.android.gms.games.internal.IGamesService"
                r12.enforceInterface(r0)
                android.os.IBinder r0 = r12.readStrongBinder()
                com.google.android.gms.games.internal.IGamesCallbacks r1 = com.google.android.gms.games.internal.IGamesCallbacks.Stub.m2620aA(r0)
                int r2 = r12.readInt()
                int r3 = r12.readInt()
                int r0 = r12.readInt()
                if (r0 == 0) goto L_0x0524
                r4 = r9
            L_0x0514:
                int r0 = r12.readInt()
                if (r0 == 0) goto L_0x0526
                r5 = r9
            L_0x051b:
                r0 = r10
                r0.mo6805a((com.google.android.gms.games.internal.IGamesCallbacks) r1, (int) r2, (int) r3, (boolean) r4, (boolean) r5)
                r13.writeNoException()
                goto L_0x000a
            L_0x0524:
                r4 = r7
                goto L_0x0514
            L_0x0526:
                r5 = r7
                goto L_0x051b
            L_0x0528:
                java.lang.String r0 = "com.google.android.gms.games.internal.IGamesService"
                r12.enforceInterface(r0)
                android.os.IBinder r0 = r12.readStrongBinder()
                com.google.android.gms.games.internal.IGamesCallbacks r1 = com.google.android.gms.games.internal.IGamesCallbacks.Stub.m2620aA(r0)
                java.lang.String r2 = r12.readString()
                int r3 = r12.readInt()
                int r0 = r12.readInt()
                if (r0 == 0) goto L_0x0554
                r4 = r9
            L_0x0544:
                int r0 = r12.readInt()
                if (r0 == 0) goto L_0x0556
                r5 = r9
            L_0x054b:
                r0 = r10
                r0.mo6819a((com.google.android.gms.games.internal.IGamesCallbacks) r1, (java.lang.String) r2, (int) r3, (boolean) r4, (boolean) r5)
                r13.writeNoException()
                goto L_0x000a
            L_0x0554:
                r4 = r7
                goto L_0x0544
            L_0x0556:
                r5 = r7
                goto L_0x054b
            L_0x0558:
                java.lang.String r0 = "com.google.android.gms.games.internal.IGamesService"
                r12.enforceInterface(r0)
                android.os.IBinder r0 = r12.readStrongBinder()
                com.google.android.gms.games.internal.IGamesCallbacks r1 = com.google.android.gms.games.internal.IGamesCallbacks.Stub.m2620aA(r0)
                int r2 = r12.readInt()
                int r0 = r12.readInt()
                if (r0 == 0) goto L_0x057f
                r0 = r9
            L_0x0570:
                int r3 = r12.readInt()
                if (r3 == 0) goto L_0x0577
                r7 = r9
            L_0x0577:
                r10.mo6854b((com.google.android.gms.games.internal.IGamesCallbacks) r1, (int) r2, (boolean) r0, (boolean) r7)
                r13.writeNoException()
                goto L_0x000a
            L_0x057f:
                r0 = r7
                goto L_0x0570
            L_0x0581:
                java.lang.String r0 = "com.google.android.gms.games.internal.IGamesService"
                r12.enforceInterface(r0)
                android.os.IBinder r0 = r12.readStrongBinder()
                com.google.android.gms.games.internal.IGamesCallbacks r0 = com.google.android.gms.games.internal.IGamesCallbacks.Stub.m2620aA(r0)
                r10.mo6913f(r0)
                r13.writeNoException()
                goto L_0x000a
            L_0x0596:
                java.lang.String r0 = "com.google.android.gms.games.internal.IGamesService"
                r12.enforceInterface(r0)
                android.os.IBinder r0 = r12.readStrongBinder()
                com.google.android.gms.games.internal.IGamesCallbacks r1 = com.google.android.gms.games.internal.IGamesCallbacks.Stub.m2620aA(r0)
                int r2 = r12.readInt()
                int r0 = r12.readInt()
                if (r0 == 0) goto L_0x05bd
                r0 = r9
            L_0x05ae:
                int r3 = r12.readInt()
                if (r3 == 0) goto L_0x05b5
                r7 = r9
            L_0x05b5:
                r10.mo6883c((com.google.android.gms.games.internal.IGamesCallbacks) r1, (int) r2, (boolean) r0, (boolean) r7)
                r13.writeNoException()
                goto L_0x000a
            L_0x05bd:
                r0 = r7
                goto L_0x05ae
            L_0x05bf:
                java.lang.String r0 = "com.google.android.gms.games.internal.IGamesService"
                r12.enforceInterface(r0)
                android.os.IBinder r0 = r12.readStrongBinder()
                com.google.android.gms.games.internal.IGamesCallbacks r0 = com.google.android.gms.games.internal.IGamesCallbacks.Stub.m2620aA(r0)
                r10.mo6919g(r0)
                r13.writeNoException()
                goto L_0x000a
            L_0x05d4:
                java.lang.String r0 = "com.google.android.gms.games.internal.IGamesService"
                r12.enforceInterface(r0)
                java.lang.String r0 = r12.readString()
                r10.mo6874bD(r0)
                r13.writeNoException()
                goto L_0x000a
            L_0x05e5:
                java.lang.String r0 = "com.google.android.gms.games.internal.IGamesService"
                r12.enforceInterface(r0)
                java.lang.String r0 = r12.readString()
                java.lang.String r1 = r12.readString()
                int r2 = r12.readInt()
                r10.mo6871b((java.lang.String) r0, (java.lang.String) r1, (int) r2)
                r13.writeNoException()
                goto L_0x000a
            L_0x05fe:
                java.lang.String r0 = "com.google.android.gms.games.internal.IGamesService"
                r12.enforceInterface(r0)
                android.os.IBinder r0 = r12.readStrongBinder()
                com.google.android.gms.games.internal.IGamesCallbacks r0 = com.google.android.gms.games.internal.IGamesCallbacks.Stub.m2620aA(r0)
                java.lang.String r1 = r12.readString()
                r10.mo6920g((com.google.android.gms.games.internal.IGamesCallbacks) r0, (java.lang.String) r1)
                r13.writeNoException()
                goto L_0x000a
            L_0x0617:
                java.lang.String r0 = "com.google.android.gms.games.internal.IGamesService"
                r12.enforceInterface(r0)
                android.os.IBinder r0 = r12.readStrongBinder()
                com.google.android.gms.games.internal.IGamesCallbacks r0 = com.google.android.gms.games.internal.IGamesCallbacks.Stub.m2620aA(r0)
                java.lang.String r1 = r12.readString()
                com.google.android.gms.games.multiplayer.realtime.RoomEntity r0 = r10.mo6923h((com.google.android.gms.games.internal.IGamesCallbacks) r0, (java.lang.String) r1)
                r13.writeNoException()
                if (r0 == 0) goto L_0x0639
                r13.writeInt(r9)
                r0.writeToParcel(r13, r9)
                goto L_0x000a
            L_0x0639:
                r13.writeInt(r7)
                goto L_0x000a
            L_0x063e:
                java.lang.String r0 = "com.google.android.gms.games.internal.IGamesService"
                r12.enforceInterface(r0)
                java.lang.String r0 = r12.readString()
                int r0 = r10.mo6875bE(r0)
                r13.writeNoException()
                r13.writeInt(r0)
                goto L_0x000a
            L_0x0653:
                java.lang.String r0 = "com.google.android.gms.games.internal.IGamesService"
                r12.enforceInterface(r0)
                android.os.IBinder r0 = r12.readStrongBinder()
                com.google.android.gms.games.internal.IGamesCallbacks r0 = com.google.android.gms.games.internal.IGamesCallbacks.Stub.m2620aA(r0)
                java.lang.String r1 = r12.readString()
                int r2 = r12.readInt()
                if (r2 == 0) goto L_0x066b
                r7 = r9
            L_0x066b:
                r10.mo6836a((com.google.android.gms.games.internal.IGamesCallbacks) r0, (java.lang.String) r1, (boolean) r7)
                r13.writeNoException()
                goto L_0x000a
            L_0x0673:
                java.lang.String r0 = "com.google.android.gms.games.internal.IGamesService"
                r12.enforceInterface(r0)
                android.os.IBinder r0 = r12.readStrongBinder()
                com.google.android.gms.games.internal.IGamesCallbacks r0 = com.google.android.gms.games.internal.IGamesCallbacks.Stub.m2620aA(r0)
                java.lang.String r1 = r12.readString()
                r10.mo6927i(r0, r1)
                r13.writeNoException()
                goto L_0x000a
            L_0x068c:
                java.lang.String r0 = "com.google.android.gms.games.internal.IGamesService"
                r12.enforceInterface(r0)
                java.lang.String r0 = r12.readString()
                int r1 = r12.readInt()
                r10.mo6967r((java.lang.String) r0, (int) r1)
                r13.writeNoException()
                goto L_0x000a
            L_0x06a1:
                java.lang.String r0 = "com.google.android.gms.games.internal.IGamesService"
                r12.enforceInterface(r0)
                boolean r0 = r10.mo6952kx()
                r13.writeNoException()
                if (r0 == 0) goto L_0x06b0
                r7 = r9
            L_0x06b0:
                r13.writeInt(r7)
                goto L_0x000a
            L_0x06b5:
                java.lang.String r0 = "com.google.android.gms.games.internal.IGamesService"
                r12.enforceInterface(r0)
                int r0 = r12.readInt()
                if (r0 == 0) goto L_0x06c1
                r7 = r9
            L_0x06c1:
                r10.mo6787N(r7)
                r13.writeNoException()
                goto L_0x000a
            L_0x06c9:
                java.lang.String r0 = "com.google.android.gms.games.internal.IGamesService"
                r12.enforceInterface(r0)
                android.os.IBinder r0 = r12.readStrongBinder()
                com.google.android.gms.games.internal.IGamesCallbacks r0 = com.google.android.gms.games.internal.IGamesCallbacks.Stub.m2620aA(r0)
                r10.mo6924h((com.google.android.gms.games.internal.IGamesCallbacks) r0)
                r13.writeNoException()
                goto L_0x000a
            L_0x06de:
                java.lang.String r0 = "com.google.android.gms.games.internal.IGamesService"
                r12.enforceInterface(r0)
                android.os.IBinder r0 = r12.readStrongBinder()
                com.google.android.gms.games.internal.IGamesCallbacks r0 = com.google.android.gms.games.internal.IGamesCallbacks.Stub.m2620aA(r0)
                java.lang.String r1 = r12.readString()
                r10.mo6929j(r0, r1)
                r13.writeNoException()
                goto L_0x000a
            L_0x06f7:
                java.lang.String r0 = "com.google.android.gms.games.internal.IGamesService"
                r12.enforceInterface(r0)
                android.os.IBinder r0 = r12.readStrongBinder()
                com.google.android.gms.games.internal.IGamesCallbacks r0 = com.google.android.gms.games.internal.IGamesCallbacks.Stub.m2620aA(r0)
                r10.mo6926i(r0)
                r13.writeNoException()
                goto L_0x000a
            L_0x070c:
                java.lang.String r0 = "com.google.android.gms.games.internal.IGamesService"
                r12.enforceInterface(r0)
                android.os.IBinder r0 = r12.readStrongBinder()
                com.google.android.gms.games.internal.IGamesCallbacks r1 = com.google.android.gms.games.internal.IGamesCallbacks.Stub.m2620aA(r0)
                int r0 = r12.readInt()
                if (r0 == 0) goto L_0x0720
                r7 = r9
            L_0x0720:
                int r0 = r12.readInt()
                if (r0 == 0) goto L_0x0736
                android.os.Parcelable$Creator r0 = android.os.Bundle.CREATOR
                java.lang.Object r0 = r0.createFromParcel(r12)
                android.os.Bundle r0 = (android.os.Bundle) r0
            L_0x072e:
                r10.mo6842a((com.google.android.gms.games.internal.IGamesCallbacks) r1, (boolean) r7, (android.os.Bundle) r0)
                r13.writeNoException()
                goto L_0x000a
            L_0x0736:
                r0 = r5
                goto L_0x072e
            L_0x0738:
                java.lang.String r0 = "com.google.android.gms.games.internal.IGamesService"
                r12.enforceInterface(r0)
                java.lang.String r0 = r12.readString()
                android.net.Uri r0 = r10.mo6876bF(r0)
                r13.writeNoException()
                if (r0 == 0) goto L_0x0752
                r13.writeInt(r9)
                r0.writeToParcel(r13, r9)
                goto L_0x000a
            L_0x0752:
                r13.writeInt(r7)
                goto L_0x000a
            L_0x0757:
                java.lang.String r0 = "com.google.android.gms.games.internal.IGamesService"
                r12.enforceInterface(r0)
                android.os.IBinder r0 = r12.readStrongBinder()
                com.google.android.gms.games.internal.IGamesCallbacks r1 = com.google.android.gms.games.internal.IGamesCallbacks.Stub.m2620aA(r0)
                java.lang.String r2 = r12.readString()
                int r3 = r12.readInt()
                int r0 = r12.readInt()
                if (r0 == 0) goto L_0x0783
                r4 = r9
            L_0x0773:
                int r0 = r12.readInt()
                if (r0 == 0) goto L_0x0785
                r5 = r9
            L_0x077a:
                r0 = r10
                r0.mo6862b((com.google.android.gms.games.internal.IGamesCallbacks) r1, (java.lang.String) r2, (int) r3, (boolean) r4, (boolean) r5)
                r13.writeNoException()
                goto L_0x000a
            L_0x0783:
                r4 = r7
                goto L_0x0773
            L_0x0785:
                r5 = r7
                goto L_0x077a
            L_0x0787:
                java.lang.String r0 = "com.google.android.gms.games.internal.IGamesService"
                r12.enforceInterface(r0)
                com.google.android.gms.common.data.DataHolder r0 = r10.mo6953ky()
                r13.writeNoException()
                if (r0 == 0) goto L_0x079d
                r13.writeInt(r9)
                r0.writeToParcel(r13, r9)
                goto L_0x000a
            L_0x079d:
                r13.writeInt(r7)
                goto L_0x000a
            L_0x07a2:
                java.lang.String r0 = "com.google.android.gms.games.internal.IGamesService"
                r12.enforceInterface(r0)
                android.os.IBinder r0 = r12.readStrongBinder()
                com.google.android.gms.games.internal.IGamesCallbacks r0 = com.google.android.gms.games.internal.IGamesCallbacks.Stub.m2620aA(r0)
                int r1 = r12.readInt()
                if (r1 == 0) goto L_0x07b6
                r7 = r9
            L_0x07b6:
                r10.mo6841a((com.google.android.gms.games.internal.IGamesCallbacks) r0, (boolean) r7)
                r13.writeNoException()
                goto L_0x000a
            L_0x07be:
                java.lang.String r0 = "com.google.android.gms.games.internal.IGamesService"
                r12.enforceInterface(r0)
                android.os.IBinder r0 = r12.readStrongBinder()
                com.google.android.gms.games.internal.IGamesCallbacks r0 = com.google.android.gms.games.internal.IGamesCallbacks.Stub.m2620aA(r0)
                java.lang.String r1 = r12.readString()
                java.lang.String r2 = r12.readString()
                int r3 = r12.readInt()
                if (r3 == 0) goto L_0x07da
                r7 = r9
            L_0x07da:
                r10.mo6832a((com.google.android.gms.games.internal.IGamesCallbacks) r0, (java.lang.String) r1, (java.lang.String) r2, (boolean) r7)
                r13.writeNoException()
                goto L_0x000a
            L_0x07e2:
                java.lang.String r0 = "com.google.android.gms.games.internal.IGamesService"
                r12.enforceInterface(r0)
                android.os.IBinder r0 = r12.readStrongBinder()
                com.google.android.gms.games.internal.IGamesCallbacks r1 = com.google.android.gms.games.internal.IGamesCallbacks.Stub.m2620aA(r0)
                int r2 = r12.readInt()
                int r0 = r12.readInt()
                if (r0 == 0) goto L_0x0809
                r0 = r9
            L_0x07fa:
                int r3 = r12.readInt()
                if (r3 == 0) goto L_0x0801
                r7 = r9
            L_0x0801:
                r10.mo6897d(r1, r2, r0, r7)
                r13.writeNoException()
                goto L_0x000a
            L_0x0809:
                r0 = r7
                goto L_0x07fa
            L_0x080b:
                java.lang.String r0 = "com.google.android.gms.games.internal.IGamesService"
                r12.enforceInterface(r0)
                android.os.IBinder r0 = r12.readStrongBinder()
                com.google.android.gms.games.internal.IGamesCallbacks r1 = com.google.android.gms.games.internal.IGamesCallbacks.Stub.m2620aA(r0)
                int r2 = r12.readInt()
                int r0 = r12.readInt()
                if (r0 == 0) goto L_0x0832
                r0 = r9
            L_0x0823:
                int r3 = r12.readInt()
                if (r3 == 0) goto L_0x082a
                r7 = r9
            L_0x082a:
                r10.mo6907e(r1, r2, r0, r7)
                r13.writeNoException()
                goto L_0x000a
            L_0x0832:
                r0 = r7
                goto L_0x0823
            L_0x0834:
                java.lang.String r0 = "com.google.android.gms.games.internal.IGamesService"
                r12.enforceInterface(r0)
                android.os.IBinder r0 = r12.readStrongBinder()
                com.google.android.gms.games.internal.IGamesCallbacks r1 = com.google.android.gms.games.internal.IGamesCallbacks.Stub.m2620aA(r0)
                java.lang.String r2 = r12.readString()
                int r3 = r12.readInt()
                int r0 = r12.readInt()
                if (r0 == 0) goto L_0x086e
                r4 = r9
            L_0x0850:
                int r0 = r12.readInt()
                if (r0 == 0) goto L_0x0870
                r5 = r9
            L_0x0857:
                int r0 = r12.readInt()
                if (r0 == 0) goto L_0x0872
                r6 = r9
            L_0x085e:
                int r0 = r12.readInt()
                if (r0 == 0) goto L_0x0865
                r7 = r9
            L_0x0865:
                r0 = r10
                r0.mo6820a((com.google.android.gms.games.internal.IGamesCallbacks) r1, (java.lang.String) r2, (int) r3, (boolean) r4, (boolean) r5, (boolean) r6, (boolean) r7)
                r13.writeNoException()
                goto L_0x000a
            L_0x086e:
                r4 = r7
                goto L_0x0850
            L_0x0870:
                r5 = r7
                goto L_0x0857
            L_0x0872:
                r6 = r7
                goto L_0x085e
            L_0x0874:
                java.lang.String r0 = "com.google.android.gms.games.internal.IGamesService"
                r12.enforceInterface(r0)
                android.os.IBinder r0 = r12.readStrongBinder()
                com.google.android.gms.games.internal.IGamesCallbacks r0 = com.google.android.gms.games.internal.IGamesCallbacks.Stub.m2620aA(r0)
                java.lang.String r1 = r12.readString()
                int r2 = r12.readInt()
                if (r2 == 0) goto L_0x088c
                r7 = r9
            L_0x088c:
                r10.mo6868b((com.google.android.gms.games.internal.IGamesCallbacks) r0, (java.lang.String) r1, (boolean) r7)
                r13.writeNoException()
                goto L_0x000a
            L_0x0894:
                java.lang.String r0 = "com.google.android.gms.games.internal.IGamesService"
                r12.enforceInterface(r0)
                android.os.IBinder r0 = r12.readStrongBinder()
                com.google.android.gms.games.internal.IGamesCallbacks r0 = com.google.android.gms.games.internal.IGamesCallbacks.Stub.m2620aA(r0)
                int r1 = r12.readInt()
                if (r1 == 0) goto L_0x08a8
                r7 = r9
            L_0x08a8:
                r10.mo6869b((com.google.android.gms.games.internal.IGamesCallbacks) r0, (boolean) r7)
                r13.writeNoException()
                goto L_0x000a
            L_0x08b0:
                java.lang.String r0 = "com.google.android.gms.games.internal.IGamesService"
                r12.enforceInterface(r0)
                android.os.IBinder r0 = r12.readStrongBinder()
                com.google.android.gms.games.internal.IGamesCallbacks r0 = com.google.android.gms.games.internal.IGamesCallbacks.Stub.m2620aA(r0)
                java.lang.String r1 = r12.readString()
                int r2 = r12.readInt()
                if (r2 == 0) goto L_0x08c8
                r7 = r9
            L_0x08c8:
                r10.mo6891c((com.google.android.gms.games.internal.IGamesCallbacks) r0, (java.lang.String) r1, (boolean) r7)
                r13.writeNoException()
                goto L_0x000a
            L_0x08d0:
                java.lang.String r0 = "com.google.android.gms.games.internal.IGamesService"
                r12.enforceInterface(r0)
                android.os.IBinder r0 = r12.readStrongBinder()
                com.google.android.gms.games.internal.IGamesCallbacks r0 = com.google.android.gms.games.internal.IGamesCallbacks.Stub.m2620aA(r0)
                java.lang.String r1 = r12.readString()
                int r2 = r12.readInt()
                if (r2 == 0) goto L_0x08e8
                r7 = r9
            L_0x08e8:
                r10.mo6903d((com.google.android.gms.games.internal.IGamesCallbacks) r0, (java.lang.String) r1, (boolean) r7)
                r13.writeNoException()
                goto L_0x000a
            L_0x08f0:
                java.lang.String r0 = "com.google.android.gms.games.internal.IGamesService"
                r12.enforceInterface(r0)
                android.os.IBinder r0 = r12.readStrongBinder()
                com.google.android.gms.games.internal.IGamesCallbacks r0 = com.google.android.gms.games.internal.IGamesCallbacks.Stub.m2620aA(r0)
                java.lang.String r1 = r12.readString()
                java.lang.String r2 = r12.readString()
                int r3 = r12.readInt()
                if (r3 == 0) goto L_0x090c
                r7 = r9
            L_0x090c:
                r10.mo6867b((com.google.android.gms.games.internal.IGamesCallbacks) r0, (java.lang.String) r1, (java.lang.String) r2, (boolean) r7)
                r13.writeNoException()
                goto L_0x000a
            L_0x0914:
                java.lang.String r0 = "com.google.android.gms.games.internal.IGamesService"
                r12.enforceInterface(r0)
                int r0 = r12.readInt()
                if (r0 == 0) goto L_0x0938
                android.os.Parcelable$Creator r0 = android.net.Uri.CREATOR
                java.lang.Object r0 = r0.createFromParcel(r12)
                android.net.Uri r0 = (android.net.Uri) r0
            L_0x0927:
                android.os.ParcelFileDescriptor r0 = r10.mo6922h((android.net.Uri) r0)
                r13.writeNoException()
                if (r0 == 0) goto L_0x093a
                r13.writeInt(r9)
                r0.writeToParcel(r13, r9)
                goto L_0x000a
            L_0x0938:
                r0 = r5
                goto L_0x0927
            L_0x093a:
                r13.writeInt(r7)
                goto L_0x000a
            L_0x093f:
                java.lang.String r0 = "com.google.android.gms.games.internal.IGamesService"
                r12.enforceInterface(r0)
                android.os.IBinder r0 = r12.readStrongBinder()
                com.google.android.gms.games.internal.IGamesCallbacks r0 = com.google.android.gms.games.internal.IGamesCallbacks.Stub.m2620aA(r0)
                java.lang.String r1 = r12.readString()
                r10.mo6932k(r0, r1)
                r13.writeNoException()
                goto L_0x000a
            L_0x0958:
                java.lang.String r0 = "com.google.android.gms.games.internal.IGamesService"
                r12.enforceInterface(r0)
                android.os.IBinder r0 = r12.readStrongBinder()
                com.google.android.gms.games.internal.IGamesCallbacks r1 = com.google.android.gms.games.internal.IGamesCallbacks.Stub.m2620aA(r0)
                java.lang.String r2 = r12.readString()
                long r3 = r12.readLong()
                java.lang.String r5 = r12.readString()
                r0 = r10
                r0.mo6823a((com.google.android.gms.games.internal.IGamesCallbacks) r1, (java.lang.String) r2, (long) r3, (java.lang.String) r5)
                r13.writeNoException()
                goto L_0x000a
            L_0x097a:
                java.lang.String r0 = "com.google.android.gms.games.internal.IGamesService"
                r12.enforceInterface(r0)
                android.os.IBinder r0 = r12.readStrongBinder()
                com.google.android.gms.games.internal.IGamesCallbacks r1 = com.google.android.gms.games.internal.IGamesCallbacks.Stub.m2620aA(r0)
                java.lang.String r2 = r12.readString()
                int r3 = r12.readInt()
                android.os.IBinder r4 = r12.readStrongBinder()
                int r0 = r12.readInt()
                if (r0 == 0) goto L_0x09a2
                android.os.Parcelable$Creator r0 = android.os.Bundle.CREATOR
                java.lang.Object r0 = r0.createFromParcel(r12)
                android.os.Bundle r0 = (android.os.Bundle) r0
                r5 = r0
            L_0x09a2:
                r0 = r10
                r0.mo6860b((com.google.android.gms.games.internal.IGamesCallbacks) r1, (java.lang.String) r2, (int) r3, (android.os.IBinder) r4, (android.os.Bundle) r5)
                r13.writeNoException()
                goto L_0x000a
            L_0x09ab:
                java.lang.String r0 = "com.google.android.gms.games.internal.IGamesService"
                r12.enforceInterface(r0)
                android.os.IBinder r0 = r12.readStrongBinder()
                com.google.android.gms.games.internal.IGamesCallbacks r1 = com.google.android.gms.games.internal.IGamesCallbacks.Stub.m2620aA(r0)
                java.lang.String r2 = r12.readString()
                java.lang.String r3 = r12.readString()
                int r4 = r12.readInt()
                int r5 = r12.readInt()
                r0 = r10
                r0.mo6827a((com.google.android.gms.games.internal.IGamesCallbacks) r1, (java.lang.String) r2, (java.lang.String) r3, (int) r4, (int) r5)
                r13.writeNoException()
                goto L_0x000a
            L_0x09d1:
                java.lang.String r0 = "com.google.android.gms.games.internal.IGamesService"
                r12.enforceInterface(r0)
                java.lang.String r0 = r12.readString()
                r10.mo6877bG(r0)
                r13.writeNoException()
                goto L_0x000a
            L_0x09e2:
                java.lang.String r0 = "com.google.android.gms.games.internal.IGamesService"
                r12.enforceInterface(r0)
                android.os.IBinder r0 = r12.readStrongBinder()
                com.google.android.gms.games.internal.IGamesCallbacks r0 = com.google.android.gms.games.internal.IGamesCallbacks.Stub.m2620aA(r0)
                int[] r1 = r12.createIntArray()
                r10.mo6844a((com.google.android.gms.games.internal.IGamesCallbacks) r0, (int[]) r1)
                r13.writeNoException()
                goto L_0x000a
            L_0x09fb:
                java.lang.String r0 = "com.google.android.gms.games.internal.IGamesService"
                r12.enforceInterface(r0)
                android.os.IBinder r0 = r12.readStrongBinder()
                com.google.android.gms.games.internal.IGamesCallbacks r1 = com.google.android.gms.games.internal.IGamesCallbacks.Stub.m2620aA(r0)
                int r2 = r12.readInt()
                int r3 = r12.readInt()
                java.lang.String[] r4 = r12.createStringArray()
                int r0 = r12.readInt()
                if (r0 == 0) goto L_0x0a23
                android.os.Parcelable$Creator r0 = android.os.Bundle.CREATOR
                java.lang.Object r0 = r0.createFromParcel(r12)
                android.os.Bundle r0 = (android.os.Bundle) r0
                r5 = r0
            L_0x0a23:
                r0 = r10
                r0.mo6806a((com.google.android.gms.games.internal.IGamesCallbacks) r1, (int) r2, (int) r3, (java.lang.String[]) r4, (android.os.Bundle) r5)
                r13.writeNoException()
                goto L_0x000a
            L_0x0a2c:
                java.lang.String r0 = "com.google.android.gms.games.internal.IGamesService"
                r12.enforceInterface(r0)
                android.os.IBinder r0 = r12.readStrongBinder()
                com.google.android.gms.games.internal.IGamesCallbacks r0 = com.google.android.gms.games.internal.IGamesCallbacks.Stub.m2620aA(r0)
                java.lang.String r1 = r12.readString()
                r10.mo6955l(r0, r1)
                r13.writeNoException()
                goto L_0x000a
            L_0x0a45:
                java.lang.String r0 = "com.google.android.gms.games.internal.IGamesService"
                r12.enforceInterface(r0)
                android.os.IBinder r0 = r12.readStrongBinder()
                com.google.android.gms.games.internal.IGamesCallbacks r0 = com.google.android.gms.games.internal.IGamesCallbacks.Stub.m2620aA(r0)
                java.lang.String r1 = r12.readString()
                r10.mo6956m(r0, r1)
                r13.writeNoException()
                goto L_0x000a
            L_0x0a5e:
                java.lang.String r0 = "com.google.android.gms.games.internal.IGamesService"
                r12.enforceInterface(r0)
                android.os.IBinder r0 = r12.readStrongBinder()
                com.google.android.gms.games.internal.IGamesCallbacks r1 = com.google.android.gms.games.internal.IGamesCallbacks.Stub.m2620aA(r0)
                java.lang.String r2 = r12.readString()
                byte[] r3 = r12.createByteArray()
                java.lang.String r4 = r12.readString()
                com.google.android.gms.games.multiplayer.ParticipantResultCreator r0 = com.google.android.gms.games.multiplayer.ParticipantResult.CREATOR
                java.lang.Object[] r5 = r12.createTypedArray(r0)
                com.google.android.gms.games.multiplayer.ParticipantResult[] r5 = (com.google.android.gms.games.multiplayer.ParticipantResult[]) r5
                r0 = r10
                r0.mo6837a((com.google.android.gms.games.internal.IGamesCallbacks) r1, (java.lang.String) r2, (byte[]) r3, (java.lang.String) r4, (com.google.android.gms.games.multiplayer.ParticipantResult[]) r5)
                r13.writeNoException()
                goto L_0x000a
            L_0x0a88:
                java.lang.String r0 = "com.google.android.gms.games.internal.IGamesService"
                r12.enforceInterface(r0)
                android.os.IBinder r0 = r12.readStrongBinder()
                com.google.android.gms.games.internal.IGamesCallbacks r1 = com.google.android.gms.games.internal.IGamesCallbacks.Stub.m2620aA(r0)
                java.lang.String r2 = r12.readString()
                byte[] r3 = r12.createByteArray()
                com.google.android.gms.games.multiplayer.ParticipantResultCreator r0 = com.google.android.gms.games.multiplayer.ParticipantResult.CREATOR
                java.lang.Object[] r0 = r12.createTypedArray(r0)
                com.google.android.gms.games.multiplayer.ParticipantResult[] r0 = (com.google.android.gms.games.multiplayer.ParticipantResult[]) r0
                r10.mo6838a((com.google.android.gms.games.internal.IGamesCallbacks) r1, (java.lang.String) r2, (byte[]) r3, (com.google.android.gms.games.multiplayer.ParticipantResult[]) r0)
                r13.writeNoException()
                goto L_0x000a
            L_0x0aad:
                java.lang.String r0 = "com.google.android.gms.games.internal.IGamesService"
                r12.enforceInterface(r0)
                android.os.IBinder r0 = r12.readStrongBinder()
                com.google.android.gms.games.internal.IGamesCallbacks r0 = com.google.android.gms.games.internal.IGamesCallbacks.Stub.m2620aA(r0)
                java.lang.String r1 = r12.readString()
                r10.mo6957n((com.google.android.gms.games.internal.IGamesCallbacks) r0, (java.lang.String) r1)
                r13.writeNoException()
                goto L_0x000a
            L_0x0ac6:
                java.lang.String r0 = "com.google.android.gms.games.internal.IGamesService"
                r12.enforceInterface(r0)
                android.os.IBinder r0 = r12.readStrongBinder()
                com.google.android.gms.games.internal.IGamesCallbacks r0 = com.google.android.gms.games.internal.IGamesCallbacks.Stub.m2620aA(r0)
                java.lang.String r1 = r12.readString()
                r10.mo6959o((com.google.android.gms.games.internal.IGamesCallbacks) r0, (java.lang.String) r1)
                r13.writeNoException()
                goto L_0x000a
            L_0x0adf:
                java.lang.String r0 = "com.google.android.gms.games.internal.IGamesService"
                r12.enforceInterface(r0)
                android.os.IBinder r0 = r12.readStrongBinder()
                com.google.android.gms.games.internal.IGamesCallbacks r0 = com.google.android.gms.games.internal.IGamesCallbacks.Stub.m2620aA(r0)
                java.lang.String r1 = r12.readString()
                java.lang.String r2 = r12.readString()
                r10.mo6889c((com.google.android.gms.games.internal.IGamesCallbacks) r0, (java.lang.String) r1, (java.lang.String) r2)
                r13.writeNoException()
                goto L_0x000a
            L_0x0afc:
                java.lang.String r0 = "com.google.android.gms.games.internal.IGamesService"
                r12.enforceInterface(r0)
                android.os.IBinder r0 = r12.readStrongBinder()
                com.google.android.gms.games.internal.IGamesCallbacks r0 = com.google.android.gms.games.internal.IGamesCallbacks.Stub.m2620aA(r0)
                long r1 = r12.readLong()
                r10.mo6855b((com.google.android.gms.games.internal.IGamesCallbacks) r0, (long) r1)
                r13.writeNoException()
                goto L_0x000a
            L_0x0b15:
                java.lang.String r0 = "com.google.android.gms.games.internal.IGamesService"
                r12.enforceInterface(r0)
                long r0 = r12.readLong()
                r10.mo6968s(r0)
                r13.writeNoException()
                goto L_0x000a
            L_0x0b26:
                java.lang.String r0 = "com.google.android.gms.games.internal.IGamesService"
                r12.enforceInterface(r0)
                android.os.IBinder r0 = r12.readStrongBinder()
                com.google.android.gms.games.internal.IGamesCallbacks r0 = com.google.android.gms.games.internal.IGamesCallbacks.Stub.m2620aA(r0)
                java.lang.String r1 = r12.readString()
                r10.mo6961p((com.google.android.gms.games.internal.IGamesCallbacks) r0, (java.lang.String) r1)
                r13.writeNoException()
                goto L_0x000a
            L_0x0b3f:
                java.lang.String r0 = "com.google.android.gms.games.internal.IGamesService"
                r12.enforceInterface(r0)
                int r0 = r10.mo6944kn()
                r13.writeNoException()
                r13.writeInt(r0)
                goto L_0x000a
            L_0x0b50:
                java.lang.String r0 = "com.google.android.gms.games.internal.IGamesService"
                r12.enforceInterface(r0)
                java.lang.String r0 = r12.readString()
                java.lang.String r1 = r12.readString()
                r10.mo6976v(r0, r1)
                r13.writeNoException()
                goto L_0x000a
            L_0x0b65:
                java.lang.String r0 = "com.google.android.gms.games.internal.IGamesService"
                r12.enforceInterface(r0)
                android.os.IBinder r0 = r12.readStrongBinder()
                com.google.android.gms.games.internal.IGamesCallbacks r0 = com.google.android.gms.games.internal.IGamesCallbacks.Stub.m2620aA(r0)
                java.lang.String r1 = r12.readString()
                java.lang.String r2 = r12.readString()
                r10.mo6902d((com.google.android.gms.games.internal.IGamesCallbacks) r0, (java.lang.String) r1, (java.lang.String) r2)
                r13.writeNoException()
                goto L_0x000a
            L_0x0b82:
                java.lang.String r0 = "com.google.android.gms.games.internal.IGamesService"
                r12.enforceInterface(r0)
                android.os.IBinder r0 = r12.readStrongBinder()
                com.google.android.gms.games.internal.IGamesCallbacks r0 = com.google.android.gms.games.internal.IGamesCallbacks.Stub.m2620aA(r0)
                java.lang.String r1 = r12.readString()
                java.lang.String r2 = r12.readString()
                r10.mo6910e((com.google.android.gms.games.internal.IGamesCallbacks) r0, (java.lang.String) r1, (java.lang.String) r2)
                r13.writeNoException()
                goto L_0x000a
            L_0x0b9f:
                java.lang.String r0 = "com.google.android.gms.games.internal.IGamesService"
                r12.enforceInterface(r0)
                android.os.IBinder r0 = r12.readStrongBinder()
                com.google.android.gms.games.internal.IGamesCallbacks r0 = com.google.android.gms.games.internal.IGamesCallbacks.Stub.m2620aA(r0)
                java.lang.String r1 = r12.readString()
                int[] r2 = r12.createIntArray()
                r10.mo6839a((com.google.android.gms.games.internal.IGamesCallbacks) r0, (java.lang.String) r1, (int[]) r2)
                r13.writeNoException()
                goto L_0x000a
            L_0x0bbc:
                java.lang.String r0 = "com.google.android.gms.games.internal.IGamesService"
                r12.enforceInterface(r0)
                java.lang.String r0 = r12.readString()
                java.lang.String r1 = r12.readString()
                int r2 = r12.readInt()
                r10.mo6894c((java.lang.String) r0, (java.lang.String) r1, (int) r2)
                r13.writeNoException()
                goto L_0x000a
            L_0x0bd5:
                java.lang.String r0 = "com.google.android.gms.games.internal.IGamesService"
                r12.enforceInterface(r0)
                android.os.IBinder r0 = r12.readStrongBinder()
                com.google.android.gms.games.internal.IGamesCallbacks r0 = com.google.android.gms.games.internal.IGamesCallbacks.Stub.m2620aA(r0)
                long r1 = r12.readLong()
                java.lang.String r3 = r12.readString()
                r10.mo6810a((com.google.android.gms.games.internal.IGamesCallbacks) r0, (long) r1, (java.lang.String) r3)
                r13.writeNoException()
                goto L_0x000a
            L_0x0bf2:
                java.lang.String r0 = "com.google.android.gms.games.internal.IGamesService"
                r12.enforceInterface(r0)
                long r0 = r12.readLong()
                java.lang.String r2 = r12.readString()
                r10.mo6799a((long) r0, (java.lang.String) r2)
                r13.writeNoException()
                goto L_0x000a
            L_0x0c07:
                java.lang.String r0 = "com.google.android.gms.games.internal.IGamesService"
                r12.enforceInterface(r0)
                android.os.IBinder r0 = r12.readStrongBinder()
                com.google.android.gms.games.internal.IGamesCallbacks r0 = com.google.android.gms.games.internal.IGamesCallbacks.Stub.m2620aA(r0)
                long r1 = r12.readLong()
                java.lang.String r3 = r12.readString()
                r10.mo6856b((com.google.android.gms.games.internal.IGamesCallbacks) r0, (long) r1, (java.lang.String) r3)
                r13.writeNoException()
                goto L_0x000a
            L_0x0c24:
                java.lang.String r0 = "com.google.android.gms.games.internal.IGamesService"
                r12.enforceInterface(r0)
                long r0 = r12.readLong()
                java.lang.String r2 = r12.readString()
                r10.mo6852b((long) r0, (java.lang.String) r2)
                r13.writeNoException()
                goto L_0x000a
            L_0x0c39:
                java.lang.String r0 = "com.google.android.gms.games.internal.IGamesService"
                r12.enforceInterface(r0)
                r10.mo6954kz()
                r13.writeNoException()
                goto L_0x000a
            L_0x0c46:
                java.lang.String r0 = "com.google.android.gms.games.internal.IGamesService"
                r12.enforceInterface(r0)
                android.os.IBinder r0 = r12.readStrongBinder()
                com.google.android.gms.games.internal.IGamesCallbacks r0 = com.google.android.gms.games.internal.IGamesCallbacks.Stub.m2620aA(r0)
                java.lang.String r1 = r12.readString()
                int r2 = r12.readInt()
                int r3 = r12.readInt()
                if (r3 == 0) goto L_0x0c62
                r7 = r9
            L_0x0c62:
                r10.mo6818a((com.google.android.gms.games.internal.IGamesCallbacks) r0, (java.lang.String) r1, (int) r2, (boolean) r7)
                r13.writeNoException()
                goto L_0x000a
            L_0x0c6a:
                java.lang.String r0 = "com.google.android.gms.games.internal.IGamesService"
                r12.enforceInterface(r0)
                android.os.IBinder r0 = r12.readStrongBinder()
                com.google.android.gms.games.internal.IGamesCallbacks r0 = com.google.android.gms.games.internal.IGamesCallbacks.Stub.m2620aA(r0)
                int r1 = r12.readInt()
                if (r1 == 0) goto L_0x0c7e
                r7 = r9
            L_0x0c7e:
                r10.mo6892c((com.google.android.gms.games.internal.IGamesCallbacks) r0, (boolean) r7)
                r13.writeNoException()
                goto L_0x000a
            L_0x0c86:
                java.lang.String r0 = "com.google.android.gms.games.internal.IGamesService"
                r12.enforceInterface(r0)
                android.os.IBinder r0 = r12.readStrongBinder()
                com.google.android.gms.games.internal.IGamesCallbacks r1 = com.google.android.gms.games.internal.IGamesCallbacks.Stub.m2620aA(r0)
                java.lang.String r2 = r12.readString()
                int r3 = r12.readInt()
                int r0 = r12.readInt()
                if (r0 == 0) goto L_0x0cb2
                r4 = r9
            L_0x0ca2:
                int r0 = r12.readInt()
                if (r0 == 0) goto L_0x0cb4
                r5 = r9
            L_0x0ca9:
                r0 = r10
                r0.mo6888c(r1, r2, r3, r4, r5)
                r13.writeNoException()
                goto L_0x000a
            L_0x0cb2:
                r4 = r7
                goto L_0x0ca2
            L_0x0cb4:
                r5 = r7
                goto L_0x0ca9
            L_0x0cb6:
                java.lang.String r0 = "com.google.android.gms.games.internal.IGamesService"
                r12.enforceInterface(r0)
                android.os.IBinder r0 = r12.readStrongBinder()
                com.google.android.gms.games.internal.IGamesCallbacks r0 = com.google.android.gms.games.internal.IGamesCallbacks.Stub.m2620aA(r0)
                java.lang.String r1 = r12.readString()
                r10.mo6964q(r0, r1)
                r13.writeNoException()
                goto L_0x000a
            L_0x0ccf:
                java.lang.String r0 = "com.google.android.gms.games.internal.IGamesService"
                r12.enforceInterface(r0)
                android.content.Intent r0 = r10.mo6936kb()
                r13.writeNoException()
                if (r0 == 0) goto L_0x0ce5
                r13.writeInt(r9)
                r0.writeToParcel(r13, r9)
                goto L_0x000a
            L_0x0ce5:
                r13.writeInt(r7)
                goto L_0x000a
            L_0x0cea:
                java.lang.String r0 = "com.google.android.gms.games.internal.IGamesService"
                r12.enforceInterface(r0)
                java.lang.String r0 = r12.readString()
                android.content.Intent r0 = r10.mo6879bu(r0)
                r13.writeNoException()
                if (r0 == 0) goto L_0x0d04
                r13.writeInt(r9)
                r0.writeToParcel(r13, r9)
                goto L_0x000a
            L_0x0d04:
                r13.writeInt(r7)
                goto L_0x000a
            L_0x0d09:
                java.lang.String r0 = "com.google.android.gms.games.internal.IGamesService"
                r12.enforceInterface(r0)
                android.content.Intent r0 = r10.mo6937kc()
                r13.writeNoException()
                if (r0 == 0) goto L_0x0d1f
                r13.writeInt(r9)
                r0.writeToParcel(r13, r9)
                goto L_0x000a
            L_0x0d1f:
                r13.writeInt(r7)
                goto L_0x000a
            L_0x0d24:
                java.lang.String r0 = "com.google.android.gms.games.internal.IGamesService"
                r12.enforceInterface(r0)
                android.content.Intent r0 = r10.mo6938kd()
                r13.writeNoException()
                if (r0 == 0) goto L_0x0d3a
                r13.writeInt(r9)
                r0.writeToParcel(r13, r9)
                goto L_0x000a
            L_0x0d3a:
                r13.writeInt(r7)
                goto L_0x000a
            L_0x0d3f:
                java.lang.String r0 = "com.google.android.gms.games.internal.IGamesService"
                r12.enforceInterface(r0)
                android.content.Intent r0 = r10.mo6939ke()
                r13.writeNoException()
                if (r0 == 0) goto L_0x0d55
                r13.writeInt(r9)
                r0.writeToParcel(r13, r9)
                goto L_0x000a
            L_0x0d55:
                r13.writeInt(r7)
                goto L_0x000a
            L_0x0d5a:
                java.lang.String r0 = "com.google.android.gms.games.internal.IGamesService"
                r12.enforceInterface(r0)
                int r1 = r12.readInt()
                int r2 = r12.readInt()
                int r0 = r12.readInt()
                if (r0 == 0) goto L_0x0d7f
                r0 = r9
            L_0x0d6e:
                android.content.Intent r0 = r10.mo6791a((int) r1, (int) r2, (boolean) r0)
                r13.writeNoException()
                if (r0 == 0) goto L_0x0d81
                r13.writeInt(r9)
                r0.writeToParcel(r13, r9)
                goto L_0x000a
            L_0x0d7f:
                r0 = r7
                goto L_0x0d6e
            L_0x0d81:
                r13.writeInt(r7)
                goto L_0x000a
            L_0x0d86:
                java.lang.String r0 = "com.google.android.gms.games.internal.IGamesService"
                r12.enforceInterface(r0)
                int r1 = r12.readInt()
                int r2 = r12.readInt()
                int r0 = r12.readInt()
                if (r0 == 0) goto L_0x0dab
                r0 = r9
            L_0x0d9a:
                android.content.Intent r0 = r10.mo6850b((int) r1, (int) r2, (boolean) r0)
                r13.writeNoException()
                if (r0 == 0) goto L_0x0dad
                r13.writeInt(r9)
                r0.writeToParcel(r13, r9)
                goto L_0x000a
            L_0x0dab:
                r0 = r7
                goto L_0x0d9a
            L_0x0dad:
                r13.writeInt(r7)
                goto L_0x000a
            L_0x0db2:
                java.lang.String r0 = "com.google.android.gms.games.internal.IGamesService"
                r12.enforceInterface(r0)
                android.content.Intent r0 = r10.mo6940kj()
                r13.writeNoException()
                if (r0 == 0) goto L_0x0dc8
                r13.writeInt(r9)
                r0.writeToParcel(r13, r9)
                goto L_0x000a
            L_0x0dc8:
                r13.writeInt(r7)
                goto L_0x000a
            L_0x0dcd:
                java.lang.String r0 = "com.google.android.gms.games.internal.IGamesService"
                r12.enforceInterface(r0)
                int r0 = r12.readInt()
                if (r0 == 0) goto L_0x0df5
                android.os.Parcelable$Creator<com.google.android.gms.games.multiplayer.realtime.RoomEntity> r0 = com.google.android.gms.games.multiplayer.realtime.RoomEntity.CREATOR
                java.lang.Object r0 = r0.createFromParcel(r12)
                com.google.android.gms.games.multiplayer.realtime.RoomEntity r0 = (com.google.android.gms.games.multiplayer.realtime.RoomEntity) r0
            L_0x0de0:
                int r1 = r12.readInt()
                android.content.Intent r0 = r10.mo6796a((com.google.android.gms.games.multiplayer.realtime.RoomEntity) r0, (int) r1)
                r13.writeNoException()
                if (r0 == 0) goto L_0x0df7
                r13.writeInt(r9)
                r0.writeToParcel(r13, r9)
                goto L_0x000a
            L_0x0df5:
                r0 = r5
                goto L_0x0de0
            L_0x0df7:
                r13.writeInt(r7)
                goto L_0x000a
            L_0x0dfc:
                java.lang.String r0 = "com.google.android.gms.games.internal.IGamesService"
                r12.enforceInterface(r0)
                android.content.Intent r0 = r10.mo6941kk()
                r13.writeNoException()
                if (r0 == 0) goto L_0x0e12
                r13.writeInt(r9)
                r0.writeToParcel(r13, r9)
                goto L_0x000a
            L_0x0e12:
                r13.writeInt(r7)
                goto L_0x000a
            L_0x0e17:
                java.lang.String r0 = "com.google.android.gms.games.internal.IGamesService"
                r12.enforceInterface(r0)
                android.content.Intent r0 = r10.mo6933kA()
                r13.writeNoException()
                if (r0 == 0) goto L_0x0e2d
                r13.writeInt(r9)
                r0.writeToParcel(r13, r9)
                goto L_0x000a
            L_0x0e2d:
                r13.writeInt(r7)
                goto L_0x000a
            L_0x0e32:
                java.lang.String r0 = "com.google.android.gms.games.internal.IGamesService"
                r12.enforceInterface(r0)
                android.os.Parcelable$Creator<com.google.android.gms.games.multiplayer.ParticipantEntity> r0 = com.google.android.gms.games.multiplayer.ParticipantEntity.CREATOR
                java.lang.Object[] r1 = r12.createTypedArray(r0)
                com.google.android.gms.games.multiplayer.ParticipantEntity[] r1 = (com.google.android.gms.games.multiplayer.ParticipantEntity[]) r1
                java.lang.String r2 = r12.readString()
                java.lang.String r3 = r12.readString()
                int r0 = r12.readInt()
                if (r0 == 0) goto L_0x0e77
                android.os.Parcelable$Creator r0 = android.net.Uri.CREATOR
                java.lang.Object r0 = r0.createFromParcel(r12)
                android.net.Uri r0 = (android.net.Uri) r0
                r4 = r0
            L_0x0e56:
                int r0 = r12.readInt()
                if (r0 == 0) goto L_0x0e65
                android.os.Parcelable$Creator r0 = android.net.Uri.CREATOR
                java.lang.Object r0 = r0.createFromParcel(r12)
                android.net.Uri r0 = (android.net.Uri) r0
                r5 = r0
            L_0x0e65:
                r0 = r10
                android.content.Intent r0 = r0.mo6798a((com.google.android.gms.games.multiplayer.ParticipantEntity[]) r1, (java.lang.String) r2, (java.lang.String) r3, (android.net.Uri) r4, (android.net.Uri) r5)
                r13.writeNoException()
                if (r0 == 0) goto L_0x0e79
                r13.writeInt(r9)
                r0.writeToParcel(r13, r9)
                goto L_0x000a
            L_0x0e77:
                r4 = r5
                goto L_0x0e56
            L_0x0e79:
                r13.writeInt(r7)
                goto L_0x000a
            L_0x0e7e:
                java.lang.String r0 = "com.google.android.gms.games.internal.IGamesService"
                r12.enforceInterface(r0)
                int r0 = r10.mo6942kl()
                r13.writeNoException()
                r13.writeInt(r0)
                goto L_0x000a
            L_0x0e8f:
                java.lang.String r0 = "com.google.android.gms.games.internal.IGamesService"
                r12.enforceInterface(r0)
                android.os.IBinder r0 = r12.readStrongBinder()
                com.google.android.gms.games.internal.IGamesCallbacks r1 = com.google.android.gms.games.internal.IGamesCallbacks.Stub.m2620aA(r0)
                java.lang.String r2 = r12.readString()
                int r3 = r12.readInt()
                int r0 = r12.readInt()
                if (r0 == 0) goto L_0x0ebb
                r4 = r9
            L_0x0eab:
                int r0 = r12.readInt()
                if (r0 == 0) goto L_0x0ebd
                r5 = r9
            L_0x0eb2:
                r0 = r10
                r0.mo6901d(r1, r2, r3, r4, r5)
                r13.writeNoException()
                goto L_0x000a
            L_0x0ebb:
                r4 = r7
                goto L_0x0eab
            L_0x0ebd:
                r5 = r7
                goto L_0x0eb2
            L_0x0ebf:
                java.lang.String r0 = "com.google.android.gms.games.internal.IGamesService"
                r12.enforceInterface(r0)
                android.os.IBinder r0 = r12.readStrongBinder()
                com.google.android.gms.games.internal.IGamesCallbacks r1 = com.google.android.gms.games.internal.IGamesCallbacks.Stub.m2620aA(r0)
                java.lang.String r2 = r12.readString()
                java.lang.String r3 = r12.readString()
                int r4 = r12.readInt()
                int r0 = r12.readInt()
                if (r0 == 0) goto L_0x0eef
                r5 = r9
            L_0x0edf:
                int r0 = r12.readInt()
                if (r0 == 0) goto L_0x0ef1
                r6 = r9
            L_0x0ee6:
                r0 = r10
                r0.mo6830a((com.google.android.gms.games.internal.IGamesCallbacks) r1, (java.lang.String) r2, (java.lang.String) r3, (int) r4, (boolean) r5, (boolean) r6)
                r13.writeNoException()
                goto L_0x000a
            L_0x0eef:
                r5 = r7
                goto L_0x0edf
            L_0x0ef1:
                r6 = r7
                goto L_0x0ee6
            L_0x0ef3:
                java.lang.String r0 = "com.google.android.gms.games.internal.IGamesService"
                r12.enforceInterface(r0)
                java.lang.String r0 = r12.readString()
                android.os.ParcelFileDescriptor r0 = r10.mo6878bH(r0)
                r13.writeNoException()
                if (r0 == 0) goto L_0x0f0d
                r13.writeInt(r9)
                r0.writeToParcel(r13, r9)
                goto L_0x000a
            L_0x0f0d:
                r13.writeInt(r7)
                goto L_0x000a
            L_0x0f12:
                java.lang.String r0 = "com.google.android.gms.games.internal.IGamesService"
                r12.enforceInterface(r0)
                android.os.IBinder r0 = r12.readStrongBinder()
                com.google.android.gms.games.internal.IGamesCallbacks r0 = com.google.android.gms.games.internal.IGamesCallbacks.Stub.m2620aA(r0)
                long r1 = r12.readLong()
                r10.mo6884c((com.google.android.gms.games.internal.IGamesCallbacks) r0, (long) r1)
                r13.writeNoException()
                goto L_0x000a
            L_0x0f2b:
                java.lang.String r0 = "com.google.android.gms.games.internal.IGamesService"
                r12.enforceInterface(r0)
                long r0 = r12.readLong()
                r10.mo6971t(r0)
                r13.writeNoException()
                goto L_0x000a
            L_0x0f3c:
                java.lang.String r0 = "com.google.android.gms.games.internal.IGamesService"
                r12.enforceInterface(r0)
                android.os.IBinder r0 = r12.readStrongBinder()
                com.google.android.gms.games.internal.IGamesCallbacks r0 = com.google.android.gms.games.internal.IGamesCallbacks.Stub.m2620aA(r0)
                long r1 = r12.readLong()
                java.lang.String r3 = r12.readString()
                r10.mo6885c((com.google.android.gms.games.internal.IGamesCallbacks) r0, (long) r1, (java.lang.String) r3)
                r13.writeNoException()
                goto L_0x000a
            L_0x0f59:
                java.lang.String r0 = "com.google.android.gms.games.internal.IGamesService"
                r12.enforceInterface(r0)
                long r0 = r12.readLong()
                java.lang.String r2 = r12.readString()
                r10.mo6881c((long) r0, (java.lang.String) r2)
                r13.writeNoException()
                goto L_0x000a
            L_0x0f6e:
                java.lang.String r0 = "com.google.android.gms.games.internal.IGamesService"
                r12.enforceInterface(r0)
                android.os.IBinder r0 = r12.readStrongBinder()
                com.google.android.gms.games.internal.IGamesCallbacks r1 = com.google.android.gms.games.internal.IGamesCallbacks.Stub.m2620aA(r0)
                java.lang.String r2 = r12.readString()
                java.lang.String[] r3 = r12.createStringArray()
                int r4 = r12.readInt()
                byte[] r5 = r12.createByteArray()
                int r6 = r12.readInt()
                r0 = r10
                r0.mo6840a((com.google.android.gms.games.internal.IGamesCallbacks) r1, (java.lang.String) r2, (java.lang.String[]) r3, (int) r4, (byte[]) r5, (int) r6)
                r13.writeNoException()
                goto L_0x000a
            L_0x0f98:
                java.lang.String r0 = "com.google.android.gms.games.internal.IGamesService"
                r12.enforceInterface(r0)
                android.os.IBinder r0 = r12.readStrongBinder()
                com.google.android.gms.games.internal.IGamesCallbacks r0 = com.google.android.gms.games.internal.IGamesCallbacks.Stub.m2620aA(r0)
                java.lang.String[] r1 = r12.createStringArray()
                r10.mo6846a((com.google.android.gms.games.internal.IGamesCallbacks) r0, (java.lang.String[]) r1)
                r13.writeNoException()
                goto L_0x000a
            L_0x0fb1:
                java.lang.String r0 = "com.google.android.gms.games.internal.IGamesService"
                r12.enforceInterface(r0)
                android.os.IBinder r0 = r12.readStrongBinder()
                com.google.android.gms.games.internal.IGamesCallbacks r0 = com.google.android.gms.games.internal.IGamesCallbacks.Stub.m2620aA(r0)
                java.lang.String[] r1 = r12.createStringArray()
                r10.mo6870b((com.google.android.gms.games.internal.IGamesCallbacks) r0, (java.lang.String[]) r1)
                r13.writeNoException()
                goto L_0x000a
            L_0x0fca:
                java.lang.String r0 = "com.google.android.gms.games.internal.IGamesService"
                r12.enforceInterface(r0)
                android.os.IBinder r0 = r12.readStrongBinder()
                com.google.android.gms.games.internal.IGamesCallbacks r0 = com.google.android.gms.games.internal.IGamesCallbacks.Stub.m2620aA(r0)
                java.lang.String r1 = r12.readString()
                java.lang.String r2 = r12.readString()
                java.lang.String[] r3 = r12.createStringArray()
                r10.mo6834a((com.google.android.gms.games.internal.IGamesCallbacks) r0, (java.lang.String) r1, (java.lang.String) r2, (java.lang.String[]) r3)
                r13.writeNoException()
                goto L_0x000a
            L_0x0feb:
                java.lang.String r0 = "com.google.android.gms.games.internal.IGamesService"
                r12.enforceInterface(r0)
                android.os.IBinder r0 = r12.readStrongBinder()
                com.google.android.gms.games.internal.IGamesCallbacks r0 = com.google.android.gms.games.internal.IGamesCallbacks.Stub.m2620aA(r0)
                int r1 = r12.readInt()
                int r2 = r12.readInt()
                int r3 = r12.readInt()
                r10.mo6804a((com.google.android.gms.games.internal.IGamesCallbacks) r0, (int) r1, (int) r2, (int) r3)
                r13.writeNoException()
                goto L_0x000a
            L_0x100c:
                java.lang.String r0 = "com.google.android.gms.games.internal.IGamesService"
                r12.enforceInterface(r0)
                android.os.IBinder r0 = r12.readStrongBinder()
                com.google.android.gms.games.internal.IGamesCallbacks r1 = com.google.android.gms.games.internal.IGamesCallbacks.Stub.m2620aA(r0)
                java.lang.String r2 = r12.readString()
                java.lang.String r3 = r12.readString()
                int r4 = r12.readInt()
                int r5 = r12.readInt()
                int r6 = r12.readInt()
                r0 = r10
                r0.mo6828a((com.google.android.gms.games.internal.IGamesCallbacks) r1, (java.lang.String) r2, (java.lang.String) r3, (int) r4, (int) r5, (int) r6)
                r13.writeNoException()
                goto L_0x000a
            L_0x1036:
                java.lang.String r0 = "com.google.android.gms.games.internal.IGamesService"
                r12.enforceInterface(r0)
                android.os.IBinder r0 = r12.readStrongBinder()
                com.google.android.gms.games.internal.IGamesCallbacks r0 = com.google.android.gms.games.internal.IGamesCallbacks.Stub.m2620aA(r0)
                java.lang.String r1 = r12.readString()
                int r2 = r12.readInt()
                r10.mo6815a((com.google.android.gms.games.internal.IGamesCallbacks) r0, (java.lang.String) r1, (int) r2)
                r13.writeNoException()
                goto L_0x000a
            L_0x1053:
                java.lang.String r0 = "com.google.android.gms.games.internal.IGamesService"
                r12.enforceInterface(r0)
                int r0 = r12.readInt()
                byte[] r1 = r12.createByteArray()
                int r2 = r12.readInt()
                java.lang.String r3 = r12.readString()
                android.content.Intent r0 = r10.mo6792a((int) r0, (byte[]) r1, (int) r2, (java.lang.String) r3)
                r13.writeNoException()
                if (r0 == 0) goto L_0x1079
                r13.writeInt(r9)
                r0.writeToParcel(r13, r9)
                goto L_0x000a
            L_0x1079:
                r13.writeInt(r7)
                goto L_0x000a
            L_0x107e:
                java.lang.String r0 = "com.google.android.gms.games.internal.IGamesService"
                r12.enforceInterface(r0)
                int r0 = r10.mo6946kp()
                r13.writeNoException()
                r13.writeInt(r0)
                goto L_0x000a
            L_0x108f:
                java.lang.String r0 = "com.google.android.gms.games.internal.IGamesService"
                r12.enforceInterface(r0)
                int r0 = r10.mo6947kq()
                r13.writeNoException()
                r13.writeInt(r0)
                goto L_0x000a
            L_0x10a0:
                java.lang.String r0 = "com.google.android.gms.games.internal.IGamesService"
                r12.enforceInterface(r0)
                android.content.Intent r0 = r10.mo6945ko()
                r13.writeNoException()
                if (r0 == 0) goto L_0x10b6
                r13.writeInt(r9)
                r0.writeToParcel(r13, r9)
                goto L_0x000a
            L_0x10b6:
                r13.writeInt(r7)
                goto L_0x000a
            L_0x10bb:
                java.lang.String r0 = "com.google.android.gms.games.internal.IGamesService"
                r12.enforceInterface(r0)
                int r0 = r12.readInt()
                if (r0 == 0) goto L_0x10cc
                com.google.android.gms.games.internal.request.GameRequestClusterCreator r0 = com.google.android.gms.games.internal.request.GameRequestCluster.CREATOR
                com.google.android.gms.games.internal.request.GameRequestCluster r5 = r0.createFromParcel(r12)
            L_0x10cc:
                java.lang.String r0 = r12.readString()
                android.content.Intent r0 = r10.mo6795a((com.google.android.gms.games.internal.request.GameRequestCluster) r5, (java.lang.String) r0)
                r13.writeNoException()
                if (r0 == 0) goto L_0x10e1
                r13.writeInt(r9)
                r0.writeToParcel(r13, r9)
                goto L_0x000a
            L_0x10e1:
                r13.writeInt(r7)
                goto L_0x000a
            L_0x10e6:
                java.lang.String r0 = "com.google.android.gms.games.internal.IGamesService"
                r12.enforceInterface(r0)
                java.lang.String r0 = r12.readString()
                int r1 = r12.readInt()
                r10.mo6970s((java.lang.String) r0, (int) r1)
                r13.writeNoException()
                goto L_0x000a
            L_0x10fb:
                java.lang.String r0 = "com.google.android.gms.games.internal.IGamesService"
                r12.enforceInterface(r0)
                android.os.IBinder r0 = r12.readStrongBinder()
                com.google.android.gms.games.internal.IGamesCallbacks r0 = com.google.android.gms.games.internal.IGamesCallbacks.Stub.m2620aA(r0)
                int r1 = r12.readInt()
                r10.mo6803a((com.google.android.gms.games.internal.IGamesCallbacks) r0, (int) r1)
                r13.writeNoException()
                goto L_0x000a
            L_0x1114:
                java.lang.String r0 = "com.google.android.gms.games.internal.IGamesService"
                r12.enforceInterface(r0)
                android.os.IBinder r0 = r12.readStrongBinder()
                com.google.android.gms.games.internal.IGamesCallbacks r0 = com.google.android.gms.games.internal.IGamesCallbacks.Stub.m2620aA(r0)
                java.lang.String r1 = r12.readString()
                int r2 = r12.readInt()
                int r3 = r12.readInt()
                if (r3 == 0) goto L_0x1130
                r7 = r9
            L_0x1130:
                r10.mo6861b((com.google.android.gms.games.internal.IGamesCallbacks) r0, (java.lang.String) r1, (int) r2, (boolean) r7)
                r13.writeNoException()
                goto L_0x000a
            L_0x1138:
                java.lang.String r0 = "com.google.android.gms.games.internal.IGamesService"
                r12.enforceInterface(r0)
                int r0 = r12.readInt()
                if (r0 == 0) goto L_0x1149
                com.google.android.gms.games.internal.multiplayer.InvitationClusterCreator r0 = com.google.android.gms.games.internal.multiplayer.ZInvitationCluster.CREATOR
                com.google.android.gms.games.internal.multiplayer.ZInvitationCluster r5 = r0.createFromParcel(r12)
            L_0x1149:
                java.lang.String r0 = r12.readString()
                java.lang.String r1 = r12.readString()
                android.content.Intent r0 = r10.mo6794a((com.google.android.gms.games.internal.multiplayer.ZInvitationCluster) r5, (java.lang.String) r0, (java.lang.String) r1)
                r13.writeNoException()
                if (r0 == 0) goto L_0x1162
                r13.writeInt(r9)
                r0.writeToParcel(r13, r9)
                goto L_0x000a
            L_0x1162:
                r13.writeInt(r7)
                goto L_0x000a
            L_0x1167:
                java.lang.String r0 = "com.google.android.gms.games.internal.IGamesService"
                r12.enforceInterface(r0)
                android.os.IBinder r0 = r12.readStrongBinder()
                com.google.android.gms.games.internal.IGamesCallbacks r0 = com.google.android.gms.games.internal.IGamesCallbacks.Stub.m2620aA(r0)
                int r1 = r12.readInt()
                int[] r2 = r12.createIntArray()
                r10.mo6808a((com.google.android.gms.games.internal.IGamesCallbacks) r0, (int) r1, (int[]) r2)
                r13.writeNoException()
                goto L_0x000a
            L_0x1184:
                java.lang.String r0 = "com.google.android.gms.games.internal.IGamesService"
                r12.enforceInterface(r0)
                android.os.IBinder r0 = r12.readStrongBinder()
                com.google.android.gms.games.internal.IGamesCallbacks r0 = com.google.android.gms.games.internal.IGamesCallbacks.Stub.m2620aA(r0)
                java.lang.String r1 = r12.readString()
                int r2 = r12.readInt()
                int[] r3 = r12.createIntArray()
                r10.mo6821a((com.google.android.gms.games.internal.IGamesCallbacks) r0, (java.lang.String) r1, (int) r2, (int[]) r3)
                r13.writeNoException()
                goto L_0x000a
            L_0x11a5:
                java.lang.String r0 = "com.google.android.gms.games.internal.IGamesService"
                r12.enforceInterface(r0)
                android.os.IBinder r0 = r12.readStrongBinder()
                com.google.android.gms.games.internal.IGamesCallbacks r0 = com.google.android.gms.games.internal.IGamesCallbacks.Stub.m2620aA(r0)
                java.lang.String[] r1 = r12.createStringArray()
                r10.mo6893c((com.google.android.gms.games.internal.IGamesCallbacks) r0, (java.lang.String[]) r1)
                r13.writeNoException()
                goto L_0x000a
            L_0x11be:
                java.lang.String r0 = "com.google.android.gms.games.internal.IGamesService"
                r12.enforceInterface(r0)
                android.os.IBinder r0 = r12.readStrongBinder()
                com.google.android.gms.games.internal.IGamesCallbacks r0 = com.google.android.gms.games.internal.IGamesCallbacks.Stub.m2620aA(r0)
                r10.mo6928j(r0)
                r13.writeNoException()
                goto L_0x000a
            L_0x11d3:
                java.lang.String r0 = "com.google.android.gms.games.internal.IGamesService"
                r12.enforceInterface(r0)
                r10.mo6934kB()
                r13.writeNoException()
                goto L_0x000a
            L_0x11e0:
                java.lang.String r0 = "com.google.android.gms.games.internal.IGamesService"
                r12.enforceInterface(r0)
                java.lang.String r2 = r12.readString()
                int r0 = r12.readInt()
                if (r0 == 0) goto L_0x120c
                r0 = r9
            L_0x11f0:
                int r1 = r12.readInt()
                if (r1 == 0) goto L_0x120e
                r1 = r9
            L_0x11f7:
                int r3 = r12.readInt()
                android.content.Intent r0 = r10.mo6797a((java.lang.String) r2, (boolean) r0, (boolean) r1, (int) r3)
                r13.writeNoException()
                if (r0 == 0) goto L_0x1210
                r13.writeInt(r9)
                r0.writeToParcel(r13, r9)
                goto L_0x000a
            L_0x120c:
                r0 = r7
                goto L_0x11f0
            L_0x120e:
                r1 = r7
                goto L_0x11f7
            L_0x1210:
                r13.writeInt(r7)
                goto L_0x000a
            L_0x1215:
                java.lang.String r0 = "com.google.android.gms.games.internal.IGamesService"
                r12.enforceInterface(r0)
                android.os.IBinder r0 = r12.readStrongBinder()
                com.google.android.gms.games.internal.IGamesCallbacks r0 = com.google.android.gms.games.internal.IGamesCallbacks.Stub.m2620aA(r0)
                int r1 = r12.readInt()
                if (r1 == 0) goto L_0x1229
                r7 = r9
            L_0x1229:
                r10.mo6904d((com.google.android.gms.games.internal.IGamesCallbacks) r0, (boolean) r7)
                r13.writeNoException()
                goto L_0x000a
            L_0x1231:
                java.lang.String r0 = "com.google.android.gms.games.internal.IGamesService"
                r12.enforceInterface(r0)
                android.os.IBinder r0 = r12.readStrongBinder()
                com.google.android.gms.games.internal.IGamesCallbacks r0 = com.google.android.gms.games.internal.IGamesCallbacks.Stub.m2620aA(r0)
                java.lang.String r1 = r12.readString()
                java.lang.String r2 = r12.readString()
                int r3 = r12.readInt()
                if (r3 == 0) goto L_0x124d
                r7 = r9
            L_0x124d:
                r10.mo6890c((com.google.android.gms.games.internal.IGamesCallbacks) r0, (java.lang.String) r1, (java.lang.String) r2, (boolean) r7)
                r13.writeNoException()
                goto L_0x000a
            L_0x1255:
                java.lang.String r0 = "com.google.android.gms.games.internal.IGamesService"
                r12.enforceInterface(r0)
                android.os.IBinder r0 = r12.readStrongBinder()
                com.google.android.gms.games.internal.IGamesCallbacks r0 = com.google.android.gms.games.internal.IGamesCallbacks.Stub.m2620aA(r0)
                java.lang.String r1 = r12.readString()
                int r2 = r12.readInt()
                if (r2 == 0) goto L_0x126d
                r7 = r9
            L_0x126d:
                r10.mo6911e((com.google.android.gms.games.internal.IGamesCallbacks) r0, (java.lang.String) r1, (boolean) r7)
                r13.writeNoException()
                goto L_0x000a
            L_0x1275:
                java.lang.String r0 = "com.google.android.gms.games.internal.IGamesService"
                r12.enforceInterface(r0)
                android.os.IBinder r0 = r12.readStrongBinder()
                com.google.android.gms.games.internal.IGamesCallbacks r2 = com.google.android.gms.games.internal.IGamesCallbacks.Stub.m2620aA(r0)
                java.lang.String r3 = r12.readString()
                int r0 = r12.readInt()
                if (r0 == 0) goto L_0x12a9
                com.google.android.gms.games.snapshot.SnapshotMetadataChangeCreator r0 = com.google.android.gms.games.snapshot.SnapshotMetadataChange.CREATOR
                com.google.android.gms.games.snapshot.SnapshotMetadataChange r0 = r0.createFromParcel((android.os.Parcel) r12)
                r1 = r0
            L_0x1293:
                int r0 = r12.readInt()
                if (r0 == 0) goto L_0x12ab
                android.os.Parcelable$Creator<com.google.android.gms.drive.Contents> r0 = com.google.android.gms.drive.Contents.CREATOR
                java.lang.Object r0 = r0.createFromParcel(r12)
                com.google.android.gms.drive.Contents r0 = (com.google.android.gms.drive.Contents) r0
            L_0x12a1:
                r10.mo6825a((com.google.android.gms.games.internal.IGamesCallbacks) r2, (java.lang.String) r3, (com.google.android.gms.games.snapshot.SnapshotMetadataChange) r1, (com.google.android.gms.drive.Contents) r0)
                r13.writeNoException()
                goto L_0x000a
            L_0x12a9:
                r1 = r5
                goto L_0x1293
            L_0x12ab:
                r0 = r5
                goto L_0x12a1
            L_0x12ad:
                java.lang.String r0 = "com.google.android.gms.games.internal.IGamesService"
                r12.enforceInterface(r0)
                int r0 = r12.readInt()
                if (r0 == 0) goto L_0x12c8
                android.os.Parcelable$Creator<com.google.android.gms.drive.Contents> r0 = com.google.android.gms.drive.Contents.CREATOR
                java.lang.Object r0 = r0.createFromParcel(r12)
                com.google.android.gms.drive.Contents r0 = (com.google.android.gms.drive.Contents) r0
            L_0x12c0:
                r10.mo6801a((com.google.android.gms.drive.Contents) r0)
                r13.writeNoException()
                goto L_0x000a
            L_0x12c8:
                r0 = r5
                goto L_0x12c0
            L_0x12ca:
                java.lang.String r0 = "com.google.android.gms.games.internal.IGamesService"
                r12.enforceInterface(r0)
                android.os.IBinder r0 = r12.readStrongBinder()
                com.google.android.gms.games.internal.IGamesCallbacks r0 = com.google.android.gms.games.internal.IGamesCallbacks.Stub.m2620aA(r0)
                java.lang.String r1 = r12.readString()
                r10.mo6966r((com.google.android.gms.games.internal.IGamesCallbacks) r0, (java.lang.String) r1)
                r13.writeNoException()
                goto L_0x000a
            L_0x12e3:
                java.lang.String r0 = "com.google.android.gms.games.internal.IGamesService"
                r12.enforceInterface(r0)
                android.os.IBinder r0 = r12.readStrongBinder()
                com.google.android.gms.games.internal.IGamesCallbacks r1 = com.google.android.gms.games.internal.IGamesCallbacks.Stub.m2620aA(r0)
                java.lang.String r2 = r12.readString()
                java.lang.String r3 = r12.readString()
                int r0 = r12.readInt()
                if (r0 == 0) goto L_0x131c
                com.google.android.gms.games.snapshot.SnapshotMetadataChangeCreator r0 = com.google.android.gms.games.snapshot.SnapshotMetadataChange.CREATOR
                com.google.android.gms.games.snapshot.SnapshotMetadataChange r4 = r0.createFromParcel((android.os.Parcel) r12)
            L_0x1304:
                int r0 = r12.readInt()
                if (r0 == 0) goto L_0x1313
                android.os.Parcelable$Creator<com.google.android.gms.drive.Contents> r0 = com.google.android.gms.drive.Contents.CREATOR
                java.lang.Object r0 = r0.createFromParcel(r12)
                com.google.android.gms.drive.Contents r0 = (com.google.android.gms.drive.Contents) r0
                r5 = r0
            L_0x1313:
                r0 = r10
                r0.mo6831a((com.google.android.gms.games.internal.IGamesCallbacks) r1, (java.lang.String) r2, (java.lang.String) r3, (com.google.android.gms.games.snapshot.SnapshotMetadataChange) r4, (com.google.android.gms.drive.Contents) r5)
                r13.writeNoException()
                goto L_0x000a
            L_0x131c:
                r4 = r5
                goto L_0x1304
            L_0x131e:
                java.lang.String r0 = "com.google.android.gms.games.internal.IGamesService"
                r12.enforceInterface(r0)
                int r0 = r10.mo6948kr()
                r13.writeNoException()
                r13.writeInt(r0)
                goto L_0x000a
            L_0x132f:
                java.lang.String r0 = "com.google.android.gms.games.internal.IGamesService"
                r12.enforceInterface(r0)
                int r0 = r10.mo6949ks()
                r13.writeNoException()
                r13.writeInt(r0)
                goto L_0x000a
            L_0x1340:
                java.lang.String r0 = "com.google.android.gms.games.internal.IGamesService"
                r12.enforceInterface(r0)
                android.os.IBinder r0 = r12.readStrongBinder()
                com.google.android.gms.games.internal.IGamesCallbacks r0 = com.google.android.gms.games.internal.IGamesCallbacks.Stub.m2620aA(r0)
                java.lang.String r1 = r12.readString()
                r10.mo6969s((com.google.android.gms.games.internal.IGamesCallbacks) r0, (java.lang.String) r1)
                r13.writeNoException()
                goto L_0x000a
            L_0x1359:
                java.lang.String r0 = "com.google.android.gms.games.internal.IGamesService"
                r12.enforceInterface(r0)
                android.os.IBinder r0 = r12.readStrongBinder()
                com.google.android.gms.games.internal.IGamesCallbacks r0 = com.google.android.gms.games.internal.IGamesCallbacks.Stub.m2620aA(r0)
                java.lang.String r1 = r12.readString()
                int r2 = r12.readInt()
                r10.mo6858b((com.google.android.gms.games.internal.IGamesCallbacks) r0, (java.lang.String) r1, (int) r2)
                r13.writeNoException()
                goto L_0x000a
            L_0x1376:
                java.lang.String r0 = "com.google.android.gms.games.internal.IGamesService"
                r12.enforceInterface(r0)
                android.os.IBinder r0 = r12.readStrongBinder()
                com.google.android.gms.games.internal.IGamesCallbacks r0 = com.google.android.gms.games.internal.IGamesCallbacks.Stub.m2620aA(r0)
                java.lang.String r1 = r12.readString()
                int r2 = r12.readInt()
                r10.mo6887c((com.google.android.gms.games.internal.IGamesCallbacks) r0, (java.lang.String) r1, (int) r2)
                r13.writeNoException()
                goto L_0x000a
            L_0x1393:
                java.lang.String r0 = "com.google.android.gms.games.internal.IGamesService"
                r12.enforceInterface(r0)
                android.os.IBinder r0 = r12.readStrongBinder()
                com.google.android.gms.games.internal.IGamesCallbacks r1 = com.google.android.gms.games.internal.IGamesCallbacks.Stub.m2620aA(r0)
                java.lang.String r2 = r12.readString()
                int r3 = r12.readInt()
                int r0 = r12.readInt()
                if (r0 == 0) goto L_0x13bf
                r4 = r9
            L_0x13af:
                int r0 = r12.readInt()
                if (r0 == 0) goto L_0x13c1
                r5 = r9
            L_0x13b6:
                r0 = r10
                r0.mo6909e(r1, r2, r3, r4, r5)
                r13.writeNoException()
                goto L_0x000a
            L_0x13bf:
                r4 = r7
                goto L_0x13af
            L_0x13c1:
                r5 = r7
                goto L_0x13b6
            L_0x13c3:
                java.lang.String r0 = "com.google.android.gms.games.internal.IGamesService"
                r12.enforceInterface(r0)
                android.os.IBinder r0 = r12.readStrongBinder()
                com.google.android.gms.games.internal.IGamesCallbacks r1 = com.google.android.gms.games.internal.IGamesCallbacks.Stub.m2620aA(r0)
                java.lang.String r2 = r12.readString()
                int r3 = r12.readInt()
                int r0 = r12.readInt()
                if (r0 == 0) goto L_0x13ef
                r4 = r9
            L_0x13df:
                int r0 = r12.readInt()
                if (r0 == 0) goto L_0x13f1
                r5 = r9
            L_0x13e6:
                r0 = r10
                r0.mo6915f(r1, r2, r3, r4, r5)
                r13.writeNoException()
                goto L_0x000a
            L_0x13ef:
                r4 = r7
                goto L_0x13df
            L_0x13f1:
                r5 = r7
                goto L_0x13e6
            L_0x13f3:
                java.lang.String r0 = "com.google.android.gms.games.internal.IGamesService"
                r12.enforceInterface(r0)
                boolean r0 = r10.mo6935kC()
                r13.writeNoException()
                if (r0 == 0) goto L_0x1402
                r7 = r9
            L_0x1402:
                r13.writeInt(r7)
                goto L_0x000a
            L_0x1407:
                java.lang.String r0 = "com.google.android.gms.games.internal.IGamesService"
                r12.enforceInterface(r0)
                int r0 = r12.readInt()
                if (r0 == 0) goto L_0x1413
                r7 = r9
            L_0x1413:
                r10.mo6788O(r7)
                r13.writeNoException()
                goto L_0x000a
            L_0x141b:
                java.lang.String r0 = "com.google.android.gms.games.internal.IGamesService"
                r12.enforceInterface(r0)
                android.os.IBinder r0 = r12.readStrongBinder()
                com.google.android.gms.games.internal.IGamesCallbacks r0 = com.google.android.gms.games.internal.IGamesCallbacks.Stub.m2620aA(r0)
                java.lang.String r1 = r12.readString()
                r10.mo6972t(r0, r1)
                r13.writeNoException()
                goto L_0x000a
            L_0x1434:
                java.lang.String r0 = "com.google.android.gms.games.internal.IGamesService"
                r12.enforceInterface(r0)
                android.os.IBinder r0 = r12.readStrongBinder()
                com.google.android.gms.games.internal.IGamesCallbacks r0 = com.google.android.gms.games.internal.IGamesCallbacks.Stub.m2620aA(r0)
                int r1 = r12.readInt()
                if (r1 == 0) goto L_0x1448
                r7 = r9
            L_0x1448:
                r10.mo6912e((com.google.android.gms.games.internal.IGamesCallbacks) r0, (boolean) r7)
                r13.writeNoException()
                goto L_0x000a
            L_0x1450:
                java.lang.String r0 = "com.google.android.gms.games.internal.IGamesService"
                r12.enforceInterface(r0)
                android.os.IBinder r0 = r12.readStrongBinder()
                com.google.android.gms.games.internal.IGamesCallbacks r0 = com.google.android.gms.games.internal.IGamesCallbacks.Stub.m2620aA(r0)
                int r1 = r12.readInt()
                if (r1 == 0) goto L_0x1464
                r7 = r9
            L_0x1464:
                r10.mo6917f((com.google.android.gms.games.internal.IGamesCallbacks) r0, (boolean) r7)
                r13.writeNoException()
                goto L_0x000a
            L_0x146c:
                java.lang.String r0 = "com.google.android.gms.games.internal.IGamesService"
                r12.enforceInterface(r0)
                android.os.IBinder r0 = r12.readStrongBinder()
                com.google.android.gms.games.internal.IGamesCallbacks r0 = com.google.android.gms.games.internal.IGamesCallbacks.Stub.m2620aA(r0)
                int r1 = r12.readInt()
                if (r1 == 0) goto L_0x1480
                r7 = r9
            L_0x1480:
                java.lang.String[] r1 = r12.createStringArray()
                r10.mo6843a((com.google.android.gms.games.internal.IGamesCallbacks) r0, (boolean) r7, (java.lang.String[]) r1)
                r13.writeNoException()
                goto L_0x000a
            L_0x148c:
                java.lang.String r0 = "com.google.android.gms.games.internal.IGamesService"
                r12.enforceInterface(r0)
                java.lang.String r0 = r12.readString()
                int r1 = r12.readInt()
                r10.mo6958n((java.lang.String) r0, (int) r1)
                r13.writeNoException()
                goto L_0x000a
            L_0x14a1:
                java.lang.String r0 = "com.google.android.gms.games.internal.IGamesService"
                r12.enforceInterface(r0)
                android.os.IBinder r0 = r12.readStrongBinder()
                com.google.android.gms.games.internal.IGamesCallbacks r0 = com.google.android.gms.games.internal.IGamesCallbacks.Stub.m2620aA(r0)
                java.lang.String r1 = r12.readString()
                r10.mo6974u((com.google.android.gms.games.internal.IGamesCallbacks) r0, (java.lang.String) r1)
                r13.writeNoException()
                goto L_0x000a
            L_0x14ba:
                java.lang.String r0 = "com.google.android.gms.games.internal.IGamesService"
                r12.enforceInterface(r0)
                android.os.IBinder r0 = r12.readStrongBinder()
                com.google.android.gms.games.internal.IGamesCallbacks r0 = com.google.android.gms.games.internal.IGamesCallbacks.Stub.m2620aA(r0)
                java.lang.String r1 = r12.readString()
                java.lang.String r2 = r12.readString()
                r10.mo6916f(r0, r1, r2)
                r13.writeNoException()
                goto L_0x000a
            L_0x14d7:
                java.lang.String r0 = "com.google.android.gms.games.internal.IGamesService"
                r12.enforceInterface(r0)
                android.os.IBinder r0 = r12.readStrongBinder()
                com.google.android.gms.games.internal.IGamesCallbacks r0 = com.google.android.gms.games.internal.IGamesCallbacks.Stub.m2620aA(r0)
                int[] r1 = r12.createIntArray()
                int r2 = r12.readInt()
                int r3 = r12.readInt()
                if (r3 == 0) goto L_0x14f3
                r7 = r9
            L_0x14f3:
                r10.mo6845a((com.google.android.gms.games.internal.IGamesCallbacks) r0, (int[]) r1, (int) r2, (boolean) r7)
                r13.writeNoException()
                goto L_0x000a
            L_0x14fb:
                java.lang.String r0 = "com.google.android.gms.games.internal.IGamesService"
                r12.enforceInterface(r0)
                android.os.IBinder r0 = r12.readStrongBinder()
                com.google.android.gms.games.internal.IGamesCallbacks r0 = com.google.android.gms.games.internal.IGamesCallbacks.Stub.m2620aA(r0)
                java.lang.String[] r1 = r12.createStringArray()
                int r2 = r12.readInt()
                if (r2 == 0) goto L_0x1513
                r7 = r9
            L_0x1513:
                r10.mo6847a((com.google.android.gms.games.internal.IGamesCallbacks) r0, (java.lang.String[]) r1, (boolean) r7)
                r13.writeNoException()
                goto L_0x000a
            L_0x151b:
                java.lang.String r0 = "com.google.android.gms.games.internal.IGamesService"
                r12.enforceInterface(r0)
                android.os.IBinder r0 = r12.readStrongBinder()
                com.google.android.gms.games.internal.IGamesCallbacks r1 = com.google.android.gms.games.internal.IGamesCallbacks.Stub.m2620aA(r0)
                java.lang.String r2 = r12.readString()
                java.lang.String r3 = r12.readString()
                int[] r4 = r12.createIntArray()
                int r5 = r12.readInt()
                int r0 = r12.readInt()
                if (r0 == 0) goto L_0x1548
                r6 = r9
            L_0x153f:
                r0 = r10
                r0.mo6833a((com.google.android.gms.games.internal.IGamesCallbacks) r1, (java.lang.String) r2, (java.lang.String) r3, (int[]) r4, (int) r5, (boolean) r6)
                r13.writeNoException()
                goto L_0x000a
            L_0x1548:
                r6 = r7
                goto L_0x153f
            L_0x154a:
                java.lang.String r0 = "com.google.android.gms.games.internal.IGamesService"
                r12.enforceInterface(r0)
                android.os.IBinder r0 = r12.readStrongBinder()
                com.google.android.gms.games.internal.IGamesCallbacks r1 = com.google.android.gms.games.internal.IGamesCallbacks.Stub.m2620aA(r0)
                java.lang.String r2 = r12.readString()
                java.lang.String r3 = r12.readString()
                java.lang.String[] r4 = r12.createStringArray()
                int r0 = r12.readInt()
                if (r0 == 0) goto L_0x1573
                r5 = r9
            L_0x156a:
                r0 = r10
                r0.mo6835a((com.google.android.gms.games.internal.IGamesCallbacks) r1, (java.lang.String) r2, (java.lang.String) r3, (java.lang.String[]) r4, (boolean) r5)
                r13.writeNoException()
                goto L_0x000a
            L_0x1573:
                r5 = r7
                goto L_0x156a
            L_0x1575:
                java.lang.String r0 = "com.google.android.gms.games.internal.IGamesService"
                r12.enforceInterface(r0)
                android.os.IBinder r0 = r12.readStrongBinder()
                com.google.android.gms.games.internal.IGamesCallbacks r0 = com.google.android.gms.games.internal.IGamesCallbacks.Stub.m2620aA(r0)
                long r1 = r12.readLong()
                r10.mo6898d((com.google.android.gms.games.internal.IGamesCallbacks) r0, (long) r1)
                r13.writeNoException()
                goto L_0x000a
            L_0x158e:
                java.lang.String r0 = "com.google.android.gms.games.internal.IGamesService"
                r12.enforceInterface(r0)
                android.os.IBinder r0 = r12.readStrongBinder()
                com.google.android.gms.games.internal.IGamesCallbacks r0 = com.google.android.gms.games.internal.IGamesCallbacks.Stub.m2620aA(r0)
                long r1 = r12.readLong()
                java.lang.String r3 = r12.readString()
                r10.mo6899d((com.google.android.gms.games.internal.IGamesCallbacks) r0, (long) r1, (java.lang.String) r3)
                r13.writeNoException()
                goto L_0x000a
            L_0x15ab:
                java.lang.String r0 = "com.google.android.gms.games.internal.IGamesService"
                r12.enforceInterface(r0)
                long r0 = r12.readLong()
                r10.mo6973u(r0)
                r13.writeNoException()
                goto L_0x000a
            L_0x15bc:
                java.lang.String r0 = "com.google.android.gms.games.internal.IGamesService"
                r12.enforceInterface(r0)
                long r0 = r12.readLong()
                java.lang.String r2 = r12.readString()
                r10.mo6895d((long) r0, (java.lang.String) r2)
                r13.writeNoException()
                goto L_0x000a
            L_0x15d1:
                java.lang.String r0 = "com.google.android.gms.games.internal.IGamesService"
                r12.enforceInterface(r0)
                int[] r0 = r12.createIntArray()
                android.content.Intent r0 = r10.mo6851b((int[]) r0)
                r13.writeNoException()
                if (r0 == 0) goto L_0x15eb
                r13.writeInt(r9)
                r0.writeToParcel(r13, r9)
                goto L_0x000a
            L_0x15eb:
                r13.writeInt(r7)
                goto L_0x000a
            L_0x15f0:
                java.lang.String r0 = "com.google.android.gms.games.internal.IGamesService"
                r12.enforceInterface(r0)
                java.lang.String r0 = r12.readString()
                android.content.Intent r0 = r10.mo6880bz(r0)
                r13.writeNoException()
                if (r0 == 0) goto L_0x160a
                r13.writeInt(r9)
                r0.writeToParcel(r13, r9)
                goto L_0x000a
            L_0x160a:
                r13.writeInt(r7)
                goto L_0x000a
            L_0x160f:
                java.lang.String r0 = "com.google.android.gms.games.internal.IGamesService"
                r12.enforceInterface(r0)
                android.os.IBinder r0 = r12.readStrongBinder()
                com.google.android.gms.games.internal.IGamesCallbacks r1 = com.google.android.gms.games.internal.IGamesCallbacks.Stub.m2620aA(r0)
                java.lang.String r2 = r12.readString()
                java.lang.String r3 = r12.readString()
                int r4 = r12.readInt()
                int r0 = r12.readInt()
                if (r0 == 0) goto L_0x163f
                r5 = r9
            L_0x162f:
                int r0 = r12.readInt()
                if (r0 == 0) goto L_0x1641
                r6 = r9
            L_0x1636:
                r0 = r10
                r0.mo6866b((com.google.android.gms.games.internal.IGamesCallbacks) r1, (java.lang.String) r2, (java.lang.String) r3, (int) r4, (boolean) r5, (boolean) r6)
                r13.writeNoException()
                goto L_0x000a
            L_0x163f:
                r5 = r7
                goto L_0x162f
            L_0x1641:
                r6 = r7
                goto L_0x1636
            L_0x1643:
                java.lang.String r0 = "com.google.android.gms.games.internal.IGamesService"
                r12.enforceInterface(r0)
                int r0 = r12.readInt()
                if (r0 == 0) goto L_0x164f
                r7 = r9
            L_0x164f:
                r10.mo6789P(r7)
                r13.writeNoException()
                goto L_0x000a
            L_0x1657:
                java.lang.String r0 = "com.google.android.gms.games.internal.IGamesService"
                r12.enforceInterface(r0)
                java.lang.String r1 = r12.readString()
                android.os.IBinder r2 = r12.readStrongBinder()
                int r0 = r12.readInt()
                if (r0 == 0) goto L_0x167a
                android.os.Parcelable$Creator r0 = android.os.Bundle.CREATOR
                java.lang.Object r0 = r0.createFromParcel(r12)
                android.os.Bundle r0 = (android.os.Bundle) r0
            L_0x1672:
                r10.mo6848a((java.lang.String) r1, (android.os.IBinder) r2, (android.os.Bundle) r0)
                r13.writeNoException()
                goto L_0x000a
            L_0x167a:
                r0 = r5
                goto L_0x1672
            L_0x167c:
                java.lang.String r0 = "com.google.android.gms.games.internal.IGamesService"
                r12.enforceInterface(r0)
                android.os.IBinder r0 = r12.readStrongBinder()
                com.google.android.gms.games.internal.IGamesCallbacks r0 = com.google.android.gms.games.internal.IGamesCallbacks.Stub.m2620aA(r0)
                int r1 = r12.readInt()
                if (r1 == 0) goto L_0x1690
                r7 = r9
            L_0x1690:
                r10.mo6921g((com.google.android.gms.games.internal.IGamesCallbacks) r0, (boolean) r7)
                r13.writeNoException()
                goto L_0x000a
            L_0x1698:
                java.lang.String r0 = "com.google.android.gms.games.internal.IGamesService"
                r12.enforceInterface(r0)
                android.os.IBinder r0 = r12.readStrongBinder()
                com.google.android.gms.games.internal.IGamesCallbacks r0 = com.google.android.gms.games.internal.IGamesCallbacks.Stub.m2620aA(r0)
                int r1 = r12.readInt()
                if (r1 == 0) goto L_0x16ac
                r7 = r9
            L_0x16ac:
                r10.mo6925h((com.google.android.gms.games.internal.IGamesCallbacks) r0, (boolean) r7)
                r13.writeNoException()
                goto L_0x000a
            L_0x16b4:
                java.lang.String r0 = "com.google.android.gms.games.internal.IGamesService"
                r12.enforceInterface(r0)
                int r0 = r12.readInt()
                if (r0 == 0) goto L_0x16c5
                com.google.android.gms.games.achievement.AchievementEntityCreator r0 = com.google.android.gms.games.achievement.AchievementEntity.CREATOR
                com.google.android.gms.games.achievement.AchievementEntity r5 = r0.createFromParcel((android.os.Parcel) r12)
            L_0x16c5:
                android.content.Intent r0 = r10.mo6793a((com.google.android.gms.games.achievement.AchievementEntity) r5)
                r13.writeNoException()
                if (r0 == 0) goto L_0x16d6
                r13.writeInt(r9)
                r0.writeToParcel(r13, r9)
                goto L_0x000a
            L_0x16d6:
                r13.writeInt(r7)
                goto L_0x000a
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.games.internal.IGamesService.Stub.onTransact(int, android.os.Parcel, android.os.Parcel, int):boolean");
        }
    }

    /* renamed from: N */
    void mo6787N(boolean z) throws RemoteException;

    /* renamed from: O */
    void mo6788O(boolean z) throws RemoteException;

    /* renamed from: P */
    void mo6789P(boolean z) throws RemoteException;

    /* renamed from: a */
    int mo6790a(IGamesCallbacks iGamesCallbacks, byte[] bArr, String str, String str2) throws RemoteException;

    /* renamed from: a */
    Intent mo6791a(int i, int i2, boolean z) throws RemoteException;

    /* renamed from: a */
    Intent mo6792a(int i, byte[] bArr, int i2, String str) throws RemoteException;

    /* renamed from: a */
    Intent mo6793a(AchievementEntity achievementEntity) throws RemoteException;

    /* renamed from: a */
    Intent mo6794a(ZInvitationCluster zInvitationCluster, String str, String str2) throws RemoteException;

    /* renamed from: a */
    Intent mo6795a(GameRequestCluster gameRequestCluster, String str) throws RemoteException;

    /* renamed from: a */
    Intent mo6796a(RoomEntity roomEntity, int i) throws RemoteException;

    /* renamed from: a */
    Intent mo6797a(String str, boolean z, boolean z2, int i) throws RemoteException;

    /* renamed from: a */
    Intent mo6798a(ParticipantEntity[] participantEntityArr, String str, String str2, Uri uri, Uri uri2) throws RemoteException;

    /* renamed from: a */
    void mo6799a(long j, String str) throws RemoteException;

    /* renamed from: a */
    void mo6800a(IBinder iBinder, Bundle bundle) throws RemoteException;

    /* renamed from: a */
    void mo6801a(Contents contents) throws RemoteException;

    /* renamed from: a */
    void mo6802a(IGamesCallbacks iGamesCallbacks) throws RemoteException;

    /* renamed from: a */
    void mo6803a(IGamesCallbacks iGamesCallbacks, int i) throws RemoteException;

    /* renamed from: a */
    void mo6804a(IGamesCallbacks iGamesCallbacks, int i, int i2, int i3) throws RemoteException;

    /* renamed from: a */
    void mo6805a(IGamesCallbacks iGamesCallbacks, int i, int i2, boolean z, boolean z2) throws RemoteException;

    /* renamed from: a */
    void mo6806a(IGamesCallbacks iGamesCallbacks, int i, int i2, String[] strArr, Bundle bundle) throws RemoteException;

    /* renamed from: a */
    void mo6807a(IGamesCallbacks iGamesCallbacks, int i, boolean z, boolean z2) throws RemoteException;

    /* renamed from: a */
    void mo6808a(IGamesCallbacks iGamesCallbacks, int i, int[] iArr) throws RemoteException;

    /* renamed from: a */
    void mo6809a(IGamesCallbacks iGamesCallbacks, long j) throws RemoteException;

    /* renamed from: a */
    void mo6810a(IGamesCallbacks iGamesCallbacks, long j, String str) throws RemoteException;

    /* renamed from: a */
    void mo6811a(IGamesCallbacks iGamesCallbacks, Bundle bundle, int i, int i2) throws RemoteException;

    /* renamed from: a */
    void mo6812a(IGamesCallbacks iGamesCallbacks, IBinder iBinder, int i, String[] strArr, Bundle bundle, boolean z, long j) throws RemoteException;

    /* renamed from: a */
    void mo6813a(IGamesCallbacks iGamesCallbacks, IBinder iBinder, String str, boolean z, long j) throws RemoteException;

    /* renamed from: a */
    void mo6814a(IGamesCallbacks iGamesCallbacks, String str) throws RemoteException;

    /* renamed from: a */
    void mo6815a(IGamesCallbacks iGamesCallbacks, String str, int i) throws RemoteException;

    /* renamed from: a */
    void mo6816a(IGamesCallbacks iGamesCallbacks, String str, int i, int i2, int i3, boolean z) throws RemoteException;

    /* renamed from: a */
    void mo6817a(IGamesCallbacks iGamesCallbacks, String str, int i, IBinder iBinder, Bundle bundle) throws RemoteException;

    /* renamed from: a */
    void mo6818a(IGamesCallbacks iGamesCallbacks, String str, int i, boolean z) throws RemoteException;

    /* renamed from: a */
    void mo6819a(IGamesCallbacks iGamesCallbacks, String str, int i, boolean z, boolean z2) throws RemoteException;

    /* renamed from: a */
    void mo6820a(IGamesCallbacks iGamesCallbacks, String str, int i, boolean z, boolean z2, boolean z3, boolean z4) throws RemoteException;

    /* renamed from: a */
    void mo6821a(IGamesCallbacks iGamesCallbacks, String str, int i, int[] iArr) throws RemoteException;

    /* renamed from: a */
    void mo6822a(IGamesCallbacks iGamesCallbacks, String str, long j) throws RemoteException;

    /* renamed from: a */
    void mo6823a(IGamesCallbacks iGamesCallbacks, String str, long j, String str2) throws RemoteException;

    /* renamed from: a */
    void mo6824a(IGamesCallbacks iGamesCallbacks, String str, IBinder iBinder, Bundle bundle) throws RemoteException;

    /* renamed from: a */
    void mo6825a(IGamesCallbacks iGamesCallbacks, String str, SnapshotMetadataChange snapshotMetadataChange, Contents contents) throws RemoteException;

    /* renamed from: a */
    void mo6826a(IGamesCallbacks iGamesCallbacks, String str, String str2) throws RemoteException;

    /* renamed from: a */
    void mo6827a(IGamesCallbacks iGamesCallbacks, String str, String str2, int i, int i2) throws RemoteException;

    /* renamed from: a */
    void mo6828a(IGamesCallbacks iGamesCallbacks, String str, String str2, int i, int i2, int i3) throws RemoteException;

    /* renamed from: a */
    void mo6829a(IGamesCallbacks iGamesCallbacks, String str, String str2, int i, int i2, int i3, boolean z) throws RemoteException;

    /* renamed from: a */
    void mo6830a(IGamesCallbacks iGamesCallbacks, String str, String str2, int i, boolean z, boolean z2) throws RemoteException;

    /* renamed from: a */
    void mo6831a(IGamesCallbacks iGamesCallbacks, String str, String str2, SnapshotMetadataChange snapshotMetadataChange, Contents contents) throws RemoteException;

    /* renamed from: a */
    void mo6832a(IGamesCallbacks iGamesCallbacks, String str, String str2, boolean z) throws RemoteException;

    /* renamed from: a */
    void mo6833a(IGamesCallbacks iGamesCallbacks, String str, String str2, int[] iArr, int i, boolean z) throws RemoteException;

    /* renamed from: a */
    void mo6834a(IGamesCallbacks iGamesCallbacks, String str, String str2, String[] strArr) throws RemoteException;

    /* renamed from: a */
    void mo6835a(IGamesCallbacks iGamesCallbacks, String str, String str2, String[] strArr, boolean z) throws RemoteException;

    /* renamed from: a */
    void mo6836a(IGamesCallbacks iGamesCallbacks, String str, boolean z) throws RemoteException;

    /* renamed from: a */
    void mo6837a(IGamesCallbacks iGamesCallbacks, String str, byte[] bArr, String str2, ParticipantResult[] participantResultArr) throws RemoteException;

    /* renamed from: a */
    void mo6838a(IGamesCallbacks iGamesCallbacks, String str, byte[] bArr, ParticipantResult[] participantResultArr) throws RemoteException;

    /* renamed from: a */
    void mo6839a(IGamesCallbacks iGamesCallbacks, String str, int[] iArr) throws RemoteException;

    /* renamed from: a */
    void mo6840a(IGamesCallbacks iGamesCallbacks, String str, String[] strArr, int i, byte[] bArr, int i2) throws RemoteException;

    /* renamed from: a */
    void mo6841a(IGamesCallbacks iGamesCallbacks, boolean z) throws RemoteException;

    /* renamed from: a */
    void mo6842a(IGamesCallbacks iGamesCallbacks, boolean z, Bundle bundle) throws RemoteException;

    /* renamed from: a */
    void mo6843a(IGamesCallbacks iGamesCallbacks, boolean z, String[] strArr) throws RemoteException;

    /* renamed from: a */
    void mo6844a(IGamesCallbacks iGamesCallbacks, int[] iArr) throws RemoteException;

    /* renamed from: a */
    void mo6845a(IGamesCallbacks iGamesCallbacks, int[] iArr, int i, boolean z) throws RemoteException;

    /* renamed from: a */
    void mo6846a(IGamesCallbacks iGamesCallbacks, String[] strArr) throws RemoteException;

    /* renamed from: a */
    void mo6847a(IGamesCallbacks iGamesCallbacks, String[] strArr, boolean z) throws RemoteException;

    /* renamed from: a */
    void mo6848a(String str, IBinder iBinder, Bundle bundle) throws RemoteException;

    /* renamed from: b */
    int mo6849b(byte[] bArr, String str, String[] strArr) throws RemoteException;

    /* renamed from: b */
    Intent mo6850b(int i, int i2, boolean z) throws RemoteException;

    /* renamed from: b */
    Intent mo6851b(int[] iArr) throws RemoteException;

    /* renamed from: b */
    void mo6852b(long j, String str) throws RemoteException;

    /* renamed from: b */
    void mo6853b(IGamesCallbacks iGamesCallbacks) throws RemoteException;

    /* renamed from: b */
    void mo6854b(IGamesCallbacks iGamesCallbacks, int i, boolean z, boolean z2) throws RemoteException;

    /* renamed from: b */
    void mo6855b(IGamesCallbacks iGamesCallbacks, long j) throws RemoteException;

    /* renamed from: b */
    void mo6856b(IGamesCallbacks iGamesCallbacks, long j, String str) throws RemoteException;

    /* renamed from: b */
    void mo6857b(IGamesCallbacks iGamesCallbacks, String str) throws RemoteException;

    /* renamed from: b */
    void mo6858b(IGamesCallbacks iGamesCallbacks, String str, int i) throws RemoteException;

    /* renamed from: b */
    void mo6859b(IGamesCallbacks iGamesCallbacks, String str, int i, int i2, int i3, boolean z) throws RemoteException;

    /* renamed from: b */
    void mo6860b(IGamesCallbacks iGamesCallbacks, String str, int i, IBinder iBinder, Bundle bundle) throws RemoteException;

    /* renamed from: b */
    void mo6861b(IGamesCallbacks iGamesCallbacks, String str, int i, boolean z) throws RemoteException;

    /* renamed from: b */
    void mo6862b(IGamesCallbacks iGamesCallbacks, String str, int i, boolean z, boolean z2) throws RemoteException;

    /* renamed from: b */
    void mo6863b(IGamesCallbacks iGamesCallbacks, String str, IBinder iBinder, Bundle bundle) throws RemoteException;

    /* renamed from: b */
    void mo6864b(IGamesCallbacks iGamesCallbacks, String str, String str2) throws RemoteException;

    /* renamed from: b */
    void mo6865b(IGamesCallbacks iGamesCallbacks, String str, String str2, int i, int i2, int i3, boolean z) throws RemoteException;

    /* renamed from: b */
    void mo6866b(IGamesCallbacks iGamesCallbacks, String str, String str2, int i, boolean z, boolean z2) throws RemoteException;

    /* renamed from: b */
    void mo6867b(IGamesCallbacks iGamesCallbacks, String str, String str2, boolean z) throws RemoteException;

    /* renamed from: b */
    void mo6868b(IGamesCallbacks iGamesCallbacks, String str, boolean z) throws RemoteException;

    /* renamed from: b */
    void mo6869b(IGamesCallbacks iGamesCallbacks, boolean z) throws RemoteException;

    /* renamed from: b */
    void mo6870b(IGamesCallbacks iGamesCallbacks, String[] strArr) throws RemoteException;

    /* renamed from: b */
    void mo6871b(String str, String str2, int i) throws RemoteException;

    /* renamed from: bB */
    String mo6872bB(String str) throws RemoteException;

    /* renamed from: bC */
    String mo6873bC(String str) throws RemoteException;

    /* renamed from: bD */
    void mo6874bD(String str) throws RemoteException;

    /* renamed from: bE */
    int mo6875bE(String str) throws RemoteException;

    /* renamed from: bF */
    Uri mo6876bF(String str) throws RemoteException;

    /* renamed from: bG */
    void mo6877bG(String str) throws RemoteException;

    /* renamed from: bH */
    ParcelFileDescriptor mo6878bH(String str) throws RemoteException;

    /* renamed from: bu */
    Intent mo6879bu(String str) throws RemoteException;

    /* renamed from: bz */
    Intent mo6880bz(String str) throws RemoteException;

    /* renamed from: c */
    void mo6881c(long j, String str) throws RemoteException;

    /* renamed from: c */
    void mo6882c(IGamesCallbacks iGamesCallbacks) throws RemoteException;

    /* renamed from: c */
    void mo6883c(IGamesCallbacks iGamesCallbacks, int i, boolean z, boolean z2) throws RemoteException;

    /* renamed from: c */
    void mo6884c(IGamesCallbacks iGamesCallbacks, long j) throws RemoteException;

    /* renamed from: c */
    void mo6885c(IGamesCallbacks iGamesCallbacks, long j, String str) throws RemoteException;

    /* renamed from: c */
    void mo6886c(IGamesCallbacks iGamesCallbacks, String str) throws RemoteException;

    /* renamed from: c */
    void mo6887c(IGamesCallbacks iGamesCallbacks, String str, int i) throws RemoteException;

    /* renamed from: c */
    void mo6888c(IGamesCallbacks iGamesCallbacks, String str, int i, boolean z, boolean z2) throws RemoteException;

    /* renamed from: c */
    void mo6889c(IGamesCallbacks iGamesCallbacks, String str, String str2) throws RemoteException;

    /* renamed from: c */
    void mo6890c(IGamesCallbacks iGamesCallbacks, String str, String str2, boolean z) throws RemoteException;

    /* renamed from: c */
    void mo6891c(IGamesCallbacks iGamesCallbacks, String str, boolean z) throws RemoteException;

    /* renamed from: c */
    void mo6892c(IGamesCallbacks iGamesCallbacks, boolean z) throws RemoteException;

    /* renamed from: c */
    void mo6893c(IGamesCallbacks iGamesCallbacks, String[] strArr) throws RemoteException;

    /* renamed from: c */
    void mo6894c(String str, String str2, int i) throws RemoteException;

    /* renamed from: d */
    void mo6895d(long j, String str) throws RemoteException;

    /* renamed from: d */
    void mo6896d(IGamesCallbacks iGamesCallbacks) throws RemoteException;

    /* renamed from: d */
    void mo6897d(IGamesCallbacks iGamesCallbacks, int i, boolean z, boolean z2) throws RemoteException;

    /* renamed from: d */
    void mo6898d(IGamesCallbacks iGamesCallbacks, long j) throws RemoteException;

    /* renamed from: d */
    void mo6899d(IGamesCallbacks iGamesCallbacks, long j, String str) throws RemoteException;

    /* renamed from: d */
    void mo6900d(IGamesCallbacks iGamesCallbacks, String str) throws RemoteException;

    /* renamed from: d */
    void mo6901d(IGamesCallbacks iGamesCallbacks, String str, int i, boolean z, boolean z2) throws RemoteException;

    /* renamed from: d */
    void mo6902d(IGamesCallbacks iGamesCallbacks, String str, String str2) throws RemoteException;

    /* renamed from: d */
    void mo6903d(IGamesCallbacks iGamesCallbacks, String str, boolean z) throws RemoteException;

    /* renamed from: d */
    void mo6904d(IGamesCallbacks iGamesCallbacks, boolean z) throws RemoteException;

    /* renamed from: dC */
    void mo6905dC(int i) throws RemoteException;

    /* renamed from: e */
    void mo6906e(IGamesCallbacks iGamesCallbacks) throws RemoteException;

    /* renamed from: e */
    void mo6907e(IGamesCallbacks iGamesCallbacks, int i, boolean z, boolean z2) throws RemoteException;

    /* renamed from: e */
    void mo6908e(IGamesCallbacks iGamesCallbacks, String str) throws RemoteException;

    /* renamed from: e */
    void mo6909e(IGamesCallbacks iGamesCallbacks, String str, int i, boolean z, boolean z2) throws RemoteException;

    /* renamed from: e */
    void mo6910e(IGamesCallbacks iGamesCallbacks, String str, String str2) throws RemoteException;

    /* renamed from: e */
    void mo6911e(IGamesCallbacks iGamesCallbacks, String str, boolean z) throws RemoteException;

    /* renamed from: e */
    void mo6912e(IGamesCallbacks iGamesCallbacks, boolean z) throws RemoteException;

    /* renamed from: f */
    void mo6913f(IGamesCallbacks iGamesCallbacks) throws RemoteException;

    /* renamed from: f */
    void mo6914f(IGamesCallbacks iGamesCallbacks, String str) throws RemoteException;

    /* renamed from: f */
    void mo6915f(IGamesCallbacks iGamesCallbacks, String str, int i, boolean z, boolean z2) throws RemoteException;

    /* renamed from: f */
    void mo6916f(IGamesCallbacks iGamesCallbacks, String str, String str2) throws RemoteException;

    /* renamed from: f */
    void mo6917f(IGamesCallbacks iGamesCallbacks, boolean z) throws RemoteException;

    /* renamed from: fD */
    Bundle mo6918fD() throws RemoteException;

    /* renamed from: g */
    void mo6919g(IGamesCallbacks iGamesCallbacks) throws RemoteException;

    /* renamed from: g */
    void mo6920g(IGamesCallbacks iGamesCallbacks, String str) throws RemoteException;

    /* renamed from: g */
    void mo6921g(IGamesCallbacks iGamesCallbacks, boolean z) throws RemoteException;

    /* renamed from: h */
    ParcelFileDescriptor mo6922h(Uri uri) throws RemoteException;

    /* renamed from: h */
    RoomEntity mo6923h(IGamesCallbacks iGamesCallbacks, String str) throws RemoteException;

    /* renamed from: h */
    void mo6924h(IGamesCallbacks iGamesCallbacks) throws RemoteException;

    /* renamed from: h */
    void mo6925h(IGamesCallbacks iGamesCallbacks, boolean z) throws RemoteException;

    /* renamed from: i */
    void mo6926i(IGamesCallbacks iGamesCallbacks) throws RemoteException;

    /* renamed from: i */
    void mo6927i(IGamesCallbacks iGamesCallbacks, String str) throws RemoteException;

    /* renamed from: j */
    void mo6928j(IGamesCallbacks iGamesCallbacks) throws RemoteException;

    /* renamed from: j */
    void mo6929j(IGamesCallbacks iGamesCallbacks, String str) throws RemoteException;

    /* renamed from: jX */
    String mo6930jX() throws RemoteException;

    /* renamed from: jY */
    String mo6931jY() throws RemoteException;

    /* renamed from: k */
    void mo6932k(IGamesCallbacks iGamesCallbacks, String str) throws RemoteException;

    /* renamed from: kA */
    Intent mo6933kA() throws RemoteException;

    /* renamed from: kB */
    void mo6934kB() throws RemoteException;

    /* renamed from: kC */
    boolean mo6935kC() throws RemoteException;

    /* renamed from: kb */
    Intent mo6936kb() throws RemoteException;

    /* renamed from: kc */
    Intent mo6937kc() throws RemoteException;

    /* renamed from: kd */
    Intent mo6938kd() throws RemoteException;

    /* renamed from: ke */
    Intent mo6939ke() throws RemoteException;

    /* renamed from: kj */
    Intent mo6940kj() throws RemoteException;

    /* renamed from: kk */
    Intent mo6941kk() throws RemoteException;

    /* renamed from: kl */
    int mo6942kl() throws RemoteException;

    /* renamed from: km */
    String mo6943km() throws RemoteException;

    /* renamed from: kn */
    int mo6944kn() throws RemoteException;

    /* renamed from: ko */
    Intent mo6945ko() throws RemoteException;

    /* renamed from: kp */
    int mo6946kp() throws RemoteException;

    /* renamed from: kq */
    int mo6947kq() throws RemoteException;

    /* renamed from: kr */
    int mo6948kr() throws RemoteException;

    /* renamed from: ks */
    int mo6949ks() throws RemoteException;

    /* renamed from: ku */
    void mo6950ku() throws RemoteException;

    /* renamed from: kw */
    DataHolder mo6951kw() throws RemoteException;

    /* renamed from: kx */
    boolean mo6952kx() throws RemoteException;

    /* renamed from: ky */
    DataHolder mo6953ky() throws RemoteException;

    /* renamed from: kz */
    void mo6954kz() throws RemoteException;

    /* renamed from: l */
    void mo6955l(IGamesCallbacks iGamesCallbacks, String str) throws RemoteException;

    /* renamed from: m */
    void mo6956m(IGamesCallbacks iGamesCallbacks, String str) throws RemoteException;

    /* renamed from: n */
    void mo6957n(IGamesCallbacks iGamesCallbacks, String str) throws RemoteException;

    /* renamed from: n */
    void mo6958n(String str, int i) throws RemoteException;

    /* renamed from: o */
    void mo6959o(IGamesCallbacks iGamesCallbacks, String str) throws RemoteException;

    /* renamed from: o */
    void mo6960o(String str, int i) throws RemoteException;

    /* renamed from: p */
    void mo6961p(IGamesCallbacks iGamesCallbacks, String str) throws RemoteException;

    /* renamed from: p */
    void mo6962p(String str, int i) throws RemoteException;

    /* renamed from: q */
    void mo6963q(long j) throws RemoteException;

    /* renamed from: q */
    void mo6964q(IGamesCallbacks iGamesCallbacks, String str) throws RemoteException;

    /* renamed from: r */
    void mo6965r(long j) throws RemoteException;

    /* renamed from: r */
    void mo6966r(IGamesCallbacks iGamesCallbacks, String str) throws RemoteException;

    /* renamed from: r */
    void mo6967r(String str, int i) throws RemoteException;

    /* renamed from: s */
    void mo6968s(long j) throws RemoteException;

    /* renamed from: s */
    void mo6969s(IGamesCallbacks iGamesCallbacks, String str) throws RemoteException;

    /* renamed from: s */
    void mo6970s(String str, int i) throws RemoteException;

    /* renamed from: t */
    void mo6971t(long j) throws RemoteException;

    /* renamed from: t */
    void mo6972t(IGamesCallbacks iGamesCallbacks, String str) throws RemoteException;

    /* renamed from: u */
    void mo6973u(long j) throws RemoteException;

    /* renamed from: u */
    void mo6974u(IGamesCallbacks iGamesCallbacks, String str) throws RemoteException;

    /* renamed from: u */
    void mo6975u(String str, String str2) throws RemoteException;

    /* renamed from: v */
    void mo6976v(String str, String str2) throws RemoteException;
}
