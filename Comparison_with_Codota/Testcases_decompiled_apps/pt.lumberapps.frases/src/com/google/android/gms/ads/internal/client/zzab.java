package com.google.android.gms.ads.internal.client;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import com.google.android.gms.ads.internal.client.zzac;

public interface zzab extends IInterface {

    public abstract class zza extends Binder implements zzab {
        public zza() {
            attachInterface(this, "com.google.android.gms.ads.internal.client.IVideoController");
        }

        public static zzab zzt(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.ads.internal.client.IVideoController");
            return (queryLocalInterface == null || !(queryLocalInterface instanceof zzab)) ? new C1229b(iBinder) : (zzab) queryLocalInterface;
        }

        public IBinder asBinder() {
            return this;
        }

        public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) {
            boolean z = false;
            switch (i) {
                case 1:
                    parcel.enforceInterface("com.google.android.gms.ads.internal.client.IVideoController");
                    play();
                    parcel2.writeNoException();
                    return true;
                case 2:
                    parcel.enforceInterface("com.google.android.gms.ads.internal.client.IVideoController");
                    pause();
                    parcel2.writeNoException();
                    return true;
                case 3:
                    parcel.enforceInterface("com.google.android.gms.ads.internal.client.IVideoController");
                    if (parcel.readInt() != 0) {
                        z = true;
                    }
                    zzm(z);
                    parcel2.writeNoException();
                    return true;
                case 4:
                    parcel.enforceInterface("com.google.android.gms.ads.internal.client.IVideoController");
                    boolean isMuted = isMuted();
                    parcel2.writeNoException();
                    if (isMuted) {
                        z = true;
                    }
                    parcel2.writeInt(z ? 1 : 0);
                    return true;
                case 5:
                    parcel.enforceInterface("com.google.android.gms.ads.internal.client.IVideoController");
                    int playbackState = getPlaybackState();
                    parcel2.writeNoException();
                    parcel2.writeInt(playbackState);
                    return true;
                case 6:
                    parcel.enforceInterface("com.google.android.gms.ads.internal.client.IVideoController");
                    float zziz = zziz();
                    parcel2.writeNoException();
                    parcel2.writeFloat(zziz);
                    return true;
                case 7:
                    parcel.enforceInterface("com.google.android.gms.ads.internal.client.IVideoController");
                    float zzja = zzja();
                    parcel2.writeNoException();
                    parcel2.writeFloat(zzja);
                    return true;
                case 8:
                    parcel.enforceInterface("com.google.android.gms.ads.internal.client.IVideoController");
                    zza(zzac.zza.zzu(parcel.readStrongBinder()));
                    parcel2.writeNoException();
                    return true;
                case 1598968902:
                    parcel2.writeString("com.google.android.gms.ads.internal.client.IVideoController");
                    return true;
                default:
                    return super.onTransact(i, parcel, parcel2, i2);
            }
        }
    }

    int getPlaybackState();

    boolean isMuted();

    void pause();

    void play();

    void zza(zzac zzac);

    float zziz();

    float zzja();

    void zzm(boolean z);
}
