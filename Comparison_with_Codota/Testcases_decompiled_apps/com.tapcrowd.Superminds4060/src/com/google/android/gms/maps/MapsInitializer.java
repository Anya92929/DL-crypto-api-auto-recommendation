package com.google.android.gms.maps;

import android.content.Context;
import android.os.RemoteException;
import com.google.android.gms.common.GooglePlayServicesNotAvailableException;
import com.google.android.gms.internal.C0411dm;
import com.google.android.gms.maps.internal.C0667c;
import com.google.android.gms.maps.internal.C0707q;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.RuntimeRemoteException;

public final class MapsInitializer {
    private MapsInitializer() {
    }

    public static void initialize(Context context) throws GooglePlayServicesNotAvailableException {
        C0411dm.m944e(context);
        C0667c u = C0707q.m2071u(context);
        try {
            CameraUpdateFactory.m1976a(u.mo5678cG());
            BitmapDescriptorFactory.m2076a(u.mo5679cH());
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }
}
