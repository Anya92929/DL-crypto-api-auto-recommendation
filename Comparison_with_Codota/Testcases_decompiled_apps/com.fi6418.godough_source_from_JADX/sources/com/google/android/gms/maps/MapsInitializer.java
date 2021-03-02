package com.google.android.gms.maps;

import android.content.Context;
import android.os.RemoteException;
import com.google.android.gms.common.C0799c;
import com.google.android.gms.common.internal.C1009bf;
import com.google.android.gms.maps.internal.zzc;
import com.google.android.gms.maps.internal.zzy;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.RuntimeRemoteException;

public final class MapsInitializer {

    /* renamed from: a */
    private static boolean f5006a = false;

    private MapsInitializer() {
    }

    public static synchronized int initialize(Context context) {
        int i = 0;
        synchronized (MapsInitializer.class) {
            C1009bf.m4529a(context, (Object) "Context is null");
            if (!f5006a) {
                try {
                    zza(zzy.zzaF(context));
                    f5006a = true;
                } catch (C0799c e) {
                    i = e.f4574a;
                }
            }
        }
        return i;
    }

    public static void zza(zzc zzc) {
        try {
            CameraUpdateFactory.zza(zzc.zzwX());
            BitmapDescriptorFactory.zza(zzc.zzwY());
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }
}
