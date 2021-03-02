package com.google.android.gms.maps;

import android.content.Context;
import android.os.RemoteException;
import com.google.android.gms.common.GooglePlayServicesNotAvailableException;
import com.google.android.gms.common.internal.C0348n;
import com.google.android.gms.maps.internal.C1816c;
import com.google.android.gms.maps.internal.C1868u;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.RuntimeRemoteException;

public final class MapsInitializer {
    private MapsInitializer() {
    }

    /* renamed from: a */
    public static void m6287a(C1816c cVar) {
        try {
            CameraUpdateFactory.m6258a(cVar.mo10669mG());
            BitmapDescriptorFactory.m6397a(cVar.mo10670mH());
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    public static int initialize(Context context) {
        C0348n.m861i(context);
        try {
            m6287a(C1868u.m6388R(context));
            return 0;
        } catch (GooglePlayServicesNotAvailableException e) {
            return e.errorCode;
        }
    }
}
