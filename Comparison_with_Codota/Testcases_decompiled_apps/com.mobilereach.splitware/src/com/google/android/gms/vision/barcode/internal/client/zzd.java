package com.google.android.gms.vision.barcode.internal.client;

import android.content.Context;
import android.graphics.Bitmap;
import android.os.IBinder;
import android.os.RemoteException;
import android.util.Log;
import com.google.android.gms.dynamic.zze;
import com.google.android.gms.dynamic.zzg;
import com.google.android.gms.vision.barcode.Barcode;
import com.google.android.gms.vision.barcode.internal.client.zzc;
import com.google.android.gms.vision.internal.client.FrameMetadataParcel;
import java.nio.ByteBuffer;

public class zzd {
    private final Context mContext;
    private final BarcodeDetectorOptions zzbnv;
    private zzb zzbnx = null;
    private final Object zzpV = new Object();

    static class zza extends zzg<zzc> {
        private static zza zzbny;

        zza() {
            super("com.google.android.gms.vision.client.DynamiteNativeBarcodeDetectorCreator");
        }

        static zzb zza(Context context, BarcodeDetectorOptions barcodeDetectorOptions) {
            if (zzbny == null) {
                zzbny = new zza();
            }
            return zzbny.zzb(context, barcodeDetectorOptions);
        }

        private zzb zzb(Context context, BarcodeDetectorOptions barcodeDetectorOptions) {
            try {
                return ((zzc) zzaB(context)).zza(zze.zzC(context), barcodeDetectorOptions);
            } catch (RemoteException e) {
                Log.e("NativeBarcodeDetectorHandle", "Error creating native barcode detector", e);
            } catch (zzg.zza e2) {
                Log.e("NativeBarcodeDetectorHandle", "Error creating native barcode detector", e2);
            }
            return null;
        }

        /* access modifiers changed from: protected */
        /* renamed from: zzef */
        public zzc zzd(IBinder iBinder) {
            return zzc.zza.zzee(iBinder);
        }
    }

    public zzd(Context context, BarcodeDetectorOptions barcodeDetectorOptions) {
        this.mContext = context;
        this.zzbnv = barcodeDetectorOptions;
        zzIg();
    }

    private zzb zzIg() {
        zzb zzb;
        synchronized (this.zzpV) {
            if (this.zzbnx == null) {
                this.zzbnx = zza.zza(this.mContext, this.zzbnv);
            }
            zzb = this.zzbnx;
        }
        return zzb;
    }

    public boolean isOperational() {
        return zzIg() != null;
    }

    public Barcode[] zza(Bitmap bitmap, FrameMetadataParcel frameMetadataParcel) {
        zzb zzIg = zzIg();
        if (zzIg == null) {
            return new Barcode[0];
        }
        try {
            return zzIg.zzb(zze.zzC(bitmap), frameMetadataParcel);
        } catch (RemoteException e) {
            Log.e("NativeBarcodeDetectorHandle", "Error calling native barcode detector", e);
            return new Barcode[0];
        }
    }

    public Barcode[] zza(ByteBuffer byteBuffer, FrameMetadataParcel frameMetadataParcel) {
        zzb zzIg = zzIg();
        if (zzIg == null) {
            return new Barcode[0];
        }
        try {
            return zzIg.zza(zze.zzC(byteBuffer), frameMetadataParcel);
        } catch (RemoteException e) {
            Log.e("NativeBarcodeDetectorHandle", "Error calling native barcode detector", e);
            return new Barcode[0];
        }
    }
}
