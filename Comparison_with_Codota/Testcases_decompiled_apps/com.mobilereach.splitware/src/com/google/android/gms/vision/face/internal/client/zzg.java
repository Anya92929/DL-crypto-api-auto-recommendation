package com.google.android.gms.vision.face.internal.client;

import android.content.Context;
import android.graphics.PointF;
import android.os.RemoteException;
import android.util.Log;
import com.google.android.gms.dynamic.zze;
import com.google.android.gms.vision.face.Face;
import com.google.android.gms.vision.face.Landmark;
import com.google.android.gms.vision.internal.client.FrameMetadataParcel;
import java.nio.ByteBuffer;

public class zzg {
    private final Context mContext;
    private final FaceSettingsParcel zzbob;
    private zzc zzboc = null;
    private boolean zzbod = false;
    private final Object zzpV = new Object();

    public zzg(Context context, FaceSettingsParcel faceSettingsParcel) {
        this.mContext = context;
        this.zzbob = faceSettingsParcel;
        zzIi();
    }

    private zzc zzIi() {
        zzc zzc;
        synchronized (this.zzpV) {
            if (this.zzboc != null) {
                zzc = this.zzboc;
            } else {
                this.zzboc = zzf.zza(this.mContext, this.zzbob);
                if (!this.zzbod && this.zzboc == null) {
                    Log.w("FaceDetectorHandle", "Native face detector not yet available.  Reverting to no-op detection.");
                    this.zzbod = true;
                } else if (this.zzbod && this.zzboc != null) {
                    Log.w("FaceDetectorHandle", "Native face detector is now available.");
                }
                zzc = this.zzboc;
            }
        }
        return zzc;
    }

    private Face zza(FaceParcel faceParcel) {
        return new Face(faceParcel.f17id, new PointF(faceParcel.centerX, faceParcel.centerY), faceParcel.width, faceParcel.height, faceParcel.zzbnP, faceParcel.zzbnQ, zzb(faceParcel), faceParcel.zzbnS, faceParcel.zzbnT, faceParcel.zzbnU);
    }

    private Landmark zza(LandmarkParcel landmarkParcel) {
        return new Landmark(new PointF(landmarkParcel.f18x, landmarkParcel.f19y), landmarkParcel.type);
    }

    private Landmark[] zzb(FaceParcel faceParcel) {
        LandmarkParcel[] landmarkParcelArr = faceParcel.zzbnR;
        if (landmarkParcelArr == null) {
            return new Landmark[0];
        }
        Landmark[] landmarkArr = new Landmark[landmarkParcelArr.length];
        for (int i = 0; i < landmarkParcelArr.length; i++) {
            landmarkArr[i] = zza(landmarkParcelArr[i]);
        }
        return landmarkArr;
    }

    public boolean isOperational() {
        return zzIi() != null;
    }

    public void zzIh() {
        synchronized (this.zzpV) {
            if (this.zzboc != null) {
                try {
                    this.zzboc.zzIh();
                } catch (RemoteException e) {
                    Log.e("FaceDetectorHandle", "Could not finalize native face detector", e);
                }
                return;
            }
            return;
        }
    }

    public Face[] zzb(ByteBuffer byteBuffer, FrameMetadataParcel frameMetadataParcel) {
        zzc zzIi = zzIi();
        if (zzIi == null) {
            return new Face[0];
        }
        try {
            FaceParcel[] zzc = zzIi.zzc(zze.zzC(byteBuffer), frameMetadataParcel);
            Face[] faceArr = new Face[zzc.length];
            for (int i = 0; i < zzc.length; i++) {
                faceArr[i] = zza(zzc[i]);
            }
            return faceArr;
        } catch (RemoteException e) {
            Log.e("FaceDetectorHandle", "Could not call native face detector", e);
            return new Face[0];
        }
    }

    public boolean zzkJ(int i) {
        zzc zzIi = zzIi();
        if (zzIi == null) {
            return false;
        }
        try {
            return zzIi.zzkJ(i);
        } catch (RemoteException e) {
            Log.e("FaceDetectorHandle", "Could not call native face detector", e);
            return false;
        }
    }
}
