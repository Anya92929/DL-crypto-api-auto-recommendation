package com.google.android.gms.vision.barcode.internal.client;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.dynamic.zzd;
import com.google.android.gms.vision.barcode.Barcode;
import com.google.android.gms.vision.internal.client.FrameMetadataParcel;

public interface zzb extends IInterface {

    public static abstract class zza extends Binder implements zzb {

        /* renamed from: com.google.android.gms.vision.barcode.internal.client.zzb$zza$zza  reason: collision with other inner class name */
        private static class C0515zza implements zzb {
            private IBinder zzoz;

            C0515zza(IBinder iBinder) {
                this.zzoz = iBinder;
            }

            public IBinder asBinder() {
                return this.zzoz;
            }

            public Barcode[] zza(zzd zzd, FrameMetadataParcel frameMetadataParcel) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.vision.barcode.internal.client.INativeBarcodeDetector");
                    obtain.writeStrongBinder(zzd != null ? zzd.asBinder() : null);
                    if (frameMetadataParcel != null) {
                        obtain.writeInt(1);
                        frameMetadataParcel.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.zzoz.transact(1, obtain, obtain2, 0);
                    obtain2.readException();
                    return (Barcode[]) obtain2.createTypedArray(Barcode.CREATOR);
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public Barcode[] zzb(zzd zzd, FrameMetadataParcel frameMetadataParcel) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.vision.barcode.internal.client.INativeBarcodeDetector");
                    obtain.writeStrongBinder(zzd != null ? zzd.asBinder() : null);
                    if (frameMetadataParcel != null) {
                        obtain.writeInt(1);
                        frameMetadataParcel.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.zzoz.transact(2, obtain, obtain2, 0);
                    obtain2.readException();
                    return (Barcode[]) obtain2.createTypedArray(Barcode.CREATOR);
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }
        }

        public static zzb zzed(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.vision.barcode.internal.client.INativeBarcodeDetector");
            return (queryLocalInterface == null || !(queryLocalInterface instanceof zzb)) ? new C0515zza(iBinder) : (zzb) queryLocalInterface;
        }

        public boolean onTransact(int code, Parcel data, Parcel reply, int flags) throws RemoteException {
            FrameMetadataParcel frameMetadataParcel = null;
            switch (code) {
                case 1:
                    data.enforceInterface("com.google.android.gms.vision.barcode.internal.client.INativeBarcodeDetector");
                    zzd zzbs = zzd.zza.zzbs(data.readStrongBinder());
                    if (data.readInt() != 0) {
                        frameMetadataParcel = FrameMetadataParcel.CREATOR.createFromParcel(data);
                    }
                    Barcode[] zza = zza(zzbs, frameMetadataParcel);
                    reply.writeNoException();
                    reply.writeTypedArray(zza, 1);
                    return true;
                case 2:
                    data.enforceInterface("com.google.android.gms.vision.barcode.internal.client.INativeBarcodeDetector");
                    zzd zzbs2 = zzd.zza.zzbs(data.readStrongBinder());
                    if (data.readInt() != 0) {
                        frameMetadataParcel = FrameMetadataParcel.CREATOR.createFromParcel(data);
                    }
                    Barcode[] zzb = zzb(zzbs2, frameMetadataParcel);
                    reply.writeNoException();
                    reply.writeTypedArray(zzb, 1);
                    return true;
                case 1598968902:
                    reply.writeString("com.google.android.gms.vision.barcode.internal.client.INativeBarcodeDetector");
                    return true;
                default:
                    return super.onTransact(code, data, reply, flags);
            }
        }
    }

    Barcode[] zza(zzd zzd, FrameMetadataParcel frameMetadataParcel) throws RemoteException;

    Barcode[] zzb(zzd zzd, FrameMetadataParcel frameMetadataParcel) throws RemoteException;
}
