package com.google.android.gms.vision.face.internal.client;

import android.content.Context;
import android.os.IBinder;
import android.util.Log;
import com.google.android.gms.dynamic.zze;
import com.google.android.gms.dynamic.zzg;
import com.google.android.gms.vision.face.internal.client.zzd;

class zzf extends zzg<zzd> {
    private static zzf zzboa;

    zzf() {
        super("com.google.android.gms.vision.client.DynamiteNativeFaceDetectorCreator");
    }

    static zzc zza(Context context, FaceSettingsParcel faceSettingsParcel) {
        if (zzboa == null) {
            zzboa = new zzf();
        }
        return zzboa.zzb(context, faceSettingsParcel);
    }

    private zzc zzb(Context context, FaceSettingsParcel faceSettingsParcel) {
        try {
            return ((zzd) zzaB(context)).zza(zze.zzC(context), faceSettingsParcel);
        } catch (Exception e) {
            Log.e("FaceDetectorHandle", "Could not create native face detector", e);
            return null;
        }
    }

    /* access modifiers changed from: protected */
    /* renamed from: zzei */
    public zzd zzd(IBinder iBinder) {
        return zzd.zza.zzeh(iBinder);
    }
}
